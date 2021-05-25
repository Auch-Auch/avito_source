package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.button.MaterialButton;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IOsagoOrderAnswerViewModel;
public class OsagoOrderAnswerLayoutSravniBindingImpl extends OsagoOrderAnswerLayoutSravniBinding implements OnClickListener.Listener {
    public long A = -1;
    @NonNull
    public final MaterialButton y;
    @Nullable
    public final View.OnClickListener z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OsagoOrderAnswerLayoutSravniBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        super(dataBindingComponent, view, 0);
        Object[] mapBindings = ViewDataBinding.mapBindings(dataBindingComponent, view, 1, (ViewDataBinding.IncludedLayouts) null, (SparseIntArray) null);
        MaterialButton materialButton = (MaterialButton) mapBindings[0];
        this.y = materialButton;
        materialButton.setTag(null);
        setRootTag(view);
        this.z = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        IOsagoOrderAnswerViewModel iOsagoOrderAnswerViewModel = this.mOsagoOrderAnswerViewModel;
        INextContentCard iNextContentCard = this.mNextContentCard;
        if (iOsagoOrderAnswerViewModel != null) {
            iOsagoOrderAnswerViewModel.clickShowOsagoOrder(iNextContentCard);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.A;
            this.A = 0;
        }
        if ((j & 4) != 0) {
            this.y.setOnClickListener(this.z);
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

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // ru.sravni.android.bankproduct.databinding.OsagoOrderAnswerLayoutSravniBinding
    public void setNextContentCard(@Nullable INextContentCard iNextContentCard) {
        this.mNextContentCard = iNextContentCard;
        synchronized (this) {
            this.A |= 2;
        }
        notifyPropertyChanged(BR.nextContentCard);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.OsagoOrderAnswerLayoutSravniBinding
    public void setOsagoOrderAnswerViewModel(@Nullable IOsagoOrderAnswerViewModel iOsagoOrderAnswerViewModel) {
        this.mOsagoOrderAnswerViewModel = iOsagoOrderAnswerViewModel;
        synchronized (this) {
            this.A |= 1;
        }
        notifyPropertyChanged(BR.osagoOrderAnswerViewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.osagoOrderAnswerViewModel == i) {
            setOsagoOrderAnswerViewModel((IOsagoOrderAnswerViewModel) obj);
        } else if (BR.nextContentCard != i) {
            return false;
        } else {
            setNextContentCard((INextContentCard) obj);
        }
        return true;
    }
}
