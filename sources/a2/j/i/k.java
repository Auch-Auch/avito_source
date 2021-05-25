package a2.j.i;

import com.google.protobuf.FieldSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;
public final class k extends l<FieldDescriptorType, Object> {
    public k(int i) {
        super(i, null);
    }

    @Override // a2.j.i.l
    public void h() {
        if (!this.d) {
            for (int i = 0; i < e(); i++) {
                Map.Entry d = d(i);
                if (((FieldSet.FieldDescriptorLite) d.getKey()).isRepeated()) {
                    d.setValue(Collections.unmodifiableList((List) d.getValue()));
                }
            }
            for (Map.Entry entry : f()) {
                if (((FieldSet.FieldDescriptorLite) entry.getKey()).isRepeated()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.h();
    }

    @Override // a2.j.i.l, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((FieldSet.FieldDescriptorLite) obj, obj2);
    }
}
