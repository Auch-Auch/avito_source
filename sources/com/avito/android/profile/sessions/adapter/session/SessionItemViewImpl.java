package com.avito.android.profile.sessions.adapter.session;

import android.view.View;
import android.widget.TextView;
import com.avito.android.profile.R;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding4.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010'\u001a\u00020\u0014¢\u0006\u0004\b(\u0010)J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0010\u001a\u00020\u00052\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\"\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010\u001a¨\u0006*"}, d2 = {"Lcom/avito/android/profile/sessions/adapter/session/SessionItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/profile/sessions/adapter/session/SessionItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "description", "setDescription", "", "isVisible", "setMoreButtonVisibility", "(Z)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "Landroid/view/View;", "u", "Landroid/view/View;", "buttonMore", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "subtitleView", VKApiConst.VERSION, "Lkotlin/jvm/functions/Function0;", "unbindListener", "Lio/reactivex/rxjava3/core/Observable;", "w", "Lio/reactivex/rxjava3/core/Observable;", "getMoreButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "moreButtonClicks", "s", "titleView", "view", "<init>", "(Landroid/view/View;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SessionItemViewImpl extends BaseViewHolder implements SessionItemView {
    public final TextView s;
    public final TextView t;
    public final View u;
    public Function0<Unit> v;
    @NotNull
    public final Observable<Unit> w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SessionItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.btn_more);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.u = findViewById3;
        this.w = RxView.clicks(findViewById3);
    }

    @Override // com.avito.android.profile.sessions.adapter.session.SessionItemView
    @NotNull
    public Observable<Unit> getMoreButtonClicks() {
        return this.w;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.v;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.profile.sessions.adapter.session.SessionItemView
    public void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        TextViews.bindText$default(this.t, str, false, 2, null);
    }

    @Override // com.avito.android.profile.sessions.adapter.session.SessionItemView
    public void setMoreButtonVisibility(boolean z) {
        Views.setVisible(this.u, z);
    }

    @Override // com.avito.android.profile.sessions.adapter.session.SessionItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        TextViews.bindText$default(this.s, str, false, 2, null);
    }

    @Override // com.avito.android.profile.sessions.adapter.session.SessionItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.v = function0;
    }
}
