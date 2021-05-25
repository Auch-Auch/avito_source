package com.avito.android.util;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.button.Button;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u001a\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0005\u001a\u00020\u0002*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\u0007\u001a\u00020\u0002*\u00020\u0000¢\u0006\u0004\b\u0007\u0010\u0006\u001a\u0011\u0010\b\u001a\u00020\u0002*\u00020\u0000¢\u0006\u0004\b\b\u0010\u0006\u001a\u0011\u0010\t\u001a\u00020\u0002*\u00020\u0000¢\u0006\u0004\b\t\u0010\u0006¨\u0006\n"}, d2 = {"Lru/avito/component/button/Button;", "Lio/reactivex/rxjava3/core/Observable;", "", "clicks", "(Lru/avito/component/button/Button;)Lio/reactivex/rxjava3/core/Observable;", "show", "(Lru/avito/component/button/Button;)V", "hide", "enable", "disable", "ui-components_release"}, k = 2, mv = {1, 4, 2})
public final class ButtonsKt {

    public static final class a<T> implements ObservableOnSubscribe<Unit> {
        public final /* synthetic */ Button a;

        /* renamed from: com.avito.android.util.ButtonsKt$a$a  reason: collision with other inner class name */
        public static final class C0165a implements Cancellable {
            public final /* synthetic */ a a;

            public C0165a(a aVar) {
                this.a = aVar;
            }

            @Override // io.reactivex.rxjava3.functions.Cancellable
            public final void cancel() {
                this.a.a.setClickListener(null);
            }
        }

        public static final class b extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ObservableEmitter a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(ObservableEmitter observableEmitter) {
                super(0);
                this.a = observableEmitter;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: io.reactivex.rxjava3.core.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function0
            public Unit invoke() {
                ObservableEmitter observableEmitter = this.a;
                Unit unit = Unit.INSTANCE;
                observableEmitter.onNext(unit);
                return unit;
            }
        }

        public a(Button button) {
            this.a = button;
        }

        @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
        public final void subscribe(ObservableEmitter<Unit> observableEmitter) {
            observableEmitter.setCancellable(new C0165a(this));
            this.a.setClickListener(new b(observableEmitter));
        }
    }

    @NotNull
    public static final Observable<Unit> clicks(@NotNull Button button) {
        Intrinsics.checkNotNullParameter(button, "$this$clicks");
        Observable<Unit> create = Observable.create(new a(button));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create<Unit> …tter.onNext(Unit) }\n    }");
        return create;
    }

    public static final void disable(@NotNull Button button) {
        Intrinsics.checkNotNullParameter(button, "$this$disable");
        button.setEnabled(false);
    }

    public static final void enable(@NotNull Button button) {
        Intrinsics.checkNotNullParameter(button, "$this$enable");
        button.setEnabled(true);
    }

    public static final void hide(@NotNull Button button) {
        Intrinsics.checkNotNullParameter(button, "$this$hide");
        button.setVisible(false);
    }

    public static final void show(@NotNull Button button) {
        Intrinsics.checkNotNullParameter(button, "$this$show");
        button.setVisible(true);
    }
}
