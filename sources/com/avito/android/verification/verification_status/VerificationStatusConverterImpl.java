package com.avito.android.verification.verification_status;

import com.avito.android.Features;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.lib.design.R;
import com.avito.android.profile_phones.analytics.event.PhoneActionStrings;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.VerificationStatusResult;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.ListUtils;
import com.avito.android.verification.VerificationStatus;
import com.avito.android.verification.verification_status.VerificationStatusScreenData;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/verification/verification_status/VerificationStatusConverterImpl;", "Lcom/avito/android/verification/verification_status/VerificationStatusConverter;", "Lcom/avito/android/remote/model/VerificationStatusResult;", "result", "Lcom/avito/android/verification/verification_status/VerificationStatusScreenData;", "convert", "(Lcom/avito/android/remote/model/VerificationStatusResult;)Lcom/avito/android/verification/verification_status/VerificationStatusScreenData;", "Lcom/avito/android/Features;", AuthSource.SEND_ABUSE, "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/Features;)V", "verification_release"}, k = 1, mv = {1, 4, 2})
public final class VerificationStatusConverterImpl implements VerificationStatusConverter {
    public final Features a;

    @Inject
    public VerificationStatusConverterImpl(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = features;
    }

    @Override // com.avito.android.verification.verification_status.VerificationStatusConverter
    @NotNull
    public VerificationStatusScreenData convert(@NotNull VerificationStatusResult verificationStatusResult) {
        ArrayList arrayList;
        VerificationStatusScreenData.Banner banner;
        ArrayList arrayList2;
        List<VerificationStatusResult.Action> actions;
        int i;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(verificationStatusResult, "result");
        String title = verificationStatusResult.getTitle();
        AttributedText description = verificationStatusResult.getDescription();
        AttributedText footerInfo = verificationStatusResult.getFooterInfo();
        Image image = verificationStatusResult.getImage();
        List<VerificationStatusResult.Button> buttons = verificationStatusResult.getButtons();
        if (buttons != null) {
            arrayList = new ArrayList(e.collectionSizeOrDefault(buttons, 10));
            for (T t : buttons) {
                String title2 = t.getTitle();
                DeepLink deeplink = t.getDeeplink();
                boolean isEnabled = t.isEnabled();
                String type = t.getType();
                int hashCode = type.hashCode();
                if (hashCode != -817598092) {
                    if (hashCode == -314765822 && type.equals("primary")) {
                        i3 = R.attr.buttonPrimaryLarge;
                        arrayList.add(new VerificationStatusScreenData.Button(title2, deeplink, isEnabled, i3));
                    }
                } else if (type.equals("secondary")) {
                    i3 = R.attr.buttonSecondaryLarge;
                    arrayList.add(new VerificationStatusScreenData.Button(title2, deeplink, isEnabled, i3));
                }
                i3 = R.attr.buttonDefaultLarge;
                arrayList.add(new VerificationStatusScreenData.Button(title2, deeplink, isEnabled, i3));
            }
        } else {
            arrayList = null;
        }
        VerificationStatusResult.Banner banner2 = verificationStatusResult.getBanner();
        if (banner2 != null) {
            String title3 = banner2.getTitle();
            String description2 = banner2.getDescription();
            AttributedText detailsLink = banner2.getDetailsLink();
            String type2 = banner2.getType();
            VerificationStatus verificationStatus = VerificationStatus.IN_PROGRESS;
            if (Intrinsics.areEqual(type2, verificationStatus.getType())) {
                i = R.attr.ic_time24;
            } else if (Intrinsics.areEqual(type2, VerificationStatus.ERROR.getType())) {
                i = R.attr.ic_attentionRound24;
            } else {
                i = R.attr.ic_attentionRound24;
            }
            String type3 = banner2.getType();
            if (Intrinsics.areEqual(type3, verificationStatus.getType())) {
                i2 = R.attr.alertBannerInfo;
            } else if (Intrinsics.areEqual(type3, VerificationStatus.ERROR.getType())) {
                i2 = R.attr.alertBannerDanger;
            } else {
                i2 = R.attr.alertBannerDefault;
            }
            banner = new VerificationStatusScreenData.Banner(title3, description2, detailsLink, i, i2);
        } else {
            banner = null;
        }
        if (!this.a.getRemoveVerification().invoke().booleanValue() || (actions = verificationStatusResult.getActions()) == null) {
            arrayList2 = null;
        } else {
            arrayList2 = new ArrayList(e.collectionSizeOrDefault(actions, 10));
            for (T t2 : actions) {
                String title4 = t2.getDeeplink().getTitle();
                DeepLink uri = t2.getDeeplink().getUri();
                String type4 = t2.getType();
                arrayList2.add(new VerificationStatusScreenData.Action(title4, uri, (type4.hashCode() == -1335458389 && type4.equals(PhoneActionStrings.REMOVE)) ? Integer.valueOf(R.attr.ic_delete24) : null, R.attr.black));
            }
        }
        Integer valueOf = Integer.valueOf(R.attr.ic_more24);
        valueOf.intValue();
        return new VerificationStatusScreenData(title, description, footerInfo, arrayList, banner, image, arrayList2, ListUtils.isNotNullAndNotEmpty(verificationStatusResult.getActions()) ? valueOf : null);
    }
}
