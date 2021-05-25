package com.avito.android.search.subscriptions.adapter;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.subscriptions.adapter.SearchSubscriptionItemPresenter;
import com.avito.android.util.Formatter;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\b\u0007\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItemPresenterImpl;", "Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItemPresenter;", "Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItemView;", "view", "Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItemView;Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItem;I)V", "Lcom/avito/android/util/Formatter;", "", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/Formatter;", "formatter", "Ldagger/Lazy;", "Lcom/avito/android/search/subscriptions/adapter/SearchSubscriptionItemPresenter$Listener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ldagger/Lazy;Lcom/avito/android/util/Formatter;)V", "subscriptions_release"}, k = 1, mv = {1, 4, 2})
public final class SearchSubscriptionItemPresenterImpl implements SearchSubscriptionItemPresenter {
    public final Lazy<SearchSubscriptionItemPresenter.Listener> a;
    public final Formatter<Long> b;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((SearchSubscriptionItemPresenter.Listener) ((SearchSubscriptionItemPresenterImpl) this.b).a.get()).onRemoveSubscriptionClicked((SearchSubscriptionItem) this.c);
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((SearchSubscriptionItemPresenter.Listener) ((SearchSubscriptionItemPresenterImpl) this.b).a.get()).onMoreActionClicked((SearchSubscriptionItem) this.c);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SearchSubscriptionItemPresenterImpl a;
        public final /* synthetic */ SearchSubscriptionItem b;
        public final /* synthetic */ SearchSubscriptionItemView c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(SearchSubscriptionItemPresenterImpl searchSubscriptionItemPresenterImpl, SearchSubscriptionItem searchSubscriptionItem, SearchSubscriptionItemView searchSubscriptionItemView) {
            super(0);
            this.a = searchSubscriptionItemPresenterImpl;
            this.b = searchSubscriptionItem;
            this.c = searchSubscriptionItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.b.resetCount();
            SearchSubscriptionItemPresenterImpl.access$resetView(this.a, this.c);
            ((SearchSubscriptionItemPresenter.Listener) this.a.a.get()).onSubscriptionClicked(this.b);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public SearchSubscriptionItemPresenterImpl(@NotNull Lazy<SearchSubscriptionItemPresenter.Listener> lazy, @NotNull Formatter<Long> formatter) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(formatter, "formatter");
        this.a = lazy;
        this.b = formatter;
    }

    public static final void access$resetView(SearchSubscriptionItemPresenterImpl searchSubscriptionItemPresenterImpl, SearchSubscriptionItemView searchSubscriptionItemView) {
        Objects.requireNonNull(searchSubscriptionItemPresenterImpl);
        searchSubscriptionItemView.setTitleInBold(false);
        searchSubscriptionItemView.showUpdatesIndicator(false);
    }

    public void bindView(@NotNull SearchSubscriptionItemView searchSubscriptionItemView, @NotNull SearchSubscriptionItem searchSubscriptionItem, int i) {
        Intrinsics.checkNotNullParameter(searchSubscriptionItemView, "view");
        Intrinsics.checkNotNullParameter(searchSubscriptionItem, "item");
        searchSubscriptionItemView.setTitle(searchSubscriptionItem.getTitle());
        searchSubscriptionItemView.setDescription(searchSubscriptionItem.getDescription());
        if (searchSubscriptionItem.getCount() > 0) {
            searchSubscriptionItemView.setTitleInBold(true);
            searchSubscriptionItemView.showUpdatesIndicator(true);
        } else {
            searchSubscriptionItemView.setTitleInBold(false);
            searchSubscriptionItemView.showUpdatesIndicator(false);
        }
        if (searchSubscriptionItem.getLastUpdateTime() > 0) {
            searchSubscriptionItemView.setDate(this.b.format(Long.valueOf(searchSubscriptionItem.getLastUpdateTime())));
        } else {
            searchSubscriptionItemView.setDate(null);
        }
        searchSubscriptionItemView.setOnItemClickListener(new b(this, searchSubscriptionItem, searchSubscriptionItemView));
        searchSubscriptionItemView.setOnRemoveClickListener(new a(0, this, searchSubscriptionItem));
        searchSubscriptionItemView.setOnMoreClickListener(new a(1, this, searchSubscriptionItem));
    }
}
