package ru.sravni.android.bankproduct.databinding;

import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import java.util.List;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.presentation.chat.adapter.answer.BindingAnswerAdapterKt;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ButtonAnswerInfo;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IButtonAnswerViewModel;
public class ButtonAnswerLayoutSravniBindingImpl extends ButtonAnswerLayoutSravniBinding {
    @NonNull
    public final FrameLayout y;
    public long z = -1;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ButtonAnswerLayoutSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r5, @androidx.annotation.NonNull android.view.View r6) {
        /*
            r4 = this;
            r0 = 2
            r1 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r5, r6, r0, r1, r1)
            r2 = 1
            r3 = r0[r2]
            androidx.recyclerview.widget.RecyclerView r3 = (androidx.recyclerview.widget.RecyclerView) r3
            r4.<init>(r5, r6, r2, r3)
            r2 = -1
            r4.z = r2
            r5 = 0
            r5 = r0[r5]
            android.widget.FrameLayout r5 = (android.widget.FrameLayout) r5
            r4.y = r5
            r5.setTag(r1)
            androidx.recyclerview.widget.RecyclerView r5 = r4.rvButtonAnswer
            r5.setTag(r1)
            r4.setRootTag(r6)
            r4.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.ButtonAnswerLayoutSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.z;
            this.z = 0;
        }
        IButtonAnswerViewModel iButtonAnswerViewModel = this.mButtonAnswerViewModel;
        INextContentCard iNextContentCard = this.mNextContentCard;
        List<ButtonAnswerInfo> list = null;
        int i = ((j & 15) > 0 ? 1 : ((j & 15) == 0 ? 0 : -1));
        if (i != 0) {
            LiveData<List<ButtonAnswerInfo>> buttonAnswerVariantList = iButtonAnswerViewModel != null ? iButtonAnswerViewModel.getButtonAnswerVariantList() : null;
            updateLiveDataRegistration(0, buttonAnswerVariantList);
            if (buttonAnswerVariantList != null) {
                list = buttonAnswerVariantList.getValue();
            }
        }
        if (i != 0) {
            BindingAnswerAdapterKt.bindListToRecycler(this.rvButtonAnswer, list, iNextContentCard);
        }
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
            this.z = 8;
        }
        requestRebind();
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/util/List<Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/ButtonAnswerInfo;>;>;I)Z */
    public final boolean j(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.z |= 1;
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

    @Override // ru.sravni.android.bankproduct.databinding.ButtonAnswerLayoutSravniBinding
    public void setButtonAnswerViewModel(@Nullable IButtonAnswerViewModel iButtonAnswerViewModel) {
        this.mButtonAnswerViewModel = iButtonAnswerViewModel;
        synchronized (this) {
            this.z |= 2;
        }
        notifyPropertyChanged(BR.buttonAnswerViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.ButtonAnswerLayoutSravniBinding
    public void setNextContentCard(@Nullable INextContentCard iNextContentCard) {
        this.mNextContentCard = iNextContentCard;
        synchronized (this) {
            this.z |= 4;
        }
        notifyPropertyChanged(BR.nextContentCard);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.buttonAnswerViewModel == i) {
            setButtonAnswerViewModel((IButtonAnswerViewModel) obj);
        } else if (BR.nextContentCard != i) {
            return false;
        } else {
            setNextContentCard((INextContentCard) obj);
        }
        return true;
    }
}
