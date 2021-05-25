package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.google.android.material.button.MaterialButton;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.generated.callback.OnClickListener;
import ru.sravni.android.bankproduct.utils.adapter.BindingButtonKt;
import ru.sravni.android.bankproduct.utils.filter.adapter.ISelectFilter;
import ru.sravni.android.bankproduct.utils.filter.entity.FilterItem;
public class FilterPanelItemSravniBindingImpl extends FilterPanelItemSravniBinding implements OnClickListener.Listener {
    @Nullable
    public final View.OnClickListener A;
    public long B = -1;
    @NonNull
    public final FrameLayout y;
    @NonNull
    public final MaterialButton z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FilterPanelItemSravniBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        super(dataBindingComponent, view, 0);
        Object[] mapBindings = ViewDataBinding.mapBindings(dataBindingComponent, view, 2, (ViewDataBinding.IncludedLayouts) null, (SparseIntArray) null);
        FrameLayout frameLayout = (FrameLayout) mapBindings[0];
        this.y = frameLayout;
        frameLayout.setTag(null);
        MaterialButton materialButton = (MaterialButton) mapBindings[1];
        this.z = materialButton;
        materialButton.setTag(null);
        setRootTag(view);
        this.A = new OnClickListener(this, 1);
        invalidateAll();
    }

    @Override // ru.sravni.android.bankproduct.generated.callback.OnClickListener.Listener
    public final void _internalCallbackOnClick(int i, View view) {
        ISelectFilter iSelectFilter = this.mFilterSelector;
        FilterItem filterItem = this.mFilterItem;
        if (iSelectFilter != null) {
            iSelectFilter.filterClicked(filterItem);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.B;
            this.B = 0;
        }
        int i = 0;
        String str = null;
        FilterItem filterItem = this.mFilterItem;
        int i2 = ((6 & j) > 0 ? 1 : ((6 & j) == 0 ? 0 : -1));
        if (!(i2 == 0 || filterItem == null)) {
            i = filterItem.getIcon();
            str = filterItem.getTitle();
        }
        if ((j & 4) != 0) {
            this.z.setOnClickListener(this.A);
        }
        if (i2 != 0) {
            TextViewBindingAdapter.setText(this.z, str);
            BindingButtonKt.bindDrawableSource(this.z, Integer.valueOf(i));
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

    @Override // ru.sravni.android.bankproduct.databinding.FilterPanelItemSravniBinding
    public void setFilterItem(@Nullable FilterItem filterItem) {
        this.mFilterItem = filterItem;
        synchronized (this) {
            this.B |= 2;
        }
        notifyPropertyChanged(BR.filterItem);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.FilterPanelItemSravniBinding
    public void setFilterSelector(@Nullable ISelectFilter iSelectFilter) {
        this.mFilterSelector = iSelectFilter;
        synchronized (this) {
            this.B |= 1;
        }
        notifyPropertyChanged(BR.filterSelector);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.filterSelector == i) {
            setFilterSelector((ISelectFilter) obj);
        } else if (BR.filterItem != i) {
            return false;
        } else {
            setFilterItem((FilterItem) obj);
        }
        return true;
    }
}
