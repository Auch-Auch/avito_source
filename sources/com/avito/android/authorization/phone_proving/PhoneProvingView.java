package com.avito.android.authorization.phone_proving;

import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0005J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H&¢\u0006\u0004\b\b\u0010\u0005J\u0017\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u000f\u0010\u000bJ\u000f\u0010\u0010\u001a\u00020\u0003H&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0007H&¢\u0006\u0004\b\u0013\u0010\u000bJ\u000f\u0010\u0014\u001a\u00020\u0003H&¢\u0006\u0004\b\u0014\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\u0003H&¢\u0006\u0004\b\u0015\u0010\u0011J\u000f\u0010\u0016\u001a\u00020\u0003H&¢\u0006\u0004\b\u0016\u0010\u0011J\u000f\u0010\u0017\u001a\u00020\u0003H&¢\u0006\u0004\b\u0017\u0010\u0011J\u0017\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0003H&¢\u0006\u0004\b\u001c\u0010\u0011J2\u0010#\u001a\u00020\u00032!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00030\u001dH&¢\u0006\u0004\b#\u0010$J\u0015\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0002H\u0016¢\u0006\u0004\b%\u0010\u0005J\u0015\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b&\u0010\u0005¨\u0006'"}, d2 = {"Lcom/avito/android/authorization/phone_proving/PhoneProvingView;", "", "Lio/reactivex/Observable;", "", "proveClicks", "()Lio/reactivex/Observable;", "navigationClicks", "", "phoneEndingChanged", "phonePart", "setPhoneStarting", "(Ljava/lang/String;)V", "hint", "setInputHint", "message", "showPhoneError", "hidePhoneError", "()V", "error", "showError", "showUnknownError", "showProgress", "hideProgress", PlatformActions.HIDE_KEYBOARD, "", "enabled", "setProveButtonEnabled", "(Z)V", "requestFieldFocus", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "actionId", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "(Lkotlin/jvm/functions/Function1;)V", "actionCallbacks", "doneCallbacks", "authorization_release"}, k = 1, mv = {1, 4, 2})
public interface PhoneProvingView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {

        public static final class a<T> implements ObservableOnSubscribe<Integer> {
            public final /* synthetic */ PhoneProvingView a;

            /* renamed from: com.avito.android.authorization.phone_proving.PhoneProvingView$DefaultImpls$a$a  reason: collision with other inner class name */
            public static final class C0133a extends Lambda implements Function1<Integer, Unit> {
                public final /* synthetic */ ObservableEmitter a;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                public C0133a(ObservableEmitter observableEmitter) {
                    super(1);
                    this.a = observableEmitter;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.ObservableEmitter */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // kotlin.jvm.functions.Function1
                public Unit invoke(Integer num) {
                    this.a.onNext(Integer.valueOf(num.intValue()));
                    return Unit.INSTANCE;
                }
            }

            public a(PhoneProvingView phoneProvingView) {
                this.a = phoneProvingView;
            }

            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(@NotNull ObservableEmitter<Integer> observableEmitter) {
                Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
                this.a.setActionListener(new C0133a(observableEmitter));
            }
        }

        public static final class b<T> implements Predicate<Integer> {
            public static final b a = new b();

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Predicate
            public boolean test(Integer num) {
                Integer num2 = num;
                Intrinsics.checkNotNullParameter(num2, "it");
                return num2.intValue() == 6;
            }
        }

        public static final class c<T, R> implements Function<Integer, Unit> {
            public static final c a = new c();

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.functions.Function
            public Unit apply(Integer num) {
                Intrinsics.checkNotNullParameter(num, "it");
                return Unit.INSTANCE;
            }
        }

        @NotNull
        public static Observable<Integer> actionCallbacks(@NotNull PhoneProvingView phoneProvingView) {
            Observable<Integer> create = Observable.create(new a(phoneProvingView));
            Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…mitter.onNext(it) }\n    }");
            return create;
        }

        @NotNull
        public static Observable<Unit> doneCallbacks(@NotNull PhoneProvingView phoneProvingView) {
            Observable<R> map = phoneProvingView.actionCallbacks().filter(b.a).map(c.a);
            Intrinsics.checkNotNullExpressionValue(map, "actionCallbacks()\n      …E }\n        .map { Unit }");
            return map;
        }
    }

    @NotNull
    Observable<Integer> actionCallbacks();

    @NotNull
    Observable<Unit> doneCallbacks();

    void hideKeyboard();

    void hidePhoneError();

    void hideProgress();

    @NotNull
    Observable<Unit> navigationClicks();

    @NotNull
    Observable<String> phoneEndingChanged();

    @NotNull
    Observable<Unit> proveClicks();

    void requestFieldFocus();

    void setActionListener(@NotNull Function1<? super Integer, Unit> function1);

    void setInputHint(@NotNull String str);

    void setPhoneStarting(@NotNull String str);

    void setProveButtonEnabled(boolean z);

    void showError(@NotNull String str);

    void showPhoneError(@Nullable String str);

    void showProgress();

    void showUnknownError();
}
