package com.my.target;

import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
public class hd extends RecyclerView {
    @Nullable
    public a E0;

    public interface a {
        void eo();
    }

    public hd(@NonNull Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void onScrollStateChanged(int i) {
        a aVar;
        super.onScrollStateChanged(i);
        if (!(i != 0) && (aVar = this.E0) != null) {
            aVar.eo();
        }
    }

    public void setMoveStopListener(@Nullable a aVar) {
        this.E0 = aVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void smoothScrollBy(int i, int i2) {
        super.smoothScrollBy(i, i2, new AccelerateDecelerateInterpolator());
    }
}
