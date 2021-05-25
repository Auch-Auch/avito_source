package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.utils.widget.ImageFilterView;
import androidx.constraintlayout.widget.R;
public class ImageFilterButton extends AppCompatImageButton {
    public ImageFilterView.c c = new ImageFilterView.c();
    public float d = 0.0f;
    public float e = 0.0f;
    public float f = Float.NaN;
    public Path g;
    public ViewOutlineProvider h;
    public RectF i;
    public Drawable[] j;
    public LayerDrawable k;
    public boolean l = true;

    public class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            int width = ImageFilterButton.this.getWidth();
            int height = ImageFilterButton.this.getHeight();
            outline.setRoundRect(0, 0, width, height, (((float) Math.min(width, height)) * ImageFilterButton.this.e) / 2.0f);
        }
    }

    public class b extends ViewOutlineProvider {
        public b() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterButton.this.getWidth(), ImageFilterButton.this.getHeight(), ImageFilterButton.this.f);
        }
    }

    public ImageFilterButton(Context context) {
        super(context);
        a(null);
    }

    private void setOverlay(boolean z) {
        this.l = z;
    }

    public final void a(AttributeSet attributeSet) {
        setPadding(0, 0, 0, 0);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i2 = 0; i2 < indexCount; i2++) {
                int index = obtainStyledAttributes.getIndex(i2);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.d = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_round) {
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.l));
                }
            }
            obtainStyledAttributes.recycle();
            if (drawable != null) {
                Drawable[] drawableArr = new Drawable[2];
                this.j = drawableArr;
                drawableArr[0] = getDrawable();
                this.j[1] = drawable;
                LayerDrawable layerDrawable = new LayerDrawable(this.j);
                this.k = layerDrawable;
                layerDrawable.getDrawable(1).setAlpha((int) (this.d * 255.0f));
                super.setImageDrawable(this.k);
            }
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (0 != 0) {
            canvas.restore();
        }
    }

    public float getContrast() {
        return this.c.f;
    }

    public float getCrossfade() {
        return this.d;
    }

    public float getRound() {
        return this.f;
    }

    public float getRoundPercent() {
        return this.e;
    }

    public float getSaturation() {
        return this.c.e;
    }

    public float getWarmth() {
        return this.c.g;
    }

    public void setBrightness(float f2) {
        ImageFilterView.c cVar = this.c;
        cVar.d = f2;
        cVar.a(this);
    }

    public void setContrast(float f2) {
        ImageFilterView.c cVar = this.c;
        cVar.f = f2;
        cVar.a(this);
    }

    public void setCrossfade(float f2) {
        this.d = f2;
        if (this.j != null) {
            if (!this.l) {
                this.k.getDrawable(0).setAlpha((int) ((1.0f - this.d) * 255.0f));
            }
            this.k.getDrawable(1).setAlpha((int) (this.d * 255.0f));
            super.setImageDrawable(this.k);
        }
    }

    @RequiresApi(21)
    public void setRound(float f2) {
        if (Float.isNaN(f2)) {
            this.f = f2;
            float f3 = this.e;
            this.e = -1.0f;
            setRoundPercent(f3);
            return;
        }
        boolean z = this.f != f2;
        this.f = f2;
        if (f2 != 0.0f) {
            if (this.g == null) {
                this.g = new Path();
            }
            if (this.i == null) {
                this.i = new RectF();
            }
            if (this.h == null) {
                b bVar = new b();
                this.h = bVar;
                setOutlineProvider(bVar);
            }
            setClipToOutline(true);
            this.i.set(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
            this.g.reset();
            Path path = this.g;
            RectF rectF = this.i;
            float f4 = this.f;
            path.addRoundRect(rectF, f4, f4, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    @RequiresApi(21)
    public void setRoundPercent(float f2) {
        boolean z = this.e != f2;
        this.e = f2;
        if (f2 != 0.0f) {
            if (this.g == null) {
                this.g = new Path();
            }
            if (this.i == null) {
                this.i = new RectF();
            }
            if (this.h == null) {
                a aVar = new a();
                this.h = aVar;
                setOutlineProvider(aVar);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (((float) Math.min(width, height)) * this.e) / 2.0f;
            this.i.set(0.0f, 0.0f, (float) width, (float) height);
            this.g.reset();
            this.g.addRoundRect(this.i, min, min, Path.Direction.CW);
        } else {
            setClipToOutline(false);
        }
        if (z) {
            invalidateOutline();
        }
    }

    public void setSaturation(float f2) {
        ImageFilterView.c cVar = this.c;
        cVar.e = f2;
        cVar.a(this);
    }

    public void setWarmth(float f2) {
        ImageFilterView.c cVar = this.c;
        cVar.g = f2;
        cVar.a(this);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public ImageFilterButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }
}
