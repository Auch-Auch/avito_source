package a2.a.a.i2.a.a;

import com.avito.android.remote.model.PretendErrorValue;
import com.avito.android.remote.model.PretendResult;
import com.avito.android.util.Collections;
import io.reactivex.functions.Function;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import t6.n.q;
public final class h<T, R> implements Function<PretendResult, Map<String, ? extends String>> {
    public static final h a = new h();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Map<String, ? extends String> apply(PretendResult pretendResult) {
        PretendResult pretendResult2 = pretendResult;
        Intrinsics.checkNotNullParameter(pretendResult2, "it");
        Map<String, PretendErrorValue> errors = pretendResult2.getErrors();
        LinkedHashMap linkedHashMap = new LinkedHashMap(q.mapCapacity(errors.size()));
        for (T t : errors.entrySet()) {
            linkedHashMap.put(t.getKey(), ((PretendErrorValue) t.getValue()).getSingleMessage());
        }
        return Collections.filterValuesNotNull(linkedHashMap);
    }
}
