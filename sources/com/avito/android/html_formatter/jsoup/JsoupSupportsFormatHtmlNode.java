package com.avito.android.html_formatter.jsoup;

import a2.g.r.g;
import com.avito.android.html_formatter.FormatChange;
import com.avito.android.html_formatter.MutableHtmlNode;
import com.avito.android.html_formatter.SupportsFormatHtmlNode;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.UserDataStore;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010$\u001a\u00020\f¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J)\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ3\u0010\u0011\u001a\u00020\t*\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\u0013\u001a\u0004\u0018\u00010\t*\u00020\f2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\u0004\u0018\u00010\t*\u00020\f2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u0004\u0018\u00010\t*\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u001c\u001a\u00020\u001b*\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001f\u001a\u0004\u0018\u00010\t*\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0013\u0010!\u001a\u00020\u0019*\u00020\u0019H\u0002¢\u0006\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010#¨\u0006'"}, d2 = {"Lcom/avito/android/html_formatter/jsoup/JsoupSupportsFormatHtmlNode;", "Lcom/avito/android/html_formatter/SupportsFormatHtmlNode;", "", "getFormat", "()I", "from", "to", "Lcom/avito/android/html_formatter/FormatChange;", "format", "Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "applyFormat", "(IILcom/avito/android/html_formatter/FormatChange;)Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "Lorg/jsoup/nodes/Node;", "", "tagName", "Lcom/avito/android/html_formatter/FormatChange$Type;", "type", AuthSource.BOOKING_ORDER, "(Lorg/jsoup/nodes/Node;IILjava/lang/String;Lcom/avito/android/html_formatter/FormatChange$Type;)Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "c", "(Lorg/jsoup/nodes/Node;Ljava/lang/String;Lcom/avito/android/html_formatter/FormatChange$Type;)Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", AuthSource.SEND_ABUSE, "(Lorg/jsoup/nodes/Node;Ljava/lang/String;)Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", g.a, "(Lorg/jsoup/nodes/Node;)Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "Lorg/jsoup/nodes/Element;", "targetListRoot", "", "f", "(Lorg/jsoup/nodes/Element;Lorg/jsoup/nodes/Element;)V", "elementToInsertBetween", "d", "(Lorg/jsoup/nodes/Element;Lorg/jsoup/nodes/Element;)Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "e", "(Lorg/jsoup/nodes/Element;)Lorg/jsoup/nodes/Element;", "Lorg/jsoup/nodes/Node;", "node", "<init>", "(Lorg/jsoup/nodes/Node;)V", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class JsoupSupportsFormatHtmlNode implements SupportsFormatHtmlNode {
    public final Node a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            FormatChange.Type.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            FormatChange.Type.values();
            int[] iArr2 = new int[2];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
            iArr2[1] = 2;
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function2<Node, Integer, Boolean> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i) {
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
            } else {
                throw null;
            }
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class b extends Lambda implements Function2<Node, Integer, Unit> {
        public static final b b = new b(0);
        public static final b c = new b(1);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(2);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Unit invoke(Node node, Integer num) {
            int i = this.a;
            if (i == 0) {
                Node node2 = node;
                if (num.intValue() > 0 && node2 != null && node2.childNodeSize() == 0) {
                    node2.remove();
                }
                return Unit.INSTANCE;
            } else if (i == 1) {
                Node node3 = node;
                if (num.intValue() < 0 && node3 != null && node3.childNodeSize() == 0) {
                    node3.remove();
                }
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class c extends Lambda implements Function2<Node, Integer, Unit> {
        public final /* synthetic */ Ref.ObjectRef a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Ref.ObjectRef objectRef) {
            super(2);
            this.a = objectRef;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Node node, Integer num) {
            Node node2 = node;
            if (num.intValue() == 0 && (node2 instanceof Element)) {
                T t = (T) ((Element) node2);
                if (Intrinsics.areEqual(t.normalName(), "li")) {
                    this.a.element = t;
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function2<Node, Integer, Unit> {
        public static final d a = new d();

        public d() {
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

    public JsoupSupportsFormatHtmlNode(@NotNull Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.a = node;
    }

    public final MutableHtmlNode.OperationResult a(Node node, String str) {
        if (node instanceof TextNode) {
            Node parent = node.parent();
            Intrinsics.checkNotNullExpressionValue(parent, "this.parent()");
            return a(parent, str);
        }
        boolean z = node instanceof Element;
        if (z && JsoupExtensionsKt.isRoot(node)) {
            Element element = new Element(str);
            Element element2 = new Element("li");
            element2.appendChild(new Element("br"));
            element.appendChild(element2);
            ((Element) node).appendChild(element);
            return new MutableHtmlNode.OperationResult(null, 1, 1, null);
        } else if (z && JsoupExtensionsKt.isListElement(node)) {
            Element element3 = (Element) node;
            if (element3.previousElementSibling() != null || element3.parent().previousElementSibling() == null || !Intrinsics.areEqual(element3.parent().previousElementSibling().normalName(), str)) {
                Element element4 = new Element(str);
                f(element3, element4);
                return d(element3, element4);
            }
            Element previousElementSibling = element3.parent().previousElementSibling();
            Intrinsics.checkNotNullExpressionValue(previousElementSibling, "targetList");
            f(element3, previousElementSibling);
            if (element3.parent().childrenSize() == 1) {
                element3.parent().remove();
            } else {
                element3.remove();
            }
            return new MutableHtmlNode.OperationResult(null, 0, 1, null);
        } else if (z && JsoupExtensionsKt.isBlankRow(node)) {
            Element parent2 = ((Element) node).parent();
            Intrinsics.checkNotNullExpressionValue(parent2, "this.parent()");
            return a(parent2, str);
        } else if (!z) {
            return new MutableHtmlNode.OperationResult(null, 0, 1, null);
        } else {
            Element element5 = (Element) node;
            Element previousElementSibling2 = element5.previousElementSibling();
            Element parent3 = element5.parent();
            if (previousElementSibling2 == null || (!Intrinsics.areEqual(previousElementSibling2.normalName(), str))) {
                Element element6 = new Element(str);
                parent3.insertChildren(element5.siblingIndex(), element6);
                f(element5, element6);
                element5.remove();
                return new MutableHtmlNode.OperationResult(null, 0, 1, null);
            }
            f(element5, previousElementSibling2);
            element5.remove();
            return new MutableHtmlNode.OperationResult(null, 0, 1, null);
        }
    }

    @Override // com.avito.android.html_formatter.SupportsFormatHtmlNode
    @Nullable
    public MutableHtmlNode.OperationResult applyFormat(int i, int i2, @NotNull FormatChange formatChange) {
        Intrinsics.checkNotNullParameter(formatChange, "format");
        int format = (getFormat() & formatChange.getValue()) ^ (formatChange.getType() == FormatChange.Type.ADD ? formatChange.getValue() : 0);
        if (format == 1) {
            return b(this.a, i, i2, "strong", formatChange.getType());
        }
        if (format == 2) {
            return b(this.a, i, i2, UserDataStore.EMAIL, formatChange.getType());
        }
        if (format == 4) {
            return c(this.a, "ul", formatChange.getType());
        }
        if (format != 8) {
            return null;
        }
        return c(this.a, "ol", formatChange.getType());
    }

    public final MutableHtmlNode.OperationResult b(Node node, int i, int i2, String str, FormatChange.Type type) {
        int i3;
        boolean z;
        int ordinal = type.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                throw new NoWhenBranchMatchedException();
            } else if (!(node instanceof TextNode) && !JsoupExtensionsKt.isBlankRow(node)) {
                return new MutableHtmlNode.OperationResult(null, 0, 1, null);
            } else {
                node.attr("label", JsoupExtensionsKt.SPLIT_MARK);
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = null;
                Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                objectRef2.element = null;
                Node node2 = node;
                while (true) {
                    z = node2 instanceof Element;
                    Element element = (Element) (!z ? null : node2);
                    if (!(!Intrinsics.areEqual(element != null ? element.normalName() : null, str))) {
                        break;
                    }
                    node2 = node2.parentNode();
                    Intrinsics.checkNotNullExpressionValue(node2, "node.parentNode()");
                }
                Element element2 = (Element) (!z ? null : node2);
                if (element2 == null || !Intrinsics.areEqual(((Element) node2).normalName(), str)) {
                    element2 = null;
                }
                if (element2 == null) {
                    return new MutableHtmlNode.OperationResult(null, 0, 1, null);
                }
                Element e = e(element2);
                Element e2 = e(element2);
                Element parent = element2.parent();
                if (parent == null) {
                    return new MutableHtmlNode.OperationResult(null, 0, 1, null);
                }
                parent.insertChildren(element2.siblingIndex(), e);
                parent.insertChildren(element2.siblingIndex() + 1, e2);
                JsoupExtensionsKt.traverseRemoveSafe(e, new HalfTreeNodeVisitor(e5.b, new d5(0, objectRef), new w5(0, i)));
                JsoupExtensionsKt.traverseRemoveSafe(element2, new HalfTreeNodeVisitor(e5.c, a2.a.a.c1.a.a.a, new a2.a.a.c1.a.b(i, i2)));
                JsoupExtensionsKt.traverseRemoveSafe(e2, new HalfTreeNodeVisitor(e5.d, new d5(1, objectRef2), new w5(1, i2)));
                node.removeAttr("label");
                T t = objectRef.element;
                if (t != null) {
                    t.removeAttr("label");
                }
                T t2 = objectRef2.element;
                if (t2 != null) {
                    t2.removeAttr("label");
                }
                String wholeText = e.wholeText();
                Intrinsics.checkNotNullExpressionValue(wholeText, "parentLeftCopy.wholeText()");
                if (wholeText.length() == 0) {
                    e.remove();
                }
                String wholeText2 = e2.wholeText();
                Intrinsics.checkNotNullExpressionValue(wholeText2, "parentRightCopy.wholeText()");
                if (wholeText2.length() == 0) {
                    e2.remove();
                }
                parent.insertChildren(element2.siblingIndex(), element2.childNodes());
                element2.remove();
                return new MutableHtmlNode.OperationResult(null, 0, 1, null);
            }
        } else if (node instanceof TextNode) {
            TextNode textNode = (TextNode) node;
            String wholeText3 = textNode.getWholeText();
            Intrinsics.checkNotNullExpressionValue(wholeText3, "text");
            Objects.requireNonNull(wholeText3, "null cannot be cast to non-null type java.lang.String");
            String substring = wholeText3.substring(0, i);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String substring2 = wholeText3.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            String substring3 = wholeText3.substring(i2, wholeText3.length());
            Intrinsics.checkNotNullExpressionValue(substring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            int siblingIndex = textNode.siblingIndex();
            Node parent2 = textNode.parent();
            Objects.requireNonNull(parent2, "null cannot be cast to non-null type org.jsoup.nodes.Element");
            Element element3 = (Element) parent2;
            if (substring3.length() > 0) {
                element3.insertChildren(siblingIndex, new TextNode(substring3));
            }
            if (substring2.length() > 0) {
                Element element4 = new Element(str);
                textNode.text(substring2);
                element4.appendChild(textNode);
                i3 = 1;
                element3.insertChildren(siblingIndex, element4);
            } else {
                i3 = 1;
            }
            if (substring.length() > 0) {
                Node[] nodeArr = new Node[i3];
                nodeArr[0] = new TextNode(substring);
                element3.insertChildren(siblingIndex, nodeArr);
            }
            return new MutableHtmlNode.OperationResult(null, 0, i3, null);
        } else if (!(node instanceof Element) || !JsoupExtensionsKt.isBlankRow(node)) {
            return new MutableHtmlNode.OperationResult(null, 0, 1, null);
        } else {
            Element parent3 = ((Element) node).parent();
            int siblingIndex2 = node.siblingIndex();
            Element element5 = new Element(str);
            element5.insertChildren(0, node);
            parent3.insertChildren(siblingIndex2, element5);
            return new MutableHtmlNode.OperationResult(null, 0, 1, null);
        }
    }

    public final MutableHtmlNode.OperationResult c(Node node, String str, FormatChange.Type type) {
        int ordinal = type.ordinal();
        if (ordinal == 0) {
            return a(node, str);
        }
        if (ordinal == 1) {
            return g(node);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final MutableHtmlNode.OperationResult d(Element element, Element element2) {
        if (!(!Intrinsics.areEqual(element.normalName(), "li"))) {
            Element parent = element.parent();
            Intrinsics.checkNotNullExpressionValue(parent, "parent()");
            if (JsoupExtensionsKt.isListRoot(parent)) {
                element.attr("label", JsoupExtensionsKt.SPLIT_MARK);
                Element parent2 = element.parent();
                Element parent3 = parent2.parent();
                Intrinsics.checkNotNullExpressionValue(parent2, "listRoot");
                Element e = e(parent2);
                parent3.insertChildren(parent2.siblingIndex(), e, element2);
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.element = null;
                JsoupExtensionsKt.traverseRemoveSafe(e, new HalfTreeNodeVisitor(a.b, new c(objectRef), b.b));
                JsoupExtensionsKt.traverseRemoveSafe(parent2, new HalfTreeNodeVisitor(a.c, d.a, b.c));
                T t = objectRef.element;
                if (t != null) {
                    t.remove();
                }
                element.remove();
                if (parent2.childrenSize() == 0) {
                    parent2.remove();
                }
                if (e.childrenSize() == 0) {
                    e.remove();
                }
                return new MutableHtmlNode.OperationResult(null, 0, 1, null);
            }
        }
        return null;
    }

    public final Element e(Element element) {
        Element element2 = new Element(element.normalName());
        List<Node> childNodesCopy = element.childNodesCopy();
        Intrinsics.checkNotNullExpressionValue(childNodesCopy, "childNodesCopy()");
        Iterator<T> it = childNodesCopy.iterator();
        while (it.hasNext()) {
            element2.appendChild(it.next());
        }
        return element2;
    }

    public final void f(Element element, Element element2) {
        Element element3 = new Element("li");
        element2.appendChild(element3);
        element3.insertChildren(0, element.childNodes());
    }

    public final MutableHtmlNode.OperationResult g(Node node) {
        if (!(node instanceof Element) || !JsoupExtensionsKt.isListElement(node)) {
            Element findClosestBlockParent = JsoupExtensionsKt.findClosestBlockParent(node);
            if (findClosestBlockParent != null) {
                return g(findClosestBlockParent);
            }
            return null;
        }
        Element element = (Element) node;
        Element element2 = new Element("p");
        element2.insertChildren(0, node.childNodes());
        return d(element, element2);
    }

    @Override // com.avito.android.html_formatter.SupportsFormatHtmlNode
    public int getFormat() {
        int i;
        int i2 = 0;
        for (T t : JsoupExtensionsKt.getNodesUpToTheRoot(this.a)) {
            if (!(t instanceof Element)) {
                t = null;
            }
            T t2 = t;
            if (t2 != null) {
                String normalName = t2.normalName();
                if (normalName != null) {
                    int hashCode = normalName.hashCode();
                    if (hashCode != -891980137) {
                        if (hashCode != 3240) {
                            if (hashCode != 3549) {
                                if (hashCode == 3735 && normalName.equals("ul")) {
                                    i = 4;
                                    i2 |= i;
                                }
                            } else if (normalName.equals("ol")) {
                                i = 8;
                                i2 |= i;
                            }
                        } else if (normalName.equals(UserDataStore.EMAIL)) {
                            i = 2;
                            i2 |= i;
                        }
                    } else if (normalName.equals("strong")) {
                        i = 1;
                        i2 |= i;
                    }
                }
                i = 0;
                i2 |= i;
            }
        }
        return i2;
    }
}
