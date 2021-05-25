package t6.w.f.a.m.c.a.d;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
public final class g extends Lambda implements Function1<CallableMemberDescriptor, KotlinType> {
    public final /* synthetic */ ValueParameterDescriptor a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(ValueParameterDescriptor valueParameterDescriptor) {
        super(1);
        this.a = valueParameterDescriptor;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public KotlinType invoke(CallableMemberDescriptor callableMemberDescriptor) {
        CallableMemberDescriptor callableMemberDescriptor2 = callableMemberDescriptor;
        Intrinsics.checkNotNullParameter(callableMemberDescriptor2, "it");
        KotlinType type = callableMemberDescriptor2.getValueParameters().get(this.a.getIndex()).getType();
        Intrinsics.checkNotNullExpressionValue(type, "it.valueParameters[p.index].type");
        return type;
    }
}
