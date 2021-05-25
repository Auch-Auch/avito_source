package com.avito.android.design.widget;

import android.view.View;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0005R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/design/widget/BoundedViewSpecCalculator;", "", "", "currentSpec", "calculate", "(I)I", "size", "getMax", "getMin", AuthSource.SEND_ABUSE, "I", "getMinSize", "()I", SDKConstants.PARAM_CONTEXT_MIN_SIZE, AuthSource.BOOKING_ORDER, "getMaxSize", SDKConstants.PARAM_CONTEXT_MAX_SIZE, "<init>", "(II)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class BoundedViewSpecCalculator {
    public final int a;
    public final int b;

    public BoundedViewSpecCalculator(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public final int calculate(int i) {
        return View.MeasureSpec.makeMeasureSpec(getMin(getMax(View.MeasureSpec.getSize(i))), View.MeasureSpec.getMode(i));
    }

    public final int getMax(int i) {
        int i2 = this.a;
        if (i2 < 0) {
            return i;
        }
        return Math.max(i2, i);
    }

    public final int getMaxSize() {
        return this.b;
    }

    public final int getMin(int i) {
        int i2 = this.b;
        if (i2 < 0) {
            return i;
        }
        return Math.min(i, i2);
    }

    public final int getMinSize() {
        return this.a;
    }
}
