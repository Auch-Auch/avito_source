package x6.d.a;

import a2.b.a.a.a;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.TypeDispKt;
public final class h extends j {
    public static final h a = new h();

    @Override // x6.d.a.j
    @NotNull
    public String a(@NotNull Class<?> cls, boolean z) {
        Intrinsics.checkParameterIsNotNull(cls, "cls");
        if (cls.isArray()) {
            StringBuilder L = a.L("Array<");
            Class<?> componentType = cls.getComponentType();
            Intrinsics.checkExpressionValueIsNotNull(componentType, "cls.componentType");
            L.append(j.c(this, componentType, false, 2, null));
            L.append(">");
            return L.toString();
        }
        String access$getPrimitiveName$p = TypeDispKt.access$getPrimitiveName$p(cls);
        if (access$getPrimitiveName$p != null) {
            return access$getPrimitiveName$p;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(TypeDispKt.simpleErasedName(cls));
        sb.append(!z ? TypeDispKt.access$getStars$p(cls) : "");
        return sb.toString();
    }
}
