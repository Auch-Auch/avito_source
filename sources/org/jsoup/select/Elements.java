package org.jsoup.select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
public class Elements extends ArrayList<Element> {
    public Elements() {
    }

    public final <T extends Node> List<T> a(Class<T> cls) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            if (element.getClass().isInstance(cls)) {
                arrayList.add(cls.cast(element));
            } else if (Node.class.isAssignableFrom(cls)) {
                for (int i = 0; i < element.childNodeSize(); i++) {
                    Node childNode = element.childNode(i);
                    if (cls.isInstance(childNode)) {
                        arrayList.add(cls.cast(childNode));
                    }
                }
            }
        }
        return arrayList;
    }

    public Elements addClass(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).addClass(str);
        }
        return this;
    }

    public Elements after(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).after(str);
        }
        return this;
    }

    public Elements append(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).append(str);
        }
        return this;
    }

    public String attr(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            if (element.hasAttr(str)) {
                return element.attr(str);
            }
        }
        return "";
    }

    public final Elements b(String str, boolean z, boolean z2) {
        Elements elements = new Elements();
        Evaluator parse = str != null ? QueryParser.parse(str) : null;
        Iterator it = iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            do {
                element = z ? element.nextElementSibling() : element.previousElementSibling();
                if (element == null) {
                    break;
                } else if (parse == null) {
                    elements.add(element);
                    continue;
                } else if (element.is(parse)) {
                    elements.add(element);
                    continue;
                } else {
                    continue;
                }
            } while (z2);
        }
        return elements;
    }

    public Elements before(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).before(str);
        }
        return this;
    }

    public List<Comment> comments() {
        return a(Comment.class);
    }

    public List<DataNode> dataNodes() {
        return a(DataNode.class);
    }

    public List<String> eachAttr(String str) {
        ArrayList arrayList = new ArrayList(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            if (element.hasAttr(str)) {
                arrayList.add(element.attr(str));
            }
        }
        return arrayList;
    }

    public List<String> eachText() {
        ArrayList arrayList = new ArrayList(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            if (element.hasText()) {
                arrayList.add(element.text());
            }
        }
        return arrayList;
    }

    public Elements empty() {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).empty();
        }
        return this;
    }

    public Elements eq(int i) {
        return size() > i ? new Elements((Element) get(i)) : new Elements();
    }

    public Elements filter(NodeFilter nodeFilter) {
        NodeTraversor.filter(nodeFilter, this);
        return this;
    }

    public Element first() {
        if (isEmpty()) {
            return null;
        }
        return (Element) get(0);
    }

    public List<FormElement> forms() {
        return a(FormElement.class);
    }

    public boolean hasAttr(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            if (((Element) it.next()).hasAttr(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasClass(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            if (((Element) it.next()).hasClass(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasText() {
        Iterator it = iterator();
        while (it.hasNext()) {
            if (((Element) it.next()).hasText()) {
                return true;
            }
        }
        return false;
    }

    public String html() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        Iterator it = iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            if (borrowBuilder.length() != 0) {
                borrowBuilder.append("\n");
            }
            borrowBuilder.append(element.html());
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    public boolean is(String str) {
        Evaluator parse = QueryParser.parse(str);
        Iterator it = iterator();
        while (it.hasNext()) {
            if (((Element) it.next()).is(parse)) {
                return true;
            }
        }
        return false;
    }

    public Element last() {
        if (isEmpty()) {
            return null;
        }
        return (Element) get(size() - 1);
    }

    public Elements next() {
        return b(null, true, false);
    }

    public Elements nextAll() {
        return b(null, true, true);
    }

    public Elements not(String str) {
        Elements select = Selector.select(str, this);
        Elements elements = new Elements();
        Iterator it = iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            boolean z = false;
            Iterator it2 = select.iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (element.equals((Element) it2.next())) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (!z) {
                elements.add(element);
            }
        }
        return elements;
    }

    public String outerHtml() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        Iterator it = iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            if (borrowBuilder.length() != 0) {
                borrowBuilder.append("\n");
            }
            borrowBuilder.append(element.outerHtml());
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    public Elements parents() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = iterator();
        while (it.hasNext()) {
            linkedHashSet.addAll(((Element) it.next()).parents());
        }
        return new Elements(linkedHashSet);
    }

    public Elements prepend(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).prepend(str);
        }
        return this;
    }

    public Elements prev() {
        return b(null, false, false);
    }

    public Elements prevAll() {
        return b(null, false, true);
    }

    public Elements remove() {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).remove();
        }
        return this;
    }

    public Elements removeAttr(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).removeAttr(str);
        }
        return this;
    }

    public Elements removeClass(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).removeClass(str);
        }
        return this;
    }

    public Elements select(String str) {
        return Selector.select(str, this);
    }

    public Elements tagName(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).tagName(str);
        }
        return this;
    }

    public String text() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        Iterator it = iterator();
        while (it.hasNext()) {
            Element element = (Element) it.next();
            if (borrowBuilder.length() != 0) {
                borrowBuilder.append(" ");
            }
            borrowBuilder.append(element.text());
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    public List<TextNode> textNodes() {
        return a(TextNode.class);
    }

    @Override // java.util.AbstractCollection, java.lang.Object
    public String toString() {
        return outerHtml();
    }

    public Elements toggleClass(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).toggleClass(str);
        }
        return this;
    }

    public Elements traverse(NodeVisitor nodeVisitor) {
        NodeTraversor.traverse(nodeVisitor, this);
        return this;
    }

    public Elements unwrap() {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).unwrap();
        }
        return this;
    }

    public String val() {
        return size() > 0 ? first().val() : "";
    }

    public Elements wrap(String str) {
        Validate.notEmpty(str);
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).wrap(str);
        }
        return this;
    }

    public Elements(int i) {
        super(i);
    }

    @Override // java.util.ArrayList, java.lang.Object
    public Elements clone() {
        Elements elements = new Elements(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            elements.add(((Element) it.next()).clone());
        }
        return elements;
    }

    public Elements next(String str) {
        return b(str, true, false);
    }

    public Elements nextAll(String str) {
        return b(str, true, true);
    }

    public Elements prev(String str) {
        return b(str, false, false);
    }

    public Elements prevAll(String str) {
        return b(str, false, true);
    }

    public Elements(Collection<Element> collection) {
        super(collection);
    }

    public Elements val(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).val(str);
        }
        return this;
    }

    public Elements(List<Element> list) {
        super(list);
    }

    public Elements attr(String str, String str2) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).attr(str, str2);
        }
        return this;
    }

    public Elements(Element... elementArr) {
        super(Arrays.asList(elementArr));
    }

    public Elements html(String str) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Element) it.next()).html(str);
        }
        return this;
    }
}
