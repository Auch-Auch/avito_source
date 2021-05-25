package x6.b.b;

import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder;
import java.util.ArrayList;
import java.util.Objects;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.DocumentType;
import org.jsoup.nodes.Element;
import org.jsoup.parser.HtmlTreeBuilder;
import org.jsoup.parser.Tag;
import org.jsoup.parser.Token;
import org.spongycastle.i18n.ErrorBundle;
public enum a {
    Initial {
        @Override // x6.b.b.a
        public boolean c(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            a aVar = a.BeforeHtml;
            if (a.a(token)) {
                return true;
            }
            if (token.b()) {
                htmlTreeBuilder.t((Token.d) token);
            } else if (token.c()) {
                Token.e eVar = (Token.e) token;
                DocumentType documentType = new DocumentType(htmlTreeBuilder.settings.normalizeTag(eVar.b.toString()), eVar.d.toString(), eVar.e.toString());
                documentType.setPubSysKey(eVar.c);
                htmlTreeBuilder.doc.appendChild(documentType);
                if (eVar.f) {
                    htmlTreeBuilder.doc.quirksMode(Document.QuirksMode.quirks);
                }
                htmlTreeBuilder.e = aVar;
            } else {
                htmlTreeBuilder.e = aVar;
                return htmlTreeBuilder.process(token);
            }
            return true;
        }
    },
    BeforeHtml {
        @Override // x6.b.b.a
        public boolean c(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.c()) {
                htmlTreeBuilder.i(this);
                return false;
            } else if (token.b()) {
                htmlTreeBuilder.t((Token.d) token);
                return true;
            } else if (a.a(token)) {
                htmlTreeBuilder.s((Token.c) token);
                return true;
            } else {
                if (token.f()) {
                    Token.h hVar = (Token.h) token;
                    if (hVar.c.equals("html")) {
                        htmlTreeBuilder.r(hVar);
                        htmlTreeBuilder.e = a.BeforeHead;
                        return true;
                    }
                }
                if (token.e() && StringUtil.inSorted(((Token.g) token).c, x.e)) {
                    return d(token, htmlTreeBuilder);
                }
                if (!token.e()) {
                    return d(token, htmlTreeBuilder);
                }
                htmlTreeBuilder.i(this);
                return false;
            }
        }

