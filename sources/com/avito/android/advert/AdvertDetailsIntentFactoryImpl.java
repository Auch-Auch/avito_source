package com.avito.android.advert;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import com.avito.android.AdvertDetailsIntentFactory;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.Features;
import com.avito.android.advert.AdvertDetailsActivity;
import com.avito.android.advert.badge_details.BadgeDetailsActivityKt;
import com.avito.android.advert.closed.ClosedAdvertActivity;
import com.avito.android.advert.consultation_form.ConsultationFormActivity;
import com.avito.android.advert.cpo_program.AutotekaCpoProgramActivity;
import com.avito.android.advert.item.AdvertDetailsArguments;
import com.avito.android.advert.item.AdvertDetailsFastOpenParams;
import com.avito.android.advert.item.AdvertDetailsFragmentData;
import com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.CreditPartner;
import com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.CreditPartnerArguments;
import com.avito.android.advert.item.dfpcreditinfo.credit_partner_screen.CreditPartnerFragmentData;
import com.avito.android.advert.notes.EditAdvertNoteActivityKt;
import com.avito.android.advert.specifications.SpecificationsActivity;
import com.avito.android.analytics.provider.clickstream.TreeClickStreamParent;
import com.avito.android.auto_catalog.AutoCatalogActivity;
import com.avito.android.auto_catalog.AutoCatalogArguments;
import com.avito.android.auto_catalog.AutoCatalogData;
import com.avito.android.auto_catalog.AutoCatalogFragmentData;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.bottom_navigation.NavigationTab;
import com.avito.android.contact_access.ContactAccessServiceActivityKt;
import com.avito.android.developments_catalog.DevelopmentsCatalogActivity;
import com.avito.android.developments_catalog.DevelopmentsCatalogArguments;
import com.avito.android.developments_catalog.DevelopmentsCatalogFragmentData;
import com.avito.android.rec.ScreenSource;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ConsultationFormData;
import com.avito.android.remote.model.CpoDescription;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ModelSpecifications;
import com.vk.sdk.api.model.VKApiUserFull;
import com.vk.sdk.api.model.VKAttachments;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020N\u0012\u0006\u0010M\u001a\u00020J\u0012\u0006\u0010T\u001a\u00020Q¢\u0006\u0004\bU\u0010VJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ+\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\"\u0010#J1\u0010'\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010\u00022\u0006\u0010&\u001a\u00020\rH\u0016¢\u0006\u0004\b'\u0010(J=\u0010-\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010\u00022\b\u0010+\u001a\u0004\u0018\u00010\u00152\b\u0010,\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b-\u0010.Je\u00105\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u00022\b\u00101\u001a\u0004\u0018\u00010\u00022\b\u00102\u001a\u0004\u0018\u00010\u00022\b\u0010*\u001a\u0004\u0018\u00010\u00022\b\u00103\u001a\u0004\u0018\u00010\u00022\b\u0010$\u001a\u0004\u0018\u00010\u00022\b\u00104\u001a\u0004\u0018\u00010\u00022\b\u0010+\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b5\u00106J\u0017\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\b9\u0010:J-\u0010>\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010\u00022\b\u0010;\u001a\u0004\u0018\u00010\u00022\b\u0010=\u001a\u0004\u0018\u00010<H\u0016¢\u0006\u0004\b>\u0010?J\u0017\u0010B\u001a\u00020\u00042\u0006\u0010A\u001a\u00020@H\u0016¢\u0006\u0004\bB\u0010CJ9\u0010H\u001a\u00020\u00042\u0006\u0010D\u001a\u00020\u00022\u0006\u0010F\u001a\u00020E2\b\u0010+\u001a\u0004\u0018\u00010\u00152\u0006\u0010$\u001a\u00020\u00022\u0006\u0010G\u001a\u00020\u0002H\u0016¢\u0006\u0004\bH\u0010IR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010\u0007\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010S¨\u0006W"}, d2 = {"Lcom/avito/android/advert/AdvertDetailsIntentFactoryImpl;", "Lcom/avito/android/AdvertDetailsIntentFactory;", "", "itemId", "Landroid/content/Intent;", "inactiveItemIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "context", "title", "price", "oldPrice", "Lcom/avito/android/remote/model/Image;", "image", "", "isMarketplace", "Lcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;", "treeParent", "", "clickTime", "", "galleryPosition", "Lcom/avito/android/bottom_navigation/NavigationTab;", "tab", "Lcom/avito/android/rec/ScreenSource;", "screenSource", "advertDetailsIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;ZLcom/avito/android/analytics/provider/clickstream/TreeClickStreamParent;JLjava/lang/Integer;Lcom/avito/android/bottom_navigation/NavigationTab;Lcom/avito/android/rec/ScreenSource;)Landroid/content/Intent;", "serviceId", "externalId", "contactAccessService", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "objectId", "objectEntity", "badgeId", "badgeDetailsIntent", "(Ljava/lang/String;Ljava/lang/String;I)Landroid/content/Intent;", BookingInfoActivity.EXTRA_ITEM_ID, VKAttachments.TYPE_NOTE, "isFavorite", "advertDetailsNoteIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Landroid/content/Intent;", "id", "searchContext", "currentTab", "fromPage", "developmentsCatalog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/bottom_navigation/NavigationTab;Ljava/lang/String;)Landroid/content/Intent;", "generationId", "bodyTypeId", "modificationId", "from", "locationId", "advertMcid", "autoCatalog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/bottom_navigation/NavigationTab;)Landroid/content/Intent;", "Lcom/avito/android/remote/model/CpoDescription;", "description", "cpoProgram", "(Lcom/avito/android/remote/model/CpoDescription;)Landroid/content/Intent;", "developmentId", "Lcom/avito/android/remote/model/ConsultationFormData;", "form", "consultationForm", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/ConsultationFormData;)Landroid/content/Intent;", "Lcom/avito/android/remote/model/ModelSpecifications;", "specifications", "advertSpecificationsIntent", "(Lcom/avito/android/remote/model/ModelSpecifications;)Landroid/content/Intent;", VKApiUserFull.RelativeType.PARTNER, "Landroid/net/Uri;", "url", "brokerSession", "creditPartnerIntent", "(Ljava/lang/String;Landroid/net/Uri;Lcom/avito/android/bottom_navigation/NavigationTab;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Lcom/avito/android/Features;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/Features;", "features", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "Lcom/avito/android/CoreActivityIntentFactory;", "c", "Lcom/avito/android/CoreActivityIntentFactory;", "coreActivityIntentFactory", "<init>", "(Landroid/app/Application;Lcom/avito/android/Features;Lcom/avito/android/CoreActivityIntentFactory;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public class AdvertDetailsIntentFactoryImpl implements AdvertDetailsIntentFactory {
    public final Application a;
    public final Features b;
    public final CoreActivityIntentFactory c;

    @Inject
    public AdvertDetailsIntentFactoryImpl(@NotNull Application application, @NotNull Features features, @NotNull CoreActivityIntentFactory coreActivityIntentFactory) {
        Intrinsics.checkNotNullParameter(application, "context");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(coreActivityIntentFactory, "coreActivityIntentFactory");
        this.a = application;
        this.b = features;
        this.c = coreActivityIntentFactory;
    }

    @Override // com.avito.android.AdvertDetailsIntentFactory
    @NotNull
    public Intent advertDetailsIntent(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable Image image, boolean z, @Nullable TreeClickStreamParent treeClickStreamParent, long j, @Nullable Integer num, @Nullable NavigationTab navigationTab, @NotNull ScreenSource screenSource) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(screenSource, "screenSource");
        if (navigationTab == null) {
            return new AdvertDetailsActivity.Factory().create(this.a, str, str2, str3, str4, str5, image, num, treeClickStreamParent, j, screenSource, z);
        }
        return this.c.mainScreenWithTab(new AdvertDetailsFragmentData(new AdvertDetailsArguments(str, str2, new AdvertDetailsFastOpenParams(str3, str4, str5, image), treeClickStreamParent, j, num != null ? num.intValue() : 0, screenSource, z), navigationTab));
    }

    @Override // com.avito.android.AdvertDetailsIntentFactory
    @NotNull
    public Intent advertDetailsNoteIntent(@NotNull String str, @NotNull String str2, @Nullable String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str2, "title");
        return EditAdvertNoteActivityKt.createAdvertDetailsNoteIntent(this.a, str, str2, str3, z);
    }

    @Override // com.avito.android.AdvertDetailsIntentFactory
    @NotNull
    public Intent advertSpecificationsIntent(@NotNull ModelSpecifications modelSpecifications) {
        Intrinsics.checkNotNullParameter(modelSpecifications, "specifications");
        return new SpecificationsActivity.Factory().create(this.a, modelSpecifications);
    }

    @Override // com.avito.android.AdvertDetailsIntentFactory
    @NotNull
    public Intent autoCatalog(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8, @Nullable NavigationTab navigationTab) {
        Intrinsics.checkNotNullParameter(str, "generationId");
        Intrinsics.checkNotNullParameter(str2, "bodyTypeId");
        if (!this.b.getAutoCatalogWithoutActivity().invoke().booleanValue() || navigationTab == null) {
            return new AutoCatalogActivity.Factory().createIntent(this.a, new AutoCatalogData(str, str2, str3, str7, str8, str6), str4, str5);
        }
        return this.c.mainScreenWithTab(new AutoCatalogFragmentData(new AutoCatalogArguments(new AutoCatalogData(str, str2, str3, str7, str8, str6), str5, str4), navigationTab));
    }

    @Override // com.avito.android.AdvertDetailsIntentFactory
    @NotNull
    public Intent badgeDetailsIntent(@NotNull String str, @NotNull String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "objectId");
        Intrinsics.checkNotNullParameter(str2, "objectEntity");
        return BadgeDetailsActivityKt.createBadgeBarActivityIntent(this.a, str, str2, i);
    }

    @Override // com.avito.android.AdvertDetailsIntentFactory
    @NotNull
    public Intent consultationForm(@Nullable String str, @Nullable String str2, @Nullable ConsultationFormData consultationFormData) {
        return new ConsultationFormActivity.Factory().createIntent(this.a, str, str2, consultationFormData);
    }

    @Override // com.avito.android.AdvertDetailsIntentFactory
    @NotNull
    public Intent contactAccessService(@NotNull String str, @Nullable String str2, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return ContactAccessServiceActivityKt.createContactAccessServiceActivityIntent(this.a, str, str2, str3);
    }

    @Override // com.avito.android.AdvertDetailsIntentFactory
    @NotNull
    public Intent cpoProgram(@NotNull CpoDescription cpoDescription) {
        Intrinsics.checkNotNullParameter(cpoDescription, "description");
        return new AutotekaCpoProgramActivity.Factory().createIntent(this.a, cpoDescription);
    }

    @Override // com.avito.android.AdvertDetailsIntentFactory
    @NotNull
    public Intent creditPartnerIntent(@NotNull String str, @NotNull Uri uri, @Nullable NavigationTab navigationTab, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, VKApiUserFull.RelativeType.PARTNER);
        Intrinsics.checkNotNullParameter(uri, "url");
        Intrinsics.checkNotNullParameter(str2, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(str3, "brokerSession");
        CoreActivityIntentFactory coreActivityIntentFactory = this.c;
        CreditPartnerArguments creditPartnerArguments = new CreditPartnerArguments(CreditPartner.valueOf(str), uri, str2, str3);
        if (navigationTab == null) {
            navigationTab = NavigationTab.SEARCH.INSTANCE;
        }
        return coreActivityIntentFactory.mainScreenWithTab(new CreditPartnerFragmentData(creditPartnerArguments, navigationTab));
    }

    @Override // com.avito.android.AdvertDetailsIntentFactory
    @NotNull
    public Intent developmentsCatalog(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable NavigationTab navigationTab, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        if (str4 == null || str4.length() == 0) {
            str4 = AdvertDetailsIntentFactoryImplKt.DEVELOPMENTS_CATALOG_FROM_PAGE_DEVELOP;
        }
        if (!this.b.getDevelopmentsCatalogWithoutActivity().invoke().booleanValue() || navigationTab == null) {
            return new DevelopmentsCatalogActivity.Factory().createIntent(this.a, str, str2, str3, str4);
        }
        return this.c.mainScreenWithTab(new DevelopmentsCatalogFragmentData(new DevelopmentsCatalogArguments(str, str2, str3, str4), navigationTab));
    }

    @Override // com.avito.android.AdvertDetailsIntentFactory
    @NotNull
    public Intent inactiveItemIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        return new ClosedAdvertActivity.Factory().createIntent(this.a, str);
    }
}
