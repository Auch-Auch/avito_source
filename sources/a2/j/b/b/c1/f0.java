package a2.j.b.b.c1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.text.CaptionStyleCompat;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.ui.SubtitleView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public final class f0 extends View implements SubtitleView.a {
    public final List<j0> a = new ArrayList();
    public List<Cue> b = Collections.emptyList();
    public int c = 0;
    public float d = 0.0533f;
    public CaptionStyleCompat e = CaptionStyleCompat.DEFAULT;
    public float f = 0.08f;

    public f0(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f2, int i, float f3) {
        this.b = list;
        this.e = captionStyleCompat;
        this.d = f2;
        this.c = i;
        this.f = f3;
        while (this.a.size() < list.size()) {
            this.a.add(new j0(getContext()));
        }
        invalidate();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:166:0x03ef, code lost:
        if (r3 < r6) goto L_0x03ff;
     */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x03ea  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x03ed  */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x043e  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x04ae  */
    /* JADX WARNING: Removed duplicated region for block: B:184:0x04b0  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0203  */
    @Override // android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void dispatchDraw(android.graphics.Canvas r40) {
        /*
        // Method dump skipped, instructions count: 1254
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.j.b.b.c1.f0.dispatchDraw(android.graphics.Canvas):void");
    }
}
