package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Objects;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.SpecialGenericSignatures;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class BuiltinMethodsWithSpecialGenericSignature extends SpecialGenericSignatures {
    @NotNull
    public static final BuiltinMethodsWithSpecialGenericSignature INSTANCE = new BuiltinMethodsWithSpecialGenericSignature();

    public static final class a extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
        public final /* synthetic */ BuiltinMethodsWithSpecialGenericSignature a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature) {
            super(1);
            this.a = builtinMethodsWithSpecialGenericSignature;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            CallableMemberDescriptor callableMemberDescriptor2 = callableMemberDescriptor;
            Intrinsics.checkNotNullParameter(callableMemberDescriptor2, "it");
            return Boolean.valueOf(BuiltinMethodsWithSpecialGenericSignature.access$getHasErasedValueParametersInJava(this.a, callableMemberDescriptor2));
        }
    }

    public static final class b extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
        public final /* synthetic */ BuiltinMethodsWithSpecialGenericSignature a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature) {
            super(1);
            this.a = builtinMethodsWithSpecialGenericSignature;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
            CallableMemberDescriptor callableMemberDescriptor2 = callableMemberDescriptor;
            Intrinsics.checkNotNullParameter(callableMemberDescriptor2, "it");
            return Boolean.valueOf((callableMemberDescriptor2 instanceof FunctionDescriptor) && BuiltinMethodsWithSpecialGenericSignature.access$getHasErasedValueParametersInJava(this.a, callableMemberDescriptor2));
        }
    }

    public static final boolean access$getHasErasedValueParametersInJava(BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature, CallableMemberDescriptor callableMemberDescriptor) {
        Objects.requireNonNull(builtinMethodsWithSpecialGenericSignature);
        return CollectionsKt___CollectionsKt.contains(SpecialGenericSignatures.Companion.getERASED_VALUE_PARAMETERS_SIGNATURES(), MethodSignatureMappingKt.computeJvmSignature(callableMemberDescriptor));
    }

    @JvmStatic
    @Nullable
    public static final FunctionDescriptor getOverriddenBuiltinFunctionWithErasedValueParametersInJava(@NotNull FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        BuiltinMethodsWithSpecialGenericSignature builtinMethodsWithSpecialGenericSignature = INSTANCE;
        Name name = functionDescriptor.getName();
        Intrinsics.checkNotNullExpressionValue(name, "functionDescriptor.name");
        if (!builtinMethodsWithSpecialGenericSignature.getSameAsBuiltinMethodWithErasedValueParameters(name)) {
            return null;
        }
        return (FunctionDescriptor) DescriptorUtilsKt.firstOverridden$default(functionDescriptor, false, new a(builtinMethodsWithSpecialGenericSignature), 1, null);
    }

    @JvmStatic
    @Nullable
    public static final SpecialGenericSignatures.SpecialSignatureInfo getSpecialSignatureInfo(@NotNull CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "<this>");
        SpecialGenericSignatures.Companion companion = SpecialGenericSignatures.Companion;
        if (!companion.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains(callableMemberDescriptor.getName())) {
            return null;
        }
        CallableMemberDescriptor firstOverridden$default = DescriptorUtilsKt.firstOverridden$default(callableMemberDescriptor, false, new b(INSTANCE), 1, null);
        String computeJvmSignature = firstOverridden$default == null ? null : MethodSignatureMappingKt.computeJvmSignature(firstOverridden$default);
        if (computeJvmSignature == null) {
            return null;
        }
        return companion.getSpecialSignatureInfo(computeJvmSignature);
    }

    public final boolean getSameAsBuiltinMethodWithErasedValueParameters(@NotNull Name name) {
        Intrinsics.checkNotNullParameter(name, "<this>");
        return SpecialGenericSignatures.Companion.getERASED_VALUE_PARAMETERS_SHORT_NAMES().contains(name);
    }
}
