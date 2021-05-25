package com.avito.android.rating.user_contacts.di;

import android.content.res.Resources;
import com.avito.android.di.PerActivity;
import com.avito.android.error_helper.di.ErrorHelperModule;
import com.avito.android.rating.details.adapter.error_snippet.di.ErrorSnippetItemModule;
import com.avito.android.rating.details.adapter.loading.di.LoadingItemModule;
import com.avito.android.rating.user_contacts.UserContactsActivity;
import com.avito.android.rating.user_contacts.adapter.contact.di.ContactItemModule;
import com.avito.android.rating.user_contacts.adapter.info.di.InfoItemModule;
import com.avito.android.util.Kundle;
import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0001\u0007J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/rating/user_contacts/di/UserContactsComponent;", "", "Lcom/avito/android/rating/user_contacts/UserContactsActivity;", "activity", "", "inject", "(Lcom/avito/android/rating/user_contacts/UserContactsActivity;)V", "Factory", "rating_release"}, k = 1, mv = {1, 4, 2})
@Component(dependencies = {UserContactsDependencies.class}, modules = {UserContactsModule.class, InfoItemModule.class, ContactItemModule.class, ErrorSnippetItemModule.class, ErrorHelperModule.class, LoadingItemModule.class})
@PerActivity
public interface UserContactsComponent {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J9\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u00062\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/rating/user_contacts/di/UserContactsComponent$Factory;", "", "Lcom/avito/android/rating/user_contacts/di/UserContactsDependencies;", "dependencies", "Lcom/avito/android/util/Kundle;", "state", "Landroid/content/res/Resources;", "resources", "", "context", "Lcom/avito/android/rating/user_contacts/di/UserContactsComponent;", "create", "(Lcom/avito/android/rating/user_contacts/di/UserContactsDependencies;Lcom/avito/android/util/Kundle;Landroid/content/res/Resources;Ljava/lang/String;)Lcom/avito/android/rating/user_contacts/di/UserContactsComponent;", "rating_release"}, k = 1, mv = {1, 4, 2})
    @Component.Factory
    public interface Factory {
        @NotNull
        UserContactsComponent create(@NotNull UserContactsDependencies userContactsDependencies, @BindsInstance @Nullable Kundle kundle, @BindsInstance @NotNull Resources resources, @BindsInstance @UserContactsContext @Nullable String str);
    }

    void inject(@NotNull UserContactsActivity userContactsActivity);
}
