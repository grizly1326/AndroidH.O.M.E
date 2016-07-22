package Click;

import android.view.View;

import ClassList.ComputerList;
import Settings.MainSettings;
import Threads.NetworkSend;
import malysoft.home.Main;

/**
 * Created by danie on 6/23/2016.
 */
public class MainClick implements View.OnClickListener {
    int i=0;
    public MainClick(int i) {
       this.i=i;
    }

    @Override
    public void onClick(View view) {
        Main.addToast("Clicked..."+ComputerList.getAddress(i).toString());
        new NetworkSend(ComputerList.getAddress(i),"getList").execute();
        MainSettings.Server=i;
    }
}
