package a2.j.d.l.a;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.ServiceManager;
import java.util.Map;
public class b0 implements Function<Map.Entry<Service, Long>, Long> {
    public b0(ServiceManager.f fVar) {
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.common.base.Function
    public Long apply(Map.Entry<Service, Long> entry) {
        return entry.getValue();
    }
}
