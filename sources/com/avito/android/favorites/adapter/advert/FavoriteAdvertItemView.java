package com.avito.android.favorites.adapter.advert;

import android.net.Uri;
import com.avito.android.image_loader.Picture;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.model.VKAttachments;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0007H&¢\u0006\u0004\b\u0010\u0010\nJ\u0019\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0012\u0010\nJ\u0017\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0018\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0018\u0010\nJ\u0019\u0010\u001a\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u001a\u0010\nJ\u0019\u0010\u001c\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u001c\u0010\nJ\u0019\u0010\u001e\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u001e\u0010\nJ\u0019\u0010!\u001a\u00020\u00032\b\u0010 \u001a\u0004\u0018\u00010\u001fH&¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b$\u0010\nJ\u0017\u0010&\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0013H&¢\u0006\u0004\b&\u0010\u0016J\u001f\u0010'\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b'\u0010\u0006J\u001f\u0010(\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b(\u0010\u0006J\u0017\u0010*\u001a\u00020)2\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b*\u0010+J\u001f\u0010-\u001a\u00020\u00032\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b-\u0010\u0006J\u0017\u0010/\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0013H&¢\u0006\u0004\b/\u0010\u0016J\u0017\u00101\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0013H&¢\u0006\u0004\b1\u0010\u0016J\u0017\u00102\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0013H&¢\u0006\u0004\b2\u0010\u0016J\u001f\u00103\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&¢\u0006\u0004\b3\u0010\u0006J\u0017\u00104\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0013H&¢\u0006\u0004\b4\u0010\u0016¨\u00065"}, d2 = {"Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "", "description", "setStatusDescription", "(Ljava/lang/String;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setPicture", "(Lcom/avito/android/image_loader/Picture;)V", "title", "setTitle", "price", "setCurrentPrice", "", "isShowDelivery", "setDeliveryVisible", "(Z)V", "value", "setPreviousPrice", "shopName", "setShopName", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", "location", "setLocation", "", "time", "setDate", "(Ljava/lang/Long;)V", VKAttachments.TYPE_NOTE, "setNote", "active", "setActive", "setOnFavoriteButtonClickListener", "setClickListener", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "clickListener", "setMoreClickListener", "isVisible", "setMoreButtonVisible", "isFavorite", "setFavorite", "setViewedBadgeVisible", "setSimilarClickListener", "setSimilarButtonVisible", "favorites_release"}, k = 1, mv = {1, 4, 2})
public interface FavoriteAdvertItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull FavoriteAdvertItemView favoriteAdvertItemView) {
            ItemView.DefaultImpls.onUnbind(favoriteAdvertItemView);
        }
    }

    @NotNull
    Uri getPictureUri(@NotNull Picture picture);

    void setActive(boolean z);

    void setAddress(@Nullable String str);

    void setClickListener(@Nullable Function0<Unit> function0);

    void setCurrentPrice(@Nullable String str);

    void setDate(@Nullable Long l);

    void setDeliveryVisible(boolean z);

    void setFavorite(boolean z);

    void setLocation(@Nullable String str);

    void setMoreButtonVisible(boolean z);

    void setMoreClickListener(@Nullable Function0<Unit> function0);

    void setNote(@Nullable String str);

    void setOnFavoriteButtonClickListener(@Nullable Function0<Unit> function0);

    void setPicture(@NotNull Picture picture);

    void setPreviousPrice(@Nullable String str);

    void setShopName(@Nullable String str);

    void setSimilarButtonVisible(boolean z);

    void setSimilarClickListener(@Nullable Function0<Unit> function0);

    void setStatusDescription(@Nullable String str);

    void setTitle(@NotNull String str);

    void setUnbindListener(@Nullable Function0<Unit> function0);

    void setViewedBadgeVisible(boolean z);
}
