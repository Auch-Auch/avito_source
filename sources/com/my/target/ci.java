package com.my.target;

import androidx.annotation.NonNull;
public class ci extends by {
    @NonNull
    public final String e;

    public ci(@NonNull String str) {
        this.e = str;
    }

    public static ci newContent(@NonNull cg cgVar, @NonNull String str) {
        ci ciVar = new ci(str);
        ciVar.id = cgVar.id;
        ciVar.trackingLink = cgVar.trackingLink;
        ciVar.deeplink = cgVar.deeplink;
        ciVar.urlscheme = cgVar.urlscheme;
        ciVar.bundleId = cgVar.bundleId;
        ciVar.navigationType = cgVar.navigationType;
        ciVar.directLink = cgVar.directLink;
        ciVar.openInBrowser = cgVar.openInBrowser;
        return ciVar;
    }

    @NonNull
    public String getSource() {
        return this.e;
    }
}
