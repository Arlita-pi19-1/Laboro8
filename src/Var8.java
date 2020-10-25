import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
public class Var8 {
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        System.out.println("Сколько людей хотите записать в файл");
        int count=sc.nextInt();
        sc.nextLine();
        RandomAccessFile rf=null;
        try {
            File f=new File("C:\\Me\\took.txt");
            if (f.exists()) f.delete();
            f.createNewFile();
            rf=new RandomAccessFile(f, "rw");
            String name, lastname;
            int age, month;
            for (int i=0; i<count; i++) {
                System.out.println("Введите фамиию");
                lastname=sc.nextLine();
                rf.writeUTF(lastname);
                for (int j=0; j<20 -lastname.length(); j++) rf.writeByte(1);

                System.out.println("Введите имя");
                name=sc.nextLine();
                rf.writeUTF(name);
                for (int j=0; j<20 -name.length(); j++) rf.writeByte(1);

                System.out.println("Введите год рождения");
                age=sc.nextInt();
                rf.writeInt(age);

                System.out.println("Ведите месяц рождения");
                month=sc.nextInt();
                rf.writeInt(month);
                    sc.nextLine();
            }
            String namer, lastnamer;
            int ages, months = 0;
            rf.seek(0);
            for (int i=0; i<count; i++) {
                namer = rf.readUTF();
                for (int j = 0; j < 20 - namer.length(); j++) rf.readByte();

                lastnamer = rf.readUTF();
                for (int j = 0; j < 20 - lastnamer.length(); j++) rf.readByte();

                ages = rf.readInt();
                if (months == 1) {
                    months = rf.readInt();}
                    System.out.println("name " + namer + " lastname " + lastnamer + " age " + ages + " month " + months);
                
            }
        }catch (IOException ie) {
            ie.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            rf.close();
        }
    }

}
