package defpackage;

import com.avito.android.advert.notes.EditAdvertNotePresenterImpl;
import com.avito.android.advert.notes.EditAdvertNoteView;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: s3  reason: default package */
public final class s3<T> implements Consumer<String> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public s3(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(String str) {
        int i = this.a;
        if (i == 0) {
            ((EditAdvertNotePresenterImpl) this.b).e = str;
        } else if (i == 1) {
            String str2 = str;
            EditAdvertNoteView editAdvertNoteView = ((EditAdvertNotePresenterImpl) this.b).c;
            if (editAdvertNoteView != null) {
                Intrinsics.checkNotNullExpressionValue(str2, "it");
                editAdvertNoteView.setMenuItemEnabled(EditAdvertNotePresenterImpl.access$isDataChanged((EditAdvertNotePresenterImpl) this.b, str2));
            }
        } else {
            throw null;
        }
    }
}
