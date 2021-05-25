package a2.a.a.m2;

import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.select.SelectDialogInteractorKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class i extends Lambda implements Function1<ParcelableEntity<String>, Boolean> {
    public final /* synthetic */ String a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(String str) {
        super(1);
        this.a = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(ParcelableEntity<String> parcelableEntity) {
        ParcelableEntity<String> parcelableEntity2 = parcelableEntity;
        Intrinsics.checkNotNullParameter(parcelableEntity2, "it");
        String name = parcelableEntity2.getName();
        return Boolean.valueOf(name != null && SelectDialogInteractorKt.access$matchesQuery(name, this.a));
    }
}
