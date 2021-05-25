package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LifecycleOwner;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.offer.product.entity.CardTypeEnum;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductDisplaySettingsDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.ProductStatusEnum;
import ru.sravni.android.bankproduct.domain.offer.product.entity.ProductTypeEnum;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailInfoDomain;
import ru.sravni.android.bankproduct.presentation.offer.product.adapter.BindingProductOfferAdapterKt;
import ru.sravni.android.bankproduct.utils.adapter.BindingImageViewKt;
import ru.sravni.android.bankproduct.utils.svg.entity.LogoInfo;
public class OfferProductInfoHeaderItemSravniBindingImpl extends OfferProductInfoHeaderItemSravniBinding {
    @Nullable
    public static final ViewDataBinding.IncludedLayouts C;
    @Nullable
    public static final SparseIntArray D;
    @Nullable
    public final OfferProductProfitabilitySravniBinding A;
    public long B = -1;
    @NonNull
    public final ConstraintLayout y;
    @Nullable
    public final OfferProductStatusSravniBinding z;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(17);
        C = includedLayouts;
        includedLayouts.setIncludes(11, new String[]{"offer_product_status_sravni", "offer_product_profitability_sravni"}, new int[]{12, 13}, new int[]{R.layout.offer_product_status_sravni, R.layout.offer_product_profitability_sravni});
        SparseIntArray sparseIntArray = new SparseIntArray();
        D = sparseIntArray;
        sparseIntArray.put(R.id.vOptional, 14);
        sparseIntArray.put(R.id.flIcon, 15);
        sparseIntArray.put(R.id.imgCreditSvgIcon, 16);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OfferProductInfoHeaderItemSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r20, @androidx.annotation.NonNull android.view.View r21) {
        /*
        // Method dump skipped, instructions count: 222
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferProductInfoHeaderItemSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        ProductStatusEnum productStatusEnum;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        OfferProductDisplaySettingsDomain offerProductDisplaySettingsDomain;
        int i8;
        String str7;
        String str8;
        int i9;
        String str9;
        String str10;
        CardTypeEnum cardTypeEnum;
        synchronized (this) {
            j = this.B;
            this.B = 0;
        }
        OfferProductDetailInfoDomain offerProductDetailInfoDomain = this.mDetailInfo;
        LogoInfo logoInfo = this.mLogoInfo;
        CardTypeEnum cardTypeEnum2 = null;
        int i10 = ((j & 5) > 0 ? 1 : ((j & 5) == 0 ? 0 : -1));
        if (i10 != 0) {
            if (offerProductDetailInfoDomain != null) {
                i8 = offerProductDetailInfoDomain.getProfitability();
                str4 = offerProductDetailInfoDomain.getStatusText();
                offerProductDisplaySettingsDomain = offerProductDetailInfoDomain.getDisplaySettings();
                productStatusEnum = offerProductDetailInfoDomain.getStatus();
                str6 = offerProductDetailInfoDomain.getProfitabilityText();
            } else {
                str6 = null;
                str4 = null;
                offerProductDisplaySettingsDomain = null;
                productStatusEnum = null;
                i8 = 0;
            }
            if (offerProductDisplaySettingsDomain != null) {
                CardTypeEnum cardType = offerProductDisplaySettingsDomain.getCardType();
                str10 = offerProductDisplaySettingsDomain.getTitleIcon();
                str9 = offerProductDisplaySettingsDomain.getOfferTitle();
                i9 = offerProductDisplaySettingsDomain.getFontColor();
                str8 = offerProductDisplaySettingsDomain.getBankName();
                i7 = offerProductDisplaySettingsDomain.getBackgroundColor();
                str7 = offerProductDisplaySettingsDomain.getProductName();
                ProductTypeEnum productType = offerProductDisplaySettingsDomain.getProductType();
                cardTypeEnum = cardType;
                cardTypeEnum2 = productType;
            } else {
                cardTypeEnum = null;
                str10 = null;
                str9 = null;
                str8 = null;
                str7 = null;
                i9 = 0;
                i7 = 0;
            }
            ProductStatusEnum productStatusEnum2 = ProductStatusEnum.NEW;
            boolean z2 = true;
            boolean z3 = productStatusEnum != productStatusEnum2;
            boolean z4 = productStatusEnum == productStatusEnum2;
            if (i10 != 0) {
                j |= z3 ? 64 : 32;
            }
            if ((j & 5) != 0) {
                j |= z4 ? 1024 : 512;
            }
            ProductTypeEnum productTypeEnum = ProductTypeEnum.CREDIT_CARD;
            boolean z5 = cardTypeEnum2 == productTypeEnum;
            if (cardTypeEnum2 == productTypeEnum) {
                z2 = false;
            }
            int i11 = z3 ? 0 : 8;
            int i12 = z4 ? 0 : 8;
            if ((j & 5) != 0) {
                j |= z5 ? 256 : 128;
            }
            if ((j & 5) != 0) {
                j |= z2 ? 16 : 8;
            }
            int i13 = z5 ? 0 : 8;
            i = i12;
            i2 = i11;
            cardTypeEnum2 = cardTypeEnum;
            str3 = str10;
            str2 = str9;
            i3 = i9;
            str = str7;
            i4 = z2 ? 0 : 8;
            i5 = i13;
            i6 = i8;
            str5 = str8;
        } else {
            str6 = null;
            str5 = null;
            str4 = null;
            str3 = null;
            str2 = null;
            str = null;
            productStatusEnum = null;
            i7 = 0;
            i6 = 0;
            i5 = 0;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        int i14 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if ((j & 5) != 0) {
            this.flCreditCardIcon.setVisibility(i5);
            this.flCreditIcon.setVisibility(i4);
            BindingImageViewKt.bindColorDrawableSource(this.imgCreditCardIcon, Integer.valueOf(i7));
            BindingProductOfferAdapterKt.bindTypeCardToImageView(this.imgCreditCardType, cardTypeEnum2, i3);
            BindingImageViewKt.bindColorDrawableSource(this.imgCreditIcon, Integer.valueOf(i7));
            this.z.getRoot().setVisibility(i2);
            this.z.setStatusEnum(productStatusEnum);
            this.z.setStatusText(str4);
            this.A.getRoot().setVisibility(i);
            this.A.setProfitability(Integer.valueOf(i6));
            this.A.setProfitabilityText(str6);
            TextViewBindingAdapter.setText(this.tvCompany, str5);
            TextViewBindingAdapter.setText(this.tvCreditCardIcon, str3);
            this.tvCreditCardIcon.setTextColor(i3);
            TextViewBindingAdapter.setText(this.tvCreditIcon, str3);
            this.tvCreditIcon.setTextColor(i3);
            TextViewBindingAdapter.setText(this.tvName, str2);
            TextViewBindingAdapter.setText(this.tvProductName, str);
        }
        if (i14 != 0) {
            BindingProductOfferAdapterKt.bindSvgUriToLogoFrameLayout(this.flCreditIcon, logoInfo);
        }
        ViewDataBinding.executeBindingsOn(this.z);
        ViewDataBinding.executeBindingsOn(this.A);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.B != 0) {
                return true;
            }
        }
        if (!this.z.hasPendingBindings() && !this.A.hasPendingBindings()) {
            return false;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.B = 4;
        }
        this.z.invalidateAll();
        this.A.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductInfoHeaderItemSravniBinding
    public void setDetailInfo(@Nullable OfferProductDetailInfoDomain offerProductDetailInfoDomain) {
        this.mDetailInfo = offerProductDetailInfoDomain;
        synchronized (this) {
            this.B |= 1;
        }
        notifyPropertyChanged(BR.detailInfo);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.z.setLifecycleOwner(lifecycleOwner);
        this.A.setLifecycleOwner(lifecycleOwner);
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductInfoHeaderItemSravniBinding
    public void setLogoInfo(@Nullable LogoInfo logoInfo) {
        this.mLogoInfo = logoInfo;
        synchronized (this) {
            this.B |= 2;
        }
        notifyPropertyChanged(BR.logoInfo);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.detailInfo == i) {
            setDetailInfo((OfferProductDetailInfoDomain) obj);
        } else if (BR.logoInfo != i) {
            return false;
        } else {
            setLogoInfo((LogoInfo) obj);
        }
        return true;
    }
}
