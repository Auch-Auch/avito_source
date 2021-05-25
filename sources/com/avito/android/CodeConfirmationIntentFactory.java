package com.avito.android;

import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001JC\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\rJ?\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/avito/android/CodeConfirmationIntentFactory;", "", "", "login", "phone", "text", "", "codeTimeout", "", "codeLength", "src", "Landroid/content/Intent;", "codeConfirmationIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JILjava/lang/String;)Landroid/content/Intent;", "challengeId", "phoneAntihackCodeConfirmationIntent", "core_release"}, k = 1, mv = {1, 4, 2})
public interface CodeConfirmationIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent codeConfirmationIntent$default(CodeConfirmationIntentFactory codeConfirmationIntentFactory, String str, String str2, String str3, long j, int i, String str4, int i2, Object obj) {
            if (obj == null) {
                return codeConfirmationIntentFactory.codeConfirmationIntent(str, (i2 & 2) != 0 ? null : str2, str3, j, i, str4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: codeConfirmationIntent");
        }
    }

    @NotNull
    Intent codeConfirmationIntent(@NotNull String str, @Nullable String str2, @NotNull String str3, long j, int i, @NotNull String str4);

    @NotNull
    Intent phoneAntihackCodeConfirmationIntent(@NotNull String str, @NotNull String str2, @NotNull String str3, long j, int i, @NotNull String str4);
}
