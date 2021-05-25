package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import ru.sravni.android.bankproduct.R;
public class OfferProductItemStatusTextSravniBindingImpl extends OfferProductItemStatusTextSravniBinding {
    @Nullable
    public static final SparseIntArray A;
    @NonNull
    public final FrameLayout y;
    public long z = -1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        A = sparseIntArray;
        sparseIntArray.put(R.id.tvText, 1);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OfferProductItemStatusTextSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r7, @androidx.annotation.NonNull android.view.View r8) {
        /*
            r6 = this;
            android.util.SparseIntArray r0 = ru.sravni.android.bankproduct.databinding.OfferProductItemStatusTextSravniBindingImpl.A
            r1 = 2
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r7, r8, r1, r2, r0)
            r1 = 1
            r1 = r0[r1]
            android.widget.TextView r1 = (android.widget.TextView) r1
            r3 = 0
            r6.<init>(r7, r8, r3, r1)
            r4 = -1
            r6.z = r4
            r7 = r0[r3]
            android.widget.FrameLayout r7 = (android.widget.FrameLayout) r7
            r6.y = r7
            r7.setTag(r2)
            r6.setRootTag(r8)
            r6.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferProductItemStatusTextSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.z = 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.z != 0) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.z = 1;
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
