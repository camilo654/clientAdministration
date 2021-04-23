import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable, of } from 'rxjs';
import { Client } from './Client';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private clientUrl = 'http://localhost:8080/client';

  constructor(private http: HttpClient) { }

  getClients(): Observable<Client[]> {
    return this.http.get<Client[]>(this.clientUrl)
  }
}
