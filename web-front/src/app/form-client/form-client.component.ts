import { DatePipe } from '@angular/common';
import { ChangeDetectorRef, Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
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

  date: string;

  constructor(
    private clientService: ClientService,
    private datePipe: DatePipe,
    private cdRef: ChangeDetectorRef
  ) { }

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

  ngAfterViewChecked(): void {
    if (this.client.dataAdded) {
      this.setFecha();
      this.cdRef.detectChanges();
    }
  }

  setFecha(): void {
    if (this.componente === 'consultar') {
      var fechaStr = new String(this.client.dataAdded);
      var year = fechaStr.substring(0, 4);
      var month = fechaStr.substring(5, 7);
      var day = fechaStr.substring(8, 10);
      const fecha = new Date(Number(year), Number(month) - 1, Number(day));
      this.date = this.datePipe.transform(fecha, 'yyyy-MM-dd');
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
