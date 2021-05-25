package com.avito.android.extended_profile.adapter.category.category_advert.list;

import android.net.Uri;
import android.os.Parcelable;
import com.avito.android.image_loader.Picture;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.appevents.integrity.IntegrityManager;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J%\u0010\u0006\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0012\u0010\u000bJ\u0019\u0010\u0014\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0014\u0010\u000bJ\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0016\u0010\u000bJ\u0019\u0010\u0018\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u0018\u0010\u000bJ\u001d\u0010\u001c\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H&¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0004H&¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\rH&¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\rH&¢\u0006\u0004\b$\u0010\"J\u0019\u0010&\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b&\u0010\u000bJ\u0017\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\rH&¢\u0006\u0004\b(\u0010\"J\u0017\u0010+\u001a\u00020*2\u0006\u0010)\u001a\u00020\u001aH&¢\u0006\u0004\b+\u0010,J\u0019\u0010/\u001a\u00020\u00042\b\u0010.\u001a\u0004\u0018\u00010-H&¢\u0006\u0004\b/\u00100J\u001f\u00103\u001a\u00020\u00042\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u000101H&¢\u0006\u0004\b3\u00104J\u000f\u00105\u001a\u00020\u0004H&¢\u0006\u0004\b5\u0010\u001fR\u0018\u00108\u001a\u0004\u0018\u00010-8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u001c\u0010<\u001a\b\u0012\u0004\u0012\u00020\u0004098&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u001c\u0010>\u001a\b\u0012\u0004\u0012\u00020\u0003098&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b=\u0010;¨\u0006?"}, d2 = {"Lcom/avito/android/extended_profile/adapter/category/category_advert/list/CategoryAdvertListItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lkotlin/Function1;", "", "", "callback", "itemClicks", "(Lkotlin/jvm/functions/Function1;)V", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "price", "", "isHighlighted", "setPrice", "(Ljava/lang/CharSequence;Z)V", "value", "setDiscount", "priceWithoutDiscount", "setPriceWithoutDiscount", "location", "setLocation", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", "", "Lcom/avito/android/image_loader/Picture;", "pictures", "setPictures", "(Ljava/util/List;)V", "clearPictures", "()V", "visible", "setFavoriteVisible", "(Z)V", "favorite", "setFavorite", "description", "setDescription", "viewed", "setViewed", "picture", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "Landroid/os/Parcelable;", "state", "restoreGalleryState", "(Landroid/os/Parcelable;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "clearSubscriptions", "getGalleryState", "()Landroid/os/Parcelable;", "galleryState", "Lio/reactivex/rxjava3/core/Observable;", "getFavoriteClicks", "()Lio/reactivex/rxjava3/core/Observable;", "favoriteClicks", "getGalleryPictureChanges", "galleryPictureChanges", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public interface CategoryAdvertListItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull CategoryAdvertListItemView categoryAdvertListItemView) {
            ItemView.DefaultImpls.onUnbind(categoryAdvertListItemView);
        }
    }

    void clearPictures();

    void clearSubscriptions();

    @NotNull
    Observable<Unit> getFavoriteClicks();

    @NotNull
    Observable<Integer> getGalleryPictureChanges();

    @Nullable
    Parcelable getGalleryState();

    @NotNull
    Uri getPictureUri(@NotNull Picture picture);

    void itemClicks(@NotNull Function1<? super Integer, Unit> function1);

    void restoreGalleryState(@Nullable Parcelable parcelable);

    void setAddress(@Nullable CharSequence charSequence);

    void setDescription(@Nullable CharSequence charSequence);

    void setDiscount(@Nullable CharSequence charSequence);

    void setFavorite(boolean z);

    void setFavoriteVisible(boolean z);

    void setLocation(@Nullable CharSequence charSequence);

    void setPictures(@NotNull List<? extends Picture> list);

    void setPrice(@Nullable CharSequence charSequence, boolean z);

    void setPriceWithoutDiscount(@Nullable CharSequence charSequence);

    void setTitle(@NotNull CharSequence charSequence);

    void setUnbindListener(@Nullable Function0<Unit> function0);

    void setViewed(boolean z);
}
