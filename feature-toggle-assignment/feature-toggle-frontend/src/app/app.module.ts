import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {applyPolyfills, defineCustomElements} from "@swisscom/sdx/dist/js/webcomponents/loader";
import { HttpClientModule} from "@angular/common/http";

@NgModule({
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  declarations: [
    AppComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor() {
    applyPolyfills().then(() => {
      defineCustomElements();
    });
  }
}
