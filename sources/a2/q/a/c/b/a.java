package a2.q.a.c.b;

import android.graphics.Bitmap;
import com.sumsub.sns.core.common.SNSDocumentRotation;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class a implements SNSDocumentRotation {
    @Override // com.sumsub.sns.core.common.SNSDocumentRotation
    @Nullable
    public Object detectRotation(@NotNull Bitmap bitmap, @NotNull Continuation<? super Integer> continuation) {
        return Boxing.boxInt(0);
    }
}
