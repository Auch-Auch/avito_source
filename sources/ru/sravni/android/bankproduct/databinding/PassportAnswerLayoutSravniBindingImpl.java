package ru.sravni.android.bankproduct.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.INextContentCard;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.IPassportScanAnswerViewModel;
public class PassportAnswerLayoutSravniBindingImpl extends PassportAnswerLayoutSravniBinding implements OnClickListener.Listener {
    @NonNull
    public final TextInputEditText A;
    @NonNull
    public final TextInputEditText B;
    @NonNull
    public final TextInputEditText C;
    @NonNull
    public final MaterialButton D;
    @Nullable
    public final View.OnClickListener E;
    public long F = -1;
    @NonNull
    public final ConstraintLayout y;
    @NonNull
    public final TextInputEditText z;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PassportAnswerLayoutSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r12, @androidx.annotation.NonNull android.view.View r13) {
        /*
            r11 = this;
            r0 = 10
            r1 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r12, r13, r0, r1, r1)
            r2 = 7
            r2 = r0[r2]
            r7 = r2
            com.google.android.material.textfield.TextInputLayout r7 = (com.google.android.material.textfield.TextInputLayout) r7
            r2 = 5
            r2 = r0[r2]
            r8 = r2
            com.google.android.material.textfield.TextInputLayout r8 = (com.google.android.material.textfield.TextInputLayout) r8
            r2 = 3
            r2 = r0[r2]
            r9 = r2
            com.google.android.material.textfield.TextInputLayout r9 = (com.google.android.material.textfield.TextInputLayout) r9
            r2 = 1
            r3 = r0[r2]
            r10 = r3
            com.google.android.material.textfield.TextInputLayout r10 = (com.google.android.material.textfield.TextInputLayout) r10
            r6 = 9
            r3 = r11
            r4 = r12
            r5 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            r3 = -1
            r11.F = r3
            r12 = 0
            r12 = r0[r12]
            androidx.constraintlayout.widget.ConstraintLayout r12 = (androidx.constraintlayout.widget.ConstraintLayout) r12
            r11.y = r12
            r12.setTag(r1)
            r12 = 2
            r12 = r0[r12]
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            r11.z = r12
            r12.setTag(r1)
            r12 = 4
            r12 = r0[r12]
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            r11.A = r12
            r12.setTag(r1)
            r12 = 6
            r12 = r0[r12]
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            r11.B = r12
            r12.setTag(r1)
            r12 = 8
            r12 = r0[r12]
            com.google.android.material.textfield.TextInputEditText r12 = (com.google.android.material.textfield.TextInputEditText) r12
            r11.C = r12
            r12.setTag(r1)
            r12 = 9
            r12 = r0[r12]
            com.google.android.material.button.MaterialButton r12 = (com.google.android.material.button.MaterialButton) r12
            r11.D = r12
            r12.setTag(r1)
            com.google.android.material.textfield.TextInputLayout r12 = r11.tilPassportBoth
            r12.setTag(r1)
            com.google.android.material.textfield.TextInputLayout r12 = r11.tilPassportCode
            r12.setTag(r1)
            com.google.android.material.textfield.TextInputLayout r12 = r11.tilPassportDate
            r12.setTag(r1)
            com.google.android.material.textfield.TextInputLayout r12 = r11.tilPassportNumber
            r12.setTag(r1)
            r11.setRootTag(r13)
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r12 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r12.<init>(r11, r2)
            r11.E = r12
            r11.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.PassportAnswerLayoutSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        INextContentCard iNextContentCard = this.mNextContentCard;
        IPassportScanAnswerViewModel iPassportScanAnswerViewModel = this.mPassportScanAnswerViewModel;
        boolean z2 = true;
        if (iNextContentCard != null) {
            if (iPassportScanAnswerViewModel == null) {
                z2 = false;
            }
            if (z2) {
                iNextContentCard.nextCard(iPassportScanAnswerViewModel.getAnswerInfoDomain());
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0178  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x00fe  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x011b  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0127  */
    @Override // androidx.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
        // Method dump skipped, instructions count: 552
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.PassportAnswerLayoutSravniBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.F != 0) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.F = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        requestRebind();
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/DocumentFieldInfo;>;I)Z */
    public final boolean j(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.F |= 16;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/DocumentFieldInfo;>;I)Z */
    public final boolean l(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.F |= 1;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Boolean;>;I)Z */
    public final boolean m(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.F |= 2;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Boolean;>;I)Z */
    public final boolean n(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.F |= 256;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Boolean;>;I)Z */
    public final boolean o(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.F |= 8;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                LiveData liveData = (LiveData) obj;
                return l(i2);
            case 1:
                LiveData liveData2 = (LiveData) obj;
                return m(i2);
            case 2:
                LiveData liveData3 = (LiveData) obj;
                return q(i2);
            case 3:
                LiveData liveData4 = (LiveData) obj;
                return o(i2);
            case 4:
                LiveData liveData5 = (LiveData) obj;
                return j(i2);
            case 5:
                LiveData liveData6 = (LiveData) obj;
                return s(i2);
            case 6:
                LiveData liveData7 = (LiveData) obj;
                return r(i2);
            case 7:
                LiveData liveData8 = (LiveData) obj;
                return p(i2);
            case 8:
                LiveData liveData9 = (LiveData) obj;
                return n(i2);
            default:
                return false;
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Boolean;>;I)Z */
    public final boolean p(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.F |= 128;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Boolean;>;I)Z */
    public final boolean q(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.F |= 4;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/DocumentFieldInfo;>;I)Z */
    public final boolean r(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.F |= 64;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Lru/sravni/android/bankproduct/presentation/chat/viewmodel/answer/DocumentFieldInfo;>;I)Z */
    public final boolean s(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.F |= 32;
        }
        return true;
    }

    @Override // ru.sravni.android.bankproduct.databinding.PassportAnswerLayoutSravniBinding
    public void setNextContentCard(@Nullable INextContentCard iNextContentCard) {
        this.mNextContentCard = iNextContentCard;
        synchronized (this) {
            this.F |= 512;
        }
        notifyPropertyChanged(BR.nextContentCard);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.PassportAnswerLayoutSravniBinding
    public void setPassportScanAnswerViewModel(@Nullable IPassportScanAnswerViewModel iPassportScanAnswerViewModel) {
        this.mPassportScanAnswerViewModel = iPassportScanAnswerViewModel;
        synchronized (this) {
            this.F |= 1024;
        }
        notifyPropertyChanged(BR.passportScanAnswerViewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.nextContentCard == i) {
            setNextContentCard((INextContentCard) obj);
        } else if (BR.passportScanAnswerViewModel != i) {
            return false;
        } else {
            setPassportScanAnswerViewModel((IPassportScanAnswerViewModel) obj);
        }
        return true;
    }
}
