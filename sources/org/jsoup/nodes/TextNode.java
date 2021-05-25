package org.jsoup.nodes;

import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import x6.b.a.a;
public class TextNode extends a {
    public TextNode(String str) {
        this.c = str;
    }

    public static TextNode createFromEncoded(String str) {
        return new TextNode(Entities.unescape(str));
    }

    public static boolean h(StringBuilder sb) {
        return sb.length() != 0 && sb.charAt(sb.length() - 1) == ' ';
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

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        if (isBlank() == false) goto L_0x003a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        indent(r10, r11, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        if (isBlank() == false) goto L_0x003a;
     */
    @Override // org.jsoup.nodes.Node
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(java.lang.Appendable r10, int r11, org.jsoup.nodes.Document.OutputSettings r12) throws java.io.IOException {
        /*
            r9 = this;
            boolean r0 = r12.prettyPrint()
            if (r0 == 0) goto L_0x003d
            int r1 = r9.siblingIndex()
            if (r1 != 0) goto L_0x0024
            org.jsoup.nodes.Node r1 = r9.a
            boolean r2 = r1 instanceof org.jsoup.nodes.Element
            if (r2 == 0) goto L_0x0024
            org.jsoup.nodes.Element r1 = (org.jsoup.nodes.Element) r1
            org.jsoup.parser.Tag r1 = r1.tag()
            boolean r1 = r1.formatAsBlock()
            if (r1 == 0) goto L_0x0024
            boolean r1 = r9.isBlank()
            if (r1 == 0) goto L_0x003a
        L_0x0024:
            boolean r1 = r12.outline()
            if (r1 == 0) goto L_0x003d
            java.util.List r1 = r9.siblingNodes()
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x003d
            boolean r1 = r9.isBlank()
            if (r1 != 0) goto L_0x003d
        L_0x003a:
            r9.indent(r10, r11, r12)
        L_0x003d:
            r11 = 1
            r1 = 0
            if (r0 == 0) goto L_0x004b
            org.jsoup.nodes.Node r2 = r9.a
            boolean r2 = org.jsoup.nodes.Element.k(r2)
            if (r2 != 0) goto L_0x004b
            r7 = 1
            goto L_0x004c
        L_0x004b:
            r7 = 0
        L_0x004c:
            if (r0 == 0) goto L_0x0056
            org.jsoup.nodes.Node r0 = r9.a
            boolean r0 = r0 instanceof org.jsoup.nodes.Document
            if (r0 == 0) goto L_0x0056
            r8 = 1
            goto L_0x0057
        L_0x0056:
            r8 = 0
        L_0x0057:
            java.lang.String r4 = r9.f()
            r6 = 0
            r3 = r10
            r5 = r12
            org.jsoup.nodes.Entities.b(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.nodes.TextNode.c(java.lang.Appendable, int, org.jsoup.nodes.Document$OutputSettings):void");
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

    public String getWholeText() {
        return f();
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ boolean hasAttr(String str) {
        return super.hasAttr(str);
    }

    public boolean isBlank() {
        return StringUtil.isBlank(f());
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#text";
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node removeAttr(String str) {
        return super.removeAttr(str);
    }

    public TextNode splitText(int i) {
        String f = f();
        Validate.isTrue(i >= 0, "Split offset must be not be negative");
        Validate.isTrue(i < f.length(), "Split offset must not be greater than current text length");
        String substring = f.substring(0, i);
        String substring2 = f.substring(i);
        text(substring);
        TextNode textNode = new TextNode(substring2);
        if (parent() != null) {
            parent().addChildren(siblingIndex() + 1, textNode);
        }
        return textNode;
    }

    public String text() {
        return StringUtil.normaliseWhitespace(getWholeText());
    }

    @Override // org.jsoup.nodes.Node, java.lang.Object
    public String toString() {
        return outerHtml();
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node attr(String str, String str2) {
        return super.attr(str, str2);
    }

    public TextNode text(String str) {
        attr(nodeName(), str);
        return this;
    }

    @Override // org.jsoup.nodes.Node, java.lang.Object
    public TextNode clone() {
        return (TextNode) super.clone();
    }
}
