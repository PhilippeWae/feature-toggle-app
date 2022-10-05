import {Component, OnInit} from '@angular/core';
import {FeatureToggle, FeatureToggleService} from "./service/FeatureToggleService";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  public featureToggles: FeatureToggle[] = [];
  public displayedToggles: FeatureToggle[] = [];
  public featureToggleName: string = '';

  constructor(private readonly featureToggleService: FeatureToggleService) {
  }

  public ngOnInit() {
    this.featureToggleService.getFeatureToggles().subscribe(value => this.featureToggles = value);
    this.featureToggleService.getFeatureToggles().subscribe(value => this.displayedToggles = value);
  }

  public onInput(event: Event) {
    const inputValue = (event.target as HTMLSdxInputElement).value
    if (inputValue === "") {
      this.displayedToggles = this.featureToggles
    } else {
      this.displayedToggles = this.featureToggles.filter(
        ft => ft.name === inputValue);
    }
  }

  public onClickCreate() {
    const name = (document.getElementById('first-input-element') as HTMLSdxInputElement).value
    this.featureToggleService.createFeatureToggle(name).subscribe(value => {
      this.featureToggles.push(value);
      this.displayedToggles.push(value);
    });
    (document.getElementById('first-input-element') as HTMLSdxInputElement).value = "";
    (document.getElementById('main-input') as HTMLSdxInputElement).value = "";
  }

  public onClickDelete(id: string) {
    this.featureToggleService.deleteFeatureToggle(id).subscribe();
    this.featureToggleService.getFeatureToggles().subscribe(value => this.featureToggles = value);
    this.featureToggleService.getFeatureToggles().subscribe(value => this.displayedToggles = value);
    (document.getElementById('main-input') as HTMLSdxInputElement).value = "";
  }
}
