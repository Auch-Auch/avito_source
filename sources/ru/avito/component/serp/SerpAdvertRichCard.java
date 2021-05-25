package ru.avito.component.serp;

import android.net.Uri;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.expected.badge_bar.BadgeViewListener;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.badge.Badge;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ActionData;
import ru.avito.component.serp.cyclic_gallery.image_carousel.seller_info.CarouselSellerItem;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\r\u0010\u0006J\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000f\u0010\u0006J\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0011\u0010\u0006J\u0019\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0013\u0010\u0006J\u0019\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0015\u0010\u0006J\u0019\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0017\u0010\u0006J\u001d\u0010\u001b\u001a\u00020\u00042\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H&¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b \u0010\u0006J#\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b \u0010\"J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\bH&¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\bH&¢\u0006\u0004\b'\u0010%J\u0019\u0010)\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b)\u0010\u0006J\u0017\u0010+\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\bH&¢\u0006\u0004\b+\u0010%J\u001f\u0010/\u001a\u00020\u00042\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020\bH&¢\u0006\u0004\b/\u00100J\u0019\u00102\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b2\u0010\u0006J\u001f\u00105\u001a\u00020\u00042\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000103H&¢\u0006\u0004\b5\u00106J#\u0010:\u001a\u00020\u00042\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u000407H&¢\u0006\u0004\b:\u0010;J#\u0010<\u001a\u00020\u00042\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000407H&¢\u0006\u0004\b<\u0010;J#\u0010=\u001a\u00020\u00042\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000407H&¢\u0006\u0004\b=\u0010;J%\u0010>\u001a\u00020\u00042\u0014\u00109\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010,\u0012\u0004\u0012\u00020\u000407H&¢\u0006\u0004\b>\u0010;J%\u0010?\u001a\u00020\u00042\u0014\u00104\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u0004\u0018\u000107H&¢\u0006\u0004\b?\u0010;J%\u0010@\u001a\u00020\u00042\u0014\u00104\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u000107H&¢\u0006\u0004\b@\u0010;J\u0017\u0010B\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\bH&¢\u0006\u0004\bB\u0010%J\u0017\u0010D\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\bH&¢\u0006\u0004\bD\u0010%J\u0019\u0010F\u001a\u00020\u00042\b\u0010E\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\bF\u0010\u0006J\u001f\u0010G\u001a\u00020\u00042\u000e\u00104\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000103H&¢\u0006\u0004\bG\u00106J\u0017\u0010J\u001a\u00020I2\u0006\u0010H\u001a\u00020\u0019H&¢\u0006\u0004\bJ\u0010KJ\u001d\u0010O\u001a\u00020\u00042\f\u0010N\u001a\b\u0012\u0004\u0012\u00020M0LH&¢\u0006\u0004\bO\u0010PJ\u000f\u0010Q\u001a\u00020\u0004H&¢\u0006\u0004\bQ\u0010\u001eJ\u0019\u0010T\u001a\u00020\u00042\b\u0010S\u001a\u0004\u0018\u00010RH&¢\u0006\u0004\bT\u0010UJ\u0019\u0010X\u001a\u00020\u00042\b\u0010W\u001a\u0004\u0018\u00010VH&¢\u0006\u0004\bX\u0010YJ\u0017\u0010\\\u001a\u00020\u00042\u0006\u0010[\u001a\u00020ZH&¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020\u0004H&¢\u0006\u0004\b^\u0010\u001eJ)\u0010c\u001a\u00020\u00042\u000e\u0010`\u001a\n\u0012\u0004\u0012\u00020_\u0018\u00010\u00182\b\u0010b\u001a\u0004\u0018\u00010aH&¢\u0006\u0004\bc\u0010dJ\u0017\u0010f\u001a\u00020\u00042\u0006\u0010e\u001a\u00020\bH&¢\u0006\u0004\bf\u0010%J\u0017\u0010h\u001a\u00020\u00042\u0006\u0010g\u001a\u00020\bH&¢\u0006\u0004\bh\u0010%J\u000f\u0010i\u001a\u00020\u0004H&¢\u0006\u0004\bi\u0010\u001eR\u0018\u0010l\u001a\u0004\u0018\u00010V8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bj\u0010k¨\u0006m"}, d2 = {"Lru/avito/component/serp/SerpAdvertRichCard;", "Lru/avito/component/serp/AsyncPhoneItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "price", "", "isHighlighted", "setPrice", "(Ljava/lang/String;Z)V", "value", "setDiscount", "priceWithoutDiscount", "setPriceWithoutDiscount", "location", "setLocation", Sort.DISTANCE, "setDistance", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", Sort.DATE, "setDate", "", "Lcom/avito/android/image_loader/Picture;", "pictures", "setPictures", "(Ljava/util/List;)V", "clearPictures", "()V", "seller", "setSeller", "since", "(Ljava/lang/String;Ljava/lang/String;)V", "visible", "setFavoriteVisible", "(Z)V", "favorite", "setFavorite", "description", "setDescription", "isVisible", "setDeliveryVisible", "", VKApiConst.POSITION, "smoothScroll", "setCurrentPicture", "(IZ)V", "actionText", "setCallActionText", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "favoriteClicks", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "Lcom/avito/android/deep_linking/links/DeepLink;", "callback", "deepLinkClicks", "(Lkotlin/jvm/functions/Function1;)V", "writeClicks", "callClicks", "itemClicks", "pictureChanges", "additionalContentVisibilityChanges", "active", "setActive", "viewed", "setViewed", "text", "setAdditionalActionText", "setOnAdditionalActionClickListener", "picture", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "", "Lru/avito/component/serp/cyclic_gallery/image_carousel/ActionData;", "actions", "setActions", "(Ljava/util/Set;)V", "clearActions", "Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/CarouselSellerItem;", "sellerItem", "setSellerInfo", "(Lru/avito/component/serp/cyclic_gallery/image_carousel/seller_info/CarouselSellerItem;)V", "Landroid/os/Parcelable;", "state", "restoreGalleryState", "(Landroid/os/Parcelable;)V", "Lcom/avito/android/remote/model/badge/Badge;", "badge", "setBadge", "(Lcom/avito/android/remote/model/badge/Badge;)V", "hideBadge", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;", "badgeListener", "bindBadges", "(Ljava/util/List;Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;)V", "enlarged", "setVideoIconEnlarged", "hasVideo", "setHasVideo", "clearListeners", "getGalleryState", "()Landroid/os/Parcelable;", "galleryState", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface SerpAdvertRichCard extends AsyncPhoneItemView {
    void additionalContentVisibilityChanges(@Nullable Function1<? super Boolean, Unit> function1);

    void bindBadges(@Nullable List<SerpBadge> list, @Nullable BadgeViewListener badgeViewListener);

    void callClicks(@NotNull Function1<? super Boolean, Unit> function1);

    void clearActions();

    void clearListeners();

    void clearPictures();

    void deepLinkClicks(@NotNull Function1<? super DeepLink, Unit> function1);

    void favoriteClicks(@Nullable Function0<Unit> function0);

    @Nullable
    Parcelable getGalleryState();

    @NotNull
    Uri getPictureUri(@NotNull Picture picture);

    void hideBadge();

    void itemClicks(@NotNull Function1<? super Integer, Unit> function1);

    void pictureChanges(@Nullable Function1<? super Integer, Unit> function1);

    void restoreGalleryState(@Nullable Parcelable parcelable);

    void setActions(@NotNull Set<ActionData> set);

    void setActive(boolean z);

    void setAdditionalActionText(@Nullable String str);

    void setAddress(@Nullable String str);

    void setBadge(@NotNull Badge badge);

    void setCallActionText(@Nullable String str);

    void setCurrentPicture(int i, boolean z);

    void setDate(@Nullable String str);

    void setDeliveryVisible(boolean z);

    void setDescription(@Nullable String str);

    void setDiscount(@Nullable String str);

    void setDistance(@Nullable String str);

    void setFavorite(boolean z);

    void setFavoriteVisible(boolean z);

    void setHasVideo(boolean z);

    void setLocation(@Nullable String str);

    void setOnAdditionalActionClickListener(@Nullable Function0<Unit> function0);

    void setPictures(@NotNull List<? extends Picture> list);

    void setPrice(@Nullable String str, boolean z);

    void setPriceWithoutDiscount(@Nullable String str);

    void setSeller(@Nullable String str);

    void setSeller(@Nullable String str, @Nullable String str2);

    void setSellerInfo(@Nullable CarouselSellerItem carouselSellerItem);

    void setTitle(@NotNull String str);

    void setVideoIconEnlarged(boolean z);

    void setViewed(boolean z);

    void writeClicks(@NotNull Function1<? super Boolean, Unit> function1);
}
