package defpackage;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jsoup.nodes.Node;
/* compiled from: kotlin-style lambda group */
/* renamed from: d5  reason: default package */
public final class d5 extends Lambda implements Function2<Node, Integer, Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d5(int i, Object obj) {
        super(2);
        this.a = i;
        this.b = obj;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(Node node, Integer num) {
        int i = this.a;
        if (i == 0) {
            T t = (T) node;
            if (num.intValue() == 0) {
                ((Ref.ObjectRef) this.b).element = t;
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            T t2 = (T) node;
            if (num.intValue() == 0) {
                ((Ref.ObjectRef) this.b).element = t2;
            }
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
