package ru.sravni.android.bankproduct.databinding;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.adapters.TextViewBindingAdapter;
import ru.sravni.android.bankproduct.BR;
public class OfferOsagoListHeaderSravniBindingImpl extends OfferOsagoListHeaderSravniBinding {
    @NonNull
    public final FrameLayout y;
    public long z = -1;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OfferOsagoListHeaderSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r7, @androidx.annotation.NonNull android.view.View r8) {
        /*
            r6 = this;
            r0 = 2
            r1 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r7, r8, r0, r1, r1)
            r2 = 1
            r2 = r0[r2]
            android.widget.TextView r2 = (android.widget.TextView) r2
            r3 = 0
            r6.<init>(r7, r8, r3, r2)
            r4 = -1
            r6.z = r4
            r7 = r0[r3]
            android.widget.FrameLayout r7 = (android.widget.FrameLayout) r7
            r6.y = r7
            r7.setTag(r1)
            android.widget.TextView r7 = r6.tvOsagoHeader
            r7.setTag(r1)
            r6.setRootTag(r8)
            r6.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferOsagoListHeaderSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.z;
            this.z = 0;
        }
        String str = this.mTitleGroup;
        if ((j & 3) != 0) {
            TextViewBindingAdapter.setText(this.tvOsagoHeader, str);
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
            this.z = 2;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferOsagoListHeaderSravniBinding
    public void setTitleGroup(@Nullable String str) {
        this.mTitleGroup = str;
        synchronized (this) {
            this.z |= 1;
        }
        notifyPropertyChanged(BR.titleGroup);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.titleGroup != i) {
            return false;
        }
        setTitleGroup((String) obj);
        return true;
    }
}
