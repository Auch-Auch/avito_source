package com.avito.android.messenger.search.adapter.pagination;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.messenger.R;
import com.avito.android.messenger.search.adapter.ChannelsSearchListItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.blueprint.ItemBlueprint;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.avito.konveyor.blueprint.ItemView;
import com.avito.konveyor.blueprint.ViewHolderBuilder;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR(\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00108\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001a"}, d2 = {"Lcom/avito/android/messenger/search/adapter/pagination/PaginationItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$Pagination;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/android/messenger/search/adapter/pagination/PaginationItemBlueprint$ViewHolder;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "Lcom/avito/konveyor/blueprint/ItemPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ItemPresenter;", "getPresenter", "()Lcom/avito/konveyor/blueprint/ItemPresenter;", "presenter", "<init>", "()V", "Presenter", "ViewHolder", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PaginationItemBlueprint implements ItemBlueprint<ItemView, ChannelsSearchListItem.Pagination> {
    @NotNull
    public final ItemPresenter<ItemView, ChannelsSearchListItem.Pagination> a = new Presenter();
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<ViewHolder> b = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.messenger_channels_search_pagination_item, a.a);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/search/adapter/pagination/PaginationItemBlueprint$Presenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$Pagination;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/konveyor/blueprint/ItemView;Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$Pagination;I)V", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Presenter implements ItemPresenter<ItemView, ChannelsSearchListItem.Pagination> {
        public void bindView(@NotNull ItemView itemView, @NotNull ChannelsSearchListItem.Pagination pagination, int i) {
            Intrinsics.checkNotNullParameter(itemView, "view");
            Intrinsics.checkNotNullParameter(pagination, "item");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/messenger/search/adapter/pagination/PaginationItemBlueprint$ViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ViewHolder extends BaseViewHolder {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    public static final class a extends Lambda implements Function2<ViewGroup, View, ViewHolder> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public ViewHolder invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            return new ViewHolder(view2);
        }
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<ItemView, ChannelsSearchListItem.Pagination> getPresenter() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<ViewHolder> getViewHolderProvider() {
        return this.b;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof ChannelsSearchListItem.Pagination;
    }
}
