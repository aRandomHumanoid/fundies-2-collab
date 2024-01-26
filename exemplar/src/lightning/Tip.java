package lightning;

import javalib.worldimages.WorldImage;

public class Tip implements ILightningBolt {
  public Tip() {
    throw new RuntimeException("If you got this to run, your tests compile correctly against the data definitions.");
  }

  public WorldImage draw() {
    throw new RuntimeException("If you got this to run, your tests compile correctly against the data definitions.");
  }

  public boolean isPhysicallyPossible() {
    throw new RuntimeException("If you got this to run, your tests compile correctly against the data definitions.");
  }

  public ILightningBolt combine(int leftLength, int rightLength,
                                int leftCapacity, int rightCapacity,
                                double leftTheta, double rightTheta,
                                ILightningBolt otherBolt) {
    throw new RuntimeException("If you got this to run, your tests compile correctly against the data definitions.");
  }

  public double getWidth() {
    throw new RuntimeException("If you got this to run, your tests compile correctly against the data definitions.");
  }
}
