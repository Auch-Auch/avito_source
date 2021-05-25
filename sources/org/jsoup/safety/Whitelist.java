package org.jsoup.safety;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.common.util.UriUtil;
import com.facebook.share.internal.ShareConstants;
import com.vk.sdk.api.VKApiConst;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Attributes;
import org.spongycastle.i18n.ErrorBundle;
public class Whitelist {
    public Set<d> a = new HashSet();
    public Map<d, Set<a>> b = new HashMap();
    public Map<d, Map<a, b>> c = new HashMap();
    public Map<d, Map<a, Set<c>>> d = new HashMap();
    public boolean e = false;

    public static class a extends e {
        public a(String str) {
            super(str);
        }
    }

    public static class b extends e {
        public b(String str) {
            super(str);
        }
    }

    public static class c extends e {
        public c(String str) {
            super(str);
        }
    }

    public static class d extends e {
        public d(String str) {
            super(str);
        }
    }

    public static abstract class e {
        public String a;

        public e(String str) {
            Validate.notNull(str);
            this.a = str;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            String str = this.a;
            if (str != null) {
                return str.equals(eVar.a);
            }
            if (eVar.a == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            String str = this.a;
            return 31 + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return this.a;
        }
    }

    public static Whitelist basic() {
        return new Whitelist().addTags(AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "blockquote", "br", "cite", "code", "dd", "dl", "dt", UserDataStore.EMAIL, "i", "li", "ol", "p", "pre", VKApiConst.Q, "small", "span", "strike", "strong", AuthSource.SUBSCRIBE_SELLER, "sup", "u", "ul").addAttributes(AuthSource.SEND_ABUSE, ShareConstants.WEB_DIALOG_PARAM_HREF).addAttributes("blockquote", "cite").addAttributes(VKApiConst.Q, "cite").addProtocols(AuthSource.SEND_ABUSE, ShareConstants.WEB_DIALOG_PARAM_HREF, "ftp", UriUtil.HTTP_SCHEME, "https", "mailto").addProtocols("blockquote", "cite", UriUtil.HTTP_SCHEME, "https").addProtocols("cite", "cite", UriUtil.HTTP_SCHEME, "https").addEnforcedAttribute(AuthSource.SEND_ABUSE, "rel", "nofollow");
    }

    public static Whitelist basicWithImages() {
        return basic().addTags("img").addAttributes("img", "align", "alt", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "src", "title", ViewHierarchyConstants.DIMENSION_WIDTH_KEY).addProtocols("img", "src", UriUtil.HTTP_SCHEME, "https");
    }

    public static Whitelist none() {
        return new Whitelist();
    }

    public static Whitelist relaxed() {
        return new Whitelist().addTags(AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "blockquote", "br", ShareConstants.FEED_CAPTION_PARAM, "cite", "code", "col", "colgroup", "dd", "div", "dl", "dt", UserDataStore.EMAIL, "h1", "h2", "h3", "h4", "h5", "h6", "i", "img", "li", "ol", "p", "pre", VKApiConst.Q, "small", "span", "strike", "strong", AuthSource.SUBSCRIBE_SELLER, "sup", "table", "tbody", "td", "tfoot", "th", "thead", "tr", "u", "ul").addAttributes(AuthSource.SEND_ABUSE, ShareConstants.WEB_DIALOG_PARAM_HREF, "title").addAttributes("blockquote", "cite").addAttributes("col", "span", ViewHierarchyConstants.DIMENSION_WIDTH_KEY).addAttributes("colgroup", "span", ViewHierarchyConstants.DIMENSION_WIDTH_KEY).addAttributes("img", "align", "alt", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "src", "title", ViewHierarchyConstants.DIMENSION_WIDTH_KEY).addAttributes("ol", Tracker.Events.CREATIVE_START, "type").addAttributes(VKApiConst.Q, "cite").addAttributes("table", ErrorBundle.SUMMARY_ENTRY, ViewHierarchyConstants.DIMENSION_WIDTH_KEY).addAttributes("td", "abbr", "axis", "colspan", "rowspan", ViewHierarchyConstants.DIMENSION_WIDTH_KEY).addAttributes("th", "abbr", "axis", "colspan", "rowspan", "scope", ViewHierarchyConstants.DIMENSION_WIDTH_KEY).addAttributes("ul", "type").addProtocols(AuthSource.SEND_ABUSE, ShareConstants.WEB_DIALOG_PARAM_HREF, "ftp", UriUtil.HTTP_SCHEME, "https", "mailto").addProtocols("blockquote", "cite", UriUtil.HTTP_SCHEME, "https").addProtocols("cite", "cite", UriUtil.HTTP_SCHEME, "https").addProtocols("img", "src", UriUtil.HTTP_SCHEME, "https").addProtocols(VKApiConst.Q, "cite", UriUtil.HTTP_SCHEME, "https");
    }

    public static Whitelist simpleText() {
        return new Whitelist().addTags(AuthSource.BOOKING_ORDER, UserDataStore.EMAIL, "i", "strong", "u");
    }

