package org.jsoup.safety;

import java.util.Iterator;
import java.util.Objects;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.ParseErrorList;
import org.jsoup.parser.Parser;
import org.jsoup.parser.Tag;
import org.jsoup.select.NodeTraversor;
import org.jsoup.select.NodeVisitor;
public class Cleaner {
    public Whitelist a;

    public final class b implements NodeVisitor {
        public int a = 0;
        public final Element b;
        public Element c;

        public b(Element element, Element element2, a aVar) {
            this.b = element;
            this.c = element2;
        }

        @Override // org.jsoup.select.NodeVisitor
        public void head(Node node, int i) {
            if (node instanceof Element) {
                Element element = (Element) node;
                if (Cleaner.this.a.isSafeTag(element.normalName())) {
                    Cleaner cleaner = Cleaner.this;
                    Objects.requireNonNull(cleaner);
                    String tagName = element.tagName();
                    Attributes attributes = new Attributes();
                    Element element2 = new Element(Tag.valueOf(tagName), element.baseUri(), attributes);
                    Iterator<Attribute> it = element.attributes().iterator();
                    int i2 = 0;
                    while (it.hasNext()) {
                        Attribute next = it.next();
                        if (cleaner.a.isSafeAttribute(tagName, element, next)) {
                            attributes.put(next);
                        } else {
                            i2++;
                        }
                    }
                    attributes.addAll(cleaner.a.a(tagName));
                    this.c.appendChild(element2);
                    this.a += i2;
                    this.c = element2;
                } else if (node != this.b) {
                    this.a++;
                }
            } else if (node instanceof TextNode) {
                this.c.appendChild(new TextNode(((TextNode) node).getWholeText()));
            } else if (!(node instanceof DataNode) || !Cleaner.this.a.isSafeTag(node.parent().nodeName())) {
                this.a++;
            } else {
                this.c.appendChild(new DataNode(((DataNode) node).getWholeData()));
            }
        }

        @Override // org.jsoup.select.NodeVisitor
        public void tail(Node node, int i) {
            if ((node instanceof Element) && Cleaner.this.a.isSafeTag(node.nodeName())) {
                this.c = this.c.parent();
            }
        }
    }

    public Cleaner(Whitelist whitelist) {
        Validate.notNull(whitelist);
        this.a = whitelist;
    }

    public final int a(Element element, Element element2) {
        b bVar = new b(element, element2, null);
        NodeTraversor.traverse(bVar, element);
        return bVar.a;
    }

    public Document clean(Document document) {
        Validate.notNull(document);
        Document createShell = Document.createShell(document.baseUri());
        if (document.body() != null) {
            a(document.body(), createShell.body());
        }
        return createShell;
    }

    public boolean isValid(Document document) {
        Validate.notNull(document);
        return a(document.body(), Document.createShell(document.baseUri()).body()) == 0 && document.head().childNodes().isEmpty();
    }

    public boolean isValidBodyHtml(String str) {
        Document createShell = Document.createShell("");
        Document createShell2 = Document.createShell("");
        ParseErrorList tracking = ParseErrorList.tracking(1);
        createShell2.body().insertChildren(0, Parser.parseFragment(str, createShell2.body(), "", tracking));
        if (a(createShell2.body(), createShell.body()) != 0 || !tracking.isEmpty()) {
            return false;
        }
        return true;
    }
}
