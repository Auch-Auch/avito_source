package com.avito.android.authorization.phone_proving;

import a2.g.r.g;
import android.text.InputFilter;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.authorization.R;
import com.avito.android.authorization.phone_proving.PhoneProvingView;
import com.avito.android.authorization.phone_proving.view.HintEditText;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.ButtonsKt;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding3.appcompat.RxToolbar;
import io.reactivex.Observable;
import io.reactivex.functions.Predicate;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button.Button;
import ru.avito.component.button.ButtonImpl;
import ru.avito.component.info_label.InfoLabel;
import ru.avito.component.info_label.InfoLevel;
import ru.avito.component.text.TextImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010?\u001a\u000201¢\u0006\u0004\b@\u0010AJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u000bJ\u000f\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0013\u0010\u000bJ\u000f\u0010\u0014\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0011J\u000f\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0011J\u000f\u0010\u0017\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0011J\u0017\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001c\u0010\u0011J2\u0010#\u001a\u00020\u00032!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00030\u001dH\u0016¢\u0006\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u00103R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006B"}, d2 = {"Lcom/avito/android/authorization/phone_proving/PhoneProvingViewImpl;", "Lcom/avito/android/authorization/phone_proving/PhoneProvingView;", "Lio/reactivex/Observable;", "", "proveClicks", "()Lio/reactivex/Observable;", "navigationClicks", "", "phoneEndingChanged", "phonePart", "setPhoneStarting", "(Ljava/lang/String;)V", "hint", "setInputHint", "message", "showPhoneError", "hidePhoneError", "()V", "error", "showError", "showUnknownError", "showProgress", "hideProgress", PlatformActions.HIDE_KEYBOARD, "", "enabled", "setProveButtonEnabled", "(Z)V", "requestFieldFocus", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "actionId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lkotlin/jvm/functions/Function1;)V", "Lru/avito/component/button/Button;", "d", "Lru/avito/component/button/Button;", "proveButton", "Lcom/avito/android/authorization/phone_proving/view/HintEditText;", "f", "Lcom/avito/android/authorization/phone_proving/view/HintEditText;", "phoneEnding", "Landroidx/appcompat/widget/Toolbar;", "c", "Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "progressView", "Lru/avito/component/info_label/InfoLabel;", g.a, "Lru/avito/component/info_label/InfoLabel;", "phoneLabel", AuthSource.BOOKING_ORDER, "contentView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "phoneStarting", "view", "<init>", "(Landroid/view/View;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneProvingViewImpl implements PhoneProvingView {
    public final View a;
    public final View b;
    public final Toolbar c;
    public final Button d;
    public final TextView e;
    public final HintEditText f;
    public final InfoLabel g;

    public static final class b<T> implements Predicate<Unit> {
        public final /* synthetic */ PhoneProvingViewImpl a;

        public b(PhoneProvingViewImpl phoneProvingViewImpl) {
            this.a = phoneProvingViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return this.a.d.isEnabled();
        }
    }

    public static final class c implements TextView.OnEditorActionListener {
        public final /* synthetic */ PhoneProvingViewImpl a;
        public final /* synthetic */ Function1 b;

        public c(PhoneProvingViewImpl phoneProvingViewImpl, Function1 function1) {
            this.a = phoneProvingViewImpl;
            this.b = function1;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            this.b.invoke(Integer.valueOf(i));
            return !this.a.d.isEnabled();
        }
    }

    public PhoneProvingViewImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.progress_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.a = findViewById;
        View findViewById2 = view.findViewById(R.id.content_container);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById2;
        View findViewById3 = view.findViewById(com.avito.android.deprecated_design.R.id.toolbar);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbar toolbar = (Toolbar) findViewById3;
        this.c = toolbar;
        View findViewById4 = view.findViewById(R.id.prove_button);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        ButtonImpl buttonImpl = new ButtonImpl(findViewById4);
        buttonImpl.setText(R.string.prove_button_text);
        Unit unit = Unit.INSTANCE;
        this.d = buttonImpl;
        View findViewById5 = view.findViewById(R.id.phone_starting_view);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.e = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.phone_ending_view);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type com.avito.android.authorization.phone_proving.view.HintEditText");
        HintEditText hintEditText = (HintEditText) findViewById6;
        hintEditText.setImeOptions(268435462);
        this.f = hintEditText;
        View findViewById7 = view.findViewById(R.id.phone_label);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.view.View");
        this.g = new InfoLabel(findViewById7);
        toolbar.setTitle(R.string.phone_proving_title);
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_close_24);
        View findViewById8 = view.findViewById(R.id.text_view);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.view.View");
        new TextImpl(findViewById8).setText(R.string.enter_last_four_digits);
        hintEditText.requestFocus();
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingView
    @NotNull
    public Observable<Integer> actionCallbacks() {
        return PhoneProvingView.DefaultImpls.actionCallbacks(this);
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingView
    @NotNull
    public Observable<Unit> doneCallbacks() {
        return PhoneProvingView.DefaultImpls.doneCallbacks(this);
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingView
    public void hideKeyboard() {
        Keyboards.hideKeyboard$default(this.b, false, 1, null);
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingView
    public void hidePhoneError() {
        this.g.setVisible(false);
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingView
    public void hideProgress() {
        Views.hide(this.a);
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingView
    @NotNull
    public Observable<Unit> navigationClicks() {
        return RxToolbar.navigationClicks(this.c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [a2.a.a.b.g.d] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.avito.android.authorization.phone_proving.PhoneProvingView
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.reactivex.Observable<java.lang.String> phoneEndingChanged() {
        /*
            r3 = this;
            com.avito.android.authorization.phone_proving.view.HintEditText r0 = r3.f
            com.jakewharton.rxbinding3.InitialValueObservable r0 = com.jakewharton.rxbinding3.widget.RxTextView.textChanges(r0)
            com.avito.android.authorization.phone_proving.PhoneProvingViewImpl$a r1 = com.avito.android.authorization.phone_proving.PhoneProvingViewImpl.a.a
            if (r1 == 0) goto L_0x0010
            a2.a.a.b.g.d r2 = new a2.a.a.b.g.d
            r2.<init>(r1)
            r1 = r2
        L_0x0010:
            io.reactivex.functions.Function r1 = (io.reactivex.functions.Function) r1
            io.reactivex.Observable r0 = r0.map(r1)
            java.lang.String r1 = "phoneEnding.textChanges(…(CharSequence?::toString)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.authorization.phone_proving.PhoneProvingViewImpl.phoneEndingChanged():io.reactivex.Observable");
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingView
    @NotNull
    public Observable<Unit> proveClicks() {
        Observable<Unit> filter = Observable.merge(InteropKt.toV2(ButtonsKt.clicks(this.d)), doneCallbacks()).filter(new b(this));
        Intrinsics.checkNotNullExpressionValue(filter, "Observable.merge(proveBu…proveButton.isEnabled() }");
        return filter;
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingView
    public void requestFieldFocus() {
        Keyboards.showKeyboard$default(this.f, 0, 1, null);
        HintEditText hintEditText = this.f;
        hintEditText.setSelection(hintEditText.getText().length());
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingView
    public void setActionListener(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f.setOnEditorActionListener(new c(this, function1));
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingView
    public void setInputHint(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "hint");
        this.f.setHintText(str);
        this.f.setFilters(new InputFilter.LengthFilter[]{new InputFilter.LengthFilter(str.length())});
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingView
    public void setPhoneStarting(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "phonePart");
        this.e.setText(str);
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingView
    public void setProveButtonEnabled(boolean z) {
        this.d.setEnabled(z);
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingView
    public void showError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        Views.showSnackBar$default(this.b, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingView
    public void showPhoneError(@Nullable String str) {
        this.g.setValues(str != null ? str : "", InfoLevel.ERROR);
        this.g.setVisible(str != null);
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingView
    public void showProgress() {
        Views.show(this.a);
    }

    @Override // com.avito.android.authorization.phone_proving.PhoneProvingView
    public void showUnknownError() {
        Views.showSnackBar$default(this.b, com.avito.android.remote.R.string.unknown_server_error, 0, (Integer) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }
}
