package a2.g.k;

import com.facebook.appevents.AppEvent;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
@AutoHandleExceptions
public class s implements Serializable {
    private static final long serialVersionUID = 20160629001L;
    public HashMap<a, List<AppEvent>> a;

    public static class b implements Serializable {
        private static final long serialVersionUID = 20160629001L;
        public final HashMap<a, List<AppEvent>> a;

        public b(HashMap hashMap, a aVar) {
            this.a = hashMap;
        }

        private Object readResolve() {
            return new s(this.a);
        }
    }

    public s() {
        this.a = new HashMap<>();
    }

    private Object writeReplace() {
        return new b(this.a, null);
    }

    public void a(a aVar, List<AppEvent> list) {
        if (!this.a.containsKey(aVar)) {
            this.a.put(aVar, list);
        } else {
            this.a.get(aVar).addAll(list);
        }
    }

    public s(HashMap<a, List<AppEvent>> hashMap) {
        HashMap<a, List<AppEvent>> hashMap2 = new HashMap<>();
        this.a = hashMap2;
        hashMap2.putAll(hashMap);
    }
}
