package com.avito.android.publish.publish_advert_request.data;

import com.avito.android.publish.PublishedAdvertData;
import com.avito.android.publish.slots.contact_info.ContactsData;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.util.LoadingState;
import io.reactivex.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J=\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/publish/publish_advert_request/data/PublishAdvertRepository;", "", "Lcom/avito/android/remote/model/Navigation;", "navigation", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "params", "Lcom/avito/android/publish/slots/contact_info/ContactsData;", "data", "", "draftId", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/publish/PublishedAdvertData;", "postAdvert", "(Lcom/avito/android/remote/model/Navigation;Lcom/avito/android/remote/model/category_parameters/CategoryParameters;Lcom/avito/android/publish/slots/contact_info/ContactsData;Ljava/lang/String;)Lio/reactivex/Observable;", "publish_release"}, k = 1, mv = {1, 4, 2})
public interface PublishAdvertRepository {
    @NotNull
    Observable<LoadingState<PublishedAdvertData>> postAdvert(@NotNull Navigation navigation, @NotNull CategoryParameters categoryParameters, @NotNull ContactsData contactsData, @Nullable String str);
}
