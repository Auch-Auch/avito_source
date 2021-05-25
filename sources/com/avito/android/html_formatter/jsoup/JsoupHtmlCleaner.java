package com.avito.android.html_formatter.jsoup;

import com.avito.android.html_formatter.HtmlCleaner;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.UserDataStore;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.safety.Cleaner;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import t6.n.i;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\t\b\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\n\u001a\u00020\t2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/html_formatter/jsoup/JsoupHtmlCleaner;", "Lcom/avito/android/html_formatter/HtmlCleaner;", "", "html", "cleanHtml", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/util/Stack;", "Lorg/jsoup/nodes/Node;", MessengerShareContentUtility.ELEMENTS, "", AuthSource.SEND_ABUSE, "(Ljava/util/Stack;)V", "<init>", "()V", "Companion", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
public final class JsoupHtmlCleaner implements HtmlCleaner {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final Whitelist a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/html_formatter/jsoup/JsoupHtmlCleaner$Companion;", "", "Lorg/jsoup/safety/Whitelist;", "whitelist", "Lorg/jsoup/safety/Whitelist;", "<init>", "()V", "html-formatter_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    static {
        Whitelist whitelist = new Whitelist();
        whitelist.addTags("p", "ul", "ol", "li", "strong", UserDataStore.EMAIL, "br");
        a = whitelist;
    }

    public final void a(Stack<Node> stack) {
        Element element = new Element("p");
        Node node = (Node) CollectionsKt___CollectionsKt.first((List<? extends Object>) stack);
        Node parent = node.parent();
        if (!(parent instanceof Element)) {
            parent = null;
        }
        Element element2 = (Element) parent;
        if (element2 != null) {
            element2.insertChildren(node.siblingIndex(), element);
        }
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            pop.remove();
            element.appendChild(pop);
        }
    }

    @Override // com.avito.android.html_formatter.HtmlCleaner
    @NotNull
    public String cleanHtml(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "html");
        Document clean = new Cleaner(a).clean(Jsoup.parse(str));
        clean.outputSettings(new Document.OutputSettings().prettyPrint(false));
        Elements<Element> allElements = clean.getAllElements();
        Intrinsics.checkNotNullExpressionValue(allElements, "htmlDocument.getAllElements()");
        for (Element element : allElements) {
            List<TextNode> textNodes = element.textNodes();
            Intrinsics.checkNotNullExpressionValue(textNodes, "it.textNodes()");
            for (TextNode textNode : i.asReversedMutable(CollectionsKt___CollectionsKt.toMutableList((Collection) textNodes))) {
                Node previousSibling = textNode.previousSibling();
                Node nextSibling = textNode.nextSibling();
                if (((previousSibling instanceof Element) && ((Element) previousSibling).isBlock()) || ((nextSibling instanceof Element) && ((Element) nextSibling).isBlock())) {
                    Intrinsics.checkNotNullExpressionValue(textNode, "it");
                    if (textNode.isBlank()) {
                        textNode.remove();
                    }
                }
            }
        }
        Stack<Node> stack = new Stack<>();
        List<Node> childNodes = clean.body().childNodes();
        Intrinsics.checkNotNullExpressionValue(childNodes, "htmlDocument.body().childNodes()");
        Iterator it = i.asReversedMutable(CollectionsKt___CollectionsKt.toMutableList((Collection) childNodes)).iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Node node = (Node) it.next();
            Intrinsics.checkNotNullExpressionValue(node, "it");
            if (!(node instanceof TextNode) && (!(node instanceof Element) || ((Element) node).isBlock())) {
                z = false;
            }
            if (z) {
                stack.add(node);
            } else if ((!stack.isEmpty() ? stack : null) != null) {
                a(stack);
                stack.clear();
            }
        }
        if (!stack.isEmpty()) {
            a(stack);
        }
        String html = clean.body().html();
        Intrinsics.checkNotNullExpressionValue(html, "htmlDocument.body().html()");
        return html;
    }
}
