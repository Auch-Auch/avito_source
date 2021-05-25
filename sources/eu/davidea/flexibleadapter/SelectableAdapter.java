package eu.davidea.flexibleadapter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.model.AdvertStatus;
import eu.davidea.fastscroller.FastScroller;
import eu.davidea.flexibleadapter.common.FlexibleLayoutManager;
import eu.davidea.flexibleadapter.common.IFlexibleLayoutManager;
import eu.davidea.flexibleadapter.utils.LayoutUtils;
import eu.davidea.flexibleadapter.utils.Log;
import eu.davidea.flexibleadapter.utils.Logger;
import eu.davidea.viewholders.FlexibleViewHolder;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import q6.a.a.b;
public abstract class SelectableAdapter extends RecyclerView.Adapter implements FastScroller.BubbleTextCreator, FastScroller.OnScrollStateChangeListener, FastScroller.AdapterInterface {
    public Logger c;
    public final Set<Integer> d;
    public final Set<FlexibleViewHolder> e;
    public int f;
    public IFlexibleLayoutManager g;
    public boolean isFastScroll = false;
    public FastScroller.Delegate mFastScrollerDelegate;
    public boolean mLastItemInActionMode = false;
    public RecyclerView mRecyclerView;
    public boolean mSelectAll = false;

