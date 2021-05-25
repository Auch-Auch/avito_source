package com.avito.android.remote.model.edit;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u000e\u001a\u00020\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/edit/TariffEditInfoResult;", "", "Lcom/avito/android/remote/model/edit/TariffBanner;", "tariffBanner", "Lcom/avito/android/remote/model/edit/TariffBanner;", "getTariffBanner", "()Lcom/avito/android/remote/model/edit/TariffBanner;", "", "Lcom/avito/android/remote/model/edit/Period;", "periods", "Ljava/util/List;", "getPeriods", "()Ljava/util/List;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/edit/TariffBanner;Ljava/util/List;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffEditInfoResult {
    @SerializedName("periods")
    @NotNull
    private final List<Period> periods;
    @SerializedName("tariffBanner")
    @Nullable
    private final TariffBanner tariffBanner;
    @SerializedName("title")
    @NotNull
    private final String title;

    public TariffEditInfoResult(@NotNull String str, @Nullable TariffBanner tariffBanner2, @NotNull List<Period> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "periods");
        this.title = str;
        this.tariffBanner = tariffBanner2;
        this.periods = list;
    }

    @NotNull
    public final List<Period> getPeriods() {
        return this.periods;
    }

    @Nullable
    public final TariffBanner getTariffBanner() {
        return this.tariffBanner;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
