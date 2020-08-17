package sg.edu.rp.c346.id19045346.demodynamicspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    Spinner spn1;
    Spinner spn2;
    Button btnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.buttonUpdate);

        //Initialise the ArrayList
        alNumbers = new ArrayList<>();

        //Create an ArrayAdapter using the default Spinner layout and the ArrayList
        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item,alNumbers);


        // Bind the ArrayAdapter to the Spinner
        spn2.setAdapter(aaNumbers);


        // alNumbers.addAll(Arrays.asList("2","4","6"));

        //Get the string-array and store as an Array
        final String[] strNumbers = getResources().getStringArray(R.array.even_numbers);
        final String[] oddNumbers = getResources().getStringArray(R.array.odd_numbers);

        //convert Array to list and add to the arraylist
        alNumbers.addAll(Arrays.asList(strNumbers));

        // Implement the button onClick() method
        // to load the correct numbers list when it is clicked
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();

                //Apply either of the two approaches
                // to load the correct number list based on the selection of spn1

                if(pos == 0) {
                    alNumbers.addAll(Arrays.asList(strNumbers));
                    spn2.setSelection(2);

                }
                else if(pos == 1) {
                    spn2.setSelection(1);
                    alNumbers.addAll(Arrays.asList(oddNumbers));
                }

            }
        });


        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position) {
                    case 0:
                        alNumbers.clear();
                        spn2.setSelection(2);
                        alNumbers.addAll(Arrays.asList(strNumbers));
                        break;
                    case 1:
                        alNumbers.clear();
                        spn2.setSelection(1);
                        alNumbers.addAll(Arrays.asList(oddNumbers));
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
