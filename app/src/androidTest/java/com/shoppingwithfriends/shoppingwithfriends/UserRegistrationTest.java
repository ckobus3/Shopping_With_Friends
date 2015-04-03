package com.shoppingwithfriends.shoppingwithfriends;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.EditText;

public class UserRegistrationTest extends ActivityUnitTestCase<UserRegistration> {

    Intent launchIntent;

    public UserRegistrationTest() {
        super(UserRegistration.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        launchIntent = new Intent(getInstrumentation().getTargetContext(), UserRegistration.class);
    }

    public void testRegister() {
        startActivity(launchIntent, null, null);
        EditText et = (EditText) getActivity().findViewById(R.id.editText);
        assertNotNull(et);
    }


}
