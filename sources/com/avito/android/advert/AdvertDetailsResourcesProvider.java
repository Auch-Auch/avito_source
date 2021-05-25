package com.avito.android.advert;

import com.avito.android.booking.info.BookingInfoActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004J!\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0002H&¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0002H&¢\u0006\u0004\b\u0018\u0010\u0004¨\u0006\u0019"}, d2 = {"Lcom/avito/android/advert/AdvertDetailsResourcesProvider;", "", "", "getAddedToFavorites", "()Ljava/lang/String;", "getRemovedFromFavorites", "getFavoritesFull", "getPrivatePerson", "getAutoCatalogButtonTitle", "query", "getSearchHeaderWithQuery", "(Ljava/lang/String;)Ljava/lang/String;", "getSearchHeader", BookingInfoActivity.EXTRA_ITEM_ID, "", "advertTime", "getAdvertNumberFormatted", "(Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/String;", "", "totalViews", "getAdvertStatsPlurals", "(I)Ljava/lang/String;", "getMarketplaceSpecsTitle", "getMarketplaceSpecsButtonTitle", "getDescriptionTitle", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertDetailsResourcesProvider {
    @NotNull
    String getAddedToFavorites();

    @NotNull
    String getAdvertNumberFormatted(@NotNull String str, @Nullable Long l);

    @NotNull
    String getAdvertStatsPlurals(int i);

    @NotNull
    String getAutoCatalogButtonTitle();

    @NotNull
    String getDescriptionTitle();

    @NotNull
    String getFavoritesFull();

    @NotNull
    String getMarketplaceSpecsButtonTitle();

    @NotNull
    String getMarketplaceSpecsTitle();

    @NotNull
    String getPrivatePerson();

    @NotNull
    String getRemovedFromFavorites();

    @NotNull
    String getSearchHeader();

    @NotNull
    String getSearchHeaderWithQuery(@NotNull String str);
}
