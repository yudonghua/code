package lambda;

import java.util.stream.Stream;

public class LambdaTest {

    public static void main(String[] args) {
        // 相当于foreach遍历操作结果值
        Integer out = Stream.of(10, 5, 3, 2, 1, 0).reduce((result, item) -> {
//            System.out.println(result);
            if (item >= 3) {
                result = result + item;
            }
            return result;
        }).get();
        System.out.println(out);

        // 相当于给定初始结果值，foreach遍历操作结果值
        Integer sum = Stream.of(10, 5, 3, 2, 1, 0).reduce(9, LambdaTest::sumTest);
        System.out.println(sum);

        //相当于给定初始结果值，两个foreach遍历操作结果值
        int str = Stream.of(100,10,1).parallel().reduce(0, (result, item) -> {
            System.out.println("1-->"+result);
            return result + item*2;
        } , (result, item) -> {
            System.out.println("2-->"+result);
            //注：只有并行parallel下才会进入此方法
            return result + item ;
        });
        System.out.println(str);
    }

    //替换Integer::sum测试
    public static Integer sumTest(int a1, int a2) {
//        System.out.println("3-->"+a1);
        return a1 + a2;
    }

}