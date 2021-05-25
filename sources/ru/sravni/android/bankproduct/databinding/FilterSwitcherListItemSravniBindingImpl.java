package ru.sravni.android.bankproduct.databinding;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.adapters.TextViewBindingAdapter;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.utils.filter.adapter.BindingFilterAdapterKt;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterSwitcherInfo;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSwitcherListViewModel;
public class FilterSwitcherListItemSravniBindingImpl extends FilterSwitcherListItemSravniBinding {
    @NonNull
    public final ConstraintLayout y;
    public long z = -1;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FilterSwitcherListItemSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r10, @androidx.annotation.NonNull android.view.View r11) {
        /*
            r9 = this;
            r0 = 3
            r1 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r10, r11, r0, r1, r1)
            r2 = 2
            r2 = r0[r2]
            r7 = r2
            com.google.android.material.switchmaterial.SwitchMaterial r7 = (com.google.android.material.switchmaterial.SwitchMaterial) r7
            r2 = 1
            r2 = r0[r2]
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            r6 = 0
            r3 = r9
            r4 = r10
            r5 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            r2 = -1
            r9.z = r2
            r10 = 0
            r10 = r0[r10]
            androidx.constraintlayout.widget.ConstraintLayout r10 = (androidx.constraintlayout.widget.ConstraintLayout) r10
            r9.y = r10
            r10.setTag(r1)
            com.google.android.material.switchmaterial.SwitchMaterial r10 = r9.swActive
            r10.setTag(r1)
            android.widget.TextView r10 = r9.tvName
            r10.setTag(r1)
            r9.setRootTag(r11)
            r9.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.FilterSwitcherListItemSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        int i2;
        boolean z2;
        boolean z3;
        synchronized (this) {
            j = this.z;
            this.z = 0;
        }
        String str = null;
        FilterSwitcherInfo filterSwitcherInfo = this.mSwitcherInfo;
        IFilterSwitcherListViewModel iFilterSwitcherListViewModel = this.mSwitcherChanged;
        boolean z4 = false;
        int i3 = 0;
        if ((j & 7) == 0 || (j & 5) == 0) {
            i = 0;
        } else {
            if (filterSwitcherInfo != null) {
                str = filterSwitcherInfo.getTitle();
                z3 = filterSwitcherInfo.getVisibility();
                z2 = filterSwitcherInfo.getEnabled();
            } else {
                z3 = false;
                z2 = false;
            }
            if (i2 != 0) {
                j |= z3 ? 16 : 8;
            }
            if (!z3) {
                i3 = 4;
            }
            i = i3;
            z4 = z2;
        }
        if ((j & 5) != 0) {
            this.swActive.setEnabled(z4);
            this.swActive.setVisibility(i);
            TextViewBindingAdapter.setText(this.tvName, str);
        }
        if ((j & 7) != 0) {
            BindingFilterAdapterKt.bindCheckedToSwitch(this.swActive, filterSwitcherInfo, iFilterSwitcherListViewModel);
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

    @Override // ru.sravni.android.bankproduct.databinding.FilterSwitcherListItemSravniBinding
    public void setSwitcherChanged(@Nullable IFilterSwitcherListViewModel iFilterSwitcherListViewModel) {
        this.mSwitcherChanged = iFilterSwitcherListViewModel;
        synchronized (this) {
            this.z |= 2;
        }
        notifyPropertyChanged(BR.switcherChanged);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.FilterSwitcherListItemSravniBinding
    public void setSwitcherInfo(@Nullable FilterSwitcherInfo filterSwitcherInfo) {
        this.mSwitcherInfo = filterSwitcherInfo;
        synchronized (this) {
            this.z |= 1;
        }
        notifyPropertyChanged(BR.switcherInfo);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.switcherInfo == i) {
            setSwitcherInfo((FilterSwitcherInfo) obj);
        } else if (BR.switcherChanged != i) {
            return false;
        } else {
            setSwitcherChanged((IFilterSwitcherListViewModel) obj);
        }
        return true;
    }
}
