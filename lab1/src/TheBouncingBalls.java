import tester.Tester;
import java.awt.Color;
import javalib.worldimages.*;
 
class BouncingBall {
  Posn pos;
  Color color;
  int size;
  int dx; // how fast is the ball moving to the right?
  int dy; // how fast is the ball moving downward?
 
  BouncingBall(Posn pos, Color color, int size, int dx, int dy) {
    this.pos = pos;
    this.color = color;
    this.size = size;
    this.dx = dx;
    this.dy = dy;
  }
 
  // Returns a new BouncingBall that's just like this BouncingBall, but moved
  // by this BouncingBall's dx and dy
  BouncingBall move() {
    return new BouncingBall(new Posn(this.pos.x + this.dx, this.pos.y + this.dy), this.color, 
                            this.size, this.dx, this.dy);
  }
 
  // Returns a new BouncingBall that represents this BouncingBall just after
  // it has bounced off a side wall. Does not actually move the ball.
  // This method will be called automatically when `collidesX` returns true
  BouncingBall bounceX() {
    return new BouncingBall(this.pos, this.color, this.size, -this.dx, this.dy);
  }
 
  // Like bounceX, except for using the top or bottom walls
  BouncingBall bounceY() {
    return new BouncingBall(this.pos, this.color, this.size, this.dx, -this.dy);
  }
 
  // Detects whether the ball is colliding with a side wall.
  boolean collidesX(Posn topLeft, Posn botRight) {
    return (this.pos.x - this.size < topLeft.x && dx < 0) 
        || (this.pos.x + this.size > botRight.x && dx > 0);
  }
 
  // Detects whether the ball is colliding with a top or bottom wall.
  boolean collidesY(Posn topLeft, Posn botRight) {
    return (this.pos.y - this.size < topLeft.y && dy < 0) 
        || (this.pos.y + this.size > botRight.y && dy > 0);
  }
  
  //Returns the area of this ball
  double area() {
    return Math.PI * Math.pow(this.size, 2);
  }
   
  // Returns the circumference of this ball
  double circumference() {
    return 2 * Math.PI * this.size;
  }
   
  // Returns the distance between this ball and that ball
  double distanceTo(BouncingBall that) {  
    return Math.sqrt(Math.pow(this.pos.x - that.pos.x, 2) + Math.pow(this.pos.y - that.pos.y, 2));
  }
   
  // Returns if this ball overlaps that ball
  boolean overlaps(BouncingBall that) {
    return this.distanceTo(that) - this.size < 0 || this.distanceTo(that) - that.size < 0;
  }
  
}
 
class ExamplesBouncingBalls {
  int WIDTH = 700;
  int HEIGHT = 700;

  // NOTE: We have provided BouncingWorld for you, in the starter code.
  // We'll see how it works in a few lectures
  boolean testBigBang(Tester t) {
    BouncingWorld w = new BouncingWorld(WIDTH, HEIGHT);
    return w.bigBang(WIDTH, HEIGHT, 0.01);
  }
  
}