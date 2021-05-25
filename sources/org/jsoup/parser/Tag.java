package org.jsoup.parser;

import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.facebook.appevents.UserDataStore;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.otaliastudios.cameraview.video.encoding.TextureMediaEncoder;
import com.vk.sdk.api.VKApiConst;
import java.util.HashMap;
import java.util.Map;
import org.jsoup.helper.Validate;
import org.jsoup.internal.Normalizer;
import org.spongycastle.i18n.ErrorBundle;
public class Tag implements Cloneable {
    public static final Map<String, Tag> j = new HashMap();
    public static final String[] k;
    public static final String[] l = {"object", "base", "font", "tt", "i", AuthSource.BOOKING_ORDER, "u", "big", "small", UserDataStore.EMAIL, "strong", "dfn", "code", "samp", "kbd", "var", "cite", "abbr", "time", "acronym", "mark", "ruby", "rt", "rp", AuthSource.SEND_ABUSE, "img", "br", "wbr", "map", VKApiConst.Q, AuthSource.SUBSCRIBE_SELLER, "sup", "bdo", "iframe", "embed", "span", "input", "select", "textarea", "label", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "optgroup", "option", "legend", "datalist", "keygen", "output", "progress", "meter", "area", "param", "source", "track", ErrorBundle.SUMMARY_ENTRY, "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track", "data", "bdi", "s"};
    public static final String[] m = {"meta", "link", "base", TextureMediaEncoder.FRAME_EVENT, "img", "br", "wbr", "embed", "hr", "input", "keygen", "col", "command", "device", "area", "basefont", "bgsound", "menuitem", "param", "source", "track"};
    public static final String[] n = {"title", AuthSource.SEND_ABUSE, "p", "h1", "h2", "h3", "h4", "h5", "h6", "pre", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "li", "th", "td", "script", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "ins", "del", "s"};
    public static final String[] o = {"pre", "plaintext", "title", "textarea"};
    public static final String[] p = {PhonePageSourceKt.PHONE_SOURCE_BUTTON, "fieldset", "input", "keygen", "object", "output", "select", "textarea"};
    public static final String[] q = {"input", "keygen", "object", "select", "textarea"};
    public String a;
    public String b;
    public boolean c = true;
    public boolean d = true;
    public boolean e = false;
    public boolean f = false;
    public boolean g = false;
    public boolean h = false;
    public boolean i = false;

    static {
        String[] strArr = {"html", "head", SDKConstants.PARAM_A2U_BODY, "frameset", "script", "noscript", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "meta", "link", "title", TextureMediaEncoder.FRAME_EVENT, "noframes", "section", "nav", "aside", "hgroup", TariffPackageInfoConverterKt.HEADER_STRING_ID, "footer", "p", "h1", "h2", "h3", "h4", "h5", "h6", "ul", "ol", "pre", "div", "blockquote", "hr", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "figure", "figcaption", "form", "fieldset", "ins", "del", "dl", "dt", "dd", "li", "table", ShareConstants.FEED_CAPTION_PARAM, "thead", "tfoot", "tbody", "colgroup", "col", "tr", "th", "td", "video", "audio", "canvas", ErrorBundle.DETAIL_ENTRY, "menu", "plaintext", "template", "article", "main", "svg", "math", "center"};
        k = strArr;
        for (String str : strArr) {
            Tag tag = new Tag(str);
            j.put(tag.a, tag);
        }
        for (String str2 : l) {
            Tag tag2 = new Tag(str2);
            tag2.c = false;
            tag2.d = false;
            j.put(tag2.a, tag2);
        }
        for (String str3 : m) {
            Tag tag3 = j.get(str3);
            Validate.notNull(tag3);
            tag3.e = true;
        }
        for (String str4 : n) {
            Tag tag4 = j.get(str4);
            Validate.notNull(tag4);
            tag4.d = false;
        }
        for (String str5 : o) {
            Tag tag5 = j.get(str5);
            Validate.notNull(tag5);
            tag5.g = true;
        }
        for (String str6 : p) {
            Tag tag6 = j.get(str6);
            Validate.notNull(tag6);
            tag6.h = true;
        }
        for (String str7 : q) {
            Tag tag7 = j.get(str7);
            Validate.notNull(tag7);
            tag7.i = true;
        }
    }

    public Tag(String str) {
        this.a = str;
        this.b = Normalizer.lowerCase(str);
    }

    public static Tag valueOf(String str, ParseSettings parseSettings) {
        Validate.notNull(str);
        Map<String, Tag> map = j;
        Tag tag = map.get(str);
        if (tag != null) {
            return tag;
        }
        String normalizeTag = parseSettings.normalizeTag(str);
        Validate.notEmpty(normalizeTag);
        String lowerCase = Normalizer.lowerCase(normalizeTag);
        Tag tag2 = map.get(lowerCase);
        if (tag2 == null) {
            Tag tag3 = new Tag(normalizeTag);
            tag3.c = false;
            return tag3;
        } else if (!parseSettings.preserveTagCase() || normalizeTag.equals(lowerCase)) {
            return tag2;
        } else {
            Tag clone = tag2.clone();
            clone.a = normalizeTag;
            return clone;
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) obj;
        if (this.a.equals(tag.a) && this.e == tag.e && this.d == tag.d && this.c == tag.c && this.g == tag.g && this.f == tag.f && this.h == tag.h && this.i == tag.i) {
            return true;
        }
        return false;
    }

    public boolean formatAsBlock() {
        return this.d;
    }

    public String getName() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (((((((((((((this.a.hashCode() * 31) + (this.c ? 1 : 0)) * 31) + (this.d ? 1 : 0)) * 31) + (this.e ? 1 : 0)) * 31) + (this.f ? 1 : 0)) * 31) + (this.g ? 1 : 0)) * 31) + (this.h ? 1 : 0)) * 31) + (this.i ? 1 : 0);
    }

    public boolean isBlock() {
        return this.c;
    }

    public boolean isEmpty() {
        return this.e;
    }

    public boolean isFormListed() {
        return this.h;
    }

    public boolean isFormSubmittable() {
        return this.i;
    }

    public boolean isInline() {
        return !this.c;
    }

    public boolean isKnownTag() {
        return j.containsKey(this.a);
    }

    public boolean isSelfClosing() {
        return this.e || this.f;
    }

    public String normalName() {
        return this.b;
    }

    public boolean preserveWhitespace() {
        return this.g;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.a;
    }

    public static boolean isKnownTag(String str) {
        return j.containsKey(str);
    }

    @Override // java.lang.Object
    public Tag clone() {
        try {
            return (Tag) super.clone();
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static Tag valueOf(String str) {
        return valueOf(str, ParseSettings.preserveCase);
    }
}
