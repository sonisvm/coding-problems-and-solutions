import java.util.*;

/**
 * We're given a hashmap associating each courseId key with a list of courseIds values,
 * which represents that the prerequisites of courseId are courseIds. Return a sorted ordering
 * of courses such that we can finish all courses.
 *
 * Return null if there is no such ordering.
 *
 * Leetcode 207
 */
public class DailyCoding92 {
    public static void main(String[] args) {
        HashMap<String, List<String>> courses = new HashMap<>();

        List<String> list1 = new ArrayList<>();
        list1.add("CSC100");
        list1.add("CSC200");

        courses.put("CSC300", list1);

        List<String> list2 = new ArrayList<>();
        list2.add("CSC100");
        courses.put("CSC200", list2);

        courses.put("CSC100", new ArrayList<>());

        List<String> ordering = getCourseOrdering(courses);

        if (ordering!=null){
            Utility.printStr(ordering);
        }
    }

    public static List<String> getCourseOrdering(HashMap<String, List<String>> courses) {
        HashMap<String, Set<String>> prerequisites = new HashMap<>();
        Deque<String> queue = new ArrayDeque<>();
        for (Map.Entry<String, List<String>> entry : courses.entrySet()) {
            if (entry.getValue().size()==0) {
                queue.add(entry.getKey());
            }
            for (String course : entry.getValue()) {
                if (!prerequisites.containsKey(course)) {
                    prerequisites.put(course, new HashSet<>());
                }
                Set<String> set = prerequisites.get(course);
                set.add(entry.getKey());
                prerequisites.put(course, set);
            }
        }

        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()){
            String c = queue.poll();
            result.add(c);

            Set<String> dep = prerequisites.getOrDefault(c, new HashSet<>());
            for (String s : dep) {
                List<String> cs = courses.get(s);
                cs.remove(c);
                if (cs.size()==0) {
                    queue.add(s);
                } else {
                    courses.put(s, cs);
                }

            }
        }
        return result.size()!=courses.size() ? null : result;
    }

}
