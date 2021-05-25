package com.avito.android.authorization.login_protection;

import a2.g.r.g;
import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.authorization.R;
import com.avito.android.lib.design.input.Input;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.TextViews;
import com.avito.android.util.Toolbars;
import com.avito.android.util.Views;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010&\u001a\u00020#\u0012\n\u00108\u001a\u0006\u0012\u0002\b\u000307¢\u0006\u0004\b9\u0010:J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u0017\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u0017\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0004R\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\tR\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00105¨\u0006;"}, d2 = {"Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListViewImpl;", "Lcom/avito/android/authorization/login_protection/LoginProtectionPhoneListView;", "", "onDataChanged", "()V", "showSearchInput", "Lio/reactivex/rxjava3/core/Observable;", "", "getSearchTextChanges", "()Lio/reactivex/rxjava3/core/Observable;", "getSearchText", "()Ljava/lang/String;", "showProgress", "hideProgress", "message", "showSnackbar", "(Ljava/lang/String;)V", "showDescriptionForTfa", "showDescriptionForAntihack", "h", "Lio/reactivex/rxjava3/core/Observable;", "getNavigationClicks", "navigationClicks", "Landroidx/recyclerview/widget/RecyclerView;", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recycler", "Landroidx/appcompat/widget/Toolbar;", "d", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "description", "Landroid/view/ViewGroup;", "i", "Landroid/view/ViewGroup;", "rootView", "Lcom/avito/android/lib/design/input/Input;", g.a, "Lcom/avito/android/lib/design/input/Input;", "searchInput", "Landroid/view/ViewStub;", AuthSource.BOOKING_ORDER, "Landroid/view/ViewStub;", "stub", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Landroid/view/View;", "e", "Landroid/view/View;", "progress", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "<init>", "(Landroid/view/ViewGroup;Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class LoginProtectionPhoneListViewImpl implements LoginProtectionPhoneListView {
    public final Context a;
    public final ViewStub b;
    public final RecyclerView c;
    public final Toolbar d;
    public View e;
    public TextView f;
    public Input g;
    @NotNull
    public final Observable<Unit> h;
    public final ViewGroup i;

    public LoginProtectionPhoneListViewImpl(@NotNull ViewGroup viewGroup, @NotNull RecyclerView.Adapter<?> adapter) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        this.i = viewGroup;
        Context context = viewGroup.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        this.a = context;
        View findViewById = viewGroup.findViewById(R.id.search_stub);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewStub");
        this.b = (ViewStub) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.recycler_view);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.c = recyclerView;
        View findViewById3 = viewGroup.findViewById(R.id.toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.toolbar)");
        Toolbar toolbar = (Toolbar) findViewById3;
        this.d = toolbar;
        View findViewById4 = viewGroup.findViewById(R.id.progress);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.progress)");
        this.e = findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.description);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.description)");
        this.f = (TextView) findViewById5;
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_close_24);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(adapter);
        this.h = Toolbars.upClicks(toolbar);
    }

    @Override // com.avito.android.authorization.login_protection.LoginProtectionPhoneListView
    @NotNull
    public Observable<Unit> getNavigationClicks() {
        return this.h;
    }

    @Override // com.avito.android.authorization.login_protection.LoginProtectionPhoneListView
    @Nullable
    public String getSearchText() {
        Editable text;
        Input input = this.g;
        if (input == null || (text = input.m90getText()) == null) {
            return null;
        }
        return text.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [a2.a.a.b.e.e] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.avito.android.authorization.login_protection.LoginProtectionPhoneListView
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.rxjava3.core.Observable<java.lang.String> getSearchTextChanges() {
        /*
            r3 = this;
            com.avito.android.lib.design.input.Input r0 = r3.g
            if (r0 == 0) goto L_0x0027
            com.jakewharton.rxbinding3.InitialValueObservable r0 = com.avito.android.lib.design.input.InputExtensionsKt.textChanges(r0)
            if (r0 == 0) goto L_0x0027
            io.reactivex.Observable r0 = r0.skipInitialValue()
            if (r0 == 0) goto L_0x0027
            io.reactivex.rxjava3.core.Observable r0 = com.avito.android.util.rx3.InteropKt.toV3(r0)
            if (r0 == 0) goto L_0x0027
            com.avito.android.authorization.login_protection.LoginProtectionPhoneListViewImpl$a r1 = com.avito.android.authorization.login_protection.LoginProtectionPhoneListViewImpl.a.a
            if (r1 == 0) goto L_0x0020
            a2.a.a.b.e.e r2 = new a2.a.a.b.e.e
            r2.<init>(r1)
            r1 = r2
        L_0x0020:
            io.reactivex.rxjava3.functions.Function r1 = (io.reactivex.rxjava3.functions.Function) r1
            io.reactivex.rxjava3.core.Observable r0 = r0.map(r1)
            goto L_0x0028
        L_0x0027:
            r0 = 0
        L_0x0028:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.authorization.login_protection.LoginProtectionPhoneListViewImpl.getSearchTextChanges():io.reactivex.rxjava3.core.Observable");
    }

    @Override // com.avito.android.authorization.login_protection.LoginProtectionPhoneListView
    public void hideProgress() {
        Views.hide(this.e);
    }

    @Override // com.avito.android.authorization.login_protection.LoginProtectionPhoneListView
    public void onDataChanged() {
        RecyclerView.Adapter adapter = this.c.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    @Override // com.avito.android.authorization.login_protection.LoginProtectionPhoneListView
    public void showDescriptionForAntihack() {
        TextViews.bindText$default(this.f, this.a.getString(R.string.antihack_phone_list_description), false, 2, null);
    }

    @Override // com.avito.android.authorization.login_protection.LoginProtectionPhoneListView
    public void showDescriptionForTfa() {
        TextViews.bindText$default(this.f, this.a.getString(R.string.tfa_phone_list_description), false, 2, null);
    }

    @Override // com.avito.android.authorization.login_protection.LoginProtectionPhoneListView
    public void showProgress() {
        Views.show(this.e);
    }

    @Override // com.avito.android.authorization.login_protection.LoginProtectionPhoneListView
    public void showSearchInput() {
        View inflate = this.b.inflate();
        if (!(inflate instanceof Input)) {
            inflate = null;
        }
        this.g = (Input) inflate;
    }

    @Override // com.avito.android.authorization.login_protection.LoginProtectionPhoneListView
    public void showSnackbar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        SnackbarExtensionsKt.showSnackbar$default(this.i, str, 0, (String) null, 0, (Function0) null, 0, (SnackbarPosition) null, (SnackbarType) null, 254, (Object) null);
    }
}
