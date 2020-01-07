import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'user-ui';

  constructor(private service: ApiService){}

  showUserById(){

    this.service.showUserById(1);

  }
}
