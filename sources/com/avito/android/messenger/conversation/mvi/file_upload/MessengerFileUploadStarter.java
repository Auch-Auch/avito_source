package com.avito.android.messenger.conversation.mvi.file_upload;

import com.avito.android.remote.model.messenger.message.MessageBody;
import io.reactivex.rxjava3.core.Completable;
import java.io.File;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/file_upload/MessengerFileUploadStarter;", "", "Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadUniqueInfo;", "uploadUniqueInfo", "", MessageBody.File.FILE_ID, "Ljava/io/File;", "file", "Lcom/avito/android/remote/model/messenger/message/MessageBody$File;", "messageBody", "Lio/reactivex/rxjava3/core/Completable;", "startUpload", "(Lcom/avito/android/messenger/conversation/mvi/file_upload/UploadUniqueInfo;Ljava/lang/String;Ljava/io/File;Lcom/avito/android/remote/model/messenger/message/MessageBody$File;)Lio/reactivex/rxjava3/core/Completable;", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface MessengerFileUploadStarter {
    @NotNull
    Completable startUpload(@NotNull UploadUniqueInfo uploadUniqueInfo, @NotNull String str, @NotNull File file, @NotNull MessageBody.File file2);
}
