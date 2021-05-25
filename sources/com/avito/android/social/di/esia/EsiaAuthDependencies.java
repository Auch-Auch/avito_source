package com.avito.android.social.di.esia;

import com.avito.android.Features;
import com.avito.android.di.ComponentDependencies;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/social/di/esia/EsiaAuthDependencies;", "Lcom/avito/android/di/ComponentDependencies;", "Lcom/avito/android/Features;", "features", "()Lcom/avito/android/Features;", "social_release"}, k = 1, mv = {1, 4, 2})
public interface EsiaAuthDependencies extends ComponentDependencies {
    @Override // com.avito.android.social.di.AppleAuthDependencies, com.avito.android.profile_phones.phones_list.di.PhonesListDependencies
    @NotNull
    Features features();
}
