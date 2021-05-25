package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.R;
public class MockView extends View {
    public Paint a = new Paint();
    public Paint b = new Paint();
    public Paint c = new Paint();
    public boolean d = true;
    public boolean e = true;
    public Rect f = new Rect();
    public int g = Color.argb(255, 0, 0, 0);
    public int h = Color.argb(255, 200, 200, 200);
    public int i = Color.argb(255, 50, 50, 50);
    public int j = 4;
    public String mText = null;

    public MockView(Context context) {
        super(context);
        a(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MockView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.MockView_mock_label) {
                    this.mText = obtainStyledAttributes.getString(index);
                } else if (index == R.styleable.MockView_mock_showDiagonals) {
                    this.d = obtainStyledAttributes.getBoolean(index, this.d);
                } else if (index == R.styleable.MockView_mock_diagonalsColor) {
                    this.g = obtainStyledAttributes.getColor(index, this.g);
                } else if (index == R.styleable.MockView_mock_labelBackgroundColor) {
                    this.i = obtainStyledAttributes.getColor(index, this.i);
                } else if (index == R.styleable.MockView_mock_labelColor) {
                    this.h = obtainStyledAttributes.getColor(index, this.h);
                } else if (index == R.styleable.MockView_mock_showLabel) {
                    this.e = obtainStyledAttributes.getBoolean(index, this.e);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.mText == null) {
            try {
                this.mText = context.getResources().getResourceEntryName(getId());
            } catch (Exception unused) {
            }
        }
        this.a.setColor(this.g);
        this.a.setAntiAlias(true);
        this.b.setColor(this.h);
        this.b.setAntiAlias(true);
        this.c.setColor(this.i);
        this.j = Math.round((getResources().getDisplayMetrics().xdpi / 160.0f) * ((float) this.j));
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.d) {
            width--;
            height--;
            float f2 = (float) width;
            float f3 = (float) height;
            canvas.drawLine(0.0f, 0.0f, f2, f3, this.a);
            canvas.drawLine(0.0f, f3, f2, 0.0f, this.a);
            canvas.drawLine(0.0f, 0.0f, f2, 0.0f, this.a);
            canvas.drawLine(f2, 0.0f, f2, f3, this.a);
            canvas.drawLine(f2, f3, 0.0f, f3, this.a);
            canvas.drawLine(0.0f, f3, 0.0f, 0.0f, this.a);
        }
        String str = this.mText;
        if (str != null && this.e) {
            this.b.getTextBounds(str, 0, str.length(), this.f);
            float width2 = ((float) (width - this.f.width())) / 2.0f;
            float height2 = (((float) (height - this.f.height())) / 2.0f) + ((float) this.f.height());
            this.f.offset((int) width2, (int) height2);
            Rect rect = this.f;
            int i2 = rect.left;
            int i3 = this.j;
            rect.set(i2 - i3, rect.top - i3, rect.right + i3, rect.bottom + i3);
            canvas.drawRect(this.f, this.c);
            canvas.drawText(this.mText, width2, height2, this.b);
        }
    }

    public MockView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public MockView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }
}
