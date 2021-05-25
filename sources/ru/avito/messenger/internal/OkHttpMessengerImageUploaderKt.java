package ru.avito.messenger.internal;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import okhttp3.MediaType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u0016\u0010\u0001\u001a\u00020\u00008\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0016\u0010\u0003\u001a\u00020\u00008\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0002\"\u0016\u0010\u0004\u001a\u00020\u00008\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0004\u0010\u0002\"\u001e\u0010\n\u001a\u0004\u0018\u00010\u00058\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"", "IMAGE_UPLOAD_ORIGIN_HEADER", "Ljava/lang/String;", "IMAGE_UPLOAD_SESSION_HEADER", "IMAGE_UPLOAD_MULTIPART_NAME", "Lokhttp3/MediaType;", AuthSource.SEND_ABUSE, "Lokhttp3/MediaType;", "getCONTENT_TYPE_IMAGE", "()Lokhttp3/MediaType;", "CONTENT_TYPE_IMAGE", "messenger_release"}, k = 2, mv = {1, 4, 2})
public final class OkHttpMessengerImageUploaderKt {
    @NotNull
    public static final String IMAGE_UPLOAD_MULTIPART_NAME = "uploadfile[]";
    @NotNull
    public static final String IMAGE_UPLOAD_ORIGIN_HEADER = "Origin";
    @NotNull
    public static final String IMAGE_UPLOAD_SESSION_HEADER = "X-Session";
    @Nullable
    public static final MediaType a = MediaType.Companion.parse("image/*");

    @Nullable
    public static final MediaType getCONTENT_TYPE_IMAGE() {
        return a;
    }
}
