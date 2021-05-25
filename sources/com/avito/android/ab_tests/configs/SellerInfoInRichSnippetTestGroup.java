package com.avito.android.ab_tests.configs;

import com.avito.android.ab_tests.models.RemoteNamingGroup;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0011\b\u0002\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\b\u001a\u00020\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/ab_tests/configs/SellerInfoInRichSnippetTestGroup;", "", "Lcom/avito/android/ab_tests/models/RemoteNamingGroup;", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getRemoteName", "()Ljava/lang/String;", "remoteName", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "NONE", "CONTROL", "CONTROL_2", "BEFORE_CONTACTS", "AFTER_CONTACTS", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
public enum SellerInfoInRichSnippetTestGroup implements RemoteNamingGroup {
    NONE(""),
    CONTROL("control1"),
    CONTROL_2("control2"),
    BEFORE_CONTACTS("seller_info_before_contacts"),
    AFTER_CONTACTS("seller_info_after_contacts");
    
    @NotNull
    public final String a;

    /* access modifiers changed from: public */
    SellerInfoInRichSnippetTestGroup(String str) {
        this.a = str;
    }

    @Override // com.avito.android.ab_tests.models.RemoteNamingGroup
    @NotNull
    public String getRemoteName() {
        return this.a;
    }
}
