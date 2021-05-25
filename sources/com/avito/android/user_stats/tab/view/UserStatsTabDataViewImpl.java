package com.avito.android.user_stats.tab.view;

import a2.b.a.a.a;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/avito/android/user_stats/tab/view/UserStatsTabDataViewImpl;", "Lcom/avito/android/user_stats/tab/view/UserStatsTabDataView;", "", "Lcom/avito/conveyor_item/Item;", "items", "", "updateItems", "(Ljava/util/List;)V", "Lcom/avito/konveyor/adapter/AdapterPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "<init>", "(Landroidx/recyclerview/widget/RecyclerView;Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "user-stats_release"}, k = 1, mv = {1, 4, 2})
public final class UserStatsTabDataViewImpl implements UserStatsTabDataView {
    public final AdapterPresenter a;

    public UserStatsTabDataViewImpl(@NotNull RecyclerView recyclerView, @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter, @NotNull AdapterPresenter adapterPresenter) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        this.a = adapterPresenter;
        recyclerView.setAdapter(simpleRecyclerAdapter);
    }

    @Override // com.avito.android.user_stats.tab.view.UserStatsTabDataView
    public void updateItems(@NotNull List<? extends Item> list) {
        Intrinsics.checkNotNullParameter(list, "items");
        a.s1(list, this.a);
    }
}
