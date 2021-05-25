package com.avito.android.photo_picker.legacy.service;

import android.content.Context;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/photo_picker/legacy/service/UploadingInteractorImpl;", "Lcom/avito/android/photo_picker/legacy/service/UploadingInteractor;", "", "photoId", "", "startUpload", "(Ljava/lang/String;)V", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "operationId", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "", "c", "Z", "uploadAfterNonRestorableError", "<init>", "(Landroid/content/Context;Ljava/lang/String;Z)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class UploadingInteractorImpl implements UploadingInteractor {
    public final Context a;
    public final String b;
    public final boolean c;

    public UploadingInteractorImpl(@NotNull Context context, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "operationId");
        this.a = context;
        this.b = str;
        this.c = z;
    }

    @Override // com.avito.android.photo_picker.legacy.service.UploadingInteractor
    public void startUpload(@Nullable String str) {
        Context context = this.a;
        context.startService(ImageUploadServiceKt.createImageUploadServiceIntent(context, this.b, str, this.c));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UploadingInteractorImpl(Context context, String str, boolean z, int i, j jVar) {
        this(context, str, (i & 4) != 0 ? false : z);
    }
}
