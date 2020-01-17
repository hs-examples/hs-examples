import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ApiServiceService {

  constructor(private http: HttpClient) { }


  showUserById(  id: number ) : string{

    this.http.get("http://localhost:8080");


    return "";

  }
}
