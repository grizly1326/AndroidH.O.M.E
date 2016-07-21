package SpecialClasses;

/**
 * Created by danie on 7/21/2016.
 */
public class MediaBlock {
    String name,subName,path;
    boolean Directory;
    public MediaBlock(String name, String subName, String path,boolean Directory){
        this.name=name;
        this.Directory=Directory;
        this.subName=subName;
        this.path=path;
    }
    public String getPath(){
        return path;
    }
    public String getSubName(){
        return subName;
    }
    public String getName(){
        return name;
    }
    public boolean isDirecotry(){
        return Directory;
    }
}
