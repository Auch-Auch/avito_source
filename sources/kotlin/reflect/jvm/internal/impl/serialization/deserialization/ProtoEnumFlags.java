package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassKind;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class ProtoEnumFlags {
    @NotNull
    public static final ProtoEnumFlags INSTANCE = new ProtoEnumFlags();

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = {1, 2, 3, 4};
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = {1, 4, 2, 3};
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = {1, 2, 4, 5, 3, 6};
        public static final /* synthetic */ int[] $EnumSwitchMapping$3 = {1, 2, 3, 4, 5, 6, 7};
        public static final /* synthetic */ int[] $EnumSwitchMapping$4 = {1, 2, 3, 4, 5, 6};
        public static final /* synthetic */ int[] $EnumSwitchMapping$5 = {1, 2, 3};
        public static final /* synthetic */ int[] $EnumSwitchMapping$6 = {1, 2, 3, 4};
        public static final /* synthetic */ int[] $EnumSwitchMapping$7 = {3, 1, 2};

        static {
            ProtoBuf.Modality.values();
            Modality.values();
            Modality modality = Modality.FINAL;
            Modality modality2 = Modality.OPEN;
            Modality modality3 = Modality.ABSTRACT;
            Modality modality4 = Modality.SEALED;
            ProtoBuf.Visibility.values();
            ProtoBuf.Class.Kind.values();
            ClassKind.values();
            ProtoBuf.TypeParameter.Variance.values();
            ProtoBuf.Type.Argument.Projection.values();
            Variance.values();
        }
    }

    @NotNull
    public final ClassKind classKind(@Nullable ProtoBuf.Class.Kind kind) {
        switch (kind == null ? -1 : WhenMappings.$EnumSwitchMapping$3[kind.ordinal()]) {
            case 1:
                return ClassKind.CLASS;
            case 2:
                return ClassKind.INTERFACE;
            case 3:
                return ClassKind.ENUM_CLASS;
            case 4:
                return ClassKind.ENUM_ENTRY;
            case 5:
                return ClassKind.ANNOTATION_CLASS;
            case 6:
            case 7:
                return ClassKind.OBJECT;
            default:
                return ClassKind.CLASS;
        }
    }

    @NotNull
    public final Modality modality(@Nullable ProtoBuf.Modality modality) {
        int i = modality == null ? -1 : WhenMappings.$EnumSwitchMapping$0[modality.ordinal()];
        if (i == 1) {
            return Modality.FINAL;
        }
        if (i == 2) {
            return Modality.OPEN;
        }
        if (i == 3) {
            return Modality.ABSTRACT;
        }
        if (i != 4) {
            return Modality.FINAL;
        }
        return Modality.SEALED;
    }

    @NotNull
    public final Variance variance(@NotNull ProtoBuf.TypeParameter.Variance variance) {
        Intrinsics.checkNotNullParameter(variance, "variance");
        int ordinal = variance.ordinal();
        if (ordinal == 0) {
            return Variance.IN_VARIANCE;
        }
        if (ordinal == 1) {
            return Variance.OUT_VARIANCE;
        }
        if (ordinal == 2) {
            return Variance.INVARIANT;
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public final Variance variance(@NotNull ProtoBuf.Type.Argument.Projection projection) {
        Intrinsics.checkNotNullParameter(projection, "projection");
        int ordinal = projection.ordinal();
        if (ordinal == 0) {
            return Variance.IN_VARIANCE;
        }
        if (ordinal == 1) {
            return Variance.OUT_VARIANCE;
        }
        if (ordinal == 2) {
            return Variance.INVARIANT;
        }
        if (ordinal != 3) {
            throw new NoWhenBranchMatchedException();
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("Only IN, OUT and INV are supported. Actual argument: ", projection));
    }
}
