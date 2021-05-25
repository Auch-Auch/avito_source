package com.avito.android.html_formatter.jsoup;

import com.avito.android.html_formatter.MutableHtmlNode;
import com.avito.android.html_formatter.SupportsInsertHtmlNode;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\r\u0010\u000eJ!\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/html_formatter/jsoup/JsoupSupportsInsertHtmlNode;", "Lcom/avito/android/html_formatter/SupportsInsertHtmlNode;", "", "where", "", "what", "Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "insert", "(ILjava/lang/String;)Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "Lorg/jsoup/nodes/Node;", AuthSource.SEND_ABUSE, "Lorg/jsoup/nodes/Node;", "node", "<init>", "(Lorg/jsoup/nodes/Node;)V", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class JsoupSupportsInsertHtmlNode implements SupportsInsertHtmlNode {
    public final Node a;

    public JsoupSupportsInsertHtmlNode(@NotNull Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.a = node;
    }

    @Override // com.avito.android.html_formatter.SupportsInsertHtmlNode
    @Nullable
    public MutableHtmlNode.OperationResult insert(int i, @NotNull String str) {
        MutableHtmlNode.OperationResult operationResult;
        MutableHtmlNode.OperationResult splitParentBlock;
        Intrinsics.checkNotNullParameter(str, "what");
        Node node = this.a;
        if (node instanceof TextNode) {
            TextNode textNode = (TextNode) node;
            if (Intrinsics.areEqual(str, "\n")) {
                splitParentBlock = JsoupExtensionsKt.splitParentBlock(textNode, i);
            } else {
                StringBuilder sb = new StringBuilder();
                if (i != 0) {
                    String wholeText = textNode.getWholeText();
                    Intrinsics.checkNotNullExpressionValue(wholeText, "wholeText");
                    Objects.requireNonNull(wholeText, "null cannot be cast to non-null type java.lang.String");
                    String substring = wholeText.substring(0, i);
                    Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    sb.append(substring);
                }
                sb.append(str);
                if (textNode.getWholeText().length() > i) {
                    String wholeText2 = textNode.getWholeText();
                    Intrinsics.checkNotNullExpressionValue(wholeText2, "wholeText");
                    int length = textNode.getWholeText().length();
                    Objects.requireNonNull(wholeText2, "null cannot be cast to non-null type java.lang.String");
                    String substring2 = wholeText2.substring(i, length);
                    Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    sb.append(substring2);
                }
                textNode.text(sb.toString());
                splitParentBlock = new MutableHtmlNode.OperationResult(null, 0, 1, null);
            }
        } else if (!(node instanceof Element)) {
            return null;
        } else {
            Element element = (Element) node;
            if (Intrinsics.areEqual(element.normalName(), SDKConstants.PARAM_A2U_BODY)) {
                Element element2 = new Element("p");
                element2.insertChildren(0, new TextNode(str));
                element.insertChildren(0, element2);
                splitParentBlock = new MutableHtmlNode.OperationResult(null, 0, 1, null);
            } else if (element.isBlock()) {
                Node firstChildTextNode = JsoupExtensionsKt.getFirstChildTextNode(element);
                if (firstChildTextNode == null) {
                    firstChildTextNode = JsoupExtensionsKt.getFirstChildBlankRow(element);
                }
                if (firstChildTextNode == null) {
                    Element parent = element.parent();
                    firstChildTextNode = new TextNode("");
                    parent.insertChildren(0, firstChildTextNode);
                }
                return new MutableJsoupHtmlNode(firstChildTextNode).insert(0, str);
            } else {
                if (JsoupExtensionsKt.isBlankRow(element) && Intrinsics.areEqual(str, "\n") && JsoupExtensionsKt.isLeafInListElementSubtree(element)) {
                    Element findClosestBlockParent = JsoupExtensionsKt.findClosestBlockParent(element);
                    if (findClosestBlockParent == null) {
                        return null;
                    }
                    Element element3 = new Element("p");
                    element3.insertChildren(0, findClosestBlockParent.childNodes());
                    JsoupExtensionsKt.splitListWithNode(findClosestBlockParent, element3);
                    operationResult = new MutableHtmlNode.OperationResult(null, (-i) - 1, 1, null);
                } else if (JsoupExtensionsKt.isBlankRow(element) && Intrinsics.areEqual(str, "\n")) {
                    splitParentBlock = JsoupExtensionsKt.splitParentBlock(element);
                } else if (!JsoupExtensionsKt.isBlankRow(element)) {
                    return null;
                } else {
                    Element parent2 = element.parent();
                    TextNode textNode2 = new TextNode(str);
                    parent2.insertChildren(element.siblingIndex(), textNode2);
                    if (element.nextSibling() == null) {
                        element.remove();
                        return new MutableHtmlNode.OperationResult(new MutableJsoupHtmlNode(textNode2), -i);
                    }
                    operationResult = new MutableHtmlNode.OperationResult(null, -i, 1, null);
                }
                return operationResult;
            }
        }
        return splitParentBlock;
    }
}
