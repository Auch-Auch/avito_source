package com.avito.android.session_refresh;

import a2.a.a.q2.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.SessionContract;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.Request;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.internal.OkHttpMessengerImageUploaderKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u001d\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0005H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\"\u001e\u0010\r\u001a\u0004\u0018\u00010\b8\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u001a\u0010\u000f\u001a\u00020\u000e*\u00020\u00008@@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001d\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u00008À\u0002@\u0000X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lokhttp3/Request;", "", SessionContract.SESSION, "withSession", "(Lokhttp3/Request;Ljava/lang/String;)Lokhttp3/Request;", "Lokhttp3/Request$Builder;", "withRefreshTag", "(Lokhttp3/Request$Builder;)Lokhttp3/Request$Builder;", "Lokhttp3/MediaType;", AuthSource.SEND_ABUSE, "Lokhttp3/MediaType;", "getMEDIA_TYPE_FORM_URLENCODED", "()Lokhttp3/MediaType;", "MEDIA_TYPE_FORM_URLENCODED", "", "isRefreshRequest", "(Lokhttp3/Request;)Z", "getSession", "(Lokhttp3/Request;)Ljava/lang/String;", "session-refresher_release"}, k = 2, mv = {1, 4, 2})
public final class RequestsKt {
    @Nullable
    public static final MediaType a = MediaType.Companion.parse("application/x-www-form-urlencoded;charset=UTF-8");

    @Nullable
    public static final MediaType getMEDIA_TYPE_FORM_URLENCODED() {
        return a;
    }

    @Nullable
    public static final String getSession(@NotNull Request request) {
        Intrinsics.checkNotNullParameter(request, "$this$session");
        return request.header(OkHttpMessengerImageUploaderKt.IMAGE_UPLOAD_SESSION_HEADER);
    }

    public static final boolean isRefreshRequest(@NotNull Request request) {
        Intrinsics.checkNotNullParameter(request, "$this$isRefreshRequest");
        return request.tag(a.class) != null;
    }

    @NotNull
    public static final Request.Builder withRefreshTag(@NotNull Request.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "$this$withRefreshTag");
        return builder.tag(a.class, a.a);
    }

    @NotNull
    public static final Request withSession(@NotNull Request request, @Nullable String str) {
        Intrinsics.checkNotNullParameter(request, "$this$withSession");
        return !(str == null || str.length() == 0) ? request.newBuilder().header(OkHttpMessengerImageUploaderKt.IMAGE_UPLOAD_SESSION_HEADER, str).build() : request;
    }
}
