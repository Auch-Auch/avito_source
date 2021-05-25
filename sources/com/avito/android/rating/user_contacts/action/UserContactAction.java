package com.avito.android.rating.user_contacts.action;

import com.avito.android.rating.user_contacts.adapter.contact.ContactItem;
import com.avito.android.remote.auth.AuthSource;
import com.google.common.net.HttpHeaders;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/rating/user_contacts/action/UserContactAction;", "", "<init>", "()V", "Rating", HttpHeaders.REFRESH, "Remove", "Lcom/avito/android/rating/user_contacts/action/UserContactAction$Rating;", "Lcom/avito/android/rating/user_contacts/action/UserContactAction$Remove;", "Lcom/avito/android/rating/user_contacts/action/UserContactAction$Refresh;", "rating_release"}, k = 1, mv = {1, 4, 2})
public abstract class UserContactAction {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/rating/user_contacts/action/UserContactAction$Rating;", "Lcom/avito/android/rating/user_contacts/action/UserContactAction;", "Lcom/avito/android/rating/user_contacts/adapter/contact/ContactItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/rating/user_contacts/adapter/contact/ContactItem;", "getItem", "()Lcom/avito/android/rating/user_contacts/adapter/contact/ContactItem;", "item", "", AuthSource.BOOKING_ORDER, "I", "getRating", "()I", "rating", "<init>", "(Lcom/avito/android/rating/user_contacts/adapter/contact/ContactItem;I)V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public static final class Rating extends UserContactAction {
        @NotNull
        public final ContactItem a;
        public final int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Rating(@NotNull ContactItem contactItem, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(contactItem, "item");
            this.a = contactItem;
            this.b = i;
        }

        @NotNull
        public final ContactItem getItem() {
            return this.a;
        }

        public final int getRating() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/rating/user_contacts/action/UserContactAction$Refresh;", "Lcom/avito/android/rating/user_contacts/action/UserContactAction;", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public static final class Refresh extends UserContactAction {
        public Refresh() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/rating/user_contacts/action/UserContactAction$Remove;", "Lcom/avito/android/rating/user_contacts/action/UserContactAction;", "Lcom/avito/android/rating/user_contacts/adapter/contact/ContactItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/rating/user_contacts/adapter/contact/ContactItem;", "getItem", "()Lcom/avito/android/rating/user_contacts/adapter/contact/ContactItem;", "item", "<init>", "(Lcom/avito/android/rating/user_contacts/adapter/contact/ContactItem;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public static final class Remove extends UserContactAction {
        @NotNull
        public final ContactItem a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Remove(@NotNull ContactItem contactItem) {
            super(null);
            Intrinsics.checkNotNullParameter(contactItem, "item");
            this.a = contactItem;
        }

        @NotNull
        public final ContactItem getItem() {
            return this.a;
        }
    }

    public UserContactAction() {
    }

    public UserContactAction(j jVar) {
    }
}
