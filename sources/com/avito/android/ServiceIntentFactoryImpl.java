package com.avito.android;

import a2.b.a.a.a;
import android.content.Intent;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.remote.model.messenger.message.MessageBody;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0012\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B)\b\u0007\u0012\u0006\u0010,\u001a\u00020\u0002\u0012\u0006\u0010-\u001a\u00020\u0003\u0012\u0006\u0010.\u001a\u00020\u0004\u0012\u0006\u0010/\u001a\u00020\u0005¢\u0006\u0004\b0\u00101J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\t\u0010\nJ*\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J0\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J2\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006H\u0001¢\u0006\u0004\b\u0015\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u001c\u0010\u001dJH\u0010\"\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0014\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010 H\u0001¢\u0006\u0004\b\"\u0010#JF\u0010%\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060 H\u0001¢\u0006\u0004\b%\u0010#JN\u0010'\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060 H\u0001¢\u0006\u0004\b'\u0010(JN\u0010*\u001a\u00020\u000f2\u0006\u0010$\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001f\u001a\u00020\u00062\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060 H\u0001¢\u0006\u0004\b*\u0010+¨\u00062"}, d2 = {"Lcom/avito/android/ServiceIntentFactoryImpl;", "Lcom/avito/android/ServiceIntentFactory;", "Lcom/avito/android/MessengerServiceIntentFactory;", "Lcom/avito/android/NotificationServiceIntentFactory;", "Lcom/avito/android/FavoriteSellerServiceIntentFactory;", "Lcom/avito/android/UserAdvertServiceIntentFactory;", "", "channelId", "", "channelSyncOnPushServiceEnqueueWork", "(Ljava/lang/String;)V", "operationId", "toString", "", "uploadAfterNonRestorableError", "Landroid/content/Intent;", "imageUploadServiceIntent", "(Ljava/lang/String;Ljava/lang/String;Z)Landroid/content/Intent;", "text", "isRetry", MessageBody.RANDOM_ID, "sendMessageServiceIntent", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)Landroid/content/Intent;", "directReplyKey", "", "notificationId", "notificationTag", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Landroid/content/Intent;", "notificationServiceIntent", "()Landroid/content/Intent;", "userKey", "notificationActionName", "", "analyticParameters", "favoriteSellerServiceMuteIntent", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)Landroid/content/Intent;", BookingInfoActivity.EXTRA_ITEM_ID, "userAdvertActivateServiceIntent", "enabled", "userAdvertAutoPublishServiceIntent", "(Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)Landroid/content/Intent;", "reasonId", "userAdvertCloseServiceIntent", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;)Landroid/content/Intent;", "messengerServiceIntentFactory", "notificationServiceIntentFactory", "favoriteSellerServiceIntentFactory", "userAdvertServiceIntentFactory", "<init>", "(Lcom/avito/android/MessengerServiceIntentFactory;Lcom/avito/android/NotificationServiceIntentFactory;Lcom/avito/android/FavoriteSellerServiceIntentFactory;Lcom/avito/android/UserAdvertServiceIntentFactory;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class ServiceIntentFactoryImpl implements ServiceIntentFactory, MessengerServiceIntentFactory, NotificationServiceIntentFactory, FavoriteSellerServiceIntentFactory, UserAdvertServiceIntentFactory {
    public final /* synthetic */ MessengerServiceIntentFactory a;
    public final /* synthetic */ NotificationServiceIntentFactory b;
    public final /* synthetic */ FavoriteSellerServiceIntentFactory c;
    public final /* synthetic */ UserAdvertServiceIntentFactory d;

    @Inject
    public ServiceIntentFactoryImpl(@NotNull MessengerServiceIntentFactory messengerServiceIntentFactory, @NotNull NotificationServiceIntentFactory notificationServiceIntentFactory, @NotNull FavoriteSellerServiceIntentFactory favoriteSellerServiceIntentFactory, @NotNull UserAdvertServiceIntentFactory userAdvertServiceIntentFactory) {
        Intrinsics.checkNotNullParameter(messengerServiceIntentFactory, "messengerServiceIntentFactory");
        Intrinsics.checkNotNullParameter(notificationServiceIntentFactory, "notificationServiceIntentFactory");
        Intrinsics.checkNotNullParameter(favoriteSellerServiceIntentFactory, "favoriteSellerServiceIntentFactory");
        Intrinsics.checkNotNullParameter(userAdvertServiceIntentFactory, "userAdvertServiceIntentFactory");
        this.a = messengerServiceIntentFactory;
        this.b = notificationServiceIntentFactory;
        this.c = favoriteSellerServiceIntentFactory;
        this.d = userAdvertServiceIntentFactory;
    }

    @Override // com.avito.android.MessengerServiceIntentFactory
    public void channelSyncOnPushServiceEnqueueWork(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        this.a.channelSyncOnPushServiceEnqueueWork(str);
    }

    @Override // com.avito.android.FavoriteSellerServiceIntentFactory
    @NotNull
    public Intent favoriteSellerServiceMuteIntent(@NotNull String str, int i, @Nullable String str2, @NotNull String str3, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "userKey");
        Intrinsics.checkNotNullParameter(str3, "notificationActionName");
        return this.c.favoriteSellerServiceMuteIntent(str, i, str2, str3, map);
    }

    @Override // com.avito.android.MessengerServiceIntentFactory
    @NotNull
    public Intent imageUploadServiceIntent(@NotNull String str, @Nullable String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "operationId");
        return this.a.imageUploadServiceIntent(str, str2, z);
    }

    @Override // com.avito.android.NotificationServiceIntentFactory
    @NotNull
    public Intent notificationServiceIntent() {
        return this.b.notificationServiceIntent();
    }

    @Override // com.avito.android.MessengerServiceIntentFactory
    @NotNull
    public Intent sendMessageServiceIntent(@NotNull String str, @NotNull String str2, int i, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "directReplyKey");
        return this.a.sendMessageServiceIntent(str, str2, i, str3);
    }

    @Override // com.avito.android.MessengerServiceIntentFactory
    @NotNull
    public Intent sendMessageServiceIntent(@NotNull String str, @NotNull String str2, boolean z, @NotNull String str3) {
        a.Z0(str, "channelId", str2, "text", str3, MessageBody.RANDOM_ID);
        return this.a.sendMessageServiceIntent(str, str2, z, str3);
    }

    @Override // com.avito.android.UserAdvertServiceIntentFactory
    @NotNull
    public Intent userAdvertActivateServiceIntent(@NotNull String str, int i, @Nullable String str2, @NotNull String str3, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str3, "notificationActionName");
        Intrinsics.checkNotNullParameter(map, "analyticParameters");
        return this.d.userAdvertActivateServiceIntent(str, i, str2, str3, map);
    }

    @Override // com.avito.android.UserAdvertServiceIntentFactory
    @NotNull
    public Intent userAdvertAutoPublishServiceIntent(@NotNull String str, boolean z, int i, @Nullable String str2, @NotNull String str3, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str3, "notificationActionName");
        Intrinsics.checkNotNullParameter(map, "analyticParameters");
        return this.d.userAdvertAutoPublishServiceIntent(str, z, i, str2, str3, map);
    }

    @Override // com.avito.android.UserAdvertServiceIntentFactory
    @NotNull
    public Intent userAdvertCloseServiceIntent(@NotNull String str, @NotNull String str2, int i, @Nullable String str3, @NotNull String str4, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "reasonId");
        Intrinsics.checkNotNullParameter(str4, "notificationActionName");
        Intrinsics.checkNotNullParameter(map, "analyticParameters");
        return this.d.userAdvertCloseServiceIntent(str, str2, i, str3, str4, map);
    }
}
