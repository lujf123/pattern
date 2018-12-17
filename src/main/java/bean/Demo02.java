package bean;

import com.sun.javafx.sg.prism.MediaFrameTracker;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.logging.FileHandler;

/**
 * 应用反射的API，获取类的信息（类的名字、属性、方法、构造器等）
 */
public class Demo02 {
    public static void main(String[] args) {
        String path = "bean.User";

        try {
            Class<?> clazz = Class.forName(path);

            // 获取类的名字
            System.out.println(clazz.getName()); // 获得包名 + 类名
            System.out.println(clazz.getSimpleName());  // 获得类名

            // 获取属性信息
            //Field[] fields = clazz.getFields();  // 只能获得public的field
            Field[] fields = clazz.getDeclaredFields(); // 获得所有的field
            Field f = clazz.getDeclaredField("uname");
            System.out.println(fields.length);
            for (Field temp : fields) {
                System.out.println("属性：" + temp);
            }

            // 获取方法信息
            Method[] methods = clazz.getDeclaredMethods();
            Method m01 = clazz.getDeclaredMethod("getUname", null);
            Method m02 = clazz.getDeclaredMethod("setUname", String.class); // 如果方法有参，则必须传递参数类型对应的class对象
            for (Method temp : methods) {
                System.out.println("方法：" + temp);
            }

            // 获取构造器信息
            Constructor[] constructors = clazz.getDeclaredConstructors();
            Constructor c = clazz.getDeclaredConstructor(null);
            Constructor c1 = clazz.getDeclaredConstructor(int.class, int.class, String.class);
            System.out.println(c);
            for (Constructor temp : constructors) {
                System.out.println("构造器：" + temp);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
