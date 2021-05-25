package net.gotev.uploadservice;

import android.content.Context;
import android.util.Base64;
import com.avito.android.util.preferences.Preference;
import com.google.common.net.HttpHeaders;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import net.gotev.uploadservice.HttpUploadRequest;
import net.gotev.uploadservice.data.HttpUploadTaskParameters;
import net.gotev.uploadservice.data.NameValue;
import net.gotev.uploadservice.extensions.CollectionsExtensionsKt;
import net.gotev.uploadservice.extensions.StringExtensionsKt;
import net.gotev.uploadservice.persistence.PersistableData;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0012\u0004\u0012\u00028\u00000\u0002B\u0017\u0012\u0006\u0010(\u001a\u00020'\u0012\u0006\u0010)\u001a\u00020\u0006¢\u0006\u0004\b*\u0010+J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\nJ\u0015\u0010\u000f\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\nJ+\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00062\u0012\u0010\u0015\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0014\"\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u00062\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018H\u0016¢\u0006\u0004\b\u0016\u0010\u001aJ\u0015\u0010\u001c\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u0006¢\u0006\u0004\b\u001c\u0010\u0010J\u0015\u0010\u001f\u001a\u00028\u00002\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 R\u001c\u0010&\u001a\u00020!8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006,"}, d2 = {"Lnet/gotev/uploadservice/HttpUploadRequest;", "B", "Lnet/gotev/uploadservice/UploadRequest;", "Lnet/gotev/uploadservice/persistence/PersistableData;", "getAdditionalParameters", "()Lnet/gotev/uploadservice/persistence/PersistableData;", "", "headerName", "headerValue", "addHeader", "(Ljava/lang/String;Ljava/lang/String;)Lnet/gotev/uploadservice/HttpUploadRequest;", Preference.USERNAME, Preference.PASSWORD, "setBasicAuth", "bearerToken", "setBearerAuth", "(Ljava/lang/String;)Lnet/gotev/uploadservice/HttpUploadRequest;", "paramName", "paramValue", "addParameter", "", "array", "addArrayParameter", "(Ljava/lang/String;[Ljava/lang/String;)Lnet/gotev/uploadservice/HttpUploadRequest;", "", "list", "(Ljava/lang/String;Ljava/util/List;)Lnet/gotev/uploadservice/HttpUploadRequest;", "method", "setMethod", "", "fixedLength", "setUsesFixedLengthStreamingMode", "(Z)Lnet/gotev/uploadservice/HttpUploadRequest;", "Lnet/gotev/uploadservice/data/HttpUploadTaskParameters;", "h", "Lnet/gotev/uploadservice/data/HttpUploadTaskParameters;", "getHttpParams", "()Lnet/gotev/uploadservice/data/HttpUploadTaskParameters;", "httpParams", "Landroid/content/Context;", "context", "serverUrl", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public abstract class HttpUploadRequest<B extends HttpUploadRequest<B>> extends UploadRequest<B> {
    @NotNull
    public final HttpUploadTaskParameters h = new HttpUploadTaskParameters(null, false, null, null, 15, null);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HttpUploadRequest(@NotNull Context context, @NotNull String str) {
        super(context, str);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "serverUrl");
        if (!StringExtensionsKt.isValidHttpUrl(str)) {
            throw new IllegalArgumentException("Specify either http:// or https:// as protocol".toString());
        }
    }

    @NotNull
    public B addArrayParameter(@NotNull String str, @NotNull String... strArr) {
        Intrinsics.checkNotNullParameter(str, "paramName");
        Intrinsics.checkNotNullParameter(strArr, "array");
        for (String str2 : strArr) {
            this.h.getRequestParameters().add(new NameValue(str, str2));
        }
        return (B) ((HttpUploadRequest) self());
    }

    @NotNull
    public final B addHeader(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "headerName");
        Intrinsics.checkNotNullParameter(str2, "headerValue");
        CollectionsExtensionsKt.addHeader(this.h.getRequestHeaders(), str, str2);
        return (B) ((HttpUploadRequest) self());
    }

    @NotNull
    public B addParameter(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "paramName");
        Intrinsics.checkNotNullParameter(str2, "paramValue");
        this.h.getRequestParameters().add(new NameValue(str, str2));
        return (B) ((HttpUploadRequest) self());
    }

    @Override // net.gotev.uploadservice.UploadRequest
    @NotNull
    public PersistableData getAdditionalParameters() {
        return this.h.toPersistableData();
    }

    @NotNull
    public final HttpUploadTaskParameters getHttpParams() {
        return this.h;
    }

    @NotNull
    public final B setBasicAuth(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, Preference.USERNAME);
        Intrinsics.checkNotNullParameter(str2, Preference.PASSWORD);
        String str3 = str + ':' + str2;
        Charset charset = Charsets.UTF_8;
        Objects.requireNonNull(str3, "null cannot be cast to non-null type java.lang.String");
        byte[] bytes = str3.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return addHeader(HttpHeaders.AUTHORIZATION, "Basic " + Base64.encodeToString(bytes, 2));
    }

    @NotNull
    public final B setBearerAuth(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "bearerToken");
        return addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + str);
    }

    @NotNull
    public final B setMethod(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "method");
        HttpUploadTaskParameters httpUploadTaskParameters = this.h;
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.ROOT");
        String upperCase = str.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        httpUploadTaskParameters.setMethod(upperCase);
        return (B) ((HttpUploadRequest) self());
    }

    @NotNull
    public final B setUsesFixedLengthStreamingMode(boolean z) {
        this.h.setUsesFixedLengthStreamingMode(z);
        return (B) ((HttpUploadRequest) self());
    }

    @NotNull
    public B addArrayParameter(@NotNull String str, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "paramName");
        Intrinsics.checkNotNullParameter(list, "list");
        for (String str2 : list) {
            this.h.getRequestParameters().add(new NameValue(str, str2));
        }
        return (B) ((HttpUploadRequest) self());
    }
}
