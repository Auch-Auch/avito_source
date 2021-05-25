package a2.a.a.e2.r;

import com.avito.android.remote.model.category_parameters.TextualTag;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
public final class d0 extends Lambda implements Function1<TextualTag, Boolean> {
    public final /* synthetic */ String a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d0(String str) {
        super(1);
        this.a = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(TextualTag textualTag) {
        TextualTag textualTag2 = textualTag;
        Intrinsics.checkNotNullParameter(textualTag2, "it");
        return Boolean.valueOf(StringsKt__StringsKt.contains$default((CharSequence) this.a, (CharSequence) textualTag2.getValue(), false, 2, (Object) null));
    }
}
