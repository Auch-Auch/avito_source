package x6.b.b;

import java.util.Arrays;
import kotlin.text.Typography;
import org.jsoup.helper.Validate;
import org.jsoup.parser.CharacterReader;
import org.jsoup.parser.ParseError;
import org.jsoup.parser.ParseErrorList;
import org.jsoup.parser.Token;
public final class b {
    public static final char[] r;
    public static final int[] s = {8364, 129, 8218, 402, 8222, 8230, 8224, 8225, 710, 8240, 352, 8249, 338, 141, 381, 143, 144, 8216, 8217, 8220, 8221, 8226, 8211, 8212, 732, 8482, 353, 8250, 339, 157, 382, 376};
    public final CharacterReader a;
    public final ParseErrorList b;
    public c c = c.Data;
    public Token d;
    public boolean e = false;
    public String f = null;
    public StringBuilder g = new StringBuilder(1024);
    public StringBuilder h = new StringBuilder(1024);
    public Token.i i;
    public Token.h j = new Token.h();
    public Token.g k = new Token.g();
    public Token.c l = new Token.c();
    public Token.e m = new Token.e();
    public Token.d n = new Token.d();
    public String o;
    public final int[] p = new int[1];
    public final int[] q = new int[2];

    static {
        char[] cArr = {'\t', '\n', '\r', '\f', ' ', Typography.less, Typography.amp};
        r = cArr;
        Arrays.sort(cArr);
    }

    public b(CharacterReader characterReader, ParseErrorList parseErrorList) {
        this.a = characterReader;
        this.b = parseErrorList;
    }

    public final void a(String str) {
        if (this.b.a()) {
            this.b.add(new ParseError(this.a.pos(), "Invalid character reference: %s", str));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:117:0x01ca, code lost:
        if (r16.a.l('=', '-', '_') == false) goto L_0x01d2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int[] b(java.lang.Character r17, boolean r18) {
        /*
        // Method dump skipped, instructions count: 531
        */
        throw new UnsupportedOperationException("Method not decompiled: x6.b.b.b.b(java.lang.Character, boolean):int[]");
    }

    public void c() {
        this.n.g();
        this.n.d = true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: org.jsoup.parser.Token$h */
    /* JADX WARN: Multi-variable type inference failed */
    public Token.i d(boolean z) {
        Token.g gVar;
        if (z) {
            Token.h hVar = this.j;
            hVar.s();
            gVar = hVar;
        } else {
            Token.g gVar2 = this.k;
            gVar2.g();
            gVar = gVar2;
        }
        this.i = gVar;
        return gVar;
    }

    public void e(char c2) {
        f(String.valueOf(c2));
    }

    public void f(String str) {
        if (this.f == null) {
            this.f = str;
            return;
        }
        if (this.g.length() == 0) {
            this.g.append(this.f);
        }
        this.g.append(str);
    }

    public void g(Token token) {
        Validate.isFalse(this.e);
        this.d = token;
        this.e = true;
        Token.TokenType tokenType = token.a;
        if (tokenType == Token.TokenType.StartTag) {
            this.o = ((Token.h) token).b;
        } else if (tokenType == Token.TokenType.EndTag && ((Token.g) token).j != null) {
            j("Attributes incorrectly present on end tag");
        }
    }

    public void h() {
        Token.i iVar = this.i;
        if (iVar.d != null) {
            iVar.r();
        }
        g(this.i);
    }

    public void i(c cVar) {
        if (this.b.a()) {
            this.b.add(new ParseError(this.a.pos(), "Unexpectedly reached end of file (EOF) in input state [%s]", cVar));
        }
    }

    public void j(String str) {
        if (this.b.a()) {
            this.b.add(new ParseError(this.a.pos(), str));
        }
    }

    public void k(c cVar) {
        if (this.b.a()) {
            this.b.add(new ParseError(this.a.pos(), "Unexpected character '%s' in input state [%s]", Character.valueOf(this.a.current()), cVar));
        }
    }

    public boolean l() {
        return this.o != null && this.i.p().equalsIgnoreCase(this.o);
    }
}
