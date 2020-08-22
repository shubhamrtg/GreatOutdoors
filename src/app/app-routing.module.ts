import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { WishlistComponent } from './wishlist/wishlist.component';
import { ViewProductComponent } from './view-product/view-product.component';
import { ViewProductAdminComponent } from './view-product-admin/view-product-admin.component';


const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:"viewproduct",component:ViewProductComponent},
  {path:"viewproductadmin",component:ViewProductAdminComponent},
  {path:"wishlist",component:WishlistComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
