package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.presentation.auth.tokenfail.viewmodel.ITokenTokenFailDialogViewModel;
public class TokenRefreshDialogSravniBindingImpl extends TokenRefreshDialogSravniBinding implements OnClickListener.Listener {
    @Nullable
    public static final SparseIntArray B;
    public long A = -1;
    @NonNull
    public final ConstraintLayout y;
    @Nullable
    public final View.OnClickListener z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        B = sparseIntArray;
        sparseIntArray.put(R.id.tvErrorDescription, 2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TokenRefreshDialogSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r11, @androidx.annotation.NonNull android.view.View r12) {
        /*
            r10 = this;
            android.util.SparseIntArray r0 = ru.sravni.android.bankproduct.databinding.TokenRefreshDialogSravniBindingImpl.B
            r1 = 3
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r11, r12, r1, r2, r0)
            r1 = 1
            r3 = r0[r1]
            r8 = r3
            android.widget.TextView r8 = (android.widget.TextView) r8
            r3 = 2
            r3 = r0[r3]
            r9 = r3
            android.widget.TextView r9 = (android.widget.TextView) r9
            r7 = 0
            r4 = r10
            r5 = r11
            r6 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            r3 = -1
            r10.A = r3
            r11 = 0
            r11 = r0[r11]
            androidx.constraintlayout.widget.ConstraintLayout r11 = (androidx.constraintlayout.widget.ConstraintLayout) r11
            r10.y = r11
            r11.setTag(r2)
            android.widget.TextView r11 = r10.tvButtonOk
            r11.setTag(r2)
            r10.setRootTag(r12)
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r11 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r11.<init>(r10, r1)
            r10.z = r11
            r10.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.TokenRefreshDialogSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        ITokenTokenFailDialogViewModel iTokenTokenFailDialogViewModel = this.mViewModel;
        if (iTokenTokenFailDialogViewModel != null) {
            iTokenTokenFailDialogViewModel.clickButtonOk();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.A;
            this.A = 0;
        }
        if ((j & 2) != 0) {
            this.tvButtonOk.setOnClickListener(this.z);
        }
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
            this.A = 2;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.viewModel != i) {
            return false;
        }
        setViewModel((ITokenTokenFailDialogViewModel) obj);
        return true;
    }

    @Override // ru.sravni.android.bankproduct.databinding.TokenRefreshDialogSravniBinding
    public void setViewModel(@Nullable ITokenTokenFailDialogViewModel iTokenTokenFailDialogViewModel) {
        this.mViewModel = iTokenTokenFailDialogViewModel;
        synchronized (this) {
            this.A |= 1;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }
}
