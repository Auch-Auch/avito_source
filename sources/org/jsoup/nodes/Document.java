package org.jsoup.nodes;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.exoplayer2.C;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Entities;
import org.jsoup.parser.ParseSettings;
import org.jsoup.parser.Parser;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;
import x6.b.a.a;
public class Document extends Element {
    public OutputSettings j = new OutputSettings();
    public Parser k;
    public QuirksMode l = QuirksMode.noQuirks;
    public String m;
    public boolean n = false;

    public static class OutputSettings implements Cloneable {
        public Entities.EscapeMode a = Entities.EscapeMode.base;
        public Charset b;
        public ThreadLocal<CharsetEncoder> c = new ThreadLocal<>();
        public Entities.a d;
        public boolean e = true;
        public boolean f = false;
        public int g = 1;
        public Syntax h = Syntax.html;

        public enum Syntax {
            html,
            xml
        }

        public OutputSettings() {
            charset(Charset.forName("UTF8"));
        }

        public CharsetEncoder a() {
            Entities.a aVar;
            CharsetEncoder newEncoder = this.b.newEncoder();
            this.c.set(newEncoder);
            String name = newEncoder.charset().name();
            if (name.equals(C.ASCII_NAME)) {
                aVar = Entities.a.ascii;
            } else if (name.startsWith("UTF-")) {
                aVar = Entities.a.utf;
            } else {
                aVar = Entities.a.fallback;
            }
            this.d = aVar;
            return newEncoder;
        }

        public Charset charset() {
            return this.b;
        }

        public Entities.EscapeMode escapeMode() {
            return this.a;
        }

        public int indentAmount() {
            return this.g;
        }

        public boolean outline() {
            return this.f;
        }

        public boolean prettyPrint() {
            return this.e;
        }

        public Syntax syntax() {
            return this.h;
        }

        public OutputSettings charset(Charset charset) {
            this.b = charset;
            return this;
        }

        @Override // java.lang.Object
        public OutputSettings clone() {
            try {
                OutputSettings outputSettings = (OutputSettings) super.clone();
                outputSettings.charset(this.b.name());
                outputSettings.a = Entities.EscapeMode.valueOf(this.a.name());
                return outputSettings;
            } catch (CloneNotSupportedException e2) {
                throw new RuntimeException(e2);
            }
        }

        public OutputSettings escapeMode(Entities.EscapeMode escapeMode) {
            this.a = escapeMode;
            return this;
        }

        public OutputSettings indentAmount(int i) {
            Validate.isTrue(i >= 0);
            this.g = i;
            return this;
        }

        public OutputSettings outline(boolean z) {
            this.f = z;
            return this;
        }

        public OutputSettings prettyPrint(boolean z) {
            this.e = z;
            return this;
        }

        public OutputSettings syntax(Syntax syntax) {
            this.h = syntax;
            return this;
        }

        public OutputSettings charset(String str) {
            charset(Charset.forName(str));
            return this;
        }
    }

    public enum QuirksMode {
        noQuirks,
        quirks,
        limitedQuirks
    }

    public Document(String str) {
        super(Tag.valueOf("#root", ParseSettings.htmlDefault), str);
        this.m = str;
    }

    public static Document createShell(String str) {
        Validate.notNull(str);
        Document document = new Document(str);
        document.k = document.parser();
        Element appendElement = document.appendElement("html");
        appendElement.appendElement("head");
        appendElement.appendElement(SDKConstants.PARAM_A2U_BODY);
        return document;
    }

    public Element body() {
        return m(SDKConstants.PARAM_A2U_BODY, this);
    }

    public void charset(Charset charset) {
        updateMetaCharsetElement(true);
        this.j.charset(charset);
        l();
    }

    public Element createElement(String str) {
        return new Element(Tag.valueOf(str, ParseSettings.preserveCase), baseUri());
    }

    public DocumentType documentType() {
        for (Node node : this.e) {
            if (node instanceof DocumentType) {
                return (DocumentType) node;
            }
            if (!(node instanceof a)) {
                return null;
            }
        }
        return null;
    }

    public Element head() {
        return m("head", this);
    }

