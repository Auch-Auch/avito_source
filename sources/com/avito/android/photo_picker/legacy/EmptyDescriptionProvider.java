package com.avito.android.photo_picker.legacy;

import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J3\u0010\u000b\u001a&\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t \n*\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u0018\u00010\b0\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/avito/android/photo_picker/legacy/EmptyDescriptionProvider;", "Lcom/avito/android/photo_picker/legacy/DescriptionProvider;", "", "isEnable", "()Z", "", "getDescription", "()Ljava/lang/String;", "Lio/reactivex/Observable;", "", "kotlin.jvm.PlatformType", "hideObservable", "()Lio/reactivex/Observable;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class EmptyDescriptionProvider implements DescriptionProvider {
    @Override // com.avito.android.photo_picker.legacy.DescriptionProvider
    @NotNull
    public String getDescription() {
        return "";
    }

    @Override // com.avito.android.photo_picker.legacy.DescriptionProvider
    public Observable<Unit> hideObservable() {
        return Observable.empty();
    }

    @Override // com.avito.android.photo_picker.legacy.DescriptionProvider
    public boolean isEnable() {
        return false;
    }
}
