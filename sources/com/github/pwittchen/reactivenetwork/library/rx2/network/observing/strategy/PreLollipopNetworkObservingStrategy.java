package com.github.pwittchen.reactivenetwork.library.rx2.network.observing.strategy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.github.pwittchen.reactivenetwork.library.rx2.Connectivity;
import com.github.pwittchen.reactivenetwork.library.rx2.network.observing.NetworkObservingStrategy;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import java.util.Objects;
import ru.sravni.android.bankproduct.utils.NetworkChangeReceiver;
public class PreLollipopNetworkObservingStrategy implements NetworkObservingStrategy {

    public class a implements ObservableOnSubscribe<Connectivity> {
        public final /* synthetic */ Context a;
        public final /* synthetic */ IntentFilter b;

        /* renamed from: com.github.pwittchen.reactivenetwork.library.rx2.network.observing.strategy.PreLollipopNetworkObservingStrategy$a$a  reason: collision with other inner class name */
        public class C0183a extends BroadcastReceiver {
            public final /* synthetic */ ObservableEmitter a;

            public C0183a(a aVar, ObservableEmitter observableEmitter) {
                this.a = observableEmitter;
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                this.a.onNext(Connectivity.create(context));
            }
        }

        public class b implements Action {
            public final /* synthetic */ BroadcastReceiver a;

            public b(BroadcastReceiver broadcastReceiver) {
                this.a = broadcastReceiver;
            }

            @Override // io.reactivex.functions.Action
            public void run() {
                a aVar = a.this;
                PreLollipopNetworkObservingStrategy.this.tryToUnregisterReceiver(aVar.a, this.a);
            }
        }

        public a(Context context, IntentFilter intentFilter) {
            this.a = context;
            this.b = intentFilter;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<Connectivity> observableEmitter) throws Exception {
            C0183a aVar = new C0183a(this, observableEmitter);
            this.a.registerReceiver(aVar, this.b);
            PreLollipopNetworkObservingStrategy preLollipopNetworkObservingStrategy = PreLollipopNetworkObservingStrategy.this;
            b bVar = new b(aVar);
            Objects.requireNonNull(preLollipopNetworkObservingStrategy);
            observableEmitter.setDisposable(Disposables.fromAction(new a2.i.a.a.a.a.a.a.a.b(preLollipopNetworkObservingStrategy, bVar)));
        }
    }

    @Override // com.github.pwittchen.reactivenetwork.library.rx2.network.observing.NetworkObservingStrategy
    public Observable<Connectivity> observeNetworkConnectivity(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(NetworkChangeReceiver.CONNECTIVITY_ACTION);
        return Observable.create(new a(context, intentFilter)).defaultIfEmpty(Connectivity.create());
    }

    @Override // com.github.pwittchen.reactivenetwork.library.rx2.network.observing.NetworkObservingStrategy
    public void onError(String str, Exception exc) {
    }

    public void tryToUnregisterReceiver(Context context, BroadcastReceiver broadcastReceiver) {
        try {
            context.unregisterReceiver(broadcastReceiver);
        } catch (Exception e) {
            onError("receiver was already unregistered", e);
        }
    }
}
