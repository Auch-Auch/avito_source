package com.avito.android.vas_performance.ui.items.tabs;

import androidx.annotation.DrawableRes;
import com.avito.android.lib.design.chips.Chipable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\f\u001a\u00020\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\t\u001a\u0004\b\u0015\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/avito/android/vas_performance/ui/items/tabs/Tab;", "Lcom/avito/android/lib/design/chips/Chipable;", "", "other", "", "equalsAsChipable", "(Ljava/lang/Object;)Z", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getChipTitle", "()Ljava/lang/String;", "chipTitle", "c", "Z", "getSelected", "()Z", "setSelected", "(Z)V", "selected", AuthSource.BOOKING_ORDER, "getTitle", "title", "<init>", "(Ljava/lang/String;Z)V", "vas-performance_release"}, k = 1, mv = {1, 4, 2})
public final class Tab implements Chipable {
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    public boolean c;

    public Tab(@NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.b = str;
        this.c = z;
        this.a = str;
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
        return this.a;
    }

    @Override // com.avito.android.lib.design.chips.Chipable
    @DrawableRes
    @Nullable
    public Integer getImageRes() {
        return Chipable.DefaultImpls.getImageRes(this);
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

    public final boolean getSelected() {
        return this.c;
    }

    @NotNull
    public final String getTitle() {
        return this.b;
    }

    public final void setSelected(boolean z) {
        this.c = z;
    }
}
