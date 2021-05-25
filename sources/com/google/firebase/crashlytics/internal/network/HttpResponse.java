package com.google.firebase.crashlytics.internal.network;

import okhttp3.Headers;
public class HttpResponse {
    public int a;
    public String b;
    public Headers c;

    public HttpResponse(int i, String str, Headers headers) {
        this.a = i;
        this.b = str;
        this.c = headers;
    }

    public String body() {
        return this.b;
    }

    public int code() {
        return this.a;
    }

    public String header(String str) {
        return this.c.get(str);
    }
}
