package com.avito.android.beduin.core.form;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0005\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/beduin/core/form/IsEnabledTransform;", "Lcom/avito/android/beduin/core/form/BeduinModelTransform;", "", "component1", "()Z", "isEnabled", "copy", "(Z)Lcom/avito/android/beduin/core/form/IsEnabledTransform;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Z", "<init>", "(Z)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class IsEnabledTransform implements BeduinModelTransform {
    public final boolean a;

    public IsEnabledTransform(boolean z) {
        this.a = z;
    }

    public static /* synthetic */ IsEnabledTransform copy$default(IsEnabledTransform isEnabledTransform, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = isEnabledTransform.a;
        }
        return isEnabledTransform.copy(z);
    }

    public final boolean component1() {
        return this.a;
    }

    @NotNull
    public final IsEnabledTransform copy(boolean z) {
        return new IsEnabledTransform(z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof IsEnabledTransform) && this.a == ((IsEnabledTransform) obj).a;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.a;
        if (z) {
            return 1;
        }
        return z ? 1 : 0;
    }

    public final boolean isEnabled() {
        return this.a;
    }

    @NotNull
    public String toString() {
        return a.B(a.L("IsEnabledTransform(isEnabled="), this.a, ")");
    }
}
