package com.facebook.drawee.backends.pipeline;

import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.drawee.backends.pipeline.info.ImagePerfDataListener;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
public class DraweeConfig {
    @Nullable
    public final ImmutableList<DrawableFactory> a;
    @Nullable
    public final PipelineDraweeControllerFactory b;
    public final Supplier<Boolean> c;
    @Nullable
    public final ImagePerfDataListener d;

    public static class Builder {
        public List<DrawableFactory> a;
        public Supplier<Boolean> b;
        public PipelineDraweeControllerFactory c;
        @Nullable
        public ImagePerfDataListener d;

        public Builder addCustomDrawableFactory(DrawableFactory drawableFactory) {
            if (this.a == null) {
                this.a = new ArrayList();
            }
            this.a.add(drawableFactory);
            return this;
        }

        public DraweeConfig build() {
            return new DraweeConfig(this, null);
        }

        public Builder setDebugOverlayEnabledSupplier(Supplier<Boolean> supplier) {
            Preconditions.checkNotNull(supplier);
            this.b = supplier;
            return this;
        }

        public Builder setDrawDebugOverlay(boolean z) {
            return setDebugOverlayEnabledSupplier(Suppliers.of(Boolean.valueOf(z)));
        }

        public Builder setImagePerfDataListener(@Nullable ImagePerfDataListener imagePerfDataListener) {
            this.d = imagePerfDataListener;
            return this;
        }

        public Builder setPipelineDraweeControllerFactory(PipelineDraweeControllerFactory pipelineDraweeControllerFactory) {
            this.c = pipelineDraweeControllerFactory;
            return this;
        }
    }

    public DraweeConfig(Builder builder, a aVar) {
        List<DrawableFactory> list = builder.a;
        this.a = list != null ? ImmutableList.copyOf(list) : null;
        Supplier<Boolean> supplier = builder.b;
        this.c = supplier == null ? Suppliers.of(Boolean.FALSE) : supplier;
        this.b = builder.c;
        this.d = builder.d;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Nullable
    public ImmutableList<DrawableFactory> getCustomDrawableFactories() {
        return this.a;
    }

    public Supplier<Boolean> getDebugOverlayEnabledSupplier() {
        return this.c;
    }

    @Nullable
    public ImagePerfDataListener getImagePerfDataListener() {
        return this.d;
    }

    @Nullable
    public PipelineDraweeControllerFactory getPipelineDraweeControllerFactory() {
        return this.b;
    }
}
