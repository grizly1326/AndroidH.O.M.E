package Packet;

import java.net.DatagramPacket;

import ClassList.ComputerList;
import Settings.MainSettings;
import SpecialClasses.Computer;
import Threads.NetworkSend;
import malysoft.home.Main;

/**
 * Created by danie on 7/1/2016.
 */
public class Switcher {
    public static void mainSwitch(DatagramPacket packet){
        String a=new String(packet.getData()).substring(0, packet.getLength());
        String[] sub=a.split("=");
        switch(sub[0]){
            case "loop.cancel":MainSettings.ReceiveLoop=false; break;
            case "ping.back":Main.addToast("ping.back");ComputerList.addComputer(new Computer(packet.getAddress()));Main.addComputerButton();new NetworkSend(packet.getAddress(),"ping.getContent").execute();break;
            case "ping.getContent":Main.addToast("Content:  "+a);ComputerList.addContent(packet.getAddress(),sub[1]);Main.addComputerButton();break;
            default:Main.addToast("Cannot find this command:    "+a);break;
        }
    }
}
