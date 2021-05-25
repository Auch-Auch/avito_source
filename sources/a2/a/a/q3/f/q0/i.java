package a2.a.a.q3.f.q0;

import com.avito.android.util.LoadingState;
import com.avito.conveyor_item.Item;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class i<T, R> implements Function<List<? extends Item>, LoadingState.Loaded<List<? extends Item>>> {
    public static final i a = new i();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public LoadingState.Loaded<List<? extends Item>> apply(List<? extends Item> list) {
        List<? extends Item> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "it");
        return new LoadingState.Loaded<>(list2);
    }
}
