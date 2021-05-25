package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSetMultimap;
@GwtCompatible(serializable = true)
public class q0 extends ImmutableSetMultimap<Object, Object> {
    public static final q0 k = new q0();
    private static final long serialVersionUID = 0;

    public q0() {
        super(ImmutableMap.of(), 0, null);
    }

    private Object readResolve() {
        return k;
    }
}
