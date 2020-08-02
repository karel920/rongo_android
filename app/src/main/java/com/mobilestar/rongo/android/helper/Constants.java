package com.mobilestar.rongo.android.helper;

public class Constants {
    public static final String PHONE_NUMBER_KEY="phone_number";
    public static final String COUNTRY_CODE_KEY="country_code";
    public static final String USER_ID_KEY="user_id";
    public static final String COUPON_DATA_EXTRA="coupon_data";
    public static final String DATA_EXTRA="extra_data";
    public static final String TYPE_EXTRA="type_container";

    public static final String LIKE_VALUE_EXTRA="like_value";
    public static final String LIKE_ID="like_Id";
    public static final String LIKE_TYPE="like_type";    // store or coupon

    public static final String LIKE_TYPE_PACKAGE="package";
    public static final String LIKE_TYPE_SERVICE="service";
    public static final String LIKE_TYPE_PROVIDER="provider";

    public static final String LIKE_INTENT_FILTER="like_filter";
    public static final String LIKE_INTENT_FOR_SERVICE="like_service_package_provider";
    public static final String VOTED_OR_UNVOTE_MY_CONTEST="vote_unvote_my_contest";
    public static final String VOTED="voted";
    public static final String DELTED_MY_POST_CONTEST="delete_my_post_contest";

    public static final String StreamAPIKey = "at5dhjq8gtxz";
    public static final String StreamSecretKey = "vu4bs8rrj7mztycujf2tknda7xwdv2gjdptesrybz76h9qkprn6qandu7hpd3scg";

    public static int UNREAD_NOTIFICATION_COUNT =0;

    public enum LikeType{
        STORE(2),COUPON(1);

        private int value;

        LikeType(int val) {
            value=val;
        }

        public int getValue() {
            return value;
        }
    }
}
