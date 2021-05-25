package com.avito.android.extended_profile.adapter.category.category_advert;

import com.avito.android.extended_profile.adapter.action.ExtendedProfileItemAction;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.serp.adapter.AdvertItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/extended_profile/adapter/category/category_advert/CategoryAdvertItemAction;", "Lcom/avito/android/extended_profile/adapter/action/ExtendedProfileItemAction;", "<init>", "()V", "AdvertItemClickAction", "FavoriteClickAction", "Lcom/avito/android/extended_profile/adapter/category/category_advert/CategoryAdvertItemAction$FavoriteClickAction;", "Lcom/avito/android/extended_profile/adapter/category/category_advert/CategoryAdvertItemAction$AdvertItemClickAction;", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public abstract class CategoryAdvertItemAction implements ExtendedProfileItemAction {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/extended_profile/adapter/category/category_advert/CategoryAdvertItemAction$AdvertItemClickAction;", "Lcom/avito/android/extended_profile/adapter/category/category_advert/CategoryAdvertItemAction;", "Lcom/avito/android/serp/adapter/AdvertItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/AdvertItem;", "getAdvert", "()Lcom/avito/android/serp/adapter/AdvertItem;", "advert", "Lcom/avito/android/remote/model/Image;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "image", "", "c", "Ljava/lang/Integer;", "getGalleryPosition", "()Ljava/lang/Integer;", "galleryPosition", "<init>", "(Lcom/avito/android/serp/adapter/AdvertItem;Lcom/avito/android/remote/model/Image;Ljava/lang/Integer;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class AdvertItemClickAction extends CategoryAdvertItemAction {
        @NotNull
        public final AdvertItem a;
        @Nullable
        public final Image b;
        @Nullable
        public final Integer c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AdvertItemClickAction(@NotNull AdvertItem advertItem, @Nullable Image image, @Nullable Integer num) {
            super(null);
            Intrinsics.checkNotNullParameter(advertItem, "advert");
            this.a = advertItem;
            this.b = image;
            this.c = num;
        }

        @NotNull
        public final AdvertItem getAdvert() {
            return this.a;
        }

        @Nullable
        public final Integer getGalleryPosition() {
            return this.c;
        }

        @Nullable
        public final Image getImage() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/extended_profile/adapter/category/category_advert/CategoryAdvertItemAction$FavoriteClickAction;", "Lcom/avito/android/extended_profile/adapter/category/category_advert/CategoryAdvertItemAction;", "Lcom/avito/android/extended_profile/adapter/category/category_advert/CategoryAdvertItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/extended_profile/adapter/category/category_advert/CategoryAdvertItem;", "getItem", "()Lcom/avito/android/extended_profile/adapter/category/category_advert/CategoryAdvertItem;", "item", "<init>", "(Lcom/avito/android/extended_profile/adapter/category/category_advert/CategoryAdvertItem;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
    public static final class FavoriteClickAction extends CategoryAdvertItemAction {
        @NotNull
        public final CategoryAdvertItem a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FavoriteClickAction(@NotNull CategoryAdvertItem categoryAdvertItem) {
            super(null);
            Intrinsics.checkNotNullParameter(categoryAdvertItem, "item");
            this.a = categoryAdvertItem;
        }

        @NotNull
        public final CategoryAdvertItem getItem() {
            return this.a;
        }
    }

    public CategoryAdvertItemAction() {
    }

    public CategoryAdvertItemAction(j jVar) {
    }
}
