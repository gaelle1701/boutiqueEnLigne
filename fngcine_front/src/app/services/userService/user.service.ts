import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Iusers } from 'src/app/models/iusers';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  API_URL = `${environment.baseURL}`;

  userSubject$ = new Subject<Iusers[]>();

  constructor(private http: HttpClient) { }

  getUsers(): void {
    this.http.get<Iusers[]>(`${this.API_URL}/users`).subscribe(resp => {
      this.userSubject$.next(resp)
    })
  }
}
