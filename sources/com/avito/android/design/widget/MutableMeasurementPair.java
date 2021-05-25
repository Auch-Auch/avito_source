package com.avito.android.design.widget;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\u0004\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/design/widget/MutableMeasurementPair;", "", "", "widthSpec", "heightSpec", "mutate", "(II)Lcom/avito/android/design/widget/MutableMeasurementPair;", AuthSource.SEND_ABUSE, "I", "getWidthSpec", "()I", "setWidthSpec", "(I)V", AuthSource.BOOKING_ORDER, "getHeightSpec", "setHeightSpec", "<init>", "()V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class MutableMeasurementPair {
    public int a;
    public int b;

    public final int getHeightSpec() {
        return this.b;
    }

    public final int getWidthSpec() {
        return this.a;
    }

    @NotNull
    public final MutableMeasurementPair mutate(int i, int i2) {
        this.a = i;
        this.b = i2;
        return this;
    }

    public final void setHeightSpec(int i) {
        this.b = i;
    }

    public final void setWidthSpec(int i) {
        this.a = i;
    }
}
