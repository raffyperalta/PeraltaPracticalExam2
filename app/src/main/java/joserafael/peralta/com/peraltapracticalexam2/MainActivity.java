package joserafael.peralta.com.peraltapracticalexam2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    EditText etFirstName;
    EditText etLastName;
    EditText etExam1;
    EditText etExam2;
    Button btnDisplay;
    TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        etFirstName = findViewById(R.id.firstName);
        etLastName = findViewById(R.id.lastName);
        etExam1 = findViewById(R.id.exam1);
        etExam2 = findViewById(R.id.exam2);
        btnDisplay = findViewById(R.id.displayAverage);
        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertGrade();
            }
        });



    }

    public void insertGrade(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference root = db.getReference("Grade");
        String fname = etFirstName.getText().toString().trim();
        String lname = etLastName.getText().toString().trim();
        Long grade = Long.parseLong(etExam1.getText().toString().trim());
        Long grade2 = Long.parseLong(etExam2.getText().toString().trim());

        Long ave = (grade + grade2) / 2;
        Grade sgrade = new Grade(fname,lname,ave);
        String key = root.push().getKey();
        root.child(key).setValue(sgrade);
        Toast.makeText(this,"record added to db",Toast.LENGTH_LONG).show();
        display.setText("Your Average is:" + ave);


    }
}
