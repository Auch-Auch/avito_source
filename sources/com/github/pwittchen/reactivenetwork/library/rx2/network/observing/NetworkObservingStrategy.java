package com.github.pwittchen.reactivenetwork.library.rx2.network.observing;

import android.content.Context;
import com.github.pwittchen.reactivenetwork.library.rx2.Connectivity;
import io.reactivex.Observable;
public interface NetworkObservingStrategy {
    Observable<Connectivity> observeNetworkConnectivity(Context context);

    void onError(String str, Exception exc);
}
