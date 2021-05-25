package org.jsoup.nodes;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.avito.android.lib.design.input.FormatterType;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import kotlin.text.Typography;
import org.jsoup.helper.ChangeNotifyingArrayList;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Tag;
import org.jsoup.select.Collector;
import org.jsoup.select.Elements;
import org.jsoup.select.Evaluator;
import org.jsoup.select.NodeFilter;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
import org.jsoup.select.QueryParser;
import org.jsoup.select.Selector;
public class Element extends Node {
    public static final List<Node> g = Collections.emptyList();
    public static final Pattern h = Pattern.compile("\\s+");
    public static final String i = "/baseUri";
    public Tag c;
    public WeakReference<List<Element>> d;
    public List<Node> e;
    public Attributes f;

    public class a implements NodeVisitor {
        public final /* synthetic */ StringBuilder a;

        public a(Element element, StringBuilder sb) {
            this.a = sb;
        }

        @Override // org.jsoup.select.NodeVisitor
        public void head(Node node, int i) {
            if (node instanceof TextNode) {
                Element.g(this.a, (TextNode) node);
            } else if (node instanceof Element) {
                Element element = (Element) node;
                if (this.a.length() <= 0) {
                    return;
                }
                if ((element.isBlock() || element.c.getName().equals("br")) && !TextNode.h(this.a)) {
                    this.a.append(' ');
                }
            }
        }

        @Override // org.jsoup.select.NodeVisitor
        public void tail(Node node, int i) {
            if ((node instanceof Element) && ((Element) node).isBlock() && (node.nextSibling() instanceof TextNode) && !TextNode.h(this.a)) {
                this.a.append(' ');
            }
        }
    }

    public class b implements NodeVisitor {
        public final /* synthetic */ StringBuilder a;

        public b(Element element, StringBuilder sb) {
            this.a = sb;
        }

        @Override // org.jsoup.select.NodeVisitor
        public void head(Node node, int i) {
            if (node instanceof TextNode) {
                this.a.append(((TextNode) node).getWholeText());
            }
        }

        @Override // org.jsoup.select.NodeVisitor
        public void tail(Node node, int i) {
        }
    }

    public static final class c extends ChangeNotifyingArrayList<Node> {
        public final Element a;

        public c(Element element, int i) {
            super(i);
            this.a = element;
        }

        @Override // org.jsoup.helper.ChangeNotifyingArrayList
        public void onContentsChanged() {
            this.a.d = null;
        }
    }

    public Element(String str) {
        this(Tag.valueOf(str), "", null);
    }

    public static void f(Element element, Elements elements) {
        Element parent = element.parent();
        if (parent != null && !parent.tagName().equals("#root")) {
            elements.add(parent);
            f(parent, elements);
        }
    }

    public static void g(StringBuilder sb, TextNode textNode) {
        String wholeText = textNode.getWholeText();
        if (k(textNode.a) || (textNode instanceof CDataNode)) {
            sb.append(wholeText);
        } else {
            StringUtil.appendNormalisedWhitespace(sb, wholeText, TextNode.h(sb));
        }
    }

