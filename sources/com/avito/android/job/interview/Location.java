package com.avito.android.job.interview;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/avito/android/job/interview/Location;", "", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "", "lat", "D", "getLat", "()D", "lng", "getLng", "<init>", "(Ljava/lang/String;DD)V", "job_release"}, k = 1, mv = {1, 4, 2})
public final class Location {
    @SerializedName("lat")
    private final double lat;
    @SerializedName("lng")
    private final double lng;
    @SerializedName("text")
    @NotNull
    private final String text;

    public Location(@NotNull String str, double d, double d2) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.text = str;
        this.lat = d;
        this.lng = d2;
    }

    public final double getLat() {
        return this.lat;
    }

    public final double getLng() {
        return this.lng;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }
}
