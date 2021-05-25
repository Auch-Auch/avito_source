package com.avito.android.messenger.channels.mvi.view.banneritems;

import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import com.avito.android.app.DescriptionPosition;
import com.avito.android.component.ads.dfp.AdDfpAppInstall;
import com.avito.android.component.ads.dfp.AdDfpAppInstallImpl;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.mvi.view.banneritems.ChannelListAdBannerItem;
import com.avito.android.module.serp.adapter.ad.AdEventListenerBridge;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.ad.DfpBanner;
import com.avito.android.serp.adapter.AdBannerEventListener;
import com.facebook.drawee.drawable.ScalingUtils;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001#B\u001f\u0012\u0006\u0010\u001e\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J9\u0010\u000e\u001a\u00020\r2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00152\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006$"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/banneritems/DfpAppInstallChannelListAdBannerItem;", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem;", "", "getLayoutRes", "()I", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "adapter", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem$ViewHolder;", "holder", VKApiConst.POSITION, "", "", "payloads", "", "bindAd", "(Leu/davidea/flexibleadapter/FlexibleAdapter;Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem$ViewHolder;ILjava/util/List;)V", "copy", "()Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem;", "", "toString", "()Ljava/lang/String;", "Landroid/view/View;", "view", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/DfpAppInstallChannelListAdBannerItem$ViewHolder;", "createViewHolder", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)Lcom/avito/android/messenger/channels/mvi/view/banneritems/DfpAppInstallChannelListAdBannerItem$ViewHolder;", "Lcom/avito/android/serp/ad/DfpBanner$DfpAppInstallBanner;", g.a, "Lcom/avito/android/serp/ad/DfpBanner$DfpAppInstallBanner;", "banner", "id", "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "<init>", "(Ljava/lang/String;Lcom/avito/android/serp/ad/DfpBanner$DfpAppInstallBanner;Lcom/avito/android/serp/ad/BannerInfo;)V", "ViewHolder", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class DfpAppInstallChannelListAdBannerItem extends ChannelListAdBannerItem {
    public final DfpBanner.DfpAppInstallBanner g;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u00104\u001a\u000203\u0012\n\u00106\u001a\u0006\u0012\u0002\b\u000305¢\u0006\u0004\b7\u00108J\u0010\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0006\u0010\u0005J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0001¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\r\u001a\u00020\u00032\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0001¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u0012\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\u0018\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\"\u0010\u001e\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u001e\u0010\u0019J\"\u0010\u001f\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u001f\u0010\u0019J\u0018\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001aH\u0001¢\u0006\u0004\b!\u0010\u001dJ\u0018\u0010$\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\"H\u0001¢\u0006\u0004\b$\u0010%J\"\u0010&\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b&\u0010\u0019J\u001a\u0010(\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b(\u0010\nJ\u0018\u0010+\u001a\u00020\u00032\u0006\u0010*\u001a\u00020)H\u0001¢\u0006\u0004\b+\u0010,R*\u00102\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u0010\u000e¨\u00069"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/banneritems/DfpAppInstallChannelListAdBannerItem$ViewHolder;", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem$ViewHolder;", "Lcom/avito/android/component/ads/dfp/AdDfpAppInstall;", "", "destroy", "()V", "hideRating", "", "callToAction", "setCallToAction", "(Ljava/lang/CharSequence;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDebugListener", "(Lkotlin/jvm/functions/Function0;)V", "description", "Lcom/avito/android/app/DescriptionPosition;", "descriptionPosition", "setDescription", "(Ljava/lang/CharSequence;Lcom/avito/android/app/DescriptionPosition;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "scaleType", "setFailureDrawable", "(Landroid/graphics/drawable/Drawable;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V", "Landroid/net/Uri;", "icon", "setIcon", "(Landroid/net/Uri;)V", "setIconFailureDrawable", "setIconPlaceholder", "image", "setImage", "Lcom/google/android/gms/ads/formats/NativeAppInstallAd;", "nativeAd", "setNativeAd", "(Lcom/google/android/gms/ads/formats/NativeAppInstallAd;)V", "setPlaceholder", "title", "setTitle", "", "rating", "showRating", "(F)V", "B", "Lkotlin/jvm/functions/Function0;", "getOnCloseListener", "()Lkotlin/jvm/functions/Function0;", "setOnCloseListener", "onCloseListener", "Landroid/view/View;", "view", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "adapter", "<init>", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ViewHolder extends ChannelListAdBannerItem.ViewHolder implements AdDfpAppInstall {
        @Nullable
        public Function0<Unit> B;
        public final /* synthetic */ AdDfpAppInstallImpl C;

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
            this.C = new AdDfpAppInstallImpl(view);
            getCloseButton().setOnClickListener(new a(this));
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
        public void destroy() {
            this.C.destroy();
        }

        @Nullable
        public final Function0<Unit> getOnCloseListener() {
            return this.B;
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
        public void hideRating() {
            this.C.hideRating();
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
        public void setCallToAction(@NotNull CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "callToAction");
            this.C.setCallToAction(charSequence);
        }

        @Override // com.avito.android.design.widget.dfp_debug.DfpDebuggableView
        public void setDebugListener(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.C.setDebugListener(function0);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
        public void setDescription(@Nullable CharSequence charSequence, @NotNull DescriptionPosition descriptionPosition) {
            Intrinsics.checkNotNullParameter(descriptionPosition, "descriptionPosition");
            this.C.setDescription(charSequence, descriptionPosition);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
        public void setFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
            Intrinsics.checkNotNullParameter(scaleType, "scaleType");
            this.C.setFailureDrawable(drawable, scaleType);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
        public void setIcon(@NotNull Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "icon");
            this.C.setIcon(uri);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
        public void setIconFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
            Intrinsics.checkNotNullParameter(scaleType, "scaleType");
            this.C.setIconFailureDrawable(drawable, scaleType);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
        public void setIconPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
            Intrinsics.checkNotNullParameter(scaleType, "scaleType");
            this.C.setIconPlaceholder(drawable, scaleType);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
        public void setImage(@NotNull Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "image");
            this.C.setImage(uri);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
        public void setNativeAd(@NotNull NativeAppInstallAd nativeAppInstallAd) {
            Intrinsics.checkNotNullParameter(nativeAppInstallAd, "nativeAd");
            this.C.setNativeAd(nativeAppInstallAd);
        }

        public final void setOnCloseListener(@Nullable Function0<Unit> function0) {
            this.B = function0;
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
        public void setPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
            Intrinsics.checkNotNullParameter(scaleType, "scaleType");
            this.C.setPlaceholder(drawable, scaleType);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
        public void setTitle(@Nullable CharSequence charSequence) {
            this.C.setTitle(charSequence);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpAppInstall
        public void showRating(float f) {
            this.C.showRating(f);
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ DfpAppInstallChannelListAdBannerItem a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DfpAppInstallChannelListAdBannerItem dfpAppInstallChannelListAdBannerItem) {
            super(0);
            this.a = dfpAppInstallChannelListAdBannerItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.onAdClosed();
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Lazy<AdBannerEventListener> {
        public final /* synthetic */ DfpAppInstallChannelListAdBannerItem a;

        public b(DfpAppInstallChannelListAdBannerItem dfpAppInstallChannelListAdBannerItem) {
            this.a = dfpAppInstallChannelListAdBannerItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // dagger.Lazy
        public AdBannerEventListener get() {
            return new DfpAppInstallChannelListAdBannerItem$bindAd$2$1(this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DfpAppInstallChannelListAdBannerItem(@NotNull String str, @NotNull DfpBanner.DfpAppInstallBanner dfpAppInstallBanner, @NotNull BannerInfo bannerInfo) {
        super(str, bannerInfo);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(dfpAppInstallBanner, "banner");
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        this.g = dfpAppInstallBanner;
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
            NativeAppInstallAd appInstallAd = this.g.getAppInstallAd();
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            viewHolder2.setNativeAd(appInstallAd);
            viewHolder2.setTitle(appInstallAd.getHeadline());
            viewHolder2.setDescription(appInstallAd.getBody(), new DescriptionPosition.Top());
            NativeAd.Image icon = appInstallAd.getIcon();
            if (icon == null || (uri = icon.getUri()) == null) {
                uri = Uri.EMPTY;
            }
            Intrinsics.checkNotNullExpressionValue(uri, "ad.icon?.uri ?: Uri.EMPTY");
            viewHolder2.setIcon(uri);
            int i2 = R.drawable.img_item_placeholder_48_40;
            Drawable drawable = context.getDrawable(i2);
            ScalingUtils.ScaleType scaleType = ScalingUtils.ScaleType.CENTER;
            Intrinsics.checkNotNullExpressionValue(scaleType, "ScalingUtils.ScaleType.CENTER");
            viewHolder2.setIconPlaceholder(drawable, scaleType);
            Drawable drawable2 = context.getDrawable(i2);
            Intrinsics.checkNotNullExpressionValue(scaleType, "ScalingUtils.ScaleType.CENTER");
            viewHolder2.setIconFailureDrawable(drawable2, scaleType);
            CharSequence callToAction = appInstallAd.getCallToAction();
            Intrinsics.checkNotNullExpressionValue(callToAction, "ad.callToAction");
            viewHolder2.setCallToAction(callToAction);
            viewHolder2.setOnCloseListener(new a(this));
            this.g.getAdEventListenerHolder().setAdEventListener(new AdEventListenerBridge(new b(this), getBannerInfo(), i));
        }
    }

    @Override // com.avito.android.messenger.channels.mvi.view.banneritems.ChannelListAdBannerItem
    @NotNull
    public ChannelListAdBannerItem copy() {
        return new DfpAppInstallChannelListAdBannerItem(this.id, this.g, getBannerInfo());
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    public int getLayoutRes() {
        return R.layout.chat_list_dfp_app_install_item;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("DfpAppInstallChannelListAdBannerItem(\n            |   banner = ");
        L.append(this.g.getAppInstallAd().getHeadline());
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
