import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


class EmptyFileException extends Exception{
    public EmptyFileException(String message){
        super(message);
    }

}

public class File {
    public static void main(String[] args) throws IOException {
        String fileName = "1.txt";
        boolean isFalse=true;
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine();
            if (line == null) {
                throw new EmptyFileException("空文件");
            }
            List<Integer> numlist = new ArrayList();
            String line2;
            while ((line2=br.readLine())!=null) {
                try{
                    numlist.add(Integer.parseInt(line2));
                }catch (NumberFormatException e){
                    System.out.println("数据中含有非整型，无法读取");
                    isFalse=false;
                    break;

                }
            }
            if (isFalse){
            double sum=0;
            double count=0;
            for(int i:numlist){
                sum+=i;
                count++;
            }
            double average=(double) (sum/count);
            System.out.println(average);}



        } catch (EmptyFileException e) {
            System.out.println("文件内容为空");
        } catch (FileNotFoundException e) {
            System.out.println("不存在对应文件");
        }

    }
}