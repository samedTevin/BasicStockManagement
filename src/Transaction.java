public class Transaction {

    private int id;
    private String product;
    private int quantity;
    private String type;

    public Transaction(String product, int quantity, String type){
        this.product = product;
        this.quantity =quantity;
        this.type = type;
    }

    public int getId(){
        return id;
    }

    public void setProduct(String product){
        this.product = product;
    }

    public String getProduct(){
        return product;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }



}
