package ru.sravni.android.bankproduct.databinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.adapters.TextViewBindingAdapter;
import ru.sravni.android.bankproduct.BR;
public class OfferProductInfoTitleItemSravniBindingImpl extends OfferProductInfoTitleItemSravniBinding {
    @NonNull
    public final ConstraintLayout y;
    public long z = -1;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OfferProductInfoTitleItemSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r7, @androidx.annotation.NonNull android.view.View r8) {
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
            androidx.constraintlayout.widget.ConstraintLayout r7 = (androidx.constraintlayout.widget.ConstraintLayout) r7
            r6.y = r7
            r7.setTag(r1)
            android.widget.TextView r7 = r6.tvName
            r7.setTag(r1)
            r6.setRootTag(r8)
            r6.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferProductInfoTitleItemSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.z;
            this.z = 0;
        }
        String str = this.mTitle;
        if ((j & 3) != 0) {
            TextViewBindingAdapter.setText(this.tvName, str);
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

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductInfoTitleItemSravniBinding
    public void setTitle(@Nullable String str) {
        this.mTitle = str;
        synchronized (this) {
            this.z |= 1;
        }
        notifyPropertyChanged(BR.title);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.title != i) {
            return false;
        }
        setTitle((String) obj);
        return true;
    }
}
