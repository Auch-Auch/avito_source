package com.transitionseverywhere;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import com.transitionseverywhere.utils.IntProperty;
public class Recolor extends Transition {
    @NonNull
    public static final Property<ColorDrawable, Integer> COLORDRAWABLE_COLOR = new b().optimize();
    public static final String[] J = {"android:recolor:background", "android:recolor:textColor"};
    @NonNull
    public static final Property<TextView, Integer> TEXTVIEW_TEXT_COLOR = new a().optimize();

    public Recolor() {
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        o(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        o(transitionValues);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0063  */
    @Override // androidx.transition.Transition
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator createAnimator(@androidx.annotation.NonNull android.view.ViewGroup r10, @androidx.annotation.Nullable androidx.transition.TransitionValues r11, @androidx.annotation.Nullable androidx.transition.TransitionValues r12) {
        /*
            r9 = this;
            r10 = 0
            if (r11 == 0) goto L_0x009c
            if (r12 != 0) goto L_0x0007
            goto L_0x009c
        L_0x0007:
            android.view.View r0 = r12.view
            java.util.Map<java.lang.String, java.lang.Object> r1 = r11.values
            java.lang.String r2 = "android:recolor:background"
            java.lang.Object r1 = r1.get(r2)
            android.graphics.drawable.Drawable r1 = (android.graphics.drawable.Drawable) r1
            java.util.Map<java.lang.String, java.lang.Object> r3 = r12.values
            java.lang.Object r2 = r3.get(r2)
            android.graphics.drawable.Drawable r2 = (android.graphics.drawable.Drawable) r2
            boolean r3 = r1 instanceof android.graphics.drawable.ColorDrawable
            r4 = 1
            r5 = 0
            r6 = 2
            if (r3 == 0) goto L_0x005e
            boolean r3 = r2 instanceof android.graphics.drawable.ColorDrawable
            if (r3 == 0) goto L_0x005e
            android.graphics.drawable.ColorDrawable r1 = (android.graphics.drawable.ColorDrawable) r1
            android.graphics.drawable.ColorDrawable r2 = (android.graphics.drawable.ColorDrawable) r2
            int r3 = r1.getColor()
            int r7 = r2.getColor()
            if (r3 == r7) goto L_0x005e
            int r3 = r2.getColor()
            android.graphics.drawable.Drawable r2 = r2.mutate()
            android.graphics.drawable.ColorDrawable r2 = (android.graphics.drawable.ColorDrawable) r2
            int r7 = r1.getColor()
            r2.setColor(r7)
            android.util.Property<android.graphics.drawable.ColorDrawable, java.lang.Integer> r7 = com.transitionseverywhere.Recolor.COLORDRAWABLE_COLOR
            int[] r8 = new int[r6]
            int r1 = r1.getColor()
            r8[r5] = r1
            r8[r4] = r3
            android.animation.ObjectAnimator r1 = android.animation.ObjectAnimator.ofInt(r2, r7, r8)
            android.animation.ArgbEvaluator r2 = new android.animation.ArgbEvaluator
            r2.<init>()
            r1.setEvaluator(r2)
            goto L_0x005f
        L_0x005e:
            r1 = r10
        L_0x005f:
            boolean r2 = r0 instanceof android.widget.TextView
            if (r2 == 0) goto L_0x0098
            android.widget.TextView r0 = (android.widget.TextView) r0
            java.util.Map<java.lang.String, java.lang.Object> r11 = r11.values
            java.lang.String r2 = "android:recolor:textColor"
            java.lang.Object r11 = r11.get(r2)
            java.lang.Integer r11 = (java.lang.Integer) r11
            int r11 = r11.intValue()
            java.util.Map<java.lang.String, java.lang.Object> r12 = r12.values
            java.lang.Object r12 = r12.get(r2)
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            if (r11 == r12) goto L_0x0098
            r0.setTextColor(r12)
            android.util.Property<android.widget.TextView, java.lang.Integer> r10 = com.transitionseverywhere.Recolor.TEXTVIEW_TEXT_COLOR
            int[] r2 = new int[r6]
            r2[r5] = r11
            r2[r4] = r12
            android.animation.ObjectAnimator r10 = android.animation.ObjectAnimator.ofInt(r0, r10, r2)
            android.animation.ArgbEvaluator r11 = new android.animation.ArgbEvaluator
            r11.<init>()
            r10.setEvaluator(r11)
        L_0x0098:
            android.animation.Animator r10 = com.transitionseverywhere.utils.TransitionUtils.mergeAnimators(r1, r10)
        L_0x009c:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transitionseverywhere.Recolor.createAnimator(android.view.ViewGroup, androidx.transition.TransitionValues, androidx.transition.TransitionValues):android.animation.Animator");
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return J;
    }

    public final void o(TransitionValues transitionValues) {
        transitionValues.values.put("android:recolor:background", transitionValues.view.getBackground());
        View view = transitionValues.view;
        if (view instanceof TextView) {
            transitionValues.values.put("android:recolor:textColor", Integer.valueOf(((TextView) view).getCurrentTextColor()));
        }
    }

    public class a extends IntProperty<TextView> {
        @Override // com.transitionseverywhere.utils.IntProperty, android.util.Property
        @NonNull
        /* renamed from: get */
        public Integer mo239get(Object obj) {
            TextView textView = (TextView) obj;
            return 0;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
        @Override // com.transitionseverywhere.utils.IntProperty
        public void setValue(@NonNull TextView textView, int i) {
            textView.setTextColor(i);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.transitionseverywhere.utils.IntProperty, android.util.Property
        @NonNull
        /* renamed from: get  reason: collision with other method in class */
        public Integer mo239get(Object obj) {
            TextView textView = (TextView) obj;
            return 0;
        }
    }

    public class b extends IntProperty<ColorDrawable> {
        @Override // com.transitionseverywhere.utils.IntProperty, android.util.Property
        @NonNull
        /* renamed from: get */
        public Integer mo239get(@NonNull Object obj) {
            return Integer.valueOf(((ColorDrawable) obj).getColor());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, int] */
        @Override // com.transitionseverywhere.utils.IntProperty
        public void setValue(@NonNull ColorDrawable colorDrawable, int i) {
            colorDrawable.setColor(i);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.transitionseverywhere.utils.IntProperty, android.util.Property
        @NonNull
        /* renamed from: get  reason: collision with other method in class */
        public Integer mo239get(@NonNull Object obj) {
            return Integer.valueOf(((ColorDrawable) obj).getColor());
        }
    }

    public Recolor(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
