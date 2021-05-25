package a2.a.a.k0.d;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.avito.android.delivery.suggest.DeliveryLocationSuggestFragment;
import com.avito.android.util.Keyboards;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Unit;
public final class a<T> implements Consumer<Unit> {
    public final /* synthetic */ DeliveryLocationSuggestFragment a;

    public a(DeliveryLocationSuggestFragment deliveryLocationSuggestFragment) {
        this.a = deliveryLocationSuggestFragment;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Unit unit) {
        View view = this.a.getView();
        if (view != null) {
            Keyboards.hideKeyboard$default(view, false, 1, null);
        }
        FragmentActivity activity = this.a.getActivity();
        if (activity != null) {
            activity.setResult(0);
            activity.finish();
        }
    }
}
