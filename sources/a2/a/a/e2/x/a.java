package a2.a.a.e2.x;

import com.avito.android.publish.objects.ObjectsEditInteractorImpl;
import com.avito.android.remote.model.PretendErrorValue;
import com.avito.android.remote.model.PretendResult;
import io.reactivex.functions.Function;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import t6.n.r;
public final class a<T, R> implements Function<PretendResult, PretendResult> {
    public final /* synthetic */ ObjectsEditInteractorImpl.a a;

    public a(ObjectsEditInteractorImpl.a aVar) {
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public PretendResult apply(PretendResult pretendResult) {
        Map<String, PretendErrorValue> map;
        PretendResult pretendResult2 = pretendResult;
        Intrinsics.checkNotNullParameter(pretendResult2, "result");
        PretendErrorValue.ObjectsMessages objectsMessages = (PretendErrorValue.ObjectsMessages) pretendResult2.getErrors().get(this.a.a.a.getId());
        ObjectsEditInteractorImpl objectsEditInteractorImpl = this.a.a;
        if (objectsMessages != null) {
            Map<Integer, Map<String, PretendErrorValue>> objectsErrorParams = objectsMessages.getObjectsErrorParams();
            if (objectsErrorParams == null || (map = objectsErrorParams.get(Integer.valueOf(this.a.a.d))) == null) {
                map = r.emptyMap();
            }
        } else {
            map = r.emptyMap();
        }
        return objectsEditInteractorImpl.a(map);
    }
}
