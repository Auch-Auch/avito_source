package kotlin.reflect.jvm.internal.impl.load.java;

import a2.b.a.a.a;
import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifierWithMigrationStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
public final class JavaDefaultQualifiers {
    @NotNull
    public final NullabilityQualifierWithMigrationStatus a;
    @NotNull
    public final Collection<AnnotationQualifierApplicabilityType> b;
    public final boolean c;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.Collection<? extends kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType> */
    /* JADX WARN: Multi-variable type inference failed */
    public JavaDefaultQualifiers(@NotNull NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, @NotNull Collection<? extends AnnotationQualifierApplicabilityType> collection, boolean z) {
        Intrinsics.checkNotNullParameter(nullabilityQualifierWithMigrationStatus, "nullabilityQualifier");
        Intrinsics.checkNotNullParameter(collection, "qualifierApplicabilityTypes");
        this.a = nullabilityQualifierWithMigrationStatus;
        this.b = collection;
        this.c = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: kotlin.reflect.jvm.internal.impl.load.java.JavaDefaultQualifiers */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JavaDefaultQualifiers copy$default(JavaDefaultQualifiers javaDefaultQualifiers, NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection collection, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            nullabilityQualifierWithMigrationStatus = javaDefaultQualifiers.a;
        }
        if ((i & 2) != 0) {
            collection = javaDefaultQualifiers.b;
        }
        if ((i & 4) != 0) {
            z = javaDefaultQualifiers.c;
        }
        return javaDefaultQualifiers.copy(nullabilityQualifierWithMigrationStatus, collection, z);
    }

    @NotNull
    public final JavaDefaultQualifiers copy(@NotNull NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, @NotNull Collection<? extends AnnotationQualifierApplicabilityType> collection, boolean z) {
        Intrinsics.checkNotNullParameter(nullabilityQualifierWithMigrationStatus, "nullabilityQualifier");
        Intrinsics.checkNotNullParameter(collection, "qualifierApplicabilityTypes");
        return new JavaDefaultQualifiers(nullabilityQualifierWithMigrationStatus, collection, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JavaDefaultQualifiers)) {
            return false;
        }
        JavaDefaultQualifiers javaDefaultQualifiers = (JavaDefaultQualifiers) obj;
        return Intrinsics.areEqual(this.a, javaDefaultQualifiers.a) && Intrinsics.areEqual(this.b, javaDefaultQualifiers.b) && this.c == javaDefaultQualifiers.c;
    }

    public final boolean getAffectsTypeParameterBasedTypes() {
        return this.c;
    }

    public final boolean getMakesTypeParameterNotNull() {
        return this.a.getQualifier() == NullabilityQualifier.NOT_NULL && this.c;
    }

    @NotNull
    public final NullabilityQualifierWithMigrationStatus getNullabilityQualifier() {
        return this.a;
    }

    @NotNull
    public final Collection<AnnotationQualifierApplicabilityType> getQualifierApplicabilityTypes() {
        return this.b;
    }

    public int hashCode() {
        int hashCode = (this.b.hashCode() + (this.a.hashCode() * 31)) * 31;
        boolean z = this.c;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("JavaDefaultQualifiers(nullabilityQualifier=");
        L.append(this.a);
        L.append(", qualifierApplicabilityTypes=");
        L.append(this.b);
        L.append(", affectsTypeParameterBasedTypes=");
        return a.A(L, this.c, ')');
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JavaDefaultQualifiers(NullabilityQualifierWithMigrationStatus nullabilityQualifierWithMigrationStatus, Collection collection, boolean z, int i, j jVar) {
        this(nullabilityQualifierWithMigrationStatus, collection, (i & 4) != 0 ? nullabilityQualifierWithMigrationStatus.getQualifier() == NullabilityQualifier.NOT_NULL : z);
    }
}
