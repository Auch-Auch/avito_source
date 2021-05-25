package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.google.android.material.button.MaterialButton;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.presentation.offer.IOfferRetryErrorViewModel;
import ru.sravni.android.bankproduct.presentation.offer.product.IProductActionGetter;
import ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IClickOfferProduct;
import ru.sravni.android.bankproduct.presentation.offer.product.info.viewmodel.IOfferProductInfoControllerForLayout;
public class OfferProductInfoFragmentSravniBindingImpl extends OfferProductInfoFragmentSravniBinding implements OnClickListener.Listener {
    @Nullable
    public static final ViewDataBinding.IncludedLayouts F;
    @Nullable
    public static final SparseIntArray G;
    @Nullable
    public final WaitingLayoutSravniBinding A;
    @Nullable
    public final OfferProductDetailSravniBinding B;
    @NonNull
    public final MaterialButton C;
    @Nullable
    public final View.OnClickListener D;
    public long E = -1;
    @NonNull
    public final ConstraintLayout y;
    @Nullable
    public final WaitErrorFragmentSravniBinding z;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(10);
        F = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"wait_error_fragment_sravni", "waiting_layout_sravni"}, new int[]{6, 7}, new int[]{R.layout.wait_error_fragment_sravni, R.layout.waiting_layout_sravni});
        includedLayouts.setIncludes(3, new String[]{"offer_product_detail_sravni"}, new int[]{5}, new int[]{R.layout.offer_product_detail_sravni});
        SparseIntArray sparseIntArray = new SparseIntArray();
        G = sparseIntArray;
        sparseIntArray.put(R.id.appBarLayout, 8);
        sparseIntArray.put(R.id.vShadow, 9);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OfferProductInfoFragmentSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r12, @androidx.annotation.NonNull android.view.View r13) {
        /*
            r11 = this;
            androidx.databinding.ViewDataBinding$IncludedLayouts r0 = ru.sravni.android.bankproduct.databinding.OfferProductInfoFragmentSravniBindingImpl.F
            android.util.SparseIntArray r1 = ru.sravni.android.bankproduct.databinding.OfferProductInfoFragmentSravniBindingImpl.G
            r2 = 10
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r12, r13, r2, r0, r1)
            r1 = 8
            r1 = r0[r1]
            r6 = r1
            com.google.android.material.appbar.AppBarLayout r6 = (com.google.android.material.appbar.AppBarLayout) r6
            r1 = 3
            r1 = r0[r1]
            r7 = r1
            android.widget.FrameLayout r7 = (android.widget.FrameLayout) r7
            r1 = 2
            r1 = r0[r1]
            r8 = r1
            androidx.recyclerview.widget.RecyclerView r8 = (androidx.recyclerview.widget.RecyclerView) r8
            r1 = 1
            r2 = r0[r1]
            r9 = r2
            com.google.android.material.appbar.MaterialToolbar r9 = (com.google.android.material.appbar.MaterialToolbar) r9
            r2 = 9
            r2 = r0[r2]
            r10 = r2
            android.view.View r10 = (android.view.View) r10
            r5 = 6
            r2 = r11
            r3 = r12
            r4 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            r2 = -1
            r11.E = r2
            android.widget.FrameLayout r12 = r11.mbSendOffer
            r2 = 0
            r12.setTag(r2)
            r12 = 0
            r12 = r0[r12]
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            r11.y = r12
            r12.setTag(r2)
            r12 = 6
            r12 = r0[r12]
            ru.sravni.android.bankproduct.databinding.WaitErrorFragmentSravniBinding r12 = (ru.sravni.android.bankproduct.databinding.WaitErrorFragmentSravniBinding) r12
            r11.z = r12
            r11.setContainedBinding(r12)
            r12 = 7
            r12 = r0[r12]
            ru.sravni.android.bankproduct.databinding.WaitingLayoutSravniBinding r12 = (ru.sravni.android.bankproduct.databinding.WaitingLayoutSravniBinding) r12
            r11.A = r12
            r11.setContainedBinding(r12)
            r12 = 5
            r12 = r0[r12]
            ru.sravni.android.bankproduct.databinding.OfferProductDetailSravniBinding r12 = (ru.sravni.android.bankproduct.databinding.OfferProductDetailSravniBinding) r12
            r11.B = r12
            r11.setContainedBinding(r12)
            r12 = 4
            r12 = r0[r12]
            com.google.android.material.button.MaterialButton r12 = (com.google.android.material.button.MaterialButton) r12
            r11.C = r12
            r12.setTag(r2)
            androidx.recyclerview.widget.RecyclerView r12 = r11.rvInfo
            r12.setTag(r2)
            com.google.android.material.appbar.MaterialToolbar r12 = r11.toolbar
            r12.setTag(r2)
            r11.setRootTag(r13)
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r12 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r12.<init>(r11, r1)
            r11.D = r12
            r11.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferProductInfoFragmentSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        IClickOfferProduct iClickOfferProduct = this.mClickOfferProduct;
        if (iClickOfferProduct != null) {
            iClickOfferProduct.sendOffer();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:74:0x00d8, code lost:
        if (r12 != false) goto L_0x00da;
     */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x011e  */
    @Override // androidx.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
        // Method dump skipped, instructions count: 471
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferProductInfoFragmentSravniBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.E != 0) {
                return true;
            }
        }
        if (!this.B.hasPendingBindings() && !this.z.hasPendingBindings() && !this.A.hasPendingBindings()) {
            return false;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.E = 1024;
        }
        this.B.invalidateAll();
        this.z.invalidateAll();
        this.A.invalidateAll();
        requestRebind();
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Boolean;>;I)Z */
    public final boolean j(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.E |= 4;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Boolean;>;I)Z */
    public final boolean l(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.E |= 2;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/util/List<Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductDetailItemDomainWithLogoInfo;>;>;I)Z */
    public final boolean m(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.E |= 8;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductActionInfo;>;I)Z */
    public final boolean n(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.E |= 16;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Lru/sravni/android/bankproduct/domain/offer/product/entity/ProductStatusEnum;>;I)Z */
    public final boolean o(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.E |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            LiveData liveData = (LiveData) obj;
            return o(i2);
        } else if (i == 1) {
            LiveData liveData2 = (LiveData) obj;
            return l(i2);
        } else if (i == 2) {
            LiveData liveData3 = (LiveData) obj;
            return j(i2);
        } else if (i == 3) {
            LiveData liveData4 = (LiveData) obj;
            return m(i2);
        } else if (i == 4) {
            LiveData liveData5 = (LiveData) obj;
            return n(i2);
        } else if (i != 5) {
            return false;
        } else {
            LiveData liveData6 = (LiveData) obj;
            return p(i2);
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
    public final boolean p(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.E |= 32;
        }
        return true;
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductInfoFragmentSravniBinding
    public void setClickOfferProduct(@Nullable IClickOfferProduct iClickOfferProduct) {
        this.mClickOfferProduct = iClickOfferProduct;
        synchronized (this) {
            this.E |= 512;
        }
        notifyPropertyChanged(BR.clickOfferProduct);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.B.setLifecycleOwner(lifecycleOwner);
        this.z.setLifecycleOwner(lifecycleOwner);
        this.A.setLifecycleOwner(lifecycleOwner);
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductInfoFragmentSravniBinding
    public void setOfferProductInfoViewModel(@Nullable IOfferProductInfoControllerForLayout iOfferProductInfoControllerForLayout) {
        this.mOfferProductInfoViewModel = iOfferProductInfoControllerForLayout;
        synchronized (this) {
            this.E |= 256;
        }
        notifyPropertyChanged(BR.offerProductInfoViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductInfoFragmentSravniBinding
    public void setOfferRetryErrorViewModel(@Nullable IOfferRetryErrorViewModel iOfferRetryErrorViewModel) {
        this.mOfferRetryErrorViewModel = iOfferRetryErrorViewModel;
        synchronized (this) {
            this.E |= 64;
        }
        notifyPropertyChanged(BR.offerRetryErrorViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductInfoFragmentSravniBinding
    public void setProductAction(@Nullable IProductActionGetter iProductActionGetter) {
        this.mProductAction = iProductActionGetter;
        synchronized (this) {
            this.E |= 128;
        }
        notifyPropertyChanged(BR.productAction);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.offerRetryErrorViewModel == i) {
            setOfferRetryErrorViewModel((IOfferRetryErrorViewModel) obj);
        } else if (BR.productAction == i) {
            setProductAction((IProductActionGetter) obj);
        } else if (BR.offerProductInfoViewModel == i) {
            setOfferProductInfoViewModel((IOfferProductInfoControllerForLayout) obj);
        } else if (BR.clickOfferProduct != i) {
            return false;
        } else {
            setClickOfferProduct((IClickOfferProduct) obj);
        }
        return true;
    }
}
