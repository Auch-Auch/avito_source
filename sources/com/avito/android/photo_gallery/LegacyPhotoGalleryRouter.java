package com.avito.android.photo_gallery;

import a2.g.r.g;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.advert_core.advert.AdvertCoreRouter;
import com.avito.android.advert_core.analytics.contactbar.ShowPhoneDialerEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.authorization.AuthParamsKt;
import com.avito.android.autoteka_details.core.analytics.event.AutotekaDetailsGetReportClickEvent;
import com.avito.android.autoteka_details.core.analytics.event.FromBlock;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.contact_access.ContactAccessPackageFragment;
import com.avito.android.contact_access.ContactAccessPackageFragmentKt;
import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.deep_linking.links.CvPackagesLink;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.in_app_calls.data.CallActivityRequest;
import com.avito.android.photo_gallery.common.LegacyPhotoGalleryActivityDelegate;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.ToastsKt;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010D\u001a\u00020A\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u0010$\u001a\u00020\u0007\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u00102\u001a\u00020/\u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u0010*\u001a\u00020'¢\u0006\u0004\bE\u0010FJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u000b\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\"\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0007H\u0016¢\u0006\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010$\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010C¨\u0006G"}, d2 = {"Lcom/avito/android/photo_gallery/LegacyPhotoGalleryRouter;", "Lcom/avito/android/advert_core/advert/AdvertCoreRouter;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "", "source", "Landroid/os/Parcelable;", AuthParamsKt.KEY_SUCCESS_AUTH_RESULT_DATA, "onAuthRequired", "(Ljava/lang/String;Landroid/os/Parcelable;)V", "Lcom/avito/android/deep_linking/links/CvPackagesLink;", "link", "buyAdvertContacts", "(Lcom/avito/android/deep_linking/links/CvPackagesLink;)V", "Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial;", "dialRequest", "makeInAppCall", "(Lcom/avito/android/in_app_calls/data/CallActivityRequest$Dial;)V", "Lcom/avito/android/deep_linking/links/PhoneLink;", "phoneLink", "", "showError", "dialPhone", "(Lcom/avito/android/deep_linking/links/PhoneLink;Ljava/lang/String;Z)Z", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "followUri", "(Landroid/net/Uri;)V", "url", "Lcom/avito/android/autoteka_details/core/analytics/event/FromBlock;", BookingInfoActivity.EXTRA_FROM_BLOCK, "openAutotekaTeaser", "(Landroid/net/Uri;Lcom/avito/android/autoteka_details/core/analytics/event/FromBlock;)V", BookingInfoActivity.EXTRA_ITEM_ID, "showContactAccessPackage", "(Ljava/lang/String;)V", "Lcom/avito/android/analytics/Analytics;", "h", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/photo_gallery/common/LegacyPhotoGalleryActivityDelegate;", "d", "Lcom/avito/android/photo_gallery/common/LegacyPhotoGalleryActivityDelegate;", "activityDelegate", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "e", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "Landroidx/fragment/app/FragmentManager;", AuthSource.BOOKING_ORDER, "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "c", "Ljava/lang/String;", "Lcom/avito/android/util/ImplicitIntentFactory;", g.a, "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/ActivityIntentFactory;", "f", "Lcom/avito/android/ActivityIntentFactory;", "activityIntentFactory", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Landroidx/fragment/app/FragmentManager;Ljava/lang/String;Lcom/avito/android/photo_gallery/common/LegacyPhotoGalleryActivityDelegate;Lcom/avito/android/deep_linking/DeepLinkIntentFactory;Lcom/avito/android/ActivityIntentFactory;Lcom/avito/android/util/ImplicitIntentFactory;Lcom/avito/android/analytics/Analytics;)V", "photo-gallery_release"}, k = 1, mv = {1, 4, 2})
public final class LegacyPhotoGalleryRouter implements AdvertCoreRouter {
    public final Context a;
    public final FragmentManager b;
    public final String c;
    public final LegacyPhotoGalleryActivityDelegate d;
    public final DeepLinkIntentFactory e;
    public final ActivityIntentFactory f;
    public final ImplicitIntentFactory g;
    public final Analytics h;

