package com.avito.android.blocked_ip.di;

import com.avito.android.ActivityIntentFactory;
import com.avito.android.di.ComponentDependencies;
import com.avito.android.util.ImplicitIntentFactory;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/blocked_ip/di/BlockedIpDependencies;", "Lcom/avito/android/di/ComponentDependencies;", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "blocked-ip_release"}, k = 1, mv = {1, 4, 2})
public interface BlockedIpDependencies extends ComponentDependencies {
    @Override // com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.short_term_rent.di.component.HotelsDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.suggest_locations.di.SuggestLocationsDependencies, com.avito.android.rating.review_details.di.ReviewDetailsDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies
    @NotNull
    ActivityIntentFactory activityIntentFactory();

    @Override // com.avito.android.details_sheet.di.DetailsSheetActivityDependencies, com.avito.android.item_map.di.ItemMapDependencies
    @NotNull
    ImplicitIntentFactory implicitIntentFactory();
}
