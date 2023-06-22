package yaku.math;

import java.awt.*;
import java.util.ArrayList;

public class PathfindingUtils {

    public static Point getNextBestPoint(Point startPos, ArrayList<Point> points) {
        Point furthestPoint = null;
        double maxDistance = -1;

        for (Point point : points) {
            if (isRaytraceable(startPos, point, points) && point.getX() > maxDistance) {
                maxDistance = point.getX();
                furthestPoint = point;
            }
        }

        return furthestPoint;
    }

    private static boolean isRaytraceable(Point start, Point end, ArrayList<Point> points) {
        for (Point point : points) {
            if (point != start && point != end && !points.contains(point)) {
                if (isPointBetween(start, end, point)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isPointBetween(Point start, Point end, Point point) {
        double minX = Math.min(start.getX(), end.getX());
        double minY = Math.min(start.getY(), end.getY());
        double maxX = Math.max(start.getX(), end.getX());
        double maxY = Math.max(start.getY(), end.getY());

        return point.getX() >= minX && point.getX() <= maxX && point.getY() >= minY && point.getY() <= maxY;
    }
}
