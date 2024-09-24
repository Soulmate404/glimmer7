import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//定义空文件类错误
class EmptyFileException extends Exception{
    public EmptyFileException(String message){
        super(message);
    }

}

public class File {
    public static void main(String[] args) throws IOException {//确保正常抛出文件不存在异常
        String fileName = "0.txt";//定义文件名
        boolean isFalse=true;//用于在错误抛出后确保程序部继续运行
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {//访问对应文件
            String line = br.readLine();//阅读第一行验证是否为空文件
            if (line == null) {
                throw new EmptyFileException("空文件");
            }
            List<Integer> numlist = new ArrayList();//用list保存所有数据
            String line2;
            while ((line2=br.readLine())!=null) {
                try{
                    numlist.add(Integer.parseInt(line2));//保存并确保所有数据为整型
                }catch (NumberFormatException e){
                    System.out.println("数据中含有非整型，无法读取");
                    isFalse=false;
                    break;

                }
            }//进行均值的计算
            if (isFalse){
            double sum=0;
            double count=0;
            for(int i:numlist){
                sum+=i;
                count++;
            }
            double average= sum/(double)count;
            System.out.println(average);}



        } catch (EmptyFileException e) {
            System.out.println("文件内容为空");
        } catch (FileNotFoundException e) {
            System.out.println("不存在对应文件");
        }finally {
            System.out.println("程序运行结束关闭文档");
        }//finally语句确保文件关闭

    }
}