package com.avito.android.messenger.channels.mvi.view.banneritems;

import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.avito.android.app.DescriptionPosition;
import com.avito.android.component.ads.dfp.AdDfpContent;
import com.avito.android.component.ads.dfp.AdDfpContentImpl;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.mvi.view.banneritems.ChannelListAdBannerItem;
import com.avito.android.module.serp.adapter.ad.AdEventListenerBridge;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.ad.DfpBanner;
import com.avito.android.serp.adapter.AdBannerEventListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001#B\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J9\u0010\u000e\u001a\u00020\r2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00152\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006$"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/banneritems/DfpContentChannelListAdBannerItem;", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem;", "", "getLayoutRes", "()I", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "adapter", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem$ViewHolder;", "holder", VKApiConst.POSITION, "", "", "payloads", "", "bindAd", "(Leu/davidea/flexibleadapter/FlexibleAdapter;Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem$ViewHolder;ILjava/util/List;)V", "copy", "()Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem;", "", "toString", "()Ljava/lang/String;", "Landroid/view/View;", "view", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/DfpContentChannelListAdBannerItem$ViewHolder;", "createViewHolder", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)Lcom/avito/android/messenger/channels/mvi/view/banneritems/DfpContentChannelListAdBannerItem$ViewHolder;", "Lcom/avito/android/serp/ad/DfpBanner$DfpContentBanner;", g.a, "Lcom/avito/android/serp/ad/DfpBanner$DfpContentBanner;", "banner", "id", "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "<init>", "(Ljava/lang/String;Lcom/avito/android/serp/ad/DfpBanner$DfpContentBanner;Lcom/avito/android/serp/ad/BannerInfo;)V", "ViewHolder", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class DfpContentChannelListAdBannerItem extends ChannelListAdBannerItem {
    public final DfpBanner.DfpContentBanner g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010-\u001a\u00020,\u0012\n\u0010/\u001a\u0006\u0012\u0002\b\u00030.¢\u0006\u0004\b0\u00101J\u0010\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0001¢\u0006\u0004\b\u000b\u0010\tJ\u001e\u0010\u000e\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ \u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u0019\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001fH\u0001¢\u0006\u0004\b!\u0010\"J\"\u0010#\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0001¢\u0006\u0004\b#\u0010\u001aJ\u0018\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0006H\u0001¢\u0006\u0004\b%\u0010\tR*\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\u000f¨\u00062"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/banneritems/DfpContentChannelListAdBannerItem$ViewHolder;", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem$ViewHolder;", "Lcom/avito/android/component/ads/dfp/AdDfpContent;", "", "destroy", "()V", "", "advertiser", "setAdvertiser", "(Ljava/lang/CharSequence;)V", "callToAction", "setCallToAction", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDebugListener", "(Lkotlin/jvm/functions/Function0;)V", "description", "Lcom/avito/android/app/DescriptionPosition;", "descriptionPosition", "setDescription", "(Ljava/lang/CharSequence;Lcom/avito/android/app/DescriptionPosition;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "scaleType", "setFailureDrawable", "(Landroid/graphics/drawable/Drawable;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V", "Landroid/net/Uri;", "imageUri", "setImage", "(Landroid/net/Uri;)V", "Lcom/google/android/gms/ads/formats/NativeContentAd;", "ad", "setNativeAd", "(Lcom/google/android/gms/ads/formats/NativeContentAd;)V", "setPlaceholder", "title", "setTitle", "B", "Lkotlin/jvm/functions/Function0;", "getOnCloseListener", "()Lkotlin/jvm/functions/Function0;", "setOnCloseListener", "onCloseListener", "Landroid/view/View;", "view", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "adapter", "<init>", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ViewHolder extends ChannelListAdBannerItem.ViewHolder implements AdDfpContent {
        @Nullable
        public Function0<Unit> B;
        public final /* synthetic */ AdDfpContentImpl C;

        public static final class a implements View.OnClickListener {
            public final /* synthetic */ ViewHolder a;

            public a(ViewHolder viewHolder) {
                this.a = viewHolder;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function0<Unit> onCloseListener = this.a.getOnCloseListener();
                if (onCloseListener != null) {
                    onCloseListener.invoke();
                }
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view, @NotNull FlexibleAdapter<?> flexibleAdapter) {
            super(ChannelListAdBannerItem.Companion.createSwipableContainer(view), flexibleAdapter);
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
            this.C = new AdDfpContentImpl(view);
            getCloseButton().setOnClickListener(new a(this));
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpContent
        public void destroy() {
            this.C.destroy();
        }

        @Nullable
        public final Function0<Unit> getOnCloseListener() {
            return this.B;
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpContent
        public void setAdvertiser(@Nullable CharSequence charSequence) {
            this.C.setAdvertiser(charSequence);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpContent
        public void setCallToAction(@Nullable CharSequence charSequence) {
            this.C.setCallToAction(charSequence);
        }

        @Override // com.avito.android.design.widget.dfp_debug.DfpDebuggableView
        public void setDebugListener(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.C.setDebugListener(function0);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpContent
        public void setDescription(@NotNull CharSequence charSequence, @NotNull DescriptionPosition descriptionPosition) {
            Intrinsics.checkNotNullParameter(charSequence, "description");
            Intrinsics.checkNotNullParameter(descriptionPosition, "descriptionPosition");
            this.C.setDescription(charSequence, descriptionPosition);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpContent
        public void setFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
            Intrinsics.checkNotNullParameter(scaleType, "scaleType");
            this.C.setFailureDrawable(drawable, scaleType);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpContent
        public void setImage(@NotNull Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "imageUri");
            this.C.setImage(uri);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpContent
        public void setNativeAd(@NotNull NativeContentAd nativeContentAd) {
            Intrinsics.checkNotNullParameter(nativeContentAd, "ad");
            this.C.setNativeAd(nativeContentAd);
        }

        public final void setOnCloseListener(@Nullable Function0<Unit> function0) {
            this.B = function0;
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpContent
        public void setPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
            Intrinsics.checkNotNullParameter(scaleType, "scaleType");
            this.C.setPlaceholder(drawable, scaleType);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpContent
        public void setTitle(@NotNull CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "title");
            this.C.setTitle(charSequence);
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ DfpContentChannelListAdBannerItem a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DfpContentChannelListAdBannerItem dfpContentChannelListAdBannerItem) {
            super(0);
            this.a = dfpContentChannelListAdBannerItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.onAdClosed();
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Lazy<AdBannerEventListener> {
        public final /* synthetic */ DfpContentChannelListAdBannerItem a;

        public b(DfpContentChannelListAdBannerItem dfpContentChannelListAdBannerItem) {
            this.a = dfpContentChannelListAdBannerItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // dagger.Lazy
        public AdBannerEventListener get() {
            return new DfpContentChannelListAdBannerItem$bindAd$2$1(this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DfpContentChannelListAdBannerItem(@NotNull String str, @NotNull DfpBanner.DfpContentBanner dfpContentBanner, @NotNull BannerInfo bannerInfo) {
        super(str, bannerInfo);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(dfpContentBanner, "banner");
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        this.g = dfpContentBanner;
    }

    @Override // com.avito.android.messenger.channels.mvi.view.banneritems.ChannelListAdBannerItem
    public void bindAd(@NotNull FlexibleAdapter<?> flexibleAdapter, @NotNull ChannelListAdBannerItem.ViewHolder viewHolder, int i, @NotNull List<? extends Object> list) {
        Uri uri;
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        if (viewHolder instanceof ViewHolder) {
            View view = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            Context context = view.getContext();
            NativeContentAd contentAd = this.g.getContentAd();
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            viewHolder2.setNativeAd(contentAd);
            CharSequence headline = contentAd.getHeadline();
            Intrinsics.checkNotNullExpressionValue(headline, "ad.headline");
            viewHolder2.setTitle(headline);
            CharSequence body = contentAd.getBody();
            Intrinsics.checkNotNullExpressionValue(body, "ad.body");
            viewHolder2.setDescription(body, new DescriptionPosition.Top());
            int i2 = R.drawable.img_item_placeholder_48_40;
            Drawable drawable = context.getDrawable(i2);
            ScalingUtils.ScaleType scaleType = ScalingUtils.ScaleType.CENTER;
            Intrinsics.checkNotNullExpressionValue(scaleType, "ScalingUtils.ScaleType.CENTER");
            viewHolder2.setPlaceholder(drawable, scaleType);
            Drawable drawable2 = context.getDrawable(i2);
            Intrinsics.checkNotNullExpressionValue(scaleType, "ScalingUtils.ScaleType.CENTER");
            viewHolder2.setFailureDrawable(drawable2, scaleType);
            List<NativeAd.Image> images = contentAd.getImages();
            Intrinsics.checkNotNullExpressionValue(images, "ad.images");
            NativeAd.Image image = (NativeAd.Image) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) images);
            if (image == null || (uri = image.getUri()) == null) {
                uri = Uri.EMPTY;
            }
            Intrinsics.checkNotNullExpressionValue(uri, "ad.images.firstOrNull()?.uri ?: Uri.EMPTY");
            viewHolder2.setImage(uri);
            viewHolder2.setAdvertiser(contentAd.getAdvertiser());
            viewHolder2.setCallToAction(contentAd.getCallToAction());
            viewHolder2.setOnCloseListener(new a(this));
            this.g.getAdEventListenerHolder().setAdEventListener(new AdEventListenerBridge(new b(this), getBannerInfo(), i));
        }
    }

    @Override // com.avito.android.messenger.channels.mvi.view.banneritems.ChannelListAdBannerItem
    @NotNull
    public ChannelListAdBannerItem copy() {
        return new DfpContentChannelListAdBannerItem(this.id, this.g, getBannerInfo());
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    public int getLayoutRes() {
        return R.layout.chat_list_dfp_content_item;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("DfpContentChannelListAdBannerItem(\n            |   banner = ");
        L.append(this.g.getContentAd().getHeadline());
        L.append("\n            |)");
        return f.trimMargin$default(L.toString(), null, 1, null);
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    @NotNull
    public ViewHolder createViewHolder(@NotNull View view, @NotNull FlexibleAdapter<?> flexibleAdapter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        return new ViewHolder(view, flexibleAdapter);
    }
}
