package com.avito.android.di;

import com.avito.android.CategoriesInteractor;
import com.avito.android.CategoriesInteractorImpl;
import com.avito.android.categories.remote.CategoriesApi;
import com.avito.android.categories.remote.CategoriesApiModule;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/di/CategoriesModule;", "", "Lcom/avito/android/categories/remote/CategoriesApi;", "categoriesApi", "Lcom/avito/android/CategoriesInteractor;", "provideCategoriesInteractor", "(Lcom/avito/android/categories/remote/CategoriesApi;)Lcom/avito/android/CategoriesInteractor;", "<init>", "()V", "categories_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {CategoriesApiModule.class})
public final class CategoriesModule {
    @NotNull
    public static final CategoriesModule INSTANCE = new CategoriesModule();

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final CategoriesInteractor provideCategoriesInteractor(@NotNull CategoriesApi categoriesApi) {
        Intrinsics.checkNotNullParameter(categoriesApi, "categoriesApi");
        return new CategoriesInteractorImpl(categoriesApi);
    }
}
