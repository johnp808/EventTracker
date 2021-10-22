import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
import { Contestant } from '../models/contestant';

@Injectable({
  providedIn: 'root'
})
export class ContestantService {

  private baseUrl = 'http://localhost:8087/';
  private url = this.baseUrl + 'api/contestants';
  constructor(
    private http: HttpClient
  ) { }

  index(): Observable<Contestant[]> {
    return this.http.get<Contestant[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError('TodoService.index(): Error retrieving Todo list');
      })
    );
  }
}
