package com.avito.android.advert.actions;

import a2.g.r.g;
import android.os.Parcelable;
import com.avito.android.adapter.HiddenAdvertItem;
import com.avito.android.analytics.AdvertActionsMenuOpenEvent;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.RecommendedAdvertHiddenEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Observables;
import com.avito.android.view.ActionsMenuData;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.IterableDataSource;
import com.avito.konveyor.util.DataSources;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u00105\u001a\u000202¢\u0006\u0004\b9\u0010:J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\nJ\u001f\u0010\u0017\u001a\u00020\u00062\u000e\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u001b\u001a\u00020\u00062\u0016\u0010\u001a\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\u0018\u00010\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R&\u0010\u001a\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\u0018\u00010\u00198\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R \u0010\u0016\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0015\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107¨\u0006;"}, d2 = {"Lcom/avito/android/advert/actions/AdvertItemActionsPresenterImpl;", "Lcom/avito/android/advert/actions/AdvertItemActionsPresenter;", "Lcom/avito/android/advert/actions/AdvertItemActionsView;", "view", "Landroid/os/Parcelable;", "state", "", "attachView", "(Lcom/avito/android/advert/actions/AdvertItemActionsView;Landroid/os/Parcelable;)V", "detachView", "()V", "", "label", "hideItem", "(Ljava/lang/String;)V", "Lcom/avito/android/view/ActionsMenuData;", "menuOpenPayload", "onActionsMenuOpened", "(Lcom/avito/android/view/ActionsMenuData;)V", "onActionsMenuClosed", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/konveyor/blueprint/Item;", "dataSource", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "", "secondaryDataSources", "onSecondaryDataSourcesChanged", "(Ljava/util/List;)V", "saveState", "()Landroid/os/Parcelable;", "e", "Lcom/avito/android/view/ActionsMenuData;", "openedPayload", "d", "Ljava/util/List;", "Lcom/avito/android/advert/actions/HiddenAdvertsInteractor;", "f", "Lcom/avito/android/advert/actions/HiddenAdvertsInteractor;", "hiddenAdvertsInteractor", "c", "Lcom/avito/konveyor/data_source/DataSource;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/analytics/Analytics;", g.a, "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/util/SchedulersFactory3;", "h", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/actions/AdvertItemActionsView;", "actionsView", "<init>", "(Lcom/avito/android/advert/actions/HiddenAdvertsInteractor;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/SchedulersFactory3;)V", "advert-item-actions_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertItemActionsPresenterImpl implements AdvertItemActionsPresenter {
    public final CompositeDisposable a = new CompositeDisposable();
    public AdvertItemActionsView b;
    public DataSource<? extends Item> c;
    public List<? extends DataSource<? extends Item>> d;
    public ActionsMenuData e;
    public final HiddenAdvertsInteractor f;
    public final Analytics g;
    public final SchedulersFactory3 h;

    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ AdvertItemActionsPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(AdvertItemActionsPresenterImpl advertItemActionsPresenterImpl) {
            super(1);
            this.a = advertItemActionsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            AdvertItemActionsPresenterImpl advertItemActionsPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            AdvertItemActionsPresenterImpl.access$updateViewItem(advertItemActionsPresenterImpl, str2);
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer<TypedResult<Unit>> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(TypedResult<Unit> typedResult) {
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public static final c a = new c();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error$default("AdvertItemActionsPresenterImpl", "Error hideItem", null, 4, null);
        }
    }

    @Inject
    public AdvertItemActionsPresenterImpl(@NotNull HiddenAdvertsInteractor hiddenAdvertsInteractor, @NotNull Analytics analytics, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(hiddenAdvertsInteractor, "hiddenAdvertsInteractor");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.f = hiddenAdvertsInteractor;
        this.g = analytics;
        this.h = schedulersFactory3;
    }

    public static final void access$updateViewItem(AdvertItemActionsPresenterImpl advertItemActionsPresenterImpl, String str) {
        IterableDataSource iterableDataSource;
        DataSource<? extends Item> dataSource = advertItemActionsPresenterImpl.c;
        int i = 0;
        if (!(dataSource == null || (iterableDataSource = DataSources.toIterableDataSource(dataSource)) == null)) {
            int i2 = 0;
            for (Object obj : iterableDataSource) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Item item = (Item) obj;
                if (item instanceof HiddenAdvertItem) {
                    HiddenAdvertItem hiddenAdvertItem = (HiddenAdvertItem) item;
                    if (hiddenAdvertItem.getCanBeHidden() && Intrinsics.areEqual(hiddenAdvertItem.getStringId(), str)) {
                        hiddenAdvertItem.setHidden(true);
                        AdvertItemActionsView advertItemActionsView = advertItemActionsPresenterImpl.b;
                        if (advertItemActionsView != null) {
                            advertItemActionsView.onItemHidden(i2);
                        }
                    }
                }
                i2 = i3;
            }
        }
        List<? extends DataSource<? extends Item>> list = advertItemActionsPresenterImpl.d;
        if (list != null) {
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(DataSources.toIterableDataSource(it.next()));
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                int i4 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                IterableDataSource iterableDataSource2 = (IterableDataSource) next;
                if (iterableDataSource2 instanceof HiddenAdvertItem) {
                    HiddenAdvertItem hiddenAdvertItem2 = (HiddenAdvertItem) iterableDataSource2;
                    if (hiddenAdvertItem2.getCanBeHidden() && Intrinsics.areEqual(hiddenAdvertItem2.getStringId(), str)) {
                        hiddenAdvertItem2.setHidden(true);
                    }
                }
                i = i4;
            }
        }
    }

    @Override // com.avito.android.advert.actions.AdvertItemActionsPresenter
    public void attachView(@NotNull AdvertItemActionsView advertItemActionsView, @Nullable Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(advertItemActionsView, "view");
        this.b = advertItemActionsView;
        advertItemActionsView.setActionsMenuPresenter(this);
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.b2(this.h, this.f.advertHiddenEvents(), "hiddenAdvertsInteractor.…(schedulers.mainThread())"), new a(this)));
        if (!(parcelable instanceof ActionsMenuData)) {
            parcelable = null;
        }
        ActionsMenuData actionsMenuData = (ActionsMenuData) parcelable;
        this.e = actionsMenuData;
        if (actionsMenuData != null) {
            advertItemActionsView.showBottomActionsMenu(actionsMenuData.getTitle(), actionsMenuData.getActions(), actionsMenuData.getId(), actionsMenuData.getCategoryId(), actionsMenuData.getLocationId(), actionsMenuData.getFeedId(), actionsMenuData.getPosition());
        }
    }

    @Override // com.avito.android.advert.actions.AdvertItemActionsPresenter
    public void detachView() {
        this.a.clear();
        AdvertItemActionsView advertItemActionsView = this.b;
        if (advertItemActionsView != null) {
            advertItemActionsView.setActionsMenuPresenter(null);
        }
        this.b = null;
    }

    @Override // com.avito.android.advert.actions.HiddenAdvertItemPresenter
    public void hideItem(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "label");
        ActionsMenuData actionsMenuData = this.e;
        if (actionsMenuData != null) {
            CompositeDisposable compositeDisposable = this.a;
            Disposable subscribe = this.f.markAsHidden(actionsMenuData.getId(), str, actionsMenuData.getCategoryId(), actionsMenuData.getLocationId(), actionsMenuData.getFeedId(), actionsMenuData.getPosition()).subscribe(b.a, c.a);
            Intrinsics.checkNotNullExpressionValue(subscribe, "hiddenAdvertsInteractor\n…pl\", \"Error hideItem\") })");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
            this.g.track(new RecommendedAdvertHiddenEvent(actionsMenuData.getId(), actionsMenuData.getCategoryId(), actionsMenuData.getLocationId(), actionsMenuData.getPosition(), str));
        }
    }

    @Override // com.avito.android.advert.actions.AdvertItemActionsPresenter
    public void onActionsMenuClosed() {
        this.e = null;
    }

    @Override // com.avito.android.advert.actions.AdvertItemActionsPresenter
    public void onActionsMenuOpened(@NotNull ActionsMenuData actionsMenuData) {
        Intrinsics.checkNotNullParameter(actionsMenuData, "menuOpenPayload");
        this.e = actionsMenuData;
        this.g.track(new AdvertActionsMenuOpenEvent(actionsMenuData.getId(), actionsMenuData.getCategoryId(), actionsMenuData.getPosition()));
    }

    @Override // com.avito.android.advert.actions.HiddenAdvertItemPresenter
    public void onDataSourceChanged(@NotNull DataSource<? extends Item> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.c = dataSource;
    }

    @Override // com.avito.android.advert.actions.HiddenAdvertItemPresenter
    public void onSecondaryDataSourcesChanged(@Nullable List<? extends DataSource<? extends Item>> list) {
        this.d = list;
    }

    @Override // com.avito.android.advert.actions.AdvertItemActionsPresenter
    @Nullable
    public Parcelable saveState() {
        return this.e;
    }
}
