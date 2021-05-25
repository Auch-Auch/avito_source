package a2.a.a.f.y;

import com.avito.android.advert.notes.EditAdvertNotePresenterImpl;
import com.avito.android.advert.notes.EditAdvertNoteView;
import com.avito.android.advert_details.R;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class j<T> implements Consumer<Boolean> {
    public final /* synthetic */ EditAdvertNotePresenterImpl a;
    public final /* synthetic */ String b;

    public j(EditAdvertNotePresenterImpl editAdvertNotePresenterImpl, String str) {
        this.a = editAdvertNotePresenterImpl;
        this.b = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Boolean bool) {
        EditAdvertNoteView editAdvertNoteView;
        Boolean bool2 = bool;
        Intrinsics.checkNotNullExpressionValue(bool2, "needShowToast");
        if (bool2.booleanValue() && (editAdvertNoteView = this.a.c) != null) {
            editAdvertNoteView.showToast(R.string.advert_added_to_fav);
        }
        EditAdvertNotePresenterImpl.a(this.a, this.b, false, 2);
    }
}
