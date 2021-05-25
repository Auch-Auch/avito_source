package com.avito.android.suggest_locations;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.location_picker.AddressSuggestion;
import com.avito.android.suggest_locations.SuggestLocationsPresenter;
import com.avito.android.suggest_locations.adapter.SuggestLocationItem;
import com.avito.android.suggest_locations.analytics.FromBlock;
import com.avito.android.suggest_locations.analytics.SuggestLocationsAnalyticsInteractor;
import com.avito.android.suggest_locations.di.AddressQuery;
import com.avito.android.suggest_locations.di.CategoryId;
import com.avito.android.suggest_locations.di.GeoSessionId;
import com.avito.android.suggest_locations.di.HistoricalSuggest;
import com.avito.android.suggest_locations.di.LocationId;
import com.avito.android.suggest_locations.di.OpenFromBlock;
import com.avito.android.suggest_locations.di.SuggestAddress;
import com.avito.android.suggest_locations.di.UseLegacyApi;
import com.avito.android.util.Kundle;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0001\b\u0007\u0012\u0006\u0010.\u001a\u00020+\u0012\u0006\u0010D\u001a\u00020A\u0012\u0006\u0010>\u001a\u00020;\u0012\n\b\u0001\u0010@\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0001\u0010\u001c\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0001\u0010I\u001a\u00020!\u0012\n\b\u0001\u0010 \u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0001\u0010$\u001a\u00020!\u0012\n\b\u0001\u00100\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0001\u0010*\u001a\u00020!\u0012\b\u0010L\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\bQ\u0010RJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\fJ\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u0017R\u0018\u0010 \u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010#R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010\u0017R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001c\u0010:\u001a\b\u0012\u0004\u0012\u000203078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010@\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010\u0017R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020E078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u00109R\u0016\u0010I\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010#R\u0018\u0010L\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010'R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bO\u0010P¨\u0006S"}, d2 = {"Lcom/avito/android/suggest_locations/SuggestLocationsPresenterImpl;", "Lcom/avito/android/suggest_locations/SuggestLocationsPresenter;", "Lcom/avito/android/suggest_locations/SuggestLocationsView;", "view", "", "attachView", "(Lcom/avito/android/suggest_locations/SuggestLocationsView;)V", "Lcom/avito/android/suggest_locations/SuggestLocationsPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/suggest_locations/SuggestLocationsPresenter$Router;)V", "detachRouter", "()V", "detachView", "", "query", "loadSuggests", "(Ljava/lang/String;)V", "onBackPressed", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", AuthSource.OPEN_CHANNEL_LIST, "Ljava/lang/String;", "categoryId", "", "n", "Ljava/lang/Integer;", "openFromBlock", "e", "currentQuery", "p", "addressQuery", "", VKApiConst.Q, "Z", "showHistoricalSuggest", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "c", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "s", "useLegacyApi", "Lcom/avito/android/suggest_locations/SuggestLocationsInteractor;", "i", "Lcom/avito/android/suggest_locations/SuggestLocationsInteractor;", "interactor", "r", "geoSessionId", AuthSource.SEND_ABUSE, "Lcom/avito/android/suggest_locations/SuggestLocationsView;", "Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem;", "f", "Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem;", "fullMatchLocation", "", g.a, "Ljava/util/List;", "currentResultList", "Lcom/avito/android/util/SchedulersFactory3;", "k", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "l", "locationId", "Lcom/avito/android/suggest_locations/analytics/SuggestLocationsAnalyticsInteractor;", "j", "Lcom/avito/android/suggest_locations/analytics/SuggestLocationsAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/remote/model/location_picker/AddressSuggestion;", "h", "currentAddressesList", "o", "suggestAddress", "t", "Lcom/avito/android/util/Kundle;", "state", "d", "viewDisposables", AuthSource.BOOKING_ORDER, "Lcom/avito/android/suggest_locations/SuggestLocationsPresenter$Router;", "<init>", "(Lcom/avito/android/suggest_locations/SuggestLocationsInteractor;Lcom/avito/android/suggest_locations/analytics/SuggestLocationsAnalyticsInteractor;Lcom/avito/android/util/SchedulersFactory3;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLjava/lang/String;ZLjava/lang/String;ZLcom/avito/android/util/Kundle;)V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestLocationsPresenterImpl implements SuggestLocationsPresenter {
    public SuggestLocationsView a;
    public SuggestLocationsPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final CompositeDisposable d = new CompositeDisposable();
    public String e = "";
    public SuggestLocationItem f;
    public List<SuggestLocationItem> g = CollectionsKt__CollectionsKt.emptyList();
    public List<AddressSuggestion> h = CollectionsKt__CollectionsKt.emptyList();
    public final SuggestLocationsInteractor i;
    public final SuggestLocationsAnalyticsInteractor j;
    public final SchedulersFactory3 k;
    public final String l;
    public final String m;
    public final Integer n;
    public final boolean o;
    public final String p;
    public final boolean q;
    public final String r;
    public final boolean s;
    public final Kundle t;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<Throwable> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public static final a d = new a(2);
        public static final a e = new a(3);
        public static final a f = new a(4);
        public static final a g = new a(5);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Throwable th) {
            int i = this.a;
            if (i == 0) {
                Logs.error(th);
            } else if (i == 1) {
                Logs.error(th);
            } else if (i == 2) {
                Logs.error(th);
            } else if (i == 3) {
                Logs.error(th);
            } else if (i == 4) {
                Logs.error(th);
            } else if (i == 5) {
                Logs.error(th);
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<String> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public b(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(String str) {
            SuggestLocationsPresenter.Router router;
            int i = this.a;
            if (i != 0) {
                T t = null;
                if (i == 1) {
                    String str2 = str;
                    if (((SuggestLocationsPresenterImpl) this.b).o) {
                        Iterator<T> it = ((SuggestLocationsPresenterImpl) this.b).h.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            T next = it.next();
                            String title = next.getTitle();
                            Objects.requireNonNull(title, "null cannot be cast to non-null type java.lang.String");
                            String lowerCase = title.toLowerCase();
                            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                            String str3 = ((SuggestLocationsPresenterImpl) this.b).e;
                            Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
                            String lowerCase2 = str3.toLowerCase();
                            Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase()");
                            if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                                t = next;
                                break;
                            }
                        }
                        T t2 = t;
                        if (t2 != null && (router = ((SuggestLocationsPresenterImpl) this.b).b) != null) {
                            router.openLocationPicker(t2);
                            return;
                        }
                        return;
                    }
                    SuggestLocationItem suggestLocationItem = ((SuggestLocationsPresenterImpl) this.b).f;
                    if (suggestLocationItem != null && Intrinsics.areEqual(str2, ((SuggestLocationsPresenterImpl) this.b).e)) {
                        ((SuggestLocationsPresenterImpl) this.b).j.trackSuggestLocationsScreenClose(((SuggestLocationsPresenterImpl) this.b).m, suggestLocationItem.getId(), ((SuggestLocationsPresenterImpl) this.b).e, FromBlock.FULL_MATCH, ((SuggestLocationsPresenterImpl) this.b).n, ((SuggestLocationsPresenterImpl) this.b).l, ((SuggestLocationsPresenterImpl) this.b).r);
                        SuggestLocationsPresenterImpl.access$leaveScreen((SuggestLocationsPresenterImpl) this.b, suggestLocationItem);
                        return;
                    }
                    return;
                }
                throw null;
            }
            String str4 = str;
            Intrinsics.checkNotNullExpressionValue(str4, "it");
            ((SuggestLocationsPresenterImpl) this.b).e = str4;
            ((SuggestLocationsPresenterImpl) this.b).loadSuggests(str4);
        }
    }

    /* compiled from: java-style lambda group */
    public static final class c<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public c(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                SuggestLocationsPresenterImpl suggestLocationsPresenterImpl = (SuggestLocationsPresenterImpl) this.b;
                suggestLocationsPresenterImpl.loadSuggests(suggestLocationsPresenterImpl.e);
            } else if (i == 1) {
                ((SuggestLocationsPresenterImpl) this.b).j.trackSuggestLocationsScreenClose(((SuggestLocationsPresenterImpl) this.b).m, ((SuggestLocationsPresenterImpl) this.b).l, ((SuggestLocationsPresenterImpl) this.b).e, FromBlock.REFUSE, ((SuggestLocationsPresenterImpl) this.b).n, ((SuggestLocationsPresenterImpl) this.b).l, ((SuggestLocationsPresenterImpl) this.b).r);
                SuggestLocationsPresenter.Router router = ((SuggestLocationsPresenterImpl) this.b).b;
                if (router != null) {
                    router.finishScreen();
                }
            } else {
                throw null;
            }
        }
    }

    public static final class d<T> implements Consumer<SuggestLocationItem> {
        public final /* synthetic */ SuggestLocationsPresenterImpl a;

        public d(SuggestLocationsPresenterImpl suggestLocationsPresenterImpl) {
            this.a = suggestLocationsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(SuggestLocationItem suggestLocationItem) {
            SuggestLocationItem suggestLocationItem2 = suggestLocationItem;
            this.a.j.trackSuggestLocationsScreenClose(this.a.m, suggestLocationItem2.getId(), this.a.e, FromBlock.SUGGEST, this.a.n, this.a.l, this.a.r);
            SuggestLocationsPresenterImpl suggestLocationsPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(suggestLocationItem2, "it");
            SuggestLocationsPresenterImpl.access$leaveScreen(suggestLocationsPresenterImpl, suggestLocationItem2);
        }
    }

    public static final class e<T> implements Consumer<AddressSuggestion> {
        public final /* synthetic */ SuggestLocationsPresenterImpl a;

        public e(SuggestLocationsPresenterImpl suggestLocationsPresenterImpl) {
            this.a = suggestLocationsPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(AddressSuggestion addressSuggestion) {
            AddressSuggestion addressSuggestion2 = addressSuggestion;
            SuggestLocationsPresenter.Router router = this.a.b;
            if (router != null) {
                Intrinsics.checkNotNullExpressionValue(addressSuggestion2, "it");
                router.openLocationPicker(addressSuggestion2);
            }
        }
    }

    @Inject
    public SuggestLocationsPresenterImpl(@NotNull SuggestLocationsInteractor suggestLocationsInteractor, @NotNull SuggestLocationsAnalyticsInteractor suggestLocationsAnalyticsInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @LocationId @Nullable String str, @CategoryId @Nullable String str2, @OpenFromBlock @Nullable Integer num, @SuggestAddress boolean z, @AddressQuery @Nullable String str3, @HistoricalSuggest boolean z2, @GeoSessionId @Nullable String str4, @UseLegacyApi boolean z3, @Nullable Kundle kundle) {
        Intrinsics.checkNotNullParameter(suggestLocationsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(suggestLocationsAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.i = suggestLocationsInteractor;
        this.j = suggestLocationsAnalyticsInteractor;
        this.k = schedulersFactory3;
        this.l = str;
        this.m = str2;
        this.n = num;
        this.o = z;
        this.p = str3;
        this.q = z2;
        this.r = str4;
        this.s = z3;
        this.t = kundle;
        if (kundle != null) {
            List<SuggestLocationItem> parcelableList = kundle.getParcelableList("key_suggests");
            if (parcelableList != null) {
                this.g = parcelableList;
                SuggestLocationsView suggestLocationsView = this.a;
                if (suggestLocationsView != null) {
                    suggestLocationsView.updateLocations(parcelableList);
                }
            }
            String string = kundle.getString("key_query");
            if (string != null) {
                this.e = string;
            }
        }
    }

    public static final void access$leaveScreen(SuggestLocationsPresenterImpl suggestLocationsPresenterImpl, SuggestLocationItem suggestLocationItem) {
        Objects.requireNonNull(suggestLocationsPresenterImpl);
        Location location = new Location(suggestLocationItem.getId(), suggestLocationItem.getNames(), false, false, false, false, null, false, null, null, 1020, null);
        if (suggestLocationsPresenterImpl.r != null) {
            location.setForcedLocationForRecommendation(Boolean.TRUE);
        }
        SuggestLocationsPresenter.Router router = suggestLocationsPresenterImpl.b;
        if (router != null) {
            router.leaveScreenWithLocation(location);
        }
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsPresenter
    public void attachRouter(@NotNull SuggestLocationsPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsPresenter
    public void attachView(@NotNull SuggestLocationsView suggestLocationsView) {
        Intrinsics.checkNotNullParameter(suggestLocationsView, "view");
        this.a = suggestLocationsView;
        this.j.trackSuggestLocationsScreenOpen(this.m, this.l, this.n, this.r);
        CompositeDisposable compositeDisposable = this.d;
        Disposable subscribe = suggestLocationsView.myLocationClicks().observeOn(this.k.mainThread()).subscribe(new d(this), a.d);
        Intrinsics.checkNotNullExpressionValue(subscribe, "view.myLocationClicks()\n…error(err)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        CompositeDisposable compositeDisposable2 = this.d;
        Disposable subscribe2 = suggestLocationsView.addressClicks().observeOn(this.k.mainThread()).subscribe(new e(this), a.e);
        Intrinsics.checkNotNullExpressionValue(subscribe2, "view.addressClicks()\n   …error(err)\n            })");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
        CompositeDisposable compositeDisposable3 = this.d;
        Disposable subscribe3 = suggestLocationsView.searchQueryChanged().skip(1).debounce(400, TimeUnit.MILLISECONDS, this.k.computation()).observeOn(this.k.mainThread()).subscribe(new b(0, this), a.f);
        Intrinsics.checkNotNullExpressionValue(subscribe3, "view.searchQueryChanged(…error(err)\n            })");
        DisposableKt.plusAssign(compositeDisposable3, subscribe3);
        CompositeDisposable compositeDisposable4 = this.d;
        Disposable subscribe4 = suggestLocationsView.backPressed().observeOn(this.k.mainThread()).subscribe(new c(1, this), a.g);
        Intrinsics.checkNotNullExpressionValue(subscribe4, "view.backPressed()\n     …error(err)\n            })");
        DisposableKt.plusAssign(compositeDisposable4, subscribe4);
        CompositeDisposable compositeDisposable5 = this.d;
        Disposable subscribe5 = suggestLocationsView.donePressed().observeOn(this.k.mainThread()).subscribe(new b(1, this), a.b);
        Intrinsics.checkNotNullExpressionValue(subscribe5, "view.donePressed()\n     …error(err)\n            })");
        DisposableKt.plusAssign(compositeDisposable5, subscribe5);
        CompositeDisposable compositeDisposable6 = this.d;
        Disposable subscribe6 = suggestLocationsView.errorSnackbarClicks().observeOn(this.k.mainThread()).subscribe(new c(0, this), a.c);
        Intrinsics.checkNotNullExpressionValue(subscribe6, "view.errorSnackbarClicks…error(err)\n            })");
        DisposableKt.plusAssign(compositeDisposable6, subscribe6);
        if (this.g.isEmpty()) {
            String str = this.p;
            if (str != null) {
                this.e = str;
                suggestLocationsView.updateTextQuery(str);
                return;
            }
            loadSuggests("");
        }
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsPresenter
    public void detachRouter() {
        this.c.clear();
        this.b = null;
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsPresenter
    public void detachView() {
        this.d.clear();
        this.a = null;
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsPresenter
    public void loadSuggests(@NotNull String str) {
        Single<SuggestLocationsResult> single;
        Intrinsics.checkNotNullParameter(str, "query");
        boolean z = false;
        if (this.o) {
            if (str.length() == 0) {
                z = true;
            }
            if (!z || !(!this.q)) {
                CompositeDisposable compositeDisposable = this.c;
                Disposable subscribe = this.i.getAddressSuggestions(str).observeOn(this.k.mainThread()).subscribe(new a2.a.a.d3.a(this), a2.a.a.d3.b.a);
                Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getAddressSug…error(err)\n            })");
                DisposableKt.plusAssign(compositeDisposable, subscribe);
                return;
            }
            SuggestLocationsView suggestLocationsView = this.a;
            if (suggestLocationsView != null) {
                suggestLocationsView.updateAddresses(CollectionsKt__CollectionsKt.emptyList());
                return;
            }
            return;
        }
        if (this.s) {
            if (str.length() == 0) {
                z = true;
            }
            if (!z) {
                single = this.i.getLegacyLocationSuggestions(str);
            } else {
                return;
            }
        } else {
            single = this.i.getLocationSuggestions(str, this.l);
        }
        CompositeDisposable compositeDisposable2 = this.c;
        Disposable subscribe2 = single.observeOn(this.k.mainThread()).subscribe(new a2.a.a.d3.c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "observable.observeOn(sch…          }\n            }");
        DisposableKt.plusAssign(compositeDisposable2, subscribe2);
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsPresenter
    public void onBackPressed() {
        SuggestLocationsAnalyticsInteractor suggestLocationsAnalyticsInteractor = this.j;
        String str = this.m;
        String str2 = this.l;
        suggestLocationsAnalyticsInteractor.trackSuggestLocationsScreenClose(str, str2, this.e, FromBlock.REFUSE, this.n, str2, this.r);
    }

    @Override // com.avito.android.suggest_locations.SuggestLocationsPresenter
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        kundle.putParcelableList("key_suggests", this.g);
        kundle.putString("key_query", this.e);
        return kundle;
    }
}
