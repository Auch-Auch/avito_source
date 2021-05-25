package com.avito.android.category.di;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.provider.TreeStateIdGenerator;
import com.avito.android.category.CategoryArguments;
import com.avito.android.category.CategoryInteractor;
import com.avito.android.category.CategoryInteractorImpl;
import com.avito.android.category.CategoryPresenter;
import com.avito.android.category.CategoryPresenterImpl;
import com.avito.android.category.analytics.CategoryAnalyticsInteractor;
import com.avito.android.category.analytics.CategoryAnalyticsInteractorImpl;
import com.avito.android.di.PerActivity;
import com.avito.android.location.di.SavedLocationInteractorModule;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchParamsConverterImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/category/di/CategoryModule;", "", "Lcom/avito/android/remote/model/SearchParamsConverter;", "provideSearchParamsConverter", "()Lcom/avito/android/remote/model/SearchParamsConverter;", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "treeStateIdGenerator", "Lcom/avito/android/category/CategoryArguments;", "categoryArguments", "Lcom/avito/android/category/analytics/CategoryAnalyticsInteractor;", "provideCategoryAnalyticsInteractor", "(Lcom/avito/android/analytics/Analytics;Lcom/avito/android/analytics/provider/TreeStateIdGenerator;Lcom/avito/android/category/CategoryArguments;)Lcom/avito/android/category/analytics/CategoryAnalyticsInteractor;", "provideTreeStateIdGenerator", "()Lcom/avito/android/analytics/provider/TreeStateIdGenerator;", "<init>", "()V", "Dependencies", "category_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {SavedLocationInteractorModule.class, Dependencies.class})
public final class CategoryModule {
    @NotNull
    public static final CategoryModule INSTANCE = new CategoryModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/category/di/CategoryModule$Dependencies;", "", "Lcom/avito/android/category/CategoryInteractorImpl;", "interactor", "Lcom/avito/android/category/CategoryInteractor;", "bindsCategoryInteractor", "(Lcom/avito/android/category/CategoryInteractorImpl;)Lcom/avito/android/category/CategoryInteractor;", "Lcom/avito/android/category/CategoryPresenterImpl;", "presenter", "Lcom/avito/android/category/CategoryPresenter;", "bindsCategoryPresenter", "(Lcom/avito/android/category/CategoryPresenterImpl;)Lcom/avito/android/category/CategoryPresenter;", "category_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerActivity
        @Binds
        @NotNull
        CategoryInteractor bindsCategoryInteractor(@NotNull CategoryInteractorImpl categoryInteractorImpl);

        @PerActivity
        @Binds
        @NotNull
        CategoryPresenter bindsCategoryPresenter(@NotNull CategoryPresenterImpl categoryPresenterImpl);
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final CategoryAnalyticsInteractor provideCategoryAnalyticsInteractor(@NotNull Analytics analytics, @NotNull TreeStateIdGenerator treeStateIdGenerator, @NotNull CategoryArguments categoryArguments) {
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(treeStateIdGenerator, "treeStateIdGenerator");
        Intrinsics.checkNotNullParameter(categoryArguments, "categoryArguments");
        return new CategoryAnalyticsInteractorImpl(analytics, treeStateIdGenerator, categoryArguments.getTreeParent());
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final SearchParamsConverter provideSearchParamsConverter() {
        return new SearchParamsConverterImpl();
    }

    @Provides
    @JvmStatic
    @NotNull
    @PerActivity
    public static final TreeStateIdGenerator provideTreeStateIdGenerator() {
        return new TreeStateIdGenerator();
    }
}
