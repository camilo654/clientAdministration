import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable, of } from 'rxjs';
import { Client } from './Client';

@Injectable({
  providedIn: 'root'
})
export class ClientService {

  private clientUrl = 'http://localhost:8080/client/';

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  getClients(): Observable<Client[]> {
    return this.http.get<Client[]>(this.clientUrl);
  }

  getClientBySharedKey(sharedKey: string): Observable<Client> {
    return this.http.get<Client>(this.clientUrl + sharedKey);
  }

  createClient(client: Client): Observable<Client> {
    return this.http.post<Client>(this.clientUrl, client, this.httpOptions);
  }

}