    public Attributes a(String str) {
        Attributes attributes = new Attributes();
        d dVar = new d(str);
        if (this.c.containsKey(dVar)) {
            for (Map.Entry<a, b> entry : this.c.get(dVar).entrySet()) {
                attributes.put(entry.getKey().a, entry.getValue().a);
            }
        }
        return attributes;
    }

    public Whitelist addAttributes(String str, String... strArr) {
        Validate.notEmpty(str);
        Validate.notNull(strArr);
        Validate.isTrue(strArr.length > 0, "No attribute names supplied.");
        d dVar = new d(str);
        this.a.add(dVar);
        HashSet hashSet = new HashSet();
        for (String str2 : strArr) {
            Validate.notEmpty(str2);
            hashSet.add(new a(str2));
        }
        if (this.b.containsKey(dVar)) {
            this.b.get(dVar).addAll(hashSet);
        } else {
            this.b.put(dVar, hashSet);
        }
        return this;
    }

    public Whitelist addEnforcedAttribute(String str, String str2, String str3) {
        Validate.notEmpty(str);
        Validate.notEmpty(str2);
        Validate.notEmpty(str3);
        d dVar = new d(str);
        this.a.add(dVar);
        a aVar = new a(str2);
        b bVar = new b(str3);
        if (this.c.containsKey(dVar)) {
            this.c.get(dVar).put(aVar, bVar);
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put(aVar, bVar);
            this.c.put(dVar, hashMap);
        }
        return this;
    }

    public Whitelist addProtocols(String str, String str2, String... strArr) {
        Map<a, Set<c>> map;
        Set<c> set;
        Validate.notEmpty(str);
        Validate.notEmpty(str2);
        Validate.notNull(strArr);
        d dVar = new d(str);
        a aVar = new a(str2);
        if (this.d.containsKey(dVar)) {
            map = this.d.get(dVar);
        } else {
            map = new HashMap<>();
            this.d.put(dVar, map);
        }
        if (map.containsKey(aVar)) {
            set = map.get(aVar);
        } else {
            HashSet hashSet = new HashSet();
            map.put(aVar, hashSet);
            set = hashSet;
        }
        for (String str3 : strArr) {
            Validate.notEmpty(str3);
            set.add(new c(str3));
        }
        return this;
    }

