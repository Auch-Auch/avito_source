package kotlin.reflect.jvm.internal.impl.types;

import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import org.jetbrains.annotations.NotNull;
import t6.c;
public final class StarProjectionImpl extends TypeProjectionBase {
    @NotNull
    public final TypeParameterDescriptor a;
    @NotNull
    public final Lazy b = c.lazy(LazyThreadSafetyMode.PUBLICATION, (Function0) new a(this));

    public static final class a extends Lambda implements Function0<KotlinType> {
        public final /* synthetic */ StarProjectionImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(StarProjectionImpl starProjectionImpl) {
            super(0);
            this.a = starProjectionImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public KotlinType invoke() {
            return StarProjectionImplKt.starProjectionType(this.a.a);
        }
    }

    public StarProjectionImpl(@NotNull TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        this.a = typeParameterDescriptor;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    @NotNull
    public Variance getProjectionKind() {
        return Variance.OUT_VARIANCE;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    @NotNull
    public KotlinType getType() {
        return (KotlinType) this.b.getValue();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    public boolean isStarProjection() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeProjection
    @NotNull
    public TypeProjection refine(@NotNull KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }
}