        public final boolean d(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            Objects.requireNonNull(htmlTreeBuilder);
            Element element = new Element(Tag.valueOf("html", htmlTreeBuilder.settings), null);
            htmlTreeBuilder.y(element);
            htmlTreeBuilder.stack.add(element);
            htmlTreeBuilder.e = a.BeforeHead;
            return htmlTreeBuilder.process(token);
        }
    },
    BeforeHead {
        @Override // x6.b.b.a
        public boolean c(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (a.a(token)) {
                htmlTreeBuilder.s((Token.c) token);
                return true;
            } else if (token.b()) {
                htmlTreeBuilder.t((Token.d) token);
                return true;
            } else if (token.c()) {
                htmlTreeBuilder.i(this);
                return false;
            } else if (token.f() && ((Token.h) token).c.equals("html")) {
                return a.InBody.c(token, htmlTreeBuilder);
            } else {
                if (token.f()) {
                    Token.h hVar = (Token.h) token;
                    if (hVar.c.equals("head")) {
                        htmlTreeBuilder.h = htmlTreeBuilder.r(hVar);
                        htmlTreeBuilder.e = a.InHead;
                        return true;
                    }
                }
                if (token.e() && StringUtil.inSorted(((Token.g) token).c, x.e)) {
                    htmlTreeBuilder.processStartTag("head");
                    return htmlTreeBuilder.process(token);
                } else if (token.e()) {
                    htmlTreeBuilder.i(this);
                    return false;
                } else {
                    htmlTreeBuilder.processStartTag("head");
                    return htmlTreeBuilder.process(token);
                }
            }
        }
    },
    InHead {
        @Override // x6.b.b.a
        public boolean c(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            a aVar = a.Text;
            if (a.a(token)) {
                htmlTreeBuilder.s((Token.c) token);
                return true;
            }
            int ordinal = token.a.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    Token.h hVar = (Token.h) token;
                    String str = hVar.c;
                    if (str.equals("html")) {
                        return a.InBody.c(token, htmlTreeBuilder);
                    }
                    if (StringUtil.inSorted(str, x.a)) {
                        Element u = htmlTreeBuilder.u(hVar);
                        if (str.equals("base") && u.hasAttr(ShareConstants.WEB_DIALOG_PARAM_HREF) && !htmlTreeBuilder.g) {
                            String absUrl = u.absUrl(ShareConstants.WEB_DIALOG_PARAM_HREF);
                            if (absUrl.length() != 0) {
                                htmlTreeBuilder.baseUri = absUrl;
                                htmlTreeBuilder.g = true;
                                htmlTreeBuilder.doc.setBaseUri(absUrl);
                            }
                        }
                    } else if (str.equals("meta")) {
                        htmlTreeBuilder.u(hVar);
                    } else if (str.equals("title")) {
                        htmlTreeBuilder.b.c = c.Rcdata;
                        htmlTreeBuilder.f = htmlTreeBuilder.e;
                        htmlTreeBuilder.e = aVar;
                        htmlTreeBuilder.r(hVar);
                    } else if (StringUtil.inSorted(str, x.b)) {
                        a.b(hVar, htmlTreeBuilder);
                    } else if (str.equals("noscript")) {
                        htmlTreeBuilder.r(hVar);
                        htmlTreeBuilder.e = a.InHeadNoscript;
                    } else if (str.equals("script")) {
                        htmlTreeBuilder.b.c = c.ScriptData;
                        htmlTreeBuilder.f = htmlTreeBuilder.e;
                        htmlTreeBuilder.e = aVar;
                        htmlTreeBuilder.r(hVar);
                    } else if (!str.equals("head")) {
                        return d(token, htmlTreeBuilder);
                    } else {
                        htmlTreeBuilder.i(this);
                        return false;
                    }
                } else if (ordinal == 2) {
                    String str2 = ((Token.g) token).c;
                    if (str2.equals("head")) {
                        htmlTreeBuilder.C();
                        htmlTreeBuilder.e = a.AfterHead;
                    } else if (StringUtil.inSorted(str2, x.c)) {
                        return d(token, htmlTreeBuilder);
                    } else {
                        htmlTreeBuilder.i(this);
                        return false;
                    }
                } else if (ordinal != 3) {
                    return d(token, htmlTreeBuilder);
                } else {
                    htmlTreeBuilder.t((Token.d) token);
                }
                return true;
            }
            htmlTreeBuilder.i(this);
            return false;
        }

        public final boolean d(Token token, d dVar) {
            dVar.processEndTag("head");
            return dVar.process(token);
        }
    },
    InHeadNoscript {
        @Override // x6.b.b.a
        public boolean c(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            a aVar = a.InHead;
            if (token.c()) {
                htmlTreeBuilder.i(this);
            } else if (token.f() && ((Token.h) token).c.equals("html")) {
                a aVar2 = a.InBody;
                htmlTreeBuilder.currentToken = token;
                return aVar2.c(token, htmlTreeBuilder);
            } else if (token.e() && ((Token.g) token).c.equals("noscript")) {
                htmlTreeBuilder.C();
                htmlTreeBuilder.e = aVar;
            } else if (a.a(token) || token.b() || (token.f() && StringUtil.inSorted(((Token.h) token).c, x.f))) {
                htmlTreeBuilder.currentToken = token;
                return aVar.c(token, htmlTreeBuilder);
            } else if (token.e() && ((Token.g) token).c.equals("br")) {
                htmlTreeBuilder.i(this);
                Token.c cVar = new Token.c();
                cVar.b = token.toString();
                htmlTreeBuilder.s(cVar);
                return true;
            } else if ((!token.f() || !StringUtil.inSorted(((Token.h) token).c, x.K)) && !token.e()) {
                htmlTreeBuilder.i(this);
                Token.c cVar2 = new Token.c();
                cVar2.b = token.toString();
                htmlTreeBuilder.s(cVar2);
                return true;
            } else {
                htmlTreeBuilder.i(this);
                return false;
            }
            return true;
        }
    },
    AfterHead {
        @Override // x6.b.b.a
        public boolean c(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            a aVar = a.InBody;
            if (a.a(token)) {
                htmlTreeBuilder.s((Token.c) token);
                return true;
            } else if (token.b()) {
                htmlTreeBuilder.t((Token.d) token);
                return true;
            } else if (token.c()) {
                htmlTreeBuilder.i(this);
                return true;
            } else if (token.f()) {
                Token.h hVar = (Token.h) token;
                String str = hVar.c;
                if (str.equals("html")) {
                    return htmlTreeBuilder.E(token, aVar);
                }
                if (str.equals(SDKConstants.PARAM_A2U_BODY)) {
                    htmlTreeBuilder.r(hVar);
                    htmlTreeBuilder.n = false;
                    htmlTreeBuilder.e = aVar;
                    return true;
                } else if (str.equals("frameset")) {
                    htmlTreeBuilder.r(hVar);
                    htmlTreeBuilder.e = a.InFrameset;
                    return true;
                } else if (StringUtil.inSorted(str, x.g)) {
                    htmlTreeBuilder.i(this);
                    Element element = htmlTreeBuilder.h;
                    htmlTreeBuilder.stack.add(element);
                    htmlTreeBuilder.E(token, a.InHead);
                    htmlTreeBuilder.I(element);
                    return true;
                } else if (str.equals("head")) {
                    htmlTreeBuilder.i(this);
                    return false;
                } else {
                    d(token, htmlTreeBuilder);
                    return true;
                }
            } else if (!token.e()) {
                d(token, htmlTreeBuilder);
                return true;
            } else if (StringUtil.inSorted(((Token.g) token).c, x.d)) {
                d(token, htmlTreeBuilder);
                return true;
            } else {
                htmlTreeBuilder.i(this);
                return false;
            }
        }

        public final boolean d(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            htmlTreeBuilder.processStartTag(SDKConstants.PARAM_A2U_BODY);
            htmlTreeBuilder.n = true;
            return htmlTreeBuilder.process(token);
        }
    },
    InBody {
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Code restructure failed: missing block: B:67:0x0132, code lost:
            if (r10.equals("h2") == false) goto L_0x0141;
         */
        /* JADX WARNING: Removed duplicated region for block: B:178:0x0355  */
        /* JADX WARNING: Removed duplicated region for block: B:182:0x0362  */
        /* JADX WARNING: Removed duplicated region for block: B:188:0x0395 A[LOOP:4: B:187:0x0393->B:188:0x0395, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:191:0x03af  */
        /* JADX WARNING: Removed duplicated region for block: B:192:0x03b1  */
        @Override // x6.b.b.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean c(org.jsoup.parser.Token r29, org.jsoup.parser.HtmlTreeBuilder r30) {
            /*
            // Method dump skipped, instructions count: 3270
            */
            throw new UnsupportedOperationException("Method not decompiled: x6.b.b.a.u.c(org.jsoup.parser.Token, org.jsoup.parser.HtmlTreeBuilder):boolean");
        }

        public boolean d(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            String str = ((Token.g) token).c;
            ArrayList<Element> arrayList = htmlTreeBuilder.stack;
            int size = arrayList.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                Element element = arrayList.get(size);
                if (element.normalName().equals(str)) {
                    htmlTreeBuilder.j(str);
                    if (!str.equals(htmlTreeBuilder.currentElement().normalName())) {
                        htmlTreeBuilder.i(this);
                    }
                    htmlTreeBuilder.D(str);
                } else if (htmlTreeBuilder.A(element)) {
                    htmlTreeBuilder.i(this);
                    return false;
                } else {
                    size--;
                }
            }
            return true;
        }
    },
    Text {
        @Override // x6.b.b.a
        public boolean c(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.a()) {
                htmlTreeBuilder.s((Token.c) token);
                return true;
            } else if (token.d()) {
                htmlTreeBuilder.i(this);
                htmlTreeBuilder.C();
                htmlTreeBuilder.e = htmlTreeBuilder.f;
                return htmlTreeBuilder.process(token);
            } else if (!token.e()) {
                return true;
            } else {
                htmlTreeBuilder.C();
                htmlTreeBuilder.e = htmlTreeBuilder.f;
                return true;
            }
        }
    },
    InTable {
        @Override // x6.b.b.a
        public boolean c(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.a()) {
                Objects.requireNonNull(htmlTreeBuilder);
                htmlTreeBuilder.l = new ArrayList();
                htmlTreeBuilder.f = htmlTreeBuilder.e;
                htmlTreeBuilder.e = a.InTableText;
                return htmlTreeBuilder.process(token);
            } else if (token.b()) {
                htmlTreeBuilder.t((Token.d) token);
                return true;
            } else if (token.c()) {
                htmlTreeBuilder.i(this);
                return false;
            } else if (token.f()) {
                Token.h hVar = (Token.h) token;
                String str = hVar.c;
                if (str.equals(ShareConstants.FEED_CAPTION_PARAM)) {
                    htmlTreeBuilder.h();
                    htmlTreeBuilder.x();
                    htmlTreeBuilder.r(hVar);
                    htmlTreeBuilder.e = a.InCaption;
                } else if (str.equals("colgroup")) {
                    htmlTreeBuilder.h();
                    htmlTreeBuilder.r(hVar);
                    htmlTreeBuilder.e = a.InColumnGroup;
                } else if (str.equals("col")) {
                    htmlTreeBuilder.processStartTag("colgroup");
                    return htmlTreeBuilder.process(token);
                } else if (StringUtil.inSorted(str, x.u)) {
                    htmlTreeBuilder.h();
                    htmlTreeBuilder.r(hVar);
                    htmlTreeBuilder.e = a.InTableBody;
                } else if (StringUtil.inSorted(str, x.v)) {
                    htmlTreeBuilder.processStartTag("tbody");
                    return htmlTreeBuilder.process(token);
                } else if (str.equals("table")) {
                    htmlTreeBuilder.i(this);
                    if (htmlTreeBuilder.processEndTag("table")) {
                        return htmlTreeBuilder.process(token);
                    }
                } else if (StringUtil.inSorted(str, x.w)) {
                    a aVar = a.InHead;
                    htmlTreeBuilder.currentToken = token;
                    return aVar.c(token, htmlTreeBuilder);
                } else if (str.equals("input")) {
                    if (!hVar.j.get("type").equalsIgnoreCase(PanelStateKt.PANEL_HIDDEN)) {
                        return d(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.u(hVar);
                } else if (!str.equals("form")) {
                    return d(token, htmlTreeBuilder);
                } else {
                    htmlTreeBuilder.i(this);
                    if (htmlTreeBuilder.i != null) {
                        return false;
                    }
                    htmlTreeBuilder.v(hVar, false);
                }
                return true;
            } else if (token.e()) {
                String str2 = ((Token.g) token).c;
                if (str2.equals("table")) {
                    if (!htmlTreeBuilder.q(str2)) {
                        htmlTreeBuilder.i(this);
                        return false;
                    }
                    htmlTreeBuilder.D("table");
                    htmlTreeBuilder.J();
                    return true;
                } else if (!StringUtil.inSorted(str2, x.B)) {
                    return d(token, htmlTreeBuilder);
                } else {
                    htmlTreeBuilder.i(this);
                    return false;
                }
            } else if (!token.d()) {
                return d(token, htmlTreeBuilder);
            } else {
                if (htmlTreeBuilder.currentElement().normalName().equals("html")) {
                    htmlTreeBuilder.i(this);
                }
                return true;
            }
        }

        public boolean d(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            a aVar = a.InBody;
            htmlTreeBuilder.i(this);
            if (StringUtil.inSorted(htmlTreeBuilder.currentElement().normalName(), x.C)) {
                htmlTreeBuilder.o = true;
                htmlTreeBuilder.currentToken = token;
                boolean c = aVar.c(token, htmlTreeBuilder);
                htmlTreeBuilder.o = false;
                return c;
            }
            htmlTreeBuilder.currentToken = token;
            return aVar.c(token, htmlTreeBuilder);
        }
    },
    InTableText {
        @Override // x6.b.b.a
        public boolean c(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            a aVar = a.InBody;
            if (token.a == Token.TokenType.Character) {
                Token.c cVar = (Token.c) token;
                if (cVar.b.equals(a.x)) {
                    htmlTreeBuilder.i(this);
                    return false;
                }
                htmlTreeBuilder.l.add(cVar.b);
                return true;
            }
            if (htmlTreeBuilder.l.size() > 0) {
                for (String str : htmlTreeBuilder.l) {
                    if (!StringUtil.isBlank(str)) {
                        htmlTreeBuilder.i(this);
                        if (StringUtil.inSorted(htmlTreeBuilder.currentElement().normalName(), x.C)) {
                            htmlTreeBuilder.o = true;
                            Token.c cVar2 = new Token.c();
                            cVar2.b = str;
                            htmlTreeBuilder.currentToken = cVar2;
                            aVar.c(cVar2, htmlTreeBuilder);
                            htmlTreeBuilder.o = false;
                        } else {
                            Token.c cVar3 = new Token.c();
                            cVar3.b = str;
                            htmlTreeBuilder.currentToken = cVar3;
                            aVar.c(cVar3, htmlTreeBuilder);
                        }
                    } else {
                        Token.c cVar4 = new Token.c();
                        cVar4.b = str;
                        htmlTreeBuilder.s(cVar4);
                    }
                }
                htmlTreeBuilder.l = new ArrayList();
            }
            htmlTreeBuilder.e = htmlTreeBuilder.f;
            return htmlTreeBuilder.process(token);
        }
    },
    InCaption {
        @Override // x6.b.b.a
        public boolean c(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.e()) {
                Token.g gVar = (Token.g) token;
                if (gVar.c.equals(ShareConstants.FEED_CAPTION_PARAM)) {
                    if (!htmlTreeBuilder.q(gVar.c)) {
                        htmlTreeBuilder.i(this);
                        return false;
                    }
                    htmlTreeBuilder.j(null);
                    if (!htmlTreeBuilder.currentElement().normalName().equals(ShareConstants.FEED_CAPTION_PARAM)) {
                        htmlTreeBuilder.i(this);
                    }
                    htmlTreeBuilder.D(ShareConstants.FEED_CAPTION_PARAM);
                    htmlTreeBuilder.e();
                    htmlTreeBuilder.e = a.InTable;
                    return true;
                }
            }
            if ((token.f() && StringUtil.inSorted(((Token.h) token).c, x.A)) || (token.e() && ((Token.g) token).c.equals("table"))) {
                htmlTreeBuilder.i(this);
                if (htmlTreeBuilder.processEndTag(ShareConstants.FEED_CAPTION_PARAM)) {
                    return htmlTreeBuilder.process(token);
                }
                return true;
            } else if (!token.e() || !StringUtil.inSorted(((Token.g) token).c, x.L)) {
                return htmlTreeBuilder.E(token, a.InBody);
            } else {
                htmlTreeBuilder.i(this);
                return false;
            }
        }
    },
    InColumnGroup {
        @Override // x6.b.b.a
        public boolean c(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (a.a(token)) {
                htmlTreeBuilder.s((Token.c) token);
                return true;
            }
            int ordinal = token.a.ordinal();
            if (ordinal == 0) {
                htmlTreeBuilder.i(this);
            } else if (ordinal == 1) {
                Token.h hVar = (Token.h) token;
                String str = hVar.c;
                str.hashCode();
                if (str.equals("col")) {
                    htmlTreeBuilder.u(hVar);
                } else if (!str.equals("html")) {
                    return d(token, htmlTreeBuilder);
                } else {
                    return htmlTreeBuilder.E(token, a.InBody);
                }
            } else if (ordinal != 2) {
                if (ordinal == 3) {
                    htmlTreeBuilder.t((Token.d) token);
                } else if (ordinal != 5) {
                    return d(token, htmlTreeBuilder);
                } else {
                    if (htmlTreeBuilder.currentElement().normalName().equals("html")) {
                        return true;
                    }
                    return d(token, htmlTreeBuilder);
                }
            } else if (!((Token.g) token).c.equals("colgroup")) {
                return d(token, htmlTreeBuilder);
            } else {
                if (htmlTreeBuilder.currentElement().normalName().equals("html")) {
                    htmlTreeBuilder.i(this);
                    return false;
                }
                htmlTreeBuilder.C();
                htmlTreeBuilder.e = a.InTable;
            }
            return true;
        }

        public final boolean d(Token token, d dVar) {
            if (dVar.processEndTag("colgroup")) {
                return dVar.process(token);
            }
            return true;
        }
    },
    InTableBody {
        @Override // x6.b.b.a
        public boolean c(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            int ordinal = token.a.ordinal();
            if (ordinal == 1) {
                Token.h hVar = (Token.h) token;
                String str = hVar.c;
                if (str.equals("template")) {
                    htmlTreeBuilder.r(hVar);
                } else if (str.equals("tr")) {
                    htmlTreeBuilder.g();
                    htmlTreeBuilder.r(hVar);
                    htmlTreeBuilder.e = a.InRow;
                } else if (StringUtil.inSorted(str, x.x)) {
                    htmlTreeBuilder.i(this);
                    htmlTreeBuilder.processStartTag("tr");
                    return htmlTreeBuilder.process(hVar);
                } else if (StringUtil.inSorted(str, x.D)) {
                    return e(token, htmlTreeBuilder);
                } else {
                    return d(token, htmlTreeBuilder);
                }
            } else if (ordinal != 2) {
                return d(token, htmlTreeBuilder);
            } else {
                String str2 = ((Token.g) token).c;
                if (StringUtil.inSorted(str2, x.J)) {
                    if (!htmlTreeBuilder.q(str2)) {
                        htmlTreeBuilder.i(this);
                        return false;
                    }
                    htmlTreeBuilder.g();
                    htmlTreeBuilder.C();
                    htmlTreeBuilder.e = a.InTable;
                } else if (str2.equals("table")) {
                    return e(token, htmlTreeBuilder);
                } else {
                    if (!StringUtil.inSorted(str2, x.E)) {
                        return d(token, htmlTreeBuilder);
                    }
                    htmlTreeBuilder.i(this);
                    return false;
                }
            }
            return true;
        }

        public final boolean d(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            a aVar = a.InTable;
            htmlTreeBuilder.currentToken = token;
            return aVar.c(token, htmlTreeBuilder);
        }

        public final boolean e(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (htmlTreeBuilder.q("tbody") || htmlTreeBuilder.q("thead") || htmlTreeBuilder.n("tfoot")) {
                htmlTreeBuilder.g();
                htmlTreeBuilder.processEndTag(htmlTreeBuilder.currentElement().normalName());
                return htmlTreeBuilder.process(token);
            }
            htmlTreeBuilder.i(this);
            return false;
        }
    },
    InRow {
        @Override // x6.b.b.a
        public boolean c(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.f()) {
                Token.h hVar = (Token.h) token;
                String str = hVar.c;
                if (str.equals("template")) {
                    htmlTreeBuilder.r(hVar);
                    return true;
                } else if (StringUtil.inSorted(str, x.x)) {
                    htmlTreeBuilder.f("tr", "template");
                    htmlTreeBuilder.r(hVar);
                    htmlTreeBuilder.e = a.InCell;
                    htmlTreeBuilder.x();
                    return true;
                } else if (!StringUtil.inSorted(str, x.F)) {
                    return d(token, htmlTreeBuilder);
                } else {
                    if (htmlTreeBuilder.processEndTag("tr")) {
                        return htmlTreeBuilder.process(token);
                    }
                    return false;
                }
            } else if (!token.e()) {
                return d(token, htmlTreeBuilder);
            } else {
                String str2 = ((Token.g) token).c;
                if (str2.equals("tr")) {
                    if (!htmlTreeBuilder.q(str2)) {
                        htmlTreeBuilder.i(this);
                        return false;
                    }
                    htmlTreeBuilder.f("tr", "template");
                    htmlTreeBuilder.C();
                    htmlTreeBuilder.e = a.InTableBody;
                    return true;
                } else if (str2.equals("table")) {
                    if (htmlTreeBuilder.processEndTag("tr")) {
                        return htmlTreeBuilder.process(token);
                    }
                    return false;
                } else if (StringUtil.inSorted(str2, x.u)) {
                    if (!htmlTreeBuilder.q(str2)) {
                        htmlTreeBuilder.i(this);
                        return false;
                    }
                    htmlTreeBuilder.processEndTag("tr");
                    return htmlTreeBuilder.process(token);
                } else if (!StringUtil.inSorted(str2, x.G)) {
                    return d(token, htmlTreeBuilder);
                } else {
                    htmlTreeBuilder.i(this);
                    return false;
                }
            }
        }

        public final boolean d(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            a aVar = a.InTable;
            htmlTreeBuilder.currentToken = token;
            return aVar.c(token, htmlTreeBuilder);
        }
    },
    InCell {
        @Override // x6.b.b.a
        public boolean c(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            a aVar = a.InRow;
            a aVar2 = a.InBody;
            if (token.e()) {
                String str = ((Token.g) token).c;
                if (StringUtil.inSorted(str, x.x)) {
                    if (!htmlTreeBuilder.q(str)) {
                        htmlTreeBuilder.i(this);
                        htmlTreeBuilder.e = aVar;
                        return false;
                    }
                    htmlTreeBuilder.j(null);
                    if (!htmlTreeBuilder.currentElement().normalName().equals(str)) {
                        htmlTreeBuilder.i(this);
                    }
                    htmlTreeBuilder.D(str);
                    htmlTreeBuilder.e();
                    htmlTreeBuilder.e = aVar;
                    return true;
                } else if (StringUtil.inSorted(str, x.y)) {
                    htmlTreeBuilder.i(this);
                    return false;
                } else if (!StringUtil.inSorted(str, x.z)) {
                    htmlTreeBuilder.currentToken = token;
                    return aVar2.c(token, htmlTreeBuilder);
                } else if (!htmlTreeBuilder.q(str)) {
                    htmlTreeBuilder.i(this);
                    return false;
                } else {
                    if (htmlTreeBuilder.q("td")) {
                        htmlTreeBuilder.processEndTag("td");
                    } else {
                        htmlTreeBuilder.processEndTag("th");
                    }
                    return htmlTreeBuilder.process(token);
                }
            } else if (!token.f() || !StringUtil.inSorted(((Token.h) token).c, x.A)) {
                htmlTreeBuilder.currentToken = token;
                return aVar2.c(token, htmlTreeBuilder);
            } else if (htmlTreeBuilder.q("td") || htmlTreeBuilder.q("th")) {
                if (htmlTreeBuilder.q("td")) {
                    htmlTreeBuilder.processEndTag("td");
                } else {
                    htmlTreeBuilder.processEndTag("th");
                }
                return htmlTreeBuilder.process(token);
            } else {
                htmlTreeBuilder.i(this);
                return false;
            }
        }
    },
    InSelect {
        /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0066, code lost:
            if (r9.equals("optgroup") == false) goto L_0x007b;
         */
        @Override // x6.b.b.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean c(org.jsoup.parser.Token r9, org.jsoup.parser.HtmlTreeBuilder r10) {
            /*
            // Method dump skipped, instructions count: 416
            */
            throw new UnsupportedOperationException("Method not decompiled: x6.b.b.a.g.c(org.jsoup.parser.Token, org.jsoup.parser.HtmlTreeBuilder):boolean");
        }
    },
    InSelectInTable {
        @Override // x6.b.b.a
        public boolean c(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (!token.f() || !StringUtil.inSorted(((Token.h) token).c, x.I)) {
                if (token.e()) {
                    Token.g gVar = (Token.g) token;
                    if (StringUtil.inSorted(gVar.c, x.I)) {
                        htmlTreeBuilder.i(this);
                        if (!htmlTreeBuilder.q(gVar.c)) {
                            return false;
                        }
                        htmlTreeBuilder.processEndTag("select");
                        return htmlTreeBuilder.process(token);
                    }
                }
                return htmlTreeBuilder.E(token, a.InSelect);
            }
            htmlTreeBuilder.i(this);
            htmlTreeBuilder.processEndTag("select");
            return htmlTreeBuilder.process(token);
        }
    },
    AfterBody {
        @Override // x6.b.b.a
        public boolean c(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            a aVar = a.InBody;
            if (a.a(token)) {
                htmlTreeBuilder.s((Token.c) token);
                return true;
            } else if (token.b()) {
                htmlTreeBuilder.t((Token.d) token);
                return true;
            } else if (token.c()) {
                htmlTreeBuilder.i(this);
                return false;
            } else if (token.f() && ((Token.h) token).c.equals("html")) {
                htmlTreeBuilder.currentToken = token;
                return aVar.c(token, htmlTreeBuilder);
            } else if (!token.e() || !((Token.g) token).c.equals("html")) {
                if (token.d()) {
                    return true;
                }
                htmlTreeBuilder.i(this);
                htmlTreeBuilder.e = aVar;
                return htmlTreeBuilder.process(token);
            } else if (htmlTreeBuilder.p) {
                htmlTreeBuilder.i(this);
                return false;
            } else {
                htmlTreeBuilder.e = a.AfterAfterBody;
                return true;
            }
        }
    },
    InFrameset {
        @Override // x6.b.b.a
        public boolean c(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (a.a(token)) {
                htmlTreeBuilder.s((Token.c) token);
            } else if (token.b()) {
                htmlTreeBuilder.t((Token.d) token);
            } else if (token.c()) {
                htmlTreeBuilder.i(this);
                return false;
            } else if (token.f()) {
                Token.h hVar = (Token.h) token;
                String str = hVar.c;
                str.hashCode();
                str.hashCode();
                char c = 65535;
                switch (str.hashCode()) {
                    case -1644953643:
                        if (str.equals("frameset")) {
                            c = 0;
                            break;
                        }
                        break;
                    case 3213227:
                        if (str.equals("html")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 97692013:
                        if (str.equals(TextureMediaEncoder.FRAME_EVENT)) {
                            c = 2;
                            break;
                        }
                        break;
                    case 1192721831:
                        if (str.equals("noframes")) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        htmlTreeBuilder.r(hVar);
                        break;
                    case 1:
                        a aVar = a.InBody;
                        htmlTreeBuilder.currentToken = hVar;
                        return aVar.c(hVar, htmlTreeBuilder);
                    case 2:
                        htmlTreeBuilder.u(hVar);
                        break;
                    case 3:
                        a aVar2 = a.InHead;
                        htmlTreeBuilder.currentToken = hVar;
                        return aVar2.c(hVar, htmlTreeBuilder);
                    default:
                        htmlTreeBuilder.i(this);
                        return false;
                }
            } else if (!token.e() || !((Token.g) token).c.equals("frameset")) {
                if (!token.d()) {
                    htmlTreeBuilder.i(this);
                    return false;
                } else if (!htmlTreeBuilder.currentElement().normalName().equals("html")) {
                    htmlTreeBuilder.i(this);
                }
            } else if (htmlTreeBuilder.currentElement().normalName().equals("html")) {
                htmlTreeBuilder.i(this);
                return false;
            } else {
                htmlTreeBuilder.C();
                if (!htmlTreeBuilder.p && !htmlTreeBuilder.currentElement().normalName().equals("frameset")) {
                    htmlTreeBuilder.e = a.AfterFrameset;
                }
            }
            return true;
        }
    },
    AfterFrameset {
        @Override // x6.b.b.a
        public boolean c(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (a.a(token)) {
                htmlTreeBuilder.s((Token.c) token);
                return true;
            } else if (token.b()) {
                htmlTreeBuilder.t((Token.d) token);
                return true;
            } else if (token.c()) {
                htmlTreeBuilder.i(this);
                return false;
            } else if (token.f() && ((Token.h) token).c.equals("html")) {
                return htmlTreeBuilder.E(token, a.InBody);
            } else {
                if (token.e() && ((Token.g) token).c.equals("html")) {
                    htmlTreeBuilder.e = a.AfterAfterFrameset;
                    return true;
                } else if (token.f() && ((Token.h) token).c.equals("noframes")) {
                    return htmlTreeBuilder.E(token, a.InHead);
                } else {
                    if (token.d()) {
                        return true;
                    }
                    htmlTreeBuilder.i(this);
                    return false;
                }
            }
        }
    },
    AfterAfterBody {
        @Override // x6.b.b.a
        public boolean c(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            a aVar = a.InBody;
            if (token.b()) {
                htmlTreeBuilder.t((Token.d) token);
                return true;
            } else if (token.c() || (token.f() && ((Token.h) token).c.equals("html"))) {
                return htmlTreeBuilder.E(token, aVar);
            } else {
                if (a.a(token)) {
                    Element D = htmlTreeBuilder.D("html");
                    htmlTreeBuilder.s((Token.c) token);
                    htmlTreeBuilder.stack.add(D);
                    htmlTreeBuilder.stack.add(D.selectFirst(SDKConstants.PARAM_A2U_BODY));
                    return true;
                } else if (token.d()) {
                    return true;
                } else {
                    htmlTreeBuilder.i(this);
                    htmlTreeBuilder.e = aVar;
                    return htmlTreeBuilder.process(token);
                }
            }
        }
    },
    AfterAfterFrameset {
        @Override // x6.b.b.a
        public boolean c(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            if (token.b()) {
                htmlTreeBuilder.t((Token.d) token);
                return true;
            } else if (token.c() || a.a(token) || (token.f() && ((Token.h) token).c.equals("html"))) {
                return htmlTreeBuilder.E(token, a.InBody);
            } else {
                if (token.d()) {
                    return true;
                }
                if (token.f() && ((Token.h) token).c.equals("noframes")) {
                    return htmlTreeBuilder.E(token, a.InHead);
                }
                htmlTreeBuilder.i(this);
                return false;
            }
        }
    },
    ForeignContent {
        @Override // x6.b.b.a
        public boolean c(Token token, HtmlTreeBuilder htmlTreeBuilder) {
            return true;
        }
    };
    
    public static final String x = String.valueOf((char) 0);

    public static final class x {
        public static final String[] A = {ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr"};
        public static final String[] B = {SDKConstants.PARAM_A2U_BODY, ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};
        public static final String[] C = {"table", "tbody", "tfoot", "thead", "tr"};
        public static final String[] D = {ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", "tbody", "tfoot", "thead"};
        public static final String[] E = {SDKConstants.PARAM_A2U_BODY, ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", "html", "td", "th", "tr"};
        public static final String[] F = {ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", "tbody", "tfoot", "thead", "tr"};
        public static final String[] G = {SDKConstants.PARAM_A2U_BODY, ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", "html", "td", "th"};
        public static final String[] H = {"input", "keygen", "textarea"};
        public static final String[] I = {ShareConstants.FEED_CAPTION_PARAM, "table", "tbody", "td", "tfoot", "th", "thead", "tr"};
        public static final String[] J = {"tbody", "tfoot", "thead"};
        public static final String[] K = {"head", "noscript"};
        public static final String[] L = {SDKConstants.PARAM_A2U_BODY, "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr"};
        public static final String[] a = {"base", "basefont", "bgsound", "command", "link"};
        public static final String[] b = {"noframes", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE};
        public static final String[] c = {SDKConstants.PARAM_A2U_BODY, "br", "html"};
        public static final String[] d = {SDKConstants.PARAM_A2U_BODY, "html"};
        public static final String[] e = {SDKConstants.PARAM_A2U_BODY, "br", "head", "html"};
        public static final String[] f = {"basefont", "bgsound", "link", "meta", "noframes", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE};
        public static final String[] g = {"base", "basefont", "bgsound", "command", "link", "meta", "noframes", "script", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "title"};
        public static final String[] h = {IntegrityManager.INTEGRITY_TYPE_ADDRESS, "article", "aside", "blockquote", "center", ErrorBundle.DETAIL_ENTRY, "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", TariffPackageInfoConverterKt.HEADER_STRING_ID, "hgroup", "menu", "nav", "ol", "p", "section", ErrorBundle.SUMMARY_ENTRY, "ul"};
        public static final String[] i = {"h1", "h2", "h3", "h4", "h5", "h6"};
        public static final String[] j = {IntegrityManager.INTEGRITY_TYPE_ADDRESS, "div", "p"};
        public static final String[] k = {"dd", "dt"};
        public static final String[] l = {AuthSource.BOOKING_ORDER, "big", "code", UserDataStore.EMAIL, "font", "i", "s", "small", "strike", "strong", "tt", "u"};
        public static final String[] m = {"applet", "marquee", "object"};
        public static final String[] n = {"area", "br", "embed", "img", "keygen", "wbr"};
        public static final String[] o = {"param", "source", "track"};
        public static final String[] p = {"action", "name", "prompt"};
        public static final String[] q = {ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", TextureMediaEncoder.FRAME_EVENT, "head", "tbody", "td", "tfoot", "th", "thead", "tr"};
        public static final String[] r = {IntegrityManager.INTEGRITY_TYPE_ADDRESS, "article", "aside", "blockquote", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "center", ErrorBundle.DETAIL_ENTRY, "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", TariffPackageInfoConverterKt.HEADER_STRING_ID, "hgroup", "listing", "menu", "nav", "ol", "pre", "section", ErrorBundle.SUMMARY_ENTRY, "ul"};
        public static final String[] s = {AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "big", "code", UserDataStore.EMAIL, "font", "i", "nobr", "s", "small", "strike", "strong", "tt", "u"};
        public static final String[] t = {"table", "tbody", "tfoot", "thead", "tr"};
        public static final String[] u = {"tbody", "tfoot", "thead"};
        public static final String[] v = {"td", "th", "tr"};
        public static final String[] w = {"script", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE};
        public static final String[] x = {"td", "th"};
        public static final String[] y = {SDKConstants.PARAM_A2U_BODY, ShareConstants.FEED_CAPTION_PARAM, "col", "colgroup", "html"};
        public static final String[] z = {"table", "tbody", "tfoot", "thead", "tr"};
    }

    /* access modifiers changed from: public */
    a(k kVar) {
    }

    public static boolean a(Token token) {
        if (token.a()) {
            return StringUtil.isBlank(((Token.c) token).b);
        }
        return false;
    }

    public static void b(Token.h hVar, HtmlTreeBuilder htmlTreeBuilder) {
        htmlTreeBuilder.b.c = c.Rawtext;
        htmlTreeBuilder.f = htmlTreeBuilder.e;
        htmlTreeBuilder.e = Text;
        htmlTreeBuilder.r(hVar);
    }

    public abstract boolean c(Token token, HtmlTreeBuilder htmlTreeBuilder);
}
