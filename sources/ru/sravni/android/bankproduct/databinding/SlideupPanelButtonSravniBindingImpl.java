package ru.sravni.android.bankproduct.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.utils.components.slidinglayout.ISlidingPanelButtonViewModel;
public class SlideupPanelButtonSravniBindingImpl extends SlideupPanelButtonSravniBinding implements OnClickListener.Listener {
    @Nullable
    public final View.OnClickListener A;
    @Nullable
    public final View.OnClickListener B;
    @Nullable
    public final View.OnClickListener C;
    public long D = -1;
    @NonNull
    public final LinearLayout y;
    @NonNull
    public final LinearLayout z;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SlideupPanelButtonSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r14, @androidx.annotation.NonNull android.view.View r15) {
        /*
            r13 = this;
            r0 = 7
            r1 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r14, r15, r0, r1, r1)
            r2 = 2
            r3 = r0[r2]
            r8 = r3
            com.google.android.material.button.MaterialButton r8 = (com.google.android.material.button.MaterialButton) r8
            r3 = 3
            r4 = r0[r3]
            r9 = r4
            com.google.android.material.button.MaterialButton r9 = (com.google.android.material.button.MaterialButton) r9
            r4 = 6
            r4 = r0[r4]
            r10 = r4
            com.google.android.material.button.MaterialButton r10 = (com.google.android.material.button.MaterialButton) r10
            r4 = 4
            r4 = r0[r4]
            r11 = r4
            android.widget.FrameLayout r11 = (android.widget.FrameLayout) r11
            r4 = 5
            r4 = r0[r4]
            r12 = r4
            android.widget.ProgressBar r12 = (android.widget.ProgressBar) r12
            r7 = 4
            r4 = r13
            r5 = r14
            r6 = r15
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
            r4 = -1
            r13.D = r4
            com.google.android.material.button.MaterialButton r14 = r13.btnCancel
            r14.setTag(r1)
            com.google.android.material.button.MaterialButton r14 = r13.btnRecount
            r14.setTag(r1)
            com.google.android.material.button.MaterialButton r14 = r13.btnRecountWithCount
            r14.setTag(r1)
            android.widget.FrameLayout r14 = r13.flRecountWithCount
            r14.setTag(r1)
            r14 = 0
            r14 = r0[r14]
            android.widget.LinearLayout r14 = (android.widget.LinearLayout) r14
            r13.y = r14
            r14.setTag(r1)
            r14 = 1
            r0 = r0[r14]
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            r13.z = r0
            r0.setTag(r1)
            android.widget.ProgressBar r0 = r13.pbRecountWithCount
            r0.setTag(r1)
            r13.setRootTag(r15)
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r15 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r15.<init>(r13, r3)
            r13.A = r15
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r15 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r15.<init>(r13, r14)
            r13.B = r15
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r14 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r14.<init>(r13, r2)
            r13.C = r14
            r13.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.SlideupPanelButtonSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        boolean z2 = false;
        if (i == 1) {
            ISlidingPanelButtonViewModel iSlidingPanelButtonViewModel = this.mButtonPanelViewModel;
            if (iSlidingPanelButtonViewModel != null) {
                z2 = true;
            }
            if (z2) {
                iSlidingPanelButtonViewModel.closeClicked();
            }
        } else if (i == 2) {
            ISlidingPanelButtonViewModel iSlidingPanelButtonViewModel2 = this.mButtonPanelViewModel;
            if (iSlidingPanelButtonViewModel2 != null) {
                z2 = true;
            }
            if (z2) {
                iSlidingPanelButtonViewModel2.applyClicked();
            }
        } else if (i == 3) {
            ISlidingPanelButtonViewModel iSlidingPanelButtonViewModel3 = this.mButtonPanelViewModel;
            if (iSlidingPanelButtonViewModel3 != null) {
                z2 = true;
            }
            if (z2) {
                iSlidingPanelButtonViewModel3.applyClicked();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:110:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01f1  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0202  */
    /* JADX WARNING: Removed duplicated region for block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00cf  */
    @Override // androidx.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
        // Method dump skipped, instructions count: 527
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.SlideupPanelButtonSravniBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.D != 0) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.D = 32;
        }
        requestRebind();
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Integer;>;I)Z */
    public final boolean j(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.D |= 1;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Boolean;>;I)Z */
    public final boolean l(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.D |= 4;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Lru/sravni/android/bankproduct/utils/components/slidinglayout/SlidingUpPanelSetupInfo;>;I)Z */
    public final boolean m(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.D |= 2;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Boolean;>;I)Z */
    public final boolean n(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.D |= 8;
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
        } else if (i != 3) {
            return false;
        } else {
            LiveData liveData4 = (LiveData) obj;
            return n(i2);
        }
    }

    @Override // ru.sravni.android.bankproduct.databinding.SlideupPanelButtonSravniBinding
    public void setButtonPanelViewModel(@Nullable ISlidingPanelButtonViewModel iSlidingPanelButtonViewModel) {
        this.mButtonPanelViewModel = iSlidingPanelButtonViewModel;
        synchronized (this) {
            this.D |= 16;
        }
        notifyPropertyChanged(BR.buttonPanelViewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.buttonPanelViewModel != i) {
            return false;
        }
        setButtonPanelViewModel((ISlidingPanelButtonViewModel) obj);
        return true;
    }
}
