package com.avito.android.rating.details;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.rating.R;
import com.avito.android.rating.details.RatingDetailsView;
import com.avito.android.rating.details.adapter.UserProfileCommentDecoration;
import com.avito.android.rating.utils.FloatingViewsKt;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.recycler.responsive.ResponsiveRecyclerAdapter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.konveyor.ItemBinder;
import com.jakewharton.rxbinding4.view.RxView;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.toolbar.AppBarLayoutWithTextAction;
import ru.avito.component.toolbar.AppbarClickListener;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u00104\u001a\u000203\u0012\u0006\u00106\u001a\u000205¢\u0006\u0004\b7\u00108J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0018\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bRD\u0010\"\u001a0\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u00030\u0003 \u001e*\u0017\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u001d¢\u0006\u0002\b\u001f0\u001d¢\u0006\u0002\b\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)RD\u0010,\u001a0\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u00030\u0003 \u001e*\u0017\u0012\f\u0012\n \u001e*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u001d¢\u0006\u0002\b\u001f0\u001d¢\u0006\u0002\b\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010!R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00069"}, d2 = {"Lcom/avito/android/rating/details/RatingDetailsViewImpl;", "Lcom/avito/android/rating/details/RatingDetailsView;", "Lio/reactivex/rxjava3/core/Observable;", "", "commentClicks", "()Lio/reactivex/rxjava3/core/Observable;", "reviewRequestClicks", "closeEvents", "Lkotlin/Function0;", "", "canAppend", "floatingViewsStateChanges", "(Lkotlin/jvm/functions/Function0;)Lio/reactivex/rxjava3/core/Observable;", "", "text", "showCommentButton", "(Ljava/lang/String;)V", "showRequestReviewButton", "updateItems", "()V", "", VKApiConst.POSITION, "scrollToPosition", "(I)V", "notifyItemAtPositionChanged", "Landroid/widget/Button;", "c", "Landroid/widget/Button;", "commentButton", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "e", "Lcom/jakewharton/rxrelay3/PublishRelay;", "upButtonClicksRelay", "Lru/avito/component/toolbar/AppBarLayoutWithTextAction;", AuthSource.BOOKING_ORDER, "Lru/avito/component/toolbar/AppBarLayoutWithTextAction;", "appBar", "Lcom/avito/android/recycler/responsive/ResponsiveRecyclerAdapter;", "f", "Lcom/avito/android/recycler/responsive/ResponsiveRecyclerAdapter;", "adapter", "d", "reviewClicksRelay", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroid/view/View;", "view", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Landroid/view/View;Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;Lcom/avito/konveyor/ItemBinder;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RatingDetailsViewImpl implements RatingDetailsView {
    public final RecyclerView a;
    public final AppBarLayoutWithTextAction b;
    public final Button c;
    public final PublishRelay<Unit> d = PublishRelay.create();
    public final PublishRelay<Unit> e = PublishRelay.create();
    public final ResponsiveRecyclerAdapter f;

    public RatingDetailsViewImpl(@NotNull View view, @NotNull ResponsiveAdapterPresenter responsiveAdapterPresenter, @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(responsiveAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        View findViewById = view.findViewById(R.id.recycler);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.a = recyclerView;
        View findViewById2 = view.findViewById(R.id.app_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.app_bar)");
        AppBarLayoutWithTextAction appBarLayoutWithTextAction = (AppBarLayoutWithTextAction) findViewById2;
        this.b = appBarLayoutWithTextAction;
        View findViewById3 = view.findViewById(R.id.comment_button);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.Button");
        this.c = (Button) findViewById3;
        ResponsiveRecyclerAdapter responsiveRecyclerAdapter = new ResponsiveRecyclerAdapter(responsiveAdapterPresenter, itemBinder);
        this.f = responsiveRecyclerAdapter;
        responsiveRecyclerAdapter.setHasStableIds(true);
        recyclerView.setAdapter(responsiveRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new UserProfileCommentDecoration(view.getResources().getDimensionPixelOffset(R.dimen.rating_details_comment_item_top), view.getResources().getDimensionPixelOffset(R.dimen.rating_details_comment_item_bottom), 0, 0, 12, null));
        appBarLayoutWithTextAction.setHomeIcon(com.avito.android.ui_components.R.drawable.ic_back_24);
        appBarLayoutWithTextAction.setClickListener(new AppbarClickListener(this) { // from class: com.avito.android.rating.details.RatingDetailsViewImpl.1
            public final /* synthetic */ RatingDetailsViewImpl a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onActionClicked() {
                this.a.d.accept(Unit.INSTANCE);
            }

            @Override // ru.avito.component.toolbar.AppbarClickListener
            public void onHomeClicked() {
                this.a.e.accept(Unit.INSTANCE);
            }
        });
    }

    @Override // com.avito.android.rating.details.RatingDetailsView
    @NotNull
    public Observable<Unit> closeEvents() {
        PublishRelay<Unit> publishRelay = this.e;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "upButtonClicksRelay");
        return publishRelay;
    }

    @Override // com.avito.android.rating.details.RatingDetailsView
    @NotNull
    public Observable<Unit> commentClicks() {
        return RxView.clicks(this.c);
    }

    @Override // com.avito.android.rating.details.RatingDetailsView
    @NotNull
    public Observable<Boolean> floatingViewsStateChanges(@NotNull Function0<Boolean> function0) {
        Intrinsics.checkNotNullParameter(function0, "canAppend");
        Observable<Boolean> distinctUntilChanged = FloatingViewsKt.floatingViewsChanges(this.a, function0).startWith(Observable.just(Boolean.TRUE)).distinctUntilChanged();
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "recycler.floatingViewsCh…  .distinctUntilChanged()");
        return distinctUntilChanged;
    }

    @Override // com.avito.android.rating.details.RatingDetailsView
    public void notifyItemAtPositionChanged(int i) {
        this.f.notifyItemChanged(i);
    }

    @Override // com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        RatingDetailsView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.rating.details.RatingDetailsView
    @NotNull
    public Observable<Unit> reviewRequestClicks() {
        PublishRelay<Unit> publishRelay = this.d;
        Intrinsics.checkNotNullExpressionValue(publishRelay, "reviewClicksRelay");
        return publishRelay;
    }

    @Override // com.avito.android.rating.details.RatingDetailsView
    public void scrollToPosition(int i) {
        this.a.smoothScrollToPosition(i);
    }

    @Override // com.avito.android.rating.details.RatingDetailsView
    public void showCommentButton(@Nullable String str) {
        if (str != null) {
            this.c.setText(str);
        }
        Context context = this.c.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "commentButton.context");
        int displayHeight = Contexts.getDisplayHeight(context) - this.c.getTop();
        if (str != null) {
            displayHeight = 0;
        }
        this.c.animate().translationY((float) displayHeight).setDuration(300).start();
    }

    @Override // com.avito.android.rating.details.RatingDetailsView
    public void showRequestReviewButton(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.b.setAction(str);
    }

    @Override // com.avito.android.rating.details.RatingDetailsView
    public void updateItems() {
        this.f.notifyDataSetChanged();
    }
}
