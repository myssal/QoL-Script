import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoveUltiSpine {

    String sourcePath = "F:\\FullSetC\\Game\\Active\\Nikke\\export\\nonEncrypt";
    String destinationPath = "F:\\FullSetC\\Game\\Active\\Nikke\\NikkeOrganizedAssets\\SkillCut";;
    String regexPattern = "skillcut";
    public MoveUltiSpine(){}
    public MoveUltiSpine(String sourcePath, String destinationPath, String regexPattern){
        this.sourcePath = sourcePath;
        this.destinationPath = destinationPath;
        this.regexPattern = regexPattern;
    }
    Pattern regex = Pattern.compile(regexPattern);
    File sourceFolder = new File(sourcePath);
    File[] subFolderDir = sourceFolder.listFiles(File::isDirectory); //get list of subfolder in destination folder
    Boolean skillCutFound = false; //check regex to determine whether that folder is l2d
    String skillCutName; //renamed name for moved folder
    public static String getFileNameOnly(String filePath)
    {
        //return name of file without extension
        int lastIndexOfDot = filePath.indexOf('.');
        return filePath.substring(0, lastIndexOfDot);
    }

    public void moveSubFoldersRegex(){

        for (File subFolder: subFolderDir){
            //get list of files in each subfolder
            File[] fileList = subFolder.listFiles();

            //iterate through list of files to find spine
            for (File file: fileList){
                String fileName = file.getName();
                Matcher matcher = regex.matcher(fileName);
                if (file.isFile() && matcher.find()){
                    skillCutFound = true;
                    skillCutName = getFileNameOnly(fileName);
                    break;
                }
                break;
            }

            //if found, move to new folder
            if (skillCutFound){
                //move all files to new folder
                new File(destinationPath + "\\" + skillCutName).mkdirs();

                for (File file: fileList){
                    try {
                        if (!(file.getName().startsWith("fx_"))){
                            System.out.println("Copy " + file.getName());
                            Files.move(file.toPath(), new File(destinationPath + "\\" + skillCutName + "\\" + file.getName()).toPath());
                        }
                    }catch (IOException e){
                        e.printStackTrace();
                    }

                }
                skillCutFound = false;
            }
        }
    }

}
