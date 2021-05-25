package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaMethodDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
import kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt;
import kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
public final class JavaIncompatibilityRulesOverridabilityCondition implements ExternalOverridabilityCondition {
    @NotNull
    public static final Companion Companion = new Companion(null);

    public static final class Companion {
        public Companion() {
        }

        public final JvmType a(FunctionDescriptor functionDescriptor, ValueParameterDescriptor valueParameterDescriptor) {
            if (!MethodSignatureMappingKt.forceSingleValueParameterBoxing(functionDescriptor)) {
                boolean z = true;
                boolean z2 = false;
                if (functionDescriptor.getValueParameters().size() == 1) {
                    DeclarationDescriptor containingDeclaration = functionDescriptor.getContainingDeclaration();
                    ClassDescriptor classDescriptor = null;
                    ClassDescriptor classDescriptor2 = containingDeclaration instanceof ClassDescriptor ? (ClassDescriptor) containingDeclaration : null;
                    if (classDescriptor2 != null) {
                        List<ValueParameterDescriptor> valueParameters = functionDescriptor.getValueParameters();
                        Intrinsics.checkNotNullExpressionValue(valueParameters, "f.valueParameters");
                        ClassifierDescriptor declarationDescriptor = ((ValueParameterDescriptor) CollectionsKt___CollectionsKt.single((List<? extends Object>) valueParameters)).getType().getConstructor().mo425getDeclarationDescriptor();
                        if (declarationDescriptor instanceof ClassDescriptor) {
                            classDescriptor = (ClassDescriptor) declarationDescriptor;
                        }
                        if (classDescriptor != null) {
                            if (!KotlinBuiltIns.isPrimitiveClass(classDescriptor2) || !Intrinsics.areEqual(DescriptorUtilsKt.getFqNameSafe(classDescriptor2), DescriptorUtilsKt.getFqNameSafe(classDescriptor))) {
                                z = false;
                            }
                            z2 = z;
                        }
                    }
                }
                if (!z2) {
                    KotlinType type = valueParameterDescriptor.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "valueParameterDescriptor.type");
                    return MethodSignatureMappingKt.mapToJvmType(type);
                }
            }
            KotlinType type2 = valueParameterDescriptor.getType();
            Intrinsics.checkNotNullExpressionValue(type2, "valueParameterDescriptor.type");
            return MethodSignatureMappingKt.mapToJvmType(TypeUtilsKt.makeNullable(type2));
        }

