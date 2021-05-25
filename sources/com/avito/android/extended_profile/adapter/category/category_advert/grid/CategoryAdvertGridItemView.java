package com.avito.android.extended_profile.adapter.category.category_advert.grid;

import android.net.Uri;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.image_loader.Picture;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\r\u0010\u0006J\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000f\u0010\u0006J\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0011\u0010\u0006J\u0019\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0013\u0010\u0006J!\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\bH&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\bH&¢\u0006\u0004\b!\u0010\u001fJ\u0019\u0010#\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b#\u0010\u0006J\u001f\u0010&\u001a\u00020\u00042\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010$H&¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\bH&¢\u0006\u0004\b)\u0010\u001fR\u001c\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040*8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040*8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010,¨\u00060"}, d2 = {"Lcom/avito/android/extended_profile/adapter/category/category_advert/grid/CategoryAdvertGridItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/CharSequence;)V", "price", "", "isHighlighted", "setPrice", "(Ljava/lang/CharSequence;Z)V", "value", "setDiscount", "priceWithoutDiscount", "setPriceWithoutDiscount", "location", "setLocation", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", "Lcom/avito/android/image_loader/Picture;", "picture", "", BookingInfoActivity.EXTRA_ITEM_ID, "setPicture", "(Lcom/avito/android/image_loader/Picture;Ljava/lang/String;)V", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "visible", "setFavoriteVisible", "(Z)V", "favorite", "setFavorite", "description", "setDescription", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "viewed", "setViewed", "Lio/reactivex/rxjava3/core/Observable;", "getItemClicks", "()Lio/reactivex/rxjava3/core/Observable;", "itemClicks", "getFavoriteClicks", "favoriteClicks", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public interface CategoryAdvertGridItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull CategoryAdvertGridItemView categoryAdvertGridItemView) {
            ItemView.DefaultImpls.onUnbind(categoryAdvertGridItemView);
        }
    }

    @NotNull
    Observable<Unit> getFavoriteClicks();

    @NotNull
    Observable<Unit> getItemClicks();

    @NotNull
    Uri getPictureUri(@NotNull Picture picture);

    void setAddress(@Nullable CharSequence charSequence);

    void setDescription(@Nullable CharSequence charSequence);

    void setDiscount(@Nullable CharSequence charSequence);

    void setFavorite(boolean z);

    void setFavoriteVisible(boolean z);

    void setLocation(@Nullable CharSequence charSequence);

    void setPicture(@NotNull Picture picture, @Nullable String str);

    void setPrice(@Nullable CharSequence charSequence, boolean z);

    void setPriceWithoutDiscount(@Nullable CharSequence charSequence);

    void setTitle(@NotNull CharSequence charSequence);

    void setUnbindListener(@Nullable Function0<Unit> function0);

    void setViewed(boolean z);
}
