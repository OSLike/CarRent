public class Bus extends Vehicle {
    int maximum;    // 人数容载

    public Bus() {
    }

    public Bus(String vehicleld, String brand, String type, int perRent, int maximum) {
        super(vehicleld, brand, type, perRent);
        this.maximum = maximum;
    }

    @Override
    public void detailsSet() {
        System.out.println("巴士产品可添加 人数容载 数据。");
        System.out.print("请输入数据（单位为人）：");
        String max_S = Main.sc.next();
        if (!Factory.isNumeric4(max_S)) {
            System.out.println("错误的输入。");
            System.out.print("请输入数据（单位为人）：");
            max_S = Main.sc.next();
        }
        maximum = Integer.parseInt(max_S);
    }

    @Override
    public void details() {
        System.out.printf("本产品最多可容载%d人\n", maximum);
    }
}
