package com.avito.android.di.module;

import com.avito.android.events.notifications_settings.NotificationSettingsChangeEvent;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/avito/android/di/module/NotificationSettingsRelayModule;", "", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/events/notifications_settings/NotificationSettingsChangeEvent;", "provideRelay", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "<init>", "()V", "Declarations", "core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class NotificationSettingsRelayModule {
    @NotNull
    public static final NotificationSettingsRelayModule INSTANCE = new NotificationSettingsRelayModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/di/module/NotificationSettingsRelayModule$Declarations;", "", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/events/notifications_settings/NotificationSettingsChangeEvent;", "relay", "Lio/reactivex/rxjava3/core/Observable;", "bindObservable", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/core/Observable;", "Lio/reactivex/rxjava3/functions/Consumer;", "bindConsumer", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/functions/Consumer;", "core_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        @Singleton
        Consumer<NotificationSettingsChangeEvent> bindConsumer(@NotNull PublishRelay<NotificationSettingsChangeEvent> publishRelay);

        @Binds
        @NotNull
        @Singleton
        Observable<NotificationSettingsChangeEvent> bindObservable(@NotNull PublishRelay<NotificationSettingsChangeEvent> publishRelay);
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final PublishRelay<NotificationSettingsChangeEvent> provideRelay() {
        PublishRelay<NotificationSettingsChangeEvent> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        return create;
    }
}
