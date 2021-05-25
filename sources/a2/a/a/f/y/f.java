package a2.a.a.f.y;

import com.avito.android.advert.notes.EditAdvertNotePresenterImpl;
import com.avito.android.advert.notes.EditAdvertNoteView;
import io.reactivex.rxjava3.functions.Consumer;
public final class f<T> implements Consumer<Throwable> {
    public final /* synthetic */ EditAdvertNotePresenterImpl a;

    public f(EditAdvertNotePresenterImpl editAdvertNotePresenterImpl) {
        this.a = editAdvertNotePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Throwable th) {
        EditAdvertNoteView editAdvertNoteView = this.a.c;
        if (editAdvertNoteView != null) {
            editAdvertNoteView.showError();
        }
    }
}
