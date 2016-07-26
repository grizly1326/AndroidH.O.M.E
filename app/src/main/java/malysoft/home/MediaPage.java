package malysoft.home;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import ClassList.MediaList;
import Click.MainClick;
import Click.MediaClick;
import Settings.MainSettings;

public class MediaPage extends AppCompatActivity {

    static Context context;
    static LinearLayout la;
    static TextView InfoBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_page);
        UpdateInfo("IP: "+ MainSettings.Server);
        context=getApplicationContext();
        la=(LinearLayout)findViewById(R.id.LinearLayout3);
        InfoBar=(TextView)findViewById(R.id.textView2);
        InfoBar.setText(MediaList.getDirBlock(0).getName()+":    "+MediaList.getDirBlock(0).getPath());
        addDirBlock();
    }
    public static void addDirBlock(){
        la.removeAllViews();
        Button b=null;
        for(int i = 2; i< MediaList.getDirSize(); i++){     //ComputerList.getListSize()
            b=new Button(context);
            b.setText(MediaList.getDirBlock(i).getName());
            b.setBackgroundColor(Color.WHITE);
            b.setTextColor(Color.BLACK);
            b.setHighlightColor(Color.BLACK);
            b.setOnClickListener(new MediaClick(i));
            la.addView(b);
        }
    }
    public static void UpdateInfo(String text){
        InfoBar.setText(text);
    }
}