    public final void l() {
        if (this.n) {
            OutputSettings.Syntax syntax = outputSettings().syntax();
            if (syntax == OutputSettings.Syntax.html) {
                Element first = select("meta[charset]").first();
                if (first != null) {
                    first.attr("charset", charset().displayName());
                } else {
                    Element head = head();
                    if (head != null) {
                        head.appendElement("meta").attr("charset", charset().displayName());
                    }
                }
                select("meta[name=charset]").remove();
            } else if (syntax == OutputSettings.Syntax.xml) {
                Node node = childNodes().get(0);
                if (node instanceof XmlDeclaration) {
                    XmlDeclaration xmlDeclaration = (XmlDeclaration) node;
                    if (xmlDeclaration.name().equals("xml")) {
                        xmlDeclaration.attr("encoding", charset().displayName());
                        if (xmlDeclaration.attr("version") != null) {
                            xmlDeclaration.attr("version", "1.0");
                            return;
                        }
                        return;
                    }
                    XmlDeclaration xmlDeclaration2 = new XmlDeclaration("xml", false);
                    xmlDeclaration2.attr("version", "1.0");
                    xmlDeclaration2.attr("encoding", charset().displayName());
                    prependChild(xmlDeclaration2);
                    return;
                }
                XmlDeclaration xmlDeclaration3 = new XmlDeclaration("xml", false);
                xmlDeclaration3.attr("version", "1.0");
                xmlDeclaration3.attr("encoding", charset().displayName());
                prependChild(xmlDeclaration3);
            }
        }
    }

    public String location() {
        return this.m;
    }

    public final Element m(String str, Node node) {
        if (node.nodeName().equals(str)) {
            return (Element) node;
        }
        int childNodeSize = node.childNodeSize();
        for (int i = 0; i < childNodeSize; i++) {
            Element m2 = m(str, node.childNode(i));
            if (m2 != null) {
                return m2;
            }
        }
        return null;
    }

    public final void n(String str, Element element) {
        Elements elementsByTag = getElementsByTag(str);
        Element first = elementsByTag.first();
        if (elementsByTag.size() > 1) {
            ArrayList arrayList = new ArrayList();
            for (int i = 1; i < elementsByTag.size(); i++) {
                Node node = (Node) elementsByTag.get(i);
                arrayList.addAll(node.ensureChildNodes());
                node.remove();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                first.appendChild((Node) it.next());
            }
        }
        if (!first.parent().equals(element)) {
            element.appendChild(first);
        }
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.Node
    public String nodeName() {
        return "#document";
    }

    public Document normalise() {
        Element m2 = m("html", this);
        if (m2 == null) {
            m2 = appendElement("html");
        }
        if (head() == null) {
            m2.prependElement("head");
        }
        if (body() == null) {
            m2.appendElement(SDKConstants.PARAM_A2U_BODY);
        }
        o(head());
        o(m2);
        o(this);
        n("head", m2);
        n(SDKConstants.PARAM_A2U_BODY, m2);
        l();
        return this;
    }

    public final void o(Element element) {
        ArrayList arrayList = new ArrayList();
        for (Node node : element.e) {
            if (node instanceof TextNode) {
                TextNode textNode = (TextNode) node;
                if (!textNode.isBlank()) {
                    arrayList.add(textNode);
                }
            }
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            Node node2 = (Node) arrayList.get(size);
            element.removeChild(node2);
            body().prependChild(new TextNode(" "));
            body().prependChild(node2);
        }
    }

    @Override // org.jsoup.nodes.Node
    public String outerHtml() {
        return super.html();
    }

    public OutputSettings outputSettings() {
        return this.j;
    }

    public Parser parser() {
        return this.k;
    }

    public QuirksMode quirksMode() {
        return this.l;
    }

    @Override // org.jsoup.nodes.Element
    public Element text(String str) {
        body().text(str);
        return this;
    }

    public String title() {
        Element first = getElementsByTag("title").first();
        return first != null ? StringUtil.normaliseWhitespace(first.text()).trim() : "";
    }

    public void updateMetaCharsetElement(boolean z) {
        this.n = z;
    }

    public Document outputSettings(OutputSettings outputSettings) {
        Validate.notNull(outputSettings);
        this.j = outputSettings;
        return this;
    }

    public Document parser(Parser parser) {
        this.k = parser;
        return this;
    }

    public Document quirksMode(QuirksMode quirksMode) {
        this.l = quirksMode;
        return this;
    }

    public boolean updateMetaCharsetElement() {
        return this.n;
    }

    public void title(String str) {
        Validate.notNull(str);
        Element first = getElementsByTag("title").first();
        if (first == null) {
            head().appendElement("title").text(str);
        } else {
            first.text(str);
        }
    }

    public Charset charset() {
        return this.j.charset();
    }

    @Override // org.jsoup.nodes.Element, org.jsoup.nodes.Node, java.lang.Object
    public Document clone() {
        Document document = (Document) super.clone();
        document.j = this.j.clone();
        return document;
    }
}
