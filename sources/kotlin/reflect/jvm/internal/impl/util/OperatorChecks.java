package kotlin.reflect.jvm.internal.impl.util;

import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ReceiverParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.MemberKindCheck;
import kotlin.reflect.jvm.internal.impl.util.ReturnsCheck;
import kotlin.reflect.jvm.internal.impl.util.ValueParameterCountCheck;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
public final class OperatorChecks extends AbstractModifierChecks {
    @NotNull
    public static final OperatorChecks INSTANCE = new OperatorChecks();
    @NotNull
    public static final List<Checks> a;

    public static final class a extends Lambda implements Function1<FunctionDescriptor, String> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public String invoke(FunctionDescriptor functionDescriptor) {
            Boolean bool;
            FunctionDescriptor functionDescriptor2 = functionDescriptor;
            Intrinsics.checkNotNullParameter(functionDescriptor2, "<this>");
            List<ValueParameterDescriptor> valueParameters = functionDescriptor2.getValueParameters();
            Intrinsics.checkNotNullExpressionValue(valueParameters, "valueParameters");
            ValueParameterDescriptor valueParameterDescriptor = (ValueParameterDescriptor) CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) valueParameters);
            if (valueParameterDescriptor == null) {
                bool = null;
            } else {
                bool = Boolean.valueOf(!DescriptorUtilsKt.declaresOrInheritsDefaultValue(valueParameterDescriptor) && valueParameterDescriptor.getVarargElementType() == null);
            }
            boolean areEqual = Intrinsics.areEqual(bool, Boolean.TRUE);
            OperatorChecks operatorChecks = OperatorChecks.INSTANCE;
            if (!areEqual) {
                return "last parameter should not have a default value or be a vararg";
            }
            return null;
        }
    }

    public static final class b extends Lambda implements Function1<FunctionDescriptor, String> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0062, code lost:
            if (r5 != false) goto L_0x0064;
         */
        @Override // kotlin.jvm.functions.Function1
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String invoke(kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r5) {
            /*
                r4 = this;
                kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r5 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r5
                java.lang.String r0 = "<this>"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                kotlin.reflect.jvm.internal.impl.util.OperatorChecks r0 = kotlin.reflect.jvm.internal.impl.util.OperatorChecks.INSTANCE
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = r5.getContainingDeclaration()
                java.lang.String r1 = "containingDeclaration"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L_0x0022
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
                boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isAny(r0)
                if (r0 == 0) goto L_0x0022
                r0 = 1
                goto L_0x0023
            L_0x0022:
                r0 = 0
            L_0x0023:
                if (r0 != 0) goto L_0x0064
                java.util.Collection r5 = r5.getOverriddenDescriptors()
                java.lang.String r0 = "overriddenDescriptors"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
                boolean r0 = r5.isEmpty()
                if (r0 == 0) goto L_0x0035
                goto L_0x0061
            L_0x0035:
                java.util.Iterator r5 = r5.iterator()
            L_0x0039:
                boolean r0 = r5.hasNext()
                if (r0 == 0) goto L_0x0061
                java.lang.Object r0 = r5.next()
                kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor) r0
                kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor r0 = r0.getContainingDeclaration()
                java.lang.String r1 = "it.containingDeclaration"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
                boolean r1 = r0 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
                if (r1 == 0) goto L_0x005c
                kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r0
                boolean r0 = kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns.isAny(r0)
                if (r0 == 0) goto L_0x005c
                r0 = 1
                goto L_0x005d
            L_0x005c:
                r0 = 0
            L_0x005d:
                if (r0 == 0) goto L_0x0039
                r5 = 1
                goto L_0x0062
            L_0x0061:
                r5 = 0
            L_0x0062:
                if (r5 == 0) goto L_0x0065
            L_0x0064:
                r2 = 1
            L_0x0065:
                if (r2 != 0) goto L_0x006a
                java.lang.String r5 = "must override ''equals()'' in Any"
                goto L_0x006b
            L_0x006a:
                r5 = 0
            L_0x006b:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.OperatorChecks.b.invoke(java.lang.Object):java.lang.Object");
        }
    }

    public static final class c extends Lambda implements Function1<FunctionDescriptor, String> {
        public static final c a = new c();

        public c() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public String invoke(FunctionDescriptor functionDescriptor) {
            boolean z;
            FunctionDescriptor functionDescriptor2 = functionDescriptor;
            Intrinsics.checkNotNullParameter(functionDescriptor2, "<this>");
            ReceiverParameterDescriptor dispatchReceiverParameter = functionDescriptor2.getDispatchReceiverParameter();
            if (dispatchReceiverParameter == null) {
                dispatchReceiverParameter = functionDescriptor2.getExtensionReceiverParameter();
            }
            OperatorChecks operatorChecks = OperatorChecks.INSTANCE;
            boolean z2 = false;
            if (dispatchReceiverParameter != null) {
                KotlinType returnType = functionDescriptor2.getReturnType();
                if (returnType == null) {
                    z = false;
                } else {
                    KotlinType type = dispatchReceiverParameter.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "receiver.type");
                    z = TypeUtilsKt.isSubtypeOf(returnType, type);
                }
                if (z) {
                    z2 = true;
                }
            }
            if (!z2) {
                return "receiver must be a supertype of the return type";
            }
            return null;
        }
    }

    static {
        Name name = OperatorNameConventions.GET;
        MemberKindCheck.MemberOrExtension memberOrExtension = MemberKindCheck.MemberOrExtension.INSTANCE;
        Check[] checkArr = {memberOrExtension, new ValueParameterCountCheck.AtLeast(1)};
        Name name2 = OperatorNameConventions.SET;
        Check[] checkArr2 = {memberOrExtension, new ValueParameterCountCheck.AtLeast(2)};
        Name name3 = OperatorNameConventions.GET_VALUE;
        t6.w.f.a.m.k.b bVar = t6.w.f.a.m.k.b.a;
        t6.w.f.a.m.k.a aVar = t6.w.f.a.m.k.a.a;
        Name name4 = OperatorNameConventions.CONTAINS;
        ValueParameterCountCheck.SingleValueParameter singleValueParameter = ValueParameterCountCheck.SingleValueParameter.INSTANCE;
        ReturnsCheck.ReturnsBoolean returnsBoolean = ReturnsCheck.ReturnsBoolean.INSTANCE;
        Name name5 = OperatorNameConventions.ITERATOR;
        ValueParameterCountCheck.NoValueParameters noValueParameters = ValueParameterCountCheck.NoValueParameters.INSTANCE;
        a = CollectionsKt__CollectionsKt.listOf((Object[]) new Checks[]{new Checks(name, checkArr, (Function1) null, 4, (j) null), new Checks(name2, checkArr2, a.a), new Checks(name3, new Check[]{memberOrExtension, bVar, new ValueParameterCountCheck.AtLeast(2), aVar}, (Function1) null, 4, (j) null), new Checks(OperatorNameConventions.SET_VALUE, new Check[]{memberOrExtension, bVar, new ValueParameterCountCheck.AtLeast(3), aVar}, (Function1) null, 4, (j) null), new Checks(OperatorNameConventions.PROVIDE_DELEGATE, new Check[]{memberOrExtension, bVar, new ValueParameterCountCheck.Equals(2), aVar}, (Function1) null, 4, (j) null), new Checks(OperatorNameConventions.INVOKE, new Check[]{memberOrExtension}, (Function1) null, 4, (j) null), new Checks(name4, new Check[]{memberOrExtension, singleValueParameter, bVar, returnsBoolean}, (Function1) null, 4, (j) null), new Checks(name5, new Check[]{memberOrExtension, noValueParameters}, (Function1) null, 4, (j) null), new Checks(OperatorNameConventions.NEXT, new Check[]{memberOrExtension, noValueParameters}, (Function1) null, 4, (j) null), new Checks(OperatorNameConventions.HAS_NEXT, new Check[]{memberOrExtension, noValueParameters, returnsBoolean}, (Function1) null, 4, (j) null), new Checks(OperatorNameConventions.RANGE_TO, new Check[]{memberOrExtension, singleValueParameter, bVar}, (Function1) null, 4, (j) null), new Checks(OperatorNameConventions.EQUALS, new Check[]{MemberKindCheck.Member.INSTANCE}, b.a), new Checks(OperatorNameConventions.COMPARE_TO, new Check[]{memberOrExtension, ReturnsCheck.ReturnsInt.INSTANCE, singleValueParameter, bVar}, (Function1) null, 4, (j) null), new Checks(OperatorNameConventions.BINARY_OPERATION_NAMES, new Check[]{memberOrExtension, singleValueParameter, bVar}, (Function1) null, 4, (j) null), new Checks(OperatorNameConventions.SIMPLE_UNARY_OPERATION_NAMES, new Check[]{memberOrExtension, noValueParameters}, (Function1) null, 4, (j) null), new Checks(CollectionsKt__CollectionsKt.listOf((Object[]) new Name[]{OperatorNameConventions.INC, OperatorNameConventions.DEC}), new Check[]{memberOrExtension}, c.a), new Checks(OperatorNameConventions.ASSIGNMENT_OPERATIONS, new Check[]{memberOrExtension, ReturnsCheck.ReturnsUnit.INSTANCE, singleValueParameter, bVar}, (Function1) null, 4, (j) null), new Checks(OperatorNameConventions.COMPONENT_REGEX, new Check[]{memberOrExtension, noValueParameters}, (Function1) null, 4, (j) null)});
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.AbstractModifierChecks
    @NotNull
    public List<Checks> getChecks$descriptors() {
        return a;
    }
}
