package a2.a.a.a.c;

import com.avito.android.component.bottom_sheet.BottomSheetViewImpl;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import kotlin.Unit;
public final class b<T> implements ObservableOnSubscribe<Unit> {
    public final /* synthetic */ BottomSheetViewImpl.d a;

    public b(BottomSheetViewImpl.d dVar) {
        this.a = dVar;
    }

    @Override // io.reactivex.rxjava3.core.ObservableOnSubscribe
    public final void subscribe(ObservableEmitter<Unit> observableEmitter) {
        this.a.a.close();
        observableEmitter.onComplete();
    }
}
