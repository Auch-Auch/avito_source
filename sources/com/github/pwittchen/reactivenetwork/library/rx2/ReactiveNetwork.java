package com.github.pwittchen.reactivenetwork.library.rx2;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.github.pwittchen.reactivenetwork.library.rx2.internet.observing.InternetObservingSettings;
import com.github.pwittchen.reactivenetwork.library.rx2.internet.observing.InternetObservingStrategy;
import com.github.pwittchen.reactivenetwork.library.rx2.internet.observing.error.ErrorHandler;
import com.github.pwittchen.reactivenetwork.library.rx2.network.observing.NetworkObservingStrategy;
import com.github.pwittchen.reactivenetwork.library.rx2.network.observing.strategy.LollipopNetworkObservingStrategy;
import com.github.pwittchen.reactivenetwork.library.rx2.network.observing.strategy.MarshmallowNetworkObservingStrategy;
import com.github.pwittchen.reactivenetwork.library.rx2.network.observing.strategy.PreLollipopNetworkObservingStrategy;
import io.reactivex.Observable;
import io.reactivex.Single;
public class ReactiveNetwork {
    public static final String LOG_TAG = "ReactiveNetwork";

    @RequiresPermission("android.permission.INTERNET")
    public static Single<Boolean> checkInternetConnectivity() {
        InternetObservingSettings create = InternetObservingSettings.create();
        return checkInternetConnectivity(create.strategy(), create.host(), create.port(), create.timeout(), create.httpResponse(), create.errorHandler());
    }

    public static ReactiveNetwork create() {
        return new ReactiveNetwork();
    }

    @RequiresPermission("android.permission.INTERNET")
    public static Observable<Boolean> observeInternetConnectivity() {
        InternetObservingSettings create = InternetObservingSettings.create();
        return observeInternetConnectivity(create.strategy(), create.initialInterval(), create.interval(), create.host(), create.port(), create.timeout(), create.httpResponse(), create.errorHandler());
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static Observable<Connectivity> observeNetworkConnectivity(Context context) {
        NetworkObservingStrategy networkObservingStrategy;
        if (Preconditions.isAtLeastAndroidMarshmallow()) {
            networkObservingStrategy = new MarshmallowNetworkObservingStrategy();
        } else if (Preconditions.isAtLeastAndroidLollipop()) {
            networkObservingStrategy = new LollipopNetworkObservingStrategy();
        } else {
            networkObservingStrategy = new PreLollipopNetworkObservingStrategy();
        }
        return observeNetworkConnectivity(context, networkObservingStrategy);
    }

    @RequiresPermission("android.permission.INTERNET")
    public static Single<Boolean> checkInternetConnectivity(InternetObservingSettings internetObservingSettings) {
        return checkInternetConnectivity(internetObservingSettings.strategy(), internetObservingSettings.host(), internetObservingSettings.port(), internetObservingSettings.timeout(), internetObservingSettings.httpResponse(), internetObservingSettings.errorHandler());
    }

    @RequiresPermission("android.permission.INTERNET")
    public static Observable<Boolean> observeInternetConnectivity(InternetObservingSettings internetObservingSettings) {
        return observeInternetConnectivity(internetObservingSettings.strategy(), internetObservingSettings.initialInterval(), internetObservingSettings.interval(), internetObservingSettings.host(), internetObservingSettings.port(), internetObservingSettings.timeout(), internetObservingSettings.httpResponse(), internetObservingSettings.errorHandler());
    }

    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public static Observable<Connectivity> observeNetworkConnectivity(Context context, NetworkObservingStrategy networkObservingStrategy) {
        Preconditions.checkNotNull(context, "context == null");
        Preconditions.checkNotNull(networkObservingStrategy, "strategy == null");
        return networkObservingStrategy.observeNetworkConnectivity(context);
    }

    @RequiresPermission("android.permission.INTERNET")
    public static Single<Boolean> checkInternetConnectivity(InternetObservingStrategy internetObservingStrategy, String str, int i, int i2, int i3, ErrorHandler errorHandler) {
        Preconditions.checkNotNull(internetObservingStrategy, "strategy == null");
        return internetObservingStrategy.checkInternetConnectivity(str, i, i2, i3, errorHandler);
    }

    @RequiresPermission("android.permission.INTERNET")
    public static Observable<Boolean> observeInternetConnectivity(InternetObservingStrategy internetObservingStrategy, int i, int i2, String str, int i3, int i4, int i5, ErrorHandler errorHandler) {
        Preconditions.checkNotNull(internetObservingStrategy, "strategy == null");
        return internetObservingStrategy.observeInternetConnectivity(i, i2, str, i3, i4, i5, errorHandler);
    }
}
