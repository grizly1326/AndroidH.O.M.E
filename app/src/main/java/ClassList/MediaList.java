package ClassList;

import java.util.ArrayList;

import SpecialClasses.MediaBlock;

/**
 * Created by danie on 7/21/2016.
 */
public class MediaList {
    static ArrayList<MediaBlock> musicList=new ArrayList<MediaBlock>();
    static ArrayList<MediaBlock> videoList=new ArrayList<MediaBlock>();
    static ArrayList<MediaBlock> dirList=new ArrayList<MediaBlock>();
    public static void addDir(MediaBlock dirBlock){
        dirList.add(dirBlock);
    }
    public static MediaBlock getDirBlock(int index){
        return dirList.get(index);
    }
    public static int getDirSize(){
        return dirList.size();
    }
    public static int findBynameInMusicList(String name){
        int out=0;
        for(int i=0;i<musicList.size();i++){
            if(musicList.get(i).getName().equals(name)){
                out=i;
            }
        }
        return out;
    }
    public static int findBynameInDirList(String name){
        int out=0;
        for(int i=0;i<dirList.size();i++){
            if(dirList.get(i).getName().equals(name)){
                out=i;
            }
        }
        return out;
    }
}
