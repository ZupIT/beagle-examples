import { NgModule, Type } from '@angular/core'
// import all the components you're going to use with beagle

const components: Type<any>[] = [
  // your components
]

@NgModule({
  declarations: components,
  entryComponents: components,
  exports: components,
  imports: [
    // everything your components depend on
  ],
})
export class BeagleComponentsModule {}
