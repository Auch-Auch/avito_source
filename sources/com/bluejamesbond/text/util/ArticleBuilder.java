package com.bluejamesbond.text.util;

import android.text.Html;
import android.text.SpannableStringBuilder;
public class ArticleBuilder extends SpannableStringBuilder {
    public ArticleBuilder append(CharSequence charSequence, boolean z, Object... objArr) {
        int length = length();
        StringBuilder sb = new StringBuilder();
        sb.append((Object) charSequence);
        String str = "<br/>";
        sb.append(str);
        if (!z) {
            str = "";
        }
        sb.append(str);
        append((CharSequence) Html.fromHtml(sb.toString()));
        for (Object obj : objArr) {
            setSpan(obj, length, length(), 17);
        }
        return this;
    }
}
