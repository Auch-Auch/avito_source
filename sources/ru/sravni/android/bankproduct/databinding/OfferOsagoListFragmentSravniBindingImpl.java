package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.generated.callback.OnRefreshListener;
import ru.sravni.android.bankproduct.presentation.offer.osago.list.viewmodel.IOfferOsagoListViewModel;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingPanelButtonViewModel;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingUpPanelViewModel;
import ru.sravni.android.bankproduct.utils.components.wraprefreshlayout.WrapContentableSwipeRefreshLayout;
public class OfferOsagoListFragmentSravniBindingImpl extends OfferOsagoListFragmentSravniBinding implements OnRefreshListener.Listener {
    @Nullable
    public static final ViewDataBinding.IncludedLayouts K;
    @Nullable
    public static final SparseIntArray L;
    @NonNull
    public final WrapContentableSwipeRefreshLayout A;
    @NonNull
    public final LinearLayout B;
    @Nullable
    public final SlideupPanelButtonSravniBinding C;
    @NonNull
    public final FrameLayout D;
    @Nullable
    public final FilterBarrelDayLayoutSravniBinding E;
    @Nullable
    public final FilterListInfoLayoutSravniBinding F;
    @Nullable
    public final FilterSwitcherListLayoutSravniBinding G;
    @Nullable
    public final FilterDescriptionLayoutSravniBinding H;
    @Nullable
    public final SwipeRefreshLayout.OnRefreshListener I;
    public long J = -1;
    @NonNull
    public final ConstraintLayout y;
    @Nullable
    public final WaitErrorFragmentSravniBinding z;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(17);
        K = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"wait_error_fragment_sravni"}, new int[]{8}, new int[]{R.layout.wait_error_fragment_sravni});
        includedLayouts.setIncludes(6, new String[]{"slideup_panel_button_sravni"}, new int[]{13}, new int[]{R.layout.slideup_panel_button_sravni});
        includedLayouts.setIncludes(7, new String[]{"filter_barrel_day_layout_sravni", "filter_list_info_layout_sravni", "filter_switcher_list_layout_sravni", "filter_description_layout_sravni"}, new int[]{9, 10, 11, 12}, new int[]{R.layout.filter_barrel_day_layout_sravni, R.layout.filter_list_info_layout_sravni, R.layout.filter_switcher_list_layout_sravni, R.layout.filter_description_layout_sravni});
        SparseIntArray sparseIntArray = new SparseIntArray();
        L = sparseIntArray;
        sparseIntArray.put(R.id.vToolbar, 14);
        sparseIntArray.put(R.id.flFilterPanel, 15);
        sparseIntArray.put(R.id.flPanelFadeLayout, 16);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OfferOsagoListFragmentSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r14, @androidx.annotation.NonNull android.view.View r15) {
        /*
        // Method dump skipped, instructions count: 207
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferOsagoListFragmentSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnRefreshListener.Listener
    public final void _internalCallbackOnRefresh(int i) {
        IOfferOsagoListViewModel iOfferOsagoListViewModel = this.mOfferOsagoListViewModel;
        if (iOfferOsagoListViewModel != null) {
            iOfferOsagoListViewModel.onRefresh();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0170  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x013f  */
    @Override // androidx.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
        // Method dump skipped, instructions count: 728
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferOsagoListFragmentSravniBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.J != 0) {
                return true;
            }
        }
        if (!this.z.hasPendingBindings() && !this.E.hasPendingBindings() && !this.F.hasPendingBindings() && !this.G.hasPendingBindings() && !this.H.hasPendingBindings() && !this.C.hasPendingBindings()) {
            return false;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.J = 1024;
        }
        this.z.invalidateAll();
        this.E.invalidateAll();
        this.F.invalidateAll();
        this.G.invalidateAll();
        this.H.invalidateAll();
        this.C.invalidateAll();
        requestRebind();
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/util/List<Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem;>;>;I)Z */
    public final boolean j(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.J |= 4;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Boolean;>;I)Z */
    public final boolean l(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.J |= 32;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Boolean;>;I)Z */
    public final boolean m(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.J |= 16;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/util/List<Lru/sravni/android/bankproduct/domain/offer/osago/entity/list/OfferOsagoItemDomain;>;>;I)Z */
    public final boolean n(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.J |= 1;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Lru/sravni/android/bankproduct/utils/filter/entity/FilterTypeEnum;>;I)Z */
    public final boolean o(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.J |= 8;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            LiveData liveData = (LiveData) obj;
            return n(i2);
        } else if (i == 1) {
            LiveData liveData2 = (LiveData) obj;
            return p(i2);
        } else if (i == 2) {
            LiveData liveData3 = (LiveData) obj;
            return j(i2);
        } else if (i == 3) {
            LiveData liveData4 = (LiveData) obj;
            return o(i2);
        } else if (i == 4) {
            LiveData liveData5 = (LiveData) obj;
            return m(i2);
        } else if (i != 5) {
            return false;
        } else {
            LiveData liveData6 = (LiveData) obj;
            return l(i2);
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
    public final boolean p(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.J |= 2;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.z.setLifecycleOwner(lifecycleOwner);
        this.E.setLifecycleOwner(lifecycleOwner);
        this.F.setLifecycleOwner(lifecycleOwner);
        this.G.setLifecycleOwner(lifecycleOwner);
        this.H.setLifecycleOwner(lifecycleOwner);
        this.C.setLifecycleOwner(lifecycleOwner);
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferOsagoListFragmentSravniBinding
    public void setOfferOsagoListViewModel(@Nullable IOfferOsagoListViewModel iOfferOsagoListViewModel) {
        this.mOfferOsagoListViewModel = iOfferOsagoListViewModel;
        synchronized (this) {
            this.J |= 512;
        }
        notifyPropertyChanged(BR.offerOsagoListViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferOsagoListFragmentSravniBinding
    public void setPanelButtonViewModel(@Nullable ISlidingPanelButtonViewModel iSlidingPanelButtonViewModel) {
        this.mPanelButtonViewModel = iSlidingPanelButtonViewModel;
        synchronized (this) {
            this.J |= 128;
        }
        notifyPropertyChanged(BR.panelButtonViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferOsagoListFragmentSravniBinding
    public void setPanelViewModel(@Nullable ISlidingUpPanelViewModel iSlidingUpPanelViewModel) {
        this.mPanelViewModel = iSlidingUpPanelViewModel;
        synchronized (this) {
            this.J |= 64;
        }
        notifyPropertyChanged(BR.panelViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferOsagoListFragmentSravniBinding
    public void setSlideLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        this.mSlideLifecycleOwner = lifecycleOwner;
        synchronized (this) {
            this.J |= 256;
        }
        notifyPropertyChanged(BR.slideLifecycleOwner);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.panelViewModel == i) {
            setPanelViewModel((ISlidingUpPanelViewModel) obj);
        } else if (BR.panelButtonViewModel == i) {
            setPanelButtonViewModel((ISlidingPanelButtonViewModel) obj);
        } else if (BR.slideLifecycleOwner == i) {
            setSlideLifecycleOwner((LifecycleOwner) obj);
        } else if (BR.offerOsagoListViewModel != i) {
            return false;
        } else {
            setOfferOsagoListViewModel((IOfferOsagoListViewModel) obj);
        }
        return true;
    }
}
