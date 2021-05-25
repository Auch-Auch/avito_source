package com.avito.android.advert.viewed;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.ViewedAdvertItem;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Observables;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.IterableDataSource;
import com.avito.konveyor.util.DataSources;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00042\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\u0010\u001a\u00020\u00042\u0016\u0010\u000f\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R&\u0010\u000f\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\n0\t\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R \u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#¨\u0006&"}, d2 = {"Lcom/avito/android/advert/viewed/ViewedAdvertsPresenterImpl;", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "Lcom/avito/android/advert/viewed/ViewedAdvertsView;", "view", "", "attachView", "(Lcom/avito/android/advert/viewed/ViewedAdvertsView;)V", "detachView", "()V", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/konveyor/blueprint/Item;", "dataSource", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "", "secondaryDataSources", "onSecondaryDataSourcesChanged", "(Ljava/util/List;)V", "d", "Ljava/util/List;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "c", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;", "e", "Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;", "interactor", "Lcom/avito/android/util/SchedulersFactory3;", "f", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/viewed/ViewedAdvertsView;", "<init>", "(Lcom/avito/android/advert/viewed/ViewedAdvertsEventInteractor;Lcom/avito/android/util/SchedulersFactory3;)V", "viewed-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class ViewedAdvertsPresenterImpl implements ViewedAdvertsPresenter {
    public final CompositeDisposable a = new CompositeDisposable();
    public ViewedAdvertsView b;
    public DataSource<? extends Item> c;
    public List<? extends DataSource<? extends Item>> d;
    public final ViewedAdvertsEventInteractor e;
    public final SchedulersFactory3 f;

    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ ViewedAdvertsPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ViewedAdvertsPresenterImpl viewedAdvertsPresenterImpl) {
            super(1);
            this.a = viewedAdvertsPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            ViewedAdvertsPresenterImpl viewedAdvertsPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            ViewedAdvertsPresenterImpl.access$updateViewItem(viewedAdvertsPresenterImpl, str2);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ViewedAdvertsPresenterImpl(@NotNull ViewedAdvertsEventInteractor viewedAdvertsEventInteractor, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(viewedAdvertsEventInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.e = viewedAdvertsEventInteractor;
        this.f = schedulersFactory3;
    }

    public static final void access$updateViewItem(ViewedAdvertsPresenterImpl viewedAdvertsPresenterImpl, String str) {
        IterableDataSource iterableDataSource;
        DataSource<? extends Item> dataSource = viewedAdvertsPresenterImpl.c;
        int i = 0;
        if (!(dataSource == null || (iterableDataSource = DataSources.toIterableDataSource(dataSource)) == null)) {
            int i2 = 0;
            for (Object obj : iterableDataSource) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Item item = (Item) obj;
                if (item instanceof ViewedAdvertItem) {
                    ViewedAdvertItem viewedAdvertItem = (ViewedAdvertItem) item;
                    if (Intrinsics.areEqual(viewedAdvertItem.getStringId(), str)) {
                        viewedAdvertItem.setViewed(true);
                        ViewedAdvertsView viewedAdvertsView = viewedAdvertsPresenterImpl.b;
                        if (viewedAdvertsView != null) {
                            viewedAdvertsView.notifyItemAtPositionChanged(i2);
                        }
                    }
                }
                i2 = i3;
            }
        }
        List<? extends DataSource<? extends Item>> list = viewedAdvertsPresenterImpl.d;
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
                if (iterableDataSource2 instanceof ViewedAdvertItem) {
                    ViewedAdvertItem viewedAdvertItem2 = (ViewedAdvertItem) iterableDataSource2;
                    if (Intrinsics.areEqual(viewedAdvertItem2.getStringId(), str)) {
                        viewedAdvertItem2.setViewed(true);
                    }
                }
                i = i4;
            }
        }
    }

    @Override // com.avito.android.advert.viewed.ViewedAdvertsPresenter
    public void attachView(@NotNull ViewedAdvertsView viewedAdvertsView) {
        Intrinsics.checkNotNullParameter(viewedAdvertsView, "view");
        this.b = viewedAdvertsView;
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.b2(this.f, this.e.getAdvertViewedEvents(), "interactor.advertViewedE…(schedulers.mainThread())"), new a(this)));
    }

    @Override // com.avito.android.advert.viewed.ViewedAdvertsPresenter
    public void detachView() {
        this.a.clear();
        this.b = null;
    }

    @Override // com.avito.android.advert.viewed.ViewedAdvertsPresenter
    public void onDataSourceChanged(@NotNull DataSource<? extends Item> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.c = dataSource;
    }

    @Override // com.avito.android.advert.viewed.ViewedAdvertsPresenter
    public void onSecondaryDataSourcesChanged(@Nullable List<? extends DataSource<? extends Item>> list) {
        this.d = list;
    }
}
