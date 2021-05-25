package eu.davidea.flexibleadapter.helpers;

import android.graphics.Canvas;
import android.view.View;
import androidx.annotation.FloatRange;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
public class ItemTouchHelperCallback extends ItemTouchHelper.Callback {
    public static final float ALPHA_FULL = 1.0f;
    public boolean handleDragEnabled = false;
    public boolean longPressDragEnabled = false;
    public AdapterCallback mAdapterCallback;
    public long mDragAnimationDuration = 400;
    public float mMoveThreshold = 0.5f;
    public long mSwipeAnimationDuration = 300;
    public int mSwipeFlags = -1;
    public float mSwipeThreshold = 0.5f;
    public boolean swipeEnabled = false;

    public interface AdapterCallback {
        void onActionStateChanged(RecyclerView.ViewHolder viewHolder, int i);

        boolean onItemMove(int i, int i2);

        void onItemSwiped(int i, int i2);

        boolean shouldMove(int i, int i2);
    }

    public interface ViewHolderCallback {
        View getFrontView();

        View getRearLeftView();

        View getRearRightView();

        boolean isDraggable();

        boolean isSwipeable();

        void onActionStateChanged(int i, int i2);

        void onItemReleased(int i);
    }

    public ItemTouchHelperCallback(AdapterCallback adapterCallback) {
        this.mAdapterCallback = adapterCallback;
    }

    public static void c(ViewHolderCallback viewHolderCallback, int i) {
        int i2 = 0;
        if (viewHolderCallback.getRearRightView() != null) {
            viewHolderCallback.getRearRightView().setVisibility(i == 4 ? 0 : 8);
        }
        if (viewHolderCallback.getRearLeftView() != null) {
            View rearLeftView = viewHolderCallback.getRearLeftView();
            if (i != 8) {
                i2 = 8;
            }
            rearLeftView.setVisibility(i2);
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        viewHolder.itemView.setAlpha(1.0f);
        if (viewHolder instanceof ViewHolderCallback) {
            ViewHolderCallback viewHolderCallback = (ViewHolderCallback) viewHolder;
            ItemTouchHelper.Callback.getDefaultUIUtil().clearView(viewHolderCallback.getFrontView());
            c(viewHolderCallback, 0);
            viewHolderCallback.onItemReleased(viewHolder.getAdapterPosition());
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public long getAnimationDuration(RecyclerView recyclerView, int i, float f, float f2) {
        return i == 8 ? this.mDragAnimationDuration : this.mSwipeAnimationDuration;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
        return this.mMoveThreshold;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0039, code lost:
        if (r7.isSwipeable() == false) goto L_0x003d;
     */
    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getMovementFlags(androidx.recyclerview.widget.RecyclerView r6, androidx.recyclerview.widget.RecyclerView.ViewHolder r7) {
        /*
            r5 = this;
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r6.getLayoutManager()
            boolean r1 = r0 instanceof androidx.recyclerview.widget.GridLayoutManager
            r2 = 12
            r3 = 3
            r4 = 0
            if (r1 != 0) goto L_0x0025
            boolean r0 = r0 instanceof androidx.recyclerview.widget.StaggeredGridLayoutManager
            if (r0 == 0) goto L_0x0011
            goto L_0x0025
        L_0x0011:
            int r6 = eu.davidea.flexibleadapter.utils.LayoutUtils.getOrientation(r6)
            if (r6 != 0) goto L_0x001d
            int r6 = r5.mSwipeFlags
            if (r6 <= 0) goto L_0x0028
            r3 = r6
            goto L_0x0028
        L_0x001d:
            int r6 = r5.mSwipeFlags
            if (r6 <= 0) goto L_0x0022
            r2 = r6
        L_0x0022:
            r3 = r2
            r2 = 3
            goto L_0x0028
        L_0x0025:
            r2 = 15
            r3 = 0
        L_0x0028:
            boolean r6 = r7 instanceof eu.davidea.flexibleadapter.helpers.ItemTouchHelperCallback.ViewHolderCallback
            if (r6 == 0) goto L_0x003c
            eu.davidea.flexibleadapter.helpers.ItemTouchHelperCallback$ViewHolderCallback r7 = (eu.davidea.flexibleadapter.helpers.ItemTouchHelperCallback.ViewHolderCallback) r7
            boolean r6 = r7.isDraggable()
            if (r6 != 0) goto L_0x0035
            r2 = 0
        L_0x0035:
            boolean r6 = r7.isSwipeable()
            if (r6 != 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r4 = r3
        L_0x003d:
            int r6 = androidx.recyclerview.widget.ItemTouchHelper.Callback.makeMovementFlags(r2, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: eu.davidea.flexibleadapter.helpers.ItemTouchHelperCallback.getMovementFlags(androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$ViewHolder):int");
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        return this.mSwipeThreshold;
    }

    public boolean isHandleDragEnabled() {
        return this.handleDragEnabled;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isItemViewSwipeEnabled() {
        return this.swipeEnabled;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean isLongPressDragEnabled() {
        return this.longPressDragEnabled;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        if (i != 1 || !(viewHolder instanceof ViewHolderCallback)) {
            super.onChildDraw(canvas, recyclerView, viewHolder, f, f2, i, z);
            return;
        }
        ViewHolderCallback viewHolderCallback = (ViewHolderCallback) viewHolder;
        View frontView = viewHolderCallback.getFrontView();
        float f3 = f2 != 0.0f ? f2 : f;
        int i2 = 0;
        if (f3 > 0.0f) {
            i2 = 8;
        } else if (f3 < 0.0f) {
            i2 = 4;
        }
        c(viewHolderCallback, i2);
        ItemTouchHelper.Callback.getDefaultUIUtil().onDraw(canvas, recyclerView, frontView, f, f2, i, z);
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        if (!this.mAdapterCallback.shouldMove(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition())) {
            return false;
        }
        this.mAdapterCallback.onItemMove(viewHolder.getAdapterPosition(), viewHolder2.getAdapterPosition());
        return true;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i) {
        this.mAdapterCallback.onActionStateChanged(viewHolder, i);
        if (i == 0) {
            super.onSelectedChanged(viewHolder, i);
        } else if (viewHolder instanceof ViewHolderCallback) {
            ViewHolderCallback viewHolderCallback = (ViewHolderCallback) viewHolder;
            viewHolderCallback.onActionStateChanged(viewHolder.getAdapterPosition(), i);
            if (i == 1) {
                ItemTouchHelper.Callback.getDefaultUIUtil().onSelected(viewHolderCallback.getFrontView());
            }
        }
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        if ((viewHolder instanceof ViewHolderCallback) && ((ViewHolderCallback) viewHolder).getFrontView().getTranslationX() != 0.0f) {
            this.mAdapterCallback.onItemSwiped(viewHolder.getAdapterPosition(), i);
        }
    }

    public void setDragAnimationDuration(long j) {
        this.mDragAnimationDuration = j;
    }

    public void setHandleDragEnabled(boolean z) {
        this.handleDragEnabled = z;
    }

    public void setLongPressDragEnabled(boolean z) {
        this.longPressDragEnabled = z;
    }

    public void setMoveThreshold(float f) {
        this.mMoveThreshold = f;
    }

    public void setSwipeAnimationDuration(long j) {
        this.mSwipeAnimationDuration = j;
    }

    public void setSwipeEnabled(boolean z) {
        this.swipeEnabled = z;
    }

    public void setSwipeFlags(int i) {
        this.mSwipeFlags = i;
    }

    public void setSwipeThreshold(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        this.mSwipeThreshold = f;
    }
}
