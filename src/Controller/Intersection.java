package Controller;

import Model.Ball;
import Model.Block;

public class Intersection {
    private Ball ball;

    public Intersection(Ball ball) {
        this.ball = ball;
    }

    public void intersectBall(){
        if(ball.getX() <= 0){
            ball.ChangeAngle(- ball.getxVelocity(), ball.getyVelocity());
        }
        if(ball.getX() >= 548){
            ball.ChangeAngle(- ball.getxVelocity(), ball.getyVelocity());
        }
        if(ball.getY() <= 0){
            ball.ChangeAngle(ball.getxVelocity(), - ball.getyVelocity());
        }
    }
    public boolean intersct(Block block){
        int object1Width = block.getWidth();
        int object1Height = block.getHeight();
        int object2Width = ball.getWidth();
        int object2Height = ball.getHeight();
        int object1X = block.getX();
        int object1Y = block.getY();
        int object2X = ball.getX();
        int object2Y = ball.getY();

        // Check if the objects have positive width and height, and return "none" if not
        if (object2Width <= 0 || object2Height <= 0 || object1Width <= 0 || object1Height <= 0) {
            return false;
        }
        int Rb1x = object1X + object1Width;
        int Rb1y = object1Y + object1Height;
        if(Rb1y >= object2Y && (object1X + 15 <= object2X && object2X <= Rb1x - 15)){
            block.Power -= 1;
            ball.ChangeAngle(ball.getxVelocity(), - ball.getyVelocity());
            return true;
        }
        if(Rb1x >= object2X && (object1Y + 15 <= object2Y && object2Y <= Rb1y - 15)){
            block.Power -= 1;
            ball.ChangeAngle(- ball.getxVelocity(),ball.getyVelocity());
            return true;
        }
        if(object1Y >= object2Y && (object1X + 15 <= object2X && object2X <= Rb1x - 15)){
            block.Power -= 1;
            ball.ChangeAngle(ball.getxVelocity(), - ball.getyVelocity());
            return true;
        }
        if(object1X >= object2X && (object1Y + 15 <= object2Y && object2Y <= Rb1y - 15)){
            block.Power -= 1;
            ball.ChangeAngle(- ball.getxVelocity(),ball.getyVelocity());
            return true;
        }
        return false;
    }


}
