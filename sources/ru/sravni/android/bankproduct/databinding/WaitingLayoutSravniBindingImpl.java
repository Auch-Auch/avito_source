package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.utils.adapter.BindingProgressBarKt;
public class WaitingLayoutSravniBindingImpl extends WaitingLayoutSravniBinding {
    public long A = -1;
    @NonNull
    public final FrameLayout y;
    @NonNull
    public final ProgressBar z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WaitingLayoutSravniBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        super(dataBindingComponent, view, 0);
        Object[] mapBindings = ViewDataBinding.mapBindings(dataBindingComponent, view, 2, (ViewDataBinding.IncludedLayouts) null, (SparseIntArray) null);
        FrameLayout frameLayout = (FrameLayout) mapBindings[0];
        this.y = frameLayout;
        frameLayout.setTag(null);
        ProgressBar progressBar = (ProgressBar) mapBindings[1];
        this.z = progressBar;
        progressBar.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.A;
            this.A = 0;
        }
        if ((j & 1) != 0) {
            ProgressBar progressBar = this.z;
            BindingProgressBarKt.bindSetIndeterminateResTint(progressBar, ViewDataBinding.getColorFromResource(progressBar, R.color.primary));
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.A != 0) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.A = 1;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        return true;
    }
}
