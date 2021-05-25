package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.m;
public class JvmDescriptorTypeWriter<T> {
    public int a;
    @Nullable
    public T b;

    public void writeArrayEnd() {
    }

    public void writeArrayType() {
        if (this.b == null) {
            this.a++;
        }
    }

    public void writeClass(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, "objectType");
        writeJvmTypeAsIs(t);
    }

    public final void writeJvmTypeAsIs(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, "type");
        if (this.b == null) {
            int i = this.a;
            if (i <= 0) {
                this.b = t;
            } else {
                m.repeat("[", i);
                throw null;
            }
        }
    }

    public void writeTypeVariable(@NotNull Name name, @NotNull T t) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(t, "type");
        writeJvmTypeAsIs(t);
    }
}
