package com.avito.android.feedback_adverts;

import android.net.Uri;
import com.avito.android.remote.feedback.FeedbackAdvertItem;
import com.avito.android.remote.model.Image;
import com.avito.android.util.Collections;
import com.avito.android.util.StringUtils;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import ru.avito.messenger.api.entity.Images;
import ru.avito.messenger.api.entity.body.item.Item;
import t6.n.d;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0003\"\u0016\u0010\u0001\u001a\u00020\u00008\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "PAGE_SIZE", "I", "feedback-adverts_release"}, k = 2, mv = {1, 4, 2})
public final class FeedbackAdvertsInteractorKt {
    public static final int PAGE_SIZE = 20;

    public static final FeedbackAdvertItem access$toFeedbackAdvertItem(Item item) {
        List list;
        String id = item.getId();
        String title = item.getTitle();
        String formattedPrice = item.getFormattedPrice();
        String location = item.getLocation();
        Images images = item.getImages();
        if (images != null) {
            Map<String, Uri> variants = images.getImage().getVariants();
            LinkedHashMap linkedHashMap = new LinkedHashMap(q.mapCapacity(variants.size()));
            for (T t : variants.entrySet()) {
                linkedHashMap.put(StringUtils.parseSize((String) t.getKey()), t.getValue());
            }
            Map filterKeysNotNull = Collections.filterKeysNotNull(linkedHashMap);
            Image image = filterKeysNotNull.isEmpty() ^ true ? new Image(filterKeysNotNull) : null;
            if (image != null) {
                list = d.listOf(image);
                return new FeedbackAdvertItem(id, title, formattedPrice, location, list);
            }
        }
        list = null;
        return new FeedbackAdvertItem(id, title, formattedPrice, location, list);
    }

    public static final List access$toListOfRemoteImagesOrNull(Images images) {
        Map<String, Uri> variants = images.getImage().getVariants();
        LinkedHashMap linkedHashMap = new LinkedHashMap(q.mapCapacity(variants.size()));
        for (T t : variants.entrySet()) {
            linkedHashMap.put(StringUtils.parseSize((String) t.getKey()), t.getValue());
        }
        Map filterKeysNotNull = Collections.filterKeysNotNull(linkedHashMap);
        Image image = filterKeysNotNull.isEmpty() ^ true ? new Image(filterKeysNotNull) : null;
        if (image != null) {
            return d.listOf(image);
        }
        return null;
    }

    public static final Image access$toRemoteImageOrNull(ru.avito.messenger.api.entity.Image image) {
        Map<String, Uri> variants = image.getVariants();
        LinkedHashMap linkedHashMap = new LinkedHashMap(q.mapCapacity(variants.size()));
        for (T t : variants.entrySet()) {
            linkedHashMap.put(StringUtils.parseSize((String) t.getKey()), t.getValue());
        }
        Map filterKeysNotNull = Collections.filterKeysNotNull(linkedHashMap);
        if (!filterKeysNotNull.isEmpty()) {
            return new Image(filterKeysNotNull);
        }
        return null;
    }
}
