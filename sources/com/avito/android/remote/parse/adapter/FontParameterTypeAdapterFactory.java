package com.avito.android.remote.parse.adapter;

import com.avito.android.Features;
import com.avito.android.remote.model.text.FontParameter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/parse/adapter/FontParameterTypeAdapterFactory;", "", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/remote/parse/adapter/RuntimeTypeAdapterFactory;", "Lcom/avito/android/remote/model/text/FontParameter;", "create", "(Lcom/avito/android/Features;)Lcom/avito/android/remote/parse/adapter/RuntimeTypeAdapterFactory;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class FontParameterTypeAdapterFactory {
    @NotNull
    public final RuntimeTypeAdapterFactory<FontParameter> create(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        RuntimeTypeAdapterFactory<FontParameter> registerSubtype = RuntimeTypeAdapterFactory.of(FontParameter.class).registerSubtype(FontParameter.StyleParameter.class, "fontStyle").registerSubtype(FontParameter.ColorParameter.class, "fontColor").registerSubtype(FontParameter.StrikethroughParameter.class, "strikeThrough").registerSubtype(FontParameter.TextStyleParameter.class, "textStyle").registerSubtype(FontParameter.ParagraphSpacingRelativeParameter.class, "paragraphSpacingRelative");
        if (features.getNewTextStyles().invoke().booleanValue()) {
            registerSubtype.registerSubtype(FontParameter.UseParagraphingParameter.class, "useParagraphing");
        }
        Intrinsics.checkNotNullExpressionValue(registerSubtype, "factory");
        return registerSubtype;
    }
}
