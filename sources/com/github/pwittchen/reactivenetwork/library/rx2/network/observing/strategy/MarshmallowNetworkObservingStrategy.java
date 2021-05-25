package com.github.pwittchen.reactivenetwork.library.rx2.network.observing.strategy;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.os.PowerManager;
import android.support.annotation.NonNull;
import com.github.pwittchen.reactivenetwork.library.rx2.Connectivity;
import com.github.pwittchen.reactivenetwork.library.rx2.network.observing.NetworkObservingStrategy;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.functions.Action;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
@TargetApi(23)
public class MarshmallowNetworkObservingStrategy implements NetworkObservingStrategy {
    public static final String ERROR_MSG_NETWORK_CALLBACK = "could not unregister network callback";
    public static final String ERROR_MSG_RECEIVER = "could not unregister receiver";
    public ConnectivityManager.NetworkCallback a;
    public final Subject<Connectivity> b = PublishSubject.create().toSerialized();
    public final BroadcastReceiver c = createIdleBroadcastReceiver();

    public class a implements Action {
        public final /* synthetic */ ConnectivityManager a;
        public final /* synthetic */ Context b;

        public a(ConnectivityManager connectivityManager, Context context) {
            this.a = connectivityManager;
            this.b = context;
        }

        @Override // io.reactivex.functions.Action
        public void run() {
            MarshmallowNetworkObservingStrategy.this.tryToUnregisterCallback(this.a);
            MarshmallowNetworkObservingStrategy.this.tryToUnregisterReceiver(this.b);
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (MarshmallowNetworkObservingStrategy.this.isIdleMode(context)) {
                MarshmallowNetworkObservingStrategy.this.onNext(Connectivity.create());
            } else {
                MarshmallowNetworkObservingStrategy.this.onNext(Connectivity.create(context));
            }
        }
    }

    public class c extends ConnectivityManager.NetworkCallback {
        public final /* synthetic */ Context a;

        public c(Context context) {
            this.a = context;
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            MarshmallowNetworkObservingStrategy.this.onNext(Connectivity.create(this.a));
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            MarshmallowNetworkObservingStrategy.this.onNext(Connectivity.create(this.a));
        }
    }

    @NonNull
    public BroadcastReceiver createIdleBroadcastReceiver() {
        return new b();
    }

    public ConnectivityManager.NetworkCallback createNetworkCallback(Context context) {
        return new c(context);
    }

    public boolean isIdleMode(Context context) {
        String packageName = context.getPackageName();
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager.isDeviceIdleMode() && !powerManager.isIgnoringBatteryOptimizations(packageName);
    }

    @Override // com.github.pwittchen.reactivenetwork.library.rx2.network.observing.NetworkObservingStrategy
    public Observable<Connectivity> observeNetworkConnectivity(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.a = createNetworkCallback(context);
        registerIdleReceiver(context);
        connectivityManager.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).addCapability(13).build(), this.a);
        return this.b.toFlowable(BackpressureStrategy.LATEST).doOnCancel(new a(connectivityManager, context)).startWith((Flowable<Connectivity>) Connectivity.create(context)).distinctUntilChanged().toObservable();
    }

    @Override // com.github.pwittchen.reactivenetwork.library.rx2.network.observing.NetworkObservingStrategy
    public void onError(String str, Exception exc) {
    }

    public void onNext(Connectivity connectivity) {
        this.b.onNext(connectivity);
    }

    public void registerIdleReceiver(Context context) {
        context.registerReceiver(this.c, new IntentFilter("android.os.action.DEVICE_IDLE_MODE_CHANGED"));
    }

    public void tryToUnregisterCallback(ConnectivityManager connectivityManager) {
        try {
            connectivityManager.unregisterNetworkCallback(this.a);
        } catch (Exception e) {
            onError(ERROR_MSG_NETWORK_CALLBACK, e);
        }
    }

    public void tryToUnregisterReceiver(Context context) {
        try {
            context.unregisterReceiver(this.c);
        } catch (Exception e) {
            onError(ERROR_MSG_RECEIVER, e);
        }
    }
}
