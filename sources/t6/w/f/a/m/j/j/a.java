package t6.w.f.a.m.j.j;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class a {
    @NotNull
    public final KotlinType a;
    @Nullable
    public final a b;

    public a(@NotNull KotlinType kotlinType, @Nullable a aVar) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        this.a = kotlinType;
        this.b = aVar;
    }
}
