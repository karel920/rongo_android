package com.mobilestar.rongo.android.activity.GoodDetail.Sheet;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;

import com.arthurivanets.bottomsheets.BaseBottomSheet;
import com.arthurivanets.bottomsheets.config.BaseConfig;
import com.arthurivanets.bottomsheets.config.Config;
import com.mobilestar.rongo.android.R;

public class PucharseSheet extends BaseBottomSheet {

    public PucharseSheet(@NonNull Activity hostActivity) {
        this(hostActivity, new Config.Builder(hostActivity).build());
    }

    /**
     * The main constructor used for the initialization of the {@link}.
     *
     * @param hostActivity the activity the content view of which is to be used as a holder of the bottom sheet
     * @param config
     */
    public PucharseSheet(@NonNull Activity hostActivity, @NonNull BaseConfig config) {
        super(hostActivity, config);
    }

    @NonNull
    @Override
    protected View onCreateSheetContentView(@NonNull Context context) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View sheet = inflater.inflate(R.layout.sheet_good_purchase, this, false);
        return sheet;
    }
}
