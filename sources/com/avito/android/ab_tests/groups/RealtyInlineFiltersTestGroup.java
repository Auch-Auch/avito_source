package com.avito.android.ab_tests.groups;

import com.avito.android.ab_tests.models.RemoteNamingGroup;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0011\b\u0002\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0005R\u001c\u0010\f\u001a\u00020\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/ab_tests/groups/RealtyInlineFiltersTestGroup;", "", "Lcom/avito/android/ab_tests/models/RemoteNamingGroup;", "", "isTest", "()Z", "isInTest", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getRemoteName", "()Ljava/lang/String;", "remoteName", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "NONE", "TEST", "TEST_2", "CONTROL", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
public enum RealtyInlineFiltersTestGroup implements RemoteNamingGroup {
    NONE(""),
    TEST("test"),
    TEST_2("test2"),
    CONTROL("control");
    
    @NotNull
    public final String a;

    /* access modifiers changed from: public */
    RealtyInlineFiltersTestGroup(String str) {
        this.a = str;
    }

    @Override // com.avito.android.ab_tests.models.RemoteNamingGroup
    @NotNull
    public String getRemoteName() {
        return this.a;
    }

    public final boolean isInTest() {
        return this != NONE;
    }

    public final boolean isTest() {
        return this == TEST || this == TEST_2;
    }
}
