package com.avito.android.rating.user_contacts;

import com.facebook.share.internal.MessengerShareContentUtility;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/avito/android/rating/user_contacts/UserContactsConverterImpl;", "Lcom/avito/android/rating/user_contacts/UserContactsConverter;", "", "Lcom/avito/android/remote/model/user_contacts/UserContactResultElement;", MessengerShareContentUtility.ELEMENTS, "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "convert", "(Ljava/util/List;)Ljava/util/List;", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class UserContactsConverterImpl implements UserContactsConverter {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.avito.android.rating.user_contacts.adapter.contact.ContactItem] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // com.avito.android.rating.user_contacts.UserContactsConverter
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.avito.android.rating.details.adapter.RatingDetailsItem> convert(@org.jetbrains.annotations.NotNull java.util.List<? extends com.avito.android.remote.model.user_contacts.UserContactResultElement> r18) {
        /*
            r17 = this;
            r0 = r18
            java.lang.String r1 = "elements"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = t6.n.e.collectionSizeOrDefault(r0, r2)
            r1.<init>(r2)
            java.util.Iterator r0 = r18.iterator()
            r2 = 0
        L_0x0017:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x00cc
            java.lang.Object r3 = r0.next()
            int r4 = r2 + 1
            if (r2 >= 0) goto L_0x0028
            kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()
        L_0x0028:
            com.avito.android.remote.model.user_contacts.UserContactResultElement r3 = (com.avito.android.remote.model.user_contacts.UserContactResultElement) r3
            boolean r5 = r3 instanceof com.avito.android.remote.model.user_contacts.InfoElement
            r6 = 0
            if (r5 == 0) goto L_0x0046
            com.avito.android.rating.user_contacts.adapter.info.InfoItem r6 = new com.avito.android.rating.user_contacts.adapter.info.InfoItem
            java.lang.String r5 = "info:"
            java.lang.String r2 = a2.b.a.a.a.M2(r5, r2)
            com.avito.android.remote.model.user_contacts.InfoElement r3 = (com.avito.android.remote.model.user_contacts.InfoElement) r3
            java.lang.String r5 = r3.getTitle()
            java.lang.String r3 = r3.getSubtitle()
            r6.<init>(r2, r5, r3)
            goto L_0x00c6
        L_0x0046:
            boolean r2 = r3 instanceof com.avito.android.remote.model.user_contacts.UserContactElement
            if (r2 == 0) goto L_0x00c6
            com.avito.android.rating.user_contacts.adapter.contact.ContactItem r2 = new com.avito.android.rating.user_contacts.adapter.contact.ContactItem
            java.lang.String r5 = "contact:"
            java.lang.StringBuilder r5 = a2.b.a.a.a.L(r5)
            com.avito.android.remote.model.user_contacts.UserContactElement r3 = (com.avito.android.remote.model.user_contacts.UserContactElement) r3
            com.avito.android.remote.model.user_contacts.UserContactElement$User r7 = r3.getUser()
            java.lang.String r7 = r7.getUserKey()
            r5.append(r7)
            java.lang.String r7 = ":item:"
            r5.append(r7)
            com.avito.android.remote.model.user_contacts.UserContactElement$Item r7 = r3.getItem()
            java.lang.String r7 = r7.getId()
            r5.append(r7)
            java.lang.String r8 = r5.toString()
            com.avito.android.remote.model.user_contacts.UserContactElement$User r5 = r3.getUser()
            java.lang.String r9 = r5.getUserKey()
            com.avito.android.remote.model.user_contacts.UserContactElement$User r5 = r3.getUser()
            java.lang.String r10 = r5.getName()
            com.avito.android.remote.model.user_contacts.UserContactElement$Item r5 = r3.getItem()
            java.lang.String r11 = r5.getId()
            com.avito.android.remote.model.user_contacts.UserContactElement$Item r5 = r3.getItem()
            com.avito.android.remote.model.Image r12 = r5.getImage()
            com.avito.android.remote.model.user_contacts.UserContactElement$Item r5 = r3.getItem()
            java.lang.String r13 = r5.getTitle()
            com.avito.android.remote.model.user_contacts.UserContactElement$Item r5 = r3.getItem()
            java.lang.String r14 = r5.getPrice()
            com.avito.android.remote.model.user_contacts.UserContactElement$Item r5 = r3.getItem()
            java.lang.Boolean r5 = r5.isAuto()
            if (r5 == 0) goto L_0x00b3
            boolean r5 = r5.booleanValue()
            r15 = r5
            goto L_0x00b5
        L_0x00b3:
            r5 = 0
            r15 = 0
        L_0x00b5:
            com.avito.android.remote.model.Action r3 = r3.getAction()
            if (r3 == 0) goto L_0x00bf
            com.avito.android.deep_linking.links.DeepLink r6 = r3.getDeepLink()
        L_0x00bf:
            r16 = r6
            r7 = r2
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16)
            r6 = r2
        L_0x00c6:
            r1.add(r6)
            r2 = r4
            goto L_0x0017
        L_0x00cc:
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.filterNotNull(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.rating.user_contacts.UserContactsConverterImpl.convert(java.util.List):java.util.List");
    }
}
