package com.avito.android.authorization.select_social;

import a2.a.a.b.j.b;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.authorization.R;
import com.avito.android.lib.design.dialog.Dialog;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui.PaddingListDecoration;
import com.avito.android.util.ToastsKt;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.appbar.AppBar;
import ru.avito.component.appbar.AppBarImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u001b\u001a\u00020\u0012\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ#\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\r\u0010\tJ\u000f\u0010\u000e\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006*"}, d2 = {"Lcom/avito/android/authorization/select_social/SelectSocialViewImpl;", "Lcom/avito/android/authorization/select_social/SelectSocialView;", "Lio/reactivex/Observable;", "", "navigationClicks", "()Lio/reactivex/Observable;", "", "message", "showError", "(Ljava/lang/String;)V", "title", "showErrorDialog", "(Ljava/lang/String;Ljava/lang/String;)V", "showToast", "showProgress", "()V", "hideProgress", "notifyItemsChanged", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "loader", "Landroidx/recyclerview/widget/RecyclerView;", AuthSource.BOOKING_ORDER, "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "e", "view", "Lru/avito/component/appbar/AppBar;", "c", "Lru/avito/component/appbar/AppBar;", "appBar", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "d", "Lcom/avito/konveyor/adapter/SimpleRecyclerAdapter;", "adapter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "<init>", "(Landroid/view/View;Lcom/avito/konveyor/adapter/AdapterPresenter;Lcom/avito/konveyor/ItemBinder;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class SelectSocialViewImpl implements SelectSocialView {
    public final View a;
    public final RecyclerView b;
    public final AppBar c;
    public final SimpleRecyclerAdapter d;
    public final View e;

    public static final class a extends Lambda implements Function2<Dialog.Config, DialogInterface, Unit> {
        public final /* synthetic */ SelectSocialViewImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SelectSocialViewImpl selectSocialViewImpl, String str, String str2) {
            super(2);
            this.a = selectSocialViewImpl;
            this.b = str;
            this.c = str2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Dialog.Config config, DialogInterface dialogInterface) {
            Dialog.Config config2 = config;
            DialogInterface dialogInterface2 = dialogInterface;
            Intrinsics.checkNotNullParameter(config2, "$receiver");
            Intrinsics.checkNotNullParameter(dialogInterface2, "it");
            config2.setTitle(this.b);
            config2.setSubtitle(this.c);
            String string = this.a.e.getResources().getString(R.string.social_auth_error_dialog_btn);
            Intrinsics.checkNotNullExpressionValue(string, "view.resources.getString…al_auth_error_dialog_btn)");
            config2.addDefaultButton(string, new b(dialogInterface2));
            config2.setCancelable(true);
            return Unit.INSTANCE;
        }
    }

    public SelectSocialViewImpl(@NotNull View view, @NotNull AdapterPresenter adapterPresenter, @NotNull ItemBinder itemBinder) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(adapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(itemBinder, "itemBinder");
        this.e = view;
        View findViewById = view.findViewById(R.id.progress);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
        View findViewById2 = view.findViewById(R.id.recycler);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.b = recyclerView;
        AppBarImpl appBarImpl = new AppBarImpl(view, recyclerView, false, 4, null);
        this.c = appBarImpl;
        SimpleRecyclerAdapter simpleRecyclerAdapter = new SimpleRecyclerAdapter(adapterPresenter, itemBinder);
        this.d = simpleRecyclerAdapter;
        simpleRecyclerAdapter.setHasStableIds(true);
        recyclerView.setAdapter(simpleRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.setItemAnimator(null);
        recyclerView.addItemDecoration(new PaddingListDecoration(a2.b.a.a.a.u1(view, "view.context").getDimensionPixelSize(com.avito.android.ui_components.R.dimen.list_top_padding)));
        appBarImpl.setTitle(R.string.login_title);
    }

    @Override // com.avito.android.authorization.select_social.SelectSocialView
    public void hideProgress() {
        Views.hide(this.a);
    }

    @Override // com.avito.android.authorization.select_social.SelectSocialView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return InteropKt.toV2(this.c.navigationCallbacks());
    }

    @Override // com.avito.android.authorization.select_social.SelectSocialView
    public void notifyItemsChanged() {
        this.d.notifyDataSetChanged();
    }

    @Override // com.avito.android.authorization.select_social.SelectSocialView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        SnackbarExtensionsKt.showSnackbar$default(this.e, str, 0, (String) null, 0, (Function0) null, 0, (SnackbarPosition) null, (SnackbarType) null, 254, (Object) null);
    }

    @Override // com.avito.android.authorization.select_social.SelectSocialView
    public void showErrorDialog(@Nullable String str, @Nullable String str2) {
        Dialog.Companion companion = Dialog.Companion;
        Context context = this.e.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        Dialog.Companion.create$default(companion, context, 0, 0, new a(this, str, str2), 6, null).show();
    }

    @Override // com.avito.android.authorization.select_social.SelectSocialView
    public void showProgress() {
        Views.show(this.a);
    }

    @Override // com.avito.android.authorization.select_social.SelectSocialView
    public void showToast(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Context context = this.e.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        ToastsKt.showToast(context, str, 1);
    }
}
