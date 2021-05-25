package x6.b.b;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.parser.CharacterReader;
import org.jsoup.parser.ParseError;
import org.jsoup.parser.ParseErrorList;
import org.jsoup.parser.ParseSettings;
import org.jsoup.parser.Parser;
import org.jsoup.parser.Token;
public abstract class d {
    public CharacterReader a;
    public b b;
    public String baseUri;
    public Token.h c = new Token.h();
    public Token currentToken;
    public Token.g d = new Token.g();
    public Document doc;
    public Parser parser;
    public ParseSettings settings;
    public ArrayList<Element> stack;

    public abstract ParseSettings a();

    public Document b(Reader reader, String str, Parser parser2) {
        initialiseParse(reader, str, parser2);
        runParser();
        this.a.close();
        this.a = null;
        this.b = null;
        this.stack = null;
        return this.doc;
    }

    public abstract List<Node> c(String str, Element element, String str2, Parser parser2);

    public Element currentElement() {
        int size = this.stack.size();
        if (size > 0) {
            return this.stack.get(size - 1);
        }
        return null;
    }

    public void error(String str) {
        ParseErrorList errors = this.parser.getErrors();
        if (errors.a()) {
            errors.add(new ParseError(this.a.pos(), str));
        }
    }

    public void initialiseParse(Reader reader, String str, Parser parser2) {
        Validate.notNull(reader, "String input must not be null");
        Validate.notNull(str, "BaseURI must not be null");
        Document document = new Document(str);
        this.doc = document;
        document.parser(parser2);
        this.parser = parser2;
        this.settings = parser2.settings();
        this.a = new CharacterReader(reader);
        this.currentToken = null;
        this.b = new b(this.a, parser2.getErrors());
        this.stack = new ArrayList<>(32);
        this.baseUri = str;
    }

    public abstract boolean process(Token token);

    public boolean processEndTag(String str) {
        Token token = this.currentToken;
        Token.g gVar = this.d;
        if (token == gVar) {
            Token.g gVar2 = new Token.g();
            gVar2.b = str;
            gVar2.c = Normalizer.lowerCase(str);
            return process(gVar2);
        }
        gVar.g();
        gVar.b = str;
        gVar.c = Normalizer.lowerCase(str);
        return process(gVar);
    }

    public boolean processStartTag(String str) {
        Token.h hVar = this.c;
        if (this.currentToken == hVar) {
            Token.h hVar2 = new Token.h();
            hVar2.b = str;
            hVar2.c = Normalizer.lowerCase(str);
            return process(hVar2);
        }
        hVar.s();
        hVar.b = str;
        hVar.c = Normalizer.lowerCase(str);
        return process(hVar);
    }

    public void runParser() {
        Token.c cVar;
        b bVar = this.b;
        Token.TokenType tokenType = Token.TokenType.EOF;
        while (true) {
            if (!bVar.e) {
                bVar.c.f(bVar, bVar.a);
            } else {
                StringBuilder sb = bVar.g;
                if (sb.length() != 0) {
                    String sb2 = sb.toString();
                    sb.delete(0, sb.length());
                    bVar.f = null;
                    Token.c cVar2 = bVar.l;
                    cVar2.b = sb2;
                    cVar = cVar2;
                } else {
                    String str = bVar.f;
                    if (str != null) {
                        Token.c cVar3 = bVar.l;
                        cVar3.b = str;
                        bVar.f = null;
                        cVar = cVar3;
                    } else {
                        bVar.e = false;
                        cVar = bVar.d;
                    }
                }
                process(cVar);
                cVar.g();
                if (cVar.a == tokenType) {
                    return;
                }
            }
        }
    }

    public boolean processStartTag(String str, Attributes attributes) {
        Token.h hVar = this.c;
        if (this.currentToken == hVar) {
            Token.h hVar2 = new Token.h();
            hVar2.b = str;
            hVar2.j = attributes;
            hVar2.c = Normalizer.lowerCase(str);
            return process(hVar2);
        }
        hVar.s();
        hVar.b = str;
        hVar.j = attributes;
        hVar.c = Normalizer.lowerCase(str);
        return process(hVar);
    }
}
