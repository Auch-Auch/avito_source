package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.presentation.auth.phone.viewmodel.IProfilePhoneViewModel;
public class AvitoPhoneFragmentSravniBindingImpl extends AvitoPhoneFragmentSravniBinding implements OnClickListener.Listener {
    @Nullable
    public static final ViewDataBinding.IncludedLayouts C;
    @Nullable
    public static final SparseIntArray D;
    @Nullable
    public final View.OnClickListener A;
    public long B = -1;
    @Nullable
    public final WaitingLayoutSravniBinding y;
    @Nullable
    public final View.OnClickListener z;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(10);
        C = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"waiting_layout_sravni"}, new int[]{4}, new int[]{R.layout.waiting_layout_sravni});
        SparseIntArray sparseIntArray = new SparseIntArray();
        D = sparseIntArray;
        sparseIntArray.put(R.id.appBarLayout, 5);
        sparseIntArray.put(R.id.toolbar, 6);
        sparseIntArray.put(R.id.tvTitlePhone, 7);
        sparseIntArray.put(R.id.tvDescriptionPhone, 8);
        sparseIntArray.put(R.id.ilPhoneNumber, 9);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AvitoPhoneFragmentSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r20, @androidx.annotation.NonNull android.view.View r21) {
        /*
            r19 = this;
            r13 = r19
            r14 = r21
            androidx.databinding.ViewDataBinding$IncludedLayouts r0 = ru.sravni.android.bankproduct.databinding.AvitoPhoneFragmentSravniBindingImpl.C
            android.util.SparseIntArray r1 = ru.sravni.android.bankproduct.databinding.AvitoPhoneFragmentSravniBindingImpl.D
            r2 = 10
            r3 = r20
            java.lang.Object[] r15 = androidx.databinding.ViewDataBinding.mapBindings(r3, r14, r2, r0, r1)
            r0 = 5
            r0 = r15[r0]
            r4 = r0
            com.google.android.material.appbar.AppBarLayout r4 = (com.google.android.material.appbar.AppBarLayout) r4
            r12 = 2
            r0 = r15[r12]
            r5 = r0
            com.google.android.material.button.MaterialButton r5 = (com.google.android.material.button.MaterialButton) r5
            r0 = 0
            r0 = r15[r0]
            r6 = r0
            androidx.constraintlayout.widget.ConstraintLayout r6 = (androidx.constraintlayout.widget.ConstraintLayout) r6
            r11 = 1
            r0 = r15[r11]
            r7 = r0
            com.google.android.material.textfield.TextInputEditText r7 = (com.google.android.material.textfield.TextInputEditText) r7
            r0 = 9
            r0 = r15[r0]
            r8 = r0
            com.google.android.material.textfield.TextInputLayout r8 = (com.google.android.material.textfield.TextInputLayout) r8
            r0 = 3
            r0 = r15[r0]
            r9 = r0
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            r0 = 6
            r0 = r15[r0]
            r10 = r0
            com.google.android.material.appbar.MaterialToolbar r10 = (com.google.android.material.appbar.MaterialToolbar) r10
            r0 = 8
            r0 = r15[r0]
            r16 = r0
            com.google.android.material.textview.MaterialTextView r16 = (com.google.android.material.textview.MaterialTextView) r16
            r0 = 7
            r0 = r15[r0]
            r17 = r0
            com.google.android.material.textview.MaterialTextView r17 = (com.google.android.material.textview.MaterialTextView) r17
            r18 = 2
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r18
            r11 = r16
            r12 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = -1
            r13.B = r0
            com.google.android.material.button.MaterialButton r0 = r13.btSendPhone
            r1 = 0
            r0.setTag(r1)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r13.clProfilePhone
            r0.setTag(r1)
            com.google.android.material.textfield.TextInputEditText r0 = r13.etMobileNumber
            r0.setTag(r1)
            android.widget.LinearLayout r0 = r13.llRepeatSendPhone
            r0.setTag(r1)
            r0 = 4
            r0 = r15[r0]
            ru.sravni.android.bankproduct.databinding.WaitingLayoutSravniBinding r0 = (ru.sravni.android.bankproduct.databinding.WaitingLayoutSravniBinding) r0
            r13.y = r0
            r13.setContainedBinding(r0)
            r13.setRootTag(r14)
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r0 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r1 = 1
            r0.<init>(r13, r1)
            r13.z = r0
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r0 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r1 = 2
            r0.<init>(r13, r1)
            r13.A = r0
            r19.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.AvitoPhoneFragmentSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z2 = false;
        if (i == 1) {
            IProfilePhoneViewModel iProfilePhoneViewModel = this.mPhoneViewModel;
            if (iProfilePhoneViewModel != null) {
                z2 = true;
            }
            if (z2) {
                iProfilePhoneViewModel.sendPhone();
            }
        } else if (i == 2) {
            IProfilePhoneViewModel iProfilePhoneViewModel2 = this.mPhoneViewModel;
            if (iProfilePhoneViewModel2 != null) {
                z2 = true;
            }
            if (z2) {
                iProfilePhoneViewModel2.sendPhone();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00fc  */
    @Override // androidx.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
        // Method dump skipped, instructions count: 276
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.AvitoPhoneFragmentSravniBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.B != 0) {
                return true;
            }
        }
        if (this.y.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.B = 8;
        }
        this.y.invalidateAll();
        requestRebind();
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Lru/sravni/android/bankproduct/presentation/auth/phone/viewmodel/StateEnum;>;I)Z */
    public final boolean j(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.B |= 2;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
    public final boolean l(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.B |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            LiveData liveData = (LiveData) obj;
            return l(i2);
        } else if (i != 1) {
            return false;
        } else {
            LiveData liveData2 = (LiveData) obj;
            return j(i2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.y.setLifecycleOwner(lifecycleOwner);
    }

    @Override // ru.sravni.android.bankproduct.databinding.AvitoPhoneFragmentSravniBinding
    public void setPhoneViewModel(@Nullable IProfilePhoneViewModel iProfilePhoneViewModel) {
        this.mPhoneViewModel = iProfilePhoneViewModel;
        synchronized (this) {
            this.B |= 4;
        }
        notifyPropertyChanged(BR.phoneViewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.phoneViewModel != i) {
            return false;
        }
        setPhoneViewModel((IProfilePhoneViewModel) obj);
        return true;
    }
}
