package com.avito.android.serp.adapter.advert_xl;

import android.net.Uri;
import android.view.View;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.expected.badge_bar.BadgeViewListener;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.badge.Badge;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.avito.android.serp.BaseSerpViewHolder;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.PhoneLoadingState;
import ru.avito.component.serp.SerpAdvertXlCard;
import ru.avito.component.serp.SerpAdvertXlCardImpl;
import ru.avito.component.serp.SerpItemViewConfig;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0017\u0012\u0006\u0010f\u001a\u00020e\u0012\u0006\u0010h\u001a\u00020g¢\u0006\u0004\bi\u0010jJ\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J*\u0010\f\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u000e\u0010\u0006J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0014\u0010\u0006J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001e\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H\u0001¢\u0006\u0004\b\u001e\u0010\u001cJ\u0018\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0001¢\u0006\u0004\b!\u0010\"J \u0010%\u001a\u00020\u00042\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010#H\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010(\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010\u0019H\u0001¢\u0006\u0004\b(\u0010\u001cJ\u001a\u0010*\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u0019H\u0001¢\u0006\u0004\b*\u0010\u001cJ \u0010+\u001a\u00020\u00042\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010#H\u0001¢\u0006\u0004\b+\u0010&J \u0010/\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\u0015H\u0001¢\u0006\u0004\b/\u00100J\u001a\u00102\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u0019H\u0001¢\u0006\u0004\b2\u0010\u001cJ\u0018\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0015H\u0001¢\u0006\u0004\b4\u0010\u0018J\u001a\u00106\u001a\u00020\u00042\b\u00105\u001a\u0004\u0018\u00010\u0019H\u0001¢\u0006\u0004\b6\u0010\u001cJ\u0018\u00108\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u0015H\u0001¢\u0006\u0004\b8\u0010\u0018J\u0018\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u0015H\u0001¢\u0006\u0004\b:\u0010\u0018J\u0018\u0010<\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u0015H\u0001¢\u0006\u0004\b<\u0010\u0018J\u001a\u0010>\u001a\u00020\u00042\b\u0010=\u001a\u0004\u0018\u00010\u0019H\u0001¢\u0006\u0004\b>\u0010\u001cJ$\u0010@\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u00192\b\u0010?\u001a\u0004\u0018\u00010\u0019H\u0001¢\u0006\u0004\b@\u0010AJ \u0010B\u001a\u00020\u00042\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010#H\u0001¢\u0006\u0004\bB\u0010&J\u0018\u0010E\u001a\u00020\u00042\u0006\u0010D\u001a\u00020CH\u0001¢\u0006\u0004\bE\u0010FJ&\u0010H\u001a\u00020\u00042\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0004\u0018\u00010GH\u0001¢\u0006\u0004\bH\u0010IJ\u001e\u0010K\u001a\u00020\u00042\f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0007H\u0001¢\u0006\u0004\bK\u0010LJ\"\u0010O\u001a\u00020\u00042\b\u0010M\u001a\u0004\u0018\u00010\u00192\u0006\u0010N\u001a\u00020\u0015H\u0001¢\u0006\u0004\bO\u0010PJ\u001a\u0010R\u001a\u00020\u00042\b\u0010Q\u001a\u0004\u0018\u00010\u0019H\u0001¢\u0006\u0004\bR\u0010\u001cJ\u001a\u0010T\u001a\u00020\u00042\b\u0010S\u001a\u0004\u0018\u00010\u0019H\u0001¢\u0006\u0004\bT\u0010\u001cJ\u0018\u0010V\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u0019H\u0001¢\u0006\u0004\bV\u0010\u001cJ\u0018\u0010X\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\u0015H\u0001¢\u0006\u0004\bX\u0010\u0018J\u0018\u0010Z\u001a\u00020\u00042\u0006\u0010Y\u001a\u00020\u0015H\u0001¢\u0006\u0004\bZ\u0010\u0018J \u0010]\u001a\u00020\u00042\u0006\u0010[\u001a\u00020,2\u0006\u0010\\\u001a\u00020,H\u0001¢\u0006\u0004\b]\u0010^R*\u0010d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010#8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010&¨\u0006k"}, d2 = {"Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemViewImpl;", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemView;", "Lcom/avito/android/serp/BaseSerpViewHolder;", "Lru/avito/component/serp/SerpAdvertXlCard;", "", "onUnbind", "()V", "", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;", "badgeListener", "bindBadges", "(Ljava/util/List;Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;)V", "clearPictures", "Lcom/avito/android/image_loader/Picture;", "picture", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "hideBadge", "", "active", "setActive", "(Z)V", "", "text", "setAdditionalName", "(Ljava/lang/String;)V", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", "Lcom/avito/android/remote/model/badge/Badge;", "badge", "setBadge", "(Lcom/avito/android/remote/model/badge/Badge;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCallActionListener", "(Lkotlin/jvm/functions/Function0;)V", "actionText", "setCallActionText", "oldPrice", "setClassifiedDiscount", "setClickListener", "", VKApiConst.POSITION, "smoothScroll", "setCurrentPicture", "(IZ)V", Sort.DATE, "setDate", "isVisible", "setDeliveryVisible", "description", "setDescription", "favorite", "setFavorite", "visible", "setFavoriteVisible", "hasVideo", "setHasVideo", "location", "setLocation", "discountPercentage", "setMarketplaceDiscount", "(Ljava/lang/String;Ljava/lang/String;)V", "setOnFavoriteButtonClickListener", "Lru/avito/component/serp/PhoneLoadingState;", "state", "setPhoneLoadingState", "(Lru/avito/component/serp/PhoneLoadingState;)V", "Lkotlin/Function1;", "setPictureChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "pictures", "setPictures", "(Ljava/util/List;)V", "price", "isHighlighted", "setPrice", "(Ljava/lang/String;Z)V", "priceWithoutDiscount", "setPriceWithoutDiscount", "seller", "setSeller", "title", "setTitle", "enlarged", "setVideoIconEnlarged", "viewed", "setViewed", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "setupGallerySize", "(II)V", "s", "Lkotlin/jvm/functions/Function0;", "getUnbindListener", "()Lkotlin/jvm/functions/Function0;", "setUnbindListener", "unbindListener", "Landroid/view/View;", "view", "Lru/avito/component/serp/SerpItemViewConfig;", "viewConfig", "<init>", "(Landroid/view/View;Lru/avito/component/serp/SerpItemViewConfig;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertXlItemViewImpl extends BaseSerpViewHolder implements AdvertXlItemView, SerpAdvertXlCard {
    @Nullable
    public Function0<Unit> s;
    public final /* synthetic */ SerpAdvertXlCardImpl t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertXlItemViewImpl(@NotNull View view, @NotNull SerpItemViewConfig serpItemViewConfig) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(serpItemViewConfig, "viewConfig");
        this.t = new SerpAdvertXlCardImpl(view, serpItemViewConfig);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void bindBadges(@Nullable List<SerpBadge> list, @Nullable BadgeViewListener badgeViewListener) {
        this.t.bindBadges(list, badgeViewListener);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void clearPictures() {
        this.t.clearPictures();
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    @NotNull
    public Uri getPictureUri(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        return this.t.getPictureUri(picture);
    }

    @Override // com.avito.android.serp.adapter.advert_xl.AdvertXlItemView
    @Nullable
    public Function0<Unit> getUnbindListener() {
        return this.s;
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void hideBadge() {
        this.t.hideBadge();
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> unbindListener = getUnbindListener();
        if (unbindListener != null) {
            unbindListener.invoke();
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setActive(boolean z) {
        this.t.setActive(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setAdditionalName(@Nullable String str) {
        this.t.setAdditionalName(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setAddress(@Nullable String str) {
        this.t.setAddress(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setBadge(@NotNull Badge badge) {
        Intrinsics.checkNotNullParameter(badge, "badge");
        this.t.setBadge(badge);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setCallActionListener(@Nullable Function0<Unit> function0) {
        this.t.setCallActionListener(function0);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setCallActionText(@Nullable String str) {
        this.t.setCallActionText(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setClassifiedDiscount(@Nullable String str) {
        this.t.setClassifiedDiscount(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setClickListener(@Nullable Function0<Unit> function0) {
        this.t.setClickListener(function0);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setCurrentPicture(int i, boolean z) {
        this.t.setCurrentPicture(i, z);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setDate(@Nullable String str) {
        this.t.setDate(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setDeliveryVisible(boolean z) {
        this.t.setDeliveryVisible(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setDescription(@Nullable String str) {
        this.t.setDescription(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setFavorite(boolean z) {
        this.t.setFavorite(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setFavoriteVisible(boolean z) {
        this.t.setFavoriteVisible(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setHasVideo(boolean z) {
        this.t.setHasVideo(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setLocation(@Nullable String str) {
        this.t.setLocation(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setMarketplaceDiscount(@Nullable String str, @Nullable String str2) {
        this.t.setMarketplaceDiscount(str, str2);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setOnFavoriteButtonClickListener(@Nullable Function0<Unit> function0) {
        this.t.setOnFavoriteButtonClickListener(function0);
    }

    @Override // ru.avito.component.serp.AsyncPhoneItemView
    public void setPhoneLoadingState(@NotNull PhoneLoadingState phoneLoadingState) {
        Intrinsics.checkNotNullParameter(phoneLoadingState, "state");
        this.t.setPhoneLoadingState(phoneLoadingState);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setPictureChangeListener(@Nullable Function1<? super Integer, Unit> function1) {
        this.t.setPictureChangeListener(function1);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setPictures(@NotNull List<? extends Picture> list) {
        Intrinsics.checkNotNullParameter(list, "pictures");
        this.t.setPictures(list);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setPrice(@Nullable String str, boolean z) {
        this.t.setPrice(str, z);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setPriceWithoutDiscount(@Nullable String str) {
        this.t.setPriceWithoutDiscount(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setSeller(@Nullable String str) {
        this.t.setSeller(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.t.setTitle(str);
    }

    @Override // com.avito.android.serp.adapter.advert_xl.AdvertXlItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.s = function0;
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setVideoIconEnlarged(boolean z) {
        this.t.setVideoIconEnlarged(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setViewed(boolean z) {
        this.t.setViewed(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertXlCard
    public void setupGallerySize(int i, int i2) {
        this.t.setupGallerySize(i, i2);
    }
}
