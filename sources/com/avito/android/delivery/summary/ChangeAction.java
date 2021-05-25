package com.avito.android.delivery.summary;

import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0001\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/delivery/summary/ChangeAction;", "", "<init>", "()V", "EditContacts", "Lcom/avito/android/delivery/summary/ChangeAction$EditContacts;", "delivery_release"}, k = 1, mv = {1, 4, 2})
public abstract class ChangeAction {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\t\u0010\nR%\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/delivery/summary/ChangeAction$EditContacts;", "Lcom/avito/android/delivery/summary/ChangeAction;", "", "", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "getContacts", "()Ljava/util/Map;", "contacts", "<init>", "(Ljava/util/Map;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class EditContacts extends ChangeAction {
        @NotNull
        public final Map<String, String> a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EditContacts(@NotNull Map<String, String> map) {
            super(null);
            Intrinsics.checkNotNullParameter(map, "contacts");
            this.a = map;
        }

        @NotNull
        public final Map<String, String> getContacts() {
            return this.a;
        }
    }

    public ChangeAction() {
    }

    public ChangeAction(j jVar) {
    }
}
