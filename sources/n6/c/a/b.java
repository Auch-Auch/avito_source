package n6.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function1<P11, R> {
    public final /* synthetic */ c a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(c cVar, Object obj) {
        super(1);
        this.a = cVar;
        this.b = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final R invoke(P11 p11) {
        c cVar = this.a;
        d dVar = cVar.a;
        e eVar = dVar.a;
        f fVar = eVar.a;
        g gVar = fVar.a;
        h hVar = gVar.a;
        i iVar = hVar.a;
        j jVar = iVar.a;
        k kVar = jVar.a;
        return (R) kVar.a.a.invoke(kVar.b, jVar.b, iVar.b, hVar.b, gVar.b, fVar.b, eVar.b, dVar.b, cVar.b, this.b, p11);
    }
}
