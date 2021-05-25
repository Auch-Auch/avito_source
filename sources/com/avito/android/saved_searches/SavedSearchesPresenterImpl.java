package com.avito.android.saved_searches;

import a2.a.a.j2.f;
import a2.a.a.j2.h;
import a2.g.r.g;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.links.SaveSearchLink;
import com.avito.android.deep_linking.links.SaveSearchLinkType;
import com.avito.android.deep_linking.links.SearchPushSubscription;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.saved_searches.SavedSearchesPresenter;
import com.avito.android.saved_searches.analytics.SavedSearchOpenEvent;
import com.avito.android.saved_searches.di.SavedSearchState;
import com.avito.android.search.subscriptions.SubscribeSearchInteractor;
import com.avito.android.util.Kundle;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Disposables;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.y.l;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B5\b\u0007\u0012\u0006\u00107\u001a\u000204\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010G\u001a\u00020D\u0012\u0006\u0010=\u001a\u00020:\u0012\n\b\u0001\u0010L\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\bM\u0010NJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJm\u0010\u0016\u001a`\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013 \u0014*\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00110\u0011 \u0014*/\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013 \u0014*\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00110\u0011\u0018\u00010\u0010¢\u0006\u0002\b\u00150\u0010¢\u0006\u0002\b\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J=\u0010\u0018\u001a0\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00060\u0006 \u0014*\u0017\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u0010¢\u0006\u0002\b\u00150\u0010¢\u0006\u0002\b\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0017J=\u0010\u0019\u001a0\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00060\u0006 \u0014*\u0017\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u0010¢\u0006\u0002\b\u00150\u0010¢\u0006\u0002\b\u0015H\u0016¢\u0006\u0004\b\u0019\u0010\u0017J+\u0010 \u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'RD\u0010+\u001a0\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00060\u0006 \u0014*\u0017\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u0010¢\u0006\u0002\b\u00150\u0010¢\u0006\u0002\b\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010#RD\u0010.\u001a0\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00060\u0006 \u0014*\u0017\u0012\f\u0012\n \u0014*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u0010¢\u0006\u0002\b\u00150\u0010¢\u0006\u0002\b\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010*R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00103\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<Rt\u0010?\u001a`\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013 \u0014*\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00110\u0011 \u0014*/\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013 \u0014*\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00110\u0011\u0018\u00010\u0010¢\u0006\u0002\b\u00150\u0010¢\u0006\u0002\b\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010*R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010J¨\u0006O"}, d2 = {"Lcom/avito/android/saved_searches/SavedSearchesPresenterImpl;", "Lcom/avito/android/saved_searches/SavedSearchesPresenter;", "Lcom/avito/android/saved_searches/SavedSearchView;", "view", "", "isPushEnabled", "", "attachView", "(Lcom/avito/android/saved_searches/SavedSearchView;Z)V", "detachView", "()V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "setPushEnabled", "(Z)V", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lkotlin/Pair;", "Lcom/avito/android/saved_searches/SearchSubscribeReason;", "Lcom/avito/android/deep_linking/links/SaveSearchLink;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "subscribeAction", "()Lcom/jakewharton/rxrelay3/PublishRelay;", "requestAuthAction", "showSettingsAction", "Lcom/avito/android/deep_linking/links/SearchPushSubscription;", "subscriptionParams", "", "fromSource", "Lcom/avito/android/remote/model/search/map/Area;", "searchArea", "openSubscriptionDialog", "(Lcom/avito/android/deep_linking/links/SearchPushSubscription;Ljava/lang/String;Lcom/avito/android/remote/model/search/map/Area;)V", g.a, "Z", "isDialogOpened", "Lcom/avito/android/util/SchedulersFactory3;", "l", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "d", "Lcom/jakewharton/rxrelay3/PublishRelay;", "requestAuthRelay", "j", "e", "showSettingsRelay", "i", "Lcom/avito/android/remote/model/search/map/Area;", "h", "Lcom/avito/android/deep_linking/links/SearchPushSubscription;", "currentSearchSubscription", "Lcom/avito/android/search/subscriptions/SubscribeSearchInteractor;", "k", "Lcom/avito/android/search/subscriptions/SubscribeSearchInteractor;", "interactor", AuthSource.SEND_ABUSE, "Lcom/avito/android/saved_searches/SavedSearchView;", "Lcom/avito/android/analytics/Analytics;", "n", "Lcom/avito/android/analytics/Analytics;", "analytics", "c", "subscribeRelay", "", "f", "Ljava/lang/Integer;", "pushFrequencyId", "Lcom/avito/android/account/AccountStateProvider;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/account/AccountStateProvider;", "accountStateProvider", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "savedSearchDisposable", "state", "<init>", "(Lcom/avito/android/search/subscriptions/SubscribeSearchInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/Kundle;)V", "saved-searches_release"}, k = 1, mv = {1, 4, 2})
public final class SavedSearchesPresenterImpl implements SavedSearchesPresenter {
    public SavedSearchView a;
    public final CompositeDisposable b = new CompositeDisposable();
    public final PublishRelay<Pair<SearchSubscribeReason, SaveSearchLink>> c = PublishRelay.create();
    public final PublishRelay<Unit> d = PublishRelay.create();
    public final PublishRelay<Unit> e = PublishRelay.create();
    public Integer f;
    public boolean g;
    public SearchPushSubscription h;
    public Area i;
    public boolean j;
    public final SubscribeSearchInteractor k;
    public final SchedulersFactory3 l;
    public final AccountStateProvider m;
    public final Analytics n;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            SaveSearchLinkType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[1] = 1;
            iArr[2] = 2;
            iArr[0] = 3;
        }
    }

    @Inject
    public SavedSearchesPresenterImpl(@NotNull SubscribeSearchInteractor subscribeSearchInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull AccountStateProvider accountStateProvider, @NotNull Analytics analytics, @SavedSearchState @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(subscribeSearchInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountStateProvider");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.k = subscribeSearchInteractor;
        this.l = schedulersFactory3;
        this.m = accountStateProvider;
        this.n = analytics;
        SearchPushSubscription searchPushSubscription = null;
        SavedSearchesPresenterState savedSearchesPresenterState = kundle != null ? (SavedSearchesPresenterState) kundle.getParcelable("saved_searches_state") : null;
        this.f = savedSearchesPresenterState != null ? savedSearchesPresenterState.getSelectedFrequencyId() : null;
        this.g = savedSearchesPresenterState != null ? savedSearchesPresenterState.isDialogOpened() : false;
        this.h = savedSearchesPresenterState != null ? savedSearchesPresenterState.getSubscriptionParams() : searchPushSubscription;
    }

    public static final void access$invalidateState(SavedSearchesPresenterImpl savedSearchesPresenterImpl) {
        savedSearchesPresenterImpl.f = null;
        savedSearchesPresenterImpl.g = false;
        savedSearchesPresenterImpl.h = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$saveSearch(com.avito.android.saved_searches.SavedSearchesPresenterImpl r30, com.avito.android.deep_linking.links.SearchPushSubscription r31) {
        /*
            r0 = r30
            java.util.Objects.requireNonNull(r30)
            kotlin.jvm.internal.Ref$ObjectRef r1 = new kotlin.jvm.internal.Ref$ObjectRef
            r1.<init>()
            a2.a.a.j2.d r2 = a2.a.a.j2.d.a
            r1.element = r2
            com.avito.android.deep_linking.links.SaveSearchLinkType r2 = r31.getType()
            int r2 = r2.ordinal()
            r3 = 1
            if (r2 == 0) goto L_0x0085
            if (r2 == r3) goto L_0x003e
            r3 = 2
            if (r2 == r3) goto L_0x0027
            com.avito.android.saved_searches.SavedSearchView r2 = r0.a
            if (r2 == 0) goto L_0x009b
            r2.showErrorMessage()
            goto L_0x009b
        L_0x0027:
            java.lang.String r2 = r31.getFilterId()
            if (r2 == 0) goto L_0x009b
            s5 r3 = new s5
            r4 = 0
            r3.<init>(r4, r0, r1)
            r1.element = r3
            com.avito.android.search.subscriptions.SubscribeSearchInteractor r3 = r0.k
            java.lang.Integer r4 = r0.f
            io.reactivex.rxjava3.core.Observable r2 = r3.subscribeToSearch(r2, r4)
            goto L_0x009c
        L_0x003e:
            a2.a.a.j2.e r2 = new a2.a.a.j2.e
            r2.<init>(r0)
            r1.element = r2
            com.avito.android.search.subscriptions.SubscribeSearchInteractor r2 = r0.k
            com.avito.android.remote.model.SearchParams r3 = r31.getSearchParams()
            if (r3 == 0) goto L_0x004e
            goto L_0x007c
        L_0x004e:
            com.avito.android.remote.model.SearchParams r3 = new com.avito.android.remote.model.SearchParams
            r4 = r3
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 8388607(0x7fffff, float:1.1754942E-38)
            r29 = 0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29)
        L_0x007c:
            java.lang.Integer r4 = r0.f
            com.avito.android.remote.model.search.map.Area r5 = r0.i
            io.reactivex.rxjava3.core.Observable r2 = r2.subscribeToSearch(r3, r4, r5)
            goto L_0x009c
        L_0x0085:
            java.lang.String r2 = r31.getFilterId()
            if (r2 == 0) goto L_0x009b
            s5 r4 = new s5
            r4.<init>(r3, r0, r1)
            r1.element = r4
            com.avito.android.search.subscriptions.SubscribeSearchInteractor r3 = r0.k
            java.lang.Integer r4 = r0.f
            io.reactivex.rxjava3.core.Observable r2 = r3.updatePushFrequencyForSubscription(r2, r4)
            goto L_0x009c
        L_0x009b:
            r2 = 0
        L_0x009c:
            if (r2 == 0) goto L_0x00ca
            io.reactivex.rxjava3.disposables.CompositeDisposable r3 = r0.b
            com.avito.android.util.SchedulersFactory3 r4 = r0.l
            io.reactivex.rxjava3.core.Scheduler r4 = r4.io()
            io.reactivex.rxjava3.core.Observable r2 = r2.subscribeOn(r4)
            com.avito.android.util.SchedulersFactory3 r4 = r0.l
            io.reactivex.rxjava3.core.Scheduler r4 = r4.mainThread()
            io.reactivex.rxjava3.core.Observable r2 = r2.observeOn(r4)
            a2.a.a.j2.b r4 = new a2.a.a.j2.b
            r4.<init>(r0, r1)
            a2.a.a.j2.c r1 = new a2.a.a.j2.c
            r1.<init>(r0)
            io.reactivex.rxjava3.disposables.Disposable r0 = r2.subscribe(r4, r1)
            java.lang.String r1 = "subscribeObservable\n    ….error(it)\n            })"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            com.avito.android.util.rx3.Disposables.plusAssign(r3, r0)
        L_0x00ca:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.saved_searches.SavedSearchesPresenterImpl.access$saveSearch(com.avito.android.saved_searches.SavedSearchesPresenterImpl, com.avito.android.deep_linking.links.SearchPushSubscription):void");
    }

    @Override // com.avito.android.saved_searches.SavedSearchesPresenter
    public void attachView(@NotNull SavedSearchView savedSearchView, boolean z) {
        Intrinsics.checkNotNullParameter(savedSearchView, "view");
        this.a = savedSearchView;
        this.j = z;
        if (savedSearchView != null) {
            CompositeDisposable compositeDisposable = this.b;
            Disposable subscribe = savedSearchView.applyAction().observeOn(this.l.mainThread()).subscribe(new t3(0, this));
            Intrinsics.checkNotNullExpressionValue(subscribe, "applyAction()\n          …      }\n                }");
            Disposables.plusAssign(compositeDisposable, subscribe);
            CompositeDisposable compositeDisposable2 = this.b;
            Disposable subscribe2 = savedSearchView.frequencyChangedAction().subscribe(new f(this));
            Intrinsics.checkNotNullExpressionValue(subscribe2, "frequencyChangedAction()…encyId = it\n            }");
            Disposables.plusAssign(compositeDisposable2, subscribe2);
            CompositeDisposable compositeDisposable3 = this.b;
            Disposable subscribe3 = savedSearchView.deleteAction().subscribe(new h(this));
            Intrinsics.checkNotNullExpressionValue(subscribe3, "deleteAction().subscribe…          }\n            }");
            Disposables.plusAssign(compositeDisposable3, subscribe3);
            CompositeDisposable compositeDisposable4 = this.b;
            Disposable subscribe4 = savedSearchView.openSettingsAction().observeOn(this.l.mainThread()).subscribe(new t3(1, this));
            Intrinsics.checkNotNullExpressionValue(subscribe4, "openSettingsAction()\n   …t(Unit)\n                }");
            Disposables.plusAssign(compositeDisposable4, subscribe4);
            CompositeDisposable compositeDisposable5 = this.b;
            Disposable subscribe5 = savedSearchView.closeAction().subscribe(new t3(2, this));
            Intrinsics.checkNotNullExpressionValue(subscribe5, "closeAction()\n          …State()\n                }");
            Disposables.plusAssign(compositeDisposable5, subscribe5);
        }
        SearchPushSubscription searchPushSubscription = this.h;
        if (searchPushSubscription != null && this.g) {
            SavedSearchesPresenter.DefaultImpls.openSubscriptionDialog$default(this, searchPushSubscription, null, null, 4, null);
        }
    }

    @Override // com.avito.android.saved_searches.SavedSearchesPresenter
    public void detachView() {
        SavedSearchView savedSearchView = this.a;
        if (savedSearchView != null) {
            savedSearchView.closeDialog();
        }
        this.a = null;
        this.b.clear();
    }

    @Override // com.avito.android.saved_searches.SavedSearchesPresenter
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelable("saved_searches_state", new SavedSearchesPresenterState(this.h, this.g, this.f));
    }

    @Override // com.avito.android.saved_searches.SavedSearchesPresenter
    public void openSubscriptionDialog(@NotNull SearchPushSubscription searchPushSubscription, @Nullable String str, @Nullable Area area) {
        Intrinsics.checkNotNullParameter(searchPushSubscription, "subscriptionParams");
        this.h = searchPushSubscription;
        searchPushSubscription.getSearchParams();
        this.i = area;
        this.g = true;
        if (this.f == null) {
            Integer pushFrequencyId = searchPushSubscription.getPushFrequencyId();
            this.f = Integer.valueOf(pushFrequencyId != null ? pushFrequencyId.intValue() : 0);
        }
        if (str != null) {
            Analytics analytics = this.n;
            String xHash = searchPushSubscription.getXHash();
            String filterId = searchPushSubscription.getFilterId();
            analytics.track(new SavedSearchOpenEvent(xHash, str, filterId != null ? l.toIntOrNull(filterId) : null));
        }
        SavedSearchView savedSearchView = this.a;
        if (savedSearchView != null) {
            savedSearchView.show(searchPushSubscription, this.f, this.j);
        }
    }

    @Override // com.avito.android.saved_searches.SavedSearchesPresenter
    public void setPushEnabled(boolean z) {
        this.j = z;
    }

    @Override // com.avito.android.saved_searches.SavedSearchesPresenter
    public PublishRelay<Unit> requestAuthAction() {
        return this.d;
    }

    @Override // com.avito.android.saved_searches.SavedSearchesPresenter
    public PublishRelay<Unit> showSettingsAction() {
        return this.e;
    }

    @Override // com.avito.android.saved_searches.SavedSearchesPresenter
    public PublishRelay<Pair<SearchSubscribeReason, SaveSearchLink>> subscribeAction() {
        return this.c;
    }
}
