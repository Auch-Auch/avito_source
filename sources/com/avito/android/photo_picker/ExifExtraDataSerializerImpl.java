package com.avito.android.photo_picker;

import com.avito.android.remote.auth.AuthSource;
import com.google.gson.Gson;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/photo_picker/ExifExtraDataSerializerImpl;", "Lcom/avito/android/photo_picker/ExifExtraDataSerializer;", "Lcom/avito/android/photo_picker/ExifExtraData;", "extraData", "", "serialize", "(Lcom/avito/android/photo_picker/ExifExtraData;)Ljava/lang/String;", "Lcom/google/gson/Gson;", AuthSource.SEND_ABUSE, "Lcom/google/gson/Gson;", "gson", "<init>", "(Lcom/google/gson/Gson;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class ExifExtraDataSerializerImpl implements ExifExtraDataSerializer {
    public final Gson a;

    @Inject
    public ExifExtraDataSerializerImpl(@NotNull Gson gson) {
        Intrinsics.checkNotNullParameter(gson, "gson");
        this.a = gson;
    }

    @Override // com.avito.android.photo_picker.ExifExtraDataSerializer
    @NotNull
    public String serialize(@NotNull ExifExtraData exifExtraData) {
        Intrinsics.checkNotNullParameter(exifExtraData, "extraData");
        String json = this.a.toJson(exifExtraData);
        Intrinsics.checkNotNullExpressionValue(json, "gson.toJson(extraData)");
        return json;
    }
}
