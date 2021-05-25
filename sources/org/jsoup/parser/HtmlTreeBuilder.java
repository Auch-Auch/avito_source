package org.jsoup.parser;

import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.CDataNode;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.DataNode;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.FormElement;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.parser.Token;
import org.jsoup.select.Elements;
import org.spongycastle.i18n.ErrorBundle;
import x6.b.b.a;
import x6.b.b.b;
import x6.b.b.c;
import x6.b.b.d;
public class HtmlTreeBuilder extends d {
    public static final int MaxScopeSearchDepth = 100;
    public static final String[] r = {"applet", ShareConstants.FEED_CAPTION_PARAM, "html", "marquee", "object", "table", "td", "th"};
    public static final String[] s = {"ol", "ul"};
    public static final String[] t = {PhonePageSourceKt.PHONE_SOURCE_BUTTON};
    public static final String[] u = {"html", "table"};
    public static final String[] v = {"optgroup", "option"};
    public static final String[] w = {"dd", "dt", "li", "optgroup", "option", "p", "rp", "rt"};
    public static final String[] x = {IntegrityManager.INTEGRITY_TYPE_ADDRESS, "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", SDKConstants.PARAM_A2U_BODY, "br", PhonePageSourceKt.PHONE_SOURCE_BUTTON, ShareConstants.FEED_CAPTION_PARAM, "center", "col", "colgroup", "command", "dd", ErrorBundle.DETAIL_ENTRY, "dir", "div", "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", TextureMediaEncoder.FRAME_EVENT, "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", TariffPackageInfoConverterKt.HEADER_STRING_ID, "hgroup", "hr", "html", "iframe", "img", "input", "isindex", "li", "link", "listing", "marquee", "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", "p", "param", "plaintext", "pre", "script", "section", "select", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, ErrorBundle.SUMMARY_ENTRY, "table", "tbody", "td", "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp"};
    public a e;
    public a f;
    public boolean g;
    public Element h;
    public FormElement i;
    public Element j;
    public ArrayList<Element> k;
    public List<String> l;
    public Token.g m;
    public boolean n;
    public boolean o;
    public boolean p;
    public String[] q = {null};

    public boolean A(Element element) {
        return StringUtil.inSorted(element.normalName(), x);
    }

    public boolean B(Element element) {
        return z(this.stack, element);
    }

    public Element C() {
        return this.stack.remove(this.stack.size() - 1);
    }

