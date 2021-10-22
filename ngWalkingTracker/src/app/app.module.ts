import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContestantListComponent } from './components/contestant-list/contestant-list.component';
import { ContestantService } from './services/contestant.service';

@NgModule({
  declarations: [
    AppComponent,
    ContestantListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule
  ],
  providers: [
    ContestantService
  ],

  bootstrap: [AppComponent]
})
export class AppModule { }
