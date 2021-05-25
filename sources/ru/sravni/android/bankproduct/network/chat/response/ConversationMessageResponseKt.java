package ru.sravni.android.bankproduct.network.chat.response;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.sravni.android.bankproduct.analytic.v2.AnalyticFieldsName;
import ru.sravni.android.bankproduct.repository.chat.entity.CardActionRepo;
import ru.sravni.android.bankproduct.repository.chat.entity.ContentCardElementRepo;
import ru.sravni.android.bankproduct.repository.chat.entity.ContentCardRepo;
import ru.sravni.android.bankproduct.repository.chat.entity.ContentElementParameterRepo;
import ru.sravni.android.bankproduct.repository.chat.entity.ContentElementValidateRepo;
import ru.sravni.android.bankproduct.repository.chat.entity.ConversationMessageRepo;
import ru.sravni.android.bankproduct.repository.chat.entity.ConversationParamsRepo;
import ru.sravni.android.bankproduct.repository.chat.entity.ConversationRepo;
import ru.sravni.android.bankproduct.repository.chat.entity.SliderSnapPointRepo;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0019\u0010\f\u001a\u00020\u000b*\u00020\b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\r\u001a\u0011\u0010\u0010\u001a\u00020\u000f*\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0011\u0010\u0014\u001a\u00020\u0013*\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0011\u0010\u0018\u001a\u00020\u0017*\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0011\u0010\u001c\u001a\u00020\u001b*\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0011\u0010 \u001a\u00020\u001f*\u00020\u001e¢\u0006\u0004\b \u0010!\u001a\u0011\u0010$\u001a\u00020#*\u00020\"¢\u0006\u0004\b$\u0010%¨\u0006&"}, d2 = {"Lru/sravni/android/bankproduct/network/chat/response/Conversation;", "Lru/sravni/android/bankproduct/repository/chat/entity/ConversationRepo;", "toConversationRepo", "(Lru/sravni/android/bankproduct/network/chat/response/Conversation;)Lru/sravni/android/bankproduct/repository/chat/entity/ConversationRepo;", "Lru/sravni/android/bankproduct/network/chat/response/Action;", "Lru/sravni/android/bankproduct/repository/chat/entity/CardActionRepo;", "toActionRepo", "(Lru/sravni/android/bankproduct/network/chat/response/Action;)Lru/sravni/android/bankproduct/repository/chat/entity/CardActionRepo;", "Lru/sravni/android/bankproduct/network/chat/response/Message;", "", AnalyticFieldsName.conversationID, "Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageRepo;", "toConversationMessageRepo", "(Lru/sravni/android/bankproduct/network/chat/response/Message;Ljava/lang/String;)Lru/sravni/android/bankproduct/repository/chat/entity/ConversationMessageRepo;", "Lru/sravni/android/bankproduct/network/chat/response/Content;", "Lru/sravni/android/bankproduct/repository/chat/entity/ContentCardRepo;", "toContentCardRepo", "(Lru/sravni/android/bankproduct/network/chat/response/Content;)Lru/sravni/android/bankproduct/repository/chat/entity/ContentCardRepo;", "Lru/sravni/android/bankproduct/network/chat/response/Element;", "Lru/sravni/android/bankproduct/repository/chat/entity/ContentCardElementRepo;", "toContentCardElementRepo", "(Lru/sravni/android/bankproduct/network/chat/response/Element;)Lru/sravni/android/bankproduct/repository/chat/entity/ContentCardElementRepo;", "Lru/sravni/android/bankproduct/network/chat/response/ElementParams;", "Lru/sravni/android/bankproduct/repository/chat/entity/ContentElementParameterRepo;", "toContentCardElementParamsRepo", "(Lru/sravni/android/bankproduct/network/chat/response/ElementParams;)Lru/sravni/android/bankproduct/repository/chat/entity/ContentElementParameterRepo;", "Lru/sravni/android/bankproduct/network/chat/response/Validation;", "Lru/sravni/android/bankproduct/repository/chat/entity/ContentElementValidateRepo;", "toContentElementValidateRepo", "(Lru/sravni/android/bankproduct/network/chat/response/Validation;)Lru/sravni/android/bankproduct/repository/chat/entity/ContentElementValidateRepo;", "Lru/sravni/android/bankproduct/network/chat/response/SnapPoint;", "Lru/sravni/android/bankproduct/repository/chat/entity/SliderSnapPointRepo;", "toSliderSnapPointRepo", "(Lru/sravni/android/bankproduct/network/chat/response/SnapPoint;)Lru/sravni/android/bankproduct/repository/chat/entity/SliderSnapPointRepo;", "Lru/sravni/android/bankproduct/network/chat/response/ConversationParams;", "Lru/sravni/android/bankproduct/repository/chat/entity/ConversationParamsRepo;", "toConversationParamsRepo", "(Lru/sravni/android/bankproduct/network/chat/response/ConversationParams;)Lru/sravni/android/bankproduct/repository/chat/entity/ConversationParamsRepo;", "sravnichat_release"}, k = 2, mv = {1, 4, 0})
public final class ConversationMessageResponseKt {
    @NotNull
    public static final CardActionRepo toActionRepo(@NotNull Action action) {
        Intrinsics.checkParameterIsNotNull(action, "$this$toActionRepo");
        return new CardActionRepo(action.getCode(), action.getText());
    }

