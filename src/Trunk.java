public class Trunk extends Vehicle {
    int capacity;   // 容量（T）

    public Trunk() {
    }

    public Trunk(String vehicleld, String brand, String type, int perRent, int capacity) {
        super(vehicleld, brand, type, perRent);
        this.capacity = capacity;
    }

    @Override
    public void detailsSet() {
        System.out.println("卡车产品可添加 容量 数据。");
        System.out.print("请输入数据（单位为吨）：");
        String cap_S = Main.sc.next();
        if (!Factory.isNumeric4(cap_S)) {
            System.out.println("错误的输入。");
            System.out.print("请输入数据（单位为吨）：");
            cap_S = Main.sc.next();
        }
        capacity = Integer.parseInt(cap_S);
    }

    @Override
    public void details() {
        System.out.printf("本产品可承载%d吨物品\n", capacity);
    }

}
