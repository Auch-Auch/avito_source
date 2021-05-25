package a2.e.a;

import a2.e.a.b;
import android.graphics.Matrix;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.avito.android.remote.model.ProfileTab;
import com.caverock.androidsvg.PreserveAspectRatio;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import com.facebook.share.internal.ShareConstants;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import kotlinx.coroutines.DebugKt;
import org.spongycastle.asn1.cmc.BodyPartID;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.DefaultHandler2;
import org.xmlpull.v1.XmlPullParser;
public class f {
    public SVG a = null;
    public SVG.h0 b = null;
    public boolean c = false;
    public int d;
    public boolean e = false;
    public h f = null;
    public StringBuilder g = null;
    public boolean h = false;
    public StringBuilder i = null;

    public static class b {
        public static final Map<String, PreserveAspectRatio.Alignment> a;

        static {
            HashMap hashMap = new HashMap(10);
            a = hashMap;
            hashMap.put("none", PreserveAspectRatio.Alignment.none);
            hashMap.put("xMinYMin", PreserveAspectRatio.Alignment.xMinYMin);
            hashMap.put("xMidYMin", PreserveAspectRatio.Alignment.xMidYMin);
            hashMap.put("xMaxYMin", PreserveAspectRatio.Alignment.xMaxYMin);
            hashMap.put("xMinYMid", PreserveAspectRatio.Alignment.xMinYMid);
            hashMap.put("xMidYMid", PreserveAspectRatio.Alignment.xMidYMid);
            hashMap.put("xMaxYMid", PreserveAspectRatio.Alignment.xMaxYMid);
            hashMap.put("xMinYMax", PreserveAspectRatio.Alignment.xMinYMax);
            hashMap.put("xMidYMax", PreserveAspectRatio.Alignment.xMidYMax);
            hashMap.put("xMaxYMax", PreserveAspectRatio.Alignment.xMaxYMax);
        }
    }

    public static class c {
        public static final Map<String, Integer> a;

        static {
            HashMap hashMap = new HashMap(47);
            a = hashMap;
            hashMap.put("aliceblue", -984833);
            hashMap.put("antiquewhite", -332841);
            hashMap.put("aqua", -16711681);
            a2.b.a.a.a.D0(-8388652, hashMap, "aquamarine", -983041, "azure", -657956, "beige", -6972, "bisque");
            a2.b.a.a.a.D0(ViewCompat.MEASURED_STATE_MASK, hashMap, "black", -5171, "blanchedalmond", -16776961, "blue", -7722014, "blueviolet");
            a2.b.a.a.a.D0(-5952982, hashMap, "brown", -2180985, "burlywood", -10510688, "cadetblue", -8388864, "chartreuse");
            a2.b.a.a.a.D0(-2987746, hashMap, "chocolate", -32944, "coral", -10185235, "cornflowerblue", -1828, "cornsilk");
            hashMap.put("crimson", -2354116);
            hashMap.put("cyan", -16711681);
            hashMap.put("darkblue", -16777077);
            hashMap.put("darkcyan", -16741493);
            hashMap.put("darkgoldenrod", -4684277);
            hashMap.put("darkgray", -5658199);
            hashMap.put("darkgreen", -16751616);
            hashMap.put("darkgrey", -5658199);
            hashMap.put("darkkhaki", -4343957);
            a2.b.a.a.a.D0(-7667573, hashMap, "darkmagenta", -11179217, "darkolivegreen", -29696, "darkorange", -6737204, "darkorchid");
            a2.b.a.a.a.D0(-7667712, hashMap, "darkred", -1468806, "darksalmon", -7357297, "darkseagreen", -12042869, "darkslateblue");
            hashMap.put("darkslategray", -13676721);
            hashMap.put("darkslategrey", -13676721);
            hashMap.put("darkturquoise", -16724271);
            hashMap.put("darkviolet", -7077677);
            hashMap.put("deeppink", -60269);
            hashMap.put("deepskyblue", -16728065);
            hashMap.put("dimgray", -9868951);
            hashMap.put("dimgrey", -9868951);
            a2.b.a.a.a.D0(-14774017, hashMap, "dodgerblue", -5103070, "firebrick", -1296, "floralwhite", -14513374, "forestgreen");
            hashMap.put("fuchsia", -65281);
            hashMap.put("gainsboro", -2302756);
            hashMap.put("ghostwhite", -460545);
            hashMap.put("gold", -10496);
            hashMap.put("goldenrod", -2448096);
            hashMap.put("gray", -8355712);
            hashMap.put("green", -16744448);
            hashMap.put("greenyellow", -5374161);
            hashMap.put("grey", -8355712);
            a2.b.a.a.a.D0(-983056, hashMap, "honeydew", -38476, "hotpink", -3318692, "indianred", -11861886, "indigo");
            a2.b.a.a.a.D0(-16, hashMap, "ivory", -989556, "khaki", -1644806, "lavender", -3851, "lavenderblush");
            a2.b.a.a.a.D0(-8586240, hashMap, "lawngreen", -1331, "lemonchiffon", -5383962, "lightblue", -1015680, "lightcoral");
            hashMap.put("lightcyan", -2031617);
            hashMap.put("lightgoldenrodyellow", -329006);
            hashMap.put("lightgray", -2894893);
            hashMap.put("lightgreen", -7278960);
            hashMap.put("lightgrey", -2894893);
            hashMap.put("lightpink", -18751);
            hashMap.put("lightsalmon", -24454);
            hashMap.put("lightseagreen", -14634326);
            hashMap.put("lightskyblue", -7876870);
            hashMap.put("lightslategray", -8943463);
            hashMap.put("lightslategrey", -8943463);
            hashMap.put("lightsteelblue", -5192482);
            hashMap.put("lightyellow", -32);
            hashMap.put("lime", -16711936);
            hashMap.put("limegreen", -13447886);
            hashMap.put("linen", -331546);
            hashMap.put("magenta", -65281);
            hashMap.put("maroon", -8388608);
            hashMap.put("mediumaquamarine", -10039894);
            a2.b.a.a.a.D0(-16777011, hashMap, "mediumblue", -4565549, "mediumorchid", -7114533, "mediumpurple", -12799119, "mediumseagreen");
            a2.b.a.a.a.D0(-8689426, hashMap, "mediumslateblue", -16713062, "mediumspringgreen", -12004916, "mediumturquoise", -3730043, "mediumvioletred");
            a2.b.a.a.a.D0(-15132304, hashMap, "midnightblue", -655366, "mintcream", -6943, "mistyrose", -6987, "moccasin");
            a2.b.a.a.a.D0(-8531, hashMap, "navajowhite", -16777088, "navy", -133658, "oldlace", -8355840, "olive");
            a2.b.a.a.a.D0(-9728477, hashMap, "olivedrab", -23296, "orange", -47872, "orangered", -2461482, "orchid");
            a2.b.a.a.a.D0(-1120086, hashMap, "palegoldenrod", -6751336, "palegreen", -5247250, "paleturquoise", -2396013, "palevioletred");
            a2.b.a.a.a.D0(-4139, hashMap, "papayawhip", -9543, "peachpuff", -3308225, "peru", -16181, "pink");
            a2.b.a.a.a.D0(-2252579, hashMap, "plum", -5185306, "powderblue", -8388480, "purple", -10079335, "rebeccapurple");
            a2.b.a.a.a.D0(SupportMenu.CATEGORY_MASK, hashMap, "red", -4419697, "rosybrown", -12490271, "royalblue", -7650029, "saddlebrown");
            a2.b.a.a.a.D0(-360334, hashMap, "salmon", -744352, "sandybrown", -13726889, "seagreen", -2578, "seashell");
            a2.b.a.a.a.D0(-6270419, hashMap, "sienna", -4144960, "silver", -7876885, "skyblue", -9807155, "slateblue");
            hashMap.put("slategray", -9404272);
            hashMap.put("slategrey", -9404272);
            hashMap.put("snow", -1286);
            hashMap.put("springgreen", -16711809);
            a2.b.a.a.a.D0(-12156236, hashMap, "steelblue", -2968436, "tan", -16744320, "teal", -2572328, "thistle");
            a2.b.a.a.a.D0(-40121, hashMap, "tomato", -12525360, "turquoise", -1146130, "violet", -663885, "wheat");
            a2.b.a.a.a.D0(-1, hashMap, "white", -657931, "whitesmoke", InputDeviceCompat.SOURCE_ANY, "yellow", -6632142, "yellowgreen");
            hashMap.put("transparent", 0);
        }
    }

