package org.jsoup.nodes;

import com.avito.android.search.map.view.PanelStateKt;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import kotlin.text.Typography;
import org.jsoup.SerializationException;
import org.jsoup.helper.Validate;
import org.jsoup.internal.StringUtil;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
public class Attribute implements Map.Entry<String, String>, Cloneable {
    public static final String[] d = {"allowfullscreen", "async", "autofocus", "checked", MessengerShareContentUtility.WEBVIEW_RATIO_COMPACT, "declare", "default", "defer", "disabled", "formnovalidate", PanelStateKt.PANEL_HIDDEN, "inert", "ismap", "itemscope", "multiple", "muted", "nohref", "noresize", "noshade", "novalidate", "nowrap", "open", "readonly", "required", "reversed", "seamless", "selected", "sortable", "truespeed", "typemustmatch"};
    public String a;
    public String b;
    public Attributes c;

    public Attribute(String str, String str2) {
        this(str, str2, null);
    }

    public static Attribute createFromEncoded(String str, String str2) {
        char[] cArr = Entities.a;
        return new Attribute(str, Parser.unescapeEntities(str2, true), null);
    }

    public static boolean isBooleanAttribute(String str) {
        return Arrays.binarySearch(d, str) >= 0;
    }

    @Override // java.util.Map.Entry, java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Attribute attribute = (Attribute) obj;
        String str = this.a;
        if (str == null ? attribute.a != null : !str.equals(attribute.a)) {
            return false;
        }
        String str2 = this.b;
        String str3 = attribute.b;
        if (str2 != null) {
            return str2.equals(str3);
        }
        if (str3 == null) {
            return true;
        }
        return false;
    }

    public boolean hasDeclaredValue() {
        return this.b != null;
    }

    @Override // java.util.Map.Entry, java.lang.Object
    public int hashCode() {
        String str = this.a;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.b;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String html() {
        StringBuilder borrowBuilder = StringUtil.borrowBuilder();
        try {
            html(borrowBuilder, new Document("").outputSettings());
            return StringUtil.releaseBuilder(borrowBuilder);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }

    public boolean isDataAttribute() {
        return isDataAttribute(this.a);
    }

    public void setKey(String str) {
        int d2;
        Validate.notNull(str);
        String trim = str.trim();
        Validate.notEmpty(trim);
        Attributes attributes = this.c;
        if (!(attributes == null || (d2 = attributes.d(this.a)) == -1)) {
            this.c.b[d2] = trim;
        }
        this.a = trim;
    }

    public final boolean shouldCollapseAttribute(Document.OutputSettings outputSettings) {
        return shouldCollapseAttribute(this.a, this.b, outputSettings);
    }

    @Override // java.lang.Object
    public String toString() {
        return html();
    }

    public Attribute(String str, String str2, Attributes attributes) {
        Validate.notNull(str);
        String trim = str.trim();
        Validate.notEmpty(trim);
        this.a = trim;
        this.b = str2;
        this.c = attributes;
    }

    public static boolean isDataAttribute(String str) {
        return str.startsWith(Attributes.dataPrefix) && str.length() > 5;
    }

    public static boolean shouldCollapseAttribute(String str, String str2, Document.OutputSettings outputSettings) {
        return outputSettings.syntax() == Document.OutputSettings.Syntax.html && (str2 == null || (("".equals(str2) || str2.equalsIgnoreCase(str)) && isBooleanAttribute(str)));
    }

    @Override // java.lang.Object
    public Attribute clone() {
        try {
            return (Attribute) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // java.util.Map.Entry
    public String getKey() {
        return this.a;
    }

    @Override // java.util.Map.Entry
    public String getValue() {
        String str = this.b;
        return str == null ? "" : str;
    }

    public String setValue(String str) {
        String str2 = this.b;
        Attributes attributes = this.c;
        if (attributes != null) {
            str2 = attributes.get(this.a);
            int d2 = this.c.d(this.a);
            if (d2 != -1) {
                this.c.c[d2] = str;
            }
        }
        this.b = str;
        return str2 == null ? "" : str2;
    }

    public static void html(String str, String str2, Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        appendable.append(str);
        if (!shouldCollapseAttribute(str, str2, outputSettings)) {
            appendable.append("=\"");
            if (str2 == null) {
                str2 = "";
            }
            Entities.b(appendable, str2, outputSettings, true, false, false);
            appendable.append(Typography.quote);
        }
    }

    public void html(Appendable appendable, Document.OutputSettings outputSettings) throws IOException {
        html(this.a, this.b, appendable, outputSettings);
    }
}
