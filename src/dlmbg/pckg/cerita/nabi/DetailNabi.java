package dlmbg.pckg.cerita.nabi;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/*
 * Gede Lumbung - 2013
 * http://gedelumbung.com
 */

public class DetailNabi extends Activity{

	private TextView nama_nabi_et, keterangan_et;
	private ImageView gambar_iv;
	
	String var_nama_nabi, var_keterangan, var_gambar;

	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);

		setContentView(R.layout.detail);

		nama_nabi_et = (TextView) findViewById(R.id.nama_nabi_detail);
		keterangan_et = (TextView) findViewById(R.id.keterangan_detail);
		gambar_iv = (ImageView) findViewById(R.id.gambar_detail);
		
		Bundle extras = getIntent().getExtras();
		var_nama_nabi = extras.getString("nama_nabi");
		var_keterangan = extras.getString("keterangan");
		var_gambar = extras.getString("gambar");

		nama_nabi_et.setText(var_nama_nabi);
		keterangan_et.setText(var_keterangan);
		
		Bitmap bmImg = BitmapFactory.decodeFile(var_gambar);
		gambar_iv.setImageBitmap(bmImg);
		
		String imageInSD = var_gambar;      
		Bitmap bitmap = BitmapFactory.decodeFile(imageInSD);
		gambar_iv.setImageBitmap(bitmap);
		

	}

}