    public static <E extends Element> int i(Element element, List<E> list) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (list.get(i2) == element) {
                return i2;
            }
        }
        return 0;
    }

    public static boolean k(Node node) {
        if (node instanceof Element) {
            Element element = (Element) node;
            int i2 = 0;
            while (!element.c.preserveWhitespace()) {
                element = element.parent();
                i2++;
                if (i2 < 6) {
                    if (element == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public Element addClass(String str) {
        Validate.notNull(str);
        Set<String> classNames = classNames();
        classNames.add(str);
        classNames(classNames);
        return this;
    }

    public Element append(String str) {
        Validate.notNull(str);
        addChildren((Node[]) AppCompatDelegateImpl.i.v1(this).parseFragmentInput(str, this, baseUri()).toArray(new Node[0]));
        return this;
    }

    public Element appendChild(Node node) {
        Validate.notNull(node);
        reparentChild(node);
        ensureChildNodes();
        this.e.add(node);
        node.setSiblingIndex(this.e.size() - 1);
        return this;
    }

    public Element appendElement(String str) {
        Element element = new Element(Tag.valueOf(str, AppCompatDelegateImpl.i.v1(this).settings()), baseUri());
        appendChild(element);
        return element;
    }

    public Element appendText(String str) {
        Validate.notNull(str);
        appendChild(new TextNode(str));
        return this;
    }

    public Element appendTo(Element element) {
        Validate.notNull(element);
        element.appendChild(this);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public Attributes attributes() {
        if (!hasAttributes()) {
            this.f = new Attributes();
        }
        return this.f;
    }

    @Override // org.jsoup.nodes.Node
    public String baseUri() {
        String str = i;
        for (Element element = this; element != null; element = element.parent()) {
            if (element.hasAttributes() && element.f.hasKey(str)) {
                return element.f.get(str);
            }
        }
        return "";
    }

    @Override // org.jsoup.nodes.Node
    public void c(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        if (outputSettings.prettyPrint()) {
            boolean z = false;
            if (this.c.formatAsBlock() || (parent() != null && parent().tag().formatAsBlock()) || outputSettings.outline()) {
                if (tag().isInline() && !tag().isEmpty() && parent().isBlock() && previousSibling() != null && !outputSettings.outline()) {
                    z = true;
                }
                if (!z) {
                    if (!(appendable instanceof StringBuilder)) {
                        indent(appendable, i2, outputSettings);
                    } else if (((StringBuilder) appendable).length() > 0) {
                        indent(appendable, i2, outputSettings);
                    }
                }
            }
        }
        appendable.append(Typography.less).append(tagName());
        Attributes attributes = this.f;
        if (attributes != null) {
            attributes.c(appendable, outputSettings);
        }
        if (!this.e.isEmpty() || !this.c.isSelfClosing()) {
            appendable.append(Typography.greater);
        } else if (outputSettings.syntax() != Document.OutputSettings.Syntax.html || !this.c.isEmpty()) {
            appendable.append(" />");
        } else {
            appendable.append(Typography.greater);
        }
    }

    public Element child(int i2) {
        return h().get(i2);
    }

    @Override // org.jsoup.nodes.Node
    public int childNodeSize() {
        return this.e.size();
    }

    public Elements children() {
        return new Elements(h());
    }

    public int childrenSize() {
        return h().size();
    }

    public String className() {
        return attr("class").trim();
    }

    public Set<String> classNames() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(Arrays.asList(h.split(className())));
        linkedHashSet.remove("");
        return linkedHashSet;
    }

    public Element closest(String str) {
        return closest(QueryParser.parse(str));
    }

    public String cssSelector() {
        if (id().length() > 0) {
            StringBuilder L = a2.b.a.a.a.L("#");
            L.append(id());
            return L.toString();
        }
        StringBuilder sb = new StringBuilder(tagName().replace(':', '|'));
        String join = StringUtil.join(classNames(), ".");
        if (join.length() > 0) {
            sb.append(FormatterType.defaultDecimalSeparator);
            sb.append(join);
        }
        if (parent() == null || (parent() instanceof Document)) {
            return sb.toString();
        }
        sb.insert(0, " > ");
        if (parent().select(sb.toString()).size() > 1) {
            sb.append(String.format(":nth-child(%d)", Integer.valueOf(elementSiblingIndex() + 1)));
        }
        return parent().cssSelector() + sb.toString();
    }

    @Override // org.jsoup.nodes.Node
    public void d(Appendable appendable, int i2, Document.OutputSettings outputSettings) throws IOException {
        if (!this.e.isEmpty() || !this.c.isSelfClosing()) {
            if (outputSettings.prettyPrint() && !this.e.isEmpty() && (this.c.formatAsBlock() || (outputSettings.outline() && (this.e.size() > 1 || (this.e.size() == 1 && !(this.e.get(0) instanceof TextNode)))))) {
                indent(appendable, i2, outputSettings);
            }
            appendable.append("</").append(tagName()).append(Typography.greater);
        }
    }

    public String data() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        for (Node node : this.e) {
            if (node instanceof DataNode) {
                borrowBuilder.append(((DataNode) node).getWholeData());
            } else if (node instanceof Comment) {
                borrowBuilder.append(((Comment) node).getData());
            } else if (node instanceof Element) {
                borrowBuilder.append(((Element) node).data());
            } else if (node instanceof CDataNode) {
                borrowBuilder.append(((CDataNode) node).getWholeText());
            }
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    public List<DataNode> dataNodes() {
        ArrayList arrayList = new ArrayList();
        for (Node node : this.e) {
            if (node instanceof DataNode) {
                arrayList.add((DataNode) node);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Map<String, String> dataset() {
        return attributes().dataset();
    }

    @Override // org.jsoup.nodes.Node
    public void doSetBaseUri(String str) {
        attributes().put(i, str);
    }

    public int elementSiblingIndex() {
        if (parent() == null) {
            return 0;
        }
        return i(this, parent().h());
    }

    @Override // org.jsoup.nodes.Node
    public List<Node> ensureChildNodes() {
        if (this.e == g) {
            this.e = new c(this, 4);
        }
        return this.e;
    }

    public Element firstElementSibling() {
        List<Element> h2 = parent().h();
        if (h2.size() > 1) {
            return h2.get(0);
        }
        return null;
    }

    public Elements getAllElements() {
        return Collector.collect(new Evaluator.AllElements(), this);
    }

    public Element getElementById(String str) {
        Validate.notEmpty(str);
        Elements collect = Collector.collect(new Evaluator.Id(str), this);
        if (collect.size() > 0) {
            return (Element) collect.get(0);
        }
        return null;
    }

    public Elements getElementsByAttribute(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.Attribute(str.trim()), this);
    }

    public Elements getElementsByAttributeStarting(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.AttributeStarting(str.trim()), this);
    }

    public Elements getElementsByAttributeValue(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValue(str, str2), this);
    }

    public Elements getElementsByAttributeValueContaining(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueContaining(str, str2), this);
    }

    public Elements getElementsByAttributeValueEnding(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueEnding(str, str2), this);
    }

    public Elements getElementsByAttributeValueMatching(String str, Pattern pattern) {
        return Collector.collect(new Evaluator.AttributeWithValueMatching(str, pattern), this);
    }

    public Elements getElementsByAttributeValueNot(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueNot(str, str2), this);
    }

    public Elements getElementsByAttributeValueStarting(String str, String str2) {
        return Collector.collect(new Evaluator.AttributeWithValueStarting(str, str2), this);
    }

    public Elements getElementsByClass(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.Class(str), this);
    }

    public Elements getElementsByIndexEquals(int i2) {
        return Collector.collect(new Evaluator.IndexEquals(i2), this);
    }

    public Elements getElementsByIndexGreaterThan(int i2) {
        return Collector.collect(new Evaluator.IndexGreaterThan(i2), this);
    }

    public Elements getElementsByIndexLessThan(int i2) {
        return Collector.collect(new Evaluator.IndexLessThan(i2), this);
    }

    public Elements getElementsByTag(String str) {
        Validate.notEmpty(str);
        return Collector.collect(new Evaluator.Tag(Normalizer.normalize(str)), this);
    }

    public Elements getElementsContainingOwnText(String str) {
        return Collector.collect(new Evaluator.ContainsOwnText(str), this);
    }

    public Elements getElementsContainingText(String str) {
        return Collector.collect(new Evaluator.ContainsText(str), this);
    }

    public Elements getElementsMatchingOwnText(Pattern pattern) {
        return Collector.collect(new Evaluator.MatchesOwn(pattern), this);
    }

    public Elements getElementsMatchingText(Pattern pattern) {
        return Collector.collect(new Evaluator.Matches(pattern), this);
    }

    public final List<Element> h() {
        List<Element> list;
        WeakReference<List<Element>> weakReference = this.d;
        if (!(weakReference == null || (list = weakReference.get()) == null)) {
            return list;
        }
        int size = this.e.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            Node node = this.e.get(i2);
            if (node instanceof Element) {
                arrayList.add((Element) node);
            }
        }
        this.d = new WeakReference<>(arrayList);
        return arrayList;
    }

    @Override // org.jsoup.nodes.Node
    public boolean hasAttributes() {
        return this.f != null;
    }

    public boolean hasClass(String str) {
        if (!hasAttributes()) {
            return false;
        }
        String ignoreCase = this.f.getIgnoreCase("class");
        int length = ignoreCase.length();
        int length2 = str.length();
        if (length != 0 && length >= length2) {
            if (length == length2) {
                return str.equalsIgnoreCase(ignoreCase);
            }
            boolean z = false;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                if (Character.isWhitespace(ignoreCase.charAt(i3))) {
                    if (!z) {
                        continue;
                    } else if (i3 - i2 == length2 && ignoreCase.regionMatches(true, i2, str, 0, length2)) {
                        return true;
                    } else {
                        z = false;
                    }
                } else if (!z) {
                    i2 = i3;
                    z = true;
                }
            }
            if (z && length - i2 == length2) {
                return ignoreCase.regionMatches(true, i2, str, 0, length2);
            }
        }
        return false;
    }

    public boolean hasText() {
        for (Node node : this.e) {
            if (node instanceof TextNode) {
                if (!((TextNode) node).isBlank()) {
                    return true;
                }
            } else if ((node instanceof Element) && ((Element) node).hasText()) {
                return true;
            }
        }
        return false;
    }

    public String html() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        html((Element) borrowBuilder);
        String releaseBuilder = StringUtil.releaseBuilder(borrowBuilder);
        Document ownerDocument = ownerDocument();
        if (ownerDocument == null) {
            ownerDocument = new Document("");
        }
        return ownerDocument.outputSettings().prettyPrint() ? releaseBuilder.trim() : releaseBuilder;
    }

    public String id() {
        return hasAttributes() ? this.f.getIgnoreCase("id") : "";
    }

    public Element insertChildren(int i2, Collection<? extends Node> collection) {
        Validate.notNull(collection, "Children collection to be inserted must not be null.");
        int childNodeSize = childNodeSize();
        if (i2 < 0) {
            i2 += childNodeSize + 1;
        }
        Validate.isTrue(i2 >= 0 && i2 <= childNodeSize, "Insert position out of bounds.");
        addChildren(i2, (Node[]) new ArrayList(collection).toArray(new Node[0]));
        return this;
    }

    public boolean is(String str) {
        return is(QueryParser.parse(str));
    }

    public boolean isBlock() {
        return this.c.isBlock();
    }

    public final Elements j(boolean z) {
        Elements elements = new Elements();
        if (this.a == null) {
            return elements;
        }
        elements.add(this);
        return z ? elements.nextAll() : elements.prevAll();
    }

    public Element lastElementSibling() {
        List<Element> h2 = parent().h();
        if (h2.size() > 1) {
            return (Element) a2.b.a.a.a.j2(h2, 1);
        }
        return null;
    }

    public Element nextElementSibling() {
        List<Element> h2;
        int i2;
        if (this.a != null && h2.size() > (i2 = i(this, (h2 = parent().h())) + 1)) {
            return h2.get(i2);
        }
        return null;
    }

    public Elements nextElementSiblings() {
        return j(true);
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return this.c.getName();
    }

    public String normalName() {
        return this.c.normalName();
    }

    public String ownText() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        for (Node node : this.e) {
            if (node instanceof TextNode) {
                g(borrowBuilder, (TextNode) node);
            } else if ((node instanceof Element) && ((Element) node).c.getName().equals("br") && !TextNode.h(borrowBuilder)) {
                borrowBuilder.append(" ");
            }
        }
        return StringUtil.releaseBuilder(borrowBuilder).trim();
    }

    public Elements parents() {
        Elements elements = new Elements();
        f(this, elements);
        return elements;
    }

    public Element prepend(String str) {
        Validate.notNull(str);
        addChildren(0, (Node[]) AppCompatDelegateImpl.i.v1(this).parseFragmentInput(str, this, baseUri()).toArray(new Node[0]));
        return this;
    }

    public Element prependChild(Node node) {
        Validate.notNull(node);
        addChildren(0, node);
        return this;
    }

    public Element prependElement(String str) {
        Element element = new Element(Tag.valueOf(str, AppCompatDelegateImpl.i.v1(this).settings()), baseUri());
        prependChild(element);
        return element;
    }

    public Element prependText(String str) {
        Validate.notNull(str);
        prependChild(new TextNode(str));
        return this;
    }

    public Element previousElementSibling() {
        List<Element> h2;
        int i2;
        if (this.a != null && (i2 = i(this, (h2 = parent().h()))) > 0) {
            return h2.get(i2 - 1);
        }
        return null;
    }

    public Elements previousElementSiblings() {
        return j(false);
    }

    public Element removeClass(String str) {
        Validate.notNull(str);
        Set<String> classNames = classNames();
        classNames.remove(str);
        classNames(classNames);
        return this;
    }

    public Elements select(String str) {
        return Selector.select(str, this);
    }

    public Element selectFirst(String str) {
        return Selector.selectFirst(str, this);
    }

    public Elements siblingElements() {
        if (this.a == null) {
            return new Elements(0);
        }
        List<Element> h2 = parent().h();
        Elements elements = new Elements(h2.size() - 1);
        for (Element element : h2) {
            if (element != this) {
                elements.add(element);
            }
        }
        return elements;
    }

    public Tag tag() {
        return this.c;
    }

    public String tagName() {
        return this.c.getName();
    }

    public String text() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        NodeTraversor.traverse(new a(this, borrowBuilder), this);
        return StringUtil.releaseBuilder(borrowBuilder).trim();
    }

    public List<TextNode> textNodes() {
        ArrayList arrayList = new ArrayList();
        for (Node node : this.e) {
            if (node instanceof TextNode) {
                arrayList.add((TextNode) node);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public Element toggleClass(String str) {
        Validate.notNull(str);
        Set<String> classNames = classNames();
        if (classNames.contains(str)) {
            classNames.remove(str);
        } else {
            classNames.add(str);
        }
        classNames(classNames);
        return this;
    }

    public String val() {
        if (normalName().equals("textarea")) {
            return text();
        }
        return attr("value");
    }

    public String wholeText() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        NodeTraversor.traverse(new b(this, borrowBuilder), this);
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    public Element(Tag tag, String str, Attributes attributes) {
        Validate.notNull(tag);
        this.e = g;
        this.f = attributes;
        this.c = tag;
        if (str != null) {
            setBaseUri(str);
        }
    }

    @Override // org.jsoup.nodes.Node
    public Element attr(String str, String str2) {
        super.attr(str, str2);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public Element clearAttributes() {
        if (this.f != null) {
            super.clearAttributes();
            this.f = null;
        }
        return this;
    }

    public Element closest(Evaluator evaluator) {
        Validate.notNull(evaluator);
        Element root = root();
        Element element = this;
        while (!evaluator.matches(root, element)) {
            element = element.parent();
            if (element == null) {
                return null;
            }
        }
        return element;
    }

    @Override // org.jsoup.nodes.Node
    public Element doClone(Node node) {
        Element element = (Element) super.doClone(node);
        Attributes attributes = this.f;
        element.f = attributes != null ? attributes.clone() : null;
        c cVar = new c(element, this.e.size());
        element.e = cVar;
        cVar.addAll(this.e);
        element.setBaseUri(baseUri());
        return element;
    }

    @Override // org.jsoup.nodes.Node
    public Element empty() {
        this.e.clear();
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public Element filter(NodeFilter nodeFilter) {
        return (Element) super.filter(nodeFilter);
    }

    public Elements getElementsByAttributeValueMatching(String str, String str2) {
        try {
            return getElementsByAttributeValueMatching(str, Pattern.compile(str2));
        } catch (PatternSyntaxException e2) {
            throw new IllegalArgumentException(a2.b.a.a.a.c3("Pattern syntax error: ", str2), e2);
        }
    }

    public Elements getElementsMatchingOwnText(String str) {
        try {
            return getElementsMatchingOwnText(Pattern.compile(str));
        } catch (PatternSyntaxException e2) {
            throw new IllegalArgumentException(a2.b.a.a.a.c3("Pattern syntax error: ", str), e2);
        }
    }

    public Elements getElementsMatchingText(String str) {
        try {
            return getElementsMatchingText(Pattern.compile(str));
        } catch (PatternSyntaxException e2) {
            throw new IllegalArgumentException(a2.b.a.a.a.c3("Pattern syntax error: ", str), e2);
        }
    }

    public boolean is(Evaluator evaluator) {
        return evaluator.matches(root(), this);
    }

    @Override // org.jsoup.nodes.Node
    public final Element parent() {
        return (Element) this.a;
    }

    @Override // org.jsoup.nodes.Node
    public Element removeAttr(String str) {
        return (Element) super.removeAttr(str);
    }

    @Override // org.jsoup.nodes.Node
    public Element root() {
        return (Element) super.root();
    }

    public Elements select(Evaluator evaluator) {
        return Selector.select(evaluator, this);
    }

    public Element selectFirst(Evaluator evaluator) {
        return Collector.findFirst(evaluator, this);
    }

    @Override // org.jsoup.nodes.Node
    public Element shallowClone() {
        Tag tag = this.c;
        String baseUri = baseUri();
        Attributes attributes = this.f;
        return new Element(tag, baseUri, attributes == null ? null : attributes.clone());
    }

    public Element tagName(String str) {
        Validate.notEmpty(str, "Tag name must not be empty.");
        this.c = Tag.valueOf(str, AppCompatDelegateImpl.i.v1(this).settings());
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public Element traverse(NodeVisitor nodeVisitor) {
        return (Element) super.traverse(nodeVisitor);
    }

    @Override // org.jsoup.nodes.Node
    public Element wrap(String str) {
        return (Element) super.wrap(str);
    }

    @Override // org.jsoup.nodes.Node
    public Element after(String str) {
        return (Element) super.after(str);
    }

    public Element attr(String str, boolean z) {
        attributes().put(str, z);
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public Element before(String str) {
        return (Element) super.before(str);
    }

    @Override // org.jsoup.nodes.Node, java.lang.Object
    public Element clone() {
        return (Element) super.clone();
    }

    @Override // org.jsoup.nodes.Node
    public Element after(Node node) {
        return (Element) super.after(node);
    }

    @Override // org.jsoup.nodes.Node
    public Element before(Node node) {
        return (Element) super.before(node);
    }

    public Element classNames(Set<String> set) {
        Validate.notNull(set);
        if (set.isEmpty()) {
            attributes().remove("class");
        } else {
            attributes().put("class", StringUtil.join(set, " "));
        }
        return this;
    }

    public Element text(String str) {
        Validate.notNull(str);
        empty();
        appendChild(new TextNode(str));
        return this;
    }

    public Element val(String str) {
        if (normalName().equals("textarea")) {
            text(str);
        } else {
            attr("value", str);
        }
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public <T extends Appendable> T html(T t) {
        int size = this.e.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.e.get(i2).outerHtml(t);
        }
        return t;
    }

    public Element insertChildren(int i2, Node... nodeArr) {
        Validate.notNull(nodeArr, "Children collection to be inserted must not be null.");
        int childNodeSize = childNodeSize();
        if (i2 < 0) {
            i2 += childNodeSize + 1;
        }
        Validate.isTrue(i2 >= 0 && i2 <= childNodeSize, "Insert position out of bounds.");
        addChildren(i2, nodeArr);
        return this;
    }

    public Element(Tag tag, String str) {
        this(tag, str, null);
    }

    public Element html(String str) {
        empty();
        append(str);
        return this;
    }
}
