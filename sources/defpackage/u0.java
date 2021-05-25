package defpackage;

import com.avito.android.blueprints.SelectedInfo;
import com.avito.android.publish.objects.ObjectsEditPresenterImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: java-style lambda group */
/* renamed from: u0  reason: default package */
public final class u0<T> implements Consumer<SelectedInfo> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public u0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public final void accept(SelectedInfo selectedInfo) {
        int i = this.a;
        if (i == 0) {
            SelectedInfo selectedInfo2 = selectedInfo;
            Intrinsics.checkNotNullExpressionValue(selectedInfo2, "selectInfo");
            ObjectsEditPresenterImpl.access$onValueSelected((ObjectsEditPresenterImpl) this.b, selectedInfo2);
        } else if (i == 1) {
            SelectedInfo selectedInfo3 = selectedInfo;
            Intrinsics.checkNotNullExpressionValue(selectedInfo3, "selectInfo");
            ObjectsEditPresenterImpl.access$onValueSelected((ObjectsEditPresenterImpl) this.b, selectedInfo3);
        } else if (i == 2) {
            SelectedInfo selectedInfo4 = selectedInfo;
            Intrinsics.checkNotNullExpressionValue(selectedInfo4, "selectInfo");
            ObjectsEditPresenterImpl.access$onValueSelected((ObjectsEditPresenterImpl) this.b, selectedInfo4);
        } else {
            throw null;
        }
    }
}
