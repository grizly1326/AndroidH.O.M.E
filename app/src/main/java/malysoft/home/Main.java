package malysoft.home;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.net.DatagramSocket;
import java.net.SocketException;

import ClassList.ComputerList;
import Click.MainClick;
import Click.MainRefresh;
import Settings.MainSettings;
import Threads.NetworkBroadcast;
import Threads.NetworkReceive;
import Threads.TcpReceive;


public class Main extends AppCompatActivity {
    static LinearLayout la;
    static Context context;
    static Button b1;
    public static DatagramSocket socket=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        context=getApplicationContext();
        la=(LinearLayout)findViewById(R.id.LinearLayout2);
        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new MainRefresh());
        addComputerButton();
        if(MainSettings.MainOnce){
            try {
                socket=new DatagramSocket();
            } catch (SocketException e) {
                e.printStackTrace();
                Log.e("MSG","Cannot create Datagram.");
            }
            new NetworkReceive().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
            new NetworkBroadcast().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);           //small filles.
            new TcpReceive().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);                 //large filles receive.
            ComputerList.ClearList();
            MainSettings.MainOnce=false;
        }
    }
    public static void startMediaActivity(){
        context.startActivity(new Intent(context,MediaPage.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
    }
    public static void addToast(String text){
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
    public static void addComputerButton(){
        la.removeAllViews();
        Button b=null;
        for(int i=0;i<ComputerList.getListSize();i++){     //ComputerList.getListSize()
            b=new Button(context);
            if(ComputerList.getComputer(i).getContent()==null){b.setText(ComputerList.getAddress(i).toString());}else{b.setText(ComputerList.getContent(i));}
            b.setBackgroundColor(Color.WHITE);
            b.setTextColor(Color.BLACK);
            b.setHighlightColor(Color.BLACK);
            b.setOnClickListener(new MainClick(i));
            la.addView(b);
        }
    }
}
