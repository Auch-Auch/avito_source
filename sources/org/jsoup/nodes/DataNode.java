package org.jsoup.nodes;

import java.io.IOException;
import org.jsoup.nodes.Document;
import x6.b.a.a;
public class DataNode extends a {
    public DataNode(String str) {
        this.c = str;
    }

    public static DataNode createFromEncoded(String str, String str2) {
        return new DataNode(Entities.unescape(str));
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
        appendable.append(getWholeData());
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

    public String getWholeData() {
        return f();
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ boolean hasAttr(String str) {
        return super.hasAttr(str);
    }

    @Override // org.jsoup.nodes.Node
    public String nodeName() {
        return "#data";
    }

    @Override // x6.b.a.a, org.jsoup.nodes.Node
    public /* bridge */ /* synthetic */ Node removeAttr(String str) {
        return super.removeAttr(str);
    }

    public DataNode setWholeData(String str) {
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
    public DataNode clone() {
        return (DataNode) super.clone();
    }
}
