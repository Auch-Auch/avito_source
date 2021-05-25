package com.avito.android.util;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0004¢\u0006\u0004\b\u0002\u0010\u0005\u001a\u001d\u0010\u0002\u001a\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0002\u0010\t\u001a\u001b\u0010\f\u001a\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a%\u0010\u0010\u001a\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011\u001a1\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0015\u0010\u0016\u001a%\u0010\u0017\u001a\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u0011\u001a1\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0018\u0010\u0016\u001a\u001b\u0010\u0019\u001a\u00020\u0001*\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0019\u0010\r\u001a/\u0010\u001e\u001a\u00020\u001d*\u00020\u00002\b\b\u0002\u0010\u001a\u001a\u00020\u00072\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u001b¢\u0006\u0004\b\u001e\u0010\u001f\u001a/\u0010\u001e\u001a\u00020\u001d*\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00072\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u001b¢\u0006\u0004\b\u001e\u0010 \u001a\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00070!*\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Landroid/app/Activity;", "", PlatformActions.HIDE_KEYBOARD, "(Landroid/app/Activity;)V", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)Lkotlin/Unit;", "Landroid/view/View;", "", "clearFocus", "(Landroid/view/View;Z)V", "", "flag", "showKeyboard", "(Landroid/view/View;I)V", "flags", "attemptCount", "showKeyboardWithAttempt", "(Landroid/view/View;II)V", "view", "Landroid/view/inputmethod/InputMethodManager;", "inputMethodManager", AuthSource.BOOKING_ORDER, "(Landroid/view/View;ILandroid/view/inputmethod/InputMethodManager;I)V", "hideKeyboardWithAttempt", AuthSource.SEND_ABUSE, "showKeyboardDelayed", "initialState", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/util/KeyboardSubscription;", "addSoftKeyboardVisibilityListener", "(Landroid/app/Activity;ZLkotlin/jvm/functions/Function1;)Lcom/avito/android/util/KeyboardSubscription;", "(Landroid/view/View;ZLkotlin/jvm/functions/Function1;)Lcom/avito/android/util/KeyboardSubscription;", "Lio/reactivex/Observable;", "keyboardVisibilityChanges", "(Landroid/app/Activity;Z)Lio/reactivex/Observable;", "android_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Keyboards")
public final class Keyboards {

    public static final class a implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;
        public final /* synthetic */ InputMethodManager c;
        public final /* synthetic */ int d;

