# CarRent
## 年轻人的第一款汽车租赁系统（面向对象系统设计实验作业）
**本程序含有 继承、多态、集合框架、异常处理、工厂模式 共五个处于Java特性考察中的特性考察点。**
存在admin用户以及可注册非admin的user账户，并均继承自User类。
存在Car、Trunk、Bus类，均有自己细节特性，并均继承自Vehicle类。
存在一个Factory类，实现了检测String是否为数字，实现了输出Main.vehicles中的carInfo，并且可以通过输入对应序号查看对应车辆详细信息，提供了一个logg作为接口在Customer和StoreMgr中分别执行对应的CLI函数。
admin用户实现了增加车辆、删除车辆、修改车辆信息，以及调用接口查看车辆信息。
user用户实现了调用接口查看车辆信息以及租用车辆。
序列化ArrayList<Vehicle> vehicles并通过t.tmp文件存储，再通过反序列化读t.tmp文件并写到ArrayList<Vehicle> vehicles中。
