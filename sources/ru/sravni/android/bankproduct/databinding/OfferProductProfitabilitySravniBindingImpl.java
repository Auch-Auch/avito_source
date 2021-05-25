package ru.sravni.android.bankproduct.databinding;

import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.presentation.offer.product.adapter.BindingProductOfferAdapterKt;
public class OfferProductProfitabilitySravniBindingImpl extends OfferProductProfitabilitySravniBinding {
    @NonNull
    public final LinearLayout y;
    public long z = -1;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OfferProductProfitabilitySravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r10, @androidx.annotation.NonNull android.view.View r11) {
        /*
            r9 = this;
            r0 = 3
            r1 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r10, r11, r0, r1, r1)
            r2 = 1
            r2 = r0[r2]
            r7 = r2
            antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator r7 = (antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator) r7
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
            antonkozyriatskyi.circularprogressindicator.CircularProgressIndicator r10 = r9.cpProbability
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
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferProductProfitabilitySravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.z;
            this.z = 0;
        }
        String str = this.mProfitabilityText;
        Integer num = this.mProfitability;
        int i = 0;
        int i2 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        int i3 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i3 != 0) {
            i = ViewDataBinding.safeUnbox(num);
        }
        if (i3 != 0) {
            BindingProductOfferAdapterKt.bindProgressToCircularProgressIndicator(this.cpProbability, i);
        }
        if (i2 != 0) {
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

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductProfitabilitySravniBinding
    public void setProfitability(@Nullable Integer num) {
        this.mProfitability = num;
        synchronized (this) {
            this.z |= 2;
        }
        notifyPropertyChanged(BR.profitability);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductProfitabilitySravniBinding
    public void setProfitabilityText(@Nullable String str) {
        this.mProfitabilityText = str;
        synchronized (this) {
            this.z |= 1;
        }
        notifyPropertyChanged(BR.profitabilityText);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.profitabilityText == i) {
            setProfitabilityText((String) obj);
        } else if (BR.profitability != i) {
            return false;
        } else {
            setProfitability((Integer) obj);
        }
        return true;
    }
}
