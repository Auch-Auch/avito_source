package com.avito.android.advert;

import android.content.res.Resources;
import com.avito.android.advert_details.R;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.date_time_formatter.DateTimeFormatter;
import com.avito.android.di.module.DateTimeFormatterModule;
import com.avito.android.remote.auth.AuthSource;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\b\b\u0001\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b!\u0010\"J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J\u000f\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0004J\u0017\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J!\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0004J\u000f\u0010\u0017\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0004J\u000f\u0010\u0018\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0004R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/avito/android/advert/AdvertDetailsResourcesProviderImpl;", "Lcom/avito/android/advert/AdvertDetailsResourcesProvider;", "", "getAddedToFavorites", "()Ljava/lang/String;", "getRemovedFromFavorites", "getFavoritesFull", "getPrivatePerson", "getAutoCatalogButtonTitle", "query", "getSearchHeaderWithQuery", "(Ljava/lang/String;)Ljava/lang/String;", "getSearchHeader", BookingInfoActivity.EXTRA_ITEM_ID, "", "advertTime", "getAdvertNumberFormatted", "(Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/String;", "", "totalViews", "getAdvertStatsPlurals", "(I)Ljava/lang/String;", "getMarketplaceSpecsTitle", "getMarketplaceSpecsButtonTitle", "getDescriptionTitle", "Lcom/avito/android/date_time_formatter/DateTimeFormatter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/date_time_formatter/DateTimeFormatter;", "dateFormatter", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", "<init>", "(Lcom/avito/android/date_time_formatter/DateTimeFormatter;Landroid/content/res/Resources;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsResourcesProviderImpl implements AdvertDetailsResourcesProvider {
    public final DateTimeFormatter a;
    public final Resources b;

    @Inject
    public AdvertDetailsResourcesProviderImpl(@DateTimeFormatterModule.UpperCase @NotNull DateTimeFormatter dateTimeFormatter, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(dateTimeFormatter, "dateFormatter");
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = dateTimeFormatter;
        this.b = resources;
    }

    @Override // com.avito.android.advert.AdvertDetailsResourcesProvider
    @NotNull
    public String getAddedToFavorites() {
        String string = this.b.getString(R.string.advert_added_to_fav);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.advert_added_to_fav)");
        return string;
    }

    @Override // com.avito.android.advert.AdvertDetailsResourcesProvider
    @NotNull
    public String getAdvertNumberFormatted(@NotNull String str, @Nullable Long l) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        String string = this.b.getString(com.avito.android.advert_core.R.string.rds_advert_number_template, str, this.a.format(l, TimeUnit.SECONDS));
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(\n   …meUnit.SECONDS)\n        )");
        return string;
    }

    @Override // com.avito.android.advert.AdvertDetailsResourcesProvider
    @NotNull
    public String getAdvertStatsPlurals(int i) {
        String quantityString = this.b.getQuantityString(R.plurals.views, i, Integer.valueOf(i));
        Intrinsics.checkNotNullExpressionValue(quantityString, "resources.getQuantityStr…, totalViews, totalViews)");
        return quantityString;
    }

    @Override // com.avito.android.advert.AdvertDetailsResourcesProvider
    @NotNull
    public String getAutoCatalogButtonTitle() {
        String string = this.b.getString(R.string.auto_catalog_button_title);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…uto_catalog_button_title)");
        return string;
    }

    @Override // com.avito.android.advert.AdvertDetailsResourcesProvider
    @NotNull
    public String getDescriptionTitle() {
        String string = this.b.getString(R.string.advert_details_description_title);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…etails_description_title)");
        return string;
    }

    @Override // com.avito.android.advert.AdvertDetailsResourcesProvider
    @NotNull
    public String getFavoritesFull() {
        String string = this.b.getString(com.avito.android.favorite_core.R.string.favorites_is_full);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(favo…string.favorites_is_full)");
        return string;
    }

    @Override // com.avito.android.advert.AdvertDetailsResourcesProvider
    @NotNull
    public String getMarketplaceSpecsButtonTitle() {
        String string = this.b.getString(R.string.marketplace_specs_button_title);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…place_specs_button_title)");
        return string;
    }

    @Override // com.avito.android.advert.AdvertDetailsResourcesProvider
    @NotNull
    public String getMarketplaceSpecsTitle() {
        String string = this.b.getString(R.string.marketplace_specs_title);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st….marketplace_specs_title)");
        return string;
    }

    @Override // com.avito.android.advert.AdvertDetailsResourcesProvider
    @NotNull
    public String getPrivatePerson() {
        String string = this.b.getString(R.string.private_person);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.private_person)");
        return string;
    }

    @Override // com.avito.android.advert.AdvertDetailsResourcesProvider
    @NotNull
    public String getRemovedFromFavorites() {
        String string = this.b.getString(R.string.advert_removed_from_fav);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st….advert_removed_from_fav)");
        return string;
    }

    @Override // com.avito.android.advert.AdvertDetailsResourcesProvider
    @NotNull
    public String getSearchHeader() {
        String string = this.b.getString(R.string.search_results);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.search_results)");
        return string;
    }

    @Override // com.avito.android.advert.AdvertDetailsResourcesProvider
    @NotNull
    public String getSearchHeaderWithQuery(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "query");
        String string = this.b.getString(R.string.search_results_template, str);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st…_results_template, query)");
        return string;
    }
}
