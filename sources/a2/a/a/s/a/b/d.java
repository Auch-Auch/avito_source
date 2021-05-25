package a2.a.a.s.a.b;

import com.avito.android.beduin.model.BeduinActionsResponse;
import com.avito.android.beduin.ui.viewmodel.BeduinViewModel;
import com.avito.android.util.LoadingState;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Consumer<LoadingState<? super BeduinActionsResponse>> {
    public final /* synthetic */ BeduinViewModel a;
    public final /* synthetic */ b b;
    public final /* synthetic */ a c;

    public d(BeduinViewModel beduinViewModel, b bVar, a aVar) {
        this.a = beduinViewModel;
        this.b = bVar;
        this.c = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: androidx.lifecycle.MutableLiveData */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(LoadingState<? super BeduinActionsResponse> loadingState) {
        LoadingState<? super BeduinActionsResponse> loadingState2 = loadingState;
        if (loadingState2 instanceof LoadingState.Loaded) {
            this.b.a(((BeduinActionsResponse) ((LoadingState.Loaded) loadingState2).getData()).getActions());
            return;
        }
        LoadingState.Loading loading = LoadingState.Loading.INSTANCE;
        if (Intrinsics.areEqual(loadingState2, loading)) {
            this.a.d.setValue(loading);
        } else if (loadingState2 instanceof LoadingState.Error) {
            this.a.c((LoadingState.Error) loadingState2);
            this.c.invoke();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
