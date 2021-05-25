package com.avito.android.developments_catalog;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.AdvertDetailsIntentFactory;
import com.avito.android.ItemMapIntentFactory;
import com.avito.android.PhoneRequestDeepLinkAnalyticsData;
import com.avito.android.PhotoGalleryIntentFactory;
import com.avito.android.SerpIntentFactory;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.ItemsSearchLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.deep_linking.links.PhoneRequestLink;
import com.avito.android.developments_catalog.analytics.DevelopmentsCatalogAnalyticsInteractor;
import com.avito.android.item_map.remote.model.AmenityButton;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ConsultationFormData;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.Image;
import com.avito.android.ui_components.R;
import com.avito.android.util.ImplicitIntentFactory;
import com.facebook.appevents.integrity.IntegrityManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010C\u001a\u00020@\u0012\u0006\u0010;\u001a\u000208\u0012\u0006\u00107\u001a\u000204¢\u0006\u0004\bH\u0010IJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ;\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J?\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u00052\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\fH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0002H\u0016¢\u0006\u0004\b \u0010\u0004J\u0019\u0010#\u001a\u00020\u00022\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J!\u0010)\u001a\u00020\u00022\u0006\u0010&\u001a\u00020%2\b\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b)\u0010*J\u001f\u0010.\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u00052\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006J"}, d2 = {"Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouterImpl;", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouter;", "", "closeScreen", "()V", "", "url", "title", "openNativeShareDialog", "(Ljava/lang/String;Ljava/lang/String;)V", "", "currentPosition", "", "Lcom/avito/android/remote/model/Image;", "images", "", "stateId", "searchContext", "showFullscreenGallery", "(ILjava/util/List;Ljava/lang/Long;Ljava/lang/String;)V", "Lcom/avito/android/deep_linking/links/PhoneLink;", "phoneLink", "makeCallSafely", "(Lcom/avito/android/deep_linking/links/PhoneLink;)V", "itemId", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "Lcom/avito/android/item_map/remote/model/AmenityButton;", "amenityButtons", "mapPreviewClicked", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;Ljava/lang/String;Ljava/util/List;)V", "mapPreviewSeen", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "Lcom/avito/android/deep_linking/links/PhoneRequestLink;", "link", "Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData$ResidentialComplex;", "analyticsData", "requestPhone", "(Lcom/avito/android/deep_linking/links/PhoneRequestLink;Lcom/avito/android/PhoneRequestDeepLinkAnalyticsData$ResidentialComplex;)V", "developmentId", "Lcom/avito/android/remote/model/ConsultationFormData;", "formData", "openConsultationForm", "(Ljava/lang/String;Lcom/avito/android/remote/model/ConsultationFormData;)V", "Lcom/avito/android/util/ImplicitIntentFactory;", "c", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogFragmentDelegate;", "f", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogFragmentDelegate;", "fragmentDelegate", "Landroid/content/res/Resources;", "e", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Lcom/avito/android/developments_catalog/analytics/DevelopmentsCatalogAnalyticsInteractor;", "d", "Lcom/avito/android/developments_catalog/analytics/DevelopmentsCatalogAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/ActivityIntentFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "<init>", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/util/ImplicitIntentFactory;Lcom/avito/android/developments_catalog/analytics/DevelopmentsCatalogAnalyticsInteractor;Landroid/content/res/Resources;Lcom/avito/android/developments_catalog/DevelopmentsCatalogFragmentDelegate;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class DevelopmentsCatalogRouterImpl implements DevelopmentsCatalogRouter {
    public final DeepLinkIntentFactory a;
    public final ActivityIntentFactory b;
    public final ImplicitIntentFactory c;
    public final DevelopmentsCatalogAnalyticsInteractor d;
    public final Resources e;
    public final DevelopmentsCatalogFragmentDelegate f;

    public DevelopmentsCatalogRouterImpl(@NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull ImplicitIntentFactory implicitIntentFactory, @NotNull DevelopmentsCatalogAnalyticsInteractor developmentsCatalogAnalyticsInteractor, @NotNull Resources resources, @NotNull DevelopmentsCatalogFragmentDelegate developmentsCatalogFragmentDelegate) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(implicitIntentFactory, "implicitIntentFactory");
        Intrinsics.checkNotNullParameter(developmentsCatalogAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(resources, "resources");
        Intrinsics.checkNotNullParameter(developmentsCatalogFragmentDelegate, "fragmentDelegate");
        this.a = deepLinkIntentFactory;
        this.b = activityIntentFactory;
        this.c = implicitIntentFactory;
        this.d = developmentsCatalogAnalyticsInteractor;
        this.e = resources;
        this.f = developmentsCatalogFragmentDelegate;
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogRouter
    public void closeScreen() {
        this.f.closeScreen();
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogRouter
    public void followDeepLink(@Nullable DeepLink deepLink) {
        if (deepLink instanceof ItemsSearchLink) {
            this.f.launchActivity(SerpIntentFactory.DefaultImpls.itemsListIntent$default(this.b, ((ItemsSearchLink) deepLink).getSearchParams(), null, null, null, true, false, 46, null));
        }
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogRouter
    public void makeCallSafely(@NotNull PhoneLink phoneLink) {
        Intrinsics.checkNotNullParameter(phoneLink, "phoneLink");
        Intent intent = this.a.getIntent(phoneLink);
        if (intent != null) {
            try {
                this.f.launchActivity(intent);
            } catch (ActivityNotFoundException unused) {
                this.f.launchToast(R.string.cant_do_call);
            }
        }
    }

    @Override // com.avito.android.advert_core.map.MapPreviewRouter
    public void mapPreviewClicked(@NotNull String str, @NotNull String str2, @NotNull Coordinates coordinates, @NotNull String str3, @Nullable List<AmenityButton> list) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str2, IntegrityManager.INTEGRITY_TYPE_ADDRESS);
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        Intrinsics.checkNotNullParameter(str3, "title");
        this.f.launchActivity(ItemMapIntentFactory.DefaultImpls.itemMapIntent$default(this.b, coordinates, false, null, false, str2, str3, null, str, list, false, false, null, false, null, 15432, null));
    }

    @Override // com.avito.android.advert_core.map.MapPreviewRouter
    public void mapPreviewSeen() {
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogRouter
    public void openConsultationForm(@NotNull String str, @NotNull ConsultationFormData consultationFormData) {
        Intrinsics.checkNotNullParameter(str, "developmentId");
        Intrinsics.checkNotNullParameter(consultationFormData, "formData");
        this.d.sendClickToConsultationItemButton(str);
        this.f.launchActivity(AdvertDetailsIntentFactory.DefaultImpls.consultationForm$default(this.b, null, str, consultationFormData, 1, null));
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogRouter
    public void openNativeShareDialog(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.f.launchActivityForResult(Intent.createChooser(this.c.shareItemIntent(str, str2), this.e.getString(R.string.menu_share)), 1);
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogRouter
    public void requestPhone(@NotNull PhoneRequestLink phoneRequestLink, @Nullable PhoneRequestDeepLinkAnalyticsData.ResidentialComplex residentialComplex) {
        Intrinsics.checkNotNullParameter(phoneRequestLink, "link");
        this.f.launchActivity(this.b.createPhoneRequestIntent(phoneRequestLink, residentialComplex));
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogRouter
    public void showFullscreenGallery(int i, @Nullable List<Image> list, @Nullable Long l, @Nullable String str) {
        List<Image> list2;
        ActivityIntentFactory activityIntentFactory = this.b;
        if (list != null) {
            list2 = list;
        } else {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        Intent flags = PhotoGalleryIntentFactory.DefaultImpls.legacyPhotoGalleryIntent$default(activityIntentFactory, null, list2, i, null, "24", null, null, null, l, str, null, null, 3304, null).setFlags(603979776);
        Intrinsics.checkNotNullExpressionValue(flags, "activityIntentFactory.le…FLAG_ACTIVITY_SINGLE_TOP)");
        this.f.launchActivityForResult(flags, 2);
    }
}
