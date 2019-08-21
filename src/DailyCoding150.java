import java.util.*;

class Point {
    int x;
    int y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class DailyCoding150 {
    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));
        points.add(new Point(5,4));
        points.add(new Point(3,1));

        Point input = new Point(1,2);
        List<Point> kNearestPoints = findKNearestPoints(input, points, 2);

        for (Point p : kNearestPoints){
            System.out.println("[" + p.x + ", "+ p.y +"]");
        }
    }
    public static List<Point> findKNearestPoints(Point input, List<Point> points, int k){
        Comparator<Point> pointComparator = (p1, p2) -> {
            int dist1 = (int)(Math.pow(p1.x - input.x, 2) + Math.pow(p1.y - input.y, 2));
            int dist2 = (int)(Math.pow(p2.x - input.x, 2) + Math.pow(p2.y - input.y, 2));
            if(dist1 < dist2){
                return 1;
            } else if(dist1 > dist2){
                return -1;
            } else {
                return 0;
            }
        };

        PriorityQueue<Point> queue = new PriorityQueue<>(pointComparator);
        int maxDist = 0;
        for (Point p : points){
            int dist = (int)(Math.pow(p.x - input.x, 2) + Math.pow(p.y - input.y, 2));
            if (queue.size() < k){
                //just add and update max distance
                queue.add(p);
                maxDist = Math.max(maxDist, dist);
            } else {
                if (dist < maxDist){
                    //the current point is closer than the farthest point in the queue
                    queue.poll(); // remove the head of the queue which is the furthest element
                    queue.add(p);
                    //have to recalculate maxDist since maxDist could be smaller than the previous value
                    maxDist = (int)(Math.pow(queue.peek().x - input.x, 2) + Math.pow(queue.peek().y - input.y, 2));
                }
            }
        }
        List<Point> result = new ArrayList<>();
        Iterator<Point> it = queue.iterator();
        while (it.hasNext()){
            result.add(it.next());
        }
        return result;
    }
}
