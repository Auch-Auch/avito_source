package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
public final class JavaTypeQualifiers {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final JavaTypeQualifiers e = new JavaTypeQualifiers(null, null, false, false, 8, null);
    @Nullable
    public final NullabilityQualifier a;
    @Nullable
    public final MutabilityQualifier b;
    public final boolean c;
    public final boolean d;

    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final JavaTypeQualifiers getNONE() {
            return JavaTypeQualifiers.e;
        }

        public Companion(j jVar) {
        }
    }

    public JavaTypeQualifiers(@Nullable NullabilityQualifier nullabilityQualifier, @Nullable MutabilityQualifier mutabilityQualifier, boolean z, boolean z2) {
        this.a = nullabilityQualifier;
        this.b = mutabilityQualifier;
        this.c = z;
        this.d = z2;
    }

    @Nullable
    public final MutabilityQualifier getMutability() {
        return this.b;
    }

    @Nullable
    public final NullabilityQualifier getNullability() {
        return this.a;
    }

    public final boolean isNotNullTypeParameter() {
        return this.c;
    }

    public final boolean isNullabilityQualifierForWarning() {
        return this.d;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JavaTypeQualifiers(NullabilityQualifier nullabilityQualifier, MutabilityQualifier mutabilityQualifier, boolean z, boolean z2, int i, j jVar) {
        this(nullabilityQualifier, mutabilityQualifier, z, (i & 8) != 0 ? false : z2);
    }
}
