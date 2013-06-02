package dlmbg.pckg.cerita.nabi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/*
 * Gede Lumbung - 2013
 * http://gedelumbung.com
 */

public class MainActivity extends Activity {
	SessionManager session;

	public static final String EXTRA_ROWID = "rowid";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        session = new SessionManager(getApplicationContext());
        
		Button tmb_dashboard = (Button) findViewById(R.id.btn_login);
 		tmb_dashboard.setOnClickListener(new View.OnClickListener() {
 			@Override
 			public void onClick(View view) {
 				StartAdmin();
 			}
 		});

		if (session.isLoggedIn() == true) 
		{
			tmb_dashboard.setText("Log Out");
		}
 		
        Button tmb_tambah = (Button) findViewById(R.id.btn_tambah_data);
        tmb_tambah.setOnClickListener(new View.OnClickListener() {
 			@Override
 			public void onClick(View view) {
 				StartTambahData();
 			}
 		});

        Button tmb_about = (Button) findViewById(R.id.btn_about);
 		tmb_about.setOnClickListener(new View.OnClickListener() {
 			@Override
 			public void onClick(View view) {
 				StartAbout();
 			}
 		});

        Button tmb_data_nabi = (Button) findViewById(R.id.btn_data_nabi);
        tmb_data_nabi.setOnClickListener(new View.OnClickListener() {
 			@Override
 			public void onClick(View view) {
 				StartDataNabi();
 			}
 		});
	}
    
    public void StartAbout() {
		Intent intent = new Intent(this, About.class);
		startActivity(intent);
	}
    
    public void StartTambahData() {
    	if(session.isLoggedIn() == true)
    	{
    		Intent intent = new Intent(this, TambahData.class);
    		intent.putExtra("nama_nabi", "");
    		startActivity(intent);
    	}
    	else
    	{
    		Intent intent = new Intent(this, Admin.class);
    		Toast.makeText(this, "Anda harus log in terlebih dahulu untuk mengakses menu ini",Toast.LENGTH_LONG).show();
    		startActivity(intent);
    	}
	}
    
    public void StartDataNabi() {
		Intent intent = new Intent(this, DataNabi.class);
		startActivity(intent);
	}
    
    public void StartAdmin() {
    	if(session.isLoggedIn() == true)
    	{
    		session.logoutUser();
    		finish();
    	}
    	else
    	{
    		Intent intent = new Intent(this, Admin.class);
    		startActivity(intent);
    		finish();
    	}
	}


}
