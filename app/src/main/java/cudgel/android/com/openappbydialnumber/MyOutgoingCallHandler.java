package cudgel.android.com.openappbydialnumber;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MyOutgoingCallHandler extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {

    String phoneNumber = getResultData();
    if (phoneNumber == null) {

       
        // No reformatted number, use the original
      //  phoneNumber = Intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
    }

    if(phoneNumber.equals("1234")){ // DialedNumber checking.
        // My app will bring up, so cancel the broadcast
        setResultData(null);

        // Start my app
        Intent i=new Intent(context,MainActivity.class);
        i.putExtra("extra_phone", phoneNumber);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }

    } // Extract phone number reformatted by previous receivers
}