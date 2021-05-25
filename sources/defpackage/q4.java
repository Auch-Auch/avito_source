package defpackage;

import arrow.core.Eval;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
/* compiled from: kotlin-style lambda group */
/* renamed from: q4  reason: default package */
public final class q4 extends Lambda implements Function1<Object, Eval<? extends A>> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object d;
    public final /* synthetic */ Object e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public q4(int i, Object obj, Object obj2, Object obj3, Object obj4) {
        super(1);
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
        this.e = obj4;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.a;
        if (i == 0) {
            return ((Eval.FlatMap) this.b).run(obj);
        }
        if (i == 1) {
            return ((Eval.FlatMap) this.b).run(obj);
        }
        throw null;
    }
}
