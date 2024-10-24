package parkManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class parkMgmt {
    private ArrayList<String> vis = new ArrayList<>();

    public void addVis(String vname) {
        vis.add(vname);
        System.out.println(vname + " added to visitors list");
    }

    public void remVis(String vname) {
        if (vis.remove(vname)) {
            System.out.println(vname + " removed from visitors list");
        } else {
            System.out.println("Visitor not found");
        }
    }

    public void listOut() {
        System.out.println("Current visitors:");
        for (String vist : vis) {
            System.out.println(vist);
        }
    }

    public static void main(String[] args) {
        parkMgmt pm = new parkMgmt();
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to PARK MANAGEMENT portal!");
            System.out.println("1. Add Visitor");
            System.out.println("2. Remove Visitor");
            System.out.println("3. List Visitors");
            System.out.println("4. Exit");
            System.out.print("Choose an option to proceed: ");
            
            int choice = s.nextInt();
            s.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter visitor name: ");
                    pm.addVis(s.nextLine());
                    break;
                case 2:
                    System.out.print("Enter visitor name: ");
                    pm.remVis(s.nextLine());
                    break;
                case 3:
                    pm.listOut();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
