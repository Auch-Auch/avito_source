package x6.b.a;

import java.util.Collections;
import java.util.List;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Node;
public abstract class a extends Node {
    public static final List<Node> d = Collections.emptyList();
    public Object c;

    @Override // org.jsoup.nodes.Node
    public String absUrl(String str) {
        g();
        return super.absUrl(str);
    }

    @Override // org.jsoup.nodes.Node
    public String attr(String str) {
        Validate.notNull(str);
        if (!hasAttributes()) {
            return str.equals(nodeName()) ? (String) this.c : "";
        }
        return super.attr(str);
    }

    @Override // org.jsoup.nodes.Node
    public final Attributes attributes() {
        g();
        return (Attributes) this.c;
    }

    @Override // org.jsoup.nodes.Node
    public String baseUri() {
        return hasParent() ? parent().baseUri() : "";
    }

    @Override // org.jsoup.nodes.Node
    public int childNodeSize() {
        return 0;
    }

    @Override // org.jsoup.nodes.Node
    public void doSetBaseUri(String str) {
    }

    @Override // org.jsoup.nodes.Node
    public Node empty() {
        return this;
    }

    @Override // org.jsoup.nodes.Node
    public List<Node> ensureChildNodes() {
        return d;
    }

    public String f() {
        return attr(nodeName());
    }

    public final void g() {
        if (!hasAttributes()) {
            Object obj = this.c;
            Attributes attributes = new Attributes();
            this.c = attributes;
            if (obj != null) {
                attributes.put(nodeName(), (String) obj);
            }
        }
    }

    @Override // org.jsoup.nodes.Node
    public boolean hasAttr(String str) {
        g();
        return super.hasAttr(str);
    }

    @Override // org.jsoup.nodes.Node
    public final boolean hasAttributes() {
        return this.c instanceof Attributes;
    }

    @Override // org.jsoup.nodes.Node
    public Node removeAttr(String str) {
        g();
        return super.removeAttr(str);
    }

    @Override // org.jsoup.nodes.Node
    public a doClone(Node node) {
        a aVar = (a) super.doClone(node);
        if (hasAttributes()) {
            aVar.c = ((Attributes) this.c).clone();
        }
        return aVar;
    }

    @Override // org.jsoup.nodes.Node
    public Node attr(String str, String str2) {
        if (hasAttributes() || !str.equals(nodeName())) {
            g();
            super.attr(str, str2);
        } else {
            this.c = str2;
        }
        return this;
    }
}
