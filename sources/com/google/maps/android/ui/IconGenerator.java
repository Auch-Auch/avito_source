package com.google.maps.android.ui;

import a2.j.g.a.b.a;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.maps.android.R;
public class IconGenerator {
    public static final int STYLE_BLUE = 4;
    public static final int STYLE_DEFAULT = 1;
    public static final int STYLE_GREEN = 5;
    public static final int STYLE_ORANGE = 7;
    public static final int STYLE_PURPLE = 6;
    public static final int STYLE_RED = 3;
    public static final int STYLE_WHITE = 2;
    public final Context a;
    public ViewGroup b;
    public RotationLayout c;
    public TextView d;
    public View e;
    public int f;
    public float g = 0.5f;
    public float h = 1.0f;
    public a i;

    public IconGenerator(Context context) {
        this.a = context;
        this.i = new a(context.getResources());
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.amu_text_bubble, (ViewGroup) null);
        this.b = viewGroup;
        RotationLayout rotationLayout = (RotationLayout) viewGroup.getChildAt(0);
        this.c = rotationLayout;
        TextView textView = (TextView) rotationLayout.findViewById(R.id.amu_text);
        this.d = textView;
        this.e = textView;
        setStyle(1);
    }

    public final float a(float f2, float f3) {
        int i2 = this.f;
        if (i2 == 0) {
            return f2;
        }
        if (i2 == 1) {
            return 1.0f - f3;
        }
        if (i2 == 2) {
            return 1.0f - f2;
        }
        if (i2 == 3) {
            return f3;
        }
        throw new IllegalStateException();
    }

    public float getAnchorU() {
        return a(this.g, this.h);
    }

    public float getAnchorV() {
        return a(this.h, this.g);
    }

    public Bitmap makeIcon(CharSequence charSequence) {
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(charSequence);
        }
        return makeIcon();
    }

    public void setBackground(Drawable drawable) {
        this.b.setBackgroundDrawable(drawable);
        if (drawable != null) {
            Rect rect = new Rect();
            drawable.getPadding(rect);
            this.b.setPadding(rect.left, rect.top, rect.right, rect.bottom);
            return;
        }
        this.b.setPadding(0, 0, 0, 0);
    }

    public void setColor(int i2) {
        a aVar = this.i;
        aVar.c = i2;
        setBackground(aVar);
    }

    public void setContentPadding(int i2, int i3, int i4, int i5) {
        this.e.setPadding(i2, i3, i4, i5);
    }

    public void setContentRotation(int i2) {
        this.c.setViewRotation(i2);
    }

    public void setContentView(View view) {
        this.c.removeAllViews();
        this.c.addView(view);
        this.e = view;
        View findViewById = this.c.findViewById(R.id.amu_text);
        this.d = findViewById instanceof TextView ? (TextView) findViewById : null;
    }

    public void setRotation(int i2) {
        this.f = ((i2 + 360) % 360) / 90;
    }

    public void setStyle(int i2) {
        int i3;
        setColor(i2 != 3 ? i2 != 4 ? i2 != 5 ? i2 != 6 ? i2 != 7 ? -1 : -30720 : -6736948 : -10053376 : -16737844 : -3407872);
        Context context = this.a;
        if (i2 == 3 || i2 == 4 || i2 == 5 || i2 == 6 || i2 == 7) {
            i3 = R.style.amu_Bubble_TextAppearance_Light;
        } else {
            i3 = R.style.amu_Bubble_TextAppearance_Dark;
        }
        setTextAppearance(context, i3);
    }

    public void setTextAppearance(Context context, int i2) {
        TextView textView = this.d;
        if (textView != null) {
            textView.setTextAppearance(context, i2);
        }
    }

    public void setTextAppearance(int i2) {
        setTextAppearance(this.a, i2);
    }

    public Bitmap makeIcon() {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.b.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredWidth = this.b.getMeasuredWidth();
        int measuredHeight = this.b.getMeasuredHeight();
        this.b.layout(0, 0, measuredWidth, measuredHeight);
        int i2 = this.f;
        if (i2 == 1 || i2 == 3) {
            measuredHeight = this.b.getMeasuredWidth();
            measuredWidth = this.b.getMeasuredHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
        createBitmap.eraseColor(0);
        Canvas canvas = new Canvas(createBitmap);
        int i3 = this.f;
        if (i3 != 0) {
            if (i3 == 1) {
                canvas.translate((float) measuredWidth, 0.0f);
                canvas.rotate(90.0f);
            } else if (i3 == 2) {
                canvas.rotate(180.0f, (float) (measuredWidth / 2), (float) (measuredHeight / 2));
            } else {
                canvas.translate(0.0f, (float) measuredHeight);
                canvas.rotate(270.0f);
            }
        }
        this.b.draw(canvas);
        return createBitmap;
    }
}
