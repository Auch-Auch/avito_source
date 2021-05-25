package a2.a.a.o1.b.b.b;

import com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractorImpl;
import com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractorImpl$UpdateBannerMutator$loadBannerConfig$1;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.messenger.ChatListBannersResponse;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
public final class i<T, R> implements Function<Location, SingleSource<? extends Pair<? extends ChatListBannersResponse, ? extends String>>> {
    public final /* synthetic */ ChatListAdBannerInteractorImpl.UpdateBannerMutator a;

    public i(ChatListAdBannerInteractorImpl.UpdateBannerMutator updateBannerMutator) {
        this.a = updateBannerMutator;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends Pair<? extends ChatListBannersResponse, ? extends String>> apply(Location location) {
        Location location2 = location;
        Intrinsics.checkNotNullParameter(location2, "location");
        String id = location2.getId();
        ChatListAdBannerInteractorImpl.UpdateBannerMutator updateBannerMutator = this.a;
        Single<R> flatMap = ChatListAdBannerInteractorImpl.this.q.withMessengerApi().flatMap(new ChatListAdBannerInteractorImpl$UpdateBannerMutator$loadBannerConfig$1(ChatListAdBannerInteractorImpl.this.r.getApiKey(), Integer.parseInt(id)));
        Intrinsics.checkNotNullExpressionValue(flatMap, "client.withMessengerApi(…tionId)\n                }");
        return flatMap.map(new h(id));
    }
}
