package com.avito.android.advert.closed.di;

import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.advert.closed.ClosedAdvertPresenter;
import com.avito.android.advert.closed.ClosedAdvertPresenterImpl;
import com.avito.android.advert.closed.ClosedAdvertResourcesProvider;
import com.avito.android.advert.closed.ClosedAdvertResourcesProviderImpl;
import com.avito.android.advert.favorites.AdvertDetailsFavoriteInteractor;
import com.avito.android.advert.favorites.AdvertDetailsFavoriteInteractorImpl;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractorFactory;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.di.PerActivity;
import com.avito.android.di.ViewedAdvertsInteractorFactoryModule;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.Formatter;
import com.avito.android.util.SchedulersFactory3;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u0019\u001aB\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0006\u0010\u0007J7\u0010\u0016\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/avito/android/advert/closed/di/ClosedAdvertModule;", "", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/util/Formatter;", "", "provideThrowableFormatter$advert_details_release", "(Landroid/content/res/Resources;)Lcom/avito/android/util/Formatter;", "provideThrowableFormatter", "Lcom/avito/android/advert/viewed/ViewedAdvertsInteractorFactory;", "viewedAdvertsInteractorFactory", "Lcom/avito/android/db/viewed/ViewedAdvertsDao;", "dao", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;", "viewedAdvertsEventInteractor", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/advert/viewed/ViewedAdvertsInteractor;", "provideViewedAdvertsInteractor$advert_details_release", "(Lcom/avito/android/advert/viewed/ViewedAdvertsInteractorFactory;Lcom/avito/android/db/viewed/ViewedAdvertsDao;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;Lcom/avito/android/Features;)Lcom/avito/android/advert/viewed/ViewedAdvertsInteractor;", "provideViewedAdvertsInteractor", "<init>", "()V", "AdvertId", "Declarations", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {ViewedAdvertsInteractorFactoryModule.class, Declarations.class})
public final class ClosedAdvertModule {
    @NotNull
    public static final ClosedAdvertModule INSTANCE = new ClosedAdvertModule();

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert/closed/di/ClosedAdvertModule$AdvertId;", "", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface AdvertId {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/advert/closed/di/ClosedAdvertModule$Declarations;", "", "Lcom/avito/android/advert/closed/ClosedAdvertPresenterImpl;", "closedAdvertPresenter", "Lcom/avito/android/advert/closed/ClosedAdvertPresenter;", "bindsClosedAdvertPresenter", "(Lcom/avito/android/advert/closed/ClosedAdvertPresenterImpl;)Lcom/avito/android/advert/closed/ClosedAdvertPresenter;", "Lcom/avito/android/advert/closed/ClosedAdvertResourcesProviderImpl;", "closedAdvertResourcesProvider", "Lcom/avito/android/advert/closed/ClosedAdvertResourcesProvider;", "bindsClosedAdvertResourcesProvider", "(Lcom/avito/android/advert/closed/ClosedAdvertResourcesProviderImpl;)Lcom/avito/android/advert/closed/ClosedAdvertResourcesProvider;", "Lcom/avito/android/advert/favorites/AdvertDetailsFavoriteInteractorImpl;", "advertDetailsFavoriteInteractor", "Lcom/avito/android/advert/favorites/AdvertDetailsFavoriteInteractor;", "bindAdvertDetailsFavoriteInteractor", "(Lcom/avito/android/advert/favorites/AdvertDetailsFavoriteInteractorImpl;)Lcom/avito/android/advert/favorites/AdvertDetailsFavoriteInteractor;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerActivity
        @Binds
        @NotNull
        AdvertDetailsFavoriteInteractor bindAdvertDetailsFavoriteInteractor(@NotNull AdvertDetailsFavoriteInteractorImpl advertDetailsFavoriteInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        ClosedAdvertPresenter bindsClosedAdvertPresenter(@NotNull ClosedAdvertPresenterImpl closedAdvertPresenterImpl);

        @PerActivity
        @Binds
        @NotNull
        ClosedAdvertResourcesProvider bindsClosedAdvertResourcesProvider(@NotNull ClosedAdvertResourcesProviderImpl closedAdvertResourcesProviderImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final Formatter<Throwable> provideThrowableFormatter$advert_details_release(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new ErrorFormatterImpl(resources);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final ViewedAdvertsInteractor provideViewedAdvertsInteractor$advert_details_release(@NotNull ViewedAdvertsInteractorFactory viewedAdvertsInteractorFactory, @NotNull ViewedAdvertsDao viewedAdvertsDao, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ViewedAdvertsEventInteractor viewedAdvertsEventInteractor, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(viewedAdvertsInteractorFactory, "viewedAdvertsInteractorFactory");
        Intrinsics.checkNotNullParameter(viewedAdvertsDao, "dao");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(viewedAdvertsEventInteractor, "viewedAdvertsEventInteractor");
        Intrinsics.checkNotNullParameter(features, "features");
        return viewedAdvertsInteractorFactory.create(viewedAdvertsDao, schedulersFactory3, viewedAdvertsEventInteractor, features);
    }
}
