package ru.sravni.android.bankproduct.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.adapters.TextViewBindingAdapter;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.order.OsagoCompanyOrderInfoDomain;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.presentation.offer.osago.order.adapter.IAlternativeCompany;
import ru.sravni.android.bankproduct.utils.adapter.BindingViewKt;
public class OfferOsagoOrderAlternativeItemSravniBindingImpl extends OfferOsagoOrderAlternativeItemSravniBinding implements OnClickListener.Listener {
    public long A = -1;
    @NonNull
    public final ConstraintLayout y;
    @Nullable
    public final View.OnClickListener z;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OfferOsagoOrderAlternativeItemSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r14, @androidx.annotation.NonNull android.view.View r15) {
        /*
            r13 = this;
            r0 = 6
            r1 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r14, r15, r0, r1, r1)
            r2 = 1
            r3 = r0[r2]
            r8 = r3
            androidx.cardview.widget.CardView r8 = (androidx.cardview.widget.CardView) r8
            r3 = 5
            r3 = r0[r3]
            r9 = r3
            com.google.android.material.button.MaterialButton r9 = (com.google.android.material.button.MaterialButton) r9
            r3 = 2
            r3 = r0[r3]
            r10 = r3
            android.widget.TextView r10 = (android.widget.TextView) r10
            r3 = 3
            r3 = r0[r3]
            r11 = r3
            android.widget.TextView r11 = (android.widget.TextView) r11
            r3 = 4
            r3 = r0[r3]
            r12 = r3
            android.widget.TextView r12 = (android.widget.TextView) r12
            r7 = 0
            r4 = r13
            r5 = r14
            r6 = r15
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
            r3 = -1
            r13.A = r3
            androidx.cardview.widget.CardView r14 = r13.cvIconOsago
            r14.setTag(r1)
            com.google.android.material.button.MaterialButton r14 = r13.mbAnotherCompany
            r14.setTag(r1)
            r14 = 0
            r14 = r0[r14]
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            r13.y = r14
            r14.setTag(r1)
            android.widget.TextView r14 = r13.tvIconOsago
            r14.setTag(r1)
            android.widget.TextView r14 = r13.tvNameOsago
            r14.setTag(r1)
            android.widget.TextView r14 = r13.tvPriceOsago
            r14.setTag(r1)
            r13.setRootTag(r15)
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r14 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r14.<init>(r13, r2)
            r13.z = r14
            r13.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferOsagoOrderAlternativeItemSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        OsagoCompanyOrderInfoDomain.CompanyDomain companyDomain = this.mCompany;
        IAlternativeCompany iAlternativeCompany = this.mAlternativeCompany;
        if (iAlternativeCompany != null) {
            iAlternativeCompany.clickNewCompany(companyDomain);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        int i;
        String str2;
        synchronized (this) {
            j = this.A;
            this.A = 0;
        }
        OsagoCompanyOrderInfoDomain.CompanyDomain companyDomain = this.mCompany;
        int i2 = 0;
        String str3 = null;
        int i3 = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if (i3 == 0 || companyDomain == null) {
            str2 = null;
            str = null;
            i = 0;
        } else {
            str3 = companyDomain.getIconText();
            i2 = companyDomain.getBackgroundColor();
            i = companyDomain.getTitleColor();
            str = companyDomain.getTitle();
            str2 = companyDomain.getPriceValue();
        }
        if (i3 != 0) {
            BindingViewKt.bindSetBackgroundColorToCardView(this.cvIconOsago, i2);
            TextViewBindingAdapter.setText(this.tvIconOsago, str3);
            this.tvIconOsago.setTextColor(i);
            TextViewBindingAdapter.setText(this.tvNameOsago, str);
            TextViewBindingAdapter.setText(this.tvPriceOsago, str2);
        }
        if ((j & 4) != 0) {
            this.mbAnotherCompany.setOnClickListener(this.z);
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
            this.A = 4;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferOsagoOrderAlternativeItemSravniBinding
    public void setAlternativeCompany(@Nullable IAlternativeCompany iAlternativeCompany) {
        this.mAlternativeCompany = iAlternativeCompany;
        synchronized (this) {
            this.A |= 1;
        }
        notifyPropertyChanged(BR.alternativeCompany);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferOsagoOrderAlternativeItemSravniBinding
    public void setCompany(@Nullable OsagoCompanyOrderInfoDomain.CompanyDomain companyDomain) {
        this.mCompany = companyDomain;
        synchronized (this) {
            this.A |= 2;
        }
        notifyPropertyChanged(BR.company);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.alternativeCompany == i) {
            setAlternativeCompany((IAlternativeCompany) obj);
        } else if (BR.company != i) {
            return false;
        } else {
            setCompany((OsagoCompanyOrderInfoDomain.CompanyDomain) obj);
        }
        return true;
    }
}
