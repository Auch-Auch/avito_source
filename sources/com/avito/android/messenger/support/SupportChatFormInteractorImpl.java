package com.avito.android.messenger.support;

import com.avito.android.remote.SupportApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.StartSupportChatResponse;
import com.avito.android.util.RandomKeyProvider;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B,\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0011\u0010\u0013\u001a\r\u0012\t\u0012\u00070\u000f¢\u0006\u0002\b\u00100\u000e\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR!\u0010\u0013\u001a\r\u0012\t\u0012\u00070\u000f¢\u0006\u0002\b\u00100\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/avito/android/messenger/support/SupportChatFormInteractorImpl;", "Lcom/avito/android/messenger/support/SupportChatFormInteractor;", "", "problemId", "", "text", "Lio/reactivex/rxjava3/core/Single;", "", "startSupportChat", "(ILjava/lang/CharSequence;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/util/RandomKeyProvider;", "c", "Lcom/avito/android/util/RandomKeyProvider;", "randomIdProvider", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", "Lkotlin/jvm/JvmSuppressWildcards;", AuthSource.BOOKING_ORDER, "Lru/avito/messenger/MessengerClient;", "client", "Lcom/avito/android/remote/SupportApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/SupportApi;", "supportApi", "<init>", "(Lcom/avito/android/remote/SupportApi;Lru/avito/messenger/MessengerClient;Lcom/avito/android/util/RandomKeyProvider;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SupportChatFormInteractorImpl implements SupportChatFormInteractor {
    public final SupportApi a;
    public final MessengerClient<AvitoMessengerApi> b;
    public final RandomKeyProvider c;

    public static final class a<T, R> implements Function<StartSupportChatResponse, SingleSource<? extends String>> {
        public final /* synthetic */ SupportChatFormInteractorImpl a;
        public final /* synthetic */ CharSequence b;

        public a(SupportChatFormInteractorImpl supportChatFormInteractorImpl, CharSequence charSequence) {
            this.a = supportChatFormInteractorImpl;
            this.b = charSequence;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public SingleSource<? extends String> apply(StartSupportChatResponse startSupportChatResponse) {
            String channelId = startSupportChatResponse.getResult().getChannelId();
            return InteropKt.toV3(this.a.b.sendTextMessage(channelId, this.a.c.generateKey(), this.b.toString(), null)).map(new a2.a.a.o1.h.a(channelId));
        }
    }

    @Inject
    public SupportChatFormInteractorImpl(@NotNull SupportApi supportApi, @NotNull MessengerClient<AvitoMessengerApi> messengerClient, @NotNull RandomKeyProvider randomKeyProvider) {
        Intrinsics.checkNotNullParameter(supportApi, "supportApi");
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        Intrinsics.checkNotNullParameter(randomKeyProvider, "randomIdProvider");
        this.a = supportApi;
        this.b = messengerClient;
        this.c = randomKeyProvider;
    }

    @Override // com.avito.android.messenger.support.SupportChatFormInteractor
    @NotNull
    public Single<String> startSupportChat(int i, @NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "text");
        Single<R> flatMap = this.a.startSupportChat(i).firstOrError().flatMap(new a(this, charSequence));
        Intrinsics.checkNotNullExpressionValue(flatMap, "supportApi.startSupportC…          }\n            }");
        return flatMap;
    }
}
