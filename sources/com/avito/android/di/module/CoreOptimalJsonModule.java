package com.avito.android.di.module;

import android.net.Uri;
import com.avito.android.Features;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.deep_linking.DeepLinkFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.AdfoxBannerItem;
import com.avito.android.remote.model.AdvertItemActions;
import com.avito.android.remote.model.Color;
import com.avito.android.remote.model.DfpBannerItem;
import com.avito.android.remote.model.Disclaimer;
import com.avito.android.remote.model.HeaderElement;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.LinkAction;
import com.avito.android.remote.model.MyTargetBannerItem;
import com.avito.android.remote.model.NameIdEntity;
import com.avito.android.remote.model.OtherAdverts;
import com.avito.android.remote.model.SerpAdvert;
import com.avito.android.remote.model.SerpAdvertEmptyPlaceholder;
import com.avito.android.remote.model.SerpAdvertGroupTitle;
import com.avito.android.remote.model.SerpAdvertXl;
import com.avito.android.remote.model.SerpBannerContainer;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.SerpVipAdverts;
import com.avito.android.remote.model.SerpWarning;
import com.avito.android.remote.model.ServiceTypeKt;
import com.avito.android.remote.model.ShortcutBanner;
import com.avito.android.remote.model.UserAdvert;
import com.avito.android.remote.model.WitcherElement;
import com.avito.android.remote.model.YandexNativeBannerItem;
import com.avito.android.remote.model.location_notification.LocationNotification;
import com.avito.android.remote.model.map_banner.MapBanner;
import com.avito.android.remote.model.search.suggest.BubblesSuggestItem;
import com.avito.android.remote.model.search.suggest.GapSuggestItem;
import com.avito.android.remote.model.search.suggest.IconSource;
import com.avito.android.remote.model.search.suggest.LocalIcon;
import com.avito.android.remote.model.search.suggest.ServerIcon;
import com.avito.android.remote.model.search.suggest.SuggestAction;
import com.avito.android.remote.model.search.suggest.SuggestAnalyticsEvent;
import com.avito.android.remote.model.search.suggest.SuggestDeeplink;
import com.avito.android.remote.model.search.suggest.SuggestItem;
import com.avito.android.remote.model.search.suggest.SuggestNewQuery;
import com.avito.android.remote.model.search.suggest.TextSuggestItem;
import com.avito.android.remote.model.search.suggest.TitleSuggestItem;
import com.avito.android.remote.model.section.SectionElement;
import com.avito.android.remote.model.section.VipAdvert;
import com.avito.android.remote.model.serp.Snippet;
import com.avito.android.remote.model.user_adverts.DiscountBanner;
import com.avito.android.remote.model.user_adverts.PerformanceVasBanner;
import com.avito.android.remote.parse.adapter.AdvertItemActionsTypeAdapter;
import com.avito.android.remote.parse.adapter.ColorTypeAdapter;
import com.avito.android.remote.parse.adapter.DeepLinkTypeAdapter;
import com.avito.android.remote.parse.adapter.ImageTypeAdapter;
import com.avito.android.remote.parse.adapter.SerpResultDisplayTypeAdapter;
import com.avito.android.remote.parse.adapter.UriTypeAdapter;
import com.avito.android.remote.parse.adapter.stream_gson.ActionTypeAdapterFactory;
import com.avito.android.remote.parse.adapter.stream_gson.AdvertCommercialsAdapterFactory;
import com.avito.android.remote.parse.adapter.stream_gson.CaseTextTypeAdapterFactory;
import com.avito.android.remote.parse.adapter.stream_gson.DfpSerpBannerTypeFactory;
import com.avito.android.remote.parse.adapter.stream_gson.LinkActionTypeAdapter;
import com.avito.android.remote.parse.adapter.stream_gson.LocationTypeAdapterFactory;
import com.avito.android.remote.parse.adapter.stream_gson.NameIdEntityTypeAdapter;
import com.avito.android.remote.parse.adapter.stream_gson.OptimalRuntimeTypeAdapterFactory;
import com.avito.android.remote.parse.adapter.stream_gson.SuggestsTypeAdapterFactory;
import com.avito.android.remote.parse.adapter.stream_gson.TypedResultTypeAdapterFactory;
import com.avito.android.remote.parse.adapter.stream_gson.UserAdvertStatusTypeAdapter;
import com.avito.android.remote.parse.adapter.stream_gson.VipAdvertTypeAdapterFactory;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.CustomTypedResultEntry;
import com.avito.android.util.OptimalTypeAdapterEntry;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.TypeAdapterFactory;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import t6.n.x;
import t6.n.y;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010#JA\u0010\u000b\u001a\u00020\n2\u0013\b\u0001\u0010\u0005\u001a\r\u0012\t\u0012\u00070\u0003¢\u0006\u0002\b\u00040\u00022\u0013\b\u0001\u0010\u0007\u001a\r\u0012\t\u0012\u00070\u0006¢\u0006\u0002\b\u00040\u00022\u0006\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u0011\u0010\u0012J$\u0010\u0016\u001a\u00020\u00152\u0013\b\u0001\u0010\u0014\u001a\r\u0012\t\u0012\u00070\u0013¢\u0006\u0002\b\u00040\u0002H\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0002H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J'\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00060\u00022\b\b\u0001\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0007¢\u0006\u0004\b\u001d\u0010\u0019J\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u001e\u0010\u0019J\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u001f\u0010\u0019J\u0015\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0007¢\u0006\u0004\b \u0010\u0019J\u0015\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0007¢\u0006\u0004\b!\u0010\u0019¨\u0006$"}, d2 = {"Lcom/avito/android/di/module/CoreOptimalJsonModule;", "", "", "Lcom/avito/android/util/OptimalTypeAdapterEntry;", "Lkotlin/jvm/JvmSuppressWildcards;", "typeAdapterEntries", "Lcom/google/gson/TypeAdapterFactory;", "typeAdapterFactories", "Lcom/avito/android/util/BuildInfo;", "buildInfo", "Lcom/google/gson/Gson;", "provideStreamGson", "(Ljava/util/Set;Ljava/util/Set;Lcom/avito/android/util/BuildInfo;)Lcom/google/gson/Gson;", "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/Features;", "features", "provideCommonTypeAdapters", "(Lcom/avito/android/deep_linking/DeepLinkFactory;Lcom/avito/android/Features;)Ljava/util/Set;", "Lcom/avito/android/util/CustomTypedResultEntry;", "entries", "Lcom/avito/android/remote/parse/adapter/stream_gson/TypedResultTypeAdapterFactory;", "provideTypedResultTypeAdapterFactory", "(Ljava/util/Set;)Lcom/avito/android/remote/parse/adapter/stream_gson/TypedResultTypeAdapterFactory;", "customTypedResultEntrySet", "()Ljava/util/Set;", "typedResultTypeAdapterFactory", "provideCommonTypeAdapterFactories", "(Lcom/avito/android/remote/parse/adapter/stream_gson/TypedResultTypeAdapterFactory;Lcom/avito/android/Features;)Ljava/util/Set;", "provideSerpElementAdapterFactories", "provideUserAdvertStatusTypeAdapter", "provideAdvertItemActionsTypeAdapter", "provideCaseTextTypeAdapterFactory", "provideLocationTypeAdapterFactory", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class CoreOptimalJsonModule {
    @NotNull
    public static final CoreOptimalJsonModule INSTANCE = new CoreOptimalJsonModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    @StreamGson
    public static final Set<CustomTypedResultEntry> customTypedResultEntrySet() {
        return y.emptySet();
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    @StreamGson
    public static final Set<TypeAdapterFactory> provideCommonTypeAdapterFactories(@StreamGson @NotNull TypedResultTypeAdapterFactory typedResultTypeAdapterFactory, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(typedResultTypeAdapterFactory, "typedResultTypeAdapterFactory");
        Intrinsics.checkNotNullParameter(features, "features");
        OptimalRuntimeTypeAdapterFactory.Companion companion = OptimalRuntimeTypeAdapterFactory.Companion;
        return y.setOf((Object[]) new TypeAdapterFactory[]{typedResultTypeAdapterFactory, new VipAdvertTypeAdapterFactory(), new ActionTypeAdapterFactory(), new DfpSerpBannerTypeFactory(), new SuggestsTypeAdapterFactory(), new AdvertCommercialsAdapterFactory(), companion.of(SectionElement.class).registerSubtype(SerpAdvert.class, "item").registerSubtype(VipAdvert.class, ServiceTypeKt.SERVICE_VIP).registerSubtype(ShortcutBanner.class, "shortcut"), companion.of(SuggestItem.class).registerSubtype(TextSuggestItem.class, "text_item").registerSubtype(BubblesSuggestItem.class, "bubble_group").registerSubtype(GapSuggestItem.class, "gap").registerSubtype(TitleSuggestItem.class, "title"), companion.of(SuggestAction.class).registerSubtype(SuggestNewQuery.class, "new_query").registerSubtype(SuggestAnalyticsEvent.class, "clickstream").registerSubtype(SuggestDeeplink.class, "deeplink"), companion.of(IconSource.class).registerSubtype(LocalIcon.class, ImagesContract.LOCAL).registerSubtype(ServerIcon.class, BaseAnalyticKt.ANALYTIC_FAIL_SERVER)});
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    @StreamGson
    public static final Set<OptimalTypeAdapterEntry> provideCommonTypeAdapters(@NotNull DeepLinkFactory deepLinkFactory, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        Intrinsics.checkNotNullParameter(features, "features");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new OptimalTypeAdapterEntry(Uri.class, new UriTypeAdapter()));
        linkedHashSet.add(new OptimalTypeAdapterEntry(Color.class, new ColorTypeAdapter()));
        linkedHashSet.add(new OptimalTypeAdapterEntry(DeepLink.class, new DeepLinkTypeAdapter(deepLinkFactory)));
        linkedHashSet.add(new OptimalTypeAdapterEntry(Image.class, new ImageTypeAdapter()));
        linkedHashSet.add(new OptimalTypeAdapterEntry(NameIdEntity.class, new NameIdEntityTypeAdapter()));
        linkedHashSet.add(new OptimalTypeAdapterEntry(LinkAction.class, new LinkActionTypeAdapter()));
        linkedHashSet.add(new OptimalTypeAdapterEntry(SerpDisplayType.class, new SerpResultDisplayTypeAdapter()));
        return linkedHashSet;
    }

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    @StreamGson
    public static final Set<TypeAdapterFactory> provideSerpElementAdapterFactories() {
        return x.setOf(OptimalRuntimeTypeAdapterFactory.Companion.of(SerpElement.class).registerSubtype(SerpAdvert.class, "item").registerSubtype(SerpAdvertXl.class, "xlItem").registerSubtype(SerpBannerContainer.class, "banner").registerSubtype(SerpVipAdverts.class, ServiceTypeKt.SERVICE_VIP).registerSubtype(DfpBannerItem.class, "dfp").registerSubtype(YandexNativeBannerItem.class, "yandex").registerSubtype(AdfoxBannerItem.class, "adfox").registerSubtype(ShortcutBanner.class, "shortcut").registerSubtype(UserAdvert.class, "user_item").registerSubtype(DiscountBanner.class, "discount_banner").registerSubtype(PerformanceVasBanner.class, "performance_vas_banner").registerSubtype(OtherAdverts.class, "other_items").registerSubtype(ShortcutBanner.class, "info_banner").registerSubtype(Disclaimer.class, "disclaimer").registerSubtype(MyTargetBannerItem.class, "myTarget").registerSubtype(Snippet.class, "snippet").registerSubtype(SerpWarning.class, "warning").registerSubtype(SerpAdvertGroupTitle.class, "groupTitle").registerSubtype(SerpAdvertEmptyPlaceholder.class, InternalConstsKt.PLACEHOLDER).registerSubtype(HeaderElement.class, TariffPackageInfoConverterKt.HEADER_STRING_ID).registerSubtype(WitcherElement.class, "witcher").registerSubtype(LocationNotification.class, "laasTooltip").registerSubtype(MapBanner.class, "mapBanner"));
    }

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    @StreamGson
    public static final Gson provideStreamGson(@StreamGson @NotNull Set<OptimalTypeAdapterEntry> set, @StreamGson @NotNull Set<TypeAdapterFactory> set2, @NotNull BuildInfo buildInfo) {
        Intrinsics.checkNotNullParameter(set, "typeAdapterEntries");
        Intrinsics.checkNotNullParameter(set2, "typeAdapterFactories");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        GsonBuilder gsonBuilder = new GsonBuilder();
        for (T t : set) {
            if (!buildInfo.isDebug() || (!Intrinsics.areEqual(t.getType(), JsonDeserializer.class))) {
                gsonBuilder.registerTypeAdapter(t.getType(), t.getTypeAdapter());
            } else {
                throw new IllegalStateException("Using jsonDeserializer is non-streaming.".toString());
            }
        }
        Iterator<T> it = set2.iterator();
        while (it.hasNext()) {
            gsonBuilder.registerTypeAdapterFactory(it.next());
        }
        Gson create = gsonBuilder.create();
        Intrinsics.checkNotNullExpressionValue(create, "gsonBuilder.create()");
        return create;
    }

    @Provides
    @JvmStatic
    @NotNull
    @StreamGson
    public static final TypedResultTypeAdapterFactory provideTypedResultTypeAdapterFactory(@StreamGson @NotNull Set<CustomTypedResultEntry> set) {
        Intrinsics.checkNotNullParameter(set, "entries");
        TypedResultTypeAdapterFactory typedResultTypeAdapterFactory = new TypedResultTypeAdapterFactory();
        for (T t : set) {
            typedResultTypeAdapterFactory.registerCustomType(t.getType(), t.getStatuses());
        }
        return typedResultTypeAdapterFactory;
    }

    @Provides
    @ElementsIntoSet
    @NotNull
    @StreamGson
    public final Set<OptimalTypeAdapterEntry> provideAdvertItemActionsTypeAdapter() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new OptimalTypeAdapterEntry(AdvertItemActions.class, new AdvertItemActionsTypeAdapter()));
        return linkedHashSet;
    }

    @Provides
    @ElementsIntoSet
    @NotNull
    @StreamGson
    public final Set<TypeAdapterFactory> provideCaseTextTypeAdapterFactory() {
        return x.setOf(new CaseTextTypeAdapterFactory());
    }

    @Provides
    @ElementsIntoSet
    @NotNull
    @StreamGson
    public final Set<TypeAdapterFactory> provideLocationTypeAdapterFactory() {
        return x.setOf(new LocationTypeAdapterFactory());
    }

    @Provides
    @ElementsIntoSet
    @NotNull
    @StreamGson
    public final Set<OptimalTypeAdapterEntry> provideUserAdvertStatusTypeAdapter() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.add(new OptimalTypeAdapterEntry(UserAdvert.Status.class, new UserAdvertStatusTypeAdapter()));
        return linkedHashSet;
    }
}
