package com.avito.android.messenger.channels.mvi.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.component.banner_card.BannerCard;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.vk.sdk.api.VKApiConst;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.viewholders.FlexibleViewHolder;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B;\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0018\u001a\u00020\u0003\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ9\u0010\u0012\u001a\u00020\u00112\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013JE\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0003\u0010\u0016\u001a\u00020\u00032\b\b\u0003\u0010\u0017\u001a\u00020\u00032\b\b\u0003\u0010\u0018\u001a\u00020\u00032\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u001b\u0010\u001f\u001a\u00020\u001e2\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0016¢\u0006\u0004\b\u001f\u0010 R\u0016\u0010\u0016\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010!R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010\u0017\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010!R\u0016\u0010\u0018\u001a\u00020\u00038\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010!R(\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00110\u00198\u0006@\u0006X.¢\u0006\u0012\n\u0004\b$\u0010#\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/ChannelsListBannerItem;", "Lcom/avito/android/messenger/channels/mvi/view/AbstractListItem;", "Lcom/avito/android/messenger/channels/mvi/view/ChannelsListBannerItem$ViewHolder;", "", "getLayoutRes", "()I", "Landroid/view/View;", "view", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "adapter", "createViewHolder", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)Lcom/avito/android/messenger/channels/mvi/view/ChannelsListBannerItem$ViewHolder;", "holder", VKApiConst.POSITION, "", "", "payloads", "", "bindViewHolder", "(Leu/davidea/flexibleadapter/FlexibleAdapter;Lcom/avito/android/messenger/channels/mvi/view/ChannelsListBannerItem$ViewHolder;ILjava/util/List;)V", "", "id", "messageId", "actionTextId", "imageId", "Lkotlin/Function0;", "closeClickListener", "copy", "(Ljava/lang/String;IIILkotlin/jvm/functions/Function0;)Lcom/avito/android/messenger/channels/mvi/view/ChannelsListBannerItem;", "other", "", "contentEquals", "(Lcom/avito/android/messenger/channels/mvi/view/AbstractListItem;)Z", "I", "f", "Lkotlin/jvm/functions/Function0;", "actionClickListener", "getActionClickListener", "()Lkotlin/jvm/functions/Function0;", "setActionClickListener", "(Lkotlin/jvm/functions/Function0;)V", "<init>", "(Ljava/lang/String;IIILkotlin/jvm/functions/Function0;)V", "ViewHolder", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ChannelsListBannerItem extends AbstractListItem<ViewHolder> {
    public Function0<Unit> actionClickListener;
    @JvmField
    public final int actionTextId;
    public final Function0<Unit> f;
    @JvmField
    public final int imageId;
    @JvmField
    public final int messageId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/ChannelsListBannerItem$ViewHolder;", "Leu/davidea/viewholders/FlexibleViewHolder;", "Lcom/avito/android/component/banner_card/BannerCard;", "bannerCard", "Lcom/avito/android/component/banner_card/BannerCard;", "Landroid/content/res/Resources;", "resources", "Landroid/content/res/Resources;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Landroid/view/View;", "view", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "adapter", "<init>", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ViewHolder extends FlexibleViewHolder {
        @JvmField
        @NotNull
        public final BannerCard bannerCard;
        @JvmField
        @NotNull
        public final Context context;
        @JvmField
        @NotNull
        public final Resources resources;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view, @NotNull FlexibleAdapter<?> flexibleAdapter) {
            super(view, flexibleAdapter);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
            this.bannerCard = BannerCard.Companion.create(view);
            Resources resources2 = view.getResources();
            Intrinsics.checkNotNullExpressionValue(resources2, "view.resources");
            this.resources = resources2;
            Context context2 = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "view.context");
            this.context = context2;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelsListBannerItem(@NotNull String str, @StringRes int i, @StringRes int i2, @AttrRes int i3, @NotNull Function0<Unit> function0) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(function0, "closeClickListener");
        this.messageId = i;
        this.actionTextId = i2;
        this.imageId = i3;
        this.f = function0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.avito.android.messenger.channels.mvi.view.ChannelsListBannerItem */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChannelsListBannerItem copy$default(ChannelsListBannerItem channelsListBannerItem, String str, int i, int i2, int i3, Function0 function0, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = channelsListBannerItem.id;
        }
        if ((i4 & 2) != 0) {
            i = channelsListBannerItem.messageId;
        }
        if ((i4 & 4) != 0) {
            i2 = channelsListBannerItem.actionTextId;
        }
        if ((i4 & 8) != 0) {
            i3 = channelsListBannerItem.imageId;
        }
        if ((i4 & 16) != 0) {
            function0 = channelsListBannerItem.f;
        }
        return channelsListBannerItem.copy(str, i, i2, i3, function0);
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    public /* bridge */ /* synthetic */ void bindViewHolder(FlexibleAdapter flexibleAdapter, RecyclerView.ViewHolder viewHolder, int i, List list) {
        bindViewHolder((FlexibleAdapter<?>) flexibleAdapter, (ViewHolder) viewHolder, i, (List<? extends Object>) list);
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem
    public boolean contentEquals(@NotNull AbstractListItem<?> abstractListItem) {
        Intrinsics.checkNotNullParameter(abstractListItem, "other");
        if (this == abstractListItem) {
            return true;
        }
        if (!(abstractListItem instanceof ChannelsListBannerItem) || !super.equals(abstractListItem)) {
            return false;
        }
        ChannelsListBannerItem channelsListBannerItem = (ChannelsListBannerItem) abstractListItem;
        return this.messageId == channelsListBannerItem.messageId && this.actionTextId == channelsListBannerItem.actionTextId && this.imageId == channelsListBannerItem.imageId;
    }

    @NotNull
    public final ChannelsListBannerItem copy(@NotNull String str, @StringRes int i, @StringRes int i2, @AttrRes int i3, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(function0, "closeClickListener");
        return new ChannelsListBannerItem(str, i, i2, i3, function0);
    }

    @NotNull
    public final Function0<Unit> getActionClickListener() {
        Function0<Unit> function0 = this.actionClickListener;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionClickListener");
        }
        return function0;
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    public int getLayoutRes() {
        return R.layout.banner_card;
    }

    public final void setActionClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.actionClickListener = function0;
    }

    public void bindViewHolder(@NotNull FlexibleAdapter<?> flexibleAdapter, @NotNull ViewHolder viewHolder, int i, @NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        BannerCard bannerCard = viewHolder.bannerCard;
        String string = viewHolder.resources.getString(this.messageId);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(messageId)");
        bannerCard.setMessage(string);
        bannerCard.setImage(Contexts.getResourceIdByAttr(viewHolder.context, this.imageId));
        bannerCard.setCloseButtonVisible(true);
        String string2 = viewHolder.resources.getString(this.actionTextId);
        Function0<Unit> function0 = this.actionClickListener;
        if (function0 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("actionClickListener");
        }
        bannerCard.setActions(d.listOf(new BannerCard.Action(string2, function0)));
        bannerCard.setCloseClickListener(this.f);
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    @NotNull
    public ViewHolder createViewHolder(@NotNull View view, @NotNull FlexibleAdapter<?> flexibleAdapter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        return new ViewHolder(view, flexibleAdapter);
    }
}
