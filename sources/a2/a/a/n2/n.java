package a2.a.a.n2;

import com.avito.android.serp.SerpInteractorImpl;
import com.avito.android.serp.SerpPage;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class n<T> implements Consumer<SerpPage> {
    public final /* synthetic */ SerpInteractorImpl a;

    public n(SerpInteractorImpl serpInteractorImpl) {
        this.a = serpInteractorImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(SerpPage serpPage) {
        SerpPage serpPage2 = serpPage;
        SerpInteractorImpl serpInteractorImpl = this.a;
        Intrinsics.checkNotNullExpressionValue(serpPage2, "it");
        SerpInteractorImpl.access$updateSearchSubscriptionsCount(serpInteractorImpl, serpPage2);
    }
}
