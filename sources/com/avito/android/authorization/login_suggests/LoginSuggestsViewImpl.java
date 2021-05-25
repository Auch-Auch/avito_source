package com.avito.android.authorization.login_suggests;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.authorization.R;
import com.avito.android.component.bottom_sheet.BottomSheetView;
import com.avito.android.component.bottom_sheet.BottomSheetViewImpl;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.VerticalListItemDecoration;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import io.reactivex.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.appbar.AppBar;
import ru.avito.component.appbar.AppBarsKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001c\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010/\u001a\u00020.¢\u0006\u0004\b0\u00101J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0007J\u000f\u0010\r\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0007J\u001d\u0010\u0011\u001a\u00020\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001e\u0010#\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u00062"}, d2 = {"Lcom/avito/android/authorization/login_suggests/LoginSuggestsViewImpl;", "Lcom/avito/android/authorization/login_suggests/LoginSuggestsView;", "Lio/reactivex/Observable;", "", "navigationClicks", "()Lio/reactivex/Observable;", "notifyItemsChanged", "()V", "", "message", "showSnackbar", "(Ljava/lang/String;)V", "close", "open", "", "", "indexes", "setDividers", "(Ljava/lang/Iterable;)V", "Landroid/view/View;", "f", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "e", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemDecoration", "Lcom/avito/android/component/bottom_sheet/BottomSheetView;", "c", "Lcom/avito/android/component/bottom_sheet/BottomSheetView;", "bottomSheetView", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "d", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class LoginSuggestsViewImpl implements LoginSuggestsView {
    public final Context a;
    public final RecyclerView b;
    public final BottomSheetView c;
    public final SimpleRecyclerAdapter d;
    public RecyclerView.ItemDecoration e;
    public final View f;

    public LoginSuggestsViewImpl(@NotNull View view, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        this.f = view;
        this.a = view.getContext();
        View findViewById = view.findViewById(R.id.recycler);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.b = recyclerView;
        BottomSheetViewImpl bottomSheetViewImpl = new BottomSheetViewImpl(view, null, null, null, recyclerView, false, 46, null);
        this.c = bottomSheetViewImpl;
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(adapterPresenter, itemBinder);
        this.d = simpleRecyclerAdapter;
        simpleRecyclerAdapter.setHasStableIds(true);
        recyclerView.setAdapter(simpleRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        AppBar appBar = bottomSheetViewImpl.getAppBar();
        if (appBar != null) {
            appBar.setTitle(com.avito.android.ui_components.R.string.login);
        }
        AppBar appBar2 = bottomSheetViewImpl.getAppBar();
        if (appBar2 != null) {
            AppBarsKt.setCloseIcon(appBar2);
        }
    }

    @Override // com.avito.android.authorization.login_suggests.LoginSuggestsView
    public void close() {
        this.c.close();
    }

    @Override // com.avito.android.authorization.login_suggests.LoginSuggestsView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return InteropKt.toV2(this.c.closeEvents());
    }

    @Override // com.avito.android.authorization.login_suggests.LoginSuggestsView
    public void notifyItemsChanged() {
        this.d.notifyDataSetChanged();
    }

    @Override // com.avito.android.authorization.login_suggests.LoginSuggestsView
    public void open() {
        this.c.openFullscreen();
    }

    @Override // com.avito.android.authorization.login_suggests.LoginSuggestsView
    public void setDividers(@NotNull Iterable<Integer> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "indexes");
        RecyclerView.ItemDecoration itemDecoration = this.e;
        if (itemDecoration != null) {
            this.b.removeItemDecoration(itemDecoration);
        }
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(com.avito.android.ui_components.R.dimen.screen_component_horizontal_padding);
        Drawable drawable = this.a.getDrawable(com.avito.android.ui_components.R.drawable.black_12_divider);
        VerticalListItemDecoration.Builder drawForLastItem = new VerticalListItemDecoration.Builder(null, 1, null).setPadding(dimensionPixelSize, dimensionPixelSize).drawForLastItem(false);
        for (Integer num : iterable) {
            drawForLastItem.setDividerForItemAt(num.intValue(), drawable);
        }
        VerticalListItemDecoration build = drawForLastItem.build();
        this.b.addItemDecoration(build);
        Unit unit = Unit.INSTANCE;
        this.e = build;
    }

    @Override // com.avito.android.authorization.login_suggests.LoginSuggestsView
    public void showSnackbar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.f, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }
}