    public static class d {
        public static final Map<String, SVG.o> a;

        static {
            HashMap hashMap = new HashMap(9);
            a = hashMap;
            SVG.b1 b1Var = SVG.b1.pt;
            hashMap.put("xx-small", new SVG.o(0.694f, b1Var));
            hashMap.put("x-small", new SVG.o(0.833f, b1Var));
            hashMap.put("small", new SVG.o(10.0f, b1Var));
            hashMap.put("medium", new SVG.o(12.0f, b1Var));
            hashMap.put("large", new SVG.o(14.4f, b1Var));
            hashMap.put("x-large", new SVG.o(17.3f, b1Var));
            hashMap.put("xx-large", new SVG.o(20.7f, b1Var));
            SVG.b1 b1Var2 = SVG.b1.percent;
            hashMap.put("smaller", new SVG.o(83.33f, b1Var2));
            hashMap.put("larger", new SVG.o(120.0f, b1Var2));
        }
    }

    public static class e {
        public static final Map<String, Integer> a;

        static {
            HashMap hashMap = new HashMap(13);
            a = hashMap;
            hashMap.put("normal", 400);
            hashMap.put("bold", 700);
            a2.b.a.a.a.D0(1, hashMap, "bolder", -1, "lighter", 100, "100", 200, "200");
            hashMap.put("300", 300);
            hashMap.put("400", 400);
            hashMap.put("500", 500);
            hashMap.put("600", 600);
            hashMap.put("700", 700);
            hashMap.put("800", 800);
            hashMap.put("900", 900);
        }
    }

    /* renamed from: a2.e.a.f$f  reason: collision with other inner class name */
    public class C0022f extends DefaultHandler2 {
        public C0022f(a aVar) {
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) throws SAXException {
            f.this.N(new String(cArr, i, i2));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() throws SAXException {
            Objects.requireNonNull(f.this);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            f.this.c(str, str2, str3);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) throws SAXException {
            f.this.d(str, f.this.E(new i(str2)));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
            f fVar = f.this;
            Objects.requireNonNull(fVar);
            fVar.a = new SVG();
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            f.this.L(str, str2, str3, attributes);
        }
    }

    public enum g {
        CLASS,
        clip,
        clip_path,
        clipPathUnits,
        clip_rule,
        color,
        cx,
        cy,
        direction,
        dx,
        dy,
        fx,
        fy,
        d,
        display,
        fill,
        fill_rule,
        fill_opacity,
        font,
        font_family,
        font_size,
        font_weight,
        font_style,
        gradientTransform,
        gradientUnits,
        height,
        href,
        image_rendering,
        marker,
        marker_start,
        marker_mid,
        marker_end,
        markerHeight,
        markerUnits,
        markerWidth,
        mask,
        maskContentUnits,
        maskUnits,
        media,
        offset,
        opacity,
        orient,
        overflow,
        pathLength,
        patternContentUnits,
        patternTransform,
        patternUnits,
        points,
        preserveAspectRatio,
        r,
        refX,
        refY,
        requiredFeatures,
        requiredExtensions,
        requiredFormats,
        requiredFonts,
        rx,
        ry,
        solid_color,
        solid_opacity,
        spreadMethod,
        startOffset,
        stop_color,
        stop_opacity,
        stroke,
        stroke_dasharray,
        stroke_dashoffset,
        stroke_linecap,
        stroke_linejoin,
        stroke_miterlimit,
        stroke_opacity,
        stroke_width,
        style,
        systemLanguage,
        text_anchor,
        text_decoration,
        transform,
        type,
        vector_effect,
        version,
        viewBox,
        width,
        x,
        y,
        x1,
        y1,
        x2,
        y2,
        viewport_fill,
        viewport_fill_opacity,
        visibility,
        UNSUPPORTED;
        
        public static final Map<String, g> O0 = new HashMap();

        /* access modifiers changed from: public */
        static {
            g[] values = values();
            for (int i = 0; i < 92; i++) {
                g gVar = values[i];
                if (gVar == CLASS) {
                    O0.put("class", gVar);
                } else if (gVar != UNSUPPORTED) {
                    O0.put(gVar.name().replace('_', '-'), gVar);
                }
            }
        }

        public static g a(String str) {
            g gVar = O0.get(str);
            if (gVar != null) {
                return gVar;
            }
            return UNSUPPORTED;
        }
    }

    public enum h {
        svg,
        a,
        circle,
        clipPath,
        defs,
        desc,
        ellipse,
        g,
        image,
        line,
        linearGradient,
        marker,
        mask,
        path,
        pattern,
        polygon,
        polyline,
        radialGradient,
        rect,
        solidColor,
        stop,
        style,
        SWITCH,
        symbol,
        text,
        textPath,
        title,
        tref,
        tspan,
        use,
        view,
        UNSUPPORTED;
        
        public static final Map<String, h> G = new HashMap();

        /* access modifiers changed from: public */
        static {
            h[] values = values();
            for (int i = 0; i < 32; i++) {
                h hVar = values[i];
                if (hVar == SWITCH) {
                    G.put("switch", hVar);
                } else if (hVar != UNSUPPORTED) {
                    G.put(hVar.name(), hVar);
                }
            }
        }
    }

    public static class i {
        public String a;
        public int b = 0;
        public int c = 0;
        public d d = new d();

        public i(String str) {
            String trim = str.trim();
            this.a = trim;
            this.c = trim.length();
        }

        public int a() {
            int i = this.b;
            int i2 = this.c;
            if (i == i2) {
                return -1;
            }
            int i3 = i + 1;
            this.b = i3;
            if (i3 < i2) {
                return this.a.charAt(i3);
            }
            return -1;
        }

        public Boolean b(Object obj) {
            if (obj == null) {
                return null;
            }
            q();
            int i = this.b;
            if (i == this.c) {
                return null;
            }
            char charAt = this.a.charAt(i);
            if (charAt != '0' && charAt != '1') {
                return null;
            }
            boolean z = true;
            this.b++;
            if (charAt != '1') {
                z = false;
            }
            return Boolean.valueOf(z);
        }

        public float c(float f) {
            if (Float.isNaN(f)) {
                return Float.NaN;
            }
            q();
            return i();
        }

        public boolean d(char c2) {
            int i = this.b;
            boolean z = i < this.c && this.a.charAt(i) == c2;
            if (z) {
                this.b++;
            }
            return z;
        }

        public boolean e(String str) {
            int length = str.length();
            int i = this.b;
            boolean z = i <= this.c - length && this.a.substring(i, i + length).equals(str);
            if (z) {
                this.b += length;
            }
            return z;
        }

        public boolean f() {
            return this.b == this.c;
        }

        public boolean g(int i) {
            return i == 32 || i == 10 || i == 13 || i == 9;
        }

        public Integer h() {
            int i = this.b;
            if (i == this.c) {
                return null;
            }
            String str = this.a;
            this.b = i + 1;
            return Integer.valueOf(str.charAt(i));
        }

        public float i() {
            float a3 = this.d.a(this.a, this.b, this.c);
            if (!Float.isNaN(a3)) {
                this.b = this.d.a;
            }
            return a3;
        }

