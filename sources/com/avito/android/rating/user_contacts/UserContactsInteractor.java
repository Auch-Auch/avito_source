package com.avito.android.rating.user_contacts;

import android.net.Uri;
import com.avito.android.remote.model.user_contacts.UserContactsResult;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0004\u0010\bJ%\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/rating/user_contacts/UserContactsInteractor;", "", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/user_contacts/UserContactsResult;", "getContactList", "()Lio/reactivex/rxjava3/core/Observable;", "Landroid/net/Uri;", "nextPage", "(Landroid/net/Uri;)Lio/reactivex/rxjava3/core/Observable;", "", "userKey", "itemId", "", "removeContact", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/rxjava3/core/Observable;", "rating_release"}, k = 1, mv = {1, 4, 2})
public interface UserContactsInteractor {
    @NotNull
    Observable<UserContactsResult> getContactList();

    @NotNull
    Observable<UserContactsResult> getContactList(@NotNull Uri uri);

    @NotNull
    Observable<Unit> removeContact(@NotNull String str, @NotNull String str2);
}
