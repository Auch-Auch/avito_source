package com.avito.android.profile;

import android.view.KeyEvent;
import android.widget.TextView;
import com.avito.android.lib.design.input.Input;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Cancellable;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class InputsKt$actionButtonClicks$1<T> implements ObservableOnSubscribe<Unit> {
    public final /* synthetic */ Input a;

    public static final class a implements Cancellable {
        public final /* synthetic */ InputsKt$actionButtonClicks$1 a;

        public a(InputsKt$actionButtonClicks$1 inputsKt$actionButtonClicks$1) {
            this.a = inputsKt$actionButtonClicks$1;
        }

        @Override // io.reactivex.functions.Cancellable
        public final void cancel() {
            this.a.a.setOnEditorActionListener(null);
        }
    }

    public InputsKt$actionButtonClicks$1(Input input) {
        this.a = input;
    }

    @Override // io.reactivex.ObservableOnSubscribe
    public final void subscribe(@NotNull final ObservableEmitter<Unit> observableEmitter) {
        Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
        observableEmitter.setCancellable(new a(this));
        this.a.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: com.avito.android.profile.InputsKt$actionButtonClicks$1.2
            /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: io.reactivex.ObservableEmitter */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // android.widget.TextView.OnEditorActionListener
            public boolean onEditorAction(@Nullable TextView textView, int i, @Nullable KeyEvent keyEvent) {
                if (i != 6) {
                    return false;
                }
                observableEmitter.onNext(Unit.INSTANCE);
                return true;
            }
        });
    }
}
