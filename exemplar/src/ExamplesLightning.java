import lightning.*;
import tester.Tester;

import javalib.worldimages.*;
 
class ExamplesLightning {
  ILightningBolt tip1 = new Tip();
  ILightningBolt segment1 = new Segment(1, 40, 120, tip1);
  ILightningBolt segment2 = new Segment(1, 30, 60, tip1);
  ILightningBolt segment3 = new Segment(1, 20, 60, tip1);
  ILightningBolt segment4 = new Segment(4, 10, 60, tip1);
  ILightningBolt segment5 = new Segment(4, 400, 60, tip1);
  ILightningBolt bolt4 = new Fork(2, 1, 20, 30, 120, 60, segment5, tip1);
  ILightningBolt bolt1 = new Fork(1, 1, 20, 30, 120, 60, segment1, segment2);
  ILightningBolt bolt2 = new Fork(1, 1, 200, 300, 120, 60, segment1, segment2);
  ILightningBolt bolt3 = new Fork(1, 1, 20, 30, 120, 60, tip1, tip1);

  boolean testPossible1(Tester t) {
    return t.checkExpect(bolt1.isPhysicallyPossible(), false);
  }

  boolean testPossible2(Tester t) {
    return t.checkExpect(segment1.isPhysicallyPossible(), true);
  }
  boolean testCombine1(Tester t) {
    return t.checkExpect(segment1.combine(1, 1, 20, 30, 120, 60, segment3), 
            new Fork(1, 1, 20, 30, 120, 60, new Segment(1, 40, 150, tip1), new Segment(1, 20, 30, tip1)));
  }

  boolean testCombine2(Tester t) {
    return t.checkExpect(bolt3.combine(1, 1, 20, 30, 120, 60, segment3), 
            new Fork(1, 1, 20, 30, 120, 60, new Fork(1, 1, 20, 30, 150, 90, tip1, tip1), new Segment(1, 20, 30, tip1)));
  }
  boolean testWidth1(Tester t) {
    return t.checkExpect((int)segment4.getWidth(), 2);
  }

  boolean testWidth2(Tester t) {
    return t.checkExpect((int)tip1.getWidth(), 0);
  }

  boolean testWidth3(Tester t) {
    return t.checkExpect((int)(bolt1.getWidth() + 0.01), 2);
  }

  boolean testWidth4(Tester t) {
    return t.checkExpect((int)(bolt4.getWidth() + 0.01), 2);
  }
}