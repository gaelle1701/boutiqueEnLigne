import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { SignupPageComponent } from './pages/signupPage/signup-page.component';

const routes: Routes = [
  { path: 'signup', component: SignupPageComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { scrollPositionRestoration: 'enabled' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
