import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { SampleappSharedModule } from 'app/shared/shared.module';
import { AccountEntityComponent } from './account-entity.component';
import { AccountEntityDetailComponent } from './account-entity-detail.component';
import { AccountEntityUpdateComponent } from './account-entity-update.component';
import { AccountEntityDeleteDialogComponent } from './account-entity-delete-dialog.component';
import { accountEntityRoute } from './account-entity.route';

@NgModule({
  imports: [SampleappSharedModule, RouterModule.forChild(accountEntityRoute)],
  declarations: [AccountEntityComponent, AccountEntityDetailComponent, AccountEntityUpdateComponent, AccountEntityDeleteDialogComponent],
  entryComponents: [AccountEntityDeleteDialogComponent],
})
export class SampleappAccountEntityModule {}
