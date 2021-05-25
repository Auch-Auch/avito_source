package a2.a.a.b3.c.b.v.a;

import androidx.annotation.DrawableRes;
import com.avito.android.lib.design.chips.Chipable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class a implements Chipable {
    @NotNull
    public final String a;

    public a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "chipTitle");
        this.a = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof a) && Intrinsics.areEqual(this.a, ((a) obj).a);
        }
        return true;
    }

    @Override // com.avito.android.lib.design.chips.Chipable
    public boolean equalsAsChipable(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "other");
        if (!(obj instanceof Chipable)) {
            return false;
        }
        boolean z = true;
        if (this.a.length() > 0) {
            Chipable chipable = (Chipable) obj;
            if (chipable.getChipTitle().length() <= 0) {
                z = false;
            }
            if (z) {
                return Intrinsics.areEqual(this.a, chipable.getChipTitle());
            }
        }
        return false;
    }

    @Override // com.avito.android.lib.design.chips.Chipable
    @NotNull
    public String getChipTitle() {
        return this.a;
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

    public int hashCode() {
        String str = this.a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return a2.b.a.a.a.t(a2.b.a.a.a.L("ChipableChip(chipTitle="), this.a, ")");
    }
}