    @NotNull
    public static final ContentElementParameterRepo toContentCardElementParamsRepo(@NotNull ElementParams elementParams) {
        ArrayList arrayList;
        Intrinsics.checkParameterIsNotNull(elementParams, "$this$toContentCardElementParamsRepo");
        List<SnapPoint> snapPoints = elementParams.getSnapPoints();
        if (snapPoints != null) {
            arrayList = new ArrayList(e.collectionSizeOrDefault(snapPoints, 10));
            Iterator<T> it = snapPoints.iterator();
            while (it.hasNext()) {
                arrayList.add(toSliderSnapPointRepo(it.next()));
            }
        } else {
            arrayList = null;
        }
        return new ContentElementParameterRepo(arrayList, elementParams.getKeyboard(), elementParams.getPlaceholder(), elementParams.getSuggestMode(), null, elementParams.getShowSuggestImmediately(), 16, null);
    }

    @NotNull
    public static final ContentCardElementRepo toContentCardElementRepo(@NotNull Element element) {
        ArrayList arrayList;
        Intrinsics.checkParameterIsNotNull(element, "$this$toContentCardElementRepo");
        String name = element.getName();
        if (name == null) {
            name = "nullName";
        }
        String text = element.getText();
        String type = element.getType();
        List<Element> elements = element.getElements();
        if (elements != null) {
            arrayList = new ArrayList(e.collectionSizeOrDefault(elements, 10));
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                arrayList.add(toContentCardElementRepo(it.next()));
            }
        } else {
            arrayList = null;
        }
        ContentElementParameterRepo contentCardElementParamsRepo = toContentCardElementParamsRepo(element.getParams());
        Validation validation = element.getValidation();
        return new ContentCardElementRepo(name, text, type, arrayList, contentCardElementParamsRepo, validation != null ? toContentElementValidateRepo(validation) : null);
    }

    @NotNull
    public static final ContentCardRepo toContentCardRepo(@NotNull Content content) {
        ArrayList arrayList;
        Intrinsics.checkParameterIsNotNull(content, "$this$toContentCardRepo");
        List<String> modifiers = content.getModifiers();
        if (modifiers == null) {
            modifiers = CollectionsKt__CollectionsKt.emptyList();
        }
        List<Element> elements = content.getElements();
        if (elements != null) {
            arrayList = new ArrayList(e.collectionSizeOrDefault(elements, 10));
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                arrayList.add(toContentCardElementRepo(it.next()));
            }
        } else {
            arrayList = null;
        }
        return new ContentCardRepo(modifiers, arrayList);
    }

    @NotNull
    public static final ContentElementValidateRepo toContentElementValidateRepo(@NotNull Validation validation) {
        Intrinsics.checkParameterIsNotNull(validation, "$this$toContentElementValidateRepo");
        String mask = validation.getMask();
        if (mask == null) {
            mask = "[A…]";
        }
        String maskPlaceholder = validation.getMaskPlaceholder();
        if (maskPlaceholder == null) {
            maskPlaceholder = "*";
        }
        return new ContentElementValidateRepo(mask, maskPlaceholder, validation.getRegexp(), Boolean.parseBoolean(validation.getRequired()));
    }

    @NotNull
    public static final ConversationMessageRepo toConversationMessageRepo(@NotNull Message message, @NotNull String str) {
        ArrayList arrayList;
        ArrayList arrayList2;
        List<Element> elements;
        Intrinsics.checkParameterIsNotNull(message, "$this$toConversationMessageRepo");
        Intrinsics.checkParameterIsNotNull(str, AnalyticFieldsName.conversationID);
        int orderId = message.getOrderId();
        String sender = message.getSender();
        String message2 = message.getMessage();
        String type = message.getType();
        if (type == null) {
            type = "nullCardType";
        }
        MessageElements messageElements = message.getMessageElements();
        if (messageElements == null || (elements = messageElements.getElements()) == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(e.collectionSizeOrDefault(elements, 10));
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                arrayList.add(toContentCardElementRepo(it.next()));
            }
        }
        List<String> modifiers = message.getModifiers();
        List<Action> actions = message.getActions();
        if (actions != null) {
            arrayList2 = new ArrayList(e.collectionSizeOrDefault(actions, 10));
            Iterator<T> it2 = actions.iterator();
            while (it2.hasNext()) {
                arrayList2.add(toActionRepo(it2.next()));
            }
        } else {
            arrayList2 = null;
        }
        Content content = message.getContent();
        ContentCardRepo contentCardRepo = content != null ? toContentCardRepo(content) : null;
        MessageParams messageParams = message.getMessageParams();
        return new ConversationMessageRepo(orderId, str, sender, message2, arrayList, type, modifiers, arrayList2, contentCardRepo, messageParams != null ? messageParams.toConversationMessageParams() : null, message.getCreatedTimeString());
    }

    @NotNull
    public static final ConversationParamsRepo toConversationParamsRepo(@NotNull ConversationParams conversationParams) {
        Intrinsics.checkParameterIsNotNull(conversationParams, "$this$toConversationParamsRepo");
        return new ConversationParamsRepo(conversationParams.getSavedSearchID());
    }

    @NotNull
    public static final ConversationRepo toConversationRepo(@NotNull Conversation conversation) {
        ArrayList arrayList;
        Intrinsics.checkParameterIsNotNull(conversation, "$this$toConversationRepo");
        String id = conversation.getId();
        String status = conversation.getStatus();
        ConversationParams params = conversation.getParams();
        ConversationParamsRepo conversationParamsRepo = params != null ? toConversationParamsRepo(params) : null;
        if (conversation.getMessages() != null) {
            List<Message> messages = conversation.getMessages();
            ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(messages, 10));
            Iterator<T> it = messages.iterator();
            while (it.hasNext()) {
                arrayList2.add(toConversationMessageRepo(it.next(), conversation.getId()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = CollectionsKt__CollectionsKt.emptyList();
        }
        return new ConversationRepo(id, status, conversationParamsRepo, arrayList, conversation.getHiddenMessages());
    }

    @NotNull
    public static final SliderSnapPointRepo toSliderSnapPointRepo(@NotNull SnapPoint snapPoint) {
        Intrinsics.checkParameterIsNotNull(snapPoint, "$this$toSliderSnapPointRepo");
        return new SliderSnapPointRepo(snapPoint.getSnapKey(), snapPoint.getSnapValue());
    }
}
