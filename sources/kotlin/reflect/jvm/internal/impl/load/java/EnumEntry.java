package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import org.jetbrains.annotations.NotNull;
public final class EnumEntry extends JavaDefaultValue {
    @NotNull
    public final ClassDescriptor a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnumEntry(@NotNull ClassDescriptor classDescriptor) {
        super(null);
        Intrinsics.checkNotNullParameter(classDescriptor, "descriptor");
        this.a = classDescriptor;
    }
}
