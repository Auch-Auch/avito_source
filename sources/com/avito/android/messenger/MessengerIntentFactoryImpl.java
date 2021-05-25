package com.avito.android.messenger;

import android.app.Application;
import android.content.Intent;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.MessengerIntentFactory;
import com.avito.android.PublishIntentFactory;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.messenger.blacklist.mvi.BlacklistActivity;
import com.avito.android.messenger.blacklist_reasons.BlacklistReasonsActivityKt;
import com.avito.android.messenger.channels.ChannelsFragmentData;
import com.avito.android.messenger.conversation.ChannelActivityArguments;
import com.avito.android.messenger.conversation.ChannelActivityFragmentData;
import com.avito.android.messenger.conversation.ChannelActivityKt;
import com.avito.android.messenger.map.search.GeoSearchActivity;
import com.avito.android.messenger.map.sharing.SharingMapActivity;
import com.avito.android.messenger.map.viewing.PlatformMapActivity;
import com.avito.android.messenger.search.ChannelsSearchActivityKt;
import com.avito.android.messenger.support.SupportChatFormActivity;
import com.avito.android.navigation.NavigationTabProvider;
import com.avito.android.photo_picker.PhotoPickerActivityKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.geo.GeoMarker;
import com.avito.android.remote.model.messenger.geo.GeoPoint;
import com.avito.android.remote.model.messenger.geo.MarkersRequest;
import com.avito.android.remote.model.messenger.message.MessageBody;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u00109\u001a\u000206\u0012\u0006\u0010=\u001a\u00020:\u0012\u0006\u0010E\u001a\u00020B\u0012\u0006\u0010A\u001a\u00020>¢\u0006\u0004\bF\u0010GJ+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\t\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ=\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0015\u0010\nJ\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J)\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\bJ7\u0010\"\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\"\u0010#J!\u0010&\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b&\u0010'J3\u0010,\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010)2\b\u0010+\u001a\u0004\u0018\u00010)H\u0016¢\u0006\u0004\b,\u0010-J'\u00101\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\f2\u0006\u00100\u001a\u00020\fH\u0016¢\u0006\u0004\b1\u00102J\u0017\u00104\u001a\u00020\u00062\u0006\u00103\u001a\u00020\fH\u0016¢\u0006\u0004\b4\u00105R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010D¨\u0006H"}, d2 = {"Lcom/avito/android/messenger/MessengerIntentFactoryImpl;", "Lcom/avito/android/MessengerIntentFactory;", "", "itemId", "messageDraft", "source", "Landroid/content/Intent;", "createChannelByItemIdIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "createChannelWithAvito", "(Ljava/lang/String;)Landroid/content/Intent;", "channelId", "", "numberInList", "messageId", "searchQuery", "", "backWorksAsUp", "channelIntent", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Z)Landroid/content/Intent;", BookingInfoActivity.EXTRA_ITEM_ID, "channelsIntent", "channelsSearchIntent", "()Landroid/content/Intent;", "blacklistIntent", ChannelContext.Item.USER_ID, "blacklistReasonsIntent", "title", "", "Lcom/avito/android/remote/model/messenger/geo/GeoMarker;", "initialGeoMarkers", "Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;", "markersRequest", "lockBottomSheet", "messengerPlatformMapIntent", "(Ljava/lang/String;[Lcom/avito/android/remote/model/messenger/geo/GeoMarker;Lcom/avito/android/remote/model/messenger/geo/MarkersRequest;Z)Landroid/content/Intent;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "initialPosition", "sharingMapIntent", "(Ljava/lang/String;Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;)Landroid/content/Intent;", "initialQuery", "Lcom/avito/android/remote/model/messenger/geo/GeoPoint;", "centerPoint", "itemLocation", "geoSearchIntent", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/geo/GeoPoint;Lcom/avito/android/remote/model/messenger/geo/GeoPoint;)Landroid/content/Intent;", "operationId", "maxPhotoCount", "minPhotoCount", "createPhotoPickerIntentForMessenger", "(Ljava/lang/String;II)Landroid/content/Intent;", "problemId", "supportChatFormIntent", "(I)Landroid/content/Intent;", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "Lcom/avito/android/CoreActivityIntentFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/CoreActivityIntentFactory;", "coreActivityIntentFactory", "Lcom/avito/android/Features;", "d", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/navigation/NavigationTabProvider;", "c", "Lcom/avito/android/navigation/NavigationTabProvider;", "tabProvider", "<init>", "(Landroid/app/Application;Lcom/avito/android/CoreActivityIntentFactory;Lcom/avito/android/navigation/NavigationTabProvider;Lcom/avito/android/Features;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerIntentFactoryImpl implements MessengerIntentFactory {
    public final Application a;
    public final CoreActivityIntentFactory b;
    public final NavigationTabProvider c;
    public final Features d;

    @Inject
    public MessengerIntentFactoryImpl(@NotNull Application application, @NotNull CoreActivityIntentFactory coreActivityIntentFactory, @NotNull NavigationTabProvider navigationTabProvider, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(application, "context");
        Intrinsics.checkNotNullParameter(coreActivityIntentFactory, "coreActivityIntentFactory");
        Intrinsics.checkNotNullParameter(navigationTabProvider, "tabProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = application;
        this.b = coreActivityIntentFactory;
        this.c = navigationTabProvider;
        this.d = features;
    }

    @Override // com.avito.android.MessengerIntentFactory
    @NotNull
    public Intent blacklistIntent() {
        return new Intent(this.a, BlacklistActivity.class);
    }

    @Override // com.avito.android.MessengerIntentFactory
    @NotNull
    public Intent blacklistReasonsIntent(@NotNull String str, @NotNull String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str2, "channelId");
        return BlacklistReasonsActivityKt.createBlacklistReasonsActivityIntent(this.a, str, str2, str3);
    }

    @Override // com.avito.android.MessengerIntentFactory
    @NotNull
    public Intent channelIntent(@NotNull String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        ChannelActivityArguments.Open open = new ChannelActivityArguments.Open(str, num, str2, str3, z);
        if (!this.d.getChannelWithoutActivity().invoke().booleanValue() || this.c.currentTab() == null) {
            return ChannelActivityKt.createChannelActivityIntent(this.a, open);
        }
        return this.b.mainScreenWithTab(new ChannelActivityFragmentData(open));
    }

    @Override // com.avito.android.MessengerIntentFactory
    @NotNull
    public Intent channelsIntent(@Nullable String str) {
        return this.b.mainScreenWithTab(new ChannelsFragmentData());
    }

    @Override // com.avito.android.MessengerIntentFactory
    @NotNull
    public Intent channelsSearchIntent() {
        return ChannelsSearchActivityKt.createChannelsSearchIntent(this.a);
    }

    @Override // com.avito.android.MessengerIntentFactory
    @NotNull
    public Intent createChannelByItemIdIntent(@NotNull String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        ChannelActivityArguments.Create.ByItem byItem = new ChannelActivityArguments.Create.ByItem(str, str2, str3);
        if (!this.d.getChannelWithoutActivity().invoke().booleanValue() || this.c.currentTab() == null) {
            return ChannelActivityKt.createChannelActivityIntent(this.a, byItem);
        }
        return this.b.mainScreenWithTab(new ChannelActivityFragmentData(byItem));
    }

    @Override // com.avito.android.MessengerIntentFactory
    @NotNull
    public Intent createChannelWithAvito(@Nullable String str) {
        ChannelActivityArguments.Create.WithAvito withAvito = new ChannelActivityArguments.Create.WithAvito(str);
        if (!this.d.getChannelWithoutActivity().invoke().booleanValue() || this.c.currentTab() == null) {
            return ChannelActivityKt.createChannelActivityIntent(this.a, withAvito);
        }
        return this.b.mainScreenWithTab(new ChannelActivityFragmentData(withAvito));
    }

    @Override // com.avito.android.MessengerIntentFactory
    @NotNull
    public Intent createPhotoPickerIntentForMessenger(@NotNull String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "operationId");
        return PhotoPickerActivityKt.createPhotoPickerActivityIntent$default(this.a, str, "messenger", i2, i, null, false, false, null, PublishIntentFactory.PhotoPickerMode.MODE_ADD, 480, null);
    }

    @Override // com.avito.android.MessengerIntentFactory
    @NotNull
    public Intent geoSearchIntent(@NotNull String str, @NotNull String str2, @Nullable GeoPoint geoPoint, @Nullable GeoPoint geoPoint2) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "initialQuery");
        return GeoSearchActivity.Companion.createIntent(this.a, str, str2, geoPoint, geoPoint2);
    }

    @Override // com.avito.android.MessengerIntentFactory
    @NotNull
    public Intent messengerPlatformMapIntent(@NotNull String str, @NotNull GeoMarker[] geoMarkerArr, @Nullable MarkersRequest markersRequest, boolean z) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(geoMarkerArr, "initialGeoMarkers");
        return PlatformMapActivity.Companion.createIntent(this.a, str, geoMarkerArr, markersRequest, z);
    }

    @Override // com.avito.android.MessengerIntentFactory
    @NotNull
    public Intent sharingMapIntent(@NotNull String str, @Nullable MessageBody.Location location) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        return SharingMapActivity.Companion.createIntent(this.a, str, location);
    }

    @Override // com.avito.android.MessengerIntentFactory
    @NotNull
    public Intent supportChatFormIntent(int i) {
        return SupportChatFormActivity.Companion.createIntent(this.a, i);
    }
}
