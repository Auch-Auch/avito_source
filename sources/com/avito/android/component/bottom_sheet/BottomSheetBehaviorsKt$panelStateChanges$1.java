package com.avito.android.component.bottom_sheet;

import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Cancellable;
public final class BottomSheetBehaviorsKt$panelStateChanges$1<T> implements ObservableOnSubscribe<Integer> {
    public final /* synthetic */ BottomSheetAdapter a;

    public static final class a implements Cancellable {
        public final /* synthetic */ BottomSheetBehaviorsKt$panelStateChanges$1 a;
        public final /* synthetic */ BottomSheetBehaviorsKt$panelStateChanges$1$callback$1 b;

        public a(BottomSheetBehaviorsKt$panelStateChanges$1 bottomSheetBehaviorsKt$panelStateChanges$1, BottomSheetBehaviorsKt$panelStateChanges$1$callback$1 bottomSheetBehaviorsKt$panelStateChanges$1$callback$1) {
            this.a = bottomSheetBehaviorsKt$panelStateChanges$1;
            this.b = bottomSheetBehaviorsKt$panelStateChanges$1$callback$1;
        }

        @Override // io.reactivex.rxjava3.functions.Cancellable
        public final void cancel() {
            this.a.a.removeBottomSheetCallback(this.b);
        }
    }

    public BottomSheetBehaviorsKt$panelStateChanges$1(BottomSheetAdapter bottomSheetAdapter) {
        this.a = bottomSheetAdapter;
    }

    @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Integer> observableEmitter) {
        BottomSheetBehaviorsKt$panelStateChanges$1$callback$1 bottomSheetBehaviorsKt$panelStateChanges$1$callback$1 = new BottomSheetBehaviorsKt$panelStateChanges$1$callback$1(observableEmitter);
        this.a.addBottomSheetCallback(bottomSheetBehaviorsKt$panelStateChanges$1$callback$1);
        observableEmitter.setCancellable(new a(this, bottomSheetBehaviorsKt$panelStateChanges$1$callback$1));
    }
}
