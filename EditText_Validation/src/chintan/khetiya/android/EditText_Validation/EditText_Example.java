package chintan.khetiya.android.EditText_Validation;



import android.app.Activity;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

public class EditText_Example extends Activity {
	EditText name, email, phone_number, auto_complate, sign_number;
	String valid_name = null, valid_email = null, valid_sign_number = null;
	AutoCompleteTextView actvDev;

	String[] devplatforms = { "C", "C++", "Java", "C#.NET", "iPhone",
			"Android", "ASP.NET", "PHP", "Python", };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		name = (EditText) findViewById(R.id.name);
		email = (EditText) findViewById(R.id.email);
		phone_number = (EditText) findViewById(R.id.phone_number);
		sign_number = (EditText) findViewById(R.id.sign_number);

		// =========================================================================================================
		name.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Person_Name(name);
			}
		});
		// =========================================================================================================
		email.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Email(email);
			}
		});

		// =========================================================================================================

		phone_number
				.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
		// =========================================================================================================

		sign_number.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub

			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub

			}

			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				Is_Valid_Sign_Number_Validation(1, 10, sign_number);
			}
		});
		// =========================================================================================================
		// auto complete text
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, devplatforms);

		AutoCompleteTextView actvDev = (AutoCompleteTextView) findViewById(R.id.actv);
		actvDev.setThreshold(1);
		
		
		actvDev.setAdapter(adapter);
		// =========================================================================================================
	}

	// =========================================================================================================
	public void Is_Valid_Person_Name(EditText edt) throws NumberFormatException {
		if (edt.getText().toString().length() <= 0) {
			edt.setError("Accept Alphabets Only.");
			valid_name = null;
		} else if (!edt.getText().toString().matches("[a-zA-Z ]+")) {
			edt.setError("Accept Alphabets Only.");
			valid_name = null;
		} else {
			valid_name = edt.getText().toString();
		}

	}

	// =========================================================================================================
	public void Is_Valid_Email(EditText edt) {
		if (edt.getText().toString() == null) {
			edt.setError("Invalid Email Address");
			valid_email = null;
		} else if (isEmailValid(edt.getText().toString()) == false) {
			edt.setError("Invalid Email Address");
			valid_email = null;
		} else {
			valid_email = edt.getText().toString();
		}
	}

	boolean isEmailValid(CharSequence email) {
		return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
	} // end of email matcher

	// =========================================================================================================

	public void Is_Valid_Sign_Number_Validation(int MinLen, int MaxLen,
			EditText edt) throws NumberFormatException {
		if (edt.getText().toString().length() <= 0) {
			edt.setError("Sign Number Only");
			valid_sign_number = null;
		} else if (Double.valueOf(edt.getText().toString()) < MinLen
				|| Double.valueOf(edt.getText().length()) > MaxLen) {
			edt.setError("Out of Range " + MinLen + " or " + MaxLen);
			valid_sign_number = null;
		} else {
			valid_sign_number = edt.getText().toString();
			// Toast.makeText(getApplicationContext(),
			// ""+edt.getText().toString(), Toast.LENGTH_LONG).show();
		}

	} // END OF Edittext validation

}
