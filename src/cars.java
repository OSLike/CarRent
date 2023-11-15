import java.io.Serializable;

abstract class Vehicle implements Serializable {
    String vehicleld;           // 车牌号
    String brand;               // 品牌
    String type;                // 型号
    int perRent;                // 日租金
    public void detailsSet() {}
    public void details() {}

    public void setVehicleld(String vehicleld) {
        this.vehicleld = vehicleld;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPerRent(int perRent) {
        this.perRent = perRent;
    }

    public Vehicle() {}
    public Vehicle(String vehicleld, String brand, String type, int perRent) {
        this.vehicleld = vehicleld;
        this.brand = brand;
        this.type = type;
        this.perRent = perRent;
    }
}

