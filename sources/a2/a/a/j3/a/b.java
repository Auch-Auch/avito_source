package a2.a.a.j3.a;

import com.avito.android.deep_linking.links.DetailsSheetLinkBody;
import com.avito.android.user_adverts_common.safety.AfterPublishWarningSession;
import com.avito.android.user_adverts_common.safety.SafetyInfoProviderImpl;
import io.reactivex.rxjava3.functions.Consumer;
public final class b<T> implements Consumer<DetailsSheetLinkBody> {
    public final /* synthetic */ SafetyInfoProviderImpl.b a;

    public b(SafetyInfoProviderImpl.b bVar) {
        this.a = bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(DetailsSheetLinkBody detailsSheetLinkBody) {
        this.a.a.c.saveSession(new AfterPublishWarningSession(this.a.a.d.now()), this.a.c);
    }
}
