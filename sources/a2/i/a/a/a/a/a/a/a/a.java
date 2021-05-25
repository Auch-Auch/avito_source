package a2.i.a.a.a.a.a.a.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import com.github.pwittchen.reactivenetwork.library.rx2.Connectivity;
import com.github.pwittchen.reactivenetwork.library.rx2.network.observing.strategy.LollipopNetworkObservingStrategy;
import io.reactivex.ObservableEmitter;
public class a extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ ObservableEmitter a;
    public final /* synthetic */ Context b;

    public a(LollipopNetworkObservingStrategy lollipopNetworkObservingStrategy, ObservableEmitter observableEmitter, Context context) {
        this.a = observableEmitter;
        this.b = context;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        this.a.onNext(Connectivity.create(this.b));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        this.a.onNext(Connectivity.create(this.b));
    }
}
