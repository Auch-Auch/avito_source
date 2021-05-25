package com.avito.android.messenger.widget.chat_list_element;

import a2.a.a.o1.i.a.a;
import android.view.View;
import com.avito.android.image_loader.Picture;
import com.avito.android.messenger.channels.mvi.presenter.MessagePreview;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Sort;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 -2\u00020\u0001:\u0004-./0J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u0010\u0010\u000eJ\u0017\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0016\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0002H&¢\u0006\u0004\b\u001f\u0010\u0006J!\u0010\"\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020!H&¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0002H&¢\u0006\u0004\b%\u0010\u0006J\u001d\u0010(\u001a\u00020\u00042\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00040&H&¢\u0006\u0004\b(\u0010)J\u0017\u0010+\u001a\u00020\u00042\u0006\u0010'\u001a\u00020*H&¢\u0006\u0004\b+\u0010,¨\u00061"}, d2 = {"Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement;", "", "", "isActive", "", "setIsActive", "(Z)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setAvatarSource", "(Lcom/avito/android/image_loader/Picture;)V", "", "name", "setChatTitle", "(Ljava/lang/String;)V", Sort.DATE, "setDate", "Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage;", "featureImage", "setFeatureImage", "(Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage;)V", "price", "setItemInfo", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$LastMessageType;", "type", "Lcom/avito/android/messenger/channels/mvi/presenter/MessagePreview;", "messagePreview", "setLastMessage", "(Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$LastMessageType;Lcom/avito/android/messenger/channels/mvi/presenter/MessagePreview;)V", "isOnline", "setInterlocutorOnline", "status", "Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$ItemDeliveryStatusType;", "setItemDeliveryStatus", "(Ljava/lang/String;Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$ItemDeliveryStatusType;)V", "isTyping", "setIsTyping", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/view/View$OnLongClickListener;", "setLongClickListener", "(Landroid/view/View$OnLongClickListener;)V", "Companion", "FeatureImage", "ItemDeliveryStatusType", "LastMessageType", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ChatListElement {
    @NotNull
    public static final Companion Companion = Companion.a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$Companion;", "", "Landroid/view/View;", "view", "", "greyOutInactiveChats", "Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement;", "create", "(Landroid/view/View;Z)Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();

        public static /* synthetic */ ChatListElement create$default(Companion companion, View view, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.create(view, z);
        }

        @NotNull
        public final ChatListElement create(@NotNull View view, boolean z) {
            Intrinsics.checkNotNullParameter(view, "view");
            return new a(view, z);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage;", "", "<init>", "()V", "Item", "System", "UserToUser", "Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage$Item;", "Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage$System;", "Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage$UserToUser;", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class FeatureImage {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage$Item;", "Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage;", "Lcom/avito/android/remote/model/Image;", "component1", "()Lcom/avito/android/remote/model/Image;", "image", "copy", "(Lcom/avito/android/remote/model/Image;)Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage$Item;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Image;", "getImage", "<init>", "(Lcom/avito/android/remote/model/Image;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class Item extends FeatureImage {
            @Nullable
            public final Image a;

            public Item(@Nullable Image image) {
                super(null);
                this.a = image;
            }

            public static /* synthetic */ Item copy$default(Item item, Image image, int i, Object obj) {
                if ((i & 1) != 0) {
                    image = item.a;
                }
                return item.copy(image);
            }

            @Nullable
            public final Image component1() {
                return this.a;
            }

            @NotNull
            public final Item copy(@Nullable Image image) {
                return new Item(image);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof Item) && Intrinsics.areEqual(this.a, ((Item) obj).a);
                }
                return true;
            }

            @Nullable
            public final Image getImage() {
                return this.a;
            }

            public int hashCode() {
                Image image = this.a;
                if (image != null) {
                    return image.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("Item(image=");
                L.append(this.a);
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004¨\u0006\u0018"}, d2 = {"Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage$System;", "Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage;", "Lcom/avito/android/remote/model/Image;", "component1", "()Lcom/avito/android/remote/model/Image;", "image", "copy", "(Lcom/avito/android/remote/model/Image;)Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage$System;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Image;", "getImage", "<init>", "(Lcom/avito/android/remote/model/Image;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class System extends FeatureImage {
            @Nullable
            public final Image a;

            public System(@Nullable Image image) {
                super(null);
                this.a = image;
            }

            public static /* synthetic */ System copy$default(System system, Image image, int i, Object obj) {
                if ((i & 1) != 0) {
                    image = system.a;
                }
                return system.copy(image);
            }

            @Nullable
            public final Image component1() {
                return this.a;
            }

            @NotNull
            public final System copy(@Nullable Image image) {
                return new System(image);
            }

            public boolean equals(@Nullable Object obj) {
                if (this != obj) {
                    return (obj instanceof System) && Intrinsics.areEqual(this.a, ((System) obj).a);
                }
                return true;
            }

            @Nullable
            public final Image getImage() {
                return this.a;
            }

            public int hashCode() {
                Image image = this.a;
                if (image != null) {
                    return image.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("System(image=");
                L.append(this.a);
                L.append(")");
                return L.toString();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0019\u0010\u0004¨\u0006\u001c"}, d2 = {"Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage$UserToUser;", "Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage;", "Lcom/avito/android/remote/model/Image;", "component1", "()Lcom/avito/android/remote/model/Image;", "component2", "userImage", "interlocutorImage", "copy", "(Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/Image;)Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$FeatureImage$UserToUser;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/Image;", "getInterlocutorImage", AuthSource.SEND_ABUSE, "getUserImage", "<init>", "(Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/Image;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
        public static final class UserToUser extends FeatureImage {
            @Nullable
            public final Image a;
            @Nullable
            public final Image b;

            public UserToUser(@Nullable Image image, @Nullable Image image2) {
                super(null);
                this.a = image;
                this.b = image2;
            }

            public static /* synthetic */ UserToUser copy$default(UserToUser userToUser, Image image, Image image2, int i, Object obj) {
                if ((i & 1) != 0) {
                    image = userToUser.a;
                }
                if ((i & 2) != 0) {
                    image2 = userToUser.b;
                }
                return userToUser.copy(image, image2);
            }

            @Nullable
            public final Image component1() {
                return this.a;
            }

            @Nullable
            public final Image component2() {
                return this.b;
            }

            @NotNull
            public final UserToUser copy(@Nullable Image image, @Nullable Image image2) {
                return new UserToUser(image, image2);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof UserToUser)) {
                    return false;
                }
                UserToUser userToUser = (UserToUser) obj;
                return Intrinsics.areEqual(this.a, userToUser.a) && Intrinsics.areEqual(this.b, userToUser.b);
            }

            @Nullable
            public final Image getInterlocutorImage() {
                return this.b;
            }

            @Nullable
            public final Image getUserImage() {
                return this.a;
            }

            public int hashCode() {
                Image image = this.a;
                int i = 0;
                int hashCode = (image != null ? image.hashCode() : 0) * 31;
                Image image2 = this.b;
                if (image2 != null) {
                    i = image2.hashCode();
                }
                return hashCode + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a2.b.a.a.a.L("UserToUser(userImage=");
                L.append(this.a);
                L.append(", interlocutorImage=");
                L.append(this.b);
                L.append(")");
                return L.toString();
            }
        }

        public FeatureImage() {
        }

        public FeatureImage(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$ItemDeliveryStatusType;", "", "<init>", "(Ljava/lang/String;I)V", "NEUTRAL", "POSITIVE", "NEGATIVE", "NONE", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public enum ItemDeliveryStatusType {
        NEUTRAL,
        POSITIVE,
        NEGATIVE,
        NONE
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/messenger/widget/chat_list_element/ChatListElement$LastMessageType;", "", "<init>", "(Ljava/lang/String;I)V", "INCOMING_UNREAD", "INCOMING_READ", "OUTGOING_PENDING", "OUTGOING_READ", "OUTGOING_DELIVERED", "OUTGOING_ERROR", "DRAFT", "EMPTY", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public enum LastMessageType {
        INCOMING_UNREAD,
        INCOMING_READ,
        OUTGOING_PENDING,
        OUTGOING_READ,
        OUTGOING_DELIVERED,
        OUTGOING_ERROR,
        DRAFT,
        EMPTY
    }

    void setAvatarSource(@Nullable Picture picture);

    void setChatTitle(@Nullable String str);

    void setClickListener(@NotNull Function0<Unit> function0);

    void setDate(@Nullable String str);

    void setFeatureImage(@NotNull FeatureImage featureImage);

    void setInterlocutorOnline(boolean z);

    void setIsActive(boolean z);

    void setIsTyping(boolean z);

    void setItemDeliveryStatus(@Nullable String str, @NotNull ItemDeliveryStatusType itemDeliveryStatusType);

    void setItemInfo(@Nullable String str, @Nullable String str2);

    void setLastMessage(@NotNull LastMessageType lastMessageType, @NotNull MessagePreview messagePreview);

    void setLongClickListener(@NotNull View.OnLongClickListener onLongClickListener);
}
