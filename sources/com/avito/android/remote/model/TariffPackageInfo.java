package com.avito.android.remote.model;

import com.avito.android.remote.tariff.bar.TariffBar;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u00020\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/TariffPackageInfo;", "", "", "Lcom/avito/android/remote/model/TariffPackageInfoItem;", "infoList", "Ljava/util/List;", "getInfoList", "()Ljava/util/List;", "Lcom/avito/android/remote/tariff/bar/TariffBar;", "bar", "Lcom/avito/android/remote/tariff/bar/TariffBar;", "getBar", "()Lcom/avito/android/remote/tariff/bar/TariffBar;", "", "packageTitle", "Ljava/lang/String;", "getPackageTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/tariff/bar/TariffBar;Ljava/util/List;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffPackageInfo {
    @SerializedName("bar")
    @NotNull
    private final TariffBar bar;
    @SerializedName("infoList")
    @NotNull
    private final List<TariffPackageInfoItem> infoList;
    @SerializedName("packageTitle")
    @NotNull
    private final String packageTitle;

    public TariffPackageInfo(@NotNull String str, @NotNull TariffBar tariffBar, @NotNull List<TariffPackageInfoItem> list) {
        Intrinsics.checkNotNullParameter(str, "packageTitle");
        Intrinsics.checkNotNullParameter(tariffBar, "bar");
        Intrinsics.checkNotNullParameter(list, "infoList");
        this.packageTitle = str;
        this.bar = tariffBar;
        this.infoList = list;
    }

    @NotNull
    public final TariffBar getBar() {
        return this.bar;
    }

    @NotNull
    public final List<TariffPackageInfoItem> getInfoList() {
        return this.infoList;
    }

    @NotNull
    public final String getPackageTitle() {
        return this.packageTitle;
    }
}
