package com.avito.android.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/model/BundleDiscount;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/UniversalColor;", "color", "Lcom/avito/android/remote/model/UniversalColor;", "getColor", "()Lcom/avito/android/remote/model/UniversalColor;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/UniversalColor;)V", "vas-bundles_release"}, k = 1, mv = {1, 4, 2})
public final class BundleDiscount {
    @SerializedName("color")
    @NotNull
    private final UniversalColor color;
    @SerializedName("title")
    @NotNull
    private final String title;

    public BundleDiscount(@NotNull String str, @NotNull UniversalColor universalColor) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(universalColor, "color");
        this.title = str;
        this.color = universalColor;
    }

    @NotNull
    public final UniversalColor getColor() {
        return this.color;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
