package net.gotev.uploadservice;

import a2.b.a.a.a;
import a2.g.r.g;
import android.content.Context;
import androidx.lifecycle.LifecycleOwner;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import net.gotev.uploadservice.UploadRequest;
import net.gotev.uploadservice.data.UploadFile;
import net.gotev.uploadservice.data.UploadNotificationConfig;
import net.gotev.uploadservice.data.UploadTaskParameters;
import net.gotev.uploadservice.extensions.ContextExtensionsKt;
import net.gotev.uploadservice.observer.request.RequestObserver;
import net.gotev.uploadservice.observer.request.RequestObserverDelegate;
import net.gotev.uploadservice.persistence.Persistable;
import net.gotev.uploadservice.persistence.PersistableData;
import org.jetbrains.annotations.NotNull;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0002B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010V\u001a\u00020\u0003¢\u0006\u0004\bW\u0010XJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ%\u0010\t\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\t\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H$¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0015\u0010\u0016JE\u0010\u001d\u001a\u00028\u000026\u0010\u001c\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010!\u001a\u00028\u00002\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"J\u0015\u0010%\u001a\u00028\u00002\u0006\u0010$\u001a\u00020#¢\u0006\u0004\b%\u0010&J\u0015\u0010(\u001a\u00028\u00002\u0006\u0010'\u001a\u00020\u0003¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020\u0012H\u0016¢\u0006\u0004\b*\u0010\u0014R\u0016\u0010.\u001a\u00020+8B@\u0002X\u0004¢\u0006\u0006\u001a\u0004\b,\u0010-R\u001e\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u0002000/8$@$X¤\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\"\u0010$\u001a\u00020#8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b%\u00108R\"\u0010?\u001a\b\u0012\u0004\u0012\u00020:098\u0004@\u0004X\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>RR\u0010E\u001a2\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u00178\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\b\u001d\u0010DR\u001c\u0010\f\u001a\u00020\u000b8\u0004@\u0004X\u0004¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\"\u0010P\u001a\u00020\u001f8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0016\u0010\u001a\u001a\u00020\u00038\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b,\u0010QR\"\u0010V\u001a\u00020\u00038\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\bR\u0010Q\u001a\u0004\bS\u0010\u0005\"\u0004\bT\u0010U¨\u0006Y"}, d2 = {"Lnet/gotev/uploadservice/UploadRequest;", "B", "Lnet/gotev/uploadservice/persistence/Persistable;", "", "startUpload", "()Ljava/lang/String;", "Lnet/gotev/uploadservice/observer/request/RequestObserver;", "observer", "", "subscribe", "(Lnet/gotev/uploadservice/observer/request/RequestObserver;)V", "Landroid/content/Context;", "context", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lnet/gotev/uploadservice/observer/request/RequestObserverDelegate;", "delegate", "(Landroid/content/Context;Landroidx/lifecycle/LifecycleOwner;Lnet/gotev/uploadservice/observer/request/RequestObserverDelegate;)Lnet/gotev/uploadservice/observer/request/RequestObserver;", "Lnet/gotev/uploadservice/persistence/PersistableData;", "getAdditionalParameters", "()Lnet/gotev/uploadservice/persistence/PersistableData;", "self", "()Lnet/gotev/uploadservice/UploadRequest;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "uploadId", "Lnet/gotev/uploadservice/data/UploadNotificationConfig;", Navigation.CONFIG, "setNotificationConfig", "(Lkotlin/jvm/functions/Function2;)Lnet/gotev/uploadservice/UploadRequest;", "", "autoDeleteFiles", "setAutoDeleteFilesAfterSuccessfulUpload", "(Z)Lnet/gotev/uploadservice/UploadRequest;", "", "maxRetries", "setMaxRetries", "(I)Lnet/gotev/uploadservice/UploadRequest;", "uploadID", "setUploadID", "(Ljava/lang/String;)Lnet/gotev/uploadservice/UploadRequest;", "toPersistableData", "Lnet/gotev/uploadservice/data/UploadTaskParameters;", AuthSource.SEND_ABUSE, "()Lnet/gotev/uploadservice/data/UploadTaskParameters;", "uploadTaskParameters", "Ljava/lang/Class;", "Lnet/gotev/uploadservice/UploadTask;", "getTaskClass", "()Ljava/lang/Class;", "taskClass", AuthSource.BOOKING_ORDER, "I", "getMaxRetries", "()I", "(I)V", "Ljava/util/ArrayList;", "Lnet/gotev/uploadservice/data/UploadFile;", "e", "Ljava/util/ArrayList;", "getFiles", "()Ljava/util/ArrayList;", "files", "d", "Lkotlin/jvm/functions/Function2;", "getNotificationConfig", "()Lkotlin/jvm/functions/Function2;", "(Lkotlin/jvm/functions/Function2;)V", "notificationConfig", "f", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "c", "Z", "getAutoDeleteSuccessfullyUploadedFiles", "()Z", "setAutoDeleteSuccessfullyUploadedFiles", "(Z)V", "autoDeleteSuccessfullyUploadedFiles", "Ljava/lang/String;", g.a, "getServerUrl", "setServerUrl", "(Ljava/lang/String;)V", "serverUrl", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "uploadservice_release"}, k = 1, mv = {1, 4, 0})
public abstract class UploadRequest<B extends UploadRequest<B>> implements Persistable {
    public String a = a.I2("UUID.randomUUID().toString()");
    public int b = UploadServiceConfig.getRetryPolicy().getDefaultMaxRetries();
    public boolean c;
    @NotNull
    public Function2<? super Context, ? super String, UploadNotificationConfig> d = UploadServiceConfig.getNotificationConfigFactory();
    @NotNull
    public final ArrayList<UploadFile> e = new ArrayList<>();
    @NotNull
    public final Context f;
    @NotNull
    public String g;

