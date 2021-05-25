package com.avito.android.phone_confirmation.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.phone_confirmation.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Toolbars;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.google.android.material.snackbar.Snackbar;
import com.jakewharton.rxrelay2.PublishRelay;
import com.jakewharton.rxrelay2.Relay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Cancellable;
import io.reactivex.functions.Consumer;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.info_label.InfoLabel;
import ru.avito.component.info_label.InfoLevel;
import ru.avito.component.text_input.EditTextSingleLine;
import ru.avito.component.text_input.EditTextSingleLineImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\bV\u0010WR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u001b\u0010\u0017R\"\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0015\u001a\u0004\b\u001f\u0010\u0017R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\"\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040%8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010\u000eR\"\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00040%8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b-\u0010'\u001a\u0004\b.\u0010)R\"\u00102\u001a\b\u0012\u0004\u0012\u00020\u001d0%8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b0\u0010'\u001a\u0004\b1\u0010)R\"\u00105\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u0010\u0015\u001a\u0004\b4\u0010\u0017R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\"\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00190\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b:\u0010\u0015\u001a\u0004\b;\u0010\u0017R\"\u0010?\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b=\u0010\u0015\u001a\u0004\b>\u0010\u0017R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR\"\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bD\u0010\u0015\u001a\u0004\bE\u0010\u0017R\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\"\u0010M\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bK\u0010\u0015\u001a\u0004\bL\u0010\u0017R\"\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00040%8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bN\u0010'\u001a\u0004\bO\u0010)R\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010\u0006R\"\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bS\u0010\u0015\u001a\u0004\bT\u0010\u0017¨\u0006X"}, d2 = {"Lcom/avito/android/phone_confirmation/view/PhoneConfirmationView;", "Lcom/avito/android/phone_confirmation/view/PhoneConfirmationInputView;", "Lcom/avito/android/phone_confirmation/view/PhoneConfirmationOutputView;", "Lcom/jakewharton/rxrelay2/Relay;", "", "h", "Lcom/jakewharton/rxrelay2/Relay;", "dialogRelay", "Lcom/google/android/material/snackbar/Snackbar;", "f", "Lcom/google/android/material/snackbar/Snackbar;", "snack", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "contentView", "Lio/reactivex/functions/Consumer;", "", "l", "Lio/reactivex/functions/Consumer;", "getShowLoader", "()Lio/reactivex/functions/Consumer;", "showLoader", "Lcom/avito/android/phone_confirmation/view/VisibilityText;", "u", "getValidationError", "validationError", "", VKApiConst.Q, "getSetConfirmationCode", "setConfirmationCode", "Lcom/avito/android/lib/design/button/Button;", "c", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Lio/reactivex/Observable;", "s", "Lio/reactivex/Observable;", "getRetry", "()Lio/reactivex/Observable;", "retry", "d", "progress", AuthSource.OPEN_CHANNEL_LIST, "getAlertDialogClicks", "alertDialogClicks", "r", "getEnteredCode", "enteredCode", "t", "getNetworkError", "networkError", "Lru/avito/component/info_label/InfoLabel;", "e", "Lru/avito/component/info_label/InfoLabel;", "infoLabel", "k", "getCodeButtonStatus", "codeButtonStatus", "o", "getTerminateDialog", "terminateDialog", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "titleMessage", "p", "getCleanText", "cleanText", "Lru/avito/component/text_input/EditTextSingleLine;", AuthSource.BOOKING_ORDER, "Lru/avito/component/text_input/EditTextSingleLine;", "singlelineViewEdit", "i", "getSetTitleMessage", "setTitleMessage", "j", "getNewCodeClicks", "newCodeClicks", a2.g.r.g.a, "retryRelay", "n", "getUnknownError", "unknownError", "<init>", "(Landroid/view/View;)V", "phone-confirmation_release"}, k = 1, mv = {1, 4, 2})
public final class PhoneConfirmationView implements PhoneConfirmationInputView, PhoneConfirmationOutputView {
    public final TextView a;
    public final EditTextSingleLine b;
    public final Button c;
    public final View d;
    public final InfoLabel e;
    public Snackbar f;
    public final Relay<Unit> g;
    public final Relay<Unit> h;
    @NotNull
    public final Consumer<String> i = new a(1, this);
    @NotNull
    public final Observable<Unit> j;
    @NotNull
    public final Consumer<VisibilityText> k;
    @NotNull
    public final Consumer<Boolean> l;
    @NotNull
    public final Observable<Unit> m;
    @NotNull
    public final Consumer<Unit> n;
    @NotNull
    public final Consumer<String> o;
    @NotNull
    public final Consumer<Unit> p;
    @NotNull
    public final Consumer<String> q;
    @NotNull
    public final Observable<String> r;
    @NotNull
    public final Observable<Unit> s;
    @NotNull
    public final Consumer<Boolean> t;
    @NotNull
    public final Consumer<VisibilityText> u;
    @NotNull
    public final View v;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Consumer<String> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(String str) {
            int i = this.a;
            if (i == 0) {
                String str2 = str;
                EditTextSingleLine editTextSingleLine = ((PhoneConfirmationView) this.b).b;
                Intrinsics.checkNotNullExpressionValue(str2, "it");
                editTextSingleLine.setText(str2);
            } else if (i == 1) {
                ((PhoneConfirmationView) this.b).a.setText(((PhoneConfirmationView) this.b).getContentView().getContext().getString(R.string.phone_confirmation_time_message, str));
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class b<T> implements Consumer<VisibilityText> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public b(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(VisibilityText visibilityText) {
            String str;
            String str2;
            int i = this.a;
            boolean z = false;
            if (i == 0) {
                VisibilityText visibilityText2 = visibilityText;
                boolean component1 = visibilityText2.component1();
                String component2 = visibilityText2.component2();
                if (component1) {
                    ((PhoneConfirmationView) this.b).c.setEnabled(true);
                } else {
                    ((PhoneConfirmationView) this.b).c.setEnabled(false);
                }
                if (component2 == null) {
                    String obj = ((PhoneConfirmationView) this.b).getContentView().getContext().getText(R.string.phone_confirmation_code_button).toString();
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
                    str = obj.toUpperCase();
                    Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).toUpperCase()");
                } else {
                    String string = ((PhoneConfirmationView) this.b).getContentView().getContext().getString(R.string.phone_confirmation_code_button_time, component2);
                    Intrinsics.checkNotNullExpressionValue(string, "contentView.context.getS…n_code_button_time, text)");
                    Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
                    str = string.toUpperCase();
                    Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.String).toUpperCase()");
                }
                ((PhoneConfirmationView) this.b).c.setText(str);
            } else if (i == 1) {
                VisibilityText visibilityText3 = visibilityText;
                boolean component12 = visibilityText3.component1();
                String component22 = visibilityText3.component2();
                ((PhoneConfirmationView) this.b).b.setHasError(component12);
                ((PhoneConfirmationView) this.b).e.setVisible(component12);
                if (component12) {
                    if (component22 == null || component22.length() == 0) {
                        z = true;
                    }
                    if (z) {
                        CharSequence text = ((PhoneConfirmationView) this.b).getContentView().getContext().getText(R.string.phone_confirmation_validation_error);
                        Intrinsics.checkNotNullExpressionValue(text, "contentView.context.getT…rmation_validation_error)");
                        str2 = text;
                    } else {
                        Intrinsics.checkNotNull(component22);
                        str2 = component22;
                    }
                    ((PhoneConfirmationView) this.b).e.setValues(str2, InfoLevel.ERROR);
                }
            } else {
                throw null;
            }
        }
    }

    /* compiled from: java-style lambda group */
    public static final class c<T> implements Consumer<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public c(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Unit unit) {
            int i = this.a;
            if (i == 0) {
                ((PhoneConfirmationView) this.b).b.setText("");
            } else if (i == 1) {
                ((PhoneConfirmationView) this.b).getTerminateDialog().accept(((PhoneConfirmationView) this.b).getContentView().getContext().getText(R.string.phone_confirmation_unknown_error).toString());
            } else {
                throw null;
            }
        }
    }

    public static final class d<T> implements Consumer<Boolean> {
        public final /* synthetic */ PhoneConfirmationView a;

        public d(PhoneConfirmationView phoneConfirmationView) {
            this.a = phoneConfirmationView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            Intrinsics.checkNotNullExpressionValue(bool2, "it");
            if (bool2.booleanValue()) {
                CharSequence text = this.a.getContentView().getContext().getText(com.avito.android.remote.R.string.network_unavailable_snack);
                Intrinsics.checkNotNullExpressionValue(text, "contentView.context.getT…etwork_unavailable_snack)");
                String obj = this.a.getContentView().getContext().getText(R.string.phone_confirmation_retry_caps).toString();
                Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
                String upperCase = obj.toUpperCase();
                Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
                PhoneConfirmationView phoneConfirmationView = this.a;
                phoneConfirmationView.f = Views.showSnackBar$default(phoneConfirmationView.getContentView(), text, -2, upperCase, 0, new a2.a.a.v1.h.a(this), (Function0) null, 0, 104, (Object) null);
                return;
            }
            Snackbar snackbar = this.a.f;
            if (snackbar != null) {
                snackbar.dismiss();
            }
        }
    }

    public static final class e<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ PhoneConfirmationView a;

        public static final class a implements Cancellable {
            public final /* synthetic */ e a;

            public a(e eVar) {
                this.a = eVar;
            }

            @Override // io.reactivex.functions.Cancellable
            public final void cancel() {
                this.a.a.c.setOnClickListener(null);
            }
        }

        public static final class b implements View.OnClickListener {
            public final /* synthetic */ ObservableEmitter a;

            public b(ObservableEmitter observableEmitter) {
                this.a = observableEmitter;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r2v1, resolved type: io.reactivex.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.onNext(Unit.INSTANCE);
            }
        }

        public e(PhoneConfirmationView phoneConfirmationView) {
            this.a = phoneConfirmationView;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(@NotNull ObservableEmitter<Unit> observableEmitter) {
            Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
            observableEmitter.setCancellable(new a(this));
            this.a.c.setOnClickListener(new b(observableEmitter));
        }
    }

    public static final class f<T> implements Consumer<Boolean> {
        public final /* synthetic */ PhoneConfirmationView a;

        public f(PhoneConfirmationView phoneConfirmationView) {
            this.a = phoneConfirmationView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Boolean bool) {
            Boolean bool2 = bool;
            View view = this.a.d;
            Intrinsics.checkNotNullExpressionValue(bool2, "it");
            Views.setVisible(view, bool2.booleanValue());
        }
    }

    public static final class g<T> implements Consumer<String> {
        public final /* synthetic */ PhoneConfirmationView a;

        public g(PhoneConfirmationView phoneConfirmationView) {
            this.a = phoneConfirmationView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(String str) {
            String str2 = str;
            AlertDialog.Builder builder = new AlertDialog.Builder(this.a.getContentView().getContext());
            if (TextUtils.isEmpty(str2)) {
                str2 = this.a.getContentView().getContext().getString(R.string.phone_confirmation_too_many_code_requests);
            }
            AlertDialog.Builder message = builder.setMessage(str2);
            String string = this.a.getContentView().getContext().getString(com.avito.android.ui_components.R.string.close);
            Intrinsics.checkNotNullExpressionValue(string, "contentView.context.getS…g.close\n                )");
            Objects.requireNonNull(string, "null cannot be cast to non-null type java.lang.String");
            String upperCase = string.toUpperCase();
            Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
            message.setPositiveButton(upperCase, new a2.a.a.v1.h.b(this)).setCancelable(false).show();
        }
    }

    public PhoneConfirmationView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "contentView");
        this.v = view;
        View findViewById = view.findViewById(R.id.message);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.input_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById(R.id.input_view)");
        EditTextSingleLineImpl editTextSingleLineImpl = new EditTextSingleLineImpl(findViewById2);
        this.b = editTextSingleLineImpl;
        View findViewById3 = view.findViewById(R.id.get_new_code);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentView.findViewById(R.id.get_new_code)");
        Button button = (Button) findViewById3;
        this.c = button;
        View findViewById4 = view.findViewById(R.id.full_progress_view);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.view.View");
        this.d = findViewById4;
        View findViewById5 = view.findViewById(R.id.info_label);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.view.View");
        this.e = new InfoLabel(findViewById5);
        PublishRelay create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.g = create;
        PublishRelay create2 = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create2, "PublishRelay.create()");
        this.h = create2;
        View findViewById6 = view.findViewById(R.id.toolbar);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        Toolbars.setBackIcon$default((Toolbar) findViewById6, 0, 1, null);
        CharSequence text = view.getContext().getText(R.string.phone_confirmation_code_hint);
        Intrinsics.checkNotNullExpressionValue(text, "contentView.context.getT…e_confirmation_code_hint)");
        editTextSingleLineImpl.setHint(text);
        String obj = view.getContext().getText(R.string.phone_confirmation_code_button).toString();
        Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
        String upperCase = obj.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
        button.setText(upperCase);
        editTextSingleLineImpl.setTextLength(5);
        editTextSingleLineImpl.setInputType(2);
        editTextSingleLineImpl.showKeyboard();
        Observable<Unit> create3 = Observable.create(new e(this));
        Intrinsics.checkNotNullExpressionValue(create3, "Observable.create<Unit> …tter.onNext(Unit) }\n    }");
        this.j = create3;
        this.k = new b(0, this);
        this.l = new f(this);
        this.m = create2;
        this.n = new c(1, this);
        this.o = new g(this);
        this.p = new c(0, this);
        this.q = new a(0, this);
        this.r = InteropKt.toV2(editTextSingleLineImpl.textChangeCallbacks());
        this.s = create;
        this.t = new d(this);
        this.u = new b(1, this);
    }

    @Override // com.avito.android.phone_confirmation.view.PhoneConfirmationOutputView
    @NotNull
    public Observable<Unit> getAlertDialogClicks() {
        return this.m;
    }

    @Override // com.avito.android.phone_confirmation.view.PhoneConfirmationInputView
    @NotNull
    public Consumer<Unit> getCleanText() {
        return this.p;
    }

    @Override // com.avito.android.phone_confirmation.view.PhoneConfirmationInputView
    @NotNull
    public Consumer<VisibilityText> getCodeButtonStatus() {
        return this.k;
    }

    @NotNull
    public final View getContentView() {
        return this.v;
    }

    @Override // com.avito.android.phone_confirmation.view.PhoneConfirmationOutputView
    @NotNull
    public Observable<String> getEnteredCode() {
        return this.r;
    }

    @Override // com.avito.android.phone_confirmation.view.PhoneConfirmationInputView
    @NotNull
    public Consumer<Boolean> getNetworkError() {
        return this.t;
    }

    @Override // com.avito.android.phone_confirmation.view.PhoneConfirmationOutputView
    @NotNull
    public Observable<Unit> getNewCodeClicks() {
        return this.j;
    }

    @Override // com.avito.android.phone_confirmation.view.PhoneConfirmationOutputView
    @NotNull
    public Observable<Unit> getRetry() {
        return this.s;
    }

    @Override // com.avito.android.phone_confirmation.view.PhoneConfirmationInputView
    @NotNull
    public Consumer<String> getSetConfirmationCode() {
        return this.q;
    }

    @Override // com.avito.android.phone_confirmation.view.PhoneConfirmationInputView
    @NotNull
    public Consumer<String> getSetTitleMessage() {
        return this.i;
    }

    @Override // com.avito.android.phone_confirmation.view.PhoneConfirmationInputView
    @NotNull
    public Consumer<Boolean> getShowLoader() {
        return this.l;
    }

    @Override // com.avito.android.phone_confirmation.view.PhoneConfirmationInputView
    @NotNull
    public Consumer<String> getTerminateDialog() {
        return this.o;
    }

    @Override // com.avito.android.phone_confirmation.view.PhoneConfirmationInputView
    @NotNull
    public Consumer<Unit> getUnknownError() {
        return this.n;
    }

    @Override // com.avito.android.phone_confirmation.view.PhoneConfirmationInputView
    @NotNull
    public Consumer<VisibilityText> getValidationError() {
        return this.u;
    }
}
