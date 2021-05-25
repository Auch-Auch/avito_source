package com.avito.android.messenger.conversation.mvi.file_upload;

import a2.a.a.o1.d.a0.f.l;
import android.content.Context;
import com.avito.android.messenger.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.messenger.message.MessageBody;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
import java.io.File;
import java.util.ArrayList;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.data.UploadNotificationConfig;
import net.gotev.uploadservice.data.UploadNotificationStatusConfig;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0019\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadServiceStarterImpl;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadStarter;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadUniqueInfo;", "uploadUniqueInfo", "", MessageBody.File.FILE_ID, "Ljava/io/File;", "file", "Lcom/avito/android/remote/model/messenger/message/MessageBody$File;", "messageBody", "Lio/reactivex/rxjava3/core/Completable;", "startUpload", "(Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadUniqueInfo;Ljava/lang/String;Ljava/io/File;Lcom/avito/android/remote/model/messenger/message/MessageBody$File;)Lio/reactivex/rxjava3/core/Completable;", "Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadConfigProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadConfigProvider;", "configProvider", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadConfigProvider;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class UploadServiceStarterImpl implements MessengerFileUploadStarter {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public final Context a;
    public final MessengerFileUploadConfigProvider b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadServiceStarterImpl$Companion;", "", "", "FILE_ID_QUERY_PARAM", "Ljava/lang/String;", "FILE_PARAMETER_NAME", "FILE_UPLOAD_PATH", "ORIGIN_HEADER", "SESSION_HEADER", "UPLOAD_FILE_METHOD", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a<T, R> implements Function<MessengerFileUploadConfig, CompletableSource> {
        public final /* synthetic */ UploadServiceStarterImpl a;
        public final /* synthetic */ String b;
        public final /* synthetic */ File c;
        public final /* synthetic */ MessageBody.File d;
        public final /* synthetic */ UploadUniqueInfo e;

        public a(UploadServiceStarterImpl uploadServiceStarterImpl, String str, File file, MessageBody.File file2, UploadUniqueInfo uploadUniqueInfo) {
            this.a = uploadServiceStarterImpl;
            this.b = str;
            this.c = file;
            this.d = file2;
            this.e = uploadUniqueInfo;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public CompletableSource apply(MessengerFileUploadConfig messengerFileUploadConfig) {
            return Completable.fromAction(new l(this, messengerFileUploadConfig));
        }
    }

    @Inject
    public UploadServiceStarterImpl(@NotNull Context context, @NotNull MessengerFileUploadConfigProvider messengerFileUploadConfigProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(messengerFileUploadConfigProvider, "configProvider");
        this.a = context;
        this.b = messengerFileUploadConfigProvider;
    }

    public static final UploadNotificationConfig access$getNotificationConfig(UploadServiceStarterImpl uploadServiceStarterImpl, String str) {
        Objects.requireNonNull(uploadServiceStarterImpl);
        ArrayList arrayList = new ArrayList();
        String string = uploadServiceStarterImpl.a.getString(R.string.messenger_notification_file_upload_title, str);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri…e_upload_title, fileName)");
        String string2 = uploadServiceStarterImpl.a.getString(R.string.messenger_notification_file_upload_progress);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.stri…ion_file_upload_progress)");
        UploadNotificationStatusConfig uploadNotificationStatusConfig = new UploadNotificationStatusConfig(string, string2, 0, 0, null, null, arrayList, false, true, null, 700, null);
        String string3 = uploadServiceStarterImpl.a.getString(R.string.messenger_notification_file_upload_result_in_time);
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.stri…le_upload_result_in_time)");
        UploadNotificationStatusConfig uploadNotificationStatusConfig2 = new UploadNotificationStatusConfig(string, string3, 0, 0, null, null, arrayList, false, true, null, 700, null);
        String string4 = uploadServiceStarterImpl.a.getString(R.string.messenger_notification_file_upload_error);
        Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.stri…cation_file_upload_error)");
        UploadNotificationStatusConfig uploadNotificationStatusConfig3 = new UploadNotificationStatusConfig(string, string4, 0, 0, null, null, arrayList, false, true, null, 700, null);
        String string5 = uploadServiceStarterImpl.a.getString(R.string.messenger_notification_file_upload_cancelled);
        Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri…on_file_upload_cancelled)");
        UploadNotificationStatusConfig uploadNotificationStatusConfig4 = new UploadNotificationStatusConfig(string, string5, 0, 0, null, null, arrayList, false, true, null, 700, null);
        String string6 = uploadServiceStarterImpl.a.getString(R.string.messenger_file_upload_notification_channel_id);
        Intrinsics.checkNotNullExpressionValue(string6, "context.getString(R.stri…_notification_channel_id)");
        return new UploadNotificationConfig(string6, false, uploadNotificationStatusConfig, uploadNotificationStatusConfig2, uploadNotificationStatusConfig3, uploadNotificationStatusConfig4);
    }

    @Override // com.avito.android.messenger.conversation.mvi.file_upload.MessengerFileUploadStarter
    @NotNull
    public Completable startUpload(@NotNull UploadUniqueInfo uploadUniqueInfo, @NotNull String str, @NotNull File file, @NotNull MessageBody.File file2) {
        Intrinsics.checkNotNullParameter(uploadUniqueInfo, "uploadUniqueInfo");
        Intrinsics.checkNotNullParameter(str, MessageBody.File.FILE_ID);
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(file2, "messageBody");
        Completable flatMapCompletable = this.b.getConfig().flatMapCompletable(new a(this, str, file, file2, uploadUniqueInfo));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "configProvider.getConfig…          }\n            }");
        return flatMapCompletable;
    }
}