    public Whitelist addTags(String... strArr) {
        Validate.notNull(strArr);
        for (String str : strArr) {
            Validate.notEmpty(str);
            this.a.add(new d(str));
        }
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0093, code lost:
        r6 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isSafeAttribute(java.lang.String r6, org.jsoup.nodes.Element r7, org.jsoup.nodes.Attribute r8) {
        /*
            r5 = this;
            org.jsoup.safety.Whitelist$d r0 = new org.jsoup.safety.Whitelist$d
            r0.<init>(r6)
            java.lang.String r1 = r8.getKey()
            org.jsoup.safety.Whitelist$a r2 = new org.jsoup.safety.Whitelist$a
            r2.<init>(r1)
            java.util.Map<org.jsoup.safety.Whitelist$d, java.util.Set<org.jsoup.safety.Whitelist$a>> r1 = r5.b
            java.lang.Object r1 = r1.get(r0)
            java.util.Set r1 = (java.util.Set) r1
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x009b
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L_0x009b
            java.util.Map<org.jsoup.safety.Whitelist$d, java.util.Map<org.jsoup.safety.Whitelist$a, java.util.Set<org.jsoup.safety.Whitelist$c>>> r6 = r5.d
            boolean r6 = r6.containsKey(r0)
            if (r6 == 0) goto L_0x009a
            java.util.Map<org.jsoup.safety.Whitelist$d, java.util.Map<org.jsoup.safety.Whitelist$a, java.util.Set<org.jsoup.safety.Whitelist$c>>> r6 = r5.d
            java.lang.Object r6 = r6.get(r0)
            java.util.Map r6 = (java.util.Map) r6
            boolean r0 = r6.containsKey(r2)
            if (r0 == 0) goto L_0x0098
            java.lang.Object r6 = r6.get(r2)
            java.util.Set r6 = (java.util.Set) r6
            java.lang.String r0 = r8.getKey()
            java.lang.String r7 = r7.absUrl(r0)
            int r0 = r7.length()
            if (r0 != 0) goto L_0x004e
            java.lang.String r7 = r8.getValue()
        L_0x004e:
            boolean r0 = r5.e
            if (r0 != 0) goto L_0x0055
            r8.setValue(r7)
        L_0x0055:
            java.util.Iterator r6 = r6.iterator()
        L_0x0059:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L_0x0095
            java.lang.Object r8 = r6.next()
            org.jsoup.safety.Whitelist$c r8 = (org.jsoup.safety.Whitelist.c) r8
            java.lang.String r8 = r8.a
            java.lang.String r0 = "#"
            boolean r1 = r8.equals(r0)
            if (r1 == 0) goto L_0x0083
            boolean r8 = r7.startsWith(r0)
            if (r8 == 0) goto L_0x007f
            java.lang.String r8 = ".*\\s.*"
            boolean r8 = r7.matches(r8)
            if (r8 != 0) goto L_0x007f
            r8 = 1
            goto L_0x0080
        L_0x007f:
            r8 = 0
        L_0x0080:
            if (r8 == 0) goto L_0x0059
            goto L_0x0093
        L_0x0083:
            java.lang.String r0 = ":"
            java.lang.String r8 = a2.b.a.a.a.c3(r8, r0)
            java.lang.String r0 = org.jsoup.internal.Normalizer.lowerCase(r7)
            boolean r8 = r0.startsWith(r8)
            if (r8 == 0) goto L_0x0059
        L_0x0093:
            r6 = 1
            goto L_0x0096
        L_0x0095:
            r6 = 0
        L_0x0096:
            if (r6 == 0) goto L_0x0099
        L_0x0098:
            r3 = 1
        L_0x0099:
            return r3
        L_0x009a:
            return r4
        L_0x009b:
            java.util.Map<org.jsoup.safety.Whitelist$d, java.util.Map<org.jsoup.safety.Whitelist$a, org.jsoup.safety.Whitelist$b>> r1 = r5.c
            java.lang.Object r0 = r1.get(r0)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 == 0) goto L_0x00c0
            org.jsoup.nodes.Attributes r0 = r5.a(r6)
            java.lang.String r1 = r8.getKey()
            boolean r2 = r0.hasKeyIgnoreCase(r1)
            if (r2 == 0) goto L_0x00c0
            java.lang.String r6 = r0.getIgnoreCase(r1)
            java.lang.String r7 = r8.getValue()
            boolean r6 = r6.equals(r7)
            return r6
        L_0x00c0:
            java.lang.String r0 = ":all"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L_0x00cf
            boolean r6 = r5.isSafeAttribute(r0, r7, r8)
            if (r6 == 0) goto L_0x00cf
            r3 = 1
        L_0x00cf:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jsoup.safety.Whitelist.isSafeAttribute(java.lang.String, org.jsoup.nodes.Element, org.jsoup.nodes.Attribute):boolean");
    }

    public boolean isSafeTag(String str) {
        return this.a.contains(new d(str));
    }

    public Whitelist preserveRelativeLinks(boolean z) {
        this.e = z;
        return this;
    }

    public Whitelist removeAttributes(String str, String... strArr) {
        Validate.notEmpty(str);
        Validate.notNull(strArr);
        Validate.isTrue(strArr.length > 0, "No attribute names supplied.");
        d dVar = new d(str);
        HashSet hashSet = new HashSet();
        for (String str2 : strArr) {
            Validate.notEmpty(str2);
            hashSet.add(new a(str2));
        }
        if (this.a.contains(dVar) && this.b.containsKey(dVar)) {
            Set<a> set = this.b.get(dVar);
            set.removeAll(hashSet);
            if (set.isEmpty()) {
                this.b.remove(dVar);
            }
        }
        if (str.equals(":all")) {
            for (d dVar2 : this.b.keySet()) {
                Set<a> set2 = this.b.get(dVar2);
                set2.removeAll(hashSet);
                if (set2.isEmpty()) {
                    this.b.remove(dVar2);
                }
            }
        }
        return this;
    }

    public Whitelist removeEnforcedAttribute(String str, String str2) {
        Validate.notEmpty(str);
        Validate.notEmpty(str2);
        d dVar = new d(str);
        if (this.a.contains(dVar) && this.c.containsKey(dVar)) {
            a aVar = new a(str2);
            Map<a, b> map = this.c.get(dVar);
            map.remove(aVar);
            if (map.isEmpty()) {
                this.c.remove(dVar);
            }
        }
        return this;
    }

    public Whitelist removeProtocols(String str, String str2, String... strArr) {
        Validate.notEmpty(str);
        Validate.notEmpty(str2);
        Validate.notNull(strArr);
        d dVar = new d(str);
        a aVar = new a(str2);
        Validate.isTrue(this.d.containsKey(dVar), "Cannot remove a protocol that is not set.");
        Map<a, Set<c>> map = this.d.get(dVar);
        Validate.isTrue(map.containsKey(aVar), "Cannot remove a protocol that is not set.");
        Set<c> set = map.get(aVar);
        for (String str3 : strArr) {
            Validate.notEmpty(str3);
            set.remove(new c(str3));
        }
        if (set.isEmpty()) {
            map.remove(aVar);
            if (map.isEmpty()) {
                this.d.remove(dVar);
            }
        }
        return this;
    }

    public Whitelist removeTags(String... strArr) {
        Validate.notNull(strArr);
        for (String str : strArr) {
            Validate.notEmpty(str);
            d dVar = new d(str);
            if (this.a.remove(dVar)) {
                this.b.remove(dVar);
                this.c.remove(dVar);
                this.d.remove(dVar);
            }
        }
        return this;
    }
}
