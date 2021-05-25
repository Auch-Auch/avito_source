package a2.a.a.s2.c;

import com.avito.android.remote.model.Location;
import io.reactivex.rxjava3.functions.Function;
import org.funktionale.option.Option;
import org.funktionale.option.OptionKt;
public final class a<T, R> implements Function<Location, Option<? extends Location>> {
    public static final a a = new a();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public Option<? extends Location> apply(Location location) {
        return OptionKt.toOption(location);
    }
}
