package a2.d.a.d.b.w;

import com.bumptech.glide.load.engine.prefill.PreFillType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public final class b {
    public final Map<PreFillType, Integer> a;
    public final List<PreFillType> b;
    public int c;
    public int d;

    public b(Map<PreFillType, Integer> map) {
        this.a = map;
        this.b = new ArrayList(map.keySet());
        for (Integer num : map.values()) {
            this.c = num.intValue() + this.c;
        }
    }
}
