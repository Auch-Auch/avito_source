package com.avito.android.messenger.channels.mvi.view;

import a2.g.r.g;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.messenger.R;
import com.avito.android.messenger.widget.chat_list_element.SupportChatElement;
import com.avito.android.messenger.widget.chat_list_element.SupportChatElementImpl;
import com.avito.android.remote.model.Image;
import com.vk.sdk.api.VKApiConst;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.viewholders.FlexibleViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00015B)\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0014\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b3\u00104J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ9\u0010\u0012\u001a\u00020\u00112\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J:\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\b¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001d\u001a\u00020\u00112\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u001eR*\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u001f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0019\u0010\u0017\u001a\u00020\u00168\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0019\u0010\u0018\u001a\u00020\u00148\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00066"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/PinnedSupportChatItem;", "Lcom/avito/android/messenger/channels/mvi/view/AbstractListItem;", "Lcom/avito/android/messenger/channels/mvi/view/PinnedSupportChatItem$ViewHolder;", "", "getLayoutRes", "()I", "Landroid/view/View;", "view", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "adapter", "createViewHolder", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)Lcom/avito/android/messenger/channels/mvi/view/PinnedSupportChatItem$ViewHolder;", "holder", VKApiConst.POSITION, "", "", "payloads", "", "bindViewHolder", "(Leu/davidea/flexibleadapter/FlexibleAdapter;Lcom/avito/android/messenger/channels/mvi/view/PinnedSupportChatItem$ViewHolder;ILjava/util/List;)V", "", "id", "", "hasNewIncomingUnreadMessages", "supportChatTitle", "Lcom/avito/android/remote/model/Image;", "supportChatIcon", "copy", "(Ljava/lang/String;ZLjava/lang/String;Lcom/avito/android/remote/model/Image;)Lcom/avito/android/messenger/channels/mvi/view/PinnedSupportChatItem;", "unbindViewHolder", "(Leu/davidea/flexibleadapter/FlexibleAdapter;Lcom/avito/android/messenger/channels/mvi/view/PinnedSupportChatItem$ViewHolder;I)V", "Lkotlin/Function0;", "f", "Lkotlin/jvm/functions/Function0;", "getItemClickListener", "()Lkotlin/jvm/functions/Function0;", "setItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "itemClickListener", g.a, "Z", "getHasNewIncomingUnreadMessages", "()Z", "h", "Ljava/lang/String;", "getSupportChatTitle", "()Ljava/lang/String;", "i", "Lcom/avito/android/remote/model/Image;", "getSupportChatIcon", "()Lcom/avito/android/remote/model/Image;", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Lcom/avito/android/remote/model/Image;)V", "ViewHolder", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class PinnedSupportChatItem extends AbstractListItem<ViewHolder> {
    @Nullable
    public Function0<Unit> f;
    public final boolean g;
    @NotNull
    public final String h;
    @Nullable
    public final Image i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\n\u0010\u000bJ \u0010\u000e\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/PinnedSupportChatItem$ViewHolder;", "Leu/davidea/viewholders/FlexibleViewHolder;", "Lcom/avito/android/messenger/widget/chat_list_element/SupportChatElement;", "Lcom/avito/android/remote/model/Image;", "image", "", "setChatIcon", "(Lcom/avito/android/remote/model/Image;)V", "", "hasNewIncomingUnreadMessages", "setHasNewUnreadMessage", "(Z)V", "Lkotlin/Function0;", "itemClickListener", "setItemClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "Landroid/view/View;", "view", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "adapter", "<init>", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ViewHolder extends FlexibleViewHolder implements SupportChatElement {
        public final /* synthetic */ SupportChatElementImpl w;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view, @NotNull FlexibleAdapter<?> flexibleAdapter) {
            super(view, flexibleAdapter);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
            this.w = new SupportChatElementImpl(view);
        }

        @Override // com.avito.android.messenger.widget.chat_list_element.SupportChatElement
        public void setChatIcon(@Nullable Image image) {
            this.w.setChatIcon(image);
        }

        @Override // com.avito.android.messenger.widget.chat_list_element.SupportChatElement
        public void setHasNewUnreadMessage(boolean z) {
            this.w.setHasNewUnreadMessage(z);
        }

        @Override // com.avito.android.messenger.widget.chat_list_element.SupportChatElement
        public void setItemClickListener(@Nullable Function0<Unit> function0) {
            this.w.setItemClickListener(function0);
        }

        @Override // com.avito.android.messenger.widget.chat_list_element.SupportChatElement
        public void setTitle(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.w.setTitle(str);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PinnedSupportChatItem(@NotNull String str, boolean z, @NotNull String str2, @Nullable Image image) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "supportChatTitle");
        this.g = z;
        this.h = str2;
        this.i = image;
    }

    public static /* synthetic */ PinnedSupportChatItem copy$default(PinnedSupportChatItem pinnedSupportChatItem, String str, boolean z, String str2, Image image, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = pinnedSupportChatItem.id;
        }
        if ((i2 & 2) != 0) {
            z = pinnedSupportChatItem.getHasNewIncomingUnreadMessages();
        }
        if ((i2 & 4) != 0) {
            str2 = pinnedSupportChatItem.getSupportChatTitle();
        }
        if ((i2 & 8) != 0) {
            image = pinnedSupportChatItem.getSupportChatIcon();
        }
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "supportChatTitle");
        return new PinnedSupportChatItem(str, z, str2, image);
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    public /* bridge */ /* synthetic */ void bindViewHolder(FlexibleAdapter flexibleAdapter, RecyclerView.ViewHolder viewHolder, int i2, List list) {
        bindViewHolder((FlexibleAdapter<?>) flexibleAdapter, (ViewHolder) viewHolder, i2, (List<? extends Object>) list);
    }

    @NotNull
    public final PinnedSupportChatItem copy(@NotNull String str, boolean z, @NotNull String str2, @Nullable Image image) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "supportChatTitle");
        return new PinnedSupportChatItem(str, z, str2, image);
    }

    public final boolean getHasNewIncomingUnreadMessages() {
        return this.g;
    }

    @Nullable
    public final Function0<Unit> getItemClickListener() {
        return this.f;
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    public int getLayoutRes() {
        return R.layout.chat_list_pinned_support_chat_item;
    }

    @Nullable
    public final Image getSupportChatIcon() {
        return this.i;
    }

    @NotNull
    public final String getSupportChatTitle() {
        return this.h;
    }

    public final void setItemClickListener(@Nullable Function0<Unit> function0) {
        this.f = function0;
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    public /* bridge */ /* synthetic */ void unbindViewHolder(FlexibleAdapter flexibleAdapter, RecyclerView.ViewHolder viewHolder, int i2) {
        unbindViewHolder((FlexibleAdapter<?>) flexibleAdapter, (ViewHolder) viewHolder, i2);
    }

    public void bindViewHolder(@NotNull FlexibleAdapter<?> flexibleAdapter, @NotNull ViewHolder viewHolder, int i2, @NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        viewHolder.setTitle(this.h);
        viewHolder.setHasNewUnreadMessage(this.g);
        viewHolder.setItemClickListener(this.f);
        Image image = this.i;
        if (image != null) {
            viewHolder.setChatIcon(image);
        }
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    @NotNull
    public ViewHolder createViewHolder(@NotNull View view, @NotNull FlexibleAdapter<?> flexibleAdapter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        return new ViewHolder(view, flexibleAdapter);
    }

    public void unbindViewHolder(@NotNull FlexibleAdapter<?> flexibleAdapter, @NotNull ViewHolder viewHolder, int i2) {
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        viewHolder.setItemClickListener(null);
        super.unbindViewHolder(flexibleAdapter, (FlexibleAdapter<?>) viewHolder, i2);
    }
}
