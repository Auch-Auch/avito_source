package ru.sravni.android.bankproduct.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import ru.sravni.android.bankproduct.BR;
import ru.sravni.android.bankproduct.presentation.chat.adapter.answer.BindingSuggestAnswerKt;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.ISetSuggestion;
import ru.sravni.android.bankproduct.presentation.chat.viewmodel.answer.SuggestInfo;
public class SuggestListSravniBindingImpl extends SuggestListSravniBinding {
    public long A = -1;
    @NonNull
    public final FrameLayout y;
    @NonNull
    public final RecyclerView z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuggestListSravniBindingImpl(@Nullable DataBindingComponent dataBindingComponent, @NonNull View view) {
        super(dataBindingComponent, view, 0);
        Object[] mapBindings = ViewDataBinding.mapBindings(dataBindingComponent, view, 2, (ViewDataBinding.IncludedLayouts) null, (SparseIntArray) null);
        FrameLayout frameLayout = (FrameLayout) mapBindings[0];
        this.y = frameLayout;
        frameLayout.setTag(null);
        RecyclerView recyclerView = (RecyclerView) mapBindings[1];
        this.z = recyclerView;
        recyclerView.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void executeBindings() {
        long j;
        synchronized (this) {
            j = this.A;
            this.A = 0;
        }
        ISetSuggestion iSetSuggestion = this.mSuggestInfoSetter;
        int i = 0;
        List<SuggestInfo> list = this.mSuggestList;
        int i2 = ((5 & j) > 0 ? 1 : ((5 & j) == 0 ? 0 : -1));
        int i3 = ((j & 6) > 0 ? 1 : ((j & 6) == 0 ? 0 : -1));
        if (!(i3 == 0 || list == null)) {
            i = list.size();
        }
        if (i3 != 0) {
            BindingSuggestAnswerKt.bindSuggestVisibilityAnimation(this.y, i);
            BindingSuggestAnswerKt.bindSuggestItemsToAutoComplete(this.z, list);
        }
        if (i2 != 0) {
            BindingSuggestAnswerKt.bindSuggestItemsToAutoComplete(this.z, iSetSuggestion);
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

    @Override // androidx.databinding.ViewDataBinding
    public boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // ru.sravni.android.bankproduct.databinding.SuggestListSravniBinding
    public void setSuggestInfoSetter(@Nullable ISetSuggestion iSetSuggestion) {
        this.mSuggestInfoSetter = iSetSuggestion;
        synchronized (this) {
            this.A |= 1;
        }
        notifyPropertyChanged(BR.suggestInfoSetter);
        super.requestRebind();
    }

    @Override // ru.sravni.android.bankproduct.databinding.SuggestListSravniBinding
    public void setSuggestList(@Nullable List<SuggestInfo> list) {
        this.mSuggestList = list;
        synchronized (this) {
            this.A |= 2;
        }
        notifyPropertyChanged(BR.suggestList);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, @Nullable Object obj) {
        if (BR.suggestInfoSetter == i) {
            setSuggestInfoSetter((ISetSuggestion) obj);
        } else if (BR.suggestList != i) {
            return false;
        } else {
            setSuggestList((List) obj);
        }
        return true;
    }
}
