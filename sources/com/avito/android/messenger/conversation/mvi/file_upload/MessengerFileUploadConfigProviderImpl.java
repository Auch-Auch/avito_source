package com.avito.android.messenger.conversation.mvi.file_upload;

import com.avito.android.messenger.service.MessengerInfoProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import okhttp3.HttpUrl;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.SessionProvider;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001d\u0010\u0013\u001a\u00020\u000e8B@\u0002X\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadConfigProviderImpl;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadConfigProvider;", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadConfig;", "getConfig", "()Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/messenger/service/MessengerInfoProvider;", "c", "Lcom/avito/android/messenger/service/MessengerInfoProvider;", "messengerInfoProvider", "Lru/avito/messenger/SessionProvider;", AuthSource.BOOKING_ORDER, "Lru/avito/messenger/SessionProvider;", "sessionProvider", "Lokhttp3/HttpUrl;", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getFileUploadEndpoint", "()Lokhttp3/HttpUrl;", "fileUploadEndpoint", "<init>", "(Lru/avito/messenger/SessionProvider;Lcom/avito/android/messenger/service/MessengerInfoProvider;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerFileUploadConfigProviderImpl implements MessengerFileUploadConfigProvider {
    public final Lazy a = c.lazy(new a(this));
    public final SessionProvider b;
    public final MessengerInfoProvider c;

    public static final class a extends Lambda implements Function0<HttpUrl> {
        public final /* synthetic */ MessengerFileUploadConfigProviderImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MessengerFileUploadConfigProviderImpl messengerFileUploadConfigProviderImpl) {
            super(0);
            this.a = messengerFileUploadConfigProviderImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public HttpUrl invoke() {
            HttpUrl parse = HttpUrl.Companion.parse(this.a.c.provideFileTransferEndpoint());
            if (parse != null) {
                return parse;
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    public static final class b<T, R> implements Function<String, MessengerFileUploadConfig> {
        public final /* synthetic */ MessengerFileUploadConfigProviderImpl a;

        public b(MessengerFileUploadConfigProviderImpl messengerFileUploadConfigProviderImpl) {
            this.a = messengerFileUploadConfigProviderImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public MessengerFileUploadConfig apply(String str) {
            String str2 = str;
            HttpUrl access$getFileUploadEndpoint$p = MessengerFileUploadConfigProviderImpl.access$getFileUploadEndpoint$p(this.a);
            String provideOrigin = this.a.c.provideOrigin();
            Intrinsics.checkNotNullExpressionValue(str2, "sessionId");
            return new MessengerFileUploadConfig(access$getFileUploadEndpoint$p, provideOrigin, str2);
        }
    }

    @Inject
    public MessengerFileUploadConfigProviderImpl(@NotNull SessionProvider sessionProvider, @NotNull MessengerInfoProvider messengerInfoProvider) {
        Intrinsics.checkNotNullParameter(sessionProvider, "sessionProvider");
        Intrinsics.checkNotNullParameter(messengerInfoProvider, "messengerInfoProvider");
        this.b = sessionProvider;
        this.c = messengerInfoProvider;
    }

    public static final HttpUrl access$getFileUploadEndpoint$p(MessengerFileUploadConfigProviderImpl messengerFileUploadConfigProviderImpl) {
        return (HttpUrl) messengerFileUploadConfigProviderImpl.a.getValue();
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_upload.MessengerFileUploadConfigProvider
    @NotNull
    public Single<MessengerFileUploadConfig> getConfig() {
        Single<MessengerFileUploadConfig> map = InteropKt.toV3(this.b.session()).map(new b(this));
        Intrinsics.checkNotNullExpressionValue(map, "sessionProvider\n        …          )\n            }");
        return map;
    }
}
