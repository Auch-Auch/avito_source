package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductDisplaySettingsDomain;
import ru.sravni.android.bankproduct.domain.offer.product.entity.OfferProductStatusDomain;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.presentation.offer.product.entity.OfferProductStatusDomainWithLogoInfo;
import ru.sravni.android.bankproduct.presentation.offer.product.status.adapter.BindingProductOfferStatusAdapterKt;
import ru.sravni.android.bankproduct.presentation.offer.product.status.viewmodel.IOfferProductStatusViewModel;
public class OfferProductStatusFragmentSravniBindingImpl extends OfferProductStatusFragmentSravniBinding implements OnClickListener.Listener {
    @Nullable
    public static final SparseIntArray D;
    @NonNull
    public final MaterialButton A;
    @Nullable
    public final View.OnClickListener B;
    public long C = -1;
    @NonNull
    public final ConstraintLayout y;
    @NonNull
    public final RecyclerView z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        D = sparseIntArray;
        sparseIntArray.put(R.id.appBarLayout, 4);
        sparseIntArray.put(R.id.vShadow, 5);
        sparseIntArray.put(R.id.flButtonPanel, 6);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OfferProductStatusFragmentSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r12, @androidx.annotation.NonNull android.view.View r13) {
        /*
            r11 = this;
            android.util.SparseIntArray r0 = ru.sravni.android.bankproduct.databinding.OfferProductStatusFragmentSravniBindingImpl.D
            r1 = 7
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r12, r13, r1, r2, r0)
            r1 = 4
            r1 = r0[r1]
            r7 = r1
            com.google.android.material.appbar.AppBarLayout r7 = (com.google.android.material.appbar.AppBarLayout) r7
            r1 = 6
            r1 = r0[r1]
            r8 = r1
            android.widget.FrameLayout r8 = (android.widget.FrameLayout) r8
            r1 = 1
            r3 = r0[r1]
            r9 = r3
            com.google.android.material.appbar.MaterialToolbar r9 = (com.google.android.material.appbar.MaterialToolbar) r9
            r3 = 5
            r3 = r0[r3]
            r10 = r3
            android.view.View r10 = (android.view.View) r10
            r6 = 1
            r3 = r11
            r4 = r12
            r5 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            r3 = -1
            r11.C = r3
            r12 = 0
            r12 = r0[r12]
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            r11.y = r12
            r12.setTag(r2)
            r12 = 2
            r12 = r0[r12]
            androidx.recyclerview.widget.RecyclerView r12 = (androidx.recyclerview.widget.RecyclerView) r12
            r11.z = r12
            r12.setTag(r2)
            r12 = 3
            r12 = r0[r12]
            com.google.android.material.button.MaterialButton r12 = (com.google.android.material.button.MaterialButton) r12
            r11.A = r12
            r12.setTag(r2)
            com.google.android.material.appbar.MaterialToolbar r12 = r11.toolbar
            r12.setTag(r2)
            r11.setRootTag(r13)
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r12 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r12.<init>(r11, r1)
            r11.B = r12
            r11.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferProductStatusFragmentSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        IOfferProductStatusViewModel iOfferProductStatusViewModel = this.mViewModel;
        if (iOfferProductStatusViewModel != null) {
            iOfferProductStatusViewModel.onReadyClicked();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.C;
            this.C = 0;
        }
        IOfferProductStatusViewModel iOfferProductStatusViewModel = this.mViewModel;
        OfferProductStatusDomainWithLogoInfo offerProductStatusDomainWithLogoInfo = null;
        String str2 = null;
        int i = ((7 & j) > 0 ? 1 : ((7 & j) == 0 ? 0 : -1));
        if (i != 0) {
            LiveData<OfferProductStatusDomainWithLogoInfo> statusList = iOfferProductStatusViewModel != null ? iOfferProductStatusViewModel.getStatusList() : null;
            updateLiveDataRegistration(0, statusList);
            OfferProductStatusDomainWithLogoInfo value = statusList != null ? statusList.getValue() : null;
            OfferProductStatusDomain offerProductStatusDomain = value != null ? value.getOfferProductStatusDomain() : null;
            OfferProductDisplaySettingsDomain displaySettings = offerProductStatusDomain != null ? offerProductStatusDomain.getDisplaySettings() : null;
            if (displaySettings != null) {
                str2 = displaySettings.getDetailTitle();
            }
            offerProductStatusDomainWithLogoInfo = value;
            str = str2;
        } else {
            str = null;
        }
        if (i != 0) {
            BindingProductOfferStatusAdapterKt.bindListToRecycler(this.z, offerProductStatusDomainWithLogoInfo);
            this.toolbar.setTitle(str);
        }
        if ((j & 4) != 0) {
            this.A.setOnClickListener(this.B);
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

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductStatusDomainWithLogoInfo;>;I)Z */
    public final boolean j(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.C |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        LiveData liveData = (LiveData) obj;
        return j(i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.viewModel != i) {
            return false;
        }
        setViewModel((IOfferProductStatusViewModel) obj);
        return true;
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductStatusFragmentSravniBinding
    public void setViewModel(@Nullable IOfferProductStatusViewModel iOfferProductStatusViewModel) {
        this.mViewModel = iOfferProductStatusViewModel;
        synchronized (this) {
            this.C |= 2;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }
}
