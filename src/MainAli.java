import java.lang.reflect.Array;
import java.util.Scanner;
public class MainAli {
/** 请完成下面这个process函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    private static int CUSTOMS_LIMIT_MONEY_PER_BOX = 2000;
    private static Model boxTemplate = new Model();
    private static Model[] items;
    private static int boxMinNum;
    private static int process() {
        int n = items.length;
        for(int i = 0;i<items.length;i++){
            if(!items[i].compareTo(boxTemplate))return -1;
        }
        for(int i =0;i<items.length;i++){
            for(int j =i+1;j<items.length;j++){
                if(Model.mergeLength(items[i],items[j]).compareTo(boxTemplate)){
                    items[j].mergeLength(items[i]);
                    n--;
                }else if(Model.mergeWidth(items[i],items[j]).compareTo(boxTemplate)){
                    System.out.println(j+" "+items[j].width);
                    items[j].mergeWidth(items[i]);
                    System.out.println(j+" "+items[j].width);
                    n--;
                }else if(Model.mergeHeight(items[i],items[j]).compareTo(boxTemplate)){
                    items[j].mergeHeight(items[i]);
                    n--;
                }
            }
            System.out.println (n);
        }
        return n;
    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        boxTemplate.price = CUSTOMS_LIMIT_MONEY_PER_BOX;

        while (scanner.hasNext()){
            boxTemplate.length = scanner.nextInt();
            boxTemplate.width = scanner.nextInt();
            boxTemplate.height = scanner.nextInt();

            int itemNum = scanner.nextInt();
            items = new Model[itemNum];
            for(int i=0; i<itemNum; i++){
                Model item = new Model();
                item.price = scanner.nextInt();
                item.length = scanner.nextInt();
                item.width = scanner.nextInt();
                item.height = scanner.nextInt();
                items[i] = item;
            }
//            long startTime = System.currentTimeMillis();
            boxMinNum = Integer.MAX_VALUE;
            System.out.println (process());

        }
    }

}
class Model{
    int price;
    int length;
    int width;
    int height;
    public boolean compareTo(Model model){
        return this.price<=model.price&&this.length<=model.length&&this.width<=model.width&&this.height<=model.height;
    }
    public void mergeLength(Model model){
        this.price += model.price;
        this.length += model.length;
        this.width = Math.max(this.width,model.width);
        this.height = Math.max(this.height,model.height);
    }
    public void mergeWidth(Model model){
        this.price += model.price;
        this.length = Math.max(this.length,model.length);
        this.width += model.width;
        this.height = Math.max(this.height,model.height);
    }
    public void mergeHeight(Model model){
        this.price += model.price;
        this.length = Math.max(this.length,model.length);
        this.width = Math.max(this.width,model.width);
        this.height += model.height;
    }
    public static Model mergeLength(Model model1,Model model2){
        Model model = new Model();
        model.price = model1.price + model2.price;
        model.length = model1.length + model2.length;
        model.width = Math.max(model1.width,model2.width);
        model.height= Math.max(model1.height,model2.height);
        return model;
    }
    public static Model mergeWidth(Model model1,Model model2){
        Model model = new Model();
        model.price = model1.price + model2.price;
        model.length = Math.max(model1.length,model2.length);
        model.width = model1.width + model2.width;
        model.height= Math.max(model1.height,model2.height);
        return model;
    }
    public static Model mergeHeight(Model model1,Model model2){
        Model model = new Model();
        model.price = model1.price + model2.price;
        model.length = Math.max(model1.length,model2.length);
        model.width = Math.max(model1.width,model2.width);
        model.height= model1.height + model2.height;
        return model;
    }

}