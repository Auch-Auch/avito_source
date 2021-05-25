package a2.a.a.o1.d.a0.n;

import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import t6.n.e;
public final class f<T, R> implements Function<Map<String, ? extends String>, List<? extends LocalMessage>> {
    public final /* synthetic */ List a;

    public f(List list) {
        this.a = list;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public List<? extends LocalMessage> apply(Map<String, ? extends String> map) {
        Map<String, ? extends String> map2 = map;
        Intrinsics.checkNotNullParameter(map2, "descriptions");
        List list = this.a;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            MessageBody messageBody = t.body;
            Objects.requireNonNull(messageBody, "null cannot be cast to non-null type com.avito.android.remote.model.messenger.message.MessageBody.Unknown");
            MessageBody.Unknown unknown = (MessageBody.Unknown) messageBody;
            String str = (String) map2.get(unknown.getType());
            boolean z = false;
            if (str != null) {
                if (str.length() > 0) {
                    z = true;
                }
            }
            if (z) {
                t = (T) LocalMessage.copy$default(t, null, null, null, unknown.withFallbackText(str), null, null, 0, false, false, null, null, false, null, 8183, null);
            }
            arrayList.add(t);
        }
        return arrayList;
    }
}
