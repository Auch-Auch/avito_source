package com.transitionseverywhere;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.transition.Transition;
import androidx.transition.TransitionListenerAdapter;
import androidx.transition.TransitionValues;
import java.util.Map;
import java.util.Objects;
public class ChangeText extends Transition {
    public static final int CHANGE_BEHAVIOR_IN = 2;
    public static final int CHANGE_BEHAVIOR_KEEP = 0;
    public static final int CHANGE_BEHAVIOR_OUT = 1;
    public static final int CHANGE_BEHAVIOR_OUT_IN = 3;
    public static final String[] K = {"android:textchange:text", "android:textchange:textSelectionStart", "android:textchange:textSelectionEnd"};
    public int J = 0;

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ CharSequence a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ CharSequence c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;

        public a(CharSequence charSequence, TextView textView, CharSequence charSequence2, int i, int i2) {
            this.a = charSequence;
            this.b = textView;
            this.c = charSequence2;
            this.d = i;
            this.e = i2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a.equals(this.b.getText())) {
                this.b.setText(this.c);
                TextView textView = this.b;
                if (textView instanceof EditText) {
                    ChangeText.o(ChangeText.this, (EditText) textView, this.d, this.e);
                }
            }
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ int b;

        public b(ChangeText changeText, TextView textView, int i) {
            this.a = textView;
            this.b = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            TextView textView = this.a;
            int i = this.b;
            textView.setTextColor((intValue << 24) | (16711680 & i) | (65280 & i) | (i & 255));
        }
    }

    public class c extends AnimatorListenerAdapter {
        public final /* synthetic */ CharSequence a;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ CharSequence c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;

        public c(CharSequence charSequence, TextView textView, CharSequence charSequence2, int i, int i2, int i3) {
            this.a = charSequence;
            this.b = textView;
            this.c = charSequence2;
            this.d = i;
            this.e = i2;
            this.f = i3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a.equals(this.b.getText())) {
                this.b.setText(this.c);
                TextView textView = this.b;
                if (textView instanceof EditText) {
                    ChangeText.o(ChangeText.this, (EditText) textView, this.d, this.e);
                }
            }
            this.b.setTextColor(this.f);
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ int b;

        public d(ChangeText changeText, TextView textView, int i) {
            this.a = textView;
            this.b = i;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            this.a.setTextColor((((Integer) valueAnimator.getAnimatedValue()).intValue() << 24) | (Color.red(this.b) << 16) | (Color.green(this.b) << 8) | Color.blue(this.b));
        }
    }

    public class e extends AnimatorListenerAdapter {
        public final /* synthetic */ TextView a;
        public final /* synthetic */ int b;

        public e(ChangeText changeText, TextView textView, int i) {
            this.a = textView;
            this.b = i;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a.setTextColor(this.b);
        }
    }

    public class f extends TransitionListenerAdapter {
        public int a = 0;
        public final /* synthetic */ TextView b;
        public final /* synthetic */ CharSequence c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ int f;
        public final /* synthetic */ CharSequence g;
        public final /* synthetic */ int h;
        public final /* synthetic */ int i;

        public f(TextView textView, CharSequence charSequence, int i2, int i3, int i4, CharSequence charSequence2, int i5, int i6) {
            this.b = textView;
            this.c = charSequence;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = charSequence2;
            this.h = i5;
            this.i = i6;
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(@NonNull Transition transition) {
            transition.removeListener(this);
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionPause(@NonNull Transition transition) {
            if (ChangeText.this.J != 2) {
                this.b.setText(this.c);
                TextView textView = this.b;
                if (textView instanceof EditText) {
                    ChangeText.o(ChangeText.this, (EditText) textView, this.d, this.e);
                }
            }
            if (ChangeText.this.J > 0) {
                this.a = this.b.getCurrentTextColor();
                this.b.setTextColor(this.f);
            }
        }

        @Override // androidx.transition.TransitionListenerAdapter, androidx.transition.Transition.TransitionListener
        public void onTransitionResume(@NonNull Transition transition) {
            if (ChangeText.this.J != 2) {
                this.b.setText(this.g);
                TextView textView = this.b;
                if (textView instanceof EditText) {
                    ChangeText.o(ChangeText.this, (EditText) textView, this.h, this.i);
                }
            }
            if (ChangeText.this.J > 0) {
                this.b.setTextColor(this.a);
            }
        }
    }

    public static void o(ChangeText changeText, EditText editText, int i, int i2) {
        Objects.requireNonNull(changeText);
        if (i >= 0 && i2 >= 0) {
            editText.setSelection(i, i2);
        }
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(@NonNull TransitionValues transitionValues) {
        p(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(@NonNull TransitionValues transitionValues) {
        p(transitionValues);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: android.animation.AnimatorSet */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.transition.Transition
    @Nullable
    public Animator createAnimator(@NonNull ViewGroup viewGroup, @Nullable TransitionValues transitionValues, @Nullable TransitionValues transitionValues2) {
        CharSequence charSequence;
        CharSequence charSequence2;
        int i;
        int i2;
        int i3;
        int i4;
        CharSequence charSequence3;
        int i5;
        int i6;
        ValueAnimator valueAnimator;
        int i7;
        ValueAnimator valueAnimator2;
        int i8;
        char c2;
        int i9;
        int i10;
        ValueAnimator valueAnimator3;
        if (transitionValues == null || transitionValues2 == null || !(transitionValues.view instanceof TextView)) {
            return null;
        }
        View view = transitionValues2.view;
        if (!(view instanceof TextView)) {
            return null;
        }
        TextView textView = (TextView) view;
        Map<String, Object> map = transitionValues.values;
        Map<String, Object> map2 = transitionValues2.values;
        if (map.get("android:textchange:text") != null) {
            charSequence = (CharSequence) map.get("android:textchange:text");
        } else {
            charSequence = "";
        }
        if (map2.get("android:textchange:text") != null) {
            charSequence2 = (CharSequence) map2.get("android:textchange:text");
        } else {
            charSequence2 = "";
        }
        int i11 = -1;
        if (textView instanceof EditText) {
            int intValue = map.get("android:textchange:textSelectionStart") != null ? ((Integer) map.get("android:textchange:textSelectionStart")).intValue() : -1;
            int intValue2 = map.get("android:textchange:textSelectionEnd") != null ? ((Integer) map.get("android:textchange:textSelectionEnd")).intValue() : intValue;
            if (map2.get("android:textchange:textSelectionStart") != null) {
                i11 = ((Integer) map2.get("android:textchange:textSelectionStart")).intValue();
            }
            i2 = map2.get("android:textchange:textSelectionEnd") != null ? ((Integer) map2.get("android:textchange:textSelectionEnd")).intValue() : i11;
            i3 = i11;
            i = intValue;
            i4 = intValue2;
        } else {
            i4 = -1;
            i3 = -1;
            i2 = -1;
            i = -1;
        }
        if (charSequence.equals(charSequence2)) {
            return null;
        }
        if (this.J != 2) {
            textView.setText(charSequence);
            if (textView instanceof EditText) {
                EditText editText = (EditText) textView;
                if (i >= 0 && i4 >= 0) {
                    editText.setSelection(i, i4);
                }
            }
        }
        int i12 = 0;
        if (this.J == 0) {
            valueAnimator2 = ValueAnimator.ofFloat(0.0f, 1.0f);
            valueAnimator2.addListener(new a(charSequence, textView, charSequence2, i3, i2));
            i6 = i4;
            charSequence3 = charSequence;
            i5 = i;
        } else {
            int intValue3 = ((Integer) map.get("android:textchange:textColor")).intValue();
            int intValue4 = ((Integer) map2.get("android:textchange:textColor")).intValue();
            int i13 = this.J;
            if (i13 == 3 || i13 == 1) {
                ValueAnimator ofInt = ValueAnimator.ofInt(Color.alpha(intValue3), 0);
                ofInt.addUpdateListener(new b(this, textView, intValue3));
                i5 = i;
                charSequence3 = charSequence;
                i9 = 3;
                c2 = 1;
                i6 = i4;
                i8 = intValue4;
                ofInt.addListener(new c(charSequence, textView, charSequence2, i3, i2, intValue4));
                valueAnimator2 = ofInt;
            } else {
                i6 = i4;
                i8 = intValue4;
                charSequence3 = charSequence;
                i5 = i;
                valueAnimator2 = null;
                i9 = 3;
                c2 = 1;
            }
            int i14 = this.J;
            if (i14 == i9 || i14 == 2) {
                int[] iArr = new int[2];
                iArr[0] = 0;
                iArr[c2] = Color.alpha(i8);
                valueAnimator3 = ValueAnimator.ofInt(iArr);
                i10 = i8;
                valueAnimator3.addUpdateListener(new d(this, textView, i10));
                valueAnimator3.addListener(new e(this, textView, i10));
            } else {
                i10 = i8;
                valueAnimator3 = null;
            }
            if (valueAnimator2 != null && valueAnimator3 != null) {
                AnimatorSet animatorSet = new AnimatorSet();
                Animator[] animatorArr = new Animator[2];
                animatorArr[0] = valueAnimator2;
                animatorArr[c2] = valueAnimator3;
                animatorSet.playSequentially(animatorArr);
                valueAnimator3 = animatorSet;
            } else if (valueAnimator2 != null) {
                i12 = i10;
            }
            valueAnimator = valueAnimator3;
            i7 = i10;
            addListener(new f(textView, charSequence2, i3, i2, i7, charSequence3, i5, i6));
            return valueAnimator;
        }
        valueAnimator = valueAnimator2;
        i7 = i12;
        addListener(new f(textView, charSequence2, i3, i2, i7, charSequence3, i5, i6));
        return valueAnimator;
    }

    public int getChangeBehavior() {
        return this.J;
    }

    @Override // androidx.transition.Transition
    @Nullable
    public String[] getTransitionProperties() {
        return K;
    }

    public final void p(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            transitionValues.values.put("android:textchange:text", textView.getText());
            if (textView instanceof EditText) {
                transitionValues.values.put("android:textchange:textSelectionStart", Integer.valueOf(textView.getSelectionStart()));
                transitionValues.values.put("android:textchange:textSelectionEnd", Integer.valueOf(textView.getSelectionEnd()));
            }
            if (this.J > 0) {
                transitionValues.values.put("android:textchange:textColor", Integer.valueOf(textView.getCurrentTextColor()));
            }
        }
    }

    @NonNull
    public ChangeText setChangeBehavior(int i) {
        if (i >= 0 && i <= 3) {
            this.J = i;
        }
        return this;
    }
}
