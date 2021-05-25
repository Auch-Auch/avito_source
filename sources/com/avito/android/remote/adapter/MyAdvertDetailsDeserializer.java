package com.avito.android.remote.adapter;

import com.avito.android.Features;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.adverts.MyAdvertDetails;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\t\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ-\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/adapter/MyAdvertDetailsDeserializer;", "Lcom/google/gson/JsonDeserializer;", "Lcom/avito/android/remote/model/adverts/MyAdvertDetails;", "Lcom/google/gson/JsonElement;", "json", "Ljava/lang/reflect/Type;", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "context", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/avito/android/remote/model/adverts/MyAdvertDetails;", "Lcom/google/gson/JsonObject;", "jsonObject", "", "dictionaryName", "id", AuthSource.SEND_ABUSE, "(Lcom/google/gson/JsonObject;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Lcom/avito/android/Features;", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/Features;)V", "user-advert_release"}, k = 1, mv = {1, 4, 2})
public final class MyAdvertDetailsDeserializer implements JsonDeserializer<MyAdvertDetails> {
    public final Features a;

    public MyAdvertDetailsDeserializer(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = features;
    }

    public final String a(JsonObject jsonObject, String str, String str2) {
        JsonElement jsonElement;
        JsonObject asJsonObject;
        JsonElement jsonElement2;
        JsonObject asJsonObject2;
        JsonElement jsonElement3;
        if ((str2 == null || str2.length() == 0) || jsonObject == null || (jsonElement = jsonObject.get(str)) == null || (asJsonObject = jsonElement.getAsJsonObject()) == null || (jsonElement2 = asJsonObject.get(str2)) == null || (asJsonObject2 = jsonElement2.getAsJsonObject()) == null || (jsonElement3 = asJsonObject2.get("name")) == null) {
            return null;
        }
        return jsonElement3.getAsString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:156:0x0344  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x034b  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0360  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x0367  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0374  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x037b  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x0388  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x038d  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0398  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x039d  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x03a0  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x03d6  */
    /* JADX WARNING: Removed duplicated region for block: B:186:0x03e3  */
    /* JADX WARNING: Removed duplicated region for block: B:187:0x03e8  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x03f3  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0404  */
    /* JADX WARNING: Removed duplicated region for block: B:198:0x040f  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x0414  */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0441  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0454  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x045f  */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x0466  */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x0473  */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x047a  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x0487  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x048e  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x049b  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x04a2  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x04b9  */
    /* JADX WARNING: Removed duplicated region for block: B:231:0x04cc  */
    /* JADX WARNING: Removed duplicated region for block: B:234:0x04d7  */
    /* JADX WARNING: Removed duplicated region for block: B:235:0x04dc  */
    /* JADX WARNING: Removed duplicated region for block: B:237:0x04df  */
    /* JADX WARNING: Removed duplicated region for block: B:245:0x0517  */
    /* JADX WARNING: Removed duplicated region for block: B:248:0x0526  */
    /* JADX WARNING: Removed duplicated region for block: B:249:0x052d  */
    /* JADX WARNING: Removed duplicated region for block: B:252:0x053a  */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x0541  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0556  */
    /* JADX WARNING: Removed duplicated region for block: B:261:0x0569  */
    /* JADX WARNING: Removed duplicated region for block: B:264:0x057e  */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x0591  */
    /* JADX WARNING: Removed duplicated region for block: B:272:0x05a6  */
    /* JADX WARNING: Removed duplicated region for block: B:277:0x05b9  */
    /* JADX WARNING: Removed duplicated region for block: B:280:0x05ce  */
    /* JADX WARNING: Removed duplicated region for block: B:285:0x05e1  */
    /* JADX WARNING: Removed duplicated region for block: B:288:0x05f8  */
    /* JADX WARNING: Removed duplicated region for block: B:289:0x05fa  */
    @Override // com.google.gson.JsonDeserializer
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.remote.model.adverts.MyAdvertDetails deserialize(@org.jetbrains.annotations.NotNull com.google.gson.JsonElement r65, @org.jetbrains.annotations.NotNull java.lang.reflect.Type r66, @org.jetbrains.annotations.NotNull com.google.gson.JsonDeserializationContext r67) {
        /*
        // Method dump skipped, instructions count: 1605
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.adapter.MyAdvertDetailsDeserializer.deserialize(com.google.gson.JsonElement, java.lang.reflect.Type, com.google.gson.JsonDeserializationContext):com.avito.android.remote.model.adverts.MyAdvertDetails");
    }
}