        public a(View view, int i, InputMethodManager inputMethodManager, int i2) {
            this.a = view;
            this.b = i;
            this.c = inputMethodManager;
            this.d = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Keyboards.a(this.a, this.b, this.c, this.d - 1);
        }
    }

    public static final class b<T> implements ObservableOnSubscribe<Boolean> {
        public final /* synthetic */ Activity a;
        public final /* synthetic */ boolean b;

        public static final class a extends Lambda implements Function1<Boolean, Unit> {
            public final /* synthetic */ ObservableEmitter a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(ObservableEmitter observableEmitter) {
                super(1);
                this.a = observableEmitter;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: io.reactivex.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Boolean bool) {
                boolean booleanValue = bool.booleanValue();
                ObservableEmitter observableEmitter = this.a;
                Intrinsics.checkNotNullExpressionValue(observableEmitter, "emitter");
                if (!observableEmitter.isDisposed()) {
                    this.a.onNext(Boolean.valueOf(booleanValue));
                }
                return Unit.INSTANCE;
            }
        }

        public b(Activity activity, boolean z) {
            this.a = activity;
            this.b = z;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(@NotNull ObservableEmitter<Boolean> observableEmitter) {
            Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
            observableEmitter.setDisposable(Keyboards.addSoftKeyboardVisibilityListener(this.a, this.b, new a(observableEmitter)));
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;

        public c(View view, int i) {
            this.a = view;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Keyboards.showKeyboardDelayed(this.a, this.b);
        }
    }

    public static final class d implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;
        public final /* synthetic */ InputMethodManager c;
        public final /* synthetic */ int d;

        public d(View view, int i, InputMethodManager inputMethodManager, int i2) {
            this.a = view;
            this.b = i;
            this.c = inputMethodManager;
            this.d = i2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Keyboards.b(this.a, this.b, this.c, this.d - 1);
        }
    }

    public static final void a(View view, int i, InputMethodManager inputMethodManager, int i2) {
        if (inputMethodManager == null) {
            Object systemService = view.getContext().getSystemService("input_method");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            inputMethodManager = (InputMethodManager) systemService;
        }
        if (!inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), i) && i2 > 0) {
            view.post(new a(view, i, inputMethodManager, i2));
        }
    }

    @NotNull
    public static final KeyboardSubscription addSoftKeyboardVisibilityListener(@NotNull Activity activity, boolean z, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(activity, "$this$addSoftKeyboardVisibilityListener");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        View findViewById = activity.findViewById(16908290);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(android.R.id.content)");
        return new KeyboardVisibilitySubscription(findViewById, z, function1);
    }

    public static /* synthetic */ KeyboardSubscription addSoftKeyboardVisibilityListener$default(Activity activity, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return addSoftKeyboardVisibilityListener(activity, z, function1);
    }

    public static final void b(View view, int i, InputMethodManager inputMethodManager, int i2) {
        if (view.isFocused()) {
            if (inputMethodManager == null) {
                Object systemService = view.getContext().getSystemService("input_method");
                Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
                inputMethodManager = (InputMethodManager) systemService;
            }
            if (!inputMethodManager.showSoftInput(view, i) && i2 > 0) {
                view.post(new d(view, i, inputMethodManager, i2));
            }
        }
    }

    public static final void hideKeyboard(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "$this$hideKeyboard");
        boolean pickFocus = ViewUtils.INSTANCE.pickFocus(activity);
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            hideKeyboard(currentFocus, pickFocus);
        }
    }

    @JvmOverloads
    public static final void hideKeyboard(@NotNull View view) {
        hideKeyboard$default(view, false, 1, null);
    }

    public static /* synthetic */ void hideKeyboard$default(View view, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        hideKeyboard(view, z);
    }

    public static final void hideKeyboardWithAttempt(@NotNull View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "$this$hideKeyboardWithAttempt");
        a(view, i, null, i2);
    }

    public static /* synthetic */ void hideKeyboardWithAttempt$default(View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 2;
        }
        if ((i3 & 2) != 0) {
            i2 = 5;
        }
        hideKeyboardWithAttempt(view, i, i2);
    }

    @NotNull
    public static final Observable<Boolean> keyboardVisibilityChanges(@NotNull Activity activity, boolean z) {
        Intrinsics.checkNotNullParameter(activity, "$this$keyboardVisibilityChanges");
        Observable<Boolean> create = Observable.create(new b(activity, z));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…posable(disposable)\n    }");
        return create;
    }

    public static final void showKeyboard(@NotNull View view, int i) {
        Intrinsics.checkNotNullParameter(view, "$this$showKeyboard");
        view.requestFocus();
        Object systemService = view.getContext().getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        ((InputMethodManager) systemService).showSoftInput(view, i);
    }

    public static /* synthetic */ void showKeyboard$default(View view, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        showKeyboard(view, i);
    }

    public static final void showKeyboardDelayed(@NotNull View view, int i) {
        Intrinsics.checkNotNullParameter(view, "$this$showKeyboardDelayed");
        if (view.isFocusable() || view.isFocusableInTouchMode()) {
            Object systemService = view.getContext().getSystemService("input_method");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            InputMethodManager inputMethodManager = (InputMethodManager) systemService;
            if (!(view.requestFocus() && inputMethodManager.isActive(view) && inputMethodManager.showSoftInput(view, i))) {
                view.postDelayed(new c(view, i), 100);
            }
        }
    }

    public static /* synthetic */ void showKeyboardDelayed$default(View view, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        showKeyboardDelayed(view, i);
    }

    public static final void showKeyboardWithAttempt(@NotNull View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "$this$showKeyboardWithAttempt");
        view.requestFocus();
        b(view, i, null, i2);
    }

    public static /* synthetic */ void showKeyboardWithAttempt$default(View view, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 1;
        }
        if ((i3 & 2) != 0) {
            i2 = 5;
        }
        showKeyboardWithAttempt(view, i, i2);
    }

    public static /* synthetic */ KeyboardSubscription addSoftKeyboardVisibilityListener$default(View view, boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return addSoftKeyboardVisibilityListener(view, z, function1);
    }

    @NotNull
    public static final KeyboardSubscription addSoftKeyboardVisibilityListener(@NotNull View view, boolean z, @NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(view, "$this$addSoftKeyboardVisibilityListener");
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        return new KeyboardVisibilitySubscription(view, z, function1);
    }

    @Nullable
    public static final Unit hideKeyboard(@NotNull Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "$this$hideKeyboard");
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            return null;
        }
        hideKeyboard(activity);
        return Unit.INSTANCE;
    }

    @JvmOverloads
    public static final void hideKeyboard(@NotNull View view, boolean z) {
        Intrinsics.checkNotNullParameter(view, "$this$hideKeyboard");
        Object systemService = view.getContext().getSystemService("input_method");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        View rootView = view.getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        ((InputMethodManager) systemService).hideSoftInputFromWindow(rootView.getWindowToken(), 0);
        if (z && !ViewUtils.INSTANCE.pickFocus(view)) {
            view.getRootView().clearFocus();
        }
    }
}
