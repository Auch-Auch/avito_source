package com.avito.android.profile.password_setting;

import a2.g.r.g;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00109\u001a\u00020\u0018¢\u0006\u0004\bB\u0010CJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\nJ\u000f\u0010\u0013\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0013\u0010\u000eR\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\"\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\"\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b(\u0010 \u001a\u0004\b)\u0010\"R\"\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b+\u0010 \u001a\u0004\b,\u0010\"R\"\u00100\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b.\u0010 \u001a\u0004\b/\u0010\"R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\"\u00107\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b5\u0010 \u001a\u0004\b6\u0010\"R\u0016\u00109\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u0010\u001aR\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010@¨\u0006D"}, d2 = {"Lcom/avito/android/profile/password_setting/PasswordSettingViewImpl;", "Lcom/avito/android/profile/password_setting/PasswordSettingView;", "", "isHidden", "", "setPasswordInputHidden", "(Z)V", "", "error", "showPasswordError", "(Ljava/lang/String;)V", "enabled", "setButtonEnabled", "showButtonProgress", "()V", "hideButtonProgress", "onDestroyView", "message", "showSnackbar", PlatformActions.HIDE_KEYBOARD, "Lcom/avito/android/lib/design/button/Button;", "d", "Lcom/avito/android/lib/design/button/Button;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Landroid/view/View;", "e", "Landroid/view/View;", "buttonContainer", "f", "scrollView", "Lio/reactivex/Observable;", "l", "Lio/reactivex/Observable;", "getPasswordChanges", "()Lio/reactivex/Observable;", "passwordChanges", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "c", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "containerPassword", "j", "getActionDoneClicks", "actionDoneClicks", "i", "getButtonClicks", "buttonClicks", "h", "getNavigationClicks", "navigationClicks", "Lio/reactivex/disposables/CompositeDisposable;", g.a, "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "k", "getPasswordIconClicks", "passwordIconClicks", AuthSource.OPEN_CHANNEL_LIST, "view", "Lcom/avito/android/lib/design/input/Input;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/input/Input;", "inputPassword", "Landroidx/appcompat/widget/Toolbar;", AuthSource.SEND_ABUSE, "Landroidx/appcompat/widget/Toolbar;", "toolbar", "<init>", "(Landroid/view/View;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class PasswordSettingViewImpl implements PasswordSettingView {
    public final Toolbar a;
    public final Input b;
    public final ComponentContainer c;
    public final Button d;
    public final View e;
    public final View f;
    public final CompositeDisposable g;
    @NotNull
    public final Observable<Unit> h;
    @NotNull
    public final Observable<Unit> i;
    @NotNull
    public final Observable<Unit> j;
    @NotNull
    public final Observable<Unit> k;
    @NotNull
    public final Observable<String> l;
    public final View m;

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
                if (((PasswordSettingViewImpl) this.b).e.getHeight() > 0) {
                    return true;
                }
                return false;
            } else if (i == 1) {
                Intrinsics.checkNotNullParameter(unit, "it");
                return ((PasswordSettingViewImpl) this.b).d.isEnabled();
            } else {
                throw null;
            }
        }
    }

    public static final class b<T, R> implements Function<Unit, Integer> {
        public final /* synthetic */ PasswordSettingViewImpl a;

        public b(PasswordSettingViewImpl passwordSettingViewImpl) {
            this.a = passwordSettingViewImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Integer apply(Unit unit) {
            Intrinsics.checkNotNullParameter(unit, "it");
            return Integer.valueOf(Views.heightWithMargins(this.a.e));
        }
    }

    public static final class c<T> implements Consumer<Integer> {
        public final /* synthetic */ PasswordSettingViewImpl a;

        public c(PasswordSettingViewImpl passwordSettingViewImpl) {
            this.a = passwordSettingViewImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Integer num) {
            Integer num2 = num;
            View view = this.a.f;
            Intrinsics.checkNotNullExpressionValue(num2, "it");
            Views.changePadding$default(view, 0, 0, 0, num2.intValue(), 7, null);
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [a2.a.a.b2.g1.f] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PasswordSettingViewImpl(@org.jetbrains.annotations.NotNull android.view.View r7) {
        /*
            r6 = this;
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r6.<init>()
            r6.m = r7
            int r0 = com.avito.android.profile.R.id.toolbar
            android.view.View r0 = r7.findViewById(r0)
            java.lang.String r1 = "view.findViewById(R.id.toolbar)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            androidx.appcompat.widget.Toolbar r0 = (androidx.appcompat.widget.Toolbar) r0
            r6.a = r0
            int r1 = com.avito.android.profile.R.id.input_password
            android.view.View r1 = r7.findViewById(r1)
            java.lang.String r2 = "view.findViewById(R.id.input_password)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.avito.android.lib.design.input.Input r1 = (com.avito.android.lib.design.input.Input) r1
            r6.b = r1
            int r2 = com.avito.android.profile.R.id.container_password
            android.view.View r2 = r7.findViewById(r2)
            java.lang.String r3 = "view.findViewById(R.id.container_password)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            com.avito.android.lib.design.component_container.ComponentContainer r2 = (com.avito.android.lib.design.component_container.ComponentContainer) r2
            r6.c = r2
            int r2 = com.avito.android.profile.R.id.button_add
            android.view.View r2 = r7.findViewById(r2)
            java.lang.String r3 = "view.findViewById(R.id.button_add)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            com.avito.android.lib.design.button.Button r2 = (com.avito.android.lib.design.button.Button) r2
            r6.d = r2
            int r3 = com.avito.android.profile.R.id.button_container
            android.view.View r3 = r7.findViewById(r3)
            java.lang.String r4 = "view.findViewById(R.id.button_container)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            r6.e = r3
            int r4 = com.avito.android.profile.R.id.scroll_view
            android.view.View r7 = r7.findViewById(r4)
            java.lang.String r4 = "view.findViewById(R.id.scroll_view)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r4)
            r6.f = r7
            io.reactivex.disposables.CompositeDisposable r7 = new io.reactivex.disposables.CompositeDisposable
            r7.<init>()
            r6.g = r7
            int r4 = com.avito.android.ui_components.R.drawable.ic_close_24
            r0.setNavigationIcon(r4)
            io.reactivex.Observable r3 = com.jakewharton.rxbinding3.view.RxView.layoutChanges(r3)
            com.avito.android.profile.password_setting.PasswordSettingViewImpl$a r4 = new com.avito.android.profile.password_setting.PasswordSettingViewImpl$a
            r5 = 0
            r4.<init>(r5, r6)
            io.reactivex.Observable r3 = r3.filter(r4)
            io.reactivex.Maybe r3 = r3.firstElement()
            com.avito.android.profile.password_setting.PasswordSettingViewImpl$b r4 = new com.avito.android.profile.password_setting.PasswordSettingViewImpl$b
            r4.<init>(r6)
            io.reactivex.Maybe r3 = r3.map(r4)
            com.avito.android.profile.password_setting.PasswordSettingViewImpl$c r4 = new com.avito.android.profile.password_setting.PasswordSettingViewImpl$c
            r4.<init>(r6)
            com.avito.android.profile.password_setting.PasswordSettingViewImpl$d r5 = com.avito.android.profile.password_setting.PasswordSettingViewImpl.d.a
            io.reactivex.disposables.Disposable r3 = r3.subscribe(r4, r5)
            java.lang.String r4 = "buttonContainer.layoutCh…error(it) }\n            )"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            io.reactivex.rxkotlin.DisposableKt.plusAssign(r7, r3)
            io.reactivex.rxjava3.core.Observable r7 = com.avito.android.util.Toolbars.upClicks(r0)
            io.reactivex.Observable r7 = com.avito.android.util.rx3.InteropKt.toV2(r7)
            r6.h = r7
            io.reactivex.Observable r7 = com.jakewharton.rxbinding3.view.RxView.clicks(r2)
            r6.i = r7
            io.reactivex.Observable r7 = com.avito.android.profile.InputsKt.actionButtonClicks(r1)
            com.avito.android.profile.password_setting.PasswordSettingViewImpl$a r0 = new com.avito.android.profile.password_setting.PasswordSettingViewImpl$a
            r2 = 1
            r0.<init>(r2, r6)
            io.reactivex.Observable r7 = r7.filter(r0)
            java.lang.String r0 = "inputPassword.actionButt…lter { button.isEnabled }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            r6.j = r7
            io.reactivex.Observable r7 = com.avito.android.profile.InputsKt.rightButtonClicks(r1)
            r6.k = r7
            com.jakewharton.rxbinding3.InitialValueObservable r7 = com.avito.android.lib.design.input.InputExtensionsKt.textChanges(r1)
            io.reactivex.Observable r7 = r7.skipInitialValue()
            com.avito.android.profile.password_setting.PasswordSettingViewImpl$e r0 = com.avito.android.profile.password_setting.PasswordSettingViewImpl.e.a
            if (r0 == 0) goto L_0x00d7
            a2.a.a.b2.g1.f r1 = new a2.a.a.b2.g1.f
            r1.<init>(r0)
            r0 = r1
        L_0x00d7:
            io.reactivex.functions.Function r0 = (io.reactivex.functions.Function) r0
            io.reactivex.Observable r7 = r7.map(r0)
            java.lang.String r0 = "inputPassword.textChange…p(CharSequence::toString)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            r6.l = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.profile.password_setting.PasswordSettingViewImpl.<init>(android.view.View):void");
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingView
    @NotNull
    public Observable<Unit> getActionDoneClicks() {
        return this.j;
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingView
    @NotNull
    public Observable<Unit> getButtonClicks() {
        return this.i;
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingView
    @NotNull
    public Observable<Unit> getNavigationClicks() {
        return this.h;
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingView
    @NotNull
    public Observable<String> getPasswordChanges() {
        return this.l;
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingView
    @NotNull
    public Observable<Unit> getPasswordIconClicks() {
        return this.k;
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingView
    public void hideButtonProgress() {
        this.d.setLoading(false);
        this.d.setClickable(true);
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingView
    public void hideKeyboard() {
        Keyboards.hideKeyboard$default(this.m, false, 1, null);
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingView
    public void onDestroyView() {
        Keyboards.hideKeyboard$default(this.m, false, 1, null);
        this.g.clear();
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingView
    public void setButtonEnabled(boolean z) {
        this.d.setEnabled(z);
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingView
    public void setPasswordInputHidden(boolean z) {
        InputsKt.togglePasswordHiddenOptions(this.b, z);
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingView
    public void showButtonProgress() {
        this.d.setLoading(true);
        this.d.setClickable(false);
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingView
    public void showPasswordError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        ComponentContainer.showErrorForAll$default(this.c, str, null, 2, null);
    }

    @Override // com.avito.android.profile.password_setting.PasswordSettingView
    public void showSnackbar(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Views.showSnackBar$default(this.m, str, 0, (String) null, 0, (Function0) null, (Function0) null, 0, 126, (Object) null);
    }
}
