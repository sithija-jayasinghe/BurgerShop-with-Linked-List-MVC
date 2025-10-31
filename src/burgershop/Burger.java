package burgershop;

public class Burger {
    public static final int UNIT_PRICE=500;
    public static final int PREPAIRING=0;
    public static final int CANCELED=1;
    public static final int DELIVERED=2;
    
    private String orderId;   
    private String customerId;
    private String customerName;
    private int qty;
    private int orderStatus;

    public Burger() {
    }

    public Burger(String orderId, String customerId, String customerName, int qty) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.qty = qty;
        this.orderStatus = PREPAIRING;
    }

    public Burger(String orderId, String customerId, String customerName, int qty, int orderStatus) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.qty = qty;
        this.orderStatus = orderStatus;
    }
    

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * @return the qty
     */
    public int getQty() {
        return qty;
    }

    /**
     * @param qty the qty to set
     */
    public void setQty(int qty) {
        this.qty = qty;
    }

    /**
     * @return the orderStatus
     */
    public int getOrderStatus() {
        return orderStatus;
    }

    /**
     * @param orderStatus the orderStatus to set
     */
    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    public boolean equals(Burger burger){
        return burger.orderId.trim().equalsIgnoreCase(this.orderId.trim());
    }
    
      public String toString() {
        return orderId + "," + customerId + "," + customerName + "," + qty + "," + orderStatus;
    }
    
}
