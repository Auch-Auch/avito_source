package com.avito.android;

import android.content.Intent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.geo.GeoMarker;
import com.avito.android.remote.model.messenger.geo.GeoPoint;
import com.avito.android.remote.model.messenger.geo.MarkersRequest;
import com.avito.android.remote.model.messenger.message.MessageBody;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J-\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\t\u0010\nJE\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0015\u001a\u00020\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0015\u0010\nJ\u000f\u0010\u0016\u001a\u00020\u0006H&¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H&¢\u0006\u0004\b\u0018\u0010\u0017J)\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u001a\u0010\bJ9\u0010\"\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010!\u001a\u00020\u0010H&¢\u0006\u0004\b\"\u0010#J!\u0010&\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010$H&¢\u0006\u0004\b&\u0010'J3\u0010,\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010+\u001a\u0004\u0018\u00010)H&¢\u0006\u0004\b,\u0010-J)\u00101\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\f2\b\b\u0002\u00100\u001a\u00020\fH&¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u00062\u0006\u00103\u001a\u00020\fH&¢\u0006\u0004\b4\u00105¨\u00066"}, d2 = {"Lcom/avito/android/MessengerIntentFactory;", "", "", "itemId", "messageDraft", "source", "Landroid/content/Intent;", "createChannelByItemIdIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "createChannelWithAvito", "(Ljava/lang/String;)Landroid/content/Intent;", "channelId", "", "numberInList", "messageId", "searchQuery", "", "backWorksAsUp", "channelIntent", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Z)Landroid/content/Intent;", BookingInfoActivity.EXTRA_ITEM_ID, "channelsIntent", "channelsSearchIntent", "()Landroid/content/Intent;", "blacklistIntent", ChannelContext.Item.USER_ID, "blacklistReasonsIntent", "title", "", "Lcom/avito/android/remote/model/messenger/geo/GeoMarker;", "initialGeoMarkers", "Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;", "markersRequest", "lockBottomSheet", "messengerPlatformMapIntent", "(Ljava/lang/String;[Lcom/avito/android/remote/model/messenger/geo/GeoMarker;Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;Z)Landroid/content/Intent;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "initialPosition", "sharingMapIntent", "(Ljava/lang/String;Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;)Landroid/content/Intent;", "initialQuery", "Lcom/avito/android/remote/model/messenger/geo/GeoPoint;", "centerPoint", "itemLocation", "geoSearchIntent", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/geo/GeoPoint;Lcom/avito/android/remote/model/messenger/geo/GeoPoint;)Landroid/content/Intent;", "operationId", "maxPhotoCount", "minPhotoCount", "createPhotoPickerIntentForMessenger", "(Ljava/lang/String;II)Landroid/content/Intent;", "problemId", "supportChatFormIntent", "(I)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface MessengerIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent channelIntent$default(MessengerIntentFactory messengerIntentFactory, String str, Integer num, String str2, String str3, boolean z, int i, Object obj) {
            if (obj == null) {
                return messengerIntentFactory.channelIntent(str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? false : z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: channelIntent");
        }

        public static /* synthetic */ Intent channelsIntent$default(MessengerIntentFactory messengerIntentFactory, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                return messengerIntentFactory.channelsIntent(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: channelsIntent");
        }

        public static /* synthetic */ Intent createChannelByItemIdIntent$default(MessengerIntentFactory messengerIntentFactory, String str, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    str3 = null;
                }
                return messengerIntentFactory.createChannelByItemIdIntent(str, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createChannelByItemIdIntent");
        }

        public static /* synthetic */ Intent createChannelWithAvito$default(MessengerIntentFactory messengerIntentFactory, String str, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                return messengerIntentFactory.createChannelWithAvito(str);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createChannelWithAvito");
        }

        public static /* synthetic */ Intent createPhotoPickerIntentForMessenger$default(MessengerIntentFactory messengerIntentFactory, String str, int i, int i2, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    i2 = 0;
                }
                return messengerIntentFactory.createPhotoPickerIntentForMessenger(str, i, i2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createPhotoPickerIntentForMessenger");
        }

        public static /* synthetic */ Intent messengerPlatformMapIntent$default(MessengerIntentFactory messengerIntentFactory, String str, GeoMarker[] geoMarkerArr, MarkersRequest markersRequest, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 8) != 0) {
                    z = false;
                }
                return messengerIntentFactory.messengerPlatformMapIntent(str, geoMarkerArr, markersRequest, z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: messengerPlatformMapIntent");
        }
    }

    @NotNull
    Intent blacklistIntent();

    @NotNull
    Intent blacklistReasonsIntent(@NotNull String str, @NotNull String str2, @Nullable String str3);

    @NotNull
    Intent channelIntent(@NotNull String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, boolean z);

    @NotNull
    Intent channelsIntent(@Nullable String str);

    @NotNull
    Intent channelsSearchIntent();

    @NotNull
    Intent createChannelByItemIdIntent(@NotNull String str, @Nullable String str2, @Nullable String str3);

    @NotNull
    Intent createChannelWithAvito(@Nullable String str);

    @NotNull
    Intent createPhotoPickerIntentForMessenger(@NotNull String str, int i, int i2);

    @NotNull
    Intent geoSearchIntent(@NotNull String str, @NotNull String str2, @Nullable GeoPoint geoPoint, @Nullable GeoPoint geoPoint2);

    @NotNull
    Intent messengerPlatformMapIntent(@NotNull String str, @NotNull GeoMarker[] geoMarkerArr, @Nullable MarkersRequest markersRequest, boolean z);

    @NotNull
    Intent sharingMapIntent(@NotNull String str, @Nullable MessageBody.Location location);

    @NotNull
    Intent supportChatFormIntent(int i);
}
