package com.avito.android.public_profile.di;

import a2.b.a.a.a;
import android.content.res.Resources;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.di.PerFragment;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.di.FavoriteItemModule;
import com.avito.android.public_profile.ProfileAdvertsInteractor;
import com.avito.android.public_profile.ProfileAdvertsInteractorImpl;
import com.avito.android.public_profile.ProfileAdvertsPresenter;
import com.avito.android.public_profile.ProfileAdvertsPresenterImpl;
import com.avito.android.public_profile.ProfileAdvertsResourceProvider;
import com.avito.android.public_profile.ProfileAdvertsResourceProviderImpl;
import com.avito.android.public_profile.adapter.error_snippet.ErrorSnippetItem;
import com.avito.android.public_profile.adapter.error_snippet.ErrorSnippetItemBlueprint;
import com.avito.android.public_profile.adapter.loading_item.PageLoadingItemBlueprint;
import com.avito.android.public_profile.adapter.placeholder.PlaceholderItemBlueprint;
import com.avito.android.public_profile.remote.PublicProfileApi;
import com.avito.android.public_profile.remote.model.ProfileAdvertsResult;
import com.avito.android.public_profile.tracker.PublicProfileAdvertsTracker;
import com.avito.android.recycler.base.DestroyableViewHolderBuilder;
import com.avito.android.recycler.base.DestroyableViewHolderBuilderImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.SerpItemProcessor;
import com.avito.android.serp.ad.AdResourceProvider;
import com.avito.android.serp.ad.AdResourceProviderImpl;
import com.avito.android.serp.adapter.AdvertItemDoubleBlueprint;
import com.avito.android.serp.adapter.AdvertItemGridBlueprint;
import com.avito.android.serp.adapter.AdvertItemListBlueprint;
import com.avito.android.serp.adapter.AdvertItemListener;
import com.avito.android.serp.adapter.SerpSpanProvider;
import com.avito.android.serp.adapter.SpannedGridPositionProvider;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.GeoContract;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.jakewharton.rxrelay3.PublishRelay;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.functions.Consumer;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Qualifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000È\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0003\\]^B!\u0012\b\u0010R\u001a\u0004\u0018\u00010O\u0012\u0006\u0010V\u001a\u00020S\u0012\u0006\u0010Y\u001a\u00020\u0018¢\u0006\u0004\bZ\u0010[J§\u0001\u0010&\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00162\b\b\u0001\u0010\u0019\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\n\b\u0001\u0010\u001d\u001a\u0004\u0018\u00010\u00182\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u001aH\u0001¢\u0006\u0004\b$\u0010%J\u000f\u0010)\u001a\u00020\u000eH\u0001¢\u0006\u0004\b'\u0010(J\u001f\u0010.\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*2\u0006\u0010\u0005\u001a\u00020\u0004H\u0001¢\u0006\u0004\b,\u0010-J?\u0010>\u001a\u00020;2\u0006\u00100\u001a\u00020/2\u0006\u00102\u001a\u0002012\u0006\u00104\u001a\u0002032\u0006\u00106\u001a\u0002052\u0006\u00108\u001a\u0002072\u0006\u0010:\u001a\u000209H\u0001¢\u0006\u0004\b<\u0010=J\u0017\u0010B\u001a\u00020\u00062\u0006\u0010?\u001a\u00020;H\u0001¢\u0006\u0004\b@\u0010AJ\u0017\u0010G\u001a\u00020D2\u0006\u0010C\u001a\u00020#H\u0001¢\u0006\u0004\bE\u0010FJ\u0017\u0010K\u001a\u00020H2\u0006\u0010?\u001a\u00020;H\u0001¢\u0006\u0004\bI\u0010JJ\u000f\u0010N\u001a\u00020\u0014H\u0001¢\u0006\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Y\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010X¨\u0006_"}, d2 = {"Lcom/avito/android/public_profile/di/ProfileAdvertsModule;", "", "Lcom/avito/android/public_profile/ProfileAdvertsInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/android/serp/adapter/SerpSpanProvider;", "spanProvider", "Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;", "gridPositionProvider", "Lcom/avito/android/serp/SerpItemProcessor;", "itemConverter", "Lcom/avito/android/util/ErrorFormatter;", "errorFormatter", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "Lcom/avito/android/public_profile/ProfileAdvertsResourceProvider;", "resourceProvider", "Lcom/avito/android/public_profile/tracker/PublicProfileAdvertsTracker;", "tracker", "", "shortcut", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/public_profile/adapter/error_snippet/ErrorSnippetItem;", "errorSnippetClicks", "contextId", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/public_profile/remote/model/ProfileAdvertsResult;", "profileAdvertsResultReceivedEvent", "", "profileAdvertsNeedReloadEvent", "Lcom/avito/android/public_profile/ProfileAdvertsPresenter;", "providePresenter$public_profile_release", "(Lcom/avito/android/public_profile/ProfileAdvertsInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/android/serp/adapter/SerpSpanProvider;Lcom/avito/android/serp/adapter/SpannedGridPositionProvider;Lcom/avito/android/serp/SerpItemProcessor;Lcom/avito/android/util/ErrorFormatter;Lcom/avito/android/favorite/FavoriteAdvertsPresenter;Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;Lcom/avito/android/public_profile/ProfileAdvertsResourceProvider;Lcom/avito/android/public_profile/tracker/PublicProfileAdvertsTracker;Ljava/lang/String;Lcom/jakewharton/rxrelay3/PublishRelay;Ljava/lang/String;Lio/reactivex/rxjava3/functions/Consumer;Lcom/jakewharton/rxrelay3/PublishRelay;)Lcom/avito/android/public_profile/ProfileAdvertsPresenter;", "providePresenter", "provideErrorFormatter$public_profile_release", "()Lcom/avito/android/util/ErrorFormatter;", "provideErrorFormatter", "Lcom/avito/android/public_profile/remote/PublicProfileApi;", "api", "provideInteractor$public_profile_release", "(Lcom/avito/android/public_profile/remote/PublicProfileApi;Lcom/avito/android/util/SchedulersFactory3;)Lcom/avito/android/public_profile/ProfileAdvertsInteractor;", "provideInteractor", "Lcom/avito/android/serp/adapter/AdvertItemGridBlueprint;", "advertItemGridBlueprint", "Lcom/avito/android/serp/adapter/AdvertItemListBlueprint;", "advertItemListBlueprint", "Lcom/avito/android/serp/adapter/AdvertItemDoubleBlueprint;", "advertItemDoubleBlueprint", "Lcom/avito/android/public_profile/adapter/placeholder/PlaceholderItemBlueprint;", "placeholderItemBlueprint", "Lcom/avito/android/public_profile/adapter/error_snippet/ErrorSnippetItemBlueprint;", "errorSnippetItemBlueprint", "Lcom/avito/android/public_profile/adapter/loading_item/PageLoadingItemBlueprint;", "pageLoadingItemBlueprint", "Lcom/avito/konveyor/ItemBinder;", "provideItemBinder$public_profile_release", "(Lcom/avito/android/serp/adapter/AdvertItemGridBlueprint;Lcom/avito/android/serp/adapter/AdvertItemListBlueprint;Lcom/avito/android/serp/adapter/AdvertItemDoubleBlueprint;Lcom/avito/android/public_profile/adapter/placeholder/PlaceholderItemBlueprint;Lcom/avito/android/public_profile/adapter/error_snippet/ErrorSnippetItemBlueprint;Lcom/avito/android/public_profile/adapter/loading_item/PageLoadingItemBlueprint;)Lcom/avito/konveyor/ItemBinder;", "provideItemBinder", "itemBinder", "provideAdapterPresenter$public_profile_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/konveyor/adapter/AdapterPresenter;", "provideAdapterPresenter", "profileAdvertsPresenter", "Lcom/avito/android/serp/adapter/AdvertItemListener;", "provideAdvertItemListener$public_profile_release", "(Lcom/avito/android/public_profile/ProfileAdvertsPresenter;)Lcom/avito/android/serp/adapter/AdvertItemListener;", "provideAdvertItemListener", "Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "provideDestroyableViewHolderBuilder$public_profile_release", "(Lcom/avito/konveyor/ItemBinder;)Lcom/avito/android/recycler/base/DestroyableViewHolderBuilder;", "provideDestroyableViewHolderBuilder", "profileAdvertsResourceProvider$public_profile_release", "()Lcom/avito/android/public_profile/ProfileAdvertsResourceProvider;", "profileAdvertsResourceProvider", "Lcom/avito/android/util/Kundle;", AuthSource.SEND_ABUSE, "Lcom/avito/android/util/Kundle;", "presenterState", "Landroid/content/res/Resources;", AuthSource.BOOKING_ORDER, "Landroid/content/res/Resources;", "resources", "c", "Ljava/lang/String;", "userKey", "<init>", "(Lcom/avito/android/util/Kundle;Landroid/content/res/Resources;Ljava/lang/String;)V", "ContextId", "Dependencies", "Shortcut", "public-profile_release"}, k = 1, mv = {1, 4, 2})
@Module(includes = {FavoriteItemModule.class, Dependencies.class})
public final class ProfileAdvertsModule {
    public final Kundle a;
    public final Resources b;
    public final String c;

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/public_profile/di/ProfileAdvertsModule$ContextId;", "", "<init>", "()V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface ContextId {
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\ba\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H'¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/public_profile/di/ProfileAdvertsModule$Dependencies;", "", "Lcom/avito/android/serp/ad/AdResourceProviderImpl;", GeoContract.PROVIDER, "Lcom/avito/android/serp/ad/AdResourceProvider;", "bindAdResourceProvider", "(Lcom/avito/android/serp/ad/AdResourceProviderImpl;)Lcom/avito/android/serp/ad/AdResourceProvider;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/public_profile/remote/model/ProfileAdvertsResult;", "advertsDataReceivedEvent", "Lio/reactivex/rxjava3/functions/Consumer;", "bindAdvertsDataReceivedEvent", "(Lcom/jakewharton/rxrelay3/PublishRelay;)Lio/reactivex/rxjava3/functions/Consumer;", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    @Module
    public interface Dependencies {
        @PerFragment
        @Binds
        @NotNull
        AdResourceProvider bindAdResourceProvider(@NotNull AdResourceProviderImpl adResourceProviderImpl);

        @Binds
        @NotNull
        @PerFragment
        Consumer<ProfileAdvertsResult> bindAdvertsDataReceivedEvent(@NotNull PublishRelay<ProfileAdvertsResult> publishRelay);
    }

    @Qualifier
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/public_profile/di/ProfileAdvertsModule$Shortcut;", "", "<init>", "()V", "public-profile_release"}, k = 1, mv = {1, 4, 2})
    @Retention(RetentionPolicy.RUNTIME)
    @kotlin.annotation.Retention
    public @interface Shortcut {
    }

    public ProfileAdvertsModule(@Nullable Kundle kundle, @NotNull Resources resources, @NotNull String str) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(str, "userKey");
        this.a = kundle;
        this.b = resources;
        this.c = str;
    }

