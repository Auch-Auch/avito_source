package eu.davidea.flexibleadapter.items;

import eu.davidea.flexibleadapter.items.IFlexible;
import eu.davidea.viewholders.ExpandableViewHolder;
import java.util.ArrayList;
import java.util.List;
public abstract class AbstractExpandableItem<VH extends ExpandableViewHolder, S extends IFlexible> extends AbstractFlexibleItem<VH> implements IExpandable<VH, S> {
    public boolean mExpanded = false;
    public List<S> mSubItems;

    public AbstractExpandableItem addSubItem(S s) {
        if (this.mSubItems == null) {
            this.mSubItems = new ArrayList();
        }
        this.mSubItems.add(s);
        return this;
    }

    public AbstractExpandableItem addSubItems(int i, List<S> list) {
        List<S> list2 = this.mSubItems;
        if (list2 == null || i < 0 || i >= list2.size()) {
            if (this.mSubItems == null) {
                this.mSubItems = new ArrayList();
            }
            this.mSubItems.addAll(list);
        } else {
            this.mSubItems.addAll(i, list);
        }
        return this;
    }

    public boolean contains(S s) {
        List<S> list = this.mSubItems;
        return list != null && list.contains(s);
    }

    @Override // eu.davidea.flexibleadapter.items.IExpandable
    public int getExpansionLevel() {
        return 0;
    }

    public S getSubItem(int i) {
        List<S> list = this.mSubItems;
        if (list == null || i < 0 || i >= list.size()) {
            return null;
        }
        return this.mSubItems.get(i);
    }

    public final int getSubItemPosition(S s) {
        List<S> list = this.mSubItems;
        if (list != null) {
            return list.indexOf(s);
        }
        return -1;
    }

    @Override // eu.davidea.flexibleadapter.items.IExpandable
    public final List<S> getSubItems() {
        return this.mSubItems;
    }

    public final int getSubItemsCount() {
        List<S> list = this.mSubItems;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final boolean hasSubItems() {
        List<S> list = this.mSubItems;
        return list != null && list.size() > 0;
    }

    @Override // eu.davidea.flexibleadapter.items.IExpandable
    public boolean isExpanded() {
        return this.mExpanded;
    }

    public boolean removeSubItem(S s) {
        List<S> list;
        return (s == null || (list = this.mSubItems) == null || !list.remove(s)) ? false : true;
    }

    public boolean removeSubItems(List<S> list) {
        List<S> list2;
        return (list == null || (list2 = this.mSubItems) == null || !list2.removeAll(list)) ? false : true;
    }

    @Override // eu.davidea.flexibleadapter.items.IExpandable
    public void setExpanded(boolean z) {
        this.mExpanded = z;
    }

    public AbstractExpandableItem setSubItems(List<S> list) {
        this.mSubItems = list;
        return this;
    }

    public boolean removeSubItem(int i) {
        List<S> list = this.mSubItems;
        if (list == null || i < 0 || i >= list.size()) {
            return false;
        }
        this.mSubItems.remove(i);
        return true;
    }

    public AbstractExpandableItem addSubItem(int i, S s) {
        List<S> list = this.mSubItems;
        if (list == null || i < 0 || i >= list.size()) {
            addSubItem(s);
        } else {
            this.mSubItems.add(i, s);
        }
        return this;
    }
}
