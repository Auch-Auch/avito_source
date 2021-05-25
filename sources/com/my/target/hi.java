package com.my.target;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
public class hi extends ProgressBar implements hh {
    public hi(Context context) {
        super(context, null, 16842872);
    }

    @Override // com.my.target.hh
    @NonNull
    public View eu() {
        return this;
    }

    @Override // com.my.target.hh
    public void setColor(int i) {
        ClipDrawable clipDrawable = new ClipDrawable(new ColorDrawable(i), GravityCompat.START, 1);
        ColorDrawable colorDrawable = new ColorDrawable(0);
        LayerDrawable layerDrawable = (LayerDrawable) getProgressDrawable();
        layerDrawable.setDrawableByLayerId(16908288, colorDrawable);
        layerDrawable.setDrawableByLayerId(16908301, clipDrawable);
        setProgressDrawable(layerDrawable);
    }

    @Override // com.my.target.hh
    public void setMaxTime(float f) {
        setMax((int) (f * 1000.0f));
    }

    @Override // com.my.target.hh
    public void setTimeChanged(float f) {
        if (Build.VERSION.SDK_INT >= 26) {
            setProgress((int) (f * 1000.0f), true);
            return;
        }
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "progress", getProgress(), (int) (f * 1000.0f));
        ofInt.setDuration(200L);
        ofInt.setInterpolator(new DecelerateInterpolator());
        ofInt.start();
    }

    @Override // com.my.target.hh
    public void setVisible(boolean z) {
        setVisibility(z ? 0 : 8);
    }
}