    @Provides
    @PerFragment
    @NotNull
    public final ProfileAdvertsResourceProvider profileAdvertsResourceProvider$public_profile_release() {
        return new ProfileAdvertsResourceProviderImpl(this.b);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdapterPresenter provideAdapterPresenter$public_profile_release(@NotNull ItemBinder itemBinder) {
        return a.D1(itemBinder, "itemBinder", itemBinder, itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final AdvertItemListener provideAdvertItemListener$public_profile_release(@NotNull ProfileAdvertsPresenter profileAdvertsPresenter) {
        Intrinsics.checkNotNullParameter(profileAdvertsPresenter, "profileAdvertsPresenter");
        return profileAdvertsPresenter;
    }

    @Provides
    @PerFragment
    @NotNull
    public final DestroyableViewHolderBuilder provideDestroyableViewHolderBuilder$public_profile_release(@NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        return new DestroyableViewHolderBuilderImpl(itemBinder);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ErrorFormatter provideErrorFormatter$public_profile_release() {
        return new ErrorFormatterImpl(this.b);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ProfileAdvertsInteractor provideInteractor$public_profile_release(@NotNull PublicProfileApi publicProfileApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(publicProfileApi, "api");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        return new ProfileAdvertsInteractorImpl(publicProfileApi, schedulersFactory3);
    }

    @Provides
    @PerFragment
    @NotNull
    public final ItemBinder provideItemBinder$public_profile_release(@NotNull AdvertItemGridBlueprint advertItemGridBlueprint, @NotNull AdvertItemListBlueprint advertItemListBlueprint, @NotNull AdvertItemDoubleBlueprint advertItemDoubleBlueprint, @NotNull PlaceholderItemBlueprint placeholderItemBlueprint, @NotNull ErrorSnippetItemBlueprint errorSnippetItemBlueprint, @NotNull PageLoadingItemBlueprint pageLoadingItemBlueprint) {
        Intrinsics.checkNotNullParameter(advertItemGridBlueprint, "advertItemGridBlueprint");
        Intrinsics.checkNotNullParameter(advertItemListBlueprint, "advertItemListBlueprint");
        Intrinsics.checkNotNullParameter(advertItemDoubleBlueprint, "advertItemDoubleBlueprint");
        Intrinsics.checkNotNullParameter(placeholderItemBlueprint, "placeholderItemBlueprint");
        Intrinsics.checkNotNullParameter(errorSnippetItemBlueprint, "errorSnippetItemBlueprint");
        Intrinsics.checkNotNullParameter(pageLoadingItemBlueprint, "pageLoadingItemBlueprint");
        return new ItemBinder.Builder().registerItem(advertItemGridBlueprint).registerItem(advertItemListBlueprint).registerItem(advertItemDoubleBlueprint).registerItem(placeholderItemBlueprint).registerItem(errorSnippetItemBlueprint).registerItem(pageLoadingItemBlueprint).build();
    }

    @Provides
    @NotNull
    @PerFragment
    public final ProfileAdvertsPresenter providePresenter$public_profile_release(@NotNull ProfileAdvertsInteractor profileAdvertsInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AdapterPresenter adapterPresenter, @NotNull SerpSpanProvider serpSpanProvider, @NotNull SpannedGridPositionProvider spannedGridPositionProvider, @NotNull SerpItemProcessor serpItemProcessor, @NotNull ErrorFormatter errorFormatter, @NotNull FavoriteAdvertsPresenter favoriteAdvertsPresenter, @NotNull ViewedAdvertsPresenter viewedAdvertsPresenter, @NotNull ProfileAdvertsResourceProvider profileAdvertsResourceProvider, @NotNull PublicProfileAdvertsTracker publicProfileAdvertsTracker, @Shortcut @NotNull String str, @NotNull PublishRelay<ErrorSnippetItem> publishRelay, @ContextId @Nullable String str2, @NotNull Consumer<ProfileAdvertsResult> consumer, @NotNull PublishRelay<Unit> publishRelay2) {
        Intrinsics.checkNotNullParameter(profileAdvertsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(serpSpanProvider, "spanProvider");
        Intrinsics.checkNotNullParameter(spannedGridPositionProvider, "gridPositionProvider");
        Intrinsics.checkNotNullParameter(serpItemProcessor, "itemConverter");
        Intrinsics.checkNotNullParameter(errorFormatter, "errorFormatter");
        Intrinsics.checkNotNullParameter(favoriteAdvertsPresenter, "favoriteAdvertsPresenter");
        Intrinsics.checkNotNullParameter(viewedAdvertsPresenter, "viewedAdvertsPresenter");
        Intrinsics.checkNotNullParameter(profileAdvertsResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(publicProfileAdvertsTracker, "tracker");
        Intrinsics.checkNotNullParameter(str, "shortcut");
        Intrinsics.checkNotNullParameter(publishRelay, "errorSnippetClicks");
        Intrinsics.checkNotNullParameter(consumer, "profileAdvertsResultReceivedEvent");
        Intrinsics.checkNotNullParameter(publishRelay2, "profileAdvertsNeedReloadEvent");
        return new ProfileAdvertsPresenterImpl(this.c, str, str2, profileAdvertsInteractor, schedulersFactory3, adapterPresenter, serpSpanProvider, spannedGridPositionProvider, serpItemProcessor, errorFormatter, favoriteAdvertsPresenter, profileAdvertsResourceProvider, viewedAdvertsPresenter, this.a, publicProfileAdvertsTracker, publishRelay, consumer, publishRelay2);
    }
}
