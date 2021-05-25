package com.sumsub.sns.core.common;

import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001b\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H¦@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sns/core/common/SNSDocumentRotation;", "", "Landroid/graphics/Bitmap;", "bitmap", "", "detectRotation", "(Landroid/graphics/Bitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public interface SNSDocumentRotation {
    @Nullable
    Object detectRotation(@NotNull Bitmap bitmap, @NotNull Continuation<? super Integer> continuation);
}
