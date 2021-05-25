package org.jsoup.nodes;

import androidx.appcompat.app.AppCompatDelegateImpl;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import x6.b.a.a;
public class Comment extends a {
    public Comment(String str) {
        this.c = str;
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String absUrl(String str) {
        return super.absUrl(str);
    }

    public XmlDeclaration asXmlDeclaration() {
        String data = getData();
        StringBuilder L = a2.b.a.a.a.L("<");
        L.append(data.substring(1, data.length() - 1));
        L.append(">");
        Document parse = Jsoup.parse(L.toString(), baseUri(), Parser.xmlParser());
        if (parse.children().size() <= 0) {
            return null;
        }
        Element child = parse.child(0);
        XmlDeclaration xmlDeclaration = new XmlDeclaration(AppCompatDelegateImpl.i.v1(parse).settings().normalizeTag(child.tagName()), data.startsWith("!"));
        xmlDeclaration.attributes().addAll(child.attributes());
        return xmlDeclaration;
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String attr(String str) {
        return super.attr(str);
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ String baseUri() {
        return super.baseUri();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0024, code lost:
        indent(r3, r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        if (((org.jsoup.nodes.Element) r0).tag().formatAsBlock() != false) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (r5.outline() != false) goto L_0x0024;
     */
    @Override // org.jsoup.nodes.Node
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(java.lang.Appendable r3, int r4, org.jsoup.nodes.Document.OutputSettings r5) throws java.io.IOException {
        /*
            r2 = this;
            boolean r0 = r5.prettyPrint()
            if (r0 == 0) goto L_0x0027
            int r0 = r2.siblingIndex()
            if (r0 != 0) goto L_0x001e
            org.jsoup.nodes.Node r0 = r2.a
            boolean r1 = r0 instanceof org.jsoup.nodes.Element
            if (r1 == 0) goto L_0x001e
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            org.jsoup.parser.Tag r0 = r0.tag()
            boolean r0 = r0.formatAsBlock()
            if (r0 != 0) goto L_0x0024
        L_0x001e:
            boolean r0 = r5.outline()
            if (r0 == 0) goto L_0x0027
        L_0x0024:
            r2.indent(r3, r4, r5)
        L_0x0027:
            java.lang.String r4 = "<!--"
            java.lang.Appendable r3 = r3.append(r4)
            java.lang.String r4 = r2.getData()
            java.lang.Appendable r3 = r3.append(r4)
            java.lang.String r4 = "-->"
            r3.append(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.Comment.c(java.lang.Appendable, int, org.jsoup.nodes.Document$OutputSettings):void");
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

    public String getData() {
        return f();
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ boolean hasAttr(String str) {
        return super.hasAttr(str);
    }

    public boolean isXmlDeclaration() {
        String data = getData();
        return data.length() > 1 && (data.startsWith("!") || data.startsWith("?"));
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#comment";
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node removeAttr(String str) {
        return super.removeAttr(str);
    }

    public Comment setData(String str) {
        attr(nodeName(), str);
        return this;
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
    public Comment clone() {
        return (Comment) super.clone();
    }
}
