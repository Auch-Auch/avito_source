package com.avito.android.developments_catalog;

import a2.g.r.g;
import android.os.Bundle;
import android.os.Parcelable;
import com.avito.android.Features;
import com.avito.android.IdProvider;
import com.avito.android.advert_core.gap.AdvertDetailsGapItem;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.deep_linking.links.PhoneRequestLink;
import com.avito.android.developments_catalog.analytics.DevelopmentsCatalogAnalyticsInteractor;
import com.avito.android.developments_catalog.di.DevelopmentId;
import com.avito.android.developments_catalog.di.DevelopmentTitle;
import com.avito.android.developments_catalog.di.FromPage;
import com.avito.android.developments_catalog.items.description.DescriptionItem;
import com.avito.android.developments_catalog.items.photoGallery.PhotoGalleryItem;
import com.avito.android.developments_catalog.items.skeleton.SkeletonItem;
import com.avito.android.developments_catalog.items.title.TitleItem;
import com.avito.android.developments_catalog.remote.model.DevelopmentsCatalogResponse;
import com.avito.android.developments_catalog.remote.model.LegalDisclaimer;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertAction;
import com.avito.android.util.Bundles;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.InteropKt;
import com.avito.conveyor_item.ParcelableItem;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BY\b\u0007\u0012\b\b\u0001\u0010`\u001a\u00020\u0002\u0012\b\b\u0001\u0010k\u001a\u00020\u0002\u0012\b\u0010\\\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0001\u0010A\u001a\u00020\u0002\u0012\u0006\u0010d\u001a\u00020a\u0012\u0006\u0010I\u001a\u00020F\u0012\u0006\u0010E\u001a\u00020B\u0012\u0006\u0010T\u001a\u00020Q\u0012\u0006\u0010X\u001a\u00020U¢\u0006\u0004\bl\u0010mJ-\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0017\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0019\u0010\u000fJ\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\u000fJ\u000f\u0010\u001f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001f\u0010\u000fJ\u000f\u0010 \u001a\u00020\bH\u0016¢\u0006\u0004\b \u0010\u000fJ\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u0019\u0010%\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b%\u0010&J\u001f\u0010*\u001a\u00020\b2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010)\u001a\u00020(H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010.\u001a\u00020\b2\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00100\u001a\u00020\bH\u0016¢\u0006\u0004\b0\u0010\u000fJ\u000f\u00101\u001a\u00020\bH\u0016¢\u0006\u0004\b1\u0010\u000fJ\u0017\u00102\u001a\u00020\b2\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b2\u0010/J\u000f\u00103\u001a\u00020\bH\u0016¢\u0006\u0004\b3\u0010\u000fJ\u0017\u00106\u001a\u00020\b2\u0006\u00105\u001a\u000204H\u0016¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u00020\b2\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b8\u0010/J!\u0010:\u001a\u00020\b2\u0006\u0010)\u001a\u00020(2\b\u0010$\u001a\u0004\u0018\u000109H\u0016¢\u0006\u0004\b:\u0010;J\u0019\u0010=\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b=\u00107J\u000f\u0010>\u001a\u00020\bH\u0016¢\u0006\u0004\b>\u0010\u000fR\u0016\u0010A\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010E\u001a\u00020B8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010L\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010YR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\f\u0010ZR\u0018\u0010\\\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010@R\u0018\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010`\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010@R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010iR\u0016\u0010k\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010@¨\u0006n"}, d2 = {"Lcom/avito/android/developments_catalog/DevelopmentsCatalogPresenterImpl;", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogPresenter;", "", "shareTitle", "shareUrl", "", "Lcom/avito/conveyor_item/ParcelableItem;", "items", "", "c", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "title", AuthSource.BOOKING_ORDER, "(Ljava/lang/String;)V", "d", "()V", "", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "Lcom/avito/android/advert_core/gap/AdvertDetailsGapItem;", AuthSource.SEND_ABUSE, "(I)Lcom/avito/android/advert_core/gap/AdvertDetailsGapItem;", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouter;", "router", "attachRouter", "(Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouter;)V", "detachRouter", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogView;", "view", "attachView", "(Lcom/avito/android/developments_catalog/DevelopmentsCatalogView;)V", "detachView", "startLoadingData", "onRetry", "Landroid/os/Bundle;", "saveState", "()Landroid/os/Bundle;", "state", "restoreState", "(Landroid/os/Bundle;)V", VKApiConst.POSITION, "", "stateId", "onPageSelected", "(IJ)V", "Lcom/avito/android/deep_linking/links/PhoneLink;", "phoneLink", "onPhoneCallShown", "(Lcom/avito/android/deep_linking/links/PhoneLink;)V", "onPhoneCallConfirmed", "onPhoneCallDismissed", "onCallButtonClick", "trackContactButtonClick", "Lcom/avito/android/deep_linking/links/DeepLink;", "link", "followDeepLink", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "call", "Landroid/os/Parcelable;", "onDescriptionExpanded", "(JLandroid/os/Parcelable;)V", "deepLink", "onOfferClick", "onDisclaimerDetailsClicked", "k", "Ljava/lang/String;", "fromPage", "Lcom/avito/android/IdProvider;", "n", "Lcom/avito/android/IdProvider;", "idProvider", "Lcom/avito/android/developments_catalog/analytics/DevelopmentsCatalogAnalyticsInteractor;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/developments_catalog/analytics/DevelopmentsCatalogAnalyticsInteractor;", "analyticsInteractor", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "commonDisposables", "", g.a, "Z", "disclaimerDialogShown", "Lcom/avito/android/util/SchedulersFactory3;", "o", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/Features;", "p", "Lcom/avito/android/Features;", "features", "Ljava/util/List;", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogRouter;", "j", "searchContext", "f", "Lcom/avito/android/deep_linking/links/PhoneLink;", "h", "itemId", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogInteractor;", "l", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogInteractor;", "interactor", "Lcom/avito/android/developments_catalog/remote/model/DevelopmentsCatalogResponse;", "e", "Lcom/avito/android/developments_catalog/remote/model/DevelopmentsCatalogResponse;", "developmentsCatalog", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogView;", "i", "startTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/developments_catalog/DevelopmentsCatalogInteractor;Lcom/avito/android/developments_catalog/analytics/DevelopmentsCatalogAnalyticsInteractor;Lcom/avito/android/IdProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/Features;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class DevelopmentsCatalogPresenterImpl implements DevelopmentsCatalogPresenter {
    public DevelopmentsCatalogView a;
    public DevelopmentsCatalogRouter b;
    public final CompositeDisposable c = new CompositeDisposable();
    public List<? extends ParcelableItem> d = CollectionsKt__CollectionsKt.emptyList();
    public DevelopmentsCatalogResponse e;
    public PhoneLink f;
    public boolean g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;
    public final DevelopmentsCatalogInteractor l;
    public final DevelopmentsCatalogAnalyticsInteractor m;
    public final IdProvider n;
    public final SchedulersFactory3 o;
    public final Features p;

    public static final class a<T> implements Consumer<Unit> {
        public final /* synthetic */ DevelopmentsCatalogPresenterImpl a;

        public a(DevelopmentsCatalogPresenterImpl developmentsCatalogPresenterImpl) {
            this.a = developmentsCatalogPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Unit unit) {
            AdvertAction.Phone phone;
            DevelopmentsCatalogResponse developmentsCatalogResponse = this.a.e;
            DeepLink deepLink = (developmentsCatalogResponse == null || (phone = developmentsCatalogResponse.getPhone()) == null) ? null : phone.getDeepLink();
            if (deepLink instanceof PhoneLink) {
                this.a.onCallButtonClick((PhoneLink) deepLink);
            } else if (deepLink instanceof PhoneRequestLink) {
                this.a.trackContactButtonClick();
                this.a.followDeepLink(deepLink);
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ DevelopmentsCatalogPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(DevelopmentsCatalogPresenterImpl developmentsCatalogPresenterImpl) {
            super(0);
            this.a = developmentsCatalogPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.g = false;
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements Consumer<LoadingState<? super DevelopmentsCatalogResponse>> {
        public final /* synthetic */ DevelopmentsCatalogPresenterImpl a;

        public d(DevelopmentsCatalogPresenterImpl developmentsCatalogPresenterImpl) {
            this.a = developmentsCatalogPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super DevelopmentsCatalogResponse> loadingState) {
            DevelopmentsCatalogView developmentsCatalogView;
            LoadingState<? super DevelopmentsCatalogResponse> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loaded) {
                DevelopmentsCatalogResponse developmentsCatalogResponse = (DevelopmentsCatalogResponse) ((LoadingState.Loaded) loadingState2).getData();
                this.a.e = developmentsCatalogResponse;
                DevelopmentsCatalogPresenterImpl.access$sendShowAnalytics(this.a, developmentsCatalogResponse);
                DevelopmentsCatalogPresenterImpl developmentsCatalogPresenterImpl = this.a;
                developmentsCatalogPresenterImpl.d = DevelopmentsCatalogPresenterImpl.access$prepareContentScreen(developmentsCatalogPresenterImpl, developmentsCatalogResponse);
                DevelopmentsCatalogPresenterImpl developmentsCatalogPresenterImpl2 = this.a;
                AdvertAction.Phone phone = developmentsCatalogResponse.getPhone();
                developmentsCatalogPresenterImpl2.b(phone != null ? phone.getTitle() : null);
                DevelopmentsCatalogPresenterImpl developmentsCatalogPresenterImpl3 = this.a;
                String title = developmentsCatalogResponse.getTitle();
                String share = developmentsCatalogResponse.getShare();
                if (share == null) {
                    share = "";
                }
                developmentsCatalogPresenterImpl3.c(title, share, this.a.d);
            } else if (loadingState2 instanceof LoadingState.Loading) {
                DevelopmentsCatalogPresenterImpl developmentsCatalogPresenterImpl4 = this.a;
                developmentsCatalogPresenterImpl4.d = DevelopmentsCatalogPresenterImpl.access$prepareLoadingScreen(developmentsCatalogPresenterImpl4);
                DevelopmentsCatalogView developmentsCatalogView2 = this.a.a;
                if (developmentsCatalogView2 != null) {
                    developmentsCatalogView2.bindItems(this.a.d);
                }
            } else if ((loadingState2 instanceof LoadingState.Error) && (developmentsCatalogView = this.a.a) != null) {
                developmentsCatalogView.showError();
            }
        }
    }

    public static final class e<T> implements Consumer<Throwable> {
        public static final e a = new e();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    @Inject
    public DevelopmentsCatalogPresenterImpl(@DevelopmentId @NotNull String str, @DevelopmentTitle @NotNull String str2, @Nullable String str3, @FromPage @NotNull String str4, @NotNull DevelopmentsCatalogInteractor developmentsCatalogInteractor, @NotNull DevelopmentsCatalogAnalyticsInteractor developmentsCatalogAnalyticsInteractor, @NotNull IdProvider idProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(str, "itemId");
        Intrinsics.checkNotNullParameter(str2, "startTitle");
        Intrinsics.checkNotNullParameter(str4, "fromPage");
        Intrinsics.checkNotNullParameter(developmentsCatalogInteractor, "interactor");
        Intrinsics.checkNotNullParameter(developmentsCatalogAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(idProvider, "idProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        this.h = str;
        this.i = str2;
        this.j = str3;
        this.k = str4;
        this.l = developmentsCatalogInteractor;
        this.m = developmentsCatalogAnalyticsInteractor;
        this.n = idProvider;
        this.o = schedulersFactory3;
        this.p = features;
    }

    public static final void access$onShareClicked(DevelopmentsCatalogPresenterImpl developmentsCatalogPresenterImpl, String str, String str2) {
        DevelopmentsCatalogAnalyticsInteractor developmentsCatalogAnalyticsInteractor = developmentsCatalogPresenterImpl.m;
        String str3 = developmentsCatalogPresenterImpl.h;
        DevelopmentsCatalogResponse developmentsCatalogResponse = developmentsCatalogPresenterImpl.e;
        developmentsCatalogAnalyticsInteractor.sendShareEvent(str3, developmentsCatalogResponse != null ? developmentsCatalogResponse.getLocationId() : null);
        DevelopmentsCatalogRouter developmentsCatalogRouter = developmentsCatalogPresenterImpl.b;
        if (developmentsCatalogRouter != null) {
            developmentsCatalogRouter.openNativeShareDialog(str2, str);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [t6.r.a.j, java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List access$prepareContentScreen(com.avito.android.developments_catalog.DevelopmentsCatalogPresenterImpl r25, com.avito.android.developments_catalog.remote.model.DevelopmentsCatalogResponse r26) {
        /*
        // Method dump skipped, instructions count: 549
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.developments_catalog.DevelopmentsCatalogPresenterImpl.access$prepareContentScreen(com.avito.android.developments_catalog.DevelopmentsCatalogPresenterImpl, com.avito.android.developments_catalog.remote.model.DevelopmentsCatalogResponse):java.util.List");
    }

    public static final List access$prepareLoadingScreen(DevelopmentsCatalogPresenterImpl developmentsCatalogPresenterImpl) {
        Objects.requireNonNull(developmentsCatalogPresenterImpl);
        ArrayList arrayList = new ArrayList();
        if (developmentsCatalogPresenterImpl.i.length() > 0) {
            arrayList.add(new TitleItem(developmentsCatalogPresenterImpl.i, null, 2, null));
        }
        arrayList.add(new SkeletonItem(null, 1, null));
        return CollectionsKt___CollectionsKt.toList(arrayList);
    }

    public static final void access$sendShowAnalytics(DevelopmentsCatalogPresenterImpl developmentsCatalogPresenterImpl, DevelopmentsCatalogResponse developmentsCatalogResponse) {
        developmentsCatalogPresenterImpl.m.sendShowDevelopments(developmentsCatalogResponse.getId(), DevelopmentsCatalogPresenterKt.access$mapMetroIds(developmentsCatalogResponse), developmentsCatalogPresenterImpl.j, developmentsCatalogResponse.getLocationId(), developmentsCatalogPresenterImpl.k);
    }

    public final AdvertDetailsGapItem a(int i2) {
        DevelopmentsCatalogItem developmentsCatalogItem = DevelopmentsCatalogItem.ITEM_GAP;
        return new AdvertDetailsGapItem((long) 11, null, i2, 0, null, null, 50, null);
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogPresenter
    public void attachRouter(@Nullable DevelopmentsCatalogRouter developmentsCatalogRouter) {
        this.b = developmentsCatalogRouter;
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogPresenter
    public void attachView(@NotNull DevelopmentsCatalogView developmentsCatalogView) {
        Intrinsics.checkNotNullParameter(developmentsCatalogView, "view");
        this.a = developmentsCatalogView;
        if (developmentsCatalogView != null) {
            CompositeDisposable compositeDisposable = this.c;
            Disposable subscribe = InteropKt.toV3(developmentsCatalogView.upButtonClicks()).observeOn(this.o.mainThread()).subscribe(new a2.a.a.n0.b(this), a2.a.a.n0.c.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "view.upButtonClicks()\n  …   }, { Logs.error(it) })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public final void b(String str) {
        DevelopmentsCatalogView developmentsCatalogView = this.a;
        if (developmentsCatalogView != null) {
            developmentsCatalogView.initContactButton(str);
            CompositeDisposable compositeDisposable = this.c;
            Disposable subscribe = InteropKt.toV3(developmentsCatalogView.contactButtonClicks()).observeOn(this.o.mainThread()).subscribe(new a(this), b.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "view.contactButtonClicks…   }, { Logs.error(it) })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
    }

    public final void c(String str, String str2, List<? extends ParcelableItem> list) {
        DevelopmentsCatalogView developmentsCatalogView = this.a;
        if (developmentsCatalogView != null) {
            developmentsCatalogView.setupToolbar();
            CompositeDisposable compositeDisposable = this.c;
            Disposable subscribe = InteropKt.toV3(developmentsCatalogView.shareButtonClicks()).toFlowable(BackpressureStrategy.DROP).subscribe(new a2.a.a.n0.a(this, str, str2));
            Intrinsics.checkNotNullExpressionValue(subscribe, "shareButtonClicks()\n    …title, url)\n            }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            developmentsCatalogView.bindItems(list);
            PhoneLink phoneLink = this.f;
            if (phoneLink != null) {
                onCallButtonClick(phoneLink);
            }
            if (this.g) {
                d();
            }
        }
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogPresenter
    public void call(@NotNull PhoneLink phoneLink) {
        Intrinsics.checkNotNullParameter(phoneLink, "phoneLink");
        DevelopmentsCatalogView developmentsCatalogView = this.a;
        if (developmentsCatalogView != null) {
            developmentsCatalogView.showPhoneCallConfirmation(phoneLink, this);
        }
        DevelopmentsCatalogResponse developmentsCatalogResponse = this.e;
        if (developmentsCatalogResponse != null) {
            this.m.sendShowPhone(developmentsCatalogResponse.getId(), DevelopmentsCatalogPresenterKt.access$mapMetroIds(developmentsCatalogResponse), this.j, developmentsCatalogResponse.getLocationId());
        }
    }

    public final void d() {
        LegalDisclaimer legalDisclaimer;
        DevelopmentsCatalogResponse developmentsCatalogResponse = this.e;
        String description = (developmentsCatalogResponse == null || (legalDisclaimer = developmentsCatalogResponse.getLegalDisclaimer()) == null) ? null : legalDisclaimer.getDescription();
        if (description != null) {
            this.g = true;
            DevelopmentsCatalogView developmentsCatalogView = this.a;
            if (developmentsCatalogView != null) {
                developmentsCatalogView.showLegalDisclaimerDialog(description, new c(this));
            }
        }
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogPresenter
    public void detachView() {
        this.a = null;
        this.c.clear();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:19:0x0048 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.ArrayList] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogPresenter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void followDeepLink(@org.jetbrains.annotations.NotNull com.avito.android.deep_linking.links.DeepLink r7) {
        /*
            r6 = this;
            java.lang.String r0 = "link"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            boolean r0 = r7 instanceof com.avito.android.deep_linking.links.PhoneRequestLink
            if (r0 == 0) goto L_0x0059
            com.avito.android.developments_catalog.remote.model.DevelopmentsCatalogResponse r0 = r6.e
            com.avito.android.developments_catalog.DevelopmentsCatalogRouter r1 = r6.b
            if (r1 == 0) goto L_0x0060
            com.avito.android.deep_linking.links.PhoneRequestLink r7 = (com.avito.android.deep_linking.links.PhoneRequestLink) r7
            if (r0 == 0) goto L_0x0054
            java.lang.String r2 = r0.getId()
            java.util.List r3 = r0.getMetro()
            if (r3 == 0) goto L_0x0044
            java.util.ArrayList r4 = new java.util.ArrayList
            r5 = 10
            int r5 = t6.n.e.collectionSizeOrDefault(r3, r5)
            r4.<init>(r5)
            java.util.Iterator r3 = r3.iterator()
        L_0x002c:
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x0048
            java.lang.Object r5 = r3.next()
            com.avito.android.developments_catalog.remote.model.MetroParam r5 = (com.avito.android.developments_catalog.remote.model.MetroParam) r5
            int r5 = r5.getId()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4.add(r5)
            goto L_0x002c
        L_0x0044:
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsKt.emptyList()
        L_0x0048:
            java.lang.String r3 = r6.j
            java.lang.String r0 = r0.getLocationId()
            com.avito.android.PhoneRequestDeepLinkAnalyticsData$ResidentialComplex r5 = new com.avito.android.PhoneRequestDeepLinkAnalyticsData$ResidentialComplex
            r5.<init>(r2, r4, r3, r0)
            goto L_0x0055
        L_0x0054:
            r5 = 0
        L_0x0055:
            r1.requestPhone(r7, r5)
            goto L_0x0060
        L_0x0059:
            com.avito.android.developments_catalog.DevelopmentsCatalogRouter r0 = r6.b
            if (r0 == 0) goto L_0x0060
            r0.followDeepLink(r7)
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.developments_catalog.DevelopmentsCatalogPresenterImpl.followDeepLink(com.avito.android.deep_linking.links.DeepLink):void");
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogPresenter
    public void onCallButtonClick(@NotNull PhoneLink phoneLink) {
        Intrinsics.checkNotNullParameter(phoneLink, "phoneLink");
        trackContactButtonClick();
        call(phoneLink);
    }

    @Override // com.avito.android.developments_catalog.items.description.DescriptionExpandListener
    public void onDescriptionExpanded(long j2, @Nullable Parcelable parcelable) {
        T t;
        T t2;
        boolean z;
        Iterator<T> it = this.d.iterator();
        while (true) {
            t = null;
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            T t3 = t2;
            if (!(t3 instanceof DescriptionItem) || t3.getStateId() != j2) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        if (t2 instanceof DescriptionItem) {
            t = t2;
        }
        T t4 = t;
        if (t4 != null) {
            t4.setState(parcelable);
        }
    }

    @Override // com.avito.android.developments_catalog.items.disclaimer.DisclaimerDetailsClickListener
    public void onDisclaimerDetailsClicked() {
        d();
    }

    @Override // com.avito.android.developments_catalog.items.avitoOffers.AvitoOfferListener
    public void onOfferClick(@Nullable DeepLink deepLink) {
        DevelopmentsCatalogResponse developmentsCatalogResponse = this.e;
        if (developmentsCatalogResponse != null) {
            this.m.sendAvitoOfferEvent(developmentsCatalogResponse.getId(), DevelopmentsCatalogPresenterKt.access$mapMetroIds(developmentsCatalogResponse), developmentsCatalogResponse.getLocationId());
        }
        DevelopmentsCatalogRouter developmentsCatalogRouter = this.b;
        if (developmentsCatalogRouter != null) {
            developmentsCatalogRouter.followDeepLink(deepLink);
        }
    }

    @Override // com.avito.android.photo_gallery.common.GalleryPageListener
    public void onPageSelected(int i2, long j2) {
        T t;
        T t2;
        boolean z;
        Iterator<T> it = this.d.iterator();
        while (true) {
            t = null;
            if (!it.hasNext()) {
                t2 = null;
                break;
            }
            t2 = it.next();
            T t3 = t2;
            if (!(t3 instanceof PhotoGalleryItem) || t3.getStateId() != j2) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        if (t2 instanceof PhotoGalleryItem) {
            t = t2;
        }
        T t4 = t;
        if (t4 != null) {
            t4.setCurrentPosition(i2);
        }
    }

    @Override // com.avito.android.developments_catalog.items.contactbar.PhoneCallListener
    public void onPhoneCallConfirmed() {
        this.f = null;
    }

    @Override // com.avito.android.developments_catalog.items.contactbar.PhoneCallListener
    public void onPhoneCallDismissed() {
        this.f = null;
    }

    @Override // com.avito.android.developments_catalog.items.contactbar.PhoneCallListener
    public void onPhoneCallShown(@NotNull PhoneLink phoneLink) {
        Intrinsics.checkNotNullParameter(phoneLink, "phoneLink");
        this.f = phoneLink;
    }

    @Override // com.avito.android.advert_core.RetryListener
    public void onRetry() {
        startLoadingData();
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogPresenter
    public void restoreState(@Nullable Bundle bundle) {
        List<? extends ParcelableItem> parcelableList;
        PhoneLink phoneLink = null;
        this.e = bundle != null ? (DevelopmentsCatalogResponse) bundle.getParcelable("developmentsCatalog") : null;
        if (!(bundle == null || (parcelableList = Bundles.getParcelableList(bundle, "developmentsCatalogItems")) == null)) {
            this.d = parcelableList;
        }
        if (bundle != null) {
            phoneLink = (PhoneLink) bundle.getParcelable("developmentsCatalogPhoneLink");
        }
        this.f = phoneLink;
        this.g = bundle != null ? bundle.getBoolean("developmentsDisclaimerDialogShown") : false;
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogPresenter
    @NotNull
    public Bundle saveState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("developmentsCatalog", this.e);
        Bundles.putParcelableList(bundle, "developmentsCatalogItems", this.d);
        bundle.putParcelable("developmentsCatalogPhoneLink", this.f);
        bundle.putBoolean("developmentsDisclaimerDialogShown", this.g);
        return bundle;
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogPresenter
    public void startLoadingData() {
        DevelopmentsCatalogResponse developmentsCatalogResponse = this.e;
        if (developmentsCatalogResponse == null) {
            CompositeDisposable compositeDisposable = this.c;
            Disposable subscribe = this.l.loadDevelopmentsCatalog(this.h).observeOn(this.o.mainThread()).subscribe(new d(this), e.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.loadDevelopme…or(it)\n                })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        } else if (developmentsCatalogResponse != null) {
            AdvertAction.Phone phone = developmentsCatalogResponse.getPhone();
            b(phone != null ? phone.getTitle() : null);
            String title = developmentsCatalogResponse.getTitle();
            String share = developmentsCatalogResponse.getShare();
            if (share == null) {
                share = "";
            }
            c(title, share, this.d);
        }
    }

    @Override // com.avito.android.developments_catalog.DevelopmentsCatalogPresenter
    public void trackContactButtonClick() {
        DevelopmentsCatalogAnalyticsInteractor developmentsCatalogAnalyticsInteractor = this.m;
        String str = this.h;
        DevelopmentsCatalogResponse developmentsCatalogResponse = this.e;
        developmentsCatalogAnalyticsInteractor.sendCallEvent(str, developmentsCatalogResponse != null ? developmentsCatalogResponse.getLocationId() : null);
    }
}
