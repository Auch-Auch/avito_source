package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import a2.b.a.a.a;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
public final class NullabilityQualifierWithMigrationStatus {
    @NotNull
    public final NullabilityQualifier a;
    public final boolean b;

    public NullabilityQualifierWithMigrationStatus(@NotNull NullabilityQualifier nullabilityQualifier, boolean z) {
        Intrinsics.checkNotNullParameter(nullabilityQualifier, "qualifier");
        this.a = nullabilityQualifier;
        this.b = z;
    }

    public static /* synthetic */ NullabilityQualifierWithMigrationStatus copy$default(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, NullabilityQualifier nullabilityQualifier, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            nullabilityQualifier = nullabilityQualifierWithMigrationStatus.a;
        }
        if ((i & 2) != 0) {
            z = nullabilityQualifierWithMigrationStatus.b;
        }
        return nullabilityQualifierWithMigrationStatus.copy(nullabilityQualifier, z);
    }

    @NotNull
    public final NullabilityQualifierWithMigrationStatus copy(@NotNull NullabilityQualifier nullabilityQualifier, boolean z) {
        Intrinsics.checkNotNullParameter(nullabilityQualifier, "qualifier");
        return new NullabilityQualifierWithMigrationStatus(nullabilityQualifier, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NullabilityQualifierWithMigrationStatus)) {
            return false;
        }
        NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus = (NullabilityQualifierWithMigrationStatus) obj;
        return this.a == nullabilityQualifierWithMigrationStatus.a && this.b == nullabilityQualifierWithMigrationStatus.b;
    }

    @NotNull
    public final NullabilityQualifier getQualifier() {
        return this.a;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        boolean z = this.b;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return hashCode + i;
    }

    public final boolean isForWarningOnly() {
        return this.b;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("NullabilityQualifierWithMigrationStatus(qualifier=");
        L.append(this.a);
        L.append(", isForWarningOnly=");
        return a.A(L, this.b, ')');
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NullabilityQualifierWithMigrationStatus(NullabilityQualifier nullabilityQualifier, boolean z, int i, j jVar) {
        this(nullabilityQualifier, (i & 2) != 0 ? false : z);
    }
}
