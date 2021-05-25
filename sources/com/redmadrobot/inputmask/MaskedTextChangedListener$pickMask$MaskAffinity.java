package com.redmadrobot.inputmask;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.redmadrobot.inputmask.helper.Mask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000)\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b*\u0001\u0000\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0007J\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0007¨\u0006\u001c"}, d2 = {"com/redmadrobot/inputmask/MaskedTextChangedListener$pickMask$MaskAffinity", "", "Lcom/redmadrobot/inputmask/helper/Mask;", "component1", "()Lcom/redmadrobot/inputmask/helper/Mask;", "", "component2", "()I", "mask", "affinity", "copy", "(Lcom/redmadrobot/inputmask/helper/Mask;I)Lcom/redmadrobot/inputmask/MaskedTextChangedListener$pickMask$MaskAffinity;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/redmadrobot/inputmask/helper/Mask;", "getMask", AuthSource.BOOKING_ORDER, "I", "getAffinity", "<init>", "(Lcom/redmadrobot/inputmask/helper/Mask;I)V", "input-mask-android_release"}, k = 1, mv = {1, 4, 0})
public final class MaskedTextChangedListener$pickMask$MaskAffinity {
    @NotNull
    public final Mask a;
    public final int b;

    public MaskedTextChangedListener$pickMask$MaskAffinity(@NotNull Mask mask, int i) {
        Intrinsics.checkParameterIsNotNull(mask, "mask");
        this.a = mask;
        this.b = i;
    }

    @NotNull
    public static /* synthetic */ MaskedTextChangedListener$pickMask$MaskAffinity copy$default(MaskedTextChangedListener$pickMask$MaskAffinity maskedTextChangedListener$pickMask$MaskAffinity, Mask mask, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            mask = maskedTextChangedListener$pickMask$MaskAffinity.a;
        }
        if ((i2 & 2) != 0) {
            i = maskedTextChangedListener$pickMask$MaskAffinity.b;
        }
        return maskedTextChangedListener$pickMask$MaskAffinity.copy(mask, i);
    }

    @NotNull
    public final Mask component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    @NotNull
    public final MaskedTextChangedListener$pickMask$MaskAffinity copy(@NotNull Mask mask, int i) {
        Intrinsics.checkParameterIsNotNull(mask, "mask");
        return new MaskedTextChangedListener$pickMask$MaskAffinity(mask, i);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            if (obj instanceof MaskedTextChangedListener$pickMask$MaskAffinity) {
                MaskedTextChangedListener$pickMask$MaskAffinity maskedTextChangedListener$pickMask$MaskAffinity = (MaskedTextChangedListener$pickMask$MaskAffinity) obj;
                if (Intrinsics.areEqual(this.a, maskedTextChangedListener$pickMask$MaskAffinity.a)) {
                    if (this.b == maskedTextChangedListener$pickMask$MaskAffinity.b) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final int getAffinity() {
        return this.b;
    }

    @NotNull
    public final Mask getMask() {
        return this.a;
    }

    public int hashCode() {
        Mask mask = this.a;
        return ((mask != null ? mask.hashCode() : 0) * 31) + this.b;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("MaskAffinity(mask=");
        L.append(this.a);
        L.append(", affinity=");
        return a.j(L, this.b, ")");
    }
}
