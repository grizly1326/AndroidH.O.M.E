package ClassList;

import android.util.Log;

import java.net.InetAddress;
import java.util.ArrayList;

import SpecialClasses.Computer;

/**
 * Created by danie on 6/24/2016.
 */
public class ComputerList {
    static ArrayList<Computer> list=new ArrayList<Computer>();

    public static void addComputer(Computer pc){
        list.add(pc);
    }
    public static Computer getComputer(int index){
        return list.get(index);
    }
    public static void ClearList(){
        list.clear();
    }
    public static String[] GetNameList(){
        String[] output = new String[list.size()];
        int i=0;
        for(Computer c:list){
            output[i]=c.getAddress().toString();
            i++;
        }
        return output;
    }
    public static InetAddress getAddress(int index){
        return list.get(index).getAddress();
    }
    public static String getContent(int index){
        return list.get(index).getContent();
    }
    public static void addContent(InetAddress address,String content){
        for(int i=0;i<list.size();i++){
            if(list.get(i).getAddress().equals(address.toString())){
                list.get(i).setContent(content);
            }
        }
    }
    public static int getListSize(){
        return list.size();
    }
}
