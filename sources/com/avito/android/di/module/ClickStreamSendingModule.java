package com.avito.android.di.module;

import android.app.Application;
import com.avito.android.analytics.clickstream.ClickStreamApi;
import com.avito.android.analytics.clickstream.ClickStreamCommonModule;
import com.avito.android.analytics.clickstream.ClickStreamCommonSendingModule;
import com.avito.android.analytics.clickstream.ClickStreamSender;
import com.avito.android.analytics.clickstream.ClickStreamSenderImpl;
import com.avito.android.analytics.clickstream.SendClickStreamEventsTaskDelegate;
import com.avito.android.analytics.clickstream.SendClickStreamEventsTaskDelegateImpl;
import com.avito.android.analytics.inhouse_transport.InHouseEventStorage;
import com.avito.android.di.PerService;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.service.short_task.clickstream.AvitoCommonParametersProvider;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.SchedulersFactory;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import proto.events.apps.EventOuterClass;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0014\u0010\u0015JO\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u000e\b\u0001\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/di/module/ClickStreamSendingModule;", "", "Lcom/avito/android/analytics/clickstream/ClickStreamApi;", "api", "Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;", "Lproto/events/apps/EventOuterClass$Event;", "storage", "Lcom/avito/android/remote/DeviceIdProvider;", "deviceIdProvider", "Lcom/avito/android/analytics/clickstream/ClickStreamSender$CommonParametersProvider;", "parametersProvider", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Landroid/app/Application;", "app", "Lcom/avito/android/analytics/clickstream/ClickStreamSender;", "provideClickStreamSender", "(Lcom/avito/android/analytics/clickstream/ClickStreamApi;Lcom/avito/android/analytics/inhouse_transport/InHouseEventStorage;Lcom/avito/android/remote/DeviceIdProvider;Lcom/avito/android/analytics/clickstream/ClickStreamSender$CommonParametersProvider;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/BuildInfo;Landroid/app/Application;)Lcom/avito/android/analytics/clickstream/ClickStreamSender;", "<init>", "()V", "Bindings", "application_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Bindings.class, ClickStreamCommonSendingModule.class, UserAgentModule.class})
public final class ClickStreamSendingModule {
    @NotNull
    public static final ClickStreamSendingModule INSTANCE = new ClickStreamSendingModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/di/module/ClickStreamSendingModule$Bindings;", "", "Lcom/avito/android/service/short_task/clickstream/AvitoCommonParametersProvider;", "delegate", "Lcom/avito/android/analytics/clickstream/ClickStreamSender$CommonParametersProvider;", "bindsCommonParametersProvider", "(Lcom/avito/android/service/short_task/clickstream/AvitoCommonParametersProvider;)Lcom/avito/android/analytics/clickstream/ClickStreamSender$CommonParametersProvider;", "Lcom/avito/android/analytics/clickstream/SendClickStreamEventsTaskDelegateImpl;", "impl", "Lcom/avito/android/analytics/clickstream/SendClickStreamEventsTaskDelegate;", "bindSendClickStreamEventsTaskDelegate", "(Lcom/avito/android/analytics/clickstream/SendClickStreamEventsTaskDelegateImpl;)Lcom/avito/android/analytics/clickstream/SendClickStreamEventsTaskDelegate;", "application_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Bindings {
        @PerService
        @Binds
        @NotNull
        SendClickStreamEventsTaskDelegate bindSendClickStreamEventsTaskDelegate(@NotNull SendClickStreamEventsTaskDelegateImpl sendClickStreamEventsTaskDelegateImpl);

        @PerService
        @Binds
        @NotNull
        ClickStreamSender.CommonParametersProvider bindsCommonParametersProvider(@NotNull AvitoCommonParametersProvider avitoCommonParametersProvider);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerService
    public static final ClickStreamSender provideClickStreamSender(@NotNull ClickStreamApi clickStreamApi, @ClickStreamCommonModule.ClickStream @NotNull InHouseEventStorage<EventOuterClass.Event> inHouseEventStorage, @NotNull DeviceIdProvider deviceIdProvider, @NotNull ClickStreamSender.CommonParametersProvider commonParametersProvider, @NotNull SchedulersFactory schedulersFactory, @NotNull BuildInfo buildInfo, @NotNull Application application) {
        Intrinsics.checkNotNullParameter(clickStreamApi, "api");
        Intrinsics.checkNotNullParameter(inHouseEventStorage, "storage");
        Intrinsics.checkNotNullParameter(deviceIdProvider, "deviceIdProvider");
        Intrinsics.checkNotNullParameter(commonParametersProvider, "parametersProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(application, "app");
        String packageName = application.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "app.packageName");
        return new ClickStreamSenderImpl(m.endsWith$default(packageName, ".beta", false, 2, null) ? "149" : "148", deviceIdProvider, clickStreamApi, inHouseEventStorage, schedulersFactory, commonParametersProvider, buildInfo);
    }
}
