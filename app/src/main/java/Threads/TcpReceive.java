package Threads;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.ServerSocket;

import Settings.Import;

/**
 * Created by danie on 7/3/2016.
 */
public class TcpReceive extends AsyncTask<Void,Void,Void> {
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Log.d("MSG","File-Server Received File...");
        Import.ImportList();
        new TcpReceive().execute();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            FileTransfer f= new FileTransfer(new ServerSocket(1325).accept());
            f.receive();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}