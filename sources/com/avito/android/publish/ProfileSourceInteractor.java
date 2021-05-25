package com.avito.android.publish;

import com.avito.android.remote.model.Profile;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0003H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/publish/ProfileSourceInteractor;", "", "Lio/reactivex/Single;", "Lcom/avito/android/remote/model/Profile;", "getProfile", "()Lio/reactivex/Single;", "profile", "", "notifyProfileChanged", "(Lcom/avito/android/remote/model/Profile;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface ProfileSourceInteractor {
    @NotNull
    Single<Profile> getProfile();

    void notifyProfileChanged(@NotNull Profile profile);
}
