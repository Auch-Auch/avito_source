package a2.a.a.t2;

import com.avito.android.remote.model.ShopSettings;
import com.avito.android.util.LoadingState;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class q extends Lambda implements Function1<LoadingState<? super ShopSettings>, ShopSettings> {
    public static final q a = new q();

    public q() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public ShopSettings invoke(LoadingState<? super ShopSettings> loadingState) {
        LoadingState<? super ShopSettings> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            return (ShopSettings) ((LoadingState.Loaded) loadingState2).getData();
        }
        return null;
    }
}
