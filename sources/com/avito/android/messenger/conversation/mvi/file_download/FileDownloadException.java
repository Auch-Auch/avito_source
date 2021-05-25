package com.avito.android.messenger.conversation.mvi.file_download;

import a2.b.a.a.a;
import androidx.core.app.NotificationCompat;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.android.persistence.messenger.MessageMetaInfo;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\b\u0005\u0006\u0007\b\t\n\u000b\fB\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u0001\b\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "<init>", "()V", "CacheAndCopyFailed", "DownloadFailed", "FeatureIsDisabled", "IllegalMessageState", "MalformedDownloadUrl", "MessageNotFoundInDb", "Unauthorized", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException$FeatureIsDisabled;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException$Unauthorized;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException$MessageNotFoundInDb;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException$IllegalMessageState;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException$MalformedDownloadUrl;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException$DownloadFailed;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException$CacheAndCopyFailed;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException$Unknown;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class FileDownloadException extends Exception {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException$CacheAndCopyFailed;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class CacheAndCopyFailed extends FileDownloadException {
        public CacheAndCopyFailed() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ.\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\bR\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException$DownloadFailed;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException;", "", "component1", "()Ljava/lang/String;", "component2", "Lokhttp3/Response;", "component3", "()Lokhttp3/Response;", "url", "headers", CommonKt.EXTRA_RESPONSE, "copy", "(Ljava/lang/String;Ljava/lang/String;Lokhttp3/Response;)Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException$DownloadFailed;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getUrl", "c", "Lokhttp3/Response;", "getResponse", AuthSource.BOOKING_ORDER, "getHeaders", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lokhttp3/Response;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class DownloadFailed extends FileDownloadException {
        @NotNull
        public final String a;
        @NotNull
        public final String b;
        @NotNull
        public final Response c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DownloadFailed(@NotNull String str, @NotNull String str2, @NotNull Response response) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(str2, "headers");
            Intrinsics.checkNotNullParameter(response, CommonKt.EXTRA_RESPONSE);
            this.a = str;
            this.b = str2;
            this.c = response;
        }

        public static /* synthetic */ DownloadFailed copy$default(DownloadFailed downloadFailed, String str, String str2, Response response, int i, Object obj) {
            if ((i & 1) != 0) {
                str = downloadFailed.a;
            }
            if ((i & 2) != 0) {
                str2 = downloadFailed.b;
            }
            if ((i & 4) != 0) {
                response = downloadFailed.c;
            }
            return downloadFailed.copy(str, str2, response);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final Response component3() {
            return this.c;
        }

        @NotNull
        public final DownloadFailed copy(@NotNull String str, @NotNull String str2, @NotNull Response response) {
            Intrinsics.checkNotNullParameter(str, "url");
            Intrinsics.checkNotNullParameter(str2, "headers");
            Intrinsics.checkNotNullParameter(response, CommonKt.EXTRA_RESPONSE);
            return new DownloadFailed(str, str2, response);
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DownloadFailed)) {
                return false;
            }
            DownloadFailed downloadFailed = (DownloadFailed) obj;
            return Intrinsics.areEqual(this.a, downloadFailed.a) && Intrinsics.areEqual(this.b, downloadFailed.b) && Intrinsics.areEqual(this.c, downloadFailed.c);
        }

        @NotNull
        public final String getHeaders() {
            return this.b;
        }

        @NotNull
        public final Response getResponse() {
            return this.c;
        }

        @NotNull
        public final String getUrl() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            Response response = this.c;
            if (response != null) {
                i = response.hashCode();
            }
            return hashCode2 + i;
        }

        @Override // java.lang.Throwable, java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("DownloadFailed(url=");
            L.append(this.a);
            L.append(", headers=");
            L.append(this.b);
            L.append(", response=");
            L.append(this.c);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException$FeatureIsDisabled;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class FeatureIsDisabled extends FileDownloadException {
        public FeatureIsDisabled() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\b\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001b\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException$IllegalMessageState;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException;", "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "component1", "()Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "component2", "()Lru/avito/android/persistence/messenger/MessageMetaInfo;", NotificationCompat.CATEGORY_MESSAGE, "metaInfo", "copy", "(Lcom/avito/android/remote/model/messenger/message/LocalMessage;Lru/avito/android/persistence/messenger/MessageMetaInfo;)Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException$IllegalMessageState;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/messenger/message/LocalMessage;", "getMsg", AuthSource.BOOKING_ORDER, "Lru/avito/android/persistence/messenger/MessageMetaInfo;", "getMetaInfo", "<init>", "(Lcom/avito/android/remote/model/messenger/message/LocalMessage;Lru/avito/android/persistence/messenger/MessageMetaInfo;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class IllegalMessageState extends FileDownloadException {
        @NotNull
        public final LocalMessage a;
        @Nullable
        public final MessageMetaInfo b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IllegalMessageState(@NotNull LocalMessage localMessage, @Nullable MessageMetaInfo messageMetaInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(localMessage, NotificationCompat.CATEGORY_MESSAGE);
            this.a = localMessage;
            this.b = messageMetaInfo;
        }

        public static /* synthetic */ IllegalMessageState copy$default(IllegalMessageState illegalMessageState, LocalMessage localMessage, MessageMetaInfo messageMetaInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                localMessage = illegalMessageState.a;
            }
            if ((i & 2) != 0) {
                messageMetaInfo = illegalMessageState.b;
            }
            return illegalMessageState.copy(localMessage, messageMetaInfo);
        }

        @NotNull
        public final LocalMessage component1() {
            return this.a;
        }

        @Nullable
        public final MessageMetaInfo component2() {
            return this.b;
        }

        @NotNull
        public final IllegalMessageState copy(@NotNull LocalMessage localMessage, @Nullable MessageMetaInfo messageMetaInfo) {
            Intrinsics.checkNotNullParameter(localMessage, NotificationCompat.CATEGORY_MESSAGE);
            return new IllegalMessageState(localMessage, messageMetaInfo);
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IllegalMessageState)) {
                return false;
            }
            IllegalMessageState illegalMessageState = (IllegalMessageState) obj;
            return Intrinsics.areEqual(this.a, illegalMessageState.a) && Intrinsics.areEqual(this.b, illegalMessageState.b);
        }

        @Nullable
        public final MessageMetaInfo getMetaInfo() {
            return this.b;
        }

        @NotNull
        public final LocalMessage getMsg() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            LocalMessage localMessage = this.a;
            int i = 0;
            int hashCode = (localMessage != null ? localMessage.hashCode() : 0) * 31;
            MessageMetaInfo messageMetaInfo = this.b;
            if (messageMetaInfo != null) {
                i = messageMetaInfo.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Throwable, java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("IllegalMessageState(msg=");
            L.append(this.a);
            L.append(", metaInfo=");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException$MalformedDownloadUrl;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException;", "", "component1", "()Ljava/lang/String;", "url", "copy", "(Ljava/lang/String;)Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException$MalformedDownloadUrl;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getUrl", "<init>", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class MalformedDownloadUrl extends FileDownloadException {
        @NotNull
        public final String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MalformedDownloadUrl(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "url");
            this.a = str;
        }

        public static /* synthetic */ MalformedDownloadUrl copy$default(MalformedDownloadUrl malformedDownloadUrl, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = malformedDownloadUrl.a;
            }
            return malformedDownloadUrl.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final MalformedDownloadUrl copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "url");
            return new MalformedDownloadUrl(str);
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof MalformedDownloadUrl) && Intrinsics.areEqual(this.a, ((MalformedDownloadUrl) obj).a);
            }
            return true;
        }

        @NotNull
        public final String getUrl() {
            return this.a;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.a;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Throwable, java.lang.Object
        @NotNull
        public String toString() {
            return a.t(a.L("MalformedDownloadUrl(url="), this.a, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException$MessageNotFoundInDb;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class MessageNotFoundInDb extends FileDownloadException {
        public MessageNotFoundInDb() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J$\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0006\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0014\u001a\u0004\b\u0017\u0010\u0004¨\u0006\u001a"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException$Unauthorized;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException;", "", "component1", "()Ljava/lang/String;", "component2", "currentUserId", "messageOwnerId", "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException$Unauthorized;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getCurrentUserId", AuthSource.BOOKING_ORDER, "getMessageOwnerId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Unauthorized extends FileDownloadException {
        @NotNull
        public final String a;
        @NotNull
        public final String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Unauthorized(@NotNull String str, @NotNull String str2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "currentUserId");
            Intrinsics.checkNotNullParameter(str2, "messageOwnerId");
            this.a = str;
            this.b = str2;
        }

        public static /* synthetic */ Unauthorized copy$default(Unauthorized unauthorized, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unauthorized.a;
            }
            if ((i & 2) != 0) {
                str2 = unauthorized.b;
            }
            return unauthorized.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final String component2() {
            return this.b;
        }

        @NotNull
        public final Unauthorized copy(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "currentUserId");
            Intrinsics.checkNotNullParameter(str2, "messageOwnerId");
            return new Unauthorized(str, str2);
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Unauthorized)) {
                return false;
            }
            Unauthorized unauthorized = (Unauthorized) obj;
            return Intrinsics.areEqual(this.a, unauthorized.a) && Intrinsics.areEqual(this.b, unauthorized.b);
        }

        @NotNull
        public final String getCurrentUserId() {
            return this.a;
        }

        @NotNull
        public final String getMessageOwnerId() {
            return this.b;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.b;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Throwable, java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Unauthorized(currentUserId=");
            L.append(this.a);
            L.append(", messageOwnerId=");
            return a.t(L, this.b, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException$Unknown;", "Lcom/avito/android/messenger/conversation/mvi/file_download/FileDownloadException;", "", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "cause", "<init>", "(Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Unknown extends FileDownloadException {
        @Nullable
        public final Throwable a;

        public Unknown(@Nullable Throwable th) {
            super(null);
            this.a = th;
        }

        @Override // java.lang.Throwable
        @Nullable
        public Throwable getCause() {
            return this.a;
        }
    }

    private FileDownloadException() {
    }

    public /* synthetic */ FileDownloadException(j jVar) {
        this();
    }
}
