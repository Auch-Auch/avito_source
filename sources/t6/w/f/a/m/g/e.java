package t6.w.f.a.m.g;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingStrategy;
public final class e implements Function1<CallableMemberDescriptor, Unit> {
    public final /* synthetic */ OverridingStrategy a;
    public final /* synthetic */ CallableMemberDescriptor b;

    public e(OverridingStrategy overridingStrategy, CallableMemberDescriptor callableMemberDescriptor) {
        this.a = overridingStrategy;
        this.b = callableMemberDescriptor;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(CallableMemberDescriptor callableMemberDescriptor) {
        this.a.inheritanceConflict(this.b, callableMemberDescriptor);
        return Unit.INSTANCE;
    }
}