    public UploadRequest(@NotNull Context context, @NotNull String str) throws IllegalArgumentException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "serverUrl");
        this.f = context;
        this.g = str;
        if (!(!m.isBlank(this.g))) {
            throw new IllegalArgumentException("Server URL cannot be empty".toString());
        }
    }

    public final UploadTaskParameters a() {
        String name = getTaskClass().getName();
        Intrinsics.checkNotNullExpressionValue(name, "taskClass.name");
        return new UploadTaskParameters(name, this.a, this.g, this.b, this.c, this.e, getAdditionalParameters());
    }

    @NotNull
    public abstract PersistableData getAdditionalParameters();

    public final boolean getAutoDeleteSuccessfullyUploadedFiles() {
        return this.c;
    }

    @NotNull
    public final Context getContext() {
        return this.f;
    }

    @NotNull
    public final ArrayList<UploadFile> getFiles() {
        return this.e;
    }

    public final int getMaxRetries() {
        return this.b;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function2<? super android.content.Context, ? super java.lang.String, net.gotev.uploadservice.data.UploadNotificationConfig>, kotlin.jvm.functions.Function2<android.content.Context, java.lang.String, net.gotev.uploadservice.data.UploadNotificationConfig> */
    @NotNull
    public final Function2<Context, String, UploadNotificationConfig> getNotificationConfig() {
        return this.d;
    }

    @NotNull
    public final String getServerUrl() {
        return this.g;
    }

    @NotNull
    public abstract Class<? extends UploadTask> getTaskClass();

    @NotNull
    public final B self() {
        return this;
    }

    @NotNull
    public final B setAutoDeleteFilesAfterSuccessfulUpload(boolean z) {
        this.c = z;
        return self();
    }

    public final void setAutoDeleteSuccessfullyUploadedFiles(boolean z) {
        this.c = z;
    }

    /* renamed from: setMaxRetries  reason: collision with other method in class */
    public final void m540setMaxRetries(int i) {
        this.b = i;
    }

    /* renamed from: setNotificationConfig  reason: collision with other method in class */
    public final void m541setNotificationConfig(@NotNull Function2<? super Context, ? super String, UploadNotificationConfig> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.d = function2;
    }

    public final void setServerUrl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.g = str;
    }

    @NotNull
    public final B setUploadID(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "uploadID");
        this.a = str;
        return self();
    }

    @NotNull
    public String startUpload() {
        return ContextExtensionsKt.startNewUpload(this.f, a(), this.d.invoke(this.f, this.a));
    }

    public final void subscribe(@NotNull RequestObserver requestObserver) {
        Intrinsics.checkNotNullParameter(requestObserver, "observer");
        requestObserver.subscribe(this);
    }

    @Override // net.gotev.uploadservice.persistence.Persistable
    @NotNull
    public PersistableData toPersistableData() {
        return a().toPersistableData();
    }

    @NotNull
    public final B setMaxRetries(int i) {
        this.b = i;
        return self();
    }

    @NotNull
    public final B setNotificationConfig(@NotNull Function2<? super Context, ? super String, UploadNotificationConfig> function2) {
        Intrinsics.checkNotNullParameter(function2, Navigation.CONFIG);
        this.d = function2;
        return self();
    }

    @NotNull
    public final RequestObserver subscribe(@NotNull Context context, @NotNull LifecycleOwner lifecycleOwner, @NotNull RequestObserverDelegate requestObserverDelegate) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(requestObserverDelegate, "delegate");
        RequestObserver requestObserver = new RequestObserver(context, lifecycleOwner, requestObserverDelegate, null, 8, null);
        requestObserver.subscribe(this);
        return requestObserver;
    }
}
