package a2.a.a.e2.r;

import com.avito.android.blueprints.publish.tagged_input.SuggestRequest;
import com.avito.android.publish.details.PublishDetailsPresenterImpl;
import io.reactivex.functions.Consumer;
public final class m<T> implements Consumer<SuggestRequest> {
    public final /* synthetic */ PublishDetailsPresenterImpl a;

    public m(PublishDetailsPresenterImpl publishDetailsPresenterImpl) {
        this.a = publishDetailsPresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(SuggestRequest suggestRequest) {
        SuggestRequest suggestRequest2 = suggestRequest;
        PublishDetailsPresenterImpl.access$getTagsViewModel$p(this.a).loadSuggests(suggestRequest2.getItemId(), suggestRequest2.getQuery(), PublishDetailsPresenterImpl.access$getPublishViewModel$p(this.a).getNavigation().getCategoryId());
    }
}
