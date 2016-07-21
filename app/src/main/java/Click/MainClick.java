package Click;

import android.view.View;

import ClassList.ComputerList;
import Threads.NetworkSend;

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
        new NetworkSend(ComputerList.getAddress(i),"getList").execute();
    }
}
