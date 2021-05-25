package com.avito.android.remote.model.change;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u000eR$\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\t\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/remote/model/change/BenefitInfo;", "", "", "Lcom/avito/android/remote/model/change/TariffBenefit;", "list", "Ljava/util/List;", "getList", "()Ljava/util/List;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class BenefitInfo {
    @SerializedName("list")
    @Nullable
    private final List<TariffBenefit> list;
    @SerializedName("title")
    @NotNull
    private final String title;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.remote.model.change.TariffBenefit> */
    /* JADX WARN: Multi-variable type inference failed */
    public BenefitInfo(@NotNull String str, @Nullable List<? extends TariffBenefit> list2) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
        this.list = list2;
    }

    @Nullable
    public final List<TariffBenefit> getList() {
        return this.list;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }
}