    public Element D(String str) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = this.stack.get(size);
            this.stack.remove(size);
            if (element.normalName().equals(str)) {
                return element;
            }
        }
        return null;
    }

    public boolean E(Token token, a aVar) {
        this.currentToken = token;
        return aVar.c(token, this);
    }

    public void F(Element element) {
        int size = this.k.size() - 1;
        int i2 = 0;
        while (true) {
            if (size >= 0) {
                Element element2 = this.k.get(size);
                if (element2 == null) {
                    break;
                }
                if (element.normalName().equals(element2.normalName()) && element.attributes().equals(element2.attributes())) {
                    i2++;
                }
                if (i2 == 3) {
                    this.k.remove(size);
                    break;
                }
                size--;
            } else {
                break;
            }
        }
        this.k.add(element);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void G() {
        /*
            r8 = this;
            java.util.ArrayList<org.jsoup.nodes.Element> r0 = r8.k
            int r0 = r0.size()
            r1 = 0
            if (r0 <= 0) goto L_0x0018
            java.util.ArrayList<org.jsoup.nodes.Element> r0 = r8.k
            int r2 = r0.size()
            int r2 = r2 + -1
            java.lang.Object r0 = r0.get(r2)
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            goto L_0x0019
        L_0x0018:
            r0 = r1
        L_0x0019:
            if (r0 == 0) goto L_0x0088
            java.util.ArrayList<org.jsoup.nodes.Element> r2 = r8.stack
            boolean r2 = r8.z(r2, r0)
            if (r2 == 0) goto L_0x0025
            goto L_0x0088
        L_0x0025:
            java.util.ArrayList<org.jsoup.nodes.Element> r2 = r8.k
            int r2 = r2.size()
            r3 = 1
            int r2 = r2 - r3
            r4 = r2
        L_0x002e:
            if (r4 != 0) goto L_0x0033
            r5 = r4
            r4 = r8
            goto L_0x004c
        L_0x0033:
            java.util.ArrayList<org.jsoup.nodes.Element> r0 = r8.k
            int r4 = r4 + -1
            java.lang.Object r0 = r0.get(r4)
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
            if (r0 == 0) goto L_0x0047
            java.util.ArrayList<org.jsoup.nodes.Element> r5 = r8.stack
            boolean r5 = r8.z(r5, r0)
            if (r5 == 0) goto L_0x002e
        L_0x0047:
            r3 = r8
        L_0x0048:
            r5 = 0
            r5 = r4
            r4 = r3
            r3 = 0
        L_0x004c:
            if (r3 != 0) goto L_0x0058
            java.util.ArrayList<org.jsoup.nodes.Element> r0 = r4.k
            int r5 = r5 + 1
            java.lang.Object r0 = r0.get(r5)
            org.jsoup.nodes.Element r0 = (org.jsoup.nodes.Element) r0
        L_0x0058:
            org.jsoup.helper.Validate.notNull(r0)
            java.lang.String r3 = r0.normalName()
            org.jsoup.nodes.Element r6 = new org.jsoup.nodes.Element
            org.jsoup.parser.ParseSettings r7 = r4.settings
            org.jsoup.parser.Tag r3 = org.jsoup.parser.Tag.valueOf(r3, r7)
            r6.<init>(r3, r1)
            r4.y(r6)
            java.util.ArrayList<org.jsoup.nodes.Element> r3 = r4.stack
            r3.add(r6)
            org.jsoup.nodes.Attributes r3 = r6.attributes()
            org.jsoup.nodes.Attributes r7 = r0.attributes()
            r3.addAll(r7)
            java.util.ArrayList<org.jsoup.nodes.Element> r3 = r4.k
            r3.set(r5, r6)
            if (r5 != r2) goto L_0x0085
            goto L_0x0088
        L_0x0085:
            r3 = r4
            r4 = r5
            goto L_0x0048
        L_0x0088:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.parser.HtmlTreeBuilder.G():void");
    }

    public void H(Element element) {
        int size = this.k.size();
        do {
            size--;
            if (size < 0) {
                return;
            }
        } while (this.k.get(size) != element);
        this.k.remove(size);
    }

    public boolean I(Element element) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            if (this.stack.get(size) == element) {
                this.stack.remove(size);
                return true;
            }
        }
        return false;
    }

    public void J() {
        boolean z = false;
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            Element element = this.stack.get(size);
            if (size == 0) {
                element = this.j;
                z = true;
            }
            String normalName = element.normalName();
            if ("select".equals(normalName)) {
                this.e = a.InSelect;
                return;
            } else if ("td".equals(normalName) || ("th".equals(normalName) && !z)) {
                this.e = a.InCell;
                return;
            } else if ("tr".equals(normalName)) {
                this.e = a.InRow;
                return;
            } else if ("tbody".equals(normalName) || "thead".equals(normalName) || "tfoot".equals(normalName)) {
                this.e = a.InTableBody;
                return;
            } else if (ShareConstants.FEED_CAPTION_PARAM.equals(normalName)) {
                this.e = a.InCaption;
                return;
            } else if ("colgroup".equals(normalName)) {
                this.e = a.InColumnGroup;
                return;
            } else if ("table".equals(normalName)) {
                this.e = a.InTable;
                return;
            } else if ("head".equals(normalName)) {
                this.e = a.InBody;
                return;
            } else if (SDKConstants.PARAM_A2U_BODY.equals(normalName)) {
                this.e = a.InBody;
                return;
            } else if ("frameset".equals(normalName)) {
                this.e = a.InFrameset;
                return;
            } else if ("html".equals(normalName)) {
                this.e = a.BeforeHead;
                return;
            } else if (z) {
                this.e = a.InBody;
                return;
            }
        }
    }

    @Override // x6.b.b.d
    public ParseSettings a() {
        return ParseSettings.htmlDefault;
    }

    @Override // x6.b.b.d
    public List<Node> c(String str, Element element, String str2, Parser parser) {
        Element element2;
        this.e = a.Initial;
        initialiseParse(new StringReader(str), str2, parser);
        this.j = element;
        this.p = true;
        if (element != null) {
            if (element.ownerDocument() != null) {
                this.doc.quirksMode(element.ownerDocument().quirksMode());
            }
            String normalName = element.normalName();
            if (StringUtil.in(normalName, "title", "textarea")) {
                this.b.c = c.Rcdata;
            } else if (StringUtil.in(normalName, "iframe", "noembed", "noframes", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "xmp")) {
                this.b.c = c.Rawtext;
            } else if (normalName.equals("script")) {
                this.b.c = c.ScriptData;
            } else if (normalName.equals("noscript")) {
                this.b.c = c.Data;
            } else if (normalName.equals("plaintext")) {
                this.b.c = c.Data;
            } else {
                this.b.c = c.Data;
            }
            element2 = new Element(Tag.valueOf("html", this.settings), str2);
            this.doc.appendChild(element2);
            this.stack.add(element2);
            J();
            Elements parents = element.parents();
            parents.add(0, element);
            Iterator it = parents.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Element element3 = (Element) it.next();
                if (element3 instanceof FormElement) {
                    this.i = (FormElement) element3;
                    break;
                }
            }
        } else {
            element2 = null;
        }
        runParser();
        if (element != null) {
            return element2.childNodes();
        }
        return this.doc.childNodes();
    }

    public Element d(Element element) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            if (this.stack.get(size) == element) {
                return this.stack.get(size - 1);
            }
        }
        return null;
    }

    public void e() {
        Element element;
        while (!this.k.isEmpty()) {
            int size = this.k.size();
            if (size > 0) {
                element = this.k.remove(size - 1);
                continue;
            } else {
                element = null;
                continue;
            }
            if (element == null) {
                return;
            }
        }
    }

    public final void f(String... strArr) {
        int size = this.stack.size();
        while (true) {
            size--;
            if (size >= 0) {
                Element element = this.stack.get(size);
                if (!StringUtil.in(element.normalName(), strArr) && !element.normalName().equals("html")) {
                    this.stack.remove(size);
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public void g() {
        f("tbody", "tfoot", "thead", "template");
    }

    public void h() {
        f("table");
    }

    public void i(a aVar) {
        if (this.parser.getErrors().a()) {
            this.parser.getErrors().add(new ParseError(this.a.pos(), "Unexpected token [%s] when in state [%s]", this.currentToken.getClass().getSimpleName(), aVar));
        }
    }

    @Override // x6.b.b.d
    public void initialiseParse(Reader reader, String str, Parser parser) {
        super.initialiseParse(reader, str, parser);
        this.e = a.Initial;
        this.f = null;
        this.g = false;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = new ArrayList<>();
        this.l = new ArrayList();
        this.m = new Token.g();
        this.n = true;
        this.o = false;
        this.p = false;
    }

    public void j(String str) {
        while (str != null && !currentElement().normalName().equals(str) && StringUtil.inSorted(currentElement().normalName(), w)) {
            C();
        }
    }

    public Element k(String str) {
        for (int size = this.k.size() - 1; size >= 0; size--) {
            Element element = this.k.get(size);
            if (element == null) {
                return null;
            }
            if (element.normalName().equals(str)) {
                return element;
            }
        }
        return null;
    }

    public Element l(String str) {
        Element element;
        int size = this.stack.size();
        do {
            size--;
            if (size < 0) {
                return null;
            }
            element = this.stack.get(size);
        } while (!element.normalName().equals(str));
        return element;
    }

    public boolean m(String str) {
        String[] strArr = t;
        String[] strArr2 = r;
        String[] strArr3 = this.q;
        strArr3[0] = str;
        return p(strArr3, strArr2, strArr);
    }

    public boolean n(String str) {
        String[] strArr = r;
        String[] strArr2 = this.q;
        strArr2[0] = str;
        return p(strArr2, strArr, null);
    }

    public boolean o(String str) {
        for (int size = this.stack.size() - 1; size >= 0; size--) {
            String normalName = this.stack.get(size).normalName();
            if (normalName.equals(str)) {
                return true;
            }
            if (!StringUtil.inSorted(normalName, v)) {
                return false;
            }
        }
        Validate.fail("Should not be reachable");
        return false;
    }

    public final boolean p(String[] strArr, String[] strArr2, String[] strArr3) {
        int size = this.stack.size() - 1;
        int i2 = size > 100 ? size - 100 : 0;
        while (size >= i2) {
            String normalName = this.stack.get(size).normalName();
            if (StringUtil.inSorted(normalName, strArr)) {
                return true;
            }
            if (StringUtil.inSorted(normalName, strArr2)) {
                return false;
            }
            if (strArr3 != null && StringUtil.inSorted(normalName, strArr3)) {
                return false;
            }
            size--;
        }
        return false;
    }

    @Override // x6.b.b.d
    public boolean process(Token token) {
        this.currentToken = token;
        return this.e.c(token, this);
    }

    @Override // x6.b.b.d
    public /* bridge */ /* synthetic */ boolean processStartTag(String str, Attributes attributes) {
        return super.processStartTag(str, attributes);
    }

    public boolean q(String str) {
        String[] strArr = u;
        String[] strArr2 = this.q;
        strArr2[0] = str;
        return p(strArr2, strArr, null);
    }

    public Element r(Token.h hVar) {
        Attributes attributes = hVar.j;
        if (attributes != null && !attributes.isEmpty() && hVar.j.deduplicate(this.settings) > 0) {
            error("Duplicate attribute");
        }
        if (hVar.i) {
            Element u2 = u(hVar);
            this.stack.add(u2);
            b bVar = this.b;
            bVar.c = c.Data;
            Token.g gVar = this.m;
            gVar.g();
            gVar.q(u2.tagName());
            bVar.g(gVar);
            return u2;
        }
        Tag valueOf = Tag.valueOf(hVar.p(), this.settings);
        ParseSettings parseSettings = this.settings;
        Attributes attributes2 = hVar.j;
        parseSettings.a(attributes2);
        Element element = new Element(valueOf, null, attributes2);
        y(element);
        this.stack.add(element);
        return element;
    }

    public void s(Token.c cVar) {
        Node node;
        Element currentElement = currentElement();
        if (currentElement == null) {
            currentElement = this.doc;
        }
        String normalName = currentElement.normalName();
        String str = cVar.b;
        if (cVar instanceof Token.b) {
            node = new CDataNode(str);
        } else if (normalName.equals("script") || normalName.equals(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)) {
            node = new DataNode(str);
        } else {
            node = new TextNode(str);
        }
        currentElement.appendChild(node);
    }

    public void t(Token.d dVar) {
        y(new Comment(dVar.k()));
    }

    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("TreeBuilder{currentToken=");
        L.append(this.currentToken);
        L.append(", state=");
        L.append(this.e);
        L.append(", currentElement=");
        L.append(currentElement());
        L.append('}');
        return L.toString();
    }

    public Element u(Token.h hVar) {
        Tag valueOf = Tag.valueOf(hVar.p(), this.settings);
        ParseSettings parseSettings = this.settings;
        Attributes attributes = hVar.j;
        parseSettings.a(attributes);
        Element element = new Element(valueOf, null, attributes);
        y(element);
        if (hVar.i) {
            if (!valueOf.isKnownTag()) {
                valueOf.f = true;
            } else if (!valueOf.isEmpty()) {
                this.b.j("Tag cannot be self closing; not a void tag");
            }
        }
        return element;
    }

    public FormElement v(Token.h hVar, boolean z) {
        Tag valueOf = Tag.valueOf(hVar.p(), this.settings);
        ParseSettings parseSettings = this.settings;
        Attributes attributes = hVar.j;
        parseSettings.a(attributes);
        FormElement formElement = new FormElement(valueOf, null, attributes);
        this.i = formElement;
        y(formElement);
        if (z) {
            this.stack.add(formElement);
        }
        return formElement;
    }

    public void w(Node node) {
        Element element;
        Element l2 = l("table");
        boolean z = false;
        if (l2 == null) {
            element = this.stack.get(0);
        } else if (l2.parent() != null) {
            element = l2.parent();
            z = true;
        } else {
            element = d(l2);
        }
        if (z) {
            Validate.notNull(l2);
            l2.before(node);
            return;
        }
        element.appendChild(node);
    }

    public void x() {
        this.k.add(null);
    }

    public final void y(Node node) {
        FormElement formElement;
        if (this.stack.isEmpty()) {
            this.doc.appendChild(node);
        } else if (this.o) {
            w(node);
        } else {
            currentElement().appendChild(node);
        }
        if (node instanceof Element) {
            Element element = (Element) node;
            if (element.tag().isFormListed() && (formElement = this.i) != null) {
                formElement.addElement(element);
            }
        }
    }

    public final boolean z(ArrayList<Element> arrayList, Element element) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (arrayList.get(size) == element) {
                return true;
            }
        }
        return false;
    }
}
