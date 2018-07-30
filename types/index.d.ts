// Type definitions for Apache Cordova Device plugin
// Project: https://github.com/apache/cordova-plugin-device
// Definitions by: Microsoft Open Technologies Inc <http://msopentech.com>
// Definitions: https://github.com/DefinitelyTyped/DefinitelyTyped
// 
// Copyright (c) Microsoft Open Technologies Inc
// Licensed under the MIT license 

/**
 * This plugin defines a global device object, which describes the device's hardware and software.
 * Although the object is in the global scope, it is not available until after the deviceready event.
 */

interface Window {
    rkatime: Rkatime;
}


interface Rkatime {
    /** Get the version of Cordova running on the device. */
    cordova: string;
    /** Indicates that Cordova initialize successfully. */
    available: boolean;

    is_time_automatic_enabled: boolean;

    getOtherInfo: (
        onResolve: (data: string) => void,
        onReject: (message: string) => void
        ) => void;

 
}


declare var rkatime: Rkatime;