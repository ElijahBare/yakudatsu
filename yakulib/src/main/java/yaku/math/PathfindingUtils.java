package yaku.math;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PathfindingUtils {


    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(1, 1));
        points.add(new Point(2, 2));
        points.add(new Point(4, 4));
        points.add(new Point(6, 6));
        points.add(new Point(8, 8));
        points.add(new Point(10, 10));

        // Test case 1
        Point startPos1 = new Point(0, 0);
        Point nextBestPoint1 = PathfindingUtils.getNextBestPoint(startPos1, points);
        System.out.println("Next best point from " + startPos1 + ": " + nextBestPoint1);

        // Test case 2
        Point startPos2 = new Point(5, 5);
        Point nextBestPoint2 = PathfindingUtils.getNextBestPoint(startPos2, points);
        System.out.println("Next best point from " + startPos2 + ": " + nextBestPoint2);
    }


    public static Point getNextBestPoint(Point startPos, ArrayList<Point> points) {
        // sort points by furthest distance from startPos
        points.sort((p1, p2) -> {
            double distance1 = startPos.distance(p1);
            double distance2 = startPos.distance(p2);
            return Double.compare(distance1, distance2);
        });

        Point nextBestPoint = new Point();

        for (Point point : points) {
            if (isRaytraceable(startPos, point, points, 2)) {
                nextBestPoint = point;
            }
        }

        return nextBestPoint;
    }

    private static boolean isRaytraceable(Point start, Point end, ArrayList<Point> points, double leeway) {
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();

        // determine the number of steps based on the distance between start and end points
        int steps = (int) Math.max(Math.abs(dx), Math.abs(dy));

        // calculate the step sizes for x and y coordinates
        double stepX = dx / steps;
        double stepY = dy / steps;

        // perform ray tracing
        for (int i = 0; i <= steps; i++) {
            double x = start.getX() + i * stepX;
            double y = start.getY() + i * stepY;
            Point checkPoint = new Point((int) x, (int) y);

            // check if the point is within the allowed area, with leeway
            boolean withinAllowedArea = false;
            for (Point point : points) {
                if (checkPoint.distance(point) <= leeway) {
                    withinAllowedArea = true;
                    break;
                }
            }

            if (!withinAllowedArea) {
                return false;
            }
        }

        return true;
    }

}
