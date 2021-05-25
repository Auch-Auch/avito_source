package a2.a.a.o1.b.b.b;

import com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractorImpl;
import com.avito.android.messenger.channels.mvi.interactor.ChatListAdBannerInteractorKt;
import com.avito.android.remote.model.AdNetworkBannerItem;
import com.avito.android.remote.model.DfpBannerItem;
import com.avito.android.remote.model.MyTargetBannerItem;
import com.avito.android.remote.model.PositionedCommercialCascade;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.YandexNativeBannerItem;
import com.avito.android.remote.model.messenger.ChatListBannersResponse;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
public final class j<T, R> implements Function<Pair<? extends ChatListBannersResponse, ? extends String>, ChatListAdBannerInteractorImpl.BannerCascadeInfo> {
    public final /* synthetic */ ChatListAdBannerInteractorImpl.UpdateBannerMutator a;

    public j(ChatListAdBannerInteractorImpl.UpdateBannerMutator updateBannerMutator) {
        this.a = updateBannerMutator;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:47:0x009b */
    @Override // io.reactivex.functions.Function
    public ChatListAdBannerInteractorImpl.BannerCascadeInfo apply(Pair<? extends ChatListBannersResponse, ? extends String> pair) {
        ArrayList arrayList;
        List<SerpElement> banners;
        Pair<? extends ChatListBannersResponse, ? extends String> pair2 = pair;
        Intrinsics.checkNotNullParameter(pair2, "<name for destructuring parameter 0>");
        ChatListBannersResponse chatListBannersResponse = (ChatListBannersResponse) pair2.component1();
        String str = (String) pair2.component2();
        List<PositionedCommercialCascade> positions = chatListBannersResponse.getPositions();
        ArrayList arrayList2 = new ArrayList();
        for (T t : positions) {
            if (Intrinsics.areEqual(t.getPosition(), ChatListAdBannerInteractorKt.MESSENGER_AD_BANNER_POSITION)) {
                arrayList2.add(t);
            }
        }
        PositionedCommercialCascade positionedCommercialCascade = (PositionedCommercialCascade) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) arrayList2);
        if (positionedCommercialCascade == null || (banners = positionedCommercialCascade.getBanners()) == null) {
            arrayList = null;
        } else {
            ArrayList arrayList3 = new ArrayList();
            for (T t2 : banners) {
                T t3 = t2;
                boolean z = false;
                if ((t3 instanceof YandexNativeBannerItem) || (!(this.a.d) && ((t3 instanceof DfpBannerItem) || (t3 instanceof MyTargetBannerItem)))) {
                    z = true;
                }
                if (z) {
                    arrayList3.add(t2);
                }
            }
            arrayList = new ArrayList();
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof AdNetworkBannerItem) {
                    arrayList.add(next);
                }
            }
        }
        ArrayList arrayList4 = arrayList;
        if (arrayList == null) {
            arrayList4 = CollectionsKt__CollectionsKt.emptyList();
        }
        Intrinsics.checkNotNullExpressionValue(chatListBannersResponse, "chatListBannerResponse");
        return new ChatListAdBannerInteractorImpl.BannerCascadeInfo(arrayList4, str, chatListBannersResponse);
    }
}
