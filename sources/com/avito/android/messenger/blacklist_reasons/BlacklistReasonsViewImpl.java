package com.avito.android.messenger.blacklist_reasons;

import a2.g.r.g;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.transition.Fade;
import androidx.transition.TransitionManager;
import com.avito.android.lib.design.spinner.Spinner;
import com.avito.android.messenger.R;
import com.avito.android.messenger.blacklist_reasons.BlacklistReasonsView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.TransitionDsl;
import com.avito.android.util.Views;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.api.entity.BlacklistReasons;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b9\u0010:J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000e\u0010\bJ#\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\bR\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010 R\"\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00040\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u001dR\u0016\u0010'\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010&R\"\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040\u00188\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010\u001b\u001a\u0004\b)\u0010\u001dR\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00101\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u00100R\u001e\u00105\u001a\n 3*\u0004\u0018\u000102028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u00104R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u00107¨\u0006;"}, d2 = {"Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsViewImpl;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView;", "Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State;", "state", "", "render", "(Lcom/avito/android/messenger/blacklist_reasons/BlacklistReasonsView$State;)V", "destroyView", "()V", AuthSource.BOOKING_ORDER, "Lru/avito/messenger/api/entity/BlacklistReasons;", "reasons", "c", "(Lru/avito/messenger/api/entity/BlacklistReasons;)V", "d", "", "message", "e", "(Ljava/lang/String;Lru/avito/messenger/api/entity/BlacklistReasons;)V", AuthSource.SEND_ABUSE, "Landroid/view/ViewGroup;", "j", "Landroid/view/ViewGroup;", "rootView", "Lcom/jakewharton/rxrelay2/Relay;", "", "i", "Lcom/jakewharton/rxrelay2/Relay;", "getReasonSelections", "()Lcom/jakewharton/rxrelay2/Relay;", "reasonSelections", "Lcom/avito/android/lib/design/spinner/Spinner;", "Lcom/avito/android/lib/design/spinner/Spinner;", "progressView", g.a, "getBackNavigationClicks", "backNavigationClicks", "Landroidx/core/widget/NestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "contentScrollView", "h", "getRetryClicks", "retryClicks", "Ljava/lang/Runnable;", "f", "Ljava/lang/Runnable;", "showProgressRunnable", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "contentContainer", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "Landroid/view/LayoutInflater;", "inflater", "Landroidx/appcompat/widget/Toolbar;", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "<init>", "(Landroid/view/ViewGroup;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class BlacklistReasonsViewImpl implements BlacklistReasonsView {
    public final Toolbar a;
    public final NestedScrollView b;
    public final Spinner c;
    public final LinearLayout d;
    public final LayoutInflater e;
    public final Runnable f = new c(this);
    @NotNull
    public final Relay<Unit> g;
    @NotNull
    public final Relay<Unit> h;
    @NotNull
    public final Relay<Long> i;
    public final ViewGroup j;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ BlacklistReasonsViewImpl a;

        public a(BlacklistReasonsViewImpl blacklistReasonsViewImpl) {
            this.a = blacklistReasonsViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.getBackNavigationClicks().accept(Unit.INSTANCE);
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ BlacklistReasonsViewImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(BlacklistReasonsViewImpl blacklistReasonsViewImpl) {
            super(0);
            this.a = blacklistReasonsViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Relay<Unit> retryClicks = this.a.getRetryClicks();
            Unit unit = Unit.INSTANCE;
            retryClicks.accept(unit);
            return unit;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ BlacklistReasonsViewImpl a;

        public c(BlacklistReasonsViewImpl blacklistReasonsViewImpl) {
            this.a = blacklistReasonsViewImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            BlacklistReasonsViewImpl.access$showProgress(this.a);
        }
    }

    public BlacklistReasonsViewImpl(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "rootView");
        this.j = viewGroup;
        View findViewById = viewGroup.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById;
        this.a = toolbar;
        View findViewById2 = viewGroup.findViewById(R.id.blacklist_reasons_content_scroll);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type androidx.core.widget.NestedScrollView");
        this.b = (NestedScrollView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.blacklist_reasons_progress);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.lib.design.spinner.Spinner");
        this.c = (Spinner) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.blacklist_reasons_content);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.d = (LinearLayout) findViewById4;
        this.e = LayoutInflater.from(viewGroup.getContext());
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.g = create;
        PublishRelay create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.h = create2;
        PublishRelay create3 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create3, "PublishRelay.create()");
        this.i = create3;
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_back_24);
        toolbar.setNavigationOnClickListener(new a(this));
    }

    public static final void access$showProgress(BlacklistReasonsViewImpl blacklistReasonsViewImpl) {
        blacklistReasonsViewImpl.a();
        Views.conceal(blacklistReasonsViewImpl.b);
        Views.show(blacklistReasonsViewImpl.c);
    }

    public final void a() {
        ViewGroup viewGroup = this.j;
        TransitionDsl transitionDsl = new TransitionDsl(new Fade());
        transitionDsl.addTarget(R.id.blacklist_reasons_content_scroll);
        transitionDsl.addTarget(R.id.blacklist_reasons_progress);
        TransitionManager.beginDelayedTransition(viewGroup, transitionDsl.buildTransition());
    }

    public final void b() {
        this.j.removeCallbacks(this.f);
    }

    public final void c(BlacklistReasons blacklistReasons) {
        b();
        this.d.removeAllViews();
        a();
        View inflate = this.e.inflate(R.layout.messenger_blacklist_reasons_title, (ViewGroup) this.d, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "titleView");
        View findViewById = inflate.findViewById(R.id.messenger_blacklist_reasons_title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView) findViewById).setText(blacklistReasons.getTitle());
        this.d.addView(inflate, new LinearLayout.LayoutParams(-1, -2));
        for (T t : blacklistReasons.getReasons()) {
            View inflate2 = this.e.inflate(R.layout.messenger_blacklist_reasons_item, (ViewGroup) this.d, false);
            Intrinsics.checkNotNullExpressionValue(inflate2, "itemView");
            View findViewById2 = inflate2.findViewById(R.id.messenger_blacklist_reasons_item_text);
            Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById2).setText(t.getText());
            inflate2.setOnClickListener(new View.OnClickListener(this) { // from class: com.avito.android.messenger.blacklist_reasons.BlacklistReasonsViewImpl$renderItems$$inlined$forEach$lambda$1
                public final /* synthetic */ BlacklistReasonsViewImpl b;

                {
                    this.b = r2;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.b.getReasonSelections().accept(Long.valueOf(BlacklistReasons.Reason.this.getId()));
                }
            });
            this.d.addView(inflate2, new LinearLayout.LayoutParams(-1, -2));
        }
        Views.show(this.b);
        Views.conceal(this.c);
    }

    public final void d() {
        b();
        TransitionManager.beginDelayedTransition(this.j, new TransitionDsl(new Fade()).buildTransition());
        Views.conceal(this.b);
        Views.conceal(this.c);
    }

    @Override // com.avito.android.messenger.blacklist_reasons.BlacklistReasonsView
    public void destroyView() {
        this.j.removeCallbacks(this.f);
    }

    public final void e(String str, BlacklistReasons blacklistReasons) {
        if (blacklistReasons != null) {
            c(blacklistReasons);
        } else {
            d();
        }
        Views.showSnackBar$default(this.j, str, blacklistReasons != null ? 0 : -2, "Повторить", 0, new b(this), (Function0) null, 0, 104, (Object) null);
    }

    @Override // com.avito.android.messenger.blacklist_reasons.BlacklistReasonsView
    public void render(@NotNull BlacklistReasonsView.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        Logs.verbose$default("BlacklistReasonsView", "Render state: " + state, null, 4, null);
        if (Intrinsics.areEqual(state, BlacklistReasonsView.State.Empty.INSTANCE)) {
            d();
        } else if (state instanceof BlacklistReasonsView.State.InProgress) {
            this.j.postDelayed(this.f, 300);
        } else if (state instanceof BlacklistReasonsView.State.List.Ok) {
            c(((BlacklistReasonsView.State.List.Ok) state).getReasons());
        } else if (state instanceof BlacklistReasonsView.State.List.ReasonsError) {
            e(((BlacklistReasonsView.State.List.ReasonsError) state).getError(), null);
        } else if (state instanceof BlacklistReasonsView.State.List.BlockUserError) {
            b();
            BlacklistReasonsView.State.List.BlockUserError blockUserError = (BlacklistReasonsView.State.List.BlockUserError) state;
            e(blockUserError.getError(), blockUserError.getReasons());
        }
    }

    @Override // com.avito.android.messenger.blacklist_reasons.BlacklistReasonsView
    @NotNull
    public Relay<Unit> getBackNavigationClicks() {
        return this.g;
    }

    @Override // com.avito.android.messenger.blacklist_reasons.BlacklistReasonsView
    @NotNull
    public Relay<Long> getReasonSelections() {
        return this.i;
    }

    @Override // com.avito.android.messenger.blacklist_reasons.BlacklistReasonsView
    @NotNull
    public Relay<Unit> getRetryClicks() {
        return this.h;
    }
}