        public final boolean doesJavaOverrideHaveIncompatibleValueParameterKinds(@NotNull CallableDescriptor callableDescriptor, @NotNull CallableDescriptor callableDescriptor2) {
            Intrinsics.checkNotNullParameter(callableDescriptor, "superDescriptor");
            Intrinsics.checkNotNullParameter(callableDescriptor2, "subDescriptor");
            if ((callableDescriptor2 instanceof JavaMethodDescriptor) && (callableDescriptor instanceof FunctionDescriptor)) {
                JavaMethodDescriptor javaMethodDescriptor = (JavaMethodDescriptor) callableDescriptor2;
                javaMethodDescriptor.getValueParameters().size();
                FunctionDescriptor functionDescriptor = (FunctionDescriptor) callableDescriptor;
                functionDescriptor.getValueParameters().size();
                List<ValueParameterDescriptor> valueParameters = javaMethodDescriptor.getOriginal().getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters, "subDescriptor.original.valueParameters");
                List<ValueParameterDescriptor> valueParameters2 = functionDescriptor.getOriginal().getValueParameters();
                Intrinsics.checkNotNullExpressionValue(valueParameters2, "superDescriptor.original.valueParameters");
                for (Pair pair : CollectionsKt___CollectionsKt.zip(valueParameters, valueParameters2)) {
                    ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) pair.component1();
                    ValueParameterDescriptor valueParameterDescriptor2 = (ValueParameterDescriptor) pair.component2();
                    Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor, "subParameter");
                    boolean z = a((FunctionDescriptor) callableDescriptor2, valueParameterDescriptor) instanceof JvmType.Primitive;
                    Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor2, "superParameter");
                    if (z != (a(functionDescriptor, valueParameterDescriptor2) instanceof JvmType.Primitive)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public Companion(j jVar) {
        }
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @NotNull
    public ExternalOverridabilityCondition.Contract getContract() {
        return ExternalOverridabilityCondition.Contract.CONFLICTS_ONLY;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b2, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0, kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(r2, false, false, 2, null)) != false) goto L_0x00b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003c, code lost:
        if (r0.getSameAsRenamedInJvmBuiltin(r3) == false) goto L_0x00b4;
     */
    @Override // kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result isOverridable(@org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r8, @org.jetbrains.annotations.NotNull kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor r9, @org.jetbrains.annotations.Nullable kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r10) {
        /*
            r7 = this;
            java.lang.String r0 = "superDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "subDescriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            boolean r0 = r8 instanceof kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor
            r1 = 0
            if (r0 == 0) goto L_0x00b4
            boolean r0 = r9 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
            if (r0 == 0) goto L_0x00b4
            boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isBuiltIn(r9)
            if (r0 == 0) goto L_0x001b
            goto L_0x00b4
        L_0x001b:
            kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature r0 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.INSTANCE
            r2 = r9
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r2
            kotlin.reflect.jvm.internal.impl.name.Name r3 = r2.getName()
            java.lang.String r4 = "subDescriptor.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            boolean r0 = r0.getSameAsBuiltinMethodWithErasedValueParameters(r3)
            if (r0 != 0) goto L_0x0040
            kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName r0 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithDifferentJvmName.INSTANCE
            kotlin.reflect.jvm.internal.impl.name.Name r3 = r2.getName()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            boolean r0 = r0.getSameAsRenamedInJvmBuiltin(r3)
            if (r0 != 0) goto L_0x0040
            goto L_0x00b4
        L_0x0040:
            r0 = r8
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor) r0
            kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r0 = kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers.getOverriddenSpecialBuiltin(r0)
            boolean r3 = r2.isHiddenToOvercomeSignatureClash()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            boolean r4 = r8 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
            r5 = 0
            if (r4 == 0) goto L_0x0058
            r6 = r8
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r6 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r6
            goto L_0x0059
        L_0x0058:
            r6 = r5
        L_0x0059:
            if (r6 != 0) goto L_0x005d
            r6 = r5
            goto L_0x0065
        L_0x005d:
            boolean r6 = r6.isHiddenToOvercomeSignatureClash()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
        L_0x0065:
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r6)
            r6 = 1
            r3 = r3 ^ r6
            if (r3 == 0) goto L_0x0077
            if (r0 == 0) goto L_0x0075
            boolean r3 = r2.isHiddenToOvercomeSignatureClash()
            if (r3 != 0) goto L_0x0077
        L_0x0075:
            r1 = 1
            goto L_0x00b4
        L_0x0077:
            boolean r3 = r10 instanceof kotlin.reflect.jvm.internal.impl.load.java.descriptors.JavaClassDescriptor
            if (r3 == 0) goto L_0x00b4
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r3 = r2.getInitialSignatureDescriptor()
            if (r3 == 0) goto L_0x0082
            goto L_0x00b4
        L_0x0082:
            if (r0 == 0) goto L_0x00b4
            boolean r10 = kotlin.reflect.jvm.internal.impl.load.java.SpecialBuiltinMembers.hasRealKotlinSuperClassWithOverrideOf(r10, r0)
            if (r10 == 0) goto L_0x008b
            goto L_0x00b4
        L_0x008b:
            boolean r10 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor
            if (r10 == 0) goto L_0x0075
            if (r4 == 0) goto L_0x0075
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r0
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r10 = kotlin.reflect.jvm.internal.impl.load.java.BuiltinMethodsWithSpecialGenericSignature.getOverriddenBuiltinFunctionWithErasedValueParametersInJava(r0)
            if (r10 == 0) goto L_0x0075
            r10 = 2
            java.lang.String r0 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(r2, r1, r1, r10, r5)
            r2 = r8
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r2 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r2
            kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r2 = r2.getOriginal()
            java.lang.String r3 = "superDescriptor.original"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.String r10 = kotlin.reflect.jvm.internal.impl.load.kotlin.MethodSignatureMappingKt.computeJvmDescriptor$default(r2, r1, r1, r10, r5)
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r10)
            if (r10 == 0) goto L_0x0075
        L_0x00b4:
            if (r1 == 0) goto L_0x00b9
            kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition$Result r8 = kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.INCOMPATIBLE
            return r8
        L_0x00b9:
            kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition$Companion r10 = kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition.Companion
            boolean r8 = r10.doesJavaOverrideHaveIncompatibleValueParameterKinds(r8, r9)
            if (r8 == 0) goto L_0x00c4
            kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition$Result r8 = kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.INCOMPATIBLE
            return r8
        L_0x00c4:
            kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition$Result r8 = kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition.Result.UNKNOWN
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.JavaIncompatibilityRulesOverridabilityCondition.isOverridable(kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor):kotlin.reflect.jvm.internal.impl.resolve.ExternalOverridabilityCondition$Result");
    }
}
