package com.avito.android.messenger.channels.mvi.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ui_components.R;
import com.vk.sdk.api.VKApiConst;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.viewholders.FlexibleViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0011\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ9\u0010\u0012\u001a\u00020\u00112\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001b\u0010\u0019\u001a\u00020\u00182\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/ChannelsListProgressItem;", "Lcom/avito/android/messenger/channels/mvi/view/AbstractListItem;", "Lcom/avito/android/messenger/channels/mvi/view/ChannelsListProgressItem$ViewHolder;", "", "getLayoutRes", "()I", "Landroid/view/View;", "view", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "adapter", "createViewHolder", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)Lcom/avito/android/messenger/channels/mvi/view/ChannelsListProgressItem$ViewHolder;", "holder", VKApiConst.POSITION, "", "", "payloads", "", "bindViewHolder", "(Leu/davidea/flexibleadapter/FlexibleAdapter;Lcom/avito/android/messenger/channels/mvi/view/ChannelsListProgressItem$ViewHolder;ILjava/util/List;)V", "", "toString", "()Ljava/lang/String;", "other", "", "contentEquals", "(Lcom/avito/android/messenger/channels/mvi/view/AbstractListItem;)Z", "id", "<init>", "(Ljava/lang/String;)V", "ViewHolder", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsListProgressItem extends AbstractListItem<ViewHolder> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/ChannelsListProgressItem$ViewHolder;", "Leu/davidea/viewholders/FlexibleViewHolder;", "Landroid/view/View;", "view", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "adapter", "<init>", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ViewHolder extends FlexibleViewHolder {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view, @NotNull FlexibleAdapter<?> flexibleAdapter) {
            super(view, flexibleAdapter);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        }
    }

    public ChannelsListProgressItem() {
        this(null, 1, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChannelsListProgressItem(String str, int i, j jVar) {
        this((i & 1) != 0 ? "ChannelsListProgressItem" : str);
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    public /* bridge */ /* synthetic */ void bindViewHolder(FlexibleAdapter flexibleAdapter, RecyclerView.ViewHolder viewHolder, int i, List list) {
        bindViewHolder((FlexibleAdapter<?>) flexibleAdapter, (ViewHolder) viewHolder, i, (List<? extends Object>) list);
    }

    public void bindViewHolder(@NotNull FlexibleAdapter<?> flexibleAdapter, @NotNull ViewHolder viewHolder, int i, @NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem
    public boolean contentEquals(@NotNull AbstractListItem<?> abstractListItem) {
        Intrinsics.checkNotNullParameter(abstractListItem, "other");
        if (this == abstractListItem) {
            return true;
        }
        return (abstractListItem instanceof ChannelsListProgressItem) && super.equals(abstractListItem);
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    public int getLayoutRes() {
        return R.layout.chat_list_progress_item;
    }

    @NotNull
    public String toString() {
        return "ChannelsListProgressItem";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsListProgressItem(@NotNull String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "id");
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    @NotNull
    public ViewHolder createViewHolder(@NotNull View view, @NotNull FlexibleAdapter<?> flexibleAdapter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        return new ViewHolder(view, flexibleAdapter);
    }
}
