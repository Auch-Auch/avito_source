package com.avito.android.lib.design.picker;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0018R\"\u0010\u0005\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0019\u0010\u000e\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/lib/design/picker/WheelStyle;", "", "", AuthSource.BOOKING_ORDER, "Z", "isCycled", "()Z", "setCycled", "(Z)V", "Lcom/avito/android/lib/design/picker/WheelGravity;", AuthSource.SEND_ABUSE, "Lcom/avito/android/lib/design/picker/WheelGravity;", "getTextPositon", "()Lcom/avito/android/lib/design/picker/WheelGravity;", "textPositon", "", "c", "I", "getExplicitWidth", "()I", "setExplicitWidth", "(I)V", "explicitWidth", "<init>", "(Lcom/avito/android/lib/design/picker/WheelGravity;ZI)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class WheelStyle {
    @NotNull
    public final WheelGravity a;
    public boolean b;
    public int c;

    public WheelStyle() {
        this(null, false, 0, 7, null);
    }

    public WheelStyle(@NotNull WheelGravity wheelGravity, boolean z, int i) {
        Intrinsics.checkNotNullParameter(wheelGravity, "textPositon");
        this.a = wheelGravity;
        this.b = z;
        this.c = i;
    }

    public final int getExplicitWidth() {
        return this.c;
    }

    @NotNull
    public final WheelGravity getTextPositon() {
        return this.a;
    }

    public final boolean isCycled() {
        return this.b;
    }

    public final void setCycled(boolean z) {
        this.b = z;
    }

    public final void setExplicitWidth(int i) {
        this.c = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WheelStyle(WheelGravity wheelGravity, boolean z, int i, int i2, j jVar) {
        this((i2 & 1) != 0 ? WheelGravity.CENTER : wheelGravity, (i2 & 2) != 0 ? true : z, (i2 & 4) != 0 ? 0 : i);
    }
}
