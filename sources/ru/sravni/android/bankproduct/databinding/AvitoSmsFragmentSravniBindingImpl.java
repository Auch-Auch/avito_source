package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.IProfileSmsViewModel;
public class AvitoSmsFragmentSravniBindingImpl extends AvitoSmsFragmentSravniBinding implements OnClickListener.Listener {
    @Nullable
    public static final ViewDataBinding.IncludedLayouts C;
    @Nullable
    public static final SparseIntArray D;
    @Nullable
    public final View.OnClickListener A;
    public long B = -1;
    @NonNull
    public final FrameLayout y;
    @Nullable
    public final WaitingLayoutSravniBinding z;

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(13);
        C = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"waiting_layout_sravni"}, new int[]{7}, new int[]{R.layout.waiting_layout_sravni});
        SparseIntArray sparseIntArray = new SparseIntArray();
        D = sparseIntArray;
        sparseIntArray.put(R.id.clProfilePhone, 8);
        sparseIntArray.put(R.id.appBarLayout, 9);
        sparseIntArray.put(R.id.toolbar, 10);
        sparseIntArray.put(R.id.tvTitleSms, 11);
        sparseIntArray.put(R.id.llInfoSmsCode, 12);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AvitoSmsFragmentSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r21, @androidx.annotation.NonNull android.view.View r22) {
        /*
            r20 = this;
            r15 = r20
            r14 = r22
            androidx.databinding.ViewDataBinding$IncludedLayouts r0 = ru.sravni.android.bankproduct.databinding.AvitoSmsFragmentSravniBindingImpl.C
            android.util.SparseIntArray r1 = ru.sravni.android.bankproduct.databinding.AvitoSmsFragmentSravniBindingImpl.D
            r2 = 13
            r3 = r21
            java.lang.Object[] r16 = androidx.databinding.ViewDataBinding.mapBindings(r3, r14, r2, r0, r1)
            r0 = 9
            r0 = r16[r0]
            r4 = r0
            com.google.android.material.appbar.AppBarLayout r4 = (com.google.android.material.appbar.AppBarLayout) r4
            r0 = 8
            r0 = r16[r0]
            r5 = r0
            androidx.constraintlayout.widget.ConstraintLayout r5 = (androidx.constraintlayout.widget.ConstraintLayout) r5
            r0 = 3
            r0 = r16[r0]
            r6 = r0
            com.google.android.material.textfield.TextInputEditText r6 = (com.google.android.material.textfield.TextInputEditText) r6
            r0 = 2
            r0 = r16[r0]
            r7 = r0
            com.google.android.material.textfield.TextInputLayout r7 = (com.google.android.material.textfield.TextInputLayout) r7
            r0 = 12
            r0 = r16[r0]
            r8 = r0
            android.widget.LinearLayout r8 = (android.widget.LinearLayout) r8
            r0 = 10
            r0 = r16[r0]
            r9 = r0
            com.google.android.material.appbar.MaterialToolbar r9 = (com.google.android.material.appbar.MaterialToolbar) r9
            r13 = 1
            r0 = r16[r13]
            r10 = r0
            com.google.android.material.textview.MaterialTextView r10 = (com.google.android.material.textview.MaterialTextView) r10
            r0 = 6
            r0 = r16[r0]
            r11 = r0
            com.google.android.material.textview.MaterialTextView r11 = (com.google.android.material.textview.MaterialTextView) r11
            r0 = 5
            r0 = r16[r0]
            r12 = r0
            com.google.android.material.textview.MaterialTextView r12 = (com.google.android.material.textview.MaterialTextView) r12
            r0 = 11
            r0 = r16[r0]
            r17 = r0
            com.google.android.material.textview.MaterialTextView r17 = (com.google.android.material.textview.MaterialTextView) r17
            r0 = 4
            r0 = r16[r0]
            r18 = r0
            com.google.android.material.textview.MaterialTextView r18 = (com.google.android.material.textview.MaterialTextView) r18
            r19 = 4
            r0 = r20
            r1 = r21
            r2 = r22
            r3 = r19
            r13 = r17
            r14 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = -1
            r15.B = r0
            com.google.android.material.textfield.TextInputEditText r0 = r15.etSmsCode
            r1 = 0
            r0.setTag(r1)
            com.google.android.material.textfield.TextInputLayout r0 = r15.ilSmsCode
            r0.setTag(r1)
            r0 = 0
            r0 = r16[r0]
            android.widget.FrameLayout r0 = (android.widget.FrameLayout) r0
            r15.y = r0
            r0.setTag(r1)
            r0 = 7
            r0 = r16[r0]
            ru.sravni.android.bankproduct.databinding.WaitingLayoutSravniBinding r0 = (ru.sravni.android.bankproduct.databinding.WaitingLayoutSravniBinding) r0
            r15.z = r0
            r15.setContainedBinding(r0)
            com.google.android.material.textview.MaterialTextView r0 = r15.tvDescriptionSms
            r0.setTag(r1)
            com.google.android.material.textview.MaterialTextView r0 = r15.tvRepeatSmsCode
            r0.setTag(r1)
            com.google.android.material.textview.MaterialTextView r0 = r15.tvTimer
            r0.setTag(r1)
            com.google.android.material.textview.MaterialTextView r0 = r15.tvWrongSmsCode
            r0.setTag(r1)
            r0 = r22
            r15.setRootTag(r0)
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r0 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r1 = 1
            r0.<init>(r15, r1)
            r15.A = r0
            r20.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.AvitoSmsFragmentSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        IProfileSmsViewModel iProfileSmsViewModel = this.mSmsViewModel;
        if (iProfileSmsViewModel != null) {
            iProfileSmsViewModel.repeatSendPhone();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00f5  */
    @Override // androidx.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
        // Method dump skipped, instructions count: 413
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.AvitoSmsFragmentSravniBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.B != 0) {
                return true;
            }
        }
        if (this.z.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.B = 32;
        }
        this.z.invalidateAll();
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

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Boolean;>;I)Z */
    public final boolean l(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.B |= 1;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
    public final boolean m(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.B |= 4;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
    public final boolean n(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.B |= 8;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            LiveData liveData = (LiveData) obj;
            return l(i2);
        } else if (i == 1) {
            LiveData liveData2 = (LiveData) obj;
            return j(i2);
        } else if (i == 2) {
            LiveData liveData3 = (LiveData) obj;
            return m(i2);
        } else if (i != 3) {
            return false;
        } else {
            LiveData liveData4 = (LiveData) obj;
            return n(i2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.z.setLifecycleOwner(lifecycleOwner);
    }

    @Override // ru.sravni.android.bankproduct.databinding.AvitoSmsFragmentSravniBinding
    public void setSmsViewModel(@Nullable IProfileSmsViewModel iProfileSmsViewModel) {
        this.mSmsViewModel = iProfileSmsViewModel;
        synchronized (this) {
            this.B |= 16;
        }
        notifyPropertyChanged(BR.smsViewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.smsViewModel != i) {
            return false;
        }
        setSmsViewModel((IProfileSmsViewModel) obj);
        return true;
    }
}
