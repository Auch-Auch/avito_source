package eu.davidea.flexibleadapter.items;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import java.util.List;
public abstract class AbstractFlexibleItem<VH extends RecyclerView.ViewHolder> implements IFlexible<VH> {
    public boolean mDraggable = false;
    public boolean mEnabled = true;
    public boolean mHidden = false;
    public boolean mSelectable = true;
    public boolean mSwipeable = false;

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public abstract void bindViewHolder(FlexibleAdapter flexibleAdapter, VH vh, int i, List<Object> list);

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public abstract VH createViewHolder(View view, FlexibleAdapter flexibleAdapter);

    public abstract boolean equals(Object obj);

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public String getBubbleText(int i) {
        return String.valueOf(i + 1);
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public int getItemViewType() {
        return getLayoutRes();
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public abstract int getLayoutRes();

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public int getSpanSize(int i, int i2) {
        return 1;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public boolean isDraggable() {
        return this.mDraggable;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public boolean isEnabled() {
        return this.mEnabled;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public boolean isHidden() {
        return this.mHidden;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public boolean isSelectable() {
        return this.mSelectable;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public boolean isSwipeable() {
        return this.mSwipeable;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public void onViewAttached(FlexibleAdapter flexibleAdapter, VH vh, int i) {
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public void onViewDetached(FlexibleAdapter flexibleAdapter, VH vh, int i) {
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public void setDraggable(boolean z) {
        this.mDraggable = z;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public void setEnabled(boolean z) {
        this.mEnabled = z;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public void setHidden(boolean z) {
        this.mHidden = z;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public void setSelectable(boolean z) {
        this.mSelectable = z;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public void setSwipeable(boolean z) {
        this.mSwipeable = z;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public boolean shouldNotifyChange(IFlexible iFlexible) {
        return true;
    }

    @Override // eu.davidea.flexibleadapter.items.IFlexible
    public void unbindViewHolder(FlexibleAdapter flexibleAdapter, VH vh, int i) {
    }
}
