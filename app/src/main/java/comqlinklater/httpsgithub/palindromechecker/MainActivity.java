/**
 *  Name: Quentin Linklater
 *  Class: 30/40S computer science
 *  teacher: Mr. Hardman
 *  Last time modified: 4/25/2018
 */

package comqlinklater.httpsgithub.palindromechecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mWordInput;
    private TextView mResult;
    private TextView mErrorMessage;

    /**
     * onCreate is the method that is rn when the activity is create
     *
     * @param savedInstanceState is a bundle of data that can be used to restore
     *                           a previous instance of this activity
     * @return Nothing is returned
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWordInput = (EditText) findViewById(R.id.et_word_input);
        mErrorMessage = (TextView) findViewById(R.id.tv_error_message);
        mResult = (TextView) findViewById(R.id.tv_result);

        mWordInput.addTextChangedListener( wordInputWatcher );
    }

    private final TextWatcher wordInputWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
        {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
        {

        }

        /**
         * afterTextChanged is the method that is called once the text has changed in an
         * editable object
         *
         * @param editable is the object that has text changed within it
         * @return Nothing is returned
         */
        @Override
        public void afterTextChanged(Editable editable)
        {
            String wordInput;
            boolean result;

            if( editable.length() == 0)
            {
                mResult.setText("");
                mErrorMessage.setText("The user must enter a word");
            }
            else
            {
                mResult.setText("");
                mErrorMessage.setText("");

                wordInput = mWordInput.getText().toString().toUpperCase();
                result = checkPalindrome( wordInput, 0 );

                if( result == true )
                {
                    mResult.setText("This word is indeed a palindrome");
                }
                else
                {
                    mResult.setText("This word is not a palindrome");
                }
            }
        }
    };

    /**
     * checkPalindrome checks if the word that the user has put in is a palindrome
     *
     * @param currentWord is the current word the user has put in
     * @param currentNumber is the index to check if the first letter matches with the last letter
     * @return a boolean is returned
     */
    private boolean checkPalindrome( String currentWord, int currentNumber )
    {
        boolean result;
        int indexFromEnd = currentWord.length() - currentNumber -1;

        if( currentWord.charAt(currentNumber) == currentWord.charAt(indexFromEnd) )
        {
            if( currentNumber == indexFromEnd || currentNumber == indexFromEnd -1)
            {
                result = true;
            }
            else
            {
                result = checkPalindrome( currentWord, currentNumber +1 );
            }
        }
        else
        {
            result = false;
        }

        return result;
    }
}
