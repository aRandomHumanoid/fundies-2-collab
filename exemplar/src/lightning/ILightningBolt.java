package lightning;

import javalib.worldimages.WorldImage;

public interface ILightningBolt {
  WorldImage draw();

  boolean isPhysicallyPossible();

  ILightningBolt combine(int leftLength, int rightLength,
                         int leftCapacity, int rightCapacity,
                         double leftTheta, double rightTheta,
                         ILightningBolt otherBolt);

  double getWidth();
}
