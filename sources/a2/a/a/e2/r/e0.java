package a2.a.a.e2.r;

import com.avito.android.remote.model.category_parameters.TextualTag;
import com.avito.android.ui.widget.tagged_input.TagItem;
import com.avito.android.ui.widget.tagged_input.TagItemKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class e0 extends Lambda implements Function1<TextualTag, TagItem> {
    public static final e0 a = new e0();

    public e0() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public TagItem invoke(TextualTag textualTag) {
        TextualTag textualTag2 = textualTag;
        Intrinsics.checkNotNullParameter(textualTag2, "it");
        return TagItemKt.toTagItem(textualTag2);
    }
}
