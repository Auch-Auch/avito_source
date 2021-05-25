package com.avito.android.remote.model;

import com.avito.android.remote.tariff.bar.TariffBar;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001e\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/CheckoutDialog;", "", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "actionTitle", "getActionTitle", "Lcom/avito/android/remote/tariff/bar/TariffBar;", "bar", "Lcom/avito/android/remote/tariff/bar/TariffBar;", "getBar", "()Lcom/avito/android/remote/tariff/bar/TariffBar;", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/tariff/bar/TariffBar;)V", "checkout_release"}, k = 1, mv = {1, 4, 2})
public final class CheckoutDialog {
    @SerializedName("actionTitle")
    @NotNull
    private final String actionTitle;
    @SerializedName("bar")
    @Nullable
    private final TariffBar bar;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("title")
    @NotNull
    private final String title;

    public CheckoutDialog(@NotNull String str, @Nullable String str2, @NotNull String str3, @Nullable TariffBar tariffBar) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str3, "actionTitle");
        this.title = str;
        this.description = str2;
        this.actionTitle = str3;
        this.bar = tariffBar;
    }

    @NotNull
    public final String getActionTitle() {
        return this.actionTitle;
    }

    @Nullable
    public final TariffBar getBar() {
        return this.bar;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
