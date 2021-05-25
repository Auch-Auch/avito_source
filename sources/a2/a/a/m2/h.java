package a2.a.a.m2;

import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.remote.model.category_parameters.SectionTitle;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class h extends Lambda implements Function1<ParcelableEntity<String>, Boolean> {
    public static final h a = new h();

    public h() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(ParcelableEntity<String> parcelableEntity) {
        ParcelableEntity<String> parcelableEntity2 = parcelableEntity;
        Intrinsics.checkNotNullParameter(parcelableEntity2, "it");
        return Boolean.valueOf(parcelableEntity2 instanceof SectionTitle);
    }
}
