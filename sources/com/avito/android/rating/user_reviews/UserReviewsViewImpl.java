package com.avito.android.rating.user_reviews;

import a2.g.r.g;
import android.app.Dialog;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.rating.R;
import com.avito.android.rating.details.adapter.UserProfileCommentDecoration;
import com.avito.android.rating.user_reviews.UserReviewsView;
import com.avito.android.recycler.responsive.ResponsiveAdapterPresenter;
import com.avito.android.recycler.responsive.ResponsiveRecyclerAdapter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.DialogRouter;
import com.avito.android.util.Toolbars;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010/\u001a\u00020,\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u0010'\u001a\u00020$¢\u0006\u0004\b8\u00109J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0007J\u000f\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0007J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0007J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0013\u0010\u000bJ\u001f\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0007R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u0006:"}, d2 = {"Lcom/avito/android/rating/user_reviews/UserReviewsViewImpl;", "Lcom/avito/android/rating/user_reviews/UserReviewsView;", "Lio/reactivex/rxjava3/core/Observable;", "", "navigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "notifyItemsChanged", "()V", "", VKApiConst.POSITION, "notifyItemRemoved", "(I)V", "", "message", "showSnackbar", "(Ljava/lang/String;)V", "showReviewDeletedMessage", "showToolbar", "updateItems", "scrollToPosition", "title", "showUserDialog", "(Ljava/lang/String;Ljava/lang/String;)V", "closeUserDialog", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroid/app/Dialog;", "d", "Landroid/app/Dialog;", "userDialog", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "toolbarTitle", "Lcom/avito/android/util/DialogRouter;", g.a, "Lcom/avito/android/util/DialogRouter;", "dialogRouter", "Lcom/avito/android/recycler/responsive/ResponsiveRecyclerAdapter;", "e", "Lcom/avito/android/recycler/responsive/ResponsiveRecyclerAdapter;", "adapter", "Landroid/view/View;", "f", "Landroid/view/View;", "view", "Landroidx/appcompat/widget/Toolbar;", AuthSource.BOOKING_ORDER, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Landroid/view/View;Lcom/avito/android/recycler/responsive/ResponsiveAdapterPresenter;Lcom/avito/konveyor/ItemBinder;Lcom/avito/android/util/DialogRouter;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class UserReviewsViewImpl implements UserReviewsView {
    public final RecyclerView a;
    public final Toolbar b;
    public final TextView c;
    public Dialog d;
    public final ResponsiveRecyclerAdapter e;
    public final View f;
    public final DialogRouter g;

    public UserReviewsViewImpl(@NotNull View view, @NotNull ResponsiveAdapterPresenter responsiveAdapterPresenter, @NotNull ItemBinder itemBinder, @NotNull DialogRouter dialogRouter) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(responsiveAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(dialogRouter, "dialogRouter");
        this.f = view;
        this.g = dialogRouter;
        View findViewById = view.findViewById(R.id.recycler);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.a = recyclerView;
        View findViewById2 = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById2;
        this.b = toolbar;
        View findViewById3 = view.findViewById(R.id.toolbar_title);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById3;
        this.c = textView;
        ResponsiveRecyclerAdapter responsiveRecyclerAdapter = new ResponsiveRecyclerAdapter(responsiveAdapterPresenter, itemBinder);
        this.e = responsiveRecyclerAdapter;
        textView.setText(R.string.user_reviews);
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24_black);
        recyclerView.setAdapter(responsiveRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.addItemDecoration(new UserProfileCommentDecoration(view.getResources().getDimensionPixelOffset(R.dimen.rating_details_comment_item_top), view.getResources().getDimensionPixelOffset(R.dimen.rating_details_comment_item_bottom), view.getResources().getDimensionPixelOffset(R.dimen.rating_details_comment_item_first_offset), view.getResources().getDimensionPixelOffset(R.dimen.rating_details_comment_item_last_offset)));
    }

    @Override // com.avito.android.rating.user_reviews.UserReviewsView
    public void closeUserDialog() {
        Dialog dialog = this.d;
        if (dialog != null) {
            dialog.hide();
        }
    }

    @Override // com.avito.android.rating.user_reviews.UserReviewsView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return Toolbars.upClicks(this.b);
    }

    @Override // com.avito.android.rating.user_reviews.UserReviewsView
    public void notifyItemRemoved(int i) {
        this.e.notifyItemRemoved(i);
    }

    @Override // com.avito.android.rating.user_reviews.UserReviewsView
    public void notifyItemsChanged() {
        this.e.notifyDataSetChanged();
    }

    @Override // com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        UserReviewsView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.rating.user_reviews.UserReviewsView
    public void scrollToPosition(int i) {
        this.a.smoothScrollToPosition(i);
    }

    @Override // com.avito.android.rating.user_reviews.UserReviewsView
    public void showReviewDeletedMessage() {
        Views.showSnackBar$default(this.f, R.string.review_deleted, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.rating.user_reviews.UserReviewsView
    public void showSnackbar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.f, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.rating.user_reviews.UserReviewsView
    public void showToolbar() {
    }

    @Override // com.avito.android.rating.user_reviews.UserReviewsView
    public void showUserDialog(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "message");
        this.d = this.g.showSimpleNotifyingDialog(str, str2);
    }

    @Override // com.avito.android.rating.user_reviews.UserReviewsView
    public void updateItems() {
        this.e.notifyDataSetChanged();
    }
}
