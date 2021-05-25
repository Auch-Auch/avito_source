package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterDescriptionViewModel;
public class FilterDescriptionLayoutSravniBindingImpl extends FilterDescriptionLayoutSravniBinding {
    @Nullable
    public static final SparseIntArray A;
    @NonNull
    public final LinearLayout y;
    public long z = -1;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        A = sparseIntArray;
        sparseIntArray.put(R.id.tvDescriptionTitle, 2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FilterDescriptionLayoutSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r10, @androidx.annotation.NonNull android.view.View r11) {
        /*
            r9 = this;
            android.util.SparseIntArray r0 = ru.sravni.android.bankproduct.databinding.FilterDescriptionLayoutSravniBindingImpl.A
            r1 = 3
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r10, r11, r1, r2, r0)
            r1 = 1
            r1 = r0[r1]
            r7 = r1
            android.widget.TextView r7 = (android.widget.TextView) r7
            r1 = 2
            r1 = r0[r1]
            r8 = r1
            android.widget.TextView r8 = (android.widget.TextView) r8
            r6 = 1
            r3 = r9
            r4 = r10
            r5 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            r3 = -1
            r9.z = r3
            r10 = 0
            r10 = r0[r10]
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            r9.y = r10
            r10.setTag(r2)
            android.widget.TextView r10 = r9.tvDescription
            r10.setTag(r2)
            r9.setRootTag(r11)
            r9.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.FilterDescriptionLayoutSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.z;
            this.z = 0;
        }
        IFilterDescriptionViewModel iFilterDescriptionViewModel = this.mDescriptionViewModel;
        String str = null;
        int i = ((j & 7) > 0 ? 1 : ((j & 7) == 0 ? 0 : -1));
        if (i != 0) {
            LiveData<String> descriptionSignal = iFilterDescriptionViewModel != null ? iFilterDescriptionViewModel.getDescriptionSignal() : null;
            updateLiveDataRegistration(0, descriptionSignal);
            if (descriptionSignal != null) {
                str = descriptionSignal.getValue();
            }
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.tvDescription, str);
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
            this.z = 4;
        }
        requestRebind();
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
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

    @Override // ru.sravni.android.bankproduct.databinding.FilterDescriptionLayoutSravniBinding
    public void setDescriptionViewModel(@Nullable IFilterDescriptionViewModel iFilterDescriptionViewModel) {
        this.mDescriptionViewModel = iFilterDescriptionViewModel;
        synchronized (this) {
            this.z |= 2;
        }
        notifyPropertyChanged(BR.descriptionViewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.descriptionViewModel != i) {
            return false;
        }
        setDescriptionViewModel((IFilterDescriptionViewModel) obj);
        return true;
    }
}
