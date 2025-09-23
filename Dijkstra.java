import java.util.*;

class PriorityItem implements Comparable<PriorityItem> {
    String item;
    int weight;

    public PriorityItem(String item, int weight) {
        this.item = item;
        this.weight = weight;
    }

    @Override
    public int compareTo(PriorityItem other) {
        return Integer.compare(this.weight, other.weight);
    }
}

class DijkstraQueue {
    private PriorityQueue<PriorityItem> heap = new PriorityQueue<>();

    public void put(PriorityItem item) {
        heap.add(item);
    }

    public boolean contains() {
        return !heap.isEmpty();
    }

    public PriorityItem getPriorityNode() {
        return heap.poll();
    }
}

class Graph {
    private Map<String, List<PriorityItem>> content = new HashMap<>();

    public void addEdge(String fromNode, String toNode, int weight) {
        content.computeIfAbsent(fromNode, k -> new ArrayList<>())
               .add(new PriorityItem(toNode, weight));
    }

    public Map<String, List<PriorityItem>> getContent() {
        return content;
    }
}

public class Dijkstra {
    private List<String> path = new ArrayList<>();
    private int shortestDistance = -1;
    private DijkstraQueue dijkstraQueue;
    private Map<String, String> previous = new HashMap<>();
    private Map<String, Integer> distance = new HashMap<>();

    public void findShortestPath(String start, String finish, Graph graph) {
        dijkstraQueue = new DijkstraQueue();
        path.clear();
        previous.clear();
        distance.clear();

        for (String key : graph.getContent().keySet()) {
            if (key.equals(start)) {
                distance.put(key, 0);
                dijkstraQueue.put(new PriorityItem(key, 0));
            } else {
                distance.put(key, Integer.MAX_VALUE);
                dijkstraQueue.put(new PriorityItem(key, Integer.MAX_VALUE));
            }
            previous.put(key, null);
        }

        while (dijkstraQueue.contains()) {
            PriorityItem currentNode = dijkstraQueue.getPriorityNode();

            if (currentNode.item.equals(finish)) {
                while (previous.get(currentNode.item) != null) {
                    path.add(currentNode.item);
                    currentNode.item = previous.get(currentNode.item);
                }
                break;
            }

            if (currentNode.weight != Integer.MAX_VALUE) {
                List<PriorityItem> children = graph.getContent().getOrDefault(currentNode.item, new ArrayList<>());
                for (PriorityItem child : children) {
                    int newWeight = child.weight + distance.get(currentNode.item);
                    int currentWeight = distance.getOrDefault(child.item, Integer.MAX_VALUE);

                    if (newWeight < currentWeight) {
                        distance.put(child.item, newWeight);
                        previous.put(child.item, currentNode.item);
                        dijkstraQueue.put(new PriorityItem(child.item, newWeight));
                    }
                }
            }
        }

        path.add(start);
        Collections.reverse(path);
        shortestDistance = distance.getOrDefault(finish, -1);
    }

    public List<String> getPath() {
        return path;
    }

    public int getShortestDistance() {
        return shortestDistance;
    }

        public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge("A", "B", 1);
        g.addEdge("B", "C", 2);

        Dijkstra d = new Dijkstra();
        d.findShortestPath("A", "C", g);

        System.out.println("Shortest path: " + d.getPath());            
        System.out.println("Shortest distance: " + d.getShortestDistance());
    }
}
