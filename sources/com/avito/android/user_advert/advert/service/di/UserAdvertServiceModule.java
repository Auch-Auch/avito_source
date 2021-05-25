package com.avito.android.user_advert.advert.service.di;

import android.app.Application;
import androidx.core.app.NotificationManagerCompat;
import com.avito.android.user_advert.advert.service.UserAdvertInteractor;
import com.avito.android.user_advert.advert.service.UserAdvertInteractorImpl;
import com.google.android.exoplayer2.util.MimeTypes;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/user_advert/advert/service/di/UserAdvertServiceModule;", "", "Landroid/app/Application;", MimeTypes.BASE_TYPE_APPLICATION, "Landroidx/core/app/NotificationManagerCompat;", "provideNotificationManager", "(Landroid/app/Application;)Landroidx/core/app/NotificationManagerCompat;", "<init>", "()V", "Declarations", "user-advert_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class UserAdvertServiceModule {
    @NotNull
    public static final UserAdvertServiceModule INSTANCE = new UserAdvertServiceModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/user_advert/advert/service/di/UserAdvertServiceModule$Declarations;", "", "Lcom/avito/android/user_advert/advert/service/UserAdvertInteractorImpl;", "interactor", "Lcom/avito/android/user_advert/advert/service/UserAdvertInteractor;", "bindInteractor", "(Lcom/avito/android/user_advert/advert/service/UserAdvertInteractorImpl;)Lcom/avito/android/user_advert/advert/service/UserAdvertInteractor;", "user-advert_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @Binds
        @NotNull
        UserAdvertInteractor bindInteractor(@NotNull UserAdvertInteractorImpl userAdvertInteractorImpl);
    }

    @Provides
    @NotNull
    public final NotificationManagerCompat provideNotificationManager(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        NotificationManagerCompat from = NotificationManagerCompat.from(application);
        Intrinsics.checkNotNullExpressionValue(from, "NotificationManagerCompat.from(application)");
        return from;
    }
}
