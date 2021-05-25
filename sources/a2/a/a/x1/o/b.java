package a2.a.a.x1.o;

import a2.b.a.a.a;
import android.animation.ValueAnimator;
import com.avito.android.krop.util.ScaleAfterRotationStyle;
import com.avito.android.photo_picker.edit.EditPhotoFragment;
import kotlin.jvm.internal.Ref;
public final class b implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ EditPhotoFragment a;
    public final /* synthetic */ Ref.FloatRef b;
    public final /* synthetic */ float c;

    public b(EditPhotoFragment editPhotoFragment, Ref.FloatRef floatRef, float f) {
        this.a = editPhotoFragment;
        this.b = floatRef;
        this.c = f;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        float floatValue = ((Float) a.g2(valueAnimator, "updatedAnimation", "null cannot be cast to non-null type kotlin.Float")).floatValue();
        Ref.FloatRef floatRef = this.b;
        float f = floatValue - floatRef.element;
        floatRef.element = floatValue;
        EditPhotoFragment.access$getPhotoView$p(this.a).rotateBy(f, floatValue == this.c ? ScaleAfterRotationStyle.ANIMATE : ScaleAfterRotationStyle.NONE);
    }
}
