package t6.w.f.a.m.a.a;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;
public final class e implements DFS.Neighbors<CallableMemberDescriptor> {
    public static final e a = new e();

    /* Return type fixed from 'java.lang.Iterable' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.reflect.jvm.internal.impl.utils.DFS.Neighbors
    public Iterable<? extends CallableMemberDescriptor> getNeighbors(CallableMemberDescriptor callableMemberDescriptor) {
        return callableMemberDescriptor.getOriginal().getOverriddenDescriptors();
    }
}
