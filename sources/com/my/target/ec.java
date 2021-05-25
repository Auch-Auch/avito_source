package com.my.target;

import a2.b.a.a.a;
import android.text.TextUtils;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.my.target.bt;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import ru.avito.messenger.internal.ConstantsKt;
public class ec<T extends bt> {
    public static final String[] k = {"video/mp4", "application/vnd.apple.mpegurl", "application/x-mpegurl"};
    public static final String[] l = {"linkTxt"};
    @NonNull
    public final a a;
    @NonNull
    public final bp b;
    @NonNull
    public final ArrayList<cy> c = new ArrayList<>();
    @NonNull
    public final ArrayList<cx> d = new ArrayList<>();
    @NonNull
    public final ArrayList<bz> e = new ArrayList<>();
    @NonNull
    public final ArrayList<cy> f = new ArrayList<>();
    @NonNull
    public final ArrayList<cf<T>> g = new ArrayList<>();
    public boolean h;
    @Nullable
    public String i;
    @Nullable
    public bp j;

    public ec(@NonNull a aVar, @NonNull bp bpVar) {
        this.a = aVar;
        this.b = bpVar;
    }

    @NonNull
    public static <T extends bt> ec<T> a(@NonNull a aVar, @NonNull bp bpVar) {
        return new ec<>(aVar, bpVar);
    }

    @NonNull
    public static String a(@NonNull String str) {
        return str.replaceAll("&amp;", "&").replaceAll("&lt;", "<").replaceAll("&gt;", ">").trim();
    }

    public static void e(@NonNull XmlPullParser xmlPullParser) {
        if (k(xmlPullParser) == 2) {
            int i2 = 1;
            while (i2 != 0) {
                int g2 = g(xmlPullParser);
                if (g2 == 2) {
                    i2++;
                } else if (g2 == 3) {
                    i2--;
                }
            }
        }
    }

    public static int g(@NonNull XmlPullParser xmlPullParser) {
        try {
            return xmlPullParser.next();
        } catch (Throwable th) {
            ae.a(th.getMessage());
            return Integer.MIN_VALUE;
        }
    }

    @NonNull
    public static String i(@NonNull XmlPullParser xmlPullParser) {
        String str;
        if (g(xmlPullParser) == 4) {
            str = xmlPullParser.getText();
            j(xmlPullParser);
        } else {
            StringBuilder L = a.L("No text: ");
            L.append(xmlPullParser.getName());
            ae.a(L.toString());
            str = "";
        }
        return str.trim();
    }

    public static int j(@NonNull XmlPullParser xmlPullParser) {
        try {
            return xmlPullParser.nextTag();
        } catch (Throwable th) {
            ae.a(th.getMessage());
            return Integer.MIN_VALUE;
        }
    }

    public static int k(@NonNull XmlPullParser xmlPullParser) {
        try {
            return xmlPullParser.getEventType();
        } catch (Throwable th) {
            ae.a(th.getMessage());
            return Integer.MIN_VALUE;
        }
    }

