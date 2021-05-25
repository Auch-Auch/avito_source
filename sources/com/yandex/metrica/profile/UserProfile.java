package com.yandex.metrica.profile;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.ur;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
public class UserProfile {
    @NonNull
    private final List<UserProfileUpdate<? extends ur>> mUserProfileUpdates;

    public static class Builder {
        private final LinkedList<UserProfileUpdate<? extends ur>> mUserProfileUpdates = new LinkedList<>();

        public Builder apply(@NonNull UserProfileUpdate<? extends ur> userProfileUpdate) {
            this.mUserProfileUpdates.add(userProfileUpdate);
            return this;
        }

        @NonNull
        public UserProfile build() {
            return new UserProfile(this.mUserProfileUpdates);
        }
    }

    @NonNull
    public static Builder newBuilder() {
        return new Builder();
    }

    @NonNull
    public List<UserProfileUpdate<? extends ur>> getUserProfileUpdates() {
        return this.mUserProfileUpdates;
    }

    private UserProfile(@NonNull List<UserProfileUpdate<? extends ur>> list) {
        this.mUserProfileUpdates = Collections.unmodifiableList(list);
    }
}
