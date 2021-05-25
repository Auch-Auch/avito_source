package eu.davidea.viewholders;

import android.animation.Animator;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.helpers.ItemTouchHelperCallback;
import eu.davidea.flexibleadapter.items.IFlexible;
import eu.davidea.flexibleadapter.utils.LayoutUtils;
import eu.davidea.flexibleadapter.utils.Log;
import java.util.List;
import q6.a.b.a;
public abstract class FlexibleViewHolder extends a implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener, ItemTouchHelperCallback.ViewHolderCallback {
    public int mActionState;
    public final FlexibleAdapter mAdapter;
    public boolean u;
    public boolean v;

    public FlexibleViewHolder(View view, FlexibleAdapter flexibleAdapter) {
        this(view, flexibleAdapter, false);
    }

    public float getActivationElevation() {
        return 0.0f;
    }

    @Override // eu.davidea.flexibleadapter.helpers.ItemTouchHelperCallback.ViewHolderCallback
    public View getFrontView() {
        return this.itemView;
    }

    @Override // eu.davidea.flexibleadapter.helpers.ItemTouchHelperCallback.ViewHolderCallback
    public View getRearLeftView() {
        return null;
    }

    @Override // eu.davidea.flexibleadapter.helpers.ItemTouchHelperCallback.ViewHolderCallback
    public View getRearRightView() {
        return null;
    }

    @Override // eu.davidea.flexibleadapter.helpers.ItemTouchHelperCallback.ViewHolderCallback
    public final boolean isDraggable() {
        IFlexible item = this.mAdapter.getItem(getFlexibleAdapterPosition());
        return item != null && item.isDraggable();
    }

