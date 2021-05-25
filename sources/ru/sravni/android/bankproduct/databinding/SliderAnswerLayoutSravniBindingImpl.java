package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISliderAnswerViewModel;
public class SliderAnswerLayoutSravniBindingImpl extends SliderAnswerLayoutSravniBinding implements OnClickListener.Listener {
    @Nullable
    public static final SparseIntArray A;
    @Nullable
    public final View.OnClickListener y;
    public long z = -1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        A = sparseIntArray;
        sparseIntArray.put(R.id.flSlider, 5);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SliderAnswerLayoutSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r14, @androidx.annotation.NonNull android.view.View r15) {
        /*
            r13 = this;
            android.util.SparseIntArray r0 = ru.sravni.android.bankproduct.databinding.SliderAnswerLayoutSravniBindingImpl.A
            r1 = 6
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r14, r15, r1, r2, r0)
            r1 = 5
            r1 = r0[r1]
            r7 = r1
            android.widget.FrameLayout r7 = (android.widget.FrameLayout) r7
            r1 = 4
            r1 = r0[r1]
            r8 = r1
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r1 = 0
            r1 = r0[r1]
            r9 = r1
            androidx.constraintlayout.widget.ConstraintLayout r9 = (androidx.constraintlayout.widget.ConstraintLayout) r9
            r1 = 1
            r3 = r0[r1]
            r10 = r3
            com.google.android.material.slider.Slider r10 = (com.google.android.material.slider.Slider) r10
            r3 = 3
            r3 = r0[r3]
            r11 = r3
            android.widget.TextView r11 = (android.widget.TextView) r11
            r3 = 2
            r0 = r0[r3]
            r12 = r0
            android.widget.TextView r12 = (android.widget.TextView) r12
            r6 = 5
            r3 = r13
            r4 = r14
            r5 = r15
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r3 = -1
            r13.z = r3
            android.widget.ImageView r14 = r13.imgSendAnswer
            r14.setTag(r2)
            androidx.constraintlayout.widget.ConstraintLayout r14 = r13.llSliderAnswerLayout
            r14.setTag(r2)
            com.google.android.material.slider.Slider r14 = r13.slider
            r14.setTag(r2)
            android.widget.TextView r14 = r13.tvMaxAmountTitle
            r14.setTag(r2)
            android.widget.TextView r14 = r13.tvMinAmountTitle
            r14.setTag(r2)
            r13.setRootTag(r15)
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r14 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r14.<init>(r13, r1)
            r13.y = r14
            r13.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.SliderAnswerLayoutSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        INextContentCard iNextContentCard = this.mNextContentCard;
        ISliderAnswerViewModel iSliderAnswerViewModel = this.mSliderAnswerViewModel;
        if (iSliderAnswerViewModel != null) {
            iSliderAnswerViewModel.sendAnswer(iNextContentCard);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00b2  */
    @Override // androidx.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
        // Method dump skipped, instructions count: 276
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.SliderAnswerLayoutSravniBindingImpl.executeBindings():void");
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
            this.z = 128;
        }
        requestRebind();
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Integer;>;I)Z */
    public final boolean j(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.z |= 1;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
    public final boolean l(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.z |= 4;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
    public final boolean m(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.z |= 2;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/util/List<Ljava/lang/String;>;>;I)Z */
    public final boolean n(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.z |= 8;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Integer;>;I)Z */
    public final boolean o(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.z |= 16;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            LiveData liveData = (LiveData) obj;
            return j(i2);
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
            return o(i2);
        }
    }

    @Override // ru.sravni.android.bankproduct.databinding.SliderAnswerLayoutSravniBinding
    public void setNextContentCard(@Nullable INextContentCard iNextContentCard) {
        this.mNextContentCard = iNextContentCard;
        synchronized (this) {
            this.z |= 64;
        }
        notifyPropertyChanged(BR.nextContentCard);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.SliderAnswerLayoutSravniBinding
    public void setSliderAnswerViewModel(@Nullable ISliderAnswerViewModel iSliderAnswerViewModel) {
        this.mSliderAnswerViewModel = iSliderAnswerViewModel;
        synchronized (this) {
            this.z |= 32;
        }
        notifyPropertyChanged(BR.sliderAnswerViewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.sliderAnswerViewModel == i) {
            setSliderAnswerViewModel((ISliderAnswerViewModel) obj);
        } else if (BR.nextContentCard != i) {
            return false;
        } else {
            setNextContentCard((INextContentCard) obj);
        }
        return true;
    }
}