    public void S(@NonNull String str) {
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
            newPullParser.setInput(new StringReader(str));
            ArrayList<cy> bd = this.b.bd();
            if (bd != null) {
                this.c.addAll(bd);
            }
            ArrayList<bz> companionBanners = this.b.getCompanionBanners();
            if (companionBanners != null) {
                this.e.addAll(companionBanners);
            }
            int k2 = k(newPullParser);
            while (k2 != 1 && k2 != Integer.MIN_VALUE) {
                if (k2 == 2 && "VAST".equalsIgnoreCase(newPullParser.getName())) {
                    while (j(newPullParser) == 2) {
                        if (k(newPullParser) == 2 && "Ad".equals(newPullParser.getName())) {
                            while (j(newPullParser) == 2) {
                                if (k(newPullParser) == 2) {
                                    String name = newPullParser.getName();
                                    if ("Wrapper".equals(name)) {
                                        this.h = true;
                                        ae.a("VAST file contains wrapped ad information.");
                                        int be = this.b.be();
                                        if (be < 5) {
                                            String str2 = null;
                                            while (j(newPullParser) == 2) {
                                                if (k(newPullParser) == 2) {
                                                    String name2 = newPullParser.getName();
                                                    if ("Impression".equals(name2)) {
                                                        m(newPullParser);
                                                    } else if ("Creatives".equals(name2)) {
                                                        n(newPullParser);
                                                    } else if ("Extensions".equals(name2)) {
                                                        l(newPullParser);
                                                    } else if ("VASTAdTagURI".equals(name2)) {
                                                        str2 = i(newPullParser);
                                                    } else {
                                                        e(newPullParser);
                                                    }
                                                }
                                            }
                                            if (str2 != null) {
                                                String ctaText = this.b.getCtaText();
                                                bp p = bp.p(str2);
                                                this.j = p;
                                                p.f(be + 1);
                                                this.j.c(this.c);
                                                bp bpVar = this.j;
                                                if (TextUtils.isEmpty(ctaText)) {
                                                    ctaText = this.i;
                                                }
                                                bpVar.setCtaText(ctaText);
                                                this.j.b(this.e);
                                                this.j.a(this.b.bg());
                                                this.j.b(this.b.bh());
                                                this.j.c(this.b.bi());
                                                this.j.d(this.b.bj());
                                                this.j.e(this.b.bk());
                                                this.j.f(this.b.bm());
                                                this.j.g(this.b.bn());
                                                this.j.setAllowCloseDelay(this.b.getAllowCloseDelay());
                                                this.j.h(this.b.bo());
                                                cz bl = this.j.bl();
                                                bl.e(this.f);
                                                bl.f(this.d);
                                                bl.a(this.b.bl(), -1.0f);
                                                this.b.b(this.j);
                                            } else {
                                                ae.a("got VAST wrapper, but no vastAdTagUri");
                                            }
                                        } else {
                                            ae.a("got VAST wrapper, but max redirects limit exceeded");
                                        }
                                    } else if ("InLine".equals(name)) {
                                        this.h = false;
                                        ae.a("VAST file contains inline ad information.");
                                        while (j(newPullParser) == 2) {
                                            if (k(newPullParser) == 2) {
                                                String name3 = newPullParser.getName();
                                                if ("Impression".equals(name3)) {
                                                    m(newPullParser);
                                                } else if (name3 != null && name3.equals("Creatives")) {
                                                    n(newPullParser);
                                                } else if (name3 == null || !name3.equals("Extensions")) {
                                                    e(newPullParser);
                                                } else {
                                                    l(newPullParser);
                                                }
                                            }
                                        }
                                        for (int i2 = 0; i2 < this.g.size(); i2++) {
                                            cf<T> cfVar = this.g.get(i2);
                                            cz statHolder = cfVar.getStatHolder();
                                            statHolder.a(this.b.bl(), cfVar.getDuration());
                                            String ctaText2 = this.b.getCtaText();
                                            if (TextUtils.isEmpty(ctaText2)) {
                                                ctaText2 = this.i;
                                            }
                                            cfVar.setCtaText(ctaText2);
                                            Iterator<cx> it = this.d.iterator();
                                            while (it.hasNext()) {
                                                cx next = it.next();
                                                c(next.cv(), next.getUrl(), cfVar);
                                            }
                                            statHolder.e(this.f);
                                            Iterator<bz> it2 = this.e.iterator();
                                            while (it2.hasNext()) {
                                                cfVar.addCompanion(it2.next());
                                            }
                                            if (i2 == 0) {
                                                statHolder.e(this.c);
                                            }
                                        }
                                    }
                                    e(newPullParser);
                                }
                            }
                        }
                    }
                }
                k2 = g(newPullParser);
            }
        } catch (Throwable th) {
            a.q1(th, a.L("Unable to parse VAST: "));
        }
    }

    @VisibleForTesting
    public float b(@NonNull String str) {
        String str2;
        long j2 = 0;
        try {
            if (str.contains(".")) {
                int indexOf = str.indexOf(".");
                j2 = Long.parseLong(str.substring(indexOf + 1));
                if (j2 > 1000) {
                    return -1.0f;
                }
                str2 = str.substring(0, indexOf);
            } else {
                str2 = str;
            }
            String[] split = str2.split(":", 3);
            long parseInt = (long) Integer.parseInt(split[0]);
            long parseInt2 = (long) Integer.parseInt(split[1]);
            long parseInt3 = (long) Integer.parseInt(split[2]);
            if (parseInt >= 24 || parseInt2 >= 60 || parseInt3 >= 60) {
                return -1.0f;
            }
            Long.signum(parseInt3);
            long j3 = parseInt2 * DefaultLoadErrorHandlingPolicy.DEFAULT_TRACK_BLACKLIST_MS;
            return ((float) ((parseInt * ConstantsKt.DEFAULT_TIME_TO_MODIFY_MESSAGE_MS) + (j3 + ((parseInt3 * 1000) + j2)))) / 1000.0f;
        } catch (Throwable unused) {
            return -1.0f;
        }
    }

    public final void c(float f2, @NonNull String str, @Nullable by byVar) {
        cx J = cx.J(str);
        if (byVar == null || byVar.getDuration() <= 0.0f) {
            J.m(f2);
            this.d.add(J);
            return;
        }
        J.l((f2 / 100.0f) * byVar.getDuration());
        byVar.getStatHolder().b(J);
    }

    @NonNull
    public ArrayList<cf<T>> cU() {
        return this.g;
    }

    @Nullable
    public bp cV() {
        return this.j;
    }

    public final void d(@NonNull String str, @NonNull String str2, @Nullable by byVar) {
        if (byVar != null) {
            byVar.getStatHolder().b(cy.c(str, str2));
            return;
        }
        this.f.add(cy.c(str, str2));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0140, code lost:
        if ("closeLinear".equalsIgnoreCase(r1) != false) goto L_0x0142;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f(@androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser r7, @androidx.annotation.Nullable com.my.target.by r8) {
        /*
        // Method dump skipped, instructions count: 360
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.ec.f(org.xmlpull.v1.XmlPullParser, com.my.target.by):void");
    }

    public final void h(@Nullable String str, @NonNull String str2, @Nullable String str3) {
        StringBuilder W = a.W("Vast parser error ", str2, " with banner Id ", str, ": ");
        W.append(str3);
        ae.a(W.toString());
    }

    public final void l(@NonNull XmlPullParser xmlPullParser) {
        while (j(xmlPullParser) == 2) {
            if (k(xmlPullParser) == 2) {
                if ("Extension".equals(xmlPullParser.getName())) {
                    String attributeValue = xmlPullParser.getAttributeValue(null, "type");
                    for (String str : l) {
                        if (!str.equals(attributeValue)) {
                            e(xmlPullParser);
                        } else if ("linkTxt".equals(attributeValue)) {
                            String i2 = i(xmlPullParser);
                            this.i = ip.decode(i2);
                            a.U0("VAST linkTxt raw text: ", i2);
                        }
                    }
                } else {
                    e(xmlPullParser);
                }
            }
        }
    }

    public final void m(@NonNull XmlPullParser xmlPullParser) {
        String i2 = i(xmlPullParser);
        if (!TextUtils.isEmpty(i2)) {
            this.c.add(cy.c("playbackStarted", i2));
            ae.a("Impression tracker url for wrapper: " + i2);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v8, resolved type: com.my.target.cf */
    /* JADX DEBUG: Multi-variable search result rejected for r0v67, resolved type: java.util.ArrayList<com.my.target.cf<T extends com.my.target.bt>> */
    /* JADX DEBUG: Multi-variable search result rejected for r6v9, resolved type: com.my.target.cf */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0362, code lost:
        r17 = r4;
        r19 = r5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x02a1  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x02bc  */
    /* JADX WARNING: Removed duplicated region for block: B:276:0x02ea A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:279:0x0355 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01e4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n(@androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser r26) {
        /*
        // Method dump skipped, instructions count: 1401
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.ec.n(org.xmlpull.v1.XmlPullParser):void");
    }
}
