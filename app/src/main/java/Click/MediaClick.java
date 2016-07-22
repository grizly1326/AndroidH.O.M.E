package Click;

import android.view.View;

import ClassList.ComputerList;
import ClassList.MediaList;
import Settings.MainSettings;
import Threads.NetworkSend;

/**
 * Created by danie on 7/22/2016.
 */
public class MediaClick implements View.OnClickListener {
    int i=0;
    public MediaClick(int i){
        this.i=i;
    }
    @Override
    public void onClick(View view) {
        new NetworkSend(ComputerList.getAddress(MainSettings.Server),"getMedia="+ MediaList.getDirBlock(i).getPath()).execute();
    }
}
