package t6.w.f.a;

import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class k {
    @NotNull
    public final WeakReference<ClassLoader> a;
    public final int b;

    public k(@NotNull ClassLoader classLoader) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        this.a = new WeakReference<>(classLoader);
        this.b = System.identityHashCode(classLoader);
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof k) && this.a.get() == ((k) obj).a.get();
    }

    public int hashCode() {
        return this.b;
    }

    @NotNull
    public String toString() {
        String classLoader;
        ClassLoader classLoader2 = this.a.get();
        return (classLoader2 == null || (classLoader = classLoader2.toString()) == null) ? "<null>" : classLoader;
    }
}
