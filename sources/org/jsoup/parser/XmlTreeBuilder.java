package org.jsoup.parser;

import a2.b.a.a.a;
import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.CDataNode;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.nodes.XmlDeclaration;
import org.jsoup.parser.Token;
import x6.b.b.d;
public class XmlTreeBuilder extends d {
    @Override // x6.b.b.d
    public ParseSettings a() {
        return ParseSettings.preserveCase;
    }

    @Override // x6.b.b.d
    public List<Node> c(String str, Element element, String str2, Parser parser) {
        initialiseParse(new StringReader(str), str2, parser);
        runParser();
        return this.doc.childNodes();
    }

    @Override // x6.b.b.d
    public void initialiseParse(Reader reader, String str, Parser parser) {
        super.initialiseParse(reader, str, parser);
        this.stack.add(this.doc);
        this.doc.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
    }

    @Override // x6.b.b.d
    public boolean process(Token token) {
        Element element;
        XmlDeclaration asXmlDeclaration;
        int ordinal = token.a.ordinal();
        if (ordinal != 0) {
            Element element2 = null;
            if (ordinal == 1) {
                Token.h hVar = (Token.h) token;
                Tag valueOf = Tag.valueOf(hVar.p(), this.settings);
                Attributes attributes = hVar.j;
                if (attributes != null) {
                    attributes.deduplicate(this.settings);
                }
                ParseSettings parseSettings = this.settings;
                Attributes attributes2 = hVar.j;
                parseSettings.a(attributes2);
                Element element3 = new Element(valueOf, null, attributes2);
                currentElement().appendChild(element3);
                if (!hVar.i) {
                    this.stack.add(element3);
                } else if (!valueOf.isKnownTag()) {
                    valueOf.f = true;
                }
            } else if (ordinal == 2) {
                String normalizeTag = this.settings.normalizeTag(((Token.g) token).b);
                int size = this.stack.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        break;
                    }
                    Element element4 = this.stack.get(size);
                    if (element4.nodeName().equals(normalizeTag)) {
                        element2 = element4;
                        break;
                    }
                }
                if (element2 != null) {
                    int size2 = this.stack.size();
                    do {
                        size2--;
                        if (size2 < 0) {
                            break;
                        }
                        element = this.stack.get(size2);
                        this.stack.remove(size2);
                    } while (element != element2);
                }
            } else if (ordinal == 3) {
                Token.d dVar = (Token.d) token;
                Comment comment = new Comment(dVar.k());
                if (dVar.d && comment.isXmlDeclaration() && (asXmlDeclaration = comment.asXmlDeclaration()) != null) {
                    comment = asXmlDeclaration;
                }
                currentElement().appendChild(comment);
            } else if (ordinal == 4) {
                Token.c cVar = (Token.c) token;
                String str = cVar.b;
                currentElement().appendChild(cVar instanceof Token.b ? new CDataNode(str) : new TextNode(str));
            } else if (ordinal != 5) {
                StringBuilder L = a.L("Unexpected token type: ");
                L.append(token.a);
                Validate.fail(L.toString());
            }
        } else {
            Token.e eVar = (Token.e) token;
            DocumentType documentType = new DocumentType(this.settings.normalizeTag(eVar.b.toString()), eVar.d.toString(), eVar.e.toString());
            documentType.setPubSysKey(eVar.c);
            currentElement().appendChild(documentType);
        }
        return true;
    }

    @Override // x6.b.b.d
    public /* bridge */ /* synthetic */ boolean processStartTag(String str, Attributes attributes) {
        return super.processStartTag(str, attributes);
    }
}
