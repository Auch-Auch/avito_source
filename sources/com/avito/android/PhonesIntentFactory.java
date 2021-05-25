package com.avito.android;

import android.content.Intent;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J'\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H&¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0016\u0010\u000fJ?\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/avito/android/PhonesIntentFactory;", "", "Landroid/content/Intent;", "phonesListIntent", "()Landroid/content/Intent;", "addPhoneIntent", "", "phone", "", "codeLength", "", "timeout", "confirmPhoneIntent", "(Ljava/lang/String;IJ)Landroid/content/Intent;", "confirmPhoneCodeRequestIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "advertsCount", "", "replacingPhones", "removePhoneIntent", "(Ljava/lang/String;ILjava/util/List;)Landroid/content/Intent;", "replacePhoneIntent", "setPhoneForAllIntent", "callId", "title", MessengerShareContentUtility.SUBTITLE, "Lcom/avito/android/remote/model/text/AttributedText;", "description", "", "isManual", "landlinePhoneVerificationIntent", "(ILjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Z)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface PhonesIntentFactory {
    @NotNull
    Intent addPhoneIntent();

    @NotNull
    Intent confirmPhoneCodeRequestIntent(@NotNull String str);

    @NotNull
    Intent confirmPhoneIntent(@NotNull String str, int i, long j);

    @NotNull
    Intent landlinePhoneVerificationIntent(int i, @NotNull String str, @NotNull String str2, @NotNull AttributedText attributedText, @NotNull String str3, boolean z);

    @NotNull
    Intent phonesListIntent();

    @NotNull
    Intent removePhoneIntent(@NotNull String str, int i, @NotNull List<String> list);

    @NotNull
    Intent replacePhoneIntent(@NotNull String str, int i, @NotNull List<String> list);

    @NotNull
    Intent setPhoneForAllIntent(@NotNull String str);
}
