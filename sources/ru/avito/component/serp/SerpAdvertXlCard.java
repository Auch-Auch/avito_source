package ru.avito.component.serp;

import android.net.Uri;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.expected.badge_bar.BadgeViewListener;
import com.avito.android.remote.model.Sort;
import com.avito.android.remote.model.badge.Badge;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000f\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0012\u0010\u000bJ\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0014\u0010\u000bJ\u0019\u0010\u0016\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0016\u0010\u000bJ\u0019\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0018\u0010\u000bJ\u001d\u0010\u001c\u001a\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H&¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0005H&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0019\u0010!\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b!\u0010\u000bJ\u0017\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\rH&¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\rH&¢\u0006\u0004\b&\u0010$J\u0019\u0010(\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b(\u0010\u000bJ\u0017\u0010*\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\rH&¢\u0006\u0004\b*\u0010$J\u001f\u0010-\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\rH&¢\u0006\u0004\b-\u0010.J\u0019\u00100\u001a\u00020\u00052\b\u0010/\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b0\u0010\u000bJ\u001f\u00103\u001a\u00020\u00052\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u000101H&¢\u0006\u0004\b3\u00104J\u001f\u00105\u001a\u00020\u00052\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u000101H&¢\u0006\u0004\b5\u00104J\u001f\u00106\u001a\u00020\u00052\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u000101H&¢\u0006\u0004\b6\u00104J%\u00108\u001a\u00020\u00052\u0014\u00102\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0005\u0018\u000107H&¢\u0006\u0004\b8\u00109J\u0017\u0010;\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\rH&¢\u0006\u0004\b;\u0010$J\u0017\u0010=\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\rH&¢\u0006\u0004\b=\u0010$J\u0017\u0010@\u001a\u00020?2\u0006\u0010>\u001a\u00020\u001aH&¢\u0006\u0004\b@\u0010AJ\u0019\u0010C\u001a\u00020\u00052\b\u0010B\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\bC\u0010\u000bJ\u0017\u0010F\u001a\u00020\u00052\u0006\u0010E\u001a\u00020DH&¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0005H&¢\u0006\u0004\bH\u0010\u001fJ)\u0010M\u001a\u00020\u00052\u000e\u0010J\u001a\n\u0012\u0004\u0012\u00020I\u0018\u00010\u00192\b\u0010L\u001a\u0004\u0018\u00010KH&¢\u0006\u0004\bM\u0010NJ\u0017\u0010P\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\rH&¢\u0006\u0004\bP\u0010$J\u0019\u0010R\u001a\u00020\u00052\b\u0010Q\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\bR\u0010\u000bJ#\u0010T\u001a\u00020\u00052\b\u0010Q\u001a\u0004\u0018\u00010\b2\b\u0010S\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\bT\u0010UJ\u0017\u0010W\u001a\u00020\u00052\u0006\u0010V\u001a\u00020\rH&¢\u0006\u0004\bW\u0010$¨\u0006X"}, d2 = {"Lru/avito/component/serp/SerpAdvertXlCard;", "Lru/avito/component/serp/AsyncPhoneItemView;", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "setupGallerySize", "(II)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "price", "", "isHighlighted", "setPrice", "(Ljava/lang/String;Z)V", "priceWithoutDiscount", "setPriceWithoutDiscount", "location", "setLocation", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", Sort.DATE, "setDate", "", "Lcom/avito/android/image_loader/Picture;", "pictures", "setPictures", "(Ljava/util/List;)V", "clearPictures", "()V", "seller", "setSeller", "visible", "setFavoriteVisible", "(Z)V", "favorite", "setFavorite", "description", "setDescription", "isVisible", "setDeliveryVisible", VKApiConst.POSITION, "smoothScroll", "setCurrentPicture", "(IZ)V", "actionText", "setCallActionText", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCallActionListener", "(Lkotlin/jvm/functions/Function0;)V", "setOnFavoriteButtonClickListener", "setClickListener", "Lkotlin/Function1;", "setPictureChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "active", "setActive", "viewed", "setViewed", "picture", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "text", "setAdditionalName", "Lcom/avito/android/remote/model/badge/Badge;", "badge", "setBadge", "(Lcom/avito/android/remote/model/badge/Badge;)V", "hideBadge", "Lcom/avito/android/remote/model/badge_bar/SerpBadge;", "badges", "Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;", "badgeListener", "bindBadges", "(Ljava/util/List;Lcom/avito/android/lib/expected/badge_bar/BadgeViewListener;)V", "enlarged", "setVideoIconEnlarged", "oldPrice", "setClassifiedDiscount", "discountPercentage", "setMarketplaceDiscount", "(Ljava/lang/String;Ljava/lang/String;)V", "hasVideo", "setHasVideo", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface SerpAdvertXlCard extends AsyncPhoneItemView {
    void bindBadges(@Nullable List<SerpBadge> list, @Nullable BadgeViewListener badgeViewListener);

    void clearPictures();

    @NotNull
    Uri getPictureUri(@NotNull Picture picture);

    void hideBadge();

    void setActive(boolean z);

    void setAdditionalName(@Nullable String str);

    void setAddress(@Nullable String str);

    void setBadge(@NotNull Badge badge);

    void setCallActionListener(@Nullable Function0<Unit> function0);

    void setCallActionText(@Nullable String str);

    void setClassifiedDiscount(@Nullable String str);

    void setClickListener(@Nullable Function0<Unit> function0);

    void setCurrentPicture(int i, boolean z);

    void setDate(@Nullable String str);

    void setDeliveryVisible(boolean z);

    void setDescription(@Nullable String str);

    void setFavorite(boolean z);

    void setFavoriteVisible(boolean z);

    void setHasVideo(boolean z);

    void setLocation(@Nullable String str);

    void setMarketplaceDiscount(@Nullable String str, @Nullable String str2);

    void setOnFavoriteButtonClickListener(@Nullable Function0<Unit> function0);

    void setPictureChangeListener(@Nullable Function1<? super Integer, Unit> function1);

    void setPictures(@NotNull List<? extends Picture> list);

    void setPrice(@Nullable String str, boolean z);

    void setPriceWithoutDiscount(@Nullable String str);

    void setSeller(@Nullable String str);

    void setTitle(@NotNull String str);

    void setVideoIconEnlarged(boolean z);

    void setViewed(boolean z);

    void setupGallerySize(int i, int i2);
}
