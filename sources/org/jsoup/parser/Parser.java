package org.jsoup.parser;

import java.io.Reader;
import java.io.StringReader;
import java.util.List;
import kotlin.text.Typography;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import x6.b.b.b;
import x6.b.b.d;
public class Parser {
    public d a;
    public ParseErrorList b = ParseErrorList.noTracking();
    public ParseSettings c;

    public Parser(d dVar) {
        this.a = dVar;
        this.c = dVar.a();
    }

    public static Parser htmlParser() {
        return new Parser(new HtmlTreeBuilder());
    }

    public static Document parse(String str, String str2) {
        HtmlTreeBuilder htmlTreeBuilder = new HtmlTreeBuilder();
        return htmlTreeBuilder.b(new StringReader(str), str2, new Parser(htmlTreeBuilder));
    }

    public static Document parseBodyFragment(String str, String str2) {
        Document createShell = Document.createShell(str2);
        Element body = createShell.body();
        List<Node> parseFragment = parseFragment(str, body, str2);
        Node[] nodeArr = (Node[]) parseFragment.toArray(new Node[0]);
        for (int length = nodeArr.length - 1; length > 0; length--) {
            nodeArr[length].remove();
        }
        for (Node node : nodeArr) {
            body.appendChild(node);
        }
        return createShell;
    }

    public static List<Node> parseFragment(String str, Element element, String str2) {
        HtmlTreeBuilder htmlTreeBuilder = new HtmlTreeBuilder();
        return htmlTreeBuilder.c(str, element, str2, new Parser(htmlTreeBuilder));
    }

    public static List<Node> parseXmlFragment(String str, String str2) {
        XmlTreeBuilder xmlTreeBuilder = new XmlTreeBuilder();
        xmlTreeBuilder.initialiseParse(new StringReader(str), str2, new Parser(xmlTreeBuilder));
        xmlTreeBuilder.runParser();
        return xmlTreeBuilder.doc.childNodes();
    }

    public static String unescapeEntities(String str, boolean z) {
        b bVar = new b(new CharacterReader(str), ParseErrorList.noTracking());
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        while (!bVar.a.isEmpty()) {
            borrowBuilder.append(bVar.a.consumeTo(Typography.amp));
            if (bVar.a.k(Typography.amp)) {
                bVar.a.c();
                int[] b2 = bVar.b(null, z);
                if (b2 == null || b2.length == 0) {
                    borrowBuilder.append(Typography.amp);
                } else {
                    borrowBuilder.appendCodePoint(b2[0]);
                    if (b2.length == 2) {
                        borrowBuilder.appendCodePoint(b2[1]);
                    }
                }
            }
        }
        return StringUtil.releaseBuilder(borrowBuilder);
    }

    public static Parser xmlParser() {
        return new Parser(new XmlTreeBuilder());
    }

    public ParseErrorList getErrors() {
        return this.b;
    }

    public d getTreeBuilder() {
        return this.a;
    }

    public boolean isTrackErrors() {
        return this.b.a > 0;
    }

    public List<Node> parseFragmentInput(String str, Element element, String str2) {
        return this.a.c(str, element, str2, this);
    }

    public Document parseInput(String str, String str2) {
        return this.a.b(new StringReader(str), str2, this);
    }

    public Parser setTrackErrors(int i) {
        this.b = i > 0 ? ParseErrorList.tracking(i) : ParseErrorList.noTracking();
        return this;
    }

    public Parser setTreeBuilder(d dVar) {
        this.a = dVar;
        dVar.parser = this;
        return this;
    }

    public Parser settings(ParseSettings parseSettings) {
        this.c = parseSettings;
        return this;
    }

    public Document parseInput(Reader reader, String str) {
        return this.a.b(reader, str, this);
    }

    public ParseSettings settings() {
        return this.c;
    }

    public static List<Node> parseFragment(String str, Element element, String str2, ParseErrorList parseErrorList) {
        HtmlTreeBuilder htmlTreeBuilder = new HtmlTreeBuilder();
        Parser parser = new Parser(htmlTreeBuilder);
        parser.b = parseErrorList;
        return htmlTreeBuilder.c(str, element, str2, parser);
    }
}
