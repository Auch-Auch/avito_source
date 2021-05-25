package com.avito.android.booking.order;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\f\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0007R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\b\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/avito/android/booking/order/ValidationResult;", "", "", "component1", "()Z", "", "component2", "()Ljava/lang/String;", "isValid", "errorMessage", "copy", "(ZLjava/lang/String;)Lcom/avito/android/booking/order/ValidationResult;", "toString", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "getErrorMessage", AuthSource.SEND_ABUSE, "Z", "<init>", "(ZLjava/lang/String;)V", "booking_release"}, k = 1, mv = {1, 4, 2})
public final class ValidationResult {
    public final boolean a;
    @Nullable
    public final String b;

    public ValidationResult(boolean z, @Nullable String str) {
        this.a = z;
        this.b = str;
    }

    public static /* synthetic */ ValidationResult copy$default(ValidationResult validationResult, boolean z, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = validationResult.a;
        }
        if ((i & 2) != 0) {
            str = validationResult.b;
        }
        return validationResult.copy(z, str);
    }

    public final boolean component1() {
        return this.a;
    }

    @Nullable
    public final String component2() {
        return this.b;
    }

    @NotNull
    public final ValidationResult copy(boolean z, @Nullable String str) {
        return new ValidationResult(z, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ValidationResult)) {
            return false;
        }
        ValidationResult validationResult = (ValidationResult) obj;
        return this.a == validationResult.a && Intrinsics.areEqual(this.b, validationResult.b);
    }

    @Nullable
    public final String getErrorMessage() {
        return this.b;
    }

    public int hashCode() {
        boolean z = this.a;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = i * 31;
        String str = this.b;
        return i4 + (str != null ? str.hashCode() : 0);
    }

    public final boolean isValid() {
        return this.a;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("ValidationResult(isValid=");
        L.append(this.a);
        L.append(", errorMessage=");
        return a.t(L, this.b, ")");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ValidationResult(boolean z, String str, int i, j jVar) {
        this(z, (i & 2) != 0 ? null : str);
    }
}
