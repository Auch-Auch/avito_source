package com.avito.android.deep_linking;

import a2.a.a.j0.f;
import a2.a.a.j0.g;
import android.net.Uri;
import com.avito.android.CalledFrom;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DeepLinkContainer;
import com.avito.android.deep_linking.links.LocationOwnerLink;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.rx3.InteropKt;
import com.facebook.share.internal.ShareConstants;
import com.yandex.mobile.ads.video.tracking.Tracker;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/deep_linking/DeepLinkingPresenterImpl;", "Lcom/avito/android/deep_linking/DeepLinkingPresenter;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", Tracker.Events.CREATIVE_START, "(Landroid/net/Uri;)V", "Lcom/avito/android/deep_linking/DeepLinkFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/DeepLinkFactory;", "deepLinkFactory", "Lcom/avito/android/deep_linking/AdjustReattributionInteractor;", "f", "Lcom/avito/android/deep_linking/AdjustReattributionInteractor;", "reattributionInteractor", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/deep_linking/DeepLinkingRouter;", "c", "Lcom/avito/android/deep_linking/DeepLinkingRouter;", "router", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "d", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "locationAnalyticsInteractor", "Lcom/avito/android/location/SavedLocationInteractor;", "e", "Lcom/avito/android/location/SavedLocationInteractor;", "locationInteractor", "<init>", "(Lcom/avito/android/deep_linking/DeepLinkFactory;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/deep_linking/DeepLinkingRouter;Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;Lcom/avito/android/location/SavedLocationInteractor;Lcom/avito/android/deep_linking/AdjustReattributionInteractor;)V", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
public final class DeepLinkingPresenterImpl implements DeepLinkingPresenter {
    public final DeepLinkFactory a;
    public final SchedulersFactory b;
    public final DeepLinkingRouter c;
    public final LocationAnalyticsInteractor d;
    public final SavedLocationInteractor e;
    public final AdjustReattributionInteractor f;

    @Inject
    public DeepLinkingPresenterImpl(@NotNull DeepLinkFactory deepLinkFactory, @NotNull SchedulersFactory schedulersFactory, @NotNull DeepLinkingRouter deepLinkingRouter, @NotNull LocationAnalyticsInteractor locationAnalyticsInteractor, @NotNull SavedLocationInteractor savedLocationInteractor, @NotNull AdjustReattributionInteractor adjustReattributionInteractor) {
        Intrinsics.checkNotNullParameter(deepLinkFactory, "deepLinkFactory");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(deepLinkingRouter, "router");
        Intrinsics.checkNotNullParameter(locationAnalyticsInteractor, "locationAnalyticsInteractor");
        Intrinsics.checkNotNullParameter(savedLocationInteractor, "locationInteractor");
        Intrinsics.checkNotNullParameter(adjustReattributionInteractor, "reattributionInteractor");
        this.a = deepLinkFactory;
        this.b = schedulersFactory;
        this.c = deepLinkingRouter;
        this.d = locationAnalyticsInteractor;
        this.e = savedLocationInteractor;
        this.f = adjustReattributionInteractor;
    }

    @Override // com.avito.android.deep_linking.DeepLinkingPresenter
    public void start(@NotNull Uri uri) {
        String locationId;
        Intrinsics.checkNotNullParameter(uri, ShareConstants.MEDIA_URI);
        DeepLink createFromUri = this.a.createFromUri(uri);
        CalledFrom.AppLinking appLinking = new CalledFrom.AppLinking(createFromUri.getPath());
        LocationOwnerLink locationOwnerLink = (LocationOwnerLink) (!(createFromUri instanceof LocationOwnerLink) ? null : createFromUri);
        if (!(locationOwnerLink == null || (locationId = locationOwnerLink.getLocationId()) == null)) {
            InteropKt.toV2(SavedLocationInteractor.DefaultImpls.wrappedLocation$default(this.e, null, false, 3, null)).subscribeOn(this.b.io()).observeOn(this.b.mainThread()).subscribe(new g(this, locationId), new f(new Function1<Throwable, Unit>(Logs.INSTANCE) { // from class: a2.a.a.j0.h
                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public Unit invoke(Throwable th) {
                    Logs logs = (Logs) this.receiver;
                    Logs.error(th);
                    return Unit.INSTANCE;
                }
            }));
        }
        this.f.startReattribution(uri);
        if (createFromUri instanceof DeepLinkContainer) {
            this.c.openDeepLinkPackage((DeepLinkContainer) createFromUri, appLinking);
        } else {
            this.c.openDeepLink(createFromUri, appLinking);
        }
    }
}
