package a2.a.a.e2.w;

import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.util.MultiStateLoading;
import io.reactivex.functions.Function;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
public final class j<T, R> implements Function<MultiStateLoading.Loaded<?>, CategoryParameters> {
    public static final j a = new j();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public CategoryParameters apply(MultiStateLoading.Loaded<?> loaded) {
        MultiStateLoading.Loaded<?> loaded2 = loaded;
        Intrinsics.checkNotNullParameter(loaded2, "it");
        Object data = loaded2.getData();
        Objects.requireNonNull(data, "null cannot be cast to non-null type com.avito.android.remote.model.category_parameters.CategoryParameters");
        return (CategoryParameters) data;
    }
}
