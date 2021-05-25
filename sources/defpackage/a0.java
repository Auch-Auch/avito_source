package defpackage;

import com.avito.android.tariff.fees_methods.items.FeeMethodClickStreamProvider;
import com.avito.android.tariff.fees_methods.viewmodel.FeeMethodsViewModelImpl;
import io.reactivex.functions.Consumer;
/* compiled from: java-style lambda group */
/* renamed from: a0  reason: default package */
public final class a0<T> implements Consumer<FeeMethodClickStreamProvider.Method> {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public a0(int i, Object obj) {
        this.a = i;
        this.b = obj;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.avito.android.util.architecture_components.SingleLiveEvent */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(FeeMethodClickStreamProvider.Method method) {
        int i = this.a;
        if (i == 0) {
            FeeMethodsViewModelImpl.access$trackFeesMethodClicked((FeeMethodsViewModelImpl) this.b, method.getType());
        } else if (i == 1) {
            ((FeeMethodsViewModelImpl) this.b).f.setValue(method.getDeepLink());
        } else {
            throw null;
        }
    }
}
