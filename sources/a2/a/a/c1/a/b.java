package a2.a.a.c1.a;

import com.avito.android.html_formatter.jsoup.JsoupExtensionsKt;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
public final class b extends Lambda implements Function2<Node, Integer, Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(int i, int i2) {
        super(2);
        this.a = i;
        this.b = i2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(Node node, Integer num) {
        Node node2 = node;
        int intValue = num.intValue();
        if (intValue != 0 && ((node2 instanceof TextNode) || (node2 != null && JsoupExtensionsKt.isBlankRow(node2)))) {
            node2.remove();
        }
        if (intValue == 0 && (node2 instanceof TextNode)) {
            TextNode textNode = (TextNode) node2;
            String wholeText = textNode.getWholeText();
            Intrinsics.checkNotNullExpressionValue(wholeText, "node.wholeText");
            int i = this.a;
            int i2 = this.b;
            Objects.requireNonNull(wholeText, "null cannot be cast to non-null type java.lang.String");
            String substring = wholeText.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            textNode.text(substring);
        }
        return Unit.INSTANCE;
    }
}
