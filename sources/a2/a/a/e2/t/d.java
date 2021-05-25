package a2.a.a.e2.t;

import com.avito.android.remote.model.category_parameters.AttributeNode;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class d extends Lambda implements Function1<AttributeNode, Boolean> {
    public final /* synthetic */ AttributeNode a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(AttributeNode attributeNode) {
        super(1);
        this.a = attributeNode;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(AttributeNode attributeNode) {
        AttributeNode attributeNode2 = attributeNode;
        Intrinsics.checkNotNullParameter(attributeNode2, "it");
        return Boolean.valueOf(Intrinsics.areEqual(attributeNode2.getId(), this.a.getId()));
    }
}
