public class Car extends Vehicle {
    int endurance;  // 续航
    @Override
    public void detailsSet() {
        System.out.println("轿车产品可添加 续航 数据。");
        System.out.print("请输入数据（单位为km）：");
        String end_S = Main.sc.next();
        if(!Factory.isNumeric4(end_S)) {
            System.out.println("错误的输入。");
            System.out.print("请输入数据（单位为km）：");
            end_S = Main.sc.next();
        }
        endurance = Integer.parseInt(end_S);
    }
    @Override
    public void details() {
        System.out.printf("本产品满电（油）续航为%dkm\n", endurance);
    }
    public Car() {}
    public Car(String vehicleld, String brand, String type, int perRent, int endurance) {
        super(vehicleld, brand, type, perRent);
        this.endurance = endurance;
    }
}
