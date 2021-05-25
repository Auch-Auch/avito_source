package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class ModuleCapability<T> {
    @NotNull
    public final String a;

    public ModuleCapability(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.a = str;
    }

    @NotNull
    public String toString() {
        return this.a;
    }
}
