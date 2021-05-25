package com.avito.android.messenger.conversation.mvi.send;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
/* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/messenger/conversation/mvi/send/Onboarding;", "", "", "getStateKey", "()Ljava/lang/String;", "stateKey", "FileSharing", "messenger_release"}, k = 1, mv = {1, 4, 2})
public abstract class Onboarding extends Enum<Onboarding> {
    public static final Onboarding FileSharing;
    public static final /* synthetic */ Onboarding[] a;

    public static final class a extends Onboarding {
        @NotNull
        public final String b = "fileSharingOnboardingState";

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public a(String str, int i) {
            super(str, i, null);
        }

        @Override // com.avito.android.messenger.conversation.mvi.send.Onboarding
        @NotNull
        public String getStateKey() {
            return this.b;
        }
    }

    static {
        a aVar = new a("FileSharing", 0);
        FileSharing = aVar;
        a = new Onboarding[]{aVar};
    }

    public Onboarding(String str, int i, j jVar) {
    }

    public static Onboarding valueOf(String str) {
        return (Onboarding) Enum.valueOf(Onboarding.class, str);
    }

    public static Onboarding[] values() {
        return (Onboarding[]) a.clone();
    }

    @NotNull
    public abstract String getStateKey();
}
