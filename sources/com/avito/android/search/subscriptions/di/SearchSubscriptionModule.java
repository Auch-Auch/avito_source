package com.avito.android.search.subscriptions.di;

import a2.b.a.a.a;
import android.content.res.Resources;
import com.avito.android.date_time_formatter.SimpleDateFormatter;
import com.avito.android.di.PerFragment;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchParamsConverterImpl;
import com.avito.android.saved_searches.di.SavedSearchesModule;
import com.avito.android.search.subscriptions.SearchSubscriptionInteractor;
import com.avito.android.search.subscriptions.SearchSubscriptionInteractorImpl;
import com.avito.android.search.subscriptions.SearchSubscriptionPresenter;
import com.avito.android.search.subscriptions.SearchSubscriptionPresenterImpl;
import com.avito.android.search.subscriptions.SearchSubscriptionServiceInteractor;
import com.avito.android.search.subscriptions.SearchSubscriptionServiceInteractorImpl;
import com.avito.android.search.subscriptions.SubscribeSearchInteractor;
import com.avito.android.search.subscriptions.SubscribeSearchInteractorImpl;
import com.avito.android.search.subscriptions.adapter.SearchSubscriptionBlueprint;
import com.avito.android.search.subscriptions.adapter.SearchSubscriptionItem;
import com.avito.android.search.subscriptions.adapter.SearchSubscriptionItemPresenter;
import com.avito.android.search.subscriptions.adapter.SearchSubscriptionItemPresenterImpl;
import com.avito.android.search.subscriptions.adapter.SearchSubscriptionItemView;
import com.avito.android.server_time.UtcTimeSource;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.Formatter;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.utils.date.DateUtilKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001eB\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0001¢\u0006\u0004\b\n\u0010\u000bJ%\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\u00112\u0006\u0010\u0017\u001a\u00020\u0016H\u0001¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006\u001f"}, d2 = {"Lcom/avito/android/search/subscriptions/di/SearchSubscriptionModule;", "", "Lcom/avito/konveyor/ItemBinder;", GeoContract.PROVIDER, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "providesAdapterPresenter$subscriptions_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "providesAdapterPresenter", "Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionBlueprint;", "searchSubscriptionBlueprint", "provideItemBinder$subscriptions_release", "(Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "Ljava/util/Locale;", "locale", "Lcom/avito/android/server_time/UtcTimeSource;", "timeSource", "Lcom/avito/android/util/Formatter;", "", "provideDateFormat$subscriptions_release", "(Ljava/util/Locale;Lcom/avito/android/server_time/UtcTimeSource;)Lcom/avito/android/util/Formatter;", "provideDateFormat", "Landroid/content/res/Resources;", "resources", "", "provideErrorFormatter$subscriptions_release", "(Landroid/content/res/Resources;)Lcom/avito/android/util/Formatter;", "provideErrorFormatter", "<init>", "()V", "Declarations", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, SavedSearchesModule.class})
public final class SearchSubscriptionModule {
    @NotNull
    public static final SearchSubscriptionModule INSTANCE = new SearchSubscriptionModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000eH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0014H'¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u001aH'¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u001eH'¢\u0006\u0004\b \u0010!J\u0017\u0010%\u001a\u00020$2\u0006\u0010#\u001a\u00020\"H'¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/avito/android/search/subscriptions/di/SearchSubscriptionModule$Declarations;", "", "Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItemPresenterImpl;", "presenter", "Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItemPresenter;", "bindSearchSubscriptionItemPresenter", "(Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItemPresenterImpl;)Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItemPresenter;", "Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionBlueprint;", "blueprint", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItemView;", "Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItem;", "bindSearchSubscriptionBlueprint", "(Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionBlueprint;)Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lcom/avito/android/search/subscriptions/SearchSubscriptionServiceInteractorImpl;", "interactor", "Lcom/avito/android/search/subscriptions/SearchSubscriptionServiceInteractor;", "bindSearchSubscriptionServiceInteractor", "(Lcom/avito/android/search/subscriptions/SearchSubscriptionServiceInteractorImpl;)Lcom/avito/android/search/subscriptions/SearchSubscriptionServiceInteractor;", "Lcom/avito/android/search/subscriptions/SearchSubscriptionPresenterImpl;", "Lcom/avito/android/search/subscriptions/SearchSubscriptionPresenter;", "bindSearchSubscriptionPresenter", "(Lcom/avito/android/search/subscriptions/SearchSubscriptionPresenterImpl;)Lcom/avito/android/search/subscriptions/SearchSubscriptionPresenter;", "Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItemPresenter$Listener;", "bindSearchSubscriptionItemPresenterListener", "(Lcom/avito/android/search/subscriptions/SearchSubscriptionPresenter;)Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItemPresenter$Listener;", "Lcom/avito/android/search/subscriptions/SearchSubscriptionInteractorImpl;", "Lcom/avito/android/search/subscriptions/SearchSubscriptionInteractor;", "bindSearchSubscriptionInteractor", "(Lcom/avito/android/search/subscriptions/SearchSubscriptionInteractorImpl;)Lcom/avito/android/search/subscriptions/SearchSubscriptionInteractor;", "Lcom/avito/android/search/subscriptions/SubscribeSearchInteractorImpl;", "Lcom/avito/android/search/subscriptions/SubscribeSearchInteractor;", "bindSubscribeSearchInteractor", "(Lcom/avito/android/search/subscriptions/SubscribeSearchInteractorImpl;)Lcom/avito/android/search/subscriptions/SubscribeSearchInteractor;", "Lcom/avito/android/remote/model/SearchParamsConverterImpl;", "converter", "Lcom/avito/android/remote/model/SearchParamsConverter;", "bindSearchParamsConverter", "(Lcom/avito/android/remote/model/SearchParamsConverterImpl;)Lcom/avito/android/remote/model/SearchParamsConverter;", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        SearchParamsConverter bindSearchParamsConverter(@NotNull SearchParamsConverterImpl searchParamsConverterImpl);

