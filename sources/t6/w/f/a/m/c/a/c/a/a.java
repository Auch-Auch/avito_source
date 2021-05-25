package t6.w.f.a.m.c.a.c.a;

import java.util.Set;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaClassMemberScope;
import kotlin.reflect.jvm.internal.impl.name.Name;
import t6.n.z;
public final class a extends Lambda implements Function0<Set<? extends Name>> {
    public final /* synthetic */ LazyJavaClassMemberScope a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(LazyJavaClassMemberScope lazyJavaClassMemberScope) {
        super(0);
        this.a = lazyJavaClassMemberScope;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Set<? extends Name> invoke() {
        return z.plus((Set) this.a.getFunctionNames(), (Iterable) this.a.getVariableNames());
    }
}
