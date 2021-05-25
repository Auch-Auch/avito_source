package a2.a.a.f.y;

import com.avito.android.advert.notes.EditAdvertNotePresenterImpl;
import com.avito.android.advert.notes.EditAdvertNoteScreenNavigation;
import com.avito.android.advert.notes.EditAdvertNoteView;
import io.reactivex.rxjava3.functions.Consumer;
public final class g<T> implements Consumer<EditAdvertNoteScreenNavigation> {
    public final /* synthetic */ EditAdvertNotePresenterImpl a;

    public g(EditAdvertNotePresenterImpl editAdvertNotePresenterImpl) {
        this.a = editAdvertNotePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(EditAdvertNoteScreenNavigation editAdvertNoteScreenNavigation) {
        String str;
        EditAdvertNoteScreenNavigation editAdvertNoteScreenNavigation2 = editAdvertNoteScreenNavigation;
        EditAdvertNoteView editAdvertNoteView = this.a.c;
        if (editAdvertNoteView != null) {
            editAdvertNoteView.hideKeyboard();
        }
        if (editAdvertNoteScreenNavigation2 instanceof EditAdvertNoteScreenNavigation.Back) {
            EditAdvertNotePresenterImpl.a(this.a, null, false, 1);
        } else if ((editAdvertNoteScreenNavigation2 instanceof EditAdvertNoteScreenNavigation.SaveNote) && (str = this.a.e) != null) {
            EditAdvertNotePresenterImpl.access$saveNote(this.a, str);
        }
    }
}
