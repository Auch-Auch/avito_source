package ru.sravni.android.bankproduct.utils.svg;

import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.SimpleResource;
import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ7\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\r2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lru/sravni/android/bankproduct/utils/svg/SvgDecoder;", "Lcom/bumptech/glide/load/ResourceDecoder;", "Ljava/io/InputStream;", "Lcom/caverock/androidsvg/SVG;", "source", "Lcom/bumptech/glide/load/Options;", "options", "", "handles", "(Ljava/io/InputStream;Lcom/bumptech/glide/load/Options;)Z", "", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "Lcom/bumptech/glide/load/engine/Resource;", "decode", "(Ljava/io/InputStream;IILcom/bumptech/glide/load/Options;)Lcom/bumptech/glide/load/engine/Resource;", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class SvgDecoder implements ResourceDecoder<InputStream, SVG> {
    public boolean handles(@NotNull InputStream inputStream, @NotNull Options options) {
        Intrinsics.checkParameterIsNotNull(inputStream, "source");
        Intrinsics.checkParameterIsNotNull(options, "options");
        return true;
    }

    @Nullable
    public Resource<SVG> decode(@NotNull InputStream inputStream, int i, int i2, @NotNull Options options) throws IOException {
        Intrinsics.checkParameterIsNotNull(inputStream, "source");
        Intrinsics.checkParameterIsNotNull(options, "options");
        try {
            return new SimpleResource(SVG.getFromInputStream(inputStream));
        } catch (SVGParseException e) {
            throw new IOException("Cannot load SVG from stream", e);
        }
    }
}
