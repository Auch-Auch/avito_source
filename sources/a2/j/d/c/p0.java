package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
@GwtCompatible(serializable = true)
public class p0 extends ImmutableListMultimap<Object, Object> {
    public static final p0 i = new p0();
    private static final long serialVersionUID = 0;

    public p0() {
        super(ImmutableMap.of(), 0);
    }

    private Object readResolve() {
        return i;
    }
}
