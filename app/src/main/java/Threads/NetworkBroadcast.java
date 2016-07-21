package Threads;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;

import malysoft.home.Main;

/**
 * Created by danie on 6/28/2016.
 */
public class NetworkBroadcast extends AsyncTask<Void,Integer,Void> {
    static InetAddress ad=null;
    static DatagramPacket packet=null;
    @Override
    protected Void doInBackground(Void... voids) {
        String text="ping";
        try {
            ad= InetAddress.getByName("10.0.0.255");
        } catch (UnknownHostException e) {
            e.printStackTrace();
            Log.e("MSG","Cannot mount this IP.");
        }
        packet= new DatagramPacket(text.getBytes(),text.getBytes().length,ad,1326);
        try {
            Main.socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("MSG","Cannot send data.");
        }
        return null;
    }
}
