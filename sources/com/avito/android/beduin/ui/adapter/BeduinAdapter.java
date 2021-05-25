package com.avito.android.beduin.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.beduin.core.ComponentsContext;
import com.avito.android.beduin.core.component.BeduinComponent;
import com.avito.android.beduin.core.model.container.component.BeduinModel;
import com.avito.android.util.Views;
import com.vk.sdk.api.VKApiConst;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B\u0011\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b \u0010!J\u001f\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0017\u001a\u00020\r2\u0018\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00130\u0012¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR(\u0010\u001f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00130\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006#"}, d2 = {"Lcom/avito/android/beduin/ui/adapter/BeduinAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/avito/android/beduin/ui/adapter/BeduinAdapter$ViewHolder;", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/avito/android/beduin/ui/adapter/BeduinAdapter$ViewHolder;", "getItemCount", "()I", "holder", VKApiConst.POSITION, "", "onBindViewHolder", "(Lcom/avito/android/beduin/ui/adapter/BeduinAdapter$ViewHolder;I)V", "getItemViewType", "(I)I", "", "Lcom/avito/android/beduin/core/component/BeduinComponent;", "Lcom/avito/android/beduin/core/model/container/component/BeduinModel;", "Landroid/view/View;", "newList", "updateList", "(Ljava/util/List;)V", "Lcom/avito/android/beduin/core/ComponentsContext;", "d", "Lcom/avito/android/beduin/core/ComponentsContext;", "componentsContext", "c", "Ljava/util/List;", "data", "<init>", "(Lcom/avito/android/beduin/core/ComponentsContext;)V", "ViewHolder", "beduin_release"}, k = 1, mv = {1, 4, 2})
public final class BeduinAdapter extends RecyclerView.Adapter<ViewHolder> {
    public List<? extends BeduinComponent<BeduinModel, View>> c = CollectionsKt__CollectionsKt.emptyList();
    public final ComponentsContext d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/beduin/ui/adapter/BeduinAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "beduin_release"}, k = 1, mv = {1, 4, 2})
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
        }
    }

    @Inject
    public BeduinAdapter(@NotNull ComponentsContext componentsContext) {
        Intrinsics.checkNotNullParameter(componentsContext, "componentsContext");
        this.d = componentsContext;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.c.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return Reflection.getOrCreateKotlinClass(this.c.get(i).getClass()).hashCode();
    }

    public final void updateList(@NotNull List<? extends BeduinComponent<BeduinModel, View>> list) {
        Intrinsics.checkNotNullParameter(list, "newList");
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new BeduinDiffUtil(this.c, list), false);
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "DiffUtil.calculateDiff(B…is.data, newList), false)");
        this.c = list;
        calculateDiff.dispatchUpdatesTo(this);
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        View view = viewHolder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        ((BeduinComponent) this.c.get(i)).updateWithData(view, this.d);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i) {
        T t;
        boolean z;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        Iterator<T> it = this.c.iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Reflection.getOrCreateKotlinClass(t.getClass()).hashCode() == i) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        Intrinsics.checkNotNull(t);
        T t2 = t;
        View createView = t2.createView(viewGroup, new RecyclerView.LayoutParams(-1, -2));
        Views.changeMargin$default(createView, t2.getDefaultHorizontalMargin(), 0, t2.getDefaultHorizontalMargin(), 0, 10, null);
        Unit unit = Unit.INSTANCE;
        return new ViewHolder(createView);
    }
}
