package com.avito.android.remote;

import com.avito.android.Features;
import com.avito.android.remote.model.notification.Payload;
import com.avito.android.remote.model.notification_center.NotificationCenterLandingRecommends;
import com.avito.android.remote.model.notification_center.landing.unified.NotificationCenterLandingField;
import com.avito.android.remote.model.notifications_settings.NotificationsSettings;
import com.avito.android.remote.notification.NotificationParameters;
import com.avito.android.remote.parse.adapter.NotificationCenterLandingRecommendsTypeAdapter;
import com.avito.android.remote.parse.adapter.NotificationCenterUnifiedFieldDeserializer;
import com.avito.android.remote.parse.adapter.NotificationParametersPayloadTypeAdapter;
import com.avito.android.remote.parse.adapter.NotificationParametersStyleTypeAdapter;
import com.avito.android.remote.parse.adapter.NotificationsSettingsSectionChannelDeserializer;
import com.avito.android.util.TypeAdapterEntry;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/NotificationsJsonModule;", "", "Lcom/avito/android/Features;", "features", "", "Lcom/avito/android/util/TypeAdapterEntry;", "provideTypeAdapters", "(Lcom/avito/android/Features;)Ljava/util/Set;", "<init>", "()V", "notifications_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class NotificationsJsonModule {
    @NotNull
    public static final NotificationsJsonModule INSTANCE = new NotificationsJsonModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    public static final Set<TypeAdapterEntry> provideTypeAdapters(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new TypeAdapterEntry(NotificationCenterLandingRecommends.Element.class, new NotificationCenterLandingRecommendsTypeAdapter()));
        linkedHashSet.add(new TypeAdapterEntry(Payload.class, new NotificationParametersPayloadTypeAdapter()));
        linkedHashSet.add(new TypeAdapterEntry(NotificationParameters.Style.class, new NotificationParametersStyleTypeAdapter()));
        linkedHashSet.add(new TypeAdapterEntry(NotificationCenterLandingField.class, new NotificationCenterUnifiedFieldDeserializer()));
        linkedHashSet.add(new TypeAdapterEntry(NotificationsSettings.Section.Channel.class, new NotificationsSettingsSectionChannelDeserializer()));
        return linkedHashSet;
    }
}
