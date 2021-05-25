package com.avito.android.di;

import com.avito.android.Features;
import com.avito.android.advert.viewed.ViewedAdvertsEventInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractor;
import com.avito.android.advert.viewed.ViewedAdvertsInteractorFactory;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.advert.viewed.ViewedAdvertsPresenterImpl;
import com.avito.android.db.viewed.ViewedAdvertsDao;
import com.avito.android.serp.adapter.ViewedStatusResolver;
import com.avito.android.serp.adapter.ViewedStatusResolverImpl;
import com.avito.android.util.SchedulersFactory3;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J7\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/di/ViewedAdvertsModule;", "", "Lcom/avito/android/advert/viewed/ViewedAdvertsInteractorFactory;", "viewedAdvertsInteractorFactory", "Lcom/avito/android/db/viewed/ViewedAdvertsDao;", "dao", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;", "viewedAdvertsEventInteractor", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/advert/viewed/ViewedAdvertsInteractor;", "provideViewedAdvertsInteractor", "(Lcom/avito/android/advert/viewed/ViewedAdvertsInteractorFactory;Lcom/avito/android/db/viewed/ViewedAdvertsDao;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;Lcom/avito/android/Features;)Lcom/avito/android/advert/viewed/ViewedAdvertsInteractor;", "interactor", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "provideViewedAdvertsPresenter", "(Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;Lcom/avito/android/util/SchedulersFactory3;)Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsInteractor", "Lcom/avito/android/serp/adapter/ViewedStatusResolver;", "provideViewedStatusResolver", "(Lcom/avito/android/advert/viewed/ViewedAdvertsInteractor;)Lcom/avito/android/serp/adapter/ViewedStatusResolver;", "<init>", "()V", "viewed-adverts_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {ViewedAdvertsInteractorFactoryModule.class})
public final class ViewedAdvertsModule {
    @NotNull
    public static final ViewedAdvertsModule INSTANCE = new ViewedAdvertsModule();

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final ViewedAdvertsInteractor provideViewedAdvertsInteractor(@NotNull ViewedAdvertsInteractorFactory viewedAdvertsInteractorFactory, @NotNull ViewedAdvertsDao viewedAdvertsDao, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull ViewedAdvertsEventInteractor viewedAdvertsEventInteractor, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(viewedAdvertsInteractorFactory, "viewedAdvertsInteractorFactory");
        Intrinsics.checkNotNullParameter(viewedAdvertsDao, "dao");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(viewedAdvertsEventInteractor, "viewedAdvertsEventInteractor");
        Intrinsics.checkNotNullParameter(features, "features");
        return viewedAdvertsInteractorFactory.create(viewedAdvertsDao, schedulersFactory3, viewedAdvertsEventInteractor, features);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final ViewedAdvertsPresenter provideViewedAdvertsPresenter(@NotNull ViewedAdvertsEventInteractor viewedAdvertsEventInteractor, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(viewedAdvertsEventInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        return new ViewedAdvertsPresenterImpl(viewedAdvertsEventInteractor, schedulersFactory3);
    }

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final ViewedStatusResolver provideViewedStatusResolver(@NotNull ViewedAdvertsInteractor viewedAdvertsInteractor) {
        Intrinsics.checkNotNullParameter(viewedAdvertsInteractor, "viewedAdvertsInteractor");
        return new ViewedStatusResolverImpl(viewedAdvertsInteractor);
    }
}
