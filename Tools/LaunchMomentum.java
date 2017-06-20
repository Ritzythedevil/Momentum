import java.io.*;
public class LaunchMomentum{
	public static void main(String[] args) throws IOException {
        String separator = System.getProperty("os.name").toLowerCase().indexOf("win") >= 0 ? ";" : ":";
        ProcessBuilder UpdaterStartProcessBuilder = new ProcessBuilder("java", "-classpath", "Libraries/*" + separator + "./" + separator + "./Resources/" + separator + "./Momentum/Views/" ,"Momentum.Models.Main").inheritIO();
        //UpdaterStartProcessBuilder.directory(new File("./"));
        UpdaterStartProcessBuilder.start();
    }
}
