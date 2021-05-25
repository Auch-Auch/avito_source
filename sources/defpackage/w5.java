package defpackage;

import com.avito.android.html_formatter.jsoup.JsoupExtensionsKt;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
/* compiled from: kotlin-style lambda group */
/* renamed from: w5  reason: default package */
public final class w5 extends Lambda implements Function2<Node, Integer, Unit> {
    public final /* synthetic */ int a;
    public final /* synthetic */ int b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w5(int i, int i2) {
        super(2);
        this.a = i;
        this.b = i2;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(Node node, Integer num) {
        int i = this.a;
        if (i == 0) {
            Node node2 = node;
            int intValue = num.intValue();
            if (intValue > 0 && ((node2 instanceof TextNode) || (node2 != null && JsoupExtensionsKt.isBlankRow(node2)))) {
                node2.remove();
            }
            if (intValue == 0 && (node2 instanceof TextNode)) {
                TextNode textNode = (TextNode) node2;
                String wholeText = textNode.getWholeText();
                Intrinsics.checkNotNullExpressionValue(wholeText, "node.wholeText");
                int i2 = this.b;
                Objects.requireNonNull(wholeText, "null cannot be cast to non-null type java.lang.String");
                String substring = wholeText.substring(0, i2);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                textNode.text(substring);
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            Node node3 = node;
            int intValue2 = num.intValue();
            if (intValue2 < 0 && ((node3 instanceof TextNode) || (node3 != null && JsoupExtensionsKt.isBlankRow(node3)))) {
                node3.remove();
            }
            if (intValue2 == 0 && (node3 instanceof TextNode)) {
                TextNode textNode2 = (TextNode) node3;
                String wholeText2 = textNode2.getWholeText();
                Intrinsics.checkNotNullExpressionValue(wholeText2, "node.wholeText");
                int i3 = this.b;
                int length = textNode2.getWholeText().length();
                Objects.requireNonNull(wholeText2, "null cannot be cast to non-null type java.lang.String");
                String substring2 = wholeText2.substring(i3, length);
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                textNode2.text(substring2);
            }
            return Unit.INSTANCE;
        } else {
            throw null;
        }
    }
}
