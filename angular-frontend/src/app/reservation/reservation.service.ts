import { Injectable, OnInit } from '@angular/core';
import { Reservation } from '../models/reservation';
import { HttpClient } from '@angular/common/http';
import { Observable, tap } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ReservationService implements OnInit{

  
  private reservations:Reservation[]=[];

  constructor(private http:HttpClient){}

  private apiURL="http://localhost:8080/api"
  // CRUD 
 


 ngOnInit(): void {
  //  throw new Error('Method not implemented.');
 }
  getReservations():Observable<Reservation[]>{
    return this.http.get<Reservation[]>(this.apiURL + "/customers")
  }

  getReservation(id:string):Observable<Reservation>
  {
    return this.http.get<Reservation>(this.apiURL + "/customers/"+id)
  }

  addreservation(reservation:Reservation):Observable<void>{
    return this.http.post<void>(this.apiURL + "/customers",reservation)
    reservation.id=Date.now().toString();
    this.reservations.push(reservation);
    // localStorage.setItem("reservations",JSON.stringify(this.reservations));
  }
  
  deletereservation(id:string):Observable<void>{

    return this.http.delete<void>(this.apiURL + "/customers/"+id)

    let index=this.reservations.findIndex(res => res.id === id)
    this.reservations.splice(index,1)
    // localStorage.setItem("reservations",JSON.stringify(this.reservations));
  }
  
  updatereservation(id:string,updatedreservation:Reservation):Observable<void>
  {
    return this.http.put<void>(this.apiURL + "/customers/"+id,updatedreservation)
   
    let index=this.reservations.findIndex(res => res.id === id)
    this.reservations[index]=updatedreservation; 
    updatedreservation.id=Date.now().toString();
    // localStorage.setItem("reservations",JSON.stringify(this.reservations));
  }


}
