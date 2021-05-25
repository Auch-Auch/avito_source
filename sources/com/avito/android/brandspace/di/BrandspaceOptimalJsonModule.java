package com.avito.android.brandspace.di;

import com.avito.android.brandspace.remote.model.BrandspaceAboutModule;
import com.avito.android.brandspace.remote.model.BrandspaceCategoriesModule;
import com.avito.android.brandspace.remote.model.BrandspaceElement;
import com.avito.android.brandspace.remote.model.BrandspaceGalleryModule;
import com.avito.android.brandspace.remote.model.BrandspaceLegalModule;
import com.avito.android.brandspace.remote.model.BrandspaceMainBannerModule;
import com.avito.android.brandspace.remote.model.BrandspaceNewsModule;
import com.avito.android.brandspace.remote.model.BrandspaceProductComparisonModule;
import com.avito.android.brandspace.remote.model.BrandspaceProductDescriptionsModule;
import com.avito.android.brandspace.remote.model.BrandspaceSERPModule;
import com.avito.android.brandspace.remote.model.BrandspaceTextWithImageModule;
import com.avito.android.brandspace.remote.model.BrandspaceTextWithVideoModule;
import com.avito.android.brandspace.remote.model.BrandspaceVideoGalleryModule;
import com.avito.android.brandspace.remote.model.MarketplaceBannerElement;
import com.avito.android.brandspace.remote.model.MarketplaceCategoriesModule;
import com.avito.android.brandspace.remote.model.MarketplaceSnippetModule;
import com.avito.android.brandspace.remote.model.MarketplaceTabsModule;
import com.avito.android.di.module.StreamGson;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.parse.adapter.stream_gson.OptimalRuntimeTypeAdapterFactory;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.google.gson.TypeAdapterFactory;
import com.vk.sdk.api.model.VKApiUserFull;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
import t6.n.x;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005JI\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0006*\b\u0012\u0004\u0012\u00028\u00000\u00072\u000e\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\b2\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000b0\n\"\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/avito/android/brandspace/di/BrandspaceOptimalJsonModule;", "", "", "Lcom/google/gson/TypeAdapterFactory;", "provideBrandspaceTypeAdapterFactories", "()Ljava/util/Set;", "T", "Lcom/avito/android/remote/parse/adapter/stream_gson/OptimalRuntimeTypeAdapterFactory;", "Ljava/lang/Class;", "type", "", "", "labels", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/parse/adapter/stream_gson/OptimalRuntimeTypeAdapterFactory;Ljava/lang/Class;[Ljava/lang/String;)Lcom/avito/android/remote/parse/adapter/stream_gson/OptimalRuntimeTypeAdapterFactory;", "<init>", "()V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class BrandspaceOptimalJsonModule {
    @NotNull
    public static final BrandspaceOptimalJsonModule INSTANCE = new BrandspaceOptimalJsonModule();

    @Provides
    @JvmStatic
    @ElementsIntoSet
    @NotNull
    @StreamGson
    public static final Set<TypeAdapterFactory> provideBrandspaceTypeAdapterFactories() {
        BrandspaceOptimalJsonModule brandspaceOptimalJsonModule = INSTANCE;
        return x.setOf(brandspaceOptimalJsonModule.a(brandspaceOptimalJsonModule.a(brandspaceOptimalJsonModule.a(brandspaceOptimalJsonModule.a(brandspaceOptimalJsonModule.a(brandspaceOptimalJsonModule.a(brandspaceOptimalJsonModule.a(brandspaceOptimalJsonModule.a(brandspaceOptimalJsonModule.a(brandspaceOptimalJsonModule.a(brandspaceOptimalJsonModule.a(brandspaceOptimalJsonModule.a(OptimalRuntimeTypeAdapterFactory.Companion.of(BrandspaceElement.class), BrandspaceMainBannerModule.class, TariffPackageInfoConverterKt.HEADER_STRING_ID, "bsMainBanner"), BrandspaceCategoriesModule.class, "infoSnippets", "bsCategories"), BrandspaceProductDescriptionsModule.class, "productDescriptions", "bsProductDescriptions"), BrandspaceVideoGalleryModule.class, "videoReviews", "bsVideoGallery"), BrandspaceSERPModule.class, "filteredAdverts", "bsSERP"), BrandspaceNewsModule.class, "news", "bsNews"), BrandspaceGalleryModule.class, "gallery", "bsGallery"), BrandspaceProductComparisonModule.class, "productComparison", "bsProductComparison"), BrandspaceTextWithImageModule.class, BaseAnalyticKt.ANALYTIC_MODULE_OFFER, "bsTextWithImage"), BrandspaceTextWithVideoModule.class, "videoOffer", "bsTextWithVideo"), BrandspaceLegalModule.class, "legal", "bsLegal"), BrandspaceAboutModule.class, VKApiUserFull.ABOUT, "bsAbout").registerSubtype(MarketplaceCategoriesModule.class, "marketplaceCategories").registerSubtype(MarketplaceBannerElement.class, "marketplaceBanner").registerSubtype(MarketplaceSnippetModule.class, "marketplaceSnippetList").registerSubtype(MarketplaceTabsModule.class, "marketplaceTabItems"));
    }

    public final <T> OptimalRuntimeTypeAdapterFactory<T> a(OptimalRuntimeTypeAdapterFactory<T> optimalRuntimeTypeAdapterFactory, Class<? extends T> cls, String... strArr) {
        for (String str : strArr) {
            optimalRuntimeTypeAdapterFactory = optimalRuntimeTypeAdapterFactory.registerSubtype(cls, str);
        }
        return optimalRuntimeTypeAdapterFactory;
    }
}
