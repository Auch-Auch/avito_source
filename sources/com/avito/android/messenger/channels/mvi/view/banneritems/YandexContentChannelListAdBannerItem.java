package com.avito.android.messenger.channels.mvi.view.banneritems;

import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.component.ads.yandex.AdYandexContent;
import com.avito.android.component.ads.yandex.AdYandexContentImpl;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.mvi.view.banneritems.ChannelListAdBannerItem;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.ad.YandexContentBanner;
import com.vk.sdk.api.VKApiConst;
import com.yandex.mobile.ads.nativeads.NativeContentAd;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001%B\u001f\u0012\u0006\u0010 \u001a\u00020\u0014\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J9\u0010\u000e\u001a\u00020\r2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0010\u001a\u00020\r2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00172\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006&"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/banneritems/YandexContentChannelListAdBannerItem;", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem;", "", "getLayoutRes", "()I", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "adapter", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem$ViewHolder;", "holder", VKApiConst.POSITION, "", "", "payloads", "", "bindAd", "(Leu/davidea/flexibleadapter/FlexibleAdapter;Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem$ViewHolder;ILjava/util/List;)V", "unbindViewHolder", "(Leu/davidea/flexibleadapter/FlexibleAdapter;Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem$ViewHolder;I)V", "copy", "()Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem;", "", "toString", "()Ljava/lang/String;", "Landroid/view/View;", "view", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/YandexContentChannelListAdBannerItem$ViewHolder;", "createViewHolder", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)Lcom/avito/android/messenger/channels/mvi/view/banneritems/YandexContentChannelListAdBannerItem$ViewHolder;", "Lcom/avito/android/serp/ad/YandexContentBanner;", g.a, "Lcom/avito/android/serp/ad/YandexContentBanner;", "banner", "id", "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "<init>", "(Ljava/lang/String;Lcom/avito/android/serp/ad/YandexContentBanner;Lcom/avito/android/serp/ad/BannerInfo;)V", "ViewHolder", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class YandexContentChannelListAdBannerItem extends ChannelListAdBannerItem {
    public final YandexContentBanner g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010\u0011\u001a\u00020\u001b\u0012\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001c¢\u0006\u0004\b\u001e\u0010\u001fJD\u0010\f\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\t2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0005H\u0001¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/banneritems/YandexContentChannelListAdBannerItem$ViewHolder;", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem$ViewHolder;", "Lcom/avito/android/component/ads/yandex/AdYandexContent;", "Lcom/yandex/mobile/ads/nativeads/NativeContentAd;", "nativeAd", "", "isClose", "isRedesign", "Lkotlin/Function0;", "", "closeListener", "openListener", "bindAd", "(Lcom/yandex/mobile/ads/nativeads/NativeContentAd;ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "hasImage", "()Z", "Landroid/widget/Button;", "view", "setFeedbackView", "(Landroid/widget/Button;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setImage", "(Landroid/graphics/drawable/Drawable;)V", "clipToOutline", "setImageClipToOutline", "(Z)V", "Landroid/view/View;", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "adapter", "<init>", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ViewHolder extends ChannelListAdBannerItem.ViewHolder implements AdYandexContent {
        public final /* synthetic */ AdYandexContentImpl B;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view, @NotNull FlexibleAdapter<?> flexibleAdapter) {
            super(ChannelListAdBannerItem.Companion.createSwipableContainer(view), flexibleAdapter);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
            this.B = new AdYandexContentImpl(view);
        }

        @Override // com.avito.android.component.ads.yandex.AdYandexContent
        public void bindAd(@NotNull NativeContentAd nativeContentAd, boolean z, boolean z2, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
            Intrinsics.checkNotNullParameter(nativeContentAd, "nativeAd");
            Intrinsics.checkNotNullParameter(function0, "closeListener");
            Intrinsics.checkNotNullParameter(function02, "openListener");
            this.B.bindAd(nativeContentAd, z, z2, function0, function02);
        }

        @Override // com.avito.android.component.ads.yandex.AdYandexContent
        public boolean hasImage() {
            return this.B.hasImage();
        }

        @Override // com.avito.android.component.ads.yandex.AdYandexContent
        public void setFeedbackView(@NotNull Button button) {
            Intrinsics.checkNotNullParameter(button, "view");
            this.B.setFeedbackView(button);
        }

        @Override // com.avito.android.component.ads.yandex.AdYandexContent
        public void setImage(@Nullable Drawable drawable) {
            this.B.setImage(drawable);
        }

        @Override // com.avito.android.component.ads.yandex.AdYandexContent
        public void setImageClipToOutline(boolean z) {
            this.B.setImageClipToOutline(z);
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ YandexContentChannelListAdBannerItem a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(YandexContentChannelListAdBannerItem yandexContentChannelListAdBannerItem) {
            super(0);
            this.a = yandexContentChannelListAdBannerItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.onAdClosed();
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ YandexContentChannelListAdBannerItem a;
        public final /* synthetic */ int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(YandexContentChannelListAdBannerItem yandexContentChannelListAdBannerItem, int i) {
            super(0);
            this.a = yandexContentChannelListAdBannerItem;
            this.b = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.onAdOpened(this.b);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public YandexContentChannelListAdBannerItem(@NotNull String str, @NotNull YandexContentBanner yandexContentBanner, @NotNull BannerInfo bannerInfo) {
        super(str, bannerInfo);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(yandexContentBanner, "banner");
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        this.g = yandexContentBanner;
    }

    @Override // com.avito.android.messenger.channels.mvi.view.banneritems.ChannelListAdBannerItem
    public void bindAd(@NotNull FlexibleAdapter<?> flexibleAdapter, @NotNull ChannelListAdBannerItem.ViewHolder viewHolder, int i, @NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        if (viewHolder instanceof ViewHolder) {
            View view = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            Context context = view.getContext();
            NativeContentAd nativeContentAd = (NativeContentAd) this.g.getAd();
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            if (!viewHolder2.hasImage()) {
                viewHolder2.setImage(context.getDrawable(R.drawable.img_item_placeholder_48_40));
            }
            viewHolder2.setFeedbackView(viewHolder.getCloseButton());
            viewHolder2.setImageClipToOutline(true);
            viewHolder2.bindAd(nativeContentAd, false, false, new a(this), new b(this, i));
        }
    }

    @Override // com.avito.android.messenger.channels.mvi.view.banneritems.ChannelListAdBannerItem
    @NotNull
    public ChannelListAdBannerItem copy() {
        return new YandexContentChannelListAdBannerItem(this.id, this.g, getBannerInfo());
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    public int getLayoutRes() {
        return R.layout.chat_list_yandex_content_item;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("YandexContentChannelListAdBannerItem(\n            |   banner = ");
        L.append(((NativeContentAd) this.g.getAd()).getInfo());
        L.append("\n            |)");
        return f.trimMargin$default(L.toString(), null, 1, null);
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    public /* bridge */ /* synthetic */ void unbindViewHolder(FlexibleAdapter flexibleAdapter, RecyclerView.ViewHolder viewHolder, int i) {
        unbindViewHolder((FlexibleAdapter<?>) flexibleAdapter, (ChannelListAdBannerItem.ViewHolder) viewHolder, i);
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    @NotNull
    public ViewHolder createViewHolder(@NotNull View view, @NotNull FlexibleAdapter<?> flexibleAdapter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        return new ViewHolder(view, flexibleAdapter);
    }

    public void unbindViewHolder(@NotNull FlexibleAdapter<?> flexibleAdapter, @NotNull ChannelListAdBannerItem.ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        super.unbindViewHolder(flexibleAdapter, (FlexibleAdapter<?>) viewHolder, i);
        if (viewHolder instanceof ViewHolder) {
            ((ViewHolder) viewHolder).setImage(null);
        }
    }
}
