package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.browser.trusted.sharing.ShareTarget;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
public class dd extends de<Void> {
    @Nullable
    public String a;

    @NonNull
    public static dd cH() {
        return new dd();
    }

    @NonNull
    public dd L(@Nullable String str) {
        this.a = str;
        return this;
    }

    /* renamed from: e */
    public Void c(@NonNull String str, @NonNull Context context) {
        HttpURLConnection httpURLConnection;
        Throwable th;
        if (this.a == null) {
            ae.a("can't send log request: body is null");
            this.eW = false;
            return null;
        }
        ae.a("send log request");
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
                httpURLConnection.setRequestProperty("Content-Type", "text/html; charset=utf-8");
                httpURLConnection.setRequestProperty("connection", "close");
                httpURLConnection.connect();
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, Charset.forName("UTF-8")));
                bufferedWriter.write(this.a);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                httpURLConnection.getInputStream().close();
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            try {
                this.eW = false;
                this.c = th.getMessage();
                ae.a("log request error: " + this.c);
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            }
        }
        return null;
    }
}
