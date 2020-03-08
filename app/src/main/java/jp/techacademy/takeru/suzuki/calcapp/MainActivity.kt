package jp.techacademy.takeru.suzuki.calcapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addition.setOnClickListener(this)
        subtraction.setOnClickListener(this)
        multiplication.setOnClickListener(this)
        division.setOnClickListener(this)
    }

    // onClickメソッドを実装
    override fun onClick(v: View) {
        // Snackbarを利用して、editTextに数値未入力の場合、表示する。、
        if (editText1.text.isEmpty() || editText2.text.isEmpty()) {
            Snackbar.make(v, "数値を入力してください",
                Snackbar.LENGTH_INDEFINITE).setAction("了解"){
                Log.d("Errors", "数値未入力")
            }.show()
        } else {
            // editTextの値を小数点に対応するため、double型に変換
            val et1: Double? = editText1.text.toString().toDouble()
            val et2: Double? = editText2.text.toString().toDouble()

            // Intentクラスを利用して、ResultActivityに値を送る
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("VALUE1", et1)
            intent.putExtra("VALUE2", et2)
            // 押されたボタンによって、計算方法を変えられるように、"ID"として、ResultActivityに送る
            when (v.id) {
                R.id.addition -> intent.putExtra("ID", "add")
                R.id.subtraction -> intent.putExtra("ID", "subtract")
                R.id.multiplication -> intent.putExtra("ID", "multiple")
                R.id.division -> intent.putExtra("ID", "divide")
            }
            startActivity(intent)
        }
    }


}