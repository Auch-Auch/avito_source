package com.avito.android.photo_picker.legacy;

import android.content.Intent;
import android.net.Uri;
import com.avito.android.util.Intents;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/photo_picker/legacy/GalleryResultsExtractor;", "", "Landroid/content/Intent;", "intent", "", "Landroid/net/Uri;", "extract", "(Landroid/content/Intent;)Ljava/util/List;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class GalleryResultsExtractor {
    @NotNull
    public final List<Uri> extract(@NotNull Intent intent) {
        Uri data;
        Intrinsics.checkNotNullParameter(intent, "intent");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Intents.extractClipDataUris(intent));
        if (arrayList.isEmpty() && (data = intent.getData()) != null) {
            arrayList.add(data);
        }
        return arrayList;
    }
}
