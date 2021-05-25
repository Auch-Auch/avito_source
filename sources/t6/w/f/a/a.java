package t6.w.f.a;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
public final class a extends Lambda implements Function0<ParameterDescriptor> {
    public final /* synthetic */ CallableMemberDescriptor a;
    public final /* synthetic */ int b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(CallableMemberDescriptor callableMemberDescriptor, int i) {
        super(0);
        this.a = callableMemberDescriptor;
        this.b = i;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public ParameterDescriptor invoke() {
        ValueParameterDescriptor valueParameterDescriptor = this.a.getValueParameters().get(this.b);
        Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor, "descriptor.valueParameters[i]");
        return valueParameterDescriptor;
    }
}
