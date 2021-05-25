package a7.c.a.a.n.g;

import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.sravni.android.bankproduct.network.scoring.response.ScoringResponse;
public final class a<T, R> implements Function<T, R> {
    public static final a a = new a();

    @Override // io.reactivex.functions.Function
    public Object apply(Object obj) {
        ScoringResponse scoringResponse = (ScoringResponse) obj;
        Intrinsics.checkParameterIsNotNull(scoringResponse, "it");
        return scoringResponse.getItem().toScoringRepo();
    }
}
