package com.avito.android.safedeal.delivery_type.di;

import a2.b.a.a.a;
import com.avito.android.analytics.Analytics;
import com.avito.android.di.PerFragment;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.DestroyableViewHolderBuilderImpl;
import com.avito.android.recycler.base.SafeRecyclerAdapter;
import com.avito.android.safedeal.delivery_type.DeliveryTypeInteractor;
import com.avito.android.safedeal.delivery_type.DeliveryTypeInteractorImpl;
import com.avito.android.safedeal.delivery_type.DeliveryTypePresenter;
import com.avito.android.safedeal.delivery_type.DeliveryTypePresenterImpl;
import com.avito.android.safedeal.delivery_type.items.DeliveryTypeResourceProvider;
import com.avito.android.safedeal.delivery_type.items.DeliveryTypeResourceProviderImpl;
import com.avito.android.safedeal.delivery_type.items.button.di.ButtonModule;
import com.avito.android.safedeal.delivery_type.items.skeleton.di.SkeletonModule;
import com.avito.android.safedeal.delivery_type.items.subtitle.di.SubTitleModule;
import com.avito.android.safedeal.delivery_type.items.title.di.TitleModule;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.text.AttributedTextFormatterModule;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.blueprint.ItemBlueprint;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\bÇ\u0002\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\t\b\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ,\u0010\u0007\u001a\u00020\u00062\u001b\b\u0001\u0010\u0005\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0002\b\u00040\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0014\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/avito/android/safedeal/delivery_type/di/DeliveryTypeModule;", "", "", "Lcom/avito/konveyor/blueprint/ItemBlueprint;", "Lkotlin/jvm/JvmSuppressWildcards;", "blueprints", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "(Ljava/util/Set;)Lcom/avito/konveyor/ItemBinder;", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "presenter", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "destroyableViewHolderBuilder", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "provideSafeRecyclerAdapter$safedeal_release", "(Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/analytics/Analytics;)Lcom/avito/android/recycler/base/SafeRecyclerAdapter;", "provideSafeRecyclerAdapter", "itemBinder", "provideAdapterPresenter$safedeal_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "provideDestroyableViewHolderBuilder$safedeal_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "provideDestroyableViewHolderBuilder", "<init>", "()V", "Declarations", "DeliveryTypeBlueprints", "safedeal_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {Declarations.class, AttributedTextFormatterModule.class, SkeletonModule.class, TitleModule.class, SubTitleModule.class, ButtonModule.class})
public final class DeliveryTypeModule {
    @NotNull
    public static final DeliveryTypeModule INSTANCE = new DeliveryTypeModule();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH'¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/safedeal/delivery_type/di/DeliveryTypeModule$Declarations;", "", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypePresenterImpl;", "presenter", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypePresenter;", "bindPresenter", "(Lcom/avito/android/safedeal/delivery_type/DeliveryTypePresenterImpl;)Lcom/avito/android/safedeal/delivery_type/DeliveryTypePresenter;", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeInteractorImpl;", "interactor", "Lcom/avito/android/safedeal/delivery_type/DeliveryTypeInteractor;", "bindInteractor", "(Lcom/avito/android/safedeal/delivery_type/DeliveryTypeInteractorImpl;)Lcom/avito/android/safedeal/delivery_type/DeliveryTypeInteractor;", "Lcom/avito/android/safedeal/delivery_type/items/DeliveryTypeResourceProviderImpl;", "resourceProvider", "Lcom/avito/android/safedeal/delivery_type/items/DeliveryTypeResourceProvider;", "bindResourceProvider", "(Lcom/avito/android/safedeal/delivery_type/items/DeliveryTypeResourceProviderImpl;)Lcom/avito/android/safedeal/delivery_type/items/DeliveryTypeResourceProvider;", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Declarations {
        @PerFragment
        @Binds
        @NotNull
        DeliveryTypeInteractor bindInteractor(@NotNull DeliveryTypeInteractorImpl deliveryTypeInteractorImpl);

        @PerFragment
        @Binds
        @NotNull
        DeliveryTypePresenter bindPresenter(@NotNull DeliveryTypePresenterImpl deliveryTypePresenterImpl);

        @PerFragment
        @Binds
        @NotNull
        DeliveryTypeResourceProvider bindResourceProvider(@NotNull DeliveryTypeResourceProviderImpl deliveryTypeResourceProviderImpl);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/safedeal/delivery_type/di/DeliveryTypeModule$DeliveryTypeBlueprints;", "", "<init>", "()V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
    public @interface DeliveryTypeBlueprints {
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdapterPresenter provideAdapterPresenter$safedeal_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final DestroyableViewHolderBuilder provideDestroyableViewHolderBuilder$safedeal_release(@NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        return new DestroyableViewHolderBuilderImpl(itemBinder);
    }

    @Provides
    @NotNull
    @PerFragment
    public final ItemBinder provideItemBinder(@DeliveryTypeBlueprints @NotNull Set<ItemBlueprint<?, ?>> set) {
        Intrinsics.checkNotNullParameter(set, "blueprints");
        ItemBinder.Builder builder = new ItemBinder.Builder();
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            builder.registerItem(it.next());
        }
        return builder.build();
    }

    @Provides
    @PerFragment
    @NotNull
    public final SafeRecyclerAdapter provideSafeRecyclerAdapter$safedeal_release(@NotNull AdapterPresenter adapterPresenter, @NotNull DestroyableViewHolderBuilder destroyableViewHolderBuilder, @NotNull BuildInfo buildInfo, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(adapterPresenter, "presenter");
        Intrinsics.checkNotNullParameter(destroyableViewHolderBuilder, "destroyableViewHolderBuilder");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        return new SafeRecyclerAdapter(adapterPresenter, destroyableViewHolderBuilder, buildInfo, analytics);
    }
}
