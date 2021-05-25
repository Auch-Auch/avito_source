package com.avito.http;

import com.avito.android.remote.auth.AuthSource;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\"\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Ljava/io/File;", "", "name", "filename", "Lokhttp3/MultipartBody$Part;", "convertToImageMultipart", "(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)Lokhttp3/MultipartBody$Part;", "Lokhttp3/MediaType;", AuthSource.SEND_ABUSE, "Lokhttp3/MediaType;", "MEDIA_TYPE_IMAGE", "okhttp"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "FileUtils")
public final class FileUtils {
    public static final MediaType a = MediaType.Companion.get("image/*");

    @NotNull
    public static final MultipartBody.Part convertToImageMultipart(@NotNull File file, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(file, "$this$convertToImageMultipart");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "filename");
        return MultipartBody.Part.Companion.createFormData(str, str2, RequestBody.Companion.create(file, a));
    }

    public static /* synthetic */ MultipartBody.Part convertToImageMultipart$default(File file, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "image";
        }
        if ((i & 2) != 0) {
            str2 = "image";
        }
        return convertToImageMultipart(file, str, str2);
    }
}
