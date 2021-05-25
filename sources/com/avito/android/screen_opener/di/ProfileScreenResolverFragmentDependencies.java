package com.avito.android.screen_opener.di;

import com.avito.android.deep_linking.DeepLinkIntentFactory;
import com.avito.android.di.CoreComponentDependencies;
import com.avito.android.public_profile.remote.PublicProfileApi;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/screen_opener/di/ProfileScreenResolverFragmentDependencies;", "Lcom/avito/android/di/CoreComponentDependencies;", "Lcom/avito/android/public_profile/remote/PublicProfileApi;", "publicProfileApi", "()Lcom/avito/android/public_profile/remote/PublicProfileApi;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "()Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public interface ProfileScreenResolverFragmentDependencies extends CoreComponentDependencies {
    @NotNull
    DeepLinkIntentFactory deepLinkIntentFactory();

    @NotNull
    PublicProfileApi publicProfileApi();
}
