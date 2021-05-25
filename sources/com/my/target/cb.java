package com.my.target;

import androidx.annotation.NonNull;
public class cb extends by {
    public boolean e;

    public cb() {
        this.clickArea = bq.dJ;
    }

    @NonNull
    public static cb newCard(@NonNull ca caVar) {
        cb cbVar = new cb();
        cbVar.id = caVar.id;
        cbVar.ctaText = caVar.ctaText;
        cbVar.navigationType = caVar.navigationType;
        cbVar.urlscheme = caVar.urlscheme;
        cbVar.bundleId = caVar.bundleId;
        cbVar.directLink = caVar.directLink;
        cbVar.openInBrowser = caVar.openInBrowser;
        cbVar.deeplink = caVar.deeplink;
        cbVar.clickArea = caVar.clickArea;
        cbVar.rating = caVar.rating;
        cbVar.votes = caVar.votes;
        cbVar.domain = caVar.domain;
        cbVar.category = caVar.category;
        cbVar.subCategory = caVar.subCategory;
        return cbVar;
    }

    public boolean isImageOnly() {
        return this.e;
    }

    public void setImageOnly(boolean z) {
        this.e = z;
    }
}
