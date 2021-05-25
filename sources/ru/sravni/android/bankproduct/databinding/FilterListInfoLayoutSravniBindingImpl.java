package ru.sravni.android.bankproduct.databinding;

import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterListInfoViewModel;
public class FilterListInfoLayoutSravniBindingImpl extends FilterListInfoLayoutSravniBinding {
    @NonNull
    public final LinearLayout y;
    public long z = -1;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public FilterListInfoLayoutSravniBindingImpl(@androidx.annotation.Nullable androidx.databinding.DataBindingComponent r10, @androidx.annotation.NonNull android.view.View r11) {
        /*
            r9 = this;
            r0 = 3
            r1 = 0
            java.lang.Object[] r0 = androidx.databinding.ViewDataBinding.mapBindings(r10, r11, r0, r1, r1)
            r2 = 2
            r2 = r0[r2]
            r7 = r2
            androidx.recyclerview.widget.RecyclerView r7 = (androidx.recyclerview.widget.RecyclerView) r7
            r2 = 1
            r2 = r0[r2]
            r8 = r2
            android.widget.TextView r8 = (android.widget.TextView) r8
            r6 = 2
            r3 = r9
            r4 = r10
            r5 = r11
            r3.<init>(r4, r5, r6, r7, r8)
            r2 = -1
            r9.z = r2
            r10 = 0
            r10 = r0[r10]
            android.widget.LinearLayout r10 = (android.widget.LinearLayout) r10
            r9.y = r10
            r10.setTag(r1)
            androidx.recyclerview.widget.RecyclerView r10 = r9.rvDrivers
            r10.setTag(r1)
            android.widget.TextView r10 = r9.tvBarrelDayTitle
            r10.setTag(r1)
            r9.setRootTag(r11)
            r9.invalidateAll()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.FilterListInfoLayoutSravniBindingImpl.<init>(androidx.databinding.DataBindingComponent, android.view.View):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0038  */
    @Override // androidx.databinding.ViewDataBinding
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeBindings() {
        /*
            r14 = this;
            monitor-enter(r14)
            long r0 = r14.z     // Catch:{ all -> 0x0067 }
            r2 = 0
            r14.z = r2     // Catch:{ all -> 0x0067 }
            monitor-exit(r14)     // Catch:{ all -> 0x0067 }
            ru.sravni.android.bankproduct.utils.filter.viewmodel.IFilterListInfoViewModel r4 = r14.mListInfoViewModel
            r5 = 15
            long r5 = r5 & r0
            r7 = 14
            r9 = 13
            r11 = 0
            int r12 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x0050
            long r5 = r0 & r9
            int r12 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r12 == 0) goto L_0x0031
            if (r4 == 0) goto L_0x0023
            androidx.lifecycle.LiveData r5 = r4.getListInfo()
            goto L_0x0024
        L_0x0023:
            r5 = r11
        L_0x0024:
            r6 = 0
            r14.updateLiveDataRegistration(r6, r5)
            if (r5 == 0) goto L_0x0031
            java.lang.Object r5 = r5.getValue()
            java.util.List r5 = (java.util.List) r5
            goto L_0x0032
        L_0x0031:
            r5 = r11
        L_0x0032:
            long r12 = r0 & r7
            int r6 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r6 == 0) goto L_0x004d
            if (r4 == 0) goto L_0x003f
            androidx.lifecycle.LiveData r4 = r4.getTitle()
            goto L_0x0040
        L_0x003f:
            r4 = r11
        L_0x0040:
            r6 = 1
            r14.updateLiveDataRegistration(r6, r4)
            if (r4 == 0) goto L_0x004d
            java.lang.Object r4 = r4.getValue()
            r11 = r4
            java.lang.String r11 = (java.lang.String) r11
        L_0x004d:
            r4 = r11
            r11 = r5
            goto L_0x0051
        L_0x0050:
            r4 = r11
        L_0x0051:
            long r5 = r0 & r9
            int r9 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r9 == 0) goto L_0x005c
            androidx.recyclerview.widget.RecyclerView r5 = r14.rvDrivers
            ru.sravni.android.bankproduct.utils.filter.adapter.BindingFilterAdapterKt.bindListInfoToRecycler(r5, r11)
        L_0x005c:
            long r0 = r0 & r7
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L_0x0066
            android.widget.TextView r0 = r14.tvBarrelDayTitle
            androidx.databinding.adapters.TextViewBindingAdapter.setText(r0, r4)
        L_0x0066:
            return
        L_0x0067:
            r0 = move-exception
            monitor-exit(r14)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ru.sravni.android.bankproduct.databinding.FilterListInfoLayoutSravniBindingImpl.executeBindings():void");
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
            this.z = 8;
        }
        requestRebind();
    }

    /* JADX WARN: Incorrect args count in method signature: (Landroidx/lifecycle/LiveData<Ljava/util/List<Lru/sravni/android/bankproduct/utils/filter/entity/FilterInfo;>;>;I)Z */
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
            this.z |= 2;
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

    @Override // ru.sravni.android.bankproduct.databinding.FilterListInfoLayoutSravniBinding
    public void setListInfoViewModel(@Nullable IFilterListInfoViewModel iFilterListInfoViewModel) {
        this.mListInfoViewModel = iFilterListInfoViewModel;
        synchronized (this) {
            this.z |= 4;
        }
        notifyPropertyChanged(BR.listInfoViewModel);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.listInfoViewModel != i) {
            return false;
        }
        setListInfoViewModel((IFilterListInfoViewModel) obj);
        return true;
    }
}
