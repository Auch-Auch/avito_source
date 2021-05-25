package com.facebook.drawee.backends.pipeline;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.Supplier;
import com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener;
import com.facebook.drawee.components.DeferredReleaser;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.fresco.ui.common.ControllerListener2;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import java.util.Set;
import javax.annotation.Nullable;
public class PipelineDraweeControllerBuilderSupplier implements Supplier<PipelineDraweeControllerBuilder> {
    public final Context a;
    public final ImagePipeline b;
    public final PipelineDraweeControllerFactory c;
    public final Set<ControllerListener> d;
    public final Set<ControllerListener2> e;
    @Nullable
    public final ImagePerfDataListener f;

    public PipelineDraweeControllerBuilderSupplier(Context context) {
        this(context, null);
    }

    public PipelineDraweeControllerBuilderSupplier(Context context, @Nullable DraweeConfig draweeConfig) {
        this(context, ImagePipelineFactory.getInstance(), draweeConfig);
    }

    @Override // com.facebook.common.internal.Supplier
    public PipelineDraweeControllerBuilder get() {
        return new PipelineDraweeControllerBuilder(this.a, this.c, this.b, this.d, this.e).setPerfDataListener(this.f);
    }

    public PipelineDraweeControllerBuilderSupplier(Context context, ImagePipelineFactory imagePipelineFactory, @Nullable DraweeConfig draweeConfig) {
        this(context, imagePipelineFactory, null, null, draweeConfig);
    }

    public PipelineDraweeControllerBuilderSupplier(Context context, ImagePipelineFactory imagePipelineFactory, Set<ControllerListener> set, Set<ControllerListener2> set2, @Nullable DraweeConfig draweeConfig) {
        this.a = context;
        ImagePipeline imagePipeline = imagePipelineFactory.getImagePipeline();
        this.b = imagePipeline;
        if (draweeConfig == null || draweeConfig.getPipelineDraweeControllerFactory() == null) {
            this.c = new PipelineDraweeControllerFactory();
        } else {
            this.c = draweeConfig.getPipelineDraweeControllerFactory();
        }
        PipelineDraweeControllerFactory pipelineDraweeControllerFactory = this.c;
        Resources resources = context.getResources();
        DeferredReleaser instance = DeferredReleaser.getInstance();
        DrawableFactory animatedDrawableFactory = imagePipelineFactory.getAnimatedDrawableFactory(context);
        ImagePerfDataListener imagePerfDataListener = null;
        pipelineDraweeControllerFactory.init(resources, instance, animatedDrawableFactory, UiThreadImmediateExecutorService.getInstance(), imagePipeline.getBitmapMemoryCache(), draweeConfig != null ? draweeConfig.getCustomDrawableFactories() : null, draweeConfig != null ? draweeConfig.getDebugOverlayEnabledSupplier() : null);
        this.d = set;
        this.e = set2;
        this.f = draweeConfig != null ? draweeConfig.getImagePerfDataListener() : imagePerfDataListener;
    }
}
