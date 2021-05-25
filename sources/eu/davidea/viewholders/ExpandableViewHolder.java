package eu.davidea.viewholders;

import android.view.View;
import androidx.annotation.CallSuper;
import eu.davidea.flexibleadapter.FlexibleAdapter;
public abstract class ExpandableViewHolder extends FlexibleViewHolder {
    public ExpandableViewHolder(View view, FlexibleAdapter flexibleAdapter) {
        super(view, flexibleAdapter);
    }

    @CallSuper
    public void collapseView(int i) {
        this.mAdapter.collapse(i, shouldNotifyParentOnClick());
        if (this.itemView.getX() < 0.0f || this.itemView.getY() < 0.0f) {
            this.mAdapter.getRecyclerView().scrollToPosition(i);
        }
    }

    @CallSuper
    public void expandView(int i) {
        this.mAdapter.expand(i, shouldNotifyParentOnClick());
    }

    public boolean isViewCollapsibleOnLongClick() {
        return true;
    }

    public boolean isViewExpandableOnClick() {
        return true;
    }

    @Override // eu.davidea.viewholders.FlexibleViewHolder, eu.davidea.flexibleadapter.helpers.ItemTouchHelperCallback.ViewHolderCallback
    @CallSuper
    public void onActionStateChanged(int i, int i2) {
        if (this.mAdapter.isExpanded(getFlexibleAdapterPosition())) {
            collapseView(i);
        }
        super.onActionStateChanged(i, i2);
    }

    @Override // eu.davidea.viewholders.FlexibleViewHolder, android.view.View.OnClickListener
    @CallSuper
    public void onClick(View view) {
        if (this.mAdapter.isEnabled(getFlexibleAdapterPosition()) && isViewExpandableOnClick()) {
            toggleExpansion();
        }
        super.onClick(view);
    }

    @Override // eu.davidea.viewholders.FlexibleViewHolder, android.view.View.OnLongClickListener
    @CallSuper
    public boolean onLongClick(View view) {
        int flexibleAdapterPosition = getFlexibleAdapterPosition();
        if (this.mAdapter.isEnabled(flexibleAdapterPosition) && isViewCollapsibleOnLongClick()) {
            collapseView(flexibleAdapterPosition);
        }
        return super.onLongClick(view);
    }

    public boolean shouldNotifyParentOnClick() {
        return false;
    }

    @CallSuper
    public void toggleExpansion() {
        int flexibleAdapterPosition = getFlexibleAdapterPosition();
        if (this.mAdapter.isExpanded(flexibleAdapterPosition)) {
            collapseView(flexibleAdapterPosition);
        } else if (!this.mAdapter.isSelected(flexibleAdapterPosition)) {
            expandView(flexibleAdapterPosition);
        }
    }

    public ExpandableViewHolder(View view, FlexibleAdapter flexibleAdapter, boolean z) {
        super(view, flexibleAdapter, z);
    }
}
