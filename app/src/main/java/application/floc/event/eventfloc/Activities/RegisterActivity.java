package application.floc.event.eventfloc.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import org.jasypt.util.password.StrongPasswordEncryptor;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;
import java.util.Date;

import application.floc.event.eventfloc.DatabaseQueries;
import application.floc.event.eventfloc.EventsClasses.Society;
import application.floc.event.eventfloc.EventsClasses.Student;
import application.floc.event.eventfloc.R;

/**
 * Created by Vanessa on 10/05/2015.
 */
public class RegisterActivity extends ActionBarActivity {
    public static final String EXTRA_REGISTER_CLICKED = "com.example.raymond.eventfloc.registration";

    EditText registerFirstName;
    EditText registerLastName;
    EditText registerEmail;
    EditText registerPassword;
    EditText registerConfirmPassword;
    RadioButton registerSocietyType;
    RadioButton registerStudentType;
    Button registerButton;
    Button backButton;
    int selectedUserType = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerSetButtons();
        final DatabaseQueries dq = new DatabaseQueries(this);


        registerSocietyType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                registerFirstName.setHint("Society Name");
                registerLastName.setHint("Faculty");
                selectedUserType = 2;
            }
        });

        registerStudentType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                registerFirstName.setHint("First Name");
                registerLastName.setHint("Last Name");
                selectedUserType = 1;
            }
        });


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String firstName = registerFirstName.getText().toString();
                String lastName = registerLastName.getText().toString();
                String password1 = registerPassword.getText().toString();
                String password2 = registerConfirmPassword.getText().toString();
                String email = registerEmail.getText().toString();

                //Checks if there are any empty fields
                if (!firstName.trim().equals("") || !lastName.trim().equals("") || !password1.trim().equals("") || !password2.trim().equals("")) {
                    //Check if email is valid
                    if (email.matches(".*@*.") && email.matches(".*.com*.")) {
                        //Checks if entered passwords are equal to each other
                        if (password1.equals(password2)) {


                            boolean exists = false;


                            //if the password length is greater than 8. CHANGE BACK TO 8 LATER-------------------
                            if (password1.length() > 2) {

                                //Checks to see if the email has already been registered
                                exists = dq.doesEmailExist(email);
                                if (exists) {
                                    //the email has been registered already, show toast
                                    Toast.makeText(RegisterActivity.this, R.string.email_registered, Toast.LENGTH_LONG).show();
                                } else {
                                    //email has not been registered, insert the user into DB
                                    if (registerStudentType.isChecked()) {
                                        //if student radio button is selected
                                        Student s = null;
                                        try {
                                            s = fillStudent();
                                            s.setUserType(1);
                                            //Log.d("ADDING STUDENT", s.toString());
                                        } catch (InvalidKeySpecException e) {
                                            e.printStackTrace();
                                        } catch (NoSuchAlgorithmException e) {
                                            e.printStackTrace();
                                        }

                                        dq.insertStudent(s);
                                        Log.d("INSERTING STUDENT", dq.findUserEmail(email).toString());
                                        //show successful registration toast
                                        passwordToast(true);
                                        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                                        startActivity(i);
                                    } else if (registerSocietyType.isChecked()) {
                                        //if society radio button is selected
                                        Society s = null;
                                        s = fillSociety();
                                        s.setUserType(2);
                                        //Log.d("ADDING SOCIETY", s.toString());
                                        dq.insertSociety(s);
                                        Log.d("ADDING SOCIETY CHECK 2", dq.findUserEmail(email).toString());
                                        try {
                                            Log.d("User email check", dq.getSociety(email).toString());
                                        } catch (ParseException e) {
                                            e.printStackTrace();
                                        }
                                        //show successful registration toast
                                        passwordToast(true);
                                        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                                        startActivity(i);
                                    } else {
                                        //if no radio button selected, assume default of student
                                        Student s = null;
                                        try {
                                            s = fillStudent();
                                            s.setUserType(1);
                                            //Log.d("ADDING STUDENT", s.toString());
                                        } catch (InvalidKeySpecException e) {
                                            e.printStackTrace();
                                        } catch (NoSuchAlgorithmException e) {
                                            e.printStackTrace();
                                        }

                                        dq.insertStudent(s);
                                        Log.d("INSERTING STUDENT", dq.findUserEmail(email).toString());
                                        //show successful registration toast
                                        passwordToast(true);
                                        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                                        startActivity(i);
                                    }
                                }
                            } else {
                                //show password too short toast
                                Toast.makeText(RegisterActivity.this, R.string.password_length, Toast.LENGTH_LONG).show();
                            }


                        } else {
                            //Show the non-matching password toast if passwords not equal
                            passwordToast(false);
                        }
                    } else {
                        //show invalid email toast if email is not valid
                        Toast.makeText(RegisterActivity.this, R.string.invalid_email, Toast.LENGTH_LONG).show();
                    }
                } else {
                    //if one or more fields empty show toast
                    Toast.makeText(RegisterActivity.this, R.string.empty_fields, Toast.LENGTH_SHORT).show();
                }

            }

        });


        backButton.setOnClickListener(new View.OnClickListener()

                                      {
                                          @Override
                                          public void onClick (View v){
                                              startLoginActivity();
                                          }
                                      }

        );

    }


    /**
     * Change the toast if some fields are correct/incorrect
     * @param goodPassword
     */

    public void passwordToast(boolean goodPassword) {
        int toastMessage = 0;


        if (goodPassword) {
            toastMessage = R.string.matching_password;

        } else {
            toastMessage = R.string.nonmatching_password;
        }

        Toast.makeText(RegisterActivity.this, toastMessage, Toast.LENGTH_SHORT).show();

    }

    ////


    /**
     * Set the buttons
     */
    public void registerSetButtons() {
        registerFirstName = (EditText) findViewById(R.id.editFirstname);
        registerLastName = (EditText) findViewById(R.id.editLastname);
        registerEmail = (EditText) findViewById(R.id.email);
        registerPassword = (EditText) findViewById(R.id.password);
        registerConfirmPassword = (EditText) findViewById(R.id.password_confirm);
        registerStudentType = (RadioButton) findViewById(R.id.radioButton2);
        registerSocietyType = (RadioButton) findViewById(R.id.radioButton);
        registerButton = (Button) findViewById(R.id.registerButton);
        backButton = (Button) findViewById(R.id.backButtonRegister);
    }


    /**
     * Creates a student with the filled in registration form
     *
     * @return
     */
    public Student fillStudent() throws InvalidKeySpecException, NoSuchAlgorithmException {
        DatabaseQueries dq = new DatabaseQueries(this);
        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();


        String firstName = registerFirstName.getText().toString();
        String lastName = registerLastName.getText().toString();
        String email = registerEmail.getText().toString();
        String password = registerPassword.getText().toString();
        String confirmPassword = registerConfirmPassword.getText().toString();
        // int userType = 1;


        Student s = new Student();
        s.setFirstName(firstName);
        s.setLastName(lastName);
        s.setUserEmail(email);
        String encryptedPassword = passwordEncryptor.encryptPassword(password);
        s.setPassword(encryptedPassword);
        //s.setUserType(1);

        return s;

    }


    /**
     * Start the activity
     */
    public void startLoginActivity() {
        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
        RegisterActivity.this.startActivity(i);
    }

    /**
     * Gets societ details from filled out registration form
     *
     * @return
     */
    public Society fillSociety() {
        DatabaseQueries dq = new DatabaseQueries(this);

        StrongPasswordEncryptor passwordEncryptor = new StrongPasswordEncryptor();

        String societyName = registerFirstName.getText().toString();
        String societyEmail = registerEmail.getText().toString();

        //HOW DO WE DO APPROVED DATE?
        Date societyDate = new Date();
        String societyFaculty = registerLastName.getText().toString();

        String password = registerPassword.getText().toString();
        String confirmPassword = registerConfirmPassword.getText().toString();
        //int userType = 2;

        Society s = new Society();
        s.setSocietyName(societyName);
        s.setUserEmail(societyEmail);
        s.setApprovalDate(societyDate);
        String encryptedPassword = passwordEncryptor.encryptPassword(password);
        s.setPassword(encryptedPassword);
        s.setSocietyFaculty(societyFaculty);
        s.setUserType(2);

        return s;
    }


}

