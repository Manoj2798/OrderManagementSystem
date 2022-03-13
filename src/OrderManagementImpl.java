import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderManagementImpl implements OrderManagement{

    static File f = new File("C:\\Workspace\\OrderManagementSystem\\OrderManagement.txt");
    static ArrayList<Order> list = new ArrayList<>();
//    ArrayList<Order> orders = new ArrayList<>();

    @Override
    public void addOrder(String orderId,String orderDescription,String deliveryAddress,LocalDateTime orderDate,double amount) {

//        if(list.isEmpty())
//        {
//            try{
//                FileInputStream fi = new FileInputStream(f);
//                ObjectInputStream oi = new ObjectInputStream(fi);
//                ArrayList<Order> orders = (ArrayList<Order>)oi.readObject();
//            }catch(Exception e)
//            {
//                e.printStackTrace();
//            }
//        }else
            list.add(new Order(orderId,orderDescription,deliveryAddress,orderDate,amount));
            System.out.println("Order Added Successfully....");

        //writing to a file
        try {
            FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(list);
            oo.flush();
            oo.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }


    }

    @Override
    public void viewOrder() {
        if(f.length()!=0) {
            try {
                FileInputStream fi = new FileInputStream(f);
                ObjectInputStream oi = new ObjectInputStream(fi);
                list = (ArrayList<Order>) oi.readObject();

//                System.out.println(" | \t +orderId +  | \t + orderDescription +  | \t + deliveryAddress +  | \t + orderDate +  | \t + amount +  | \t +deliveryDateTime +  |");
                // reading to the console
                for (Order i : list) {
                    System.out.println(i.toString());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else
            System.out.println("List is empty.....");
    }

    @Override
    public void viewByOrderId(String orderID) {

        System.out.println("----------------------------");
        System.out.println("Order Detail");
        System.out.println("----------------------------");
        for(Order i : list)
        {
            if(orderID.equals(i.getOrderId()))
            {
                System.out.println("Order Id : " +i.getOrderId());
                System.out.println("Order Description : " +i.getOrderDescription());
                System.out.println("Delivery Address : " +i.getDeliveryAddress());
                System.out.println("Order Date : " +i.getOrderDate());
                System.out.println("Amount : " +i.getAmount());
                System.out.println("Delivery Date Time : " +i.getDeliveryDateTime());
            }
        }
    }

    @Override
    public void sortOrder() {

    }

    @Override
    public void deleteOrderById(String orderId) {
        Load();
        System.out.println("The size of the List is : " +list.size());
        for(int i=0;i<list.size();i++)
        {
            if(orderId.equals(list.get(i).getOrderId()))
            {
                list.remove(i);
                break;
            }
        }
        System.out.println("Your order has been removed Successfully.....");

        //updating the file
        try {
            FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(list);
            oo.flush();
            oo.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void markAsDelivered(String orderID) {
        Load();
        System.out.println("The size of the List is : " +list.size());

        for(int i=0;i<list.size();i++)
        {
            if(orderID.equals(list.get(i).getOrderId()))
            {
                list.get(i).setDeliveryDateTime(LocalDateTime.now());
                System.out.println("Order Delivered Successfully...");
                break;
            }
        }

        //updating the file
        update();
    }

    @Override
    public void generateReport() {

    }

    @Override
    public void exit() {
        try {
            FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(list);
            oo.flush();
            oo.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Exited Thank you.....");
    }

    public static void Load()
    {
        if(f.length()!=0) {
            try {
                FileInputStream fi = new FileInputStream(f);
                ObjectInputStream oi = new ObjectInputStream(fi);
                list = (ArrayList<Order>) oi.readObject();

//                // reading to the console
//                for (Order i : list) {
//                    System.out.println(i.toString());
//                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else
            System.out.println("List is empty.....");
    }

    public static void update()
    {
        try {
            FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream oo = new ObjectOutputStream(fo);
            oo.writeObject(list);
            oo.flush();
            oo.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
