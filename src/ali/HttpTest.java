package ali;

import com.sun.deploy.net.HttpResponse;
import com.sun.deploy.net.HttpUtils;
import sun.rmi.runtime.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by PC on 2019/5/14.
 */
public class HttpTest {
    public static void main(String[] args) {
        reflex(new User());

    }
    public static void reflex(Object obj){
        Class<?> aClass = obj.getClass();
        // aClass.getFields() 获取 public 类型的成员
        Field[] declaredFields = aClass.getDeclaredFields(); //获取所有成员包含 private
        Method[] methods = aClass.getMethods();
        for (Method mt:
                methods) {
            String mn = mt.getName();
            Object dv = mt.getDefaultValue();
            String returnType = mt.getReturnType().getName();
            System.out.println("方法名称：" + mn + "    默认值：" + dv + "    返回类型：" + returnType);
        }
        for (Field field:
                declaredFields) {
            try {
                field.setAccessible(true);
                String fn = field.getName();
                System.out.println(fn+":"+field.get(aClass.newInstance()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
