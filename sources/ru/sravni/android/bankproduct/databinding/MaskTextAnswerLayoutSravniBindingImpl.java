package ru.sravni.android.bankproduct.databinding;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.LiveData;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.presentation.chat.adapter.answer.BindingMaskAnswerAdapterKt;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IMaskTextAnswerViewModel;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.InitMaskElementInfo;
public class MaskTextAnswerLayoutSravniBindingImpl extends MaskTextAnswerLayoutSravniBinding implements OnClickListener.Listener {
    public long A = -1;
    @NonNull
    public final ConstraintLayout y;
    @Nullable
    public final View.OnClickListener z;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public MaskTextAnswerLayoutSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r11, @androidx.annotation.NonNull android.view.View r12) {
        /*
            r10 = this;
            r0 = 3
            r1 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r11, r12, r0, r1, r1)
            r2 = 1
            r3 = r0[r2]
            r8 = r3
            ru.sravni.android.bankproduct.utils.CustomEditTextWithControlledListeners r8 = (ru.sravni.android.bankproduct.utils.CustomEditTextWithControlledListeners) r8
            r3 = 2
            r3 = r0[r3]
            r9 = r3
            android.widget.ImageView r9 = (android.widget.ImageView) r9
            r7 = 2
            r4 = r10
            r5 = r11
            r6 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            r3 = -1
            r10.A = r3
            ru.sravni.android.bankproduct.utils.CustomEditTextWithControlledListeners r11 = r10.etAnswer
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
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.MaskTextAnswerLayoutSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        INextContentCard iNextContentCard = this.mNextContentCard;
        IMaskTextAnswerViewModel iMaskTextAnswerViewModel = this.mMaskTextAnswerViewModel;
        boolean z2 = true;
        if (iNextContentCard != null) {
            if (iMaskTextAnswerViewModel == null) {
                z2 = false;
            }
            if (z2) {
                iNextContentCard.nextCard(iMaskTextAnswerViewModel.getAnswerInfoDomain());
            }
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        Drawable drawable;
        synchronized (this) {
            j = this.A;
            this.A = 0;
        }
        IMaskTextAnswerViewModel iMaskTextAnswerViewModel = this.mMaskTextAnswerViewModel;
        boolean z2 = false;
        InitMaskElementInfo initMaskElementInfo = null;
        if ((27 & j) != 0) {
            int i = ((j & 25) > 0 ? 1 : ((j & 25) == 0 ? 0 : -1));
            if (i != 0) {
                LiveData<Boolean> canAnswer = iMaskTextAnswerViewModel != null ? iMaskTextAnswerViewModel.getCanAnswer() : null;
                updateLiveDataRegistration(0, canAnswer);
                boolean safeUnbox = ViewDataBinding.safeUnbox(canAnswer != null ? canAnswer.getValue() : null);
                if (i != 0) {
                    j |= safeUnbox ? 64 : 32;
                }
                drawable = AppCompatResources.getDrawable(this.imgSendAnswer.getContext(), safeUnbox ? R.drawable.ic_send_answer_active_sravni : R.drawable.ic_send_answer_inactive_sravni);
                z2 = safeUnbox;
            } else {
                drawable = null;
            }
            if ((j & 26) != 0) {
                LiveData<InitMaskElementInfo> initMaskElement = iMaskTextAnswerViewModel != null ? iMaskTextAnswerViewModel.getInitMaskElement() : null;
                updateLiveDataRegistration(1, initMaskElement);
                if (initMaskElement != null) {
                    initMaskElementInfo = initMaskElement.getValue();
                }
            }
        } else {
            drawable = null;
        }
        if ((26 & j) != 0) {
            BindingMaskAnswerAdapterKt.bindMaskAnswerToEditText(this.etAnswer, initMaskElementInfo, iMaskTextAnswerViewModel);
        }
        if ((j & 25) != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.imgSendAnswer, drawable);
            ViewBindingAdapter.setOnClick(this.imgSendAnswer, this.z, z2);
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
            this.A = 16;
        }
        requestRebind();
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Boolean;>;I)Z */
    public final boolean j(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.A |= 1;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/InitMaskElementInfo;>;I)Z */
    public final boolean l(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.A |= 2;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            LiveData liveData = (LiveData) obj;
            return j(i2);
        } else if (i != 1) {
            return false;
        } else {
            LiveData liveData2 = (LiveData) obj;
            return l(i2);
        }
    }

    @Override // ru.sravni.android.bankproduct.databinding.MaskTextAnswerLayoutSravniBinding
    public void setMaskTextAnswerViewModel(@Nullable IMaskTextAnswerViewModel iMaskTextAnswerViewModel) {
        this.mMaskTextAnswerViewModel = iMaskTextAnswerViewModel;
        synchronized (this) {
            this.A |= 8;
        }
        notifyPropertyChanged(BR.maskTextAnswerViewModel);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.MaskTextAnswerLayoutSravniBinding
    public void setNextContentCard(@Nullable INextContentCard iNextContentCard) {
        this.mNextContentCard = iNextContentCard;
        synchronized (this) {
            this.A |= 4;
        }
        notifyPropertyChanged(BR.nextContentCard);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.nextContentCard == i) {
            setNextContentCard((INextContentCard) obj);
        } else if (BR.maskTextAnswerViewModel != i) {
            return false;
        } else {
            setMaskTextAnswerViewModel((IMaskTextAnswerViewModel) obj);
        }
        return true;
    }
}
