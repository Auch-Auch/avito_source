package com.avito.android.publish_limits_info.history;

import a2.g.r.g;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.publish_limits_info.ItemId;
import com.avito.android.publish_limits_info.history.tab.HistoryTabItem;
import com.avito.android.publish_limits_info.history.tab.PublishAdvertsHistoryProvider;
import com.avito.android.publish_limits_info.history.tab.advert.HistoryAdvertItem;
import com.avito.android.publish_limits_info.history.tab.info.InfoItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertHistoryInfo;
import com.avito.android.remote.model.AdvertsHistory;
import com.avito.android.util.LoadingState;
import com.avito.android.util.LoadingStateKt;
import com.avito.android.util.Logs;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.rx3.Disposables;
import com.avito.conveyor_item.Item;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u00011B'\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010.\u001a\u00020+¢\u0006\u0004\b/\u00100J\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0014¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0004\b\r\u0010\u000bR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0017\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR%\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u001d0\u001c8\u0006@\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/avito/android/publish_limits_info/history/tab/PublishAdvertsHistoryProvider;", "", "shortcut", "", "Lcom/avito/conveyor_item/Item;", "getAdvertsShortcut", "(Ljava/lang/String;)Ljava/util/List;", "", "onCleared", "()V", "onRetryClicked", "c", "Lcom/avito/android/util/SchedulersFactory3;", "h", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/publish_limits_info/ItemId;", "f", "Lcom/avito/android/publish_limits_info/ItemId;", "getItemId", "()Lcom/avito/android/publish_limits_info/ItemId;", "itemId", "Lcom/avito/android/remote/model/AdvertsHistory;", "d", "Lcom/avito/android/remote/model/AdvertsHistory;", "history", "Landroidx/lifecycle/MutableLiveData;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryViewModel$State;", "e", "Landroidx/lifecycle/MutableLiveData;", "getState", "()Landroidx/lifecycle/MutableLiveData;", "state", "Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryInteractor;", g.a, "Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryInteractor;", "interactor", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposable", "Lcom/avito/android/util/RandomKeyProvider;", "i", "Lcom/avito/android/util/RandomKeyProvider;", "keyProvider", "<init>", "(Lcom/avito/android/publish_limits_info/ItemId;Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/util/RandomKeyProvider;)V", "State", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public final class PublishLimitsHistoryViewModel extends ViewModel implements PublishAdvertsHistoryProvider {
    public final CompositeDisposable c = new CompositeDisposable();
    public AdvertsHistory d;
    @NotNull
    public final MutableLiveData<LoadingState<State>> e = new MutableLiveData<>();
    @NotNull
    public final ItemId f;
    public final PublishLimitsHistoryInteractor g;
    public final SchedulersFactory3 h;
    public final RandomKeyProvider i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0010\u0010\r\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b¢\u0006\u0004\b \u0010!J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u001a\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ8\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00022\u0012\b\u0002\u0010\r\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u000b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R#\u0010\r\u001a\f\u0012\u0004\u0012\u00020\u00070\u0006j\u0002`\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\nR\u0019\u0010\f\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u0004¨\u0006\""}, d2 = {"Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryViewModel$State;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "Lcom/avito/android/publish_limits_info/history/tab/HistoryTabItem;", "Lcom/avito/android/publish_limits_info/history/Tabs;", "component3", "()Ljava/util/List;", "title", "description", "tabs", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/publish_limits_info/history/PublishLimitsHistoryViewModel$State;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "c", "Ljava/util/List;", "getTabs", AuthSource.BOOKING_ORDER, "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @NotNull
        public final String a;
        @NotNull
        public final String b;
        @NotNull
        public final List<HistoryTabItem> c;

        public State(@NotNull String str, @NotNull String str2, @NotNull List<HistoryTabItem> list) {
            a2.b.a.a.a.c1(str, "title", str2, "description", list, "tabs");
            this.a = str;
            this.b = str2;
            this.c = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.publish_limits_info.history.PublishLimitsHistoryViewModel$State */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, String str, String str2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = state.a;
            }
            if ((i & 2) != 0) {
                str2 = state.b;
            }
            if ((i & 4) != 0) {
                list = state.c;
            }
            return state.copy(str, str2, list);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final List<HistoryTabItem> component3() {
            return this.c;
        }

        @NotNull
        public final State copy(@NotNull String str, @NotNull String str2, @NotNull List<HistoryTabItem> list) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "description");
            Intrinsics.checkNotNullParameter(list, "tabs");
            return new State(str, str2, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return Intrinsics.areEqual(this.a, state.a) && Intrinsics.areEqual(this.b, state.b) && Intrinsics.areEqual(this.c, state.c);
        }

        @NotNull
        public final String getDescription() {
            return this.b;
        }

        @NotNull
        public final List<HistoryTabItem> getTabs() {
            return this.c;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            List<HistoryTabItem> list = this.c;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("State(title=");
            L.append(this.a);
            L.append(", description=");
            L.append(this.b);
            L.append(", tabs=");
            return a2.b.a.a.a.w(L, this.c, ")");
        }
    }

    public static final class a<T> implements Consumer<LoadingState<? super AdvertsHistory>> {
        public final /* synthetic */ PublishLimitsHistoryViewModel a;

        public a(PublishLimitsHistoryViewModel publishLimitsHistoryViewModel) {
            this.a = publishLimitsHistoryViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super AdvertsHistory> loadingState) {
            LoadingState<? super AdvertsHistory> loadingState2 = loadingState;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "result");
            AdvertsHistory advertsHistory = (AdvertsHistory) LoadingStateKt.dataOrNull(loadingState2);
            if (advertsHistory != null) {
                this.a.d = advertsHistory;
            }
            this.a.getState().setValue(PublishLimitsHistoryViewModel.access$getTabs(this.a, loadingState2));
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public static final b a = new b();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("PublishLimitsHistory", "Can't get history", th);
        }
    }

    public PublishLimitsHistoryViewModel(@NotNull ItemId itemId, @NotNull PublishLimitsHistoryInteractor publishLimitsHistoryInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull RandomKeyProvider randomKeyProvider) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(publishLimitsHistoryInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(randomKeyProvider, "keyProvider");
        this.f = itemId;
        this.g = publishLimitsHistoryInteractor;
        this.h = schedulersFactory3;
        this.i = randomKeyProvider;
        c();
    }

    public static final /* synthetic */ AdvertsHistory access$getHistory$p(PublishLimitsHistoryViewModel publishLimitsHistoryViewModel) {
        AdvertsHistory advertsHistory = publishLimitsHistoryViewModel.d;
        if (advertsHistory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("history");
        }
        return advertsHistory;
    }

    public static final LoadingState access$getTabs(PublishLimitsHistoryViewModel publishLimitsHistoryViewModel, LoadingState loadingState) {
        Objects.requireNonNull(publishLimitsHistoryViewModel);
        if (loadingState instanceof LoadingState.Loaded) {
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState;
            String title = ((AdvertsHistory) loaded.getData()).getTitle();
            String description = ((AdvertsHistory) loaded.getData()).getDescription();
            List<AdvertsHistory.Tab> tabs = ((AdvertsHistory) loaded.getData()).getTabs();
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(tabs, 10));
            for (T t : tabs) {
                arrayList.add(new HistoryTabItem(t.getTitle(), t.getTitle(), t.getCount()));
            }
            return new LoadingState.Loaded(new State(title, description, arrayList));
        } else if ((loadingState instanceof LoadingState.Error) || (loadingState instanceof LoadingState.Loading)) {
            return loadingState;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void c() {
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.g.getAdvertsHistory(this.f).observeOn(this.h.mainThread()).subscribe(new a(this), b.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.getAdvertsHis…tory\", e) }\n            )");
        Disposables.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.publish_limits_info.history.tab.PublishAdvertsHistoryProvider
    @NotNull
    public List<Item> getAdvertsShortcut(@NotNull String str) {
        InfoItem infoItem;
        T t;
        Intrinsics.checkNotNullParameter(str, "shortcut");
        AdvertsHistory advertsHistory = this.d;
        if (advertsHistory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("history");
        }
        Iterator<T> it = advertsHistory.getTabs().iterator();
        while (true) {
            infoItem = null;
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (Intrinsics.areEqual(t.getTitle(), str)) {
                break;
            }
        }
        Intrinsics.checkNotNull(t);
        T t2 = t;
        List<AdvertHistoryInfo> items = t2.getItems();
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(items, 10));
        for (T t3 : items) {
            arrayList.add(new HistoryAdvertItem(this.i.generateKey(), t3.getTitle(), t3.getPrice(), t3.getHint(), t3.getImage(), t3.getAutoPublish()));
        }
        InfoItem infoItem2 = new InfoItem("extra_info", t2.getDescription(), t2.getExtra());
        if (!infoItem2.isEmpty()) {
            infoItem = infoItem2;
        }
        return CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) CollectionsKt__CollectionsKt.listOfNotNull(infoItem));
    }

    @NotNull
    public final ItemId getItemId() {
        return this.f;
    }

    @NotNull
    public final MutableLiveData<LoadingState<State>> getState() {
        return this.e;
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.c.clear();
    }

    public final void onRetryClicked() {
        c();
    }
}
