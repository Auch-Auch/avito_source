package ru.sravni.android.bankproduct.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.material.card.MaterialCardView;
import java.util.List;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductDisplaySettingsDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.ProductStatusEnum;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.detail.OfferProductDetailInfoDomain;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.presentation.offer.product.entity.OfferProductActionInfo;
import ru.sravni.android.bankproduct.presentation.offer.product.list.adapter.BindingProductOfferListAdapterKt;
import ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.ISelectOfferProduct;
import ru.sravni.android.bankproduct.utils.svg.entity.LogoInfo;
public class OfferProductListItemSravniBindingImpl extends OfferProductListItemSravniBinding implements OnClickListener.Listener {
    @Nullable
    public static final ViewDataBinding.IncludedLayouts G;
    @Nullable
    public static final SparseIntArray H;
    @Nullable
    public final OfferProductDetailSravniBinding A;
    @Nullable
    public final OfferProductStatusSravniBinding B;
    @Nullable
    public final OfferProductProfitabilitySravniBinding C;
    @Nullable
    public final View.OnClickListener D;
    @Nullable
    public final View.OnClickListener E;
    public long F = -1;
    @NonNull
    public final MaterialCardView y;
    @NonNull
    public final ConstraintLayout z;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(11);
        G = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"offer_product_title_sravni", "offer_product_detail_sravni"}, new int[]{6, 9}, new int[]{R.layout.offer_product_title_sravni, R.layout.offer_product_detail_sravni});
        includedLayouts.setIncludes(3, new String[]{"offer_product_status_sravni", "offer_product_profitability_sravni"}, new int[]{7, 8}, new int[]{R.layout.offer_product_status_sravni, R.layout.offer_product_profitability_sravni});
        SparseIntArray sparseIntArray = new SparseIntArray();
        H = sparseIntArray;
        sparseIntArray.put(R.id.vOptional, 10);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OfferProductListItemSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r13, @androidx.annotation.NonNull android.view.View r14) {
        /*
            r12 = this;
            androidx.databinding.ViewDataBinding$IncludedLayouts r0 = ru.sravni.android.bankproduct.databinding.OfferProductListItemSravniBindingImpl.G
            android.util.SparseIntArray r1 = ru.sravni.android.bankproduct.databinding.OfferProductListItemSravniBindingImpl.H
            r2 = 11
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r13, r14, r2, r0, r1)
            r1 = 3
            r1 = r0[r1]
            r6 = r1
            android.widget.FrameLayout r6 = (android.widget.FrameLayout) r6
            r1 = 4
            r1 = r0[r1]
            r7 = r1
            com.google.android.material.button.MaterialButton r7 = (com.google.android.material.button.MaterialButton) r7
            r1 = 2
            r2 = r0[r1]
            r8 = r2
            ru.sravni.android.bankproduct.utils.components.recyclerview.UntouchableRecyclerView r8 = (ru.sravni.android.bankproduct.utils.components.recyclerview.UntouchableRecyclerView) r8
            r2 = 5
            r2 = r0[r2]
            r9 = r2
            android.view.View r9 = (android.view.View) r9
            r2 = 6
            r2 = r0[r2]
            r10 = r2
            ru.sravni.android.bankproduct.databinding.OfferProductTitleSravniBinding r10 = (ru.sravni.android.bankproduct.databinding.OfferProductTitleSravniBinding) r10
            r2 = 10
            r2 = r0[r2]
            r11 = r2
            android.view.View r11 = (android.view.View) r11
            r5 = 1
            r2 = r12
            r3 = r13
            r4 = r14
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r2 = -1
            r12.F = r2
            android.widget.FrameLayout r13 = r12.flStatus
            r2 = 0
            r13.setTag(r2)
            com.google.android.material.button.MaterialButton r13 = r12.mbSendOffer
            r13.setTag(r2)
            r13 = 0
            r13 = r0[r13]
            com.google.android.material.card.MaterialCardView r13 = (com.google.android.material.card.MaterialCardView) r13
            r12.y = r13
            r13.setTag(r2)
            r13 = 1
            r3 = r0[r13]
            androidx.constraintlayout.widget.ConstraintLayout r3 = (androidx.constraintlayout.widget.ConstraintLayout) r3
            r12.z = r3
            r3.setTag(r2)
            r3 = 9
            r3 = r0[r3]
            ru.sravni.android.bankproduct.databinding.OfferProductDetailSravniBinding r3 = (ru.sravni.android.bankproduct.databinding.OfferProductDetailSravniBinding) r3
            r12.A = r3
            r12.setContainedBinding(r3)
            r3 = 7
            r3 = r0[r3]
            ru.sravni.android.bankproduct.databinding.OfferProductStatusSravniBinding r3 = (ru.sravni.android.bankproduct.databinding.OfferProductStatusSravniBinding) r3
            r12.B = r3
            r12.setContainedBinding(r3)
            r3 = 8
            r0 = r0[r3]
            ru.sravni.android.bankproduct.databinding.OfferProductProfitabilitySravniBinding r0 = (ru.sravni.android.bankproduct.databinding.OfferProductProfitabilitySravniBinding) r0
            r12.C = r0
            r12.setContainedBinding(r0)
            ru.sravni.android.bankproduct.utils.components.recyclerview.UntouchableRecyclerView r0 = r12.rvInfo
            r0.setTag(r2)
            android.view.View r0 = r12.statusLine
            r0.setTag(r2)
            r12.setRootTag(r14)
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r14 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r14.<init>(r12, r1)
            r12.D = r14
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r14 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r14.<init>(r12, r13)
            r12.E = r14
            r12.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferProductListItemSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z2 = false;
        if (i == 1) {
            OfferProductDetailDomain offerProductDetailDomain = this.mOffer;
            ISelectOfferProduct iSelectOfferProduct = this.mSelectOfferProduct;
            if (iSelectOfferProduct != null) {
                z2 = true;
            }
            if (z2) {
                iSelectOfferProduct.clickProduct(offerProductDetailDomain);
            }
        } else if (i == 2) {
            OfferProductDetailDomain offerProductDetailDomain2 = this.mOffer;
            ISelectOfferProduct iSelectOfferProduct2 = this.mSelectOfferProduct;
            if (iSelectOfferProduct2 != null) {
                z2 = true;
            }
            if (z2) {
                iSelectOfferProduct2.sendOffer(offerProductDetailDomain2);
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        int i2;
        int i3;
        int i4;
        OfferProductDisplaySettingsDomain offerProductDisplaySettingsDomain;
        List<OfferProductDetailDomain.MainParam> list;
        String str;
        String str2;
        OfferProductDetailInfoDomain offerProductDetailInfoDomain;
        List<OfferProductDetailDomain.MainParam> list2;
        String str3;
        OfferProductDisplaySettingsDomain offerProductDisplaySettingsDomain2;
        int i5;
        long j2;
        long j3;
        synchronized (this) {
            j = this.F;
            this.F = 0;
        }
        OfferProductDetailDomain offerProductDetailDomain = this.mOffer;
        OfferProductActionInfo offerProductActionInfo = this.mOfferProductStatusInfo;
        ISelectOfferProduct iSelectOfferProduct = this.mSelectOfferProduct;
        LogoInfo logoInfo = this.mLogoInfo;
        ProductStatusEnum productStatusEnum = null;
        int i6 = ((j & 34) > 0 ? 1 : ((j & 34) == 0 ? 0 : -1));
        if (i6 != 0) {
            if (offerProductDetailDomain != null) {
                offerProductDetailInfoDomain = offerProductDetailDomain.getDetailInfo();
                list2 = offerProductDetailDomain.getMainParams();
            } else {
                list2 = null;
                offerProductDetailInfoDomain = null;
            }
            if (offerProductDetailInfoDomain != null) {
                i5 = offerProductDetailInfoDomain.getProfitability();
                productStatusEnum = offerProductDetailInfoDomain.getStatus();
                offerProductDisplaySettingsDomain2 = offerProductDetailInfoDomain.getDisplaySettings();
                str3 = offerProductDetailInfoDomain.getProfitabilityText();
                str = offerProductDetailInfoDomain.getStatusText();
            } else {
                str = null;
                offerProductDisplaySettingsDomain2 = null;
                str3 = null;
                i5 = 0;
            }
            ProductStatusEnum productStatusEnum2 = ProductStatusEnum.NEW;
            boolean z2 = true;
            boolean z3 = productStatusEnum == productStatusEnum2;
            if (productStatusEnum == productStatusEnum2) {
                z2 = false;
            }
            if (i6 != 0) {
                if (z3) {
                    j3 = j | 128;
                    j2 = 512;
                } else {
                    j3 = j | 64;
                    j2 = 256;
                }
                j = j3 | j2;
            }
            if ((j & 34) != 0) {
                j |= z2 ? PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH : 1024;
            }
            int i7 = z3 ? 0 : 4;
            int i8 = 8;
            int i9 = z3 ? 0 : 8;
            if (z2) {
                i8 = 0;
            }
            i3 = i5;
            i2 = i8;
            i = i9;
            list = list2;
            i4 = i7;
            offerProductDisplaySettingsDomain = offerProductDisplaySettingsDomain2;
            str2 = str3;
        } else {
            str2 = null;
            str = null;
            list = null;
            offerProductDisplaySettingsDomain = null;
            i4 = 0;
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        int i10 = ((j & 36) > 0 ? 1 : ((j & 36) == 0 ? 0 : -1));
        int i11 = ((j & 40) > 0 ? 1 : ((j & 40) == 0 ? 0 : -1));
        int i12 = ((j & 48) > 0 ? 1 : ((j & 48) == 0 ? 0 : -1));
        if ((j & 32) != 0) {
            this.mbSendOffer.setOnClickListener(this.D);
            this.y.setOnClickListener(this.E);
        }
        if ((j & 34) != 0) {
            this.mbSendOffer.setVisibility(i4);
            this.A.getRoot().setVisibility(i2);
            this.B.getRoot().setVisibility(i2);
            this.B.setStatusEnum(productStatusEnum);
            this.B.setStatusText(str);
            this.C.getRoot().setVisibility(i);
            this.C.setProfitability(Integer.valueOf(i3));
            this.C.setProfitabilityText(str2);
            BindingProductOfferListAdapterKt.bindListParamToRecycler(this.rvInfo, list);
            this.statusLine.setVisibility(i2);
            this.title.setOfferTitleInfo(offerProductDisplaySettingsDomain);
        }
        if (i10 != 0) {
            this.A.setOfferProductStatusInfo(offerProductActionInfo);
        }
        if (i11 != 0) {
            this.A.setProductActionGetter(iSelectOfferProduct);
        }
        if (i12 != 0) {
            this.title.setLogoInfo(logoInfo);
        }
        ViewDataBinding.executeBindingsOn(this.title);
        ViewDataBinding.executeBindingsOn(this.B);
        ViewDataBinding.executeBindingsOn(this.C);
        ViewDataBinding.executeBindingsOn(this.A);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.F != 0) {
                return true;
            }
        }
        if (!this.title.hasPendingBindings() && !this.B.hasPendingBindings() && !this.C.hasPendingBindings() && !this.A.hasPendingBindings()) {
            return false;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.F = 32;
        }
        this.title.invalidateAll();
        this.B.invalidateAll();
        this.C.invalidateAll();
        this.A.invalidateAll();
        requestRebind();
    }

    public final boolean j(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.F |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        OfferProductTitleSravniBinding offerProductTitleSravniBinding = (OfferProductTitleSravniBinding) obj;
        return j(i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.title.setLifecycleOwner(lifecycleOwner);
        this.B.setLifecycleOwner(lifecycleOwner);
        this.C.setLifecycleOwner(lifecycleOwner);
        this.A.setLifecycleOwner(lifecycleOwner);
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductListItemSravniBinding
    public void setLogoInfo(@Nullable LogoInfo logoInfo) {
        this.mLogoInfo = logoInfo;
        synchronized (this) {
            this.F |= 16;
        }
        notifyPropertyChanged(BR.logoInfo);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductListItemSravniBinding
    public void setOffer(@Nullable OfferProductDetailDomain offerProductDetailDomain) {
        this.mOffer = offerProductDetailDomain;
        synchronized (this) {
            this.F |= 2;
        }
        notifyPropertyChanged(BR.offer);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductListItemSravniBinding
    public void setOfferProductStatusInfo(@Nullable OfferProductActionInfo offerProductActionInfo) {
        this.mOfferProductStatusInfo = offerProductActionInfo;
        synchronized (this) {
            this.F |= 4;
        }
        notifyPropertyChanged(BR.offerProductStatusInfo);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductListItemSravniBinding
    public void setSelectOfferProduct(@Nullable ISelectOfferProduct iSelectOfferProduct) {
        this.mSelectOfferProduct = iSelectOfferProduct;
        synchronized (this) {
            this.F |= 8;
        }
        notifyPropertyChanged(BR.selectOfferProduct);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.offer == i) {
            setOffer((OfferProductDetailDomain) obj);
        } else if (BR.offerProductStatusInfo == i) {
            setOfferProductStatusInfo((OfferProductActionInfo) obj);
        } else if (BR.selectOfferProduct == i) {
            setSelectOfferProduct((ISelectOfferProduct) obj);
        } else if (BR.logoInfo != i) {
            return false;
        } else {
            setLogoInfo((LogoInfo) obj);
        }
        return true;
    }
}
