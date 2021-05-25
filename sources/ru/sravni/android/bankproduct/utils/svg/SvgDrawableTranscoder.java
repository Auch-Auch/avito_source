package ru.sravni.android.bankproduct.utils.svg;

import android.graphics.drawable.PictureDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.SimpleResource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.caverock.androidsvg.SVG;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00042\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lru/sravni/android/bankproduct/utils/svg/SvgDrawableTranscoder;", "Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;", "Lcom/caverock/androidsvg/SVG;", "Landroid/graphics/drawable/PictureDrawable;", "Lcom/bumptech/glide/load/engine/Resource;", "toTranscode", "Lcom/bumptech/glide/load/Options;", "options", "transcode", "(Lcom/bumptech/glide/load/engine/Resource;Lcom/bumptech/glide/load/Options;)Lcom/bumptech/glide/load/engine/Resource;", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SvgDrawableTranscoder implements ResourceTranscoder<SVG, PictureDrawable> {
    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    @Nullable
    public Resource<PictureDrawable> transcode(@NotNull Resource<SVG> resource, @NotNull Options options) {
        Intrinsics.checkParameterIsNotNull(resource, "toTranscode");
        Intrinsics.checkParameterIsNotNull(options, "options");
        SVG svg = resource.get();
        Intrinsics.checkExpressionValueIsNotNull(svg, "toTranscode.get()");
        return new SimpleResource(new PictureDrawable(svg.renderToPicture()));
    }
}
