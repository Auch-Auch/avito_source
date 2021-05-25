package kotlin.reflect.jvm.internal.impl.types;

import com.avito.android.analytics.screens.InternalConstsKt;
import com.vk.sdk.api.VKApiConst;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
public final class DisjointKeysUnionTypeSubstitution extends TypeSubstitution {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final TypeSubstitution a;
    @NotNull
    public final TypeSubstitution b;

    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        @NotNull
        public final TypeSubstitution create(@NotNull TypeSubstitution typeSubstitution, @NotNull TypeSubstitution typeSubstitution2) {
            Intrinsics.checkNotNullParameter(typeSubstitution, InternalConstsKt.FIRST_IMAGE);
            Intrinsics.checkNotNullParameter(typeSubstitution2, "second");
            if (typeSubstitution.isEmpty()) {
                return typeSubstitution2;
            }
            if (typeSubstitution2.isEmpty()) {
                return typeSubstitution;
            }
            return new DisjointKeysUnionTypeSubstitution(typeSubstitution, typeSubstitution2, null);
        }

        public Companion(j jVar) {
        }
    }

    public DisjointKeysUnionTypeSubstitution(TypeSubstitution typeSubstitution, TypeSubstitution typeSubstitution2, j jVar) {
        this.a = typeSubstitution;
        this.b = typeSubstitution2;
    }

    @JvmStatic
    @NotNull
    public static final TypeSubstitution create(@NotNull TypeSubstitution typeSubstitution, @NotNull TypeSubstitution typeSubstitution2) {
        return Companion.create(typeSubstitution, typeSubstitution2);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateCapturedTypes() {
        return this.a.approximateCapturedTypes() || this.b.approximateCapturedTypes();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateContravariantCapturedTypes() {
        return this.a.approximateContravariantCapturedTypes() || this.b.approximateContravariantCapturedTypes();
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    @NotNull
    public Annotations filterAnnotations(@NotNull Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        return this.b.filterAnnotations(this.a.filterAnnotations(annotations));
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    @Nullable
    public TypeProjection get(@NotNull KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "key");
        TypeProjection typeProjection = this.a.get(kotlinType);
        return typeProjection == null ? this.b.get(kotlinType) : typeProjection;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return false;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    @NotNull
    public KotlinType prepareTopLevelType(@NotNull KotlinType kotlinType, @NotNull Variance variance) {
        Intrinsics.checkNotNullParameter(kotlinType, "topLevelType");
        Intrinsics.checkNotNullParameter(variance, VKApiConst.POSITION);
        return this.b.prepareTopLevelType(this.a.prepareTopLevelType(kotlinType, variance), variance);
    }
}
