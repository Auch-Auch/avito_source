package com.avito.android.ui.view;

import android.content.Context;
import android.text.Editable;
import android.text.Html;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
public class TypefaceTagHandler implements Html.TagHandler {
    @NonNull
    public final Context a;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Tag {
        public static final String BOLD = "bold";
        public static final String MEDIUM = "medium";
        public static final String REGULAR = "regular";
    }

    public TypefaceTagHandler(@NonNull Context context) {
        this.a = context;
    }

    public static void a(@NonNull Editable editable, @NonNull Class cls, @Nullable Object obj) {
        Object obj2;
        int length = editable.length();
        Object[] spans = editable.getSpans(0, editable.length(), cls);
        if (spans.length == 0) {
            obj2 = null;
        } else {
            obj2 = spans[spans.length - 1];
        }
        int spanStart = editable.getSpanStart(obj2);
        editable.removeSpan(obj2);
        if (spanStart != length && obj != null) {
            editable.setSpan(obj, spanStart, length, 33);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        if (r8.equals("medium") == false) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0098, code lost:
        if (r8.equals("medium") == false) goto L_0x0080;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0064  */
    @Override // android.text.Html.TagHandler
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleTag(boolean r8, java.lang.String r9, android.text.Editable r10, org.xml.sax.XMLReader r11) {
        /*
            r7 = this;
            java.lang.String r11 = "regular"
            java.lang.String r0 = "bold"
            r1 = 0
            java.lang.String r2 = "medium"
            r3 = -1
            r4 = 2
            r5 = 1
            if (r8 == 0) goto L_0x006e
            java.util.Locale r8 = java.util.Locale.getDefault()
            java.lang.String r8 = r9.toLowerCase(r8)
            r8.hashCode()
            int r9 = r8.hashCode()
            r6 = -1078030475(0xffffffffbfbe8f75, float:-1.488753)
            if (r9 == r6) goto L_0x003d
            r1 = 3029637(0x2e3a85, float:4.245426E-39)
            if (r9 == r1) goto L_0x0034
            r0 = 1086463900(0x40c21f9c, float:6.0663586)
            if (r9 == r0) goto L_0x002b
            goto L_0x0043
        L_0x002b:
            boolean r8 = r8.equals(r11)
            if (r8 != 0) goto L_0x0032
            goto L_0x0043
        L_0x0032:
            r1 = 2
            goto L_0x0044
        L_0x0034:
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x003b
            goto L_0x0043
        L_0x003b:
            r1 = 1
            goto L_0x0044
        L_0x003d:
            boolean r8 = r8.equals(r2)
            if (r8 != 0) goto L_0x0044
        L_0x0043:
            r1 = -1
        L_0x0044:
            r8 = 17
            if (r1 == 0) goto L_0x0064
            if (r1 == r5) goto L_0x0059
            if (r1 == r4) goto L_0x004e
            goto L_0x00ce
        L_0x004e:
            com.avito.android.util.TypefaceType r9 = com.avito.android.util.TypefaceType.Regular
            int r11 = r10.length()
            r10.setSpan(r9, r11, r11, r8)
            goto L_0x00ce
        L_0x0059:
            com.avito.android.util.TypefaceType r9 = com.avito.android.util.TypefaceType.Bold
            int r11 = r10.length()
            r10.setSpan(r9, r11, r11, r8)
            goto L_0x00ce
        L_0x0064:
            com.avito.android.util.TypefaceType r9 = com.avito.android.util.TypefaceType.Medium
            int r11 = r10.length()
            r10.setSpan(r9, r11, r11, r8)
            goto L_0x00ce
        L_0x006e:
            java.util.Locale r8 = java.util.Locale.getDefault()
            java.lang.String r8 = r9.toLowerCase(r8)
            r8.hashCode()
            int r9 = r8.hashCode()
            switch(r9) {
                case -1078030475: goto L_0x0094;
                case 3029637: goto L_0x008b;
                case 1086463900: goto L_0x0082;
                default: goto L_0x0080;
            }
        L_0x0080:
            r1 = -1
            goto L_0x009b
        L_0x0082:
            boolean r8 = r8.equals(r11)
            if (r8 != 0) goto L_0x0089
            goto L_0x0080
        L_0x0089:
            r1 = 2
            goto L_0x009b
        L_0x008b:
            boolean r8 = r8.equals(r0)
            if (r8 != 0) goto L_0x0092
            goto L_0x0080
        L_0x0092:
            r1 = 1
            goto L_0x009b
        L_0x0094:
            boolean r8 = r8.equals(r2)
            if (r8 != 0) goto L_0x009b
            goto L_0x0080
        L_0x009b:
            switch(r1) {
                case 0: goto L_0x00bf;
                case 1: goto L_0x00af;
                case 2: goto L_0x009f;
                default: goto L_0x009e;
            }
        L_0x009e:
            goto L_0x00ce
        L_0x009f:
            com.avito.android.util.TypefaceType r8 = com.avito.android.util.TypefaceType.Regular
            java.lang.Class r9 = r8.getClass()
            android.content.Context r11 = r7.a
            com.avito.android.util.TypefaceSpan r8 = com.avito.android.util.Typefaces.getSpan(r11, r8)
            a(r10, r9, r8)
            goto L_0x00ce
        L_0x00af:
            com.avito.android.util.TypefaceType r8 = com.avito.android.util.TypefaceType.Bold
            java.lang.Class r9 = r8.getClass()
            android.content.Context r11 = r7.a
            com.avito.android.util.TypefaceSpan r8 = com.avito.android.util.Typefaces.getSpan(r11, r8)
            a(r10, r9, r8)
            goto L_0x00ce
        L_0x00bf:
            com.avito.android.util.TypefaceType r8 = com.avito.android.util.TypefaceType.Medium
            java.lang.Class r9 = r8.getClass()
            android.content.Context r11 = r7.a
            com.avito.android.util.TypefaceSpan r8 = com.avito.android.util.Typefaces.getSpan(r11, r8)
            a(r10, r9, r8)
        L_0x00ce:
            return
            switch-data {-1078030475->0x0094, 3029637->0x008b, 1086463900->0x0082, }
            switch-data {0->0x00bf, 1->0x00af, 2->0x009f, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.ui.view.TypefaceTagHandler.handleTag(boolean, java.lang.String, android.text.Editable, org.xml.sax.XMLReader):void");
    }
}
