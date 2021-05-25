package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.adapters.TextViewBindingAdapter;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.order.OsagoCompanyOrderDomain;
import ru.sravni.android.bankproduct.utils.adapter.BindingViewKt;
public class OfferOsagoOrderInfoSravniBindingImpl extends OfferOsagoOrderInfoSravniBinding {
    @Nullable
    public static final SparseIntArray A;
    @NonNull
    public final ConstraintLayout y;
    public long z = -1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        A = sparseIntArray;
        sparseIntArray.put(R.id.tvTitleOsago, 4);
        sparseIntArray.put(R.id.vLine, 5);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OfferOsagoOrderInfoSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r13, @androidx.annotation.NonNull android.view.View r14) {
        /*
            r12 = this;
            android.util.SparseIntArray r0 = ru.sravni.android.bankproduct.databinding.OfferOsagoOrderInfoSravniBindingImpl.A
            r1 = 6
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r13, r14, r1, r2, r0)
            r1 = 1
            r1 = r0[r1]
            r7 = r1
            androidx.cardview.widget.CardView r7 = (androidx.cardview.widget.CardView) r7
            r1 = 2
            r1 = r0[r1]
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            r1 = 3
            r1 = r0[r1]
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            r1 = 4
            r1 = r0[r1]
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            r1 = 5
            r1 = r0[r1]
            r11 = r1
            android.view.View r11 = (android.view.View) r11
            r6 = 0
            r3 = r12
            r4 = r13
            r5 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            r3 = -1
            r12.z = r3
            androidx.cardview.widget.CardView r13 = r12.cvIconOsago
            r13.setTag(r2)
            r13 = 0
            r13 = r0[r13]
            androidx.constraintlayout.widget.ConstraintLayout r13 = (androidx.constraintlayout.widget.ConstraintLayout) r13
            r12.y = r13
            r13.setTag(r2)
            android.widget.TextView r13 = r12.tvIconOsago
            r13.setTag(r2)
            android.widget.TextView r13 = r12.tvNameOsago
            r13.setTag(r2)
            r12.setRootTag(r14)
            r12.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferOsagoOrderInfoSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        String str;
        synchronized (this) {
            j = this.z;
            this.z = 0;
        }
        OsagoCompanyOrderDomain osagoCompanyOrderDomain = this.mOsagoCompanyOrder;
        String str2 = null;
        int i2 = 0;
        int i3 = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i3 == 0 || osagoCompanyOrderDomain == null) {
            str = null;
            i = 0;
        } else {
            int titleColor = osagoCompanyOrderDomain.getTitleColor();
            String title = osagoCompanyOrderDomain.getTitle();
            i2 = osagoCompanyOrderDomain.getBackgroundColor();
            str = title;
            str2 = osagoCompanyOrderDomain.getIconText();
            i = titleColor;
        }
        if (i3 != 0) {
            BindingViewKt.bindSetBackgroundColorToCardView(this.cvIconOsago, i2);
            TextViewBindingAdapter.setText(this.tvIconOsago, str2);
            this.tvIconOsago.setTextColor(i);
            TextViewBindingAdapter.setText(this.tvNameOsago, str);
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

    @Override // ru.sravni.android.bankproduct.databinding.OfferOsagoOrderInfoSravniBinding
    public void setOsagoCompanyOrder(@Nullable OsagoCompanyOrderDomain osagoCompanyOrderDomain) {
        this.mOsagoCompanyOrder = osagoCompanyOrderDomain;
        synchronized (this) {
            this.z |= 1;
        }
        notifyPropertyChanged(BR.osagoCompanyOrder);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.osagoCompanyOrder != i) {
            return false;
        }
        setOsagoCompanyOrder((OsagoCompanyOrderDomain) obj);
        return true;
    }
}
