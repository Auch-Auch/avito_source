package ru.sravni.android.bankproduct.databinding;

import android.view.View;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISuggestionAnswerViewModel;
public class SuggestTextAnswerSravniBindingImpl extends SuggestTextAnswerSravniBinding implements OnClickListener.Listener {
    @Nullable
    public final View.OnClickListener y;
    public long z = -1;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SuggestTextAnswerSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r12, @androidx.annotation.NonNull android.view.View r13) {
        /*
            r11 = this;
            r0 = 3
            r1 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r12, r13, r0, r1, r1)
            r2 = 1
            r3 = r0[r2]
            r8 = r3
            android.widget.AutoCompleteTextView r8 = (android.widget.AutoCompleteTextView) r8
            r3 = 0
            r3 = r0[r3]
            r9 = r3
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            r3 = 2
            r0 = r0[r3]
            r10 = r0
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            r7 = 4
            r4 = r11
            r5 = r12
            r6 = r13
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r3 = -1
            r11.z = r3
            android.widget.AutoCompleteTextView r12 = r11.actvAnswer
            r12.setTag(r1)
            androidx.constraintlayout.widget.ConstraintLayout r12 = r11.clSuggestContainer
            r12.setTag(r1)
            android.widget.ImageView r12 = r11.imgSendAnswer
            r12.setTag(r1)
            r11.setRootTag(r13)
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r12 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r12.<init>(r11, r2)
            r11.y = r12
            r11.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.SuggestTextAnswerSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        INextContentCard iNextContentCard = this.mNextContentCard;
        ISuggestionAnswerViewModel iSuggestionAnswerViewModel = this.mSuggestionAnswerViewModel;
        if (iSuggestionAnswerViewModel != null) {
            iSuggestionAnswerViewModel.sendAnswer(iNextContentCard);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c5  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
        // Method dump skipped, instructions count: 270
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.SuggestTextAnswerSravniBindingImpl.executeBindings():void");
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
            this.z = 64;
        }
        requestRebind();
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Boolean;>;I)Z */
    public final boolean j(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.z |= 2;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
    public final boolean l(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.z |= 1;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Integer;>;I)Z */
    public final boolean m(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.z |= 8;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
    public final boolean n(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.z |= 4;
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
            return n(i2);
        } else if (i != 3) {
            return false;
        } else {
            LiveData liveData4 = (LiveData) obj;
            return m(i2);
        }
    }

    @Override // ru.sravni.android.bankproduct.databinding.SuggestTextAnswerSravniBinding
    public void setNextContentCard(@Nullable INextContentCard iNextContentCard) {
        this.mNextContentCard = iNextContentCard;
        synchronized (this) {
            this.z |= 32;
        }
        notifyPropertyChanged(BR.nextContentCard);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.SuggestTextAnswerSravniBinding
    public void setSuggestionAnswerViewModel(@Nullable ISuggestionAnswerViewModel iSuggestionAnswerViewModel) {
        this.mSuggestionAnswerViewModel = iSuggestionAnswerViewModel;
        synchronized (this) {
            this.z |= 16;
        }
        notifyPropertyChanged(BR.suggestionAnswerViewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.suggestionAnswerViewModel == i) {
            setSuggestionAnswerViewModel((ISuggestionAnswerViewModel) obj);
        } else if (BR.nextContentCard != i) {
            return false;
        } else {
            setNextContentCard((INextContentCard) obj);
        }
        return true;
    }
}
