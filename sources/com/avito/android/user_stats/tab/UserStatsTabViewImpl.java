package com.avito.android.user_stats.tab;

import android.view.View;
import android.view.ViewStub;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.user_stats.R;
import com.avito.android.user_stats.tab.view.UserStatsTabDataView;
import com.avito.android.user_stats.tab.view.UserStatsTabDataViewImpl;
import com.avito.android.user_stats.tab.view.UserStatsTabEmptyView;
import com.avito.android.user_stats.tab.view.UserStatsTabEmptyViewImpl;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0012\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001e\u0010\u001c\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010\"\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001bR\"\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060#8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'RD\u0010-\u001a0\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00060\u0006 \u0019*\u0017\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00060\u0006\u0018\u00010)¢\u0006\u0002\b*0)¢\u0006\u0002\b*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00062"}, d2 = {"Lcom/avito/android/user_stats/tab/UserStatsTabViewImpl;", "Lcom/avito/android/user_stats/tab/UserStatsTabView;", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "", "showStats", "(Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "", "title", "description", "buttonText", "showEmptyScreen", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "", "Lcom/avito/conveyor_item/Item;", "items", "updateItems", "(Ljava/util/List;)V", "Lcom/avito/android/user_stats/tab/view/UserStatsTabDataView;", "d", "Lcom/avito/android/user_stats/tab/view/UserStatsTabDataView;", "userStatsTabDataView", "Landroid/view/ViewStub;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/view/ViewStub;", "emptyViewStub", "Lcom/avito/android/user_stats/tab/view/UserStatsTabEmptyView;", "c", "Lcom/avito/android/user_stats/tab/view/UserStatsTabEmptyView;", "userStatsTabEmptyView", AuthSource.BOOKING_ORDER, "dataViewStub", "Lio/reactivex/rxjava3/core/Observable;", "f", "Lio/reactivex/rxjava3/core/Observable;", "getEmptyScreenActionButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "emptyScreenActionButtonClicks", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lio/reactivex/rxjava3/annotations/NonNull;", "e", "Lcom/jakewharton/rxrelay3/PublishRelay;", "emptyActionClickRelay", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class UserStatsTabViewImpl implements UserStatsTabView {
    public final ViewStub a;
    public final ViewStub b;
    public UserStatsTabEmptyView c;
    public UserStatsTabDataView d;
    public final PublishRelay<Unit> e;
    @NotNull
    public final Observable<Unit> f;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ UserStatsTabViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(UserStatsTabViewImpl userStatsTabViewImpl) {
            super(0);
            this.a = userStatsTabViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            PublishRelay publishRelay = this.a.e;
            Unit unit = Unit.INSTANCE;
            publishRelay.accept(unit);
            return unit;
        }
    }

    public UserStatsTabViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = (ViewStub) view.findViewById(R.id.empty);
        this.b = (ViewStub) view.findViewById(R.id.data);
        PublishRelay<Unit> create = PublishRelay.create();
        this.e = create;
        Intrinsics.checkNotNullExpressionValue(create, "emptyActionClickRelay");
        this.f = create;
    }

    @Override // com.avito.android.user_stats.tab.UserStatsTabView
    @NotNull
    public Observable<Unit> getEmptyScreenActionButtonClicks() {
        return this.f;
    }

    @Override // com.avito.android.user_stats.tab.UserStatsTabView
    public void showEmptyScreen(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        a2.b.a.a.a.Z0(str, "title", str2, "description", str3, "buttonText");
        if (this.c == null) {
            View inflate = this.a.inflate();
            Intrinsics.checkNotNullExpressionValue(inflate, "emptyViewStub.inflate()");
            this.c = new UserStatsTabEmptyViewImpl(inflate, str, str2, str3, new a(this));
        }
    }

    @Override // com.avito.android.user_stats.tab.UserStatsTabView
    public void showStats(@NotNull SimpleRecyclerAdapter simpleRecyclerAdapter, @NotNull AdapterPresenter adapterPresenter) {
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        if (this.d == null) {
            View inflate = this.b.inflate();
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
            this.d = new UserStatsTabDataViewImpl((RecyclerView) inflate, simpleRecyclerAdapter, adapterPresenter);
        }
    }

    @Override // com.avito.android.user_stats.tab.view.UserStatsTabDataView
    public void updateItems(@NotNull List<? extends Item> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        UserStatsTabDataView userStatsTabDataView = this.d;
        if (userStatsTabDataView != null) {
            userStatsTabDataView.updateItems(list);
        }
    }
}
