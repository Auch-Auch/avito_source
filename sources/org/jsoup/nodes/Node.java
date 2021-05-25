package org.jsoup.nodes;

import androidx.appcompat.app.AppCompatDelegateImpl;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.SerializationException;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeFilter;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
public abstract class Node implements Cloneable {
    public Node a;
    public int b;

    public static class a implements NodeVisitor {
        public Appendable a;
        public Document.OutputSettings b;

        public a(Appendable appendable, Document.OutputSettings outputSettings) {
            this.a = appendable;
            this.b = outputSettings;
            outputSettings.a();
        }

        @Override // org.jsoup.select.NodeVisitor
        public void head(Node node, int i) {
            try {
                node.c(this.a, i, this.b);
            } catch (IOException e) {
                throw new SerializationException(e);
            }
        }

        @Override // org.jsoup.select.NodeVisitor
        public void tail(Node node, int i) {
            if (!node.nodeName().equals("#text")) {
                try {
                    node.d(this.a, i, this.b);
                } catch (IOException e) {
                    throw new SerializationException(e);
                }
            }
        }
    }

    public final void a(int i, String str) {
        Validate.notNull(str);
        Validate.notNull(this.a);
        this.a.addChildren(i, (Node[]) AppCompatDelegateImpl.i.v1(this).parseFragmentInput(str, parent() instanceof Element ? (Element) parent() : null, baseUri()).toArray(new Node[0]));
    }

    public String absUrl(String str) {
        Validate.notEmpty(str);
        if (!hasAttr(str)) {
            return "";
        }
        return StringUtil.resolve(baseUri(), attr(str));
    }

    public void addChildren(Node... nodeArr) {
        List<Node> ensureChildNodes = ensureChildNodes();
        for (Node node : nodeArr) {
            reparentChild(node);
            ensureChildNodes.add(node);
            node.setSiblingIndex(ensureChildNodes.size() - 1);
        }
    }

    public Node after(String str) {
        a(this.b + 1, str);
        return this;
    }

    public String attr(String str) {
        Validate.notNull(str);
        if (!hasAttributes()) {
            return "";
        }
        String ignoreCase = attributes().getIgnoreCase(str);
        if (ignoreCase.length() > 0) {
            return ignoreCase;
        }
        if (str.startsWith("abs:")) {
            return absUrl(str.substring(4));
        }
        return "";
    }

    public abstract Attributes attributes();

    public final Element b(Element element) {
        Elements children = element.children();
        return children.size() > 0 ? b((Element) children.get(0)) : element;
    }

    public abstract String baseUri();

    public Node before(String str) {
        a(this.b, str);
        return this;
    }

