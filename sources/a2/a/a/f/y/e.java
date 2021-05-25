package a2.a.a.f.y;

import com.avito.android.advert.notes.EditAdvertNotePresenterImpl;
import com.avito.android.advert.notes.EditAdvertNoteView;
import com.avito.android.advert.notes.UpdateAdvertNoteResult;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
public final class e<T> implements Consumer<LoadingState<? super UpdateAdvertNoteResult>> {
    public final /* synthetic */ EditAdvertNotePresenterImpl a;
    public final /* synthetic */ String b;

    public e(EditAdvertNotePresenterImpl editAdvertNotePresenterImpl, String str) {
        this.a = editAdvertNotePresenterImpl;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super UpdateAdvertNoteResult> loadingState) {
        EditAdvertNoteView editAdvertNoteView;
        LoadingState<? super UpdateAdvertNoteResult> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loading) {
            EditAdvertNoteView editAdvertNoteView2 = this.a.c;
            if (editAdvertNoteView2 != null) {
                editAdvertNoteView2.startLoad();
            }
        } else if (loadingState2 instanceof LoadingState.Loaded) {
            if (((UpdateAdvertNoteResult) ((LoadingState.Loaded) loadingState2).getData()).ordinal() != 0) {
                EditAdvertNotePresenterImpl.a(this.a, this.b, false, 2);
            } else {
                EditAdvertNotePresenterImpl.access$updateFavoriteState(this.a, this.b);
            }
        } else if ((loadingState2 instanceof LoadingState.Error) && (editAdvertNoteView = this.a.c) != null) {
            editAdvertNoteView.showError();
        }
    }
}
