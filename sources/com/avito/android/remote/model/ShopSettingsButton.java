package com.avito.android.remote.model;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u001c\u0010\u0007\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/model/ShopSettingsButton;", "", "", "isFloating", "Z", "()Z", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Z)V", "shop-settings_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsButton {
    @SerializedName("isFloating")
    private final boolean isFloating;
    @SerializedName("title")
    @NotNull
    private final String title;

    public ShopSettingsButton(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
        this.isFloating = z;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final boolean isFloating() {
        return this.isFloating;
    }
}
