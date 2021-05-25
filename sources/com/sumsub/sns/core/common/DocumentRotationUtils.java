package com.sumsub.sns.core.common;

import a2.q.a.c.b.a;
import a2.q.a.c.b.b;
import android.graphics.Bitmap;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/sumsub/sns/core/common/DocumentRotationUtils;", "Lcom/sumsub/sns/core/common/SNSDocumentRotation;", "Landroid/graphics/Bitmap;", "bitmap", "", "detectRotation", "(Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/common/SNSDocumentRotation;", "detector", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class DocumentRotationUtils implements SNSDocumentRotation {
    @NotNull
    public static final DocumentRotationUtils INSTANCE = new DocumentRotationUtils();
    public static final SNSDocumentRotation a;

    static {
        SNSDocumentRotation sNSDocumentRotation;
        try {
            Class.forName("com.google.mlkit.vision.face.FaceDetection");
            sNSDocumentRotation = new b();
        } catch (Exception unused) {
            sNSDocumentRotation = new a();
        }
        a = sNSDocumentRotation;
    }

    @Override // com.sumsub.sns.core.common.SNSDocumentRotation
    @Nullable
    public Object detectRotation(@NotNull Bitmap bitmap, @NotNull Continuation<? super Integer> continuation) {
        return a.detectRotation(bitmap, continuation);
    }
}
