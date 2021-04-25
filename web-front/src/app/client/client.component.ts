import { Component, Input, OnInit, ViewChild } from '@angular/core';
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
  sharedKeyClient: string;
  userIcon = './assets/images/userIcon.png';
  editIcon = './assets/images/edit-icon.webp';
  editIconBW = './assets/images/editIconBW.png';

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
    this.search = true;
    this.nameComponent = 'consultar';
    this.clientSelected = {
      sharedKey: '',
      bussinessID: '',
      email: '',
      phone: null,
      dataAdded: null,
      componente: null
    };
    this.clientService.getClientBySharedKey(this.sharedKeyClient).subscribe(client => {
      this.clientSelected = client;
    });

  }

  openPopUp() {
    const dialogRef = this.dialog.open(PopUpComponent, {
      width: 'auto',
      height: 'auto',
      data: {
        componente: 'crear'
      }
    });
    dialogRef.afterClosed().subscribe(rep => {
      this.getClients();
    }
    );
  }

  cerrar() {
    this.search = false;
    this.sharedKeyClient = '';
  }

}
