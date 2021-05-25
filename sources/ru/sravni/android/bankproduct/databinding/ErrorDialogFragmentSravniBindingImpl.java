package ru.sravni.android.bankproduct.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.presentation.dialogerror.viewmodel.IDialogErrorViewModel;
public class ErrorDialogFragmentSravniBindingImpl extends ErrorDialogFragmentSravniBinding implements OnClickListener.Listener {
    public long A = -1;
    @NonNull
    public final ConstraintLayout y;
    @Nullable
    public final View.OnClickListener z;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ErrorDialogFragmentSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r10, @androidx.annotation.NonNull android.view.View r11) {
        /*
            r9 = this;
            r0 = 3
            r1 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r10, r11, r0, r1, r1)
            r2 = 2
            r2 = r0[r2]
            r7 = r2
            android.widget.TextView r7 = (android.widget.TextView) r7
            r2 = 1
            r3 = r0[r2]
            r8 = r3
            android.widget.TextView r8 = (android.widget.TextView) r8
            r6 = 1
            r3 = r9
            r4 = r10
            r5 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            r3 = -1
            r9.A = r3
            r10 = 0
            r10 = r0[r10]
            androidx.constraintlayout.widget.ConstraintLayout r10 = (androidx.constraintlayout.widget.ConstraintLayout) r10
            r9.y = r10
            r10.setTag(r1)
            android.widget.TextView r10 = r9.tvButtonOk
            r10.setTag(r1)
            android.widget.TextView r10 = r9.tvErrorDescription
            r10.setTag(r1)
            r9.setRootTag(r11)
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r10 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r10.<init>(r9, r2)
            r9.z = r10
            r9.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.ErrorDialogFragmentSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        IDialogErrorViewModel iDialogErrorViewModel = this.mViewModel;
        if (iDialogErrorViewModel != null) {
            iDialogErrorViewModel.clickButtonOk();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.A;
            this.A = 0;
        }
        IDialogErrorViewModel iDialogErrorViewModel = this.mViewModel;
        String str = null;
        int i = ((7 & j) > 0 ? 1 : ((7 & j) == 0 ? 0 : -1));
        if (i != 0) {
            LiveData<String> errorMessage = iDialogErrorViewModel != null ? iDialogErrorViewModel.getErrorMessage() : null;
            updateLiveDataRegistration(0, errorMessage);
            if (errorMessage != null) {
                str = errorMessage.getValue();
            }
        }
        if ((j & 4) != 0) {
            this.tvButtonOk.setOnClickListener(this.z);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.tvErrorDescription, str);
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
            this.A = 4;
        }
        requestRebind();
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
    public final boolean j(int i) {
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
        setViewModel((IDialogErrorViewModel) obj);
        return true;
    }

    @Override // ru.sravni.android.bankproduct.databinding.ErrorDialogFragmentSravniBinding
    public void setViewModel(@Nullable IDialogErrorViewModel iDialogErrorViewModel) {
        this.mViewModel = iDialogErrorViewModel;
        synchronized (this) {
            this.A |= 2;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }
}
