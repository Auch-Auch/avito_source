package eu.davidea.flexibleadapter.common;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
public class FlexibleLayoutManager implements IFlexibleLayoutManager {
    public RecyclerView.LayoutManager mLayoutManager;
    public RecyclerView mRecyclerView;

    public FlexibleLayoutManager(RecyclerView recyclerView) {
        this(recyclerView.getLayoutManager());
        this.mRecyclerView = recyclerView;
    }

    public final RecyclerView.LayoutManager a() {
        RecyclerView recyclerView = this.mRecyclerView;
        return recyclerView != null ? recyclerView.getLayoutManager() : this.mLayoutManager;
    }

    @Override // eu.davidea.flexibleadapter.common.IFlexibleLayoutManager
    public int findFirstCompletelyVisibleItemPosition() {
        RecyclerView.LayoutManager a = a();
        if (a instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) a).findFirstCompletelyVisibleItemPositions(null)[0];
        }
        return ((LinearLayoutManager) a).findFirstCompletelyVisibleItemPosition();
    }

    @Override // eu.davidea.flexibleadapter.common.IFlexibleLayoutManager
    public int findFirstVisibleItemPosition() {
        RecyclerView.LayoutManager a = a();
        if (a instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) a).findFirstVisibleItemPositions(null)[0];
        }
        return ((LinearLayoutManager) a).findFirstVisibleItemPosition();
    }

    @Override // eu.davidea.flexibleadapter.common.IFlexibleLayoutManager
    public int findLastCompletelyVisibleItemPosition() {
        RecyclerView.LayoutManager a = a();
        if (a instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) a).findLastCompletelyVisibleItemPositions(null)[0];
        }
        return ((LinearLayoutManager) a).findLastCompletelyVisibleItemPosition();
    }

    @Override // eu.davidea.flexibleadapter.common.IFlexibleLayoutManager
    public int findLastVisibleItemPosition() {
        RecyclerView.LayoutManager a = a();
        if (a instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) a).findLastVisibleItemPositions(null)[0];
        }
        return ((LinearLayoutManager) a).findLastVisibleItemPosition();
    }

    @Override // eu.davidea.flexibleadapter.common.IFlexibleLayoutManager
    public int getOrientation() {
        RecyclerView.LayoutManager a = a();
        if (a instanceof LinearLayoutManager) {
            return ((LinearLayoutManager) a).getOrientation();
        }
        if (a instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) a).getOrientation();
        }
        return 1;
    }

    @Override // eu.davidea.flexibleadapter.common.IFlexibleLayoutManager
    public int getSpanCount() {
        RecyclerView.LayoutManager a = a();
        if (a instanceof GridLayoutManager) {
            return ((GridLayoutManager) a).getSpanCount();
        }
        if (a instanceof StaggeredGridLayoutManager) {
            return ((StaggeredGridLayoutManager) a).getSpanCount();
        }
        return 1;
    }

    public FlexibleLayoutManager(RecyclerView.LayoutManager layoutManager) {
        this.mLayoutManager = layoutManager;
    }
}
