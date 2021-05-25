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
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;
public class WalledGardenInternetObservingStrategy implements InternetObservingStrategy {

    public class a implements Function<Long, Boolean> {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ ErrorHandler e;

        public a(String str, int i, int i2, int i3, ErrorHandler errorHandler) {
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = errorHandler;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Boolean apply(@NonNull Long l) throws Exception {
            return WalledGardenInternetObservingStrategy.this.isConnected(this.a, this.b, this.c, this.d, this.e);
        }
    }

    public class b implements SingleOnSubscribe<Boolean> {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ ErrorHandler e;

        public b(String str, int i, int i2, int i3, ErrorHandler errorHandler) {
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = errorHandler;
        }

        @Override // io.reactivex.SingleOnSubscribe
        public void subscribe(@NonNull SingleEmitter<Boolean> singleEmitter) {
            singleEmitter.onSuccess(WalledGardenInternetObservingStrategy.this.isConnected(this.a, this.b, this.c, this.d, this.e));
        }
    }

    public final void a(String str, int i, int i2, int i3, ErrorHandler errorHandler) {
        Preconditions.checkNotNullOrEmpty(str, "host is null or empty");
        Preconditions.checkGreaterThanZero(i, "port is not a positive number");
        Preconditions.checkGreaterThanZero(i2, "timeoutInMs is not a positive number");
        Preconditions.checkNotNull(errorHandler, "errorHandler is null");
        Preconditions.checkNotNull(Integer.valueOf(i3), "httpResponse is null");
        Preconditions.checkGreaterThanZero(i3, "httpResponse is not a positive number");
    }

    public String adjustHost(String str) {
        return (str.startsWith("http://") || str.startsWith("https://")) ? str : "http://".concat(str);
    }

    @Override // com.github.pwittchen.reactivenetwork.library.rx2.internet.observing.InternetObservingStrategy
    public Single<Boolean> checkInternetConnectivity(String str, int i, int i2, int i3, ErrorHandler errorHandler) {
        a(str, i, i2, i3, errorHandler);
        return Single.create(new b(str, i, i2, i3, errorHandler));
    }

    public HttpURLConnection createHttpUrlConnection(String str, int i, int i2) throws IOException {
        URL url = new URL(str);
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(url.getProtocol(), url.getHost(), i, url.getFile()).openConnection();
        httpURLConnection.setConnectTimeout(i2);
        httpURLConnection.setReadTimeout(i2);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setUseCaches(false);
        return httpURLConnection;
    }

    @Override // com.github.pwittchen.reactivenetwork.library.rx2.internet.observing.InternetObservingStrategy
    public String getDefaultPingHost() {
        return "http://clients3.google.com/generate_204";
    }

    public Boolean isConnected(String str, int i, int i2, int i3, ErrorHandler errorHandler) {
        HttpURLConnection httpURLConnection = null;
        try {
            HttpURLConnection createHttpUrlConnection = createHttpUrlConnection(str, i, i2);
            Boolean valueOf = Boolean.valueOf(createHttpUrlConnection.getResponseCode() == i3);
            createHttpUrlConnection.disconnect();
            return valueOf;
        } catch (IOException e) {
            errorHandler.handleError(e, "Could not establish connection with WalledGardenStrategy");
            Boolean bool = Boolean.FALSE;
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            return bool;
        } catch (Throwable th) {
            if (0 != 0) {
                httpURLConnection.disconnect();
            }
            throw th;
        }
    }

    @Override // com.github.pwittchen.reactivenetwork.library.rx2.internet.observing.InternetObservingStrategy
    public Observable<Boolean> observeInternetConnectivity(int i, int i2, String str, int i3, int i4, int i5, ErrorHandler errorHandler) {
        Preconditions.checkGreaterOrEqualToZero(i, "initialIntervalInMs is not a positive number");
        Preconditions.checkGreaterThanZero(i2, "intervalInMs is not a positive number");
        a(str, i3, i4, i5, errorHandler);
        return Observable.interval((long) i, (long) i2, TimeUnit.MILLISECONDS, Schedulers.io()).map(new a(adjustHost(str), i3, i4, i5, errorHandler)).distinctUntilChanged();
    }
}
