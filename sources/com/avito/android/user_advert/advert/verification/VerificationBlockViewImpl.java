package com.avito.android.user_advert.advert.verification;

import a2.g.r.g;
import android.view.View;
import android.widget.TextView;
import com.avito.android.advert_core.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Views;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010(\u001a\u00020\u001d¢\u0006\u0004\b-\u0010.J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\nJ%\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0014\u001a\u00020\u00042\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0006J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0018\u0010\u0006R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010(\u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010\u001fR\u0018\u0010*\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010\u001fR\u0018\u0010,\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010\u001f¨\u0006/"}, d2 = {"Lcom/avito/android/user_advert/advert/verification/VerificationBlockViewImpl;", "Lcom/avito/android/user_advert/advert/verification/VerificationBlockView;", "", "isVisible", "", "setVisible", "(Z)V", "", "titleId", "showTitle", "(I)V", "descriptionId", "showDescription", "title", "Lkotlin/Function0;", "onClick", "showButton", "(ILkotlin/jvm/functions/Function0;)V", "hideButton", "()V", "showSupportButton", "(Lkotlin/jvm/functions/Function0;)V", "hideSupportButton", "setAdditionalDescriptionVisible", "setBadgeVisible", "Lcom/avito/android/lib/design/button/Button;", "c", "Lcom/avito/android/lib/design/button/Button;", "verificationButton", "Landroid/view/View;", "e", "Landroid/view/View;", "verificationBadge", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "descriptionTextView", AuthSource.SEND_ABUSE, "titleTextView", g.a, "view", "f", "supportButton", "d", "additionalDescription", "<init>", "(Landroid/view/View;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationBlockViewImpl implements VerificationBlockView {
    public final TextView a;
    public final TextView b;
    public final Button c;
    public final View d;
    public final View e;
    public final View f;
    public final View g;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public VerificationBlockViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.g = view;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.description);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.verification_button);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        this.c = (Button) findViewById3;
        this.d = view.findViewById(R.id.additional_description);
        this.e = view.findViewById(R.id.verification_badge);
        this.f = view.findViewById(R.id.support_button);
    }

    @Override // com.avito.android.user_advert.advert.verification.VerificationBlockView
    public void hideButton() {
        Views.setVisible(this.c, false);
    }

    @Override // com.avito.android.user_advert.advert.verification.VerificationBlockView
    public void hideSupportButton() {
        View view = this.f;
        if (view != null) {
            Views.setVisible(view, false);
        }
    }

    @Override // com.avito.android.user_advert.advert.verification.VerificationBlockView
    public void setAdditionalDescriptionVisible(boolean z) {
        Views.setVisible(this.d, z);
    }

    @Override // com.avito.android.user_advert.advert.verification.VerificationBlockView
    public void setBadgeVisible(boolean z) {
        View view = this.e;
        if (view != null) {
            Views.setVisible(view, z);
        }
    }

    @Override // com.avito.android.user_advert.advert.verification.VerificationBlockView
    public void setVisible(boolean z) {
        Views.setVisible(this.g, z);
    }

    @Override // com.avito.android.user_advert.advert.verification.VerificationBlockView
    public void showButton(int i, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        this.c.setText(i);
        this.c.setOnClickListener(new a(function0));
        Views.setVisible(this.c, true);
    }

    @Override // com.avito.android.user_advert.advert.verification.VerificationBlockView
    public void showDescription(int i) {
        this.b.setText(i);
    }

    @Override // com.avito.android.user_advert.advert.verification.VerificationBlockView
    public void showSupportButton(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "onClick");
        View view = this.f;
        if (view != null) {
            Views.setVisible(view, true);
        }
        View view2 = this.f;
        if (view2 != null) {
            view2.setOnClickListener(new b(function0));
        }
    }

    @Override // com.avito.android.user_advert.advert.verification.VerificationBlockView
    public void showTitle(int i) {
        this.a.setText(i);
    }
}
