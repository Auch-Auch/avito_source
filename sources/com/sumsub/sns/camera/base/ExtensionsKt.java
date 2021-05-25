package com.sumsub.sns.camera.base;

import android.graphics.Bitmap;
import com.otaliastudios.cameraview.CameraUtils;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.p.a.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0019\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001b\u0010\u0006\u001a\u00020\u0000*\u00020\u00012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"", "Landroid/graphics/Bitmap;", "toBitmap", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "quality", "toByteArray", "(Landroid/graphics/Bitmap;I)[B", "sns-camera_release"}, k = 2, mv = {1, 4, 2})
public final class ExtensionsKt {
    @Nullable
    public static final Object toBitmap(@NotNull byte[] bArr, @NotNull Continuation<? super Bitmap> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation));
        Bitmap decodeBitmap = CameraUtils.decodeBitmap(bArr);
        Result.Companion companion = Result.Companion;
        safeContinuation.resumeWith(Result.m242constructorimpl(decodeBitmap));
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == a.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    @NotNull
    public static final byte[] toByteArray(@NotNull Bitmap bitmap, int i) {
        Intrinsics.checkNotNullParameter(bitmap, "$this$toByteArray");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, i, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "stream.toByteArray()");
        bitmap.recycle();
        return byteArray;
    }

    public static /* synthetic */ byte[] toByteArray$default(Bitmap bitmap, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 100;
        }
        return toByteArray(bitmap, i);
    }
}
