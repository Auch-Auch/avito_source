package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.presentation.auth.sms.viewmodel.IProfileSmsViewModel;
public class ProfileSmsFragmentSravniBindingImpl extends ProfileSmsFragmentSravniBinding implements OnClickListener.Listener {
    @Nullable
    public static final SparseIntArray B;
    public long A = -1;
    @NonNull
    public final LinearLayout y;
    @Nullable
    public final View.OnClickListener z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        B = sparseIntArray;
        sparseIntArray.put(R.id.toolbar, 7);
        sparseIntArray.put(R.id.clProfilePhone, 8);
        sparseIntArray.put(R.id.tvTitleSmsCode, 9);
        sparseIntArray.put(R.id.flSmsCode, 10);
        sparseIntArray.put(R.id.llInfoSmsCode, 11);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ProfileSmsFragmentSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r21, @androidx.annotation.NonNull android.view.View r22) {
        /*
            r20 = this;
            r15 = r20
            r14 = r22
            android.util.SparseIntArray r0 = ru.sravni.android.bankproduct.databinding.ProfileSmsFragmentSravniBindingImpl.B
            r1 = 12
            r13 = 0
            r2 = r21
            java.lang.Object[] r16 = androidx.databinding.ViewDataBinding.mapBindings(r2, r14, r1, r13, r0)
            r0 = 8
            r0 = r16[r0]
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r0 = 2
            r0 = r16[r0]
            r5 = r0
            android.widget.EditText r5 = (android.widget.EditText) r5
            r0 = 10
            r0 = r16[r0]
            r6 = r0
            android.widget.FrameLayout r6 = (android.widget.FrameLayout) r6
            r0 = 11
            r0 = r16[r0]
            r7 = r0
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            r0 = 3
            r0 = r16[r0]
            r8 = r0
            android.widget.ProgressBar r8 = (android.widget.ProgressBar) r8
            r0 = 7
            r0 = r16[r0]
            r9 = r0
            androidx.appcompat.widget.Toolbar r9 = (androidx.appcompat.widget.Toolbar) r9
            r0 = 6
            r0 = r16[r0]
            r10 = r0
            android.widget.TextView r10 = (android.widget.TextView) r10
            r12 = 1
            r0 = r16[r12]
            r11 = r0
            android.widget.TextView r11 = (android.widget.TextView) r11
            r0 = 5
            r0 = r16[r0]
            r17 = r0
            android.widget.TextView r17 = (android.widget.TextView) r17
            r0 = 9
            r0 = r16[r0]
            r18 = r0
            android.widget.TextView r18 = (android.widget.TextView) r18
            r0 = 4
            r0 = r16[r0]
            r19 = r0
            android.widget.TextView r19 = (android.widget.TextView) r19
            r3 = 5
            r0 = r20
            r1 = r21
            r2 = r22
            r12 = r17
            r13 = r18
            r14 = r19
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = -1
            r15.A = r0
            android.widget.EditText r0 = r15.etSmsCode
            r1 = 0
            r0.setTag(r1)
            r0 = 0
            r0 = r16[r0]
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r15.y = r0
            r0.setTag(r1)
            android.widget.ProgressBar r0 = r15.pbSmsCode
            r0.setTag(r1)
            android.widget.TextView r0 = r15.tvRepeatSmsCode
            r0.setTag(r1)
            android.widget.TextView r0 = r15.tvSubTitleSmsCode
            r0.setTag(r1)
            android.widget.TextView r0 = r15.tvTimer
            r0.setTag(r1)
            android.widget.TextView r0 = r15.tvWrongSmsCode
            r0.setTag(r1)
            r0 = r22
            r15.setRootTag(r0)
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r0 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r1 = 1
            r0.<init>(r15, r1)
            r15.z = r0
            r20.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.ProfileSmsFragmentSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        IProfileSmsViewModel iProfileSmsViewModel = this.mViewModel;
        if (iProfileSmsViewModel != null) {
            iProfileSmsViewModel.repeatSendPhone();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0151  */
    @Override // androidx.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
        // Method dump skipped, instructions count: 457
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.ProfileSmsFragmentSravniBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.A != 0) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.A = 64;
        }
        requestRebind();
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Lru/sravni/android/bankproduct/presentation/auth/phone/viewmodel/StateEnum;>;I)Z */
    public final boolean j(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.A |= 16;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
    public final boolean l(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.A |= 4;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Boolean;>;I)Z */
    public final boolean m(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.A |= 2;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
    public final boolean n(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.A |= 8;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
    public final boolean o(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.A |= 1;
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
            return m(i2);
        } else if (i == 2) {
            LiveData liveData3 = (LiveData) obj;
            return l(i2);
        } else if (i == 3) {
            LiveData liveData4 = (LiveData) obj;
            return n(i2);
        } else if (i != 4) {
            return false;
        } else {
            LiveData liveData5 = (LiveData) obj;
            return j(i2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.viewModel != i) {
            return false;
        }
        setViewModel((IProfileSmsViewModel) obj);
        return true;
    }

    @Override // ru.sravni.android.bankproduct.databinding.ProfileSmsFragmentSravniBinding
    public void setViewModel(@Nullable IProfileSmsViewModel iProfileSmsViewModel) {
        this.mViewModel = iProfileSmsViewModel;
        synchronized (this) {
            this.A |= 32;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }
}
