package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.cardview.R;
import l6.d.a.b;
import l6.d.a.c;
import l6.d.a.d;
public class CardView extends FrameLayout {
    public static final int[] h = {16842801};
    public static final c i = new l6.d.a.a();
    public boolean a;
    public boolean b;
    public int c;
    public int d;
    public final Rect e;
    public final Rect f;
    public final b g;

    public class a implements b {
        public Drawable a;

        public a() {
        }

        public boolean a() {
            return CardView.this.getPreventCornerOverlap();
        }

        public void b(int i, int i2, int i3, int i4) {
            CardView.this.f.set(i, i2, i3, i4);
            CardView cardView = CardView.this;
            Rect rect = cardView.e;
            CardView.super.setPadding(i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
        }
    }

    public CardView(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return ((d) ((a) this.g).a).h;
    }

    public float getCardElevation() {
        return CardView.this.getElevation();
    }

    @Px
    public int getContentPaddingBottom() {
        return this.e.bottom;
    }

    @Px
    public int getContentPaddingLeft() {
        return this.e.left;
    }

    @Px
    public int getContentPaddingRight() {
        return this.e.right;
    }

    @Px
    public int getContentPaddingTop() {
        return this.e.top;
    }

    public float getMaxCardElevation() {
        return ((d) ((a) this.g).a).e;
    }

    public boolean getPreventCornerOverlap() {
        return this.b;
    }

    public float getRadius() {
        return ((d) ((a) this.g).a).a;
    }

    public boolean getUseCompatPadding() {
        return this.a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public void setCardBackgroundColor(@ColorInt int i2) {
        b bVar = this.g;
        ColorStateList valueOf = ColorStateList.valueOf(i2);
        d dVar = (d) ((a) bVar).a;
        dVar.b(valueOf);
        dVar.invalidateSelf();
    }

    public void setCardElevation(float f2) {
        CardView.this.setElevation(f2);
    }

    public void setContentPadding(@Px int i2, @Px int i3, @Px int i4, @Px int i5) {
        this.e.set(i2, i3, i4, i5);
        ((l6.d.a.a) i).c(this.g);
    }

    public void setMaxCardElevation(float f2) {
        ((l6.d.a.a) i).b(this.g, f2);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i2) {
        this.d = i2;
        super.setMinimumHeight(i2);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i2) {
        this.c = i2;
        super.setMinimumWidth(i2);
    }

    @Override // android.view.View
    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i2, int i3, int i4, int i5) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.b) {
            this.b = z;
            c cVar = i;
            b bVar = this.g;
            l6.d.a.a aVar = (l6.d.a.a) cVar;
            aVar.b(bVar, aVar.a(bVar).e);
        }
    }

    public void setRadius(float f2) {
        d dVar = (d) ((a) this.g).a;
        if (f2 != dVar.a) {
            dVar.a = f2;
            dVar.c(null);
            dVar.invalidateSelf();
        }
    }

    public void setUseCompatPadding(boolean z) {
        if (this.a != z) {
            this.a = z;
            c cVar = i;
            b bVar = this.g;
            l6.d.a.a aVar = (l6.d.a.a) cVar;
            aVar.b(bVar, aVar.a(bVar).e);
        }
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.cardViewStyle);
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        ColorStateList colorStateList;
        int i3;
        Rect rect = new Rect();
        this.e = rect;
        this.f = new Rect();
        a aVar = new a();
        this.g = aVar;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CardView, i2, R.style.CardView);
        int i4 = R.styleable.CardView_cardBackgroundColor;
        if (obtainStyledAttributes.hasValue(i4)) {
            colorStateList = obtainStyledAttributes.getColorStateList(i4);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(h);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            if (fArr[2] > 0.5f) {
                i3 = getResources().getColor(R.color.cardview_light_background);
            } else {
                i3 = getResources().getColor(R.color.cardview_dark_background);
            }
            colorStateList = ColorStateList.valueOf(i3);
        }
        float dimension = obtainStyledAttributes.getDimension(R.styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(R.styleable.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(R.styleable.CardView_cardMaxElevation, 0.0f);
        this.a = obtainStyledAttributes.getBoolean(R.styleable.CardView_cardUseCompatPadding, false);
        this.b = obtainStyledAttributes.getBoolean(R.styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPadding, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.c = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_android_minWidth, 0);
        this.d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        d dVar = new d(colorStateList, dimension);
        a aVar2 = aVar;
        aVar2.a = dVar;
        CardView.this.setBackgroundDrawable(dVar);
        CardView cardView = CardView.this;
        cardView.setClipToOutline(true);
        cardView.setElevation(dimension2);
        ((l6.d.a.a) i).b(aVar, dimension3);
    }

    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        d dVar = (d) ((a) this.g).a;
        dVar.b(colorStateList);
        dVar.invalidateSelf();
    }
}
