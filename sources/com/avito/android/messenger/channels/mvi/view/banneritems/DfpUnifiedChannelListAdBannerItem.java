package com.avito.android.messenger.channels.mvi.view.banneritems;

import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.app.DescriptionPosition;
import com.avito.android.component.ads.dfp.AdDfpUnified;
import com.avito.android.component.ads.dfp.AdDfpUnifiedImpl;
import com.avito.android.messenger.R;
import com.avito.android.messenger.channels.mvi.view.banneritems.ChannelListAdBannerItem;
import com.avito.android.module.serp.adapter.ad.AdEventListenerBridge;
import com.avito.android.module.serp.adapter.ad.dfp.DfpImageLoaderImpl;
import com.avito.android.module.serp.adapter.ad.dfp.DfpUnifiedPresenterKt;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.ad.DfpBanner;
import com.avito.android.serp.ad.DfpBannerKt;
import com.avito.android.serp.adapter.AdBannerEventListener;
import com.avito.android.util.SchedulersFactory3;
import com.facebook.drawee.drawable.ScalingUtils;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u00010B'\u0012\u0006\u0010+\u001a\u00020\u0014\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010*\u001a\u00020'¢\u0006\u0004\b.\u0010/J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J9\u0010\u000e\u001a\u00020\r2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ+\u0010\u0010\u001a\u00020\r2\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J#\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u00172\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u00061"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/banneritems/DfpUnifiedChannelListAdBannerItem;", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem;", "", "getLayoutRes", "()I", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "adapter", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem$ViewHolder;", "holder", VKApiConst.POSITION, "", "", "payloads", "", "bindAd", "(Leu/davidea/flexibleadapter/FlexibleAdapter;Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem$ViewHolder;ILjava/util/List;)V", "unbindViewHolder", "(Leu/davidea/flexibleadapter/FlexibleAdapter;Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem$ViewHolder;I)V", "copy", "()Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem;", "", "toString", "()Ljava/lang/String;", "Landroid/view/View;", "view", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/DfpUnifiedChannelListAdBannerItem$ViewHolder;", "createViewHolder", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)Lcom/avito/android/messenger/channels/mvi/view/banneritems/DfpUnifiedChannelListAdBannerItem$ViewHolder;", "Lcom/avito/android/serp/ad/DfpBanner$DfpUnifiedBanner;", "i", "Lcom/avito/android/serp/ad/DfpBanner$DfpUnifiedBanner;", "banner", "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpImageLoaderImpl;", g.a, "Lcom/avito/android/module/serp/adapter/ad/dfp/DfpImageLoaderImpl;", "dfpImageLoader", "h", "I", "imageOperationId", "Lcom/avito/android/util/SchedulersFactory3;", "j", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "id", "Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "<init>", "(Ljava/lang/String;Lcom/avito/android/serp/ad/DfpBanner$DfpUnifiedBanner;Lcom/avito/android/serp/ad/BannerInfo;Lcom/avito/android/util/SchedulersFactory3;)V", "ViewHolder", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class DfpUnifiedChannelListAdBannerItem extends ChannelListAdBannerItem {
    public final DfpImageLoaderImpl g;
    public int h;
    public final DfpBanner.DfpUnifiedBanner i;
    public final SchedulersFactory3 j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010H\u001a\u00020G\u0012\n\u0010J\u001a\u0006\u0012\u0002\b\u00030I¢\u0006\u0004\bK\u0010LJ\u0010\u0010\u0004\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0003H\u0001¢\u0006\u0004\b\u0007\u0010\u0005J\u001a\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\bH\u0001¢\u0006\u0004\b\r\u0010\u000bJ\u001e\u0010\u0010\u001a\u00020\u00032\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u000eH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\u0015\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\"\u0010\u001b\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001dH\u0001¢\u0006\u0004\b\u001f\u0010 J\"\u0010!\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b!\u0010\u001cJ\"\u0010\"\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b\"\u0010\u001cJ\u0018\u0010%\u001a\u00020\u00032\u0006\u0010$\u001a\u00020#H\u0001¢\u0006\u0004\b%\u0010&J \u0010*\u001a\u00020\u00032\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020#H\u0001¢\u0006\u0004\b*\u0010+J\u0018\u0010.\u001a\u00020\u00032\u0006\u0010-\u001a\u00020,H\u0001¢\u0006\u0004\b.\u0010/J\"\u00100\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\b0\u0010\u001cJ\u001a\u00102\u001a\u00020\u00032\b\u00101\u001a\u0004\u0018\u00010\bH\u0001¢\u0006\u0004\b2\u0010\u000bJ\u0018\u00105\u001a\u00020\u00032\u0006\u00104\u001a\u000203H\u0001¢\u0006\u0004\b5\u00106R\u001c\u0010<\u001a\u0002078\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R*\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000e8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010\u0011R\u001e\u0010F\u001a\u0004\u0018\u00010\u001d8\u0016@\u0016X\u000f¢\u0006\f\u001a\u0004\bC\u0010D\"\u0004\bE\u0010 ¨\u0006M"}, d2 = {"Lcom/avito/android/messenger/channels/mvi/view/banneritems/DfpUnifiedChannelListAdBannerItem$ViewHolder;", "Lcom/avito/android/messenger/channels/mvi/view/banneritems/ChannelListAdBannerItem$ViewHolder;", "Lcom/avito/android/component/ads/dfp/AdDfpUnified;", "", "clearImageData", "()V", "destroy", "hideRating", "", "advertiser", "setAdvertiser", "(Ljava/lang/CharSequence;)V", "callToAction", "setCallToAction", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setDebugListener", "(Lkotlin/jvm/functions/Function0;)V", "description", "Lcom/avito/android/app/DescriptionPosition;", "descriptionPosition", "setDescription", "(Ljava/lang/CharSequence;Lcom/avito/android/app/DescriptionPosition;)V", "Landroid/graphics/drawable/Drawable;", "drawable", "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;", "scaleType", "setFailureDrawable", "(Landroid/graphics/drawable/Drawable;Lcom/facebook/drawee/drawable/ScalingUtils$ScaleType;)V", "Landroid/net/Uri;", "icon", "setIcon", "(Landroid/net/Uri;)V", "setIconFailureDrawable", "setIconPlaceholder", "", "isApplication", "setIsApplication", "(Z)V", "Lcom/google/android/gms/ads/MediaContent;", "mediaContent", "animated", "setMediaContent", "(Lcom/google/android/gms/ads/MediaContent;Z)V", "Lcom/google/android/gms/ads/formats/UnifiedNativeAd;", "nativeAd", "setNativeAd", "(Lcom/google/android/gms/ads/formats/UnifiedNativeAd;)V", "setPlaceholder", "title", "setTitle", "", "rating", "showRating", "(F)V", "", "getImageOperationId", "()I", "setImageOperationId", "(I)V", "imageOperationId", "B", "Lkotlin/jvm/functions/Function0;", "getOnCloseListener", "()Lkotlin/jvm/functions/Function0;", "setOnCloseListener", "onCloseListener", "getImageUri", "()Landroid/net/Uri;", "setImageUri", "imageUri", "Landroid/view/View;", "view", "Leu/davidea/flexibleadapter/FlexibleAdapter;", "adapter", "<init>", "(Landroid/view/View;Leu/davidea/flexibleadapter/FlexibleAdapter;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class ViewHolder extends ChannelListAdBannerItem.ViewHolder implements AdDfpUnified {
        @Nullable
        public Function0<Unit> B;
        public final /* synthetic */ AdDfpUnifiedImpl C;

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
            this.C = new AdDfpUnifiedImpl(view);
            getCloseButton().setOnClickListener(new a(this));
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpUnified
        public void clearImageData() {
            this.C.clearImageData();
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpUnified
        public void destroy() {
            this.C.destroy();
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpUnified
        public int getImageOperationId() {
            return this.C.getImageOperationId();
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpUnified
        @Nullable
        public Uri getImageUri() {
            return this.C.getImageUri();
        }

        @Nullable
        public final Function0<Unit> getOnCloseListener() {
            return this.B;
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpUnified
        public void hideRating() {
            this.C.hideRating();
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpUnified
        public void setAdvertiser(@Nullable CharSequence charSequence) {
            this.C.setAdvertiser(charSequence);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpUnified
        public void setCallToAction(@NotNull CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "callToAction");
            this.C.setCallToAction(charSequence);
        }

        @Override // com.avito.android.design.widget.dfp_debug.DfpDebuggableView
        public void setDebugListener(@NotNull Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.C.setDebugListener(function0);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpUnified
        public void setDescription(@Nullable CharSequence charSequence, @NotNull DescriptionPosition descriptionPosition) {
            Intrinsics.checkNotNullParameter(descriptionPosition, "descriptionPosition");
            this.C.setDescription(charSequence, descriptionPosition);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpUnified
        public void setFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
            Intrinsics.checkNotNullParameter(scaleType, "scaleType");
            this.C.setFailureDrawable(drawable, scaleType);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpUnified
        public void setIcon(@NotNull Uri uri) {
            Intrinsics.checkNotNullParameter(uri, "icon");
            this.C.setIcon(uri);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpUnified
        public void setIconFailureDrawable(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
            Intrinsics.checkNotNullParameter(scaleType, "scaleType");
            this.C.setIconFailureDrawable(drawable, scaleType);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpUnified
        public void setIconPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
            Intrinsics.checkNotNullParameter(scaleType, "scaleType");
            this.C.setIconPlaceholder(drawable, scaleType);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpUnified
        public void setImageOperationId(int i) {
            this.C.setImageOperationId(i);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpUnified
        public void setImageUri(@Nullable Uri uri) {
            this.C.setImageUri(uri);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpUnified
        public void setIsApplication(boolean z) {
            this.C.setIsApplication(z);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpUnified
        public void setMediaContent(@NotNull MediaContent mediaContent, boolean z) {
            Intrinsics.checkNotNullParameter(mediaContent, "mediaContent");
            this.C.setMediaContent(mediaContent, z);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpUnified
        public void setNativeAd(@NotNull UnifiedNativeAd unifiedNativeAd) {
            Intrinsics.checkNotNullParameter(unifiedNativeAd, "nativeAd");
            this.C.setNativeAd(unifiedNativeAd);
        }

        public final void setOnCloseListener(@Nullable Function0<Unit> function0) {
            this.B = function0;
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpUnified
        public void setPlaceholder(@Nullable Drawable drawable, @NotNull ScalingUtils.ScaleType scaleType) {
            Intrinsics.checkNotNullParameter(scaleType, "scaleType");
            this.C.setPlaceholder(drawable, scaleType);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpUnified
        public void setTitle(@Nullable CharSequence charSequence) {
            this.C.setTitle(charSequence);
        }

        @Override // com.avito.android.component.ads.dfp.AdDfpUnified
        public void showRating(float f) {
            this.C.showRating(f);
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ DfpUnifiedChannelListAdBannerItem a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(DfpUnifiedChannelListAdBannerItem dfpUnifiedChannelListAdBannerItem) {
            super(0);
            this.a = dfpUnifiedChannelListAdBannerItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.onAdClosed();
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Lazy<AdBannerEventListener> {
        public final /* synthetic */ DfpUnifiedChannelListAdBannerItem a;

        public b(DfpUnifiedChannelListAdBannerItem dfpUnifiedChannelListAdBannerItem) {
            this.a = dfpUnifiedChannelListAdBannerItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // dagger.Lazy
        public AdBannerEventListener get() {
            return new DfpUnifiedChannelListAdBannerItem$bindAd$2$1(this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DfpUnifiedChannelListAdBannerItem(@NotNull String str, @NotNull DfpBanner.DfpUnifiedBanner dfpUnifiedBanner, @NotNull BannerInfo bannerInfo, @NotNull SchedulersFactory3 schedulersFactory3) {
        super(str, bannerInfo);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(dfpUnifiedBanner, "banner");
        Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.i = dfpUnifiedBanner;
        this.j = schedulersFactory3;
        this.g = new DfpImageLoaderImpl(schedulersFactory3);
    }

    @Override // com.avito.android.messenger.channels.mvi.view.banneritems.ChannelListAdBannerItem
    public void bindAd(@NotNull FlexibleAdapter<?> flexibleAdapter, @NotNull ChannelListAdBannerItem.ViewHolder viewHolder, int i2, @NotNull List<? extends Object> list) {
        Uri uri;
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        if (viewHolder instanceof ViewHolder) {
            View view = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
            Context context = view.getContext();
            UnifiedNativeAd ad = this.i.getAd();
            boolean isApplicationAd = DfpBannerKt.isApplicationAd(ad);
            ViewHolder viewHolder2 = (ViewHolder) viewHolder;
            viewHolder2.setIsApplication(isApplicationAd);
            viewHolder2.setTitle(ad.getHeadline());
            viewHolder2.setDescription(ad.getBody(), new DescriptionPosition.Top());
            viewHolder2.setAdvertiser(ad.getAdvertiser());
            String callToAction = ad.getCallToAction();
            Intrinsics.checkNotNullExpressionValue(callToAction, "ad.callToAction");
            viewHolder2.setCallToAction(callToAction);
            viewHolder2.setOnCloseListener(new a(this));
            this.h = 0;
            if (isApplicationAd) {
                int i3 = R.drawable.img_item_placeholder_48_40;
                Drawable drawable = context.getDrawable(i3);
                ScalingUtils.ScaleType scaleType = ScalingUtils.ScaleType.CENTER;
                Intrinsics.checkNotNullExpressionValue(scaleType, "ScalingUtils.ScaleType.CENTER");
                viewHolder2.setIconPlaceholder(drawable, scaleType);
                Drawable drawable2 = context.getDrawable(i3);
                Intrinsics.checkNotNullExpressionValue(scaleType, "ScalingUtils.ScaleType.CENTER");
                viewHolder2.setIconFailureDrawable(drawable2, scaleType);
                NativeAd.Image icon = ad.getIcon();
                if (icon == null || (uri = icon.getUri()) == null) {
                    uri = Uri.EMPTY;
                }
                Intrinsics.checkNotNullExpressionValue(uri, "ad.icon?.uri ?: Uri.EMPTY");
                viewHolder2.setIcon(uri);
            } else {
                int i4 = R.drawable.img_item_placeholder_48_40;
                Drawable drawable3 = context.getDrawable(i4);
                ScalingUtils.ScaleType scaleType2 = ScalingUtils.ScaleType.CENTER;
                Intrinsics.checkNotNullExpressionValue(scaleType2, "ScalingUtils.ScaleType.CENTER");
                viewHolder2.setPlaceholder(drawable3, scaleType2);
                Drawable drawable4 = context.getDrawable(i4);
                Intrinsics.checkNotNullExpressionValue(scaleType2, "ScalingUtils.ScaleType.CENTER");
                viewHolder2.setFailureDrawable(drawable4, scaleType2);
                this.h = DfpUnifiedPresenterKt.bindMedia(this.g, ad, (AdDfpUnified) viewHolder);
            }
            viewHolder2.setNativeAd(ad);
            this.i.getAdEventListenerHolder().setAdEventListener(new AdEventListenerBridge(new b(this), getBannerInfo(), i2));
        }
    }

    @Override // com.avito.android.messenger.channels.mvi.view.banneritems.ChannelListAdBannerItem
    @NotNull
    public ChannelListAdBannerItem copy() {
        return new DfpUnifiedChannelListAdBannerItem(this.id, this.i, getBannerInfo(), this.j);
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    public int getLayoutRes() {
        return R.layout.chat_list_dfp_unified_item;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("DfpUnifiedChannelListAdBannerItem(\n            |   banner = ");
        L.append(this.i.getAd().getHeadline());
        L.append("\n            |)");
        return f.trimMargin$default(L.toString(), null, 1, null);
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    public /* bridge */ /* synthetic */ void unbindViewHolder(FlexibleAdapter flexibleAdapter, RecyclerView.ViewHolder viewHolder, int i2) {
        unbindViewHolder((FlexibleAdapter<?>) flexibleAdapter, (ChannelListAdBannerItem.ViewHolder) viewHolder, i2);
    }

    @Override // com.avito.android.messenger.channels.mvi.view.AbstractListItem, eu.davidea.flexibleadapter.items.IFlexible
    @NotNull
    public ViewHolder createViewHolder(@NotNull View view, @NotNull FlexibleAdapter<?> flexibleAdapter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        return new ViewHolder(view, flexibleAdapter);
    }

    public void unbindViewHolder(@NotNull FlexibleAdapter<?> flexibleAdapter, @NotNull ChannelListAdBannerItem.ViewHolder viewHolder, int i2) {
        Intrinsics.checkNotNullParameter(flexibleAdapter, "adapter");
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        super.unbindViewHolder(flexibleAdapter, (FlexibleAdapter<?>) viewHolder, i2);
        this.g.cancel(this.h);
        MediaContent mediaContent = this.i.getAd().getMediaContent();
        Intrinsics.checkNotNullExpressionValue(mediaContent, "banner.ad.mediaContent");
        mediaContent.setMainImage(null);
        if (viewHolder instanceof ViewHolder) {
            ((ViewHolder) viewHolder).clearImageData();
        }
    }
}
