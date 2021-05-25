package com.avito.android.messenger.search.adapter.channel;

import android.view.View;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.messenger.search.adapter.ChannelsSearchListItem;
import com.avito.android.messenger.widget.chat_list_element.ChatListElement;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/search/adapter/channel/ChannelItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$Channel;", "data", "", "render", "(Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$Channel;)V", "Lkotlin/Function0;", "getClickListener", "()Lkotlin/jvm/functions/Function0;", "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "clickListener", "Impl", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChannelItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ChannelItemView channelItemView) {
            ItemView.DefaultImpls.onUnbind(channelItemView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/search/adapter/channel/ChannelItemView$Impl;", "Lcom/avito/android/messenger/search/adapter/channel/ChannelItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$Channel;", "data", "", "render", "(Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$Channel;)V", "Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement;", "s", "Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement;", "chatListElement", "Lkotlin/Function0;", "t", "Lkotlin/jvm/functions/Function0;", "getClickListener", "()Lkotlin/jvm/functions/Function0;", "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "clickListener", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl extends BaseViewHolder implements ChannelItemView {
        public final ChatListElement s;
        @Nullable
        public Function0<Unit> t;

        public static final class a extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Impl a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(Impl impl) {
                super(0);
                this.a = impl;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                Function0<Unit> clickListener = this.a.getClickListener();
                if (clickListener != null) {
                    clickListener.invoke();
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.s = ChatListElement.Companion.create$default(ChatListElement.Companion, view, false, 2, null);
        }

        @Override // com.avito.android.messenger.search.adapter.channel.ChannelItemView
        @Nullable
        public Function0<Unit> getClickListener() {
            return this.t;
        }

        @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
        public void onUnbind() {
            DefaultImpls.onUnbind(this);
        }

        @Override // com.avito.android.messenger.search.adapter.channel.ChannelItemView
        public void render(@NotNull ChannelsSearchListItem.Channel channel) {
            Intrinsics.checkNotNullParameter(channel, "data");
            this.s.setChatTitle(channel.getChatTitle());
            this.s.setLastMessage(channel.getLastMessageType(), channel.getLastMessage());
            this.s.setAvatarSource(AvitoPictureKt.pictureOf$default(channel.getAvatar(), false, 0.0f, 0.0f, null, 28, null));
            ChatListElement chatListElement = this.s;
            ChannelsSearchListItem.Channel.ItemInfo itemInfo = channel.getItemInfo();
            String title = itemInfo != null ? itemInfo.getTitle() : null;
            ChannelsSearchListItem.Channel.ItemInfo itemInfo2 = channel.getItemInfo();
            chatListElement.setItemInfo(title, itemInfo2 != null ? itemInfo2.getPrice() : null);
            this.s.setFeatureImage(channel.getFeatureImage());
            this.s.setDate(channel.getDateString());
            this.s.setIsActive(channel.isActive());
            this.s.setInterlocutorOnline(false);
            this.s.setItemDeliveryStatus(null, ChatListElement.ItemDeliveryStatusType.NONE);
            this.s.setClickListener(new a(this));
        }

        @Override // com.avito.android.messenger.search.adapter.channel.ChannelItemView
        public void setClickListener(@Nullable Function0<Unit> function0) {
            this.t = function0;
        }
    }

    @Nullable
    Function0<Unit> getClickListener();

    void render(@NotNull ChannelsSearchListItem.Channel channel);

    void setClickListener(@Nullable Function0<Unit> function0);
}
