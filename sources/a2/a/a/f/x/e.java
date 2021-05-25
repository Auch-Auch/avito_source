package a2.a.a.f.x;

import com.avito.android.advert_core.advert.AdvertDetailsItem;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class e extends Lambda implements Function1<Integer, Long> {
    public static final e a = new e();

    public e() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Long invoke(Integer num) {
        int intValue = num.intValue();
        AdvertDetailsItem.values();
        return Long.valueOf((long) (intValue + 73));
    }
}
