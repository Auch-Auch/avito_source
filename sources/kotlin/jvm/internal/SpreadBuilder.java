package kotlin.jvm.internal;

import a2.b.a.a.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
public class SpreadBuilder {
    public final ArrayList<Object> a;

    public SpreadBuilder(int i) {
        this.a = new ArrayList<>(i);
    }

    public void add(Object obj) {
        this.a.add(obj);
    }

    public void addSpread(Object obj) {
        if (obj != null) {
            if (obj instanceof Object[]) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length > 0) {
                    ArrayList<Object> arrayList = this.a;
                    arrayList.ensureCapacity(arrayList.size() + objArr.length);
                    Collections.addAll(this.a, objArr);
                }
            } else if (obj instanceof Collection) {
                this.a.addAll((Collection) obj);
            } else if (obj instanceof Iterable) {
                for (Object obj2 : (Iterable) obj) {
                    this.a.add(obj2);
                }
            } else if (obj instanceof Iterator) {
                Iterator it = (Iterator) obj;
                while (it.hasNext()) {
                    this.a.add(it.next());
                }
            } else {
                StringBuilder L = a.L("Don't know how to spread ");
                L.append(obj.getClass());
                throw new UnsupportedOperationException(L.toString());
            }
        }
    }

    public int size() {
        return this.a.size();
    }

    public Object[] toArray(Object[] objArr) {
        return this.a.toArray(objArr);
    }
}
