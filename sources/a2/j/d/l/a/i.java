package a2.j.d.l.a;

import com.google.common.base.Function;
import com.google.common.util.concurrent.AtomicLongMap;
import java.util.concurrent.atomic.AtomicLong;
public class i implements Function<AtomicLong, Long> {
    public i(AtomicLongMap atomicLongMap) {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.common.base.Function
    public Long apply(AtomicLong atomicLong) {
        return Long.valueOf(atomicLong.get());
    }
}
