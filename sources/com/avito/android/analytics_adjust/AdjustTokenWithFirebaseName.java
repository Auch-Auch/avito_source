package com.avito.android.analytics_adjust;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b3\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006j\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4¨\u00065"}, d2 = {"Lcom/avito/android/analytics_adjust/AdjustTokenWithFirebaseName;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getAdjustToken", "()Ljava/lang/String;", "adjustToken", AuthSource.BOOKING_ORDER, "getFirebaseName", "firebaseName", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V", "ADD_ADVERT", "ADD_ADVERT_TRANSPORT", "ADD_ADVERT_REALTY", "ADD_ADVERT_JOB", "ADD_ADVERT_SERVICES", "ADD_ADVERT_GENERAL", "OPEN_APP", "CALL_TO_SELLER", "SELECT_CATEGORY", "SEARCH_RESULT", "ADVERT_VIEWED", "ADVERT_VIEWED_GENERAL", "ADVERT_VIEWED_JOB", "ADVERT_VIEWED_REALTY", "ADVERT_VIEWED_SERVICES", "ADVERT_VIEWED_TRANSPORT", "SUCCESSFUL_AUTHENTICATION", "WRITE_TO_SELLER", "CONTACT_SELLER", "NEW_BUYER", "CONTACT_SELLER_TRANSPORT", "CONTACT_SELLER_GENERAL", "CONTACT_SELLER_REALTY", "NEW_BUYER_RE", "CONTACT_SELLER_JOB", "CONTACT_SELLER_SERVICES", "CONTACT_SELLER_TRANSPORT_CARS", "CONTACT_SELLER_TRANSPORT_MOTOWATER", "CONTACT_SELLER_TRANSPORT_TRUCKS", "CONTACT_SELLER_SPAREPARTS", "CONTACT_SELLER_NEW_AUTO", "BUYER_DEVELOPMENT_CONTACT", "BUYER_NEW_DEVELOPMENT_DAY", "BUYER_SECONDARY_SELL", "BUY_WITH_DELIVERY", "PVZ_IS_CHOSEN", "DELIVERY_PAYMENT_SUCCESSFUL", "HOTELS_FIND", "OPEN_COURIER_SUMMARY", "COURIER_ORDER_PAID", "analytics-adjust_release"}, k = 1, mv = {1, 4, 2})
public enum AdjustTokenWithFirebaseName {
    ADD_ADVERT("l0y59q", "Publish_Item"),
    ADD_ADVERT_TRANSPORT("i6hq0e", "Publish_Item_Transport"),
    ADD_ADVERT_REALTY("96zyru", "Publish_Item_Realty"),
    ADD_ADVERT_JOB("w0gavn", "Publish_Item_Job"),
    ADD_ADVERT_SERVICES("fel03h", "Publish_Item_Services"),
    ADD_ADVERT_GENERAL("tea7bz", "Publish_Item_General"),
    OPEN_APP("onbptc", "Launch_App"),
    CALL_TO_SELLER("nzi0m6", "Press_CallButton"),
    SELECT_CATEGORY("19b4in", "View_AddNewItem"),
    SEARCH_RESULT("7l7tpi", "View_ProductList"),
    ADVERT_VIEWED("i9z9kv", "View_Item"),
    ADVERT_VIEWED_GENERAL("k791kj", "View_Item_General"),
    ADVERT_VIEWED_JOB("vhib7y", "View_Item_Job"),
    ADVERT_VIEWED_REALTY("p3p7yk", "View_Item_Realty"),
    ADVERT_VIEWED_SERVICES("3kemrz", "View_Item_Services"),
    ADVERT_VIEWED_TRANSPORT("6alefb", "View_Item_Transport"),
    SUCCESSFUL_AUTHENTICATION("8p0u0x", "Complete_Authorization"),
    WRITE_TO_SELLER("aau8dv", "Press_ChatButton"),
    CONTACT_SELLER("k67mie", "Buyer"),
    NEW_BUYER("91z9p6", "New_Buyer"),
    CONTACT_SELLER_TRANSPORT("bctl8p", "Buyer_Transport"),
    CONTACT_SELLER_GENERAL("mz99nu", "Buyer_General"),
    CONTACT_SELLER_REALTY("o28d22", "Buyer_Realty"),
    NEW_BUYER_RE("679tkd", "New_Buyer_Realty"),
    CONTACT_SELLER_JOB("mm2qdy", "Buyer_Job"),
    CONTACT_SELLER_SERVICES("kv54xg", "Buyer_Services"),
    CONTACT_SELLER_TRANSPORT_CARS("dnpscd", "Buyer_TransportCars"),
    CONTACT_SELLER_TRANSPORT_MOTOWATER("qxyu1m", "Buyer_TransportMotowater"),
    CONTACT_SELLER_TRANSPORT_TRUCKS("e03es5", "Buyer_TransportTrucks"),
    CONTACT_SELLER_SPAREPARTS("6q9pt0", "Buyer_Spareparts"),
    CONTACT_SELLER_NEW_AUTO("8fhng1", "Buyer_TransportNewCars"),
    BUYER_DEVELOPMENT_CONTACT("i7ccxf", "Buyer_RealtyNewDevelopment"),
    BUYER_NEW_DEVELOPMENT_DAY("7nn668", "Buyer_RealtyNewDevelopment_Day"),
    BUYER_SECONDARY_SELL("9r3o1f", "Buyer_RealtySecondarySell"),
    BUY_WITH_DELIVERY("89w11g", "Press_BuyWithDelivery"),
    PVZ_IS_CHOSEN("kgbxvp", "View_DeliveryMap"),
    DELIVERY_PAYMENT_SUCCESSFUL("ss5vgb", "Purchase_Delivery"),
    HOTELS_FIND("gqhmt5", "HotelsForm_Realty"),
    OPEN_COURIER_SUMMARY("l9lvp6", "Courier_order_widget"),
    COURIER_ORDER_PAID("56bfl0", "Courier_order_create");
    
    @NotNull
    public final String a;
    @NotNull
    public final String b;

    /* access modifiers changed from: public */
    AdjustTokenWithFirebaseName(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @NotNull
    public final String getAdjustToken() {
        return this.a;
    }

    @NotNull
    public final String getFirebaseName() {
        return this.b;
    }
}
