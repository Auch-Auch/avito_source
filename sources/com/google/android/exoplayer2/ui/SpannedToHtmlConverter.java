package com.google.android.exoplayer2.ui;

import android.text.Html;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
public final class SpannedToHtmlConverter {
    public static final Pattern a = Pattern.compile("(&#13;)?&#10;");

    public static class HtmlAndCss {
        public final Map<String, String> cssRuleSets;
        public final String html;

        public HtmlAndCss(String str, Map map, a aVar) {
            this.html = str;
            this.cssRuleSets = map;
        }
    }

    public static final class b {
        public final int a;
        public final int b;
        public final String c;
        public final String d;

        public b(int i, int i2, String str, String str2, a aVar) {
            this.a = i;
            this.b = i2;
            this.c = str;
            this.d = str2;
        }
    }

    public static final class c {
        public final List<b> a = new ArrayList();
        public final List<b> b = new ArrayList();
    }

    public static String a(CharSequence charSequence) {
        return a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }
}
