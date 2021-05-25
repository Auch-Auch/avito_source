package kotlin.reflect.jvm.internal.impl.load.java.descriptors;

import org.jetbrains.annotations.NotNull;
public final class NullDefaultValue extends AnnotationDefaultValue {
    @NotNull
    public static final NullDefaultValue INSTANCE = new NullDefaultValue();

    public NullDefaultValue() {
        super(null);
    }
}
