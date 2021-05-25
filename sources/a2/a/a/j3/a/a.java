package a2.a.a.j3.a;

import com.avito.android.deep_linking.links.DetailsSheetLinkBody;
import com.avito.android.user_adverts_common.safety.SafetyInfoProviderImpl;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<DetailsSheetLinkBody, MaybeSource<? extends DetailsSheetLinkBody>> {
    public final /* synthetic */ SafetyInfoProviderImpl.b a;

    public a(SafetyInfoProviderImpl.b bVar) {
        this.a = bVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public MaybeSource<? extends DetailsSheetLinkBody> apply(DetailsSheetLinkBody detailsSheetLinkBody) {
        DetailsSheetLinkBody detailsSheetLinkBody2 = detailsSheetLinkBody;
        SafetyInfoProviderImpl safetyInfoProviderImpl = this.a.a;
        Intrinsics.checkNotNullExpressionValue(detailsSheetLinkBody2, "result");
        if (SafetyInfoProviderImpl.access$isEmpty(safetyInfoProviderImpl, detailsSheetLinkBody2)) {
            return Maybe.empty();
        }
        return Maybe.just(detailsSheetLinkBody2);
    }
}
