package t6.w.f.a.m.c.a.d;

import a2.b.a.a.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class c<T> {
    public final T a;
    @Nullable
    public final Annotations b;

    public c(T t, @Nullable Annotations annotations) {
        this.a = t;
        this.b = annotations;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return Intrinsics.areEqual(this.a, cVar.a) && Intrinsics.areEqual(this.b, cVar.b);
    }

    public int hashCode() {
        T t = this.a;
        int i = 0;
        int hashCode = (t == null ? 0 : t.hashCode()) * 31;
        Annotations annotations = this.b;
        if (annotations != null) {
            i = annotations.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("EnhancementResult(result=");
        L.append((Object) this.a);
        L.append(", enhancementAnnotations=");
        L.append(this.b);
        L.append(')');
        return L.toString();
    }
}
