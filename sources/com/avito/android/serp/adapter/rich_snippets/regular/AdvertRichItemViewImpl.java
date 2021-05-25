package com.avito.android.serp.adapter.rich_snippets.regular;

import android.net.Uri;
import android.os.Parcelable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.expected.badge_bar.BadgeViewListener;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.badge.Badge;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.avito.android.serp.BaseSerpViewHolder;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.PhoneLoadingState;
import ru.avito.component.serp.SerpAdvertRichCard;
import ru.avito.component.serp.SerpAdvertRichCardImpl;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ActionData;
import ru.avito.component.serp.cyclic_gallery.image_carousel.GalleryRatio;
import ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItem;
import ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.SellerInfoParams;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B<\u0012\u0006\u0010z\u001a\u00020y\u0012\u0006\u0010|\u001a\u00020{\u0012\u0006\u0010~\u001a\u00020}\u0012\u0006\u0010\u001a\u00020\b\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0007\u0010\u0001\u001a\u00020\b¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J&\u0010\n\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\u0011\u001a\u00020\u00042\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0004\b\u0011\u0010\u0012J$\u0010\u0014\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0001¢\u0006\u0004\b\u0014\u0010\u000bJ\u0010\u0010\u0015\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0015\u0010\u0006J\u0010\u0010\u0016\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0016\u0010\u0006J\u0010\u0010\u0017\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0017\u0010\u0006J$\u0010\u0019\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00040\u0007H\u0001¢\u0006\u0004\b\u0019\u0010\u000bJ \u0010\u001b\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001aH\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001dH\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\"\u0010\u0006J&\u0010$\u001a\u00020\u00042\u0014\u0010\u0013\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010#\u0012\u0004\u0012\u00020\u00040\u0007H\u0001¢\u0006\u0004\b$\u0010\u000bJ&\u0010%\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b%\u0010\u000bJ\u001a\u0010(\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010&H\u0001¢\u0006\u0004\b(\u0010)J\u001e\u0010-\u001a\u00020\u00042\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0*H\u0001¢\u0006\u0004\b-\u0010.J\u0018\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\bH\u0001¢\u0006\u0004\b0\u00101J\u001a\u00104\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u000102H\u0001¢\u0006\u0004\b4\u00105J\u001a\u00107\u001a\u00020\u00042\b\u00106\u001a\u0004\u0018\u000102H\u0001¢\u0006\u0004\b7\u00105J\u0018\u0010:\u001a\u00020\u00042\u0006\u00109\u001a\u000208H\u0001¢\u0006\u0004\b:\u0010;J\u001a\u0010=\u001a\u00020\u00042\b\u0010<\u001a\u0004\u0018\u000102H\u0001¢\u0006\u0004\b=\u00105J \u0010@\u001a\u00020\u00042\u0006\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020\bH\u0001¢\u0006\u0004\b@\u0010AJ\u001a\u0010C\u001a\u00020\u00042\b\u0010B\u001a\u0004\u0018\u000102H\u0001¢\u0006\u0004\bC\u00105J\u0018\u0010E\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\bH\u0001¢\u0006\u0004\bE\u00101J\u001a\u0010G\u001a\u00020\u00042\b\u0010F\u001a\u0004\u0018\u000102H\u0001¢\u0006\u0004\bG\u00105J\u001a\u0010I\u001a\u00020\u00042\b\u0010H\u001a\u0004\u0018\u000102H\u0001¢\u0006\u0004\bI\u00105J\u001a\u0010K\u001a\u00020\u00042\b\u0010J\u001a\u0004\u0018\u000102H\u0001¢\u0006\u0004\bK\u00105J\u0018\u0010M\u001a\u00020\u00042\u0006\u0010L\u001a\u00020\bH\u0001¢\u0006\u0004\bM\u00101J\u0018\u0010O\u001a\u00020\u00042\u0006\u0010N\u001a\u00020\bH\u0001¢\u0006\u0004\bO\u00101J\u0018\u0010Q\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\bH\u0001¢\u0006\u0004\bQ\u00101J\u001a\u0010S\u001a\u00020\u00042\b\u0010R\u001a\u0004\u0018\u000102H\u0001¢\u0006\u0004\bS\u00105J \u0010T\u001a\u00020\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001aH\u0001¢\u0006\u0004\bT\u0010\u001cJ\u0018\u0010V\u001a\u00020\u00042\u0006\u0010'\u001a\u00020UH\u0001¢\u0006\u0004\bV\u0010WJ\u001e\u0010Y\u001a\u00020\u00042\f\u0010X\u001a\b\u0012\u0004\u0012\u00020\u001d0\fH\u0001¢\u0006\u0004\bY\u0010ZJ\"\u0010]\u001a\u00020\u00042\b\u0010[\u001a\u0004\u0018\u0001022\u0006\u0010\\\u001a\u00020\bH\u0001¢\u0006\u0004\b]\u0010^J\u001a\u0010`\u001a\u00020\u00042\b\u0010_\u001a\u0004\u0018\u000102H\u0001¢\u0006\u0004\b`\u00105J\u001a\u0010b\u001a\u00020\u00042\b\u0010a\u001a\u0004\u0018\u000102H\u0001¢\u0006\u0004\bb\u00105J$\u0010b\u001a\u00020\u00042\b\u0010a\u001a\u0004\u0018\u0001022\b\u0010c\u001a\u0004\u0018\u000102H\u0001¢\u0006\u0004\bb\u0010dJ\u001a\u0010g\u001a\u00020\u00042\b\u0010f\u001a\u0004\u0018\u00010eH\u0001¢\u0006\u0004\bg\u0010hJ\u0018\u0010j\u001a\u00020\u00042\u0006\u0010i\u001a\u000202H\u0001¢\u0006\u0004\bj\u00105J\u0018\u0010l\u001a\u00020\u00042\u0006\u0010k\u001a\u00020\bH\u0001¢\u0006\u0004\bl\u00101J\u0018\u0010n\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\bH\u0001¢\u0006\u0004\bn\u00101J$\u0010o\u001a\u00020\u00042\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00040\u0007H\u0001¢\u0006\u0004\bo\u0010\u000bR\u0018\u0010r\u001a\u0004\u0018\u00010&8\u0016@\u0016X\u0005¢\u0006\u0006\u001a\u0004\bp\u0010qR*\u0010x\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001a8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010\u001c¨\u0006\u0001"}, d2 = {"Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichItemViewImpl;", "Lcom/avito/android/serp/adapter/rich_snippets/regular/AdvertRichItemView;", "Lcom/avito/android/serp/BaseSerpViewHolder;", "Lru/avito/component/serp/SerpAdvertRichCard;", "", "onUnbind", "()V", "Lkotlin/Function1;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "additionalContentVisibilityChanges", "(Lkotlin/jvm/functions/Function1;)V", "", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;", "badgeListener", "bindBadges", "(Ljava/util/List;Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;)V", "callback", "callClicks", "clearActions", "clearListeners", "clearPictures", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLinkClicks", "Lkotlin/Function0;", "favoriteClicks", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "hideBadge", "", "itemClicks", "pictureChanges", "Landroid/os/Parcelable;", "state", "restoreGalleryState", "(Landroid/os/Parcelable;)V", "", "Lru/avito/component/serp/cyclic_gallery/image_carousel/ActionData;", "actions", "setActions", "(Ljava/util/Set;)V", "active", "setActive", "(Z)V", "", "text", "setAdditionalActionText", "(Ljava/lang/String;)V", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", "Lcom/avito/android/remote/model/badge/Badge;", "badge", "setBadge", "(Lcom/avito/android/remote/model/badge/Badge;)V", "actionText", "setCallActionText", VKApiConst.POSITION, "smoothScroll", "setCurrentPicture", "(IZ)V", Sort.DATE, "setDate", "isVisible", "setDeliveryVisible", "description", "setDescription", "value", "setDiscount", Sort.DISTANCE, "setDistance", "favorite", "setFavorite", "visible", "setFavoriteVisible", "hasVideo", "setHasVideo", "location", "setLocation", "setOnAdditionalActionClickListener", "Lru/avito/component/serp/PhoneLoadingState;", "setPhoneLoadingState", "(Lru/avito/component/serp/PhoneLoadingState;)V", "pictures", "setPictures", "(Ljava/util/List;)V", "price", "isHighlighted", "setPrice", "(Ljava/lang/String;Z)V", "priceWithoutDiscount", "setPriceWithoutDiscount", "seller", "setSeller", "since", "(Ljava/lang/String;Ljava/lang/String;)V", "Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/CarouselSellerItem;", "sellerItem", "setSellerInfo", "(Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/CarouselSellerItem;)V", "title", "setTitle", "enlarged", "setVideoIconEnlarged", "viewed", "setViewed", "writeClicks", "getGalleryState", "()Landroid/os/Parcelable;", "galleryState", "s", "Lkotlin/jvm/functions/Function0;", "getUnbindListener", "()Lkotlin/jvm/functions/Function0;", "setUnbindListener", "unbindListener", "Landroid/view/View;", "view", "Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;", "galleryRatio", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "recycledViewPool", "stickyBadgesEnabled", "Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams;", "sellerInfoParams", "asyncText", "<init>", "(Landroid/view/View;Lru/avito/component/serp/cyclic_gallery/image_carousel/GalleryRatio;Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;ZLru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/SellerInfoParams;Z)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertRichItemViewImpl extends BaseSerpViewHolder implements AdvertRichItemView, SerpAdvertRichCard {
    @Nullable
    public Function0<Unit> s;
    public final /* synthetic */ SerpAdvertRichCardImpl t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertRichItemViewImpl(@NotNull View view, @NotNull GalleryRatio galleryRatio, @NotNull RecyclerView.RecycledViewPool recycledViewPool, boolean z, @NotNull SellerInfoParams sellerInfoParams, boolean z2) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(galleryRatio, "galleryRatio");
        Intrinsics.checkNotNullParameter(recycledViewPool, "recycledViewPool");
        Intrinsics.checkNotNullParameter(sellerInfoParams, "sellerInfoParams");
        this.t = new SerpAdvertRichCardImpl(view, galleryRatio, recycledViewPool, z, sellerInfoParams, z2);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void additionalContentVisibilityChanges(@Nullable Function1<? super Boolean, Unit> function1) {
        this.t.additionalContentVisibilityChanges(function1);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void bindBadges(@Nullable List<SerpBadge> list, @Nullable BadgeViewListener badgeViewListener) {
        this.t.bindBadges(list, badgeViewListener);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void callClicks(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.t.callClicks(function1);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void clearActions() {
        this.t.clearActions();
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void clearListeners() {
        this.t.clearListeners();
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void clearPictures() {
        this.t.clearPictures();
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void deepLinkClicks(@NotNull Function1<? super DeepLink, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.t.deepLinkClicks(function1);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void favoriteClicks(@Nullable Function0<Unit> function0) {
        this.t.favoriteClicks(function0);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    @Nullable
    public Parcelable getGalleryState() {
        return this.t.getGalleryState();
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    @NotNull
    public Uri getPictureUri(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        return this.t.getPictureUri(picture);
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemView
    @Nullable
    public Function0<Unit> getUnbindListener() {
        return this.s;
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void hideBadge() {
        this.t.hideBadge();
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void itemClicks(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.t.itemClicks(function1);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> unbindListener = getUnbindListener();
        if (unbindListener != null) {
            unbindListener.invoke();
        }
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void pictureChanges(@Nullable Function1<? super Integer, Unit> function1) {
        this.t.pictureChanges(function1);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void restoreGalleryState(@Nullable Parcelable parcelable) {
        this.t.restoreGalleryState(parcelable);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setActions(@NotNull Set<ActionData> set) {
        Intrinsics.checkNotNullParameter(set, "actions");
        this.t.setActions(set);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setActive(boolean z) {
        this.t.setActive(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setAdditionalActionText(@Nullable String str) {
        this.t.setAdditionalActionText(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setAddress(@Nullable String str) {
        this.t.setAddress(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setBadge(@NotNull Badge badge) {
        Intrinsics.checkNotNullParameter(badge, "badge");
        this.t.setBadge(badge);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setCallActionText(@Nullable String str) {
        this.t.setCallActionText(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setCurrentPicture(int i, boolean z) {
        this.t.setCurrentPicture(i, z);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setDate(@Nullable String str) {
        this.t.setDate(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setDeliveryVisible(boolean z) {
        this.t.setDeliveryVisible(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setDescription(@Nullable String str) {
        this.t.setDescription(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setDiscount(@Nullable String str) {
        this.t.setDiscount(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setDistance(@Nullable String str) {
        this.t.setDistance(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setFavorite(boolean z) {
        this.t.setFavorite(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setFavoriteVisible(boolean z) {
        this.t.setFavoriteVisible(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setHasVideo(boolean z) {
        this.t.setHasVideo(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setLocation(@Nullable String str) {
        this.t.setLocation(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setOnAdditionalActionClickListener(@Nullable Function0<Unit> function0) {
        this.t.setOnAdditionalActionClickListener(function0);
    }

    @Override // ru.avito.component.serp.AsyncPhoneItemView
    public void setPhoneLoadingState(@NotNull PhoneLoadingState phoneLoadingState) {
        Intrinsics.checkNotNullParameter(phoneLoadingState, "state");
        this.t.setPhoneLoadingState(phoneLoadingState);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setPictures(@NotNull List<? extends Picture> list) {
        Intrinsics.checkNotNullParameter(list, "pictures");
        this.t.setPictures(list);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setPrice(@Nullable String str, boolean z) {
        this.t.setPrice(str, z);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setPriceWithoutDiscount(@Nullable String str) {
        this.t.setPriceWithoutDiscount(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setSeller(@Nullable String str) {
        this.t.setSeller(str);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setSeller(@Nullable String str, @Nullable String str2) {
        this.t.setSeller(str, str2);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setSellerInfo(@Nullable CarouselSellerItem carouselSellerItem) {
        this.t.setSellerInfo(carouselSellerItem);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.t.setTitle(str);
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.s = function0;
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setVideoIconEnlarged(boolean z) {
        this.t.setVideoIconEnlarged(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void setViewed(boolean z) {
        this.t.setViewed(z);
    }

    @Override // ru.avito.component.serp.SerpAdvertRichCard
    public void writeClicks(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        this.t.writeClicks(function1);
    }
}
