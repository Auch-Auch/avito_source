package eu.davidea.flexibleadapter.items;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import eu.davidea.flexibleadapter.items.IHeader;
public interface ISectionable<VH extends RecyclerView.ViewHolder, T extends IHeader> extends IFlexible<VH> {
    T getHeader();

    void setHeader(T t);
}
