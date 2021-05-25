package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import l6.z.n;
public class Explode extends Visibility {
    public static final TimeInterpolator M = new DecelerateInterpolator();
    public static final TimeInterpolator N = new AccelerateInterpolator();
    public int[] L;

    public Explode() {
        this.L = new int[2];
        setPropagation(new CircularPropagation());
    }

    @Override // androidx.transition.Visibility
    private void o(TransitionValues transitionValues) {
        View view = transitionValues.view;
        view.getLocationOnScreen(this.L);
        int[] iArr = this.L;
        int i = iArr[0];
        int i2 = iArr[1];
        transitionValues.values.put("android:explode:screenBounds", new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2));
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        o(transitionValues);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        o(transitionValues);
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues2.values.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        q(viewGroup, rect, this.L);
        int[] iArr = this.L;
        return n.a(view, transitionValues2, rect.left, rect.top, translationX + ((float) iArr[0]), translationY + ((float) iArr[1]), translationX, translationY, M, this);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f;
        float f2;
        if (transitionValues == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues.values.get("android:explode:screenBounds");
        int i = rect.left;
        int i2 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.view.getTag(R.id.transition_position);
        if (iArr != null) {
            f2 = ((float) (iArr[0] - rect.left)) + translationX;
            f = ((float) (iArr[1] - rect.top)) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f2 = translationX;
            f = translationY;
        }
        q(viewGroup, rect, this.L);
        int[] iArr2 = this.L;
        return n.a(view, transitionValues, i, i2, translationX, translationY, f2 + ((float) iArr2[0]), f + ((float) iArr2[1]), N, this);
    }

    public final void q(View view, Rect rect, int[] iArr) {
        int i;
        int i2;
        view.getLocationOnScreen(this.L);
        int[] iArr2 = this.L;
        int i3 = iArr2[0];
        int i4 = iArr2[1];
        Rect epicenter = getEpicenter();
        if (epicenter == null) {
            i2 = Math.round(view.getTranslationX()) + (view.getWidth() / 2) + i3;
            i = Math.round(view.getTranslationY()) + (view.getHeight() / 2) + i4;
        } else {
            i2 = epicenter.centerX();
            i = epicenter.centerY();
        }
        float centerX = (float) (rect.centerX() - i2);
        float centerY = (float) (rect.centerY() - i);
        if (centerX == 0.0f && centerY == 0.0f) {
            centerX = ((float) (Math.random() * 2.0d)) - 1.0f;
            centerY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float sqrt = (float) Math.sqrt((double) ((centerY * centerY) + (centerX * centerX)));
        int i5 = i2 - i3;
        int i6 = i - i4;
        float max = (float) Math.max(i5, view.getWidth() - i5);
        float max2 = (float) Math.max(i6, view.getHeight() - i6);
        float sqrt2 = (float) Math.sqrt((double) ((max2 * max2) + (max * max)));
        iArr[0] = Math.round((centerX / sqrt) * sqrt2);
        iArr[1] = Math.round(sqrt2 * (centerY / sqrt));
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.L = new int[2];
        setPropagation(new CircularPropagation());
    }
}
