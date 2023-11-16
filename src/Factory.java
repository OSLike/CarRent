import java.io.IOException;
import java.util.Scanner;

public interface Factory {
    static boolean isNumeric4(String str) {
        return str != null && str.chars().allMatch(Character::isDigit);
    }

    static void carInfoViewer() {
        Scanner sc = new Scanner(System.in);
        System.out.println("序号\t车牌号\t品牌\t型号\t日租金");
        for (int i = 0; i < Main.vehicles.size(); i++) {
            System.out.printf("%d\t%s\t%s\t%s\t%d\n",
                    i + 1,
                    Main.vehicles.get(i).vehicleld,
                    Main.vehicles.get(i).brand,
                    Main.vehicles.get(i).type,
                    Main.vehicles.get(i).perRent);
        }
        System.out.println("查看某车详细数据请输入对应序号");
        System.out.print("退出请输入数字0:");
        String num = sc.next();
        if (num.equals("0")) return;
        int numInt;
        if (!isNumeric4(num)) {
            System.out.println("错误的输入。");
            return;
        } else {
            numInt = Integer.parseInt(num);
        }
        if (numInt <= Main.vehicles.size() && numInt >= 0) {
            Main.vehicles.get(numInt - 1).details();
        } else {
            System.out.println("错误的输入。");
        }
    }

    void logg() throws IOException;
}
