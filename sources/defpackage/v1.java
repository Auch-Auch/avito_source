package defpackage;

import com.avito.android.spare_parts.bottom_sheet.SparePartsBottomSheetViewImpl;
import io.reactivex.rxjava3.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: v1  reason: default package */
public final class v1<T> implements Consumer<Throwable> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public v1(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public final void accept(Throwable th) {
        int i = this.a;
        if (i == 0) {
            ((SparePartsBottomSheetViewImpl) this.b).c();
        } else if (i == 1) {
            ((SparePartsBottomSheetViewImpl) this.b).c();
        } else {
            throw null;
        }
    }
}
