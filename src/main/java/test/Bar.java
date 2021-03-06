package test;

abstract class Bar
{
   // you don't have to have this in the base class 
   // - you could leave out the variable and make
   // getFoo() abstract.
   static private String foo="sd";

//   String getFoo() {
//     return foo;
//   }
   
   abstract String getFoo();

   public void printFoo() {
      System.out.print(getFoo());
   }
}

class Foo1 extends Bar
{
   static String foo1;

   public String getFoo() {
      return foo1;  // return our foo1 value
   }

   public Foo1() {
      foo1 = "myfoo1";
   }
}


class Foo2 extends Foo1
{
   static String foo2;

   public String getFoo() {
      return foo2;  // return our foo2 value
   }

   public Foo2() {
      foo2 = "myfoo2";
   }
}