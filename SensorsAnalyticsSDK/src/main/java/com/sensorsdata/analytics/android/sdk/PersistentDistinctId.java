/**Created by wangzhuozhou on 2015/08/01.
 * Copyright © 2015－2018 Sensors Data Inc. All rights reserved. */
 
package com.sensorsdata.analytics.android.sdk;

import android.content.Context;
import android.content.SharedPreferences;

import com.sensorsdata.analytics.android.sdk.util.SensorsDataUtils;

import java.util.UUID;
import java.util.concurrent.Future;

/**
 * Created by 王灼洲 on 2017/4/10
 */

class PersistentDistinctId extends PersistentIdentity<String> {
    PersistentDistinctId(Future<SharedPreferences> loadStoredPreferences, final Context context) {
        super(loadStoredPreferences, "events_distinct_id", new PersistentSerializer<String>() {
            @Override
            public String load(String value) {
                return value;
            }

            @Override
            public String save(String item) {
                return item;
            }

            @Override
            public String create() {
                if (SensorsDataUtils.isValidAndroidId(SensorsDataAPI.mAndroidId)) {
                    return SensorsDataAPI.mAndroidId;
                }
                return UUID.randomUUID().toString();
            }
        });
    }
}
