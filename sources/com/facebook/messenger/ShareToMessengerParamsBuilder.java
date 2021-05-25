package com.facebook.messenger;

import android.net.Uri;
public class ShareToMessengerParamsBuilder {
    public final Uri a;
    public final String b;
    public String c;
    public Uri d;

    public ShareToMessengerParamsBuilder(Uri uri, String str) {
        this.a = uri;
        this.b = str;
    }

    public ShareToMessengerParams build() {
        return new ShareToMessengerParams(this);
    }

    public Uri getExternalUri() {
        return this.d;
    }

    public String getMetaData() {
        return this.c;
    }

    public String getMimeType() {
        return this.b;
    }

    public Uri getUri() {
        return this.a;
    }

    public ShareToMessengerParamsBuilder setExternalUri(Uri uri) {
        this.d = uri;
        return this;
    }

    public ShareToMessengerParamsBuilder setMetaData(String str) {
        this.c = str;
        return this;
    }
}
