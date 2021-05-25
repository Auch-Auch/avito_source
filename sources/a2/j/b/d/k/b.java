package a2.j.b.d.k;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import java.util.ArrayList;
public abstract class b implements k {
    public final Context a;
    @NonNull
    public final ExtendedFloatingActionButton b;
    public final ArrayList<Animator.AnimatorListener> c = new ArrayList<>();
    public final a d;
    @Nullable
    public MotionSpec e;
    @Nullable
    public MotionSpec f;

    public class a extends Property<ExtendedFloatingActionButton, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
            ExtendedFloatingActionButton extendedFloatingActionButton2 = extendedFloatingActionButton;
            return Float.valueOf(AnimationUtils.lerp(0.0f, 1.0f, (((float) Color.alpha(extendedFloatingActionButton2.getCurrentTextColor())) / 255.0f) / ((float) Color.alpha(extendedFloatingActionButton2.originalTextCsl.getColorForState(extendedFloatingActionButton2.getDrawableState(), b.this.b.originalTextCsl.getDefaultColor())))));
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f) {
            ExtendedFloatingActionButton extendedFloatingActionButton2 = extendedFloatingActionButton;
            Float f2 = f;
            int colorForState = extendedFloatingActionButton2.originalTextCsl.getColorForState(extendedFloatingActionButton2.getDrawableState(), b.this.b.originalTextCsl.getDefaultColor());
            ColorStateList valueOf = ColorStateList.valueOf(Color.argb((int) (AnimationUtils.lerp(0.0f, ((float) Color.alpha(colorForState)) / 255.0f, f2.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
            if (f2.floatValue() == 1.0f) {
                extendedFloatingActionButton2.silentlyUpdateTextColor(extendedFloatingActionButton2.originalTextCsl);
            } else {
                extendedFloatingActionButton2.silentlyUpdateTextColor(valueOf);
            }
        }
    }

    public b(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton, a aVar) {
        this.b = extendedFloatingActionButton;
        this.a = extendedFloatingActionButton.getContext();
        this.d = aVar;
    }

    @Override // a2.j.b.d.k.k
    public AnimatorSet c() {
        return h(i());
    }

    @Override // a2.j.b.d.k.k
    @CallSuper
    public void f() {
        this.d.a = null;
    }

    @Override // a2.j.b.d.k.k
    @CallSuper
    public void g() {
        this.d.a = null;
    }

    @NonNull
    public AnimatorSet h(@NonNull MotionSpec motionSpec) {
        ArrayList arrayList = new ArrayList();
        if (motionSpec.hasPropertyValues("opacity")) {
            arrayList.add(motionSpec.getAnimator("opacity", this.b, View.ALPHA));
        }
        if (motionSpec.hasPropertyValues("scale")) {
            arrayList.add(motionSpec.getAnimator("scale", this.b, View.SCALE_Y));
            arrayList.add(motionSpec.getAnimator("scale", this.b, View.SCALE_X));
        }
        if (motionSpec.hasPropertyValues(ViewHierarchyConstants.DIMENSION_WIDTH_KEY)) {
            arrayList.add(motionSpec.getAnimator(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, this.b, ExtendedFloatingActionButton.G));
        }
        if (motionSpec.hasPropertyValues(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY)) {
            arrayList.add(motionSpec.getAnimator(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, this.b, ExtendedFloatingActionButton.H));
        }
        if (motionSpec.hasPropertyValues("paddingStart")) {
            arrayList.add(motionSpec.getAnimator("paddingStart", this.b, ExtendedFloatingActionButton.I));
        }
        if (motionSpec.hasPropertyValues("paddingEnd")) {
            arrayList.add(motionSpec.getAnimator("paddingEnd", this.b, ExtendedFloatingActionButton.J));
        }
        if (motionSpec.hasPropertyValues("labelOpacity")) {
            arrayList.add(motionSpec.getAnimator("labelOpacity", this.b, new a(Float.class, "LABEL_OPACITY_PROPERTY")));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    public final MotionSpec i() {
        MotionSpec motionSpec = this.f;
        if (motionSpec != null) {
            return motionSpec;
        }
        if (this.e == null) {
            this.e = MotionSpec.createFromResource(this.a, b());
        }
        return (MotionSpec) Preconditions.checkNotNull(this.e);
    }

    @Override // a2.j.b.d.k.k
    @CallSuper
    public void onAnimationStart(Animator animator) {
        a aVar = this.d;
        Animator animator2 = aVar.a;
        if (animator2 != null) {
            animator2.cancel();
        }
        aVar.a = animator;
    }
}
