package ru.sravni.android.bankproduct.databinding;

import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.presentation.offer.IOfferRetryErrorViewModel;
import ru.sravni.android.bankproduct.utils.adapter.BindingProgressBarKt;
public class OfferOsagoOrderWaitErrorSravniBindingImpl extends OfferOsagoOrderWaitErrorSravniBinding implements OnClickListener.Listener {
    public long A = -1;
    @NonNull
    public final ConstraintLayout y;
    @Nullable
    public final View.OnClickListener z;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OfferOsagoOrderWaitErrorSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r13, @androidx.annotation.NonNull android.view.View r14) {
        /*
            r12 = this;
            r0 = 6
            r1 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r13, r14, r0, r1, r1)
            r2 = 5
            r2 = r0[r2]
            r7 = r2
            com.google.android.material.button.MaterialButton r7 = (com.google.android.material.button.MaterialButton) r7
            r2 = 2
            r2 = r0[r2]
            r8 = r2
            android.widget.ImageView r8 = (android.widget.ImageView) r8
            r2 = 1
            r3 = r0[r2]
            r9 = r3
            android.widget.ProgressBar r9 = (android.widget.ProgressBar) r9
            r3 = 4
            r3 = r0[r3]
            r10 = r3
            android.widget.TextView r10 = (android.widget.TextView) r10
            r3 = 3
            r3 = r0[r3]
            r11 = r3
            android.widget.TextView r11 = (android.widget.TextView) r11
            r6 = 1
            r3 = r12
            r4 = r13
            r5 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            r3 = -1
            r12.A = r3
            com.google.android.material.button.MaterialButton r13 = r12.btnRepeat
            r13.setTag(r1)
            android.widget.ImageView r13 = r12.icErrorIcon
            r13.setTag(r1)
            r13 = 0
            r13 = r0[r13]
            androidx.constraintlayout.widget.ConstraintLayout r13 = (androidx.constraintlayout.widget.ConstraintLayout) r13
            r12.y = r13
            r13.setTag(r1)
            android.widget.ProgressBar r13 = r12.pbWait
            r13.setTag(r1)
            android.widget.TextView r13 = r12.tvDescription
            r13.setTag(r1)
            android.widget.TextView r13 = r12.tvTitle
            r13.setTag(r1)
            r12.setRootTag(r14)
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r13 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r13.<init>(r12, r2)
            r12.z = r13
            r12.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferOsagoOrderWaitErrorSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        IOfferRetryErrorViewModel iOfferRetryErrorViewModel = this.mOfferRetryErrorViewModel;
        if (iOfferRetryErrorViewModel != null) {
            iOfferRetryErrorViewModel.repeatClick();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        int i;
        int i2;
        long j2;
        long j3;
        synchronized (this) {
            j = this.A;
            this.A = 0;
        }
        IOfferRetryErrorViewModel iOfferRetryErrorViewModel = this.mOfferRetryErrorViewModel;
        int i3 = 0;
        int i4 = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        if (i4 != 0) {
            Boolean bool = null;
            MutableLiveData<Boolean> errorOccurred = iOfferRetryErrorViewModel != null ? iOfferRetryErrorViewModel.getErrorOccurred() : null;
            updateLiveDataRegistration(0, errorOccurred);
            if (errorOccurred != null) {
                bool = errorOccurred.getValue();
            }
            boolean safeUnbox = ViewDataBinding.safeUnbox(bool);
            boolean z2 = !safeUnbox;
            boolean z3 = true;
            if (!safeUnbox) {
                z3 = false;
            }
            if (i4 != 0) {
                j |= z2 ? 64 : 32;
            }
            if ((j & 7) != 0) {
                if (z3) {
                    j3 = j | 16;
                    j2 = 256;
                } else {
                    j3 = j | 8;
                    j2 = 128;
                }
                j = j3 | j2;
            }
            i2 = z2 ? 0 : 4;
            i = z3 ? 0 : 8;
            if (!z3) {
                i3 = 4;
            }
        } else {
            i2 = 0;
            i = 0;
        }
        if ((4 & j) != 0) {
            this.btnRepeat.setOnClickListener(this.z);
            ProgressBar progressBar = this.pbWait;
            BindingProgressBarKt.bindSetIndeterminateResTint(progressBar, ViewDataBinding.getColorFromResource(progressBar, R.color.primary));
        }
        if ((j & 7) != 0) {
            this.btnRepeat.setVisibility(i3);
            this.icErrorIcon.setVisibility(i3);
            this.pbWait.setVisibility(i2);
            this.tvDescription.setVisibility(i);
            this.tvTitle.setVisibility(i);
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

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/MutableLiveData<Ljava/lang/Boolean;>;I)Z */
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
        MutableLiveData mutableLiveData = (MutableLiveData) obj;
        return j(i2);
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferOsagoOrderWaitErrorSravniBinding
    public void setOfferRetryErrorViewModel(@Nullable IOfferRetryErrorViewModel iOfferRetryErrorViewModel) {
        this.mOfferRetryErrorViewModel = iOfferRetryErrorViewModel;
        synchronized (this) {
            this.A |= 2;
        }
        notifyPropertyChanged(BR.offerRetryErrorViewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.offerRetryErrorViewModel != i) {
            return false;
        }
        setOfferRetryErrorViewModel((IOfferRetryErrorViewModel) obj);
        return true;
    }
}
