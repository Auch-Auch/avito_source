package com.avito.android.favorites;

import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertPrice;
import com.avito.android.util.Formatter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u0018J-\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/favorites/FavoriteAdvertItemConverterImpl;", "Lcom/avito/android/favorites/FavoriteAdvertItemConverter;", "", "Lcom/avito/android/remote/model/FavoriteAdvert;", "adverts", "Lcom/avito/android/remote/model/References;", "references", "Lcom/avito/android/favorite/FavoriteModel;", "convert", "(Ljava/util/List;Lcom/avito/android/remote/model/References;)Ljava/util/List;", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/favorites/FavoriteAdvertItemConverterResourceProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/favorites/FavoriteAdvertItemConverterResourceProvider;", "resourceProvider", "Lcom/avito/android/util/Formatter;", "Lcom/avito/android/remote/model/AdvertPrice;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/Formatter;", "priceFormatter", "<init>", "(Lcom/avito/android/util/Formatter;Lcom/avito/android/favorites/FavoriteAdvertItemConverterResourceProvider;Lcom/avito/android/Features;)V", "favorite-core_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteAdvertItemConverterImpl implements FavoriteAdvertItemConverter {
    public final Formatter<AdvertPrice> a;
    public final FavoriteAdvertItemConverterResourceProvider b;
    public final Features c;

    @Inject
    public FavoriteAdvertItemConverterImpl(@NotNull Formatter<AdvertPrice> formatter, @NotNull FavoriteAdvertItemConverterResourceProvider favoriteAdvertItemConverterResourceProvider, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(formatter, "priceFormatter");
        Intrinsics.checkNotNullParameter(favoriteAdvertItemConverterResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = formatter;
        this.b = favoriteAdvertItemConverterResourceProvider;
        this.c = features;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01a5  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01b0  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01c6  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01ca  */
    @Override // com.avito.android.favorites.FavoriteAdvertItemConverter
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.avito.android.favorite.FavoriteModel> convert(@org.jetbrains.annotations.NotNull java.util.List<com.avito.android.remote.model.FavoriteAdvert> r31, @org.jetbrains.annotations.Nullable com.avito.android.remote.model.References r32) {
        /*
        // Method dump skipped, instructions count: 510
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.favorites.FavoriteAdvertItemConverterImpl.convert(java.util.List, com.avito.android.remote.model.References):java.util.List");
    }
}
