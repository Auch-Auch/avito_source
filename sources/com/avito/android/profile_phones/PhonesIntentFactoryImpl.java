package com.avito.android.profile_phones;

import android.content.Intent;
import com.avito.android.CoreActivityIntentFactory;
import com.avito.android.PhonesIntentFactory;
import com.avito.android.profile_phones.add_phone.AddPhoneTabFragmentData;
import com.avito.android.profile_phones.confirm_phone.PhoneConfirmCodeRequestTabFragmentData;
import com.avito.android.profile_phones.confirm_phone.PhoneConfirmTabFragmentData;
import com.avito.android.profile_phones.confirm_phone.PhoneConfirmationArguments;
import com.avito.android.profile_phones.landline_verification.LandlinePhoneVerificationTabFragmentData;
import com.avito.android.profile_phones.phone_action.PhoneActionArguments;
import com.avito.android.profile_phones.phone_action.PhoneActionTabFragmentData;
import com.avito.android.profile_phones.phone_action.PhoneParcelableEntity;
import com.avito.android.profile_phones.phones_list.PhonesListTabFragmentData;
import com.avito.android.profile_phones.phones_list.list_item.PhoneActionCode;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.share.internal.MessengerShareContentUtility;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010&\u001a\u00020$¢\u0006\u0004\b'\u0010(J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J'\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J-\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u000fJ?\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ;\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0006\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0002¢\u0006\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010%¨\u0006)"}, d2 = {"Lcom/avito/android/profile_phones/PhonesIntentFactoryImpl;", "Lcom/avito/android/PhonesIntentFactory;", "Landroid/content/Intent;", "phonesListIntent", "()Landroid/content/Intent;", "addPhoneIntent", "", "phone", "", "codeLength", "", "timeout", "confirmPhoneIntent", "(Ljava/lang/String;IJ)Landroid/content/Intent;", "confirmPhoneCodeRequestIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "advertsCount", "", "replacingPhones", "removePhoneIntent", "(Ljava/lang/String;ILjava/util/List;)Landroid/content/Intent;", "replacePhoneIntent", "setPhoneForAllIntent", "callId", "title", MessengerShareContentUtility.SUBTITLE, "Lcom/avito/android/remote/model/text/AttributedText;", "description", "", "isManual", "landlinePhoneVerificationIntent", "(ILjava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Z)Landroid/content/Intent;", "Lcom/avito/android/profile_phones/phones_list/list_item/PhoneActionCode;", "action", AuthSource.SEND_ABUSE, "(Lcom/avito/android/profile_phones/phones_list/list_item/PhoneActionCode;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;)Landroid/content/Intent;", "Lcom/avito/android/CoreActivityIntentFactory;", "Lcom/avito/android/CoreActivityIntentFactory;", "coreActivityIntentFactory", "<init>", "(Lcom/avito/android/CoreActivityIntentFactory;)V", "profile-phones_release"}, k = 1, mv = {1, 4, 2})
public final class PhonesIntentFactoryImpl implements PhonesIntentFactory {
    public final CoreActivityIntentFactory a;

    @Inject
    public PhonesIntentFactoryImpl(@NotNull CoreActivityIntentFactory coreActivityIntentFactory) {
        Intrinsics.checkNotNullParameter(coreActivityIntentFactory, "coreActivityIntentFactory");
        this.a = coreActivityIntentFactory;
    }

    public final Intent a(PhoneActionCode phoneActionCode, String str, Integer num, List<String> list) {
        CoreActivityIntentFactory coreActivityIntentFactory = this.a;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new PhoneParcelableEntity(it.next()));
        }
        return coreActivityIntentFactory.mainScreenWithTab(new PhoneActionTabFragmentData(new PhoneActionArguments(str, phoneActionCode, num, arrayList)));
    }

    @Override // com.avito.android.PhonesIntentFactory
    @NotNull
    public Intent addPhoneIntent() {
        return this.a.mainScreenWithTab(new AddPhoneTabFragmentData());
    }

    @Override // com.avito.android.PhonesIntentFactory
    @NotNull
    public Intent confirmPhoneCodeRequestIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "phone");
        return this.a.mainScreenWithTab(new PhoneConfirmCodeRequestTabFragmentData(str));
    }

    @Override // com.avito.android.PhonesIntentFactory
    @NotNull
    public Intent confirmPhoneIntent(@NotNull String str, int i, long j) {
        Intrinsics.checkNotNullParameter(str, "phone");
        return this.a.mainScreenWithTab(new PhoneConfirmTabFragmentData(new PhoneConfirmationArguments(str, i, j)));
    }

    @Override // com.avito.android.PhonesIntentFactory
    @NotNull
    public Intent landlinePhoneVerificationIntent(int i, @NotNull String str, @NotNull String str2, @NotNull AttributedText attributedText, @NotNull String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, MessengerShareContentUtility.SUBTITLE);
        Intrinsics.checkNotNullParameter(attributedText, "description");
        Intrinsics.checkNotNullParameter(str3, "phone");
        return this.a.mainScreenWithTab(new LandlinePhoneVerificationTabFragmentData(i, str, str2, attributedText, str3, z));
    }

    @Override // com.avito.android.PhonesIntentFactory
    @NotNull
    public Intent phonesListIntent() {
        return this.a.mainScreenWithTab(new PhonesListTabFragmentData());
    }

    @Override // com.avito.android.PhonesIntentFactory
    @NotNull
    public Intent removePhoneIntent(@NotNull String str, int i, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(list, "replacingPhones");
        return a(PhoneActionCode.REMOVE, str, Integer.valueOf(i), list);
    }

    @Override // com.avito.android.PhonesIntentFactory
    @NotNull
    public Intent replacePhoneIntent(@NotNull String str, int i, @NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(str, "phone");
        Intrinsics.checkNotNullParameter(list, "replacingPhones");
        return a(PhoneActionCode.REPLACE_FOR_ADS, str, Integer.valueOf(i), list);
    }

    @Override // com.avito.android.PhonesIntentFactory
    @NotNull
    public Intent setPhoneForAllIntent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "phone");
        return a(PhoneActionCode.SET_FOR_ALL, str, null, CollectionsKt__CollectionsKt.emptyList());
    }
}
