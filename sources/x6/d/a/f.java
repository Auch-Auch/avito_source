package x6.d.a;

import a2.b.a.a.a;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.TypeDispKt;
public final class f extends j {
    public static final f a = new f();

    @Override // x6.d.a.j
    @NotNull
    public String a(@NotNull Class<?> cls, boolean z) {
        String str;
        String name;
        String c3;
        Intrinsics.checkParameterIsNotNull(cls, "cls");
        if (cls.isArray()) {
            StringBuilder L = a.L("kotlin.Array<");
            Class<?> componentType = cls.getComponentType();
            Intrinsics.checkExpressionValueIsNotNull(componentType, "cls.componentType");
            L.append(j.c(this, componentType, false, 2, null));
            L.append(">");
            return L.toString();
        }
        String access$getPrimitiveName$p = TypeDispKt.access$getPrimitiveName$p(cls);
        if (access$getPrimitiveName$p != null && (c3 = a.c3("kotlin.", access$getPrimitiveName$p)) != null) {
            return c3;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        Package r2 = cls.getPackage();
        String str2 = "";
        if (r2 == null || (name = r2.getName()) == null || (str = a.c3(name, ".")) == null) {
            str = str2;
        }
        sb2.append(str);
        sb2.append(h.a.a(cls, true));
        sb.append(TypeDispKt.a(sb2.toString()));
        if (!z) {
            str2 = TypeDispKt.access$getStars$p(cls);
        }
        sb.append(str2);
        return sb.toString();
    }
}
