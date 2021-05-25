package androidx.core.text.util;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.PatternsCompat;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public final class LinkifyCompat {
    public static final String[] a = new String[0];
    public static final Comparator<b> b = new a();

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public @interface LinkifyMask {
    }

    public class a implements Comparator<b> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // java.util.Comparator
        public int compare(b bVar, b bVar2) {
            int i;
            int i2;
            b bVar3 = bVar;
            b bVar4 = bVar2;
            int i3 = bVar3.c;
            int i4 = bVar4.c;
            if (i3 < i4) {
                return -1;
            }
            if (i3 > i4 || (i = bVar3.d) < (i2 = bVar4.d)) {
                return 1;
            }
            if (i > i2) {
                return -1;
            }
            return 0;
        }
    }

    public static class b {
        public URLSpan a;
        public String b;
        public int c;
        public int d;
    }

    public static void a(@NonNull TextView textView) {
        if (!(textView.getMovementMethod() instanceof LinkMovementMethod) && textView.getLinksClickable()) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public static boolean addLinks(@NonNull Spannable spannable, int i) {
        int i2;
        int i3;
        int i4;
        if (e()) {
            return Linkify.addLinks(spannable, i);
        }
        if (i == 0) {
            return false;
        }
        Object[] objArr = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int length = objArr.length - 1; length >= 0; length--) {
            spannable.removeSpan(objArr[length]);
        }
        if ((i & 4) != 0) {
            Linkify.addLinks(spannable, 4);
        }
        ArrayList arrayList = new ArrayList();
        if ((i & 1) != 0) {
            c(arrayList, spannable, PatternsCompat.AUTOLINK_WEB_URL, new String[]{"http://", "https://", "rtsp://"}, Linkify.sUrlMatchFilter, null);
        }
        if ((i & 2) != 0) {
            c(arrayList, spannable, PatternsCompat.AUTOLINK_EMAIL_ADDRESS, new String[]{"mailto:"}, null, null);
        }
        if ((i & 8) != 0) {
            String obj = spannable.toString();
            int i5 = 0;
            while (true) {
                try {
                    String b2 = b(obj);
                    if (b2 == null) {
                        break;
                    }
                    int indexOf = obj.indexOf(b2);
                    if (indexOf < 0) {
                        break;
                    }
                    b bVar = new b();
                    int length2 = b2.length() + indexOf;
                    bVar.c = indexOf + i5;
                    i5 += length2;
                    bVar.d = i5;
                    obj = obj.substring(length2);
                    try {
                        bVar.b = "geo:0,0?q=" + URLEncoder.encode(b2, "UTF-8");
                        arrayList.add(bVar);
                    } catch (UnsupportedEncodingException unused) {
                    }
                } catch (UnsupportedOperationException unused2) {
                }
            }
        }
        Object[] objArr2 = (URLSpan[]) spannable.getSpans(0, spannable.length(), URLSpan.class);
        for (int i6 = 0; i6 < objArr2.length; i6++) {
            b bVar2 = new b();
            bVar2.a = objArr2[i6];
            bVar2.c = spannable.getSpanStart(objArr2[i6]);
            bVar2.d = spannable.getSpanEnd(objArr2[i6]);
            arrayList.add(bVar2);
        }
        Collections.sort(arrayList, b);
        int size = arrayList.size();
        int i7 = 0;
        while (true) {
            int i8 = size - 1;
            if (i7 >= i8) {
                break;
            }
            b bVar3 = (b) arrayList.get(i7);
            int i9 = i7 + 1;
            b bVar4 = (b) arrayList.get(i9);
            int i10 = bVar3.c;
            int i11 = bVar4.c;
            if (i10 <= i11 && (i2 = bVar3.d) > i11) {
                int i12 = bVar4.d;
                int i13 = (i12 > i2 && (i3 = i2 - i10) <= (i4 = i12 - i11)) ? i3 < i4 ? i7 : -1 : i9;
                if (i13 != -1) {
                    Object obj2 = ((b) arrayList.get(i13)).a;
                    if (obj2 != null) {
                        spannable.removeSpan(obj2);
                    }
                    arrayList.remove(i13);
                    size = i8;
                }
            }
            i7 = i9;
        }
        if (arrayList.size() == 0) {
            return false;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b bVar5 = (b) it.next();
            if (bVar5.a == null) {
                spannable.setSpan(new URLSpan(bVar5.b), bVar5.c, bVar5.d, 33);
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0060, code lost:
        r2 = -r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0061, code lost:
        r13 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ba, code lost:
        if (l6.h.h.a.a.a(r2.group(0)) != false) goto L_0x00be;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00eb, code lost:
        r5 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x01a1, code lost:
        r2 = 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x019b A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x011f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.lang.String r18) {
        /*
        // Method dump skipped, instructions count: 462
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.text.util.LinkifyCompat.b(java.lang.String):java.lang.String");
    }

    public static void c(ArrayList<b> arrayList, Spannable spannable, Pattern pattern, String[] strArr, Linkify.MatchFilter matchFilter, Linkify.TransformFilter transformFilter) {
        Matcher matcher = pattern.matcher(spannable);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (matchFilter == null || matchFilter.acceptMatch(spannable, start, end)) {
                b bVar = new b();
                bVar.b = d(matcher.group(0), strArr, matcher, null);
                bVar.c = start;
                bVar.d = end;
                arrayList.add(bVar);
            }
        }
    }

    public static String d(@NonNull String str, @NonNull String[] strArr, Matcher matcher, @Nullable Linkify.TransformFilter transformFilter) {
        boolean z;
        if (transformFilter != null) {
            str = transformFilter.transformUrl(matcher, str);
        }
        int i = 0;
        while (true) {
            z = true;
            if (i >= strArr.length) {
                z = false;
                break;
            } else if (!str.regionMatches(true, 0, strArr[i], 0, strArr[i].length())) {
                i++;
            } else if (!str.regionMatches(false, 0, strArr[i], 0, strArr[i].length())) {
                str = strArr[i] + str.substring(strArr[i].length());
            }
        }
        return (z || strArr.length <= 0) ? str : a2.b.a.a.a.t(new StringBuilder(), strArr[0], str);
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean addLinks(@NonNull TextView textView, int i) {
        if (e()) {
            return Linkify.addLinks(textView, i);
        }
        if (i == 0) {
            return false;
        }
        CharSequence text = textView.getText();
        if (!(text instanceof Spannable)) {
            SpannableString valueOf = SpannableString.valueOf(text);
            if (!addLinks(valueOf, i)) {
                return false;
            }
            a(textView);
            textView.setText(valueOf);
            return true;
        } else if (!addLinks((Spannable) text, i)) {
            return false;
        } else {
            a(textView);
            return true;
        }
    }

    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str) {
        if (e()) {
            Linkify.addLinks(textView, pattern, str);
        } else {
            addLinks(textView, pattern, str, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
        }
    }

    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (e()) {
            Linkify.addLinks(textView, pattern, str, matchFilter, transformFilter);
        } else {
            addLinks(textView, pattern, str, (String[]) null, matchFilter, transformFilter);
        }
    }

    @SuppressLint({"NewApi"})
    public static void addLinks(@NonNull TextView textView, @NonNull Pattern pattern, @Nullable String str, @Nullable String[] strArr, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (e()) {
            Linkify.addLinks(textView, pattern, str, strArr, matchFilter, transformFilter);
            return;
        }
        SpannableString valueOf = SpannableString.valueOf(textView.getText());
        if (addLinks(valueOf, pattern, str, strArr, matchFilter, transformFilter)) {
            textView.setText(valueOf);
            a(textView);
        }
    }

    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str) {
        if (e()) {
            return Linkify.addLinks(spannable, pattern, str);
        }
        return addLinks(spannable, pattern, str, (String[]) null, (Linkify.MatchFilter) null, (Linkify.TransformFilter) null);
    }

    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        if (e()) {
            return Linkify.addLinks(spannable, pattern, str, matchFilter, transformFilter);
        }
        return addLinks(spannable, pattern, str, (String[]) null, matchFilter, transformFilter);
    }

    @SuppressLint({"NewApi"})
    public static boolean addLinks(@NonNull Spannable spannable, @NonNull Pattern pattern, @Nullable String str, @Nullable String[] strArr, @Nullable Linkify.MatchFilter matchFilter, @Nullable Linkify.TransformFilter transformFilter) {
        String str2;
        if (e()) {
            return Linkify.addLinks(spannable, pattern, str, strArr, matchFilter, transformFilter);
        }
        if (str == null) {
            str = "";
        }
        if (strArr == null || strArr.length < 1) {
            strArr = a;
        }
        String[] strArr2 = new String[(strArr.length + 1)];
        strArr2[0] = str.toLowerCase(Locale.ROOT);
        int i = 0;
        while (i < strArr.length) {
            String str3 = strArr[i];
            i++;
            if (str3 == null) {
                str2 = "";
            } else {
                str2 = str3.toLowerCase(Locale.ROOT);
            }
            strArr2[i] = str2;
        }
        Matcher matcher = pattern.matcher(spannable);
        boolean z = false;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if (matchFilter != null ? matchFilter.acceptMatch(spannable, start, end) : true) {
                spannable.setSpan(new URLSpan(d(matcher.group(0), strArr2, matcher, transformFilter)), start, end, 33);
                z = true;
            }
        }
        return z;
    }
}
