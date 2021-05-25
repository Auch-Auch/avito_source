package a2.a.a.e3.e.f;

import com.avito.android.remote.model.FeeMethodAction;
import com.avito.android.remote.model.FeeMethodBottomSheet;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsViewModelImpl;
import com.avito.android.tariff.fees_methods.viewmodel.HighDemandBottomSheetParams;
import com.avito.android.util.architecture_components.SingleLiveEvent;
import io.reactivex.functions.Consumer;
public final class b<T> implements Consumer<FeeMethodBottomSheet> {
    public final /* synthetic */ FeeMethodsViewModelImpl a;

    public b(FeeMethodsViewModelImpl feeMethodsViewModelImpl) {
        this.a = feeMethodsViewModelImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public void accept(FeeMethodBottomSheet feeMethodBottomSheet) {
        FeeMethodBottomSheet feeMethodBottomSheet2 = feeMethodBottomSheet;
        if (feeMethodBottomSheet2 != null) {
            SingleLiveEvent singleLiveEvent = this.a.h;
            String title = feeMethodBottomSheet2.getTitle();
            AttributedText description = feeMethodBottomSheet2.getDescription();
            FeeMethodAction primaryAction = feeMethodBottomSheet2.getPrimaryAction();
            String title2 = primaryAction != null ? primaryAction.getTitle() : null;
            FeeMethodAction secondaryAction = feeMethodBottomSheet2.getSecondaryAction();
            singleLiveEvent.setValue(new HighDemandBottomSheetParams(title, description, title2, secondaryAction != null ? secondaryAction.getTitle() : null, new l5(0, feeMethodBottomSheet2, this), new l5(1, feeMethodBottomSheet2, this)));
        }
    }
}
