package com.avito.android.favorite_sellers.adapter.recommendation.adapter.seller_carousel;

import a2.b.a.a.a;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b \u0010!J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J4\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0007R\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001c\u0010\u0007R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/AdvertWithOverlay;", "", "Lcom/avito/android/image_loader/Picture;", "component1", "()Lcom/avito/android/image_loader/Picture;", "", "component2", "()Ljava/lang/CharSequence;", "component3", "picture", "title", MessengerShareContentUtility.SUBTITLE, "copy", "(Lcom/avito/android/image_loader/Picture;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Lcom/avito/android/favorite_sellers/adapter/recommendation/adapter/seller_carousel/AdvertWithOverlay;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/CharSequence;", "getTitle", "c", "getSubtitle", AuthSource.SEND_ABUSE, "Lcom/avito/android/image_loader/Picture;", "getPicture", "<init>", "(Lcom/avito/android/image_loader/Picture;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertWithOverlay {
    @Nullable
    public final Picture a;
    @Nullable
    public final CharSequence b;
    @Nullable
    public final CharSequence c;

    public AdvertWithOverlay(@Nullable Picture picture, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        this.a = picture;
        this.b = charSequence;
        this.c = charSequence2;
    }

    public static /* synthetic */ AdvertWithOverlay copy$default(AdvertWithOverlay advertWithOverlay, Picture picture, CharSequence charSequence, CharSequence charSequence2, int i, Object obj) {
        if ((i & 1) != 0) {
            picture = advertWithOverlay.a;
        }
        if ((i & 2) != 0) {
            charSequence = advertWithOverlay.b;
        }
        if ((i & 4) != 0) {
            charSequence2 = advertWithOverlay.c;
        }
        return advertWithOverlay.copy(picture, charSequence, charSequence2);
    }

    @Nullable
    public final Picture component1() {
        return this.a;
    }

    @Nullable
    public final CharSequence component2() {
        return this.b;
    }

    @Nullable
    public final CharSequence component3() {
        return this.c;
    }

    @NotNull
    public final AdvertWithOverlay copy(@Nullable Picture picture, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        return new AdvertWithOverlay(picture, charSequence, charSequence2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdvertWithOverlay)) {
            return false;
        }
        AdvertWithOverlay advertWithOverlay = (AdvertWithOverlay) obj;
        return Intrinsics.areEqual(this.a, advertWithOverlay.a) && Intrinsics.areEqual(this.b, advertWithOverlay.b) && Intrinsics.areEqual(this.c, advertWithOverlay.c);
    }

    @Nullable
    public final Picture getPicture() {
        return this.a;
    }

    @Nullable
    public final CharSequence getSubtitle() {
        return this.c;
    }

    @Nullable
    public final CharSequence getTitle() {
        return this.b;
    }

    public int hashCode() {
        Picture picture = this.a;
        int i = 0;
        int hashCode = (picture != null ? picture.hashCode() : 0) * 31;
        CharSequence charSequence = this.b;
        int hashCode2 = (hashCode + (charSequence != null ? charSequence.hashCode() : 0)) * 31;
        CharSequence charSequence2 = this.c;
        if (charSequence2 != null) {
            i = charSequence2.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("AdvertWithOverlay(picture=");
        L.append(this.a);
        L.append(", title=");
        L.append(this.b);
        L.append(", subtitle=");
        L.append(this.c);
        L.append(")");
        return L.toString();
    }
}
