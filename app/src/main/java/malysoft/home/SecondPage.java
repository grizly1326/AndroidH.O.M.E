package malysoft.home;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import ClassList.ComputerList;
import ClassList.MediaList;
import Click.MainClick;

public class SecondPage extends AppCompatActivity {

    static LinearLayout la;
    static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=getApplicationContext();
        la=(LinearLayout)findViewById(R.id.LinearLayout3);
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
            b.setOnClickListener(new MainClick(i));
            la.addView(b);
        }
    }
}
