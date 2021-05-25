package com.avito.android.feedback_adverts;

import android.net.Uri;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.feedback.FeedbackAdvertItem;
import com.avito.android.remote.model.Image;
import com.avito.android.util.Collections;
import com.avito.android.util.StringUtils;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.MessengerClient;
import ru.avito.messenger.api.AvitoMessengerApi;
import ru.avito.messenger.api.entity.Images;
import ru.avito.messenger.api.entity.body.item.Item;
import t6.n.d;
import t6.n.e;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/feedback_adverts/FeedbackAdvertsInteractorImpl;", "Lcom/avito/android/feedback_adverts/FeedbackAdvertsInteractor;", "", "itemId", "", "page", "Lio/reactivex/Single;", "", "Lcom/avito/android/remote/feedback/FeedbackAdvertItem;", "getFeedbackItems", "(Ljava/lang/String;I)Lio/reactivex/Single;", "Lru/avito/messenger/MessengerClient;", "Lru/avito/messenger/api/AvitoMessengerApi;", AuthSource.SEND_ABUSE, "Lru/avito/messenger/MessengerClient;", "client", "<init>", "(Lru/avito/messenger/MessengerClient;)V", "feedback-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class FeedbackAdvertsInteractorImpl implements FeedbackAdvertsInteractor {
    public final MessengerClient<AvitoMessengerApi> a;

    public static final class a<T, R> implements Function<List<? extends Item>, List<? extends FeedbackAdvertItem>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public List<? extends FeedbackAdvertItem> apply(List<? extends Item> list) {
            List list2;
            List<? extends Item> list3 = list;
            Intrinsics.checkNotNullParameter(list3, "items");
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list3, 10));
            for (T t : list3) {
                String id = t.getId();
                String title = t.getTitle();
                String formattedPrice = t.getFormattedPrice();
                String location = t.getLocation();
                Images images = t.getImages();
                if (images != null) {
                    Map<String, Uri> variants = images.getImage().getVariants();
                    LinkedHashMap linkedHashMap = new LinkedHashMap(q.mapCapacity(variants.size()));
                    for (T t2 : variants.entrySet()) {
                        linkedHashMap.put(StringUtils.parseSize((String) t2.getKey()), t2.getValue());
                    }
                    Map filterKeysNotNull = Collections.filterKeysNotNull(linkedHashMap);
                    Image image = filterKeysNotNull.isEmpty() ^ true ? new Image(filterKeysNotNull) : null;
                    if (image != null) {
                        list2 = d.listOf(image);
                        arrayList.add(new FeedbackAdvertItem(id, title, formattedPrice, location, list2));
                    }
                }
                list2 = null;
                arrayList.add(new FeedbackAdvertItem(id, title, formattedPrice, location, list2));
            }
            return arrayList;
        }
    }

    @Inject
    public FeedbackAdvertsInteractorImpl(@NotNull MessengerClient<AvitoMessengerApi> messengerClient) {
        Intrinsics.checkNotNullParameter(messengerClient, "client");
        this.a = messengerClient;
    }

    @Override // com.avito.android.feedback_adverts.FeedbackAdvertsInteractor
    @NotNull
    public Single<List<FeedbackAdvertItem>> getFeedbackItems(@Nullable String str, int i) {
        Single<R> map = this.a.getItemsForAttach(str, 20, Integer.valueOf((i - 1) * 20)).map(a.a);
        Intrinsics.checkNotNullExpressionValue(map, "client.getItemsForAttach…backAdvertItem)\n        }");
        return map;
    }
}
