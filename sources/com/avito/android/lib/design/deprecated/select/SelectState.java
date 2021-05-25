package com.avito.android.lib.design.deprecated.select;

import androidx.annotation.AttrRes;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
/* JADX WARN: Init of enum NORMAL can be incorrect */
/* JADX WARN: Init of enum WARNING can be incorrect */
/* JADX WARN: Init of enum ERROR can be incorrect */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0014\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B1\b\u0002\u0012\b\b\u0001\u0010\r\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0001\u0010\n\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\r\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/lib/design/deprecated/select/SelectState;", "", "", AuthSource.BOOKING_ORDER, "I", "getPressedBackgroundAttr", "()I", "pressedBackgroundAttr", "c", "getRippleBackgroundAttr", "rippleBackgroundAttr", AuthSource.SEND_ABUSE, "getNormalBackgroundAttr", "normalBackgroundAttr", "d", "getStatusAttr", "statusAttr", "<init>", "(Ljava/lang/String;IIIII)V", "NORMAL", "WARNING", "ERROR", "components_release"}, k = 1, mv = {1, 4, 2})
public enum SelectState {
    NORMAL(r4, r5, r6, r15),
    WARNING(r12, r14, r14, r15),
    ERROR(r6, r8, r8, R.attr.red);
    
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    /* access modifiers changed from: public */
    static {
        int i = R.attr.gray4;
        int i2 = R.attr.gray8;
        int i3 = R.attr.gray12;
        int i4 = R.attr.gray48;
        int i5 = R.attr.orange50;
        int i6 = R.attr.orange200;
        int i7 = R.attr.red50;
        int i8 = R.attr.red100;
    }

    /* access modifiers changed from: public */
    SelectState(@AttrRes int i, @AttrRes int i2, @AttrRes int i3, @AttrRes int i4) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
    }

    public final int getNormalBackgroundAttr() {
        return this.a;
    }

    public final int getPressedBackgroundAttr() {
        return this.b;
    }

    public final int getRippleBackgroundAttr() {
        return this.c;
    }

    public final int getStatusAttr() {
        return this.d;
    }
}
