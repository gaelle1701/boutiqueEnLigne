import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { Idelivery } from 'src/app/models/idelivery';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class DeliveryService {

  subjDeliveries$ = new Subject<Idelivery[]>();

  constructor(private http: HttpClient) { }

  getDeliveries(): Observable<Idelivery[]> {
    return this.http.get<Idelivery[]>(`${environment.baseURL}/deliveries`)
  }

  getListDeliveries(): void {
    this.getDeliveries().subscribe(data => {
      this.subjDeliveries$.next(data);
      console.log("data listDelievries: ", data);
      
    })
  }

  getDeliveryById(id: string): Observable<Idelivery> {    
    return this.http.get<Idelivery>(`${environment.baseURL}/deliveries/${parseInt(id, 10)}`);
  }
}
