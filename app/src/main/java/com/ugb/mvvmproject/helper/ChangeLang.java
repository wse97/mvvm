package com.ugb.mvvmproject.helper;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;


import com.ugb.mvvmproject.data.local.SharedPreference;

import java.util.Locale;

/**
 * Created by free WaseemBarzaq on 12/07/2017.
 */

public class ChangeLang {
    static ChangeLang mInstance = null;
    private static Context mContext;
    String language;

    public ChangeLang(Context context) {
        mContext = context;
    }

    public static synchronized ChangeLang getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new ChangeLang(context);
        }
        return mInstance;
    }

    public void ChangelangeActivity() {
        language = SharedPreference.getInstance(mContext).getLanguage();
        if (language == null) {
            String lang = Locale.getDefault().getDisplayLanguage();
            Log.d("Language",lang);
            if (lang.equals("English")) {
                SharedPreference.getInstance(mContext).setLanguage("en");
                language = SharedPreference.getInstance(mContext).getLanguage();
            } else if (lang.equals("العربية")) {
                SharedPreference.getInstance(mContext).setLanguage("ar");
                language = SharedPreference.getInstance(mContext).getLanguage();
            }
        }
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        mContext.getResources().updateConfiguration(config,
                mContext.getResources().getDisplayMetrics());
    }

}