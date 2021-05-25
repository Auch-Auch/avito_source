package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class BuiltinMethodsWithDifferentJvmName extends SpecialGenericSignatures {
    @NotNull
    public static final BuiltinMethodsWithDifferentJvmName INSTANCE = new BuiltinMethodsWithDifferentJvmName();

    public static final class a extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
        public final /* synthetic */ SimpleFunctionDescriptor a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SimpleFunctionDescriptor simpleFunctionDescriptor) {
            super(1);
            this.a = simpleFunctionDescriptor;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            Intrinsics.checkNotNullParameter(callableMemberDescriptor, "it");
            Map<String, Name> signature_to_jvm_representation_name = SpecialGenericSignatures.Companion.getSIGNATURE_TO_JVM_REPRESENTATION_NAME();
            String computeJvmSignature = MethodSignatureMappingKt.computeJvmSignature(this.a);
            Objects.requireNonNull(signature_to_jvm_representation_name, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
            return Boolean.valueOf(signature_to_jvm_representation_name.containsKey(computeJvmSignature));
        }
    }

    @NotNull
    public final List<Name> getBuiltinFunctionNamesByJvmName(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        List<Name> list = SpecialGenericSignatures.Companion.getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP().get(name);
        return list == null ? CollectionsKt__CollectionsKt.emptyList() : list;
    }

    @Nullable
    public final Name getJvmName(@NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics.checkNotNullParameter(simpleFunctionDescriptor, "functionDescriptor");
        Map<String, Name> signature_to_jvm_representation_name = SpecialGenericSignatures.Companion.getSIGNATURE_TO_JVM_REPRESENTATION_NAME();
        String computeJvmSignature = MethodSignatureMappingKt.computeJvmSignature(simpleFunctionDescriptor);
        if (computeJvmSignature == null) {
            return null;
        }
        return signature_to_jvm_representation_name.get(computeJvmSignature);
    }

    public final boolean getSameAsRenamedInJvmBuiltin(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "<this>");
        return SpecialGenericSignatures.Companion.getORIGINAL_SHORT_NAMES().contains(name);
    }

    public final boolean isBuiltinFunctionWithDifferentNameInJvm(@NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics.checkNotNullParameter(simpleFunctionDescriptor, "functionDescriptor");
        return KotlinBuiltIns.isBuiltIn(simpleFunctionDescriptor) && DescriptorUtilsKt.firstOverridden$default(simpleFunctionDescriptor, false, new a(simpleFunctionDescriptor), 1, null) != null;
    }

    public final boolean isRemoveAtByIndex(@NotNull SimpleFunctionDescriptor simpleFunctionDescriptor) {
        Intrinsics.checkNotNullParameter(simpleFunctionDescriptor, "<this>");
        return Intrinsics.areEqual(simpleFunctionDescriptor.getName().asString(), "removeAt") && Intrinsics.areEqual(MethodSignatureMappingKt.computeJvmSignature(simpleFunctionDescriptor), SpecialGenericSignatures.Companion.getREMOVE_AT_NAME_AND_SIGNATURE().getSignature());
    }
}
