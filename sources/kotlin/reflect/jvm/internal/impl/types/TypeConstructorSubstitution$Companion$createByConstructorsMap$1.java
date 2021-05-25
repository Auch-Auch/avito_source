package kotlin.reflect.jvm.internal.impl.types;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class TypeConstructorSubstitution$Companion$createByConstructorsMap$1 extends TypeConstructorSubstitution {
    public final /* synthetic */ Map<TypeConstructor, TypeProjection> a;
    public final /* synthetic */ boolean b;

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.util.Map<kotlin.reflect.jvm.internal.impl.types.TypeConstructor, ? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> */
    /* JADX WARN: Multi-variable type inference failed */
    public TypeConstructorSubstitution$Companion$createByConstructorsMap$1(Map<TypeConstructor, ? extends TypeProjection> map, boolean z) {
        this.a = map;
        this.b = z;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean approximateCapturedTypes() {
        return this.b;
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution
    @Nullable
    public TypeProjection get(@NotNull TypeConstructor typeConstructor) {
        Intrinsics.checkNotNullParameter(typeConstructor, "key");
        return this.a.get(typeConstructor);
    }

    @Override // kotlin.reflect.jvm.internal.impl.types.TypeSubstitution
    public boolean isEmpty() {
        return this.a.isEmpty();
    }
}
