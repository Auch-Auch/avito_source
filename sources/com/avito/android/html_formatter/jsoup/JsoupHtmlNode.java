package com.avito.android.html_formatter.jsoup;

import android.text.SpannableStringBuilder;
import com.avito.android.html_formatter.HtmlCharSequence;
import com.avito.android.html_formatter.HtmlNode;
import com.avito.android.html_formatter.HtmlRenderOptions;
import com.avito.android.html_formatter.MutableHtmlNode;
import com.avito.android.html_formatter.span.NodeSpan;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeVisitor;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001:\u0002\u001f'B\u000f\u0012\u0006\u0010$\u001a\u00020\u001e¢\u0006\u0004\b%\u0010&J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0016\u0010\u0013J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0011\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u0019\u0010\u0018J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u001a\u0010\u0018J\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u000e*\u0004\u0018\u00010\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010$\u001a\u00020\u001e8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\u001f\u0010!\u001a\u0004\b\"\u0010#¨\u0006("}, d2 = {"Lcom/avito/android/html_formatter/jsoup/JsoupHtmlNode;", "Lcom/avito/android/html_formatter/HtmlNode;", "Lcom/avito/android/html_formatter/HtmlRenderOptions;", "options", "Lcom/avito/android/html_formatter/HtmlCharSequence;", "render", "(Lcom/avito/android/html_formatter/HtmlRenderOptions;)Lcom/avito/android/html_formatter/HtmlCharSequence;", "", "getHtml", "()Ljava/lang/String;", "another", "getCommonParent", "(Lcom/avito/android/html_formatter/HtmlNode;)Lcom/avito/android/html_formatter/HtmlNode;", "anotherNode", "", "isChildOf", "(Lcom/avito/android/html_formatter/HtmlNode;)Z", "isParentOf", "isBlock", "()Z", "isTextNode", "isBlankLine", "isRoot", "getFirstChildTextNode", "()Lcom/avito/android/html_formatter/HtmlNode;", "getFirstBlankRow", "getLeftSiblingBlock", "Lcom/avito/android/html_formatter/MutableHtmlNode;", "asMutable", "()Lcom/avito/android/html_formatter/MutableHtmlNode;", "Lorg/jsoup/nodes/Node;", AuthSource.SEND_ABUSE, "(Lorg/jsoup/nodes/Node;)Z", "Lorg/jsoup/nodes/Node;", "getNode", "()Lorg/jsoup/nodes/Node;", "node", "<init>", "(Lorg/jsoup/nodes/Node;)V", AuthSource.BOOKING_ORDER, "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public class JsoupHtmlNode implements HtmlNode {
    @NotNull
    public final Node a;

    public static final class a implements NodeVisitor {
        public final Function1<Element, Unit> a;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super org.jsoup.nodes.Element, kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull Function1<? super Element, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "action");
            this.a = function1;
        }

        @Override // org.jsoup.select.NodeVisitor
        public void head(@Nullable Node node, int i) {
        }

        @Override // org.jsoup.select.NodeVisitor
        public void tail(@Nullable Node node, int i) {
            if (node instanceof Element) {
                this.a.invoke(node);
            }
        }
    }

    public static final class b implements NodeVisitor {
        public final Function1<TextNode, Unit> a;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: kotlin.jvm.functions.Function1<? super org.jsoup.nodes.TextNode, kotlin.Unit> */
        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull Function1<? super TextNode, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "action");
            this.a = function1;
        }

        @Override // org.jsoup.select.NodeVisitor
        public void head(@Nullable Node node, int i) {
        }

        @Override // org.jsoup.select.NodeVisitor
        public void tail(@Nullable Node node, int i) {
            if (node instanceof TextNode) {
                this.a.invoke(node);
            }
        }
    }

    public static final class c extends Lambda implements Function1<Element, Unit> {
        public final /* synthetic */ Ref.ObjectRef a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Ref.ObjectRef objectRef) {
            super(1);
            this.a = objectRef;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Element element) {
            T t = (T) element;
            Intrinsics.checkNotNullParameter(t, "it");
            if (this.a.element == null && Intrinsics.areEqual(t.normalName(), "br")) {
                this.a.element = t;
            }
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<TextNode, Unit> {
        public final /* synthetic */ Ref.ObjectRef a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Ref.ObjectRef objectRef) {
            super(1);
            this.a = objectRef;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(TextNode textNode) {
            T t = (T) textNode;
            Intrinsics.checkNotNullParameter(t, "it");
            Ref.ObjectRef objectRef = this.a;
            if (objectRef.element == null) {
                objectRef.element = t;
            }
            return Unit.INSTANCE;
        }
    }

    public JsoupHtmlNode(@NotNull Node node) {
        Intrinsics.checkNotNullParameter(node, "node");
        this.a = node;
    }

    public static final void access$appendRenderedText(JsoupHtmlNode jsoupHtmlNode, SpannableStringBuilder spannableStringBuilder, String str, HtmlRenderOptions htmlRenderOptions, Node node) {
        Objects.requireNonNull(jsoupHtmlNode);
        if (htmlRenderOptions.getMarkupForEdit()) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str);
            spannableStringBuilder.setSpan(new NodeSpan(new MutableJsoupHtmlNode(node)), length, spannableStringBuilder.length(), 33);
            return;
        }
        Intrinsics.checkNotNullExpressionValue(spannableStringBuilder.append((CharSequence) str), "append(text)");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r1, "p") != false) goto L_0x00a9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String access$getHeadTextFromNode(com.avito.android.html_formatter.jsoup.JsoupHtmlNode r6, org.jsoup.nodes.Node r7) {
        /*
        // Method dump skipped, instructions count: 258
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.html_formatter.jsoup.JsoupHtmlNode.access$getHeadTextFromNode(com.avito.android.html_formatter.jsoup.JsoupHtmlNode, org.jsoup.nodes.Node):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007f, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r12.normalName(), "ol") != false) goto L_0x008b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object access$getSpanForNode(com.avito.android.html_formatter.jsoup.JsoupHtmlNode r9, org.jsoup.nodes.Element r10, com.avito.android.html_formatter.jsoup.BulletProvider r11, com.avito.android.html_formatter.HtmlRenderOptions r12) {
        /*
            java.util.Objects.requireNonNull(r9)
            java.lang.String r9 = r10.normalName()
            if (r9 != 0) goto L_0x000b
            goto L_0x00b7
        L_0x000b:
            int r0 = r9.hashCode()
            r1 = -891980137(0xffffffffcad57697, float:-6994763.5)
            r2 = 1
            if (r0 == r1) goto L_0x00a9
            r1 = 3240(0xca8, float:4.54E-42)
            if (r0 == r1) goto L_0x009a
            r1 = 3453(0xd7d, float:4.839E-42)
            if (r0 == r1) goto L_0x001f
            goto L_0x00b7
        L_0x001f:
            java.lang.String r0 = "li"
            boolean r9 = r9.equals(r0)
            if (r9 == 0) goto L_0x00b7
            com.avito.android.html_formatter.span.ListElementSpan r9 = new com.avito.android.html_formatter.span.ListElementSpan
            int r4 = r12.getListBulletLeftMargin()
            int r5 = r12.getListBulletRightMargin()
            int r6 = r12.getListBulletWidth()
            java.lang.String r12 = r10.normalName()
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual(r12, r0)
            r0 = 0
            if (r12 == 0) goto L_0x008a
            org.jsoup.select.Elements r10 = r10.parents()
            java.lang.String r12 = "parents()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r12)
            java.util.Iterator r10 = r10.iterator()
        L_0x004d:
            boolean r12 = r10.hasNext()
            if (r12 == 0) goto L_0x0082
            java.lang.Object r12 = r10.next()
            org.jsoup.nodes.Element r12 = (org.jsoup.nodes.Element) r12
            java.lang.String r1 = r12.normalName()
            java.lang.String r3 = "ul"
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            java.lang.String r3 = "ol"
            if (r1 != 0) goto L_0x0074
            java.lang.String r1 = r12.normalName()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r3)
            if (r1 == 0) goto L_0x0072
            goto L_0x0074
        L_0x0072:
            r1 = 0
            goto L_0x0075
        L_0x0074:
            r1 = 1
        L_0x0075:
            if (r1 == 0) goto L_0x004d
            java.lang.String r10 = r12.normalName()
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual(r10, r3)
            if (r10 == 0) goto L_0x008a
            goto L_0x008b
        L_0x0082:
            java.util.NoSuchElementException r9 = new java.util.NoSuchElementException
            java.lang.String r10 = "Collection contains no element matching the predicate."
            r9.<init>(r10)
            throw r9
        L_0x008a:
            r2 = 0
        L_0x008b:
            if (r2 == 0) goto L_0x0090
            r10 = -1
            r7 = -1
            goto L_0x0091
        L_0x0090:
            r7 = 0
        L_0x0091:
            java.util.List r8 = r11.getCurrentBulletList()
            r3 = r9
            r3.<init>(r4, r5, r6, r7, r8)
            goto L_0x00b8
        L_0x009a:
            java.lang.String r10 = "em"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x00b7
            android.text.style.StyleSpan r9 = new android.text.style.StyleSpan
            r10 = 2
            r9.<init>(r10)
            goto L_0x00b8
        L_0x00a9:
            java.lang.String r10 = "strong"
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x00b7
            android.text.style.StyleSpan r9 = new android.text.style.StyleSpan
            r9.<init>(r2)
            goto L_0x00b8
        L_0x00b7:
            r9 = 0
        L_0x00b8:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.html_formatter.jsoup.JsoupHtmlNode.access$getSpanForNode(com.avito.android.html_formatter.jsoup.JsoupHtmlNode, org.jsoup.nodes.Element, com.avito.android.html_formatter.jsoup.BulletProvider, com.avito.android.html_formatter.HtmlRenderOptions):java.lang.Object");
    }

    public static final String access$getTailTextFromNode(JsoupHtmlNode jsoupHtmlNode, Node node) {
        Objects.requireNonNull(jsoupHtmlNode);
        if (node instanceof TextNode) {
            return ((TextNode) node).getWholeText();
        }
        return null;
    }

    public static final boolean access$isRoot(JsoupHtmlNode jsoupHtmlNode, Node node) {
        Objects.requireNonNull(jsoupHtmlNode);
        return (node instanceof Element) && Intrinsics.areEqual(((Element) node).normalName(), SDKConstants.PARAM_A2U_BODY);
    }

    public final boolean a(Node node) {
        return (node instanceof Element) && Intrinsics.areEqual(((Element) node).normalName(), "br");
    }

    @Override // com.avito.android.html_formatter.HtmlNode
    @NotNull
    public MutableHtmlNode asMutable() {
        return new MutableJsoupHtmlNode(this.a);
    }

    @Override // com.avito.android.html_formatter.HtmlNode
    @Nullable
    public HtmlNode getCommonParent(@Nullable HtmlNode htmlNode) {
        Node node;
        if (!(htmlNode instanceof JsoupHtmlNode)) {
            htmlNode = null;
        }
        JsoupHtmlNode jsoupHtmlNode = (JsoupHtmlNode) htmlNode;
        if (jsoupHtmlNode == null || (node = (Node) CollectionsKt___CollectionsKt.firstOrNull(CollectionsKt___CollectionsKt.intersect(JsoupExtensionsKt.getNodesUpToTheRoot(this.a), JsoupExtensionsKt.getNodesUpToTheRoot(jsoupHtmlNode.a)))) == null) {
            return null;
        }
        return new JsoupHtmlNode(node);
    }

    @Override // com.avito.android.html_formatter.HtmlNode
    @Nullable
    public HtmlNode getFirstBlankRow() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        this.a.traverse(new a(new c(objectRef)));
        T t = objectRef.element;
        if (t != null) {
            return new JsoupHtmlNode(t);
        }
        return null;
    }

    @Override // com.avito.android.html_formatter.HtmlNode
    @Nullable
    public HtmlNode getFirstChildTextNode() {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        this.a.traverse(new b(new d(objectRef)));
        T t = objectRef.element;
        if (t != null) {
            return new JsoupHtmlNode(t);
        }
        return null;
    }

    @Override // com.avito.android.html_formatter.HtmlNode
    @NotNull
    public String getHtml() {
        StringBuilder sb = new StringBuilder();
        List<Node> childNodes = this.a.childNodes();
        Intrinsics.checkNotNullExpressionValue(childNodes, "node\n                .childNodes()");
        ArrayList<String> arrayList = new ArrayList(e.collectionSizeOrDefault(childNodes, 10));
        Iterator<T> it = childNodes.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().outerHtml());
        }
        for (String str : arrayList) {
            sb.append(str);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply {\n…t) }\n        }.toString()");
        return sb2;
    }

    @Override // com.avito.android.html_formatter.HtmlNode
    @Nullable
    public HtmlNode getLeftSiblingBlock() {
        Element parent;
        Element previousElementSibling;
        Node previousSibling = this.a.previousSibling();
        if (previousSibling != null) {
            return new JsoupHtmlNode(previousSibling);
        }
        Node node = this.a;
        if (!(node instanceof Element) || !Intrinsics.areEqual(((Element) node).normalName(), "li") || (parent = ((Element) this.a).parent()) == null || (previousElementSibling = parent.previousElementSibling()) == null) {
            return null;
        }
        return new JsoupHtmlNode(previousElementSibling);
    }

    @NotNull
    public final Node getNode() {
        return this.a;
    }

    @Override // com.avito.android.html_formatter.HtmlNode
    public boolean isBlankLine() {
        Node node = this.a;
        return (node instanceof Element) && Intrinsics.areEqual(((Element) node).normalName(), "br");
    }

    @Override // com.avito.android.html_formatter.HtmlNode
    public boolean isBlock() {
        Node node = this.a;
        return (node instanceof Element) && ((Element) node).isBlock();
    }

    @Override // com.avito.android.html_formatter.HtmlNode
    public boolean isChildOf(@NotNull HtmlNode htmlNode) {
        Intrinsics.checkNotNullParameter(htmlNode, "anotherNode");
        if (!(htmlNode instanceof JsoupHtmlNode)) {
            htmlNode = null;
        }
        JsoupHtmlNode jsoupHtmlNode = (JsoupHtmlNode) htmlNode;
        if (jsoupHtmlNode == null) {
            return false;
        }
        List<Node> nodesUpToTheRoot = JsoupExtensionsKt.getNodesUpToTheRoot(this.a);
        if ((nodesUpToTheRoot instanceof Collection) && nodesUpToTheRoot.isEmpty()) {
            return false;
        }
        Iterator<T> it = nodesUpToTheRoot.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next(), jsoupHtmlNode.a)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.avito.android.html_formatter.HtmlNode
    public boolean isParentOf(@NotNull HtmlNode htmlNode) {
        Intrinsics.checkNotNullParameter(htmlNode, "anotherNode");
        if (!(htmlNode instanceof JsoupHtmlNode)) {
            htmlNode = null;
        }
        JsoupHtmlNode jsoupHtmlNode = (JsoupHtmlNode) htmlNode;
        if (jsoupHtmlNode == null) {
            return false;
        }
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = false;
        this.a.traverse(new NodeVisitor(booleanRef, jsoupHtmlNode) { // from class: com.avito.android.html_formatter.jsoup.JsoupHtmlNode$isParentOf$1
            public final /* synthetic */ Ref.BooleanRef a;
            public final /* synthetic */ JsoupHtmlNode b;

            {
                this.a = r1;
                this.b = r2;
            }

            @Override // org.jsoup.select.NodeVisitor
            public void head(@Nullable Node node, int i) {
                Ref.BooleanRef booleanRef2 = this.a;
                booleanRef2.element = booleanRef2.element || Intrinsics.areEqual(node, this.b.getNode());
            }

            @Override // org.jsoup.select.NodeVisitor
            public void tail(@Nullable Node node, int i) {
            }
        });
        return booleanRef.element;
    }

    @Override // com.avito.android.html_formatter.HtmlNode
    public boolean isRoot() {
        Node node = this.a;
        return (node instanceof Element) && Intrinsics.areEqual(((Element) node).normalName(), SDKConstants.PARAM_A2U_BODY);
    }

    @Override // com.avito.android.html_formatter.HtmlNode
    public boolean isTextNode() {
        return this.a instanceof TextNode;
    }

    @Override // com.avito.android.html_formatter.HtmlNode
    @NotNull
    public HtmlCharSequence render(@NotNull HtmlRenderOptions htmlRenderOptions) {
        Intrinsics.checkNotNullParameter(htmlRenderOptions, "options");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        this.a.traverse(new NodeVisitor(this, spannableStringBuilder, htmlRenderOptions, new Stack(), new BulletProviderImpl(htmlRenderOptions)) { // from class: com.avito.android.html_formatter.jsoup.JsoupHtmlNode$render$1
            public final /* synthetic */ JsoupHtmlNode a;
            public final /* synthetic */ SpannableStringBuilder b;
            public final /* synthetic */ HtmlRenderOptions c;
            public final /* synthetic */ Stack d;
            public final /* synthetic */ BulletProvider e;

            {
                this.a = r1;
                this.b = r2;
                this.c = r3;
                this.d = r4;
                this.e = r5;
            }

            @Override // org.jsoup.select.NodeVisitor
            public void head(@Nullable Node node, int i) {
                if (node != null && !(node instanceof TextNode) && !JsoupHtmlNode.access$isRoot(this.a, node)) {
                    String access$getHeadTextFromNode = JsoupHtmlNode.access$getHeadTextFromNode(this.a, node);
                    if (access$getHeadTextFromNode != null) {
                        JsoupHtmlNode.access$appendRenderedText(this.a, this.b, access$getHeadTextFromNode, this.c, node);
                    }
                    this.d.push(Integer.valueOf(this.b.length()));
                    this.e.populateBulletListIfNeeded(node);
                }
            }

            @Override // org.jsoup.select.NodeVisitor
            public void tail(@Nullable Node node, int i) {
                if (node != null && !JsoupHtmlNode.access$isRoot(this.a, node)) {
                    String access$getTailTextFromNode = JsoupHtmlNode.access$getTailTextFromNode(this.a, node);
                    if (access$getTailTextFromNode != null) {
                        JsoupHtmlNode.access$appendRenderedText(this.a, this.b, access$getTailTextFromNode, this.c, node);
                    }
                    if (node instanceof Element) {
                        Integer num = (Integer) this.d.pop();
                        int length = this.b.length();
                        Object access$getSpanForNode = JsoupHtmlNode.access$getSpanForNode(this.a, (Element) node, this.e, this.c);
                        if (access$getSpanForNode != null) {
                            SpannableStringBuilder spannableStringBuilder2 = this.b;
                            Intrinsics.checkNotNullExpressionValue(num, "from");
                            spannableStringBuilder2.setSpan(access$getSpanForNode, num.intValue(), length, 33);
                        }
                    }
                    this.e.truncateBulletListIfNeeded(node);
                }
            }
        });
        return new HtmlCharSequence(spannableStringBuilder);
    }
}
