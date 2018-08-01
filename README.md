# cordova-plugin-rkatime


# Rkatime

check android setting autodatetime is on-off enable/disable

cordova plugin add https://github.com/rupendraa/cordova-plugin-rkatime


	window.AppUpdate.getOtherInfo(onSuccess, onFail);  //return is_time_automatic_enabled  = true/false


		function onSuccess(datax){

		 if( !datax.is_time_automatic_enabled ){

			// == do somthing like this if setting is disable/off 

		  }

		}

 
