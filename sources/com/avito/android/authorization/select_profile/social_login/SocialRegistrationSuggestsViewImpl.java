package com.avito.android.authorization.select_profile.social_login;

import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.authorization.R;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.PaddingListDecoration;
import com.avito.android.ui.VerticalListItemDecoration;
import com.avito.android.util.Toolbars;
import com.avito.android.util.Views;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00107\u001a\u000206¢\u0006\u0004\b8\u00109J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u001d\u0010\u0010\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010+\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102¨\u0006:"}, d2 = {"Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsViewImpl;", "Lcom/avito/android/authorization/select_profile/social_login/SocialRegistrationSuggestsView;", "", "title", "", "showScreenTitle", "(Ljava/lang/String;)V", "onDataChanged", "()V", "showProgress", "hideProgress", "message", "showError", "", "", "indexes", "setDividers", "(Ljava/lang/Iterable;)V", "Lio/reactivex/rxjava3/core/Observable;", g.a, "Lio/reactivex/rxjava3/core/Observable;", "getNavigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "navigationClicks", "Landroid/view/ViewGroup;", "h", "Landroid/view/ViewGroup;", "rootView", "Landroid/view/View;", "d", "Landroid/view/View;", "progressView", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "e", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "f", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemDecoration", "Landroidx/appcompat/widget/Toolbar;", "c", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Landroid/view/ViewGroup;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class SocialRegistrationSuggestsViewImpl implements SocialRegistrationSuggestsView {
    public final Context a;
    public final RecyclerView b;
    public final Toolbar c;
    public final View d;
    public final SimpleRecyclerAdapter e;
    public RecyclerView.ItemDecoration f;
    @NotNull
    public final Observable<Unit> g;
    public final ViewGroup h;

    public SocialRegistrationSuggestsViewImpl(@NotNull ViewGroup viewGroup, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        this.h = viewGroup;
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        this.a = context;
        View findViewById = viewGroup.findViewById(R.id.recycler);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.b = recyclerView;
        View findViewById2 = viewGroup.findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.toolbar)");
        Toolbar toolbar = (Toolbar) findViewById2;
        this.c = toolbar;
        View findViewById3 = viewGroup.findViewById(R.id.progress);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.progress)");
        this.d = findViewById3;
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(adapterPresenter, itemBinder);
        this.e = simpleRecyclerAdapter;
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_close_24);
        recyclerView.setItemAnimator(null);
        recyclerView.addItemDecoration(new PaddingListDecoration(context.getResources().getDimensionPixelSize(com.avito.android.ui_components.R.dimen.list_top_padding)));
        recyclerView.setAdapter(simpleRecyclerAdapter);
        this.g = Toolbars.upClicks(toolbar);
    }

    @Override // com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsView
    @NotNull
    public Observable<Unit> getNavigationClicks() {
        return this.g;
    }

    @Override // com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsView
    public void hideProgress() {
        Views.hide(this.d);
    }

    @Override // com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsView
    public void onDataChanged() {
        this.e.notifyDataSetChanged();
    }

    @Override // com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsView
    public void setDividers(@NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "indexes");
        RecyclerView.ItemDecoration itemDecoration = this.f;
        if (itemDecoration != null) {
            this.b.removeItemDecoration(itemDecoration);
        }
        int dimensionPixelSize = this.a.getResources().getDimensionPixelSize(com.avito.android.ui_components.R.dimen.content_horizontal_padding);
        Drawable drawable = this.a.getDrawable(com.avito.android.ui_components.R.drawable.black_12_divider);
        VerticalListItemDecoration.Builder drawForLastItem = new VerticalListItemDecoration.Builder(null, 1, null).setPadding(dimensionPixelSize, dimensionPixelSize).drawForLastItem(false);
        for (Integer num : iterable) {
            drawForLastItem.setDividerForItemAt(num.intValue(), drawable);
        }
        VerticalListItemDecoration build = drawForLastItem.build();
        this.b.addItemDecoration(build);
        Unit unit = Unit.INSTANCE;
        this.f = build;
    }

    @Override // com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        SnackbarExtensionsKt.showSnackbar$default(this.h, str, 0, (String) null, 0, (Function0) null, 0, (SnackbarPosition) null, (SnackbarType) null, 254, (Object) null);
    }

    @Override // com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsView
    public void showProgress() {
        Views.show(this.d);
    }

    @Override // com.avito.android.authorization.select_profile.social_login.SocialRegistrationSuggestsView
    public void showScreenTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.c.setTitle(str);
    }
}
