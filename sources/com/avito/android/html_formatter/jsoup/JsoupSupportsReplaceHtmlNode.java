package com.avito.android.html_formatter.jsoup;

import com.avito.android.html_formatter.MutableHtmlNode;
import com.avito.android.html_formatter.SupportsDeleteHtmlNode;
import com.avito.android.html_formatter.SupportsInsertHtmlNode;
import com.avito.android.html_formatter.SupportsReplaceHtmlNode;
import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Node;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J/\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ.\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/avito/android/html_formatter/jsoup/JsoupSupportsReplaceHtmlNode;", "Lcom/avito/android/html_formatter/SupportsReplaceHtmlNode;", "Lcom/avito/android/html_formatter/SupportsDeleteHtmlNode;", "Lcom/avito/android/html_formatter/SupportsInsertHtmlNode;", "", "from", "to", "", "Lcom/avito/android/html_formatter/InsertOperation;", "insertOperations", "Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "replace", "(IILjava/util/List;)Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "Lcom/avito/android/html_formatter/SupportsDeleteHtmlNode$OperationTransaction;", "transaction", PhoneActionStrings.REMOVE, "(IILcom/avito/android/html_formatter/SupportsDeleteHtmlNode$OperationTransaction;)Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "where", "", "what", "insert", "(ILjava/lang/String;)Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "Lorg/jsoup/nodes/Node;", "node", "<init>", "(Lorg/jsoup/nodes/Node;)V", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class JsoupSupportsReplaceHtmlNode implements SupportsReplaceHtmlNode, SupportsDeleteHtmlNode, SupportsInsertHtmlNode {
    public final /* synthetic */ JsoupSupportsDeleteHtmlNode a;
    public final /* synthetic */ JsoupSupportsInsertHtmlNode b;

    public JsoupSupportsReplaceHtmlNode(@NotNull Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.a = new JsoupSupportsDeleteHtmlNode(node);
        this.b = new JsoupSupportsInsertHtmlNode(node);
    }

    @Override // com.avito.android.html_formatter.SupportsDeleteHtmlNode
    @Nullable
    public MutableHtmlNode.OperationResult delete(int i, int i2, @Nullable SupportsDeleteHtmlNode.OperationTransaction operationTransaction) {
        return this.a.delete(i, i2, operationTransaction);
    }

    @Override // com.avito.android.html_formatter.SupportsInsertHtmlNode
    @Nullable
    public MutableHtmlNode.OperationResult insert(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "what");
        return this.b.insert(i, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0091, code lost:
        if ((r0.length() == 0) == false) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ac, code lost:
        if ((r0.length() == 0) != false) goto L_0x00b0;
     */
    @Override // com.avito.android.html_formatter.SupportsReplaceHtmlNode
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.html_formatter.MutableHtmlNode.OperationResult replace(int r6, int r7, @org.jetbrains.annotations.NotNull java.util.List<com.avito.android.html_formatter.InsertOperation> r8) {
        /*
            r5 = this;
            java.lang.String r0 = "insertOperations"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            com.avito.android.html_formatter.SupportsDeleteHtmlNode$OperationTransaction r0 = new com.avito.android.html_formatter.SupportsDeleteHtmlNode$OperationTransaction
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.LinkedHashMap r2 = new java.util.LinkedHashMap
            r2.<init>()
            r0.<init>(r1, r2)
            com.avito.android.html_formatter.MutableHtmlNode$OperationResult r6 = r5.delete(r6, r7, r0)
            if (r6 == 0) goto L_0x0021
            com.avito.android.html_formatter.MutableHtmlNode r7 = r6.getReplacedNode()
            if (r7 == 0) goto L_0x0021
            goto L_0x0022
        L_0x0021:
            r7 = r5
        L_0x0022:
            r1 = 0
            if (r6 == 0) goto L_0x002a
            int r2 = r6.getCursorPositionShift()
            goto L_0x002b
        L_0x002a:
            r2 = 0
        L_0x002b:
            java.util.Iterator r8 = r8.iterator()
        L_0x002f:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto L_0x0063
            java.lang.Object r3 = r8.next()
            com.avito.android.html_formatter.InsertOperation r3 = (com.avito.android.html_formatter.InsertOperation) r3
            int r4 = r3.getFrom()
            int r4 = r4 + r2
            java.lang.String r3 = r3.getContent()
            com.avito.android.html_formatter.MutableHtmlNode$OperationResult r3 = r7.insert(r4, r3)
            if (r3 == 0) goto L_0x0051
            com.avito.android.html_formatter.MutableHtmlNode r4 = r3.getReplacedNode()
            if (r4 == 0) goto L_0x0051
            r7 = r4
        L_0x0051:
            if (r3 == 0) goto L_0x0058
            int r4 = r3.getCursorPositionShift()
            goto L_0x0059
        L_0x0058:
            r4 = 0
        L_0x0059:
            int r2 = r2 + r4
            if (r6 == 0) goto L_0x0061
            com.avito.android.html_formatter.MutableHtmlNode$OperationResult r6 = r6.merge(r3)
            goto L_0x002f
        L_0x0061:
            r6 = 0
            goto L_0x002f
        L_0x0063:
            java.util.List r7 = r0.getRemovedNodes()
            java.util.Iterator r7 = r7.iterator()
        L_0x006b:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x00bc
            java.lang.Object r8 = r7.next()
            org.jsoup.nodes.Node r8 = (org.jsoup.nodes.Node) r8
            boolean r0 = r8 instanceof org.jsoup.nodes.Element
            r2 = 1
            if (r0 == 0) goto L_0x0093
            r0 = r8
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            java.lang.String r0 = r0.wholeText()
            java.lang.String r3 = "it.wholeText()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0090
            r0 = 1
            goto L_0x0091
        L_0x0090:
            r0 = 0
        L_0x0091:
            if (r0 != 0) goto L_0x00b0
        L_0x0093:
            boolean r0 = r8 instanceof org.jsoup.nodes.TextNode
            if (r0 == 0) goto L_0x00af
            r0 = r8
            org.jsoup.nodes.TextNode r0 = (org.jsoup.nodes.TextNode) r0
            java.lang.String r0 = r0.getWholeText()
            java.lang.String r3 = "it.wholeText"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00ab
            r0 = 1
            goto L_0x00ac
        L_0x00ab:
            r0 = 0
        L_0x00ac:
            if (r0 == 0) goto L_0x00af
            goto L_0x00b0
        L_0x00af:
            r2 = 0
        L_0x00b0:
            boolean r0 = r8.hasParent()
            if (r0 == 0) goto L_0x006b
            if (r2 == 0) goto L_0x006b
            r8.remove()
            goto L_0x006b
        L_0x00bc:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.html_formatter.jsoup.JsoupSupportsReplaceHtmlNode.replace(int, int, java.util.List):com.avito.android.html_formatter.MutableHtmlNode$OperationResult");
    }
}
