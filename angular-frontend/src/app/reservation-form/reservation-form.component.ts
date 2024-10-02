import { Component,OnInit } from '@angular/core';
import { FormBuilder,FormGroup,Validators } from '@angular/forms';
import { ReservationService } from '../reservation/reservation.service';
import { Reservation } from '../models/reservation';
import { ActivatedRoute, Router } from '@angular/router';
import { HomeComponent } from '../home/home.component';



@Component({
  selector: 'app-reservation-form',
  templateUrl: './reservation-form.component.html',
  styleUrl: './reservation-form.component.css'
})


export class ReservationFormComponent implements OnInit 
{
    
    reservationForm:FormGroup = new FormGroup({});

    // dependencies
    constructor(private formBuilder:FormBuilder,
      private reservationService : ReservationService,
      private router:Router,
      private activatedRoute:ActivatedRoute
    ){

    }

    ngOnInit(): void {
      this.reservationForm=this.formBuilder.group({
        checkInDate:['',Validators.required],
        checkOutDate:['',Validators.required],
        name:['',Validators.required],
        email:['',[Validators.required,Validators.email]],
        roomNumber:['',Validators.required]
      })

      let id = this.activatedRoute.snapshot.paramMap.get('id');
 
      if(id){
        this.reservationService.getReservation(id).subscribe(reservation =>{
          if(reservation)
            this.reservationForm.patchValue(reservation)
        });  
       
      }
    } 
    onsubmit() {
      if (this.reservationForm.valid) {
        // Get the form values
        let reservation: Reservation = this.reservationForm.value;
        let id = this.activatedRoute.snapshot.paramMap.get('id');
    
        if (id) {
          // Update the reservation
          this.reservationService.updatereservation(id, reservation).subscribe(() => {
            console.log('Reservation updated');
            this.router.navigate(['/list']);
          });
        } else {
          // Add a new reservation
          this.reservationService.addreservation(reservation).subscribe(() => {
            console.log('Reservation added');
            this.router.navigate(['/list']);
          });
        }
      }
    }
    
}
