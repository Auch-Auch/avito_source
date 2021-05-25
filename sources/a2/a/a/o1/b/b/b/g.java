package a2.a.a.o1.b.b.b;

import com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractor;
import com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractorImpl;
import com.avito.android.remote.model.CommercialBanner;
import com.avito.android.remote.model.messenger.ChatListBannersResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class g<T, R> implements Function<CommercialBanner, ChatListAdBannerInteractor.State> {
    public final /* synthetic */ ChatListAdBannerInteractorImpl.UpdateBannerMutator.a a;
    public final /* synthetic */ ChatListAdBannerInteractorImpl.BannerCascadeInfo b;
    public final /* synthetic */ ChatListBannersResponse c;

    public g(ChatListAdBannerInteractorImpl.UpdateBannerMutator.a aVar, ChatListAdBannerInteractorImpl.BannerCascadeInfo bannerCascadeInfo, ChatListBannersResponse chatListBannersResponse) {
        this.a = aVar;
        this.b = bannerCascadeInfo;
        this.c = chatListBannersResponse;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public ChatListAdBannerInteractor.State apply(CommercialBanner commercialBanner) {
        CommercialBanner commercialBanner2 = commercialBanner;
        Intrinsics.checkNotNullParameter(commercialBanner2, "banner");
        ChatListAdBannerInteractorImpl.this.v.putLong("banner_shown_timestamp", ChatListAdBannerInteractorImpl.this.w.now());
        return this.a.b.copy(commercialBanner2, this.b.getLocationId(), this.c.getChatListOffset(), this.c.getSecondsBeforeChange(), this.c.getSecondsBeforeShowAgain());
    }
}
