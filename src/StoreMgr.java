import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class StoreMgr extends User implements Factory {
    public StoreMgr(String userName, String userPwd, boolean isAdmin) {
        super(userName, userPwd, isAdmin);
    }

    public static boolean CLI() throws IOException {
        System.out.println("*********************");
        System.out.println("*    本汽车租赁系统   *");
        System.out.println("*  你现在在管理员页面  *");
        System.out.println("*    1 查看汽车信息   *");
        System.out.println("*    2 修改汽车信息   *");
        System.out.println("*    3 增加车辆      *");
        System.out.println("*    4 删除车辆      *");
        System.out.println("*    5 返回         *");
        System.out.println("*    当前版本V4.0    *");
        System.out.println("*********************");
        System.out.print("请输入对应数字：");
        String num_into = Main.sc.next();
        switch (num_into) {
            case "5":
                return false;
            case "1":
                Factory.carInfoViewer();
                break;
            case "2":
                carInfoChange();
                break;
            case "3":
                addCar();
                break;
            case "4":
                delCar();
                break;
            default:
                System.out.println("错误的输入。");
                break;
        }
        return true;
    }

    public static void carInfoChange() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("t.tmp"));
        System.out.print("请输入你希望修改信息的车辆的对应编号：");
        String num_S = Main.sc.next();
        if (!Factory.isNumeric4(num_S)) {
            System.out.print("错误的输入。\n请重新输入：");
            num_S = Main.sc.next();
        }
        int num = Integer.parseInt(num_S);
        System.out.println("接下来请输入对应车辆的基础信息：");
        System.out.print("车牌号：");
        Main.vehicles.get(num - 1).setVehicleld(Main.sc.next());
        System.out.print("品牌：");
        Main.vehicles.get(num - 1).setBrand(Main.sc.next());
        System.out.print("型号：");
        Main.vehicles.get(num - 1).setType(Main.sc.next());
        System.out.print("日租金：");
        String perRent_S = Main.sc.next();
        int perRent_I;
        if (!Factory.isNumeric4(perRent_S)) {
            System.out.print("错误的输入。\n请重新输入：");
            perRent_S = Main.sc.next();
        }
        perRent_I = Integer.parseInt(perRent_S);
        Main.vehicles.get(num - 1).setPerRent(perRent_I);
        System.out.println("接下来请输入对应车辆的细节信息：");
        Main.vehicles.get(num - 1).detailsSet();
        System.out.println("修改成功！");
        oos.writeObject(Main.vehicles);
        oos.close();
    }

    public static void addCar() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("t.tmp"));
        System.out.println("1 卡车;2 轿车;3 巴士");
        System.out.print("请输入车辆类型对应的数字：");
        String num = Main.sc.next();
        Vehicle newVehicle;
        switch (num) {
            case "1":
                newVehicle = new Trunk();
                break;
            case "2":
                newVehicle = new Car();
                break;
            case "3":
                newVehicle = new Bus();
                break;
            default:
                System.out.println("错误的输入。");
                return;
        }
        System.out.println("请输入基础信息（包括车牌号、品牌、型号、日租金）");
        System.out.print("车牌号：");
        newVehicle.setVehicleld(Main.sc.next());
        System.out.print("品牌：");
        newVehicle.setBrand(Main.sc.next());
        System.out.print("型号：");
        newVehicle.setType(Main.sc.next());
        System.out.print("日租金：");
        String perRent_S = Main.sc.next();
        int perRent_I;
        while (!Factory.isNumeric4(perRent_S)) {
            System.out.println("错误的输入，请重新输入。");
            System.out.print("日租金:");
            perRent_S = Main.sc.next();
        }
        perRent_I = Integer.parseInt(perRent_S);
        newVehicle.setPerRent(perRent_I);
        System.out.println("已成功添加。\n请添加当前车辆的细节信息：");
        newVehicle.detailsSet();
        Main.vehicles.add(newVehicle);
        System.out.println("添加成功！");
        oos.writeObject(Main.vehicles);
        oos.close();
    }

    public static void delCar() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("t.tmp"));
        System.out.println("请输入你希望删除的车辆的对应编号：");
        String num_S = Main.sc.next();
        if (!Factory.isNumeric4(num_S)) {
            System.out.print("错误的输入。\n请重新输入：");
            num_S = Main.sc.next();
        }
        int num = Integer.parseInt(num_S);
        Main.vehicles.remove(num - 1);
        oos.writeObject(Main.vehicles);
        oos.close();
    }

    @Override
    public void logg() throws IOException {
        while (CLI()) ;
    }
}
