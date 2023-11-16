import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<User> userInfo = new ArrayList<>();
    static ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        initInfos();
        while (true) {
            try {
                CLI();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void initInfos() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("t.tmp"));
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("t.tmp"));
        StoreMgr admin = new StoreMgr("admin", "admin", true);
        userInfo.add(admin);
        vehicles = (ArrayList<Vehicle>) ois.readObject();
//        Car carIni_1 = new Car("A1207", "W", "Z1", 7, 120);
//        Trunk trunkIni_1 = new Trunk("B1003", "J", "Y1", 20, 20);
//        Bus busIni_1 = new Bus("C0228", "X", "S1", 12, 40);
//        vehicles.add(carIni_1);
//        vehicles.add(trunkIni_1);
//        vehicles.add(busIni_1);
//        oos.writeObject(vehicles);
        ois.close();
//        oos.close();
    }

    private static void CLI() throws IOException {
        System.out.println("********************");
        System.out.println("*   本汽车租赁系统   *");
        System.out.println("*      1 登录      *");
        System.out.println("*      2 注册      *");
        System.out.println("*      3 退出      *");
        System.out.println("*    当前版本V4.0   *");
        System.out.println("********************");
        System.out.print("请输入对应数字：");
        String num_into = sc.next();
        switch (num_into) {
            case "1":
                loginPage_CLI();
                break;
            case "2":
                regPage_CLI();
                break;
            default:
                System.out.println("错误的输入。");
                break;
            case "3":
                System.exit(0);
        }
    }

    private static void loginPage_CLI() throws IOException {
        System.out.print("请输入用户名：");
        String userName = sc.next();
        System.out.print("请输入密码：");
        String userPwd = sc.next();
        boolean bool = false;
        for (User user : userInfo) {
            if (userName.equals(user.getUserName())
                    && userPwd.equals(user.getUserPwd())) {
                System.out.println("登录成功！");
                bool = true;
                user.logg();
            }
        }
        if (!bool) System.out.println("账号或密码错误！");
    }

    private static void regPage_CLI() {
        System.out.print("请输入用户名：");
        String userName = sc.next();
        System.out.print("请输入密码：");
        String userPwdF = sc.next();
        System.out.print("请再次输入密码：");
        String userPwdS = sc.next();
        if (!userPwdF.equals(userPwdS)) {
            System.out.println("两次输入的密码不同，请检查后重试！");
            return;
        }
        Customer user = new Customer(userName, userPwdF, false);
        userInfo.add(user);
        System.out.println("注册成功。");
    }
}

abstract class User implements Factory {
    String userName;
    String userPwd;
    boolean isAdmin;

    public User(String userName, String userPwd, boolean isAdmin) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.isAdmin = isAdmin;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

}