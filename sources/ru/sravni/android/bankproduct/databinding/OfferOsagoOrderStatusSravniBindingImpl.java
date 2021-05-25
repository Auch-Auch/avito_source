package ru.sravni.android.bankproduct.databinding;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import java.util.List;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.order.OsagoCompanyOrderInfoDomain;
import ru.sravni.android.bankproduct.presentation.offer.osago.order.adapter.BindingOfferOsagoOrderAdapterKt;
import ru.sravni.android.bankproduct.utils.adapter.BindingImageViewKt;
public class OfferOsagoOrderStatusSravniBindingImpl extends OfferOsagoOrderStatusSravniBinding {
    @NonNull
    public final ConstraintLayout y;
    public long z = -1;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OfferOsagoOrderStatusSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r14, @androidx.annotation.NonNull android.view.View r15) {
        /*
            r13 = this;
            r0 = 7
            r1 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r14, r15, r0, r1, r1)
            r2 = 1
            r2 = r0[r2]
            r7 = r2
            android.widget.ImageView r7 = (android.widget.ImageView) r7
            r2 = 6
            r2 = r0[r2]
            r8 = r2
            com.yarolegovich.discretescrollview.DiscreteScrollView r8 = (com.yarolegovich.discretescrollview.DiscreteScrollView) r8
            r2 = 4
            r2 = r0[r2]
            r9 = r2
            android.widget.TextView r9 = (android.widget.TextView) r9
            r2 = 3
            r2 = r0[r2]
            r10 = r2
            android.widget.TextView r10 = (android.widget.TextView) r10
            r2 = 5
            r2 = r0[r2]
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            r2 = 2
            r2 = r0[r2]
            r12 = r2
            android.widget.TextView r12 = (android.widget.TextView) r12
            r6 = 0
            r3 = r13
            r4 = r14
            r5 = r15
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r2 = -1
            r13.z = r2
            android.widget.ImageView r14 = r13.imgIconAnswer
            r14.setTag(r1)
            r14 = 0
            r14 = r0[r14]
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            r13.y = r14
            r14.setTag(r1)
            com.yarolegovich.discretescrollview.DiscreteScrollView r14 = r13.rvAnotherCompany
            r14.setTag(r1)
            android.widget.TextView r14 = r13.tvComparisonPrice
            r14.setTag(r1)
            android.widget.TextView r14 = r13.tvComparisonText
            r14.setTag(r1)
            android.widget.TextView r14 = r13.tvText
            r14.setTag(r1)
            android.widget.TextView r14 = r13.tvTextTitle
            r14.setTag(r1)
            r13.setRootTag(r15)
            r13.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferOsagoOrderStatusSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        int i;
        int i2;
        List<OsagoCompanyOrderInfoDomain.CompanyDomain> list;
        String str2;
        String str3;
        int i3;
        String str4;
        String str5;
        String str6;
        synchronized (this) {
            j = this.z;
            this.z = 0;
        }
        Integer num = this.mIconStatus;
        OsagoCompanyOrderInfoDomain osagoCompanyOrderInfoDomain = this.mOsagoPaymentInfo;
        Boolean bool = this.mNeedAlternativeCompany;
        String str7 = null;
        int i4 = ((j & 10) > 0 ? 1 : ((j & 10) == 0 ? 0 : -1));
        if (i4 != 0) {
            if (osagoCompanyOrderInfoDomain != null) {
                String textTitle = osagoCompanyOrderInfoDomain.getTextTitle();
                List<OsagoCompanyOrderInfoDomain.CompanyDomain> listCompany = osagoCompanyOrderInfoDomain.getListCompany();
                String comparisonPrice = osagoCompanyOrderInfoDomain.getComparisonPrice();
                str4 = osagoCompanyOrderInfoDomain.getText();
                str6 = osagoCompanyOrderInfoDomain.getComparisonText();
                list = listCompany;
                str5 = textTitle;
                str7 = comparisonPrice;
            } else {
                str6 = null;
                str5 = null;
                list = null;
                str4 = null;
            }
            boolean isEmpty = TextUtils.isEmpty(str7);
            boolean isEmpty2 = TextUtils.isEmpty(str6);
            if (i4 != 0) {
                j |= isEmpty ? 32 : 16;
            }
            if ((j & 10) != 0) {
                j |= isEmpty2 ? 128 : 64;
            }
            i2 = isEmpty ? 8 : 0;
            i = isEmpty2 ? 8 : 0;
            str = str6;
            str3 = str7;
            str7 = str5;
            str2 = str4;
        } else {
            str3 = null;
            str2 = null;
            list = null;
            str = null;
            i2 = 0;
            i = 0;
        }
        int i5 = ((j & 12) > 0 ? 1 : ((j & 12) == 0 ? 0 : -1));
        if (i5 != 0) {
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            if (i5 != 0) {
                j |= safeUnbox ? 512 : 256;
            }
            i3 = safeUnbox ? 0 : 8;
        } else {
            i3 = 0;
        }
        if ((j & 9) != 0) {
            BindingImageViewKt.bindDrawableSource(this.imgIconAnswer, num);
        }
        if ((j & 12) != 0) {
            this.rvAnotherCompany.setVisibility(i3);
        }
        if ((j & 10) != 0) {
            BindingOfferOsagoOrderAdapterKt.bindCompanyList(this.rvAnotherCompany, list);
            TextViewBindingAdapter.setText(this.tvComparisonPrice, str3);
            this.tvComparisonPrice.setVisibility(i2);
            this.tvComparisonText.setVisibility(i);
            TextViewBindingAdapter.setText(this.tvComparisonText, str);
            TextViewBindingAdapter.setText(this.tvText, str2);
            TextViewBindingAdapter.setText(this.tvTextTitle, str7);
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
            this.z = 8;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferOsagoOrderStatusSravniBinding
    public void setIconStatus(@Nullable Integer num) {
        this.mIconStatus = num;
        synchronized (this) {
            this.z |= 1;
        }
        notifyPropertyChanged(BR.iconStatus);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferOsagoOrderStatusSravniBinding
    public void setNeedAlternativeCompany(@Nullable Boolean bool) {
        this.mNeedAlternativeCompany = bool;
        synchronized (this) {
            this.z |= 4;
        }
        notifyPropertyChanged(BR.needAlternativeCompany);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferOsagoOrderStatusSravniBinding
    public void setOsagoPaymentInfo(@Nullable OsagoCompanyOrderInfoDomain osagoCompanyOrderInfoDomain) {
        this.mOsagoPaymentInfo = osagoCompanyOrderInfoDomain;
        synchronized (this) {
            this.z |= 2;
        }
        notifyPropertyChanged(BR.osagoPaymentInfo);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.iconStatus == i) {
            setIconStatus((Integer) obj);
        } else if (BR.osagoPaymentInfo == i) {
            setOsagoPaymentInfo((OsagoCompanyOrderInfoDomain) obj);
        } else if (BR.needAlternativeCompany != i) {
            return false;
        } else {
            setNeedAlternativeCompany((Boolean) obj);
        }
        return true;
    }
}
