package com.avito.android.profile.sessions.info;

import a2.g.r.g;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.profile.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Contexts;
import com.avito.android.util.Toolbars;
import com.avito.android.util.Views;
import com.jakewharton.rxbinding4.view.RxView;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00104\u001a\u00020\u0015¢\u0006\u0004\b5\u00106J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\rR\u0016\u0010\u001c\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\tR\u0016\u0010\u001e\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\tR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\"\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b$\u0010\u0013R\u0016\u0010'\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010\u0017R\"\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010\u0011\u001a\u0004\b)\u0010\u0013R\u0016\u0010,\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010\tR\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\"\u00103\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u0010\u0011\u001a\u0004\b2\u0010\u0013¨\u00067"}, d2 = {"Lcom/avito/android/profile/sessions/info/SessionsInfoViewImpl;", "Lcom/avito/android/profile/sessions/info/SessionsInfoView;", "", "bindTextsForPasswordChange", "()V", "bindTextsForLogout", "expandInfo", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "description", "Lcom/jakewharton/rxrelay3/PublishRelay;", "j", "Lcom/jakewharton/rxrelay3/PublishRelay;", "expandInfoClickRelay", "Lio/reactivex/rxjava3/core/Observable;", AuthSource.OPEN_CHANNEL_LIST, "Lio/reactivex/rxjava3/core/Observable;", "getExpandInfoClicks", "()Lio/reactivex/rxjava3/core/Observable;", "expandInfoClicks", "Landroid/view/View;", "h", "Landroid/view/View;", "collapsedText", "i", "linkClickRelay", "c", "title", "e", "openHelpCenter", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "k", "getButtonClicks", "buttonClicks", "f", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "l", "getHelpCenterLinkClicks", "helpCenterLinkClicks", g.a, "collapsedTextHeader", "Landroidx/appcompat/widget/Toolbar;", AuthSource.BOOKING_ORDER, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "n", "getNavigationClicks", "navigationClicks", "rootView", "<init>", "(Landroid/view/View;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class SessionsInfoViewImpl implements SessionsInfoView {
    public final Context a;
    public final Toolbar b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final View f;
    public final TextView g;
    public final View h;
    public final PublishRelay<Unit> i;
    public final PublishRelay<Unit> j;
    @NotNull
    public final Observable<Unit> k;
    @NotNull
    public final Observable<Unit> l;
    @NotNull
    public final Observable<Unit> m;
    @NotNull
    public final Observable<Unit> n;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ SessionsInfoViewImpl a;

        public a(SessionsInfoViewImpl sessionsInfoViewImpl) {
            this.a = sessionsInfoViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (!Views.isVisible(this.a.h)) {
                this.a.j.accept(Unit.INSTANCE);
            }
        }
    }

    public SessionsInfoViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        this.a = context;
        View findViewById = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById;
        this.b = toolbar;
        View findViewById2 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.description_part_1);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.open_help_center);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById4;
        this.e = textView;
        View findViewById5 = view.findViewById(R.id.button);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.f = findViewById5;
        View findViewById6 = view.findViewById(R.id.header);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) findViewById6;
        this.g = textView2;
        View findViewById7 = view.findViewById(R.id.description_list);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.view.View");
        this.h = findViewById7;
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.i = create;
        PublishRelay<Unit> create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.j = create2;
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_close_24);
        SpannableString spannableString = new SpannableString(context.getString(R.string.sessions_result_support));
        spannableString.setSpan(new ClickableSpan(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.blue)) { // from class: com.avito.android.profile.sessions.info.SessionsInfoViewImpl$initSupportText$span$1
            public final /* synthetic */ int b;

            {
                this.b = r2;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(@NotNull View view2) {
                Intrinsics.checkNotNullParameter(view2, "widget");
                SessionsInfoViewImpl.this.i.accept(Unit.INSTANCE);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(@NotNull TextPaint textPaint) {
                Intrinsics.checkNotNullParameter(textPaint, "ds");
                textPaint.setColor(this.b);
                textPaint.setUnderlineText(false);
            }
        }, spannableString.length() - 10, spannableString.length() - 1, 18);
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setOnClickListener(new a(this));
        this.k = RxView.clicks(findViewById5);
        this.l = create;
        this.m = create2;
        this.n = Toolbars.upClicks(toolbar);
    }

    @Override // com.avito.android.profile.sessions.info.SessionsInfoView
    public void bindTextsForLogout() {
        this.c.setText(this.a.getString(R.string.sessions_result_logout_title));
        this.d.setText(this.a.getString(R.string.sessions_result_logout_description));
    }

    @Override // com.avito.android.profile.sessions.info.SessionsInfoView
    public void bindTextsForPasswordChange() {
        this.c.setText(this.a.getString(R.string.sessions_result_password_change_title));
        this.d.setText(this.a.getString(R.string.sessions_result_password_change_description));
    }

    @Override // com.avito.android.profile.sessions.info.SessionsInfoView
    public void expandInfo() {
        Views.show(this.h);
        Views.show(this.e);
        this.g.setTextColor(Contexts.getColorByAttr(this.a, com.avito.android.lib.design.R.attr.black));
        TextView textView = this.g;
        textView.setTypeface(textView.getTypeface(), 1);
    }

    @Override // com.avito.android.profile.sessions.info.SessionsInfoView
    @NotNull
    public Observable<Unit> getButtonClicks() {
        return this.k;
    }

    @Override // com.avito.android.profile.sessions.info.SessionsInfoView
    @NotNull
    public Observable<Unit> getExpandInfoClicks() {
        return this.m;
    }

    @Override // com.avito.android.profile.sessions.info.SessionsInfoView
    @NotNull
    public Observable<Unit> getHelpCenterLinkClicks() {
        return this.l;
    }

    @Override // com.avito.android.profile.sessions.info.SessionsInfoView
    @NotNull
    public Observable<Unit> getNavigationClicks() {
        return this.n;
    }
}
