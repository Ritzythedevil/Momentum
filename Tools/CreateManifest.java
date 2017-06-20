import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

/**
 * Created by Ritesh Jain on 01-02-2017.
 */
public class CreateManifest {

    static File AppFolder = (new File("../App"));
    static File ToolsFolder = (new File("./"));
    static File GetDown = (new File("../App/getdown.txt"));








    public static void main(String[] args) throws IOException, InterruptedException {

        CheckEverythingExists();

//        ProcessBuilder UpdaterStartProcessBuilder2 = new ProcessBuilder("javac", "Tools/LaunchMomentum.java").inheritIO();
//        UpdaterStartProcessBuilder2.start().waitFor();
//
//        ProcessBuilder UpdaterStartProcessBuilder3 = new ProcessBuilder("jar", "cvfe", "LaunchMomentum.jar", "LaunchMomentum", "LaunchMomentum.class").inheritIO();
//        UpdaterStartProcessBuilder3.directory(new File("./Tools/"));
//        UpdaterStartProcessBuilder3.start().waitFor();
//        // jar cvfe Craps.jar Craps *.class

        Files.copy(Paths.get(ToolsFolder.getPath()+"/getdown.txt"), Paths.get(AppFolder.getPath()+"/getdown.txt"), StandardCopyOption.REPLACE_EXISTING);
        //Files.copy(Paths.get(ToolsFolder.getPath()+"/LaunchMomentum.jar"), Paths.get(AppFolder.getPath()+"/LaunchMomentum.jar"), StandardCopyOption.REPLACE_EXISTING);

        searchextdirrec(new File(AppFolder.getPath()+"/Momentum"), "code");
        searchextdirrec(new File(AppFolder.getPath()+"/Libraries"), "code");
        searchextdirrec(new File(AppFolder.getPath()+"/MotivationalContent"), "resource");
        searchextdirrec(new File(AppFolder.getPath()+"/Resources"), "resource");


        ProcessBuilder UpdaterStartProcessBuilder = new ProcessBuilder("java", "-classpath", "getdown.jar" ,"com.threerings.getdown.tools.Digester", "../App").inheritIO();
        UpdaterStartProcessBuilder.start().waitFor();

    }

    private static void CheckEverythingExists(){
        if(!AppFolder.exists()){
            System.out.println("App Folder Not Found! Aborting");
            System.exit(1);
        } else if (!ToolsFolder.exists()){
            System.out.println("Tools Folder Not Found! Aborting");
            System.exit(1);
        } else if ( !new File("LaunchMomentum.java").exists() ||
                    !new File("Getdown.jar").exists() ||
                    !new File("getdown.txt").exists() ){
            System.out.println("Necessary Files Not Found! Aborting");
            System.exit(1);
        }
        GetDown.delete();
    }





    public static ArrayList<File> searchextdirrec(File FolderToRecurse, String AssetType) throws IOException {
        ArrayList<File> files24 = new ArrayList<File>(0);
        File[] files24a = FolderToRecurse.listFiles();
        listadd(files24, files24a);
        filelistprint(files24, AssetType);
        return files24;
    }

    public static void listadd (ArrayList<File> files25, File[] folder25)
    {
        for (File file25 : folder25)
        {
            if(file25.isDirectory()) {
                File[] folder25a = searchextdir(file25);
                listadd(files25, folder25a);
            } else {
                files25.add(file25);
            }
        }
    }

    public static File[] searchextdir(File folder21)
    {
        File[] files21= folder21.listFiles();
        return files21;
    }











    public static void filelistprint(ArrayList<File> file18, String assetType) throws IOException {


        BufferedReader bufferedReader = new BufferedReader(new FileReader(GetDown));
        StringBuffer stringBuffer = new StringBuffer();
        String line = null;

        while((line = bufferedReader.readLine())!=null) {
            stringBuffer.append(line).append("\n");
        }






        for(File file15 : file18)
        {
            String str15 = file15.getPath();
            str15 = str15.substring(str15.indexOf("App")+4);
            String s2 = assetType + " = " + str15.replace("\\" , "/");
            stringBuffer.append(s2).append("\n");
        }

        String s = stringBuffer.toString();
        stringBuffer.delete(0, stringBuffer.length());
        bufferedReader.close();


        FileWriter fileWriter1 = new FileWriter(GetDown);
        fileWriter1.write(s);
        fileWriter1.flush();
        fileWriter1.close();




    }



}
