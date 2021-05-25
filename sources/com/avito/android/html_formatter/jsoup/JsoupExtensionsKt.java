package com.avito.android.html_formatter.jsoup;

import com.avito.android.html_formatter.MutableHtmlNode;
import com.avito.android.html_formatter.SupportsDeleteHtmlNode;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeVisitor;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0006\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0003\u001a\u0013\u0010\u0005\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0003\u001a\u0013\u0010\u0006\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0006\u0010\u0003\u001a\u0013\u0010\u0007\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\u0003\u001a\u0013\u0010\b\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\u0003\u001a\u0015\u0010\u000b\u001a\u0004\u0018\u00010\n*\u00020\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001d\u0010\u000f\u001a\u0004\u0018\u00010\t*\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0015\u0010\u0011\u001a\u0004\u0018\u00010\t*\u00020\tH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0015\u0010\u0015\u001a\u0004\u0018\u00010\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0015\u0010\u0014\u001a\u001b\u0010\u0018\u001a\u00020\u0017*\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0013\u0010\u001b\u001a\u00020\u001a*\u00020\tH\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001b\u0010\u001b\u001a\u00020\u001a*\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001dH\u0000¢\u0006\u0004\b\u001b\u0010\u001f\u001a\u001b\u0010\"\u001a\u00020\u0017*\u00020\u00002\u0006\u0010!\u001a\u00020 H\u0000¢\u0006\u0004\b\"\u0010#\u001a\u0015\u0010$\u001a\u0004\u0018\u00010\t*\u00020\u0000H\u0000¢\u0006\u0004\b$\u0010%\u001a\u0013\u0010&\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b&\u0010\u0003\u001a\u0013\u0010'\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b'\u0010\u0003\u001a\u001d\u0010*\u001a\u00020\u001a*\u00020\u00002\b\u0010)\u001a\u0004\u0018\u00010(H\u0000¢\u0006\u0004\b*\u0010+\u001a\u0019\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00000,*\u00020\u0000H\u0000¢\u0006\u0004\b-\u0010.\"\u0016\u0010/\u001a\u00020\r8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b/\u00100\"\u0016\u00101\u001a\u00020\r8\u0000@\u0000XT¢\u0006\u0006\n\u0004\b1\u00100¨\u00062"}, d2 = {"Lorg/jsoup/nodes/Node;", "", "isListRoot", "(Lorg/jsoup/nodes/Node;)Z", "isListElement", "isBlankRow", "isRoot", "isBlockElement", "isInlineElement", "Lorg/jsoup/nodes/Element;", "Lorg/jsoup/nodes/TextNode;", "getFirstChildTextNode", "(Lorg/jsoup/nodes/Element;)Lorg/jsoup/nodes/TextNode;", "", "tagName", "getFirstChildElement", "(Lorg/jsoup/nodes/Element;Ljava/lang/String;)Lorg/jsoup/nodes/Element;", "getFirstChildBlankRow", "(Lorg/jsoup/nodes/Element;)Lorg/jsoup/nodes/Element;", "getSiblingNodeInRowFromLeft", "(Lorg/jsoup/nodes/Node;)Lorg/jsoup/nodes/Node;", "getSiblingNodeInRowFromRight", "insertedNode", "", "splitListWithNode", "(Lorg/jsoup/nodes/Element;Lorg/jsoup/nodes/Element;)V", "Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "splitParentBlock", "(Lorg/jsoup/nodes/Element;)Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "", "where", "(Lorg/jsoup/nodes/TextNode;I)Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "Lorg/jsoup/select/NodeVisitor;", "visitor", "traverseRemoveSafe", "(Lorg/jsoup/nodes/Node;Lorg/jsoup/select/NodeVisitor;)V", "findClosestBlockParent", "(Lorg/jsoup/nodes/Node;)Lorg/jsoup/nodes/Element;", "isLeafInListElementSubtree", "isLeafInBlockParentSubtree", "Lcom/avito/android/html_formatter/SupportsDeleteHtmlNode$OperationTransaction;", "transaction", ProductAction.ACTION_REMOVE, "(Lorg/jsoup/nodes/Node;Lcom/avito/android/html_formatter/SupportsDeleteHtmlNode$OperationTransaction;)Lcom/avito/android/html_formatter/MutableHtmlNode$OperationResult;", "", "getNodesUpToTheRoot", "(Lorg/jsoup/nodes/Node;)Ljava/util/List;", "SPLIT_MARK", "Ljava/lang/String;", "ATTR_SPLIT_LABEL", "html-formatter_release"}, k = 2, mv = {1, 4, 2})
public final class JsoupExtensionsKt {
    @NotNull
    public static final String ATTR_SPLIT_LABEL = "label";
    @NotNull
    public static final String SPLIT_MARK = "split";

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function2<Node, Integer, Unit> {
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

    /* compiled from: kotlin-style lambda group */
    public static final class b extends Lambda implements Function2<Node, Integer, Boolean> {
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
    public static final class c extends Lambda implements Function2<Node, Integer, Unit> {
        public static final c b = new c(0);
        public static final c c = new c(1);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(int i) {
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
                if (num.intValue() < 0 && node2 != null && node2.childNodeSize() == 0) {
                    node2.remove();
                }
                return Unit.INSTANCE;
            } else if (i == 1) {
                Node node3 = node;
                if (num.intValue() > 0 && node3 != null && node3.childNodeSize() == 0) {
                    node3.remove();
                }
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class d extends Lambda implements Function2<Node, Integer, Boolean> {
        public static final d b = new d(0);
        public static final d c = new d(1);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(int i) {
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
    public static final class e extends Lambda implements Function2<Node, Integer, Boolean> {
        public static final e b = new e(0);
        public static final e c = new e(1);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(int i) {
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
    public static final class f extends Lambda implements Function2<Node, Integer, Unit> {
        public static final f b = new f(0);
        public static final f c = new f(1);
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(int i) {
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

    public static final class g extends Lambda implements Function1<Element, Unit> {
        public final /* synthetic */ Ref.ObjectRef a;
        public final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(Ref.ObjectRef objectRef, String str) {
            super(1);
            this.a = objectRef;
            this.b = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Element element) {
            T t = (T) element;
            Intrinsics.checkNotNullParameter(t, "it");
            if (this.a.element == null && Intrinsics.areEqual(t.normalName(), this.b)) {
                this.a.element = t;
            }
            return Unit.INSTANCE;
        }
    }

    public static final class h extends Lambda implements Function1<TextNode, Unit> {
        public final /* synthetic */ Ref.ObjectRef a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(Ref.ObjectRef objectRef) {
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

    public static final class i extends Lambda implements Function2<Node, Integer, Boolean> {
        public static final i a = new i();

        public i() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Boolean invoke(Node node, Integer num) {
            Node node2 = node;
            num.intValue();
            boolean z = true;
            if (node2 == null || !node2.hasAttr("label")) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    public static final class j extends Lambda implements Function2<Node, Integer, Unit> {
        public final /* synthetic */ Ref.ObjectRef a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(Ref.ObjectRef objectRef) {
            super(2);
            this.a = objectRef;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Node node, Integer num) {
            T t = (T) node;
            if (num.intValue() < 0 && ((t instanceof TextNode) || (t != null && JsoupExtensionsKt.isBlankRow(t)))) {
                this.a.element = t;
            }
            return Unit.INSTANCE;
        }
    }

    public static final class k extends Lambda implements Function2<Node, Integer, Unit> {
        public static final k a = new k();

        public k() {
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

    public static final class l extends Lambda implements Function2<Node, Integer, Boolean> {
        public static final l a = new l();

        public l() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Boolean invoke(Node node, Integer num) {
            Node node2 = node;
            num.intValue();
            boolean z = true;
            if (node2 == null || !node2.hasAttr("label")) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
    }

    public static final class m extends Lambda implements Function2<Node, Integer, Unit> {
        public final /* synthetic */ Ref.ObjectRef a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(Ref.ObjectRef objectRef) {
            super(2);
            this.a = objectRef;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Node node, Integer num) {
            T t = (T) node;
            int intValue = num.intValue();
            if (this.a.element == null && intValue > 0 && ((t instanceof TextNode) || (t != null && JsoupExtensionsKt.isBlankRow(t)))) {
                this.a.element = t;
            }
            return Unit.INSTANCE;
        }
    }

    public static final class n extends Lambda implements Function2<Node, Integer, Unit> {
        public static final n a = new n();

        public n() {
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

    public static final class o extends Lambda implements Function2<Node, Integer, Unit> {
        public final /* synthetic */ Ref.ObjectRef a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(Ref.ObjectRef objectRef) {
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

    public static final class p extends Lambda implements Function2<Node, Integer, Unit> {
        public static final p a = new p();

        public p() {
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

    public static final class q extends Lambda implements Function2<Node, Integer, Unit> {
        public final /* synthetic */ int a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(int i) {
            super(2);
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Node node, Integer num) {
            Node node2 = node;
            if (num.intValue() == 0 && (node2 instanceof TextNode)) {
                TextNode textNode = (TextNode) node2;
                String wholeText = textNode.getWholeText();
                Intrinsics.checkNotNullExpressionValue(wholeText, "oldText");
                String substring = wholeText.substring(this.a, wholeText.length());
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                textNode.text(substring);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class r extends Lambda implements Function2<Node, Integer, Unit> {
        public final /* synthetic */ Ref.ObjectRef a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public r(Ref.ObjectRef objectRef) {
            super(2);
            this.a = objectRef;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Node node, Integer num) {
            Node node2 = node;
            if (num.intValue() == 0 && (node2 instanceof Element)) {
                this.a.element = (T) ((Element) node2);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class s extends Lambda implements Function2<Node, Integer, Unit> {
        public static final s a = new s();

        public s() {
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

    public static final class t extends Lambda implements Function2<Node, Integer, Unit> {
        public final /* synthetic */ Ref.ObjectRef a;
        public final /* synthetic */ int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public t(Ref.ObjectRef objectRef, int i) {
            super(2);
            this.a = objectRef;
            this.b = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Node node, Integer num) {
            Node node2 = node;
            if (num.intValue() == 0 && (node2 instanceof TextNode)) {
                T t = (T) ((TextNode) node2);
                this.a.element = t;
                String wholeText = t.getWholeText();
                Intrinsics.checkNotNullExpressionValue(wholeText, "node.wholeText");
                int i = this.b;
                Objects.requireNonNull(wholeText, "null cannot be cast to non-null type java.lang.String");
                String substring = wholeText.substring(0, i);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                t.text(substring);
            }
            return Unit.INSTANCE;
        }
    }

    @Nullable
    public static final Element findClosestBlockParent(@NotNull Node node) {
        boolean z;
        Intrinsics.checkNotNullParameter(node, "$this$findClosestBlockParent");
        while (true) {
            z = node instanceof Element;
            Element element = (Element) (!z ? null : node);
            if (element != null && element.isBlock()) {
                break;
            }
            node = node.parentNode();
            Intrinsics.checkNotNullExpressionValue(node, "node.parentNode()");
        }
        Element element2 = (Element) (!z ? null : node);
        if (element2 == null || !((Element) node).isBlock()) {
            return null;
        }
        return element2;
    }

    @Nullable
    public static final Element getFirstChildBlankRow(@NotNull Element element) {
        Intrinsics.checkNotNullParameter(element, "$this$getFirstChildBlankRow");
        return getFirstChildElement(element, "br");
    }

    @Nullable
    public static final Element getFirstChildElement(@NotNull Element element, @NotNull String str) {
        Intrinsics.checkNotNullParameter(element, "$this$getFirstChildElement");
        Intrinsics.checkNotNullParameter(str, "tagName");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        element.traverse((NodeVisitor) new ElementVisitor(new g(objectRef, str)));
        return objectRef.element;
    }

    @Nullable
    public static final TextNode getFirstChildTextNode(@NotNull Element element) {
        Intrinsics.checkNotNullParameter(element, "$this$getFirstChildTextNode");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        element.traverse((NodeVisitor) new TextVisitor(new h(objectRef)));
        return objectRef.element;
    }

    @NotNull
    public static final List<Node> getNodesUpToTheRoot(@NotNull Node node) {
        Intrinsics.checkNotNullParameter(node, "$this$getNodesUpToTheRoot");
        ArrayList arrayList = new ArrayList();
        arrayList.add(node);
        if (node instanceof Element) {
            Elements parents = ((Element) node).parents();
            Intrinsics.checkNotNullExpressionValue(parents, "this.parents()");
            arrayList.addAll(parents);
        } else if (node instanceof TextNode) {
            Node parent = node.parent();
            Intrinsics.checkNotNullExpressionValue(parent, "parent()");
            arrayList.add(parent);
            Node parent2 = node.parent();
            Objects.requireNonNull(parent2, "null cannot be cast to non-null type org.jsoup.nodes.Element");
            Elements parents2 = ((Element) parent2).parents();
            Intrinsics.checkNotNullExpressionValue(parents2, "(parent() as Element).parents()");
            arrayList.addAll(parents2);
        }
        return arrayList;
    }

    @Nullable
    public static final Node getSiblingNodeInRowFromLeft(@NotNull Node node) {
        Intrinsics.checkNotNullParameter(node, "$this$getSiblingNodeInRowFromLeft");
        Element findClosestBlockParent = findClosestBlockParent(node);
        if (findClosestBlockParent == null) {
            return null;
        }
        node.attr("label", SPLIT_MARK);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        findClosestBlockParent.traverse((NodeVisitor) new HalfTreeNodeVisitor(i.a, new j(objectRef), k.a));
        node.removeAttr("label");
        return objectRef.element;
    }

    @Nullable
    public static final Node getSiblingNodeInRowFromRight(@NotNull Node node) {
        Intrinsics.checkNotNullParameter(node, "$this$getSiblingNodeInRowFromRight");
        Element findClosestBlockParent = findClosestBlockParent(node);
        if (findClosestBlockParent == null) {
            return null;
        }
        node.attr("label", SPLIT_MARK);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        findClosestBlockParent.traverse((NodeVisitor) new HalfTreeNodeVisitor(l.a, new m(objectRef), n.a));
        node.removeAttr("label");
        return objectRef.element;
    }

    public static final boolean isBlankRow(@NotNull Node node) {
        Intrinsics.checkNotNullParameter(node, "$this$isBlankRow");
        return (node instanceof Element) && Intrinsics.areEqual(((Element) node).normalName(), "br");
    }

    public static final boolean isBlockElement(@NotNull Node node) {
        Intrinsics.checkNotNullParameter(node, "$this$isBlockElement");
        return (node instanceof Element) && ((Element) node).isBlock();
    }

    public static final boolean isInlineElement(@NotNull Node node) {
        Intrinsics.checkNotNullParameter(node, "$this$isInlineElement");
        return (node instanceof Element) && !((Element) node).isBlock();
    }

    public static final boolean isLeafInBlockParentSubtree(@NotNull Node node) {
        Intrinsics.checkNotNullParameter(node, "$this$isLeafInBlockParentSubtree");
        while (!isRoot(node) && !isBlockElement(node) && node.previousSibling() == null && node.nextSibling() == null) {
            node = node.parentNode();
            Intrinsics.checkNotNullExpressionValue(node, "currentNode.parentNode()");
        }
        return isBlockElement(node);
    }

    public static final boolean isLeafInListElementSubtree(@NotNull Node node) {
        Intrinsics.checkNotNullParameter(node, "$this$isLeafInListElementSubtree");
        if (isListElement(node)) {
            return false;
        }
        while (!isRoot(node) && !isListElement(node) && node.previousSibling() == null && node.nextSibling() == null) {
            node = node.parentNode();
            Intrinsics.checkNotNullExpressionValue(node, "currentNode.parentNode()");
        }
        return isListElement(node);
    }

    public static final boolean isListElement(@NotNull Node node) {
        Intrinsics.checkNotNullParameter(node, "$this$isListElement");
        if (node instanceof Element) {
            Element element = (Element) node;
            if (Intrinsics.areEqual(element.normalName(), "li")) {
                Element parent = element.parent();
                Intrinsics.checkNotNullExpressionValue(parent, "parent()");
                if (isListRoot(parent)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean isListRoot(@NotNull Node node) {
        Intrinsics.checkNotNullParameter(node, "$this$isListRoot");
        if (node instanceof Element) {
            Element element = (Element) node;
            if (Intrinsics.areEqual(element.normalName(), "ul") || Intrinsics.areEqual(element.normalName(), "ol")) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isRoot(@NotNull Node node) {
        Intrinsics.checkNotNullParameter(node, "$this$isRoot");
        return (node instanceof Element) && Intrinsics.areEqual(((Element) node).normalName(), SDKConstants.PARAM_A2U_BODY);
    }

    @NotNull
    public static final MutableHtmlNode.OperationResult remove(@NotNull Node node, @Nullable SupportsDeleteHtmlNode.OperationTransaction operationTransaction) {
        Intrinsics.checkNotNullParameter(node, "$this$remove");
        Node parent = node.parent();
        if (!(parent instanceof Element)) {
            parent = null;
        }
        Element element = (Element) parent;
        if (element == null) {
            return new MutableHtmlNode.OperationResult(null, 0, 1, null);
        }
        if (operationTransaction != null) {
            operationTransaction.getRemovedNodes().add(node);
        } else {
            node.remove();
        }
        if (isListRoot(element) && element.childrenSize() == 0) {
            element.remove();
        }
        return new MutableHtmlNode.OperationResult(null, 0, 1, null);
    }

    public static final void splitListWithNode(@NotNull Element element, @NotNull Element element2) {
        Intrinsics.checkNotNullParameter(element, "$this$splitListWithNode");
        Intrinsics.checkNotNullParameter(element2, "insertedNode");
        if (isListElement(element)) {
            element.attr("label", SPLIT_MARK);
            Element parent = element.parent();
            Element parent2 = parent.parent();
            Element clone = parent.clone();
            Intrinsics.checkNotNullExpressionValue(clone, "listRoot.clone()");
            parent2.insertChildren(parent.siblingIndex(), clone, element2);
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            objectRef.element = null;
            traverseRemoveSafe(clone, new HalfTreeNodeVisitor(b.b, new o(objectRef), f.b));
            Intrinsics.checkNotNullExpressionValue(parent, "listRoot");
            traverseRemoveSafe(parent, new HalfTreeNodeVisitor(b.c, p.a, f.c));
            T t2 = objectRef.element;
            if (t2 != null) {
                t2.remove();
            }
            element.remove();
            if (parent.childrenSize() == 0) {
                parent.remove();
            }
            if (clone.childrenSize() == 0) {
                clone.remove();
            }
        }
    }

    @NotNull
    public static final MutableHtmlNode.OperationResult splitParentBlock(@NotNull Element element) {
        Intrinsics.checkNotNullParameter(element, "$this$splitParentBlock");
        Element findClosestBlockParent = findClosestBlockParent(element);
        if (findClosestBlockParent == null) {
            return new MutableHtmlNode.OperationResult(null, 0, 1, null);
        }
        element.attr("label", SPLIT_MARK);
        Element clone = findClosestBlockParent.clone();
        Intrinsics.checkNotNullExpressionValue(clone, "blockParent.clone()");
        findClosestBlockParent.parent().insertChildren(findClosestBlockParent.siblingIndex(), clone);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        traverseRemoveSafe(clone, new HalfTreeNodeVisitor(e.b, new r(objectRef), a.b));
        traverseRemoveSafe(findClosestBlockParent, new HalfTreeNodeVisitor(e.c, s.a, a.c));
        element.removeAttr("label");
        T t2 = objectRef.element;
        if (t2 != null) {
            t2.removeAttr("label");
        }
        return new MutableHtmlNode.OperationResult(null, 1, 1, null);
    }

    public static final void traverseRemoveSafe(@NotNull Node node, @NotNull NodeVisitor nodeVisitor) {
        Node node2;
        Intrinsics.checkNotNullParameter(node, "$this$traverseRemoveSafe");
        Intrinsics.checkNotNullParameter(nodeVisitor, "visitor");
        int i2 = 0;
        Node node3 = node;
        while (node3 != null) {
            nodeVisitor.head(node3, i2);
            if (node3.childNodeSize() > 0) {
                node3 = node3.childNode(0);
                i2++;
            } else {
                while (true) {
                    node2 = null;
                    if ((node3 != null ? node3.nextSibling() : null) != null || i2 <= 0) {
                        break;
                    }
                    if (node3 != null) {
                        node2 = node3.parentNode();
                    }
                    nodeVisitor.tail(node3, i2);
                    i2--;
                    node3 = node2;
                }
                if (node3 != null) {
                    node2 = node3.nextSibling();
                }
                nodeVisitor.tail(node3, i2);
                if (node3 != node) {
                    node3 = node2;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ad  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.avito.android.html_formatter.MutableHtmlNode.OperationResult splitParentBlock(@org.jetbrains.annotations.NotNull org.jsoup.nodes.TextNode r11, int r12) {
        /*
            java.lang.String r0 = "$this$splitParentBlock"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            org.jsoup.nodes.Element r0 = findClosestBlockParent(r11)
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x00b8
            java.lang.String r4 = "label"
            java.lang.String r5 = "split"
            r11.attr(r4, r5)
            org.jsoup.nodes.Element r5 = r0.clone()
            java.lang.String r6 = "blockParent.clone()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            org.jsoup.nodes.Element r6 = r0.parent()
            int r7 = r0.siblingIndex()
            org.jsoup.nodes.Node[] r8 = new org.jsoup.nodes.Node[r1]
            r8[r2] = r5
            r6.insertChildren(r7, r8)
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            r6.element = r3
            com.avito.android.html_formatter.jsoup.HalfTreeNodeVisitor r7 = new com.avito.android.html_formatter.jsoup.HalfTreeNodeVisitor
            com.avito.android.html_formatter.jsoup.JsoupExtensionsKt$d r8 = com.avito.android.html_formatter.jsoup.JsoupExtensionsKt.d.c
            com.avito.android.html_formatter.jsoup.JsoupExtensionsKt$t r9 = new com.avito.android.html_formatter.jsoup.JsoupExtensionsKt$t
            r9.<init>(r6, r12)
            com.avito.android.html_formatter.jsoup.JsoupExtensionsKt$c r10 = com.avito.android.html_formatter.jsoup.JsoupExtensionsKt.c.c
            r7.<init>(r8, r9, r10)
            traverseRemoveSafe(r5, r7)
            com.avito.android.html_formatter.jsoup.HalfTreeNodeVisitor r7 = new com.avito.android.html_formatter.jsoup.HalfTreeNodeVisitor
            com.avito.android.html_formatter.jsoup.JsoupExtensionsKt$d r8 = com.avito.android.html_formatter.jsoup.JsoupExtensionsKt.d.b
            com.avito.android.html_formatter.jsoup.JsoupExtensionsKt$q r9 = new com.avito.android.html_formatter.jsoup.JsoupExtensionsKt$q
            r9.<init>(r12)
            com.avito.android.html_formatter.jsoup.JsoupExtensionsKt$c r12 = com.avito.android.html_formatter.jsoup.JsoupExtensionsKt.c.b
            r7.<init>(r8, r9, r12)
            traverseRemoveSafe(r0, r7)
            r11.removeAttr(r4)
            T r12 = r6.element
            org.jsoup.nodes.TextNode r12 = (org.jsoup.nodes.TextNode) r12
            if (r12 == 0) goto L_0x0062
            r12.removeAttr(r4)
        L_0x0062:
            java.lang.String r12 = r0.wholeText()
            java.lang.String r0 = "br"
            if (r12 == 0) goto L_0x007e
            int r12 = r12.length()
            if (r12 != 0) goto L_0x0072
            r12 = 1
            goto L_0x0073
        L_0x0072:
            r12 = 0
        L_0x0073:
            if (r12 != r1) goto L_0x007e
            org.jsoup.nodes.Element r12 = new org.jsoup.nodes.Element
            r12.<init>(r0)
            r11.replaceWith(r12)
            goto L_0x007f
        L_0x007e:
            r12 = r3
        L_0x007f:
            java.lang.String r11 = r5.wholeText()
            if (r11 == 0) goto L_0x00ab
            int r11 = r11.length()
            if (r11 != 0) goto L_0x008d
            r11 = 1
            goto L_0x008e
        L_0x008d:
            r11 = 0
        L_0x008e:
            if (r11 != r1) goto L_0x00ab
            T r11 = r6.element
            org.jsoup.nodes.TextNode r11 = (org.jsoup.nodes.TextNode) r11
            if (r11 == 0) goto L_0x009e
            org.jsoup.nodes.Element r2 = new org.jsoup.nodes.Element
            r2.<init>(r0)
            r11.replaceWith(r2)
        L_0x009e:
            if (r12 == 0) goto L_0x00a5
            com.avito.android.html_formatter.jsoup.MutableJsoupHtmlNode r3 = new com.avito.android.html_formatter.jsoup.MutableJsoupHtmlNode
            r3.<init>(r12)
        L_0x00a5:
            com.avito.android.html_formatter.MutableHtmlNode$OperationResult r11 = new com.avito.android.html_formatter.MutableHtmlNode$OperationResult
            r11.<init>(r3, r1)
            goto L_0x00b7
        L_0x00ab:
            if (r12 == 0) goto L_0x00b2
            com.avito.android.html_formatter.jsoup.MutableJsoupHtmlNode r3 = new com.avito.android.html_formatter.jsoup.MutableJsoupHtmlNode
            r3.<init>(r12)
        L_0x00b2:
            com.avito.android.html_formatter.MutableHtmlNode$OperationResult r11 = new com.avito.android.html_formatter.MutableHtmlNode$OperationResult
            r11.<init>(r3, r2)
        L_0x00b7:
            return r11
        L_0x00b8:
            com.avito.android.html_formatter.MutableHtmlNode$OperationResult r11 = new com.avito.android.html_formatter.MutableHtmlNode$OperationResult
            r11.<init>(r3, r2, r1, r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.html_formatter.jsoup.JsoupExtensionsKt.splitParentBlock(org.jsoup.nodes.TextNode, int):com.avito.android.html_formatter.MutableHtmlNode$OperationResult");
    }
}
