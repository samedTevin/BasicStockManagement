public class Product {

    private int id;
    private String productName;
    private String brand;
    private String countryCode;
    private double price;
    private int stockQuantity;

    public Product(String productName, String brand, String countryCode, double price, int stockQuantity) {
        this.productName = productName;
        this.brand = brand;
        this.countryCode = countryCode;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setStockQuantity(int stock_quantity) {
        this.stockQuantity = stockQuantity;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

}
