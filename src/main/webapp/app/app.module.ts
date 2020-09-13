import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { SampleappSharedModule } from 'app/shared/shared.module';
import { SampleappCoreModule } from 'app/core/core.module';
import { SampleappAppRoutingModule } from './app-routing.module';
import { SampleappHomeModule } from './home/home.module';
import { SampleappEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    SampleappSharedModule,
    SampleappCoreModule,
    SampleappHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    SampleappEntityModule,
    SampleappAppRoutingModule,
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent],
})
export class SampleappAppModule {}
