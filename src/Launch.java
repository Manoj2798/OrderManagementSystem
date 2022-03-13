import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Launch {

    static ArrayList<Order> orders = new ArrayList<>();
    static File f = new File("C:\\Workspace\\OrderManagementSystem\\OrderManagement.txt");

    static void menu() {
        System.out.println("********Order Management System*********");
        System.out.println("1.	Add Order");
        System.out.println("2.	View Order List");
        System.out.println("3.	View By Order Id");
        System.out.println("4.	Sort Order");
        System.out.println("5.	Delete Order by Id");
        System.out.println("6.	Mark as Delivered.");
        System.out.println("7.	Generate Report.");
        System.out.println("8.	Exit");

    }

    public static void readFile() {
        if (f.length() == 0) {
            System.out.println("File is empty......");
        } else {
//            System.out.println("Inside Orders updation.....");
            try {
                FileInputStream fi = new FileInputStream(f);
                ObjectInputStream oi = new ObjectInputStream(fi);
                orders = (ArrayList<Order>) oi.readObject();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {


//        Scanner s = new Scanner(f);


        Scanner sc = new Scanner(System.in);
        OrderManagementImpl o = new OrderManagementImpl();
        boolean flag = false;


        int choice;
        lbl:
        do {
            readFile();
            menu();

            if (flag) {
                choice = 1;
            } else {
                choice = sc.nextInt();
            }
            switch (choice) {

                case 1:
                case 'Y':
                    System.out.println("Enter orderId : ");
                    String orderId = sc.next();
                    /*System.out.println("OrderId is : " +orderId);
                    System.out.println("List size is : " +orders.size());*/
                    for (Order i : orders) {
                        if (orderId.equalsIgnoreCase(i.getOrderId())) {
                            System.out.println("Duplicate Order Id... Please Enter the order again");
                            break lbl;
                        }
                    }
                    sc.skip("\n");
                    System.out.println("Enter orderDescription: ");
                    String orderDescription = sc.nextLine();
                    System.out.println("Enter deliveryAddress: ");
                    String deliveryAddress = sc.nextLine();
                    System.out.println("Enter amount: ");
                    double amount = sc.nextDouble();

//                    String dateFormat = "yyyy-MM-dd hh:mm:ss a";
//                    LocalDateTime now = LocalDateTime.now();
//                    LocalDateTime format = LocalDateTime.parse(now.format(DateTimeFormatter.ofPattern(dateFormat)));

                    LocalDateTime orderDate = LocalDateTime.now();
                    o.addOrder(orderId, orderDescription, deliveryAddress, orderDate, amount);
//                    System.out.println("Do you want to Place another order... Press Y to place.. N to return to menu");
//                    char ch = sc.next().charAt(0);
//                    if(ch == 'Y') {
//                        flag = true;
//                    }
                    break;

                case 2:
                    o.viewOrder();
                    break;

                case 3:
                    System.out.println("Enter OrderId :");
                    String ordID = sc.next();
                    o.viewByOrderId(ordID);
                    break;

                case 4:
                    o.sortOrder();
                    break;

                case 5:
                    System.out.println("Enter OrderId : ");
                    String oID = sc.next();
                    o.deleteOrderById(oID);
                    break;

                case 6:
                    System.out.println("Enter orderId : ");
                    String id = sc.next();

                    for(int i=0;i<orders.size();i++)
                    {
                        if(id.equals(orders.get(i).getOrderId()) && orders.get(i).getDeliveryDateTime()!=null)
                        {
                            System.out.println("Order has been already delivered at : " +LocalDateTime.now());
                            break lbl;
                        }
                    }
                    o.markAsDelivered(id);
                    break;

                case 7:
                    o.generateReport();
                    break;

                case 8:
                    o.exit();
                    break;
            }
        } while (choice != 8);
    }
}
