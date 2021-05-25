package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.ImageData;
public abstract class by {
    @NonNull
    public final cz a = cz.cx();
    @Nullable
    public bo adChoices;
    @NonNull
    public String advertisingLabel = "";
    @NonNull
    public String ageRestrictions = "";
    public boolean appInWhiteList = false;
    @NonNull
    public final bx b = bx.bE();
    @Nullable
    public String bundleId;
    @Nullable
    public String c;
    @NonNull
    public String category = "";
    @NonNull
    public bq clickArea = bq.dI;
    @Nullable
    public String ctaText;
    public boolean d = true;
    @Nullable
    public String deeplink;
    @NonNull
    public String description = "";
    public boolean directLink = false;
    @NonNull
    public String disclaimer = "";
    @NonNull
    public String domain = "";
    public float duration;
    public int height;
    @Nullable
    public ImageData icon;
    @NonNull
    public String id = "";
    @Nullable
    public ImageData image;
    @NonNull
    public String navigationType = "web";
    public boolean openInBrowser = false;
    public float rating;
    @NonNull
    public String subCategory = "";
    @NonNull
    public String title = "";
    @Nullable
    public String trackingLink;
    @NonNull
    public String type = "";
    @Nullable
    public String urlscheme;
    public int votes;
    public int width;

    @Nullable
    public bo getAdChoices() {
        return this.adChoices;
    }

    @NonNull
    public String getAdvertisingLabel() {
        return this.advertisingLabel;
    }

    @NonNull
    public String getAgeRestrictions() {
        return this.ageRestrictions;
    }

    @Nullable
    public String getBundleId() {
        return this.bundleId;
    }

    @NonNull
    public String getCategory() {
        return this.category;
    }

    @NonNull
    public bq getClickArea() {
        return this.clickArea;
    }

    @NonNull
    public String getCtaText() {
        String str = this.ctaText;
        return str == null ? "store".equals(this.navigationType) ? "Install" : "Visit" : str;
    }

    @Nullable
    public String getDeeplink() {
        return this.deeplink;
    }

    @NonNull
    public String getDescription() {
        return this.description;
    }

    @NonNull
    public String getDisclaimer() {
        return this.disclaimer;
    }

    @NonNull
    public String getDomain() {
        return this.domain;
    }

    public float getDuration() {
        return this.duration;
    }

    public int getHeight() {
        return this.height;
    }

    @Nullable
    public ImageData getIcon() {
        return this.icon;
    }

    @NonNull
    public String getId() {
        return this.id;
    }

    @Nullable
    public ImageData getImage() {
        return this.image;
    }

    @NonNull
    public String getNavigationType() {
        return this.navigationType;
    }

    @Nullable
    public String getPaidType() {
        return this.c;
    }

    public float getRating() {
        return this.rating;
    }

    @NonNull
    public cz getStatHolder() {
        return this.a;
    }

    @NonNull
    public String getSubCategory() {
        return this.subCategory;
    }

    @NonNull
    public String getTitle() {
        return this.title;
    }

    @Nullable
    public String getTrackingLink() {
        return this.trackingLink;
    }

    @NonNull
    public String getType() {
        return this.type;
    }

    @Nullable
    public String getUrlscheme() {
        return this.urlscheme;
    }

    @NonNull
    public bx getViewability() {
        return this.b;
    }

    public int getVotes() {
        return this.votes;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isAppInWhiteList() {
        return this.appInWhiteList;
    }

    public boolean isDirectLink() {
        return this.directLink;
    }

    public boolean isLogErrors() {
        return this.d;
    }

    public boolean isOpenInBrowser() {
        return this.openInBrowser;
    }

    public void setAdChoices(@Nullable bo boVar) {
        this.adChoices = boVar;
    }

    public void setAdvertisingLabel(@NonNull String str) {
        this.advertisingLabel = str;
    }

    public void setAgeRestrictions(@NonNull String str) {
        this.ageRestrictions = str;
    }

    public void setAppInWhiteList(boolean z) {
        this.appInWhiteList = z;
    }

    public void setBundleId(@Nullable String str) {
        this.bundleId = str;
    }

    public void setCategory(@NonNull String str) {
        this.category = str;
    }

    public void setClickArea(@NonNull bq bqVar) {
        this.clickArea = bqVar;
    }

    public void setCtaText(@NonNull String str) {
        this.ctaText = str;
    }

    public void setDeeplink(@Nullable String str) {
        this.deeplink = str;
    }

    public void setDescription(@NonNull String str) {
        this.description = str;
    }

    public void setDirectLink(boolean z) {
        this.directLink = z;
    }

    public void setDisclaimer(@NonNull String str) {
        this.disclaimer = str;
    }

    public void setDomain(@NonNull String str) {
        this.domain = str;
    }

    public void setDuration(float f) {
        this.duration = f;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setIcon(@Nullable ImageData imageData) {
        this.icon = imageData;
    }

    public void setId(@NonNull String str) {
        this.id = str;
    }

    public void setImage(@Nullable ImageData imageData) {
        this.image = imageData;
    }

    public void setLogErrors(boolean z) {
        this.d = z;
    }

    public void setNavigationType(@NonNull String str) {
        this.navigationType = str;
    }

    public void setOpenInBrowser(boolean z) {
        this.openInBrowser = z;
    }

    public void setPaidType(@Nullable String str) {
        this.c = str;
    }

    public void setRating(float f) {
        this.rating = f;
    }

    public void setSubCategory(@NonNull String str) {
        this.subCategory = str;
    }

    public void setTitle(@NonNull String str) {
        this.title = str;
    }

    public void setTrackingLink(@Nullable String str) {
        this.trackingLink = str;
    }

    public void setType(@NonNull String str) {
        this.type = str;
    }

    public void setUrlscheme(@Nullable String str) {
        this.urlscheme = str;
    }

    public void setVotes(int i) {
        this.votes = i;
    }

    public void setWidth(int i) {
        this.width = i;
    }
}
