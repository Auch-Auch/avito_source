package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.IChatViewModel;
public class CreditOfferItemSravniBindingImpl extends CreditOfferItemSravniBinding {
    @Nullable
    public static final SparseIntArray A;
    @NonNull
    public final CardView y;
    public long z = -1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        A = sparseIntArray;
        sparseIntArray.put(R.id.tvNameCredit, 1);
        sparseIntArray.put(R.id.tvNameBank, 2);
        sparseIntArray.put(R.id.tvInterestRate, 3);
        sparseIntArray.put(R.id.tvRate, 4);
        sparseIntArray.put(R.id.tvPayment, 5);
        sparseIntArray.put(R.id.tvPaymentRub, 6);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public CreditOfferItemSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r14, @androidx.annotation.NonNull android.view.View r15) {
        /*
            r13 = this;
            android.util.SparseIntArray r0 = ru.sravni.android.bankproduct.databinding.CreditOfferItemSravniBindingImpl.A
            r1 = 7
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r14, r15, r1, r2, r0)
            r1 = 3
            r1 = r0[r1]
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            r1 = 2
            r1 = r0[r1]
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            r1 = 1
            r1 = r0[r1]
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            r1 = 5
            r1 = r0[r1]
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            r1 = 6
            r1 = r0[r1]
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            r1 = 4
            r1 = r0[r1]
            r12 = r1
            android.widget.TextView r12 = (android.widget.TextView) r12
            r6 = 0
            r3 = r13
            r4 = r14
            r5 = r15
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r3 = -1
            r13.z = r3
            r14 = 0
            r14 = r0[r14]
            androidx.cardview.widget.CardView r14 = (androidx.cardview.widget.CardView) r14
            r13.y = r14
            r14.setTag(r2)
            r13.setRootTag(r15)
            r13.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.CreditOfferItemSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        synchronized (this) {
            this.z = 0;
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
            this.z = 2;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // ru.sravni.android.bankproduct.databinding.CreditOfferItemSravniBinding
    public void setChatViewModel(@Nullable IChatViewModel iChatViewModel) {
        this.mChatViewModel = iChatViewModel;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.chatViewModel != i) {
            return false;
        }
        setChatViewModel((IChatViewModel) obj);
        return true;
    }
}
