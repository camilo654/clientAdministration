import { Component, OnInit } from '@angular/core';
import { Client } from '../Client';
import { ClientService } from '../client.service';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  clients: Client[];

  constructor(private clientService: ClientService) { }

  ngOnInit() {
    this.getClients();
  }

  getClients(): void {
    this.clientService.getClients().subscribe(clients => this.clients = clients);
  }

}