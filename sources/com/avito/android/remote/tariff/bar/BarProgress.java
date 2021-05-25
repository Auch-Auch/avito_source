package com.avito.android.remote.tariff.bar;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/remote/tariff/bar/BarProgress;", "", "", "value", "F", "getValue", "()F", "Lcom/avito/android/remote/tariff/bar/BarProgressState;", "state", "Lcom/avito/android/remote/tariff/bar/BarProgressState;", "getState", "()Lcom/avito/android/remote/tariff/bar/BarProgressState;", "<init>", "(FLcom/avito/android/remote/tariff/bar/BarProgressState;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class BarProgress {
    @SerializedName("state")
    @NotNull
    private final BarProgressState state;
    @SerializedName("value")
    private final float value;

    public BarProgress(float f, @NotNull BarProgressState barProgressState) {
        Intrinsics.checkNotNullParameter(barProgressState, "state");
        this.value = f;
        this.state = barProgressState;
    }

    @NotNull
    public final BarProgressState getState() {
        return this.state;
    }

    public final float getValue() {
        return this.value;
    }
}
