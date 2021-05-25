package t6.w.f.a.m.b;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ScopesHolderForClass;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
public final class b extends Lambda implements Function0<T> {
    public final /* synthetic */ ScopesHolderForClass<T> a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(ScopesHolderForClass<T> scopesHolderForClass) {
        super(0);
        this.a = scopesHolderForClass;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return (MemberScope) ScopesHolderForClass.access$getScopeFactory$p(this.a).invoke(ScopesHolderForClass.access$getKotlinTypeRefinerForOwnerModule$p(this.a));
    }
}
