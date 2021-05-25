package com.avito.android.blueprints.chips;

import a2.b.a.a.a;
import androidx.annotation.DrawableRes;
import com.avito.android.lib.design.chips.Chipable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\r\u0010\fJ$\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u0012\u0010\fJ\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0015\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÖ\u0003¢\u0006\u0004\b\u0015\u0010\tR\u001c\u0010\u000f\u001a\u00020\n8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\fR\u0019\u0010\u000e\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0017\u001a\u0004\b\u001a\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/avito/android/blueprints/chips/ChipableValue;", "Lcom/avito/android/lib/design/chips/Chipable;", "", "getImageRes", "()Ljava/lang/Integer;", "", "other", "", "equalsAsChipable", "(Ljava/lang/Object;)Z", "", "component1", "()Ljava/lang/String;", "component2", "stringId", "chipTitle", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/blueprints/chips/ChipableValue;", "toString", "hashCode", "()I", "equals", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getChipTitle", AuthSource.SEND_ABUSE, "getStringId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class ChipableValue implements Chipable {
    @NotNull
    public final String a;
    @NotNull
    public final String b;

    public ChipableValue(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "chipTitle");
        this.a = str;
        this.b = str2;
    }

    public static /* synthetic */ ChipableValue copy$default(ChipableValue chipableValue, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = chipableValue.a;
        }
        if ((i & 2) != 0) {
            str2 = chipableValue.getChipTitle();
        }
        return chipableValue.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final String component2() {
        return getChipTitle();
    }

    @NotNull
    public final ChipableValue copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "chipTitle");
        return new ChipableValue(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChipableValue)) {
            return false;
        }
        ChipableValue chipableValue = (ChipableValue) obj;
        return Intrinsics.areEqual(this.a, chipableValue.a) && Intrinsics.areEqual(getChipTitle(), chipableValue.getChipTitle());
    }

    @Override // com.avito.android.lib.design.chips.Chipable
    public boolean equalsAsChipable(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "other");
        if (!(obj instanceof Chipable)) {
            return false;
        }
        boolean z = true;
        if (getChipTitle().length() > 0) {
            Chipable chipable = (Chipable) obj;
            if (chipable.getChipTitle().length() <= 0) {
                z = false;
            }
            if (z) {
                return Intrinsics.areEqual(getChipTitle(), chipable.getChipTitle());
            }
        }
        return false;
    }

    @Override // com.avito.android.lib.design.chips.Chipable
    @NotNull
    public String getChipTitle() {
        return this.b;
    }

    @Override // com.avito.android.lib.design.chips.Chipable
    @Nullable
    public Integer getImageRes() {
        return null;
    }

    @Override // com.avito.android.lib.design.chips.Chipable
    @DrawableRes
    @Nullable
    public Integer getLeftImageRes() {
        return Chipable.DefaultImpls.getLeftImageRes(this);
    }

    @Override // com.avito.android.lib.design.chips.Chipable
    @DrawableRes
    @Nullable
    public Integer getRightImageRes() {
        return Chipable.DefaultImpls.getRightImageRes(this);
    }

    @NotNull
    public final String getStringId() {
        return this.a;
    }

    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String chipTitle = getChipTitle();
        if (chipTitle != null) {
            i = chipTitle.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ChipableValue(stringId=");
        L.append(this.a);
        L.append(", chipTitle=");
        L.append(getChipTitle());
        L.append(")");
        return L.toString();
    }
}
