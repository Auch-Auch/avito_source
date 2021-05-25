package x6.b.b;

import java.util.Locale;
import kotlin.text.Typography;
import okio.Utf8;
import org.jsoup.nodes.DocumentType;
import org.jsoup.parser.CharacterReader;
import org.jsoup.parser.Token;
public enum c {
    Data {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                bVar.k(this);
                bVar.e(characterReader.c());
            } else if (current == '&') {
                c cVar = c.CharacterReferenceInData;
                bVar.a.advance();
                bVar.c = cVar;
            } else if (current == '<') {
                c cVar2 = c.TagOpen;
                bVar.a.advance();
                bVar.c = cVar2;
            } else if (current != 65535) {
                bVar.f(characterReader.d());
            } else {
                bVar.g(new Token.f());
            }
        }
    },
    CharacterReferenceInData {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c.a(bVar, c.Data);
        }
    },
    Rcdata {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                bVar.k(this);
                characterReader.advance();
                bVar.e(Utf8.REPLACEMENT_CHARACTER);
            } else if (current == '&') {
                c cVar = c.CharacterReferenceInRcdata;
                bVar.a.advance();
                bVar.c = cVar;
            } else if (current == '<') {
                c cVar2 = c.RcdataLessthanSign;
                bVar.a.advance();
                bVar.c = cVar2;
            } else if (current != 65535) {
                bVar.f(characterReader.d());
            } else {
                bVar.g(new Token.f());
            }
        }
    },
    CharacterReferenceInRcdata {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c.a(bVar, c.Rcdata);
        }
    },
    Rawtext {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c.b(bVar, characterReader, this, c.RawtextLessthanSign);
        }
    },
    ScriptData {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c.b(bVar, characterReader, this, c.ScriptDataLessthanSign);
        }
    },
    PLAINTEXT {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                bVar.k(this);
                characterReader.advance();
                bVar.e(Utf8.REPLACEMENT_CHARACTER);
            } else if (current != 65535) {
                bVar.f(characterReader.consumeTo(0));
            } else {
                bVar.g(new Token.f());
            }
        }
    },
    TagOpen {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == '!') {
                c cVar = c.MarkupDeclarationOpen;
                bVar.a.advance();
                bVar.c = cVar;
            } else if (current == '/') {
                c cVar2 = c.EndTagOpen;
                bVar.a.advance();
                bVar.c = cVar2;
            } else if (current == '?') {
                bVar.c();
                c cVar3 = c.BogusComment;
                bVar.a.advance();
                bVar.c = cVar3;
            } else if (characterReader.m()) {
                bVar.d(true);
                bVar.c = c.TagName;
            } else {
                bVar.k(this);
                bVar.e(Typography.less);
                bVar.c = c.Data;
            }
        }
    },
    EndTagOpen {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            if (characterReader.isEmpty()) {
                bVar.i(this);
                bVar.f("</");
                bVar.c = cVar;
            } else if (characterReader.m()) {
                bVar.d(false);
                bVar.c = c.TagName;
            } else if (characterReader.k(Typography.greater)) {
                bVar.k(this);
                bVar.a.advance();
                bVar.c = cVar;
            } else {
                bVar.k(this);
                bVar.c();
                c cVar2 = c.BogusComment;
                bVar.a.advance();
                bVar.c = cVar2;
            }
        }
    },
    TagName {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            characterReader.a();
            int i = characterReader.e;
            int i2 = characterReader.c;
            char[] cArr = characterReader.a;
            int i3 = i;
            while (i3 < i2 && (r8 = cArr[i3]) != 0 && r8 != ' ' && r8 != '/' && r8 != '<' && r8 != '>' && r8 != '\t' && r8 != '\n' && r8 != '\f' && r8 != '\r') {
                i3++;
            }
            characterReader.e = i3;
            bVar.i.n(i3 > i ? CharacterReader.b(characterReader.a, characterReader.h, i, i3 - i) : "");
            char c = characterReader.c();
            if (c != 0) {
                if (c != ' ') {
                    if (c != '/') {
                        if (c == '<') {
                            characterReader.p();
                            bVar.k(this);
                        } else if (c != '>') {
                            if (c == 65535) {
                                bVar.i(this);
                                bVar.c = cVar;
                                return;
                            } else if (!(c == '\t' || c == '\n' || c == '\f' || c == '\r')) {
                                bVar.i.m(c);
                                return;
                            }
                        }
                        bVar.h();
                        bVar.c = cVar;
                        return;
                    }
                    bVar.c = c.SelfClosingStartTag;
                    return;
                }
                bVar.c = c.BeforeAttributeName;
                return;
            }
            bVar.i.n(c.t0);
        }
    },
    RcdataLessthanSign {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            if (characterReader.k('/')) {
                Token.h(bVar.h);
                c cVar = c.RCDATAEndTagOpen;
                bVar.a.advance();
                bVar.c = cVar;
                return;
            }
            if (characterReader.m() && bVar.o != null) {
                StringBuilder L = a2.b.a.a.a.L("</");
                L.append(bVar.o);
                String sb = L.toString();
                Locale locale = Locale.ENGLISH;
                if (!(characterReader.n(sb.toLowerCase(locale)) > -1 || characterReader.n(sb.toUpperCase(locale)) > -1)) {
                    Token.i d = bVar.d(false);
                    d.q(bVar.o);
                    bVar.i = d;
                    bVar.h();
                    characterReader.p();
                    bVar.c = c.Data;
                    return;
                }
            }
            bVar.f("<");
            bVar.c = c.Rcdata;
        }
    },
    RCDATAEndTagOpen {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            if (characterReader.m()) {
                bVar.d(false);
                bVar.i.m(characterReader.current());
                bVar.h.append(characterReader.current());
                c cVar = c.RCDATAEndTagName;
                bVar.a.advance();
                bVar.c = cVar;
                return;
            }
            bVar.f("</");
            bVar.c = c.Rcdata;
        }
    },
    RCDATAEndTagName {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            if (characterReader.m()) {
                String e = characterReader.e();
                bVar.i.n(e);
                bVar.h.append(e);
                return;
            }
            char c = characterReader.c();
            if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
                if (bVar.l()) {
                    bVar.c = c.BeforeAttributeName;
                } else {
                    h(bVar, characterReader);
                }
            } else if (c != '/') {
                if (c != '>') {
                    h(bVar, characterReader);
                } else if (bVar.l()) {
                    bVar.h();
                    bVar.c = c.Data;
                } else {
                    h(bVar, characterReader);
                }
            } else if (bVar.l()) {
                bVar.c = c.SelfClosingStartTag;
            } else {
                h(bVar, characterReader);
            }
        }

        public final void h(b bVar, CharacterReader characterReader) {
            StringBuilder L = a2.b.a.a.a.L("</");
            L.append(bVar.h.toString());
            bVar.f(L.toString());
            characterReader.p();
            bVar.c = c.Rcdata;
        }
    },
    RawtextLessthanSign {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            if (characterReader.k('/')) {
                Token.h(bVar.h);
                c cVar = c.RawtextEndTagOpen;
                bVar.a.advance();
                bVar.c = cVar;
                return;
            }
            bVar.e(Typography.less);
            bVar.c = c.Rawtext;
        }
    },
    RawtextEndTagOpen {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c.c(bVar, characterReader, c.RawtextEndTagName, c.Rawtext);
        }
    },
    RawtextEndTagName {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c.d(bVar, characterReader, c.Rawtext);
        }
    },
    ScriptDataLessthanSign {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            char c = characterReader.c();
            if (c == '!') {
                bVar.f("<!");
                bVar.c = c.ScriptDataEscapeStart;
            } else if (c == '/') {
                Token.h(bVar.h);
                bVar.c = c.ScriptDataEndTagOpen;
            } else if (c != 65535) {
                bVar.f("<");
                characterReader.p();
                bVar.c = c.ScriptData;
            } else {
                bVar.f("<");
                bVar.i(this);
                bVar.c = c.Data;
            }
        }
    },
    ScriptDataEndTagOpen {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c.c(bVar, characterReader, c.ScriptDataEndTagName, c.ScriptData);
        }
    },
    ScriptDataEndTagName {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c.d(bVar, characterReader, c.ScriptData);
        }
    },
    ScriptDataEscapeStart {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            if (characterReader.k('-')) {
                bVar.e('-');
                c cVar = c.ScriptDataEscapeStartDash;
                bVar.a.advance();
                bVar.c = cVar;
                return;
            }
            bVar.c = c.ScriptData;
        }
    },
    ScriptDataEscapeStartDash {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            if (characterReader.k('-')) {
                bVar.e('-');
                c cVar = c.ScriptDataEscapedDashDash;
                bVar.a.advance();
                bVar.c = cVar;
                return;
            }
            bVar.c = c.ScriptData;
        }
    },
    ScriptDataEscaped {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            if (characterReader.isEmpty()) {
                bVar.i(this);
                bVar.c = c.Data;
                return;
            }
            char current = characterReader.current();
            if (current == 0) {
                bVar.k(this);
                characterReader.advance();
                bVar.e(Utf8.REPLACEMENT_CHARACTER);
            } else if (current == '-') {
                bVar.e('-');
                c cVar = c.ScriptDataEscapedDash;
                bVar.a.advance();
                bVar.c = cVar;
            } else if (current != '<') {
                bVar.f(characterReader.consumeToAny('-', Typography.less, 0));
            } else {
                c cVar2 = c.ScriptDataEscapedLessthanSign;
                bVar.a.advance();
                bVar.c = cVar2;
            }
        }
    },
    ScriptDataEscapedDash {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.ScriptDataEscaped;
            if (characterReader.isEmpty()) {
                bVar.i(this);
                bVar.c = c.Data;
                return;
            }
            char c = characterReader.c();
            if (c == 0) {
                bVar.k(this);
                bVar.e(Utf8.REPLACEMENT_CHARACTER);
                bVar.c = cVar;
            } else if (c == '-') {
                bVar.e(c);
                bVar.c = c.ScriptDataEscapedDashDash;
            } else if (c != '<') {
                bVar.e(c);
                bVar.c = cVar;
            } else {
                bVar.c = c.ScriptDataEscapedLessthanSign;
            }
        }
    },
    ScriptDataEscapedDashDash {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.ScriptDataEscaped;
            if (characterReader.isEmpty()) {
                bVar.i(this);
                bVar.c = c.Data;
                return;
            }
            char c = characterReader.c();
            if (c == 0) {
                bVar.k(this);
                bVar.e(Utf8.REPLACEMENT_CHARACTER);
                bVar.c = cVar;
            } else if (c == '-') {
                bVar.e(c);
            } else if (c == '<') {
                bVar.c = c.ScriptDataEscapedLessthanSign;
            } else if (c != '>') {
                bVar.e(c);
                bVar.c = cVar;
            } else {
                bVar.e(c);
                bVar.c = c.ScriptData;
            }
        }
    },
    ScriptDataEscapedLessthanSign {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            if (characterReader.m()) {
                Token.h(bVar.h);
                bVar.h.append(characterReader.current());
                bVar.f("<" + characterReader.current());
                c cVar = c.ScriptDataDoubleEscapeStart;
                bVar.a.advance();
                bVar.c = cVar;
            } else if (characterReader.k('/')) {
                Token.h(bVar.h);
                c cVar2 = c.ScriptDataEscapedEndTagOpen;
                bVar.a.advance();
                bVar.c = cVar2;
            } else {
                bVar.e(Typography.less);
                bVar.c = c.ScriptDataEscaped;
            }
        }
    },
    ScriptDataEscapedEndTagOpen {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            if (characterReader.m()) {
                bVar.d(false);
                bVar.i.m(characterReader.current());
                bVar.h.append(characterReader.current());
                c cVar = c.ScriptDataEscapedEndTagName;
                bVar.a.advance();
                bVar.c = cVar;
                return;
            }
            bVar.f("</");
            bVar.c = c.ScriptDataEscaped;
        }
    },
    ScriptDataEscapedEndTagName {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c.d(bVar, characterReader, c.ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscapeStart {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c.e(bVar, characterReader, c.ScriptDataDoubleEscaped, c.ScriptDataEscaped);
        }
    },
    ScriptDataDoubleEscaped {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                bVar.k(this);
                characterReader.advance();
                bVar.e(Utf8.REPLACEMENT_CHARACTER);
            } else if (current == '-') {
                bVar.e(current);
                c cVar = c.ScriptDataDoubleEscapedDash;
                bVar.a.advance();
                bVar.c = cVar;
            } else if (current == '<') {
                bVar.e(current);
                c cVar2 = c.ScriptDataDoubleEscapedLessthanSign;
                bVar.a.advance();
                bVar.c = cVar2;
            } else if (current != 65535) {
                bVar.f(characterReader.consumeToAny('-', Typography.less, 0));
            } else {
                bVar.i(this);
                bVar.c = c.Data;
            }
        }
    },
    ScriptDataDoubleEscapedDash {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.ScriptDataDoubleEscaped;
            char c = characterReader.c();
            if (c == 0) {
                bVar.k(this);
                bVar.e(Utf8.REPLACEMENT_CHARACTER);
                bVar.c = cVar;
            } else if (c == '-') {
                bVar.e(c);
                bVar.c = c.ScriptDataDoubleEscapedDashDash;
            } else if (c == '<') {
                bVar.e(c);
                bVar.c = c.ScriptDataDoubleEscapedLessthanSign;
            } else if (c != 65535) {
                bVar.e(c);
                bVar.c = cVar;
            } else {
                bVar.i(this);
                bVar.c = c.Data;
            }
        }
    },
    ScriptDataDoubleEscapedDashDash {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.ScriptDataDoubleEscaped;
            char c = characterReader.c();
            if (c == 0) {
                bVar.k(this);
                bVar.e(Utf8.REPLACEMENT_CHARACTER);
                bVar.c = cVar;
            } else if (c == '-') {
                bVar.e(c);
            } else if (c == '<') {
                bVar.e(c);
                bVar.c = c.ScriptDataDoubleEscapedLessthanSign;
            } else if (c == '>') {
                bVar.e(c);
                bVar.c = c.ScriptData;
            } else if (c != 65535) {
                bVar.e(c);
                bVar.c = cVar;
            } else {
                bVar.i(this);
                bVar.c = c.Data;
            }
        }
    },
    ScriptDataDoubleEscapedLessthanSign {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            if (characterReader.k('/')) {
                bVar.e('/');
                Token.h(bVar.h);
                c cVar = c.ScriptDataDoubleEscapeEnd;
                bVar.a.advance();
                bVar.c = cVar;
                return;
            }
            bVar.c = c.ScriptDataDoubleEscaped;
        }
    },
    ScriptDataDoubleEscapeEnd {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c.e(bVar, characterReader, c.ScriptDataEscaped, c.ScriptDataDoubleEscaped);
        }
    },
    BeforeAttributeName {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            c cVar2 = c.AttributeName;
            char c = characterReader.c();
            if (c == 0) {
                characterReader.p();
                bVar.k(this);
                bVar.i.r();
                bVar.c = cVar2;
            } else if (c != ' ') {
                if (!(c == '\"' || c == '\'')) {
                    if (c == '/') {
                        bVar.c = c.SelfClosingStartTag;
                        return;
                    } else if (c == 65535) {
                        bVar.i(this);
                        bVar.c = cVar;
                        return;
                    } else if (c != '\t' && c != '\n' && c != '\f' && c != '\r') {
                        switch (c) {
                            case '<':
                                characterReader.p();
                                bVar.k(this);
                                bVar.h();
                                bVar.c = cVar;
                                return;
                            case '=':
                                break;
                            case '>':
                                bVar.h();
                                bVar.c = cVar;
                                return;
                            default:
                                bVar.i.r();
                                characterReader.p();
                                bVar.c = cVar2;
                                return;
                        }
                    } else {
                        return;
                    }
                }
                bVar.k(this);
                bVar.i.r();
                bVar.i.i(c);
                bVar.c = cVar2;
            }
        }
    },
    AttributeName {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            String f = characterReader.f(c.r0);
            Token.i iVar = bVar.i;
            String str = iVar.d;
            if (str != null) {
                f = str.concat(f);
            }
            iVar.d = f;
            char c = characterReader.c();
            if (c != 0) {
                if (c != ' ') {
                    if (!(c == '\"' || c == '\'')) {
                        if (c == '/') {
                            bVar.c = c.SelfClosingStartTag;
                            return;
                        } else if (c == 65535) {
                            bVar.i(this);
                            bVar.c = cVar;
                            return;
                        } else if (!(c == '\t' || c == '\n' || c == '\f' || c == '\r')) {
                            switch (c) {
                                case '<':
                                    break;
                                case '=':
                                    bVar.c = c.BeforeAttributeValue;
                                    return;
                                case '>':
                                    bVar.h();
                                    bVar.c = cVar;
                                    return;
                                default:
                                    bVar.i.i(c);
                                    return;
                            }
                        }
                    }
                    bVar.k(this);
                    bVar.i.i(c);
                    return;
                }
                bVar.c = c.AfterAttributeName;
                return;
            }
            bVar.k(this);
            bVar.i.i(Utf8.REPLACEMENT_CHARACTER);
        }
    },
    AfterAttributeName {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            c cVar2 = c.AttributeName;
            char c = characterReader.c();
            if (c == 0) {
                bVar.k(this);
                bVar.i.i(Utf8.REPLACEMENT_CHARACTER);
                bVar.c = cVar2;
            } else if (c != ' ') {
                if (!(c == '\"' || c == '\'')) {
                    if (c == '/') {
                        bVar.c = c.SelfClosingStartTag;
                        return;
                    } else if (c == 65535) {
                        bVar.i(this);
                        bVar.c = cVar;
                        return;
                    } else if (c != '\t' && c != '\n' && c != '\f' && c != '\r') {
                        switch (c) {
                            case '<':
                                break;
                            case '=':
                                bVar.c = c.BeforeAttributeValue;
                                return;
                            case '>':
                                bVar.h();
                                bVar.c = cVar;
                                return;
                            default:
                                bVar.i.r();
                                characterReader.p();
                                bVar.c = cVar2;
                                return;
                        }
                    } else {
                        return;
                    }
                }
                bVar.k(this);
                bVar.i.r();
                bVar.i.i(c);
                bVar.c = cVar2;
            }
        }
    },
    BeforeAttributeValue {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            c cVar2 = c.AttributeValue_unquoted;
            char c = characterReader.c();
            if (c == 0) {
                bVar.k(this);
                bVar.i.j(Utf8.REPLACEMENT_CHARACTER);
                bVar.c = cVar2;
            } else if (c == ' ') {
            } else {
                if (c != '\"') {
                    if (c != '`') {
                        if (c == 65535) {
                            bVar.i(this);
                            bVar.h();
                            bVar.c = cVar;
                            return;
                        } else if (c != '\t' && c != '\n' && c != '\f' && c != '\r') {
                            if (c == '&') {
                                characterReader.p();
                                bVar.c = cVar2;
                                return;
                            } else if (c != '\'') {
                                switch (c) {
                                    case '<':
                                    case '=':
                                        break;
                                    case '>':
                                        bVar.k(this);
                                        bVar.h();
                                        bVar.c = cVar;
                                        return;
                                    default:
                                        characterReader.p();
                                        bVar.c = cVar2;
                                        return;
                                }
                            } else {
                                bVar.c = c.AttributeValue_singleQuoted;
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                    bVar.k(this);
                    bVar.i.j(c);
                    bVar.c = cVar2;
                    return;
                }
                bVar.c = c.AttributeValue_doubleQuoted;
            }
        }
    },
    AttributeValue_doubleQuoted {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            String f = characterReader.f(c.q0);
            if (f.length() > 0) {
                bVar.i.k(f);
            } else {
                bVar.i.g = true;
            }
            char c = characterReader.c();
            if (c == 0) {
                bVar.k(this);
                bVar.i.j(Utf8.REPLACEMENT_CHARACTER);
            } else if (c == '\"') {
                bVar.c = c.AfterAttributeValue_quoted;
            } else if (c == '&') {
                int[] b = bVar.b(Character.valueOf(Typography.quote), true);
                if (b != null) {
                    bVar.i.l(b);
                } else {
                    bVar.i.j(Typography.amp);
                }
            } else if (c != 65535) {
                bVar.i.j(c);
            } else {
                bVar.i(this);
                bVar.c = c.Data;
            }
        }
    },
    AttributeValue_singleQuoted {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            String f = characterReader.f(c.p0);
            if (f.length() > 0) {
                bVar.i.k(f);
            } else {
                bVar.i.g = true;
            }
            char c = characterReader.c();
            if (c == 0) {
                bVar.k(this);
                bVar.i.j(Utf8.REPLACEMENT_CHARACTER);
            } else if (c == 65535) {
                bVar.i(this);
                bVar.c = c.Data;
            } else if (c == '&') {
                int[] b = bVar.b('\'', true);
                if (b != null) {
                    bVar.i.l(b);
                } else {
                    bVar.i.j(Typography.amp);
                }
            } else if (c != '\'') {
                bVar.i.j(c);
            } else {
                bVar.c = c.AfterAttributeValue_quoted;
            }
        }
    },
    AttributeValue_unquoted {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            String f = characterReader.f(c.s0);
            if (f.length() > 0) {
                bVar.i.k(f);
            }
            char c = characterReader.c();
            if (c != 0) {
                if (c != ' ') {
                    if (!(c == '\"' || c == '`')) {
                        if (c == 65535) {
                            bVar.i(this);
                            bVar.c = cVar;
                            return;
                        } else if (!(c == '\t' || c == '\n' || c == '\f' || c == '\r')) {
                            if (c == '&') {
                                int[] b = bVar.b(Character.valueOf(Typography.greater), true);
                                if (b != null) {
                                    bVar.i.l(b);
                                    return;
                                } else {
                                    bVar.i.j(Typography.amp);
                                    return;
                                }
                            } else if (c != '\'') {
                                switch (c) {
                                    case '<':
                                    case '=':
                                        break;
                                    case '>':
                                        bVar.h();
                                        bVar.c = cVar;
                                        return;
                                    default:
                                        bVar.i.j(c);
                                        return;
                                }
                            }
                        }
                    }
                    bVar.k(this);
                    bVar.i.j(c);
                    return;
                }
                bVar.c = c.BeforeAttributeName;
                return;
            }
            bVar.k(this);
            bVar.i.j(Utf8.REPLACEMENT_CHARACTER);
        }
    },
    AfterAttributeValue_quoted {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            c cVar2 = c.BeforeAttributeName;
            char c = characterReader.c();
            if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
                bVar.c = cVar2;
            } else if (c == '/') {
                bVar.c = c.SelfClosingStartTag;
            } else if (c == '>') {
                bVar.h();
                bVar.c = cVar;
            } else if (c != 65535) {
                characterReader.p();
                bVar.k(this);
                bVar.c = cVar2;
            } else {
                bVar.i(this);
                bVar.c = cVar;
            }
        }
    },
    SelfClosingStartTag {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            char c = characterReader.c();
            if (c == '>') {
                bVar.i.i = true;
                bVar.h();
                bVar.c = cVar;
            } else if (c != 65535) {
                characterReader.p();
                bVar.k(this);
                bVar.c = c.BeforeAttributeName;
            } else {
                bVar.i(this);
                bVar.c = cVar;
            }
        }
    },
    BogusComment {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            characterReader.p();
            bVar.n.j(characterReader.consumeTo(Typography.greater));
            char c = characterReader.c();
            if (c == '>' || c == 65535) {
                bVar.g(bVar.n);
                bVar.c = c.Data;
            }
        }
    },
    MarkupDeclarationOpen {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            if (characterReader.i("--")) {
                bVar.n.g();
                bVar.c = c.CommentStart;
            } else if (characterReader.j("DOCTYPE")) {
                bVar.c = c.Doctype;
            } else if (characterReader.i("[CDATA[")) {
                Token.h(bVar.h);
                bVar.c = c.CdataSection;
            } else {
                bVar.k(this);
                bVar.c();
                c cVar = c.BogusComment;
                bVar.a.advance();
                bVar.c = cVar;
            }
        }
    },
    CommentStart {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            c cVar2 = c.Comment;
            char c = characterReader.c();
            if (c == 0) {
                bVar.k(this);
                bVar.n.i(Utf8.REPLACEMENT_CHARACTER);
                bVar.c = cVar2;
            } else if (c == '-') {
                bVar.c = c.CommentStartDash;
            } else if (c == '>') {
                bVar.k(this);
                bVar.g(bVar.n);
                bVar.c = cVar;
            } else if (c != 65535) {
                characterReader.p();
                bVar.c = cVar2;
            } else {
                bVar.i(this);
                bVar.g(bVar.n);
                bVar.c = cVar;
            }
        }
    },
    CommentStartDash {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            c cVar2 = c.Comment;
            char c = characterReader.c();
            if (c == 0) {
                bVar.k(this);
                bVar.n.i(Utf8.REPLACEMENT_CHARACTER);
                bVar.c = cVar2;
            } else if (c == '-') {
                bVar.c = c.CommentStartDash;
            } else if (c == '>') {
                bVar.k(this);
                bVar.g(bVar.n);
                bVar.c = cVar;
            } else if (c != 65535) {
                bVar.n.i(c);
                bVar.c = cVar2;
            } else {
                bVar.i(this);
                bVar.g(bVar.n);
                bVar.c = cVar;
            }
        }
    },
    Comment {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            char current = characterReader.current();
            if (current == 0) {
                bVar.k(this);
                characterReader.advance();
                bVar.n.i(Utf8.REPLACEMENT_CHARACTER);
            } else if (current == '-') {
                c cVar = c.CommentEndDash;
                bVar.a.advance();
                bVar.c = cVar;
            } else if (current != 65535) {
                bVar.n.j(characterReader.consumeToAny('-', 0));
            } else {
                bVar.i(this);
                bVar.g(bVar.n);
                bVar.c = c.Data;
            }
        }
    },
    CommentEndDash {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Comment;
            char c = characterReader.c();
            if (c == 0) {
                bVar.k(this);
                Token.d dVar = bVar.n;
                dVar.i('-');
                dVar.i(Utf8.REPLACEMENT_CHARACTER);
                bVar.c = cVar;
            } else if (c == '-') {
                bVar.c = c.CommentEnd;
            } else if (c != 65535) {
                Token.d dVar2 = bVar.n;
                dVar2.i('-');
                dVar2.i(c);
                bVar.c = cVar;
            } else {
                bVar.i(this);
                bVar.g(bVar.n);
                bVar.c = c.Data;
            }
        }
    },
    CommentEnd {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            c cVar2 = c.Comment;
            char c = characterReader.c();
            if (c == 0) {
                bVar.k(this);
                Token.d dVar = bVar.n;
                dVar.j("--");
                dVar.i(Utf8.REPLACEMENT_CHARACTER);
                bVar.c = cVar2;
            } else if (c == '!') {
                bVar.k(this);
                bVar.c = c.CommentEndBang;
            } else if (c == '-') {
                bVar.k(this);
                bVar.n.i('-');
            } else if (c == '>') {
                bVar.g(bVar.n);
                bVar.c = cVar;
            } else if (c != 65535) {
                bVar.k(this);
                Token.d dVar2 = bVar.n;
                dVar2.j("--");
                dVar2.i(c);
                bVar.c = cVar2;
            } else {
                bVar.i(this);
                bVar.g(bVar.n);
                bVar.c = cVar;
            }
        }
    },
    CommentEndBang {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            c cVar2 = c.Comment;
            char c = characterReader.c();
            if (c == 0) {
                bVar.k(this);
                Token.d dVar = bVar.n;
                dVar.j("--!");
                dVar.i(Utf8.REPLACEMENT_CHARACTER);
                bVar.c = cVar2;
            } else if (c == '-') {
                bVar.n.j("--!");
                bVar.c = c.CommentEndDash;
            } else if (c == '>') {
                bVar.g(bVar.n);
                bVar.c = cVar;
            } else if (c != 65535) {
                Token.d dVar2 = bVar.n;
                dVar2.j("--!");
                dVar2.i(c);
                bVar.c = cVar2;
            } else {
                bVar.i(this);
                bVar.g(bVar.n);
                bVar.c = cVar;
            }
        }
    },
    Doctype {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.BeforeDoctypeName;
            char c = characterReader.c();
            if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
                bVar.c = cVar;
                return;
            }
            if (c != '>') {
                if (c != 65535) {
                    bVar.k(this);
                    bVar.c = cVar;
                    return;
                }
                bVar.i(this);
            }
            bVar.k(this);
            bVar.m.g();
            Token.e eVar = bVar.m;
            eVar.f = true;
            bVar.g(eVar);
            bVar.c = c.Data;
        }
    },
    BeforeDoctypeName {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.DoctypeName;
            if (characterReader.m()) {
                bVar.m.g();
                bVar.c = cVar;
                return;
            }
            char c = characterReader.c();
            if (c == 0) {
                bVar.k(this);
                bVar.m.g();
                bVar.m.b.append(Utf8.REPLACEMENT_CHARACTER);
                bVar.c = cVar;
            } else if (c == ' ') {
            } else {
                if (c == 65535) {
                    bVar.i(this);
                    bVar.m.g();
                    Token.e eVar = bVar.m;
                    eVar.f = true;
                    bVar.g(eVar);
                    bVar.c = c.Data;
                } else if (c != '\t' && c != '\n' && c != '\f' && c != '\r') {
                    bVar.m.g();
                    bVar.m.b.append(c);
                    bVar.c = cVar;
                }
            }
        }
    },
    DoctypeName {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            if (characterReader.m()) {
                bVar.m.b.append(characterReader.e());
                return;
            }
            char c = characterReader.c();
            if (c != 0) {
                if (c != ' ') {
                    if (c == '>') {
                        bVar.g(bVar.m);
                        bVar.c = cVar;
                        return;
                    } else if (c == 65535) {
                        bVar.i(this);
                        Token.e eVar = bVar.m;
                        eVar.f = true;
                        bVar.g(eVar);
                        bVar.c = cVar;
                        return;
                    } else if (!(c == '\t' || c == '\n' || c == '\f' || c == '\r')) {
                        bVar.m.b.append(c);
                        return;
                    }
                }
                bVar.c = c.AfterDoctypeName;
                return;
            }
            bVar.k(this);
            bVar.m.b.append(Utf8.REPLACEMENT_CHARACTER);
        }
    },
    AfterDoctypeName {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            if (characterReader.isEmpty()) {
                bVar.i(this);
                Token.e eVar = bVar.m;
                eVar.f = true;
                bVar.g(eVar);
                bVar.c = cVar;
            } else if (characterReader.l('\t', '\n', '\r', '\f', ' ')) {
                characterReader.advance();
            } else if (characterReader.k(Typography.greater)) {
                bVar.g(bVar.m);
                bVar.a.advance();
                bVar.c = cVar;
            } else if (characterReader.j(DocumentType.PUBLIC_KEY)) {
                bVar.m.c = DocumentType.PUBLIC_KEY;
                bVar.c = c.AfterDoctypePublicKeyword;
            } else if (characterReader.j(DocumentType.SYSTEM_KEY)) {
                bVar.m.c = DocumentType.SYSTEM_KEY;
                bVar.c = c.AfterDoctypeSystemKeyword;
            } else {
                bVar.k(this);
                bVar.m.f = true;
                c cVar2 = c.BogusDoctype;
                bVar.a.advance();
                bVar.c = cVar2;
            }
        }
    },
    AfterDoctypePublicKeyword {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            char c = characterReader.c();
            if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
                bVar.c = c.BeforeDoctypePublicIdentifier;
            } else if (c == '\"') {
                bVar.k(this);
                bVar.c = c.DoctypePublicIdentifier_doubleQuoted;
            } else if (c == '\'') {
                bVar.k(this);
                bVar.c = c.DoctypePublicIdentifier_singleQuoted;
            } else if (c == '>') {
                bVar.k(this);
                Token.e eVar = bVar.m;
                eVar.f = true;
                bVar.g(eVar);
                bVar.c = cVar;
            } else if (c != 65535) {
                bVar.k(this);
                bVar.m.f = true;
                bVar.c = c.BogusDoctype;
            } else {
                bVar.i(this);
                Token.e eVar2 = bVar.m;
                eVar2.f = true;
                bVar.g(eVar2);
                bVar.c = cVar;
            }
        }
    },
    BeforeDoctypePublicIdentifier {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            char c = characterReader.c();
            if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                if (c == '\"') {
                    bVar.c = c.DoctypePublicIdentifier_doubleQuoted;
                } else if (c == '\'') {
                    bVar.c = c.DoctypePublicIdentifier_singleQuoted;
                } else if (c == '>') {
                    bVar.k(this);
                    Token.e eVar = bVar.m;
                    eVar.f = true;
                    bVar.g(eVar);
                    bVar.c = cVar;
                } else if (c != 65535) {
                    bVar.k(this);
                    bVar.m.f = true;
                    bVar.c = c.BogusDoctype;
                } else {
                    bVar.i(this);
                    Token.e eVar2 = bVar.m;
                    eVar2.f = true;
                    bVar.g(eVar2);
                    bVar.c = cVar;
                }
            }
        }
    },
    DoctypePublicIdentifier_doubleQuoted {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            char c = characterReader.c();
            if (c == 0) {
                bVar.k(this);
                bVar.m.d.append(Utf8.REPLACEMENT_CHARACTER);
            } else if (c == '\"') {
                bVar.c = c.AfterDoctypePublicIdentifier;
            } else if (c == '>') {
                bVar.k(this);
                Token.e eVar = bVar.m;
                eVar.f = true;
                bVar.g(eVar);
                bVar.c = cVar;
            } else if (c != 65535) {
                bVar.m.d.append(c);
            } else {
                bVar.i(this);
                Token.e eVar2 = bVar.m;
                eVar2.f = true;
                bVar.g(eVar2);
                bVar.c = cVar;
            }
        }
    },
    DoctypePublicIdentifier_singleQuoted {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            char c = characterReader.c();
            if (c == 0) {
                bVar.k(this);
                bVar.m.d.append(Utf8.REPLACEMENT_CHARACTER);
            } else if (c == '\'') {
                bVar.c = c.AfterDoctypePublicIdentifier;
            } else if (c == '>') {
                bVar.k(this);
                Token.e eVar = bVar.m;
                eVar.f = true;
                bVar.g(eVar);
                bVar.c = cVar;
            } else if (c != 65535) {
                bVar.m.d.append(c);
            } else {
                bVar.i(this);
                Token.e eVar2 = bVar.m;
                eVar2.f = true;
                bVar.g(eVar2);
                bVar.c = cVar;
            }
        }
    },
    AfterDoctypePublicIdentifier {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            char c = characterReader.c();
            if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
                bVar.c = c.BetweenDoctypePublicAndSystemIdentifiers;
            } else if (c == '\"') {
                bVar.k(this);
                bVar.c = c.DoctypeSystemIdentifier_doubleQuoted;
            } else if (c == '\'') {
                bVar.k(this);
                bVar.c = c.DoctypeSystemIdentifier_singleQuoted;
            } else if (c == '>') {
                bVar.g(bVar.m);
                bVar.c = cVar;
            } else if (c != 65535) {
                bVar.k(this);
                bVar.m.f = true;
                bVar.c = c.BogusDoctype;
            } else {
                bVar.i(this);
                Token.e eVar = bVar.m;
                eVar.f = true;
                bVar.g(eVar);
                bVar.c = cVar;
            }
        }
    },
    BetweenDoctypePublicAndSystemIdentifiers {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            char c = characterReader.c();
            if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                if (c == '\"') {
                    bVar.k(this);
                    bVar.c = c.DoctypeSystemIdentifier_doubleQuoted;
                } else if (c == '\'') {
                    bVar.k(this);
                    bVar.c = c.DoctypeSystemIdentifier_singleQuoted;
                } else if (c == '>') {
                    bVar.g(bVar.m);
                    bVar.c = cVar;
                } else if (c != 65535) {
                    bVar.k(this);
                    bVar.m.f = true;
                    bVar.c = c.BogusDoctype;
                } else {
                    bVar.i(this);
                    Token.e eVar = bVar.m;
                    eVar.f = true;
                    bVar.g(eVar);
                    bVar.c = cVar;
                }
            }
        }
    },
    AfterDoctypeSystemKeyword {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            char c = characterReader.c();
            if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
                bVar.c = c.BeforeDoctypeSystemIdentifier;
            } else if (c == '\"') {
                bVar.k(this);
                bVar.c = c.DoctypeSystemIdentifier_doubleQuoted;
            } else if (c == '\'') {
                bVar.k(this);
                bVar.c = c.DoctypeSystemIdentifier_singleQuoted;
            } else if (c == '>') {
                bVar.k(this);
                Token.e eVar = bVar.m;
                eVar.f = true;
                bVar.g(eVar);
                bVar.c = cVar;
            } else if (c != 65535) {
                bVar.k(this);
                Token.e eVar2 = bVar.m;
                eVar2.f = true;
                bVar.g(eVar2);
            } else {
                bVar.i(this);
                Token.e eVar3 = bVar.m;
                eVar3.f = true;
                bVar.g(eVar3);
                bVar.c = cVar;
            }
        }
    },
    BeforeDoctypeSystemIdentifier {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            char c = characterReader.c();
            if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                if (c == '\"') {
                    bVar.c = c.DoctypeSystemIdentifier_doubleQuoted;
                } else if (c == '\'') {
                    bVar.c = c.DoctypeSystemIdentifier_singleQuoted;
                } else if (c == '>') {
                    bVar.k(this);
                    Token.e eVar = bVar.m;
                    eVar.f = true;
                    bVar.g(eVar);
                    bVar.c = cVar;
                } else if (c != 65535) {
                    bVar.k(this);
                    bVar.m.f = true;
                    bVar.c = c.BogusDoctype;
                } else {
                    bVar.i(this);
                    Token.e eVar2 = bVar.m;
                    eVar2.f = true;
                    bVar.g(eVar2);
                    bVar.c = cVar;
                }
            }
        }
    },
    DoctypeSystemIdentifier_doubleQuoted {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            char c = characterReader.c();
            if (c == 0) {
                bVar.k(this);
                bVar.m.e.append(Utf8.REPLACEMENT_CHARACTER);
            } else if (c == '\"') {
                bVar.c = c.AfterDoctypeSystemIdentifier;
            } else if (c == '>') {
                bVar.k(this);
                Token.e eVar = bVar.m;
                eVar.f = true;
                bVar.g(eVar);
                bVar.c = cVar;
            } else if (c != 65535) {
                bVar.m.e.append(c);
            } else {
                bVar.i(this);
                Token.e eVar2 = bVar.m;
                eVar2.f = true;
                bVar.g(eVar2);
                bVar.c = cVar;
            }
        }
    },
    DoctypeSystemIdentifier_singleQuoted {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            char c = characterReader.c();
            if (c == 0) {
                bVar.k(this);
                bVar.m.e.append(Utf8.REPLACEMENT_CHARACTER);
            } else if (c == '\'') {
                bVar.c = c.AfterDoctypeSystemIdentifier;
            } else if (c == '>') {
                bVar.k(this);
                Token.e eVar = bVar.m;
                eVar.f = true;
                bVar.g(eVar);
                bVar.c = cVar;
            } else if (c != 65535) {
                bVar.m.e.append(c);
            } else {
                bVar.i(this);
                Token.e eVar2 = bVar.m;
                eVar2.f = true;
                bVar.g(eVar2);
                bVar.c = cVar;
            }
        }
    },
    AfterDoctypeSystemIdentifier {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            char c = characterReader.c();
            if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                if (c == '>') {
                    bVar.g(bVar.m);
                    bVar.c = cVar;
                } else if (c != 65535) {
                    bVar.k(this);
                    bVar.c = c.BogusDoctype;
                } else {
                    bVar.i(this);
                    Token.e eVar = bVar.m;
                    eVar.f = true;
                    bVar.g(eVar);
                    bVar.c = cVar;
                }
            }
        }
    },
    BogusDoctype {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            c cVar = c.Data;
            char c = characterReader.c();
            if (c == '>') {
                bVar.g(bVar.m);
                bVar.c = cVar;
            } else if (c == 65535) {
                bVar.g(bVar.m);
                bVar.c = cVar;
            }
        }
    },
    CdataSection {
        @Override // x6.b.b.c
        public void f(b bVar, CharacterReader characterReader) {
            String str;
            int n = characterReader.n("]]>");
            if (n != -1) {
                str = CharacterReader.b(characterReader.a, characterReader.h, characterReader.e, n);
                characterReader.e += n;
            } else {
                int i = characterReader.c;
                int i2 = characterReader.e;
                if (i - i2 < 3) {
                    str = characterReader.g();
                } else {
                    int i3 = (i - 3) + 1;
                    str = CharacterReader.b(characterReader.a, characterReader.h, i2, i3 - i2);
                    characterReader.e = i3;
                }
            }
            bVar.h.append(str);
            if (characterReader.i("]]>") || characterReader.isEmpty()) {
                bVar.g(new Token.b(bVar.h.toString()));
                bVar.c = c.Data;
            }
        }
    };
    
    public static final char[] p0 = {0, Typography.amp, '\''};
    public static final char[] q0 = {0, Typography.quote, Typography.amp};
    public static final char[] r0 = {0, '\t', '\n', '\f', '\r', ' ', Typography.quote, '\'', '/', Typography.less, '=', Typography.greater};
    public static final char[] s0 = {0, '\t', '\n', '\f', '\r', ' ', Typography.quote, Typography.amp, '\'', Typography.less, '=', Typography.greater, '`'};
    public static final String t0 = String.valueOf((char) Utf8.REPLACEMENT_CHARACTER);

    /* access modifiers changed from: public */
    c(k kVar) {
    }

    public static void a(b bVar, c cVar) {
        int[] b2 = bVar.b(null, false);
        if (b2 == null) {
            bVar.e(Typography.amp);
        } else {
            bVar.f(new String(b2, 0, b2.length));
        }
        bVar.c = cVar;
    }

    public static void b(b bVar, CharacterReader characterReader, c cVar, c cVar2) {
        char current = characterReader.current();
        if (current == 0) {
            bVar.k(cVar);
            characterReader.advance();
            bVar.e(Utf8.REPLACEMENT_CHARACTER);
        } else if (current == '<') {
            bVar.a.advance();
            bVar.c = cVar2;
        } else if (current != 65535) {
            int i2 = characterReader.e;
            int i3 = characterReader.c;
            char[] cArr = characterReader.a;
            int i4 = i2;
            while (i4 < i3) {
                char c = cArr[i4];
                if (c == 0 || c == '<') {
                    break;
                }
                i4++;
            }
            characterReader.e = i4;
            bVar.f(i4 > i2 ? CharacterReader.b(characterReader.a, characterReader.h, i2, i4 - i2) : "");
        } else {
            bVar.g(new Token.f());
        }
    }

    public static void c(b bVar, CharacterReader characterReader, c cVar, c cVar2) {
        if (characterReader.m()) {
            bVar.d(false);
            bVar.c = cVar;
            return;
        }
        bVar.f("</");
        bVar.c = cVar2;
    }

    public static void d(b bVar, CharacterReader characterReader, c cVar) {
        if (characterReader.m()) {
            String e2 = characterReader.e();
            bVar.i.n(e2);
            bVar.h.append(e2);
            return;
        }
        boolean z2 = false;
        boolean z3 = true;
        if (bVar.l() && !characterReader.isEmpty()) {
            char c = characterReader.c();
            if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
                bVar.c = BeforeAttributeName;
            } else if (c == '/') {
                bVar.c = SelfClosingStartTag;
            } else if (c != '>') {
                bVar.h.append(c);
                z2 = true;
            } else {
                bVar.h();
                bVar.c = Data;
            }
            z3 = z2;
        }
        if (z3) {
            StringBuilder L = a2.b.a.a.a.L("</");
            L.append(bVar.h.toString());
            bVar.f(L.toString());
            bVar.c = cVar;
        }
    }

    public static void e(b bVar, CharacterReader characterReader, c cVar, c cVar2) {
        if (characterReader.m()) {
            String e2 = characterReader.e();
            bVar.h.append(e2);
            bVar.f(e2);
            return;
        }
        char c = characterReader.c();
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ' || c == '/' || c == '>') {
            if (bVar.h.toString().equals("script")) {
                bVar.c = cVar;
            } else {
                bVar.c = cVar2;
            }
            bVar.e(c);
            return;
        }
        characterReader.p();
        bVar.c = cVar2;
    }

    public abstract void f(b bVar, CharacterReader characterReader);
}