        public SVG.o j() {
            float i = i();
            if (Float.isNaN(i)) {
                return null;
            }
            SVG.b1 o = o();
            if (o == null) {
                return new SVG.o(i, SVG.b1.px);
            }
            return new SVG.o(i, o);
        }

        public String k() {
            if (f()) {
                return null;
            }
            int i = this.b;
            char charAt = this.a.charAt(i);
            if (charAt != '\'' && charAt != '\"') {
                return null;
            }
            int a3 = a();
            while (a3 != -1 && a3 != charAt) {
                a3 = a();
            }
            if (a3 == -1) {
                this.b = i;
                return null;
            }
            int i2 = this.b + 1;
            this.b = i2;
            return this.a.substring(i + 1, i2 - 1);
        }

        public String l() {
            return n(' ', false);
        }

        public String m(char c2) {
            return n(c2, false);
        }

        public String n(char c2, boolean z) {
            if (f()) {
                return null;
            }
            char charAt = this.a.charAt(this.b);
            if ((!z && g(charAt)) || charAt == c2) {
                return null;
            }
            int i = this.b;
            int a3 = a();
            while (a3 != -1 && a3 != c2 && (z || !g(a3))) {
                a3 = a();
            }
            return this.a.substring(i, this.b);
        }

        public SVG.b1 o() {
            if (f()) {
                return null;
            }
            if (this.a.charAt(this.b) == '%') {
                this.b++;
                return SVG.b1.percent;
            }
            int i = this.b;
            if (i > this.c - 2) {
                return null;
            }
            try {
                SVG.b1 valueOf = SVG.b1.valueOf(this.a.substring(i, i + 2).toLowerCase(Locale.US));
                this.b += 2;
                return valueOf;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public float p() {
            q();
            float a3 = this.d.a(this.a, this.b, this.c);
            if (!Float.isNaN(a3)) {
                this.b = this.d.a;
            }
            return a3;
        }

        public boolean q() {
            r();
            int i = this.b;
            if (i == this.c || this.a.charAt(i) != ',') {
                return false;
            }
            this.b++;
            r();
            return true;
        }

        public void r() {
            while (true) {
                int i = this.b;
                if (i < this.c && g(this.a.charAt(i))) {
                    this.b++;
                } else {
                    return;
                }
            }
        }
    }

    public class j implements Attributes {
        public XmlPullParser a;

        public j(f fVar, XmlPullParser xmlPullParser) {
            this.a = xmlPullParser;
        }

        @Override // org.xml.sax.Attributes
        public int getIndex(String str) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public int getIndex(String str, String str2) {
            return -1;
        }

        @Override // org.xml.sax.Attributes
        public int getLength() {
            return this.a.getAttributeCount();
        }

        @Override // org.xml.sax.Attributes
        public String getLocalName(int i) {
            return this.a.getAttributeName(i);
        }

        @Override // org.xml.sax.Attributes
        public String getQName(int i) {
            String attributeName = this.a.getAttributeName(i);
            if (this.a.getAttributePrefix(i) == null) {
                return attributeName;
            }
            return this.a.getAttributePrefix(i) + ':' + attributeName;
        }

        @Override // org.xml.sax.Attributes
        public String getType(int i) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String str) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getType(String str, String str2) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getURI(int i) {
            return this.a.getAttributeNamespace(i);
        }

        @Override // org.xml.sax.Attributes
        public String getValue(int i) {
            return this.a.getAttributeValue(i);
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String str) {
            return null;
        }

        @Override // org.xml.sax.Attributes
        public String getValue(String str, String str2) {
            return null;
        }
    }

    public static SVG.o A(i iVar) {
        if (iVar.e(DebugKt.DEBUG_PROPERTY_VALUE_AUTO)) {
            return new SVG.o(0.0f);
        }
        return iVar.j();
    }

    public static Float B(String str) {
        try {
            float t = t(str);
            if (t < 0.0f) {
                t = 0.0f;
            } else if (t > 1.0f) {
                t = 1.0f;
            }
            return Float.valueOf(t);
        } catch (SVGParseException unused) {
            return null;
        }
    }

    public static SVG.m0 C(String str) {
        if (!str.startsWith("url(")) {
            return r(str);
        }
        int indexOf = str.indexOf(")");
        SVG.m0 m0Var = null;
        if (indexOf == -1) {
            return new SVG.t(str.substring(4).trim(), null);
        }
        String trim = str.substring(4, indexOf).trim();
        String trim2 = str.substring(indexOf + 1).trim();
        if (trim2.length() > 0) {
            m0Var = r(trim2);
        }
        return new SVG.t(trim, m0Var);
    }

