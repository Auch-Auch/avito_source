package ru.avito.messenger.internal;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dagger.Lazy;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerImageUploadApi;
import ru.avito.messenger.SessionProvider;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B=\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b \u0010!J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lru/avito/messenger/internal/OkHttpMessengerImageUploader;", "Lru/avito/messenger/MessengerImageUploadApi;", "Ljava/io/File;", "file", "Lio/reactivex/Single;", "", "uploadImage", "(Ljava/io/File;)Lio/reactivex/Single;", "Lcom/google/gson/Gson;", "e", "Lcom/google/gson/Gson;", "gson", "c", "Ljava/lang/String;", "origin", "Lru/avito/messenger/SessionProvider;", "d", "Lru/avito/messenger/SessionProvider;", "sessionProvider", "Ldagger/Lazy;", "Lokhttp3/OkHttpClient;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", "client", "Lokhttp3/HttpUrl;", AuthSource.BOOKING_ORDER, "Lokhttp3/HttpUrl;", "endpoint", "Lcom/avito/android/util/SchedulersFactory;", "f", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Ldagger/Lazy;Lokhttp3/HttpUrl;Ljava/lang/String;Lru/avito/messenger/SessionProvider;Lcom/google/gson/Gson;Lcom/avito/android/util/SchedulersFactory;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class OkHttpMessengerImageUploader implements MessengerImageUploadApi {
    public final Lazy<OkHttpClient> a;
    public final HttpUrl b;
    public final String c;
    public final SessionProvider d;
    public final Gson e;
    public final SchedulersFactory f;

    public static final class a<T, R> implements Function<String, Request> {
        public final /* synthetic */ OkHttpMessengerImageUploader a;
        public final /* synthetic */ File b;

        public a(OkHttpMessengerImageUploader okHttpMessengerImageUploader, File file) {
            this.a = okHttpMessengerImageUploader;
            this.b = file;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Request apply(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "sessionId");
            return new Request.Builder().addHeader(OkHttpMessengerImageUploaderKt.IMAGE_UPLOAD_SESSION_HEADER, str2).addHeader("Origin", this.a.c).url(this.a.b).post(new MultipartBody.Builder(null, 1, null).setType(MultipartBody.FORM).addFormDataPart(OkHttpMessengerImageUploaderKt.IMAGE_UPLOAD_MULTIPART_NAME, "image", RequestBody.Companion.create(OkHttpMessengerImageUploaderKt.getCONTENT_TYPE_IMAGE(), this.b)).build()).build();
        }
    }

    public static final class b<T, R> implements Function<Request, Call> {
        public final /* synthetic */ OkHttpMessengerImageUploader a;

        public b(OkHttpMessengerImageUploader okHttpMessengerImageUploader) {
            this.a = okHttpMessengerImageUploader;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Call apply(Request request) {
            Request request2 = request;
            Intrinsics.checkNotNullParameter(request2, "request");
            return ((OkHttpClient) this.a.a.get()).newCall(request2);
        }
    }

    public static final class c<T, R> implements Function<Call, Response> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Response apply(Call call) {
            Call call2 = call;
            Intrinsics.checkNotNullParameter(call2, "call");
            return call2.execute();
        }
    }

    public static final class d<T, R> implements Function<Response, String> {
        public final /* synthetic */ OkHttpMessengerImageUploader a;

        public d(OkHttpMessengerImageUploader okHttpMessengerImageUploader) {
            this.a = okHttpMessengerImageUploader;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public String apply(Response response) {
            Response response2 = response;
            Intrinsics.checkNotNullParameter(response2, CommonKt.EXTRA_RESPONSE);
            return OkHttpMessengerImageUploader.access$parseUploadResponse(this.a, response2);
        }
    }

    public OkHttpMessengerImageUploader(@NotNull Lazy<OkHttpClient> lazy, @NotNull HttpUrl httpUrl, @NotNull String str, @NotNull SessionProvider sessionProvider, @NotNull Gson gson, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(lazy, "client");
        Intrinsics.checkNotNullParameter(httpUrl, "endpoint");
        Intrinsics.checkNotNullParameter(str, "origin");
        Intrinsics.checkNotNullParameter(sessionProvider, "sessionProvider");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = lazy;
        this.b = httpUrl;
        this.c = str;
        this.d = sessionProvider;
        this.e = gson;
        this.f = schedulersFactory;
    }

    public static final String access$parseUploadResponse(OkHttpMessengerImageUploader okHttpMessengerImageUploader, Response response) {
        Objects.requireNonNull(okHttpMessengerImageUploader);
        if (response.isSuccessful()) {
            ResponseBody body = response.body();
            if (body != null) {
                JsonObject jsonObject = (JsonObject) okHttpMessengerImageUploader.e.fromJson(body.charStream(), (Class<Object>) JsonObject.class);
                if (!jsonObject.has("error")) {
                    Set<Map.Entry<String, JsonElement>> entrySet = jsonObject.entrySet();
                    Intrinsics.checkNotNullExpressionValue(entrySet, "parsedResponse.entrySet()");
                    Object key = ((Map.Entry) CollectionsKt___CollectionsKt.first(entrySet)).getKey();
                    Intrinsics.checkNotNullExpressionValue(key, "parsedResponse.entrySet().first().key");
                    return (String) key;
                }
                throw new IOException(a2.b.a.a.a.x2(jsonObject, "error", "parsedResponse[\"error\"]"));
            }
            throw new IllegalArgumentException("Required value was null.".toString());
        }
        StringBuilder L = a2.b.a.a.a.L("Image upload failed with response code: ");
        L.append(response.code());
        throw new IOException(L.toString());
    }

    @Override // ru.avito.messenger.MessengerImageUploadApi
    @NotNull
    public Single<String> uploadImage(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        Single<R> map = this.d.session().observeOn(this.f.computation()).map(new a(this, file)).map(new b(this)).observeOn(this.f.io()).map(c.a).observeOn(this.f.computation()).map(new d(this));
        Intrinsics.checkNotNullExpressionValue(map, "sessionProvider.session(…ploadResponse(response) }");
        return map;
    }
}
