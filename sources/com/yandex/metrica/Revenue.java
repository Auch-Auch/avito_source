package com.yandex.metrica;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.adr;
import com.yandex.metrica.impl.ob.ads;
import com.yandex.metrica.impl.ob.adw;
import java.util.Currency;
public class Revenue {
    @NonNull
    public final Currency currency;
    @Nullable
    public final String payload;
    @Nullable
    @Deprecated
    public final Double price;
    @Nullable
    public final Long priceMicros;
    @Nullable
    public final String productID;
    @Nullable
    public final Integer quantity;
    @Nullable
    public final Receipt receipt;

    public static class Receipt {
        @Nullable
        public final String data;
        @Nullable
        public final String signature;

        public static class Builder {
            @Nullable
            public String a;
            @Nullable
            public String b;

            @NonNull
            public Receipt build() {
                return new Receipt(this, null);
            }

            @NonNull
            public Builder withData(@Nullable String str) {
                this.a = str;
                return this;
            }

            @NonNull
            public Builder withSignature(@Nullable String str) {
                this.b = str;
                return this;
            }
        }

        public Receipt(Builder builder, a aVar) {
            this.data = builder.a;
            this.signature = builder.b;
        }

        @NonNull
        public static Builder newBuilder() {
            return new Builder();
        }
    }

    public Revenue(Builder builder, a aVar) {
        this.price = builder.a;
        this.priceMicros = builder.b;
        this.currency = builder.c;
        this.quantity = builder.d;
        this.productID = builder.e;
        this.payload = builder.f;
        this.receipt = builder.g;
    }

    @NonNull
    @Deprecated
    public static Builder newBuilder(double d, @NonNull Currency currency2) {
        return new Builder(d, currency2);
    }

    @NonNull
    public static Builder newBuilderWithMicros(long j, @NonNull Currency currency2) {
        return new Builder(j, currency2);
    }

    public static class Builder {
        public static final adw<Currency> h = new ads(new adr("revenue currency"));
        @Nullable
        public Double a;
        @Nullable
        public Long b;
        @NonNull
        public Currency c;
        @Nullable
        public Integer d;
        @Nullable
        public String e;
        @Nullable
        public String f;
        @Nullable
        public Receipt g;

        public Builder(double d2, @NonNull Currency currency) {
            h.a(currency);
            this.a = Double.valueOf(d2);
            this.c = currency;
        }

        @NonNull
        public Revenue build() {
            return new Revenue(this, null);
        }

        @NonNull
        public Builder withPayload(@Nullable String str) {
            this.f = str;
            return this;
        }

        @NonNull
        public Builder withProductID(@Nullable String str) {
            this.e = str;
            return this;
        }

        @NonNull
        public Builder withQuantity(@Nullable Integer num) {
            this.d = num;
            return this;
        }

        @NonNull
        public Builder withReceipt(@Nullable Receipt receipt) {
            this.g = receipt;
            return this;
        }

        public Builder(long j, @NonNull Currency currency) {
            h.a(currency);
            this.b = Long.valueOf(j);
            this.c = currency;
        }
    }
}
