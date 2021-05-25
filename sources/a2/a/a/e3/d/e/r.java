package a2.a.a.e3.d.e;

import com.avito.android.remote.model.change.TariffAutoProlongResult;
import com.avito.android.tariff.edit_info.viewmodel.EditInfoViewModelImpl;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class r<T> implements Consumer<LoadingState<? super TariffAutoProlongResult>> {
    public final /* synthetic */ EditInfoViewModelImpl a;
    public final /* synthetic */ boolean b;

    public r(EditInfoViewModelImpl editInfoViewModelImpl, boolean z) {
        this.a = editInfoViewModelImpl;
        this.b = z;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(LoadingState<? super TariffAutoProlongResult> loadingState) {
        LoadingState<? super TariffAutoProlongResult> loadingState2 = loadingState;
        EditInfoViewModelImpl editInfoViewModelImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
        EditInfoViewModelImpl.access$handleLoadingResult(editInfoViewModelImpl, loadingState2, this.b);
    }
}
