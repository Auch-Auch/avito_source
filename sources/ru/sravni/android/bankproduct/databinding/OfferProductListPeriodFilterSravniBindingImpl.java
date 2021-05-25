package ru.sravni.android.bankproduct.databinding;

import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import com.shawnlin.numberpicker.NumberPicker;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSnapPointViewModel;
public class OfferProductListPeriodFilterSravniBindingImpl extends OfferProductListPeriodFilterSravniBinding {
    public long A = -1;
    @NonNull
    public final LinearLayout y;
    @NonNull
    public final NumberPicker z;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public OfferProductListPeriodFilterSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r7, @androidx.annotation.NonNull android.view.View r8) {
        /*
            r6 = this;
            r0 = 3
            r1 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r7, r8, r0, r1, r1)
            r2 = 1
            r2 = r0[r2]
            android.widget.TextView r2 = (android.widget.TextView) r2
            r3 = 2
            r6.<init>(r7, r8, r3, r2)
            r4 = -1
            r6.A = r4
            r7 = 0
            r7 = r0[r7]
            android.widget.LinearLayout r7 = (android.widget.LinearLayout) r7
            r6.y = r7
            r7.setTag(r1)
            r7 = r0[r3]
            com.shawnlin.numberpicker.NumberPicker r7 = (com.shawnlin.numberpicker.NumberPicker) r7
            r6.z = r7
            r7.setTag(r1)
            android.widget.TextView r7 = r6.tvDriversTitle
            r7.setTag(r1)
            r6.setRootTag(r8)
            r6.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferProductListPeriodFilterSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    @Override // androidx.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r14 = this;
            monitor-enter(r14)
            long r0 = r14.A     // Catch:{ all -> 0x0070 }
            r2 = 0
            r14.A = r2     // Catch:{ all -> 0x0070 }
            monitor-exit(r14)     // Catch:{ all -> 0x0070 }
            ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterSnapPointViewModel r4 = r14.mSnapPointViewModel
            r5 = 15
            long r5 = r5 & r0
            r7 = 13
            r9 = 14
            r11 = 0
            int r12 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x004e
            long r5 = r0 & r7
            int r12 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x0031
            if (r4 == 0) goto L_0x0023
            androidx.lifecycle.LiveData r5 = r4.getTitle()
            goto L_0x0024
        L_0x0023:
            r5 = r11
        L_0x0024:
            r6 = 0
            r14.updateLiveDataRegistration(r6, r5)
            if (r5 == 0) goto L_0x0031
            java.lang.Object r5 = r5.getValue()
            java.lang.String r5 = (java.lang.String) r5
            goto L_0x0032
        L_0x0031:
            r5 = r11
        L_0x0032:
            long r12 = r0 & r9
            int r6 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x004f
            if (r4 == 0) goto L_0x003f
            androidx.lifecycle.LiveData r6 = r4.getInitPeriodList()
            goto L_0x0040
        L_0x003f:
            r6 = r11
        L_0x0040:
            r12 = 1
            r14.updateLiveDataRegistration(r12, r6)
            if (r6 == 0) goto L_0x004f
            java.lang.Object r6 = r6.getValue()
            r11 = r6
            ru.sravni.android.bankproduct.utils.adapter.InitNumberPicker r11 = (ru.sravni.android.bankproduct.utils.adapter.InitNumberPicker) r11
            goto L_0x004f
        L_0x004e:
            r5 = r11
        L_0x004f:
            long r9 = r9 & r0
            int r6 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0059
            com.shawnlin.numberpicker.NumberPicker r6 = r14.z
            ru.sravni.android.bankproduct.utils.adapter.BindingNumberPickerKt.bindListToNumberPicker(r6, r11)
        L_0x0059:
            r9 = 12
            long r9 = r9 & r0
            int r6 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x0065
            com.shawnlin.numberpicker.NumberPicker r6 = r14.z
            ru.sravni.android.bankproduct.utils.adapter.BindingNumberPickerKt.bindViewModelToNumberPicker(r6, r4)
        L_0x0065:
            long r0 = r0 & r7
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x006f
            android.widget.TextView r0 = r14.tvDriversTitle
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r5)
        L_0x006f:
            return
        L_0x0070:
            r0 = move-exception
            monitor-exit(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.OfferProductListPeriodFilterSravniBindingImpl.executeBindings():void");
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
            this.A = 8;
        }
        requestRebind();
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Lru/sravni/android/bankproduct/utils/adapter/InitNumberPicker;>;I)Z */
    public final boolean j(int i) {
        if (i != BR._all) {
            return false;
        }
        synchronized (this) {
            this.A |= 2;
        }
        return true;
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/lang/String;>;I)Z */
    public final boolean l(int i) {
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
            return l(i2);
        } else if (i != 1) {
            return false;
        } else {
            LiveData liveData2 = (LiveData) obj;
            return j(i2);
        }
    }

    @Override // ru.sravni.android.bankproduct.databinding.OfferProductListPeriodFilterSravniBinding
    public void setSnapPointViewModel(@Nullable IFilterSnapPointViewModel iFilterSnapPointViewModel) {
        this.mSnapPointViewModel = iFilterSnapPointViewModel;
        synchronized (this) {
            this.A |= 4;
        }
        notifyPropertyChanged(BR.snapPointViewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.snapPointViewModel != i) {
            return false;
        }
        setSnapPointViewModel((IFilterSnapPointViewModel) obj);
        return true;
    }
}
