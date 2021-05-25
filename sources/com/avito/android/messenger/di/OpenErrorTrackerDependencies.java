package com.avito.android.messenger.di;

import com.avito.android.account.AccountStateProvider;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.messenger.conversation.mvi.data.MessageBodySerializer;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.android.persistence.messenger.MessengerDatabase;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/di/OpenErrorTrackerDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/messenger/conversation/mvi/data/MessageBodySerializer;", "messageBodySerializer", "()Lcom/avito/android/messenger/conversation/mvi/data/MessageBodySerializer;", "Lru/avito/android/persistence/messenger/MessengerDatabase;", "messengerDatabase", "()Lru/avito/android/persistence/messenger/MessengerDatabase;", "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "()Lcom/avito/android/account/AccountStateProvider;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface OpenErrorTrackerDependencies extends CoreComponentDependencies {
    @Override // com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies, com.avito.android.messenger.di.UpdateUnreadMessagesCountDependencies, com.avito.android.messenger.conversation.mvi.file_download.FileDownloadWorkerComponentDependencies, com.avito.android.photo_gallery.di.PhotoGalleryDependencies, com.avito.android.user_advert.di.MyAdvertDetailsDependencies, com.avito.android.short_term_rent.di.component.StrStartBookingDependencies, com.avito.android.messenger.map.search.di.GeoSearchFragmentDependencies, com.avito.android.in_app_calls.workers.CallAvailabilityComponentDependencies, com.avito.android.in_app_calls.ui.call.CallFragmentComponentDependencies, com.avito.android.safedeal.delivery_courier.di.component.DeliveryCourierCommonDependencies, com.avito.android.safedeal.delivery_type.di.DeliveryTypeDependencies, com.avito.android.advert_core.phone_request.di.PhoneRequestDeepLinkDependencies, com.avito.android.booking.di.BookingOrderDependencies, com.avito.android.brandspace.di.BrandspaceFragmentDependencies, com.avito.android.cart.di.deps.CartSummaryDependencies, com.avito.android.extended_profile.di.ExtendedProfileDependencies, com.avito.android.similar_adverts.di.SimilarAdvertsDependencies
    @NotNull
    AccountStateProvider accountStateProvider();

    @Override // com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies
    @NotNull
    MessageBodySerializer messageBodySerializer();

    @Override // com.avito.android.messenger.di.SendPendingMessagesWorkerComponentDependencies
    @NotNull
    MessengerDatabase messengerDatabase();
}
