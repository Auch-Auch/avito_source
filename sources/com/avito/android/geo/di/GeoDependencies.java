package com.avito.android.geo.di;

import com.avito.android.di.ComponentDependencies;
import com.avito.android.geo.GeoStorage;
import com.avito.android.server_time.TimeSource;
import com.avito.android.version_conflict.ConfigStorage;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/geo/di/GeoDependencies;", "Lcom/avito/android/di/ComponentDependencies;", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "()Lcom/avito/android/server_time/TimeSource;", "Lcom/avito/android/geo/GeoStorage;", "geoStorage", "()Lcom/avito/android/geo/GeoStorage;", "Lcom/avito/android/version_conflict/ConfigStorage;", "configStorage", "()Lcom/avito/android/version_conflict/ConfigStorage;", "geo_release"}, k = 1, mv = {1, 4, 2})
public interface GeoDependencies extends ComponentDependencies {
    @NotNull
    ConfigStorage configStorage();

    @Override // com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.messenger.map.viewing.di.PlatformMapFragmentDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies
    @NotNull
    GeoStorage geoStorage();

    @Override // com.avito.android.search.filter.di.FiltersDependencies, com.avito.android.deep_linking.di.AppLinkDependencies, com.avito.android.certificate_pinning.di.UnsafeNetworkDependencies, com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponentDependencies, com.avito.android.messenger.di.MessageIsReadMarkerDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies, com.avito.android.messenger.di.DirectReplyServiceDependencies, com.avito.android.messenger.map.viewing.di.PlatformMapFragmentDependencies, com.avito.android.deep_linking.di.DeepLinkingDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies, com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.player.di.PlayerFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    TimeSource timeSource();
}
