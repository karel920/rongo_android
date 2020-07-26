package com.mobilestar.rongo.android.helper;


/**
 * Class is used for getting the location of the device.
 */

public class AppLocationUtils {
    public AppLocationUtils(){}
}
//implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {
//    private static final long INTERVAL = 2 * 1000;
//    private final static int CONNECTION_FAILURE_RESOLUTION_REQUEST = 3000;
//    private static final long FASTEST_INTERVAL = 3000;
//    private static AppLocationUtils appLocationUtils;
//    private static float displacement;
//    /**
//     * The formatted location address.
//     */
//    protected String mAddressOutput;
//    private Context mContext;
//    private GoogleApiClient mGoogleApiClient;
//    private LocationRequest mLocationRequest;
//    private Location location;
//    private boolean isLocationConfirmation;
//
//    private AppLocationUtils(Activity context) {
//        mContext = context;
//    }
//
//    public static synchronized AppLocationUtils getInstance(Activity context) {
//        if (appLocationUtils == null) {
//            appLocationUtils = new AppLocationUtils(context);
//        }
//        return appLocationUtils;
//    }
//
//    public synchronized void startFetchingLocation(Context context, float displacement) {
//        AppLocationUtils.displacement = displacement;
//        this.mContext = context;
//        mGoogleApiClient = new GoogleApiClient.Builder(mContext)
//                .addApi(LocationServices.API)
//                .addConnectionCallbacks(this)
//                .addOnConnectionFailedListener(this)
//                .build();
//        // Set defaults, then update using values stored in the Bundle.
////        mResultReceiver = new AddressResultReceiver(new Handler());
//
//        mAddressOutput = "";
//
//        mLocationRequest = LocationRequest.create();
//        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//        mLocationRequest.setInterval(INTERVAL);
////        mLocationRequest.setSmallestDisplacement(displacement);
//        mLocationRequest.setFastestInterval(FASTEST_INTERVAL);
//        showLocationDialog();
//    }
//
//    public void showLocationDialog() {
//        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
//                .addLocationRequest(mLocationRequest);
//
//        //**************************
//        builder.setAlwaysShow(true); //this is the key ingredient
//        //**************************
//        PendingResult<LocationSettingsResult> result =
//                LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient, builder.build());
//        result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
//                                     @Override
//                                     public void onResult(LocationSettingsResult result) {
//                                         final Status status = result.getStatus();
//                                         final LocationSettingsStates state = result.getLocationSettingsStates();
//                                         switch (status.getStatusCode()) {
//                                             case LocationSettingsStatusCodes.SUCCESS:
//                                                 Logger.e("Success---" + "isCalling");
//                                                 // All location settings are satisfied. The client can initialize location
//                                                 // requests here.
//                                                 break;
//                                             case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
//                                                 Logger.e("Denied--" + "isCalling");
//                                                 break;
//                                             case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
//                                                 Logger.e("Denied--" + "isCalling");
//                                                 break;
//                                         }
//                                     }
//
//                                 }
//        );
//    }
//
//    @Override
//    public void onConnected(@Nullable Bundle bundle) {
//        try {
//            if (ActivityCompat.checkSelfPermission(mContext, Manifest.permission.ACCESS_FINE_LOCATION)
//                    != PackageManager.PERMISSION_GRANTED) {
//            } else {
//                location = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
//                LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
//
//                if (location == null) {
//                    LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
//                } else {
//                    //mapPrefences.saveMapData(mContext, String.valueOf(location.getLatitude()), String.valueOf(location.getLongitude()));
//                    AppSharedPreference.getInstance(mContext).setLatitude(String.valueOf(location.getLatitude()));
//                    AppSharedPreference.getInstance(mContext).setLongitude(String.valueOf(location.getLongitude()));
//                }
//                // TODO(: 1/2/17 LocationData of the user.
//            }
//        } catch (Exception e) {
//            e.getLocalizedMessage();
//        }
//    }
//
//    @Override
//    public void onConnectionSuspended(int i) {
//        Logger.e("connection_suspended");
//    }
//
//    @Override
//    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//        if (connectionResult.hasResolution()) {
//            try {
//                if (isLocationConfirmation) {
//                    connectionResult.startResolutionForResult((Activity) mContext,
//                            CONNECTION_FAILURE_RESOLUTION_REQUEST);
//                }
//                /*
//                 * Thrown if Google Play services canceled the original
//                 * PendingIntent
//                 */
//            } catch (Exception e) {
//                // Log the error
//                e.printStackTrace();
//            }
//        } else {
//            /*
//             * If no resolution is available, display a dialog to the
//             * user with the error.
//             */
//            Logger.e("LocationData services connection failed with code " + connectionResult.getErrorCode());
//            try {
//                if (connectionResult.getErrorCode() == SERVICE_VERSION_UPDATE_REQUIRED) {
//                    ((Activity) mContext).startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.google.android.gms")));
//                }
//            } catch (Exception e) {
//            }
//
//        }
//    }
//
//    /*
//     * This method is calling to onLocationChanged()
//     *
//     * */
//    @Override
//    public void onLocationChanged(Location location) {
////        Toast.makeText(mContext, "" + location, Toast.LENGTH_SHORT).show();
////        Logger.e("onLocationChanged      " + location);
//        this.location = location;
//        if (location.getLatitude() == 0 && location.getLongitude() == 0) {
//            Logger.e("OnLocation Changed:- With Lat:-0 & Long:-0");
//        } else {
//            getAddress(location.getLatitude(),location.getLongitude());
//           // AppSharedPreferences.getInstance(mContext).setLat(String.valueOf(location.getLatitude()));
//            //AppSharedPreferences.getInstance(mContext).setLong(String.valueOf(location.getLongitude()));
//            sendBroadCast();
//        }
//    }
//
//    public void connectClient(boolean isLocationConfirmation) {
//        this.isLocationConfirmation = isLocationConfirmation;
//        mGoogleApiClient.connect();
//    }
//
//    /*
//     * send broadcast while driving
//     * */
//    private void sendBroadCast() {
//       // Logger.e("broadcast send");
//        LocalBroadcastManager.getInstance(mContext).sendBroadcast(new Intent("current_location"));
//    }
//
//    private void getAddress(double latitude,double longitude){
//        Geocoder geocoder;
//        geocoder = new Geocoder(mContext, Locale.getDefault());
//        try {
//            List<Address> addresses= geocoder.getFromLocation(latitude, longitude, 1);
//            if (!addresses.isEmpty()) {
//                Address returnedAddress = addresses.get(0);
//                String locality=returnedAddress.getLocality()+", "+returnedAddress.getAdminArea()+", "+returnedAddress.getCountryName()+", "+returnedAddress.getCountryCode();
//                //AppSharedPreferences.getInstance(mContext).setAddress(locality);
//            } else {
//                //      Log.e("MyCurrentLoctionAddress", "No Address returned!");
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void stopFetchingLocation() {
//        if (mGoogleApiClient != null && mGoogleApiClient.isConnected())
//            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
//    }

 /*   public GoogleApiClient getmGoogleApiClient() {
        return mGoogleApiClient;
    }

    public void disconnectClient() {
        mGoogleApiClient.disconnect();
    }*/

//}
