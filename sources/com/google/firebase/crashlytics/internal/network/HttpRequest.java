package com.google.firebase.crashlytics.internal.network;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.CacheControl;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
public class HttpRequest {
    public static final OkHttpClient f = new OkHttpClient().newBuilder().callTimeout(10000, TimeUnit.MILLISECONDS).build();
    public final HttpMethod a;
    public final String b;
    public final Map<String, String> c;
    public final Map<String, String> d;
    public MultipartBody.Builder e = null;

    public HttpRequest(HttpMethod httpMethod, String str, Map<String, String> map) {
        this.a = httpMethod;
        this.b = str;
        this.c = map;
        this.d = new HashMap();
    }

    public HttpResponse execute() throws IOException {
        Request.Builder cacheControl = new Request.Builder().cacheControl(new CacheControl.Builder().noCache().build());
        HttpUrl.Builder newBuilder = HttpUrl.parse(this.b).newBuilder();
        for (Map.Entry<String, String> entry : this.c.entrySet()) {
            newBuilder = newBuilder.addEncodedQueryParameter(entry.getKey(), entry.getValue());
        }
        Request.Builder url = cacheControl.url(newBuilder.build());
        for (Map.Entry<String, String> entry2 : this.d.entrySet()) {
            url = url.header(entry2.getKey(), entry2.getValue());
        }
        MultipartBody.Builder builder = this.e;
        String str = null;
        Response execute = f.newCall(url.method(this.a.name(), builder == null ? null : builder.build()).build()).execute();
        if (execute.body() != null) {
            str = execute.body().string();
        }
        return new HttpResponse(execute.code(), str, execute.headers());
    }

    public HttpRequest header(String str, String str2) {
        this.d.put(str, str2);
        return this;
    }

    public String method() {
        return this.a.name();
    }

    public HttpRequest part(String str, String str2) {
        if (this.e == null) {
            this.e = new MultipartBody.Builder().setType(MultipartBody.FORM);
        }
        this.e = this.e.addFormDataPart(str, str2);
        return this;
    }

    public HttpRequest header(Map.Entry<String, String> entry) {
        return header(entry.getKey(), entry.getValue());
    }

    public HttpRequest part(String str, String str2, String str3, File file) {
        RequestBody create = RequestBody.create(MediaType.parse(str3), file);
        if (this.e == null) {
            this.e = new MultipartBody.Builder().setType(MultipartBody.FORM);
        }
        this.e = this.e.addFormDataPart(str, str2, create);
        return this;
    }
}
