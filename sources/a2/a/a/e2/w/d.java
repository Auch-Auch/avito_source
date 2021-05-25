package a2.a.a.e2.w;

import com.avito.android.publish.input_vin.InputVinFragment;
import com.avito.android.publish.input_vin.InputVinViewModel;
import com.avito.android.publish.input_vin.items.scan_button.ScanVinButtonItem;
import io.reactivex.functions.Consumer;
public final class d<T> implements Consumer<ScanVinButtonItem> {
    public final /* synthetic */ InputVinViewModel a;

    public d(InputVinFragment inputVinFragment, InputVinViewModel inputVinViewModel) {
        this.a = inputVinViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(ScanVinButtonItem scanVinButtonItem) {
        this.a.onVinScanButtonClick();
    }
}
