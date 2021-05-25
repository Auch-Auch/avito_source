package ru.sravni.android.bankproduct.databinding;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.presentation.bottomnavigation.adapter.BindingBottomNavigationAdapterKt;
import ru.sravni.android.bankproduct.presentation.bottomnavigation.viewmodel.IBottomNavigationViewModel;
import ru.sravni.android.bankproduct.presentation.bottomnavigation.viewmodel.SelectItemBottomNavigationEnum;
public class BottomNavigationFragmentSravniBindingImpl extends BottomNavigationFragmentSravniBinding {
    public long y = -1;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BottomNavigationFragmentSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r13, @androidx.annotation.NonNull android.view.View r14) {
        /*
            r12 = this;
            r0 = 5
            r1 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r13, r14, r0, r1, r1)
            r2 = 4
            r2 = r0[r2]
            r7 = r2
            com.google.android.material.bottomnavigation.BottomNavigationView r7 = (com.google.android.material.bottomnavigation.BottomNavigationView) r7
            r2 = 0
            r2 = r0[r2]
            r8 = r2
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            r2 = 1
            r2 = r0[r2]
            r9 = r2
            androidx.fragment.app.FragmentContainerView r9 = (androidx.fragment.app.FragmentContainerView) r9
            r2 = 2
            r2 = r0[r2]
            r10 = r2
            androidx.fragment.app.FragmentContainerView r10 = (androidx.fragment.app.FragmentContainerView) r10
            r2 = 3
            r0 = r0[r2]
            r11 = r0
            androidx.fragment.app.FragmentContainerView r11 = (androidx.fragment.app.FragmentContainerView) r11
            r6 = 1
            r3 = r12
            r4 = r13
            r5 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            r2 = -1
            r12.y = r2
            com.google.android.material.bottomnavigation.BottomNavigationView r13 = r12.bottomNavigationView
            r13.setTag(r1)
            androidx.constraintlayout.widget.ConstraintLayout r13 = r12.container
            r13.setTag(r1)
            androidx.fragment.app.FragmentContainerView r13 = r12.sectionDashboard
            r13.setTag(r1)
            androidx.fragment.app.FragmentContainerView r13 = r12.sectionProfile
            r13.setTag(r1)
            androidx.fragment.app.FragmentContainerView r13 = r12.sectionProfileLegacy
            r13.setTag(r1)
            r12.setRootTag(r14)
            r12.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.BottomNavigationFragmentSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        int i2;
        int i3;
        synchronized (this) {
            j = this.y;
            this.y = 0;
        }
        IBottomNavigationViewModel iBottomNavigationViewModel = this.mViewModel;
        int i4 = 0;
        int i5 = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        if (i5 != 0) {
            SelectItemBottomNavigationEnum selectItemBottomNavigationEnum = null;
            LiveData<SelectItemBottomNavigationEnum> selectItemElement = iBottomNavigationViewModel != null ? iBottomNavigationViewModel.getSelectItemElement() : null;
            updateLiveDataRegistration(0, selectItemElement);
            if (selectItemElement != null) {
                selectItemBottomNavigationEnum = selectItemElement.getValue();
            }
            boolean z = true;
            boolean z2 = selectItemBottomNavigationEnum == SelectItemBottomNavigationEnum.SELECT_PROFILE_LEGACY;
            boolean z3 = selectItemBottomNavigationEnum == SelectItemBottomNavigationEnum.SELECT_PROFILE;
            if (selectItemBottomNavigationEnum != SelectItemBottomNavigationEnum.SELECT_DASHBOARD) {
                z = false;
            }
            if (i5 != 0) {
                j |= z2 ? 256 : 128;
            }
            if ((j & 7) != 0) {
                j |= z3 ? 16 : 8;
            }
            if ((j & 7) != 0) {
                j |= z ? 64 : 32;
            }
            int element = selectItemBottomNavigationEnum != null ? selectItemBottomNavigationEnum.getElement() : 0;
            i2 = z2 ? 0 : 4;
            i = z3 ? 0 : 4;
            if (!z) {
                i4 = 4;
            }
            i4 = element;
            i3 = i4;
        } else {
            i3 = 0;
            i2 = 0;
            i = 0;
        }
        if ((7 & j) != 0) {
            BindingBottomNavigationAdapterKt.bindSelectNavigationItemListener(this.bottomNavigationView, i4);
            this.sectionDashboard.setVisibility(i3);
            this.sectionProfile.setVisibility(i);
            this.sectionProfileLegacy.setVisibility(i2);
        }
        if ((j & 6) != 0) {
            BindingBottomNavigationAdapterKt.bindSelectNavigationItemListener(this.bottomNavigationView, iBottomNavigationViewModel);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.y != 0) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.y = 4;
        }
        requestRebind();
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Lru/sravni/android/bankproduct/presentation/bottomnavigation/viewmodel/SelectItemBottomNavigationEnum;>;I)Z */
    public final boolean j(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.y |= 1;
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
        setViewModel((IBottomNavigationViewModel) obj);
        return true;
    }

    @Override // ru.sravni.android.bankproduct.databinding.BottomNavigationFragmentSravniBinding
    public void setViewModel(@Nullable IBottomNavigationViewModel iBottomNavigationViewModel) {
        this.mViewModel = iBottomNavigationViewModel;
        synchronized (this) {
            this.y |= 2;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }
}
