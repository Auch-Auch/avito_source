package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterInfo;
public class FilterListInfoItemSravniBindingImpl extends FilterListInfoItemSravniBinding {
    @NonNull
    public final TextView A;
    public long B = -1;
    @NonNull
    public final LinearLayout y;
    @NonNull
    public final TextView z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FilterListInfoItemSravniBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        super(dataBindingComponent, view, 0);
        Object[] mapBindings = ViewDataBinding.mapBindings(dataBindingComponent, view, 3, (ViewDataBinding.IncludedLayouts) null, (SparseIntArray) null);
        LinearLayout linearLayout = (LinearLayout) mapBindings[0];
        this.y = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) mapBindings[1];
        this.z = textView;
        textView.setTag(null);
        TextView textView2 = (TextView) mapBindings[2];
        this.A = textView2;
        textView2.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.B;
            this.B = 0;
        }
        FilterInfo filterInfo = this.mFilterInfo;
        String str2 = null;
        int i = ((j & 3) > 0 ? 1 : ((j & 3) == 0 ? 0 : -1));
        if (i == 0 || filterInfo == null) {
            str = null;
        } else {
            String value = filterInfo.getValue();
            str2 = filterInfo.getTitle();
            str = value;
        }
        if (i != 0) {
            TextViewBindingAdapter.setText(this.z, str2);
            TextViewBindingAdapter.setText(this.A, str);
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
            this.B = 2;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // ru.sravni.android.bankproduct.databinding.FilterListInfoItemSravniBinding
    public void setFilterInfo(@Nullable FilterInfo filterInfo) {
        this.mFilterInfo = filterInfo;
        synchronized (this) {
            this.B |= 1;
        }
        notifyPropertyChanged(BR.filterInfo);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.filterInfo != i) {
            return false;
        }
        setFilterInfo((FilterInfo) obj);
        return true;
    }
}
