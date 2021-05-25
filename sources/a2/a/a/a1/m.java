package a2.a.a.a1;

import com.avito.android.home.HomePresenter;
import com.avito.android.home.HomePresenterImpl;
import com.avito.android.stories.StartupStoryBanner;
import io.reactivex.rxjava3.functions.Consumer;
import t6.n.d;
public final class m<T> implements Consumer<StartupStoryBanner> {
    public final /* synthetic */ HomePresenterImpl a;

    public m(HomePresenterImpl homePresenterImpl) {
        this.a = homePresenterImpl;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(StartupStoryBanner startupStoryBanner) {
        StartupStoryBanner startupStoryBanner2 = startupStoryBanner;
        HomePresenter.Router router = this.a.c;
        if (router != null) {
            router.openStory(startupStoryBanner2.getUrl(), d.listOf(startupStoryBanner2.getId()), startupStoryBanner2.getId());
        }
    }
}
