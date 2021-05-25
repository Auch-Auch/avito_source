package a2.g.n.a.a;

import android.graphics.Rect;
import com.facebook.fresco.animation.factory.AnimatedFactoryV2Impl;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
public class c implements AnimatedDrawableBackendProvider {
    public final /* synthetic */ AnimatedFactoryV2Impl a;

    public c(AnimatedFactoryV2Impl animatedFactoryV2Impl) {
        this.a = animatedFactoryV2Impl;
    }

    @Override // com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider
    public AnimatedDrawableBackend get(AnimatedImageResult animatedImageResult, Rect rect) {
        AnimatedFactoryV2Impl animatedFactoryV2Impl = this.a;
        if (animatedFactoryV2Impl.g == null) {
            animatedFactoryV2Impl.g = new AnimatedDrawableUtil();
        }
        return new AnimatedDrawableBackendImpl(animatedFactoryV2Impl.g, animatedImageResult, rect, this.a.d);
    }
}
