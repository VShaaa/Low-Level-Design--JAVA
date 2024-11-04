package lift_Mgmt;

import java.util.PriorityQueue;
import java.util.*;
class Lifts {
    private int cFloor;
    private PriorityQueue<Integer> upQ;
    private PriorityQueue<Integer> downQ;

    public Lifts() {
        this.cFloor = 0;
        this.upQ = new PriorityQueue<>();
        this.downQ = new PriorityQueue<>((a, b) -> b - a);
    }

    public void reqFloor(int floor) {
        if (floor > cFloor) {
            upQ.add(floor);
        } else if (floor < cFloor) {
            downQ.add(floor);
        }
    }

    public void move() {
        while (!upQ.isEmpty() || !downQ.isEmpty()) {
            if (!upQ.isEmpty()) {
                cFloor = upQ.poll();
                System.out.println("You have moved to the floor " + cFloor);
            } else if (!downQ.isEmpty()) {
                cFloor = downQ.poll();
                System.out.println("You have moved to the floor " + cFloor);
            }
        }
    }
}

public class LiftMgt {
    public static void main(String[] args) {
        Lifts l = new Lifts();
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to the Lift Management Portal!");
            System.out.println("1. Request floor");
            System.out.println("2. Move lift");
            System.out.println("3. Exit");
            System.out.print("Choose an option to proceed: ");
            int choice = s.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter floor number to request: ");
                    int floor = s.nextInt();
                    l.reqFloor(floor);
                    break;
                case 2:
                    l.move();
                    break;
                case 3:
                    System.out.println("Exiting... THANK YOU!");
                    return;
                default:
                    System.out.println("Invalid choice. Please select from above options.");
            }
        }
    }
}


