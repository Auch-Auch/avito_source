package eu.davidea.flexibleadapter.items;

import android.view.View;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import java.util.List;
public interface IFlexible<VH extends RecyclerView.ViewHolder> {
    void bindViewHolder(FlexibleAdapter flexibleAdapter, VH vh, int i, List<Object> list);

    VH createViewHolder(View view, FlexibleAdapter flexibleAdapter);

    String getBubbleText(int i);

    int getItemViewType();

    @LayoutRes
    int getLayoutRes();

    @IntRange(from = 1)
    int getSpanSize(int i, int i2);

    boolean isDraggable();

    boolean isEnabled();

    boolean isHidden();

    boolean isSelectable();

    boolean isSwipeable();

    void onViewAttached(FlexibleAdapter flexibleAdapter, VH vh, int i);

    void onViewDetached(FlexibleAdapter flexibleAdapter, VH vh, int i);

    void setDraggable(boolean z);

    void setEnabled(boolean z);

    void setHidden(boolean z);

    void setSelectable(boolean z);

    void setSwipeable(boolean z);

    boolean shouldNotifyChange(IFlexible iFlexible);

    void unbindViewHolder(FlexibleAdapter flexibleAdapter, VH vh, int i);
}
