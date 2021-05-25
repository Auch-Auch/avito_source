package com.avito.android.messenger.conversation.adapter.image;

import android.net.Uri;
import com.avito.android.image_loader.Picture;
import com.avito.android.image_loader.SimplePicture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Size;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.SortedSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.j;
import t6.o.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ\u001b\u0010\u000e\u001a\u00020\r*\u00020\n2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/avito/android/messenger/conversation/adapter/image/MessagePictureProviderImpl;", "Lcom/avito/android/messenger/conversation/adapter/image/MessagePictureProvider;", "Lcom/avito/android/remote/model/messenger/message/MessageBody;", "messageBody", "", "imageId", "Lcom/avito/android/image_loader/Picture;", "getPicture", "(Lcom/avito/android/remote/model/messenger/message/MessageBody;Ljava/lang/String;)Lcom/avito/android/image_loader/Picture;", "getThumbnail", "Lcom/avito/android/remote/model/Image;", "", SDKConstants.PARAM_CONTEXT_MAX_SIZE, "Landroid/net/Uri;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/Image;I)Landroid/net/Uri;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class MessagePictureProviderImpl implements MessagePictureProvider {
    public final Uri a(Image image, int i) {
        Object obj;
        Uri uri;
        boolean z;
        SortedSet sortedSet = j.toSortedSet(image.getVariants().entrySet(), new Comparator<T>() { // from class: com.avito.android.messenger.conversation.adapter.image.MessagePictureProviderImpl$findUrlForSize$$inlined$compareBy$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                T t3 = t;
                T t4 = t2;
                return a.compareValues(Integer.valueOf(Math.min(((Size) t3.getKey()).getHeight(), ((Size) t3.getKey()).getWidth())), Integer.valueOf(Math.min(((Size) t4.getKey()).getHeight(), ((Size) t4.getKey()).getWidth())));
            }
        });
        Iterator it = sortedSet.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Map.Entry entry = (Map.Entry) obj;
            if (((Size) entry.getKey()).getHeight() < i || ((Size) entry.getKey()).getWidth() < i) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        Map.Entry entry2 = (Map.Entry) obj;
        return (entry2 == null || (uri = (Uri) entry2.getValue()) == null) ? (Uri) ((Map.Entry) sortedSet.last()).getValue() : uri;
    }

    @Override // com.avito.android.messenger.conversation.adapter.image.MessagePictureProvider
    @NotNull
    public Picture getPicture(@NotNull MessageBody messageBody, @Nullable String str) {
        Object obj;
        SimplePicture simplePicture;
        Intrinsics.checkNotNullParameter(messageBody, "messageBody");
        if (messageBody instanceof MessageBody.ImageBody) {
            return new SimplePicture(a(((MessageBody.ImageBody) messageBody).getImage(), 480));
        }
        if (messageBody instanceof MessageBody.LocalImage) {
            return new SimplePicture(((MessageBody.LocalImage) messageBody).getSource());
        }
        Image image = null;
        if (messageBody instanceof MessageBody.Link) {
            MessageBody.Link.Preview preview = ((MessageBody.Link) messageBody).getPreview();
            if (preview != null) {
                image = preview.getImage();
            }
            if (image != null) {
                return new SimplePicture(a(image, 480));
            }
            throw new IllegalArgumentException("MessageBody.Link.Preview image is null: " + messageBody);
        } else if (!(messageBody instanceof MessageBody.SystemMessageBody.Platform)) {
            throw new IllegalArgumentException("Unsupported image message body: " + messageBody);
        } else if (str != null) {
            Sequence filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(((MessageBody.SystemMessageBody.Platform) messageBody).getChunks()), MessagePictureProviderImpl$getPicture$$inlined$filterIsInstance$1.INSTANCE);
            Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
            Iterator it = filter.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((MessageBody.SystemMessageBody.Platform.Bubble.Image) obj).getImageId(), str)) {
                    break;
                }
            }
            MessageBody.SystemMessageBody.Platform.Bubble.Image image2 = (MessageBody.SystemMessageBody.Platform.Bubble.Image) obj;
            if (image2 != null) {
                image = image2.getImage();
            }
            if (image != null) {
                simplePicture = new SimplePicture(a(image, 480));
            } else {
                Uri uri = Uri.EMPTY;
                Intrinsics.checkNotNullExpressionValue(uri, "Uri.EMPTY");
                simplePicture = new SimplePicture(uri);
            }
            return simplePicture;
        } else {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }

    @Override // com.avito.android.messenger.conversation.adapter.image.MessagePictureProvider
    @NotNull
    public Picture getThumbnail(@NotNull MessageBody messageBody, @Nullable String str) {
        Object obj;
        SimplePicture simplePicture;
        Intrinsics.checkNotNullParameter(messageBody, "messageBody");
        if (messageBody instanceof MessageBody.ImageBody) {
            return new SimplePicture(a(((MessageBody.ImageBody) messageBody).getImage(), 60));
        }
        if (messageBody instanceof MessageBody.LocalImage) {
            return new SimplePicture(((MessageBody.LocalImage) messageBody).getSource());
        }
        Image image = null;
        if (messageBody instanceof MessageBody.Link) {
            MessageBody.Link.Preview preview = ((MessageBody.Link) messageBody).getPreview();
            if (preview != null) {
                image = preview.getImage();
            }
            if (image != null) {
                return new SimplePicture(a(image, 60));
            }
            throw new IllegalArgumentException("MessageBody.Link.Preview image is null: " + messageBody);
        } else if (!(messageBody instanceof MessageBody.SystemMessageBody.Platform)) {
            throw new IllegalArgumentException("Unsupported image message body: " + messageBody);
        } else if (str != null) {
            Sequence filter = SequencesKt___SequencesKt.filter(CollectionsKt___CollectionsKt.asSequence(((MessageBody.SystemMessageBody.Platform) messageBody).getChunks()), MessagePictureProviderImpl$getThumbnail$$inlined$filterIsInstance$1.INSTANCE);
            Objects.requireNonNull(filter, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
            Iterator it = filter.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((MessageBody.SystemMessageBody.Platform.Bubble.Image) obj).getImageId(), str)) {
                    break;
                }
            }
            MessageBody.SystemMessageBody.Platform.Bubble.Image image2 = (MessageBody.SystemMessageBody.Platform.Bubble.Image) obj;
            if (image2 != null) {
                image = image2.getImage();
            }
            if (image != null) {
                simplePicture = new SimplePicture(a(image, 60));
            } else {
                Uri uri = Uri.EMPTY;
                Intrinsics.checkNotNullExpressionValue(uri, "Uri.EMPTY");
                simplePicture = new SimplePicture(uri);
            }
            return simplePicture;
        } else {
            throw new IllegalArgumentException("Required value was null.".toString());
        }
    }
}
