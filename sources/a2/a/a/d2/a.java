package a2.a.a.d2;

import com.avito.android.public_profile.adapter.error_snippet.ErrorSnippetItem;
import com.avito.android.serp.adapter.SpannedItem;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<SpannedItem, Boolean> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(SpannedItem spannedItem) {
        SpannedItem spannedItem2 = spannedItem;
        Intrinsics.checkNotNullParameter(spannedItem2, "it");
        return Boolean.valueOf(Intrinsics.areEqual(spannedItem2.getStringId(), ErrorSnippetItem.ID));
    }
}
