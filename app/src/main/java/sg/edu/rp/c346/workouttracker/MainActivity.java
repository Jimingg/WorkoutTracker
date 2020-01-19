package sg.edu.rp.c346.workouttracker;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new DatabaseHelper(this);
        final EditText etName = findViewById(R.id.editTextName);
        final EditText etSets = findViewById(R.id.editTextSets);
        final EditText etReps = findViewById(R.id.editTextReps);

        Button btnAdd = findViewById(R.id.buttonAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                    //set the dialog details
                    myBuilder.setTitle(etName.getText().toString());
                    myBuilder.setMessage("Add new workout?");
                    myBuilder.setCancelable(false);
                    myBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {


                            Toast.makeText(getApplicationContext(), "New workout added", Toast.LENGTH_LONG).show();

                            Intent intent = new Intent(getBaseContext(), View_shift.class);



                            boolean trt = myDB.addData(etName.getText().toString(),etSets.getText().toString(),etReps.getText().toString());
                            startActivity(intent);
                            if (trt) {

                            }


                        }
                    });
                    myBuilder.setNegativeButton("CANCEL", null);
                    AlertDialog myDialog = myBuilder.create();

                    myDialog.show();
                }

        });

        final BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.Bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.action_home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.action_home:
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();

                        Intent intent1 = new Intent(getBaseContext(),MainActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.action_view:
                        Toast.makeText(MainActivity.this, "View Statistics", Toast.LENGTH_SHORT).show();
                        Intent intent2 = new Intent(getBaseContext(),View_shift.class);
                        startActivity(intent2);
                        break;

                }
                return true;
            }
        });



    }

}
