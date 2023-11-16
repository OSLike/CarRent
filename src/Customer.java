import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Customer extends User implements Factory {
    public Customer(String userName, String userPwd, boolean isAdmin) {
        super(userName, userPwd, isAdmin);
    }

    public static boolean CLI() throws IOException {
        System.out.println("********************");
        System.out.println("*   本汽车租赁系统   *");
        System.out.println("*    1 查看汽车信息  *");
        System.out.println("*    2 借车        *");
        System.out.println("*    3 返回        *");
        System.out.println("*    当前版本V4.0   *");
        System.out.println("********************");
        System.out.print("请输入对应数字：");
        String num_into = Main.sc.next();
        switch (num_into) {
            case "3":
                return false;
            case "1":
                Factory.carInfoViewer();
                break;
            case "2":
                rentCar();
                break;
            default:
                System.out.println("错误的输入。");
                break;
        }
        return true;
    }

    public static void rentCar() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("t.tmp"));
        System.out.print("请输入你希望租赁的车辆对应的编号：");
        String num_S = Main.sc.next();
        if (!Factory.isNumeric4(num_S)) {
            System.out.print("错误的输入。\n请重新输入：");
            num_S = Main.sc.next();
        }
        int num = Integer.parseInt(num_S);
        Main.vehicles.remove(num - 1);
        System.out.println("租赁成功！已为您出货，请到门店领取您租赁的车辆。");
        oos.writeObject(Main.vehicles);
        oos.close();
    }

    @Override
    public void logg() throws IOException {
        while (CLI()) ;
    }

}
