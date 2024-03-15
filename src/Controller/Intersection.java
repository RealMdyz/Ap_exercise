package Controller;

import Model.Ball;

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

}
