package com.avito.android;

import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\rJ\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/avito/android/VerificationIntentFactory;", "", "Landroid/content/Intent;", "verificationsList", "()Landroid/content/Intent;", "", "type", "verificationStatus", "(Ljava/lang/String;)Landroid/content/Intent;", "Lcom/avito/android/VerificationIntentFactory$VerificationAction;", "action", "verificationAction", "(Lcom/avito/android/VerificationIntentFactory$VerificationAction;Ljava/lang/String;)Landroid/content/Intent;", "VerificationAction", "core_release"}, k = 1, mv = {1, 4, 2})
public interface VerificationIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/avito/android/VerificationIntentFactory$VerificationAction;", "", "<init>", "(Ljava/lang/String;I)V", "REMOVE", "core_release"}, k = 1, mv = {1, 4, 2})
    public enum VerificationAction {
        REMOVE
    }

    @NotNull
    Intent verificationAction(@NotNull VerificationAction verificationAction, @NotNull String str);

    @NotNull
    Intent verificationStatus(@NotNull String str);

    @NotNull
    Intent verificationsList();
}
