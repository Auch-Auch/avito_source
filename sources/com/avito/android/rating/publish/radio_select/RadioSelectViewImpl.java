package com.avito.android.rating.publish.radio_select;

import a2.b.a.a.a;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.analytics.Analytics;
import com.avito.android.lib.design.button.Button;
import com.avito.android.progress_overlay.ProgressOverlay;
import com.avito.android.rating.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.PaddingListDecoration;
import com.avito.android.util.Toolbars;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import com.avito.konveyor.adapter.SimpleRecyclerAdapter;
import com.jakewharton.rxbinding4.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\u0006\u00103\u001a\u000202\u0012\u0006\u00105\u001a\u000204\u0012\u0006\u00107\u001a\u000206\u0012\u0006\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0018\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0018\u0010\rJ\u000f\u0010\u0019\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0019\u0010\rJ\u0017\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u001b\u0010\u0017J\u0017\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u000bR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u0006<"}, d2 = {"Lcom/avito/android/rating/publish/radio_select/RadioSelectViewImpl;", "Lcom/avito/android/rating/publish/radio_select/RadioSelectView;", "Lio/reactivex/rxjava3/core/Observable;", "", "navigationClicks", "()Lio/reactivex/rxjava3/core/Observable;", "retryClicks", "continueClicks", "", "message", "showError", "(Ljava/lang/String;)V", "showProgress", "()V", "hideProgress", "notifyItemsChanged", "", VKApiConst.POSITION, "notifyItemChanged", "(I)V", "", "isEnabled", "setButtonEnabled", "(Z)V", "showContinueButton", "showSendButton", "isLoading", "showLoadingState", "title", "setTitle", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "d", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lcom/avito/android/lib/design/button/Button;", "c", "Lcom/avito/android/lib/design/button/Button;", "continueButton", "Landroidx/appcompat/widget/Toolbar;", AuthSource.BOOKING_ORDER, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.SEND_ABUSE, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "e", "Lcom/avito/android/progress_overlay/ProgressOverlay;", "progressOverlay", "Landroid/view/View;", "view", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;Lcom/avito/android/analytics/Analytics;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class RadioSelectViewImpl implements RadioSelectView {
    public final RecyclerView a;
    public final Toolbar b;
    public final Button c;
    public final SimpleRecyclerAdapter d;
    public ProgressOverlay e;

    public RadioSelectViewImpl(@NotNull View view, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        int i = R.id.recycler;
        View findViewById = view.findViewById(i);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        this.a = recyclerView;
        View findViewById2 = view.findViewById(com.avito.android.deprecated_design.R.id.toolbar);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        this.b = (Toolbar) findViewById2;
        View findViewById3 = view.findViewById(R.id.continue_button);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById3;
        this.c = button;
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(adapterPresenter, itemBinder);
        this.d = simpleRecyclerAdapter;
        View findViewById4 = view.findViewById(R.id.content_container);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.ViewGroup");
        this.e = new ProgressOverlay((ViewGroup) findViewById4, i, analytics, false, 0, 24, null);
        recyclerView.setAdapter(simpleRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setItemAnimator(null);
        recyclerView.addItemDecoration(new PaddingListDecoration(a.u1(view, "view.context").getDimensionPixelSize(com.avito.android.ui_components.R.dimen.list_top_padding)));
        button.setText(R.string.continue_button_title);
    }

    @Override // com.avito.android.rating.publish.radio_select.RadioSelectView
    @NotNull
    public Observable<Unit> continueClicks() {
        return RxView.clicks(this.c);
    }

    @Override // com.avito.android.rating.publish.radio_select.RadioSelectView
    public void hideProgress() {
        this.e.showContent();
    }

    @Override // com.avito.android.rating.publish.radio_select.RadioSelectView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return Toolbars.upClicks(this.b);
    }

    @Override // com.avito.android.rating.publish.radio_select.RadioSelectView
    public void notifyItemChanged(int i) {
        this.d.notifyItemChanged(i);
    }

    @Override // com.avito.android.rating.publish.radio_select.RadioSelectView
    public void notifyItemsChanged() {
        this.d.notifyDataSetChanged();
    }

    @Override // com.avito.android.rating.publish.radio_select.RadioSelectView
    @NotNull
    public Observable<Unit> retryClicks() {
        return InteropKt.toV3(this.e.refreshes());
    }

    @Override // com.avito.android.rating.publish.radio_select.RadioSelectView
    public void setButtonEnabled(boolean z) {
        this.c.setEnabled(z);
    }

    @Override // com.avito.android.rating.publish.radio_select.RadioSelectView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.b.setTitle(str);
    }

    @Override // com.avito.android.rating.publish.radio_select.RadioSelectView
    public void showContinueButton() {
        this.c.setText(R.string.continue_button_title);
    }

    @Override // com.avito.android.rating.publish.radio_select.RadioSelectView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.e.showLoadingProblem(str);
    }

    @Override // com.avito.android.rating.publish.radio_select.RadioSelectView
    public void showLoadingState(boolean z) {
        this.c.setLoading(z);
        this.c.setClickable(!z);
    }

    @Override // com.avito.android.rating.publish.radio_select.RadioSelectView
    public void showProgress() {
        this.e.showLoading();
    }

    @Override // com.avito.android.rating.publish.radio_select.RadioSelectView
    public void showSendButton() {
        this.c.setText(R.string.send_button_title);
    }
}
