package sg.edu.rp.c346.id21009632.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.sql.Time;


public class MainActivity extends AppCompatActivity {

    EditText firstName;
    EditText lastName;
    EditText phoneNo;
    EditText groupSize;
    RadioGroup smokingArea;
    DatePicker date;
    TimePicker time;
    Button submitButton;
    Button resetButton;
    Button hiddenResetButton;
    TextView heading;
    TextView dateHeading;
    TextView timeHeading;
    TextView hiddenText;
    View line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstName = findViewById(R.id.firstName);
        lastName = findViewById(R.id.lastName);
        phoneNo = findViewById(R.id.phone);
        groupSize = findViewById(R.id.sizeOfGroup);
        smokingArea = findViewById(R.id.smokingAreaChoice);
        date = findViewById(R.id.datePicker);
        time = findViewById(R.id.timePicker);
        submitButton = findViewById(R.id.submitButton);
        resetButton = findViewById(R.id.resetButton);
        hiddenResetButton = findViewById(R.id.hiddenResetButton);
        heading = findViewById(R.id.headerText);
        dateHeading = findViewById(R.id.dateHeading);
        timeHeading = findViewById(R.id.timeHeading);
        hiddenText = findViewById(R.id.hiddenText);
        line = findViewById(R.id.line2);

        hiddenResetButton.setClickable(false);
        date.updateDate(2022,4,11);
        time.setCurrentHour(19);
        time.setCurrentMinute(30);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean check = true;

                if (firstName.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your first name", Toast.LENGTH_LONG).show();
                    check = false;
                } else if (lastName.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your last name", Toast.LENGTH_LONG).show();
                    check = false;
                } else if (phoneNo.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your phone number", Toast.LENGTH_LONG).show();
                    check = false;
                } else if (groupSize.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter your group's size", Toast.LENGTH_LONG).show();
                    check = false;
                } else if (smokingArea.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(MainActivity.this, "Please choose your of dining area choice", Toast.LENGTH_LONG).show();
                    check = false;
                } else if (date.getYear() < 2022 && date.getMonth() < 5 && date.getDayOfMonth() < 12) {
                    Toast.makeText(MainActivity.this, "Please select a day after today", Toast.LENGTH_LONG).show();
                    check = false;
                }

                if (check == true) {
                    heading.setText("Booking confirmed!");
                    firstName.setVisibility(View.INVISIBLE);
                    lastName.setVisibility(View.INVISIBLE);
                    phoneNo.setVisibility(View.INVISIBLE);
                    groupSize.setVisibility(View.INVISIBLE);
                    smokingArea.setVisibility(View.INVISIBLE);
                    date.setVisibility(View.INVISIBLE);
                    time.setVisibility(View.INVISIBLE);
                    submitButton.setVisibility(View.INVISIBLE);
                    resetButton.setVisibility(View.INVISIBLE);
                    dateHeading.setVisibility(View.INVISIBLE);
                    timeHeading.setVisibility(View.INVISIBLE);
                    line.setVisibility(View.INVISIBLE);
                    hiddenResetButton.setClickable(true);
                    hiddenResetButton.setText("Reset?");
                    hiddenText.setText("Name: " + firstName.getText().toString() + " " + lastName.getText().toString() + "\nPhone Number: " +
                            phoneNo.getText().toString() + "\nSize of Group: " + groupSize.getText().toString() + "\nDate: " + (date.getDayOfMonth() + 1) + "/" + date.getMonth() + "/" + date.getYear()
                            + "\nTime: " + time.getCurrentHour() + ":" + time.getCurrentMinute());
                }
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firstName.setText("");
                lastName.setText("");
                phoneNo.setText("");
                groupSize.setText("");
                smokingArea.clearCheck();
            }
        });

        hiddenResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                hiddenResetButton.setText("Welcome to my reservation app!");
                hiddenResetButton.setClickable(false);
                firstName.setVisibility(View.VISIBLE);
                lastName.setVisibility(View.VISIBLE);
                phoneNo.setVisibility(View.VISIBLE);
                groupSize.setVisibility(View.VISIBLE);
                smokingArea.setVisibility(View.VISIBLE);
                date.setVisibility(View.VISIBLE);
                time.setVisibility(View.VISIBLE);
                submitButton.setVisibility(View.VISIBLE);
                resetButton.setVisibility(View.VISIBLE);
                dateHeading.setVisibility(View.VISIBLE);
                timeHeading.setVisibility(View.VISIBLE);
                line.setVisibility(View.VISIBLE);
                firstName.setText("");
                lastName.setText("");
                phoneNo.setText("");
                groupSize.setText("");
                smokingArea.clearCheck();
                hiddenText.setText("");
            }
        });

        time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker v, int hourOfDay, int minute) {

                if (hourOfDay < 8 || hourOfDay > 20) {
                    time.setCurrentHour(19);
                    time.setCurrentMinute(30);
                }
            }
        });
    }
}