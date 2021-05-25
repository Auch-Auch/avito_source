package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import com.google.android.material.slider.Slider;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.R;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSliderViewModel;
public class FilterSliderLayoutSravniBindingImpl extends FilterSliderLayoutSravniBinding {
    @Nullable
    public static final SparseIntArray B;
    public long A = -1;
    @NonNull
    public final LinearLayout y;
    @NonNull
    public final Slider z;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        B = sparseIntArray;
        sparseIntArray.put(R.id.tilAmount, 6);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FilterSliderLayoutSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r13, @androidx.annotation.NonNull android.view.View r14) {
        /*
            r12 = this;
            android.util.SparseIntArray r0 = ru.sravni.android.bankproduct.databinding.FilterSliderLayoutSravniBindingImpl.B
            r1 = 7
            r2 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r13, r14, r1, r2, r0)
            r1 = 2
            r1 = r0[r1]
            r7 = r1
            com.google.android.material.textfield.TextInputEditText r7 = (com.google.android.material.textfield.TextInputEditText) r7
            r1 = 6
            r1 = r0[r1]
            r8 = r1
            com.google.android.material.textfield.TextInputLayout r8 = (com.google.android.material.textfield.TextInputLayout) r8
            r1 = 1
            r1 = r0[r1]
            r9 = r1
            android.widget.TextView r9 = (android.widget.TextView) r9
            r1 = 5
            r1 = r0[r1]
            r10 = r1
            android.widget.TextView r10 = (android.widget.TextView) r10
            r1 = 4
            r1 = r0[r1]
            r11 = r1
            android.widget.TextView r11 = (android.widget.TextView) r11
            r6 = 6
            r3 = r12
            r4 = r13
            r5 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            r3 = -1
            r12.A = r3
            r13 = 0
            r13 = r0[r13]
            android.widget.LinearLayout r13 = (android.widget.LinearLayout) r13
            r12.y = r13
            r13.setTag(r2)
            r13 = 3
            r13 = r0[r13]
            com.google.android.material.slider.Slider r13 = (com.google.android.material.slider.Slider) r13
            r12.z = r13
            r13.setTag(r2)
            com.google.android.material.textfield.TextInputEditText r13 = r12.tietAmount
            r13.setTag(r2)
            android.widget.TextView r13 = r12.tvAmountTitle
            r13.setTag(r2)
            android.widget.TextView r13 = r12.tvMaxAmountTitle
            r13.setTag(r2)
            android.widget.TextView r13 = r12.tvMinAmountTitle
            r13.setTag(r2)
            r12.setRootTag(r14)
            r12.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.FilterSliderLayoutSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00d7  */
    @Override // androidx.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
        // Method dump skipped, instructions count: 318
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.FilterSliderLayoutSravniBindingImpl.executeBindings():void");
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
            this.A = 128;
        }
        requestRebind();
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
    public final boolean j(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.A |= 8;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
    public final boolean l(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.A |= 16;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Integer;>;I)Z */
    public final boolean m(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.A |= 2;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/Integer;>;I)Z */
    public final boolean n(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.A |= 32;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
    public final boolean o(int i) {
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
        if (i == 0) {
            LiveData liveData = (LiveData) obj;
            return o(i2);
        } else if (i == 1) {
            LiveData liveData2 = (LiveData) obj;
            return m(i2);
        } else if (i == 2) {
            LiveData liveData3 = (LiveData) obj;
            return p(i2);
        } else if (i == 3) {
            LiveData liveData4 = (LiveData) obj;
            return j(i2);
        } else if (i == 4) {
            LiveData liveData5 = (LiveData) obj;
            return l(i2);
        } else if (i != 5) {
            return false;
        } else {
            LiveData liveData6 = (LiveData) obj;
            return n(i2);
        }
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
    public final boolean p(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.A |= 4;
        }
        return true;
    }

    @Override // ru.sravni.android.bankproduct.databinding.FilterSliderLayoutSravniBinding
    public void setSliderViewModel(@Nullable IFilterSliderViewModel iFilterSliderViewModel) {
        this.mSliderViewModel = iFilterSliderViewModel;
        synchronized (this) {
            this.A |= 64;
        }
        notifyPropertyChanged(BR.sliderViewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.sliderViewModel != i) {
            return false;
        }
        setSliderViewModel((IFilterSliderViewModel) obj);
        return true;
    }
}
