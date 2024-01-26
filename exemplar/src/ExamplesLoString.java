import lists.*;
import tester.*;

class ExamplesLoString {

  ILoString mtList = new MtLoString();

  ILoString mixTest1 = new ConsLoString("One", new SnocLoString(new ConsLoString("Two", mtList), "Three"));
  
  ILoString consList1 =
      new ConsLoString("One",
          new ConsLoString("Two", 
              new ConsLoString("Three", mtList)));
  ILoString consList1Rev = 
      new ConsLoString("Three",
          new ConsLoString("Two", 
              new ConsLoString("One", mtList)));
    
  ILoString consList1Norm =
      new ConsLoString("One",
          new ConsLoString("Two", 
              new ConsLoString("Three", mtList)));

  ILoString snocList1 =
      new SnocLoString(
          new SnocLoString(
              new SnocLoString(
                  mtList, "One"), "Two"), "Three");
  ILoString snocList1Rev =
      new SnocLoString(
          new SnocLoString(
              new SnocLoString(
                  mtList, "Three"), "Two"), "One");

  ILoString appendList1 =
      new AppendLoString(
          consList1, snocList1);
  ILoString appendList1Rev = 
      new AppendLoString(
          consList1Rev, snocList1Rev);


  boolean testReverse1(Tester t) {
    return t.checkExpect(mtList.reverse(), mtList)
        && t.checkExpect(consList1.reverse().normalize(), consList1Rev)
        && t.checkExpect(snocList1.reverse().normalize(), consList1Rev)
        && t.checkExpect(mixTest1.reverse().normalize(), new ConsLoString("Three", new ConsLoString("Two", new ConsLoString("One", mtList))))
        && t.checkExpect(appendList1.reverse().normalize(), new ConsLoString("Three", new ConsLoString("Two", new ConsLoString("One", new ConsLoString("Three", new ConsLoString("Two", new ConsLoString("One", mtList)))))));
  }
  boolean testNormal1(Tester t) {
    return t.checkExpect(mixTest1.normalize(), new ConsLoString("One", new ConsLoString("Two", new ConsLoString("Three", mtList))));
  }
  boolean testLeftScan(Tester t) {
    return t.checkExpect(mixTest1.scanConcat(), new ConsLoString("One", new ConsLoString("OneTwo", new ConsLoString("OneTwoThree", mtList))));
  }

  
}
