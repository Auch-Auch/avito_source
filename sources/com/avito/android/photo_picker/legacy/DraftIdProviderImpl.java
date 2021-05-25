package com.avito.android.photo_picker.legacy;

import a2.b.a.a.a;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/photo_picker/legacy/DraftIdProviderImpl;", "Lcom/avito/android/photo_picker/legacy/DraftIdProvider;", "", "generateDraftId", "()Ljava/lang/String;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class DraftIdProviderImpl implements DraftIdProvider {
    @Override // com.avito.android.photo_picker.legacy.DraftIdProvider
    @NotNull
    public String generateDraftId() {
        return a.I2("UUID.randomUUID().toString()");
    }
}
