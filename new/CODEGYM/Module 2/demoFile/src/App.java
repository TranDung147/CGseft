import java.io.*;

public class App {
    public static void main(String[] args) {
        File myFile = new File("./src/data.txt");
        if (myFile.exists()) {
            if (myFile.canRead()) {
                System.out.println("File can raed");
            } else {
                System.out.println("File can not read");
            }

            if (myFile.canWrite()) {
                System.out.println("File can write");
                try {
//                    FileWriter fileWriter = new FileWriter(myFile);
//                    String content = "Day la noi dung ghi vao file";
//                    fileWriter.write(content);
//                    fileWriter.append("Hello Dung");
//                    //Tao mot dong moi
//                    fileWriter.write("\n");
//                    fileWriter.close();
//                    String content = "Day la noi dung ghi vao file";
//                    FileWriter fileWriter = new FileWriter(myFile);
//                    BufferedWriter buffWriter = new BufferedWriter(fileWriter);
//                    buffWriter.write(content);
//                    //tao noi dung moi
//                    buffWriter.newLine();
//                    buffWriter.write("Hello Dung");
//                    buffWriter.close();
                    FileReader reader = new FileReader(myFile);
                    BufferedReader buffReader = new BufferedReader(reader);
                    String contentOfLine = null;
                    /*while ((contentOfLine = buffReader.readLine())!= null) {
                        System.out.println(contentOfLine);
                    }*/
                    while ((contentOfLine = buffReader.readLine()) != null){
                        contentOfLine = buffReader.readLine();
                        System.out.println(contentOfLine);
                    }
                } catch (IOException e){
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("File can not write");
            }
        } else {
            System.out.println("File not found");
        }
    }
}
