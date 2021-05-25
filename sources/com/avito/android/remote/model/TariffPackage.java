package com.avito.android.remote.model;

import com.avito.android.remote.tariff.bar.TariffBar;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/TariffPackage;", "", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "subcategories", "getSubcategories", "Lcom/avito/android/remote/tariff/bar/TariffBar;", "bar", "Lcom/avito/android/remote/tariff/bar/TariffBar;", "getBar", "()Lcom/avito/android/remote/tariff/bar/TariffBar;", "locations", "getLocations", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/tariff/bar/TariffBar;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffPackage {
    @SerializedName("bar")
    @NotNull
    private final TariffBar bar;
    @SerializedName("locations")
    @NotNull
    private final String locations;
    @SerializedName("subcategories")
    @Nullable
    private final String subcategories;
    @SerializedName("title")
    @NotNull
    private final String title;

    public TariffPackage(@NotNull String str, @Nullable String str2, @NotNull String str3, @NotNull TariffBar tariffBar) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str3, "locations");
        Intrinsics.checkNotNullParameter(tariffBar, "bar");
        this.title = str;
        this.subcategories = str2;
        this.locations = str3;
        this.bar = tariffBar;
    }

    @NotNull
    public final TariffBar getBar() {
        return this.bar;
    }

    @NotNull
    public final String getLocations() {
        return this.locations;
    }

    @Nullable
    public final String getSubcategories() {
        return this.subcategories;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
