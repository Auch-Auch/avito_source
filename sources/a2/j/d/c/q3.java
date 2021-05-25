package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
@GwtCompatible
public interface q3<T> extends Iterable<T> {
    Comparator<? super T> comparator();
}
