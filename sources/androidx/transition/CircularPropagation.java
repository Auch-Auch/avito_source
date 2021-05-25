package androidx.transition;

import android.graphics.Rect;
import android.view.ViewGroup;
public class CircularPropagation extends VisibilityPropagation {
    public float b = 3.0f;

    @Override // androidx.transition.TransitionPropagation
    public long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i;
        int i2;
        int i3;
        if (transitionValues == null && transitionValues2 == null) {
            return 0;
        }
        if (transitionValues2 == null || getViewVisibility(transitionValues) == 0) {
            i = -1;
        } else {
            transitionValues = transitionValues2;
            i = 1;
        }
        int viewX = getViewX(transitionValues);
        int viewY = getViewY(transitionValues);
        Rect epicenter = transition.getEpicenter();
        if (epicenter != null) {
            i3 = epicenter.centerX();
            i2 = epicenter.centerY();
        } else {
            int[] iArr = new int[2];
            viewGroup.getLocationOnScreen(iArr);
            int round = Math.round(viewGroup.getTranslationX() + ((float) ((viewGroup.getWidth() / 2) + iArr[0])));
            int i4 = iArr[1];
            i2 = Math.round(viewGroup.getTranslationY() + ((float) ((viewGroup.getHeight() / 2) + i4)));
            i3 = round;
        }
        float f = ((float) i3) - ((float) viewX);
        float f2 = ((float) i2) - ((float) viewY);
        float sqrt = (float) Math.sqrt((double) ((f2 * f2) + (f * f)));
        float width = ((float) viewGroup.getWidth()) - 0.0f;
        float height = ((float) viewGroup.getHeight()) - 0.0f;
        float sqrt2 = sqrt / ((float) Math.sqrt((double) ((height * height) + (width * width))));
        long duration = transition.getDuration();
        if (duration < 0) {
            duration = 300;
        }
        return (long) Math.round((((float) (duration * ((long) i))) / this.b) * sqrt2);
    }

    public void setPropagationSpeed(float f) {
        if (f != 0.0f) {
            this.b = f;
            return;
        }
        throw new IllegalArgumentException("propagationSpeed may not be 0");
    }
}