    public abstract void c(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException;

    public Node childNode(int i) {
        return ensureChildNodes().get(i);
    }

    public abstract int childNodeSize();

    public List<Node> childNodes() {
        return Collections.unmodifiableList(ensureChildNodes());
    }

    public Node[] childNodesAsArray() {
        return (Node[]) ensureChildNodes().toArray(new Node[0]);
    }

    public List<Node> childNodesCopy() {
        List<Node> ensureChildNodes = ensureChildNodes();
        ArrayList arrayList = new ArrayList(ensureChildNodes.size());
        for (Node node : ensureChildNodes) {
            arrayList.add(node.clone());
        }
        return arrayList;
    }

    public Node clearAttributes() {
        Iterator<Attribute> it = attributes().iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
        return this;
    }

    public abstract void d(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException;

    public Node doClone(Node node) {
        int i;
        try {
            Node node2 = (Node) super.clone();
            node2.a = node;
            if (node == null) {
                i = 0;
            } else {
                i = this.b;
            }
            node2.b = i;
            return node2;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract void doSetBaseUri(String str);

    public final void e(int i) {
        List<Node> ensureChildNodes = ensureChildNodes();
        while (i < ensureChildNodes.size()) {
            ensureChildNodes.get(i).setSiblingIndex(i);
            i++;
        }
    }

    public abstract Node empty();

    public abstract List<Node> ensureChildNodes();

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return this == obj;
    }

    public Node filter(NodeFilter nodeFilter) {
        Validate.notNull(nodeFilter);
        NodeTraversor.filter(nodeFilter, this);
        return this;
    }

    public boolean hasAttr(String str) {
        Validate.notNull(str);
        if (str.startsWith("abs:")) {
            String substring = str.substring(4);
            if (attributes().hasKeyIgnoreCase(substring) && !absUrl(substring).equals("")) {
                return true;
            }
        }
        return attributes().hasKeyIgnoreCase(str);
    }

    public abstract boolean hasAttributes();

    public boolean hasParent() {
        return this.a != null;
    }

    public boolean hasSameValue(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return outerHtml().equals(((Node) obj).outerHtml());
    }

    public <T extends Appendable> T html(T t) {
        outerHtml(t);
        return t;
    }

    public void indent(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        appendable.append('\n').append(StringUtil.padding(outputSettings.indentAmount() * i));
    }

    public Node nextSibling() {
        Node node = this.a;
        if (node == null) {
            return null;
        }
        List<Node> ensureChildNodes = node.ensureChildNodes();
        int i = this.b + 1;
        if (ensureChildNodes.size() > i) {
            return ensureChildNodes.get(i);
        }
        return null;
    }

    public abstract String nodeName();

    public String outerHtml() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        outerHtml(borrowBuilder);
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    public Document ownerDocument() {
        Node root = root();
        if (root instanceof Document) {
            return (Document) root;
        }
        return null;
    }

    public Node parent() {
        return this.a;
    }

    public final Node parentNode() {
        return this.a;
    }

    public Node previousSibling() {
        Node node = this.a;
        if (node != null && this.b > 0) {
            return node.ensureChildNodes().get(this.b - 1);
        }
        return null;
    }

    public void remove() {
        Validate.notNull(this.a);
        this.a.removeChild(this);
    }

    public Node removeAttr(String str) {
        Validate.notNull(str);
        attributes().removeIgnoreCase(str);
        return this;
    }

    public void removeChild(Node node) {
        Validate.isTrue(node.a == this);
        int i = node.b;
        ensureChildNodes().remove(i);
        e(i);
        node.a = null;
    }

    public void reparentChild(Node node) {
        node.setParentNode(this);
    }

    public void replaceChild(Node node, Node node2) {
        Validate.isTrue(node.a == this);
        Validate.notNull(node2);
        Node node3 = node2.a;
        if (node3 != null) {
            node3.removeChild(node2);
        }
        int i = node.b;
        ensureChildNodes().set(i, node2);
        node2.a = this;
        node2.setSiblingIndex(i);
        node.a = null;
    }

    public void replaceWith(Node node) {
        Validate.notNull(node);
        Validate.notNull(this.a);
        this.a.replaceChild(this, node);
    }

    public Node root() {
        Node node = this;
        while (true) {
            Node node2 = node.a;
            if (node2 == null) {
                return node;
            }
            node = node2;
        }
    }

    public void setBaseUri(String str) {
        Validate.notNull(str);
        doSetBaseUri(str);
    }

    public void setParentNode(Node node) {
        Validate.notNull(node);
        Node node2 = this.a;
        if (node2 != null) {
            node2.removeChild(this);
        }
        this.a = node;
    }

    public void setSiblingIndex(int i) {
        this.b = i;
    }

    public Node shallowClone() {
        return doClone(null);
    }

    public int siblingIndex() {
        return this.b;
    }

    public List<Node> siblingNodes() {
        Node node = this.a;
        if (node == null) {
            return Collections.emptyList();
        }
        List<Node> ensureChildNodes = node.ensureChildNodes();
        ArrayList arrayList = new ArrayList(ensureChildNodes.size() - 1);
        for (Node node2 : ensureChildNodes) {
            if (node2 != this) {
                arrayList.add(node2);
            }
        }
        return arrayList;
    }

    @Override // java.lang.Object
    public String toString() {
        return outerHtml();
    }

    public Node traverse(NodeVisitor nodeVisitor) {
        Validate.notNull(nodeVisitor);
        NodeTraversor.traverse(nodeVisitor, this);
        return this;
    }

    public Node unwrap() {
        Validate.notNull(this.a);
        List<Node> ensureChildNodes = ensureChildNodes();
        Node node = ensureChildNodes.size() > 0 ? ensureChildNodes.get(0) : null;
        this.a.addChildren(this.b, childNodesAsArray());
        remove();
        return node;
    }

    public Node wrap(String str) {
        Validate.notEmpty(str);
        List<Node> parseFragmentInput = AppCompatDelegateImpl.i.v1(this).parseFragmentInput(str, parent() instanceof Element ? (Element) parent() : null, baseUri());
        Node node = parseFragmentInput.get(0);
        if (!(node instanceof Element)) {
            return null;
        }
        Element element = (Element) node;
        Element b2 = b(element);
        this.a.replaceChild(this, element);
        b2.addChildren(this);
        if (parseFragmentInput.size() > 0) {
            for (int i = 0; i < parseFragmentInput.size(); i++) {
                Node node2 = parseFragmentInput.get(i);
                node2.a.removeChild(node2);
                element.appendChild(node2);
            }
        }
        return this;
    }

    public Node after(Node node) {
        Validate.notNull(node);
        Validate.notNull(this.a);
        this.a.addChildren(this.b + 1, node);
        return this;
    }

    public Node before(Node node) {
        Validate.notNull(node);
        Validate.notNull(this.a);
        this.a.addChildren(this.b, node);
        return this;
    }

    @Override // java.lang.Object
    public Node clone() {
        Node doClone = doClone(null);
        LinkedList linkedList = new LinkedList();
        linkedList.add(doClone);
        while (!linkedList.isEmpty()) {
            Node node = (Node) linkedList.remove();
            int childNodeSize = node.childNodeSize();
            for (int i = 0; i < childNodeSize; i++) {
                List<Node> ensureChildNodes = node.ensureChildNodes();
                Node doClone2 = ensureChildNodes.get(i).doClone(node);
                ensureChildNodes.set(i, doClone2);
                linkedList.add(doClone2);
            }
        }
        return doClone;
    }

    public void outerHtml(Appendable appendable) {
        Document ownerDocument = ownerDocument();
        if (ownerDocument == null) {
            ownerDocument = new Document("");
        }
        NodeTraversor.traverse(new a(appendable, ownerDocument.outputSettings()), this);
    }

    public void addChildren(int i, Node... nodeArr) {
        Validate.notNull(nodeArr);
        if (nodeArr.length != 0) {
            List<Node> ensureChildNodes = ensureChildNodes();
            Node parent = nodeArr[0].parent();
            if (parent == null || parent.childNodeSize() != nodeArr.length) {
                Validate.noNullElements(nodeArr);
                for (Node node : nodeArr) {
                    reparentChild(node);
                }
                ensureChildNodes.addAll(i, Arrays.asList(nodeArr));
                e(i);
                return;
            }
            List<Node> childNodes = parent.childNodes();
            int length = nodeArr.length;
            while (true) {
                int i2 = length - 1;
                if (length <= 0 || nodeArr[i2] != childNodes.get(i2)) {
                    break;
                }
                length = i2;
            }
            parent.empty();
            ensureChildNodes.addAll(i, Arrays.asList(nodeArr));
            int length2 = nodeArr.length;
            while (true) {
                int i3 = length2 - 1;
                if (length2 > 0) {
                    nodeArr[i3].a = this;
                    length2 = i3;
                } else {
                    e(i);
                    return;
                }
            }
        }
    }

    public Node attr(String str, String str2) {
        attributes().g(AppCompatDelegateImpl.i.v1(this).settings().normalizeAttribute(str), str2);
        return this;
    }
}
