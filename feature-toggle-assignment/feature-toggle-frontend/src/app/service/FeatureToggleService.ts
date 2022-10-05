import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {catchError, Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class FeatureToggleService {

  constructor(private httpClient: HttpClient) {

  }

  public getFeatureToggles(): Observable<FeatureToggle[]>{
    return this.httpClient.get<FeatureToggle[]>("api");
  }

  public createFeatureToggle(name: string): Observable<FeatureToggle>{
    return this.httpClient.post<FeatureToggle>("api", {name: name});
  }

  public deleteFeatureToggle(id: string): Observable<unknown>{
     return this.httpClient.delete<FeatureToggle>("api/" + id);
  }
}

export interface FeatureToggle {
  id: string;
  name: string;
}
