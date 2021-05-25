package com.avito.android.html_formatter.jsoup;

import a2.b.a.a.a;
import com.avito.android.html_formatter.FormatChange;
import com.avito.android.html_formatter.InsertOperation;
import com.avito.android.html_formatter.MutableHtmlNode;
import com.avito.android.html_formatter.SupportsDeleteHtmlNode;
import com.avito.android.html_formatter.SupportsFormatHtmlNode;
import com.avito.android.html_formatter.SupportsReplaceHtmlNode;
import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import t6.n.h;
import t6.n.i;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u000f\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\b\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ,\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\nH\u0001¢\u0006\u0004\b\u0016\u0010\u0017J0\u0010\u001b\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ*\u0010\u001f\u001a\u0004\u0018\u00010\u00112\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0005H\u0001¢\u0006\u0004\b!\u0010\u0007¨\u0006&"}, d2 = {"Lcom/avito/android/html_formatter/jsoup/MutableJsoupHtmlNode;", "Lcom/avito/android/html_formatter/jsoup/JsoupHtmlNode;", "Lcom/avito/android/html_formatter/SupportsReplaceHtmlNode;", "Lcom/avito/android/html_formatter/SupportsFormatHtmlNode;", "Lcom/avito/android/html_formatter/MutableHtmlNode;", "", "simplifyHtml", "()I", "createEmptyParagraph", "()Lcom/avito/android/html_formatter/MutableHtmlNode;", "", "toString", "()Ljava/lang/String;", "from", "to", "Lcom/avito/android/html_formatter/SupportsDeleteHtmlNode$OperationTransaction;", "transaction", "Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", PhoneActionStrings.REMOVE, "(IILcom/avito/android/html_formatter/SupportsDeleteHtmlNode$OperationTransaction;)Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "where", "what", "insert", "(ILjava/lang/String;)Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "", "Lcom/avito/android/html_formatter/InsertOperation;", "insertOperations", "replace", "(IILjava/util/List;)Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "Lcom/avito/android/html_formatter/FormatChange;", "format", "applyFormat", "(IILcom/avito/android/html_formatter/FormatChange;)Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "getFormat", "Lorg/jsoup/nodes/Node;", "node", "<init>", "(Lorg/jsoup/nodes/Node;)V", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class MutableJsoupHtmlNode extends JsoupHtmlNode implements SupportsReplaceHtmlNode, SupportsFormatHtmlNode, MutableHtmlNode {
    public final /* synthetic */ JsoupSupportsReplaceHtmlNode b;
    public final /* synthetic */ JsoupSupportsFormatHtmlNode c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MutableJsoupHtmlNode(@NotNull Node node) {
        super(node);
        Intrinsics.checkNotNullParameter(node, "node");
        this.b = new JsoupSupportsReplaceHtmlNode(node);
        this.c = new JsoupSupportsFormatHtmlNode(node);
    }

    @Override // com.avito.android.html_formatter.SupportsFormatHtmlNode
    @Nullable
    public MutableHtmlNode.OperationResult applyFormat(int i, int i2, @NotNull FormatChange formatChange) {
        Intrinsics.checkNotNullParameter(formatChange, "format");
        return this.c.applyFormat(i, i2, formatChange);
    }

    @Override // com.avito.android.html_formatter.MutableHtmlNode
    @Nullable
    public MutableHtmlNode createEmptyParagraph() {
        Node node = getNode();
        if (!(node instanceof Element)) {
            node = null;
        }
        Element element = (Element) node;
        if (element == null) {
            return null;
        }
        Element element2 = new Element("p");
        element2.insertChildren(0, new Element("br"));
        element.insertChildren(0, element2);
        return new MutableJsoupHtmlNode(element2);
    }

    @Override // com.avito.android.html_formatter.SupportsDeleteHtmlNode
    @Nullable
    public MutableHtmlNode.OperationResult delete(int i, int i2, @Nullable SupportsDeleteHtmlNode.OperationTransaction operationTransaction) {
        return this.b.delete(i, i2, operationTransaction);
    }

    @Override // com.avito.android.html_formatter.SupportsFormatHtmlNode
    public int getFormat() {
        return this.c.getFormat();
    }

    @Override // com.avito.android.html_formatter.SupportsInsertHtmlNode
    @Nullable
    public MutableHtmlNode.OperationResult insert(int i, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "what");
        return this.b.insert(i, str);
    }

    @Override // com.avito.android.html_formatter.SupportsReplaceHtmlNode
    @Nullable
    public MutableHtmlNode.OperationResult replace(int i, int i2, @NotNull List<InsertOperation> list) {
        Intrinsics.checkNotNullParameter(list, "insertOperations");
        return this.b.replace(i, i2, list);
    }

    @Override // com.avito.android.html_formatter.MutableHtmlNode
    public int simplifyHtml() {
        Elements allElements;
        List<Element> asReversedMutable;
        Elements<Element> allElements2;
        Node node = getNode();
        if (!(node instanceof Element)) {
            node = null;
        }
        Element element = (Element) node;
        if (!(element == null || (allElements2 = element.getAllElements()) == null)) {
            ArrayList arrayList = new ArrayList();
            for (Element element2 : allElements2) {
                h.addAll(arrayList, element2.textNodes());
            }
            List<TextNode> asReversed = i.asReversed(arrayList);
            if (asReversed != null) {
                for (TextNode textNode : asReversed) {
                    Intrinsics.checkNotNullExpressionValue(textNode, "it");
                    String wholeText = textNode.getWholeText();
                    Intrinsics.checkNotNullExpressionValue(wholeText, "it.wholeText");
                    if (wholeText.length() == 0) {
                        textNode.remove();
                    }
                }
            }
        }
        Node node2 = getNode();
        if (!(node2 instanceof Element)) {
            node2 = null;
        }
        Element element3 = (Element) node2;
        if (element3 == null || (allElements = element3.getAllElements()) == null || (asReversedMutable = i.asReversedMutable(allElements)) == null) {
            return 0;
        }
        int i = 0;
        for (Element element4 : asReversedMutable) {
            List<TextNode> textNodes = element4.textNodes();
            if (textNodes.size() > 1) {
                Intrinsics.checkNotNullExpressionValue(textNodes, "textNodes");
                for (TextNode textNode2 : i.asReversedMutable(textNodes)) {
                    Node previousSibling = textNode2.previousSibling();
                    if (!(previousSibling instanceof TextNode)) {
                        previousSibling = null;
                    }
                    TextNode textNode3 = (TextNode) previousSibling;
                    if (textNode3 != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(textNode3.getWholeText());
                        Intrinsics.checkNotNullExpressionValue(textNode2, "textNode");
                        sb.append(textNode2.getWholeText());
                        textNode3.text(sb.toString());
                        textNode2.remove();
                    }
                }
            }
            Node previousSibling2 = element4.previousSibling();
            if (!(previousSibling2 instanceof Element)) {
                previousSibling2 = null;
            }
            Element element5 = (Element) previousSibling2;
            Intrinsics.checkNotNullExpressionValue(element4, "element");
            if (JsoupExtensionsKt.isInlineElement(element4) && !JsoupExtensionsKt.isBlankRow(element4) && element5 != null && Intrinsics.areEqual(element5.normalName(), element4.normalName())) {
                element5.insertChildren(element5.childNodeSize(), element4.childNodes());
                element4.remove();
            } else if (element4.parent() != null) {
                String wholeText2 = element4.wholeText();
                Intrinsics.checkNotNullExpressionValue(wholeText2, "element.wholeText()");
                if ((wholeText2.length() == 0) && !JsoupExtensionsKt.isBlankRow(element4) && (!JsoupExtensionsKt.isLeafInBlockParentSubtree(element4) || JsoupExtensionsKt.getFirstChildBlankRow(element4) == null)) {
                    element4.remove();
                }
                if (JsoupExtensionsKt.isBlankRow(element4) && (JsoupExtensionsKt.getSiblingNodeInRowFromLeft(element4) instanceof TextNode) && JsoupExtensionsKt.getSiblingNodeInRowFromRight(element4) == null) {
                    element4.remove();
                    i--;
                }
            }
        }
        return i;
    }

    @NotNull
    public String toString() {
        Node node = getNode();
        if (node instanceof Element) {
            StringBuilder L = a.L("ElementNode(");
            L.append(getNode().outerHtml());
            L.append(')');
            return L.toString();
        } else if (!(node instanceof TextNode)) {
            return "Node(NO_TEXT)";
        } else {
            StringBuilder L2 = a.L("TextNode(");
            L2.append(((TextNode) getNode()).text());
            L2.append(')');
            return L2.toString();
        }
    }
}
