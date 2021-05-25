package a2.a.a.n2;

import com.avito.android.home.appending_item.loader.AppendingLoaderItem;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class q extends Lambda implements Function1<ViewTypeSerpItem, Boolean> {
    public static final q a = new q();

    public q() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(ViewTypeSerpItem viewTypeSerpItem) {
        ViewTypeSerpItem viewTypeSerpItem2 = viewTypeSerpItem;
        Intrinsics.checkNotNullParameter(viewTypeSerpItem2, "it");
        return Boolean.valueOf(!(viewTypeSerpItem2 instanceof AppendingLoaderItem));
    }
}
