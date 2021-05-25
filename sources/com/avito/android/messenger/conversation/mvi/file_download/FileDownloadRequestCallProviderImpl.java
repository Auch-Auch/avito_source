package com.avito.android.messenger.conversation.mvi.file_download;

import com.avito.android.messenger.conversation.mvi.file_download.FileDownloadException;
import com.avito.android.messenger.service.MessengerInfoProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.social.AppleSignInManagerKt;
import com.avito.android.util.rx3.InteropKt;
import dagger.Lazy;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.SessionProvider;
import ru.avito.messenger.internal.OkHttpMessengerImageUploaderKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadRequestCallProviderImpl;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadRequestCallProvider;", "", "url", AppleSignInManagerKt.EXTRA_APPLE_TOKEN, "Lio/reactivex/rxjava3/core/Single;", "Lokhttp3/Call;", "getDownloadRequestCall", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "Lru/avito/messenger/SessionProvider;", AuthSource.BOOKING_ORDER, "Lru/avito/messenger/SessionProvider;", "sessionProvider", "Lcom/avito/android/messenger/service/MessengerInfoProvider;", "c", "Lcom/avito/android/messenger/service/MessengerInfoProvider;", "messengerInfoProvider", "Ldagger/Lazy;", "Lokhttp3/OkHttpClient;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", "client", "<init>", "(Ldagger/Lazy;Lru/avito/messenger/SessionProvider;Lcom/avito/android/messenger/service/MessengerInfoProvider;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class FileDownloadRequestCallProviderImpl implements FileDownloadRequestCallProvider {
    public final Lazy<OkHttpClient> a;
    public final SessionProvider b;
    public final MessengerInfoProvider c;

    public static final class a<T, R> implements Function<String, Call> {
        public final /* synthetic */ FileDownloadRequestCallProviderImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ HttpUrl c;

        public a(FileDownloadRequestCallProviderImpl fileDownloadRequestCallProviderImpl, String str, HttpUrl httpUrl) {
            this.a = fileDownloadRequestCallProviderImpl;
            this.b = str;
            this.c = httpUrl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public Call apply(String str) {
            String str2 = str;
            Request.Builder addHeader = new Request.Builder().get().addHeader("Origin", this.a.c.provideOrigin());
            Intrinsics.checkNotNullExpressionValue(str2, "sessionId");
            return ((OkHttpClient) this.a.a.get()).newCall(addHeader.addHeader(OkHttpMessengerImageUploaderKt.IMAGE_UPLOAD_SESSION_HEADER, str2).addHeader("X-File-Token", this.b).url(this.c).build());
        }
    }

    @Inject
    public FileDownloadRequestCallProviderImpl(@NotNull Lazy<OkHttpClient> lazy, @NotNull SessionProvider sessionProvider, @NotNull MessengerInfoProvider messengerInfoProvider) {
        Intrinsics.checkNotNullParameter(lazy, "client");
        Intrinsics.checkNotNullParameter(sessionProvider, "sessionProvider");
        Intrinsics.checkNotNullParameter(messengerInfoProvider, "messengerInfoProvider");
        this.a = lazy;
        this.b = sessionProvider;
        this.c = messengerInfoProvider;
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_download.FileDownloadRequestCallProvider
    @NotNull
    public Single<Call> getDownloadRequestCall(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(str2, AppleSignInManagerKt.EXTRA_APPLE_TOKEN);
        HttpUrl parse = HttpUrl.Companion.parse(str);
        if (parse != null) {
            Single<Call> map = InteropKt.toV3(this.b.session()).map(new a(this, str2, parse));
            Intrinsics.checkNotNullExpressionValue(map, "sessionProvider\n        …equest)\n                }");
            return map;
        }
        Single<Call> error = Single.error(new FileDownloadException.MalformedDownloadUrl(str));
        Intrinsics.checkNotNullExpressionValue(error, "Single.error(FileDownloa…alformedDownloadUrl(url))");
        return error;
    }
}
