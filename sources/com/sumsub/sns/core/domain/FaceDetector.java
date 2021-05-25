package com.sumsub.sns.core.domain;

import android.graphics.RectF;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001:\u0004\u0014\u0015\u0016\u0017JS\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\rH&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\rH&¢\u0006\u0004\b\u0013\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/sumsub/sns/core/domain/FaceDetector;", "", "Landroid/graphics/RectF;", "capturingRect", "", "format", "rotation", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "data", "Lkotlin/Function1;", "Lcom/sumsub/sns/core/domain/FaceDetector$FaceDetectorResult;", "", "onResult", "processImage", "(Landroid/graphics/RectF;IIII[BLkotlin/jvm/functions/Function1;)V", Tracker.Events.CREATIVE_START, "()V", "stop", "FaceDetectorResult", "Image", "RawImage", "Size", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public interface FaceDetector {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\b\t\n\u000b\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u0001\u0005\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/core/domain/FaceDetector$FaceDetectorResult;", "", "Lcom/sumsub/sns/core/domain/FaceDetector$RawImage;", AuthSource.SEND_ABUSE, "Lcom/sumsub/sns/core/domain/FaceDetector$RawImage;", "getImage", "()Lcom/sumsub/sns/core/domain/FaceDetector$RawImage;", "image", "Error", "FaceSegment", "NoFace", "NotInCaptureBox", "TooManyFaces", "Lcom/sumsub/sns/core/domain/FaceDetector$FaceDetectorResult$NoFace;", "Lcom/sumsub/sns/core/domain/FaceDetector$FaceDetectorResult$TooManyFaces;", "Lcom/sumsub/sns/core/domain/FaceDetector$FaceDetectorResult$NotInCaptureBox;", "Lcom/sumsub/sns/core/domain/FaceDetector$FaceDetectorResult$FaceSegment;", "Lcom/sumsub/sns/core/domain/FaceDetector$FaceDetectorResult$Error;", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class FaceDetectorResult {
        @NotNull
        public final RawImage a;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\u0010\b\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u000b\u0010\fR\u001d\u0010\b\u001a\u00060\u0002j\u0002`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/sumsub/sns/core/domain/FaceDetector$FaceDetectorResult$Error;", "Lcom/sumsub/sns/core/domain/FaceDetector$FaceDetectorResult;", "Ljava/lang/Exception;", "Lkotlin/Exception;", AuthSource.BOOKING_ORDER, "Ljava/lang/Exception;", "getE", "()Ljava/lang/Exception;", "e", "Lcom/sumsub/sns/core/domain/FaceDetector$RawImage;", "image", "<init>", "(Lcom/sumsub/sns/core/domain/FaceDetector$RawImage;Ljava/lang/Exception;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class Error extends FaceDetectorResult {
            @NotNull
            public final Exception b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Error(@NotNull RawImage rawImage, @NotNull Exception exc) {
                super(rawImage, null);
                Intrinsics.checkNotNullParameter(rawImage, "image");
                Intrinsics.checkNotNullParameter(exc, "e");
                this.b = exc;
            }

            @NotNull
            public final Exception getE() {
                return this.b;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/sumsub/sns/core/domain/FaceDetector$FaceDetectorResult$FaceSegment;", "Lcom/sumsub/sns/core/domain/FaceDetector$FaceDetectorResult;", "Landroid/graphics/RectF;", "c", "Landroid/graphics/RectF;", "getFaceBox", "()Landroid/graphics/RectF;", "faceBox", "Lcom/sumsub/sns/core/domain/FaceDetector$Size;", AuthSource.BOOKING_ORDER, "Lcom/sumsub/sns/core/domain/FaceDetector$Size;", "getTrackSize", "()Lcom/sumsub/sns/core/domain/FaceDetector$Size;", "trackSize", "Lcom/sumsub/sns/core/domain/FaceDetector$RawImage;", "image", "<init>", "(Lcom/sumsub/sns/core/domain/FaceDetector$RawImage;Lcom/sumsub/sns/core/domain/FaceDetector$Size;Landroid/graphics/RectF;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class FaceSegment extends FaceDetectorResult {
            @NotNull
            public final Size b;
            @NotNull
            public final RectF c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public FaceSegment(@NotNull RawImage rawImage, @NotNull Size size, @NotNull RectF rectF) {
                super(rawImage, null);
                Intrinsics.checkNotNullParameter(rawImage, "image");
                Intrinsics.checkNotNullParameter(size, "trackSize");
                Intrinsics.checkNotNullParameter(rectF, "faceBox");
                this.b = size;
                this.c = rectF;
            }

            @NotNull
            public final RectF getFaceBox() {
                return this.c;
            }

            @NotNull
            public final Size getTrackSize() {
                return this.b;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/core/domain/FaceDetector$FaceDetectorResult$NoFace;", "Lcom/sumsub/sns/core/domain/FaceDetector$FaceDetectorResult;", "Lcom/sumsub/sns/core/domain/FaceDetector$RawImage;", "image", "<init>", "(Lcom/sumsub/sns/core/domain/FaceDetector$RawImage;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class NoFace extends FaceDetectorResult {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public NoFace(@NotNull RawImage rawImage) {
                super(rawImage, null);
                Intrinsics.checkNotNullParameter(rawImage, "image");
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/sumsub/sns/core/domain/FaceDetector$FaceDetectorResult$NotInCaptureBox;", "Lcom/sumsub/sns/core/domain/FaceDetector$FaceDetectorResult;", "Landroid/graphics/RectF;", AuthSource.BOOKING_ORDER, "Landroid/graphics/RectF;", "getFaceBox", "()Landroid/graphics/RectF;", "faceBox", "Lcom/sumsub/sns/core/domain/FaceDetector$RawImage;", "image", "<init>", "(Lcom/sumsub/sns/core/domain/FaceDetector$RawImage;Landroid/graphics/RectF;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class NotInCaptureBox extends FaceDetectorResult {
            @NotNull
            public final RectF b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public NotInCaptureBox(@NotNull RawImage rawImage, @NotNull RectF rectF) {
                super(rawImage, null);
                Intrinsics.checkNotNullParameter(rawImage, "image");
                Intrinsics.checkNotNullParameter(rectF, "faceBox");
                this.b = rectF;
            }

            @NotNull
            public final RectF getFaceBox() {
                return this.b;
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/core/domain/FaceDetector$FaceDetectorResult$TooManyFaces;", "Lcom/sumsub/sns/core/domain/FaceDetector$FaceDetectorResult;", "Lcom/sumsub/sns/core/domain/FaceDetector$RawImage;", "image", "<init>", "(Lcom/sumsub/sns/core/domain/FaceDetector$RawImage;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class TooManyFaces extends FaceDetectorResult {
            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public TooManyFaces(@NotNull RawImage rawImage) {
                super(rawImage, null);
                Intrinsics.checkNotNullParameter(rawImage, "image");
            }
        }

        public FaceDetectorResult(RawImage rawImage, j jVar) {
            this.a = rawImage;
        }

        @NotNull
        public final RawImage getImage() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/sumsub/sns/core/domain/FaceDetector$Image;", "", "", AuthSource.SEND_ABUSE, "I", "getWidth", "()I", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, AuthSource.BOOKING_ORDER, "getHeight", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "c", "[B", "getJpeg", "()[B", "jpeg", "<init>", "(II[B)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Image {
        public final int a;
        public final int b;
        @NotNull
        public final byte[] c;

        public Image(int i, int i2, @NotNull byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "jpeg");
            this.a = i;
            this.b = i2;
            this.c = bArr;
        }

        public final int getHeight() {
            return this.b;
        }

        @NotNull
        public final byte[] getJpeg() {
            return this.c;
        }

        public final int getWidth() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0013\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0019\u0010\u0016\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/sumsub/sns/core/domain/FaceDetector$RawImage;", "", "", AuthSource.SEND_ABUSE, "[B", "getData", "()[B", "data", "", "d", "I", "getFormat", "()I", "format", "e", "getRotation", "rotation", "c", "getHeight", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, AuthSource.BOOKING_ORDER, "getWidth", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "<init>", "([BIIII)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class RawImage {
        @NotNull
        public final byte[] a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;

        public RawImage(@NotNull byte[] bArr, int i, int i2, int i3, int i4) {
            Intrinsics.checkNotNullParameter(bArr, "data");
            this.a = bArr;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
        }

        @NotNull
        public final byte[] getData() {
            return this.a;
        }

        public final int getFormat() {
            return this.d;
        }

        public final int getHeight() {
            return this.c;
        }

        public final int getRotation() {
            return this.e;
        }

        public final int getWidth() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/sumsub/sns/core/domain/FaceDetector$Size;", "", "", AuthSource.BOOKING_ORDER, "I", "getHeight", "()I", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, AuthSource.SEND_ABUSE, "getWidth", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "<init>", "(II)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Size {
        public final int a;
        public final int b;

        public Size(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public final int getHeight() {
            return this.b;
        }

        public final int getWidth() {
            return this.a;
        }
    }

    void processImage(@NotNull RectF rectF, int i, int i2, int i3, int i4, @NotNull byte[] bArr, @NotNull Function1<? super FaceDetectorResult, Unit> function1);

    void start();

    void stop();
}
