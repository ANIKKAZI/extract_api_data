package data_processing;
import java.io.*;
import java.util.ArrayList;

public class FileOperation {
    /**
     * @param fileName title content
     * @return String
     */
   public String fileCreation(String fileName,String title,String content){
     try {
           File article = new File(fileName.concat(".txt"));
           if(!article.exists())
           {
               article.createNewFile();
           }
               FileWriter fileWriterObject = new FileWriter(article,true);
               BufferedWriter articleWriter = new BufferedWriter(fileWriterObject);
               articleWriter.write(title);
               articleWriter.newLine();
               articleWriter.write(content);
               articleWriter.newLine();
               articleWriter.close();
       } catch (IOException e) {
           System.out.println("An error occurred.");
           e.printStackTrace();
       }
       return "";
   }

    /**
     * @param keyName
     * @return ArrayList
     *  @throws IOException
     */
    public ArrayList<String> fileReadOperation(String keyName)throws IOException {
        ArrayList <String> dataFiltered = new ArrayList<String>();
        String fileInformation="";
        try {
                String fileString = keyName.concat(".txt");
                File fileName = new File(fileString);
               if(fileName.exists()){
                   FileReader fileObj = new FileReader(fileString);
                   BufferedReader br = new BufferedReader(fileObj);
                   while((fileInformation = br.readLine())!=null) {
                       dataFiltered.add(fileInformation);
                   }
                   fileObj.close();
               }
        }
        catch(IOException file) {
            System.out.println("File was not found");
        }
        return dataFiltered;
    }




}
