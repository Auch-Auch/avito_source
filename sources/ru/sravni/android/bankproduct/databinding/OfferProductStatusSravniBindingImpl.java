package ru.sravni.android.bankproduct.databinding;

import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.adapters.TextViewBindingAdapter;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.domain.offer.product.entity.ProductStatusEnum;
import ru.sravni.android.bankproduct.presentation.offer.product.adapter.BindingProductOfferAdapterKt;
public class OfferProductStatusSravniBindingImpl extends OfferProductStatusSravniBinding {
    @NonNull
    public final LinearLayout y;
    public long z = -1;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OfferProductStatusSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r10, @androidx.annotation.NonNull android.view.View r11) {
        /*
            r9 = this;
            r0 = 3
            r1 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r10, r11, r0, r1, r1)
            r2 = 1
            r2 = r0[r2]
            r7 = r2
            androidx.appcompat.widget.AppCompatImageView r7 = (androidx.appcompat.widget.AppCompatImageView) r7
            r2 = 2
            r2 = r0[r2]
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            r6 = 0
            r3 = r9
            r4 = r10
            r5 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            r2 = -1
            r9.z = r2
            androidx.appcompat.widget.AppCompatImageView r10 = r9.ivIcon
            r10.setTag(r1)
            r10 = 0
            r10 = r0[r10]
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            r9.y = r10
            r10.setTag(r1)
            android.widget.TextView r10 = r9.tvText
            r10.setTag(r1)
            r9.setRootTag(r11)
            r9.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferProductStatusSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.z;
            this.z = 0;
        }
        ProductStatusEnum productStatusEnum = this.mStatusEnum;
        String str = this.mStatusText;
        int i = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if ((5 & j) != 0) {
            BindingProductOfferAdapterKt.bindStatusToImageView(this.ivIcon, productStatusEnum);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.tvText, str);
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
            this.z = 4;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductStatusSravniBinding
    public void setStatusEnum(@Nullable ProductStatusEnum productStatusEnum) {
        this.mStatusEnum = productStatusEnum;
        synchronized (this) {
            this.z |= 1;
        }
        notifyPropertyChanged(BR.statusEnum);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductStatusSravniBinding
    public void setStatusText(@Nullable String str) {
        this.mStatusText = str;
        synchronized (this) {
            this.z |= 2;
        }
        notifyPropertyChanged(BR.statusText);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.statusEnum == i) {
            setStatusEnum((ProductStatusEnum) obj);
        } else if (BR.statusText != i) {
            return false;
        } else {
            setStatusText((String) obj);
        }
        return true;
    }
}
