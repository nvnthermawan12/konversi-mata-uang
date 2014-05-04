package com.glmvn.konversimatauang;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class MainActivity extends Activity {
  private AutoCompleteTextView hasil;
  private EditText input;
  private Button mbol;
  private RadioButton rd1;
  private RadioButton rd2;
  private String jenis="dollar";
  private EditText dlar;
  private EditText pons;
  private EditText euo;
  private Button simpn;
  private int kurs, nDollar=9000,nEuro=15000,nPounds=19000;
  
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jancok();
    }

    public void jancok()
    {
    	rd1=(RadioButton)findViewById(R.id.radioButton1);
    	rd1.setChecked(true);
    	rd2=(RadioButton)findViewById(R.id.radioButton2);
    	mbol=(Button)findViewById(R.id.knvrs);
    	mbol.setOnClickListener(mbloListener);
    	input=(EditText)findViewById(R.id.Editmas);
    	hasil=(AutoCompleteTextView)findViewById(R.id.hasilT);
    	setTextRadioButton();
    }
    
    //text radioButton
    public void setTextRadioButton()
    {
    	 rd1.setText("konversi dari "+jenis+" ke rupiah");
  	     rd2.setText("konversi dari rupiah ke  "+jenis);
    }
    
  //menu
    public boolean onCreateOptionsMenu(Menu menu)
    {
 	SubMenu subMenu = menu.addSubMenu("mata uang");
 	subMenu.add(1,1,0, "dollar").setChecked (true); 
 	subMenu.add(1,2,0,"pounds");
 	subMenu.add(1,3,0, "euro");
 	subMenu.setGroupCheckable(1,true,true);
 	menu.add(0,4,0, "setting");
 	menu.add(0,5,0, "exit").setIcon(android.R.drawable.btn_minus);
 	return true;
 	
    }
    
    //item menu
    public boolean onOptionsItemSelected(MenuItem item)
    {
 	   switch (item.getItemId()){
 	   case 1:
 		   jenis="dollar";
 		   setTextRadioButton();
 		   item.setChecked(true);
 		   return (true);
 	   case 2:
 		   jenis="pounds";
 		   setTextRadioButton();
 		   item.setChecked(true);
 		   return (true);
 	   case 3:
 		   jenis="euro";
 		   setTextRadioButton();
 		   item.setChecked(true);
 		   return (true);
 	   case 4:
 		   setting();
 		   item.setChecked(true);
 		   return (true);
 	  
 	   case 5:
 		   this.finish();
 		   return (true);
 	   }
 	   return false;
 	   
    }
    
    //method setting
    public void setting()
    {
    	this.setContentView(R.layout.setting);
  	  dlar=(EditText)findViewById(R.id.editdollar);
  	  euo=(EditText)findViewById(R.id.editeuro);
  	  pons=(EditText)findViewById(R.id.editpounds);
  	  dlar.setText(String.valueOf(nDollar));
  	  euo.setText(String.valueOf(nEuro));
  	  pons.setText(String.valueOf(nPounds));
  	  simpn=(Button)findViewById(R.id.button1);
  	  simpn.setOnClickListener(smListener);
    }
    
   
    //listener dan method tombol simpan
    private View.OnClickListener smListener = new View.OnClickListener() {
		
		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			nDollar=Integer.valueOf(dlar.getText().toString()).intValue();
			  nPounds=Integer.valueOf(pons.getText().toString()).intValue();
			  nEuro=Integer.valueOf(euo.getText().toString()).intValue();
			  setContentView(R.layout.activity_main);
			  jancok();
		}
	};
	
	//method tombol back
	public void onBackPressed()
	  {
		    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
		    localBuilder.setTitle("persetujuan");
		    localBuilder.setMessage("apakah kamu benar ingin keluar?");
		    localBuilder.setPositiveButton("ok", new OnClickListener(){
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					exit();
				}});
		    localBuilder.setNegativeButton("tidak", new OnClickListener(){
		    	public void onClick(DialogInterface dialog, int which){	
		    	}});
		    localBuilder.show();
	  }
	
	  public void exit()
	  {
		  this.finish();
	  }
    
 //listener dan method tombol konversi
    private View.OnClickListener mbloListener = new View.OnClickListener() {
		
		

		
		public void onClick(View v) {
			// TODO Auto-generated method stub
			 if(jenis.equalsIgnoreCase("dollar"))
			  {kurs=nDollar;}
			  else if (jenis.equalsIgnoreCase("euro"))
			  {kurs=nEuro;}
			  else if(jenis.equalsIgnoreCase("pounds"))
			  {kurs=nPounds;}
			  if (rd1.isChecked())
			  {
				  try{
					  hasil.setText(" "+kurs *Integer.valueOf(input.getText().toString()).intValue());
				  }
					  catch (Exception e)
					  {
						  hasil.setText("number only");
					  }
				  }
			  else {
				  try{
					  hasil.setText(" "+Integer.valueOf(input.getText().toString()).intValue()/kurs);
				  }
				  catch  (Exception e)
				  {
					  hasil.setText("number only");
				  }
			  }
			  }
	
	};
}
