package ru.sravni.android.bankproduct.databinding;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoCompanyDetailDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoDetailDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OfferOsagoDisplaySettingsDomain;
import ru.sravni.android.bankproduct.domain.offer.osago.entity.list.OsagoCompanyDetailEnum;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.ISelectOfferOsago;
import ru.sravni.android.bankproduct.utils.adapter.BindingProgressBarKt;
import ru.sravni.android.bankproduct.utils.adapter.BindingViewKt;
public class OfferOsagoListItemSravniBindingImpl extends OfferOsagoListItemSravniBinding implements OnClickListener.Listener {
    @NonNull
    public final TextView A;
    @Nullable
    public final View.OnClickListener B;
    public long C = -1;
    @NonNull
    public final CardView y;
    @NonNull
    public final ProgressBar z;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OfferOsagoListItemSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r16, @androidx.annotation.NonNull android.view.View r17) {
        /*
            r15 = this;
            r10 = r15
            r11 = r17
            r0 = 9
            r12 = 0
            r1 = r16
            java.lang.Object[] r13 = androidx.databinding.ViewDataBinding.mapBindings(r1, r11, r0, r12, r12)
            r14 = 1
            r0 = r13[r14]
            r4 = r0
            androidx.cardview.widget.CardView r4 = (androidx.cardview.widget.CardView) r4
            r0 = 5
            r0 = r13[r0]
            r5 = r0
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            r0 = 8
            r0 = r13[r0]
            r6 = r0
            com.google.android.material.button.MaterialButton r6 = (com.google.android.material.button.MaterialButton) r6
            r0 = 2
            r0 = r13[r0]
            r7 = r0
            android.widget.TextView r7 = (android.widget.TextView) r7
            r0 = 3
            r0 = r13[r0]
            r8 = r0
            android.widget.TextView r8 = (android.widget.TextView) r8
            r0 = 4
            r0 = r13[r0]
            r9 = r0
            android.widget.TextView r9 = (android.widget.TextView) r9
            r3 = 0
            r0 = r15
            r1 = r16
            r2 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r0 = -1
            r10.C = r0
            androidx.cardview.widget.CardView r0 = r10.cvIconOsago
            r0.setTag(r12)
            android.widget.LinearLayout r0 = r10.llSumWaitOsago
            r0.setTag(r12)
            com.google.android.material.button.MaterialButton r0 = r10.mbCarInfo
            r0.setTag(r12)
            r0 = 0
            r0 = r13[r0]
            androidx.cardview.widget.CardView r0 = (androidx.cardview.widget.CardView) r0
            r10.y = r0
            r0.setTag(r12)
            r0 = 6
            r0 = r13[r0]
            android.widget.ProgressBar r0 = (android.widget.ProgressBar) r0
            r10.z = r0
            r0.setTag(r12)
            r0 = 7
            r0 = r13[r0]
            android.widget.TextView r0 = (android.widget.TextView) r0
            r10.A = r0
            r0.setTag(r12)
            android.widget.TextView r0 = r10.tvIconOsago
            r0.setTag(r12)
            android.widget.TextView r0 = r10.tvNameOsago
            r0.setTag(r12)
            android.widget.TextView r0 = r10.tvSumOsago
            r0.setTag(r12)
            r15.setRootTag(r11)
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r0 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r0.<init>(r15, r14)
            r10.B = r0
            r15.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferOsagoListItemSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        ISelectOfferOsago iSelectOfferOsago = this.mSelectOfferOsago;
        OfferOsagoDetailDomain offerOsagoDetailDomain = this.mOsagoDetail;
        if (iSelectOfferOsago != null) {
            iSelectOfferOsago.selectedOsago(offerOsagoDetailDomain);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        boolean z2;
        int i2;
        int i3;
        String str;
        int i4;
        String str2;
        int i5;
        String str3;
        String str4;
        OfferOsagoDisplaySettingsDomain offerOsagoDisplaySettingsDomain;
        OsagoCompanyDetailEnum osagoCompanyDetailEnum;
        OfferOsagoCompanyDetailDomain offerOsagoCompanyDetailDomain;
        int i6;
        int i7;
        synchronized (this) {
            j = this.C;
            this.C = 0;
        }
        OfferOsagoDetailDomain offerOsagoDetailDomain = this.mOsagoDetail;
        int i8 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i8 != 0) {
            if (offerOsagoDetailDomain != null) {
                osagoCompanyDetailEnum = offerOsagoDetailDomain.getStatus();
                offerOsagoDisplaySettingsDomain = offerOsagoDetailDomain.getDisplaySettings();
                offerOsagoCompanyDetailDomain = offerOsagoDetailDomain.getCompanyDetail();
            } else {
                offerOsagoCompanyDetailDomain = null;
                osagoCompanyDetailEnum = null;
                offerOsagoDisplaySettingsDomain = null;
            }
            OsagoCompanyDetailEnum osagoCompanyDetailEnum2 = OsagoCompanyDetailEnum.OSAGO_SUCCESS;
            boolean z3 = true;
            z2 = osagoCompanyDetailEnum == osagoCompanyDetailEnum2;
            boolean z4 = osagoCompanyDetailEnum == OsagoCompanyDetailEnum.OSAGO_WAIT;
            boolean z5 = osagoCompanyDetailEnum != osagoCompanyDetailEnum2;
            if (osagoCompanyDetailEnum != OsagoCompanyDetailEnum.OSAGO_ERROR) {
                z3 = false;
            }
            if (i8 != 0) {
                j |= z2 ? 1024 : 512;
            }
            if ((j & 5) != 0) {
                j |= z4 ? 16 : 8;
            }
            if ((j & 5) != 0) {
                j |= z5 ? 256 : 128;
            }
            if ((j & 5) != 0) {
                j |= z3 ? 64 : 32;
            }
            if (offerOsagoDisplaySettingsDomain != null) {
                str3 = offerOsagoDisplaySettingsDomain.getProductName();
                i6 = offerOsagoDisplaySettingsDomain.getFontColor();
                str = offerOsagoDisplaySettingsDomain.getTitleIcon();
                i7 = offerOsagoDisplaySettingsDomain.getBackgroundColor();
            } else {
                str3 = null;
                i7 = 0;
                i6 = 0;
                str = null;
            }
            String sumValue = offerOsagoCompanyDetailDomain != null ? offerOsagoCompanyDetailDomain.getSumValue() : null;
            int i9 = 4;
            int i10 = z2 ? 0 : 4;
            int i11 = z4 ? 0 : 8;
            if (z5) {
                i9 = 0;
            }
            String string = this.A.getResources().getString(z3 ? R.string.load_price_fail : R.string.load_price);
            i2 = i6;
            i = i10;
            i4 = i7;
            i5 = i9;
            str4 = sumValue;
            i3 = i11;
            str2 = string;
        } else {
            str4 = null;
            str3 = null;
            i5 = 0;
            str2 = null;
            i4 = 0;
            str = null;
            i3 = 0;
            i2 = 0;
            z2 = false;
            i = 0;
        }
        if ((5 & j) != 0) {
            BindingViewKt.bindSetBackgroundColorToCardView(this.cvIconOsago, i4);
            this.llSumWaitOsago.setVisibility(i5);
            this.mbCarInfo.setEnabled(z2);
            this.z.setVisibility(i3);
            TextViewBindingAdapter.setText(this.A, str2);
            TextViewBindingAdapter.setText(this.tvIconOsago, str);
            this.tvIconOsago.setTextColor(i2);
            TextViewBindingAdapter.setText(this.tvNameOsago, str3);
            TextViewBindingAdapter.setText(this.tvSumOsago, str4);
            this.tvSumOsago.setVisibility(i);
        }
        if ((j & 4) != 0) {
            this.mbCarInfo.setOnClickListener(this.B);
            ProgressBar progressBar = this.z;
            BindingProgressBarKt.bindSetIndeterminateResTint(progressBar, ViewDataBinding.getColorFromResource(progressBar, R.color.battleship_grey_sravni));
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.C != 0) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.C = 4;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferOsagoListItemSravniBinding
    public void setOsagoDetail(@Nullable OfferOsagoDetailDomain offerOsagoDetailDomain) {
        this.mOsagoDetail = offerOsagoDetailDomain;
        synchronized (this) {
            this.C |= 1;
        }
        notifyPropertyChanged(BR.osagoDetail);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferOsagoListItemSravniBinding
    public void setSelectOfferOsago(@Nullable ISelectOfferOsago iSelectOfferOsago) {
        this.mSelectOfferOsago = iSelectOfferOsago;
        synchronized (this) {
            this.C |= 2;
        }
        notifyPropertyChanged(BR.selectOfferOsago);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.osagoDetail == i) {
            setOsagoDetail((OfferOsagoDetailDomain) obj);
        } else if (BR.selectOfferOsago != i) {
            return false;
        } else {
            setSelectOfferOsago((ISelectOfferOsago) obj);
        }
        return true;
    }
}
