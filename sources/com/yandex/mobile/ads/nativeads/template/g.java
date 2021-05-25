package com.yandex.mobile.ads.nativeads.template;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.widget.TextView;
import com.yandex.mobile.ads.impl.dv;
import com.yandex.mobile.ads.impl.eg;
public final class g extends TextView {
    private Rect a = new Rect();
    private Paint b = new Paint();
    private int c = dv.a(getContext(), 1.0f);
    private int d = dv.a(getContext(), 4.0f);

    public g(Context context) {
        super(context);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas canvas) {
        int a3 = eg.a(getCurrentTextColor(), 85.0f);
        Paint paint = this.b;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth((float) this.c);
        paint.setColor(a3);
        int lineCount = getLineCount();
        Layout layout = getLayout();
        for (int i = 0; i < lineCount; i++) {
            int lineBounds = getLineBounds(i, this.a);
            int lineStart = layout.getLineStart(i);
            int lineEnd = layout.getLineEnd(i);
            float primaryHorizontal = layout.getPrimaryHorizontal(lineStart);
            float primaryHorizontal2 = layout.getPrimaryHorizontal(lineEnd - 1) + (layout.getPrimaryHorizontal(lineStart + 1) - primaryHorizontal);
            int i2 = this.d;
            canvas.drawLine(primaryHorizontal, (float) (lineBounds + i2), primaryHorizontal2, (float) (lineBounds + i2), paint);
        }
        super.onDraw(canvas);
    }
}
