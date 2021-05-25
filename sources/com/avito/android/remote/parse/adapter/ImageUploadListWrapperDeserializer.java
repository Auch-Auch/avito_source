package com.avito.android.remote.parse.adapter;

import com.avito.android.remote.model.ExtendedImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ImageUploadResult;
import com.avito.android.remote.model.category_parameters.PhotoParameter;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/parse/adapter/ImageUploadListWrapperDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/category_parameters/PhotoParameter$ImageUploadListWrapper;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/category_parameters/PhotoParameter$ImageUploadListWrapper;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ImageUploadListWrapperDeserializer implements JsonDeserializer<PhotoParameter.ImageUploadListWrapper> {
    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public PhotoParameter.ImageUploadListWrapper deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
        Image image;
        Intrinsics.checkNotNullParameter(jsonElement, "json");
        Intrinsics.checkNotNullParameter(type, "typeOfT");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        Object deserialize = jsonDeserializationContext.deserialize(jsonElement, ImageUploadListWrapperDeserializerKt.access$getIMAGE_UPLOAD_RESULT_TYPE_TOKEN$p().getType());
        Intrinsics.checkNotNullExpressionValue(deserialize, "context.deserialize<List…D_RESULT_TYPE_TOKEN.type)");
        ArrayList<ExtendedImage> arrayList = new ArrayList();
        for (Object obj : (Iterable) deserialize) {
            if (((ExtendedImage) obj).getId() != null) {
                arrayList.add(obj);
            }
        }
        PhotoParameter.ImageUploadListWrapper imageUploadListWrapper = new PhotoParameter.ImageUploadListWrapper(new ArrayList());
        for (ExtendedImage extendedImage : arrayList) {
            Image original = extendedImage.getOriginal();
            if (original != null) {
                image = new Image(r.plus(extendedImage.getImage().getVariants(), original.getVariants()));
            } else {
                image = extendedImage.getImage();
            }
            String id = extendedImage.getId();
            Intrinsics.checkNotNull(id);
            imageUploadListWrapper.add((PhotoParameter.ImageUploadListWrapper) new ImageUploadResult(id, image));
        }
        return imageUploadListWrapper;
    }
}