    @Override // eu.davidea.flexibleadapter.helpers.ItemTouchHelperCallback.ViewHolderCallback
    public final boolean isSwipeable() {
        IFlexible item = this.mAdapter.getItem(getFlexibleAdapterPosition());
        return item != null && item.isSwipeable();
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0029: APUT  (r0v3 java.lang.Object[]), (2 ??[int, float, short, byte, char]), (r1v4 java.lang.String) */
    @Override // eu.davidea.flexibleadapter.helpers.ItemTouchHelperCallback.ViewHolderCallback
    @CallSuper
    public void onActionStateChanged(int i, int i2) {
        this.mActionState = i2;
        this.v = this.mAdapter.isSelected(i);
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = LayoutUtils.getModeName(this.mAdapter.getMode());
        objArr[2] = i2 == 1 ? "Swipe(1)" : "Drag(2)";
        Log.v("onActionStateChanged position=%s mode=%s actionState=%s", objArr);
        if (i2 == 2) {
            if (!this.v) {
                if ((this.u || this.mAdapter.getMode() == 2) && (shouldAddSelectionInActionMode() || this.mAdapter.getMode() != 2)) {
                    FlexibleAdapter flexibleAdapter = this.mAdapter;
                    if (flexibleAdapter.mItemLongClickListener != null && flexibleAdapter.isSelectable(i)) {
                        Log.v("onLongClick on position %s mode=%s", Integer.valueOf(i), Integer.valueOf(this.mAdapter.getMode()));
                        this.mAdapter.mItemLongClickListener.onItemLongClick(i);
                        this.v = true;
                    }
                }
                if (!this.v) {
                    this.mAdapter.toggleSelection(i);
                }
            }
            if (!getContentView().isActivated()) {
                toggleActivation();
            }
        } else if (i2 == 1 && shouldActivateViewWhileSwiping() && !this.v) {
            this.mAdapter.toggleSelection(i);
            toggleActivation();
        }
    }

    @Override // android.view.View.OnClickListener
    @CallSuper
    public void onClick(View view) {
        int flexibleAdapterPosition = getFlexibleAdapterPosition();
        if (this.mAdapter.isEnabled(flexibleAdapterPosition) && this.mAdapter.mItemClickListener != null && this.mActionState == 0) {
            Log.v("onClick on position %s mode=%s", Integer.valueOf(flexibleAdapterPosition), LayoutUtils.getModeName(this.mAdapter.getMode()));
            if (this.mAdapter.mItemClickListener.onItemClick(flexibleAdapterPosition)) {
                toggleActivation();
            }
        }
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0021: APUT  (r0v1 java.lang.Object[]), (2 ??[int, float, short, byte, char]), (r1v5 java.lang.String) */
    @Override // eu.davidea.flexibleadapter.helpers.ItemTouchHelperCallback.ViewHolderCallback
    @CallSuper
    public void onItemReleased(int i) {
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = LayoutUtils.getModeName(this.mAdapter.getMode());
        objArr[2] = this.mActionState == 1 ? "Swipe(1)" : "Drag(2)";
        Log.v("onItemReleased position=%s mode=%s actionState=%s", objArr);
        if (!this.v) {
            if (shouldAddSelectionInActionMode() && this.mAdapter.getMode() == 2) {
                Log.v("onLongClick for ActionMode on position %s mode=%s", Integer.valueOf(i), Integer.valueOf(this.mAdapter.getMode()));
                FlexibleAdapter.OnItemLongClickListener onItemLongClickListener = this.mAdapter.mItemLongClickListener;
                if (onItemLongClickListener != null) {
                    onItemLongClickListener.onItemLongClick(i);
                }
                if (this.mAdapter.isSelected(i)) {
                    toggleActivation();
                }
            } else if (shouldActivateViewWhileSwiping() && getContentView().isActivated()) {
                this.mAdapter.toggleSelection(i);
                toggleActivation();
            } else if (this.mActionState == 2) {
                this.mAdapter.toggleSelection(i);
                if (getContentView().isActivated()) {
                    toggleActivation();
                }
            }
        }
        this.u = false;
        this.mActionState = 0;
    }

    @Override // android.view.View.OnLongClickListener
    @CallSuper
    public boolean onLongClick(View view) {
        int flexibleAdapterPosition = getFlexibleAdapterPosition();
        if (!this.mAdapter.isEnabled(flexibleAdapterPosition)) {
            return false;
        }
        FlexibleAdapter flexibleAdapter = this.mAdapter;
        if (flexibleAdapter.mItemLongClickListener == null || flexibleAdapter.isLongPressDragEnabled()) {
            this.u = true;
            return false;
        }
        Log.v("onLongClick on position %s mode=%s", Integer.valueOf(flexibleAdapterPosition), LayoutUtils.getModeName(this.mAdapter.getMode()));
        this.mAdapter.mItemLongClickListener.onItemLongClick(flexibleAdapterPosition);
        toggleActivation();
        return true;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int flexibleAdapterPosition = getFlexibleAdapterPosition();
        if (!this.mAdapter.isEnabled(flexibleAdapterPosition) || !isDraggable()) {
            Log.w("Can't start drag: Item is not enabled or draggable!", new Object[0]);
            return false;
        }
        Log.v("onTouch with DragHandleView on position %s mode=%s", Integer.valueOf(flexibleAdapterPosition), LayoutUtils.getModeName(this.mAdapter.getMode()));
        if (motionEvent.getActionMasked() == 0 && this.mAdapter.isHandleDragEnabled()) {
            this.mAdapter.getItemTouchHelper().startDrag(this);
        }
        return false;
    }

    public void scrollAnimators(@NonNull List<Animator> list, int i, boolean z) {
    }

    @CallSuper
    public void setDragHandleView(@NonNull View view) {
        if (view != null) {
            view.setOnTouchListener(this);
        }
    }

    public void setFullSpan(boolean z) {
        if (this.itemView.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) this.itemView.getLayoutParams()).setFullSpan(z);
        }
    }

    public boolean shouldActivateViewWhileSwiping() {
        return false;
    }

    public boolean shouldAddSelectionInActionMode() {
        return false;
    }

    @CallSuper
    public void toggleActivation() {
        int flexibleAdapterPosition = getFlexibleAdapterPosition();
        if (this.mAdapter.isSelectable(flexibleAdapterPosition)) {
            boolean isSelected = this.mAdapter.isSelected(flexibleAdapterPosition);
            if ((getContentView().isActivated() && !isSelected) || (!getContentView().isActivated() && isSelected)) {
                getContentView().setActivated(isSelected);
                if (this.mAdapter.getStickyPosition() == flexibleAdapterPosition) {
                    this.mAdapter.ensureHeaderParent();
                }
                if (getContentView().isActivated() && getActivationElevation() > 0.0f) {
                    ViewCompat.setElevation(this.itemView, getActivationElevation());
                } else if (getActivationElevation() > 0.0f) {
                    ViewCompat.setElevation(this.itemView, 0.0f);
                }
            }
        }
    }

    public FlexibleViewHolder(View view, FlexibleAdapter flexibleAdapter, boolean z) {
        super(view, flexibleAdapter, z);
        this.u = false;
        this.v = false;
        this.mActionState = 0;
        this.mAdapter = flexibleAdapter;
        if (flexibleAdapter.mItemClickListener != null) {
            getContentView().setOnClickListener(this);
        }
        if (flexibleAdapter.mItemLongClickListener != null) {
            getContentView().setOnLongClickListener(this);
        }
    }
}
