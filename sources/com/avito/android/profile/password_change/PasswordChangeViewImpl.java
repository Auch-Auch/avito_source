package com.avito.android.profile.password_change;

import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.Input;
import com.avito.android.profile.InputsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Logs;
import com.avito.android.util.Views;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010N\u001a\u00020#\u0012\u0006\u0010f\u001a\u00020e¢\u0006\u0004\bg\u0010hJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0006J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0006J\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\rJ\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\bJ\u000f\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\bJ\u000f\u0010\u0016\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\bJ\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\bJ\u000f\u0010\u0018\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0018\u0010\bJ\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0006J\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\bJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001c\u0010\bJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\bJ\u000f\u0010\u001e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001e\u0010\bR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\"\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020+8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\"\u00103\u001a\b\u0012\u0004\u0012\u00020\u00040+8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b1\u0010-\u001a\u0004\b2\u0010/R\"\u00106\u001a\b\u0012\u0004\u0012\u00020\u00040+8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b4\u0010-\u001a\u0004\b5\u0010/R\u0016\u00108\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u0010%R\u0016\u0010:\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b9\u0010%R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\"\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00040+8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bC\u0010-\u001a\u0004\bD\u0010/R\"\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00020+8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bF\u0010-\u001a\u0004\bG\u0010/R\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010N\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010%R\"\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00040+8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bO\u0010-\u001a\u0004\bP\u0010/R\u0016\u0010S\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010=R\"\u0010V\u001a\b\u0012\u0004\u0012\u00020\u00040+8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bT\u0010-\u001a\u0004\bU\u0010/R\"\u0010Y\u001a\b\u0012\u0004\u0012\u00020\n0+8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bW\u0010-\u001a\u0004\bX\u0010/R\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010_\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010AR\"\u0010b\u001a\b\u0012\u0004\u0012\u00020\u00040+8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b`\u0010-\u001a\u0004\ba\u0010/R\u0016\u0010d\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010%¨\u0006i"}, d2 = {"Lcom/avito/android/profile/password_change/PasswordChangeViewImpl;", "Lcom/avito/android/profile/password_change/PasswordChangeView;", "", "oldPassword", "", "fillOldPassword", "(Ljava/lang/String;)V", "highlightOldPassword", "()V", "highlightNewPassword", "", "isHidden", "setOldPasswordInputHidden", "(Z)V", "setNewPasswordInputHidden", "error", "showOldPasswordError", "showNewPasswordError", "enabled", "setButtonEnabled", "showProgress", "hideProgress", "showButtonProgress", "hideButtonProgress", "onDestroyView", "message", "showSnackbar", PlatformActions.HIDE_KEYBOARD, "showViewsForSessionsFlow", "hideViewsForSessionsFlow", "scrollToBottom", "Lio/reactivex/disposables/CompositeDisposable;", "l", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Landroid/view/View;", "k", "Landroid/view/View;", "descriptionView", "Lcom/avito/android/lib/design/button/Button;", "f", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Lio/reactivex/Observable;", "s", "Lio/reactivex/Observable;", "getOldPasswordChanges", "()Lio/reactivex/Observable;", "oldPasswordChanges", AuthSource.OPEN_CHANNEL_LIST, "getNavigationClicks", "navigationClicks", "r", "getForgotPasswordClicks", "forgotPasswordClicks", "i", "progressView", a2.g.r.g.a, "buttonContainer", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "e", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "containerNewPassword", "Lcom/avito/android/lib/design/input/Input;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/input/Input;", "inputNewPassword", "p", "getOldPasswordIconClicks", "oldPasswordIconClicks", "t", "getNewPasswordChanges", "newPasswordChanges", "Landroidx/appcompat/widget/Toolbar;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/widget/Toolbar;", "toolbar", VKApiConst.VERSION, "view", "o", "getActionDoneClicks", "actionDoneClicks", "d", "containerOldPassword", VKApiConst.Q, "getNewPasswordIconClicks", "newPasswordIconClicks", "u", "getKeyboardVisibilityChanges", "keyboardVisibilityChanges", "Landroidx/core/widget/NestedScrollView;", "h", "Landroidx/core/widget/NestedScrollView;", "scrollView", "c", "inputOldPassword", "n", "getButtonClicks", "buttonClicks", "j", "forgotPasswordView", "Landroid/app/Activity;", "activity", "<init>", "(Landroid/view/View;Landroid/app/Activity;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class PasswordChangeViewImpl implements PasswordChangeView {
    public final Toolbar a;
    public final Input b;
    public final Input c;
    public final ComponentContainer d;
    public final ComponentContainer e;
    public final Button f;
    public final View g;
    public final NestedScrollView h;
    public final View i;
    public final View j;
    public final View k;
    public final CompositeDisposable l;
    @NotNull
    public final Observable<Unit> m;
    @NotNull
    public final Observable<Unit> n;
    @NotNull
    public final Observable<Unit> o;
    @NotNull
    public final Observable<Unit> p;
    @NotNull
    public final Observable<Unit> q;
    @NotNull
    public final Observable<Unit> r;
    @NotNull
    public final Observable<String> s;
    @NotNull
    public final Observable<String> t;
    @NotNull
    public final Observable<Boolean> u;
    public final View v;

    /* compiled from: java-style lambda group */
    public static final class a<T> implements Predicate<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public a(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public final boolean test(Unit unit) {
            int i = this.a;
            if (i == 0) {
                Intrinsics.checkNotNullParameter(unit, "it");
                if (((PasswordChangeViewImpl) this.b).g.getHeight() > 0) {
                    return true;
                }
                return false;
            } else if (i == 1) {
                Intrinsics.checkNotNullParameter(unit, "it");
                return ((PasswordChangeViewImpl) this.b).f.isEnabled();
            } else {
                throw null;
            }
        }
    }

    public static final class b<T, R> implements Function<Unit, Integer> {
        public final /* synthetic */ PasswordChangeViewImpl a;

        public b(PasswordChangeViewImpl passwordChangeViewImpl) {
            this.a = passwordChangeViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Integer apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return Integer.valueOf(Views.heightWithMargins(this.a.g));
        }
    }

    public static final class c<T> implements Consumer<Integer> {
        public final /* synthetic */ PasswordChangeViewImpl a;

        public c(PasswordChangeViewImpl passwordChangeViewImpl) {
            this.a = passwordChangeViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Integer num) {
            Integer num2 = num;
            NestedScrollView nestedScrollView = this.a.h;
            Intrinsics.checkNotNullExpressionValue(num2, "it");
            Views.changePadding$default(nestedScrollView, 0, 0, 0, num2.intValue(), 7, null);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public static final d a = new d();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error(th);
        }
    }

    public static final class g implements Runnable {
        public final /* synthetic */ PasswordChangeViewImpl a;

        public g(PasswordChangeViewImpl passwordChangeViewImpl) {
            this.a = passwordChangeViewImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.h.fullScroll(130);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [a2.a.a.b2.f1.o] */
    /* JADX WARN: Type inference failed for: r2v4, types: [a2.a.a.b2.f1.o] */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PasswordChangeViewImpl(@org.jetbrains.annotations.NotNull android.view.View r10, @org.jetbrains.annotations.NotNull android.app.Activity r11) {
        /*
        // Method dump skipped, instructions count: 370
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.profile.password_change.PasswordChangeViewImpl.<init>(android.view.View, android.app.Activity):void");
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    public void fillOldPassword(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "oldPassword");
        Input.setText$default(this.c, str, false, 2, null);
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    @NotNull
    public Observable<Unit> getActionDoneClicks() {
        return this.o;
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    @NotNull
    public Observable<Unit> getButtonClicks() {
        return this.n;
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    @NotNull
    public Observable<Unit> getForgotPasswordClicks() {
        return this.r;
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    @NotNull
    public Observable<Boolean> getKeyboardVisibilityChanges() {
        return this.u;
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    @NotNull
    public Observable<Unit> getNavigationClicks() {
        return this.m;
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    @NotNull
    public Observable<String> getNewPasswordChanges() {
        return this.t;
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    @NotNull
    public Observable<Unit> getNewPasswordIconClicks() {
        return this.q;
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    @NotNull
    public Observable<String> getOldPasswordChanges() {
        return this.s;
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    @NotNull
    public Observable<Unit> getOldPasswordIconClicks() {
        return this.p;
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    public void hideButtonProgress() {
        this.f.setLoading(false);
        this.f.setClickable(true);
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    public void hideKeyboard() {
        Keyboards.hideKeyboard$default(this.v, false, 1, null);
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    public void hideProgress() {
        Views.hide(this.i);
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    public void hideViewsForSessionsFlow() {
        Views.hide(this.j);
        Views.hide(this.k);
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    public void highlightNewPassword() {
        this.b.showKeyboard();
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    public void highlightOldPassword() {
        this.c.showKeyboard();
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    public void onDestroyView() {
        Keyboards.hideKeyboard$default(this.v, false, 1, null);
        this.l.clear();
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    public void scrollToBottom() {
        this.h.post(new g(this));
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    public void setButtonEnabled(boolean z) {
        this.f.setEnabled(z);
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    public void setNewPasswordInputHidden(boolean z) {
        InputsKt.togglePasswordHiddenOptions(this.b, z);
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    public void setOldPasswordInputHidden(boolean z) {
        InputsKt.togglePasswordHiddenOptions(this.c, z);
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    public void showButtonProgress() {
        this.f.setLoading(true);
        this.f.setClickable(false);
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    public void showNewPasswordError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        ComponentContainer.showErrorForAll$default(this.e, str, null, 2, null);
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    public void showOldPasswordError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        ComponentContainer.showErrorForAll$default(this.d, str, null, 2, null);
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    public void showProgress() {
        Views.show(this.i);
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    public void showSnackbar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.v, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }

    @Override // com.avito.android.profile.password_change.PasswordChangeView
    public void showViewsForSessionsFlow() {
        Views.show(this.j);
        Views.show(this.k);
    }
}
