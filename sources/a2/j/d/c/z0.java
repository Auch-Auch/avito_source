package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import com.google.common.collect.Multimap;
import java.util.Map;
@GwtCompatible
public interface z0<K, V> extends Multimap<K, V> {
    /* renamed from: a */
    Multimap<K, V> mo31a();

    Predicate<? super Map.Entry<K, V>> c();
}
