package a2.a.a.w.c;

import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.ExtraLoadingListItemsResultKt;
import com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.List;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
public final class v<T> implements Consumer<Triple<? extends ExtraLoadingListItems, ? extends List<? extends BrandspaceItem>, ? extends Throwable>> {
    public static final v a = new v();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(Triple<? extends ExtraLoadingListItems, ? extends List<? extends BrandspaceItem>, ? extends Throwable> triple) {
        Triple<? extends ExtraLoadingListItems, ? extends List<? extends BrandspaceItem>, ? extends Throwable> triple2 = triple;
        Intrinsics.checkNotNullExpressionValue(triple2, "result");
        ExtraLoadingListItemsResultKt.onError(ExtraLoadingListItemsResultKt.onSuccess(triple2, new t(triple2)), new u(triple2));
    }
}
