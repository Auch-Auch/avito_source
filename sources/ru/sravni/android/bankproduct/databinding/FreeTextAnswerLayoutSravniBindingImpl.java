package ru.sravni.android.bankproduct.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IFreeTextAnswerViewModel;
public class FreeTextAnswerLayoutSravniBindingImpl extends FreeTextAnswerLayoutSravniBinding implements OnClickListener.Listener {
    public long A = -1;
    @NonNull
    public final ConstraintLayout y;
    @Nullable
    public final View.OnClickListener z;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FreeTextAnswerLayoutSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r11, @androidx.annotation.NonNull android.view.View r12) {
        /*
            r10 = this;
            r0 = 3
            r1 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r11, r12, r0, r1, r1)
            r2 = 1
            r3 = r0[r2]
            r8 = r3
            android.widget.EditText r8 = (android.widget.EditText) r8
            r3 = 2
            r3 = r0[r3]
            r9 = r3
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            r7 = 4
            r4 = r10
            r5 = r11
            r6 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            r3 = -1
            r10.A = r3
            android.widget.EditText r11 = r10.etAnswer
            r11.setTag(r1)
            android.widget.ImageView r11 = r10.imgSendAnswer
            r11.setTag(r1)
            r11 = 0
            r11 = r0[r11]
            androidx.constraintlayout.widget.ConstraintLayout r11 = (androidx.constraintlayout.widget.ConstraintLayout) r11
            r10.y = r11
            r11.setTag(r1)
            r10.setRootTag(r12)
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r11 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r11.<init>(r10, r2)
            r10.z = r11
            r10.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.FreeTextAnswerLayoutSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        IFreeTextAnswerViewModel iFreeTextAnswerViewModel = this.mFreeTextAnswerViewModel;
        INextContentCard iNextContentCard = this.mNextContentCard;
        boolean z2 = true;
        if (iNextContentCard != null) {
            if (iFreeTextAnswerViewModel == null) {
                z2 = false;
            }
            if (z2) {
                iNextContentCard.nextCard(iFreeTextAnswerViewModel.getAnswerInfoDomain());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ab  */
    @Override // androidx.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
        // Method dump skipped, instructions count: 280
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.FreeTextAnswerLayoutSravniBindingImpl.executeBindings():void");
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

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Boolean;>;I)Z */
    public final boolean j(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.A |= 2;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
    public final boolean l(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.A |= 8;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Integer;>;I)Z */
    public final boolean m(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.A |= 4;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
    public final boolean n(int i) {
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
            return n(i2);
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
            return l(i2);
        }
    }

    @Override // ru.sravni.android.bankproduct.databinding.FreeTextAnswerLayoutSravniBinding
    public void setFreeTextAnswerViewModel(@Nullable IFreeTextAnswerViewModel iFreeTextAnswerViewModel) {
        this.mFreeTextAnswerViewModel = iFreeTextAnswerViewModel;
        synchronized (this) {
            this.A |= 16;
        }
        notifyPropertyChanged(BR.freeTextAnswerViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.FreeTextAnswerLayoutSravniBinding
    public void setNextContentCard(@Nullable INextContentCard iNextContentCard) {
        this.mNextContentCard = iNextContentCard;
        synchronized (this) {
            this.A |= 32;
        }
        notifyPropertyChanged(BR.nextContentCard);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.freeTextAnswerViewModel == i) {
            setFreeTextAnswerViewModel((IFreeTextAnswerViewModel) obj);
        } else if (BR.nextContentCard != i) {
            return false;
        } else {
            setNextContentCard((INextContentCard) obj);
        }
        return true;
    }
}
