package a2.a.a.o1.b.b.b;

import com.avito.android.remote.model.messenger.ChatListBannersResponse;
import io.reactivex.functions.Function;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
public final class h<T, R> implements Function<ChatListBannersResponse, Pair<? extends ChatListBannersResponse, ? extends String>> {
    public final /* synthetic */ String a;

    public h(String str) {
        this.a = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Pair<? extends ChatListBannersResponse, ? extends String> apply(ChatListBannersResponse chatListBannersResponse) {
        ChatListBannersResponse chatListBannersResponse2 = chatListBannersResponse;
        Intrinsics.checkNotNullParameter(chatListBannersResponse2, "chatListBannerResponse");
        return TuplesKt.to(chatListBannersResponse2, this.a);
    }
}
