package lightning;

import javalib.worldimages.WorldImage;

public class Fork implements ILightningBolt {
  public Fork(int leftLength, int rightLength,
              int leftCurrent, int rightCurrent,
              double leftTheta, double rightTheta,
              ILightningBolt left, ILightningBolt right) {
    throw new RuntimeException("If you got this to run, your tests compile correctly against the data definitions.");
  }

  public WorldImage draw() {
    throw new RuntimeException("If you got this to run, your tests compile correctly against the data definitions.");
  }

  public boolean isPhysicallyPossible() {
    throw new RuntimeException("If you got this to run, your tests compile correctly against the data definitions.");
  }

  public ILightningBolt combine(int leftLength, int rightLength,
                                int leftCurrent, int rightCurrent,
                                double leftTheta, double rightTheta,
                                ILightningBolt otherBolt) {
    throw new RuntimeException("If you got this to run, your tests compile correctly against the data definitions.");
  }

  public double getWidth() {
    throw new RuntimeException("If you got this to run, your tests compile correctly against the data definitions.");
  }
}
