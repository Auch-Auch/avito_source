package com.avito.android.location_picker.job;

import com.avito.android.location_picker.entities.SendLocationResponse;
import com.facebook.appevents.integrity.IntegrityManager;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J5\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/location_picker/job/JobAssistantInteractor;", "", "", "channelId", "", "lat", "lng", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/location_picker/entities/SendLocationResponse;", "sendLocation", "(Ljava/lang/String;DDLjava/lang/String;)Lio/reactivex/rxjava3/core/Single;", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public interface JobAssistantInteractor {
    @NotNull
    Single<SendLocationResponse> sendLocation(@NotNull String str, double d, double d2, @NotNull String str2);
}
