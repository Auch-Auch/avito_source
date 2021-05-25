package ru.sravni.android.bankproduct.databinding;

import android.content.res.Resources;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
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
public class OfferOsagoListProlongationItemSravniBindingImpl extends OfferOsagoListProlongationItemSravniBinding implements OnClickListener.Listener {
    @NonNull
    public final ProgressBar A;
    @NonNull
    public final TextView B;
    @NonNull
    public final TextView C;
    @Nullable
    public final View.OnClickListener D;
    @Nullable
    public final View.OnClickListener E;
    public long F = -1;
    @NonNull
    public final CardView y;
    @NonNull
    public final TextView z;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OfferOsagoListProlongationItemSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r18, @androidx.annotation.NonNull android.view.View r19) {
        /*
            r17 = this;
            r11 = r17
            r12 = r19
            r0 = 12
            r13 = 0
            r1 = r18
            java.lang.Object[] r14 = androidx.databinding.ViewDataBinding.mapBindings(r1, r12, r0, r13, r13)
            r15 = 1
            r0 = r14[r15]
            r4 = r0
            androidx.cardview.widget.CardView r4 = (androidx.cardview.widget.CardView) r4
            r0 = 8
            r0 = r14[r0]
            r5 = r0
            android.widget.LinearLayout r5 = (android.widget.LinearLayout) r5
            r0 = 5
            r0 = r14[r0]
            r6 = r0
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            r0 = 11
            r0 = r14[r0]
            r7 = r0
            com.google.android.material.button.MaterialButton r7 = (com.google.android.material.button.MaterialButton) r7
            r10 = 2
            r0 = r14[r10]
            r8 = r0
            android.widget.TextView r8 = (android.widget.TextView) r8
            r0 = 3
            r0 = r14[r0]
            r9 = r0
            android.widget.TextView r9 = (android.widget.TextView) r9
            r0 = 4
            r0 = r14[r0]
            r16 = r0
            android.widget.TextView r16 = (android.widget.TextView) r16
            r3 = 0
            r0 = r17
            r1 = r18
            r2 = r19
            r15 = 2
            r10 = r16
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r0 = -1
            r11.F = r0
            androidx.cardview.widget.CardView r0 = r11.cvIconOsago
            r0.setTag(r13)
            android.widget.LinearLayout r0 = r11.llDescriptionProlongation
            r0.setTag(r13)
            android.widget.LinearLayout r0 = r11.llSumWaitOsago
            r0.setTag(r13)
            com.google.android.material.button.MaterialButton r0 = r11.mbCarInfo
            r0.setTag(r13)
            r0 = 0
            r0 = r14[r0]
            androidx.cardview.widget.CardView r0 = (androidx.cardview.widget.CardView) r0
            r11.y = r0
            r0.setTag(r13)
            r0 = 10
            r0 = r14[r0]
            android.widget.TextView r0 = (android.widget.TextView) r0
            r11.z = r0
            r0.setTag(r13)
            r0 = 6
            r0 = r14[r0]
            android.widget.ProgressBar r0 = (android.widget.ProgressBar) r0
            r11.A = r0
            r0.setTag(r13)
            r0 = 7
            r0 = r14[r0]
            android.widget.TextView r0 = (android.widget.TextView) r0
            r11.B = r0
            r0.setTag(r13)
            r0 = 9
            r0 = r14[r0]
            android.widget.TextView r0 = (android.widget.TextView) r0
            r11.C = r0
            r0.setTag(r13)
            android.widget.TextView r0 = r11.tvIconOsago
            r0.setTag(r13)
            android.widget.TextView r0 = r11.tvNameOsago
            r0.setTag(r13)
            android.widget.TextView r0 = r11.tvSumOsago
            r0.setTag(r13)
            r11.setRootTag(r12)
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r0 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r0.<init>(r11, r15)
            r11.D = r0
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r0 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r1 = 1
            r0.<init>(r11, r1)
            r11.E = r0
            r17.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferOsagoListProlongationItemSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z2 = false;
        if (i == 1) {
            ISelectOfferOsago iSelectOfferOsago = this.mSelectOfferOsago;
            OfferOsagoDetailDomain offerOsagoDetailDomain = this.mOsagoDetail;
            if (iSelectOfferOsago != null) {
                if (offerOsagoDetailDomain != null) {
                    OfferOsagoCompanyDetailDomain companyDetail = offerOsagoDetailDomain.getCompanyDetail();
                    if (companyDetail != null) {
                        z2 = true;
                    }
                    if (z2) {
                        iSelectOfferOsago.clickProlongationInfo(companyDetail.getStatusDescription());
                    }
                }
            }
        } else if (i == 2) {
            ISelectOfferOsago iSelectOfferOsago2 = this.mSelectOfferOsago;
            OfferOsagoDetailDomain offerOsagoDetailDomain2 = this.mOsagoDetail;
            if (iSelectOfferOsago2 != null) {
                z2 = true;
            }
            if (z2) {
                iSelectOfferOsago2.selectedOsago(offerOsagoDetailDomain2);
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        int i2;
        String str;
        String str2;
        boolean z2;
        int i3;
        int i4;
        boolean z3;
        int i5;
        int i6;
        String str3;
        int i7;
        String str4;
        String str5;
        OfferOsagoCompanyDetailDomain offerOsagoCompanyDetailDomain;
        OfferOsagoDisplaySettingsDomain offerOsagoDisplaySettingsDomain;
        OsagoCompanyDetailEnum osagoCompanyDetailEnum;
        int i8;
        int i9;
        String str6;
        String str7;
        String str8;
        int i10;
        Resources resources;
        synchronized (this) {
            j = this.F;
            this.F = 0;
        }
        OfferOsagoDetailDomain offerOsagoDetailDomain = this.mOsagoDetail;
        String str9 = null;
        int i11 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i11 != 0) {
            if (offerOsagoDetailDomain != null) {
                offerOsagoDisplaySettingsDomain = offerOsagoDetailDomain.getDisplaySettings();
                offerOsagoCompanyDetailDomain = offerOsagoDetailDomain.getCompanyDetail();
                osagoCompanyDetailEnum = offerOsagoDetailDomain.getStatus();
            } else {
                osagoCompanyDetailEnum = null;
                offerOsagoDisplaySettingsDomain = null;
                offerOsagoCompanyDetailDomain = null;
            }
            if (offerOsagoDisplaySettingsDomain != null) {
                str6 = offerOsagoDisplaySettingsDomain.getProductName();
                i9 = offerOsagoDisplaySettingsDomain.getBackgroundColor();
                i8 = offerOsagoDisplaySettingsDomain.getFontColor();
                str3 = offerOsagoDisplaySettingsDomain.getTitleIcon();
            } else {
                str3 = null;
                str6 = null;
                i9 = 0;
                i8 = 0;
            }
            if (offerOsagoCompanyDetailDomain != null) {
                str9 = offerOsagoCompanyDetailDomain.getLinkText();
                str7 = offerOsagoCompanyDetailDomain.getStatusText();
                str8 = offerOsagoCompanyDetailDomain.getSumValue();
            } else {
                str8 = null;
                str7 = null;
            }
            OsagoCompanyDetailEnum osagoCompanyDetailEnum2 = OsagoCompanyDetailEnum.OSAGO_SUCCESS;
            boolean z4 = true;
            boolean z5 = osagoCompanyDetailEnum == osagoCompanyDetailEnum2;
            boolean z7 = osagoCompanyDetailEnum == OsagoCompanyDetailEnum.OSAGO_WAIT;
            boolean z8 = osagoCompanyDetailEnum != osagoCompanyDetailEnum2;
            boolean z9 = osagoCompanyDetailEnum == OsagoCompanyDetailEnum.OSAGO_ERROR;
            if (i11 != 0) {
                j |= z5 ? 1024 : 512;
            }
            if ((j & 5) != 0) {
                j |= z7 ? 16 : 8;
            }
            if ((j & 5) != 0) {
                j |= z8 ? 256 : 128;
            }
            if ((j & 5) != 0) {
                j |= z9 ? 64 : 32;
            }
            boolean z10 = str9 != null;
            boolean z11 = str9 == null;
            if (str7 == null) {
                z4 = false;
            }
            int i12 = 4;
            int i13 = z5 ? 0 : 4;
            int i14 = z7 ? 0 : 8;
            if (z8) {
                i12 = 0;
            }
            if (z9) {
                resources = this.B.getResources();
                i10 = R.string.load_price_fail;
            } else {
                resources = this.B.getResources();
                i10 = R.string.load_price;
            }
            str5 = resources.getString(i10);
            if ((j & 5) != 0) {
                j |= z11 ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            if ((j & 5) != 0) {
                j |= z4 ? 16384 : PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            int i15 = z11 ? 8 : 0;
            z3 = z10;
            i5 = i9;
            i2 = i8;
            z2 = z5;
            i3 = i12;
            i = i13;
            i4 = i14;
            str4 = str7;
            str2 = str8;
            i6 = i15;
            i7 = z4 ? 0 : 8;
            str = str6;
        } else {
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i7 = 0;
            i6 = 0;
            i5 = 0;
            z3 = false;
            i4 = 0;
            i3 = 0;
            z2 = false;
            i2 = 0;
            i = 0;
        }
        if ((5 & j) != 0) {
            BindingViewKt.bindSetBackgroundColorToCardView(this.cvIconOsago, i5);
            this.llDescriptionProlongation.setVisibility(i7);
            ViewBindingAdapter.setOnClick(this.llDescriptionProlongation, this.E, z3);
            this.llSumWaitOsago.setVisibility(i3);
            this.mbCarInfo.setEnabled(z2);
            TextViewBindingAdapter.setText(this.z, str9);
            this.z.setVisibility(i6);
            this.A.setVisibility(i4);
            TextViewBindingAdapter.setText(this.B, str5);
            TextViewBindingAdapter.setText(this.C, str4);
            TextViewBindingAdapter.setText(this.tvIconOsago, str3);
            this.tvIconOsago.setTextColor(i2);
            TextViewBindingAdapter.setText(this.tvNameOsago, str);
            TextViewBindingAdapter.setText(this.tvSumOsago, str2);
            this.tvSumOsago.setVisibility(i);
        }
        if ((j & 4) != 0) {
            this.mbCarInfo.setOnClickListener(this.D);
            ProgressBar progressBar = this.A;
            BindingProgressBarKt.bindSetIndeterminateResTint(progressBar, ViewDataBinding.getColorFromResource(progressBar, R.color.battleship_grey_sravni));
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.F != 0) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.F = 4;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferOsagoListProlongationItemSravniBinding
    public void setOsagoDetail(@Nullable OfferOsagoDetailDomain offerOsagoDetailDomain) {
        this.mOsagoDetail = offerOsagoDetailDomain;
        synchronized (this) {
            this.F |= 1;
        }
        notifyPropertyChanged(BR.osagoDetail);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferOsagoListProlongationItemSravniBinding
    public void setSelectOfferOsago(@Nullable ISelectOfferOsago iSelectOfferOsago) {
        this.mSelectOfferOsago = iSelectOfferOsago;
        synchronized (this) {
            this.F |= 2;
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
