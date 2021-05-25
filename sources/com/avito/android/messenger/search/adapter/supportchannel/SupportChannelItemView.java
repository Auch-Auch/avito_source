package com.avito.android.messenger.search.adapter.supportchannel;

import android.view.View;
import com.avito.android.messenger.search.adapter.ChannelsSearchListItem;
import com.avito.android.messenger.widget.chat_list_element.SupportChatElementImpl;
import com.avito.android.remote.model.Image;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R$\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/avito/android/messenger/search/adapter/supportchannel/SupportChannelItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$SupportChannel;", "data", "", "render", "(Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$SupportChannel;)V", "Lkotlin/Function0;", "getClickListener", "()Lkotlin/jvm/functions/Function0;", "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "clickListener", "Impl", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface SupportChannelItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull SupportChannelItemView supportChannelItemView) {
            ItemView.DefaultImpls.onUnbind(supportChannelItemView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/search/adapter/supportchannel/SupportChannelItemView$Impl;", "Lcom/avito/android/messenger/search/adapter/supportchannel/SupportChannelItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$SupportChannel;", "data", "", "render", "(Lcom/avito/android/messenger/search/adapter/ChannelsSearchListItem$SupportChannel;)V", "Lcom/avito/android/messenger/widget/chat_list_element/SupportChatElementImpl;", "s", "Lcom/avito/android/messenger/widget/chat_list_element/SupportChatElementImpl;", "supportChannelItemElement", "Lkotlin/Function0;", "t", "Lkotlin/jvm/functions/Function0;", "getClickListener", "()Lkotlin/jvm/functions/Function0;", "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "clickListener", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl extends BaseViewHolder implements SupportChannelItemView {
        public final SupportChatElementImpl s;
        @Nullable
        public Function0<Unit> t;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Impl(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            this.s = new SupportChatElementImpl(view);
        }

        @Override // com.avito.android.messenger.search.adapter.supportchannel.SupportChannelItemView
        @Nullable
        public Function0<Unit> getClickListener() {
            return this.t;
        }

        @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
        public void onUnbind() {
            DefaultImpls.onUnbind(this);
        }

        @Override // com.avito.android.messenger.search.adapter.supportchannel.SupportChannelItemView
        public void render(@NotNull ChannelsSearchListItem.SupportChannel supportChannel) {
            Intrinsics.checkNotNullParameter(supportChannel, "data");
            this.s.setHasNewUnreadMessage(supportChannel.getHasNewIncomingUnreadMessages());
            this.s.setTitle(supportChannel.getSupportChatTitle());
            Image supportChatIcon = supportChannel.getSupportChatIcon();
            if (supportChatIcon != null) {
                this.s.setChatIcon(supportChatIcon);
            }
            this.s.setItemClickListener(getClickListener());
        }

        @Override // com.avito.android.messenger.search.adapter.supportchannel.SupportChannelItemView
        public void setClickListener(@Nullable Function0<Unit> function0) {
            this.t = function0;
        }
    }

    @Nullable
    Function0<Unit> getClickListener();

    void render(@NotNull ChannelsSearchListItem.SupportChannel supportChannel);

    void setClickListener(@Nullable Function0<Unit> function0);
}
