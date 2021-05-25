package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class PossiblyInnerType {
    @NotNull
    public final ClassifierDescriptorWithTypeParameters a;
    @NotNull
    public final List<TypeProjection> b;
    @Nullable
    public final PossiblyInnerType c;

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends kotlin.reflect.jvm.internal.impl.types.TypeProjection> */
    /* JADX WARN: Multi-variable type inference failed */
    public PossiblyInnerType(@NotNull ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters, @NotNull List<? extends TypeProjection> list, @Nullable PossiblyInnerType possiblyInnerType) {
        Intrinsics.checkNotNullParameter(classifierDescriptorWithTypeParameters, "classifierDescriptor");
        Intrinsics.checkNotNullParameter(list, "arguments");
        this.a = classifierDescriptorWithTypeParameters;
        this.b = list;
        this.c = possiblyInnerType;
    }

    @NotNull
    public final List<TypeProjection> getArguments() {
        return this.b;
    }

    @NotNull
    public final ClassifierDescriptorWithTypeParameters getClassifierDescriptor() {
        return this.a;
    }

    @Nullable
    public final PossiblyInnerType getOuterType() {
        return this.c;
    }
}
