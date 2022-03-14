import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order implements Serializable,Runnable{

    private static final long serialVersionUID = -7242995977297486759L;

    static File f = new File("C:\\Workspace\\OrderManagementSystem\\OrderManagement.txt");
    static ArrayList<Order> list = new ArrayList<>();
    static ArrayList<Order> delivered = new ArrayList<>();

    //Data members
    private String orderId;
    private String orderDescription;
    private String deliveryAddress;
    private LocalDateTime orderDate;
    private double amount;
    private LocalDateTime deliveryDateTime;

    public Order()
    {

    }

    public Order(String orderId, String orderDescription, String deliveryAddress, LocalDateTime orderDate, double amount) {
        this.orderId = orderId;
        this.orderDescription = orderDescription;
        this.deliveryAddress = deliveryAddress;
        this.orderDate = orderDate;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDescription() {
        return orderDescription;
    }

    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDeliveryDateTime() {
        return deliveryDateTime;
    }

    public void setDeliveryDateTime(LocalDateTime deliveryDateTime) {
        this.deliveryDateTime = deliveryDateTime;
    }

    public String toString()
    {
          return " | \t" +orderId + " | \t" + orderDescription + " | \t" + deliveryAddress + " | \t" + orderDate + " | \t" + amount + " | \t" +deliveryDateTime + " |";
    }

    @Override
    public void run() {
        load();

        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getDeliveryDateTime() != null)
            {
                try {
                    FileWriter fw = new FileWriter("Delivered.txt",true);
                    PrintWriter pw = new PrintWriter(fw);
                    pw.println(list.get(i).toString());
                    pw.close();
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }



    /*load();

        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).getDeliveryDateTime() == null)
            {

            }else {
                try {
                    FileOutputStream fo = new FileOutputStream("OrderDelivered.txt");
                    ObjectOutputStream oo = new ObjectOutputStream(fo);
                    oo.writeObject(list.get(i).getOrderId() + " " + list.get(i).getOrderDescription() + " " + list.get(i).getOrderDate());
                    oo.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

                try {
                    FileInputStream fi = new FileInputStream("OrderDelivered.txt");
                    ObjectInputStream oi = new ObjectInputStream(fi);
                   delivered = (ArrayList<Order>) oi.readObject();
                   oi.close();
                }catch(Exception e)
                {
                    e.printStackTrace();
                }

                File newFile = new File("Delivered.txt");
                try {
                    newFile.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try{
                    FileWriter fw = new FileWriter(newFile);
                    PrintWriter pw = new PrintWriter(fw);
                    for(int j=0;j<delivered.size();j++) {
                        pw.println(delivered.get(j).getOrderId() + " " + delivered.get(j).getOrderDescription());
                    }
                    pw.close();
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
            }*/


    }


    public void load()
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
        }else {
            System.out.println("List is empty.....");
        }
        }



}
