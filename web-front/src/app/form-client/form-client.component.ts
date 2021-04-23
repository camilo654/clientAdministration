import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Client } from '../Client';

@Component({
  selector: 'app-form-client',
  templateUrl: './form-client.component.html',
  styleUrls: ['./form-client.component.css']
})
export class FormClientComponent implements OnInit {
  @Input() client: Client; 
  @Input() componente: string
  @Output() cerrar = new EventEmitter<boolean>();

  constructor() { }

  ngOnInit(): void {
    console.log(this.client)
  }

  cerrarForm(){
    if (this.componente === 'crear') {
      console.log('crear')
    } else {
      this.cerrar.emit(true)
      console.log('consultar')
    } 
  }
}
