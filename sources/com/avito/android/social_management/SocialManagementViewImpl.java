package com.avito.android.social_management;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.appbar.AppBar;
import ru.avito.component.appbar.AppBarImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010*\u001a\u00020 \u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\rJ\u000f\u0010\u0013\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\rR\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010\"¨\u0006/"}, d2 = {"Lcom/avito/android/social_management/SocialManagementViewImpl;", "Lcom/avito/android/social_management/SocialManagementView;", "Lio/reactivex/Observable;", "", "navigationClicks", "()Lio/reactivex/Observable;", "retryClicks", "", "message", "showError", "(Ljava/lang/String;)V", "showMessage", "notifyItemsChanged", "()V", "", VKApiConst.POSITION, "notifyItemRemoved", "(I)V", "hideProgress", "showProgress", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lru/avito/component/appbar/AppBar;", AuthSource.BOOKING_ORDER, "Lru/avito/component/appbar/AppBar;", "appBar", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "c", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroid/view/View;", "e", "Landroid/view/View;", "contentView", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "f", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "d", "progressView", "view", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;Lcom/avito/android/analytics/Analytics;)V", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
public final class SocialManagementViewImpl implements SocialManagementView {
    public final RecyclerView a;
    public final AppBar b;
    public ProgressOverlay c;
    public final View d;
    public final View e;
    public final SimpleRecyclerAdapter f;

    public SocialManagementViewImpl(@NotNull View view, @NotNull SimpleRecyclerAdapter simpleRecyclerAdapter, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(simpleRecyclerAdapter, "adapter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.f = simpleRecyclerAdapter;
        int i = R.id.recycler;
        View findViewById = view.findViewById(i);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.a = recyclerView;
        AppBarImpl appBarImpl = new AppBarImpl(view, recyclerView, false, 4, null);
        appBarImpl.setTitle(R.string.social_networks);
        AppBar.DefaultImpls.setNavigationIcon$default(appBarImpl, R.drawable.ic_close_24_blue, null, 2, null);
        Unit unit = Unit.INSTANCE;
        this.b = appBarImpl;
        int i2 = R.id.content_container;
        View findViewById2 = view.findViewById(i2);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
        this.c = new ProgressOverlay((ViewGroup) findViewById2, i, analytics, false, 0, 24, null);
        View findViewById3 = view.findViewById(R.id.progress);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.d = findViewById3;
        View findViewById4 = view.findViewById(i2);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.e = findViewById4;
        recyclerView.setAdapter(simpleRecyclerAdapter);
        RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
        if (itemAnimator != null) {
            itemAnimator.setAddDuration(250);
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.addItemDecoration(new SocialNotificationDecoration());
    }

    @Override // com.avito.android.social_management.SocialManagementView
    public void hideProgress() {
        this.c.showContent();
        Views.hide(this.d);
    }

    @Override // com.avito.android.social_management.SocialManagementView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return InteropKt.toV2(this.b.navigationCallbacks());
    }

    @Override // com.avito.android.social_management.SocialManagementView
    public void notifyItemRemoved(int i) {
        this.f.notifyItemRemoved(i);
    }

    @Override // com.avito.android.social_management.SocialManagementView
    public void notifyItemsChanged() {
        this.f.notifyDataSetChanged();
    }

    @Override // com.avito.android.social_management.SocialManagementView
    @NotNull
    public Observable<Unit> retryClicks() {
        return this.c.refreshes();
    }

    @Override // com.avito.android.social_management.SocialManagementView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.c.showLoadingProblem(str);
    }

    @Override // com.avito.android.social_management.SocialManagementView
    public void showMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.e, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.social_management.SocialManagementView
    public void showProgress() {
        this.c.showContent();
        Views.show(this.d);
    }
}
