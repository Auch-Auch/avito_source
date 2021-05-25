package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.adapters.TextViewBindingAdapter;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.presentation.offer.osago.order.viewmodel.ITapQuote;
public class OfferOsagoOrderQuoteSravniBindingImpl extends OfferOsagoOrderQuoteSravniBinding implements OnClickListener.Listener {
    @Nullable
    public static final SparseIntArray C;
    @Nullable
    public final View.OnClickListener A;
    public long B = -1;
    @NonNull
    public final ConstraintLayout y;
    @NonNull
    public final TextView z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        C = sparseIntArray;
        sparseIntArray.put(R.id.pbTimeWait, 2);
        sparseIntArray.put(R.id.tvTimeWait, 3);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OfferOsagoOrderQuoteSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r10, @androidx.annotation.NonNull android.view.View r11) {
        /*
            r9 = this;
            android.util.SparseIntArray r0 = ru.sravni.android.bankproduct.databinding.OfferOsagoOrderQuoteSravniBindingImpl.C
            r1 = 4
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r10, r11, r1, r2, r0)
            r1 = 2
            r1 = r0[r1]
            r7 = r1
            android.widget.ProgressBar r7 = (android.widget.ProgressBar) r7
            r1 = 3
            r1 = r0[r1]
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            r6 = 0
            r3 = r9
            r4 = r10
            r5 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            r3 = -1
            r9.B = r3
            r10 = 0
            r10 = r0[r10]
            androidx.constraintlayout.widget.ConstraintLayout r10 = (androidx.constraintlayout.widget.ConstraintLayout) r10
            r9.y = r10
            r10.setTag(r2)
            r10 = 1
            r0 = r0[r10]
            android.widget.TextView r0 = (android.widget.TextView) r0
            r9.z = r0
            r0.setTag(r2)
            r9.setRootTag(r11)
            ru.sravni.android.bankproduct.generated.callback.OnClickListener r11 = new ru.sravni.android.bankproduct.generated.callback.OnClickListener
            r11.<init>(r9, r10)
            r9.A = r11
            r9.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferOsagoOrderQuoteSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        ITapQuote iTapQuote = this.mTapQuote;
        if (iTapQuote != null) {
            iTapQuote.nextQuote();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.B;
            this.B = 0;
        }
        String str = this.mQuote;
        int i = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        if ((j & 4) != 0) {
            this.z.setOnClickListener(this.A);
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.z, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.B != 0) {
                return true;
            }
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.B = 4;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferOsagoOrderQuoteSravniBinding
    public void setQuote(@Nullable String str) {
        this.mQuote = str;
        synchronized (this) {
            this.B |= 1;
        }
        notifyPropertyChanged(BR.quote);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferOsagoOrderQuoteSravniBinding
    public void setTapQuote(@Nullable ITapQuote iTapQuote) {
        this.mTapQuote = iTapQuote;
        synchronized (this) {
            this.B |= 2;
        }
        notifyPropertyChanged(BR.tapQuote);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.quote == i) {
            setQuote((String) obj);
        } else if (BR.tapQuote != i) {
            return false;
        } else {
            setTapQuote((ITapQuote) obj);
        }
        return true;
    }
}
