# CarRent
## 年轻人的第一款汽车租赁系统（面向对象系统设计实验作业）

**本程序含有 继承、多态、集合框架、异常处理、工厂模式 共五个处于Java特性考察中的特性考察点。**

**注意使用UTF-8编码或兼容UTF-8编码的工具来使用该项目（优先在各个GNU/Linux的发行版上），如出现编码问题作者概不负责。**

存在admin用户以及可注册非admin的user账户，并均继承自``User``类。

存在``Car``、``Trunk``、``Bus类``，均有自己细节特性，并均继承自``Vehicle``类。

存在一个``Factory``类，实现了检测String是否为数字，实现了输出``Main.vehicles``中的``carInfo``，并且可以通过输入对应序号查看对应车辆详细信息，提供了一个``logg``作为接口在``Customer``和``StoreMgr``中分别执行对应的``CLI``函数。

admin用户实现了增加车辆、删除车辆、修改车辆信息，以及调用接口查看车辆信息。

user用户实现了调用接口查看车辆信息以及租用车辆。

序列化``ArrayList<Vehicle> vehicles``并通过``t.tmp``文件存储，再通过反序列化读``t.tmp``文件并写到``ArrayList<Vehicle> vehicles``中。

在各个GNU/Linux发行版的IDEA项目的文件操作，当前目录为当前项目主文件夹下，即本项目``/path/to/CarRent/``的位置，也是``t.tmp``应该存放的位置。Win下应该将``t.tmp``文件放置在``/path/to/CarRent/../``中。（如果仍存在报错，请调整Main.initInfos()中的注释，进行一次完整的init以获得``t.tmp``文件正确部署位置并初始化``t.tmp``）

在``artifications``中的内容为通过jar直接打包的包，需要配合在同一目录下的``t.tmp``使用。