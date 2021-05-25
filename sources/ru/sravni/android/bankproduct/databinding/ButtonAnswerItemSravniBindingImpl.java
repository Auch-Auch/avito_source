package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.google.android.material.button.MaterialButton;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ButtonAnswerInfo;
public class ButtonAnswerItemSravniBindingImpl extends ButtonAnswerItemSravniBinding implements OnClickListener.Listener {
    public long A = -1;
    @NonNull
    public final MaterialButton y;
    @Nullable
    public final View.OnClickListener z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ButtonAnswerItemSravniBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
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
        INextContentCard iNextContentCard = this.mClickSendAnswer;
        ButtonAnswerInfo buttonAnswerInfo = this.mButtonAnswerInfo;
        boolean z2 = true;
        if (iNextContentCard != null) {
            if (buttonAnswerInfo == null) {
                z2 = false;
            }
            if (z2) {
                iNextContentCard.nextCard(buttonAnswerInfo.getAnswerInfoDomain());
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.A;
            this.A = 0;
        }
        String str = null;
        ButtonAnswerInfo buttonAnswerInfo = this.mButtonAnswerInfo;
        int i = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if (!(i == 0 || buttonAnswerInfo == null)) {
            str = buttonAnswerInfo.getActionText();
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.y, str);
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

    @Override // ru.sravni.android.bankproduct.databinding.ButtonAnswerItemSravniBinding
    public void setButtonAnswerInfo(@Nullable ButtonAnswerInfo buttonAnswerInfo) {
        this.mButtonAnswerInfo = buttonAnswerInfo;
        synchronized (this) {
            this.A |= 2;
        }
        notifyPropertyChanged(BR.buttonAnswerInfo);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ButtonAnswerItemSravniBinding
    public void setClickSendAnswer(@Nullable INextContentCard iNextContentCard) {
        this.mClickSendAnswer = iNextContentCard;
        synchronized (this) {
            this.A |= 1;
        }
        notifyPropertyChanged(BR.clickSendAnswer);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.clickSendAnswer == i) {
            setClickSendAnswer((INextContentCard) obj);
        } else if (BR.buttonAnswerInfo != i) {
            return false;
        } else {
            setButtonAnswerInfo((ButtonAnswerInfo) obj);
        }
        return true;
    }
}