        @Binds
        @NotNull
        @PerFragment
        ItemBlueprint<SearchSubscriptionItemView, SearchSubscriptionItem> bindSearchSubscriptionBlueprint(@NotNull SearchSubscriptionBlueprint searchSubscriptionBlueprint);

        @PerFragment
        @Binds
        @NotNull
        SearchSubscriptionInteractor bindSearchSubscriptionInteractor(@NotNull SearchSubscriptionInteractorImpl searchSubscriptionInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        SearchSubscriptionItemPresenter bindSearchSubscriptionItemPresenter(@NotNull SearchSubscriptionItemPresenterImpl searchSubscriptionItemPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        SearchSubscriptionItemPresenter.Listener bindSearchSubscriptionItemPresenterListener(@NotNull SearchSubscriptionPresenter searchSubscriptionPresenter);

        @PerFragment
        @Binds
        @NotNull
        SearchSubscriptionPresenter bindSearchSubscriptionPresenter(@NotNull SearchSubscriptionPresenterImpl searchSubscriptionPresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        SearchSubscriptionServiceInteractor bindSearchSubscriptionServiceInteractor(@NotNull SearchSubscriptionServiceInteractorImpl searchSubscriptionServiceInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        SubscribeSearchInteractor bindSubscribeSearchInteractor(@NotNull SubscribeSearchInteractorImpl subscribeSearchInteractorImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final Formatter<Long> provideDateFormat$subscriptions_release(@NotNull Locale locale, @NotNull UtcTimeSource utcTimeSource) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(utcTimeSource, "timeSource");
        return new SimpleDateFormatter(DateUtilKt.serverFormat, locale, utcTimeSource);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final Formatter<Throwable> provideErrorFormatter$subscriptions_release(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new ErrorFormatterImpl(resources);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final ItemBinder provideItemBinder$subscriptions_release(@NotNull SearchSubscriptionBlueprint searchSubscriptionBlueprint) {
        Intrinsics.checkNotNullParameter(searchSubscriptionBlueprint, "searchSubscriptionBlueprint");
        return new ItemBinder.Builder().registerItem(searchSubscriptionBlueprint).build();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerFragment
    public static final AdapterPresenter providesAdapterPresenter$subscriptions_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, GeoContract.PROVIDER, itemBinder, itemBinder);
    }
}
