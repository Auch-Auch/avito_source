package a2.a.a.e2.w;

import com.avito.android.items.ItemWithAdditionalButton;
import com.avito.android.publish.input_vin.InputVinFragment;
import com.avito.android.publish.input_vin.InputVinViewModel;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class e<T> implements Consumer<ItemWithAdditionalButton> {
    public final /* synthetic */ InputVinViewModel a;

    public e(InputVinFragment inputVinFragment, InputVinViewModel inputVinViewModel) {
        this.a = inputVinViewModel;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(ItemWithAdditionalButton itemWithAdditionalButton) {
        ItemWithAdditionalButton itemWithAdditionalButton2 = itemWithAdditionalButton;
        InputVinViewModel inputVinViewModel = this.a;
        Intrinsics.checkNotNullExpressionValue(itemWithAdditionalButton2, "item");
        inputVinViewModel.onInputAdditionalButtonClick(itemWithAdditionalButton2);
    }
}
