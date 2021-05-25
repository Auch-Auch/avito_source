package a2.q.a.c.b;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceDetector;
import com.sumsub.sns.core.common.SNSDocumentRotation;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class b implements SNSDocumentRotation {

    public static final class a implements OnCanceledListener {
        public final /* synthetic */ CancellableContinuation a;
        public final /* synthetic */ FaceDetector b;

        public a(CancellableContinuation cancellableContinuation, FaceDetector faceDetector, InputImage inputImage) {
            this.a = cancellableContinuation;
            this.b = faceDetector;
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public final void onCanceled() {
            this.b.close();
            CancellableContinuation cancellableContinuation = this.a;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m242constructorimpl(0));
        }
    }

    /* renamed from: a2.q.a.c.b.b$b  reason: collision with other inner class name */
    public static final class C0103b implements OnFailureListener {
        public final /* synthetic */ CancellableContinuation a;
        public final /* synthetic */ FaceDetector b;

        public C0103b(CancellableContinuation cancellableContinuation, FaceDetector faceDetector, InputImage inputImage) {
            this.a = cancellableContinuation;
            this.b = faceDetector;
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(@NotNull Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "it");
            this.b.close();
            CancellableContinuation cancellableContinuation = this.a;
            Result.Companion companion = Result.Companion;
            cancellableContinuation.resumeWith(Result.m242constructorimpl(ResultKt.createFailure(exc)));
        }
    }

    public static final class c<TResult> implements OnSuccessListener<List<Face>> {
        public final /* synthetic */ CancellableContinuation a;
        public final /* synthetic */ FaceDetector b;

        public c(CancellableContinuation cancellableContinuation, FaceDetector faceDetector, InputImage inputImage) {
            this.a = cancellableContinuation;
            this.b = faceDetector;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.android.gms.tasks.OnSuccessListener
        public void onSuccess(List<Face> list) {
            List<Face> list2 = list;
            Intrinsics.checkNotNullExpressionValue(list2, "faces");
            Face face = (Face) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
            this.b.close();
            if (face == null) {
                CancellableContinuation cancellableContinuation = this.a;
                Result.Companion companion = Result.Companion;
                cancellableContinuation.resumeWith(Result.m242constructorimpl(0));
                this.b.close();
                return;
            }
            CancellableContinuation cancellableContinuation2 = this.a;
            Integer valueOf = Integer.valueOf((int) face.getHeadEulerAngleZ());
            Result.Companion companion2 = Result.Companion;
            cancellableContinuation2.resumeWith(Result.m242constructorimpl(valueOf));
        }
    }

    @DebugMetadata(c = "com.sumsub.sns.core.common.MLKitDocumentRotationDetector", f = "DocumentRotationUtils.kt", i = {}, l = {71}, m = "detectRotation", n = {}, s = {})
    public static final class d extends ContinuationImpl {
        public /* synthetic */ Object a;
        public int b;
        public final /* synthetic */ b c;
        public Object d;
        public Object e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(b bVar, Continuation continuation) {
            super(continuation);
            this.c = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.a = obj;
            this.b |= Integer.MIN_VALUE;
            return this.c.detectRotation(null, this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.sumsub.sns.core.common.SNSDocumentRotation
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object detectRotation(@org.jetbrains.annotations.NotNull android.graphics.Bitmap r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.Integer> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof a2.q.a.c.b.b.d
            if (r0 == 0) goto L_0x0013
            r0 = r8
            a2.q.a.c.b.b$d r0 = (a2.q.a.c.b.b.d) r0
            int r1 = r0.b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.b = r1
            goto L_0x0018
        L_0x0013:
            a2.q.a.c.b.b$d r0 = new a2.q.a.c.b.b$d
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            int r2 = r0.b
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r4) goto L_0x0032
            java.lang.Object r7 = r0.e
            com.google.mlkit.vision.common.InputImage r7 = (com.google.mlkit.vision.common.InputImage) r7
            java.lang.Object r7 = r0.d
            com.google.mlkit.vision.face.FaceDetector r7 = (com.google.mlkit.vision.face.FaceDetector) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ Exception -> 0x00b0 }
            goto L_0x00aa
        L_0x0032:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r8)
            com.google.mlkit.vision.face.FaceDetectorOptions$Builder r8 = new com.google.mlkit.vision.face.FaceDetectorOptions$Builder
            r8.<init>()
            r2 = 2
            com.google.mlkit.vision.face.FaceDetectorOptions$Builder r8 = r8.setPerformanceMode(r2)
            com.google.mlkit.vision.face.FaceDetectorOptions$Builder r8 = r8.setLandmarkMode(r2)
            com.google.mlkit.vision.face.FaceDetectorOptions$Builder r8 = r8.setClassificationMode(r2)
            com.google.mlkit.vision.face.FaceDetectorOptions r8 = r8.build()
            java.lang.String r2 = "FaceDetectorOptions.Buil…                 .build()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)
            com.google.mlkit.vision.face.FaceDetector r8 = com.google.mlkit.vision.face.FaceDetection.getClient(r8)
            java.lang.String r2 = "FaceDetection.getClient(highAccuracyOpts)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)
            com.google.mlkit.vision.common.InputImage r7 = com.google.mlkit.vision.common.InputImage.fromBitmap(r7, r3)
            java.lang.String r2 = "InputImage.fromBitmap(bitmap, 0)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r2)
            r0.d = r8
            r0.e = r7
            r0.b = r4
            kotlinx.coroutines.CancellableContinuationImpl r2 = new kotlinx.coroutines.CancellableContinuationImpl
            kotlin.coroutines.Continuation r5 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r0)
            r2.<init>(r5, r4)
            r2.initCancellability()
            com.google.android.gms.tasks.Task r4 = r8.process(r7)
            a2.q.a.c.b.b$a r5 = new a2.q.a.c.b.b$a
            r5.<init>(r2, r8, r7)
            com.google.android.gms.tasks.Task r4 = r4.addOnCanceledListener(r5)
            a2.q.a.c.b.b$b r5 = new a2.q.a.c.b.b$b
            r5.<init>(r2, r8, r7)
            com.google.android.gms.tasks.Task r4 = r4.addOnFailureListener(r5)
            a2.q.a.c.b.b$c r5 = new a2.q.a.c.b.b$c
            r5.<init>(r2, r8, r7)
            r4.addOnSuccessListener(r5)
            java.lang.Object r8 = r2.getResult()
            java.lang.Object r7 = t6.p.a.a.getCOROUTINE_SUSPENDED()
            if (r8 != r7) goto L_0x00a7
            kotlin.coroutines.jvm.internal.DebugProbesKt.probeCoroutineSuspended(r0)
        L_0x00a7:
            if (r8 != r1) goto L_0x00aa
            return r1
        L_0x00aa:
            java.lang.Number r8 = (java.lang.Number) r8
            int r3 = r8.intValue()
        L_0x00b0:
            java.lang.Integer r7 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r3)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.q.a.c.b.b.detectRotation(android.graphics.Bitmap, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
