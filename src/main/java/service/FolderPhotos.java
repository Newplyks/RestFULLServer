package service;

import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class FolderPhotos {

    public static void CreateFolderForPhotographer(int idPhotographer){

        File dir = new File(Setting.PHOTO_OF_PHOTOGRAPHERS+ String.valueOf(idPhotographer));

        dir.mkdir();

    }

    public static String[] getPhotosByPhotographer(int idPhotographer){
        File dir = new File(Setting.PHOTO_OF_PHOTOGRAPHERS+ String.valueOf(idPhotographer));
        File[] files = dir.listFiles();

        if(files==null || files.length==0){
            return null;
        }
        BufferedReader reader;
        String[] photosBase64 = new String[files.length];
        int i = 0;
        for(File f:files){
            try {
                reader = new BufferedReader(new FileReader(f));
                photosBase64[i]=reader.readLine();
                i++;
                reader.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                return null;
            }
        }
        return photosBase64;
    }

    public static void deleteFolder(int idPhotographer){
        File dir = new File(Setting.PHOTO_OF_PHOTOGRAPHERS+ String.valueOf(idPhotographer));

        dir.delete();
    }


    public static Boolean addPhotoInProfile(int idPhotographer, String imageString){
        BufferedImage bufferedImage = null;
        byte[] imageByte;
        File dir = new File(Setting.PHOTO_OF_PHOTOGRAPHERS+ String.valueOf(idPhotographer));
        int count;

        if(dir.listFiles()==null){
            return null;
        }
        else{
            count = dir.listFiles().length;
        }
        File fileImage = new File(Setting.PHOTO_OF_PHOTOGRAPHERS+String.valueOf(idPhotographer)+"//"+(count+1)+".jpg");
        try{
            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(imageString);
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            bufferedImage = ImageIO.read(bis);
            ImageIO.write(bufferedImage,"jpg",fileImage);
            bis.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public static Boolean deletePhotoFromProfile(int idPhotographer, int idPhoto){
        try {
            Files.delete(new File(Setting.PHOTO_OF_PHOTOGRAPHERS+idPhotographer+"//"+idPhoto+".jpg").toPath());
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
