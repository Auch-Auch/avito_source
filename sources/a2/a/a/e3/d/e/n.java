package a2.a.a.e3.d.e;

import com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModelImpl;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class n<T> implements Consumer<Boolean> {
    public final /* synthetic */ EditInfoViewModelImpl a;

    public n(EditInfoViewModelImpl editInfoViewModelImpl) {
        this.a = editInfoViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Boolean bool) {
        Boolean bool2 = bool;
        EditInfoViewModelImpl editInfoViewModelImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(bool2, "it");
        EditInfoViewModelImpl.access$updateProlongationState(editInfoViewModelImpl, bool2.booleanValue());
    }
}
