package Click;

import android.os.AsyncTask;
import android.view.View;

import Threads.NetworkBroadcast;

/**
 * Created by danie on 7/22/2016.
 */
public class MainRefresh implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        new NetworkBroadcast().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}
