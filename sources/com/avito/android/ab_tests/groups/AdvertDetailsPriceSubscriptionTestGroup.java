package com.avito.android.ab_tests.groups;

import com.avito.android.ab_tests.models.RemoteNamingGroup;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0011\b\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\u0005R\u001c\u0010\r\u001a\u00020\b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/ab_tests/groups/AdvertDetailsPriceSubscriptionTestGroup;", "", "Lcom/avito/android/ab_tests/models/RemoteNamingGroup;", "", "isTest", "()Z", "isListItem", "isFavIcon", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getRemoteName", "()Ljava/lang/String;", "remoteName", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "CONTROL", "PUSH_LIST_ITEM", "PUSH_FAV_ICON", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
public enum AdvertDetailsPriceSubscriptionTestGroup implements RemoteNamingGroup {
    CONTROL("control_no_push"),
    PUSH_LIST_ITEM("test_push_with_button"),
    PUSH_FAV_ICON("test_push_fav_add");
    
    @NotNull
    public final String a;

    /* access modifiers changed from: public */
    AdvertDetailsPriceSubscriptionTestGroup(String str) {
        this.a = str;
    }

    @Override // com.avito.android.ab_tests.models.RemoteNamingGroup
    @NotNull
    public String getRemoteName() {
        return this.a;
    }

    public final boolean isFavIcon() {
        return this == PUSH_FAV_ICON;
    }

    public final boolean isListItem() {
        return this == PUSH_LIST_ITEM;
    }

    public final boolean isTest() {
        return isListItem() || isFavIcon();
    }
}
