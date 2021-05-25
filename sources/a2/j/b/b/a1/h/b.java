package a2.j.b.b.a1.h;

import android.text.SpannableStringBuilder;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.ttml.TtmlStyle;
import com.google.android.exoplayer2.util.Assertions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
public final class b {
    @Nullable
    public final String a;
    @Nullable
    public final String b;
    public final boolean c;
    public final long d;
    public final long e;
    @Nullable
    public final TtmlStyle f;
    @Nullable
    public final String[] g;
    public final String h;
    @Nullable
    public final String i;
    @Nullable
    public final b j;
    public final HashMap<String, Integer> k;
    public final HashMap<String, Integer> l;
    public List<b> m;

    public b(@Nullable String str, @Nullable String str2, long j2, long j3, @Nullable TtmlStyle ttmlStyle, @Nullable String[] strArr, String str3, @Nullable String str4, @Nullable b bVar) {
        this.a = str;
        this.b = str2;
        this.i = str4;
        this.f = ttmlStyle;
        this.g = strArr;
        this.c = str2 != null;
        this.d = j2;
        this.e = j3;
        this.h = (String) Assertions.checkNotNull(str3);
        this.j = bVar;
        this.k = new HashMap<>();
        this.l = new HashMap<>();
    }

    public static b b(String str) {
        return new b(null, str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), C.TIME_UNSET, C.TIME_UNSET, null, null, "", null, null);
    }

    public static SpannableStringBuilder f(String str, Map<String, Cue.Builder> map) {
        if (!map.containsKey(str)) {
            Cue.Builder builder = new Cue.Builder();
            builder.setText(new SpannableStringBuilder());
            map.put(str, builder);
        }
        return (SpannableStringBuilder) Assertions.checkNotNull(map.get(str).getText());
    }

    public void a(b bVar) {
        if (this.m == null) {
            this.m = new ArrayList();
        }
        this.m.add(bVar);
    }

    public b c(int i2) {
        List<b> list = this.m;
        if (list != null) {
            return list.get(i2);
        }
        throw new IndexOutOfBoundsException();
    }

    public int d() {
        List<b> list = this.m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final void e(TreeSet<Long> treeSet, boolean z) {
        boolean equals = "p".equals(this.a);
        boolean equals2 = "div".equals(this.a);
        if (z || equals || (equals2 && this.i != null)) {
            long j2 = this.d;
            if (j2 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j2));
            }
            long j3 = this.e;
            if (j3 != C.TIME_UNSET) {
                treeSet.add(Long.valueOf(j3));
            }
        }
        if (this.m != null) {
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                this.m.get(i2).e(treeSet, z || equals);
            }
        }
    }

    public boolean g(long j2) {
        long j3 = this.d;
        return (j3 == C.TIME_UNSET && this.e == C.TIME_UNSET) || (j3 <= j2 && this.e == C.TIME_UNSET) || ((j3 == C.TIME_UNSET && j2 < this.e) || (j3 <= j2 && j2 < this.e));
    }

    public final void h(long j2, String str, List<Pair<String, String>> list) {
        if (!"".equals(this.h)) {
            str = this.h;
        }
        if (!g(j2) || !"div".equals(this.a) || this.i == null) {
            for (int i2 = 0; i2 < d(); i2++) {
                c(i2).h(j2, str, list);
            }
            return;
        }
        list.add(new Pair<>(str, this.i));
    }

    /* JADX WARNING: Removed duplicated region for block: B:88:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01c9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(long r17, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.ttml.TtmlStyle> r19, java.util.Map<java.lang.String, com.google.android.exoplayer2.text.Cue.Builder> r20) {
        /*
        // Method dump skipped, instructions count: 498
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.b.b.a1.h.b.i(long, java.util.Map, java.util.Map):void");
    }

    public final void j(long j2, boolean z, String str, Map<String, Cue.Builder> map) {
        this.k.clear();
        this.l.clear();
        if (!"metadata".equals(this.a)) {
            if (!"".equals(this.h)) {
                str = this.h;
            }
            if (this.c && z) {
                f(str, map).append((CharSequence) Assertions.checkNotNull(this.b));
            } else if ("br".equals(this.a) && z) {
                f(str, map).append('\n');
            } else if (g(j2)) {
                for (Map.Entry<String, Cue.Builder> entry : map.entrySet()) {
                    this.k.put(entry.getKey(), Integer.valueOf(((CharSequence) Assertions.checkNotNull(entry.getValue().getText())).length()));
                }
                boolean equals = "p".equals(this.a);
                for (int i2 = 0; i2 < d(); i2++) {
                    c(i2).j(j2, z || equals, str, map);
                }
                if (equals) {
                    SpannableStringBuilder f2 = f(str, map);
                    int length = f2.length();
                    do {
                        length--;
                        if (length < 0) {
                            break;
                        }
                    } while (f2.charAt(length) == ' ');
                    if (length >= 0 && f2.charAt(length) != '\n') {
                        f2.append('\n');
                    }
                }
                for (Map.Entry<String, Cue.Builder> entry2 : map.entrySet()) {
                    this.l.put(entry2.getKey(), Integer.valueOf(((CharSequence) Assertions.checkNotNull(entry2.getValue().getText())).length()));
                }
            }
        }
    }
}
