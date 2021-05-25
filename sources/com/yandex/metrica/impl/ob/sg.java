package com.yandex.metrica.impl.ob;

import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;
public abstract class sg {
    private final String a;

    public static final class a {
        public static final int a = ((int) TimeUnit.SECONDS.toMillis(30));
    }

    public sg(String str) {
        this.a = str;
    }

    public HttpURLConnection a() throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.a).openConnection();
        int i = a.a;
        httpURLConnection.setConnectTimeout(i);
        httpURLConnection.setReadTimeout(i);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setRequestProperty("Accept", AbstractSpiCall.ACCEPT_JSON_VALUE);
        httpURLConnection.setRequestProperty("User-Agent", cx.a("com.yandex.mobile.metrica.sdk"));
        return httpURLConnection;
    }

    public abstract boolean b();
}
