package com.avito.android.advert.item.spare_parts.di;

import com.avito.android.advert.item.spare_parts.SparePartsInteractor;
import com.avito.android.advert.item.spare_parts.SparePartsInteractorImpl;
import com.avito.android.advert.item.spare_parts.SparePartsItemType;
import com.avito.android.advert.item.spare_parts.SparePartsPresenter;
import com.avito.android.advert.item.spare_parts.SparePartsPresenterImpl;
import com.avito.android.di.PerFragment;
import com.avito.android.spare_parts.SparePartsFormatter;
import com.avito.android.spare_parts.SparePartsFormatterImpl;
import com.avito.android.spare_parts.SparePartsResourceProvider;
import com.avito.android.spare_parts.SparePartsResourceProviderImpl;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001:\u0005\u0010\u0011\u0012\u0013\u0014B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ3\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ3\u0010\r\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\bH\u0007¢\u0006\u0004\b\r\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/advert/item/spare_parts/di/SparePartsModule;", "", "Lcom/avito/android/advert/item/spare_parts/SparePartsInteractor;", "interactor", "Lcom/avito/android/spare_parts/SparePartsFormatter;", "formatter", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/util/Kundle;", "state", "Lcom/avito/android/advert/item/spare_parts/SparePartsPresenter;", "provideReplacementsPresenter", "(Lcom/avito/android/advert/item/spare_parts/SparePartsInteractor;Lcom/avito/android/spare_parts/SparePartsFormatter;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/util/Kundle;)Lcom/avito/android/advert/item/spare_parts/SparePartsPresenter;", "provideCompatibilitiesPresenter", "<init>", "()V", "CompatibilitiesPresenter", "CompatibilitiesPresenterState", "Declarations", "ReplacementsPresenter", "ReplacementsPresenterState", "advert-details_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class})
public final class SparePartsModule {
    @NotNull
    public static final SparePartsModule INSTANCE = new SparePartsModule();

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert/item/spare_parts/di/SparePartsModule$CompatibilitiesPresenter;", "", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface CompatibilitiesPresenter {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert/item/spare_parts/di/SparePartsModule$CompatibilitiesPresenterState;", "", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface CompatibilitiesPresenterState {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/advert/item/spare_parts/di/SparePartsModule$Declarations;", "", "Lcom/avito/android/advert/item/spare_parts/SparePartsInteractorImpl;", "interactor", "Lcom/avito/android/advert/item/spare_parts/SparePartsInteractor;", "bindSparePartsInteractor", "(Lcom/avito/android/advert/item/spare_parts/SparePartsInteractorImpl;)Lcom/avito/android/advert/item/spare_parts/SparePartsInteractor;", "Lcom/avito/android/spare_parts/SparePartsFormatterImpl;", "formatter", "Lcom/avito/android/spare_parts/SparePartsFormatter;", "bindSparePartsFormatter", "(Lcom/avito/android/spare_parts/SparePartsFormatterImpl;)Lcom/avito/android/spare_parts/SparePartsFormatter;", "Lcom/avito/android/spare_parts/SparePartsResourceProviderImpl;", "resourceProvider", "Lcom/avito/android/spare_parts/SparePartsResourceProvider;", "bindSparePartsResourceProvider", "(Lcom/avito/android/spare_parts/SparePartsResourceProviderImpl;)Lcom/avito/android/spare_parts/SparePartsResourceProvider;", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        SparePartsFormatter bindSparePartsFormatter(@NotNull SparePartsFormatterImpl sparePartsFormatterImpl);

        @PerFragment
        @Binds
        @NotNull
        SparePartsInteractor bindSparePartsInteractor(@NotNull SparePartsInteractorImpl sparePartsInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        SparePartsResourceProvider bindSparePartsResourceProvider(@NotNull SparePartsResourceProviderImpl sparePartsResourceProviderImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert/item/spare_parts/di/SparePartsModule$ReplacementsPresenter;", "", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ReplacementsPresenter {
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/advert/item/spare_parts/di/SparePartsModule$ReplacementsPresenterState;", "", "<init>", "()V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ReplacementsPresenterState {
    }

    @Provides
    @CompatibilitiesPresenter
    @NotNull
    @PerFragment
    public final SparePartsPresenter provideCompatibilitiesPresenter(@NotNull SparePartsInteractor sparePartsInteractor, @NotNull SparePartsFormatter sparePartsFormatter, @NotNull SchedulersFactory3 schedulersFactory3, @CompatibilitiesPresenterState @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(sparePartsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(sparePartsFormatter, "formatter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        return new SparePartsPresenterImpl(sparePartsInteractor, sparePartsFormatter, schedulersFactory3, SparePartsItemType.COMPATIBILITIES, kundle);
    }

    @Provides
    @ReplacementsPresenter
    @NotNull
    @PerFragment
    public final SparePartsPresenter provideReplacementsPresenter(@NotNull SparePartsInteractor sparePartsInteractor, @NotNull SparePartsFormatter sparePartsFormatter, @NotNull SchedulersFactory3 schedulersFactory3, @ReplacementsPresenterState @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(sparePartsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(sparePartsFormatter, "formatter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        return new SparePartsPresenterImpl(sparePartsInteractor, sparePartsFormatter, schedulersFactory3, SparePartsItemType.REPLACEMENTS, kundle);
    }
}
