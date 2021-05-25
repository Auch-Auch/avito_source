package com.avito.android.shop.filter.di;

import com.avito.android.di.PerFragment;
import com.avito.android.shop.filter.ShopsFilterInteractor;
import com.avito.android.shop.filter.ShopsFilterInteractorImpl;
import com.avito.android.shop.filter.ShopsFilterPresenter;
import com.avito.android.shop.filter.ShopsFilterPresenterImpl;
import dagger.Binds;
import dagger.Module;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/avito/android/shop/filter/di/ShopsFilterModule;", "", "<init>", "()V", "Declarations", "PresenterState", "ShopsSearchParams", "shop_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class ShopsFilterModule {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/shop/filter/di/ShopsFilterModule$Declarations;", "", "Lcom/avito/android/shop/filter/ShopsFilterInteractorImpl;", "interactor", "Lcom/avito/android/shop/filter/ShopsFilterInteractor;", "bindShopFilterInteractor", "(Lcom/avito/android/shop/filter/ShopsFilterInteractorImpl;)Lcom/avito/android/shop/filter/ShopsFilterInteractor;", "Lcom/avito/android/shop/filter/ShopsFilterPresenterImpl;", "presenter", "Lcom/avito/android/shop/filter/ShopsFilterPresenter;", "bindShopFilterPresenter", "(Lcom/avito/android/shop/filter/ShopsFilterPresenterImpl;)Lcom/avito/android/shop/filter/ShopsFilterPresenter;", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        ShopsFilterInteractor bindShopFilterInteractor(@NotNull ShopsFilterInteractorImpl shopsFilterInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        ShopsFilterPresenter bindShopFilterPresenter(@NotNull ShopsFilterPresenterImpl shopsFilterPresenterImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/shop/filter/di/ShopsFilterModule$PresenterState;", "", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface PresenterState {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/shop/filter/di/ShopsFilterModule$ShopsSearchParams;", "", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ShopsSearchParams {
    }
}
