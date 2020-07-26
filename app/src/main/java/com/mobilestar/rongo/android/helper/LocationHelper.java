package com.mobilestar.rongo.android.helper;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationHelper {


    public static Address getAddresses(Context context, LatLng locationPoints) throws IOException {

        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(context, Locale.getDefault());

        addresses = geocoder.getFromLocation(locationPoints.latitude, locationPoints.longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5

        if(addresses.size()>0){
            return  addresses.get(0);
        }

        return  null;

    }
}
