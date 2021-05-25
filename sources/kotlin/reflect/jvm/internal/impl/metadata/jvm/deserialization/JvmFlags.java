package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.reflect.jvm.internal.impl.metadata.deserialization.Flags;
import org.jetbrains.annotations.NotNull;
public final class JvmFlags {
    @NotNull
    public static final JvmFlags INSTANCE = new JvmFlags();
    public static final Flags.BooleanFlagField a = Flags.FlagField.booleanFirst();
    public static final Flags.BooleanFlagField b;

    static {
        Flags.BooleanFlagField booleanFirst = Flags.FlagField.booleanFirst();
        b = booleanFirst;
        Flags.FlagField.booleanAfter(booleanFirst);
    }

    public final Flags.BooleanFlagField getIS_MOVED_FROM_INTERFACE_COMPANION() {
        return a;
    }
}
