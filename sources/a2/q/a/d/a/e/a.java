package a2.q.a.d.a.e;

import com.sumsub.sns.core.data.model.Document;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<Document, CharSequence> {
    public static final a a = new a();

    public a() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public CharSequence invoke(Document document) {
        Document document2 = document;
        Intrinsics.checkNotNullParameter(document2, "it");
        return document2.getType().getValue();
    }
}
