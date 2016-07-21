package Threads;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;

import malysoft.home.Main;

/**
 * Created by danie on 7/2/2016.
 */
public class NetworkSend extends AsyncTask<Void,Void,Void> {
    InetAddress address=null;
    DatagramPacket packet=null;
    String Text=null;
    public NetworkSend(InetAddress address, String Text){
        this.address=address;
        this.Text=Text;
    }
    @Override
    protected Void doInBackground(Void... voids) {
        packet= new DatagramPacket(Text.getBytes(),Text.getBytes().length,address,1326);
        try {
            Main.socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("MSG","Cannot send data.");
        }
        return null;
    }
}