    public LegacyPhotoGalleryRouter(@NotNull Context context, @NotNull FragmentManager fragmentManager, @NotNull String str, @NotNull LegacyPhotoGalleryActivityDelegate legacyPhotoGalleryActivityDelegate, @NotNull DeepLinkIntentFactory deepLinkIntentFactory, @NotNull ActivityIntentFactory activityIntentFactory, @NotNull ImplicitIntentFactory implicitIntentFactory, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Intrinsics.checkNotNullParameter(legacyPhotoGalleryActivityDelegate, "activityDelegate");
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        Intrinsics.checkNotNullParameter(activityIntentFactory, "activityIntentFactory");
        Intrinsics.checkNotNullParameter(implicitIntentFactory, "implicitIntentFactory");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = context;
        this.b = fragmentManager;
        this.c = str;
        this.d = legacyPhotoGalleryActivityDelegate;
        this.e = deepLinkIntentFactory;
        this.f = activityIntentFactory;
        this.g = implicitIntentFactory;
        this.h = analytics;
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag("tag_choose_package_fragment");
        ContactAccessPackageFragment contactAccessPackageFragment = (ContactAccessPackageFragment) (!(findFragmentByTag instanceof ContactAccessPackageFragment) ? null : findFragmentByTag);
        if (contactAccessPackageFragment != null) {
            contactAccessPackageFragment.setRouter(new LegacyPhotoGalleryRouter$setRouter$contactAccessPackageRouter$1(contactAccessPackageFragment));
        }
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreRouter
    public void buyAdvertContacts(@NotNull CvPackagesLink cvPackagesLink) {
        Intrinsics.checkNotNullParameter(cvPackagesLink, "link");
        Intent intent = this.e.getIntent(cvPackagesLink);
        if (intent != null) {
            this.d.runActivityForResult(intent, 2);
        }
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreRouter
    public boolean dialPhone(@NotNull PhoneLink phoneLink, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(phoneLink, "phoneLink");
        Intrinsics.checkNotNullParameter(str, "source");
        Intent intent = this.e.getIntent(phoneLink);
        boolean z2 = false;
        if (intent != null) {
            try {
                this.d.runActivity(intent);
                z2 = true;
            } catch (ActivityNotFoundException unused) {
                if (z) {
                    ToastsKt.showToast$default(this.a, R.string.cant_do_call, 0, 2, (Object) null);
                }
            }
            this.h.track(new ShowPhoneDialerEvent(this.c, str, true, null, null, 24, null));
        }
        return z2;
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreRouter, com.avito.android.advert.item.booking.AdvertBookingPresenter.Router, com.avito.android.advert_core.advert_badge_bar.AdvertBadgeBarPresenter.Router, com.avito.android.advert.item.cre_geo_report.AdvertDetailsGeoReportTeaserPresenter.Router, com.avito.android.advert_core.car_market_price.price_chart.CarMarketPriceChartPresenter.Router
    public void followDeepLink(@NotNull DeepLink deepLink) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intent intent = this.e.getIntent(deepLink);
        if (intent != null) {
            this.d.runActivity(intent);
        }
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreRouter
    public void followUri(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        this.d.runActivity(this.g.uriIntent(uri));
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreRouter
    public void makeInAppCall(@NotNull CallActivityRequest.Dial dial) {
        Intrinsics.checkNotNullParameter(dial, "dialRequest");
        this.d.runActivity(this.f.inAppCallIntent(dial));
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreRouter
    public void onAuthRequired(@Nullable String str, @Nullable Parcelable parcelable) {
        this.d.runActivityForResult(this.f.authIntent(null, str, parcelable), 1);
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreRouter
    public void openAutotekaTeaser(@NotNull Uri uri, @NotNull FromBlock fromBlock) {
        Intrinsics.checkNotNullParameter(uri, "url");
        Intrinsics.checkNotNullParameter(fromBlock, BookingInfoActivity.EXTRA_FROM_BLOCK);
        this.d.runActivity(ImplicitIntentFactory.DefaultImpls.uriIntentCustomChromeTabs$default(this.g, uri, false, 2, null));
        Analytics analytics = this.h;
        String str = this.c;
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "url.toString()");
        analytics.track(new AutotekaDetailsGetReportClickEvent(str, uri2, fromBlock));
    }

    @Override // com.avito.android.advert_core.advert.AdvertCoreRouter
    public void showContactAccessPackage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
        Fragment findFragmentByTag = this.b.findFragmentByTag("tag_choose_package_fragment");
        if (!(findFragmentByTag instanceof ContactAccessPackageFragment)) {
            findFragmentByTag = null;
        }
        ContactAccessPackageFragment contactAccessPackageFragment = (ContactAccessPackageFragment) findFragmentByTag;
        if (contactAccessPackageFragment == null) {
            contactAccessPackageFragment = ContactAccessPackageFragmentKt.createContactAccessPackageFragment(str);
        }
        if (contactAccessPackageFragment != null) {
            contactAccessPackageFragment.setRouter(new LegacyPhotoGalleryRouter$setRouter$contactAccessPackageRouter$1(contactAccessPackageFragment));
            contactAccessPackageFragment.show(this.b, "tag_choose_package_fragment");
        }
    }
}
