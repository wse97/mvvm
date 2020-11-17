package com.ugb.mvvmproject.helper;

public class GlobalConstants {


    public static final String SERVER_URL_BASE="https://eylul.app/api/";
    public final static int BASE_PERMISSION_FINE_LOCATION_CODE = 1000;
    public final static int BASE_PERMISSION_COARSE_LOCATION_CODE = 1005;
    public final static int BASE_PERMISSION_WRITE_EXTERNAL_STORAGE = 1008;
    public static final int PICK_IMAGE = 1009;


    public final static int GAS_RESPONSE_CODE_OK = 200;
    public final static String GAS_RESPONSE_STATUS_OK = "OK";
    public final static int GAS_RESPONSE_CODE_CREATED = 201;
    public final static String GAS_RESPONSE_STATUS_CREATED = "Created";
    public final static int GAS_RESPONSE_CODE_NO_CONTENT = 204;
    public final static String GAS_RESPONSE_STATUS_NO_CONTENT = "No Content";
    public final static int GAS_RESPONSE_CODE_BAD_REQUEST = 400;
    public final static String GAS_RESPONSE_STATUS_BAD_REQUEST = "Bad Request";
    public final static int GAS_RESPONSE_CODE_UNAUTHORIZED = 401;
    public final static String GAS_RESPONSE_STATUS_UNAUTHORIZED = "Unauthorized";
    public final static int GAS_RESPONSE_CODE_FORBIDDEN = 403;
    public final static String GAS_RESPONSE_STATUS_FORBIDDEN = "Forbidden";
    public final static int GAS_RESPONSE_CODE_NOT_FOUND = 404;
    public final static String GAS_RESPONSE_STATUS_NOT_FOUND = "Not Found";
    public final static int GAS_RESPONSE_CODE_CONFLICT = 409;
    public final static String GAS_RESPONSE_STATUS_CONFLICT = "Conflict";
    public final static int GAS_RESPONSE_CODE_UNPROCESSABLE_ENTITY = 422;
    public final static String GAS_RESPONSE_STATUS_UNPROCESSABLE_ENTITY = "Unprocessable Entity";

    public final static int GAS_RESPONSE_ORDER_STATUS_PENDING = 0;
    public final static int GAS_RESPONSE_ORDER_STATUS_ACCEPTED = 1;
    public final static int GAS_RESPONSE_ORDER_STATUS_START_TRIP = 2;
    public final static int GAS_RESPONSE_ORDER_STATUS_END_TRIP = 3;
    public final static int GAS_RESPONSE_ORDER_STATUS_DECLINED = 4;

    public final static String USER_MAIN_ACTIVITY = "user_main_activity";
    public final static String USER_MAIN_ACTIVITY_TYPE_TAG = "type";
    public final static String USER_GAS_ITEM = "user_gas_item";
    public final static String PROVIDER_GAS_ITEM = "provider_gas_item";
    public final static String API_TOKEN_PREFIX = "Bearer ";



}
