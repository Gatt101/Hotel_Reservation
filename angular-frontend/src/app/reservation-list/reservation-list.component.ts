import { Component, OnInit } from '@angular/core';
import { Reservation } from '../models/reservation';
import { ReservationService } from '../reservation/reservation.service';
import {RouterModule,Routes} from '@angular/router';


@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrl: './reservation-list.component.css'
})
export class ReservationListComponent implements OnInit{
   reservations:Reservation[]=[]

   constructor(private reservationService:ReservationService){

   }
  ngOnInit(): void {
    // throw new Error('Method not implemented.');
    this.reservationService.getReservations().subscribe(reservations =>{
        this.reservations=reservations;
    });
  }

  deleteReservations(id:string){
this.reservationService.deletereservation(id).subscribe(()=>
  {
    this.reservations = this.reservations.filter(r => r.id !== id)
  })
  }

}
