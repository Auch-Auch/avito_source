package com.avito.android.serp.adapter.closable;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.ClosableSerpItem;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Observables;
import com.avito.konveyor.blueprint.Item;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.IterableDataSource;
import com.avito.konveyor.util.DataSources;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u00042\u000e\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R \u0010\u000b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\n\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c¨\u0006 "}, d2 = {"Lcom/avito/android/serp/adapter/closable/ClosedItemPresenterImpl;", "Lcom/avito/android/serp/adapter/closable/ClosedItemPresenter;", "Lcom/avito/android/serp/adapter/closable/ClosedItemView;", "view", "", "attachView", "(Lcom/avito/android/serp/adapter/closable/ClosedItemView;)V", "detachView", "()V", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/konveyor/blueprint/Item;", "dataSource", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "Lcom/avito/android/serp/adapter/closable/ClosedItemEventInteractor;", "d", "Lcom/avito/android/serp/adapter/closable/ClosedItemEventInteractor;", "interactor", "c", "Lcom/avito/konveyor/data_source/DataSource;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", AuthSource.BOOKING_ORDER, "Lcom/avito/android/serp/adapter/closable/ClosedItemView;", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/serp/adapter/closable/ClosedItemEventInteractor;Lcom/avito/android/util/SchedulersFactory3;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class ClosedItemPresenterImpl implements ClosedItemPresenter {
    public final CompositeDisposable a = new CompositeDisposable();
    public ClosedItemView b;
    public DataSource<? extends Item> c;
    public final ClosedItemEventInteractor d;
    public final SchedulersFactory3 e;

    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ ClosedItemPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ClosedItemPresenterImpl closedItemPresenterImpl) {
            super(1);
            this.a = closedItemPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            ClosedItemPresenterImpl closedItemPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(str2, "it");
            ClosedItemPresenterImpl.access$updateViewItem(closedItemPresenterImpl, str2);
            return Unit.INSTANCE;
        }
    }

    public ClosedItemPresenterImpl(@NotNull ClosedItemEventInteractor closedItemEventInteractor, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(closedItemEventInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.d = closedItemEventInteractor;
        this.e = schedulersFactory3;
    }

    public static final void access$updateViewItem(ClosedItemPresenterImpl closedItemPresenterImpl, String str) {
        IterableDataSource iterableDataSource;
        DataSource<? extends Item> dataSource = closedItemPresenterImpl.c;
        if (!(dataSource == null || (iterableDataSource = DataSources.toIterableDataSource(dataSource)) == null)) {
            int i = 0;
            for (Object obj : iterableDataSource) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                Item item = (Item) obj;
                if (item instanceof ClosableSerpItem) {
                    ClosableSerpItem closableSerpItem = (ClosableSerpItem) item;
                    if (Intrinsics.areEqual(closableSerpItem.getStringId(), str)) {
                        closableSerpItem.setClosed(true);
                        ClosedItemView closedItemView = closedItemPresenterImpl.b;
                        if (closedItemView != null) {
                            closedItemView.notifyItemAtPositionChanged(i);
                        }
                    }
                }
                i = i2;
            }
        }
    }

    @Override // com.avito.android.serp.adapter.closable.ClosedItemPresenter
    public void attachView(@NotNull ClosedItemView closedItemView) {
        Intrinsics.checkNotNullParameter(closedItemView, "view");
        this.b = closedItemView;
        DisposableKt.plusAssign(this.a, Observables.subscribeOnNext(a2.b.a.a.a.b2(this.e, this.d.getClosedItemEvents(), "interactor.closedItemEve…(schedulers.mainThread())"), new a(this)));
    }

    @Override // com.avito.android.serp.adapter.closable.ClosedItemPresenter
    public void detachView() {
        this.a.clear();
        this.b = null;
    }

    @Override // com.avito.android.serp.adapter.closable.ClosedItemPresenter
    public void onDataSourceChanged(@NotNull DataSource<? extends Item> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.c = dataSource;
    }
}
