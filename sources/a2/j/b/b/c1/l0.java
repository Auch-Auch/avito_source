package a2.j.b.b.c1;

import android.content.Context;
import android.text.Layout;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.ui.SubtitleView;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public final class l0 extends FrameLayout implements SubtitleView.a {
    public final f0 a;
    public final WebView b;
    public List<Cue> c = Collections.emptyList();
    public CaptionStyleCompat d = CaptionStyleCompat.DEFAULT;
    public float e = 0.0533f;
    public int f = 0;
    public float g = 0.08f;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public l0(Context context) {
        super(context, null);
        f0 f0Var = new f0(context, null);
        this.a = f0Var;
        k0 k0Var = new k0(this, context, null);
        this.b = k0Var;
        k0Var.setBackgroundColor(0);
        addView(f0Var);
        addView(k0Var);
    }

    public static int b(int i) {
        if (i != 1) {
            return i != 2 ? 0 : -100;
        }
        return -50;
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f2, int i, float f3) {
        this.d = captionStyleCompat;
        this.e = f2;
        this.f = i;
        this.g = f3;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            Cue cue = list.get(i2);
            if (cue.bitmap != null) {
                arrayList.add(cue);
            } else {
                arrayList2.add(cue);
            }
        }
        if (!this.c.isEmpty() || !arrayList2.isEmpty()) {
            this.c = arrayList2;
            d();
        }
        this.a.a(arrayList, captionStyleCompat, f2, i, f3);
        invalidate();
    }

    public final String c(int i, float f2) {
        float S1 = AppCompatDelegateImpl.i.S1(i, f2, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        if (S1 == -3.4028235E38f) {
            return "unset";
        }
        return Util.formatInvariant("%.2fpx", Float.valueOf(S1 / getContext().getResources().getDisplayMetrics().density));
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x007d: APUT  (r3v0 java.lang.Object[]), (3 ??[int, float, short, byte, char]), (r2v1 java.lang.String) */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x03e3, code lost:
        if (((android.text.style.TypefaceSpan) r9).getFamily() != null) goto L_0x042f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01c3, code lost:
        if (r12 != false) goto L_0x01ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01c6, code lost:
        if (r12 != false) goto L_0x01c8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x043b  */
    /* JADX WARNING: Removed duplicated region for block: B:201:0x0514  */
    /* JADX WARNING: Removed duplicated region for block: B:220:0x0475 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0168  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0194  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01a2  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01ba  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x01d1  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x01f8  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0209  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
        // Method dump skipped, instructions count: 1548
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.b.b.c1.l0.d():void");
    }

    @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z && !this.c.isEmpty()) {
            d();
        }
    }
}
