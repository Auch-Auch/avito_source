package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class StringDefaultValue extends AnnotationDefaultValue {
    @NotNull
    public final String a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StringDefaultValue(@NotNull String str) {
        super(null);
        Intrinsics.checkNotNullParameter(str, "value");
        this.a = str;
    }

    @NotNull
    public final String getValue() {
        return this.a;
    }
}
