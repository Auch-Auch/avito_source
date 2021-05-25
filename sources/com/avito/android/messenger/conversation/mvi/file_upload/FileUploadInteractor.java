package com.avito.android.messenger.conversation.mvi.file_upload;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.facebook.internal.AnalyticsEvents;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\fJ5\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractor;", "", "", ChannelContext.Item.USER_ID, "channelId", "localId", "Lcom/avito/android/remote/model/messenger/message/MessageBody$File;", "messageBody", "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractor$FileUploadResult;", "uploadFile", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/messenger/message/MessageBody$File;)Lio/reactivex/rxjava3/core/Single;", "FileUploadResult", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface FileUploadInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractor$FileUploadResult;", "", "<init>", "()V", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Success", "Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractor$FileUploadResult$Success;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractor$FileUploadResult$Failed;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class FileUploadResult {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractor$FileUploadResult$Failed;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractor$FileUploadResult;", "", "component1", "()Ljava/lang/Throwable;", OkListener.KEY_EXCEPTION, "copy", "(Ljava/lang/Throwable;)Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractor$FileUploadResult$Failed;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/Throwable;", "getException", "<init>", "(Ljava/lang/Throwable;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Failed extends FileUploadResult {
            @Nullable
            public final Throwable a;

            public Failed() {
                this(null, 1, null);
            }

            public Failed(@Nullable Throwable th) {
                super(null);
                this.a = th;
            }

            public static /* synthetic */ Failed copy$default(Failed failed, Throwable th, int i, Object obj) {
                if ((i & 1) != 0) {
                    th = failed.a;
                }
                return failed.copy(th);
            }

            @Nullable
            public final Throwable component1() {
                return this.a;
            }

            @NotNull
            public final Failed copy(@Nullable Throwable th) {
                return new Failed(th);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Failed) && Intrinsics.areEqual(this.a, ((Failed) obj).a);
                }
                return true;
            }

            @Nullable
            public final Throwable getException() {
                return this.a;
            }

            public int hashCode() {
                Throwable th = this.a;
                if (th != null) {
                    return th.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("Failed(exception=");
                L.append(this.a);
                L.append(")");
                return L.toString();
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Failed(Throwable th, int i, j jVar) {
                this((i & 1) != 0 ? null : th);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0005\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004¨\u0006\u0016"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractor$FileUploadResult$Success;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractor$FileUploadResult;", "", "component1", "()Ljava/lang/String;", MessageBody.File.FILE_ID, "copy", "(Ljava/lang/String;)Lcom/avito/android/messenger/conversation/mvi/file_upload/FileUploadInteractor$FileUploadResult$Success;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getFileId", "<init>", "(Ljava/lang/String;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Success extends FileUploadResult {
            @NotNull
            public final String a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Success(@NotNull String str) {
                super(null);
                Intrinsics.checkNotNullParameter(str, MessageBody.File.FILE_ID);
                this.a = str;
            }

            public static /* synthetic */ Success copy$default(Success success, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = success.a;
                }
                return success.copy(str);
            }

            @NotNull
            public final String component1() {
                return this.a;
            }

            @NotNull
            public final Success copy(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, MessageBody.File.FILE_ID);
                return new Success(str);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Success) && Intrinsics.areEqual(this.a, ((Success) obj).a);
                }
                return true;
            }

            @NotNull
            public final String getFileId() {
                return this.a;
            }

            public int hashCode() {
                String str = this.a;
                if (str != null) {
                    return str.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return a.t(a.L("Success(fileId="), this.a, ")");
            }
        }

        public FileUploadResult() {
        }

        public FileUploadResult(j jVar) {
        }
    }

    @NotNull
    Single<FileUploadResult> uploadFile(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull MessageBody.File file);
}
