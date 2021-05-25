package com.avito.android.remote.model.change;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/change/PlusTextBenefit;", "Lcom/avito/android/remote/model/change/TariffBenefit;", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class PlusTextBenefit implements TariffBenefit {
    @SerializedName("plusText")
    @NotNull
    private final String text;

    public PlusTextBenefit(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.text = str;
    }

    @Override // com.avito.android.remote.model.change.TariffBenefit
    @NotNull
    public String getText() {
        return this.text;
    }
}
