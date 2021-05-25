package a2.j.b.b.a1.h;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.ttml.TtmlStyle;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;
public final class d implements Subtitle {
    public final b a;
    public final long[] b;
    public final Map<String, TtmlStyle> c;
    public final Map<String, c> d;
    public final Map<String, String> e;

    public d(b bVar, Map<String, TtmlStyle> map, Map<String, c> map2, Map<String, String> map3) {
        this.a = bVar;
        this.d = map2;
        this.e = map3;
        this.c = Collections.unmodifiableMap(map);
        Objects.requireNonNull(bVar);
        TreeSet<Long> treeSet = new TreeSet<>();
        int i = 0;
        bVar.e(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = it.next().longValue();
            i++;
        }
        this.b = jArr;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long j) {
        b bVar = this.a;
        Map<String, TtmlStyle> map = this.c;
        Map<String, c> map2 = this.d;
        Map<String, String> map3 = this.e;
        Objects.requireNonNull(bVar);
        ArrayList arrayList = new ArrayList();
        bVar.h(j, bVar.h, arrayList);
        TreeMap treeMap = new TreeMap();
        bVar.j(j, false, bVar.h, treeMap);
        bVar.i(j, map, treeMap);
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            String str = map3.get(pair.second);
            if (str != null) {
                byte[] decode = Base64.decode(str, 0);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
                c cVar = (c) Assertions.checkNotNull(map2.get(pair.first));
                arrayList2.add(new Cue.Builder().setBitmap(decodeByteArray).setPosition(cVar.b).setPositionAnchor(0).setLine(cVar.c, 0).setLineAnchor(cVar.e).setSize(cVar.f).setBitmapHeight(cVar.g).setVerticalType(cVar.j).build());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            c cVar2 = (c) Assertions.checkNotNull(map2.get(entry.getKey()));
            Cue.Builder builder = (Cue.Builder) entry.getValue();
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) Assertions.checkNotNull(builder.getText());
            a[] aVarArr = (a[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), a.class);
            for (a aVar : aVarArr) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(aVar), spannableStringBuilder.getSpanEnd(aVar), (CharSequence) "");
            }
            for (int i = 0; i < spannableStringBuilder.length(); i++) {
                if (spannableStringBuilder.charAt(i) == ' ') {
                    int i2 = i + 1;
                    int i3 = i2;
                    while (i3 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i3) == ' ') {
                        i3++;
                    }
                    int i4 = i3 - i2;
                    if (i4 > 0) {
                        spannableStringBuilder.delete(i, i4 + i);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
            }
            for (int i5 = 0; i5 < spannableStringBuilder.length() - 1; i5++) {
                if (spannableStringBuilder.charAt(i5) == '\n') {
                    int i6 = i5 + 1;
                    if (spannableStringBuilder.charAt(i6) == ' ') {
                        spannableStringBuilder.delete(i6, i5 + 2);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            for (int i7 = 0; i7 < spannableStringBuilder.length() - 1; i7++) {
                if (spannableStringBuilder.charAt(i7) == ' ') {
                    int i8 = i7 + 1;
                    if (spannableStringBuilder.charAt(i8) == '\n') {
                        spannableStringBuilder.delete(i7, i8);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            builder.setLine(cVar2.c, cVar2.d);
            builder.setLineAnchor(cVar2.e);
            builder.setPosition(cVar2.b);
            builder.setSize(cVar2.f);
            builder.setTextSize(cVar2.i, cVar2.h);
            builder.setVerticalType(cVar2.j);
            arrayList2.add(builder.build());
        }
        return arrayList2;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        return this.b[i];
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.b.length;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        int binarySearchCeil = Util.binarySearchCeil(this.b, j, false, false);
        if (binarySearchCeil < this.b.length) {
            return binarySearchCeil;
        }
        return -1;
    }
}
