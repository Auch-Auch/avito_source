package com.avito.android.di;

import com.avito.android.analytics.clickstream.ClickStreamCommonModule;
import com.avito.android.analytics.inhouse_transport.InHouseEventStorage;
import com.avito.android.geo.GeoStorage;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.remote.UserAgentProvider;
import com.avito.android.util.preferences.Preferences;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import proto.events.apps.EventOuterClass;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/di/ClickStreamSendDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;", "Lproto/events/apps/EventOuterClass$Event;", "clickStreamEventStorage", "()Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;", "Lcom/avito/android/remote/DeviceIdProvider;", "deviceIdProvider", "()Lcom/avito/android/remote/DeviceIdProvider;", "Lcom/avito/android/remote/UserAgentProvider;", "userAgentProvider", "()Lcom/avito/android/remote/UserAgentProvider;", "Lcom/avito/android/geo/GeoStorage;", "geoProvider", "()Lcom/avito/android/geo/GeoStorage;", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "()Lcom/avito/android/util/preferences/Preferences;", "application_release"}, k = 1, mv = {1, 4, 2})
public interface ClickStreamSendDependencies extends CoreComponentDependencies {
    @ClickStreamCommonModule.ClickStream
    @NotNull
    InHouseEventStorage<EventOuterClass.Event> clickStreamEventStorage();

    @Override // com.avito.android.settings.di.SettingsDependencies
    @NotNull
    DeviceIdProvider deviceIdProvider();

    @NotNull
    GeoStorage geoProvider();

    @Override // com.avito.android.settings.di.SettingsDependencies, com.avito.android.push.MessagingDependencies, com.avito.android.app_rater.di.AppRaterDependencies
    @NotNull
    Preferences preferences();

    @NotNull
    UserAgentProvider userAgentProvider();
}
