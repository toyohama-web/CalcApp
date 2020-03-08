package jp.techacademy.takeru.suzuki.calcapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.result_activity.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.result_activity)

        // MainActivityから値を受け取る
        val value1 = intent.getDoubleExtra("VALUE1", 0.0)
        val value2 = intent.getDoubleExtra("VALUE2", 0.0)
        val str = intent.getStringExtra("ID")

        // 受け取った値で計算して、textViewに表示させる
        if (str == "add") {
            resultView.text = "${value1 + value2}"
        } else if (str == "subtract") {
            resultView.text = "${value1 - value2}"
        } else if (str == "multiple") {
            resultView.text = "${value1 * value2}"
        } else if (str == "divide") {
            resultView.text = "${value1 / value2}"
        }
    }
}
