package com.sumsub.sns.core.domain;

import android.graphics.Rect;
import android.graphics.RectF;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetection;
import com.google.mlkit.vision.face.FaceDetector;
import com.google.mlkit.vision.face.FaceDetectorOptions;
import com.sumsub.sns.core.domain.FaceDetector;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004JS\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/sumsub/sns/core/domain/MLKitFaceDetector;", "Lcom/sumsub/sns/core/domain/FaceDetector;", "", Tracker.Events.CREATIVE_START, "()V", "stop", "Landroid/graphics/RectF;", "capturingBox", "", "format", "rotation", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", "data", "Lkotlin/Function1;", "Lcom/sumsub/sns/core/domain/FaceDetector$FaceDetectorResult;", "onResult", "processImage", "(Landroid/graphics/RectF;IIII[BLkotlin/jvm/functions/Function1;)V", "Lcom/google/mlkit/vision/face/FaceDetector;", AuthSource.SEND_ABUSE, "Lcom/google/mlkit/vision/face/FaceDetector;", "detector", "<init>", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class MLKitFaceDetector implements FaceDetector {
    public FaceDetector a;

    public static final class a<TResult> implements OnSuccessListener<List<Face>> {
        public final /* synthetic */ MLKitFaceDetector a;
        public final /* synthetic */ Function1 b;
        public final /* synthetic */ FaceDetector.RawImage c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;
        public final /* synthetic */ RectF f;

        public a(MLKitFaceDetector mLKitFaceDetector, Function1 function1, FaceDetector.RawImage rawImage, int i, int i2, RectF rectF) {
            this.a = mLKitFaceDetector;
            this.b = function1;
            this.c = rawImage;
            this.d = i;
            this.e = i2;
            this.f = rectF;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.android.gms.tasks.OnSuccessListener
        public void onSuccess(List<Face> list) {
            Object obj;
            List<Face> list2 = list;
            Function1 function1 = this.b;
            if (list2.isEmpty()) {
                obj = new FaceDetector.FaceDetectorResult.NoFace(this.c);
            } else if (list2.size() > 1) {
                obj = new FaceDetector.FaceDetectorResult.TooManyFaces(this.c);
            } else {
                FaceDetector.Size size = new FaceDetector.Size(this.d, this.e);
                MLKitFaceDetector mLKitFaceDetector = this.a;
                RectF rectF = this.f;
                Intrinsics.checkNotNullExpressionValue(list2, "faces");
                Object first = CollectionsKt___CollectionsKt.first((List<? extends Object>) list2);
                Intrinsics.checkNotNullExpressionValue(first, "faces.first()");
                obj = MLKitFaceDetector.access$processFace(mLKitFaceDetector, rectF, (Face) first, this.c, size);
            }
            function1.invoke(obj);
        }
    }

    public static final class b implements OnFailureListener {
        public final /* synthetic */ Function1 a;
        public final /* synthetic */ FaceDetector.RawImage b;

        public b(Function1 function1, FaceDetector.RawImage rawImage) {
            this.a = function1;
            this.b = rawImage;
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(@NotNull Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "e");
            this.a.invoke(new FaceDetector.FaceDetectorResult.Error(this.b, exc));
        }
    }

    public static final FaceDetector.FaceDetectorResult access$processFace(MLKitFaceDetector mLKitFaceDetector, RectF rectF, Face face, FaceDetector.RawImage rawImage, FaceDetector.Size size) {
        Objects.requireNonNull(mLKitFaceDetector);
        Rect boundingBox = face.getBoundingBox();
        Intrinsics.checkNotNullExpressionValue(boundingBox, "face.boundingBox");
        RectF rectF2 = new RectF((((float) size.getWidth()) - ((float) boundingBox.right)) / ((float) size.getWidth()), ((float) boundingBox.top) / ((float) size.getHeight()), (((float) size.getWidth()) - ((float) boundingBox.left)) / ((float) size.getWidth()), ((float) boundingBox.bottom) / ((float) size.getHeight()));
        if (!rectF.contains(rectF2)) {
            return new FaceDetector.FaceDetectorResult.NotInCaptureBox(rawImage, rectF2);
        }
        return new FaceDetector.FaceDetectorResult.FaceSegment(rawImage, size, rectF2);
    }

    @Override // com.sumsub.sns.core.domain.FaceDetector
    public void processImage(@NotNull RectF rectF, int i, int i2, int i3, int i4, @NotNull byte[] bArr, @NotNull Function1<? super FaceDetector.FaceDetectorResult, Unit> function1) {
        Task<List<Face>> process;
        Task<List<Face>> addOnSuccessListener;
        Intrinsics.checkNotNullParameter(rectF, "capturingBox");
        Intrinsics.checkNotNullParameter(bArr, "data");
        Intrinsics.checkNotNullParameter(function1, "onResult");
        InputImage fromByteArray = InputImage.fromByteArray(bArr, i3, i4, i2, i);
        Intrinsics.checkNotNullExpressionValue(fromByteArray, "InputImage.fromByteArray…height, rotation, format)");
        FaceDetector.RawImage rawImage = new FaceDetector.RawImage(bArr, i3, i4, i, i2);
        com.google.mlkit.vision.face.FaceDetector faceDetector = this.a;
        if (faceDetector != null && (process = faceDetector.process(fromByteArray)) != null && (addOnSuccessListener = process.addOnSuccessListener(new a(this, function1, rawImage, i4, i3, rectF))) != null) {
            addOnSuccessListener.addOnFailureListener(new b(function1, rawImage));
        }
    }

    @Override // com.sumsub.sns.core.domain.FaceDetector
    public void start() {
        stop();
        FaceDetectorOptions build = new FaceDetectorOptions.Builder().setPerformanceMode(1).setLandmarkMode(1).setClassificationMode(1).setMinFaceSize(0.4f).build();
        Intrinsics.checkNotNullExpressionValue(build, "FaceDetectorOptions.Buil…\n                .build()");
        this.a = FaceDetection.getClient(build);
    }

    @Override // com.sumsub.sns.core.domain.FaceDetector
    public void stop() {
        com.google.mlkit.vision.face.FaceDetector faceDetector = this.a;
        if (faceDetector != null) {
            faceDetector.close();
        }
        this.a = null;
    }
}
