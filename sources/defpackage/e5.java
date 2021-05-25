package defpackage;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jsoup.nodes.Node;
/* compiled from: kotlin-style lambda group */
/* renamed from: e5  reason: default package */
public final class e5 extends Lambda implements Function2<Node, Integer, Boolean> {
    public static final e5 b = new e5(0);
    public static final e5 c = new e5(1);
    public static final e5 d = new e5(2);
    public final /* synthetic */ int a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e5(int i) {
        super(2);
        this.a = i;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Boolean invoke(Node node, Integer num) {
        int i = this.a;
        boolean z = false;
        if (i == 0) {
            Node node2 = node;
            num.intValue();
            if (node2 != null && node2.hasAttr("label")) {
                z = true;
            }
            return Boolean.valueOf(z);
        } else if (i == 1) {
            Node node3 = node;
            num.intValue();
            if (node3 != null && node3.hasAttr("label")) {
                z = true;
            }
            return Boolean.valueOf(z);
        } else if (i == 2) {
            Node node4 = node;
            num.intValue();
            if (node4 != null && node4.hasAttr("label")) {
                z = true;
            }
            return Boolean.valueOf(z);
        } else {
            throw null;
        }
    }
}
