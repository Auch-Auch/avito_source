package l6.z;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.view.ViewCompat;
import androidx.transition.R;
@SuppressLint({"ViewConstructor"})
public class f extends ViewGroup implements c {
    public static final /* synthetic */ int g = 0;
    public ViewGroup a;
    public View b;
    public final View c;
    public int d;
    @Nullable
    public Matrix e;
    public final ViewTreeObserver.OnPreDrawListener f = new a();

    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            View view;
            ViewCompat.postInvalidateOnAnimation(f.this);
            f fVar = f.this;
            ViewGroup viewGroup = fVar.a;
            if (viewGroup == null || (view = fVar.b) == null) {
                return true;
            }
            viewGroup.endViewTransition(view);
            ViewCompat.postInvalidateOnAnimation(f.this.a);
            f fVar2 = f.this;
            fVar2.a = null;
            fVar2.b = null;
            return true;
        }
    }

    public f(View view) {
        super(view.getContext());
        this.c = view;
        setWillNotDraw(false);
        setLayerType(2, null);
    }

    public static void b(View view, View view2) {
        p.b(view2, view2.getLeft(), view2.getTop(), view.getWidth() + view2.getLeft(), view.getHeight() + view2.getTop());
    }

    public static f c(View view) {
        return (f) view.getTag(R.id.ghost_view);
    }

    @Override // l6.z.c
    public void a(ViewGroup viewGroup, View view) {
        this.a = viewGroup;
        this.b = view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.c.setTag(R.id.ghost_view, this);
        this.c.getViewTreeObserver().addOnPreDrawListener(this.f);
        p.a.g(this.c, 4);
        if (this.c.getParent() != null) {
            ((View) this.c.getParent()).invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.c.getViewTreeObserver().removeOnPreDrawListener(this.f);
        p.a.g(this.c, 0);
        this.c.setTag(R.id.ghost_view, null);
        if (this.c.getParent() != null) {
            ((View) this.c.getParent()).invalidate();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        AppCompatDelegateImpl.i.h0(canvas, true);
        canvas.setMatrix(this.e);
        View view = this.c;
        v vVar = p.a;
        vVar.g(view, 0);
        this.c.invalidate();
        vVar.g(this.c, 4);
        drawChild(canvas, this.c, getDrawingTime());
        AppCompatDelegateImpl.i.h0(canvas, false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View, l6.z.c
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (c(this.c) == this) {
            p.a.g(this.c, i == 0 ? 4 : 0);
        }
    }
}
