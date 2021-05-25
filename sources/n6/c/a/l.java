package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class l extends Lambda implements Function1<P12, R> {
    public final /* synthetic */ m a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(m mVar, Object obj) {
        super(1);
        this.a = mVar;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final R invoke(P12 p12) {
        m mVar = this.a;
        n nVar = mVar.a;
        o oVar = nVar.a;
        p pVar = oVar.a;
        q qVar = pVar.a;
        r rVar = qVar.a;
        s sVar = rVar.a;
        t tVar = sVar.a;
        u uVar = tVar.a;
        v vVar = uVar.a;
        return (R) vVar.a.a.invoke(vVar.b, uVar.b, tVar.b, sVar.b, rVar.b, qVar.b, pVar.b, oVar.b, nVar.b, mVar.b, this.b, p12);
    }
}
