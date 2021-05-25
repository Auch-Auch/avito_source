package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.DocumentType;
public final class ProtoEnumFlagsUtilsKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = {1, 2, 3, 4};
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = {1, 2, 3, 4};
        public static final /* synthetic */ int[] $EnumSwitchMapping$2 = {1, 2, 4, 5, 3, 6};

        static {
            ProtoBuf.MemberKind.values();
            CallableMemberDescriptor.Kind.values();
            ProtoBuf.Visibility.values();
        }
    }

    @NotNull
    public static final DescriptorVisibility descriptorVisibility(@NotNull ProtoEnumFlags protoEnumFlags, @Nullable ProtoBuf.Visibility visibility) {
        Intrinsics.checkNotNullParameter(protoEnumFlags, "<this>");
        switch (visibility == null ? -1 : WhenMappings.$EnumSwitchMapping$2[visibility.ordinal()]) {
            case 1:
                DescriptorVisibility descriptorVisibility = DescriptorVisibilities.INTERNAL;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "INTERNAL");
                return descriptorVisibility;
            case 2:
                DescriptorVisibility descriptorVisibility2 = DescriptorVisibilities.PRIVATE;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility2, "PRIVATE");
                return descriptorVisibility2;
            case 3:
                DescriptorVisibility descriptorVisibility3 = DescriptorVisibilities.PRIVATE_TO_THIS;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility3, "PRIVATE_TO_THIS");
                return descriptorVisibility3;
            case 4:
                DescriptorVisibility descriptorVisibility4 = DescriptorVisibilities.PROTECTED;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility4, "PROTECTED");
                return descriptorVisibility4;
            case 5:
                DescriptorVisibility descriptorVisibility5 = DescriptorVisibilities.PUBLIC;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility5, DocumentType.PUBLIC_KEY);
                return descriptorVisibility5;
            case 6:
                DescriptorVisibility descriptorVisibility6 = DescriptorVisibilities.LOCAL;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility6, "LOCAL");
                return descriptorVisibility6;
            default:
                DescriptorVisibility descriptorVisibility7 = DescriptorVisibilities.PRIVATE;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility7, "PRIVATE");
                return descriptorVisibility7;
        }
    }

    @NotNull
    public static final CallableMemberDescriptor.Kind memberKind(@NotNull ProtoEnumFlags protoEnumFlags, @Nullable ProtoBuf.MemberKind memberKind) {
        Intrinsics.checkNotNullParameter(protoEnumFlags, "<this>");
        int i = memberKind == null ? -1 : WhenMappings.$EnumSwitchMapping$0[memberKind.ordinal()];
        if (i == 1) {
            return CallableMemberDescriptor.Kind.DECLARATION;
        }
        if (i == 2) {
            return CallableMemberDescriptor.Kind.FAKE_OVERRIDE;
        }
        if (i == 3) {
            return CallableMemberDescriptor.Kind.DELEGATION;
        }
        if (i != 4) {
            return CallableMemberDescriptor.Kind.DECLARATION;
        }
        return CallableMemberDescriptor.Kind.SYNTHESIZED;
    }
}
