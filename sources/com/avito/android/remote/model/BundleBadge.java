package com.avito.android.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/model/BundleBadge;", "", "Lcom/avito/android/remote/model/UniversalColor;", "backgroundColor", "Lcom/avito/android/remote/model/UniversalColor;", "getBackgroundColor", "()Lcom/avito/android/remote/model/UniversalColor;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "textColor", "getTextColor", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class BundleBadge {
    @SerializedName("backgroundColor")
    @NotNull
    private final UniversalColor backgroundColor;
    @SerializedName("textColor")
    @NotNull
    private final UniversalColor textColor;
    @SerializedName("title")
    @NotNull
    private final String title;

    public BundleBadge(@NotNull String str, @NotNull UniversalColor universalColor, @NotNull UniversalColor universalColor2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(universalColor, "textColor");
        Intrinsics.checkNotNullParameter(universalColor2, "backgroundColor");
        this.title = str;
        this.textColor = universalColor;
        this.backgroundColor = universalColor2;
    }

    @NotNull
    public final UniversalColor getBackgroundColor() {
        return this.backgroundColor;
    }

    @NotNull
    public final UniversalColor getTextColor() {
        return this.textColor;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
