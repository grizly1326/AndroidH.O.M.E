package Settings;

import android.os.Environment;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import ClassList.MediaList;
import SpecialClasses.MediaBlock;

/**
 * Created by danie on 7/21/2016.
 */
public class Import {
    public static void ImportList() {
        FileInputStream fstream = null;
        try {
            fstream = new FileInputStream(Environment.getExternalStorageDirectory()+"/list.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String line;
        try {
            while ((line = br.readLine()) != null)   {
                ListSwitcher(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
}
    private static void ListSwitcher(String line){
        String[] sub=line.split("//");
        boolean d;
        if(sub[7].equals("true"))d=true;else d=false;
        MediaList.addDir(new MediaBlock(sub[5],sub[3],sub[1],d));
    }
}
