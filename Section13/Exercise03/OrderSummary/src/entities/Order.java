package entities;

import entities.enums.OrderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Date moment;
    private OrderStatus status;
    private List<OrderItem> items = new ArrayList<>();

    private Client client;

    public Order(){

    }

    public Order(Date moment, OrderStatus status, Client client) {
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item){
        items.add(item);
    }

    public void removeItem(OrderItem item){
        items.remove(item);
    }

    public Double total(){
        Double orderTotal = Double.valueOf(0);

        for (OrderItem item: items) {
            orderTotal += item.subTotal();
        }

        return orderTotal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY: \n");
        sb.append("Order moment: " + this.moment + "\n");
        sb.append("Order Status: " + this.getStatus() + "\n");
        sb.append("Client: " + this.client.getName()
                + " (" + this.client.getBirthDate() +
                ") " + " - " + this.client.getEmail() + "\n");
        sb.append("Order items: " + "\n");
        for (OrderItem item : items) {
            sb.append(item.getProduct().getName() + ", $"
                    + item.getPrice() + ", Quantity: "
                    + item.getQuantity() + ", Subtotal: $"
                    + item.subTotal() + "\n");
        }

        sb.append("Total price: $" + total());

        return sb.toString();
    }
}
