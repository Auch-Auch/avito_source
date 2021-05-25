package com.avito.android.remote.model.change;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/change/TariffChangeResult;", "", "", "Lcom/avito/android/remote/model/change/Tariff;", "tariffs", "Ljava/util/List;", "getTariffs", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffChangeResult {
    @SerializedName("tariffs")
    @NotNull
    private final List<Tariff> tariffs;

    public TariffChangeResult(@NotNull List<Tariff> list) {
        Intrinsics.checkNotNullParameter(list, "tariffs");
        this.tariffs = list;
    }

    @NotNull
    public final List<Tariff> getTariffs() {
        return this.tariffs;
    }
}
