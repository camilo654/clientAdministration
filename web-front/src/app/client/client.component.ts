import { Component, Input, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { Client } from '../Client';
import { ClientService } from '../client.service';
import { PopUpComponent } from '../shared/pop-up/pop-up.component';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {
  search = false;
  clients: Client[];
  clientSelected: Client;
  nameComponent: string

  constructor(
    private clientService: ClientService,
    public dialog: MatDialog
  ) { }

  ngOnInit() {
    this.getClients();
  }

  getClients(): void {
    this.clientService.getClients().subscribe(clients => this.clients = clients);
  }
  searchClient() {
    this.search = true
    this.nameComponent = 'consultar'
    this.clientSelected = {
      sharedKey: '',
      bussinessID: '',
      email: '',
      phone: null,
      dataAdded: null,
      componente: null
    };

  }

  cerrar() {
      this.search = false;
  }

  openPopoUp() {
    const dialogRef = this.dialog.open(PopUpComponent, {
      width: 'auto',
      height: 'auto',
      data: {
        name: '',
        animal: '',
        componente: 'crear'
      }
    });
    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      // this.animal = result;
    });
  }

}
