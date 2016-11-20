package cn.edu.gdmec.s07150836.mycontacts_step;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class AddcontactsActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText mobileEditText;
    private EditText qqEditText;
    private EditText danweiEditText;
    private EditText adderssEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        setTitle("添加联系人");
        nameEditText=(EditText) findViewById(R.id.name);
        mobileEditText=(EditText) findViewById(R.id.mobile);
        danweiEditText=(EditText) findViewById(R.id.danwei);
        qqEditText=(EditText) findViewById(R.id.qq);
        adderssEditText=(EditText) findViewById(R.id.address);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,1,Menu.NONE,"保存");
        menu.add(Menu.NONE,2,Menu.NONE,"返回");
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case 1:
                if(!nameEditText.getText().toString().trim().equals("")){
                    User user=new User();
                    user.setName(nameEditText.getText().toString());
                    user.setMobile(mobileEditText.getText().toString());
                    user.setQq(qqEditText.getText().toString());
                    user.setDanwei(danweiEditText.getText().toString());
                    user.setAddress(adderssEditText.getText().toString());
                    ContactsTable ct =new ContactsTable(AddcontactsActivity.this);
                    if(ct.addDate(user)){
                        Toast.makeText(AddcontactsActivity.this,"添加成功",Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(AddcontactsActivity.this,"添加失败",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(AddcontactsActivity.this,"请先输入数据",Toast.LENGTH_SHORT).show();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
