package ru.sravni.android.bankproduct.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.adapters.TextViewBindingAdapter;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailItemDomain;
import ru.sravni.android.bankproduct.presentation.offer.product.list.adapter.BindingProductOfferListAdapterKt;
public class OfferProductInfoStandartItemSravniBindingImpl extends OfferProductInfoStandartItemSravniBinding {
    public long A = -1;
    @NonNull
    public final LinearLayout y;
    @NonNull
    public final View z;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OfferProductInfoStandartItemSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r10, @androidx.annotation.NonNull android.view.View r11) {
        /*
            r9 = this;
            r0 = 4
            r1 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r10, r11, r0, r1, r1)
            r2 = 1
            r2 = r0[r2]
            r7 = r2
            android.widget.TextView r7 = (android.widget.TextView) r7
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
            r9.A = r2
            r10 = 0
            r10 = r0[r10]
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            r9.y = r10
            r10.setTag(r1)
            r10 = 3
            r10 = r0[r10]
            android.view.View r10 = (android.view.View) r10
            r9.z = r10
            r10.setTag(r1)
            android.widget.TextView r10 = r9.tvName
            r10.setTag(r1)
            android.widget.TextView r10 = r9.tvValue
            r10.setTag(r1)
            r9.setRootTag(r11)
            r9.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferProductInfoStandartItemSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        String str2;
        boolean z2;
        synchronized (this) {
            j = this.A;
            this.A = 0;
        }
        OfferProductDetailItemDomain.ItemParam itemParam = this.mMainParam;
        String str3 = null;
        int i = 0;
        int i2 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i2 != 0) {
            if (itemParam != null) {
                z2 = itemParam.getNeedLine();
                str3 = itemParam.getName();
                str = itemParam.getValue();
                str2 = itemParam.getFontType();
            } else {
                str2 = null;
                str = null;
                z2 = false;
            }
            if (i2 != 0) {
                j |= z2 ? 8 : 4;
            }
            if (!z2) {
                i = 8;
            }
        } else {
            str2 = null;
            str = null;
        }
        if ((j & 3) != 0) {
            this.z.setVisibility(i);
            TextViewBindingAdapter.setText(this.tvName, str3);
            TextViewBindingAdapter.setText(this.tvValue, str);
            BindingProductOfferListAdapterKt.bindTextAppearanceStyleToTextView(this.tvValue, str2);
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
            this.A = 2;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductInfoStandartItemSravniBinding
    public void setMainParam(@Nullable OfferProductDetailItemDomain.ItemParam itemParam) {
        this.mMainParam = itemParam;
        synchronized (this) {
            this.A |= 1;
        }
        notifyPropertyChanged(BR.mainParam);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.mainParam != i) {
            return false;
        }
        setMainParam((OfferProductDetailItemDomain.ItemParam) obj);
        return true;
    }
}
