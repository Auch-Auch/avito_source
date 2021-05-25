package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.text.Layout;
import android.text.TextUtils;
import android.widget.TextView;
public class aas {
    public int a(@NonNull TextView textView) {
        if (TextUtils.isEmpty(textView.getText()) || textView.getVisibility() != 0) {
            return 0;
        }
        String charSequence = textView.getText().toString();
        Layout layout = textView.getLayout();
        if (layout == null) {
            return charSequence.length();
        }
        int maxLines = textView.getMaxLines() - 1;
        TextUtils.TruncateAt ellipsize = textView.getEllipsize();
        if (ellipsize == null) {
            return charSequence.length();
        }
        if (maxLines != 0 && ellipsize != TextUtils.TruncateAt.END) {
            return charSequence.length();
        }
        return charSequence.length() - layout.getEllipsisCount(maxLines);
    }
}
