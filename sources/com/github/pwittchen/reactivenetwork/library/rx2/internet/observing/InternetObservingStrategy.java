package com.github.pwittchen.reactivenetwork.library.rx2.internet.observing;

import com.github.pwittchen.reactivenetwork.library.rx2.internet.observing.error.ErrorHandler;
import io.reactivex.Observable;
import io.reactivex.Single;
public interface InternetObservingStrategy {
    Single<Boolean> checkInternetConnectivity(String str, int i, int i2, int i3, ErrorHandler errorHandler);

    String getDefaultPingHost();

    Observable<Boolean> observeInternetConnectivity(int i, int i2, String str, int i3, int i4, int i5, ErrorHandler errorHandler);
}
