package Threads;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

import Packet.Switcher;
import Settings.MainSettings;
import malysoft.home.Main;

/**
 * Created by danie on 6/28/2016.
 */
public class NetworkReceive extends AsyncTask<Void,DatagramPacket,Void> {
    DatagramPacket packet=null;
    public boolean loop=true;
    @Override
    protected void onProgressUpdate(DatagramPacket... values) {
        Switcher.mainSwitch(values[0]);
        super.onProgressUpdate(values);
    }

    @Override
    protected Void doInBackground(Void... voids) {
        DatagramSocket socket=null;
        byte[] b = new byte[1024];
        try {
            socket=new DatagramSocket(1326);
        } catch (SocketException e) {
            e.printStackTrace();
            Log.e("MSG","Cannot create DatagramSocket on Receive");
        }
        while(MainSettings.ReceiveLoop) {
            packet= new DatagramPacket(b, b.length);
            try {
                socket.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
                Log.e("MSG", "Cannot Receive.");
            }
            packet.setData(packet.getData(),0,packet.getLength());
            publishProgress(packet);
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        Main.addToast("Receive Canceld.");
        super.onPostExecute(aVoid);
    }
}
