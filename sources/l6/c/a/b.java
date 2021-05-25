package l6.c.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.MotionEvent;
import android.view.View;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
@Deprecated
public class b extends Dialog {
    public final View a;

    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;

        public a(boolean z) {
            this.a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.a) {
                b.super.dismiss();
            }
        }
    }

    public b(Context context, View view) {
        super(context);
        this.a = view;
    }

    public final void b(boolean z) {
        float f = 0.0f;
        float f2 = z ? 0.0f : 1.0f;
        if (z) {
            f = 1.0f;
        }
        long j = z ? 250 : 150;
        this.a.setScaleX(f2);
        this.a.setScaleY(f2);
        this.a.animate().scaleX(f).scaleY(f).setDuration(j).setInterpolator(new LinearOutSlowInInterpolator()).setListener(new a(z)).start();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        b(false);
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() != 0) {
            return false;
        }
        b(false);
        return true;
    }

    @Override // android.app.Dialog
    public void show() {
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        b(true);
        super.show();
    }
}
