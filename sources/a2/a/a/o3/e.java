package a2.a.a.o3;

import com.avito.android.items.CheckBoxItem;
import com.avito.android.validation.ParametersListPresenterImpl;
import io.reactivex.functions.Consumer;
public final class e<T> implements Consumer<CheckBoxItem> {
    public final /* synthetic */ ParametersListPresenterImpl a;

    public e(ParametersListPresenterImpl parametersListPresenterImpl) {
        this.a = parametersListPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(CheckBoxItem checkBoxItem) {
        CheckBoxItem checkBoxItem2 = checkBoxItem;
        this.a.i.applyToggleValue(checkBoxItem2.getStringId(), checkBoxItem2.isChecked());
    }
}
