package ru.sravni.android.bankproduct.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
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
import ru.sravni.android.bankproduct.presentation.offer.product.list.viewmodel.IOfferProductListViewModel;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingPanelButtonViewModel;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingUpPanelViewModel;
import ru.sravni.android.bankproduct.utils.components.wraprefreshlayout.WrapContentableSwipeRefreshLayout;
public class OfferProductListFragmentSravniBindingImpl extends OfferProductListFragmentSravniBinding implements OnRefreshListener.Listener {
    @Nullable
    public static final ViewDataBinding.IncludedLayouts K;
    @Nullable
    public static final SparseIntArray L;
    @Nullable
    public final WaitingLayoutSravniBinding A;
    @NonNull
    public final WrapContentableSwipeRefreshLayout B;
    @NonNull
    public final LinearLayout C;
    @NonNull
    public final LinearLayout D;
    @Nullable
    public final SlideupPanelButtonSravniBinding E;
    @NonNull
    public final FrameLayout F;
    @Nullable
    public final FilterSliderLayoutSravniBinding G;
    @Nullable
    public final FilterSnapPointLayoutSravniBinding H;
    @Nullable
    public final SwipeRefreshLayout.OnRefreshListener I;
    public long J = -1;
    @NonNull
    public final ConstraintLayout y;
    @Nullable
    public final WaitErrorFragmentSravniBinding z;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(20);
        K = includedLayouts;
        includedLayouts.setIncludes(1, new String[]{"wait_error_fragment_sravni", "waiting_layout_sravni"}, new int[]{9, 10}, new int[]{R.layout.wait_error_fragment_sravni, R.layout.waiting_layout_sravni});
        includedLayouts.setIncludes(7, new String[]{"slideup_panel_button_sravni"}, new int[]{13}, new int[]{R.layout.slideup_panel_button_sravni});
        includedLayouts.setIncludes(8, new String[]{"filter_slider_layout_sravni", "filter_snap_point_layout_sravni"}, new int[]{11, 12}, new int[]{R.layout.filter_slider_layout_sravni, R.layout.filter_snap_point_layout_sravni});
        SparseIntArray sparseIntArray = new SparseIntArray();
        L = sparseIntArray;
        sparseIntArray.put(R.id.appBarLayout, 14);
        sparseIntArray.put(R.id.vToolbar, 15);
        sparseIntArray.put(R.id.flFilterPanel, 16);
        sparseIntArray.put(R.id.tvHeader, 17);
        sparseIntArray.put(R.id.tvDescription, 18);
        sparseIntArray.put(R.id.flPanelFadeLayout, 19);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OfferProductListFragmentSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r19, @androidx.annotation.NonNull android.view.View r20) {
        /*
        // Method dump skipped, instructions count: 240
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferProductListFragmentSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnRefreshListener.Listener
    public final void _internalCallbackOnRefresh(int i) {
        IOfferProductListViewModel iOfferProductListViewModel = this.mOfferProductListViewModel;
        if (iOfferProductListViewModel != null) {
            iOfferProductListViewModel.onRefresh();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:119:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01f0  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x013a  */
    @Override // androidx.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
        // Method dump skipped, instructions count: 762
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferProductListFragmentSravniBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.J != 0) {
                return true;
            }
        }
        if (!this.z.hasPendingBindings() && !this.A.hasPendingBindings() && !this.G.hasPendingBindings() && !this.H.hasPendingBindings() && !this.E.hasPendingBindings()) {
            return false;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.J = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        }
        this.z.invalidateAll();
        this.A.invalidateAll();
        this.G.invalidateAll();
        this.H.invalidateAll();
        this.E.invalidateAll();
        requestRebind();
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/util/List<Lru/sravni/android/bankproduct/utils/filter/entity/FilterItem;>;>;I)Z */
    public final boolean j(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.J |= 2;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Boolean;>;I)Z */
    public final boolean l(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.J |= 128;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Boolean;>;I)Z */
    public final boolean m(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.J |= 8;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Boolean;>;I)Z */
    public final boolean n(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.J |= 4;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Boolean;>;I)Z */
    public final boolean o(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.J |= 16;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                LiveData liveData = (LiveData) obj;
                return p(i2);
            case 1:
                LiveData liveData2 = (LiveData) obj;
                return j(i2);
            case 2:
                LiveData liveData3 = (LiveData) obj;
                return n(i2);
            case 3:
                LiveData liveData4 = (LiveData) obj;
                return m(i2);
            case 4:
                LiveData liveData5 = (LiveData) obj;
                return o(i2);
            case 5:
                LiveData liveData6 = (LiveData) obj;
                return r(i2);
            case 6:
                LiveData liveData7 = (LiveData) obj;
                return q(i2);
            case 7:
                LiveData liveData8 = (LiveData) obj;
                return l(i2);
            default:
                return false;
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/util/List<Lru/sravni/android/bankproduct/presentation/offer/product/entity/OfferProductDetailDomainWithLogoInfo;>;>;I)Z */
    public final boolean p(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.J |= 1;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Lru/sravni/android/bankproduct/utils/filter/entity/FilterTypeEnum;>;I)Z */
    public final boolean q(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.J |= 64;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
    public final boolean r(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.J |= 32;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.z.setLifecycleOwner(lifecycleOwner);
        this.A.setLifecycleOwner(lifecycleOwner);
        this.G.setLifecycleOwner(lifecycleOwner);
        this.H.setLifecycleOwner(lifecycleOwner);
        this.E.setLifecycleOwner(lifecycleOwner);
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductListFragmentSravniBinding
    public void setOfferProductListViewModel(@Nullable IOfferProductListViewModel iOfferProductListViewModel) {
        this.mOfferProductListViewModel = iOfferProductListViewModel;
        synchronized (this) {
            this.J |= 256;
        }
        notifyPropertyChanged(BR.offerProductListViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductListFragmentSravniBinding
    public void setPanelButtonViewModel(@Nullable ISlidingPanelButtonViewModel iSlidingPanelButtonViewModel) {
        this.mPanelButtonViewModel = iSlidingPanelButtonViewModel;
        synchronized (this) {
            this.J |= 1024;
        }
        notifyPropertyChanged(BR.panelButtonViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductListFragmentSravniBinding
    public void setPanelViewModel(@Nullable ISlidingUpPanelViewModel iSlidingUpPanelViewModel) {
        this.mPanelViewModel = iSlidingUpPanelViewModel;
        synchronized (this) {
            this.J |= 512;
        }
        notifyPropertyChanged(BR.panelViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductListFragmentSravniBinding
    public void setSlideLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        this.mSlideLifecycleOwner = lifecycleOwner;
        synchronized (this) {
            this.J |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        notifyPropertyChanged(BR.slideLifecycleOwner);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.offerProductListViewModel == i) {
            setOfferProductListViewModel((IOfferProductListViewModel) obj);
        } else if (BR.panelViewModel == i) {
            setPanelViewModel((ISlidingUpPanelViewModel) obj);
        } else if (BR.panelButtonViewModel == i) {
            setPanelButtonViewModel((ISlidingPanelButtonViewModel) obj);
        } else if (BR.slideLifecycleOwner != i) {
            return false;
        } else {
            setSlideLifecycleOwner((LifecycleOwner) obj);
        }
        return true;
    }
}