    @SuppressLint({"UniqueConstants"})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
        public static final int IDLE = 0;
        public static final int MULTI = 2;
        public static final int SINGLE = 1;
    }

    public SelectableAdapter() {
        if (Log.customTag == null) {
            Log.useTag("FlexibleAdapter");
        }
        Logger logger = new Logger(Log.customTag);
        this.c = logger;
        logger.i("Running version %s", BuildConfig.VERSION_NAME);
        this.d = Collections.synchronizedSet(new TreeSet());
        this.e = new HashSet();
        this.f = 0;
        this.mFastScrollerDelegate = new FastScroller.Delegate();
    }

    public static void enableLogs(int i) {
        Log.setLevel(i);
    }

    public static void useTag(String str) {
        Log.useTag(str);
    }

    public final void a(int i, int i2) {
        if (i2 > 0) {
            for (FlexibleViewHolder flexibleViewHolder : this.e) {
                flexibleViewHolder.toggleActivation();
            }
            if (this.e.isEmpty()) {
                notifyItemRangeChanged(i, i2, Payload.SELECTION);
            }
        }
    }

    public final boolean addSelection(int i) {
        return isSelectable(i) && this.d.add(Integer.valueOf(i));
    }

    public void clearSelection() {
        synchronized (this.d) {
            int i = 0;
            this.c.d("clearSelection %s", this.d);
            Iterator<Integer> it = this.d.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                it.remove();
                if (i + i2 == intValue) {
                    i2++;
                } else {
                    a(i, i2);
                    i = intValue;
                    i2 = 1;
                }
            }
            a(i, i2);
        }
    }

    public Set<FlexibleViewHolder> getAllBoundViewHolders() {
        return Collections.unmodifiableSet(this.e);
    }

    public FastScroller getFastScroller() {
        return this.mFastScrollerDelegate.getFastScroller();
    }

    public IFlexibleLayoutManager getFlexibleLayoutManager() {
        if (this.g == null) {
            RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
            if (layoutManager instanceof IFlexibleLayoutManager) {
                this.g = (IFlexibleLayoutManager) layoutManager;
            } else if (layoutManager != null) {
                this.g = new FlexibleLayoutManager(this.mRecyclerView);
            }
        }
        return this.g;
    }

    public int getMode() {
        return this.f;
    }

    public RecyclerView getRecyclerView() {
        return this.mRecyclerView;
    }

    public int getSelectedItemCount() {
        return this.d.size();
    }

    public List<Integer> getSelectedPositions() {
        return new ArrayList(this.d);
    }

    public Set<Integer> getSelectedPositionsAsSet() {
        return this.d;
    }

    public boolean isFastScrollerEnabled() {
        return this.mFastScrollerDelegate.isFastScrollerEnabled();
    }

    public boolean isLastItemInActionMode() {
        if (this.mSelectAll || this.mLastItemInActionMode) {
            this.mRecyclerView.postDelayed(new b(this), 200);
        }
        return this.mLastItemInActionMode;
    }

    public boolean isSelectAll() {
        if (this.mSelectAll || this.mLastItemInActionMode) {
            this.mRecyclerView.postDelayed(new b(this), 200);
        }
        return this.mSelectAll;
    }

    public abstract boolean isSelectable(int i);

    public boolean isSelected(int i) {
        return this.d.contains(Integer.valueOf(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        FastScroller.Delegate delegate = this.mFastScrollerDelegate;
        if (delegate != null) {
            delegate.onAttachedToRecyclerView(recyclerView);
        }
        this.mRecyclerView = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i, List list) {
        if (viewHolder instanceof FlexibleViewHolder) {
            FlexibleViewHolder flexibleViewHolder = (FlexibleViewHolder) viewHolder;
            flexibleViewHolder.getContentView().setActivated(isSelected(i));
            if (flexibleViewHolder.getContentView().isActivated() && flexibleViewHolder.getActivationElevation() > 0.0f) {
                ViewCompat.setElevation(flexibleViewHolder.getContentView(), flexibleViewHolder.getActivationElevation());
            } else if (flexibleViewHolder.getActivationElevation() > 0.0f) {
                ViewCompat.setElevation(flexibleViewHolder.getContentView(), 0.0f);
            }
            this.e.add(flexibleViewHolder);
            return;
        }
        viewHolder.itemView.setActivated(isSelected(i));
    }

    @Override // eu.davidea.fastscroller.FastScroller.BubbleTextCreator
    public String onCreateBubbleText(int i) {
        return String.valueOf(i + 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        FastScroller.Delegate delegate = this.mFastScrollerDelegate;
        if (delegate != null) {
            delegate.onDetachedFromRecyclerView(recyclerView);
        }
        this.mRecyclerView = null;
        this.g = null;
    }

    @Override // eu.davidea.fastscroller.FastScroller.OnScrollStateChangeListener
    public void onFastScrollerStateChange(boolean z) {
        this.isFastScroll = z;
    }

    public void onRestoreInstanceState(Bundle bundle) {
        this.d.addAll(bundle.getIntegerArrayList("SelectableAdapter"));
        if (getSelectedItemCount() > 0) {
            this.c.d("Restore selection %s", this.d);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putIntegerArrayList("SelectableAdapter", new ArrayList<>(this.d));
        if (getSelectedItemCount() > 0) {
            this.c.d("Saving selection %s", this.d);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof FlexibleViewHolder) {
            this.e.remove(viewHolder);
        }
    }

    public final boolean removeSelection(int i) {
        return this.d.remove(Integer.valueOf(i));
    }

    public void selectAll(Integer... numArr) {
        this.mSelectAll = true;
        List asList = Arrays.asList(numArr);
        this.c.v("selectAll ViewTypes to include %s", asList);
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < getItemCount(); i3++) {
            if (isSelectable(i3) && (asList.isEmpty() || asList.contains(Integer.valueOf(getItemViewType(i3))))) {
                this.d.add(Integer.valueOf(i3));
                i2++;
            } else if (i + i2 == i3) {
                a(i, i2);
                i = i3;
                i2 = 0;
            }
        }
        this.c.d("selectAll notifyItemRangeChanged from positionStart=%s itemCount=%s", Integer.valueOf(i), Integer.valueOf(getItemCount()));
        a(i, getItemCount());
    }

    @Override // eu.davidea.fastscroller.FastScroller.AdapterInterface
    public void setFastScroller(@NonNull FastScroller fastScroller) {
        this.mFastScrollerDelegate.setFastScroller(fastScroller);
    }

    public void setFlexibleLayoutManager(IFlexibleLayoutManager iFlexibleLayoutManager) {
        this.g = iFlexibleLayoutManager;
    }

    public void setMode(int i) {
        boolean z = true;
        this.c.i("Mode %s enabled", LayoutUtils.getModeName(i));
        if (this.f == 1 && i == 0) {
            clearSelection();
        }
        this.f = i;
        if (i == 2) {
            z = false;
        }
        this.mLastItemInActionMode = z;
    }

    public void swapSelection(int i, int i2) {
        if (isSelected(i) && !isSelected(i2)) {
            removeSelection(i);
            addSelection(i2);
        } else if (!isSelected(i) && isSelected(i2)) {
            removeSelection(i2);
            addSelection(i);
        }
    }

    public void toggleFastScroller() {
        this.mFastScrollerDelegate.toggleFastScroller();
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x002b: APUT  (r3v1 java.lang.Object[]), (0 ??[int, short, byte, char]), (r0v3 java.lang.String) */
    public void toggleSelection(int i) {
        if (i >= 0) {
            if (this.f == 1) {
                clearSelection();
            }
            boolean contains = this.d.contains(Integer.valueOf(i));
            if (contains) {
                removeSelection(i);
            } else {
                addSelection(i);
            }
            Logger logger = this.c;
            Object[] objArr = new Object[3];
            objArr[0] = contains ? AdvertStatus.REMOVED : "added";
            objArr[1] = Integer.valueOf(i);
            objArr[2] = this.d;
            logger.v("toggleSelection %s on position %s, current %s", objArr);
        }
    }
}
