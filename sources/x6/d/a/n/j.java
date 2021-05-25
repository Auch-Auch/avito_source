package x6.d.a.n;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.kodein.di.bindings.ScopeRegistry;
import org.kodein.di.bindings.SubScope;
public final class j extends Lambda implements Function0<ScopeRegistry> {
    public final /* synthetic */ SubScope.b a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(SubScope.b bVar) {
        super(0);
        this.a = bVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public ScopeRegistry invoke() {
        return this.a.a.newRegistry();
    }
}
