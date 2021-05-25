package a2.a.a.e2.r;

import androidx.lifecycle.Observer;
import com.avito.android.publish.view.ItemDetailsViewImpl;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Observer<Integer> {
    public final /* synthetic */ ItemDetailsViewImpl a;

    public d(ItemDetailsViewImpl itemDetailsViewImpl) {
        this.a = itemDetailsViewImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // androidx.lifecycle.Observer
    public void onChanged(Integer num) {
        Integer num2 = num;
        ItemDetailsViewImpl itemDetailsViewImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(num2, "it");
        itemDetailsViewImpl.setEditorToolbarStateFlags(num2.intValue());
    }
}