    public static PreserveAspectRatio D(String str) throws SVGParseException {
        i iVar = new i(str);
        iVar.r();
        String l = iVar.l();
        if ("defer".equals(l)) {
            iVar.r();
            l = iVar.l();
        }
        PreserveAspectRatio.Alignment alignment = b.a.get(l);
        PreserveAspectRatio.Scale scale = null;
        iVar.r();
        if (!iVar.f()) {
            String l2 = iVar.l();
            l2.hashCode();
            if (l2.equals("meet")) {
                scale = PreserveAspectRatio.Scale.meet;
            } else if (!l2.equals("slice")) {
                throw new SVGParseException(a2.b.a.a.a.c3("Invalid preserveAspectRatio definition: ", str));
            } else {
                scale = PreserveAspectRatio.Scale.slice;
            }
        }
        return new PreserveAspectRatio(alignment, scale);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0259, code lost:
        if (r14.equals("optimizeQuality") == false) goto L_0x025b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x046c, code lost:
        if (r14.equals("line-through") == false) goto L_0x046e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:262:0x04c6, code lost:
        if (r14.equals("middle") == false) goto L_0x04c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x056a, code lost:
        if (r14.equals(com.avito.android.search.map.view.PanelStateKt.PANEL_HIDDEN) == false) goto L_0x056c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0269  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x026f  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x04cb  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x04d6  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x04dc  */
    /* JADX WARNING: Removed duplicated region for block: B:378:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:404:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void J(com.caverock.androidsvg.SVG.Style r12, java.lang.String r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 1730
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.e.a.f.J(com.caverock.androidsvg.SVG$Style, java.lang.String, java.lang.String):void");
    }

    public static int b(float f2) {
        if (f2 < 0.0f) {
            return 0;
        }
        if (f2 > 255.0f) {
            return 255;
        }
        return Math.round(f2);
    }

    public static int e(float f2, float f3, float f4) {
        float f5 = 0.0f;
        int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        float f6 = f2 % 360.0f;
        if (i2 < 0) {
            f6 += 360.0f;
        }
        float f7 = f6 / 60.0f;
        float f8 = f3 / 100.0f;
        float f9 = f4 / 100.0f;
        if (f8 < 0.0f) {
            f8 = 0.0f;
        } else if (f8 > 1.0f) {
            f8 = 1.0f;
        }
        if (f9 >= 0.0f) {
            f5 = f9 > 1.0f ? 1.0f : f9;
        }
        float f10 = f5 <= 0.5f ? (f8 + 1.0f) * f5 : (f5 + f8) - (f8 * f5);
        float f11 = (f5 * 2.0f) - f10;
        return b(f(f11, f10, f7 - 2.0f) * 256.0f) | (b(f(f11, f10, f7 + 2.0f) * 256.0f) << 16) | (b(f(f11, f10, f7) * 256.0f) << 8);
    }

    public static float f(float f2, float f3, float f4) {
        if (f4 < 0.0f) {
            f4 += 6.0f;
        }
        if (f4 >= 6.0f) {
            f4 -= 6.0f;
        }
        return f4 < 1.0f ? a2.b.a.a.a.b(f3, f2, f4, f2) : f4 < 3.0f ? f3 : f4 < 4.0f ? a2.b.a.a.a.b(4.0f, f4, f3 - f2, f2) : f2;
    }

    public static SVG.e q(String str) throws SVGParseException {
        int i2;
        long j2;
        int i3 = 4;
        if (str.charAt(0) == '#') {
            int length = str.length();
            c cVar = null;
            if (1 < length) {
                long j3 = 0;
                int i4 = 1;
                while (true) {
                    if (i4 >= length) {
                        break;
                    }
                    char charAt = str.charAt(i4);
                    if (charAt < '0' || charAt > '9') {
                        if (charAt < 'A' || charAt > 'F') {
                            if (charAt < 'a' || charAt > 'f') {
                                break;
                            }
                            j2 = j3 * 16;
                            i2 = charAt - 'a';
                        } else {
                            j2 = j3 * 16;
                            i2 = charAt - 'A';
                        }
                        j3 = j2 + ((long) i2) + 10;
                    } else {
                        j3 = (j3 * 16) + ((long) (charAt - '0'));
                    }
                    if (j3 > BodyPartID.bodyIdMax) {
                        break;
                    }
                    i4++;
                }
                if (i4 != 1) {
                    cVar = new c(j3, i4);
                }
            }
            if (cVar != null) {
                int i5 = cVar.a;
                if (i5 == 4) {
                    int i6 = (int) cVar.b;
                    int i7 = i6 & 3840;
                    int i8 = i6 & 240;
                    int i9 = i6 & 15;
                    return new SVG.e(i9 | (i7 << 8) | -16777216 | (i7 << 12) | (i8 << 8) | (i8 << 4) | (i9 << 4));
                } else if (i5 == 5) {
                    int i10 = (int) cVar.b;
                    int i11 = 61440 & i10;
                    int i12 = i10 & 3840;
                    int i13 = i10 & 240;
                    int i14 = i10 & 15;
                    return new SVG.e((i14 << 24) | (i14 << 28) | (i11 << 8) | (i11 << 4) | (i12 << 4) | i12 | i13 | (i13 >> 4));
                } else if (i5 == 7) {
                    return new SVG.e(((int) cVar.b) | ViewCompat.MEASURED_STATE_MASK);
                } else {
                    if (i5 == 9) {
                        int i15 = (int) cVar.b;
                        return new SVG.e((i15 << 24) | (i15 >>> 8));
                    }
                    throw new SVGParseException(a2.b.a.a.a.c3("Bad hex colour value: ", str));
                }
            } else {
                throw new SVGParseException(a2.b.a.a.a.c3("Bad hex colour value: ", str));
            }
        } else {
            String lowerCase = str.toLowerCase(Locale.US);
            boolean startsWith = lowerCase.startsWith("rgba(");
            if (startsWith || lowerCase.startsWith("rgb(")) {
                if (startsWith) {
                    i3 = 5;
                }
                i iVar = new i(str.substring(i3));
                iVar.r();
                float i16 = iVar.i();
                if (!Float.isNaN(i16) && iVar.d('%')) {
                    i16 = (i16 * 256.0f) / 100.0f;
                }
                float c2 = iVar.c(i16);
                if (!Float.isNaN(c2) && iVar.d('%')) {
                    c2 = (c2 * 256.0f) / 100.0f;
                }
                float c3 = iVar.c(c2);
                if (!Float.isNaN(c3) && iVar.d('%')) {
                    c3 = (c3 * 256.0f) / 100.0f;
                }
                if (startsWith) {
                    float c4 = iVar.c(c3);
                    iVar.r();
                    if (!Float.isNaN(c4) && iVar.d(')')) {
                        return new SVG.e((b(c4 * 256.0f) << 24) | (b(i16) << 16) | (b(c2) << 8) | b(c3));
                    }
                    throw new SVGParseException(a2.b.a.a.a.c3("Bad rgba() colour value: ", str));
                }
                iVar.r();
                if (!Float.isNaN(c3) && iVar.d(')')) {
                    return new SVG.e((b(i16) << 16) | ViewCompat.MEASURED_STATE_MASK | (b(c2) << 8) | b(c3));
                }
                throw new SVGParseException(a2.b.a.a.a.c3("Bad rgb() colour value: ", str));
            }
            boolean startsWith2 = lowerCase.startsWith("hsla(");
            if (startsWith2 || lowerCase.startsWith("hsl(")) {
                if (startsWith2) {
                    i3 = 5;
                }
                i iVar2 = new i(str.substring(i3));
                iVar2.r();
                float i17 = iVar2.i();
                float c5 = iVar2.c(i17);
                if (!Float.isNaN(c5)) {
                    iVar2.d('%');
                }
                float c6 = iVar2.c(c5);
                if (!Float.isNaN(c6)) {
                    iVar2.d('%');
                }
                if (startsWith2) {
                    float c7 = iVar2.c(c6);
                    iVar2.r();
                    if (!Float.isNaN(c7) && iVar2.d(')')) {
                        return new SVG.e((b(c7 * 256.0f) << 24) | e(i17, c5, c6));
                    }
                    throw new SVGParseException(a2.b.a.a.a.c3("Bad hsla() colour value: ", str));
                }
                iVar2.r();
                if (!Float.isNaN(c6) && iVar2.d(')')) {
                    return new SVG.e(e(i17, c5, c6) | ViewCompat.MEASURED_STATE_MASK);
                }
                throw new SVGParseException(a2.b.a.a.a.c3("Bad hsl() colour value: ", str));
            }
            Integer num = c.a.get(lowerCase);
            if (num != null) {
                return new SVG.e(num.intValue());
            }
            throw new SVGParseException(a2.b.a.a.a.c3("Invalid colour keyword: ", lowerCase));
        }
    }

    public static SVG.m0 r(String str) {
        if (str.equals("none")) {
            return SVG.e.c;
        }
        if (str.equals("currentColor")) {
            return SVG.f.a;
        }
        try {
            return q(str);
        } catch (SVGParseException unused) {
            return null;
        }
    }

    public static SVG.Style.FillRule s(String str) {
        if ("nonzero".equals(str)) {
            return SVG.Style.FillRule.NonZero;
        }
        if ("evenodd".equals(str)) {
            return SVG.Style.FillRule.EvenOdd;
        }
        return null;
    }

    public static float t(String str) throws SVGParseException {
        int length = str.length();
        if (length != 0) {
            return u(str, 0, length);
        }
        throw new SVGParseException("Invalid float value (empty string)");
    }

    public static float u(String str, int i2, int i3) throws SVGParseException {
        float a3 = new d().a(str, i2, i3);
        if (!Float.isNaN(a3)) {
            return a3;
        }
        throw new SVGParseException(a2.b.a.a.a.c3("Invalid float value: ", str));
    }

    public static List<String> v(String str) {
        i iVar = new i(str);
        ArrayList arrayList = null;
        do {
            String k = iVar.k();
            if (k == null) {
                k = iVar.n(',', true);
            }
            if (k == null) {
                break;
            }
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(k);
            iVar.q();
        } while (!iVar.f());
        return arrayList;
    }

    public static SVG.Style.FontStyle w(String str) {
        char c2 = 65535;
        switch (str.hashCode()) {
            case -1657669071:
                if (str.equals("oblique")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1178781136:
                if (str.equals("italic")) {
                    c2 = 1;
                    break;
                }
                break;
            case -1039745817:
                if (str.equals("normal")) {
                    c2 = 2;
                    break;
                }
                break;
        }
        switch (c2) {
            case 0:
                return SVG.Style.FontStyle.Oblique;
            case 1:
                return SVG.Style.FontStyle.Italic;
            case 2:
                return SVG.Style.FontStyle.Normal;
            default:
                return null;
        }
    }

    public static String x(String str) {
        if (str.equals("none") || !str.startsWith("url(")) {
            return null;
        }
        if (str.endsWith(")")) {
            return str.substring(4, str.length() - 1).trim();
        }
        return str.substring(4).trim();
    }

    public static SVG.o y(String str) throws SVGParseException {
        if (str.length() != 0) {
            int length = str.length();
            SVG.b1 b1Var = SVG.b1.px;
            char charAt = str.charAt(length - 1);
            if (charAt == '%') {
                length--;
                b1Var = SVG.b1.percent;
            } else if (length > 2 && Character.isLetter(charAt) && Character.isLetter(str.charAt(length - 2))) {
                length -= 2;
                try {
                    b1Var = SVG.b1.valueOf(str.substring(length).toLowerCase(Locale.US));
                } catch (IllegalArgumentException unused) {
                    throw new SVGParseException(a2.b.a.a.a.c3("Invalid length unit specifier: ", str));
                }
            }
            try {
                return new SVG.o(u(str, 0, length), b1Var);
            } catch (NumberFormatException e2) {
                throw new SVGParseException(a2.b.a.a.a.c3("Invalid length value: ", str), e2);
            }
        } else {
            throw new SVGParseException("Invalid length value (empty string)");
        }
    }

    public static List<SVG.o> z(String str) throws SVGParseException {
        if (str.length() != 0) {
            ArrayList arrayList = new ArrayList(1);
            i iVar = new i(str);
            iVar.r();
            while (!iVar.f()) {
                float i2 = iVar.i();
                if (Float.isNaN(i2)) {
                    StringBuilder L = a2.b.a.a.a.L("Invalid length list value: ");
                    int i3 = iVar.b;
                    while (!iVar.f() && !iVar.g(iVar.a.charAt(iVar.b))) {
                        iVar.b++;
                    }
                    String substring = iVar.a.substring(i3, iVar.b);
                    iVar.b = i3;
                    L.append(substring);
                    throw new SVGParseException(L.toString());
                }
                SVG.b1 o = iVar.o();
                if (o == null) {
                    o = SVG.b1.px;
                }
                arrayList.add(new SVG.o(i2, o));
                iVar.q();
            }
            return arrayList;
        }
        throw new SVGParseException("Invalid length list (empty string)");
    }

    public final Map<String, String> E(i iVar) {
        HashMap hashMap = new HashMap();
        iVar.r();
        String m = iVar.m('=');
        while (m != null) {
            iVar.d('=');
            hashMap.put(m, iVar.k());
            iVar.r();
            m = iVar.m('=');
        }
        return hashMap;
    }

    public final Matrix F(String str) throws SVGParseException {
        Matrix matrix = new Matrix();
        i iVar = new i(str);
        iVar.r();
        while (!iVar.f()) {
            String str2 = null;
            if (!iVar.f()) {
                int i2 = iVar.b;
                int charAt = iVar.a.charAt(i2);
                while (true) {
                    if ((charAt >= 97 && charAt <= 122) || (charAt >= 65 && charAt <= 90)) {
                        charAt = iVar.a();
                    }
                }
                int i3 = iVar.b;
                while (iVar.g(charAt)) {
                    charAt = iVar.a();
                }
                if (charAt == 40) {
                    iVar.b++;
                    str2 = iVar.a.substring(i2, i3);
                } else {
                    iVar.b = i2;
                }
            }
            if (str2 != null) {
                char c2 = 65535;
                switch (str2.hashCode()) {
                    case -1081239615:
                        if (str2.equals("matrix")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -925180581:
                        if (str2.equals("rotate")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case 109250890:
                        if (str2.equals("scale")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 109493390:
                        if (str2.equals("skewX")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 109493391:
                        if (str2.equals("skewY")) {
                            c2 = 4;
                            break;
                        }
                        break;
                    case 1052832078:
                        if (str2.equals("translate")) {
                            c2 = 5;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        iVar.r();
                        float i4 = iVar.i();
                        iVar.q();
                        float i5 = iVar.i();
                        iVar.q();
                        float i6 = iVar.i();
                        iVar.q();
                        float i7 = iVar.i();
                        iVar.q();
                        float i8 = iVar.i();
                        iVar.q();
                        float i9 = iVar.i();
                        iVar.r();
                        if (!Float.isNaN(i9) && iVar.d(')')) {
                            Matrix matrix2 = new Matrix();
                            matrix2.setValues(new float[]{i4, i6, i8, i5, i7, i9, 0.0f, 0.0f, 1.0f});
                            matrix.preConcat(matrix2);
                            break;
                        } else {
                            throw new SVGParseException(a2.b.a.a.a.c3("Invalid transform list: ", str));
                        }
                    case 1:
                        iVar.r();
                        float i10 = iVar.i();
                        float p = iVar.p();
                        float p2 = iVar.p();
                        iVar.r();
                        if (Float.isNaN(i10) || !iVar.d(')')) {
                            throw new SVGParseException(a2.b.a.a.a.c3("Invalid transform list: ", str));
                        } else if (Float.isNaN(p)) {
                            matrix.preRotate(i10);
                            break;
                        } else if (!Float.isNaN(p2)) {
                            matrix.preRotate(i10, p, p2);
                            break;
                        } else {
                            throw new SVGParseException(a2.b.a.a.a.c3("Invalid transform list: ", str));
                        }
                    case 2:
                        iVar.r();
                        float i11 = iVar.i();
                        float p3 = iVar.p();
                        iVar.r();
                        if (!Float.isNaN(i11) && iVar.d(')')) {
                            if (!Float.isNaN(p3)) {
                                matrix.preScale(i11, p3);
                                break;
                            } else {
                                matrix.preScale(i11, i11);
                                break;
                            }
                        } else {
                            throw new SVGParseException(a2.b.a.a.a.c3("Invalid transform list: ", str));
                        }
                        break;
                    case 3:
                        iVar.r();
                        float i12 = iVar.i();
                        iVar.r();
                        if (!Float.isNaN(i12) && iVar.d(')')) {
                            matrix.preSkew((float) Math.tan(Math.toRadians((double) i12)), 0.0f);
                            break;
                        } else {
                            throw new SVGParseException(a2.b.a.a.a.c3("Invalid transform list: ", str));
                        }
                        break;
                    case 4:
                        iVar.r();
                        float i13 = iVar.i();
                        iVar.r();
                        if (!Float.isNaN(i13) && iVar.d(')')) {
                            matrix.preSkew(0.0f, (float) Math.tan(Math.toRadians((double) i13)));
                            break;
                        } else {
                            throw new SVGParseException(a2.b.a.a.a.c3("Invalid transform list: ", str));
                        }
                        break;
                    case 5:
                        iVar.r();
                        float i14 = iVar.i();
                        float p4 = iVar.p();
                        iVar.r();
                        if (!Float.isNaN(i14) && iVar.d(')')) {
                            if (!Float.isNaN(p4)) {
                                matrix.preTranslate(i14, p4);
                                break;
                            } else {
                                matrix.preTranslate(i14, 0.0f);
                                break;
                            }
                        } else {
                            throw new SVGParseException(a2.b.a.a.a.c3("Invalid transform list: ", str));
                        }
                        break;
                    default:
                        throw new SVGParseException(a2.b.a.a.a.e3("Invalid transform list fn: ", str2, ")"));
                }
                if (iVar.f()) {
                    return matrix;
                }
                iVar.q();
            } else {
                throw new SVGParseException(a2.b.a.a.a.c3("Bad transform function encountered in transform list: ", str));
            }
        }
        return matrix;
    }

    public final void G(InputStream inputStream) throws SVGParseException {
        try {
            SAXParserFactory newInstance = SAXParserFactory.newInstance();
            newInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
            newInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            XMLReader xMLReader = newInstance.newSAXParser().getXMLReader();
            C0022f fVar = new C0022f(null);
            xMLReader.setContentHandler(fVar);
            xMLReader.setProperty("http://xml.org/sax/properties/lexical-handler", fVar);
            xMLReader.parse(new InputSource(inputStream));
        } catch (ParserConfigurationException e2) {
            throw new SVGParseException("XML parser problem", e2);
        } catch (SAXException e3) {
            throw new SVGParseException("SVG parse error", e3);
        } catch (IOException e4) {
            throw new SVGParseException("Stream error", e4);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f3, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00fb, code lost:
        throw new com.caverock.androidsvg.SVGParseException("XML parser problem", r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00f3 A[ExcHandler: XmlPullParserException (r9v1 'e' org.xmlpull.v1.XmlPullParserException A[CUSTOM_DECLARE]), Splitter:B:0:0x0000] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void H(java.io.InputStream r9, boolean r10) throws com.caverock.androidsvg.SVGParseException {
        /*
            r8 = this;
            org.xmlpull.v1.XmlPullParser r0 = android.util.Xml.newPullParser()     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            a2.e.a.f$j r1 = new a2.e.a.f$j     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            r1.<init>(r8, r0)     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            java.lang.String r2 = "http://xmlpull.org/v1/doc/features.html#process-docdecl"
            r3 = 0
            r0.setFeature(r2, r3)     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            java.lang.String r2 = "http://xmlpull.org/v1/doc/features.html#process-namespaces"
            r4 = 1
            r0.setFeature(r2, r4)     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            r2 = 0
            r0.setInput(r9, r2)     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            int r2 = r0.getEventType()     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
        L_0x001d:
            if (r2 == r4) goto L_0x00e9
            if (r2 == 0) goto L_0x00dc
            r5 = 8
            if (r2 == r5) goto L_0x00c4
            r5 = 10
            if (r2 == r5) goto L_0x00a9
            r5 = 58
            r6 = 2
            if (r2 == r6) goto L_0x007d
            r7 = 3
            if (r2 == r7) goto L_0x0051
            r5 = 4
            if (r2 == r5) goto L_0x0042
            r5 = 5
            if (r2 == r5) goto L_0x0039
            goto L_0x00e3
        L_0x0039:
            java.lang.String r2 = r0.getText()     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            r8.N(r2)     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            goto L_0x00e3
        L_0x0042:
            int[] r2 = new int[r6]     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            char[] r5 = r0.getTextCharacters(r2)     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            r6 = r2[r3]     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            r2 = r2[r4]     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            r8.O(r5, r6, r2)     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            goto L_0x00e3
        L_0x0051:
            java.lang.String r2 = r0.getName()     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            java.lang.String r6 = r0.getPrefix()     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            if (r6 == 0) goto L_0x0071
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            r6.<init>()     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            java.lang.String r7 = r0.getPrefix()     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            r6.append(r7)     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            r6.append(r5)     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            r6.append(r2)     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            java.lang.String r2 = r6.toString()     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
        L_0x0071:
            java.lang.String r5 = r0.getNamespace()     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            java.lang.String r6 = r0.getName()     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            r8.c(r5, r6, r2)     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            goto L_0x00e3
        L_0x007d:
            java.lang.String r2 = r0.getName()     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            java.lang.String r6 = r0.getPrefix()     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            if (r6 == 0) goto L_0x009d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            r6.<init>()     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            java.lang.String r7 = r0.getPrefix()     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            r6.append(r7)     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            r6.append(r5)     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            r6.append(r2)     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            java.lang.String r2 = r6.toString()     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
        L_0x009d:
            java.lang.String r5 = r0.getNamespace()     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            java.lang.String r6 = r0.getName()     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            r8.L(r5, r6, r2, r1)     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            goto L_0x00e3
        L_0x00a9:
            if (r10 == 0) goto L_0x00e3
            com.caverock.androidsvg.SVG r2 = r8.a     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            com.caverock.androidsvg.SVG$d0 r2 = r2.a     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            if (r2 != 0) goto L_0x00e3
            java.lang.String r2 = r0.getText()     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            java.lang.String r5 = "<!ENTITY "
            boolean r2 = r2.contains(r5)     // Catch:{ XmlPullParserException -> 0x00f3, IOException -> 0x00ea }
            if (r2 == 0) goto L_0x00e3
            r9.reset()     // Catch:{ IOException -> 0x00c3, XmlPullParserException -> 0x00f3 }
            r8.G(r9)     // Catch:{ IOException -> 0x00c3, XmlPullParserException -> 0x00f3 }
        L_0x00c3:
            return
        L_0x00c4:
            r0.getText()
            a2.e.a.f$i r2 = new a2.e.a.f$i
            java.lang.String r5 = r0.getText()
            r2.<init>(r5)
            java.lang.String r5 = r2.l()
            java.util.Map r2 = r8.E(r2)
            r8.d(r5, r2)
            goto L_0x00e3
        L_0x00dc:
            com.caverock.androidsvg.SVG r2 = new com.caverock.androidsvg.SVG
            r2.<init>()
            r8.a = r2
        L_0x00e3:
            int r2 = r0.nextToken()
            goto L_0x001d
        L_0x00e9:
            return
        L_0x00ea:
            r9 = move-exception
            com.caverock.androidsvg.SVGParseException r10 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r0 = "Stream error"
            r10.<init>(r0, r9)
            throw r10
        L_0x00f3:
            r9 = move-exception
            com.caverock.androidsvg.SVGParseException r10 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r0 = "XML parser problem"
            r10.<init>(r0, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.e.a.f.H(java.io.InputStream, boolean):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00db, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void I(org.xml.sax.Attributes r7) throws com.caverock.androidsvg.SVGParseException {
        /*
        // Method dump skipped, instructions count: 268
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.e.a.f.I(org.xml.sax.Attributes):void");
    }

    public final void K(Attributes attributes) throws SVGParseException {
        SVG.h0 h0Var = this.b;
        if (h0Var != null) {
            SVG.b0 b0Var = new SVG.b0();
            b0Var.a = this.a;
            b0Var.b = h0Var;
            j(b0Var, attributes);
            m(b0Var, attributes);
            this.b.h(b0Var);
            this.b = b0Var;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:566:0x0108, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:589:0x0430, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:648:0x0a02, code lost:
        continue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:676:0x0c50, code lost:
        continue;
     */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x078b  */
    /* JADX WARNING: Removed duplicated region for block: B:605:0x07bb A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void L(java.lang.String r22, java.lang.String r23, java.lang.String r24, org.xml.sax.Attributes r25) throws com.caverock.androidsvg.SVGParseException {
        /*
        // Method dump skipped, instructions count: 3400
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.e.a.f.L(java.lang.String, java.lang.String, java.lang.String, org.xml.sax.Attributes):void");
    }

    public final void M(Attributes attributes) throws SVGParseException {
        if (this.b != null) {
            String str = ProfileTab.ALL;
            boolean z = true;
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                String trim = attributes.getValue(i2).trim();
                int ordinal = g.a(attributes.getLocalName(i2)).ordinal();
                if (ordinal == 38) {
                    str = trim;
                } else if (ordinal == 77) {
                    z = trim.equals("text/css");
                }
            }
            if (z) {
                b.f fVar = b.f.screen;
                b.d dVar = new b.d(str);
                dVar.r();
                if (b.b(b.e(dVar), fVar)) {
                    this.h = true;
                    return;
                }
            }
            this.c = true;
            this.d = 1;
            return;
        }
        throw new SVGParseException("Invalid document. Root element must be <svg>");
    }

    public final void N(String str) throws SVGParseException {
        if (!this.c) {
            if (this.e) {
                if (this.g == null) {
                    this.g = new StringBuilder(str.length());
                }
                this.g.append(str);
            } else if (this.h) {
                if (this.i == null) {
                    this.i = new StringBuilder(str.length());
                }
                this.i.append(str);
            } else if (this.b instanceof SVG.w0) {
                a(str);
            }
        }
    }

    public final void O(char[] cArr, int i2, int i3) throws SVGParseException {
        if (!this.c) {
            if (this.e) {
                if (this.g == null) {
                    this.g = new StringBuilder(i3);
                }
                this.g.append(cArr, i2, i3);
            } else if (this.h) {
                if (this.i == null) {
                    this.i = new StringBuilder(i3);
                }
                this.i.append(cArr, i2, i3);
            } else if (this.b instanceof SVG.w0) {
                a(new String(cArr, i2, i3));
            }
        }
    }

    public final void a(String str) throws SVGParseException {
        SVG.l0 l0Var;
        SVG.f0 f0Var = (SVG.f0) this.b;
        int size = f0Var.i.size();
        if (size == 0) {
            l0Var = null;
        } else {
            l0Var = f0Var.i.get(size - 1);
        }
        if (l0Var instanceof SVG.a1) {
            SVG.a1 a1Var = (SVG.a1) l0Var;
            a1Var.c = a2.b.a.a.a.t(new StringBuilder(), a1Var.c, str);
            return;
        }
        this.b.h(new SVG.a1(str));
    }

    public final void c(String str, String str2, String str3) throws SVGParseException {
        if (this.c) {
            int i2 = this.d - 1;
            this.d = i2;
            if (i2 == 0) {
                this.c = false;
                return;
            }
        }
        if ("http://www.w3.org/2000/svg".equals(str) || "".equals(str)) {
            if (str2.length() <= 0) {
                str2 = str3;
            }
            h hVar = h.G.get(str2);
            if (hVar == null) {
                hVar = h.UNSUPPORTED;
            }
            switch (hVar.ordinal()) {
                case 0:
                case 3:
                case 4:
                case 7:
                case 8:
                case 10:
                case 11:
                case 12:
                case 14:
                case 17:
                case 19:
                case 20:
                case 22:
                case 23:
                case 24:
                case 25:
                case 28:
                case 29:
                case 30:
                    this.b = ((SVG.l0) this.b).b;
                    return;
                case 1:
                case 2:
                case 6:
                case 9:
                case 13:
                case 15:
                case 16:
                case 18:
                case 27:
                default:
                    return;
                case 5:
                case 26:
                    this.e = false;
                    StringBuilder sb = this.g;
                    if (sb != null) {
                        h hVar2 = this.f;
                        if (hVar2 == h.title) {
                            this.a.b = sb.toString();
                        } else if (hVar2 == h.desc) {
                            this.a.c = sb.toString();
                        }
                        this.g.setLength(0);
                        return;
                    }
                    return;
                case 21:
                    StringBuilder sb2 = this.i;
                    if (sb2 != null) {
                        this.h = false;
                        String sb3 = sb2.toString();
                        b bVar = new b(b.f.screen, b.u.Document);
                        this.a.e.b(bVar.c(sb3));
                        this.i.setLength(0);
                        return;
                    }
                    return;
            }
        }
    }

    public final void d(String str, Map<String, String> map) {
        String str2;
        String resolveCSSStyleSheet;
        if (str.equals("xml-stylesheet") && SVG.g != null) {
            if (map.get("type") != null && !"text/css".equals(map.get("type"))) {
                return;
            }
            if ((map.get("alternate") == null || "no".equals(map.get("alternate"))) && (str2 = map.get(ShareConstants.WEB_DIALOG_PARAM_HREF)) != null && (resolveCSSStyleSheet = SVG.g.resolveCSSStyleSheet(str2)) != null) {
                String str3 = map.get("media");
                if (str3 != null && !ProfileTab.ALL.equals(str3.trim())) {
                    resolveCSSStyleSheet = a2.b.a.a.a.f("@media ", str3, " { ", resolveCSSStyleSheet, "}");
                }
                b bVar = new b(b.f.screen, b.u.Document);
                this.a.e.b(bVar.c(resolveCSSStyleSheet));
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00ae, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(org.xml.sax.Attributes r8) throws com.caverock.androidsvg.SVGParseException {
        /*
            r7 = this;
            com.caverock.androidsvg.SVG$h0 r0 = r7.b
            if (r0 == 0) goto L_0x00c2
            com.caverock.androidsvg.SVG$r r0 = new com.caverock.androidsvg.SVG$r
            r0.<init>()
            com.caverock.androidsvg.SVG r1 = r7.a
            r0.a = r1
            com.caverock.androidsvg.SVG$h0 r1 = r7.b
            r0.b = r1
            r7.j(r0, r8)
            r7.m(r0, r8)
            r7.i(r0, r8)
            r1 = 0
        L_0x001b:
            int r2 = r8.getLength()
            if (r1 >= r2) goto L_0x00ba
            java.lang.String r2 = r8.getValue(r1)
            java.lang.String r2 = r2.trim()
            java.lang.String r3 = r8.getLocalName(r1)
            a2.e.a.f$g r3 = a2.e.a.f.g.a(r3)
            int r3 = r3.ordinal()
            r4 = 25
            if (r3 == r4) goto L_0x00a2
            r4 = 36
            java.lang.String r5 = "userSpaceOnUse"
            java.lang.String r6 = "objectBoundingBox"
            if (r3 == r4) goto L_0x0084
            r4 = 37
            if (r3 == r4) goto L_0x0066
            switch(r3) {
                case 81: goto L_0x0051;
                case 82: goto L_0x004d;
                case 83: goto L_0x0049;
                default: goto L_0x0048;
            }
        L_0x0048:
            goto L_0x00ae
        L_0x0049:
            y(r2)
            goto L_0x00ae
        L_0x004d:
            y(r2)
            goto L_0x00ae
        L_0x0051:
            com.caverock.androidsvg.SVG$o r2 = y(r2)
            r0.p = r2
            boolean r2 = r2.f()
            if (r2 != 0) goto L_0x005e
            goto L_0x00ae
        L_0x005e:
            com.caverock.androidsvg.SVGParseException r8 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r0 = "Invalid <mask> element. width cannot be negative"
            r8.<init>(r0)
            throw r8
        L_0x0066:
            boolean r3 = r6.equals(r2)
            if (r3 == 0) goto L_0x0071
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r0.n = r2
            goto L_0x00ae
        L_0x0071:
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x007c
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r0.n = r2
            goto L_0x00ae
        L_0x007c:
            com.caverock.androidsvg.SVGParseException r8 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r0 = "Invalid value for attribute maskUnits"
            r8.<init>(r0)
            throw r8
        L_0x0084:
            boolean r3 = r6.equals(r2)
            if (r3 == 0) goto L_0x008f
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            r0.o = r2
            goto L_0x00ae
        L_0x008f:
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x009a
            java.lang.Boolean r2 = java.lang.Boolean.TRUE
            r0.o = r2
            goto L_0x00ae
        L_0x009a:
            com.caverock.androidsvg.SVGParseException r8 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r0 = "Invalid value for attribute maskContentUnits"
            r8.<init>(r0)
            throw r8
        L_0x00a2:
            com.caverock.androidsvg.SVG$o r2 = y(r2)
            r0.q = r2
            boolean r2 = r2.f()
            if (r2 != 0) goto L_0x00b2
        L_0x00ae:
            int r1 = r1 + 1
            goto L_0x001b
        L_0x00b2:
            com.caverock.androidsvg.SVGParseException r8 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r0 = "Invalid <mask> element. height cannot be negative"
            r8.<init>(r0)
            throw r8
        L_0x00ba:
            com.caverock.androidsvg.SVG$h0 r8 = r7.b
            r8.h(r0)
            r7.b = r0
            return
        L_0x00c2:
            com.caverock.androidsvg.SVGParseException r8 = new com.caverock.androidsvg.SVGParseException
            java.lang.String r0 = "Invalid document. Root element must be <svg>"
            r8.<init>(r0)
            throw r8
            switch-data {81->0x0051, 82->0x004d, 83->0x0049, }
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.e.a.f.g(org.xml.sax.Attributes):void");
    }

    public SVG h(InputStream inputStream, boolean z) throws SVGParseException {
        if (!inputStream.markSupported()) {
            inputStream = new BufferedInputStream(inputStream);
        }
        try {
            inputStream.mark(3);
            int read = inputStream.read() + (inputStream.read() << 8);
            inputStream.reset();
            if (read == 35615) {
                inputStream = new BufferedInputStream(new GZIPInputStream(inputStream));
            }
        } catch (IOException unused) {
        }
        try {
            inputStream.mark(4096);
            H(inputStream, z);
            return this.a;
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
        }
    }

    public final void i(SVG.e0 e0Var, Attributes attributes) throws SVGParseException {
        Set<String> hashSet;
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int ordinal = g.a(attributes.getLocalName(i2)).ordinal();
            if (ordinal != 73) {
                switch (ordinal) {
                    case 52:
                        i iVar = new i(trim);
                        HashSet hashSet2 = new HashSet();
                        while (!iVar.f()) {
                            String l = iVar.l();
                            if (l.startsWith("http://www.w3.org/TR/SVG11/feature#")) {
                                hashSet2.add(l.substring(35));
                            } else {
                                hashSet2.add("UNSUPPORTED");
                            }
                            iVar.r();
                        }
                        e0Var.g(hashSet2);
                        continue;
                    case 53:
                        e0Var.j(trim);
                        continue;
                    case 54:
                        i iVar2 = new i(trim);
                        HashSet hashSet3 = new HashSet();
                        while (!iVar2.f()) {
                            hashSet3.add(iVar2.l());
                            iVar2.r();
                        }
                        e0Var.i(hashSet3);
                        continue;
                    case 55:
                        if (v(trim) == null) {
                            hashSet = new HashSet<>(0);
                        }
                        e0Var.b(hashSet);
                        continue;
                }
            } else {
                i iVar3 = new i(trim);
                HashSet hashSet4 = new HashSet();
                while (!iVar3.f()) {
                    String l2 = iVar3.l();
                    int indexOf = l2.indexOf(45);
                    if (indexOf != -1) {
                        l2 = l2.substring(0, indexOf);
                    }
                    hashSet4.add(new Locale(l2, "", "").getLanguage());
                    iVar3.r();
                }
                e0Var.d(hashSet4);
            }
        }
    }

    public final void j(SVG.j0 j0Var, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String qName = attributes.getQName(i2);
            if (qName.equals("id") || qName.equals("xml:id")) {
                j0Var.c = attributes.getValue(i2).trim();
                return;
            } else if (qName.equals("xml:space")) {
                String trim = attributes.getValue(i2).trim();
                if ("default".equals(trim)) {
                    j0Var.d = Boolean.FALSE;
                    return;
                } else if ("preserve".equals(trim)) {
                    j0Var.d = Boolean.TRUE;
                    return;
                } else {
                    throw new SVGParseException(a2.b.a.a.a.c3("Invalid value for \"xml:space\" attribute: ", trim));
                }
            }
        }
    }

    public final void k(SVG.i iVar, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int ordinal = g.a(attributes.getLocalName(i2)).ordinal();
            if (ordinal == 23) {
                iVar.j = F(trim);
            } else if (ordinal != 24) {
                if (ordinal != 26) {
                    if (ordinal == 60) {
                        try {
                            iVar.k = SVG.j.valueOf(trim);
                        } catch (IllegalArgumentException unused) {
                            throw new SVGParseException(a2.b.a.a.a.e3("Invalid spreadMethod attribute. \"", trim, "\" is not a valid value."));
                        }
                    }
                } else if ("".equals(attributes.getURI(i2)) || "http://www.w3.org/1999/xlink".equals(attributes.getURI(i2))) {
                    iVar.l = trim;
                }
            } else if ("objectBoundingBox".equals(trim)) {
                iVar.i = Boolean.FALSE;
            } else if ("userSpaceOnUse".equals(trim)) {
                iVar.i = Boolean.TRUE;
            } else {
                throw new SVGParseException("Invalid value for attribute gradientUnits");
            }
        }
    }

    public final void l(SVG.y yVar, Attributes attributes, String str) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            if (g.a(attributes.getLocalName(i2)) == g.points) {
                i iVar = new i(attributes.getValue(i2));
                ArrayList arrayList = new ArrayList();
                iVar.r();
                while (!iVar.f()) {
                    float i3 = iVar.i();
                    if (!Float.isNaN(i3)) {
                        iVar.q();
                        float i4 = iVar.i();
                        if (!Float.isNaN(i4)) {
                            iVar.q();
                            arrayList.add(Float.valueOf(i3));
                            arrayList.add(Float.valueOf(i4));
                        } else {
                            throw new SVGParseException(a2.b.a.a.a.e3("Invalid <", str, "> points attribute. There should be an even number of coordinates."));
                        }
                    } else {
                        throw new SVGParseException(a2.b.a.a.a.e3("Invalid <", str, "> points attribute. Non-coordinate content found in list."));
                    }
                }
                yVar.o = new float[arrayList.size()];
                Iterator it = arrayList.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    yVar.o[i5] = ((Float) it.next()).floatValue();
                    i5++;
                }
            }
        }
    }

    public final void m(SVG.j0 j0Var, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            if (trim.length() != 0) {
                int ordinal = g.a(attributes.getLocalName(i2)).ordinal();
                if (ordinal == 0) {
                    b.d dVar = new b.d(trim);
                    ArrayList arrayList = null;
                    while (!dVar.f()) {
                        String l = dVar.l();
                        if (l != null) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(l);
                            dVar.r();
                        }
                    }
                    j0Var.g = arrayList;
                } else if (ordinal != 72) {
                    if (j0Var.e == null) {
                        j0Var.e = new SVG.Style();
                    }
                    J(j0Var.e, attributes.getLocalName(i2), attributes.getValue(i2).trim());
                } else {
                    i iVar = new i(trim.replaceAll("/\\*.*?\\*/", ""));
                    while (true) {
                        String m = iVar.m(':');
                        iVar.r();
                        if (!iVar.d(':')) {
                            break;
                        }
                        iVar.r();
                        String n = iVar.n(';', true);
                        if (n == null) {
                            break;
                        }
                        iVar.r();
                        if (iVar.f() || iVar.d(';')) {
                            if (j0Var.f == null) {
                                j0Var.f = new SVG.Style();
                            }
                            J(j0Var.f, m, n);
                            iVar.r();
                        }
                    }
                }
            }
        }
    }

    public final void n(SVG.y0 y0Var, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int ordinal = g.a(attributes.getLocalName(i2)).ordinal();
            if (ordinal == 9) {
                y0Var.p = z(trim);
            } else if (ordinal == 10) {
                y0Var.q = z(trim);
            } else if (ordinal == 82) {
                y0Var.n = z(trim);
            } else if (ordinal == 83) {
                y0Var.o = z(trim);
            }
        }
    }

    public final void o(SVG.m mVar, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            if (g.a(attributes.getLocalName(i2)) == g.transform) {
                mVar.k(F(attributes.getValue(i2)));
            }
        }
    }

    public final void p(SVG.p0 p0Var, Attributes attributes) throws SVGParseException {
        for (int i2 = 0; i2 < attributes.getLength(); i2++) {
            String trim = attributes.getValue(i2).trim();
            int ordinal = g.a(attributes.getLocalName(i2)).ordinal();
            if (ordinal == 48) {
                p0Var.n = D(trim);
            } else if (ordinal != 80) {
                continue;
            } else {
                i iVar = new i(trim);
                iVar.r();
                float i3 = iVar.i();
                iVar.q();
                float i4 = iVar.i();
                iVar.q();
                float i5 = iVar.i();
                iVar.q();
                float i6 = iVar.i();
                if (Float.isNaN(i3) || Float.isNaN(i4) || Float.isNaN(i5) || Float.isNaN(i6)) {
                    throw new SVGParseException("Invalid viewBox definition - should have four numbers");
                } else if (i5 < 0.0f) {
                    throw new SVGParseException("Invalid viewBox. width cannot be negative");
                } else if (i6 >= 0.0f) {
                    p0Var.o = new SVG.a(i3, i4, i5, i6);
                } else {
                    throw new SVGParseException("Invalid viewBox. height cannot be negative");
                }
            }
        }
    }
}
