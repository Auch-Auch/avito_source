package a2.a.a.c1.a;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jsoup.nodes.Node;
public final class a extends Lambda implements Function2<Node, Integer, Unit> {
    public static final a a = new a();

    public a() {
        super(2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(Node node, Integer num) {
        num.intValue();
        return Unit.INSTANCE;
    }
}
