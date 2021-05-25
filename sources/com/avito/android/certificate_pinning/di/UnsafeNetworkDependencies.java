package com.avito.android.certificate_pinning.di;

import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.remote.interceptor.CertificatePinningInterceptor;
import com.avito.android.remote.interceptor.UserAgentHeaderProvider;
import com.avito.android.server_time.ServerTimeSource;
import com.avito.android.server_time.TimeSource;
import kotlin.Metadata;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/certificate_pinning/di/UnsafeNetworkDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/remote/interceptor/CertificatePinningInterceptor;", "certificatePinningInterceptor", "()Lcom/avito/android/remote/interceptor/CertificatePinningInterceptor;", "Lokhttp3/OkHttpClient;", "okHttpClient", "()Lokhttp3/OkHttpClient;", "Lcom/avito/android/server_time/ServerTimeSource;", "serverTimeSource", "()Lcom/avito/android/server_time/ServerTimeSource;", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "()Lcom/avito/android/server_time/TimeSource;", "Lcom/avito/android/remote/interceptor/UserAgentHeaderProvider;", "userAgentHeaderProvider", "()Lcom/avito/android/remote/interceptor/UserAgentHeaderProvider;", "unsafe-network_release"}, k = 1, mv = {1, 4, 2})
public interface UnsafeNetworkDependencies extends CoreComponentDependencies {
    @NotNull
    CertificatePinningInterceptor certificatePinningInterceptor();

    @Override // com.avito.android.messenger.conversation.mvi.file_download.FileDownloadWorkerComponentDependencies
    @NotNull
    OkHttpClient okHttpClient();

    @NotNull
    ServerTimeSource serverTimeSource();

    @Override // com.avito.android.messenger.di.ChannelActivityDependencies, com.avito.android.messenger.blacklist.mvi.di.BlacklistFragmentComponentDependencies, com.avito.android.messenger.di.MessageIsReadMarkerDependencies, com.avito.android.messenger.search.di.ChannelsSearchComponentDependencies, com.avito.android.messenger.channels.mvi.di.ChannelsDependencies, com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies, com.avito.android.messenger.di.DirectReplyServiceDependencies, com.avito.android.messenger.map.viewing.di.PlatformMapFragmentDependencies, com.avito.android.deep_linking.di.DeepLinkingDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.advert.di.AdvertFragmentDependencies, com.avito.android.short_term_rent.di.component.StrBookingCommonDependencies, com.avito.android.str_calendar.di.component.StrBookingCommonDependencies, com.avito.android.item_map.di.ItemMapDependencies, com.avito.android.location_picker.di.LocationPickerDependencies, com.avito.android.in_app_calls.di.CallActivityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.in_app_calls.di.CallManagerServiceComponentDependencies, com.avito.android.app_rater.di.AppRaterDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.player.di.PlayerFragmentDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    TimeSource timeSource();

    @NotNull
    UserAgentHeaderProvider userAgentHeaderProvider();
}
