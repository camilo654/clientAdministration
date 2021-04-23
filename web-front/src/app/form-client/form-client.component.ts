import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Client } from '../Client';
import { ClientService } from '../client.service';

@Component({
  selector: 'app-form-client',
  templateUrl: './form-client.component.html',
  styleUrls: ['./form-client.component.css']
})
export class FormClientComponent implements OnInit {
  @Input() client: Client;
  @Input() componente: string;
  @Output() cerrar = new EventEmitter<boolean>();

  constructor(private clientService: ClientService) { }

  ngOnInit(): void {
    if (!this.client) {
      this.client = {
        sharedKey: '',
        bussinessID: '',
        email: '',
        phone: null,
        dataAdded: null,
        componente: null
      }
    }
  }

  cerrarForm() {
    if (this.componente === 'crear') {
      this.client.sharedKey = this.client.bussinessID[0] + this.client.bussinessID.split(' ')[1];
      this.client.sharedKey = this.client.sharedKey.toLowerCase();
      this.clientService.createClient(this.client).subscribe();
    }
    this.cerrar.emit(true);
  }
}
