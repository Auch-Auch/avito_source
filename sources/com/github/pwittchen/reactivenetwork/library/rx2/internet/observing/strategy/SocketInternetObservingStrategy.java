package com.github.pwittchen.reactivenetwork.library.rx2.internet.observing.strategy;

import com.github.pwittchen.reactivenetwork.library.rx2.Preconditions;
import com.github.pwittchen.reactivenetwork.library.rx2.internet.observing.InternetObservingStrategy;
import com.github.pwittchen.reactivenetwork.library.rx2.internet.observing.error.ErrorHandler;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
public class SocketInternetObservingStrategy implements InternetObservingStrategy {

    public class a implements Function<Long, Boolean> {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ErrorHandler d;

        public a(String str, int i, int i2, ErrorHandler errorHandler) {
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = errorHandler;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Boolean apply(@NonNull Long l) throws Exception {
            return Boolean.valueOf(SocketInternetObservingStrategy.this.isConnected(this.a, this.b, this.c, this.d));
        }
    }

    public class b implements SingleOnSubscribe<Boolean> {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ ErrorHandler d;

        public b(String str, int i, int i2, ErrorHandler errorHandler) {
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = errorHandler;
        }

        @Override // io.reactivex.SingleOnSubscribe
        public void subscribe(@NonNull SingleEmitter<Boolean> singleEmitter) throws Exception {
            singleEmitter.onSuccess(Boolean.valueOf(SocketInternetObservingStrategy.this.isConnected(this.a, this.b, this.c, this.d)));
        }
    }

    public String adjustHost(String str) {
        if (str.startsWith("http://")) {
            return str.replace("http://", "");
        }
        return str.startsWith("https://") ? str.replace("https://", "") : str;
    }

    @Override // com.github.pwittchen.reactivenetwork.library.rx2.internet.observing.InternetObservingStrategy
    public Single<Boolean> checkInternetConnectivity(String str, int i, int i2, int i3, ErrorHandler errorHandler) {
        Preconditions.checkNotNullOrEmpty(str, "host is null or empty");
        Preconditions.checkGreaterThanZero(i, "port is not a positive number");
        Preconditions.checkGreaterThanZero(i2, "timeoutInMs is not a positive number");
        Preconditions.checkNotNull(errorHandler, "errorHandler is null");
        return Single.create(new b(str, i, i2, errorHandler));
    }

    @Override // com.github.pwittchen.reactivenetwork.library.rx2.internet.observing.InternetObservingStrategy
    public String getDefaultPingHost() {
        return "www.google.com";
    }

    public boolean isConnected(String str, int i, int i2, ErrorHandler errorHandler) {
        return isConnected(new Socket(), str, i, i2, errorHandler);
    }

    @Override // com.github.pwittchen.reactivenetwork.library.rx2.internet.observing.InternetObservingStrategy
    public Observable<Boolean> observeInternetConnectivity(int i, int i2, String str, int i3, int i4, int i5, ErrorHandler errorHandler) {
        Preconditions.checkGreaterOrEqualToZero(i, "initialIntervalInMs is not a positive number");
        Preconditions.checkGreaterThanZero(i2, "intervalInMs is not a positive number");
        Preconditions.checkNotNullOrEmpty(str, "host is null or empty");
        Preconditions.checkGreaterThanZero(i3, "port is not a positive number");
        Preconditions.checkGreaterThanZero(i4, "timeoutInMs is not a positive number");
        Preconditions.checkNotNull(errorHandler, "errorHandler is null");
        return Observable.interval((long) i, (long) i2, TimeUnit.MILLISECONDS, Schedulers.io()).map(new a(adjustHost(str), i3, i4, errorHandler)).distinctUntilChanged();
    }

    public boolean isConnected(Socket socket, String str, int i, int i2, ErrorHandler errorHandler) {
        try {
            socket.connect(new InetSocketAddress(str, i), i2);
            boolean isConnected = socket.isConnected();
            try {
                socket.close();
                return isConnected;
            } catch (IOException e) {
                errorHandler.handleError(e, "Could not close the socket");
                return isConnected;
            }
        } catch (IOException unused) {
            socket.close();
            return false;
        } catch (Throwable th) {
            try {
                socket.close();
            } catch (IOException e2) {
                errorHandler.handleError(e2, "Could not close the socket");
            }
            throw th;
        }
    }
}
