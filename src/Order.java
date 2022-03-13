import java.io.Serializable;
import java.time.LocalDateTime;

public class Order implements Serializable{
    //Data members
    private String orderId;
    private String orderDescription;
    private String deliveryAddress;
    private LocalDateTime orderDate;
    private double amount;
    private LocalDateTime deliveryDateTime;

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
//        return "OrderId : " +orderId + "\tOrderDescription : " +orderDescription + "\tdeliveryAddress : " +deliveryAddress + "\tOrderTime : " +orderDate + "\tAmount : " +amount;
        System.out.println("----------------------------------------------------------------------------------------------------------");
          return " | \t" +orderId + " | \t" + orderDescription + " | \t" + deliveryAddress + " | \t" + orderDate + " | \t" + amount + " | \t" +deliveryDateTime + " |";
    }
}
