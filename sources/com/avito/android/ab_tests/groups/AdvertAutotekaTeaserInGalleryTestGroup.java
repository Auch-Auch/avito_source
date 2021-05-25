package com.avito.android.ab_tests.groups;

import com.avito.android.ab_tests.models.RemoteNamingGroup;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0011\b\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u000b\u001a\u00020\u00068\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/ab_tests/groups/AdvertAutotekaTeaserInGalleryTestGroup;", "", "Lcom/avito/android/ab_tests/models/RemoteNamingGroup;", "", "isTest", "()Z", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getRemoteName", "()Ljava/lang/String;", "remoteName", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "NONE", "CONTROL", "TEASER_WITH_OVERVIEW", "TEASER_WITHOUT_OVERVIEW", "ab-tests_release"}, k = 1, mv = {1, 4, 2})
public enum AdvertAutotekaTeaserInGalleryTestGroup implements RemoteNamingGroup {
    NONE(""),
    CONTROL("control"),
    TEASER_WITH_OVERVIEW("teaser_in_gallery_a"),
    TEASER_WITHOUT_OVERVIEW("teaser_in_gallery_b");
    
    @NotNull
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            AdvertAutotekaTeaserInGalleryTestGroup.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[2] = 1;
            iArr[3] = 2;
        }
    }

    /* access modifiers changed from: public */
    AdvertAutotekaTeaserInGalleryTestGroup(String str) {
        this.a = str;
    }

    @Override // com.avito.android.ab_tests.models.RemoteNamingGroup
    @NotNull
    public String getRemoteName() {
        return this.a;
    }

    public final boolean isTest() {
        int ordinal = ordinal();
        return ordinal == 2 || ordinal == 3;
    }
}
