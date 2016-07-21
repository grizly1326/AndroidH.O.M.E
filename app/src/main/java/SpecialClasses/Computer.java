package SpecialClasses;

import java.net.InetAddress;

/**
 * Created by danie on 6/24/2016.
 */
public class Computer {
    InetAddress address;
    String content;
    public Computer(InetAddress address){
        this.address=address;
    }
    public InetAddress getAddress(){
        return address;
    }
    public void setContent(String content){
        if(!content.equals(""))this.content=content;
    }
    public String getContent(){
        return content;
    }
}
