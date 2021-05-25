package com.avito.android.di.module;

import android.content.res.Resources;
import com.avito.android.Features;
import com.avito.android.db.SearchSubscriptionDao;
import com.avito.android.di.CommercialBannersInteractorModule;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchParamsConverterImpl;
import com.avito.android.remote.model.SuggestParamsConverter;
import com.avito.android.remote.model.SuggestParamsConverterImpl;
import com.avito.android.search.SearchDeepLinkInteractor;
import com.avito.android.search.SearchDeepLinkInteractorImpl;
import com.avito.android.search.subscriptions.SearchSubscriptionConsumer;
import com.avito.android.search.subscriptions.SerpSearchSubscriptionInteractor;
import com.avito.android.search.subscriptions.SerpSearchSubscriptionInteractorImpl;
import com.avito.android.search.subscriptions.SubscribeSearchInteractor;
import com.avito.android.search.subscriptions.SubscribeSearchInteractorImpl;
import com.avito.android.serp.SerpResourcesProvider;
import com.avito.android.serp.SerpResourcesProviderImpl;
import com.avito.android.serp.SerpSnippetInteractor;
import com.avito.android.serp.adapter.closable.di.ClosedItemModule;
import com.avito.android.serp.warning.AbstractWarningStateStorage;
import com.avito.android.serp.warning.PermanentWarningStateStorage;
import com.avito.android.serp.warning.TemporalWarningStateStorage;
import com.avito.android.serp.warning.WarningStateProvider;
import com.avito.android.serp.warning.WarningStateProviderImpl;
import com.avito.android.serp.warning.WarningStateProviderState;
import com.avito.android.subscriptions.remote.SubscriptionsApi;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.Preferences;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002EFB\t\b\u0002¢\u0006\u0004\bC\u0010DJ)\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0001\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0018\u001a\u00020\u00152\b\b\u0001\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J7\u0010#\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0001¢\u0006\u0004\b!\u0010\"J9\u0010+\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0001\u0010$\u001a\u00020\u00042\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u0006H\u0001¢\u0006\u0004\b)\u0010*J)\u00105\u001a\u0002022\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.2\b\u00101\u001a\u0004\u0018\u000100H\u0001¢\u0006\u0004\b3\u00104J\u000f\u00108\u001a\u00020,H\u0001¢\u0006\u0004\b6\u00107J\u0017\u0010=\u001a\u00020.2\u0006\u0010:\u001a\u000209H\u0001¢\u0006\u0004\b;\u0010<J\u001f\u0010B\u001a\u00020?2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u0002H\u0001¢\u0006\u0004\b@\u0010A¨\u0006G"}, d2 = {"Lcom/avito/android/di/module/SerpInteractorModule;", "", "Lcom/avito/android/remote/SearchApi;", "api", "Lcom/avito/android/remote/model/SearchParamsConverter;", "searchParamsConverter", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/search/SearchDeepLinkInteractor;", "provideSearchDeepLinkInteractor$serp_core_release", "(Lcom/avito/android/remote/SearchApi;Lcom/avito/android/remote/model/SearchParamsConverter;Lcom/avito/android/util/SchedulersFactory3;)Lcom/avito/android/search/SearchDeepLinkInteractor;", "provideSearchDeepLinkInteractor", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/serp/SerpResourcesProvider;", "provideResourcesProvider$serp_core_release", "(Landroid/content/res/Resources;)Lcom/avito/android/serp/SerpResourcesProvider;", "provideResourcesProvider", "provideSearchParamsConverter$serp_core_release", "()Lcom/avito/android/remote/model/SearchParamsConverter;", "provideSearchParamsConverter", "Lcom/avito/android/remote/model/SuggestParamsConverter;", "provideSuggestParamsConverter$serp_core_release", "(Lcom/avito/android/remote/model/SearchParamsConverter;)Lcom/avito/android/remote/model/SuggestParamsConverter;", "provideSuggestParamsConverter", "Lcom/avito/android/db/SearchSubscriptionDao;", "dao", "Lcom/avito/android/subscriptions/remote/SubscriptionsApi;", "Lcom/avito/android/search/subscriptions/SearchSubscriptionConsumer;", "searchSubscriptionConsumer", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/search/subscriptions/SerpSearchSubscriptionInteractor;", "provideServiceInteractor$serp_core_release", "(Lcom/avito/android/db/SearchSubscriptionDao;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/subscriptions/remote/SubscriptionsApi;Lcom/avito/android/search/subscriptions/SearchSubscriptionConsumer;Lcom/avito/android/Features;)Lcom/avito/android/search/subscriptions/SerpSearchSubscriptionInteractor;", "provideServiceInteractor", "paramsConverter", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "schedulers", "Lcom/avito/android/search/subscriptions/SubscribeSearchInteractor;", "provideSubscribeSearchInteractor$serp_core_release", "(Lcom/avito/android/subscriptions/remote/SubscriptionsApi;Lcom/avito/android/db/SearchSubscriptionDao;Lcom/avito/android/remote/model/SearchParamsConverter;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/util/SchedulersFactory3;)Lcom/avito/android/search/subscriptions/SubscribeSearchInteractor;", "provideSubscribeSearchInteractor", "Lcom/avito/android/serp/warning/TemporalWarningStateStorage;", "temporaryStorage", "Lcom/avito/android/serp/warning/PermanentWarningStateStorage;", "permanentStorage", "Lcom/avito/android/serp/warning/WarningStateProviderState;", "warningStateProviderState", "Lcom/avito/android/serp/warning/WarningStateProvider;", "provideWarningStateProvider$serp_core_release", "(Lcom/avito/android/serp/warning/TemporalWarningStateStorage;Lcom/avito/android/serp/warning/PermanentWarningStateStorage;Lcom/avito/android/serp/warning/WarningStateProviderState;)Lcom/avito/android/serp/warning/WarningStateProvider;", "provideWarningStateProvider", "providerWarningStateStorage$serp_core_release", "()Lcom/avito/android/serp/warning/TemporalWarningStateStorage;", "providerWarningStateStorage", "Lcom/avito/android/util/preferences/Preferences;", "preferences", "providerPermanentWarningStateStorage$serp_core_release", "(Lcom/avito/android/util/preferences/Preferences;)Lcom/avito/android/serp/warning/PermanentWarningStateStorage;", "providerPermanentWarningStateStorage", "searchApi", "Lcom/avito/android/serp/SerpSnippetInteractor;", "provideSerpSnippetInteractor$serp_core_release", "(Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/SearchApi;)Lcom/avito/android/serp/SerpSnippetInteractor;", "provideSerpSnippetInteractor", "<init>", "()V", "SerpSearchParamsConverter", "ShowJobNearbyBanner", "serp-core_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {CommercialBannersInteractorModule.class, PersistedSerpModule.class, SerpItemConverterModule.class, SpanAdapterModule.class, ClosedItemModule.class, InlineFiltersInteractorModule.class})
public final class SerpInteractorModule {
    @NotNull
    public static final SerpInteractorModule INSTANCE = new SerpInteractorModule();

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/di/module/SerpInteractorModule$SerpSearchParamsConverter;", "", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface SerpSearchParamsConverter {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/di/module/SerpInteractorModule$ShowJobNearbyBanner;", "", "<init>", "()V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ShowJobNearbyBanner {
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final SerpResourcesProvider provideResourcesProvider$serp_core_release(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new SerpResourcesProviderImpl(resources);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final SearchDeepLinkInteractor provideSearchDeepLinkInteractor$serp_core_release(@NotNull SearchApi searchApi, @SerpSearchParamsConverter @NotNull SearchParamsConverter searchParamsConverter, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(searchApi, "api");
        Intrinsics.checkNotNullParameter(searchParamsConverter, "searchParamsConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        return new SearchDeepLinkInteractorImpl(searchApi, searchParamsConverter, schedulersFactory3);
    }

    @Provides
    @JvmStatic
    @SerpSearchParamsConverter
    @NotNull
    public static final SearchParamsConverter provideSearchParamsConverter$serp_core_release() {
        return new SearchParamsConverterImpl();
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final SerpSnippetInteractor provideSerpSnippetInteractor$serp_core_release(@NotNull SchedulersFactory3 schedulersFactory3, @NotNull SearchApi searchApi) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(searchApi, "searchApi");
        return new SerpSnippetInteractor.Impl(schedulersFactory3, searchApi);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final SerpSearchSubscriptionInteractor provideServiceInteractor$serp_core_release(@NotNull SearchSubscriptionDao searchSubscriptionDao, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull SubscriptionsApi subscriptionsApi, @NotNull SearchSubscriptionConsumer searchSubscriptionConsumer, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(searchSubscriptionDao, "dao");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(subscriptionsApi, "api");
        Intrinsics.checkNotNullParameter(searchSubscriptionConsumer, "searchSubscriptionConsumer");
        Intrinsics.checkNotNullParameter(features, "features");
        return new SerpSearchSubscriptionInteractorImpl(searchSubscriptionDao, subscriptionsApi, schedulersFactory3, searchSubscriptionConsumer, features);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final SubscribeSearchInteractor provideSubscribeSearchInteractor$serp_core_release(@NotNull SubscriptionsApi subscriptionsApi, @NotNull SearchSubscriptionDao searchSubscriptionDao, @SerpSearchParamsConverter @NotNull SearchParamsConverter searchParamsConverter, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(subscriptionsApi, "api");
        Intrinsics.checkNotNullParameter(searchSubscriptionDao, "dao");
        Intrinsics.checkNotNullParameter(searchParamsConverter, "paramsConverter");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        return new SubscribeSearchInteractorImpl(subscriptionsApi, searchSubscriptionDao, searchParamsConverter, typedErrorThrowableConverter, schedulersFactory3);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final SuggestParamsConverter provideSuggestParamsConverter$serp_core_release(@SerpSearchParamsConverter @NotNull SearchParamsConverter searchParamsConverter) {
        Intrinsics.checkNotNullParameter(searchParamsConverter, "searchParamsConverter");
        return new SuggestParamsConverterImpl(searchParamsConverter);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final WarningStateProvider provideWarningStateProvider$serp_core_release(@NotNull TemporalWarningStateStorage temporalWarningStateStorage, @NotNull PermanentWarningStateStorage permanentWarningStateStorage, @Nullable WarningStateProviderState warningStateProviderState) {
        Intrinsics.checkNotNullParameter(temporalWarningStateStorage, "temporaryStorage");
        Intrinsics.checkNotNullParameter(permanentWarningStateStorage, "permanentStorage");
        return new WarningStateProviderImpl(CollectionsKt__CollectionsKt.listOf((Object[]) new AbstractWarningStateStorage[]{permanentWarningStateStorage, temporalWarningStateStorage}), warningStateProviderState);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final PermanentWarningStateStorage providerPermanentWarningStateStorage$serp_core_release(@NotNull Preferences preferences) {
        Intrinsics.checkNotNullParameter(preferences, "preferences");
        return new PermanentWarningStateStorage(preferences);
    }

    @Provides
    @JvmStatic
    @NotNull
    public static final TemporalWarningStateStorage providerWarningStateStorage$serp_core_release() {
        return new TemporalWarningStateStorage();
    }
}
