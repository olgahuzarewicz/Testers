import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { MatSelectModule } from '@angular/material/select';
import { MatTableModule } from '@angular/material/table';

import { ResultTableComponent } from './result-table/result-table.component';
import { SearchBarComponent } from './search-bar/search-bar.component';
import { SearchBarService } from './search-bar/search-bar.service';
import { ResultTableService } from './result-table/result-table.service';

@NgModule({
  declarations: [
    AppComponent,
    ResultTableComponent,
    SearchBarComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MatSelectModule,
    MatTableModule
  ],
  providers: [SearchBarService, ResultTableService],
  bootstrap: [AppComponent]
})
export class AppModule { }
