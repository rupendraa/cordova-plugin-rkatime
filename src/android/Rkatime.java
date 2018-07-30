/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
*/
package org.apache.cordova.rkatime;

import java.util.TimeZone;

import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import android.os.Bundle;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;

import android.provider.Settings;

public class Rkatime extends CordovaPlugin {
    public static final String TAG = "Rkatime";

 
    /**
     * Constructor.
     */
    // public Rkatime() {
    //       Log.i("Rkatime", "called  Rkatime ");
    // }

    /**
     * Sets the context of the Command. This can then be used to do things like
     * get file paths associated with the Activity.
     *
     * @param cordova The context of the main Activity.
     * @param webView The CordovaWebView Cordova is running in.
     */
    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
         Log.i("Rkatime", "called  initialize ");
        super.initialize(cordova, webView);
    }

    /**
     * Executes the request and returns PluginResult.
     *
     * @param action            The action to execute.
     * @param args              JSONArry of arguments for the plugin.
     * @param callbackContext   The callback id used when calling back into JavaScript.
     * @return                  True if the action was valid, false if not.
     */
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        // if (action.equals("getOtherInfo")) {
        //     JSONObject r = new JSONObject();
        //     r.put("is_time_automatic_enabled", this.isTimeAutomaticEnabled() );
        //     callbackContext.success(r);
        // }
        // else {
        //     return false;
        // }
        // return true;


           Log.i("Rkatime", "called  getOtherInfo ");

        if(action.equals("getOtherInfo")) {
           Log.i("Rkatime", "call  isTimeAutomaticEnabled ");
          

            JSONObject r = new JSONObject();
            r.put("is_time_automatic_enabled", isTimeAutomaticEnabled() );
            callbackContext.success(r);


           //callbackContext.success( isTimeAutomaticEnabled() ? 1 : 0);
        }else{
            return false;
        }
        return true;

    }

    //--------------------------------------------------------------------------
    // LOCAL METHODS
    //--------------------------------------------------------------------------
 
    /**
     * Function to check if the device is manufactured by Amazon
     *
     * @return
     */
    private boolean isTimeAutomaticEnabled() { 
        Log.i("Rkatime", "called isTimeAutomaticEnabled ");
        // throws Exception
        //logDebug("call isTimeAutomaticEnabled function");
        boolean result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR1) {
            Log.i("Rkatime", "called isTimeAutomaticEnabled  1");
            result = Settings.System.getInt(this.cordova.getActivity().getContentResolver(), Settings.Global.AUTO_TIME, 0) == 1;
        }else{
            Log.i("Rkatime", "called isTimeAutomaticEnabled  2");
            result = Settings.Global.getInt(this.cordova.getActivity().getContentResolver(), Settings.Global.AUTO_TIME, 0) == 1;
        }
        Log.i("Rkatime", "called isTimeAutomaticEnabled  3");

        return result;
    }   
  

}
