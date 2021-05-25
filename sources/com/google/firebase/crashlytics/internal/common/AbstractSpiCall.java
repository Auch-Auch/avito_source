package com.google.firebase.crashlytics.internal.common;

import a2.b.a.a.a;
import com.google.firebase.crashlytics.internal.network.HttpMethod;
import com.google.firebase.crashlytics.internal.network.HttpRequest;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;
public abstract class AbstractSpiCall {
    public static final String ACCEPT_JSON_VALUE = "application/json";
    public static final String ANDROID_CLIENT_TYPE = "android";
    public static final String CRASHLYTICS_USER_AGENT = "Crashlytics Android SDK/";
    public static final String HEADER_ACCEPT = "Accept";
    public static final String HEADER_CLIENT_TYPE = "X-CRASHLYTICS-API-CLIENT-TYPE";
    public static final String HEADER_CLIENT_VERSION = "X-CRASHLYTICS-API-CLIENT-VERSION";
    public static final String HEADER_DEVELOPER_TOKEN = "X-CRASHLYTICS-DEVELOPER-TOKEN";
    public static final String HEADER_GOOGLE_APP_ID = "X-CRASHLYTICS-GOOGLE-APP-ID";
    public static final String HEADER_ORG_ID = "X-CRASHLYTICS-ORG-ID";
    public static final String HEADER_REQUEST_ID = "X-REQUEST-ID";
    public static final String HEADER_USER_AGENT = "User-Agent";
    public static final Pattern e = Pattern.compile("http(s?)://[^\\/]+", 2);
    public final String a;
    public final HttpRequestFactory b;
    public final HttpMethod c;
    public final String d;

    public AbstractSpiCall(String str, String str2, HttpRequestFactory httpRequestFactory, HttpMethod httpMethod) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        } else if (httpRequestFactory != null) {
            this.d = str;
            this.a = !CommonUtils.isNullOrEmpty(str) ? e.matcher(str2).replaceFirst(str) : str2;
            this.b = httpRequestFactory;
            this.c = httpMethod;
        } else {
            throw new IllegalArgumentException("requestFactory must not be null.");
        }
    }

    public HttpRequest getHttpRequest() {
        return getHttpRequest(Collections.emptyMap());
    }

    public String getUrl() {
        return this.a;
    }

    public HttpRequest getHttpRequest(Map<String, String> map) {
        HttpRequest buildHttpRequest = this.b.buildHttpRequest(this.c, getUrl(), map);
        StringBuilder L = a.L(CRASHLYTICS_USER_AGENT);
        L.append(CrashlyticsCore.getVersion());
        return buildHttpRequest.header("User-Agent", L.toString()).header(HEADER_DEVELOPER_TOKEN, "470fa2b4ae81cd56ecbcda9735803434cec591fa");
    }
}
