package com.github.pwittchen.reactivenetwork.library.rx2.network.observing.strategy;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import com.github.pwittchen.reactivenetwork.library.rx2.Connectivity;
import com.github.pwittchen.reactivenetwork.library.rx2.network.observing.NetworkObservingStrategy;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Action;
import java.util.Objects;
@TargetApi(21)
public class LollipopNetworkObservingStrategy implements NetworkObservingStrategy {
    public ConnectivityManager.NetworkCallback a;

    public class a implements Action {
        public final /* synthetic */ ConnectivityManager a;

        public a(ConnectivityManager connectivityManager) {
            this.a = connectivityManager;
        }

        @Override // io.reactivex.functions.Action
        public void run() {
            LollipopNetworkObservingStrategy lollipopNetworkObservingStrategy = LollipopNetworkObservingStrategy.this;
            ConnectivityManager connectivityManager = this.a;
            Objects.requireNonNull(lollipopNetworkObservingStrategy);
            try {
                connectivityManager.unregisterNetworkCallback(lollipopNetworkObservingStrategy.a);
            } catch (Exception e) {
                lollipopNetworkObservingStrategy.onError(MarshmallowNetworkObservingStrategy.ERROR_MSG_NETWORK_CALLBACK, e);
            }
        }
    }

    public class b implements ObservableOnSubscribe<Connectivity> {
        public final /* synthetic */ Context a;
        public final /* synthetic */ ConnectivityManager b;

        public b(Context context, ConnectivityManager connectivityManager) {
            this.a = context;
            this.b = connectivityManager;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<Connectivity> observableEmitter) throws Exception {
            LollipopNetworkObservingStrategy lollipopNetworkObservingStrategy = LollipopNetworkObservingStrategy.this;
            Context context = this.a;
            Objects.requireNonNull(lollipopNetworkObservingStrategy);
            lollipopNetworkObservingStrategy.a = new a2.i.a.a.a.a.a.a.a.a(lollipopNetworkObservingStrategy, observableEmitter, context);
            this.b.registerNetworkCallback(new NetworkRequest.Builder().build(), LollipopNetworkObservingStrategy.this.a);
        }
    }

    @Override // com.github.pwittchen.reactivenetwork.library.rx2.network.observing.NetworkObservingStrategy
    public Observable<Connectivity> observeNetworkConnectivity(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        return Observable.create(new b(context, connectivityManager)).doOnDispose(new a(connectivityManager)).startWith((Observable) Connectivity.create(context)).distinctUntilChanged();
    }

    @Override // com.github.pwittchen.reactivenetwork.library.rx2.network.observing.NetworkObservingStrategy
    public void onError(String str, Exception exc) {
    }
}
