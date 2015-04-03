package com.shoppingwithfriends.shoppingwithfriends;

import android.content.Intent;
import android.test.ActivityUnitTestCase;
import android.widget.Button;
import android.widget.EditText;

/**
 * @author Colby McBride
 */
@SuppressWarnings("ALL")
public class UserRegistrationTest extends ActivityUnitTestCase<UserRegistration> {

    Intent launchIntent;

    public UserRegistrationTest() {
        super(UserRegistration.class);
    }

    public void setUp() throws Exception {
        super.setUp();
        launchIntent = new Intent(getInstrumentation().getTargetContext(), UserRegistration.class);
    }

    /**
     * tests if fields are not null
     */
    public void testNotNull() {
        startActivity(launchIntent, null, null);
        EditText et = (EditText) getActivity().findViewById(R.id.editText);
        EditText et2 = (EditText) getActivity().findViewById(R.id.editText2);
        EditText et3= (EditText) getActivity().findViewById(R.id.editText3);
        EditText et4 = (EditText) getActivity().findViewById(R.id.editText4);
        Button b = (Button) getActivity().findViewById(R.id.button);
        assertNotNull(et);
        assertNotNull(et2);
        assertNotNull(et3);
        assertNotNull(et4);
        assertNotNull(b);
    }

    /**
     * Tests if register checks length correctly
     */
    public void testValidInputs() {
        startActivity(launchIntent, null, null);
        EditText et = (EditText) getActivity().findViewById(R.id.editText);
        EditText et2 = (EditText) getActivity().findViewById(R.id.editText2);
        EditText et3= (EditText) getActivity().findViewById(R.id.editText3);
        EditText et4 = (EditText) getActivity().findViewById(R.id.editText4);
        Button b = (Button) getActivity().findViewById(R.id.button);
        et.setText("name");
        et2.setText("username");
        et3.setText("password");
        et4.setText("email@gmail.com");
        String name = et.getText().toString();
        String un = et2.getText().toString();
        String pass = et3.getText().toString();
        String email = et4.getText().toString();
        assertEquals(name, "name");
        assertEquals(un, "username");
        assertEquals(pass, "password");
        assertEquals(email, "email@gmail.com");
        if (un.equals("") || pass.equals("") || email.equals("") || name.equals("")) {
            et2.setError("Every field must be completed");
            et2.requestFocus();
        } else {
            assertFalse(un.equals(""));
            assertFalse(pass.equals(""));
            assertFalse(name.equals(""));
            assertFalse(email.equals(""));
        }
    }


}
