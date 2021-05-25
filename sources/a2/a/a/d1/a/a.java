package a2.a.a.d1.a;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.util.Size;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.performance.PerformanceImageTracker;
import com.avito.android.util.Logs;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.Objects;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public final class a implements ControllerListener<ImageInfo> {
    public long a;
    public final Uri b;
    public final ImageRequest.SourcePlace c;
    public final Uri d;
    public final Size e;
    public final String f;
    public final Function0<Boolean> g;
    public final ControllerListener<ImageInfo> h;

    public a(@Nullable Uri uri, @NotNull ImageRequest.SourcePlace sourcePlace, @Nullable Uri uri2, @NotNull Size size, @Nullable String str, @NotNull Function0<Boolean> function0, @Nullable ControllerListener<ImageInfo> controllerListener) {
        Intrinsics.checkNotNullParameter(sourcePlace, "sourcePlace");
        Intrinsics.checkNotNullParameter(size, "viewPortSize");
        Intrinsics.checkNotNullParameter(function0, "isConnectionAvailable");
        this.b = uri;
        this.c = sourcePlace;
        this.d = uri2;
        this.e = size;
        this.f = str;
        this.g = function0;
        this.h = controllerListener;
    }

    /* renamed from: a */
    public void onFinalImageSet(@NotNull String str, @Nullable ImageInfo imageInfo, @Nullable Animatable animatable) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (!(this.b == null || imageInfo == null)) {
            PerformanceImageTracker.INSTANCE.reportLoaded(this.b, System.currentTimeMillis() - this.a, imageInfo.getWidth(), imageInfo.getHeight());
        }
        ControllerListener<ImageInfo> controllerListener = this.h;
        if (controllerListener != null) {
            controllerListener.onFinalImageSet(str, imageInfo, animatable);
        }
    }

    /* renamed from: b */
    public void onIntermediateImageSet(@NotNull String str, @Nullable ImageInfo imageInfo) {
        Intrinsics.checkNotNullParameter(str, "id");
        ControllerListener<ImageInfo> controllerListener = this.h;
        if (controllerListener != null) {
            controllerListener.onIntermediateImageSet(str, imageInfo);
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onFailure(@NotNull String str, @Nullable Throwable th) {
        String str2;
        Intrinsics.checkNotNullParameter(str, "id");
        ControllerListener<ImageInfo> controllerListener = this.h;
        if (controllerListener != null) {
            controllerListener.onFailure(str, th);
        }
        if (this.b != null) {
            PerformanceImageTracker.INSTANCE.reportFailed(this.b, System.currentTimeMillis() - this.a, th);
        }
        StringBuilder L = a2.b.a.a.a.L("\nImage load failed from ");
        L.append(this.c.name());
        L.append("\n with uri=");
        Uri uri = this.d;
        if (uri == null || (str2 = uri.toString()) == null) {
            str2 = "empty";
        }
        L.append(str2);
        L.append("\n with viewPort=(");
        L.append(this.e.getWidth());
        L.append('X');
        L.append(this.e.getHeight());
        L.append(")\n advertId=");
        String str3 = this.f;
        if (str3 == null) {
            str3 = "none";
        }
        L.append(str3);
        L.append("\n isConnectionAvailable=");
        L.append(this.g.invoke().booleanValue());
        L.append(" |\n                ");
        String sb = L.toString();
        Objects.requireNonNull(sb, "null cannot be cast to non-null type kotlin.CharSequence");
        Logs.error("Fresco", StringsKt__StringsKt.trim(sb).toString(), th);
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onIntermediateImageFailed(@NotNull String str, @Nullable Throwable th) {
        Intrinsics.checkNotNullParameter(str, "id");
        ControllerListener<ImageInfo> controllerListener = this.h;
        if (controllerListener != null) {
            controllerListener.onIntermediateImageFailed(str, th);
        }
        Logs.error("Fresco", "Intermediate image load failed", th);
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onRelease(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        ControllerListener<ImageInfo> controllerListener = this.h;
        if (controllerListener != null) {
            controllerListener.onRelease(str);
        }
    }

    @Override // com.facebook.drawee.controller.ControllerListener
    public void onSubmit(@NotNull String str, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(str, "id");
        if (this.b != null) {
            this.a = System.currentTimeMillis();
            PerformanceImageTracker.INSTANCE.reportSubmit(this.b);
        }
        ControllerListener<ImageInfo> controllerListener = this.h;
        if (controllerListener != null) {
            controllerListener.onSubmit(str, obj);
        }
    }
}
