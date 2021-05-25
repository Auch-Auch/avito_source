package com.avito.android.profile;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import com.avito.android.lib.design.avito.R;
import com.avito.android.lib.design.input.Input;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Cancellable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006*\u00020\u0000H\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006*\u00020\u0000H\u0000¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/lib/design/input/Input;", "", "inputHidden", "", "togglePasswordHiddenOptions", "(Lcom/avito/android/lib/design/input/Input;Z)V", "Lio/reactivex/Observable;", "rightButtonClicks", "(Lcom/avito/android/lib/design/input/Input;)Lio/reactivex/Observable;", "actionButtonClicks", "profile_release"}, k = 2, mv = {1, 4, 2})
public final class InputsKt {

    public static final class a<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ Input a;

        /* renamed from: com.avito.android.profile.InputsKt$a$a  reason: collision with other inner class name */
        public static final class C0148a implements Cancellable {
            public final /* synthetic */ a a;

            public C0148a(a aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.functions.Cancellable
            public final void cancel() {
                this.a.a.setRightIconListener(null);
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

        public a(Input input) {
            this.a = input;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(@NotNull ObservableEmitter<Unit> observableEmitter) {
            Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
            observableEmitter.setCancellable(new C0148a(this));
            this.a.setRightIconListener(new b(observableEmitter));
        }
    }

    @NotNull
    public static final Observable<Unit> actionButtonClicks(@NotNull Input input) {
        Intrinsics.checkNotNullParameter(input, "$this$actionButtonClicks");
        Observable<Unit> create = Observable.create(new InputsKt$actionButtonClicks$1(input));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create<Unit> …       }\n        })\n    }");
        return create;
    }

    @NotNull
    public static final Observable<Unit> rightButtonClicks(@NotNull Input input) {
        Intrinsics.checkNotNullParameter(input, "$this$rightButtonClicks");
        Observable<Unit> create = Observable.create(new a(input));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create<Unit> …xt(Unit)\n        })\n    }");
        return create;
    }

    public static final void togglePasswordHiddenOptions(@NotNull Input input, boolean z) {
        Intrinsics.checkNotNullParameter(input, "$this$togglePasswordHiddenOptions");
        if (z) {
            input.setRightIcon(R.drawable.ic_password_hide);
            PasswordTransformationMethod instance = PasswordTransformationMethod.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "PasswordTransformationMethod.getInstance()");
            input.setTransformationMethod(instance);
            return;
        }
        input.setRightIcon(R.drawable.ic_password_show);
        HideReturnsTransformationMethod instance2 = HideReturnsTransformationMethod.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance2, "HideReturnsTransformationMethod.getInstance()");
        input.setTransformationMethod(instance2);
    }
}
