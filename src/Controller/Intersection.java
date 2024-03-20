package Controller;

import Model.Ball;
import Model.Block;
import Model.UsualItem;

public class Intersection {

    public Intersection() {

    }

    public boolean intersect(Block block, Ball ball) {
        // Calculate the center of the ball
        int ballCenterX = ball.getX() + ball.getWidth() / 2;
        int ballCenterY = ball.getY() + ball.getHeight() / 2;

        // Calculate the closest corner of the block to the ball
        int closestX = clamp(ballCenterX, block.getX(), block.getX() + block.getWidth());
        int closestY = clamp(ballCenterY, block.getY(), block.getY() + block.getHeight());

        // Calculate the distance from the ball's center to the closest corner
        int dx = ballCenterX - closestX;
        int dy = ballCenterY - closestY;
        int distanceSquared = dx * dx + dy * dy;

        // Check if the distance is less than the ball's radius squared
        if (distanceSquared <= ball.getRadius() * ball.getRadius()) {
            // Collision occurred
            // Determine which corner the ball is closest to
            boolean onTopEdge = closestY == block.getY();
            boolean onBottomEdge = closestY == block.getY() + block.getHeight();
            boolean onLeftEdge = closestX == block.getX();
            boolean onRightEdge = closestX == block.getX() + block.getWidth();

            // Adjust ball's position and reverse velocity based on corner
            if (onTopEdge && onLeftEdge) {
                handleCornerCollision(ball, block, -1, -1);
            } else if (onTopEdge && onRightEdge) {
                handleCornerCollision(ball, block, 1, -1);
            } else if (onBottomEdge && onLeftEdge) {
                handleCornerCollision(ball, block, -1, 1);
            } else if (onBottomEdge && onRightEdge) {
                handleCornerCollision(ball, block, 1, 1);
            } else if (onTopEdge) {
                ball.setY(block.getY() - ball.getHeight() - ball.getRadius());
                ball.setyVelocity(-ball.getyVelocity());
            } else if (onBottomEdge) {
                ball.setY(block.getY() + block.getHeight() + ball.getRadius());
                ball.setyVelocity(-ball.getyVelocity());
            } else if (onLeftEdge) {
                ball.setX(block.getX() - ball.getWidth() - ball.getRadius());
                ball.setxVelocity(-ball.getxVelocity());
            } else if (onRightEdge) {
                ball.setX(block.getX() + block.getWidth() + ball.getRadius());
                ball.setxVelocity(-ball.getxVelocity());
            }

            return true;
        }

        return false;
    }
    public boolean intersect(UsualItem itemBall, Ball ball) {
        // Calculate the center of the ball
        int ballCenterX = ball.getX() + ball.getWidth() / 2;
        int ballCenterY = ball.getY() + ball.getHeight() / 2;

        // Calculate the center of the item ball
        int itemBallCenterX = itemBall.getX() + itemBall.getWidth() / 2;
        int itemBallCenterY = itemBall.getY() + itemBall.getHeight() / 2;

        // Calculate the distance between the centers of the two balls
        int dx = ballCenterX - itemBallCenterX;
        int dy = ballCenterY - itemBallCenterY;
        int distanceSquared = dx * dx + dy * dy;

        // Check if the distance is less than the sum of their radii squared
        int combinedRadius = ball.getRadius() + itemBall.getWidth();
        return distanceSquared <= combinedRadius * combinedRadius;
    }

    // Helper method to handle corner collision
    private void handleCornerCollision(Ball ball, Block block, int xDirection, int yDirection) {
        ball.setX(block.getX() + (xDirection > 0 ? block.getWidth() + ball.getRadius() : -ball.getWidth() - ball.getRadius()));
        ball.setY(block.getY() + (yDirection > 0 ? block.getHeight() + ball.getRadius() : -ball.getHeight() - ball.getRadius()));
        ball.setxVelocity(-ball.getxVelocity());
        ball.setyVelocity(-ball.getyVelocity());
    }

    // Helper method to clamp a value between a minimum and maximum
    private int clamp(int val, int min, int max) {
        if (val < min) return min;
        if (val > max) return max;
        return val;
    }
}
