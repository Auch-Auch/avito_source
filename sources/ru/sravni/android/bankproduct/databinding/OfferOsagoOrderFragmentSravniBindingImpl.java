package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.presentation.offer.entity.UrlInfo;
import ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.IOfferOsagoOrderViewModel;
public class OfferOsagoOrderFragmentSravniBindingImpl extends OfferOsagoOrderFragmentSravniBinding implements OnClickListener.Listener {
    @Nullable
    public static final ViewDataBinding.IncludedLayouts F;
    @Nullable
    public static final SparseIntArray G;
    @Nullable
    public final OfferOsagoOrderWaitErrorSravniBinding A;
    @Nullable
    public final OfferOsagoOrderQuoteSravniBinding B;
    @Nullable
    public final View.OnClickListener C;
    @Nullable
    public final View.OnClickListener D;
    public long E = -1;
    @NonNull
    public final ConstraintLayout y;
    @Nullable
    public final OfferOsagoOrderInfoSravniBinding z;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(10);
        F = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"offer_osago_order_info_sravni", "offer_osago_order_wait_error_sravni", "offer_osago_order_quote_sravni", "offer_osago_order_status_sravni"}, new int[]{5, 6, 7, 8}, new int[]{R.layout.offer_osago_order_info_sravni, R.layout.offer_osago_order_wait_error_sravni, R.layout.offer_osago_order_quote_sravni, R.layout.offer_osago_order_status_sravni});
        SparseIntArray sparseIntArray = new SparseIntArray();
        G = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 9);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OfferOsagoOrderFragmentSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r14, @androidx.annotation.NonNull android.view.View r15) {
        /*
            r13 = this;
            androidx.databinding.ViewDataBinding$IncludedLayouts r0 = ru.sravni.android.bankproduct.databinding.OfferOsagoOrderFragmentSravniBindingImpl.F
            android.util.SparseIntArray r1 = ru.sravni.android.bankproduct.databinding.OfferOsagoOrderFragmentSravniBindingImpl.G
            r2 = 10
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r14, r15, r2, r0, r1)
            r1 = 3
            r1 = r0[r1]
            r6 = r1
            com.google.android.material.button.MaterialButton r6 = (com.google.android.material.button.MaterialButton) r6
            r1 = 4
            r1 = r0[r1]
            r7 = r1
            com.google.android.material.button.MaterialButton r7 = (com.google.android.material.button.MaterialButton) r7
            r1 = 2
            r2 = r0[r1]
            r8 = r2
            android.widget.FrameLayout r8 = (android.widget.FrameLayout) r8
            r2 = 8
            r2 = r0[r2]
            r9 = r2
            ru.sravni.android.bankproduct.databinding.OfferOsagoOrderStatusSravniBinding r9 = (ru.sravni.android.bankproduct.databinding.OfferOsagoOrderStatusSravniBinding) r9
            r12 = 1
            r2 = r0[r12]
            r10 = r2
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            r2 = 9
            r2 = r0[r2]
            r11 = r2
            androidx.appcompat.widget.Toolbar r11 = (androidx.appcompat.widget.Toolbar) r11
            r5 = 7
            r2 = r13
            r3 = r14
            r4 = r15
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r2 = -1
            r13.E = r2
            com.google.android.material.button.MaterialButton r14 = r13.btnCloseOsago
            r2 = 0
            r14.setTag(r2)
            com.google.android.material.button.MaterialButton r14 = r13.btnPaymentOsago
            r14.setTag(r2)
            android.widget.FrameLayout r14 = r13.frBtnSection
            r14.setTag(r2)
            android.widget.LinearLayout r14 = r13.llViewSection
            r14.setTag(r2)
            r14 = 0
            r14 = r0[r14]
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            r13.y = r14
            r14.setTag(r2)
            r14 = 5
            r14 = r0[r14]
            ru.sravni.android.bankproduct.databinding.OfferOsagoOrderInfoSravniBinding r14 = (ru.sravni.android.bankproduct.databinding.OfferOsagoOrderInfoSravniBinding) r14
            r13.z = r14
            r13.setContainedBinding(r14)
            r14 = 6
            r14 = r0[r14]
            ru.sravni.android.bankproduct.databinding.OfferOsagoOrderWaitErrorSravniBinding r14 = (ru.sravni.android.bankproduct.databinding.OfferOsagoOrderWaitErrorSravniBinding) r14
            r13.A = r14
            r13.setContainedBinding(r14)
            r14 = 7
            r14 = r0[r14]
            ru.sravni.android.bankproduct.databinding.OfferOsagoOrderQuoteSravniBinding r14 = (ru.sravni.android.bankproduct.databinding.OfferOsagoOrderQuoteSravniBinding) r14
            r13.B = r14
            r13.setContainedBinding(r14)
            r13.setRootTag(r15)
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r14 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r14.<init>(r13, r1)
            r13.C = r14
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r14 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r14.<init>(r13, r12)
            r13.D = r14
            r13.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferOsagoOrderFragmentSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z2 = false;
        if (i == 1) {
            IOfferOsagoOrderViewModel iOfferOsagoOrderViewModel = this.mOfferOsagoOrderViewModel;
            if (iOfferOsagoOrderViewModel != null) {
                z2 = true;
            }
            if (z2) {
                iOfferOsagoOrderViewModel.closeAction();
            }
        } else if (i == 2) {
            IOfferOsagoOrderViewModel iOfferOsagoOrderViewModel2 = this.mOfferOsagoOrderViewModel;
            if (iOfferOsagoOrderViewModel2 != null) {
                LiveData<UrlInfo> urlInfo = iOfferOsagoOrderViewModel2.getUrlInfo();
                if (urlInfo != null) {
                    z2 = true;
                }
                if (z2) {
                    iOfferOsagoOrderViewModel2.openWebAction(urlInfo.getValue());
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:123:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0188  */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00c5  */
    @Override // androidx.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
        // Method dump skipped, instructions count: 827
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferOsagoOrderFragmentSravniBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.E != 0) {
                return true;
            }
        }
        if (!this.z.hasPendingBindings() && !this.A.hasPendingBindings() && !this.B.hasPendingBindings() && !this.incStatusView.hasPendingBindings()) {
            return false;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.E = 256;
        }
        this.z.invalidateAll();
        this.A.invalidateAll();
        this.B.invalidateAll();
        this.incStatusView.invalidateAll();
        requestRebind();
    }

    public final boolean j(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.E |= 32;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Integer;>;I)Z */
    public final boolean l(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.E |= 8;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderDomain;>;I)Z */
    public final boolean m(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.E |= 16;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Lru/sravni/android/bankproduct/presentation/offer/osago/order/viewmodel/OsagoOrderButtonState;>;I)Z */
    public final boolean n(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.E |= 1;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Lru/sravni/android/bankproduct/presentation/offer/osago/order/viewmodel/OsagoOrderState;>;I)Z */
    public final boolean o(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.E |= 4;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                LiveData liveData = (LiveData) obj;
                return n(i2);
            case 1:
                LiveData liveData2 = (LiveData) obj;
                return q(i2);
            case 2:
                LiveData liveData3 = (LiveData) obj;
                return o(i2);
            case 3:
                LiveData liveData4 = (LiveData) obj;
                return l(i2);
            case 4:
                LiveData liveData5 = (LiveData) obj;
                return m(i2);
            case 5:
                OfferOsagoOrderStatusSravniBinding offerOsagoOrderStatusSravniBinding = (OfferOsagoOrderStatusSravniBinding) obj;
                return j(i2);
            case 6:
                LiveData liveData6 = (LiveData) obj;
                return p(i2);
            default:
                return false;
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Lru/sravni/android/bankproduct/domain/offer/osago/entity/order/OsagoCompanyOrderInfoDomain;>;I)Z */
    public final boolean p(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.E |= 64;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
    public final boolean q(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.E |= 2;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.z.setLifecycleOwner(lifecycleOwner);
        this.A.setLifecycleOwner(lifecycleOwner);
        this.B.setLifecycleOwner(lifecycleOwner);
        this.incStatusView.setLifecycleOwner(lifecycleOwner);
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferOsagoOrderFragmentSravniBinding
    public void setOfferOsagoOrderViewModel(@Nullable IOfferOsagoOrderViewModel iOfferOsagoOrderViewModel) {
        this.mOfferOsagoOrderViewModel = iOfferOsagoOrderViewModel;
        synchronized (this) {
            this.E |= 128;
        }
        notifyPropertyChanged(BR.offerOsagoOrderViewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.offerOsagoOrderViewModel != i) {
            return false;
        }
        setOfferOsagoOrderViewModel((IOfferOsagoOrderViewModel) obj);
        return true;
    }
}
