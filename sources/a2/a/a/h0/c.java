package a2.a.a.h0;

import com.avito.android.remote.model.ContactAccessService;
import com.avito.android.util.LoadingState;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class c<T, R> implements Function<ContactAccessService, LoadingState.Loaded<ContactAccessService>> {
    public static final c a = new c();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public LoadingState.Loaded<ContactAccessService> apply(ContactAccessService contactAccessService) {
        ContactAccessService contactAccessService2 = contactAccessService;
        Intrinsics.checkNotNullParameter(contactAccessService2, "it");
        return new LoadingState.Loaded<>(contactAccessService2);
    }
}
