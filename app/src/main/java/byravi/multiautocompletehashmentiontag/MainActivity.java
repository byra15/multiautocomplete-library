package byravi.multiautocompletehashmentiontag;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    MultiAutoCompleteTextView  multiAutoCompleteTexthashmention;
    //define the hashtags and user tag
    String[] tags = {"@john mart", "@ajai jhan", "@num kij", "@user tag","@philip luci", "#enjoy", "#home", "#wow", "#holiday", "#love"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        multiAutoCompleteTexthashmention = findViewById(R.id.hashtagtextView);



        ArrayAdapter<String> tagArray = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tags);
        multiAutoCompleteTexthashmention.setAdapter(tagArray);
        multiAutoCompleteTexthashmention.setThreshold(1);

        multiAutoCompleteTexthashmention.setTokenizer(new SpaceTokenizer());
        System.out.println("text output"+multiAutoCompleteTexthashmention.getText().toString());

        multiAutoCompleteTexthashmention.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {


            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {


            }

            @Override
            public void afterTextChanged(Editable editable) {
                String string = editable.toString();
                String[] split = string.split("\\s");

                int startIndex = 0;
                for(int i = 0 ; i < split.length ; i++){
                    String s = split[i];
                    if(multiAutoCompleteTexthashmention.getText().toString().contains(s)){
                        if(s.contains("#")){
                            int index = string.indexOf(s, startIndex);
                                //set span color for # tags when typing
                            editable.setSpan(new ForegroundColorSpan(Color.BLUE),
                                    index,
                                    index + s.length(),
                                    Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                            startIndex = index + s.length();
                        }

                    }

                }



            }
        });



    }

}
