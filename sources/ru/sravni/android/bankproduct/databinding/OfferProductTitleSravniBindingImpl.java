package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.adapters.TextViewBindingAdapter;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.offer.product.entity.CardTypeEnum;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductDisplaySettingsDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.ProductTypeEnum;
import ru.sravni.android.bankproduct.presentation.offer.product.adapter.BindingProductOfferAdapterKt;
import ru.sravni.android.bankproduct.utils.adapter.BindingImageViewKt;
import ru.sravni.android.bankproduct.utils.svg.entity.LogoInfo;
public class OfferProductTitleSravniBindingImpl extends OfferProductTitleSravniBinding {
    @Nullable
    public static final SparseIntArray A;
    @NonNull
    public final ConstraintLayout y;
    public long z = -1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        A = sparseIntArray;
        sparseIntArray.put(R.id.vOptional, 11);
        sparseIntArray.put(R.id.flIcon, 12);
        sparseIntArray.put(R.id.imgCreditSvgIcon, 13);
        sparseIntArray.put(R.id.vLine, 14);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OfferProductTitleSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r20, @androidx.annotation.NonNull android.view.View r21) {
        /*
        // Method dump skipped, instructions count: 196
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferProductTitleSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        String str;
        String str2;
        int i2;
        int i3;
        String str3;
        int i4;
        String str4;
        CardTypeEnum cardTypeEnum;
        String str5;
        int i5;
        int i6;
        synchronized (this) {
            j = this.z;
            this.z = 0;
        }
        LogoInfo logoInfo = this.mLogoInfo;
        OfferProductDisplaySettingsDomain offerProductDisplaySettingsDomain = this.mOfferTitleInfo;
        CardTypeEnum cardTypeEnum2 = null;
        int i7 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (i7 != 0) {
            if (offerProductDisplaySettingsDomain != null) {
                String offerTitle = offerProductDisplaySettingsDomain.getOfferTitle();
                i5 = offerProductDisplaySettingsDomain.getBackgroundColor();
                String titleIcon = offerProductDisplaySettingsDomain.getTitleIcon();
                ProductTypeEnum productType = offerProductDisplaySettingsDomain.getProductType();
                str = offerProductDisplaySettingsDomain.getProductName();
                str5 = offerProductDisplaySettingsDomain.getBankName();
                cardTypeEnum = offerProductDisplaySettingsDomain.getCardType();
                i6 = offerProductDisplaySettingsDomain.getFontColor();
                str2 = titleIcon;
                str3 = offerTitle;
                cardTypeEnum2 = productType;
            } else {
                str3 = null;
                str2 = null;
                str = null;
                str5 = null;
                cardTypeEnum = null;
                i6 = 0;
                i5 = 0;
            }
            ProductTypeEnum productTypeEnum = ProductTypeEnum.CREDIT_CARD;
            boolean z2 = true;
            boolean z3 = cardTypeEnum2 == productTypeEnum;
            if (cardTypeEnum2 == productTypeEnum) {
                z2 = false;
            }
            if (i7 != 0) {
                j |= z3 ? 64 : 32;
            }
            if ((j & 6) != 0) {
                j |= z2 ? 16 : 8;
            }
            i3 = z3 ? 0 : 8;
            i2 = i6;
            str4 = str5;
            cardTypeEnum2 = cardTypeEnum;
            i = i5;
            i4 = z2 ? 0 : 8;
        } else {
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        if ((6 & j) != 0) {
            this.flCreditCardIcon.setVisibility(i3);
            this.flCreditIcon.setVisibility(i4);
            BindingImageViewKt.bindColorDrawableSource(this.imgCreditCardIcon, Integer.valueOf(i));
            BindingProductOfferAdapterKt.bindTypeCardToImageView(this.imgCreditCardType, cardTypeEnum2, i2);
            BindingImageViewKt.bindColorDrawableSource(this.imgCreditIcon, Integer.valueOf(i));
            TextViewBindingAdapter.setText(this.tvCompany, str4);
            TextViewBindingAdapter.setText(this.tvCreditCardIcon, str2);
            this.tvCreditCardIcon.setTextColor(i2);
            TextViewBindingAdapter.setText(this.tvCreditIcon, str2);
            this.tvCreditIcon.setTextColor(i2);
            TextViewBindingAdapter.setText(this.tvName, str3);
            TextViewBindingAdapter.setText(this.tvProductName, str);
        }
        if ((j & 5) != 0) {
            BindingProductOfferAdapterKt.bindSvgUriToLogoFrameLayout(this.flCreditIcon, logoInfo);
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

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductTitleSravniBinding
    public void setLogoInfo(@Nullable LogoInfo logoInfo) {
        this.mLogoInfo = logoInfo;
        synchronized (this) {
            this.z |= 1;
        }
        notifyPropertyChanged(BR.logoInfo);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductTitleSravniBinding
    public void setOfferTitleInfo(@Nullable OfferProductDisplaySettingsDomain offerProductDisplaySettingsDomain) {
        this.mOfferTitleInfo = offerProductDisplaySettingsDomain;
        synchronized (this) {
            this.z |= 2;
        }
        notifyPropertyChanged(BR.offerTitleInfo);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.logoInfo == i) {
            setLogoInfo((LogoInfo) obj);
        } else if (BR.offerTitleInfo != i) {
            return false;
        } else {
            setOfferTitleInfo((OfferProductDisplaySettingsDomain) obj);
        }
        return true;
    }
}
