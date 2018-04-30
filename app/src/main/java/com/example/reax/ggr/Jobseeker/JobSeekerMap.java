package com.example.reax.ggr.Jobseeker;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.reax.ggr.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;

public class JobSeekerMap extends Fragment implements View.OnClickListener,OnMapReadyCallback,
            GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    MapView mMapView;
    GoogleMap mGoogleMap_obj;
    Button Locationupdate_obj;
    double destlat,destlng,originlat,originlng;
    LocationManager locationManager_obj;
    Location location_obj=null;
    GoogleApiClient mGoogleApiClient_obj;
    UiSettings uisettings_obj;
    SeekBar mSeekBar;
    LocationRequest mLocationRequest;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    static final int REQUEST_LOCATION = 1;
    int PLACE_AUTOCOMPLETE_REQUEST_CODE = 1,radiusvalue=15;
    TextView seekbartxt;
    Marker marker_obj;

    // Declare a variable for the cluster manager.
    private ClusterManager<MyItem> mClusterManager;

    private OnFragmentInteractionListener mListener;

    public JobSeekerMap() {
        // Required empty public constructor
    }

    public static JobSeekerMap newInstance(String param1, String param2) {
        JobSeekerMap fragment = new JobSeekerMap();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View jobseeker_view=inflater.inflate(R.layout.fragment_job_seeker_map, container, false);
        mMapView =jobseeker_view.findViewById(R.id.jbskrmapViewid);
        seekbartxt=(TextView)jobseeker_view.findViewById(R.id.seekbartextid);
        mSeekBar = (SeekBar)jobseeker_view.findViewById(R.id.seekbarid);
        Locationupdate_obj=jobseeker_view.findViewById(R.id.jbskrmapupdtbtnid);

        //AutoComplete location text search box work
        PlaceAutocompleteFragment autocompleteFragment =(PlaceAutocompleteFragment)getActivity().getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                if (marker_obj != null) {
                    marker_obj.remove();
                }
                MarkerOptions addmarker_obj = new MarkerOptions();
                marker_obj =mGoogleMap_obj.addMarker(addmarker_obj.position(place.getLatLng()).title("You are in "+String.valueOf(place.getName())).snippet("Click to remove marker").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                mGoogleMap_obj.moveCamera(CameraUpdateFactory.newLatLng(place.getLatLng()));
                mGoogleMap_obj.animateCamera(CameraUpdateFactory.zoomTo(12));
            }
            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Toast.makeText(getActivity(), "Error occurend in getting name", Toast.LENGTH_SHORT).show();
            }
        });
        Locationupdate_obj.setOnClickListener(this);
        mMapView.onCreate(savedInstanceState);
        mMapView.onResume(); // needed to get the map to display immediately
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mMapView.getMapAsync(this);
        // Set a SeekBar change listener
        mSeekBar.setProgress(radiusvalue);
        seekbartxt.setText(""+radiusvalue+" Km(s)");
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                // Display the current progress of SeekBar
                radiusvalue=i;
                seekbartxt.setText(""+radiusvalue+" Km(s)");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        locationManager_obj=(LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);
        return jobseeker_view;
    }//end of onCreateView method

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
      //      throw new RuntimeException(context.toString()
      //              + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View view) {

    }//end of onClick method

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mGoogleMap_obj = googleMap;
        mGoogleMap_obj.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            //Google map UI setting work
            uisettings_obj = mGoogleMap_obj.getUiSettings();
            uisettings_obj.setZoomControlsEnabled(true);
            uisettings_obj.setAllGesturesEnabled(true);
            uisettings_obj.setCompassEnabled(true);
            uisettings_obj.setMapToolbarEnabled(false);
            uisettings_obj.setMyLocationButtonEnabled(true);
            uisettings_obj.isCompassEnabled();
            uisettings_obj.setIndoorLevelPickerEnabled(true);
            //Initialize Google Play Services
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    //Location Permission already granted
                    getCurrentLocation();
                    buildGoogleApiClient();
                    markeroperations_method();
                    mGoogleMap_obj.setMyLocationEnabled(true);
                } else {
                    //Request Location Permission
                    checkLocationPermission();
                }
            }
    }//end of onMapReady method

      private void checkLocationPermission() {
            if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // Should we show an explanation?
                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)) {
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Location Permission Needed")
                            .setMessage("This app needs the Location permission, please accept to use location functionality")
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                                }
                            })
                            .create()
                            .show();
                } else {
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                }
            }
        }//end of checkLocationPermission method

    public void markeroperations_method() {
//        //Marker options initialize
//        MarkerOptions destmarkerOption_obj = new MarkerOptions();
//        //marker icon set
//        destmarkerOption_obj.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
//      //  destlat=alllocations_list.get(0);
//        //Add markers
//        mGoogleMap_obj.addMarker(destmarkerOption_obj.position(new LatLng(30.7223, 76.7032)).title("Company Name1").snippet("Company Address1"));
//        mGoogleMap_obj.addMarker(destmarkerOption_obj.position(new LatLng(30.7105, 76.7128)).title("Company Name2").snippet("Company Address2"));
//        mGoogleMap_obj.addMarker(destmarkerOption_obj.position(new LatLng(30.7196, 76.6961)).title("Company Name3").snippet("Company Address3"));
//        //Move camera on origin location
//        mGoogleMap_obj.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(30.7223, 76.7032)));
//        mGoogleMap_obj.animateCamera(CameraUpdateFactory.zoomTo(12));
        setUpClusterer();
    }//end of marker operations method

    private void setUpClusterer() {
        // Position the map.
        mGoogleMap_obj.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(originlat, originlng), 10));
        mGoogleMap_obj.animateCamera(CameraUpdateFactory.zoomTo(12));
        // Initialize the manager with the context and the map.
        // (Activity extends context, so we can pass 'this' in the constructor.)
        mClusterManager = new ClusterManager<>(getActivity(),mGoogleMap_obj);
        // Point the map's listeners at the listeners implemented by the cluster manager.
        mGoogleMap_obj.setOnCameraIdleListener(mClusterManager);
        mGoogleMap_obj.setOnMarkerClickListener(mClusterManager);
        mGoogleMap_obj.setOnInfoWindowClickListener(mClusterManager);
        mClusterManager.setOnClusterClickListener(new ClusterManager.OnClusterClickListener<MyItem>() {
            @Override
            public boolean onClusterClick(Cluster<MyItem> cluster) {
                mGoogleMap_obj.animateCamera(CameraUpdateFactory.newLatLngZoom(cluster.getPosition(),(float) Math.floor(mGoogleMap_obj.getCameraPosition().zoom+2)), 500, null);
                return true;
            }//end of onClusterClick method
        });
        mClusterManager.setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener<MyItem>() {
            @Override
            public boolean onClusterItemClick(MyItem myItem) {
                markerinfoalertbox_method(myItem);
                return true;
            }//end of onClick method
        });
        mGoogleMap_obj.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                marker_obj.remove();
            }
        });
        // Add cluster items (markers) to the cluster manager.
        addItems();
    }//end of setUpClusterer method

    private void markerinfoalertbox_method(MyItem myItem) {
        TextView comp_name,comp_addrs,comp_phone;
        Button cancel;
        final AlertDialog dialog_obj;
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view1 = inflater.inflate(R.layout.mapinfoalertbox, null);
        builder.setView(view1);
        cancel=view1.findViewById(R.id.canclemapinfoid);
        comp_name=view1.findViewById(R.id.mapcompnameid);
        comp_addrs=view1.findViewById(R.id.mapcompaddrsid);
        comp_phone=view1.findViewById(R.id.mapcompnumid);
        comp_name.setText(myItem.getTitle());
        comp_addrs.setText(myItem.getSnippet());
        comp_phone.setText("9128765699");
        comp_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = "9128765699";
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            }
        });

        dialog_obj = builder.create();
        dialog_obj.show();
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_obj.dismiss();
            }
        });
    }//end of marker info alertbox method

    private void addItems() {
            MyItem offsetItem1 = new MyItem(30.7105, 76.7128,"Company 1","Address1");
            MyItem offsetItem2 = new MyItem(30.7196, 76.6961,"Company 2","Address2");
            MyItem offsetItem3 = new MyItem(30.7223, 76.7032,"Company 3","Address3");
            MyItem offsetItem4 = new MyItem(30.67995, 76.72211,"Company 4","Address4");
            MyItem offsetItem5 = new MyItem(30.7145, 76.7149,"Company 5","Address5");
            MyItem offsetItem6 = new MyItem(30.7241, 76.7174,"Company 6","Address6");
            mClusterManager.addItem(offsetItem1);
            mClusterManager.addItem(offsetItem2);
            mClusterManager.addItem(offsetItem3);
            mClusterManager.addItem(offsetItem4);
            mClusterManager.addItem(offsetItem5);
            mClusterManager.addItem(offsetItem6);
            mClusterManager.setAnimation(true);
  //      }
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case REQUEST_LOCATION:
                getCurrentLocation();
                break;
        }//end of switch case statement
    }//end of method

    public void getCurrentLocation(){
        if(ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(),Manifest.permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_LOCATION);
        }else{
            location_obj=locationManager_obj.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if(location_obj!=null){
                originlat=location_obj.getLatitude();
                originlng=location_obj.getLongitude();
            }else{
                Toast.makeText(getActivity(), "Current location is not able to find", Toast.LENGTH_SHORT).show();
            }

        }//end of if-else condition
    }//end of method

    protected synchronized void buildGoogleApiClient() {
        mGoogleApiClient_obj = new GoogleApiClient.Builder(getActivity())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient_obj.connect();
    }//end of buildGoogleApiClient method

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient_obj, mLocationRequest, this);
        }
    }//end of onConnected method

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        getCurrentLocation();
        mGoogleApiClient_obj.connect();
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient_obj, mLocationRequest, this);
        }
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mGoogleMap_obj.setMyLocationEnabled(true);
    }//end of onLocationChanged method

    @Override
    public void onPause() {
        super.onPause();
        //stop location updates when Activity is no longer active
        if (mGoogleApiClient_obj != null) {
            LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient_obj, this);
        }
    }//end of onPause method

    @Override
    public void onResume() {
        super.onResume();
        if (mGoogleApiClient_obj != null) {
            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient_obj, mLocationRequest, this);
        }
    }
}//end of main class
