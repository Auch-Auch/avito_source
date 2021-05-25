package com.avito.android.html_formatter.jsoup;

import com.avito.android.html_formatter.MutableHtmlNode;
import com.avito.android.html_formatter.SupportsDeleteHtmlNode;
import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J+\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\f\u001a\u00020\u000b*\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/html_formatter/jsoup/JsoupSupportsDeleteHtmlNode;", "Lcom/avito/android/html_formatter/SupportsDeleteHtmlNode;", "", "from", "to", "Lcom/avito/android/html_formatter/SupportsDeleteHtmlNode$OperationTransaction;", "transaction", "Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", PhoneActionStrings.REMOVE, "(IILcom/avito/android/html_formatter/SupportsDeleteHtmlNode$OperationTransaction;)Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "Lorg/jsoup/nodes/Element;", "", AuthSource.SEND_ABUSE, "(Lorg/jsoup/nodes/Element;)Z", "Lorg/jsoup/nodes/Node;", "Lorg/jsoup/nodes/Node;", "node", "<init>", "(Lorg/jsoup/nodes/Node;)V", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class JsoupSupportsDeleteHtmlNode implements SupportsDeleteHtmlNode {
    public final Node a;

    public JsoupSupportsDeleteHtmlNode(@NotNull Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.a = node;
    }

    public final boolean a(Element element) {
        while (element.childrenSize() == 1 && !JsoupExtensionsKt.isBlankRow(element)) {
            element = element.child(0);
            Intrinsics.checkNotNullExpressionValue(element, "element.child(0)");
        }
        if (!JsoupExtensionsKt.isBlankRow(element)) {
            return false;
        }
        element.remove();
        return true;
    }

    @Override // com.avito.android.html_formatter.SupportsDeleteHtmlNode
    @Nullable
    public MutableHtmlNode.OperationResult delete(int i, int i2, @Nullable SupportsDeleteHtmlNode.OperationTransaction operationTransaction) {
        MutableHtmlNode.OperationResult remove;
        Element element;
        Node siblingNodeInRowFromLeft;
        MutableHtmlNode.OperationResult operationResult = null;
        if (!this.a.hasParent()) {
            return null;
        }
        Node node = this.a;
        int i3 = 0;
        if (node instanceof TextNode) {
            TextNode textNode = (TextNode) node;
            String wholeText = textNode.getWholeText();
            Intrinsics.checkNotNullExpressionValue(wholeText, "wholeText");
            Objects.requireNonNull(wholeText, "null cannot be cast to non-null type kotlin.CharSequence");
            String obj = StringsKt__StringsKt.removeRange(wholeText, i, i2).toString();
            textNode.text(obj);
            boolean z = (obj.length() == 0) && JsoupExtensionsKt.isLeafInBlockParentSubtree(textNode);
            boolean z2 = (obj.length() == 0) && (siblingNodeInRowFromLeft = JsoupExtensionsKt.getSiblingNodeInRowFromLeft(textNode)) != null && JsoupExtensionsKt.isBlankRow(siblingNodeInRowFromLeft) && JsoupExtensionsKt.getSiblingNodeInRowFromRight(textNode) == null;
            if (!z && !z2) {
                return new MutableHtmlNode.OperationResult(null, 0, 1, null);
            }
            Element element2 = new Element("br");
            textNode.replaceWith(element2);
            remove = new MutableHtmlNode.OperationResult(new MutableJsoupHtmlNode(element2), 0);
        } else if (!(node instanceof Element)) {
            return null;
        } else {
            Element element3 = (Element) node;
            if (Intrinsics.areEqual(element3.normalName(), SDKConstants.PARAM_A2U_BODY)) {
                return null;
            }
            if (JsoupExtensionsKt.isBlankRow(element3)) {
                JsoupExtensionsKt.remove(element3, operationTransaction);
                remove = new MutableHtmlNode.OperationResult(null, -i, 1, null);
            } else if (element3.isBlock()) {
                Node parentNode = element3.parentNode();
                int siblingIndex = element3.siblingIndex();
                while (siblingIndex == 0) {
                    Intrinsics.checkNotNullExpressionValue(parentNode, "parent");
                    if (JsoupExtensionsKt.isRoot(parentNode)) {
                        break;
                    }
                    siblingIndex = parentNode.siblingIndex();
                    parentNode = parentNode.parent();
                }
                if (siblingIndex == 0) {
                    element = null;
                } else {
                    Node childNode = parentNode.childNode(siblingIndex - 1);
                    if (!(childNode instanceof Element)) {
                        childNode = null;
                    }
                    element = (Element) childNode;
                }
                if (element != null) {
                    if (JsoupExtensionsKt.isListRoot(element)) {
                        element = element.child(element.childrenSize() - 1);
                    }
                    Intrinsics.checkNotNullExpressionValue(element, "attachTarget");
                    if (a(element)) {
                        i3 = -1;
                    } else {
                        a(element3);
                    }
                    element.insertChildren(element.childNodeSize(), element3.childNodes());
                    Element parent = element3.parent();
                    element3.remove();
                    Intrinsics.checkNotNullExpressionValue(parent, "parent");
                    if (JsoupExtensionsKt.isListRoot(parent) && parent.childrenSize() == 0) {
                        parent.remove();
                    }
                    operationResult = new MutableHtmlNode.OperationResult(null, i3, 1, null);
                }
                if (operationResult != null) {
                    return operationResult;
                }
                return JsoupExtensionsKt.remove(element3, operationTransaction);
            } else {
                remove = JsoupExtensionsKt.remove(element3, operationTransaction);
            }
        }
        return remove;
    }
}
