package com.avito.android.user_advert.advert.verification;

import a2.b.a.a.a;
import a2.g.r.g;
import androidx.annotation.StringRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.VerificationStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u001a\b\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0005\u0012\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b1\u00102J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJX\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0003\u0010\u0011\u001a\u00020\u00052\b\b\u0003\u0010\u0012\u001a\u00020\u00052\n\b\u0003\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u000b2\b\b\u0002\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0016\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0007J\u001a\u0010\u001e\u001a\u00020\u000b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0014\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\rR\u0019\u0010\u0016\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010!\u001a\u0004\b\u0016\u0010\rR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\nR\u0019\u0010\u0011\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\u0007R\u0019\u0010\u0015\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010!\u001a\u0004\b+\u0010\rR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010\u0004R\u0019\u0010\u0012\u001a\u00020\u00058\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010(\u001a\u0004\b0\u0010\u0007¨\u00063"}, d2 = {"Lcom/avito/android/user_advert/advert/verification/VerificationBlockItem;", "", "Lcom/avito/android/remote/model/VerificationStatus;", "component1", "()Lcom/avito/android/remote/model/VerificationStatus;", "", "component2", "()I", "component3", "component4", "()Ljava/lang/Integer;", "", "component5", "()Z", "component6", "component7", "status", "titleId", "descriptionId", "buttonTitleId", "hasAdditionalDescription", "hasBadge", "isSupportNeeded", "copy", "(Lcom/avito/android/remote/model/VerificationStatus;IILjava/lang/Integer;ZZZ)Lcom/avito/android/user_advert/advert/verification/VerificationBlockItem;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "e", "Z", "getHasAdditionalDescription", g.a, "d", "Ljava/lang/Integer;", "getButtonTitleId", AuthSource.BOOKING_ORDER, "I", "getTitleId", "f", "getHasBadge", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/VerificationStatus;", "getStatus", "c", "getDescriptionId", "<init>", "(Lcom/avito/android/remote/model/VerificationStatus;IILjava/lang/Integer;ZZZ)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationBlockItem {
    @NotNull
    public final VerificationStatus a;
    public final int b;
    public final int c;
    @Nullable
    public final Integer d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    public VerificationBlockItem(@NotNull VerificationStatus verificationStatus, @StringRes int i, @StringRes int i2, @StringRes @Nullable Integer num, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(verificationStatus, "status");
        this.a = verificationStatus;
        this.b = i;
        this.c = i2;
        this.d = num;
        this.e = z;
        this.f = z2;
        this.g = z3;
    }

    public static /* synthetic */ VerificationBlockItem copy$default(VerificationBlockItem verificationBlockItem, VerificationStatus verificationStatus, int i, int i2, Integer num, boolean z, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            verificationStatus = verificationBlockItem.a;
        }
        if ((i3 & 2) != 0) {
            i = verificationBlockItem.b;
        }
        if ((i3 & 4) != 0) {
            i2 = verificationBlockItem.c;
        }
        if ((i3 & 8) != 0) {
            num = verificationBlockItem.d;
        }
        if ((i3 & 16) != 0) {
            z = verificationBlockItem.e;
        }
        if ((i3 & 32) != 0) {
            z2 = verificationBlockItem.f;
        }
        if ((i3 & 64) != 0) {
            z3 = verificationBlockItem.g;
        }
        return verificationBlockItem.copy(verificationStatus, i, i2, num, z, z2, z3);
    }

    @NotNull
    public final VerificationStatus component1() {
        return this.a;
    }

    public final int component2() {
        return this.b;
    }

    public final int component3() {
        return this.c;
    }

    @Nullable
    public final Integer component4() {
        return this.d;
    }

    public final boolean component5() {
        return this.e;
    }

    public final boolean component6() {
        return this.f;
    }

    public final boolean component7() {
        return this.g;
    }

    @NotNull
    public final VerificationBlockItem copy(@NotNull VerificationStatus verificationStatus, @StringRes int i, @StringRes int i2, @StringRes @Nullable Integer num, boolean z, boolean z2, boolean z3) {
        Intrinsics.checkNotNullParameter(verificationStatus, "status");
        return new VerificationBlockItem(verificationStatus, i, i2, num, z, z2, z3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VerificationBlockItem)) {
            return false;
        }
        VerificationBlockItem verificationBlockItem = (VerificationBlockItem) obj;
        return Intrinsics.areEqual(this.a, verificationBlockItem.a) && this.b == verificationBlockItem.b && this.c == verificationBlockItem.c && Intrinsics.areEqual(this.d, verificationBlockItem.d) && this.e == verificationBlockItem.e && this.f == verificationBlockItem.f && this.g == verificationBlockItem.g;
    }

    @Nullable
    public final Integer getButtonTitleId() {
        return this.d;
    }

    public final int getDescriptionId() {
        return this.c;
    }

    public final boolean getHasAdditionalDescription() {
        return this.e;
    }

    public final boolean getHasBadge() {
        return this.f;
    }

    @NotNull
    public final VerificationStatus getStatus() {
        return this.a;
    }

    public final int getTitleId() {
        return this.b;
    }

    public int hashCode() {
        VerificationStatus verificationStatus = this.a;
        int i = 0;
        int hashCode = (((((verificationStatus != null ? verificationStatus.hashCode() : 0) * 31) + this.b) * 31) + this.c) * 31;
        Integer num = this.d;
        if (num != null) {
            i = num.hashCode();
        }
        int i2 = (hashCode + i) * 31;
        boolean z = this.e;
        int i3 = 1;
        if (z) {
            z = true;
        }
        int i4 = z ? 1 : 0;
        int i5 = z ? 1 : 0;
        int i6 = z ? 1 : 0;
        int i7 = (i2 + i4) * 31;
        boolean z2 = this.f;
        if (z2) {
            z2 = true;
        }
        int i8 = z2 ? 1 : 0;
        int i9 = z2 ? 1 : 0;
        int i10 = z2 ? 1 : 0;
        int i11 = (i7 + i8) * 31;
        boolean z3 = this.g;
        if (!z3) {
            i3 = z3 ? 1 : 0;
        }
        return i11 + i3;
    }

    public final boolean isSupportNeeded() {
        return this.g;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("VerificationBlockItem(status=");
        L.append(this.a);
        L.append(", titleId=");
        L.append(this.b);
        L.append(", descriptionId=");
        L.append(this.c);
        L.append(", buttonTitleId=");
        L.append(this.d);
        L.append(", hasAdditionalDescription=");
        L.append(this.e);
        L.append(", hasBadge=");
        L.append(this.f);
        L.append(", isSupportNeeded=");
        return a.B(L, this.g, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VerificationBlockItem(VerificationStatus verificationStatus, int i, int i2, Integer num, boolean z, boolean z2, boolean z3, int i3, j jVar) {
        this(verificationStatus, i, i2, (i3 & 8) != 0 ? null : num, (i3 & 16) != 0 ? false : z, (i3 & 32) != 0 ? false : z2, (i3 & 64) != 0 ? false : z3);
    }
}
