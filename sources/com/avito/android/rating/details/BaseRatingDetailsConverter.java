package com.avito.android.rating.details;

import com.avito.android.Features;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.rating.details.adapter.action.ActionItem;
import com.avito.android.rating.details.adapter.button.ButtonItem;
import com.avito.android.rating.details.adapter.info.InfoItem;
import com.avito.android.rating.details.adapter.rating.RatingItem;
import com.avito.android.rating.details.adapter.text.TextItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.rating_details.ActionElement;
import com.avito.android.remote.model.rating_details.ButtonElement;
import com.avito.android.remote.model.rating_details.CommentElement;
import com.avito.android.remote.model.rating_details.InfoElement;
import com.avito.android.remote.model.rating_details.InfoHint;
import com.avito.android.remote.model.rating_details.RatingDetailsElement;
import com.avito.android.remote.model.rating_details.RatingScoreElement;
import com.avito.android.remote.model.rating_details.RatingStatEntry;
import com.avito.android.remote.model.rating_details.TextElement;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH$¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0011\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/avito/android/rating/details/BaseRatingDetailsConverter;", "Lcom/avito/android/rating/details/RatingDetailsConverter;", "Lcom/avito/android/remote/model/rating_details/RatingDetailsElement;", "element", "", "id", "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "convert", "(Lcom/avito/android/remote/model/rating_details/RatingDetailsElement;Ljava/lang/String;)Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "Lcom/avito/android/remote/model/rating_details/CommentElement;", "convertCommentElement", "(Ljava/lang/String;Lcom/avito/android/remote/model/rating_details/CommentElement;)Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "Lcom/avito/android/Features;", AuthSource.SEND_ABUSE, "Lcom/avito/android/Features;", "getFeatures", "()Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/Features;)V", "rating_release"}, k = 1, mv = {1, 4, 2})
public abstract class BaseRatingDetailsConverter implements RatingDetailsConverter {
    @NotNull
    public final Features a;

    public BaseRatingDetailsConverter(@NotNull Features features) {
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = features;
    }

    @Override // com.avito.android.rating.details.RatingDetailsConverter
    @NotNull
    public RatingDetailsItem convert(@NotNull RatingDetailsElement ratingDetailsElement, @NotNull String str) {
        Intrinsics.checkNotNullParameter(ratingDetailsElement, "element");
        Intrinsics.checkNotNullParameter(str, "id");
        if (ratingDetailsElement instanceof ActionElement) {
            ActionElement actionElement = (ActionElement) ratingDetailsElement;
            return new ActionItem(str, actionElement.getAction().getTitle(), actionElement.getAction().getDeepLink());
        } else if (ratingDetailsElement instanceof ButtonElement) {
            ButtonElement buttonElement = (ButtonElement) ratingDetailsElement;
            return new ButtonItem(str, buttonElement.getAction().getTitle(), buttonElement.getAction().getDeepLink());
        } else {
            ArrayList arrayList = null;
            DeepLink deepLink = null;
            InfoItem.Hint hint = null;
            if (ratingDetailsElement instanceof InfoElement) {
                InfoElement infoElement = (InfoElement) ratingDetailsElement;
                String title = infoElement.getTitle();
                String subtitle = infoElement.getSubtitle();
                InfoHint hint2 = infoElement.getHint();
                if (hint2 != null) {
                    String title2 = hint2.getTitle();
                    String text = hint2.getText();
                    Action action = hint2.getAction();
                    String title3 = action != null ? action.getTitle() : null;
                    Action action2 = hint2.getAction();
                    if (action2 != null) {
                        deepLink = action2.getDeepLink();
                    }
                    hint = new InfoItem.Hint(title2, text, title3, deepLink);
                }
                return new InfoItem(str, title, subtitle, hint);
            } else if (ratingDetailsElement instanceof TextElement) {
                return new TextItem(str, ((TextElement) ratingDetailsElement).getMessage());
            } else {
                if (ratingDetailsElement instanceof RatingScoreElement) {
                    RatingScoreElement ratingScoreElement = (RatingScoreElement) ratingDetailsElement;
                    float score = ratingScoreElement.getScore();
                    Float scoreFloat = ratingScoreElement.getScoreFloat();
                    String title4 = ratingScoreElement.getTitle();
                    String subtitle2 = ratingScoreElement.getSubtitle();
                    Integer reviewCount = ratingScoreElement.getReviewCount();
                    List<RatingStatEntry> ratingStat = ratingScoreElement.getRatingStat();
                    if (ratingStat != null) {
                        arrayList = new ArrayList(e.collectionSizeOrDefault(ratingStat, 10));
                        for (T t : ratingStat) {
                            int score2 = t.getScore();
                            Integer reviewCount2 = ratingScoreElement.getReviewCount();
                            arrayList.add(new com.avito.android.rating.details.adapter.rating.RatingStatEntry(score2, reviewCount2 != null ? ((float) t.getCount()) / ((float) reviewCount2.intValue()) : 0.0f, t.getTitle()));
                        }
                    }
                    return new RatingItem(str, score, scoreFloat, title4, subtitle2, reviewCount, arrayList);
                } else if (ratingDetailsElement instanceof CommentElement) {
                    return convertCommentElement(str, (CommentElement) ratingDetailsElement);
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    @NotNull
    public abstract RatingDetailsItem convertCommentElement(@NotNull String str, @NotNull CommentElement commentElement);

    @NotNull
    public final Features getFeatures() {
        return this.a;
    }
}
