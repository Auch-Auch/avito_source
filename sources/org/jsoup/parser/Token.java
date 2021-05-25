package org.jsoup.parser;

import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.jsoup.nodes.Attributes;
public abstract class Token {
    public TokenType a;

    public enum TokenType {
        Doctype,
        StartTag,
        EndTag,
        Comment,
        Character,
        EOF
    }

    public static final class b extends c {
        public b(String str) {
            this.b = str;
        }

        @Override // org.jsoup.parser.Token.c
        public String toString() {
            return a2.b.a.a.a.t(a2.b.a.a.a.L("<![CDATA["), this.b, "]]>");
        }
    }

    public static class c extends Token {
        public String b;

        public c() {
            super(null);
            this.a = TokenType.Character;
        }

        @Override // org.jsoup.parser.Token
        public Token g() {
            this.b = null;
            return this;
        }

        public String toString() {
            return this.b;
        }
    }

    public static final class d extends Token {
        public final StringBuilder b = new StringBuilder();
        public String c;
        public boolean d = false;

        public d() {
            super(null);
            this.a = TokenType.Comment;
        }

        @Override // org.jsoup.parser.Token
        public Token g() {
            Token.h(this.b);
            this.c = null;
            this.d = false;
            return this;
        }

        public final d i(char c2) {
            String str = this.c;
            if (str != null) {
                this.b.append(str);
                this.c = null;
            }
            this.b.append(c2);
            return this;
        }

        public final d j(String str) {
            String str2 = this.c;
            if (str2 != null) {
                this.b.append(str2);
                this.c = null;
            }
            if (this.b.length() == 0) {
                this.c = str;
            } else {
                this.b.append(str);
            }
            return this;
        }

        public String k() {
            String str = this.c;
            return str != null ? str : this.b.toString();
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("<!--");
            L.append(k());
            L.append("-->");
            return L.toString();
        }
    }

    public static final class e extends Token {
        public final StringBuilder b = new StringBuilder();
        public String c = null;
        public final StringBuilder d = new StringBuilder();
        public final StringBuilder e = new StringBuilder();
        public boolean f = false;

        public e() {
            super(null);
            this.a = TokenType.Doctype;
        }

        @Override // org.jsoup.parser.Token
        public Token g() {
            Token.h(this.b);
            this.c = null;
            Token.h(this.d);
            Token.h(this.e);
            this.f = false;
            return this;
        }
    }

    public static final class f extends Token {
        public f() {
            super(null);
            this.a = TokenType.EOF;
        }

        @Override // org.jsoup.parser.Token
        public Token g() {
            return this;
        }
    }

    public static final class g extends i {
        public g() {
            this.a = TokenType.EndTag;
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("</");
            String str = this.b;
            if (str == null) {
                str = "(unset)";
            }
            return a2.b.a.a.a.t(L, str, ">");
        }
    }

    public static final class h extends i {
        public h() {
            this.a = TokenType.StartTag;
        }

        @Override // org.jsoup.parser.Token.i, org.jsoup.parser.Token
        public /* bridge */ /* synthetic */ Token g() {
            s();
            return this;
        }

        @Override // org.jsoup.parser.Token.i
        public i s() {
            super.g();
            this.j = null;
            return this;
        }

        public String toString() {
            Attributes attributes = this.j;
            if (attributes == null || attributes.size() <= 0) {
                StringBuilder L = a2.b.a.a.a.L("<");
                L.append(p());
                L.append(">");
                return L.toString();
            }
            StringBuilder L2 = a2.b.a.a.a.L("<");
            L2.append(p());
            L2.append(" ");
            L2.append(this.j.toString());
            L2.append(">");
            return L2.toString();
        }
    }

    public static abstract class i extends Token {
        public String b;
        public String c;
        public String d;
        public StringBuilder e = new StringBuilder();
        public String f;
        public boolean g = false;
        public boolean h = false;
        public boolean i = false;
        public Attributes j;

        public i() {
            super(null);
        }

        public final void i(char c2) {
            String valueOf = String.valueOf(c2);
            String str = this.d;
            if (str != null) {
                valueOf = str.concat(valueOf);
            }
            this.d = valueOf;
        }

        public final void j(char c2) {
            o();
            this.e.append(c2);
        }

        public final void k(String str) {
            o();
            if (this.e.length() == 0) {
                this.f = str;
            } else {
                this.e.append(str);
            }
        }

        public final void l(int[] iArr) {
            o();
            for (int i2 : iArr) {
                this.e.appendCodePoint(i2);
            }
        }

        public final void m(char c2) {
            n(String.valueOf(c2));
        }

        public final void n(String str) {
            String str2 = this.b;
            if (str2 != null) {
                str = str2.concat(str);
            }
            this.b = str;
            this.c = Normalizer.lowerCase(str);
        }

        public final void o() {
            this.h = true;
            String str = this.f;
            if (str != null) {
                this.e.append(str);
                this.f = null;
            }
        }

        public final String p() {
            String str = this.b;
            Validate.isFalse(str == null || str.length() == 0);
            return this.b;
        }

        public final i q(String str) {
            this.b = str;
            this.c = Normalizer.lowerCase(str);
            return this;
        }

        public final void r() {
            String str;
            if (this.j == null) {
                this.j = new Attributes();
            }
            String str2 = this.d;
            if (str2 != null) {
                String trim = str2.trim();
                this.d = trim;
                if (trim.length() > 0) {
                    if (this.h) {
                        str = this.e.length() > 0 ? this.e.toString() : this.f;
                    } else {
                        str = this.g ? "" : null;
                    }
                    this.j.add(this.d, str);
                }
            }
            this.d = null;
            this.g = false;
            this.h = false;
            Token.h(this.e);
            this.f = null;
        }

        /* renamed from: s */
        public i g() {
            this.b = null;
            this.c = null;
            this.d = null;
            Token.h(this.e);
            this.f = null;
            this.g = false;
            this.h = false;
            this.i = false;
            this.j = null;
            return this;
        }
    }

    public Token(a aVar) {
    }

    public static void h(StringBuilder sb) {
        if (sb != null) {
            sb.delete(0, sb.length());
        }
    }

    public final boolean a() {
        return this.a == TokenType.Character;
    }

    public final boolean b() {
        return this.a == TokenType.Comment;
    }

    public final boolean c() {
        return this.a == TokenType.Doctype;
    }

    public final boolean d() {
        return this.a == TokenType.EOF;
    }

    public final boolean e() {
        return this.a == TokenType.EndTag;
    }

    public final boolean f() {
        return this.a == TokenType.StartTag;
    }

    public abstract Token g();
}
