package com.avito.android.messenger.conversation.adapter.new_messages_divider;

import android.view.View;
import android.view.ViewGroup;
import com.avito.android.messenger.R;
import com.avito.android.messenger.conversation.ChannelItem;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0004:\u0001\u0010B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ'\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR(\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00048\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\"\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/new_messages_divider/NewMessagesDividerBlueprint;", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/messenger/conversation/ChannelItem$UnreadMessagesDivider;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/konveyor/blueprint/Item;", "item", "", "isRelevantItem", "(Lcom/avito/konveyor/blueprint/Item;)Z", "view", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/konveyor/blueprint/ItemView;Lcom/avito/android/messenger/conversation/ChannelItem$UnreadMessagesDivider;I)V", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/blueprint/ItemPresenter;", "getPresenter", "()Lcom/avito/konveyor/blueprint/ItemPresenter;", "presenter", "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", AuthSource.BOOKING_ORDER, "Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "getViewHolderProvider", "()Lcom/avito/konveyor/blueprint/ViewHolderBuilder$ViewHolderProvider;", "viewHolderProvider", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class NewMessagesDividerBlueprint implements ItemBlueprint<ItemView, ChannelItem.UnreadMessagesDivider>, ItemPresenter<ItemView, ChannelItem.UnreadMessagesDivider> {
    @NotNull
    public final ItemPresenter<ItemView, ChannelItem.UnreadMessagesDivider> a = this;
    @NotNull
    public final ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> b = new ViewHolderBuilder.ViewHolderProvider<>(R.layout.messenger_new_messages_divider, b.a);

    public static final class a extends BaseViewHolder {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
        }
    }

    public static final class b extends Lambda implements Function2<ViewGroup, View, BaseViewHolder> {
        public static final b a = new b();

        public b() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public BaseViewHolder invoke(ViewGroup viewGroup, View view) {
            View view2 = view;
            Intrinsics.checkNotNullParameter(viewGroup, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(view2, "view");
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            view2.setLayoutParams(layoutParams);
            return new a(view2);
        }
    }

    public void bindView(@NotNull ItemView itemView, @NotNull ChannelItem.UnreadMessagesDivider unreadMessagesDivider, int i) {
        Intrinsics.checkNotNullParameter(itemView, "view");
        Intrinsics.checkNotNullParameter(unreadMessagesDivider, "item");
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ItemPresenter<ItemView, ChannelItem.UnreadMessagesDivider> getPresenter() {
        return this.a;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    @NotNull
    public ViewHolderBuilder.ViewHolderProvider<BaseViewHolder> getViewHolderProvider() {
        return this.b;
    }

    @Override // com.avito.konveyor.blueprint.ItemBlueprint
    public boolean isRelevantItem(@NotNull Item item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item instanceof ChannelItem.UnreadMessagesDivider;
    }
}
