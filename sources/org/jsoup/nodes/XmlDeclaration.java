package org.jsoup.nodes;

import java.io.IOException;
import java.util.Iterator;
import org.jsoup.SerializationException;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import x6.b.a.a;
public class XmlDeclaration extends a {
    public final boolean e;

    public XmlDeclaration(String str, boolean z) {
        Validate.notNull(str);
        this.c = str;
        this.e = z;
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String absUrl(String str) {
        return super.absUrl(str);
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String attr(String str) {
        return super.attr(str);
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String baseUri() {
        return super.baseUri();
    }

    @Override // org.jsoup.nodes.Node
    public void c(Appendable appendable, int i, Document.OutputSettings outputSettings) throws IOException {
        String str = "!";
        appendable.append("<").append(this.e ? str : "?").append(f());
        h(appendable, outputSettings);
        if (!this.e) {
            str = "?";
        }
        appendable.append(str).append(">");
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ int childNodeSize() {
        return super.childNodeSize();
    }

    @Override // org.jsoup.nodes.Node
    public void d(Appendable appendable, int i, Document.OutputSettings outputSettings) {
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node empty() {
        return super.empty();
    }

    public String getWholeDeclaration() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        try {
            h(borrowBuilder, new Document.OutputSettings());
            return StringUtil.releaseBuilder(borrowBuilder).trim();
        } catch (IOException e2) {
            throw new SerializationException(e2);
        }
    }

    public final void h(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        Iterator<Attribute> it = attributes().iterator();
        while (it.hasNext()) {
            Attribute next = it.next();
            if (!next.getKey().equals(nodeName())) {
                appendable.append(' ');
                next.html(appendable, outputSettings);
            }
        }
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ boolean hasAttr(String str) {
        return super.hasAttr(str);
    }

    public String name() {
        return f();
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#declaration";
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node removeAttr(String str) {
        return super.removeAttr(str);
    }

    @Override // org.jsoup.nodes.Node, java.lang.Object
    public String toString() {
        return outerHtml();
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node attr(String str, String str2) {
        return super.attr(str, str2);
    }

    @Override // org.jsoup.nodes.Node, java.lang.Object
    public XmlDeclaration clone() {
        return (XmlDeclaration) super.clone();
    }
}
